package com.paytm.android.chat.data.providers;

import com.paytm.android.chat.bean.ChannelMetaData;
import com.paytm.android.chat.bean.ReceiverDisplayInfo;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.data.models.messages.ChatMessageDataModel;
import com.paytm.android.chat.data.models.messages.MPCMessagePreview;
import com.paytm.android.chat.data.models.messages.MPCPreviewDrawable;
import com.paytm.android.chat.data.models.users.ChatUserDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CPCDataProviderKt {
    private static final String EMPTY_FAKE_ENTRY = "FAKE_ENTRY";

    public static final String getEMPTY_FAKE_ENTRY() {
        return EMPTY_FAKE_ENTRY;
    }

    public static final ChatGroupChannelDataModel provideOfflineFakeChannel(List<ChatUserDataModel> list) {
        k.c(list, "chatUserDataModels");
        MPCMessagePreview mPCMessagePreview = r2;
        MPCMessagePreview mPCMessagePreview2 = new MPCMessagePreview("", MPCPreviewDrawable.NONE);
        String str = EMPTY_FAKE_ENTRY;
        ReceiverDisplayInfo receiverDisplayInfo = r4;
        ReceiverDisplayInfo receiverDisplayInfo2 = new ReceiverDisplayInfo();
        return new ChatGroupChannelDataModel(true, str, receiverDisplayInfo, false, (ChatMessageDataModel) null, mPCMessagePreview, (String) null, list, (Long) null, (String) null, list.size(), 0, 0, 0, (String) null, EMPTY_FAKE_ENTRY, false, (String) null, 0L, EMPTY_FAKE_ENTRY, false, false, false, false, false, (ChannelMetaData) null, list.size(), true, false, true, (String) null, 1073741824, (g) null);
    }
}
