package com.paytm.android.chat.utils;

import android.text.TextUtils;
import androidx.recyclerview.widget.h;
import com.paytm.android.chat.data.models.messages.ChatMessageDataModel;
import com.paytm.utility.q;
import com.sendbird.android.BaseMessage;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.y;

public final class MessageDiffUtil extends h.a {
    private final List<ChatMessageDataModel> newList;
    private final List<ChatMessageDataModel> oldList;

    public MessageDiffUtil(List<? extends ChatMessageDataModel> list, List<? extends ChatMessageDataModel> list2) {
        k.c(list, "oldList");
        k.c(list2, "newList");
        this.oldList = list;
        this.newList = list2;
    }

    public final boolean areItemsTheSame(int i2, int i3) {
        ChatMessageDataModel chatMessageDataModel = this.oldList.get(i2);
        ChatMessageDataModel chatMessageDataModel2 = this.newList.get(i3);
        if (chatMessageDataModel.messageId != 0 && chatMessageDataModel2.messageId != 0 && chatMessageDataModel.messageId == chatMessageDataModel2.messageId) {
            return true;
        }
        if (TextUtils.isEmpty(chatMessageDataModel.requestId) || TextUtils.isEmpty(chatMessageDataModel2.requestId) || !chatMessageDataModel.requestId.equals(chatMessageDataModel2.requestId)) {
            return false;
        }
        return true;
    }

    public final boolean areContentsTheSame(int i2, int i3) {
        ChatMessageDataModel chatMessageDataModel = this.oldList.get(i2);
        ChatMessageDataModel chatMessageDataModel2 = this.newList.get(i3);
        if (k.a((Object) y.b(chatMessageDataModel.baseMessage.getClass()), (Object) y.b(chatMessageDataModel2.baseMessage.getClass()))) {
            String str = chatMessageDataModel.customType;
            if (str == null) {
                str = "";
            }
            if (str.equals(chatMessageDataModel2.customType) && chatMessageDataModel.state == chatMessageDataModel2.state && chatMessageDataModel.showAnim == chatMessageDataModel2.showAnim && chatMessageDataModel.showQuickReply == chatMessageDataModel2.showQuickReply) {
                BaseMessage baseMessage = chatMessageDataModel.baseMessage;
                k.a((Object) baseMessage, "oldItem.baseMessage");
                long createdAt = baseMessage.getCreatedAt();
                BaseMessage baseMessage2 = chatMessageDataModel2.baseMessage;
                k.a((Object) baseMessage2, "newItem.baseMessage");
                if (createdAt == baseMessage2.getCreatedAt()) {
                    BaseMessage baseMessage3 = chatMessageDataModel.baseMessage;
                    k.a((Object) baseMessage3, "oldItem.baseMessage");
                    long updatedAt = baseMessage3.getUpdatedAt();
                    BaseMessage baseMessage4 = chatMessageDataModel2.baseMessage;
                    k.a((Object) baseMessage4, "newItem.baseMessage");
                    if (updatedAt == baseMessage4.getUpdatedAt() && !(!k.a((Object) chatMessageDataModel.showStore, (Object) chatMessageDataModel2.showStore))) {
                        BaseMessage baseMessage5 = chatMessageDataModel.baseMessage;
                        k.a((Object) baseMessage5, "oldItem.baseMessage");
                        String data = baseMessage5.getData();
                        if (data == null) {
                            data = "";
                        }
                        BaseMessage baseMessage6 = chatMessageDataModel2.baseMessage;
                        k.a((Object) baseMessage6, "newItem.baseMessage");
                        if (data.equals(baseMessage6.getData())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int getOldListSize() {
        return this.oldList.size();
    }

    public final int getNewListSize() {
        return this.newList.size();
    }

    public final boolean areListSame() {
        if (getOldListSize() != getNewListSize()) {
            return false;
        }
        int oldListSize = getOldListSize();
        for (int i2 = 0; i2 < oldListSize; i2++) {
            if (!areItemsTheSame(i2, i2) || !areContentsTheSame(i2, i2)) {
                q.b("oldItem " + i2 + 10 + this.oldList.get(i2));
                q.b("newItem " + i2 + 10 + this.newList.get(i2));
                return false;
            }
        }
        return true;
    }
}
