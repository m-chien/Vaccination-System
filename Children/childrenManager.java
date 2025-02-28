package phantichtkhdt.tiemchung.Children;

import phantichtkhdt.tiemchung.Account.UserAccount;
import phantichtkhdt.tiemchung.IGenericRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class childrenManager {
    private final Scanner sc = new Scanner(System.in);
    private final IGenericRepository<children> qly;
    public childrenManager(IGenericRepository<children> qly) {
        this.qly = qly;
    }
    //nhập và thêm trẻ
    public void nhapthongtin()
    {
        System.out.println("nhập tên trẻ: ");
        String name = sc.nextLine();
        System.out.println("nhập ngày sinh: ");
        LocalDate birthdate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("nhập giới tính: 1: Nam | 2. Nữ");
        byte gender = sc.nextByte();
        System.out.println("nhập cân nặng(kg): ");
        double weight = sc.nextDouble();
        System.out.println("nhập chiều cao(m): ");
        double height = sc.nextDouble();sc.nextLine();
        HealthProfile healthProfile = new HealthProfile(weight,height);
        children child = new children(name,birthdate,gender,healthProfile);
        qly.add(child);
        System.out.println("thêm thành công trẻ!");
    }
    //xem danh sách trẻ
    public void indanhsach()
    {
        System.out.println("nhập tên trẻ muốn xem lịch tiêm: ");
        String name = sc.nextLine();
        for (children c: qly.getAll())
        {
            if(c.getName().equals(name))
            {
                System.out.println(c);
                break;
            }
        }
    }
    public List<children> getAllchildren()
    {
        return qly.getAll();
    }
    public children laychildren()
    {
        return qly.getUser();
    }
}
