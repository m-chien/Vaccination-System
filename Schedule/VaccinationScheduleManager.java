package phantichtkhdt.tiemchung.Schedule;

import phantichtkhdt.tiemchung.Account.UserAccount;
import phantichtkhdt.tiemchung.Children.children;
import phantichtkhdt.tiemchung.Employee.Employee;
import phantichtkhdt.tiemchung.Role;
import phantichtkhdt.tiemchung.Vaccine.Vaccine;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class VaccinationScheduleManager {
    private final IVaccinationScheduleRepository iVaccinationScheduleRepository;

    public VaccinationScheduleManager(IVaccinationScheduleRepository iVaccinationScheduleRepository) {
        this.iVaccinationScheduleRepository = iVaccinationScheduleRepository;
    }

    public void quanLyLichTiem(UserAccount user)
    {
        System.out.println("danh sách lịch hẹn tiêm chủng: ");
        for (VaccinationAppointment appointment : iVaccinationScheduleRepository.getAllappointment())
        {
            if (appointment.getDoctor().getId() == user.getId())
                System.out.println(appointment);
        }
    }

    public void themlichtiem(UserAccount user, List<children> childrenList, List<Vaccine> vaccineList,List<Employee> employeeList)
    {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < childrenList.size(); i++) {
            System.out.println((i + 1) + ". " + childrenList.get(i).getName());
        }
        System.out.print(" vui lòng chọn trẻ: ");
        int children = sc.nextInt();sc.nextLine();
        for (int i = 0; i < vaccineList.size(); i++) {
            System.out.println((i + 1) + ". " + vaccineList.get(i));
        }
        System.out.print("Vui lòng chọn vắc-xin: ");
        int vaccine = sc.nextInt();
        System.out.println("chọn trạng thái: 1. Chờ Tiêm | 2. Đã Tiêm | 3. Hoãn | 4. Chống Chỉ Định");
        int chon;
        String status;
        chon = sc.nextInt();sc.nextLine();
        switch (chon)
        {
            case 1: status = "Chờ Tiêm";break;
            case 2: status = "Đã Tiêm";break;
            case 3: status = "Hoãn"; break;
            case 4: status = "Chống Chỉ Định";break;
            default: status = "Chờ Tiêm";break;
        }
        System.out.println("nhập ngày tiêm: ");
        LocalDate birthdate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Employee doctor = null;
        for (Employee e : employeeList) {
            if (e.getRole() == Role.DOCTOR && e.getId() == user.getId()) {
                doctor = e;
                break;
            }
        }
        if (doctor == null) {
            System.out.println("Không tìm thấy bác sĩ tương ứng!");
        }
        else
        {
            VaccinationAppointment v1 = new VaccinationAppointment(childrenList.get(children-1),vaccineList.get(vaccine-1),birthdate,doctor,status);
            iVaccinationScheduleRepository.addApointment(v1);
            System.out.println("thêm thành công!!!");
        }
    }

}
