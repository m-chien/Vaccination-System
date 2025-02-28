package phantichtkhdt.tiemchung;

import java.time.LocalDate;

public abstract class Human {
    protected String Name;
    protected LocalDate DateofBirth;
    protected byte Gender;

    public Human(String name, LocalDate dateofBirth, byte gender) {
        Name = name;
        DateofBirth = dateofBirth;
        Gender = gender;
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
}
