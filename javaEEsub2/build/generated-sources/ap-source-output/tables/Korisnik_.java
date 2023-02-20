package tables;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tables.Artikal;
import tables.Korpa;
import tables.Recenzija;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2023-02-07T21:04:20")
@StaticMetamodel(Korisnik.class)
public class Korisnik_ { 

    public static volatile SingularAttribute<Korisnik, String> ime;
    public static volatile SingularAttribute<Korisnik, String> prezime;
    public static volatile ListAttribute<Korisnik, Korpa> korpaList;
    public static volatile ListAttribute<Korisnik, Recenzija> recenzijaList;
    public static volatile SingularAttribute<Korisnik, Integer> novac;
    public static volatile SingularAttribute<Korisnik, String> adresa;
    public static volatile SingularAttribute<Korisnik, Integer> idGrad;
    public static volatile SingularAttribute<Korisnik, String> sifra;
    public static volatile ListAttribute<Korisnik, Artikal> artikalList;
    public static volatile SingularAttribute<Korisnik, Integer> idKorisnik;
    public static volatile SingularAttribute<Korisnik, String> username;

}