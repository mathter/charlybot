package io.githib.mathter.charlybot.persistance;

import io.githib.mathter.charlybot.persistance.entity.MessageEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.List;

@SpringBootTest(classes = TestPersistanceConfiguration.class)
public class MessageRepositoryTest {
    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void test() {
        final MessageEntity message = new MessageEntity();
        message.setDate(Instant.now());
        message.setUserName("user_name");
        message.setText("This is sample text");

        this.messageRepository.put(message);

        final List<MessageEntity> entities = this.messageRepository.find();
        Assertions.assertNotNull(entities);
        Assertions.assertEquals(1, entities.size());
    }
}
