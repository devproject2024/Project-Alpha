package net.one97.paytm.oauth.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.paytm.utility.q;
import kotlin.g.b.k;
import kotlin.m.j;
import kotlin.m.l;
import kotlin.u;

public final class OtpSmsRetrieveBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final l f56749a = new l("(\\d{6})");

    /* renamed from: b  reason: collision with root package name */
    private a f56750b;

    public interface a {
        void c(String str);
    }

    public final void a(a aVar) {
        this.f56750b = aVar;
        String.valueOf(this.f56750b);
        q.b();
    }

    public final void onReceive(Context context, Intent intent) {
        k.c(context, "context");
        k.c(intent, "intent");
        q.b();
        if (k.a((Object) "com.google.android.gms.auth.api.phone.SMS_RETRIEVED", (Object) intent.getAction())) {
            q.b();
            Bundle extras = intent.getExtras();
            if (extras == null) {
                k.a();
            }
            Object obj = extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS");
            if (obj == null) {
                throw new u("null cannot be cast to non-null type com.google.android.gms.common.api.Status");
            } else if (((Status) obj).d() == 0) {
                Object obj2 = extras.get("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
                if (obj2 != null) {
                    j find$default = l.find$default(this.f56749a, (String) obj2, 0, 2, (Object) null);
                    if (find$default != null) {
                        q.b();
                        a aVar = this.f56750b;
                        if (aVar != null) {
                            aVar.c(find$default.b());
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.String");
            }
        }
    }
}
