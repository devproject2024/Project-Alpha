package com.google.android.play.core.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class b extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f37330a;

    /* synthetic */ b(c cVar) {
        this.f37330a = cVar;
    }

    public final void onReceive(Context context, Intent intent) {
        this.f37330a.a(context, intent);
    }
}
