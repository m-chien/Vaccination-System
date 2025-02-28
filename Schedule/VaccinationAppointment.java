package phantichtkhdt.tiemchung.Schedule;

import phantichtkhdt.tiemchung.Account.UserAccount;
import phantichtkhdt.tiemchung.Children.children;
import phantichtkhdt.tiemchung.Employee.Employee;
import phantichtkhdt.tiemchung.Vaccine.Vaccine;

import java.time.LocalDate;

public class VaccinationAppointment {
    private children children;
    private Vaccine vaccine;
    private LocalDate date;
    private Employee doctor;
    private String status;

    public VaccinationAppointment(children children, Vaccine vaccine, LocalDate date, Employee doctor, String status) {
        this.children = children;
        this.vaccine = vaccine;
        this.date = date;
        this.doctor = doctor;
        this.status = status;
    }

    public children getChildren() {
        return children;
    }

    public void setChildren(children children) {
        this.children = children;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Employee getDoctor() {
        return doctor;
    }

    public void setDoctor(Employee doctor) {
        this.doctor = doctor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Lịch hẹn{" +
                "Trẻ: " + children +
                ", vaccine: " + vaccine +
                ", Ngày tiêm: " + date +
                ", Bác Sĩ: " + doctor +
                ", Trạng Thái: '" + status + '\'' +
                '}';
    }
}
