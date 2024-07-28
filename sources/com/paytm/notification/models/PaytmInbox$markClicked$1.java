package com.paytm.notification.models;

import com.paytm.notification.c;
import com.paytm.notification.models.callback.InboxHandlerReadyCallback;
import kotlin.g.b.k;

public final class PaytmInbox$markClicked$1 implements InboxHandlerReadyCallback {
    final /* synthetic */ PaytmInbox this$0;

    PaytmInbox$markClicked$1(PaytmInbox paytmInbox) {
        this.this$0 = paytmInbox;
    }

    public final void onCallbackReady(c cVar) {
        k.c(cVar, "inboxHandler");
        cVar.a(this.this$0);
    }
}
