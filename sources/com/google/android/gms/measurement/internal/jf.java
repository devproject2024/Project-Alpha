package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import com.google.android.gms.common.util.e;
import com.google.android.gms.internal.measurement.fr;

public final class jf extends jg {

    /* renamed from: a  reason: collision with root package name */
    private final AlarmManager f12257a = ((AlarmManager) k().getSystemService("alarm"));

    /* renamed from: c  reason: collision with root package name */
    private final g f12258c;

    /* renamed from: d  reason: collision with root package name */
    private Integer f12259d;

    protected jf(jj jjVar) {
        super(jjVar);
        this.f12258c = new jd(this, jjVar.f12266b, jjVar);
    }

    /* access modifiers changed from: protected */
    public final boolean a() {
        this.f12257a.cancel(u());
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        s();
        return false;
    }

    private final void s() {
        int t = t();
        J_().k.a("Cancelling job. JobID", Integer.valueOf(t));
        ((JobScheduler) k().getSystemService("jobscheduler")).cancel(t);
    }

    public final void a(long j) {
        w();
        Context k = k();
        if (!er.a(k)) {
            J_().j.a("Receiver not registered/enabled");
        }
        if (!jq.a(k)) {
            J_().j.a("Service not registered/enabled");
        }
        b();
        long b2 = j().b() + j;
        if (j < Math.max(0, o.x.a(null).longValue()) && !this.f12258c.b()) {
            J_().k.a("Scheduling upload with DelayedRunnable");
            this.f12258c.a(j);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            J_().k.a("Scheduling upload with JobScheduler");
            Context k2 = k();
            ComponentName componentName = new ComponentName(k2, "com.google.android.gms.measurement.AppMeasurementJobService");
            int t = t();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            JobInfo build = new JobInfo.Builder(t, componentName).setMinimumLatency(j).setOverrideDeadline(j << 1).setExtras(persistableBundle).build();
            J_().k.a("Scheduling job. JobID", Integer.valueOf(t));
            fr.a(k2, build, "com.google.android.gms", "UploadAlarm");
            return;
        }
        J_().k.a("Scheduling upload with AlarmManager");
        this.f12257a.setInexactRepeating(2, b2, Math.max(o.s.a(null).longValue(), j), u());
    }

    private final int t() {
        if (this.f12259d == null) {
            String valueOf = String.valueOf(k().getPackageName());
            this.f12259d = Integer.valueOf((valueOf.length() != 0 ? "measurement".concat(valueOf) : new String("measurement")).hashCode());
        }
        return this.f12259d.intValue();
    }

    public final void b() {
        w();
        this.f12257a.cancel(u());
        this.f12258c.c();
        if (Build.VERSION.SDK_INT >= 24) {
            s();
        }
    }

    private final PendingIntent u() {
        Context k = k();
        return PendingIntent.getBroadcast(k, 0, new Intent().setClassName(k, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
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
