package com.google.firebase.messaging;

import android.content.Context;
import com.google.android.datatransport.g;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.a.b;
import com.google.android.gms.tasks.Task;
import com.google.firebase.c;
import com.google.firebase.e.h;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.af;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FirebaseMessaging {

    /* renamed from: b  reason: collision with root package name */
    static g f38988b;

    /* renamed from: a  reason: collision with root package name */
    final FirebaseInstanceId f38989a;

    /* renamed from: c  reason: collision with root package name */
    private final Context f38990c;

    /* renamed from: d  reason: collision with root package name */
    private final c f38991d;

    /* renamed from: e  reason: collision with root package name */
    private final Task<v> f38992e;

    static synchronized FirebaseMessaging getInstance(c cVar) {
        FirebaseMessaging firebaseMessaging;
        Class cls = FirebaseMessaging.class;
        synchronized (cls) {
            firebaseMessaging = (FirebaseMessaging) cVar.a(cls);
            s.a(firebaseMessaging, (Object) "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }

    FirebaseMessaging(c cVar, FirebaseInstanceId firebaseInstanceId, h hVar, com.google.firebase.b.c cVar2, com.google.firebase.installations.g gVar, g gVar2) {
        f38988b = gVar2;
        this.f38991d = cVar;
        this.f38989a = firebaseInstanceId;
        this.f38990c = cVar.a();
        this.f38992e = v.a(cVar, firebaseInstanceId, new af(this.f38990c), hVar, cVar2, gVar, this.f38990c, new ScheduledThreadPoolExecutor(1, new b("Firebase-Messaging-Topics-Io")));
        this.f38992e.a((Executor) new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b("Firebase-Messaging-Trigger-Topics-Io")), new g(this));
    }

    public static g a() {
        return f38988b;
    }
}
