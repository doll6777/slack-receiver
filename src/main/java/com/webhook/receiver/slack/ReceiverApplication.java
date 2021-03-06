package com.webhook.receiver.slack;

import com.webhook.receiver.slack.exception.PropertyNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ReceiverApplication {
    
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ReceiverApplication.class, args);
        String incomingWebhookUrl = ctx.getEnvironment().getProperty("slack.incoming.webhook.url");
        
        if (incomingWebhookUrl == null || incomingWebhookUrl.isEmpty()) {
            throw new PropertyNotFoundException("slack incoming webhook url is empty in application.properties");
        }
    }
}
