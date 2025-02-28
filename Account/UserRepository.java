package phantichtkhdt.tiemchung.Account;

import phantichtkhdt.tiemchung.Role;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements  IUserRepository {
    private List<UserAccount> qlyuser = new ArrayList<>();

    public UserRepository() {
        initData(); // Gọi phương thức khởi tạo tài khoản mẫu
    }

    private void initData() {
        qlyuser.add(new UserAccount("doctor1", "Doctor123", Role.DOCTOR));
        qlyuser.add(new UserAccount("admin", "Admin123", Role.ADMIN));
        qlyuser.add(new UserAccount("staff", "Staff123", Role.STAFF));
    }
    @Override
    public List<UserAccount> getAll() {
        return qlyuser;
    }

    @Override
    public void add(UserAccount user) {
        qlyuser.add(user);
    }

    @Override
    public UserAccount findusername(String username) {
        for (UserAccount user: qlyuser)
        {
            if (user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    @Override
    public void save(UserAccount user) {
        for (int i = 0; i < qlyuser.size(); i++) {
            if (qlyuser.get(i).getUsername().equals(user.getUsername())) {
                qlyuser.set(i, user); // Cập nhật thông tin user
                return;
            }
        }
    }

    @Override
    public void delete(String username) {
        qlyuser.remove(username);
    }
}
