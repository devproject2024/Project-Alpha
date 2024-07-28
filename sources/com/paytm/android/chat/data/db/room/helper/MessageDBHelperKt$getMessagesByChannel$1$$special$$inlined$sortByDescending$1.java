package com.paytm.android.chat.data.db.room.helper;

import com.paytm.android.chat.data.models.messages.ChatMessageDataModel;
import java.util.Comparator;
import kotlin.b.a;

public final class MessageDBHelperKt$getMessagesByChannel$1$$special$$inlined$sortByDescending$1<T> implements Comparator<T> {
    public final int compare(T t, T t2) {
        return a.a(Long.valueOf(((ChatMessageDataModel) t2).time), Long.valueOf(((ChatMessageDataModel) t).time));
    }
}
