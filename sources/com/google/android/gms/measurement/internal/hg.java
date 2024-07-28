package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.measurement.aj;
import com.google.android.gms.internal.measurement.dv;
import com.google.android.gms.internal.measurement.jz;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class hg extends jg {
    public hg(jj jjVar) {
        super(jjVar);
    }

    /* access modifiers changed from: protected */
    public final boolean a() {
        return false;
    }

    public final byte[] a(zzan zzan, String str) {
        jr jrVar;
        Bundle bundle;
        long j;
        k kVar;
        zzan zzan2 = zzan;
        String str2 = str;
        h();
        fc.s();
        s.a(zzan);
        s.a(str);
        if (!H_().d(str2, o.ae)) {
            J_().j.a("Generating ScionPayload disabled. packageName", str2);
            return new byte[0];
        } else if ("_iap".equals(zzan2.f12368a) || "_iapx".equals(zzan2.f12368a)) {
            aj.f.a a2 = aj.f.a();
            F_().b();
            try {
                fb b2 = F_().b(str2);
                if (b2 == null) {
                    J_().j.a("Log and bundle not available. package_name", str2);
                    return new byte[0];
                } else if (!b2.q()) {
                    J_().j.a("Log and bundle disabled. package_name", str2);
                    byte[] bArr = new byte[0];
                    F_().x_();
                    return bArr;
                } else {
                    aj.g.a a3 = aj.g.c().a().a("android");
                    if (!TextUtils.isEmpty(b2.b())) {
                        a3.f(b2.b());
                    }
                    if (!TextUtils.isEmpty(b2.m())) {
                        a3.e(b2.m());
                    }
                    if (!TextUtils.isEmpty(b2.k())) {
                        a3.g(b2.k());
                    }
                    if (b2.l() != -2147483648L) {
                        a3.g((int) b2.l());
                    }
                    a3.f(b2.n()).j(b2.p());
                    jz.a();
                    if (H_().d(b2.b(), o.aC)) {
                        if (!TextUtils.isEmpty(b2.d())) {
                            a3.k(b2.d());
                        } else if (!TextUtils.isEmpty(b2.f())) {
                            a3.o(b2.f());
                        } else if (!TextUtils.isEmpty(b2.e())) {
                            a3.n(b2.e());
                        }
                    } else if (!TextUtils.isEmpty(b2.d())) {
                        a3.k(b2.d());
                    } else if (!TextUtils.isEmpty(b2.e())) {
                        a3.n(b2.e());
                    }
                    a3.g(b2.o());
                    if (this.y.r() && H_().d((String) null, o.f12346a) && H_().d(a3.k()) && !TextUtils.isEmpty((CharSequence) null)) {
                        a3.p();
                    }
                    Pair<String, Boolean> a4 = I_().a(b2.b());
                    if (b2.x() && !TextUtils.isEmpty((CharSequence) a4.first)) {
                        Object obj = a4.first;
                        Long.toString(zzan2.f12371d);
                        a3.h(b());
                        if (a4.second != null) {
                            a3.a(((Boolean) a4.second).booleanValue());
                        }
                    }
                    i().w();
                    aj.g.a c2 = a3.c(Build.MODEL);
                    i().w();
                    c2.b(Build.VERSION.RELEASE).e((int) i().N_()).d(i().c());
                    try {
                        b2.c();
                        Long.toString(zzan2.f12371d);
                        a3.i(b());
                        if (!TextUtils.isEmpty(b2.h())) {
                            a3.l(b2.h());
                        }
                        String b3 = b2.b();
                        List<jr> a5 = F_().a(b3);
                        Iterator<jr> it2 = a5.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                jrVar = null;
                                break;
                            }
                            jrVar = it2.next();
                            if ("_lte".equals(jrVar.f12291c)) {
                                break;
                            }
                        }
                        if (jrVar == null || jrVar.f12293e == null) {
                            jr jrVar2 = new jr(b3, "auto", "_lte", j().a(), 0L);
                            a5.add(jrVar2);
                            F_().a(jrVar2);
                        }
                        if (H_().d(b3, o.aa)) {
                            jn G_ = G_();
                            G_.J_().k.a("Checking account type status for ad personalization signals");
                            if (G_.i().e()) {
                                String b4 = b2.b();
                                if (b2.x() && G_.E_().e(b4)) {
                                    G_.J_().j.a("Turning off ad personalization due to account type");
                                    Iterator<jr> it3 = a5.iterator();
                                    while (true) {
                                        if (!it3.hasNext()) {
                                            break;
                                        } else if ("_npa".equals(it3.next().f12291c)) {
                                            it3.remove();
                                            break;
                                        }
                                    }
                                    a5.add(new jr(b4, "auto", "_npa", G_.j().a(), 1L));
                                }
                            }
                        }
                        aj.k[] kVarArr = new aj.k[a5.size()];
                        for (int i2 = 0; i2 < a5.size(); i2++) {
                            aj.k.a a6 = aj.k.d().a(a5.get(i2).f12291c).a(a5.get(i2).f12292d);
                            G_().a(a6, a5.get(i2).f12293e);
                            kVarArr[i2] = (aj.k) ((dv) a6.w());
                        }
                        a3.b((Iterable<? extends aj.k>) Arrays.asList(kVarArr));
                        Bundle a7 = zzan2.f12369b.a();
                        a7.putLong("_c", 1);
                        J_().j.a("Marking in-app purchase as real-time");
                        a7.putLong("_r", 1);
                        a7.putString("_o", zzan2.f12370c);
                        if (L_().f(a3.k())) {
                            L_().a(a7, "_dbg", (Object) 1L);
                            L_().a(a7, "_r", (Object) 1L);
                        }
                        k a8 = F_().a(str2, zzan2.f12368a);
                        if (a8 == null) {
                            bundle = a7;
                            kVar = new k(str, zzan2.f12368a, 0, 0, zzan2.f12371d);
                            j = 0;
                        } else {
                            bundle = a7;
                            long j2 = a8.f12318f;
                            kVar = a8.a(zzan2.f12371d);
                            j = j2;
                        }
                        F_().a(kVar);
                        k kVar2 = kVar;
                        l lVar = r2;
                        aj.g.a aVar = a3;
                        l lVar2 = new l(this.y, zzan2.f12370c, str, zzan2.f12368a, zzan2.f12371d, j, bundle);
                        aj.c.a b5 = aj.c.c().a(lVar.f12340c).a(lVar.f12339b).b(lVar.f12341d);
                        Iterator<String> it4 = lVar.f12342e.iterator();
                        while (it4.hasNext()) {
                            String next = it4.next();
                            aj.e.a a9 = aj.e.d().a(next);
                            G_().a(a9, lVar.f12342e.a(next));
                            b5.a(a9);
                        }
                        aVar.a(b5).a(aj.h.a().a(aj.d.a().a(kVar2.f12315c).a(zzan2.f12368a)));
                        aVar.c((Iterable<? extends aj.a>) d().a(b2.b(), Collections.emptyList(), aVar.e(), Long.valueOf(b5.f())));
                        if (b5.e()) {
                            aVar.b(b5.f()).c(b5.f());
                        }
                        long j3 = b2.j();
                        int i3 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
                        if (i3 != 0) {
                            aVar.e(j3);
                        }
                        long i4 = b2.i();
                        if (i4 != 0) {
                            aVar.d(i4);
                        } else if (i3 != 0) {
                            aVar.d(j3);
                        }
                        b2.u();
                        aVar.f((int) b2.r()).o_().a(j().a()).b(true);
                        a2.a(aVar);
                        b2.a(aVar.g());
                        b2.b(aVar.h());
                        F_().a(b2);
                        F_().c();
                        F_().x_();
                        try {
                            return G_().c(((aj.f) ((dv) a2.w())).i());
                        } catch (IOException e2) {
                            J_().f11828c.a("Data loss. Failed to bundle and serialize. appId", dy.a(str), e2);
                            return null;
                        }
                    } catch (SecurityException e3) {
                        J_().j.a("app instance id encryption failed", e3.getMessage());
                        byte[] bArr2 = new byte[0];
                        F_().x_();
                        return bArr2;
                    }
                }
            } catch (SecurityException e4) {
                J_().j.a("Resettable device id encryption failed", e4.getMessage());
                return new byte[0];
            } finally {
                F_().x_();
            }
        } else {
            J_().j.a("Generating a payload for this event is not available. package_name, event_name", str2, zzan2.f12368a);
            return null;
        }
    }

    private static String b() {
        throw new SecurityException("This implementation should not be used.");
    }
}
