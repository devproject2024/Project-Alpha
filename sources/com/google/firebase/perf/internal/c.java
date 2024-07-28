package com.google.firebase.perf.internal;

import com.google.android.gms.tasks.OnFailureListener;

final /* synthetic */ class c implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    private final RemoteConfigManager f39196a;

    c(RemoteConfigManager remoteConfigManager) {
        this.f39196a = remoteConfigManager;
    }

    public final void onFailure(Exception exc) {
        this.f39196a.zza(exc);
    }
}
