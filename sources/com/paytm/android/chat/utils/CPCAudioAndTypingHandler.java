package com.paytm.android.chat.utils;

import android.os.Handler;
import android.os.Message;
import com.paytm.android.chat.a.f;
import com.paytm.android.chat.activity.APCChatActivity;
import com.paytm.android.chat.services.MediaPlayerService;
import com.paytm.utility.q;
import java.lang.ref.WeakReference;
import kotlin.g.b.k;

public final class CPCAudioAndTypingHandler extends Handler {
    private WeakReference<APCChatActivity> weakReference;

    public CPCAudioAndTypingHandler(WeakReference<APCChatActivity> weakReference2) {
        k.c(weakReference2, "weakReference");
        this.weakReference = weakReference2;
    }

    public final WeakReference<APCChatActivity> getWeakReference() {
        return this.weakReference;
    }

    public final void setWeakReference(WeakReference<APCChatActivity> weakReference2) {
        k.c(weakReference2, "<set-?>");
        this.weakReference = weakReference2;
    }

    public final void handleMessage(Message message) {
        f fVar;
        k.c(message, "msg");
        super.handleMessage(message);
        APCChatActivity aPCChatActivity = (APCChatActivity) this.weakReference.get();
        if (aPCChatActivity != null) {
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 == 2) {
                    q.a("HANDLER_TypingStatus");
                    aPCChatActivity.c().a(true);
                }
            } else if (aPCChatActivity.f41477e != null) {
                MediaPlayerService mediaPlayerService = aPCChatActivity.f41477e;
                Integer num = null;
                Integer valueOf = mediaPlayerService != null ? Integer.valueOf(mediaPlayerService.c()) : null;
                MediaPlayerService mediaPlayerService2 = aPCChatActivity.f41477e;
                if (mediaPlayerService2 != null) {
                    num = Integer.valueOf(mediaPlayerService2.d());
                }
                if (!(num == null || valueOf == null || (fVar = aPCChatActivity.f41475c) == null)) {
                    fVar.a(valueOf.intValue(), num.intValue());
                }
                aPCChatActivity.f41476d.sendEmptyMessageDelayed(1, 100);
                MediaPlayerService mediaPlayerService3 = aPCChatActivity.f41477e;
                if (mediaPlayerService3 != null) {
                    boolean e2 = mediaPlayerService3.e();
                    f fVar2 = aPCChatActivity.f41475c;
                    if (fVar2 != null) {
                        fVar2.b(e2);
                    }
                }
            }
        }
    }
}
