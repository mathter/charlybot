package io.githib.mathter.charlybot.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.generics.BotOptions;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class BotConfiguration {
    @Bean
    public BotSession botSession(
            @Autowired LongPollingBot bot,
            @Autowired BotOptions botOptions
    ) {
        final DefaultBotSession session = new DefaultBotSession();

        session.setCallback(bot);
        session.setToken(bot.getBotToken());
        session.setOptions(botOptions);
        session.start();

        return session;
    }

    @Bean
    public BotOptions botOptions() {
        return new DefaultBotOptions();
    }
}
