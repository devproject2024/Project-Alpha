package com.google.firebase.messaging;

import android.content.Intent;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.gms.common.internal.s;
import com.google.firebase.encoders.d;
import com.google.firebase.encoders.e;
import java.io.IOException;

final class j {

    /* renamed from: a  reason: collision with root package name */
    final String f39012a;

    /* renamed from: b  reason: collision with root package name */
    final Intent f39013b;

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final j f39014a;

        b(j jVar) {
            this.f39014a = (j) s.a(jVar);
        }
    }

    j(String str, Intent intent) {
        this.f39012a = s.a(str, (Object) "evenType must be non-null");
        this.f39013b = (Intent) s.a(intent, (Object) "intent must be non-null");
    }

    static final class c implements d<b> {
        c() {
        }

        public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            ((e) obj2).a("messaging_client_event", (Object) ((b) obj).f39014a);
        }
    }

    static class a implements d<j> {
        a() {
        }

        public final /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            j jVar = (j) obj;
            e eVar = (e) obj2;
            Intent intent = jVar.f39013b;
            eVar.a("ttl", m.f(intent));
            eVar.a(AppConstants.NOTIFICATION_DETAILS.EVENT, (Object) jVar.f39012a);
            eVar.a("instanceId", (Object) m.b());
            eVar.a("priority", m.m(intent));
            eVar.a("packageName", (Object) m.a());
            eVar.a("sdkPlatform", (Object) "ANDROID");
            eVar.a("messageType", (Object) m.k(intent));
            String j = m.j(intent);
            if (j != null) {
                eVar.a("messageId", (Object) j);
            }
            String l = m.l(intent);
            if (l != null) {
                eVar.a("topic", (Object) l);
            }
            String g2 = m.g(intent);
            if (g2 != null) {
                eVar.a("collapseKey", (Object) g2);
            }
            if (m.i(intent) != null) {
                eVar.a("analyticsLabel", (Object) m.i(intent));
            }
            if (m.h(intent) != null) {
                eVar.a("composerLabel", (Object) m.h(intent));
            }
            String c2 = m.c();
            if (c2 != null) {
                eVar.a("projectNumber", (Object) c2);
            }
        }
    }
}
