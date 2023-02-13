package tables;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tables.Ukorpi;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2023-02-10T14:29:39")
@StaticMetamodel(Korpa.class)
public class Korpa_ { 

    public static volatile SingularAttribute<Korpa, Double> iznos;
    public static volatile SingularAttribute<Korpa, Integer> idkorisnik;
    public static volatile SingularAttribute<Korpa, Integer> idkorpa;
    public static volatile ListAttribute<Korpa, Ukorpi> ukorpiList;

}