package com.paytm.android.chat.bean;

import com.paytm.android.chat.network.response.HomeChips;
import java.util.List;
import kotlin.g.b.k;

public final class ChatHomeChip {
    private final List<HomeChips> list;

    public static /* synthetic */ ChatHomeChip copy$default(ChatHomeChip chatHomeChip, List<HomeChips> list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list2 = chatHomeChip.list;
        }
        return chatHomeChip.copy(list2);
    }

    public final List<HomeChips> component1() {
        return this.list;
    }

    public final ChatHomeChip copy(List<HomeChips> list2) {
        k.c(list2, "list");
        return new ChatHomeChip(list2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ChatHomeChip) && k.a((Object) this.list, (Object) ((ChatHomeChip) obj).list);
        }
        return true;
    }

    public final int hashCode() {
        List<HomeChips> list2 = this.list;
        if (list2 != null) {
            return list2.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "ChatHomeChip(list=" + this.list + ")";
    }

    public ChatHomeChip(List<HomeChips> list2) {
        k.c(list2, "list");
        this.list = list2;
    }

    public final List<HomeChips> getList() {
        return this.list;
    }
}
