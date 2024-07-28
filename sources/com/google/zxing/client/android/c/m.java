package com.google.zxing.client.android.c;

import com.google.zxing.client.a.aj;
import com.google.zxing.client.a.q;
import com.google.zxing.client.android.CaptureActivity;

public final class m extends g {

    /* renamed from: i  reason: collision with root package name */
    private static final String f40188i = m.class.getSimpleName();
    private final CaptureActivity j;

    public m(CaptureActivity captureActivity, q qVar) {
        super(captureActivity, qVar);
        this.j = captureActivity;
    }

    public final CharSequence a() {
        aj ajVar = (aj) this.f40181g;
        return ajVar.f40023a + " (" + ajVar.f40024b + ')';
    }
}
