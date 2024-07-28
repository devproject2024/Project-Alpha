package com.google.firebase.messaging;

import android.content.Context;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.af;
import com.google.firebase.iid.q;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

final /* synthetic */ class w implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final Context f39045a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f39046b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseInstanceId f39047c;

    /* renamed from: d  reason: collision with root package name */
    private final af f39048d;

    /* renamed from: e  reason: collision with root package name */
    private final q f39049e;

    w(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseInstanceId firebaseInstanceId, af afVar, q qVar) {
        this.f39045a = context;
        this.f39046b = scheduledExecutorService;
        this.f39047c = firebaseInstanceId;
        this.f39048d = afVar;
        this.f39049e = qVar;
    }

    public final Object call() {
        return v.a(this.f39045a, this.f39046b, this.f39047c, this.f39048d, this.f39049e);
    }
}
