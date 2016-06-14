package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali on 14.06.16.
 */
public class Antennes implements Serializable {

    public List<Antenne> antenne;

    public Antennes(){
        antenne = new ArrayList<Antenne>();
    }
}
