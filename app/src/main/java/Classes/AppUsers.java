package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali on 14.06.16.
 */
public class AppUsers implements Serializable {

    public List<AppUser> appusers;

    public AppUsers(){
        appusers = new ArrayList<AppUser>();
    }

}
