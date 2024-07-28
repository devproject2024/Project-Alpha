package com.google.firebase.iid;

import com.google.firebase.a.a;
import com.google.firebase.a.b;
import com.google.firebase.iid.FirebaseInstanceId;

final /* synthetic */ class o implements b {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseInstanceId.a f38880a;

    o(FirebaseInstanceId.a aVar) {
        this.f38880a = aVar;
    }

    public final void a(a aVar) {
        FirebaseInstanceId.a aVar2 = this.f38880a;
        synchronized (aVar2) {
            if (aVar2.a()) {
                FirebaseInstanceId.this.b();
            }
        }
    }
}
