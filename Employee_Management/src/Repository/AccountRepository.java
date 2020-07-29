package Repository;

import java.util.Scanner;

public interface AccountRepository {
    void login();
    boolean isExist(String username , String password);
    boolean isAdmin(String role_id);
}
