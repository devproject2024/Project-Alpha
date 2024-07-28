package com.paytm.android.chat.data.models.messages;

public final class ChatUPIResponseDataModel extends ChatMessageDataModel {
    private ChatMessageUPIData data;

    public final ChatMessageUPIData getData() {
        return this.data;
    }

    public final void setData(ChatMessageUPIData chatMessageUPIData) {
        this.data = chatMessageUPIData;
    }
}
