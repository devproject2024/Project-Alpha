package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.play.core.common.a;

final class g implements a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f36900a;

    g(Activity activity) {
        this.f36900a = activity;
    }

    public final void a(IntentSender intentSender, int i2) throws IntentSender.SendIntentException {
        this.f36900a.startIntentSenderForResult(intentSender, i2, (Intent) null, 0, 0, 0, (Bundle) null);
    }
}
