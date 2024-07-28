package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnSuccessListener;

final /* synthetic */ class g implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseMessaging f39009a;

    g(FirebaseMessaging firebaseMessaging) {
        this.f39009a = firebaseMessaging;
    }

    public final void onSuccess(Object obj) {
        v vVar = (v) obj;
        if (this.f39009a.f38989a.f38778h.a()) {
            if ((vVar.f39037a.a() != null) && !vVar.b()) {
                vVar.a(0);
            }
        }
    }
}
