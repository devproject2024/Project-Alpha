package com.google.firebase.iid;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.c;
import java.util.concurrent.ScheduledFuture;

final /* synthetic */ class ao implements c {

    /* renamed from: a  reason: collision with root package name */
    private final ak f38819a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38820b;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledFuture f38821c;

    ao(ak akVar, String str, ScheduledFuture scheduledFuture) {
        this.f38819a = akVar;
        this.f38820b = str;
        this.f38821c = scheduledFuture;
    }

    public final void a(Task task) {
        ak akVar = this.f38819a;
        String str = this.f38820b;
        ScheduledFuture scheduledFuture = this.f38821c;
        synchronized (akVar.f38807a) {
            akVar.f38807a.remove(str);
        }
        scheduledFuture.cancel(false);
    }
}
