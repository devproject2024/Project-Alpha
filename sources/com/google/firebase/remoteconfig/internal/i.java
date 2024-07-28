package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.a;
import java.util.Date;

final /* synthetic */ class i implements a {

    /* renamed from: a  reason: collision with root package name */
    private final g f39390a;

    /* renamed from: b  reason: collision with root package name */
    private final Task f39391b;

    /* renamed from: c  reason: collision with root package name */
    private final Task f39392c;

    /* renamed from: d  reason: collision with root package name */
    private final Date f39393d;

    i(g gVar, Task task, Task task2, Date date) {
        this.f39390a = gVar;
        this.f39391b = task;
        this.f39392c = task2;
        this.f39393d = date;
    }

    public final Object a(Task task) {
        return g.a(this.f39390a, this.f39391b, this.f39392c, this.f39393d);
    }
}
