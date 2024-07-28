package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.h;
import com.google.android.datatransport.runtime.l;

final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f7879a;

    /* renamed from: b  reason: collision with root package name */
    private final l f7880b;

    /* renamed from: c  reason: collision with root package name */
    private final h f7881c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.h f7882d;

    private b(a aVar, l lVar, h hVar, com.google.android.datatransport.runtime.h hVar2) {
        this.f7879a = aVar;
        this.f7880b = lVar;
        this.f7881c = hVar;
        this.f7882d = hVar2;
    }

    public static Runnable a(a aVar, l lVar, h hVar, com.google.android.datatransport.runtime.h hVar2) {
        return new b(aVar, lVar, hVar, hVar2);
    }

    public final void run() {
        a.a(this.f7879a, this.f7880b, this.f7881c, this.f7882d);
    }
}
