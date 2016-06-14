package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali on 14.06.16.
 */
public class Zones implements Serializable {

    public List<Zone> zone;
    public Zones(){
        zone = new ArrayList<Zone>();
    }
}
