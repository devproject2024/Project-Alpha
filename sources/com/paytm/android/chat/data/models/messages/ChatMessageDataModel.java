package com.paytm.android.chat.data.models.messages;

import android.text.TextUtils;
import com.paytm.android.chat.utils.ChatMessageState;
import com.sendbird.android.BaseMessage;
import java.util.Objects;

public class ChatMessageDataModel implements Comparable<ChatMessageDataModel> {
    public BaseMessage baseMessage;
    public String campaignId;
    public Long createdAt;
    public String customType;
    public String fileName;
    public String fileType;
    public String fileUrl;
    public boolean isForward;
    public String message;
    public long messageId;
    public ChatMessageState messageState;
    public String messageType;
    public String previewText;
    public boolean readEngageEventSent = false;
    public String requestId;
    public String sendId;
    public boolean showAnim;
    public boolean showQuickReply = false;
    public Boolean showStore;
    public RequestState state;
    public long time;
    public Long updatedAt;

    public enum RequestState {
        NONE,
        PENDING,
        FAILED,
        SUCCEEDED
    }

    public int compareTo(ChatMessageDataModel chatMessageDataModel) {
        return (int) (this.time - chatMessageDataModel.time);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatMessageDataModel)) {
            return false;
        }
        return isEquals((ChatMessageDataModel) obj);
    }

    private boolean isEquals(ChatMessageDataModel chatMessageDataModel) {
        if (!TextUtils.isEmpty(this.requestId) && !TextUtils.isEmpty(chatMessageDataModel.requestId) && this.requestId.equals(chatMessageDataModel.requestId)) {
            return true;
        }
        if (this.messageId == chatMessageDataModel.messageId && this.time == chatMessageDataModel.time) {
            return this.customType.equals(chatMessageDataModel.customType);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.sendId, this.requestId});
    }
}
