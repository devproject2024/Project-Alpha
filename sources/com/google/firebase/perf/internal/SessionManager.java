package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p001firebaseperf.ar;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SessionManager extends f {
    private static final SessionManager zzfo = new SessionManager();
    private final GaugeManager zzbk;
    private final a zzcw;
    private final Set<WeakReference<e>> zzfp;
    private zzs zzfq;

    public static SessionManager zzcl() {
        return zzfo;
    }

    public final zzs zzcm() {
        return this.zzfq;
    }

    private SessionManager() {
        this(GaugeManager.zzbe(), zzs.a(), a.a());
    }

    private SessionManager(GaugeManager gaugeManager, zzs zzs, a aVar) {
        this.zzfp = new HashSet();
        this.zzbk = gaugeManager;
        this.zzfq = zzs;
        this.zzcw = aVar;
        zzay();
    }

    public final void zza(ar arVar) {
        super.zza(arVar);
        if (!this.zzcw.f39185a) {
            if (arVar == ar.FOREGROUND) {
                zzc(arVar);
            } else if (!zzcn()) {
                zzd(arVar);
            }
        }
    }

    public final boolean zzcn() {
        if (!(TimeUnit.MICROSECONDS.toMinutes(this.zzfq.f39256c.b()) > FeatureControl.zzao().zzax())) {
            return false;
        }
        zzc(this.zzcw.f39187c);
        return true;
    }

    public final void zzc(ar arVar) {
        this.zzfq = zzs.a();
        synchronized (this.zzfp) {
            Iterator<WeakReference<e>> it2 = this.zzfp.iterator();
            while (it2.hasNext()) {
                e eVar = (e) it2.next().get();
                if (eVar != null) {
                    eVar.a(this.zzfq);
                } else {
                    it2.remove();
                }
            }
        }
        if (this.zzfq.f39255b) {
            this.zzbk.zzc(this.zzfq.f39254a, arVar);
        }
        zzd(arVar);
    }

    public final void zzc(WeakReference<e> weakReference) {
        synchronized (this.zzfp) {
            this.zzfp.add(weakReference);
        }
    }

    public final void zzd(WeakReference<e> weakReference) {
        synchronized (this.zzfp) {
            this.zzfp.remove(weakReference);
        }
    }

    private final void zzd(ar arVar) {
        if (this.zzfq.f39255b) {
            this.zzbk.zza(this.zzfq.f39254a, arVar);
        } else {
            this.zzbk.zzbf();
        }
    }
}
