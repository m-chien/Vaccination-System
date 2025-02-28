package phantichtkhdt.tiemchung.Account;

import java.util.Objects;

public class AuthenticationService implements IAuthenticationService {
    private final IUserRepository userRepository;

    public AuthenticationService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean checkpassword(String name,String password) {
        UserAccount user = userRepository.findusername(name);
        if (user == null) return false;
        else return Objects.equals(user.getPassword(), password);
    }
}
