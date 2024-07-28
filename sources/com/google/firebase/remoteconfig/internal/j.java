package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.a;
import java.util.Date;

final /* synthetic */ class j implements a {

    /* renamed from: a  reason: collision with root package name */
    private final g f39394a;

    /* renamed from: b  reason: collision with root package name */
    private final Date f39395b;

    j(g gVar, Date date) {
        this.f39394a = gVar;
        this.f39395b = date;
    }

    public final Object a(Task task) {
        return g.a(this.f39394a, this.f39395b, task);
    }
}
