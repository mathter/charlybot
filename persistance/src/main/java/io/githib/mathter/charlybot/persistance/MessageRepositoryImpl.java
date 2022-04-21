package io.githib.mathter.charlybot.persistance;

import io.githib.mathter.charlybot.persistance.entity.MessageEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class MessageRepositoryImpl implements MessageRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public MessageEntity put(MessageEntity message) {
        return this.em.merge(message);
    }

    @Override
    public List<MessageEntity> find() {
        final TypedQuery<MessageEntity> typedQuery = this.em.createNamedQuery("Message_genAll", MessageEntity.class);

        return typedQuery.getResultList();
    }
}
