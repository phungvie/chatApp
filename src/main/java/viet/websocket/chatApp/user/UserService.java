package viet.websocket.chatApp.user;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserService {
    final UserRepository userRepository;

    public User saveUser(User user) {
        user.setStatus(Status.ONLINE);
        return userRepository.save(user);
    }
    public void disconnect(User user) {
       var storedUser = userRepository.findByNickname(user.getNickname()).orElse(null);
       if(storedUser != null) {
              storedUser.setStatus(Status.OFFLINE);
              userRepository.save(storedUser);
       }
    }

    public List<User> findConnectedUsers() {
        return userRepository.findAllByStatus(Status.ONLINE);
    }


}
