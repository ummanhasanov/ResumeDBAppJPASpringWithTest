/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Umman Hasan
 */
@Entity
@Table(name = "user")
@XmlRootElement
//@NamedQueries({
//        @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
//        @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
//        @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
//        @NamedQuery(name = "User.findBySurname", query = "SELECT u FROM User u WHERE u.surname = :surname"),
//        @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
//        @NamedQuery(name = "User.findByPhone", query = "SELECT u FROM User u WHERE u.phone = :phone"),
//        @NamedQuery(name = "User.findByAddress", query = "SELECT u FROM User u WHERE u.address = :address"),
//        @NamedQuery(name = "User.findByBirthdate", query = "SELECT u FROM User u WHERE u.birthdate = :birthdate"),
//        @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;
//    @Basic(optional = false)
    @Column(name = "email")
    private String email;
//    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Lob
    @Column(name = "profile_description")
    private String profileDesc;
    @Column(name = "address")
    private String address;
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
//    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<UserSkill> userSkillList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<EmploymentHistory> employmentHistoryList;
    @JoinColumn(name = "nationality_id", referencedColumnName = "id")
    @ManyToOne
    private Country nationality;
    @JoinColumn(name = "birthplace_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Country birthplace;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

//    public User(Integer id, String name, String surname, String email, String phone, String password) {
//        this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.email = email;
//        this.phone = phone;
//        this.password = password;
//    }

//    public User(int id, String name, String surname, String phone, String email, java.sql.Date birthdate, Country birthplace, Country nationality) {
//        this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.phone = phone;
//        this.email = email;
//        this.birthdate = birthdate;
//        this.birthplace = birthplace;
//        this.nationality = nationality;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfileDesc() {
        return profileDesc;
    }

    public void setProfileDesc(String profileDesc) {
        this.profileDesc = profileDesc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserSkill> getUserSkillList() {
        return userSkillList;
    }

    public void setUserSkillList(List<UserSkill> userSkillList) {
        this.userSkillList = userSkillList;
    }

    public List<EmploymentHistory> getEmploymentHistoryList() {
        return employmentHistoryList;
    }

    public void setEmploymentHistoryList(List<EmploymentHistory> employmentHistoryList) {
        this.employmentHistoryList = employmentHistoryList;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Country getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(Country birthplace) {
        this.birthplace = birthplace;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getSurname();
    }

}
