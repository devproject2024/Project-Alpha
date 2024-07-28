package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.e;
import java.util.concurrent.atomic.AtomicReference;

public final class dw extends fw {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReference<String[]> f11817a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReference<String[]> f11818b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReference<String[]> f11819c = new AtomicReference<>();

    dw(fc fcVar) {
        super(fcVar);
    }

    /* access modifiers changed from: protected */
    public final boolean a() {
        return false;
    }

    private final boolean c() {
        return TextUtils.isEmpty(this.y.f11941a) && this.y.J_().a(3);
    }

    /* access modifiers changed from: protected */
    public final String a(String str) {
        if (str == null) {
            return null;
        }
        if (!c()) {
            return str;
        }
        return a(str, fx.f12003b, fx.f12002a, f11817a);
    }

    /* access modifiers changed from: protected */
    public final String b(String str) {
        if (str == null) {
            return null;
        }
        if (!c()) {
            return str;
        }
        return a(str, ga.f12011b, ga.f12010a, f11818b);
    }

    /* access modifiers changed from: protected */
    public final String c(String str) {
        if (str == null) {
            return null;
        }
        if (!c()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return a(str, fz.f12005b, fz.f12004a, f11819c);
        }
        return "experiment_id" + "(" + str + ")";
    }

    private static String a(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        s.a(strArr);
        s.a(strArr2);
        s.a(atomicReference);
        s.b(strArr.length == strArr2.length);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (jq.c(str, strArr[i2])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i2] == null) {
                        strArr3[i2] = strArr2[i2] + "(" + strArr[i2] + ")";
                    }
                    str2 = strArr3[i2];
                }
                return str2;
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public final String a(zzan zzan) {
        if (zzan == null) {
            return null;
        }
        if (!c()) {
            return zzan.toString();
        }
        return "origin=" + zzan.f12370c + ",name=" + a(zzan.f12368a) + ",params=" + a(zzan.f12369b);
    }

    /* access modifiers changed from: protected */
    public final String a(l lVar) {
        if (lVar == null) {
            return null;
        }
        if (!c()) {
            return lVar.toString();
        }
        return "Event{appId='" + lVar.f12338a + "', name='" + a(lVar.f12339b) + "', params=" + a(lVar.f12342e) + "}";
    }

    private final String a(zzam zzam) {
        if (zzam == null) {
            return null;
        }
        if (!c()) {
            return zzam.toString();
        }
        return a(zzam.a());
    }

    /* access modifiers changed from: protected */
    public final String a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!c()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        for (String str : bundle.keySet()) {
            if (sb.length() != 0) {
                sb.append(", ");
            } else {
                sb.append("Bundle[{");
            }
            sb.append(b(str));
            sb.append("=");
            sb.append(bundle.get(str));
        }
        sb.append("}]");
        return sb.toString();
    }

    public final /* bridge */ /* synthetic */ void M_() {
        super.M_();
    }

    public final /* bridge */ /* synthetic */ void g() {
        super.g();
    }

    public final /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    public final /* bridge */ /* synthetic */ i i() {
        return super.i();
    }

    public final /* bridge */ /* synthetic */ e j() {
        return super.j();
    }

    public final /* bridge */ /* synthetic */ Context k() {
        return super.k();
    }

    public final /* bridge */ /* synthetic */ dw l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ jq L_() {
        return super.L_();
    }

    public final /* bridge */ /* synthetic */ eu K_() {
        return super.K_();
    }

    public final /* bridge */ /* synthetic */ dy J_() {
        return super.J_();
    }

    public final /* bridge */ /* synthetic */ eh I_() {
        return super.I_();
    }

    public final /* bridge */ /* synthetic */ ke H_() {
        return super.H_();
    }
}
