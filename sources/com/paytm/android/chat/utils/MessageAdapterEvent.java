package com.paytm.android.chat.utils;

import androidx.recyclerview.widget.h;
import com.paytm.android.chat.data.models.messages.ChatMessageDataModel;
import java.util.List;
import kotlin.g.b.k;

public final class MessageAdapterEvent {
    private final boolean autoScroll;
    private final h.b diffResult;
    private final boolean isSentByMe;
    private final List<ChatMessageDataModel> newList;

    public static /* synthetic */ MessageAdapterEvent copy$default(MessageAdapterEvent messageAdapterEvent, List<ChatMessageDataModel> list, h.b bVar, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = messageAdapterEvent.newList;
        }
        if ((i2 & 2) != 0) {
            bVar = messageAdapterEvent.diffResult;
        }
        if ((i2 & 4) != 0) {
            z = messageAdapterEvent.isSentByMe;
        }
        if ((i2 & 8) != 0) {
            z2 = messageAdapterEvent.autoScroll;
        }
        return messageAdapterEvent.copy(list, bVar, z, z2);
    }

    public final List<ChatMessageDataModel> component1() {
        return this.newList;
    }

    public final h.b component2() {
        return this.diffResult;
    }

    public final boolean component3() {
        return this.isSentByMe;
    }

    public final boolean component4() {
        return this.autoScroll;
    }

    public final MessageAdapterEvent copy(List<? extends ChatMessageDataModel> list, h.b bVar, boolean z, boolean z2) {
        k.c(list, "newList");
        k.c(bVar, "diffResult");
        return new MessageAdapterEvent(list, bVar, z, z2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageAdapterEvent)) {
            return false;
        }
        MessageAdapterEvent messageAdapterEvent = (MessageAdapterEvent) obj;
        return k.a((Object) this.newList, (Object) messageAdapterEvent.newList) && k.a((Object) this.diffResult, (Object) messageAdapterEvent.diffResult) && this.isSentByMe == messageAdapterEvent.isSentByMe && this.autoScroll == messageAdapterEvent.autoScroll;
    }

    public final int hashCode() {
        List<ChatMessageDataModel> list = this.newList;
        int i2 = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        h.b bVar = this.diffResult;
        if (bVar != null) {
            i2 = bVar.hashCode();
        }
        int i3 = (hashCode + i2) * 31;
        boolean z = this.isSentByMe;
        if (z) {
            z = true;
        }
        int i4 = (i3 + (z ? 1 : 0)) * 31;
        boolean z2 = this.autoScroll;
        if (z2) {
            z2 = true;
        }
        return i4 + (z2 ? 1 : 0);
    }

    public final String toString() {
        return "MessageAdapterEvent(newList=" + this.newList + ", diffResult=" + this.diffResult + ", isSentByMe=" + this.isSentByMe + ", autoScroll=" + this.autoScroll + ")";
    }

    public MessageAdapterEvent(List<? extends ChatMessageDataModel> list, h.b bVar, boolean z, boolean z2) {
        k.c(list, "newList");
        k.c(bVar, "diffResult");
        this.newList = list;
        this.diffResult = bVar;
        this.isSentByMe = z;
        this.autoScroll = z2;
    }

    public final boolean getAutoScroll() {
        return this.autoScroll;
    }

    public final h.b getDiffResult() {
        return this.diffResult;
    }

    public final List<ChatMessageDataModel> getNewList() {
        return this.newList;
    }

    public final boolean isSentByMe() {
        return this.isSentByMe;
    }
}
