package viet.websocket.chatApp.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByStatus(Status status);

     Optional<User> findByNickname(String nickname);

    List<User> findAllByStatus(Status status);
}
