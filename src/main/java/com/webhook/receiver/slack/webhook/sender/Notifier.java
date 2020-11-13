package com.webhook.receiver.slack.webhook.sender;

import com.webhook.receiver.slack.webhook.vo.WebhookPayload;

public interface Notifier {
    boolean send(WebhookPayload webhookPayload);
}
