package phantichtkhdt.tiemchung;

import phantichtkhdt.tiemchung.Account.*;
import phantichtkhdt.tiemchung.Children.children;
import phantichtkhdt.tiemchung.Children.childrenManager;
import phantichtkhdt.tiemchung.Employee.Employee;
import phantichtkhdt.tiemchung.Employee.EmployeeManager;
import phantichtkhdt.tiemchung.HealthcareCenter.HealthCenterRepository;
import phantichtkhdt.tiemchung.HealthcareCenter.HealthcareCenter;
import phantichtkhdt.tiemchung.HealthcareCenter.IHealthVaccineRepository;
import phantichtkhdt.tiemchung.Schedule.IVaccinationScheduleRepository;
import phantichtkhdt.tiemchung.Schedule.VaccinationScheduleManager;
import phantichtkhdt.tiemchung.Schedule.VaccinationScheduleRepository;
import phantichtkhdt.tiemchung.Vaccine.VaccinationManager;
import phantichtkhdt.tiemchung.Vaccine.Vaccine;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int chon;
        IUserRepository iUserRepository = new UserRepository();
        IAuthenticationService iAuthenticationService = new AuthenticationService(iUserRepository);
        IVaccinationScheduleRepository iVaccinationScheduleRepository = new VaccinationScheduleRepository();
        VaccinationScheduleManager vaccinationScheduleManager = new VaccinationScheduleManager(iVaccinationScheduleRepository);
        UserManager userManager1 = new UserManager(iUserRepository,iAuthenticationService);
        IGenericRepository<children> childrenRepository = new GenericRepository<>();
        childrenManager childrenManager = new childrenManager(childrenRepository);
        IHealthVaccineRepository<Vaccine> VaccineRepository = new HealthCenterRepository<>();
        IHealthVaccineRepository<HealthcareCenter> HealthcenterReopositoryy = new HealthCenterRepository<>();
        VaccinationManager vaccinationManager1 = new VaccinationManager(VaccineRepository,HealthcenterReopositoryy);
        IGenericRepository<Employee> IEmployeeRepository = new GenericRepository<>();
        EmployeeManager employeeManager = new EmployeeManager(HealthcenterReopositoryy,IEmployeeRepository);
        System.out.println("\n\nchào mừng bạn đã tới hệ thống tiêm chủng!!!!!!");
        do {
            System.out.println("1. Đăng Nhập\n2. Đăng Ký\n3. Thoát");
            chon = sc.nextInt();sc.nextLine();
            switch (chon)
            {
                case 1:
                {
                    UserAccount user = userManager1.dangnhap();
                    if (user != null)
                    {
                        int chon1;
                        do {
                            if (user.getRole() == Role.PARENT) {
                                System.out.println("1. Xem lịch tiêm chủng | 2. Xem vắc-xin | 3. Đăng kí tiêm chủng | 4. Thoát");
                            } else if (user.getRole() == Role.DOCTOR || user.getRole() == Role.STAFF) {
                                System.out.println("1. Quản lý lịch tiêm | 2. Thêm lịch tiêm | 3. Kiểm tra vắc-xin | 4. Thoát");
                            } else if (user.getRole() == Role.ADMIN) {
                                System.out.println("1. Quản lý tài khoản | 2. Quản lý nhân viên | 3. Thêm Nhân Viên | 4. Thoát");
                            }
                            chon1 = sc.nextInt(); sc.nextLine();
                            switch (chon1) {
                                case 1:
                                {
                                    if (user.getRole() == Role.PARENT) {
                                        System.out.println("----- LỊCH TIÊM CHỦNG -----");
                                        childrenManager.indanhsach();
                                    } else if (user.getRole() == Role.DOCTOR || user.getRole() == Role.STAFF) {
                                        System.out.println("----- QUẢN LÝ LỊCH TIÊM -----");
                                        vaccinationScheduleManager.quanLyLichTiem(user);
                                    } else if (user.getRole() == Role.ADMIN) {
                                        System.out.println("----- QUẢN LÝ TÀI KHOẢN -----");
                                        System.out.println(userManager1.GetAllUser());
                                    }
                                    break;
                                }
                                case 2:
                                    if (user.getRole() == Role.PARENT) {
                                        System.out.println("----- VẮC-XIN -----");
                                        System.out.println(vaccinationManager1.getVaccineAvailable());
                                    } else if (user.getRole() == Role.DOCTOR || user.getRole() == Role.STAFF) {
                                        System.out.println("----- THÊM LỊCH TIÊM -----");
                                        vaccinationScheduleManager.themlichtiem(user,childrenManager.getAllchildren(),vaccinationManager1.getVaccineAvailable(),employeeManager.getAllEmployee());
                                    } else if (user.getRole() == Role.ADMIN) {
                                        System.out.println("----- QUẢN LÝ NHÂN VIÊN -----");
                                        System.out.println(employeeManager.getAllEmployee());
                                    }
                                    break;
                                case 3:
                                    if (user.getRole() == Role.PARENT) {
                                        childrenManager.nhapthongtin();
                                        vaccinationManager1.addVaccine(childrenManager.laychildren());
                                        System.out.println("Đăng ký thành công!");
                                    } else if (user.getRole() == Role.DOCTOR || user.getRole() == Role.STAFF) {
                                        System.out.println("----- DANH SÁCH VẮC-XIN -----");
                                        System.out.println(vaccinationManager1.getVaccineAvailable());
                                    } else if (user.getRole() == Role.ADMIN) {
                                        System.out.println("----- QUẢN LÝ HỆ THỐNG -----");
                                        employeeManager.nhapthongtin();
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }while(chon1!=4);
                    }
                    break;
                }
                case 2:
                {
                    if (!userManager1.dangki())
                        System.out.println("đăng ký thất bại!!");
                    break;
                }
                case 3:
                    break;
                default:
                    System.out.println("chọn sai, vui lòng chọn lại");break;
            }
        }while (chon != 3);
        System.out.println("Cám ơn bạn đã dùng chương trình :)");
    }
}
