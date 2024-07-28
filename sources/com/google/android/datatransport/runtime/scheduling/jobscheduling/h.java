package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.e;
import com.google.android.datatransport.runtime.c.b;
import com.google.android.datatransport.runtime.d.a;
import com.google.android.datatransport.runtime.l;
import com.google.android.datatransport.runtime.scheduling.a.c;
import java.util.concurrent.Executor;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    final Context f7917a;

    /* renamed from: b  reason: collision with root package name */
    final e f7918b;

    /* renamed from: c  reason: collision with root package name */
    final c f7919c;

    /* renamed from: d  reason: collision with root package name */
    final s f7920d;

    /* renamed from: e  reason: collision with root package name */
    final b f7921e;

    /* renamed from: f  reason: collision with root package name */
    final a f7922f;

    /* renamed from: g  reason: collision with root package name */
    private final Executor f7923g;

    public h(Context context, e eVar, c cVar, s sVar, Executor executor, b bVar, a aVar) {
        this.f7917a = context;
        this.f7918b = eVar;
        this.f7919c = cVar;
        this.f7920d = sVar;
        this.f7923g = executor;
        this.f7921e = bVar;
        this.f7922f = aVar;
    }

    public final void a(l lVar, int i2, Runnable runnable) {
        this.f7923g.execute(i.a(this, lVar, i2, runnable));
    }
}
