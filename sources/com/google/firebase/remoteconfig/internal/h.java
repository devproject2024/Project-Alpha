package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.a;

final /* synthetic */ class h implements a {

    /* renamed from: a  reason: collision with root package name */
    private final g f39388a;

    /* renamed from: b  reason: collision with root package name */
    private final long f39389b;

    private h(g gVar, long j) {
        this.f39388a = gVar;
        this.f39389b = j;
    }

    public static a a(g gVar, long j) {
        return new h(gVar, j);
    }

    public final Object a(Task task) {
        return g.a(this.f39388a, this.f39389b, task);
    }
}
