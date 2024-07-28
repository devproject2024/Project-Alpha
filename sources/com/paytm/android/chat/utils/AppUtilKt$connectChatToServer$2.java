package com.paytm.android.chat.utils;

import com.imsdk.IMManager;
import com.imsdk.LoginInfo;
import kotlin.g.a.b;
import kotlin.g.a.m;

public final class AppUtilKt$connectChatToServer$2 implements IMManager.ConnectCallback {
    final /* synthetic */ m $failure;
    final /* synthetic */ b $success;

    AppUtilKt$connectChatToServer$2(m mVar, b bVar) {
        this.$failure = mVar;
        this.$success = bVar;
    }

    public final void onFailed(int i2, String str) {
        m mVar = this.$failure;
        if (mVar != null) {
            mVar.invoke(Integer.valueOf(i2), str);
        }
    }

    public final void onConnected(LoginInfo loginInfo) {
        b bVar = this.$success;
        if (bVar != null) {
            bVar.invoke(loginInfo);
        }
    }
}
