package Classes;

import java.io.Serializable;

/**
 * Created by Ali on 14.06.16.
 */
public class Antenne implements Serializable {
    private int id;
    private float lat;
    private float lng;


    public Agg agg;

    public Antenne(){}

    public float getZoneID() {
        return zoneID;
    }

    public void setZoneID(float zoneID) {
        this.zoneID = zoneID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    private float zoneID;


}
