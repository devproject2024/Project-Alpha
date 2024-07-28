package com.business.merchant_payments.notificationsettings.activity;

import android.content.Context;
import android.view.View;
import com.business.common_module.utilities.c;
import kotlin.g.b.k;

public final class MpNotificationsActivity$highlightParticularSection$1 implements Runnable {
    public final /* synthetic */ MpNotificationsActivity this$0;

    public MpNotificationsActivity$highlightParticularSection$1(MpNotificationsActivity mpNotificationsActivity) {
        this.this$0 = mpNotificationsActivity;
    }

    public final void run() {
        c.a aVar = c.f7365a;
        View access$getMViewToBeHighLighted$p = this.this$0.mViewToBeHighLighted;
        k.a((Object) access$getMViewToBeHighLighted$p);
        c.a.a(access$getMViewToBeHighLighted$p, (Context) this.this$0);
        this.this$0.mToBeHighlightedSection = "";
    }
}
