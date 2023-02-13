/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "artikal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artikal.findAll", query = "SELECT a FROM Artikal a"),
    @NamedQuery(name = "Artikal.findByIdartikal", query = "SELECT a FROM Artikal a WHERE a.idartikal = :idartikal"),
    @NamedQuery(name = "Artikal.findByNaziv", query = "SELECT a FROM Artikal a WHERE a.naziv = :naziv"),
    @NamedQuery(name = "Artikal.findByOpis", query = "SELECT a FROM Artikal a WHERE a.opis = :opis"),
    @NamedQuery(name = "Artikal.findByCena", query = "SELECT a FROM Artikal a WHERE a.cena = :cena"),
    @NamedQuery(name = "Artikal.findByPopust", query = "SELECT a FROM Artikal a WHERE a.popust = :popust")})
public class Artikal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idartikal")
    private Integer idartikal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Naziv")
    private String naziv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Opis")
    private String opis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cena")
    private double cena;
    @Column(name = "Popust")
    private Integer popust;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idartikal")
    private List<Recenzija> recenzijaList;
    @JoinColumn(name = "idkategorija", referencedColumnName = "idkategorija")
    @ManyToOne(optional = false)
    private Kategorija idkategorija;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artikal")
    private List<Prodaja> prodajaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artikal")
    private List<Ukorpi> ukorpiList;

    public Artikal() {
    }

    public Artikal(Integer idartikal) {
        this.idartikal = idartikal;
    }

    public Artikal(Integer idartikal, String naziv, String opis, double cena) {
        this.idartikal = idartikal;
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
    }

    public Integer getIdartikal() {
        return idartikal;
    }

    public void setIdartikal(Integer idartikal) {
        this.idartikal = idartikal;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Integer getPopust() {
        return popust;
    }

    public void setPopust(Integer popust) {
        this.popust = popust;
    }

    @XmlTransient
    public List<Recenzija> getRecenzijaList() {
        return recenzijaList;
    }

    public void setRecenzijaList(List<Recenzija> recenzijaList) {
        this.recenzijaList = recenzijaList;
    }

    public Kategorija getIdkategorija() {
        return idkategorija;
    }

    public void setIdkategorija(Kategorija idkategorija) {
        this.idkategorija = idkategorija;
    }

    @XmlTransient
    public List<Prodaja> getProdajaList() {
        return prodajaList;
    }

    public void setProdajaList(List<Prodaja> prodajaList) {
        this.prodajaList = prodajaList;
    }

    @XmlTransient
    public List<Ukorpi> getUkorpiList() {
        return ukorpiList;
    }

    public void setUkorpiList(List<Ukorpi> ukorpiList) {
        this.ukorpiList = ukorpiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idartikal != null ? idartikal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artikal)) {
            return false;
        }
        Artikal other = (Artikal) object;
        if ((this.idartikal == null && other.idartikal != null) || (this.idartikal != null && !this.idartikal.equals(other.idartikal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idartikal + "," + naziv + "," + opis + "," + cena + "," + popust + "," + idkategorija.getIdkategorija() +" ]";
    }
    
}
