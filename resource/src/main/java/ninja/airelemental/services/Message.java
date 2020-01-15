package ninja.airelemental.services;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Message {

        private String id = UUID.randomUUID().toString();
        private String content;

        Message() {
        }

        public Message(String content) {
            this.content = content;
        }

        public String getId() {
            return id;
        }

        public String getContent() {
            return content;
        }


}
