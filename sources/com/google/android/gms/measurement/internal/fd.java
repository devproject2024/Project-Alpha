package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.common.h;
import com.google.android.gms.common.i;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public final class fd extends dp {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public final jj f11950a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f11951b;

    /* renamed from: c  reason: collision with root package name */
    private String f11952c;

    public fd(jj jjVar) {
        this(jjVar, (byte) 0);
    }

    private fd(jj jjVar, byte b2) {
        s.a(jjVar);
        this.f11950a = jjVar;
        this.f11952c = null;
    }

    public final void b(zzm zzm) {
        e(zzm);
        a((Runnable) new fg(this, zzm));
    }

    public final void a(zzan zzan, zzm zzm) {
        s.a(zzan);
        e(zzm);
        a((Runnable) new fl(this, zzan, zzm));
    }

    public final void a(zzan zzan, String str, String str2) {
        s.a(zzan);
        s.a(str);
        a(str, true);
        a((Runnable) new fo(this, zzan, str));
    }

    public final byte[] a(zzan zzan, String str) {
        s.a(str);
        s.a(zzan);
        a(str, true);
        this.f11950a.J_().j.a("Log and bundle. event", this.f11950a.f12266b.f().a(zzan.f12368a));
        long c2 = this.f11950a.j().c() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f11950a.K_().b(new fn(this, zzan, str)).get();
            if (bArr == null) {
                this.f11950a.J_().f11828c.a("Log and bundle returned null. appId", dy.a(str));
                bArr = new byte[0];
            }
            this.f11950a.J_().j.a("Log and bundle processed. event, size, time_ms", this.f11950a.f12266b.f().a(zzan.f12368a), Integer.valueOf(bArr.length), Long.valueOf((this.f11950a.j().c() / 1000000) - c2));
            return bArr;
        } catch (InterruptedException | ExecutionException e2) {
            this.f11950a.J_().f11828c.a("Failed to log and bundle. appId, event, error", dy.a(str), this.f11950a.f12266b.f().a(zzan.f12368a), e2);
            return null;
        }
    }

    public final void a(zzkl zzkl, zzm zzm) {
        s.a(zzkl);
        e(zzm);
        a((Runnable) new fq(this, zzkl, zzm));
    }

    public final List<zzkl> a(zzm zzm, boolean z) {
        e(zzm);
        try {
            List<jr> list = (List) this.f11950a.K_().a(new fp(this, zzm)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (jr jrVar : list) {
                if (z || !jq.e(jrVar.f12291c)) {
                    arrayList.add(new zzkl(jrVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.f11950a.J_().f11828c.a("Failed to get user attributes. appId", dy.a(zzm.f12380a), e2);
            return null;
        }
    }

    public final void a(zzm zzm) {
        e(zzm);
        a((Runnable) new fs(this, zzm));
    }

    private final void e(zzm zzm) {
        s.a(zzm);
        a(zzm.f12380a, false);
        this.f11950a.f12266b.e().a(zzm.f12381b, zzm.r, zzm.v);
    }

    private final void a(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.f11951b == null) {
                        if (!"com.google.android.gms".equals(this.f11952c) && !q.a(this.f11950a.k(), Binder.getCallingUid())) {
                            if (!i.a(this.f11950a.k()).a(Binder.getCallingUid())) {
                                z2 = false;
                                this.f11951b = Boolean.valueOf(z2);
                            }
                        }
                        z2 = true;
                        this.f11951b = Boolean.valueOf(z2);
                    }
                    if (this.f11951b.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e2) {
                    this.f11950a.J_().f11828c.a("Measurement Service called with invalid calling package. appId", dy.a(str));
                    throw e2;
                }
            }
            if (this.f11952c == null && h.a(this.f11950a.k(), Binder.getCallingUid(), str)) {
                this.f11952c = str;
            }
            if (!str.equals(this.f11952c)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
            return;
        }
        this.f11950a.J_().f11828c.a("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    public final void a(long j, String str, String str2, String str3) {
        a((Runnable) new fr(this, str2, str3, str, j));
    }

    public final String c(zzm zzm) {
        e(zzm);
        return this.f11950a.d(zzm);
    }

    public final void a(zzv zzv, zzm zzm) {
        s.a(zzv);
        s.a(zzv.f12391c);
        e(zzm);
        zzv zzv2 = new zzv(zzv);
        zzv2.f12389a = zzm.f12380a;
        a((Runnable) new fu(this, zzv2, zzm));
    }

    public final void a(zzv zzv) {
        s.a(zzv);
        s.a(zzv.f12391c);
        a(zzv.f12389a, true);
        a((Runnable) new ff(this, new zzv(zzv)));
    }

    public final List<zzkl> a(String str, String str2, boolean z, zzm zzm) {
        e(zzm);
        try {
            List<jr> list = (List) this.f11950a.K_().a(new fi(this, zzm, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (jr jrVar : list) {
                if (z || !jq.e(jrVar.f12291c)) {
                    arrayList.add(new zzkl(jrVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.f11950a.J_().f11828c.a("Failed to get user attributes. appId", dy.a(zzm.f12380a), e2);
            return Collections.emptyList();
        }
    }

    public final List<zzkl> a(String str, String str2, String str3, boolean z) {
        a(str, true);
        try {
            List<jr> list = (List) this.f11950a.K_().a(new fh(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (jr jrVar : list) {
                if (z || !jq.e(jrVar.f12291c)) {
                    arrayList.add(new zzkl(jrVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.f11950a.J_().f11828c.a("Failed to get user attributes. appId", dy.a(str), e2);
            return Collections.emptyList();
        }
    }

    public final List<zzv> a(String str, String str2, zzm zzm) {
        e(zzm);
        try {
            return (List) this.f11950a.K_().a(new fk(this, zzm, str, str2)).get();
        } catch (InterruptedException | ExecutionException e2) {
            this.f11950a.J_().f11828c.a("Failed to get conditional user properties", e2);
            return Collections.emptyList();
        }
    }

    public final List<zzv> a(String str, String str2, String str3) {
        a(str, true);
        try {
            return (List) this.f11950a.K_().a(new fj(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e2) {
            this.f11950a.J_().f11828c.a("Failed to get conditional user properties", e2);
            return Collections.emptyList();
        }
    }

    public final void d(zzm zzm) {
        a(zzm.f12380a, false);
        a((Runnable) new fm(this, zzm));
    }

    private final void a(Runnable runnable) {
        s.a(runnable);
        if (this.f11950a.K_().c()) {
            runnable.run();
        } else {
            this.f11950a.K_().a(runnable);
        }
    }
}
