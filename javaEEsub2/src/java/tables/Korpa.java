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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "korpa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Korpa.findAll", query = "SELECT k FROM Korpa k"),
    @NamedQuery(name = "Korpa.findByIdkorpa", query = "SELECT k FROM Korpa k WHERE k.idkorpa = :idkorpa"),
    @NamedQuery(name = "Korpa.findByIznos", query = "SELECT k FROM Korpa k WHERE k.iznos = :iznos"),
    @NamedQuery(name = "Korpa.findByIdkorisnik", query = "SELECT k FROM Korpa k WHERE k.idkorisnik = :idkorisnik")})
public class Korpa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idkorpa")
    private Integer idkorpa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iznos")
    private double iznos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idkorisnik")
    private int idkorisnik;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "korpa")
    private List<Ukorpi> ukorpiList;

    public Korpa() {
    }

    public Korpa(Integer idkorpa) {
        this.idkorpa = idkorpa;
    }

    public Korpa(Integer idkorpa, double iznos, int idkorisnik) {
        this.idkorpa = idkorpa;
        this.iznos = iznos;
        this.idkorisnik = idkorisnik;
    }

    public Integer getIdkorpa() {
        return idkorpa;
    }

    public void setIdkorpa(Integer idkorpa) {
        this.idkorpa = idkorpa;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public int getIdkorisnik() {
        return idkorisnik;
    }

    public void setIdkorisnik(int idkorisnik) {
        this.idkorisnik = idkorisnik;
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
        hash += (idkorpa != null ? idkorpa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korpa)) {
            return false;
        }
        Korpa other = (Korpa) object;
        if ((this.idkorpa == null && other.idkorpa != null) || (this.idkorpa != null && !this.idkorpa.equals(other.idkorpa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.Korpa[ idkorpa=" + idkorpa + " ]";
    }
    
}
