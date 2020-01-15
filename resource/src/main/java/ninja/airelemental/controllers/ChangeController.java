package ninja.airelemental.controllers;

import ninja.airelemental.services.Change;
import ninja.airelemental.services.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ChangeController {

    private String message = "Hello World";
    private List<Change> changes = new ArrayList<>();

    @GetMapping(value = "/")
    public Message home() {
        return new Message(message);
    }

    @GetMapping(value = "/changes")
    public List<Change> changes() {
        return changes;
    }

    @PostMapping(value = "/")
    public Message update(@RequestBody Message map, Principal principal) {
        if (map.getContent() != null) {
            message = map.getContent();
            changes.add(new Change(principal.getName(), message));
            while (changes.size() > 10) {
                changes.remove(0);
            }
        }
        return new Message(message);
    }

}
