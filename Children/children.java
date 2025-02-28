package phantichtkhdt.tiemchung.Children;

import phantichtkhdt.tiemchung.Human;
import phantichtkhdt.tiemchung.Vaccine.VaccinationRecord;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class children extends Human {
    Scanner sc;
    private static int idCounter =1;
    private int Id;
    private HealthProfile healthProfile;
    private List<VaccinationRecord>  vaccinationRecord;


    public children(String name, LocalDate dateofBirth, byte gender, HealthProfile healthProfile) {
        super(name, dateofBirth, gender);
        Id = idCounter++;
        this.healthProfile = healthProfile;
        this.vaccinationRecord = new ArrayList<>();
    }

    public List<VaccinationRecord> getVaccinationRecord() {
        return vaccinationRecord;
    }

    public void setVaccinationRecord(List<VaccinationRecord> vaccinationRecord) {
        this.vaccinationRecord = vaccinationRecord;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public LocalDate getDateofBirth() {
        return DateofBirth;
    }

    public void setDateofBirth(LocalDate dateofBirth) {
        DateofBirth = dateofBirth;
    }

    public byte getGender() {
        return Gender;
    }

    public void setGender(byte gender) {
        Gender = gender;
    }

    public HealthProfile getHealthProfile() {
        return healthProfile;
    }

    public void setHealthProfile(HealthProfile healthProfile) {
        this.healthProfile = healthProfile;
    }

    @Override
    public String toString() {
        return "Id: " + Id +
                ", tên: '" + Name + '\'' +
                ", Ngày Sinh: " + DateofBirth +
                ", Giới tính: " + Gender+", " + healthProfile + vaccinationRecord+"\n";
    }

    public void addVAccinationRecord(VaccinationRecord recorrd)
    {
        vaccinationRecord.add(recorrd);
    }
}
