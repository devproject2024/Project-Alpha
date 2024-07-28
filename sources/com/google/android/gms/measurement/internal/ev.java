package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.a.a;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.e;
import com.google.android.gms.internal.measurement.ab;
import com.google.android.gms.internal.measurement.ag;
import com.google.android.gms.internal.measurement.dv;
import com.google.android.gms.internal.measurement.eg;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ev extends jg implements kg {

    /* renamed from: a  reason: collision with root package name */
    private static int f11913a = 65535;

    /* renamed from: c  reason: collision with root package name */
    private static int f11914c = 2;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Map<String, String>> f11915d = new a();

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Map<String, Boolean>> f11916e = new a();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, Map<String, Boolean>> f11917f = new a();

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, ag.b> f11918g = new a();

    /* renamed from: h  reason: collision with root package name */
    private final Map<String, Map<String, Integer>> f11919h = new a();

    /* renamed from: i  reason: collision with root package name */
    private final Map<String, String> f11920i = new a();

    ev(jj jjVar) {
        super(jjVar);
    }

    /* access modifiers changed from: protected */
    public final boolean a() {
        return false;
    }

    private final void i(String str) {
        w();
        h();
        s.a(str);
        if (this.f11918g.get(str) == null) {
            byte[] d2 = F_().d(str);
            if (d2 == null) {
                this.f11915d.put(str, (Object) null);
                this.f11916e.put(str, (Object) null);
                this.f11917f.put(str, (Object) null);
                this.f11918g.put(str, (Object) null);
                this.f11920i.put(str, (Object) null);
                this.f11919h.put(str, (Object) null);
                return;
            }
            ag.b.a aVar = (ag.b.a) a(str, d2).m();
            a(str, aVar);
            this.f11915d.put(str, a((ag.b) ((dv) aVar.w())));
            this.f11918g.put(str, (ag.b) ((dv) aVar.w()));
            this.f11920i.put(str, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public final ag.b a(String str) {
        w();
        h();
        s.a(str);
        i(str);
        return this.f11918g.get(str);
    }

    /* access modifiers changed from: protected */
    public final String b(String str) {
        h();
        return this.f11920i.get(str);
    }

    /* access modifiers changed from: protected */
    public final void c(String str) {
        h();
        this.f11920i.put(str, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final void d(String str) {
        h();
        this.f11918g.remove(str);
    }

    /* access modifiers changed from: package-private */
    public final boolean e(String str) {
        h();
        ag.b a2 = a(str);
        if (a2 == null) {
            return false;
        }
        return a2.zzk;
    }

    public final String a(String str, String str2) {
        h();
        i(str);
        Map map = this.f11915d.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    private static Map<String, String> a(ag.b bVar) {
        a aVar = new a();
        if (bVar != null) {
            for (ag.c next : bVar.zzg) {
                aVar.put(next.zzd, next.zze);
            }
        }
        return aVar;
    }

    private final void a(String str, ag.b.a aVar) {
        a aVar2 = new a();
        a aVar3 = new a();
        a aVar4 = new a();
        if (aVar != null) {
            for (int i2 = 0; i2 < aVar.a(); i2++) {
                ag.a.C0156a aVar5 = (ag.a.C0156a) aVar.a(i2).m();
                if (TextUtils.isEmpty(aVar5.a())) {
                    J_().f11831f.a("EventConfig contained null event name");
                } else {
                    String b2 = fx.b(aVar5.a());
                    if (!TextUtils.isEmpty(b2)) {
                        aVar5 = aVar5.a(b2);
                        aVar.a(i2, aVar5);
                    }
                    aVar2.put(aVar5.a(), Boolean.valueOf(aVar5.b()));
                    aVar3.put(aVar5.a(), Boolean.valueOf(aVar5.c()));
                    if (aVar5.d()) {
                        if (aVar5.e() < f11914c || aVar5.e() > f11913a) {
                            J_().f11831f.a("Invalid sampling rate. Event name, sample rate", aVar5.a(), Integer.valueOf(aVar5.e()));
                        } else {
                            aVar4.put(aVar5.a(), Integer.valueOf(aVar5.e()));
                        }
                    }
                }
            }
        }
        this.f11916e.put(str, aVar2);
        this.f11917f.put(str, aVar3);
        this.f11919h.put(str, aVar4);
    }

    /* access modifiers changed from: protected */
    public final boolean a(String str, byte[] bArr, String str2) {
        w();
        h();
        s.a(str);
        ag.b.a aVar = (ag.b.a) a(str, bArr).m();
        if (aVar == null) {
            return false;
        }
        a(str, aVar);
        this.f11918g.put(str, (ag.b) ((dv) aVar.w()));
        this.f11920i.put(str, str2);
        this.f11915d.put(str, a((ag.b) ((dv) aVar.w())));
        F_().b(str, (List<ab.a>) new ArrayList(aVar.b()));
        try {
            aVar.c();
            bArr = ((ag.b) ((dv) aVar.w())).i();
        } catch (RuntimeException e2) {
            J_().f11831f.a("Unable to serialize reduced-size config. Storing full config instead. appId", dy.a(str), e2);
        }
        d F_ = F_();
        s.a(str);
        F_.h();
        F_.w();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) F_.e().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                F_.J_().f11828c.a("Failed to update remote config (got 0). appId", dy.a(str));
            }
        } catch (SQLiteException e3) {
            F_.J_().f11828c.a("Error storing remote config. appId", dy.a(str), e3);
        }
        this.f11918g.put(str, (ag.b) ((dv) aVar.w()));
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean b(String str, String str2) {
        Boolean bool;
        h();
        i(str);
        if (g(str) && jq.e(str2)) {
            return true;
        }
        if (h(str) && jq.a(str2)) {
            return true;
        }
        Map map = this.f11916e.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean c(String str, String str2) {
        Boolean bool;
        h();
        i(str);
        if ("ecommerce_purchase".equals(str2)) {
            return true;
        }
        Map map = this.f11917f.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final int d(String str, String str2) {
        Integer num;
        h();
        i(str);
        Map map = this.f11919h.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: package-private */
    public final long f(String str) {
        String a2 = a(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(a2)) {
            return 0;
        }
        try {
            return Long.parseLong(a2);
        } catch (NumberFormatException e2) {
            J_().f11831f.a("Unable to parse timezone offset. appId", dy.a(str), e2);
            return 0;
        }
    }

    private final ag.b a(String str, byte[] bArr) {
        Long l;
        if (bArr == null) {
            return ag.b.c();
        }
        try {
            ag.b bVar = (ag.b) ((dv) ((ag.b.a) jn.a(ag.b.b(), bArr)).w());
            ea eaVar = J_().k;
            String str2 = null;
            if (bVar.a()) {
                l = Long.valueOf(bVar.zzd);
            } else {
                l = null;
            }
            if ((bVar.zzc & 2) != 0) {
                str2 = bVar.zze;
            }
            eaVar.a("Parsed config. version, gmp_app_id", l, str2);
            return bVar;
        } catch (eg e2) {
            J_().f11831f.a("Unable to merge remote config. appId", dy.a(str), e2);
            return ag.b.c();
        } catch (RuntimeException e3) {
            J_().f11831f.a("Unable to merge remote config. appId", dy.a(str), e3);
            return ag.b.c();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean g(String str) {
        return "1".equals(a(str, "measurement.upload.blacklist_internal"));
    }

    /* access modifiers changed from: package-private */
    public final boolean h(String str) {
        return "1".equals(a(str, "measurement.upload.blacklist_public"));
    }

    public final /* bridge */ /* synthetic */ jn G_() {
        return super.G_();
    }

    public final /* bridge */ /* synthetic */ jv d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ d F_() {
        return super.F_();
    }

    public final /* bridge */ /* synthetic */ ev E_() {
        return super.E_();
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
