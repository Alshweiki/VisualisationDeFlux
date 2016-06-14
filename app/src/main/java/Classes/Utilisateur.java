package Classes;

import java.io.Serializable;

/**
 * Created by Ali on 14.06.16.
 */
public class Utilisateur implements Serializable {

    private int id;

    public Events events;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
