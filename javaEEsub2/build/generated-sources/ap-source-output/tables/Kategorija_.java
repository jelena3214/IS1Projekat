package tables;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tables.Artikal;
import tables.Kategorija;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2023-02-12T22:45:08")
@StaticMetamodel(Kategorija.class)
public class Kategorija_ { 

    public static volatile ListAttribute<Kategorija, Kategorija> kategorijaList;
    public static volatile SingularAttribute<Kategorija, String> naziv;
    public static volatile SingularAttribute<Kategorija, Integer> idkategorija;
    public static volatile ListAttribute<Kategorija, Artikal> artikalList;
    public static volatile SingularAttribute<Kategorija, Kategorija> idpotkat;

}