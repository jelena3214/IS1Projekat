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
@Table(name = "kategorija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kategorija.findAll", query = "SELECT k FROM Kategorija k"),
    @NamedQuery(name = "Kategorija.findByIdkategorija", query = "SELECT k FROM Kategorija k WHERE k.idkategorija = :idkategorija"),
    @NamedQuery(name = "Kategorija.findByNaziv", query = "SELECT k FROM Kategorija k WHERE k.naziv = :naziv")})
public class Kategorija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idkategorija")
    private Integer idkategorija;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "naziv")
    private String naziv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idkategorija")
    private List<Artikal> artikalList;
    @OneToMany(mappedBy = "idpotkat")
    private List<Kategorija> kategorijaList;
    @JoinColumn(name = "idpotkat", referencedColumnName = "idkategorija")
    @ManyToOne
    private Kategorija idpotkat;

    public Kategorija() {
    }

    public Kategorija(Integer idkategorija) {
        this.idkategorija = idkategorija;
    }

    public Kategorija(Integer idkategorija, String naziv) {
        this.idkategorija = idkategorija;
        this.naziv = naziv;
    }

    public Integer getIdkategorija() {
        return idkategorija;
    }

    public void setIdkategorija(Integer idkategorija) {
        this.idkategorija = idkategorija;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @XmlTransient
    public List<Artikal> getArtikalList() {
        return artikalList;
    }

    public void setArtikalList(List<Artikal> artikalList) {
        this.artikalList = artikalList;
    }

    @XmlTransient
    public List<Kategorija> getKategorijaList() {
        return kategorijaList;
    }

    public void setKategorijaList(List<Kategorija> kategorijaList) {
        this.kategorijaList = kategorijaList;
    }

    public Kategorija getIdpotkat() {
        return idpotkat;
    }

    public void setIdpotkat(Kategorija idpotkat) {
        this.idpotkat = idpotkat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idkategorija != null ? idkategorija.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kategorija)) {
            return false;
        }
        Kategorija other = (Kategorija) object;
        if ((this.idkategorija == null && other.idkategorija != null) || (this.idkategorija != null && !this.idkategorija.equals(other.idkategorija))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        int idp = -1;
        if(idpotkat != null){
            idp = idpotkat.getIdkategorija();
        }
        return "Kategorija[ idkategorija=" + idkategorija + "," + naziv + "," + idp + " ]";
    }
    
}
