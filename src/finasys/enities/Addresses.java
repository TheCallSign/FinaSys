/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finasys.enities;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ADDRESSES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Addresses.findAll", query = "SELECT a FROM Addresses a"),
    @NamedQuery(name = "Addresses.findByAddressid", query = "SELECT a FROM Addresses a WHERE a.addressid = :addressid"),
    @NamedQuery(name = "Addresses.findByStreetNumber", query = "SELECT a FROM Addresses a WHERE a.streetNumber = :streetNumber"),
    @NamedQuery(name = "Addresses.findByStreetName", query = "SELECT a FROM Addresses a WHERE a.streetName = :streetName"),
    @NamedQuery(name = "Addresses.findBySuburb", query = "SELECT a FROM Addresses a WHERE a.suburb = :suburb"),
    @NamedQuery(name = "Addresses.findByPostalCode", query = "SELECT a FROM Addresses a WHERE a.postalCode = :postalCode")})
public class Addresses implements Serializable, FinaSysEntity{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ADDRESSID")
    private Integer addressid;
    @Column(name = "STREET_NUMBER")
    private Integer streetNumber;
    @Column(name = "STREET_NAME")
    private String streetName;
    @Column(name = "SUBURB")
    private String suburb;
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @OneToMany(mappedBy = "homeAddress")
    private List<Staff> staffList;
    @OneToMany(mappedBy = "addressid")
    private List<Vendors> vendorsList;

    public Addresses() {
    }
    

//    @Override
//    public Object[] getRows() {
//        return new Object[]{streetNumber, streetName, suburb, postalCode};
//    }
    
    public Addresses(Integer addressid) {
        this.addressid = addressid;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @XmlTransient
    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    @XmlTransient
    public List<Vendors> getVendorsList() {
        return vendorsList;
    }

    public void setVendorsList(List<Vendors> vendorsList) {
        this.vendorsList = vendorsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressid != null ? addressid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Addresses)) {
            return false;
        }
        Addresses other = (Addresses) object;
        if ((this.addressid == null && other.addressid != null) || (this.addressid != null && !this.addressid.equals(other.addressid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "finasys.enities.Addresses[ addressid=" + addressid + " ]";
    }
    
}
