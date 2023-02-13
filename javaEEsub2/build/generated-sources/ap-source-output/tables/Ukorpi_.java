package tables;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tables.Artikal;
import tables.Korpa;
import tables.UkorpiPK;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2023-02-10T14:29:39")
@StaticMetamodel(Ukorpi.class)
public class Ukorpi_ { 

    public static volatile SingularAttribute<Ukorpi, UkorpiPK> ukorpiPK;
    public static volatile SingularAttribute<Ukorpi, Korpa> korpa;
    public static volatile SingularAttribute<Ukorpi, Artikal> artikal;
    public static volatile SingularAttribute<Ukorpi, Integer> kolicina;

}