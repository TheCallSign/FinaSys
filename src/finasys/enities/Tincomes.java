/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finasys.enities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stjohn
 */
@Entity
@Table(name = "TINCOMES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tincomes.findAll", query = "SELECT t FROM Tincomes t"),
    @NamedQuery(name = "Tincomes.findByTaxid", query = "SELECT t FROM Tincomes t WHERE t.taxid = :taxid"),
    @NamedQuery(name = "Tincomes.findByAmount", query = "SELECT t FROM Tincomes t WHERE t.amount = :amount"),
    @NamedQuery(name = "Tincomes.findByTdate", query = "SELECT t FROM Tincomes t WHERE t.tdate = :tdate")})
public class Tincomes implements Serializable, FinaSysEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TAXID")
    private Integer taxid;
    @Basic(optional = false)
    @Column(name = "AMOUNT")
    private int amount;
    @Basic(optional = false)
    @Column(name = "TDATE")
    @Temporal(TemporalType.DATE)
    private Date tdate;

    public Tincomes() {
    }

    public Tincomes(Integer taxid) {
        this.taxid = taxid;
    }

    public Tincomes(Integer taxid, int amount, Date tdate) {
        this.taxid = taxid;
        this.amount = amount;
        this.tdate = tdate;
    }

    public Integer getTaxid() {
        return taxid;
    }

    public void setTaxid(Integer taxid) {
        this.taxid = taxid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxid != null ? taxid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tincomes)) {
            return false;
        }
        Tincomes other = (Tincomes) object;
        if ((this.taxid == null && other.taxid != null) || (this.taxid != null && !this.taxid.equals(other.taxid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "finasys.enities.Tincomes[ taxid=" + taxid + " ]";
    }
    
}
