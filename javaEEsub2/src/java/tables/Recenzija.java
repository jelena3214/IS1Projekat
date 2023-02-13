/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "recenzija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recenzija.findAll", query = "SELECT r FROM Recenzija r"),
    @NamedQuery(name = "Recenzija.findByIdkorisnik", query = "SELECT r FROM Recenzija r WHERE r.idkorisnik = :idkorisnik"),
    @NamedQuery(name = "Recenzija.findByOpis", query = "SELECT r FROM Recenzija r WHERE r.opis = :opis"),
    @NamedQuery(name = "Recenzija.findByOcena", query = "SELECT r FROM Recenzija r WHERE r.ocena = :ocena"),
    @NamedQuery(name = "Recenzija.findByIdrecenzija", query = "SELECT r FROM Recenzija r WHERE r.idrecenzija = :idrecenzija")})
public class Recenzija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idkorisnik")
    private int idkorisnik;
    @Size(max = 45)
    @Column(name = "Opis")
    private String opis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ocena")
    private int ocena;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrecenzija")
    private Integer idrecenzija;
    @JoinColumn(name = "idartikal", referencedColumnName = "idartikal")
    @ManyToOne(optional = false)
    private Artikal idartikal;

    public Recenzija() {
    }

    public Recenzija(Integer idrecenzija) {
        this.idrecenzija = idrecenzija;
    }

    public Recenzija(Integer idrecenzija, int idkorisnik, int ocena) {
        this.idrecenzija = idrecenzija;
        this.idkorisnik = idkorisnik;
        this.ocena = ocena;
    }

    public int getIdkorisnik() {
        return idkorisnik;
    }

    public void setIdkorisnik(int idkorisnik) {
        this.idkorisnik = idkorisnik;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public Integer getIdrecenzija() {
        return idrecenzija;
    }

    public void setIdrecenzija(Integer idrecenzija) {
        this.idrecenzija = idrecenzija;
    }

    public Artikal getIdartikal() {
        return idartikal;
    }

    public void setIdartikal(Artikal idartikal) {
        this.idartikal = idartikal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrecenzija != null ? idrecenzija.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recenzija)) {
            return false;
        }
        Recenzija other = (Recenzija) object;
        if ((this.idrecenzija == null && other.idrecenzija != null) || (this.idrecenzija != null && !this.idrecenzija.equals(other.idrecenzija))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.Recenzija[ idrecenzija=" + idrecenzija + " ]";
    }
    
}
