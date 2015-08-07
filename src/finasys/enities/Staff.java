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
@Table(name = "STAFF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s"),
    @NamedQuery(name = "Staff.findByStaffid", query = "SELECT s FROM Staff s WHERE s.staffid = :staffid"),
    @NamedQuery(name = "Staff.findByFname", query = "SELECT s FROM Staff s WHERE s.fname = :fname"),
    @NamedQuery(name = "Staff.findBySname", query = "SELECT s FROM Staff s WHERE s.sname = :sname"),
    @NamedQuery(name = "Staff.findBySalary", query = "SELECT s FROM Staff s WHERE s.salary = :salary"),
    @NamedQuery(name = "Staff.findByContact", query = "SELECT s FROM Staff s WHERE s.contact = :contact"),
    @NamedQuery(name = "Staff.findByContractStart", query = "SELECT s FROM Staff s WHERE s.contractStart = :contractStart"),
    @NamedQuery(name = "Staff.findByContractExpiry", query = "SELECT s FROM Staff s WHERE s.contractExpiry = :contractExpiry")})
public class Staff implements Serializable, FinaSysEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "STAFFID")
    private Integer staffid;
    @Column(name = "FNAME")
    private String fname;
    @Column(name = "SNAME")
    private String sname;
    @Column(name = "SALARY")
    private Integer salary;
    @Column(name = "CONTACT")
    private String contact;
    @Basic(optional = false)
    @Column(name = "CONTRACT_START")
    @Temporal(TemporalType.DATE)
    private Date contractStart;
    @Column(name = "CONTRACT_EXPIRY")
    @Temporal(TemporalType.DATE)
    private Date contractExpiry;
    @JoinColumn(name = "HOME_ADDRESS", referencedColumnName = "ADDRESSID")
    @ManyToOne
    private Addresses homeAddress;

    public Staff() {
    }

    public Staff(Integer staffid) {
        this.staffid = staffid;
    }

    public Staff(Integer staffid, Date contractStart) {
        this.staffid = staffid;
        this.contractStart = contractStart;
    }

    public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getContractStart() {
        return contractStart;
    }

    public void setContractStart(Date contractStart) {
        this.contractStart = contractStart;
    }

    public Date getContractExpiry() {
        return contractExpiry;
    }

    public void setContractExpiry(Date contractExpiry) {
        this.contractExpiry = contractExpiry;
    }

    public Addresses getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Addresses homeAddress) {
        this.homeAddress = homeAddress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffid != null ? staffid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.staffid == null && other.staffid != null) || (this.staffid != null && !this.staffid.equals(other.staffid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "finasys.enities.Staff[ staffid=" + staffid + " ]";
    }
    
}
