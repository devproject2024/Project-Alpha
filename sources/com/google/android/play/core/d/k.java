package com.google.android.play.core.d;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import com.google.android.play.core.common.a;

final class k implements a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f37428a;

    k(Activity activity) {
        this.f37428a = activity;
    }

    public final void a(IntentSender intentSender, int i2) throws IntentSender.SendIntentException {
        this.f37428a.startIntentSenderForResult(intentSender, i2, (Intent) null, 0, 0, 0);
    }
}
