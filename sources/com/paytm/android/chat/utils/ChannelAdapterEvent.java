package com.paytm.android.chat.utils;

import androidx.recyclerview.widget.h;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import java.util.List;
import kotlin.g.b.k;

public final class ChannelAdapterEvent {
    private final h.b diffResult;
    private final List<ChatGroupChannelDataModel> newList;

    public static /* synthetic */ ChannelAdapterEvent copy$default(ChannelAdapterEvent channelAdapterEvent, List<ChatGroupChannelDataModel> list, h.b bVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = channelAdapterEvent.newList;
        }
        if ((i2 & 2) != 0) {
            bVar = channelAdapterEvent.diffResult;
        }
        return channelAdapterEvent.copy(list, bVar);
    }

    public final List<ChatGroupChannelDataModel> component1() {
        return this.newList;
    }

    public final h.b component2() {
        return this.diffResult;
    }

    public final ChannelAdapterEvent copy(List<ChatGroupChannelDataModel> list, h.b bVar) {
        k.c(list, "newList");
        k.c(bVar, "diffResult");
        return new ChannelAdapterEvent(list, bVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelAdapterEvent)) {
            return false;
        }
        ChannelAdapterEvent channelAdapterEvent = (ChannelAdapterEvent) obj;
        return k.a((Object) this.newList, (Object) channelAdapterEvent.newList) && k.a((Object) this.diffResult, (Object) channelAdapterEvent.diffResult);
    }

    public final int hashCode() {
        List<ChatGroupChannelDataModel> list = this.newList;
        int i2 = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        h.b bVar = this.diffResult;
        if (bVar != null) {
            i2 = bVar.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "ChannelAdapterEvent(newList=" + this.newList + ", diffResult=" + this.diffResult + ")";
    }

    public ChannelAdapterEvent(List<ChatGroupChannelDataModel> list, h.b bVar) {
        k.c(list, "newList");
        k.c(bVar, "diffResult");
        this.newList = list;
        this.diffResult = bVar;
    }

    public final h.b getDiffResult() {
        return this.diffResult;
    }

    public final List<ChatGroupChannelDataModel> getNewList() {
        return this.newList;
    }
}
