package tables;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tables.Artikal;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2023-02-10T14:29:39")
@StaticMetamodel(Recenzija.class)
public class Recenzija_ { 

    public static volatile SingularAttribute<Recenzija, Integer> idkorisnik;
    public static volatile SingularAttribute<Recenzija, Integer> idrecenzija;
    public static volatile SingularAttribute<Recenzija, Artikal> idartikal;
    public static volatile SingularAttribute<Recenzija, Integer> ocena;
    public static volatile SingularAttribute<Recenzija, String> opis;

}