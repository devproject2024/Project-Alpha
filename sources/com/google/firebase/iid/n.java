package com.google.firebase.iid;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.h;

final /* synthetic */ class n implements e {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseInstanceId f38876a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38877b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38878c;

    /* renamed from: d  reason: collision with root package name */
    private final String f38879d;

    n(FirebaseInstanceId firebaseInstanceId, String str, String str2, String str3) {
        this.f38876a = firebaseInstanceId;
        this.f38877b = str;
        this.f38878c = str2;
        this.f38879d = str3;
    }

    public final Task a(Object obj) {
        FirebaseInstanceId firebaseInstanceId = this.f38876a;
        String str = this.f38877b;
        String str2 = this.f38878c;
        String str3 = this.f38879d;
        String str4 = (String) obj;
        FirebaseInstanceId.f38770a.a(firebaseInstanceId.k(), str, str2, str4, firebaseInstanceId.f38775e.c());
        return h.a(new x(str3, str4));
    }
}
