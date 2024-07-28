package com.google.android.datatransport.runtime;

import com.google.android.datatransport.b;
import com.google.android.datatransport.c;
import com.google.android.datatransport.e;
import com.google.android.datatransport.f;
import com.google.android.datatransport.h;
import com.google.android.datatransport.runtime.b;

final class n<T> implements f<T> {

    /* renamed from: a  reason: collision with root package name */
    private final l f7794a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7795b;

    /* renamed from: c  reason: collision with root package name */
    private final b f7796c;

    /* renamed from: d  reason: collision with root package name */
    private final e<T, byte[]> f7797d;

    /* renamed from: e  reason: collision with root package name */
    private final p f7798e;

    n(l lVar, String str, b bVar, e<T, byte[]> eVar, p pVar) {
        this.f7794a = lVar;
        this.f7795b = str;
        this.f7796c = bVar;
        this.f7797d = eVar;
        this.f7798e = pVar;
    }

    public final void a(c<T> cVar) {
        a(cVar, o.a());
    }

    public final void a(c<T> cVar, h hVar) {
        this.f7798e.a(new b.a().a(this.f7794a).a((c<?>) cVar).a(this.f7795b).a((e<?, byte[]>) this.f7797d).a(this.f7796c).a(), hVar);
    }
}
