package com.google.android.play.core.splitcompat;

import android.content.Context;
import com.google.android.play.core.d.i;

final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f37521a;

    o(Context context) {
        this.f37521a = context;
    }

    public final void run() {
        i.a(this.f37521a).a(true);
    }
}
