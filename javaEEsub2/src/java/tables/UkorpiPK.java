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
public class UkorpiPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idkorpa")
    private int idkorpa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idartikal")
    private int idartikal;

    public UkorpiPK() {
    }

    public UkorpiPK(int idkorpa, int idartikal) {
        this.idkorpa = idkorpa;
        this.idartikal = idartikal;
    }

    public int getIdkorpa() {
        return idkorpa;
    }

    public void setIdkorpa(int idkorpa) {
        this.idkorpa = idkorpa;
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
        hash += (int) idkorpa;
        hash += (int) idartikal;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UkorpiPK)) {
            return false;
        }
        UkorpiPK other = (UkorpiPK) object;
        if (this.idkorpa != other.idkorpa) {
            return false;
        }
        if (this.idartikal != other.idartikal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.UkorpiPK[ idkorpa=" + idkorpa + ", idartikal=" + idartikal + " ]";
    }
    
}
