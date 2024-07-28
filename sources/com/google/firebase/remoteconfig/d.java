package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.remoteconfig.internal.f;

public final /* synthetic */ class d implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    private final a f39339a;

    private d(a aVar) {
        this.f39339a = aVar;
    }

    public static OnSuccessListener a(a aVar) {
        return new d(aVar);
    }

    public final void onSuccess(Object obj) {
        a.a(this.f39339a, (f) obj);
    }
}
