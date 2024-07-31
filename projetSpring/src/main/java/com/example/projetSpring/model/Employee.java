package com.example.projetSpring.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Employee {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false, unique = true)
    protected String cin;

    @Column(nullable = false)
    protected String nom;

    @Column(nullable = false)
    protected String prenom;

    @Temporal(TemporalType.DATE)
    protected Date dateDeNaissance;

    protected double salairebrut;

    @Enumerated(EnumType.STRING)
    protected String position;

    @Column(nullable = false, unique = true)
    protected String email;

    protected String adresse;

    protected String telephone;

    protected int nombreDeJoursConge;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    protected List<LeaveRequest> leaveRequests;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    protected List<Bonus> bonuses;
    
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    protected List<Salary> salaries;



    public Employee() {
    }

    public Employee(String cin, String nom, String prenom, Date dateDeNaissance, double salaire, String role, String email, String adresse, String telephone, int nombreDeJoursConge, List<LeaveRequest> leaveRequests, List<Bonus> bonuses, List<Salary> salaries) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.position = role;
        this.salairebrut=salaire;
        this.email = email;
        this.adresse = adresse;
        this.telephone = telephone;
        this.nombreDeJoursConge = nombreDeJoursConge;
        this.leaveRequests = leaveRequests;
        this.bonuses = bonuses;
        this.salaries = salaries;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
    
    public double getSalairebrut() {
        return salairebrut;
    }

    public void setSalairebrut(double salairebrut) {
        this.salairebrut = salairebrut;
    }

    public String  getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getNombreDeJoursConge() {
        return nombreDeJoursConge;
    }

    public void setNombreDeJoursConge(int nombreDeJoursConge) {
        this.nombreDeJoursConge = nombreDeJoursConge;
    }
    public List<LeaveRequest> getLeaveRequests() {
        return leaveRequests;
    }

    public void setLeaveRequests(List<LeaveRequest> leaveRequests) {
        this.leaveRequests = leaveRequests;
    }
    public List<Bonus> getBonuses() {
        return bonuses;
    }
    
    public void setBonuses(List<Bonus> bonuses) {
        this.bonuses = bonuses;
    }
    
    public List<Salary> getSalaries() {
        return salaries;
    }
    
    public void setSalaries(List<Salary> salaries) {
        this.salaries = salaries;
    }
    
}
