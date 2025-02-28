package phantichtkhdt.tiemchung.Vaccine;

import java.time.LocalDate;

public class Vaccine {
    private String nameVaccine;
    private String manufactuorVaccine;
    private int soluong;

    public Vaccine(String nameVaccine, String manufactuorVaccine, int soluong) {
        this.nameVaccine = nameVaccine;
        this.manufactuorVaccine = manufactuorVaccine;
        this.soluong = soluong;
    }

    public Vaccine() {
    }

    public String getNameVaccine() {
        return nameVaccine;
    }

    public void setNameVaccine(String nameVaccine) {
        this.nameVaccine = nameVaccine;
    }

    public String getManufactuorVaccine() {
        return manufactuorVaccine;
    }

    public void setManufactuorVaccine(String manufactuorVaccine) {
        this.manufactuorVaccine = manufactuorVaccine;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @Override
    public String toString() {
        return
                "Tên Vắc-Xin: '" + nameVaccine + '\'' +
                ", Nơi sản xuất: " + manufactuorVaccine + '\'' +
                ", số lượng cần tiêm: " + soluong+"\n";
    }
}
