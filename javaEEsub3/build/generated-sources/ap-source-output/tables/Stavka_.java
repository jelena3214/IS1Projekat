package tables;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tables.Narudzbina;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2023-02-10T14:14:53")
@StaticMetamodel(Stavka.class)
public class Stavka_ { 

    public static volatile SingularAttribute<Stavka, Double> jedinicnaCena;
    public static volatile SingularAttribute<Stavka, Integer> kolicina;
    public static volatile SingularAttribute<Stavka, Narudzbina> idnarudzbina;
    public static volatile SingularAttribute<Stavka, Integer> idartikal;
    public static volatile SingularAttribute<Stavka, Integer> popust;
    public static volatile SingularAttribute<Stavka, Integer> idstavka;

}