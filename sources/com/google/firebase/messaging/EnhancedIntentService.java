package com.google.firebase.messaging;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.internal.f.a;
import com.google.android.gms.internal.f.b;
import com.google.android.gms.internal.f.e;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.h;
import com.google.firebase.iid.at;
import com.google.firebase.iid.au;
import java.util.concurrent.ExecutorService;

public abstract class EnhancedIntentService extends Service {
    private Binder binder;
    final ExecutorService executor;
    private int lastStartId;
    private final Object lock = new Object();
    private int runningTasks = 0;

    public EnhancedIntentService() {
        b a2 = a.a();
        com.google.android.gms.common.util.a.b bVar = new com.google.android.gms.common.util.a.b("Firebase-Messaging-Intent-Handle");
        int i2 = e.f9466a;
        this.executor = a2.a(bVar);
    }

    /* access modifiers changed from: protected */
    public Intent getStartCommandIntent(Intent intent) {
        return intent;
    }

    public abstract void handleIntent(Intent intent);

    public boolean handleIntentOnMainThread(Intent intent) {
        return false;
    }

    public final synchronized IBinder onBind(Intent intent) {
        Log.isLoggable("EnhancedIntentService", 3);
        if (this.binder == null) {
            this.binder = new au(new au.a() {
                public final Task<Void> a(Intent intent) {
                    return EnhancedIntentService.this.processIntent(intent);
                }
            });
        }
        return this.binder;
    }

    /* access modifiers changed from: private */
    public Task<Void> processIntent(Intent intent) {
        if (handleIntentOnMainThread(intent)) {
            return h.a(null);
        }
        f fVar = new f();
        this.executor.execute(new d(this, intent, fVar));
        return fVar.f12478a;
    }

    public final int onStartCommand(Intent intent, int i2, int i3) {
        synchronized (this.lock) {
            this.lastStartId = i3;
            this.runningTasks++;
        }
        Intent startCommandIntent = getStartCommandIntent(intent);
        if (startCommandIntent == null) {
            finishTask(intent);
            return 2;
        }
        Task<Void> processIntent = processIntent(startCommandIntent);
        if (processIntent.a()) {
            finishTask(intent);
            return 2;
        }
        processIntent.a(e.f39006a, (c<Void>) new f(this, intent));
        return 3;
    }

    public void onDestroy() {
        this.executor.shutdown();
        super.onDestroy();
    }

    private void finishTask(Intent intent) {
        if (intent != null) {
            at.a(intent);
        }
        synchronized (this.lock) {
            this.runningTasks--;
            if (this.runningTasks == 0) {
                stopSelfResultHook(this.lastStartId);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean stopSelfResultHook(int i2) {
        return stopSelfResult(i2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$onStartCommand$1$EnhancedIntentService(Intent intent, Task task) {
        finishTask(intent);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$processIntent$0$EnhancedIntentService(Intent intent, f fVar) {
        try {
            handleIntent(intent);
        } finally {
            fVar.a(null);
        }
    }
}
