package phantichtkhdt.tiemchung.Account;

import phantichtkhdt.tiemchung.Children.children;
import phantichtkhdt.tiemchung.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private IUserRepository qlyUserAccount;
    private final IAuthenticationService authenticationService;

    public UserManager(IUserRepository qlyUserAccount, IAuthenticationService authenticationService) {
        this.qlyUserAccount = qlyUserAccount;
        this.authenticationService = authenticationService;
    }

    public List<UserAccount> GetAllUser()
    {
        return qlyUserAccount.getAll();
    }

    //đăng kí
    public boolean dangki()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập tên tài khoản: ");
        String name = sc.nextLine();
        System.out.println("vui lòng nhập mật khẩu (mật khẩu phải bao gồm chữ viết hoa, số và lớn hơn 8): ");
        for (int i = 0; i < 3; i++) {
            String password = sc.nextLine();
            if (check(password))
            {
                Role role = Role.PARENT;
                UserAccount user = new UserAccount(name,password,role);
                qlyUserAccount.add(user);
                System.out.println("Đã đăng kí thành công!!!!!");
                return true;
            }
            System.out.println("bạn nhập sai, vui lòng nhập lại. còn "+ (2-i) + "lần");
        }
        return false;
    }
    //đăng nhập
    public UserAccount dangnhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập tên tài khoản: ");
        String name = sc.nextLine();
        System.out.println("vui lòng nhập mật khẩu: ");
        String password = sc.nextLine();
        UserAccount user = qlyUserAccount.findusername(name);
        if(user!= null && authenticationService.checkpassword(user.getUsername(), password))
        {
            System.out.println("nhập vai trò của bạn: 1. nhân viên | 2. bác sĩ | 3. Quản trị viên | 4. Phụ Huynh");
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
                    case 4:
                        role = Role.PARENT;
                        break;
                    default:
                        role = Role.PARENT;
                        System.out.println("bạn nhập sai");
                        break;
                }
            }while(chon<1 || chon>4);
            if (role == user.getRole())
            {
                System.out.println("chào mừng bạn quay trở lại hệ thống");
                return user;
            }
        }
        System.out.println("đăng nhập sai hoặc bạn chưa có tài khoản");
        return null;
    }
    //đổi mật  khẩu
    public boolean doimk()
    {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("nhập tên tài khoản: ");
            String name = sc.nextLine();
            System.out.println("vui lòng nhập mật khẩu: ");
            String password = sc.nextLine();
            UserAccount user = qlyUserAccount.findusername(name);
            if(user!= null && authenticationService.checkpassword(user.getUsername(), password))
            {
                System.out.println("vui lòng nhập mật khẩu mới");
                String pass = sc.nextLine();
                user.setPassword(pass);
                qlyUserAccount.save(user);
                System.out.println("đổi thành công!!!");
                return true;
            }
            System.out.println("nhập sai tên hoặc mật khẩu!(nhập sai tối đa 3 lần)");
        }
        return false;
    }
    //xóa người dùng
    public void xoaUser(String username)
    {
        UserAccount user = qlyUserAccount.findusername(username);
        if (user == null)
        {
            System.out.println("người dùng không tòn tại");
            return;
        }
        qlyUserAccount.delete(username);
        System.out.println("xóa thành công");
    }
    //tìm theo tên
    public UserAccount findUser(String name)
    {
       return qlyUserAccount.findusername(name);
    }
    //ktra mat khau
    public boolean check(String password)
    {
        if (password.length()<= 8)
            System.out.println("mật khẩu phải lớn hơn 8 ký tự");
        else
        {
            int viethooa =0;
            int so =0;
            for (char s: password.toCharArray())
            {
                if (s>='1' && s<= '9') so =1;
                if (s>= 'A' && s<= 'Z') viethooa =1;
                if (so ==1 && viethooa == 1 ) return true;
            }
        }
        return false;
    }
}
