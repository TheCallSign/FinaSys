/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finasys.enities;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stjohn
 */
@Entity
@Table(name = "VENDORS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendors.findAll", query = "SELECT v FROM Vendors v"),
    @NamedQuery(name = "Vendors.findByVendorid", query = "SELECT v FROM Vendors v WHERE v.vendorid = :vendorid"),
    @NamedQuery(name = "Vendors.findByVendorName", query = "SELECT v FROM Vendors v WHERE v.vendorName = :vendorName")})
public class Vendors implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VENDORID")
    private Integer vendorid;
    @Column(name = "VENDOR_NAME")
    private String vendorName;
    @OneToMany(mappedBy = "vendorid")
    private List<Expenses> expensesList;
    @JoinColumn(name = "ADDRESSID", referencedColumnName = "ADDRESSID")
    @ManyToOne
    private Addresses addressid;

    public Vendors() {
    }

    public Vendors(Integer vendorid) {
        this.vendorid = vendorid;
    }

    public Integer getVendorid() {
        return vendorid;
    }

    public void setVendorid(Integer vendorid) {
        this.vendorid = vendorid;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @XmlTransient
    public List<Expenses> getExpensesList() {
        return expensesList;
    }

    public void setExpensesList(List<Expenses> expensesList) {
        this.expensesList = expensesList;
    }

    public Addresses getAddressid() {
        return addressid;
    }

    public void setAddressid(Addresses addressid) {
        this.addressid = addressid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendorid != null ? vendorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendors)) {
            return false;
        }
        Vendors other = (Vendors) object;
        if ((this.vendorid == null && other.vendorid != null) || (this.vendorid != null && !this.vendorid.equals(other.vendorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "finasys.enities.Vendors[ vendorid=" + vendorid + " ]";
    }
    
}
