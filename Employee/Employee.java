package phantichtkhdt.tiemchung.Employee;

import phantichtkhdt.tiemchung.HealthcareCenter.HealthcareCenter;
import phantichtkhdt.tiemchung.Human;
import phantichtkhdt.tiemchung.Role;

import java.time.LocalDate;

public class Employee extends Human {
    private static int idCounter =1;
    private int Id;
    private Role role;
    private String phone;
    private HealthcareCenter healthcareCenter;

    public Employee(String name, LocalDate dateofBirth, byte gender,Role role, String phone, HealthcareCenter healthcareCenter) {
        super(name, dateofBirth, gender);
        Id = idCounter++;
        this.role = role;
        this.phone = phone;
        this.healthcareCenter = healthcareCenter;
    }

    public HealthcareCenter getHealthcareCenter() {
        return healthcareCenter;
    }

    public void setHealthcareCenter(HealthcareCenter healthcareCenter) {
        this.healthcareCenter = healthcareCenter;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", DateofBirth=" + DateofBirth +
                ", Gender=" + Gender +
                ", role=" + role +
                ", phone='" + phone + '\'' +
                ", healthcareCenter=" + healthcareCenter +
                '}'+"\n";
    }
}
