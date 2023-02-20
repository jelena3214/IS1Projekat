/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "ukorpi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ukorpi.findAll", query = "SELECT u FROM Ukorpi u"),
    @NamedQuery(name = "Ukorpi.findByIdkorpa", query = "SELECT u FROM Ukorpi u WHERE u.ukorpiPK.idkorpa = :idkorpa"),
    @NamedQuery(name = "Ukorpi.findByIdartikal", query = "SELECT u FROM Ukorpi u WHERE u.ukorpiPK.idartikal = :idartikal"),
    @NamedQuery(name = "Ukorpi.findByKolicina", query = "SELECT u FROM Ukorpi u WHERE u.kolicina = :kolicina")})
public class Ukorpi implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UkorpiPK ukorpiPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kolicina")
    private int kolicina;
    @JoinColumn(name = "idartikal", referencedColumnName = "idartikal", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Artikal artikal;
    @JoinColumn(name = "idkorpa", referencedColumnName = "idkorpa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Korpa korpa;

    public Ukorpi() {
    }

    public Ukorpi(UkorpiPK ukorpiPK) {
        this.ukorpiPK = ukorpiPK;
    }

    public Ukorpi(UkorpiPK ukorpiPK, int kolicina) {
        this.ukorpiPK = ukorpiPK;
        this.kolicina = kolicina;
    }

    public Ukorpi(int idkorpa, int idartikal) {
        this.ukorpiPK = new UkorpiPK(idkorpa, idartikal);
    }

    public UkorpiPK getUkorpiPK() {
        return ukorpiPK;
    }

    public void setUkorpiPK(UkorpiPK ukorpiPK) {
        this.ukorpiPK = ukorpiPK;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Artikal getArtikal() {
        return artikal;
    }

    public void setArtikal(Artikal artikal) {
        this.artikal = artikal;
    }

    public Korpa getKorpa() {
        return korpa;
    }

    public void setKorpa(Korpa korpa) {
        this.korpa = korpa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ukorpiPK != null ? ukorpiPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ukorpi)) {
            return false;
        }
        Ukorpi other = (Ukorpi) object;
        if ((this.ukorpiPK == null && other.ukorpiPK != null) || (this.ukorpiPK != null && !this.ukorpiPK.equals(other.ukorpiPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.Ukorpi[ ukorpiPK=" + ukorpiPK + " ]";
    }
    
}
