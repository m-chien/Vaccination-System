package phantichtkhdt.tiemchung.Employee;

import phantichtkhdt.tiemchung.HealthcareCenter.HealthcareCenter;
import phantichtkhdt.tiemchung.IGenericRepository;
import phantichtkhdt.tiemchung.HealthcareCenter.IHealthVaccineRepository;
import phantichtkhdt.tiemchung.Role;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
    private final IGenericRepository<Employee> qly;
    private final IHealthVaccineRepository<HealthcareCenter> iHealthcenter;

    public EmployeeManager(IHealthVaccineRepository<HealthcareCenter> iHealthcenter, IGenericRepository<Employee> qly ) {
        this.iHealthcenter = iHealthcenter;
        this.qly = qly;
        qly.add(new Employee("doctor1", LocalDate.of(1990, 5, 15), (byte) 1, Role.DOCTOR, "0123456789", iHealthcenter.getHealthcareCenter().get(0)));
        qly.add(new Employee("admin", LocalDate.of(1992, 12, 10), (byte) 1, Role.ADMIN, "0912345678", iHealthcenter.getHealthcareCenter().get(0)));
        qly.add(new Employee("staff", LocalDate.of(1985, 8, 20), (byte) 2, Role.STAFF, "0987654321", iHealthcenter.getHealthcareCenter().get(1)));
    }
    public void nhapthongtin()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập tên: ");
        String name = sc.nextLine();
        System.out.println("nhập ngày sinh: ");
        LocalDate birthdate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("nhập giới tính: 1: Nam | 2. Nữ");
        byte gender = sc.nextByte();
        System.out.println("nhập vai trò của bạn: 1. nhân viên | 2. bác sĩ | 3. Quản trị viên");
        Role role;
        int chon;
        do {
            chon = sc.nextInt();sc.nextLine();
            switch (chon)
            {
                case 1:
                    role = Role.STAFF;
                    break;
                case 2:
                    role = Role.DOCTOR;
                    break;
                case 3:
                    role = Role.ADMIN;
                    break;
                default:
                    role = Role.STAFF;
                    System.out.println("bạn nhập sai");
                    break;
            }
        }while(chon<1 || chon>3);
        System.out.println("nhập số điện thoại: ");
        String phone = sc.nextLine();
        for (int i = 0; i < iHealthcenter.getHealthcareCenter().size(); i++) {
            System.out.println((i+1)+". " + iHealthcenter.getHealthcareCenter().get(i));
        }
        System.out.println("vui lòng chọn khu y tế cần ở: ");
        int choose = sc.nextInt();sc.nextLine();
        HealthcareCenter healthcareCenter = iHealthcenter.getHealthcareCenter().get(choose-1);
        Employee employee = new Employee(name,birthdate,gender,role,phone,healthcareCenter);
        qly.add(employee);
        System.out.println("đã nhập thông tin!");
    }
    public List<Employee> getAllEmployee()
    {
        return qly.getAll();
    }
}
