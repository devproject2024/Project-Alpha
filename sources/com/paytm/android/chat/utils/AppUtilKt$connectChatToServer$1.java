package com.paytm.android.chat.utils;

import android.app.Activity;
import android.content.Context;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.e;
import com.paytm.network.model.NetworkCustomError;

public final class AppUtilKt$connectChatToServer$1 implements ChatManager.c {
    final /* synthetic */ Context $context;

    public final void onSuccess() {
    }

    AppUtilKt$connectChatToServer$1(Context context) {
        this.$context = context;
    }

    public final void onFailed(int i2, String str) {
        if (!(this.$context instanceof Activity)) {
            return;
        }
        if (i2 == 410 || i2 == 401 || i2 == 403) {
            new NetworkCustomError();
            e.a().a((Activity) this.$context, (String) null, false, true);
        }
    }
}
