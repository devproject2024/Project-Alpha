package com.google.firebase.iid;

import com.appsflyer.internal.referrer.Payload;
import com.google.android.gms.tasks.f;
import java.io.IOException;

final /* synthetic */ class an implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f38818a;

    an(f fVar) {
        this.f38818a = fVar;
    }

    public final void run() {
        this.f38818a.b((Exception) new IOException(Payload.RESPONSE_TIMEOUT));
    }
}
