/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.io.Serializable;
import static java.lang.Math.ceil;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import responses.ArtikalModel;
import responses.TextResponse;
import tables.Narudzbina;
import tables.Stavka;
import tables.Transakcija;

/**
 *
 * @author Lenovo
 */
public class CommandExecuter {
    
    public Serializable executeCommand(Command cmd, EntityManager em){
        if(cmd.getType() == Command.Type.BUY_ARTICLES)return buyArticles((BuyArticlesCommand)cmd, em);
        if(cmd.getType() == Command.Type.GET_USER_ORDERS)return getUserOrders((GetUserOrdersCommand)cmd, em);
        if(cmd.getType() == Command.Type.GET_ALL_ORDERS)return getAllOrders((GetAllOrdersCommand)cmd, em);
        if(cmd.getType() == Command.Type.GET_ALL_TRANSACTIONS)return getAllTransactions((GetAllTransactionsCommand)cmd, em);
        return null;
    }

    private Serializable buyArticles(BuyArticlesCommand buyCmd, EntityManager em) {
        //adresa i idgrad za dostavu
        String adr = buyCmd.getAdresa();
        int idgrad = buyCmd.getIdGrad();
        int idKorisnik = buyCmd.getIdK();
        double novac = buyCmd.getNovac();
        
        List<ArtikalModel> artikli = buyCmd.getArtikli();
        double sum = 0;
        for(ArtikalModel art: artikli){
            sum += (art.getCena() * art.getKolicina()*(100-art.getPopust()))/100;
        }
                
        System.out.println("sum" + sum);
        
        if(sum > novac){
            return new TextResponse("Korisnik nema dovoljno novca za kupovinu");
        }
        
        Narudzbina narudzbina = new Narudzbina();
        narudzbina.setAdresa(adr);
        narudzbina.setIdgrad(idgrad);
        narudzbina.setIdkorisnik(idKorisnik);
        narudzbina.setUkupnaCena(sum);
        narudzbina.setVreme(new Date(System.currentTimeMillis()));
        
        em.getTransaction().begin();
        em.persist(narudzbina);
        em.getTransaction().commit();
        em.clear();
        
        TypedQuery<Narudzbina> q = em.createQuery("select t from Narudzbina t order by t.idnarudzbina desc", Narudzbina.class);
        Narudzbina zadnja = q.getResultList().get(0);
        
        List<Stavka> stavke = new ArrayList<>();
        
        for(ArtikalModel art: artikli){
            Stavka nova = new Stavka();
            nova.setIdartikal(art.getIdart());
            nova.setIdnarudzbina(zadnja);
            nova.setJedinicnaCena(art.getCena());
            nova.setKolicina(art.getKolicina());
            nova.setPopust(art.getPopust());
            stavke.add(nova);
        }
        
        zadnja.setStavkaList(stavke);
        
        
        //transakcija
        Transakcija trans = new Transakcija();
        trans.setIdnarudzbina(zadnja);
        trans.setSuma(sum); //cena sa popustima
        trans.setVremePlacanja(new Date(System.currentTimeMillis()));
        
        List<Transakcija> transakcije = new ArrayList<>();
        transakcije.add(trans);
        zadnja.setTransakcijaList(transakcije);
        
        em.getTransaction().begin();
        em.persist(zadnja);
        em.getTransaction().commit();
        em.clear();
        
        return new TextResponse("Obavljena kupovina");
    }

    private Serializable getUserOrders(GetUserOrdersCommand getCmd, EntityManager em) {
        TypedQuery<Narudzbina> q = em.createNamedQuery("Narudzbina.findByIdkorisnik", Narudzbina.class).setParameter("idkorisnik", getCmd.getIdK());
        List<Narudzbina> resultList = q.getResultList();
        
        if(resultList.isEmpty()){
            return new TextResponse("Nema narudzbina za ovog korisnika");
        }
        
        String result = "";
        for(Narudzbina n: resultList){
            result += n.toString() + "\n";
        }
        
        return new TextResponse(result);
    }

    private Serializable getAllOrders(GetAllOrdersCommand getAllOrdersCommand, EntityManager em) {
        TypedQuery<Narudzbina> q = em.createNamedQuery("Narudzbina.findAll", Narudzbina.class);
        List<Narudzbina> resultList = q.getResultList();
        
        if(resultList.isEmpty()){
            return new TextResponse("Nema narudzbina");
        }
        
        String result = "";
        for(Narudzbina n: resultList){
            result += n.toString() + "\n";
        }
        
        return new TextResponse(result);
        
    }

    private Serializable getAllTransactions(GetAllTransactionsCommand getAllTransactionsCommand, EntityManager em) {
        TypedQuery<Transakcija> q = em.createNamedQuery("Transakcija.findAll", Transakcija.class);
        List<Transakcija> resultList = q.getResultList();
        
        if(resultList.isEmpty()){
            return new TextResponse("Nema transakcija");
        }
        
        String result = "";
        for(Transakcija n: resultList){
            result += n.toString() + "\n";
        }
        
        return new TextResponse(result);
    }
}