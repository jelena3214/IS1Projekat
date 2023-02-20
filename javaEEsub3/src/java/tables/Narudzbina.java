/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "narudzbina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Narudzbina.findAll", query = "SELECT n FROM Narudzbina n"),
    @NamedQuery(name = "Narudzbina.findByIdnarudzbina", query = "SELECT n FROM Narudzbina n WHERE n.idnarudzbina = :idnarudzbina"),
    @NamedQuery(name = "Narudzbina.findByUkupnaCena", query = "SELECT n FROM Narudzbina n WHERE n.ukupnaCena = :ukupnaCena"),
    @NamedQuery(name = "Narudzbina.findByVreme", query = "SELECT n FROM Narudzbina n WHERE n.vreme = :vreme"),
    @NamedQuery(name = "Narudzbina.findByAdresa", query = "SELECT n FROM Narudzbina n WHERE n.adresa = :adresa"),
    @NamedQuery(name = "Narudzbina.findByIdgrad", query = "SELECT n FROM Narudzbina n WHERE n.idgrad = :idgrad"),
    @NamedQuery(name = "Narudzbina.findByIdkorisnik", query = "SELECT n FROM Narudzbina n WHERE n.idkorisnik = :idkorisnik")})
public class Narudzbina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnarudzbina")
    private Integer idnarudzbina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ukupnaCena")
    private double ukupnaCena;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Vreme")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vreme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Adresa")
    private String adresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idgrad")
    private int idgrad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idkorisnik")
    private int idkorisnik;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idnarudzbina")
    private List<Stavka> stavkaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idnarudzbina")
    private List<Transakcija> transakcijaList;

    public Narudzbina() {
    }

    public Narudzbina(Integer idnarudzbina) {
        this.idnarudzbina = idnarudzbina;
    }

    public Narudzbina(Integer idnarudzbina, double ukupnaCena, Date vreme, String adresa, int idgrad, int idkorisnik) {
        this.idnarudzbina = idnarudzbina;
        this.ukupnaCena = ukupnaCena;
        this.vreme = vreme;
        this.adresa = adresa;
        this.idgrad = idgrad;
        this.idkorisnik = idkorisnik;
    }

    public Integer getIdnarudzbina() {
        return idnarudzbina;
    }

    public void setIdnarudzbina(Integer idnarudzbina) {
        this.idnarudzbina = idnarudzbina;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public Date getVreme() {
        return vreme;
    }

    public void setVreme(Date vreme) {
        this.vreme = vreme;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getIdgrad() {
        return idgrad;
    }

    public void setIdgrad(int idgrad) {
        this.idgrad = idgrad;
    }

    public int getIdkorisnik() {
        return idkorisnik;
    }

    public void setIdkorisnik(int idkorisnik) {
        this.idkorisnik = idkorisnik;
    }

    @XmlTransient
    public List<Stavka> getStavkaList() {
        return stavkaList;
    }

    public void setStavkaList(List<Stavka> stavkaList) {
        this.stavkaList = stavkaList;
    }

    @XmlTransient
    public List<Transakcija> getTransakcijaList() {
        return transakcijaList;
    }

    public void setTransakcijaList(List<Transakcija> transakcijaList) {
        this.transakcijaList = transakcijaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnarudzbina != null ? idnarudzbina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Narudzbina)) {
            return false;
        }
        Narudzbina other = (Narudzbina) object;
        if ((this.idnarudzbina == null && other.idnarudzbina != null) || (this.idnarudzbina != null && !this.idnarudzbina.equals(other.idnarudzbina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Narudzbina{" + "idnarudzbina=" + idnarudzbina + ", ukupnaCena=" + ukupnaCena + ", vreme=" + vreme + ", adresa=" + adresa + ", idgrad=" + idgrad + ", idkorisnik=" + idkorisnik + '}';
    }

    
    
}
