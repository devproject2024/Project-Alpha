package com.google.firebase.iid;

final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseInstanceId f38866a;

    i(FirebaseInstanceId firebaseInstanceId) {
        this.f38866a = firebaseInstanceId;
    }

    public final void run() {
        FirebaseInstanceId firebaseInstanceId = this.f38866a;
        if (firebaseInstanceId.f38778h.a()) {
            firebaseInstanceId.b();
        }
    }
}
