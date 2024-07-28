package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.f;

final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final EnhancedIntentService f39003a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f39004b;

    /* renamed from: c  reason: collision with root package name */
    private final f f39005c;

    d(EnhancedIntentService enhancedIntentService, Intent intent, f fVar) {
        this.f39003a = enhancedIntentService;
        this.f39004b = intent;
        this.f39005c = fVar;
    }

    public final void run() {
        this.f39003a.lambda$processIntent$0$EnhancedIntentService(this.f39004b, this.f39005c);
    }
}
