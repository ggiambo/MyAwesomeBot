package com.giambo.ch.myawesomebot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;

@Component
public class MyDefaultAbsSender extends DefaultAbsSender {

    protected MyDefaultAbsSender(MyBotConfig myBotConfig) {
        super(new DefaultBotOptions(), myBotConfig.getBotToken());
    }
}
