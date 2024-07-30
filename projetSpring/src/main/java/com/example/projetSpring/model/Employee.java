package com.example.projetSpring.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Employee {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String cin;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Temporal(TemporalType.DATE)
    private Date dateDeNaissance;

    private double salaire;

    @Enumerated(EnumType.STRING)
    private String position;

    @Column(nullable = false, unique = true)
    private String email;

    private String adresse;

    private String telephone;

    private int nombreDeJoursConge;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<LeaveRequest> leaveRequests;


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Prime> primes;

    public Employee() {
    }

    public Employee(String cin, String nom, String prenom, Date dateDeNaissance, double salaire, String role, String email, String adresse, String telephone, int nombreDeJoursConge, List<LeaveRequest> leaveRequests) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.salaire = salaire;
        this.position = role;
        this.email = email;
        this.adresse = adresse;
        this.telephone = telephone;
        this.nombreDeJoursConge = nombreDeJoursConge;
        this.leaveRequests = leaveRequests;
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

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
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
    
}
