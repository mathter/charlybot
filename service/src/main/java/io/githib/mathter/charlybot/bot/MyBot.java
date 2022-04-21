package io.githib.mathter.charlybot.bot;

import io.githib.mathter.charlybot.persistance.MessageRepository;
import io.githib.mathter.charlybot.persistance.entity.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.Instant;

@Service
public class MyBot extends TelegramLongPollingBot {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public String getBotToken() {
        return "5146812526:AAGfOuqiDDAGfUSSQy0aukctG07SJgRtr_k";
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update);

        Message message = update.getMessage();

        SendMessage answer = new SendMessage();
        answer.setChatId(String.valueOf(message.getChatId()));
        answer.setText("Hello");

        try {
            this.execute(answer);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        try {
            this.save(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void save(Message message) {
        final MessageEntity entity = new MessageEntity();

        entity.setUserName(message.getChat().getUserName());
        entity.setText(message.getText());
        entity.setDate(Instant.ofEpochMilli(message.getDate()));

        this.messageRepository.put(entity);
    }

    @Override
    public String getBotUsername() {
        return null;
    }
}
