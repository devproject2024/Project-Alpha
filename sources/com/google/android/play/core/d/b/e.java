package com.google.android.play.core.d.b;

import java.util.List;

final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f37384a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ List f37385b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ a f37386c;

    e(a aVar, List list, List list2) {
        this.f37386c = aVar;
        this.f37384a = list;
        this.f37385b = list2;
    }

    public final void run() {
        a.a(this.f37386c, this.f37384a, this.f37385b);
    }
}
