package com.paytm.android.chat.utils;

import com.sendbird.android.BaseMessage;
import java.util.ArrayList;
import java.util.List;

public class MessageSendingManager {
    private List<BaseMessage> sendingMessages;

    static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static MessageSendingManager f42352a = new MessageSendingManager();
    }

    private MessageSendingManager() {
        this.sendingMessages = new ArrayList();
    }

    public static MessageSendingManager getInstance() {
        return a.f42352a;
    }

    public void addSendingMessage(BaseMessage baseMessage) {
        if (this.sendingMessages == null) {
            this.sendingMessages = new ArrayList();
        }
        if (!this.sendingMessages.contains(baseMessage)) {
            this.sendingMessages.add(baseMessage);
        }
    }

    public void removeSendingMessage(BaseMessage baseMessage) {
        if (this.sendingMessages == null) {
            this.sendingMessages = new ArrayList();
        }
        this.sendingMessages.remove(baseMessage);
    }

    public boolean isHaveMessage(BaseMessage baseMessage) {
        if (this.sendingMessages == null) {
            this.sendingMessages = new ArrayList();
        }
        return this.sendingMessages.contains(baseMessage);
    }
}
