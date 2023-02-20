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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "stavka")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stavka.findAll", query = "SELECT s FROM Stavka s"),
    @NamedQuery(name = "Stavka.findByIdstavka", query = "SELECT s FROM Stavka s WHERE s.idstavka = :idstavka"),
    @NamedQuery(name = "Stavka.findByKolicina", query = "SELECT s FROM Stavka s WHERE s.kolicina = :kolicina"),
    @NamedQuery(name = "Stavka.findByJedinicnaCena", query = "SELECT s FROM Stavka s WHERE s.jedinicnaCena = :jedinicnaCena"),
    @NamedQuery(name = "Stavka.findByIdartikal", query = "SELECT s FROM Stavka s WHERE s.idartikal = :idartikal"),
    @NamedQuery(name = "Stavka.findByPopust", query = "SELECT s FROM Stavka s WHERE s.popust = :popust")})
public class Stavka implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idstavka")
    private Integer idstavka;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kolicina")
    private int kolicina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jedinicnaCena")
    private double jedinicnaCena;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idartikal")
    private int idartikal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "popust")
    private int popust;
    @JoinColumn(name = "idnarudzbina", referencedColumnName = "idnarudzbina")
    @ManyToOne(optional = false)
    private Narudzbina idnarudzbina;

    public Stavka() {
    }

    public Stavka(Integer idstavka) {
        this.idstavka = idstavka;
    }

    public Stavka(Integer idstavka, int kolicina, double jedinicnaCena, int idartikal, int popust) {
        this.idstavka = idstavka;
        this.kolicina = kolicina;
        this.jedinicnaCena = jedinicnaCena;
        this.idartikal = idartikal;
        this.popust = popust;
    }

    public Integer getIdstavka() {
        return idstavka;
    }

    public void setIdstavka(Integer idstavka) {
        this.idstavka = idstavka;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getJedinicnaCena() {
        return jedinicnaCena;
    }

    public void setJedinicnaCena(double jedinicnaCena) {
        this.jedinicnaCena = jedinicnaCena;
    }

    public int getIdartikal() {
        return idartikal;
    }

    public void setIdartikal(int idartikal) {
        this.idartikal = idartikal;
    }

    public int getPopust() {
        return popust;
    }

    public void setPopust(int popust) {
        this.popust = popust;
    }

    public Narudzbina getIdnarudzbina() {
        return idnarudzbina;
    }

    public void setIdnarudzbina(Narudzbina idnarudzbina) {
        this.idnarudzbina = idnarudzbina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstavka != null ? idstavka.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stavka)) {
            return false;
        }
        Stavka other = (Stavka) object;
        if ((this.idstavka == null && other.idstavka != null) || (this.idstavka != null && !this.idstavka.equals(other.idstavka))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.Stavka[ idstavka=" + idstavka + " ]";
    }
    
}
