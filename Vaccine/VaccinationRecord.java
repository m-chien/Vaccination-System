package phantichtkhdt.tiemchung.Vaccine;

import phantichtkhdt.tiemchung.HealthcareCenter.HealthcareCenter;

import java.time.LocalDate;

//lịch sử tiêm chủng
public class VaccinationRecord {
    private Vaccine vaccine;
    private LocalDate Vaccinationdate;//ngày tiêm
    private HealthcareCenter DonViTiem;//đơn vị tiêm

    public VaccinationRecord(Vaccine vaccine, LocalDate vaccinationdate, HealthcareCenter donViTiem) {
        this.vaccine = vaccine;
        Vaccinationdate = vaccinationdate;
        this.DonViTiem = donViTiem;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public LocalDate getVaccinationdate() {
        return Vaccinationdate;
    }

    public void setVaccinationdate(LocalDate vaccinationdate) {
        Vaccinationdate = vaccinationdate;
    }

    public HealthcareCenter getDonViTiem() {
        return DonViTiem;
    }

    public void setDonViTiem(HealthcareCenter donViTiem) {
        DonViTiem = donViTiem;
    }

    @Override
    public String toString() {
        return "vaccine: " + vaccine +", ngày tiêm: " + Vaccinationdate +"\nĐơn vị tiêm:\n    '" + DonViTiem;
    }
}
