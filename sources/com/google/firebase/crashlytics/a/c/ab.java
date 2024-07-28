package com.google.firebase.crashlytics.a.c;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.a;
import com.google.firebase.crashlytics.a.b;

final /* synthetic */ class ab implements a {

    /* renamed from: a  reason: collision with root package name */
    private final aa f38159a;

    private ab(aa aaVar) {
        this.f38159a = aaVar;
    }

    public static a a(aa aaVar) {
        return new ab(aaVar);
    }

    public final Object a(Task task) {
        boolean z;
        aa aaVar = this.f38159a;
        if (task.b()) {
            o oVar = (o) task.d();
            b a2 = b.a();
            new StringBuilder("Crashlytics report successfully enqueued to DataTransport: ").append(oVar.b());
            a2.a(3);
            aaVar.f38154b.a(oVar.b());
            z = true;
        } else {
            b.a().a(3);
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
