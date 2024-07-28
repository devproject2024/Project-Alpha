package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;
import java.util.concurrent.Callable;

final /* synthetic */ class v implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final Intent f38892a;

    v(Intent intent) {
        this.f38892a = intent;
    }

    public final Object call() {
        Intent intent = this.f38892a;
        String stringExtra = intent.getStringExtra("CMD");
        if (stringExtra != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                StringBuilder sb = new StringBuilder(String.valueOf(stringExtra).length() + 21 + String.valueOf(valueOf).length());
                sb.append("Received command: ");
                sb.append(stringExtra);
                sb.append(" - ");
                sb.append(valueOf);
            }
            if ("RST".equals(stringExtra) || "RST_FULL".equals(stringExtra)) {
                FirebaseInstanceId.a().j();
            } else if ("SYNC".equals(stringExtra)) {
                FirebaseInstanceId a2 = FirebaseInstanceId.a();
                FirebaseInstanceId.f38770a.b(a2.k());
                a2.c();
            }
        }
        return -1;
    }
}
