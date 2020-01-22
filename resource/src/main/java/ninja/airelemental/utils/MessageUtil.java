package ninja.airelemental.utils;

import ninja.airelemental.services.Change;
import ninja.airelemental.services.Message;

import java.security.Principal;
import java.util.List;

public class MessageUtil {

    public static String transformMessage(Message map, Principal principal, List<Change> changes) {
        if (map.getContent() != null) {
            changes.add(new Change(principal.getName(), map.getContent()));
            // a list of 10 minimum.
            // a test changes than 10, remove to be executed.
            while (changes.size() > 10) {
                changes.remove(0);
            }
        }
        return map.getContent();
    }
}
