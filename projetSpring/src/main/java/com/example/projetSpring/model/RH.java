package com.example.projetSpring.model;



import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rh")  //
public class RH extends Employee {
   
    public RH() {
        super();
    }
   
    public RH(String cin, String nom, String prenom, Date dateDeNaissance, double salaire, String role, String email, String adresse, String telephone, int nombreDeJoursConge, List<LeaveRequest> leaveRequests) {
        super(cin, nom, prenom, dateDeNaissance, salaire, role, email, adresse, telephone, nombreDeJoursConge, leaveRequests);
    }
}
