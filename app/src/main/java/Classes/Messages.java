package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali on 14.06.16.
 */
public class Messages implements Serializable {

    List<Message> messages;

    public Messages(){
        messages = new ArrayList<Message>();
    }
}
