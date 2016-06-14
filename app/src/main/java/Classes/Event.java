package Classes;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ali on 14.06.16.
 */
public class Event implements Serializable {

    private int id;
    private String type;
    private Date timeStamp;
    private int antenneID;
    private int utilisateurId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAntenneID() {
        return antenneID;
    }

    public void setAntenneID(int antenneID) {
        this.antenneID = antenneID;
    }

    public int getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(int utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }


}
