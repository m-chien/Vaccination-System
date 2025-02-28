package phantichtkhdt.tiemchung.Account;

import java.util.List;

public interface IUserRepository {
    UserAccount findusername(String username);
    void add(UserAccount user);
    void delete(String username);
    List<UserAccount> getAll();
    void save(UserAccount user);
}
