package com.google.firebase.perf.internal;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.internal.p001firebaseperf.ac;
import com.google.android.gms.internal.p001firebaseperf.ar;
import com.google.android.gms.internal.p001firebaseperf.ba;
import com.google.android.gms.internal.p001firebaseperf.bc;
import com.google.android.gms.internal.p001firebaseperf.dq;
import com.google.android.gms.internal.p001firebaseperf.g;
import com.google.android.gms.internal.p001firebaseperf.o;
import com.google.android.gms.internal.p001firebaseperf.s;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class GaugeManager {
    private static GaugeManager zzdm = new GaugeManager();
    private final FeatureControl zzcx;
    private final ScheduledExecutorService zzdn;
    private final o zzdo;
    private final s zzdp;
    private g zzdq;
    private t zzdr;
    private ar zzds;
    private String zzdt;
    private ScheduledFuture zzdu;
    private final ConcurrentLinkedQueue<a> zzdv;

    class a {

        /* renamed from: a  reason: collision with root package name */
        final bc f39182a;

        /* renamed from: b  reason: collision with root package name */
        final ar f39183b;

        a(bc bcVar, ar arVar) {
            this.f39182a = bcVar;
            this.f39183b = arVar;
        }
    }

    private GaugeManager() {
        this(Executors.newSingleThreadScheduledExecutor(), (g) null, FeatureControl.zzao(), (t) null, o.a(), s.a());
    }

    private GaugeManager(ScheduledExecutorService scheduledExecutorService, g gVar, FeatureControl featureControl, t tVar, o oVar, s sVar) {
        this.zzds = ar.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.zzdt = null;
        this.zzdu = null;
        this.zzdv = new ConcurrentLinkedQueue<>();
        this.zzdn = scheduledExecutorService;
        this.zzdq = null;
        this.zzcx = featureControl;
        this.zzdr = null;
        this.zzdo = oVar;
        this.zzdp = sVar;
    }

    public final void zze(Context context) {
        this.zzdr = new t(context);
    }

    public static synchronized GaugeManager zzbe() {
        GaugeManager gaugeManager;
        synchronized (GaugeManager.class) {
            gaugeManager = zzdm;
        }
        return gaugeManager;
    }

    public final void zza(String str, ar arVar) {
        long j;
        boolean z;
        long j2;
        String str2 = str;
        ar arVar2 = arVar;
        if (this.zzdt != null) {
            zzbf();
        }
        int i2 = r.f39227a[arVar.ordinal()];
        if (i2 == 1) {
            j = this.zzcx.zzav();
        } else if (i2 != 2) {
            j = -1;
        } else {
            j = this.zzcx.zzat();
        }
        if (j == -1 || j <= 0) {
            j = -1;
        }
        boolean z2 = false;
        if (this.zzcx.zzaq() && j != -1) {
            o oVar = this.zzdo;
            if (!(oVar.f9713c == -1 || oVar.f9713c == 0 || j <= 0)) {
                if (oVar.f9711a == null) {
                    oVar.a(j);
                } else if (oVar.f9712b != j) {
                    oVar.b();
                    oVar.a(j);
                }
            }
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            j = -1;
        }
        int i3 = r.f39227a[arVar.ordinal()];
        if (i3 == 1) {
            j2 = this.zzcx.zzaw();
        } else if (i3 != 2) {
            j2 = -1;
        } else {
            j2 = this.zzcx.zzau();
        }
        if (j2 == -1 || j2 <= 0) {
            j2 = -1;
        }
        if (this.zzcx.zzar() && j2 != -1) {
            s sVar = this.zzdp;
            if (j2 > 0) {
                if (sVar.f9722b == null) {
                    sVar.a(j2);
                } else if (sVar.f9723c != j2) {
                    sVar.b();
                    sVar.a(j2);
                }
            }
            z2 = true;
        }
        if (z2) {
            if (j != -1) {
                j2 = Math.min(j, j2);
            }
            j = j2;
        }
        if (j != -1) {
            this.zzdt = str2;
            this.zzds = arVar2;
            try {
                long j3 = j * 20;
                this.zzdu = this.zzdn.scheduleAtFixedRate(new q(this, str2, arVar2), j3, j3, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e2) {
                String valueOf = String.valueOf(e2.getMessage());
                if (valueOf.length() != 0) {
                    "Unable to start collecting Gauges: ".concat(valueOf);
                } else {
                    new String("Unable to start collecting Gauges: ");
                }
            }
        }
    }

    public final void zzbf() {
        String str = this.zzdt;
        if (str != null) {
            ar arVar = this.zzds;
            this.zzdo.b();
            this.zzdp.b();
            ScheduledFuture scheduledFuture = this.zzdu;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.zzdn.schedule(new s(this, str, arVar), 20, TimeUnit.MILLISECONDS);
            this.zzdt = null;
            this.zzds = ar.APPLICATION_PROCESS_STATE_UNKNOWN;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final void zze(String str, ar arVar) {
        bc.a d2 = bc.d();
        while (!this.zzdo.f9714d.isEmpty()) {
            d2.a(this.zzdo.f9714d.poll());
        }
        while (!this.zzdp.f9721a.isEmpty()) {
            d2.a(this.zzdp.f9721a.poll());
        }
        d2.a(str);
        zzc((bc) ((dq) d2.k()), arVar);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc(String str, ar arVar) {
        int i2;
        if (this.zzdr == null) {
            return false;
        }
        bc.a a2 = bc.d().a(str);
        ba.a a3 = ba.a().a(this.zzdr.f39234d);
        t tVar = this.zzdr;
        if (Build.VERSION.SDK_INT >= 16) {
            i2 = g.a(ac.BYTES.zzp(tVar.f39233c.totalMem));
        } else {
            i2 = t.a("/proc/meminfo");
        }
        zzc((bc) ((dq) a2.a((ba) ((dq) a3.a(i2).b(g.a(ac.BYTES.zzp(this.zzdr.f39231a.maxMemory()))).c(g.a(ac.zzhz.zzp((long) this.zzdr.f39232b.getMemoryClass()))).k())).k()), arVar);
        return true;
    }

    private final void zzc(bc bcVar, ar arVar) {
        g gVar = this.zzdq;
        if (gVar == null) {
            gVar = g.a();
        }
        this.zzdq = gVar;
        g gVar2 = this.zzdq;
        if (gVar2 != null) {
            gVar2.a(bcVar, arVar);
            while (!this.zzdv.isEmpty()) {
                a poll = this.zzdv.poll();
                this.zzdq.a(poll.f39182a, poll.f39183b);
            }
            return;
        }
        this.zzdv.add(new a(bcVar, arVar));
    }

    public final void zzbg() {
        zza(this.zzcx.zzaq(), this.zzcx.zzar(), this.zzdo, this.zzdp);
    }

    public static void zzbh() {
        zza(true, true, o.a(), s.a());
    }

    private static void zza(boolean z, boolean z2, o oVar, s sVar) {
        if (z) {
            oVar.c();
        }
        if (z2) {
            sVar.c();
        }
    }
}
