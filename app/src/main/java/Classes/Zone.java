package Classes;

import java.io.Serializable;

/**
 * Created by Ali on 14.06.16.
 */
public class Zone implements Serializable {


    private int id;
    private String name;
    private String type;



    private String AggTime;
    private float lat1;
    private float lat2;
    private float lng1;
    private float lng2;

    public Antennes antennes;
    public Messages messages;

    public Zone(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getLat1() {
        return lat1;
    }

    public void setLat1(float lat1) {
        this.lat1 = lat1;
    }

    public float getLat2() {
        return lat2;
    }

    public void setLat2(float lat2) {
        this.lat2 = lat2;
    }

    public float getLng1() {
        return lng1;
    }

    public void setLng1(float lng1) {
        this.lng1 = lng1;
    }

    public float getLng2() {
        return lng2;
    }

    public void setLng2(float lng2) {
        this.lng2 = lng2;
    }

    public String getAggTime() {
        return AggTime;
    }

    public void setAggTime(String aggTime) {
        AggTime = aggTime;
    }



}
