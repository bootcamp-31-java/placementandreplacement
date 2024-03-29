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
@Table(name = "interview")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Interview.findAll", query = "SELECT i FROM Interview i")
    , @NamedQuery(name = "Interview.findById", query = "SELECT i FROM Interview i WHERE i.id = :id")
    , @NamedQuery(name = "Interview.findByDate", query = "SELECT i FROM Interview i WHERE i.date = :date")
    , @NamedQuery(name = "Interview.findByTime", query = "SELECT i FROM Interview i WHERE i.time = :time")
    , @NamedQuery(name = "Interview.findByNote", query = "SELECT i FROM Interview i WHERE i.note = :note")})
public class Interview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "client", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;
    @JoinColumn(name = "employee", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;

    public Interview() {
    }

    public Interview(Integer id) {
        this.id = id;
    }

    public Interview(Integer id, Date date, Date time, String note) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interview)) {
            return false;
        }
        Interview other = (Interview) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.placementandreplacement.entities.Interview[ id=" + id + " ]";
    }
    
}
