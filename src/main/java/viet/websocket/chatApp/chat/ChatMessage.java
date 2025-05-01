package viet.websocket.chatApp.chat;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document
public class ChatMessage {
    @Id
    String id;
    String ChatId;
    String senderId;
    String recipientId;
    String content;
    Timestamp timestamp;
}
