package tables;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tables.Grad;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2023-02-13T16:33:25")
@StaticMetamodel(Korisnik.class)
public class Korisnik_ { 

    public static volatile SingularAttribute<Korisnik, String> ime;
    public static volatile SingularAttribute<Korisnik, String> prezime;
    public static volatile SingularAttribute<Korisnik, Double> novac;
    public static volatile SingularAttribute<Korisnik, String> adresa;
    public static volatile SingularAttribute<Korisnik, Grad> idGrad;
    public static volatile SingularAttribute<Korisnik, String> sifra;
    public static volatile SingularAttribute<Korisnik, Integer> idKorisnik;
    public static volatile SingularAttribute<Korisnik, String> username;

}