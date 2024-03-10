package com.giambo.ch.myawesomebot;

import org.springframework.stereotype.Component;

@Component
public class MyBotConfig {

    public String getBotName() {
        return "MyAwesomeBot";
    }

    public String getBotToken() {
        return "HERE YOUR BOT TOKEN";
    }
}
