/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "prodaja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prodaja.findAll", query = "SELECT p FROM Prodaja p"),
    @NamedQuery(name = "Prodaja.findByIdkorisnik", query = "SELECT p FROM Prodaja p WHERE p.prodajaPK.idkorisnik = :idkorisnik"),
    @NamedQuery(name = "Prodaja.findByIdartikal", query = "SELECT p FROM Prodaja p WHERE p.prodajaPK.idartikal = :idartikal")})
public class Prodaja implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProdajaPK prodajaPK;
    @JoinColumn(name = "idartikal", referencedColumnName = "idartikal", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Artikal artikal;

    public Prodaja() {
    }

    public Prodaja(ProdajaPK prodajaPK) {
        this.prodajaPK = prodajaPK;
    }

    public Prodaja(int idkorisnik, int idartikal) {
        this.prodajaPK = new ProdajaPK(idkorisnik, idartikal);
    }

    public ProdajaPK getProdajaPK() {
        return prodajaPK;
    }

    public void setProdajaPK(ProdajaPK prodajaPK) {
        this.prodajaPK = prodajaPK;
    }

    public Artikal getArtikal() {
        return artikal;
    }

    public void setArtikal(Artikal artikal) {
        this.artikal = artikal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodajaPK != null ? prodajaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prodaja)) {
            return false;
        }
        Prodaja other = (Prodaja) object;
        if ((this.prodajaPK == null && other.prodajaPK != null) || (this.prodajaPK != null && !this.prodajaPK.equals(other.prodajaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.Prodaja[ prodajaPK=" + prodajaPK + " ]";
    }
    
}
