package tables;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tables.Kategorija;
import tables.Prodaja;
import tables.Recenzija;
import tables.Ukorpi;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2023-02-13T18:03:02")
@StaticMetamodel(Artikal.class)
public class Artikal_ { 

    public static volatile ListAttribute<Artikal, Recenzija> recenzijaList;
    public static volatile ListAttribute<Artikal, Prodaja> prodajaList;
    public static volatile SingularAttribute<Artikal, String> naziv;
    public static volatile SingularAttribute<Artikal, Integer> idartikal;
    public static volatile SingularAttribute<Artikal, Integer> popust;
    public static volatile SingularAttribute<Artikal, Double> cena;
    public static volatile SingularAttribute<Artikal, Kategorija> idkategorija;
    public static volatile ListAttribute<Artikal, Ukorpi> ukorpiList;
    public static volatile SingularAttribute<Artikal, String> opis;

}