package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.c;

final /* synthetic */ class f implements c {

    /* renamed from: a  reason: collision with root package name */
    private final EnhancedIntentService f39007a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f39008b;

    f(EnhancedIntentService enhancedIntentService, Intent intent) {
        this.f39007a = enhancedIntentService;
        this.f39008b = intent;
    }

    public final void a(Task task) {
        this.f39007a.lambda$onStartCommand$1$EnhancedIntentService(this.f39008b, task);
    }
}
