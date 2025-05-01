package viet.websocket.chatApp.chatroom;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatRoom {
    @Id
    String id;
    String chatId;
    String senderId;;
    String recipientId;
}
