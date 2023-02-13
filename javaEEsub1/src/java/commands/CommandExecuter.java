/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import responses.TextResponse;
import tables.Grad;
import tables.Korisnik;

/**
 *
 * @author Lenovo
 */

 //TODO: greska ako korisnik/grad postoji! jer u suprotnom on baca to, za sve sto je unique
public class CommandExecuter {
    public Serializable executeCommand(Command cmd, EntityManager em){
        if(cmd.getType() == Command.Type.CREATE_PLACE)return createPlace((CreatePlaceCommand)cmd, em);
        if(cmd.getType() == Command.Type.CREATE_CLIENT)return createClient((CreateClientCommand)cmd, em);
        if(cmd.getType() == Command.Type.ADD_MONEY)return addClientMoney((AddClientMoneyCommand)cmd, em);
        if(cmd.getType() == Command.Type.CHANGE_CITY_ADRESS)return changeCityAdress((ChangeAdressCityCommand)cmd, em);
        if(cmd.getType() == Command.Type.GET_ALL_CITIES)return getCities((GetCitiesCommand)cmd, em);
        if(cmd.getType() == Command.Type.GET_ALL_CLIENTS)return getClients((GetClientsCommand)cmd, em);
        if(cmd.getType() == Command.Type.GET_USER_ID)return getUserId((GetUserIdCommand)cmd, em);
        if(cmd.getType() == Command.Type.GET_CLIENT_INFO)return getUserInfo((GetUserInfoCommand)cmd, em);
        return null;
    }

    private Serializable createPlace(CreatePlaceCommand createCmd, EntityManager em) {
        Grad place = new Grad();
        place.setPostanskiBroj(createCmd.getPostalCode());
        place.setNaziv(createCmd.getName());
        em.getTransaction().begin();
        em.persist(place);
        em.getTransaction().commit();
        em.clear();
        
        return new TextResponse("Kreiran je grad");
    }

    private Serializable createClient(CreateClientCommand createCmd, EntityManager em) {
        TypedQuery<Grad> grad = em.createNamedQuery("Grad.findByNaziv", Grad.class).setParameter("naziv", createCmd.getGrad());
        if(grad.getSingleResult() == null){
            System.out.println("Ne postoji dati grad u bazi");
            return new TextResponse("Ne postoji dati grad u bazi");
        }
        Korisnik korisnik = new Korisnik();
        korisnik.setAdresa(createCmd.getAdresa());
        korisnik.setIdGrad((Grad)grad.getSingleResult());
        korisnik.setIme(createCmd.getIme());
        korisnik.setNovac(createCmd.getNovac());
        korisnik.setPrezime(createCmd.getPrezime());
        korisnik.setSifra(createCmd.getSifra());
        korisnik.setUsername(createCmd.getUsername());
        
        //dodavanje korisnika u listu
        Grad gr = grad.getSingleResult();
        List<Korisnik> korisnikList = gr.getKorisnikList();
        korisnikList.add(korisnik);
        gr.setKorisnikList(korisnikList);
        
        em.getTransaction().begin();
        em.persist(korisnik);
        em.getTransaction().commit();
        em.clear();
        return new TextResponse("Kreiran je korisnik");
    }

    
    private Serializable addClientMoney(AddClientMoneyCommand addCmd, EntityManager em) {
        TypedQuery<Korisnik> korisnik = em.createNamedQuery("Korisnik.findByUsername", Korisnik.class).setParameter("username", addCmd.getUsername());
        if(korisnik.getSingleResult() == null){
            System.out.println("Ne postoji korisnik sa datim username-om u bazi");
            return new TextResponse("Ne postoji korisnik sa datim username-om u bazi");
        }
        
        Korisnik kor = korisnik.getSingleResult();
        kor.setNovac(kor.getNovac() + addCmd.getNovac());
        em.getTransaction().begin();
        em.persist(kor);
        em.getTransaction().commit();
        em.clear();
        return new TextResponse("Dodat je novac korisniku");
    }

    private Serializable changeCityAdress(ChangeAdressCityCommand changeCmd, EntityManager em) {
        TypedQuery<Korisnik> korisnik = em.createNamedQuery("Korisnik.findByUsername", Korisnik.class).setParameter("username", changeCmd.getUsername());
        if(korisnik.getSingleResult() == null){
            System.out.println("Ne postoji korisnik sa datim username-om u bazi");
            return new TextResponse("Ne postoji korisnik sa datim username-om u bazi");
        }
        
        TypedQuery<Grad> grad = em.createNamedQuery("Grad.findByNaziv", Grad.class).setParameter("naziv", changeCmd.getGrad());
        if(grad.getSingleResult() == null){
            System.out.println("Ne postoji dati grad u bazi");
            return new TextResponse("Ne postoji dati grad u bazi");
        }
       
        
        Korisnik kor = korisnik.getSingleResult();
        
        Grad stariGrad = kor.getIdGrad();
        List<Korisnik> korisnikList = stariGrad.getKorisnikList();
        korisnikList.remove(kor);
        stariGrad.setKorisnikList(korisnikList);
        
        Grad noviGrad = grad.getSingleResult();
        List<Korisnik> korisnikList1 = noviGrad.getKorisnikList();
        korisnikList1.add(kor);
        noviGrad.setKorisnikList(korisnikList1);
        
        kor.setAdresa(changeCmd.getAdresa());
        kor.setIdGrad(grad.getSingleResult());
       
        em.getTransaction().begin();
        em.persist(kor);
        em.getTransaction().commit();
        em.clear();
        return new TextResponse("Promenjena je adresa i grad");
    }

    private Serializable getCities(GetCitiesCommand getCmd, EntityManager em) {
        TypedQuery<Grad> qu = em.createNamedQuery("Grad.findAll", Grad.class);
        List<Grad> res = qu.getResultList();
        
        if(res.isEmpty()){
            return new TextResponse("Nema gradova u bazi");
        }
        
        String resultString = "";
        
        for(Grad g: res){
            resultString += g.toString() + "\n";
        }
        
        
        return new TextResponse(resultString);
    }

    private Serializable getClients(GetClientsCommand getClientsCommand, EntityManager em) {
        TypedQuery<Korisnik> qu = em.createNamedQuery("Korisnik.findAll", Korisnik.class);
        List<Korisnik> res = qu.getResultList();
        
        if(res.isEmpty()){
            return new TextResponse("Nema korisnika u bazi");
        }
        
        String resultString = "";
        
        for(Korisnik k: res){
            resultString += k.toString() + '\n';
        }
        
        
        return new TextResponse(resultString);
    }

    private Serializable getUserId(GetUserIdCommand getCmd, EntityManager em) {
        TypedQuery<Korisnik> qu = em.createNamedQuery("Korisnik.findByUsername", Korisnik.class).setParameter("username", getCmd.getUsername());
        List<Korisnik> resultList = qu.getResultList();
        if(resultList.isEmpty()){
            return new TextResponse(-1 + "");
        }
        
        Korisnik korisnik = resultList.get(0);
        
        return new TextResponse(korisnik.getIdKorisnik() + "");
    }

    private Serializable getUserInfo(GetUserInfoCommand getCmd, EntityManager em) {
        TypedQuery<Korisnik> qu = em.createNamedQuery("Korisnik.findByIdKorisnik", Korisnik.class).setParameter("idKorisnik", getCmd.getIdK());
        List<Korisnik> resultList = qu.getResultList();
        
        Korisnik korisnik = resultList.get(0);
        double novac = korisnik.getNovac();
        
        return new TextResponse(korisnik.getAdresa()+ "," +korisnik.getIdGrad().getIdGrad() + "," + novac);
    }
}
