/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.placementandreplacement.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author G551VW
 */
@Entity
@Table(name = "placement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Placement.findAll", query = "SELECT p FROM Placement p")
    , @NamedQuery(name = "Placement.findById", query = "SELECT p FROM Placement p WHERE p.id = :id")
    , @NamedQuery(name = "Placement.findByStartDate", query = "SELECT p FROM Placement p WHERE p.startDate = :startDate")
    , @NamedQuery(name = "Placement.findByEndDate", query = "SELECT p FROM Placement p WHERE p.endDate = :endDate")
    , @NamedQuery(name = "Placement.findByNote", query = "SELECT p FROM Placement p WHERE p.note = :note")})
public class Placement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Size(max = 100)
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "client", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;
    @JoinColumn(name = "employee", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;
    @JoinColumn(name = "status_aproval", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private StatusAproval statusAproval;

    public Placement() {
    }

    public Placement(Integer id) {
        this.id = id;
    }

    public Placement(Integer id, Date startDate) {
        this.id = id;
        this.startDate = startDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public StatusAproval getStatusAproval() {
        return statusAproval;
    }

    public void setStatusAproval(StatusAproval statusAproval) {
        this.statusAproval = statusAproval;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Placement)) {
            return false;
        }
        Placement other = (Placement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.placementandreplacement.entities.Placement[ id=" + id + " ]";
    }
    
}
