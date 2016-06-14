package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali on 14.06.16.
 */
public class Events implements Serializable {

    List<Event> events;

    public Events(){
        events = new ArrayList<Event>();
    }
}
