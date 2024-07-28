package com.google.firebase.iid;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.h;
import com.google.firebase.iid.ar;

final /* synthetic */ class j implements a {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseInstanceId f38867a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38868b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38869c;

    j(FirebaseInstanceId firebaseInstanceId, String str, String str2) {
        this.f38867a = firebaseInstanceId;
        this.f38868b = str;
        this.f38869c = str2;
    }

    public final Object a(Task task) {
        FirebaseInstanceId firebaseInstanceId = this.f38867a;
        String str = this.f38868b;
        String str2 = this.f38869c;
        String e2 = firebaseInstanceId.e();
        ar.a b2 = firebaseInstanceId.b(str, str2);
        if (!firebaseInstanceId.a(b2)) {
            return h.a(new x(e2, b2.f38832a));
        }
        return firebaseInstanceId.f38777g.a(str, str2, new m(firebaseInstanceId, e2, str, str2));
    }
}
