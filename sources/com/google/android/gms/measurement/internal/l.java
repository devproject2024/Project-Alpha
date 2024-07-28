package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.s;
import java.util.Iterator;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    final String f12338a;

    /* renamed from: b  reason: collision with root package name */
    final String f12339b;

    /* renamed from: c  reason: collision with root package name */
    final long f12340c;

    /* renamed from: d  reason: collision with root package name */
    final long f12341d;

    /* renamed from: e  reason: collision with root package name */
    final zzam f12342e;

    /* renamed from: f  reason: collision with root package name */
    private final String f12343f;

    private l(fc fcVar, String str, String str2, String str3, long j, long j2, zzam zzam) {
        s.a(str2);
        s.a(str3);
        s.a(zzam);
        this.f12338a = str2;
        this.f12339b = str3;
        this.f12343f = TextUtils.isEmpty(str) ? null : str;
        this.f12340c = j;
        this.f12341d = j2;
        long j3 = this.f12341d;
        if (j3 != 0 && j3 > this.f12340c) {
            fcVar.J_().f11831f.a("Event created with reverse previous/current timestamps. appId, name", dy.a(str2), dy.a(str3));
        }
        this.f12342e = zzam;
    }

    l(fc fcVar, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzam zzam;
        s.a(str2);
        s.a(str3);
        this.f12338a = str2;
        this.f12339b = str3;
        this.f12343f = TextUtils.isEmpty(str) ? null : str;
        this.f12340c = j;
        this.f12341d = j2;
        long j3 = this.f12341d;
        if (j3 != 0 && j3 > this.f12340c) {
            fcVar.J_().f11831f.a("Event created with reverse previous/current timestamps. appId", dy.a(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzam = new zzam(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator it2 = bundle2.keySet().iterator();
            while (it2.hasNext()) {
                String str4 = (String) it2.next();
                if (str4 == null) {
                    fcVar.J_().f11828c.a("Param name can't be null");
                    it2.remove();
                } else {
                    fcVar.e();
                    Object a2 = jq.a(str4, bundle2.get(str4));
                    if (a2 == null) {
                        fcVar.J_().f11831f.a("Param value can't be null", fcVar.f().b(str4));
                        it2.remove();
                    } else {
                        fcVar.e().a(bundle2, str4, a2);
                    }
                }
            }
            zzam = new zzam(bundle2);
        }
        this.f12342e = zzam;
    }

    /* access modifiers changed from: package-private */
    public final l a(fc fcVar, long j) {
        return new l(fcVar, this.f12343f, this.f12338a, this.f12339b, this.f12340c, j, this.f12342e);
    }

    public final String toString() {
        String str = this.f12338a;
        String str2 = this.f12339b;
        String valueOf = String.valueOf(this.f12342e);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(valueOf);
        sb.append('}');
        return sb.toString();
    }
}
