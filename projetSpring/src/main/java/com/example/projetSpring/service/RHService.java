package com.example.projetSpring.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.example.projetSpring.model.Bonus;
import com.example.projetSpring.model.Employee;
import com.example.projetSpring.model.LeaveRequest;
import com.example.projetSpring.model.RH;
import com.example.projetSpring.model.Salary;
import com.example.projetSpring.repository.EmployeeRepository;
import com.example.projetSpring.repository.LeaveRequestRepository;
import com.example.projetSpring.repository.RHRepository;
import com.example.projetSpring.repository.SalaryRepository;
import com.example.projetSpring.repository.BonusRepository;
@Service
public class RHService {
    @Autowired
    private RHRepository rhRepository;

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SalaryRepository salaryRepository;
    @Autowired
    private BonusRepository bonusRepository;


    public RH getRHById(Long id) {
        return rhRepository.findById(id).orElse(null);
    }

    public void approveLeaveRequest(Long requestId) {
        LeaveRequest request = leaveRequestRepository.findById(requestId).orElse(null);
        if (request != null) {
            request.setApproved(true);
            leaveRequestRepository.save(request);
        }
    }

    public void rejectLeaveRequest(Long requestId) {
        LeaveRequest request = leaveRequestRepository.findById(requestId).orElse(null);
        if (request != null) {
            request.setApproved(false);
            leaveRequestRepository.save(request);
        }
    }

    public void updateEmployeeInfo(Long employeeId, String newAddress, String newPhone) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            employee.setAdresse(newAddress);
            employee.setTelephone(newPhone);
            employeeRepository.save(employee);
        }
    }

    public void assignSalary(Long employeeId, double newSalary) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            employee.setSalairebrut(newSalary);
            employeeRepository.save(employee);
        }
    }

    public void assignBonus(Long employeeId, double bonus) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            employee.setSalairebrut(employee.getSalairebrut() + bonus);
            employeeRepository.save(employee);
        }
    }


    
    public Salary addSalaryToEmployee(Long employeeId, double baseSalary) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            Salary salary = new Salary(employee, baseSalary);
            Salary savedSalary = salaryRepository.save(salary);
            employee.getSalaries().add(salary);
            employeeRepository.save(employee);
            return savedSalary;
        } else {
            return null;
        }
    }
    public Bonus addBonusToEmployee(Long employeeId, double amount) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            Bonus bonus = new Bonus(employee, amount, new Date());
            employee.getBonuses().add(bonus);
            employeeRepository.save(employee);
            Bonus savedBonus = bonusRepository.save(bonus); // Stocker le bonus sauvegardé dans une variable
            return savedBonus; // Retourner la variable
        } else {
            return null;
        }
    }
    public Salary addSalaryToEmployeeWithBonus(Long employeeId, double baseSalary, double bonusAmount) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            // Ajouter le bonus à l'employé
            Bonus bonus = addBonusToEmployee(employeeId, bonusAmount);

            // Créer un nouveau salaire avec le bonus inclus
            Salary salary = new Salary(employee, baseSalary);
            salary.setTotalBonuses(bonusAmount);
            salary.setTotalSalary(baseSalary + bonusAmount);
            employee.getSalaries().add(salary);
            employeeRepository.save(employee);
            return salaryRepository.save(salary);
        } else {
            return null;
        }
    }
}
