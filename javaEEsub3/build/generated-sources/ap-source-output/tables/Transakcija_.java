package tables;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tables.Narudzbina;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2023-02-18T13:32:00")
@StaticMetamodel(Transakcija.class)
public class Transakcija_ { 

    public static volatile SingularAttribute<Transakcija, Double> suma;
    public static volatile SingularAttribute<Transakcija, Date> vremePlacanja;
    public static volatile SingularAttribute<Transakcija, Integer> idtransakcija;
    public static volatile SingularAttribute<Transakcija, Narudzbina> idnarudzbina;

}