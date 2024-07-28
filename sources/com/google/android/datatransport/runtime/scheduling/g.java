package com.google.android.datatransport.runtime.scheduling;

import android.content.Context;
import android.os.Build;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.e;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import dagger.a.c;
import javax.a.a;

public final class g implements c<s> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f7892a;

    /* renamed from: b  reason: collision with root package name */
    private final a<com.google.android.datatransport.runtime.scheduling.a.c> f7893b;

    /* renamed from: c  reason: collision with root package name */
    private final a<com.google.android.datatransport.runtime.scheduling.jobscheduling.g> f7894c;

    /* renamed from: d  reason: collision with root package name */
    private final a<com.google.android.datatransport.runtime.d.a> f7895d;

    public g(a<Context> aVar, a<com.google.android.datatransport.runtime.scheduling.a.c> aVar2, a<com.google.android.datatransport.runtime.scheduling.jobscheduling.g> aVar3, a<com.google.android.datatransport.runtime.d.a> aVar4) {
        this.f7892a = aVar;
        this.f7893b = aVar2;
        this.f7894c = aVar3;
        this.f7895d = aVar4;
    }

    public final /* synthetic */ Object get() {
        Object obj;
        Context context = this.f7892a.get();
        com.google.android.datatransport.runtime.scheduling.a.c cVar = this.f7893b.get();
        com.google.android.datatransport.runtime.scheduling.jobscheduling.g gVar = this.f7894c.get();
        com.google.android.datatransport.runtime.d.a aVar = this.f7895d.get();
        if (Build.VERSION.SDK_INT >= 21) {
            obj = new e(context, cVar, gVar);
        } else {
            obj = new com.google.android.datatransport.runtime.scheduling.jobscheduling.a(context, cVar, aVar, gVar);
        }
        return (s) dagger.a.g.a(obj, "Cannot return null from a non-@Nullable @Provides method");
    }
}
