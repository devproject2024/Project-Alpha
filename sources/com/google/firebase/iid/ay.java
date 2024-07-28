package com.google.firebase.iid;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.c;
import java.util.concurrent.ScheduledFuture;

final /* synthetic */ class ay implements c {

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledFuture f38853a;

    ay(ScheduledFuture scheduledFuture) {
        this.f38853a = scheduledFuture;
    }

    public final void a(Task task) {
        this.f38853a.cancel(false);
    }
}
