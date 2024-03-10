package com.giambo.ch.myawesomebot;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.BotOptions;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.telegram.telegrambots.util.WebhookUtils;

@Component
public class MyAwesomeBot implements LongPollingBot {

    private static final Logger logger = LoggerFactory.getLogger(MyAwesomeBot.class.getName());
    private final MyDefaultAbsSender myDefaultAbsSender;
    private final MyBotConfig myBotConfig;

    public MyAwesomeBot(MyDefaultAbsSender myDefaultAbsSender, MyBotConfig myBotConfig) {
        this.myDefaultAbsSender = myDefaultAbsSender;
        this.myBotConfig = myBotConfig;
    }

    @PostConstruct
    public void postConstruct() throws TelegramApiException {
        new TelegramBotsApi(DefaultBotSession.class).registerBot(this);
    }

    @Override
    public void onUpdateReceived(Update update) {
        logger.info("Received update: {}", update);
    }

    @Override
    public BotOptions getOptions() {
        return myDefaultAbsSender.getOptions();
    }

    @Override
    public void clearWebhook() throws TelegramApiRequestException {
        WebhookUtils.clearWebhook(myDefaultAbsSender);
    }

    @Override
    public String getBotUsername() {
        return myBotConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return myBotConfig.getBotToken();
    }
}
