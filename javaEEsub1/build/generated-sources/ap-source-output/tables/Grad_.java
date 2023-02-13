package tables;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tables.Korisnik;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2023-02-13T18:02:58")
@StaticMetamodel(Grad.class)
public class Grad_ { 

    public static volatile SingularAttribute<Grad, String> naziv;
    public static volatile SingularAttribute<Grad, Integer> idGrad;
    public static volatile SingularAttribute<Grad, Integer> postanskiBroj;
    public static volatile ListAttribute<Grad, Korisnik> korisnikList;

}