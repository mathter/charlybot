package io.githib.mathter.charlybot.persistance;

import io.githib.mathter.charlybot.persistance.entity.MessageEntity;

import java.util.List;

public interface MessageRepository {
    public MessageEntity put(MessageEntity message);

    public List<MessageEntity> find();
}
