package ninja.airelemental.utils;

import ninja.airelemental.models.Change;
import ninja.airelemental.models.Message;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.List;

@Controller
public class MessageUtil {

    public static String adminSubmitsNewChange(Message map, Principal principal, List<Change> changes) {
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
