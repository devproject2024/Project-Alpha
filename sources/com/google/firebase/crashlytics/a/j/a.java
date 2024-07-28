package com.google.firebase.crashlytics.a.j;

import android.content.Context;
import com.google.android.datatransport.b;
import com.google.android.datatransport.c;
import com.google.android.datatransport.e;
import com.google.android.datatransport.f;
import com.google.android.datatransport.runtime.q;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.a.c.o;
import com.google.firebase.crashlytics.a.e.v;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final com.google.firebase.crashlytics.a.e.a.a f38642a = new com.google.firebase.crashlytics.a.e.a.a();

    /* renamed from: b  reason: collision with root package name */
    private static final String f38643b = a("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");

    /* renamed from: c  reason: collision with root package name */
    private static final String f38644c = a("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");

    /* renamed from: d  reason: collision with root package name */
    private static final e<v, byte[]> f38645d = c.a();

    /* renamed from: e  reason: collision with root package name */
    private final f<v> f38646e;

    /* renamed from: f  reason: collision with root package name */
    private final e<v, byte[]> f38647f;

    public static a a(Context context) {
        q.a(context);
        Class<v> cls = v.class;
        return new a(q.a().a((com.google.android.datatransport.runtime.e) new com.google.android.datatransport.cct.a(f38643b, f38644c)).a("FIREBASE_CRASHLYTICS_REPORT", b.a("json"), f38645d), f38645d);
    }

    private a(f<v> fVar, e<v, byte[]> eVar) {
        this.f38646e = fVar;
        this.f38647f = eVar;
    }

    public final Task<o> a(o oVar) {
        v a2 = oVar.a();
        com.google.android.gms.tasks.f fVar = new com.google.android.gms.tasks.f();
        this.f38646e.a(c.a(a2), b.a(fVar, oVar));
        return fVar.a();
    }

    static /* synthetic */ void a(com.google.android.gms.tasks.f fVar, o oVar, Exception exc) {
        if (exc != null) {
            fVar.b(exc);
        } else {
            fVar.b(oVar);
        }
    }

    private static String a(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str.length() + str2.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            sb.append(str.charAt(i2));
            if (str2.length() > i2) {
                sb.append(str2.charAt(i2));
            }
        }
        return sb.toString();
    }
}
