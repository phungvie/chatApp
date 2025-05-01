package viet.websocket.chatApp.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import viet.websocket.chatApp.chatroom.ChatRoomService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatRoomService chatRoomService;
    private final ChatMessageRepository chatMessageRepository;

    public ChatMessage save(ChatMessage chatMessage) {
        var chatId = chatRoomService
                .getChatRoomId(chatMessage.getSenderId(), chatMessage.getRecipientId(), true)
                .orElseThrow(); // You can create your own dedicated exception
        chatMessage.setChatId(chatId);
        chatMessageRepository.save(chatMessage);
        return chatMessage;
    }

    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
        return chatRoomService.getChatRoomId(
                senderId,
                recipientId,
                false
        ).map(chatMessageRepository::findByChatId).orElse(new ArrayList<>());
    }



}
