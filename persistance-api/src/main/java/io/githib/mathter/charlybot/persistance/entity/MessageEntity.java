package io.githib.mathter.charlybot.persistance.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "c_messages")
@Access(AccessType.FIELD)
@NamedQuery(name = "Message_genAll", query = "select o from MessageEntity o")
public class MessageEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "MessageEntityIdGenerator")
    @GenericGenerator(name = "MessageEntityIdGenerator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private Instant date;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity message = (MessageEntity) o;
        return Objects.equals(id, message.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
