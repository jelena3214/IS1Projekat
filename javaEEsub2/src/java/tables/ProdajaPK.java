/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Lenovo
 */
@Embeddable
public class ProdajaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idkorisnik")
    private int idkorisnik;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idartikal")
    private int idartikal;

    public ProdajaPK() {
    }

    public ProdajaPK(int idkorisnik, int idartikal) {
        this.idkorisnik = idkorisnik;
        this.idartikal = idartikal;
    }

    public int getIdkorisnik() {
        return idkorisnik;
    }

    public void setIdkorisnik(int idkorisnik) {
        this.idkorisnik = idkorisnik;
    }

    public int getIdartikal() {
        return idartikal;
    }

    public void setIdartikal(int idartikal) {
        this.idartikal = idartikal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idkorisnik;
        hash += (int) idartikal;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdajaPK)) {
            return false;
        }
        ProdajaPK other = (ProdajaPK) object;
        if (this.idkorisnik != other.idkorisnik) {
            return false;
        }
        if (this.idartikal != other.idartikal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.ProdajaPK[ idkorisnik=" + idkorisnik + ", idartikal=" + idartikal + " ]";
    }
    
}
