package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.e;

final /* synthetic */ class c implements e {

    /* renamed from: a  reason: collision with root package name */
    private final a f39362a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f39363b;

    /* renamed from: c  reason: collision with root package name */
    private final f f39364c;

    private c(a aVar, boolean z, f fVar) {
        this.f39362a = aVar;
        this.f39363b = z;
        this.f39364c = fVar;
    }

    public static e a(a aVar, boolean z, f fVar) {
        return new c(aVar, z, fVar);
    }

    public final Task a(Object obj) {
        return a.a(this.f39362a, this.f39363b, this.f39364c);
    }
}
