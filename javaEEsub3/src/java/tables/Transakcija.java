/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "transakcija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transakcija.findAll", query = "SELECT t FROM Transakcija t"),
    @NamedQuery(name = "Transakcija.findByIdtransakcija", query = "SELECT t FROM Transakcija t WHERE t.idtransakcija = :idtransakcija"),
    @NamedQuery(name = "Transakcija.findBySuma", query = "SELECT t FROM Transakcija t WHERE t.suma = :suma"),
    @NamedQuery(name = "Transakcija.findByVremePlacanja", query = "SELECT t FROM Transakcija t WHERE t.vremePlacanja = :vremePlacanja")})
public class Transakcija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtransakcija")
    private Integer idtransakcija;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suma")
    private double suma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vremePlacanja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vremePlacanja;
    @JoinColumn(name = "idnarudzbina", referencedColumnName = "idnarudzbina")
    @ManyToOne(optional = false)
    private Narudzbina idnarudzbina;

    public Transakcija() {
    }

    public Transakcija(Integer idtransakcija) {
        this.idtransakcija = idtransakcija;
    }

    public Transakcija(Integer idtransakcija, double suma, Date vremePlacanja) {
        this.idtransakcija = idtransakcija;
        this.suma = suma;
        this.vremePlacanja = vremePlacanja;
    }

    public Integer getIdtransakcija() {
        return idtransakcija;
    }

    public void setIdtransakcija(Integer idtransakcija) {
        this.idtransakcija = idtransakcija;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public Date getVremePlacanja() {
        return vremePlacanja;
    }

    public void setVremePlacanja(Date vremePlacanja) {
        this.vremePlacanja = vremePlacanja;
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
        hash += (idtransakcija != null ? idtransakcija.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transakcija)) {
            return false;
        }
        Transakcija other = (Transakcija) object;
        if ((this.idtransakcija == null && other.idtransakcija != null) || (this.idtransakcija != null && !this.idtransakcija.equals(other.idtransakcija))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transakcija{" + "idtransakcija=" + idtransakcija + ", suma=" + suma + ", vremePlacanja=" + vremePlacanja + ", idnarudzbina=" + idnarudzbina.getIdnarudzbina() + '}';
    }

}
