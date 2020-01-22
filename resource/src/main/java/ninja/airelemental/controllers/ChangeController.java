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


    // {{item.timestamp}} ({{item.user}}): "{{item.message}}"   template from changes.component.html
    // body: {content: this.greeting['content']}  update() from write.component.ts
    @GetMapping(value = "/changes")
    public List<Change> changes() { // Stores every instance of the "Change" class created by the Admin submit button.
        return changes;
    }


    // from write.component.ts
    // this.http.post('/resource', {content: this.greeting['content']})
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
