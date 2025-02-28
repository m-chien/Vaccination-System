package phantichtkhdt.tiemchung.Vaccine;

import phantichtkhdt.tiemchung.Children.children;
import phantichtkhdt.tiemchung.HealthcareCenter.HealthcareCenter;
import phantichtkhdt.tiemchung.HealthcareCenter.IHealthVaccineRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VaccinationManager {
    private final Scanner sc = new Scanner(System.in);
    private final IHealthVaccineRepository<Vaccine> qlyvaccine;
    private final IHealthVaccineRepository<HealthcareCenter> qly;

    //lấy thông tin vắc-xin
    public List<Vaccine> getVaccineAvailable() {
        return qlyvaccine.getHealthcareCenter();
    }

    public VaccinationManager(IHealthVaccineRepository<Vaccine> qlyvaccine, IHealthVaccineRepository<HealthcareCenter> qly) {
        this.qlyvaccine = qlyvaccine;
        this.qly = qly;
        qlyvaccine.add(new Vaccine("Sởi - Rubella", "Viện Vắc-xin Nha Trang", 1));
        qlyvaccine.add(new Vaccine("Viêm gan B", "Sanofi", 3));
        qlyvaccine.add(new Vaccine("Bại liệt", "GSK", 2));

        qly.add(new HealthcareCenter("Trạm Y tế Phường A", "123 Đường ABC", "0123456789"));
        qly.add(new HealthcareCenter("Bệnh viện Nhi Đồng 2", "456 Đường XYZ", "0987654321"));
    }
    public void addVaccine(children children)
    {
        for (int i = 0; i < qlyvaccine.getsize(); i++) {
            System.out.println((i+1)+". " + qlyvaccine.gethealthcenter(i));
        }
        System.out.print("vui lòng chọn vắc-xin cần tiêm: ");
        int chon = sc.nextInt();sc.nextLine();
        Vaccine vaccine = qlyvaccine.gethealthcenter(chon-1);
        System.out.println("nhập ngày tiêm (vd: 2025-10-15): ");
        LocalDate date = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        for (int i = 0; i < qly.getsize(); i++) {
            System.out.println((i+1)+". " + qly.gethealthcenter(i));
        }
        System.out.println("vui lòng chọn khu y tế cần tiêm: ");
        int choose = sc.nextInt();sc.nextLine();
        HealthcareCenter healthcareCenter = qly.gethealthcenter(choose-1);
        VaccinationRecord record = new VaccinationRecord(vaccine,date,healthcareCenter);
        children.addVAccinationRecord(record);
    }
}
