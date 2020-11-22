package com.webhook.receiver.slack.sender;

import com.webhook.receiver.slack.vo.WebhookPayload;

public interface Notifier {
    boolean send(WebhookPayload webhookPayload);
}
