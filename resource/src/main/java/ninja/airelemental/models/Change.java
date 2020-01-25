package ninja.airelemental.models;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class Change {

    private Date timestamp = new Date();
    private String user;
    private String message;

    Change() {
    }

    public Change(String user, String message) {
        this.user = user;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

}