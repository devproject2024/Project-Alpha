package com.paytm.android.chat.utils;

import com.paytm.android.chat.d.a.a;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.MessageListParams;
import java.util.List;
import kotlin.g.b.k;

public final class CPCMessageUtilsKt {
    public static final void fetchMessagesFromProvider(ChatGroupChannelDataModel chatGroupChannelDataModel, long j, MessageListParams messageListParams, BaseChannel.GetMessagesHandler getMessagesHandler) {
        k.c(chatGroupChannelDataModel, "channel");
        k.c(messageListParams, "fetchParams");
        k.c(getMessagesHandler, "messageHandler");
        a aVar = a.f41891a;
        GroupChannel a2 = a.a(chatGroupChannelDataModel.getChannelUrl());
        if (a2 != null) {
            a2.getMessagesByTimestamp(j, messageListParams, getMessagesHandler);
        }
    }

    public static final void fetchLatestMessagesFromProvider(ChatGroupChannelDataModel chatGroupChannelDataModel, BaseChannel.GetMessagesHandler getMessagesHandler) {
        BaseChannel.GetMessagesHandler getMessagesHandler2 = getMessagesHandler;
        k.c(chatGroupChannelDataModel, "channel");
        k.c(getMessagesHandler2, "handler");
        long currentTimeMillis = System.currentTimeMillis();
        MessageListParams messageListParams = new MessageListParams(30, 40, BaseChannel.MessageTypeFilter.ALL, (String) null, (List<String>) null, true, true, false, false, false, false, false);
        a aVar = a.f41891a;
        GroupChannel a2 = a.a(chatGroupChannelDataModel.getChannelUrl());
        if (a2 != null) {
            a2.getMessagesByTimestamp(currentTimeMillis, messageListParams, getMessagesHandler2);
        }
    }
}
