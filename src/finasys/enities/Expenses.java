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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "EXPENSES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expenses.findAll", query = "SELECT e FROM Expenses e"),
    @NamedQuery(name = "Expenses.findByExpenseid", query = "SELECT e FROM Expenses e WHERE e.expenseid = :expenseid"),
    @NamedQuery(name = "Expenses.findByExpenseName", query = "SELECT e FROM Expenses e WHERE e.expenseName = :expenseName"),
    @NamedQuery(name = "Expenses.findByAmount", query = "SELECT e FROM Expenses e WHERE e.amount = :amount"),
    @NamedQuery(name = "Expenses.findByRepeat", query = "SELECT e FROM Expenses e WHERE e.repeat = :repeat"),
    @NamedQuery(name = "Expenses.findByRepeatExpiry", query = "SELECT e FROM Expenses e WHERE e.repeatExpiry = :repeatExpiry")})
public class Expenses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EXPENSEID")
    private Integer expenseid;
    @Column(name = "EXPENSE_NAME")
    private String expenseName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMOUNT")
    private Double amount;
    @Basic(optional = false)
    @Column(name = "REPEAT")
    private Boolean repeat;
    @Column(name = "REPEAT_EXPIRY")
    @Temporal(TemporalType.DATE)
    private Date repeatExpiry;
    @JoinColumn(name = "VENDORID", referencedColumnName = "VENDORID")
    @ManyToOne
    private Vendors vendorid;

    public Expenses() {
    }

    public Expenses(Integer expenseid) {
        this.expenseid = expenseid;
    }

    public Expenses(Integer expenseid, Boolean repeat) {
        this.expenseid = expenseid;
        this.repeat = repeat;
    }

    public Integer getExpenseid() {
        return expenseid;
    }

    public void setExpenseid(Integer expenseid) {
        this.expenseid = expenseid;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getRepeat() {
        return repeat;
    }

    public void setRepeat(Boolean repeat) {
        this.repeat = repeat;
    }

    public Date getRepeatExpiry() {
        return repeatExpiry;
    }

    public void setRepeatExpiry(Date repeatExpiry) {
        this.repeatExpiry = repeatExpiry;
    }

    public Vendors getVendorid() {
        return vendorid;
    }

    public void setVendorid(Vendors vendorid) {
        this.vendorid = vendorid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (expenseid != null ? expenseid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expenses)) {
            return false;
        }
        Expenses other = (Expenses) object;
        if ((this.expenseid == null && other.expenseid != null) || (this.expenseid != null && !this.expenseid.equals(other.expenseid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "finasys.enities.Expenses[ expenseid=" + expenseid + " ]";
    }
    
}
