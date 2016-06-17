package Classes;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ali on 14.06.16.
 */
public class Message implements Serializable {

    private int id;
    //private Date timestamp;
    private String state;
    private String device_id;
    private String subject;
    private String content;
    private int zone_id;

    /*public Date getTimestamp() {
        return timestamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timestamp = timeStamp;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDeviceId() {
        return device_id;
    }

    public void setDeviceId(String deviceId) {
        this.device_id = deviceId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getZoneId() {
        return zone_id;
    }

    public void setZoneId(int zoneId) {
        this.zone_id = zoneId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



}
