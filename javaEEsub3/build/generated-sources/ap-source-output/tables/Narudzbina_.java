package tables;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tables.Stavka;
import tables.Transakcija;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2023-02-10T14:14:53")
@StaticMetamodel(Narudzbina.class)
public class Narudzbina_ { 

    public static volatile SingularAttribute<Narudzbina, Integer> idkorisnik;
    public static volatile SingularAttribute<Narudzbina, Double> ukupnaCena;
    public static volatile SingularAttribute<Narudzbina, Date> vreme;
    public static volatile SingularAttribute<Narudzbina, Integer> idgrad;
    public static volatile SingularAttribute<Narudzbina, String> adresa;
    public static volatile SingularAttribute<Narudzbina, Integer> idnarudzbina;
    public static volatile ListAttribute<Narudzbina, Stavka> stavkaList;
    public static volatile ListAttribute<Narudzbina, Transakcija> transakcijaList;

}