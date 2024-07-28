package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.appsflyer.AppsFlyerProperties;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.h;
import com.google.firebase.b.c;
import com.google.firebase.c;
import com.google.firebase.e.h;
import com.google.firebase.installations.g;
import com.google.firebase.installations.l;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    private final c f38883a;

    /* renamed from: b  reason: collision with root package name */
    private final af f38884b;

    /* renamed from: c  reason: collision with root package name */
    private final ak f38885c;

    /* renamed from: d  reason: collision with root package name */
    private final h f38886d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.firebase.b.c f38887e;

    /* renamed from: f  reason: collision with root package name */
    private final g f38888f;

    public q(c cVar, af afVar, h hVar, com.google.firebase.b.c cVar2, g gVar) {
        this(cVar, afVar, new ak(cVar.a(), afVar), hVar, cVar2, gVar);
    }

    private q(c cVar, af afVar, ak akVar, h hVar, com.google.firebase.b.c cVar2, g gVar) {
        this.f38883a = cVar;
        this.f38884b = afVar;
        this.f38885c = akVar;
        this.f38886d = hVar;
        this.f38887e = cVar2;
        this.f38888f = gVar;
    }

    public final Task<Bundle> a(String str, String str2, String str3, Bundle bundle) {
        b(str, str2, str3, bundle);
        return this.f38885c.a(bundle);
    }

    private String a() {
        try {
            return Base64.encodeToString(MessageDigest.getInstance("SHA-1").digest(this.f38883a.b().getBytes()), 11);
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    private Bundle b(String str, String str2, String str3, Bundle bundle) {
        Object obj;
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString(CLConstants.FIELD_SUBTYPE, str2);
        bundle.putString(AppsFlyerProperties.APP_ID, str);
        bundle.putString("gmp_app_id", this.f38883a.c().f38755b);
        bundle.putString("gmsv", Integer.toString(this.f38884b.e()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f38884b.c());
        bundle.putString("app_ver_name", this.f38884b.d());
        bundle.putString("firebase-app-name-hash", a());
        try {
            Task b2 = this.f38888f.b();
            s.c("Must not be called on the main application thread");
            s.a(b2, (Object) "Task must not be null");
            if (b2.a()) {
                obj = com.google.android.gms.tasks.h.a(b2);
            } else {
                h.a aVar = new h.a((byte) 0);
                com.google.android.gms.tasks.h.a((Task<?>) b2, (h.c) aVar);
                aVar.f12482a.await();
                obj = com.google.android.gms.tasks.h.a(b2);
            }
            String a2 = ((l) obj).a();
            if (!TextUtils.isEmpty(a2)) {
                bundle.putString("Goog-Firebase-Installations-Auth", a2);
            }
        } catch (InterruptedException | ExecutionException unused) {
        }
        bundle.putString("cliv", "20.2.3".length() != 0 ? "fiid-".concat("20.2.3") : new String("fiid-"));
        c.a a3 = this.f38887e.a("fire-iid");
        if (a3 != c.a.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(a3.getCode()));
            bundle.putString("Firebase-Client", this.f38886d.a());
        }
        return bundle;
    }

    public final Task<String> a(Task<Bundle> task) {
        return task.a(g.a(), (a<Bundle, TContinuationResult>) new s(this));
    }
}
