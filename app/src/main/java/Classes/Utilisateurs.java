package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali on 14.06.16.
 */
public class Utilisateurs implements Serializable {

    List<Utilisateur> utilisateurs;

    public Utilisateurs(){
        utilisateurs = new ArrayList<Utilisateur>();
    }
}
