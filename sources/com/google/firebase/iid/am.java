package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.a;

final /* synthetic */ class am implements a {

    /* renamed from: a  reason: collision with root package name */
    private final ak f38816a;

    /* renamed from: b  reason: collision with root package name */
    private final Bundle f38817b;

    am(ak akVar, Bundle bundle) {
        this.f38816a = akVar;
        this.f38817b = bundle;
    }

    public final Object a(Task task) {
        ak akVar = this.f38816a;
        Bundle bundle = this.f38817b;
        if (task.b() && ak.b((Bundle) task.d())) {
            return akVar.c(bundle).a(g.a(), ap.f38822a);
        }
        return task;
    }
}
