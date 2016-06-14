package Classes;

import java.io.Serializable;

/**
 * Created by Ali on 14.06.16.
 */
public class AppUser implements Serializable {

    public String username;
    public String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
