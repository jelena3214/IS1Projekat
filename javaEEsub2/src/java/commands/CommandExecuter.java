/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import responses.ArtikalModel;
import responses.MultipleObjectResponse;
import responses.TextResponse;
import tables.Artikal;
import tables.Kategorija;
import tables.Korpa;
import tables.Prodaja;
import tables.Ukorpi;
import tables.UkorpiPK;

/**
 *
 * @author Lenovo
 */
public class CommandExecuter {
    
    public Serializable executeCommand(Command cmd, EntityManager em){
        if(cmd.getType() == Command.Type.CREATE_CATEGORY)return createCategory((CreateCategoryCommand)cmd, em);
        if(cmd.getType() == Command.Type.CREATE_ARTICLE)return createArticle((CreateArticleCommand)cmd, em);
        if(cmd.getType() == Command.Type.CHANGE_PRICE)return changePrice((ChangePriceCommand)cmd, em);
        if(cmd.getType() == Command.Type.SET_DISCOUNT)return setDiscount((SetDiscountCommand)cmd, em);
        if(cmd.getType() == Command.Type.ADD_TO_BAG)return addToBag((AddToBagCommand)cmd, em);
        if(cmd.getType() == Command.Type.REMOVE_FROM_BAG)return removeFromBag((RemoveFromBagCommand)cmd, em);
        if(cmd.getType() == Command.Type.GET_CATEGORIES)return getCategories((GetCategoriesCommand)cmd, em);
        if(cmd.getType() == Command.Type.GET_SELLING_ARTICLES)return getSellingArticles((GetSellingArticlesCommand)cmd, em);
        if(cmd.getType() == Command.Type.GET_BAG_ARTICLES)return getBagArticles((GetBagArticlesCommand)cmd, em);
        return null;
    }

    private Serializable createCategory(CreateCategoryCommand createCmd, EntityManager em) {
        Kategorija kategorija = new Kategorija();
        kategorija.setNaziv(createCmd.getNaziv());
        if(createCmd.getPotkat() != -1){
            TypedQuery<Kategorija> qu = em.createNamedQuery("Kategorija.findByIdkategorija", Kategorija.class).setParameter("idkategorija", createCmd.getPotkat());
            if(qu.getResultList().isEmpty()){
                return new TextResponse("Ne postoji id potkategorije");
            }
            Kategorija potkategorija = qu.getResultList().get(0);
            if(potkategorija != null){
                kategorija.setIdpotkat(potkategorija);
                List<Kategorija> kategorijaList = potkategorija.getKategorijaList();
                kategorijaList.add(kategorija);
                potkategorija.setKategorijaList(kategorijaList);
            }
        }
        em.getTransaction().begin();
        em.persist(kategorija);
        em.getTransaction().commit();
        em.clear();
        
        return new TextResponse("Kreirana je kategorija");
    }

    private Serializable createArticle(CreateArticleCommand createCmd, EntityManager em) {
        TypedQuery<Kategorija> qu = em.createNamedQuery("Kategorija.findByNaziv", Kategorija.class).setParameter("naziv", createCmd.getKategorija());
        if(qu.getResultList().isEmpty()){
            return new TextResponse("Ne postoji kategorija.");
        }
        Kategorija kategorija = qu.getResultList().get(0);
        
        Artikal artikal = new Artikal();
        artikal.setCena(createCmd.getCena());
        artikal.setNaziv(createCmd.getNaziv());
        artikal.setOpis(createCmd.getOpis());
        artikal.setPopust(createCmd.getPopust());
        if(kategorija != null){
            artikal.setIdkategorija(kategorija);
            List<Artikal> artikalList = kategorija.getArtikalList();
            artikalList.add(artikal);
            kategorija.setArtikalList(artikalList);
        }
        
        em.getTransaction().begin();
        em.persist(artikal);
        em.getTransaction().commit();
        em.clear();
        
        return new TextResponse("Kreiran je artikal");
        
    }

    private Serializable changePrice(ChangePriceCommand changeCmd, EntityManager em) {
        TypedQuery<Artikal> qu = em.createNamedQuery("Artikal.findByIdartikal", Artikal.class).setParameter("idartikal", changeCmd.getIdArt());
        
        if(qu.getResultList().isEmpty()){
            return new TextResponse("Ne postoji artikal sa datim id-jem");
        }
        Artikal artikal = qu.getResultList().get(0);
        artikal.setCena(changeCmd.getCena());
        em.getTransaction().begin();
        em.persist(artikal);
        em.getTransaction().commit();
        em.clear();
        
        return new TextResponse("Promenjena je cena artikla");
    }

    private Serializable setDiscount(SetDiscountCommand setCmd, EntityManager em) {
        TypedQuery<Artikal> qu = em.createNamedQuery("Artikal.findByIdartikal", Artikal.class).setParameter("idartikal", setCmd.getIdart());
        if(qu.getResultList().isEmpty()){
            return new TextResponse("Ne postoji artikal sa datim id-jem");
        }
        Artikal artikal = qu.getResultList().get(0);
        artikal.setPopust(setCmd.getPopust());
        em.getTransaction().begin();
        em.persist(artikal);
        em.getTransaction().commit();
        em.clear();
        
        return new TextResponse("Postavljen je popust artiklu");
    }

    private Serializable addToBag(AddToBagCommand addCmd, EntityManager em) {
        TypedQuery<Artikal> qu = em.createNamedQuery("Artikal.findByNaziv", Artikal.class).setParameter("naziv", addCmd.getArt());
        List<Artikal> art = qu.getResultList();
        if(art.isEmpty()){
            return new TextResponse("Ne postoji artikal sa tim imenom");
        }

        Artikal artikal = art.get(0);
       
        
        TypedQuery<Korpa> korpaq = em.createNamedQuery("Korpa.findByIdkorisnik", Korpa.class).setParameter("idkorisnik", addCmd.getIdK());
        
        if(korpaq.getResultList().isEmpty()){
            return new TextResponse("Ne postoji korpa za korisnika");
        }
        
        Korpa korpa = korpaq.getSingleResult();
        
        TypedQuery<Ukorpi> qu1 = em.createQuery("select k from Ukorpi k where  k.korpa.idkorpa = :idk and k.artikal.idartikal = :ida", Ukorpi.class).setParameter("idk", korpa.getIdkorpa()).setParameter("ida", artikal.getIdartikal());
        List<Ukorpi> resultList = qu1.getResultList();
        
        if(resultList.isEmpty()){
            Ukorpi novo = new Ukorpi(new UkorpiPK(korpa.getIdkorpa(), artikal.getIdartikal()));
            novo.setArtikal(artikal);
            novo.setKorpa(korpa);
            novo.setKolicina(addCmd.getKol());
            
            em.getTransaction().begin();
            em.persist(novo);
            em.getTransaction().commit();
            em.clear();
            
            return new TextResponse("Ubaceno u korpu");
        }
        
        Ukorpi staro = resultList.get(0);
        staro.setKolicina(staro.getKolicina() + addCmd.getKol());
        
        em.getTransaction().begin();
        em.persist(staro);
        em.getTransaction().commit();
        em.clear();
        
        return new TextResponse("Ubaceno u korpu");
    }

    private Serializable removeFromBag(RemoveFromBagCommand removeCmd, EntityManager em) {
        TypedQuery<Artikal> qu = em.createNamedQuery("Artikal.findByNaziv", Artikal.class).setParameter("naziv", removeCmd.getArt());
        List<Artikal> art = qu.getResultList();
        if(art.isEmpty()){
            return new TextResponse("Ne postoji artikal sa tim imenom");
        }

        Artikal artikal = art.get(0);
       
        
        TypedQuery<Korpa> korpaq = em.createNamedQuery("Korpa.findByIdkorisnik", Korpa.class).setParameter("idkorisnik", removeCmd.getIdK());
        
        if(korpaq.getResultList().isEmpty()){
            return new TextResponse("Ne postoji korpa za korisnika");
        }
        
        Korpa korpa = korpaq.getSingleResult();
        
        TypedQuery<Ukorpi> qu1 = em.createQuery("select k from Ukorpi k where  k.korpa.idkorpa = :idk and k.artikal.idartikal = :ida", Ukorpi.class).setParameter("idk", korpa.getIdkorpa()).setParameter("ida", artikal.getIdartikal());
        List<Ukorpi> resultList = qu1.getResultList();
        
        if(resultList.isEmpty()){
            return new TextResponse("Artikal nije u korpi");
        }
        
        Ukorpi ukorpi = resultList.get(0);
        if(ukorpi.getKolicina() < removeCmd.getKol()){
            return new TextResponse("Uneli ste vecu kolicinu od one koja je u korpi");
        }
        
        ukorpi.setKolicina(ukorpi.getKolicina() - removeCmd.getKol());
        em.getTransaction().begin();
        em.persist(ukorpi);
        em.getTransaction().commit();
        em.clear();
        
        //brisanje ako je kolicina 0 nakon izbacivanja
        em.getTransaction().begin();
        int deleted = em.createQuery("delete from Ukorpi k where k.kolicina = 0", Ukorpi.class).executeUpdate();
        em.getTransaction().commit();
        em.clear();
        
        return new TextResponse("Izbaceno iz korpe");
    }

    private Serializable getCategories(GetCategoriesCommand getCmd, EntityManager em) {
        TypedQuery<Kategorija> qu = em.createNamedQuery("Kategorija.findAll", Kategorija.class);
        List<Kategorija> resultList = qu.getResultList();
        
        if(resultList.isEmpty()){
            return new TextResponse("Nema kategorija u bazi");
        }
        
        String result = "";
        
        for(Kategorija k: resultList){
            result += k.toString();
            result += "\n";
        }
        
        return new TextResponse(result);
    }

    private Serializable getSellingArticles(GetSellingArticlesCommand getCmd, EntityManager em) {
        TypedQuery<Prodaja> q = em.createQuery("select p from Prodaja p where p.prodajaPK.idkorisnik = :idK", Prodaja.class).setParameter("idK", getCmd.getIdK());
        List<Prodaja> resultList = q.getResultList();
        
        String result = "";
        if(resultList.isEmpty())return new TextResponse("Nema artikala koje prodaje dati korisnik");
        for(Prodaja p: resultList){
            Artikal artikal = em.createNamedQuery("Artikal.findByIdartikal", Artikal.class).setParameter("idartikal", p.getProdajaPK().getIdartikal()).getSingleResult();
            result += artikal.toString();
            result += "\n";
        }
        
        return new TextResponse(result);
    }

    private Serializable getBagArticles(GetBagArticlesCommand getCmd, EntityManager em) {
        TypedQuery<Korpa> korpaq = em.createNamedQuery("Korpa.findByIdkorisnik", Korpa.class).setParameter("idkorisnik", getCmd.getIdK());
        
        //ako nema korpe greska!
        if(korpaq.getResultList().isEmpty()){
            return new TextResponse("Ne postoji korpa za korisnika");
        }
        
        Korpa korpa = korpaq.getResultList().get(0);
        TypedQuery<Ukorpi> q = em.createQuery("select uk from Ukorpi uk where uk.korpa.idkorpa = :idKor", Ukorpi.class).setParameter("idKor", korpa.getIdkorpa());
        
        List<Ukorpi> resultList = q.getResultList();
        if(resultList.isEmpty()){
            return new MultipleObjectResponse();
        }
        
        /*String result = "IdArtikal, Naziv, Opis, Cena, Popust, IdKategorija, Kolicina\n";
        
        for(Ukorpi uk: resultList){
            result += uk.getArtikal().toString() + "," + uk.getKolicina();
            result += "\n";
        }
        
        return new TextResponse(result);*/
        
        MultipleObjectResponse response = new MultipleObjectResponse();
        List<Serializable> listr = new ArrayList<>();
        for(Ukorpi uk:resultList){
            Artikal art = uk.getArtikal();
            ArtikalModel novi = new ArtikalModel(art.getNaziv(), art.getOpis(), art.getIdartikal(), art.getCena(), art.getPopust(), art.getIdkategorija().getIdkategorija(), uk.getKolicina());
            listr.add(novi);
        }
        response.setObjects(listr);
        System.out.println(response.getObjects().size());
        return response;
    }
}
