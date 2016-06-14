package Classes;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ali on 14.06.16.
 */
public class Agg implements Serializable {

    private Date timestamp;
    private int antenneId;
    private float value;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getAntenneId() {
        return antenneId;
    }

    public void setAntenneId(int antenneId) {
        this.antenneId = antenneId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }



}
