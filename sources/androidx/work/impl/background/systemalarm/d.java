package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.WorkerParameters;
import androidx.work.impl.a.c;
import androidx.work.impl.b;
import androidx.work.impl.background.systemalarm.e;
import androidx.work.impl.utils.n;
import androidx.work.l;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class d implements c, b, n.a {

    /* renamed from: h  reason: collision with root package name */
    private static final String f5260h = l.a("DelayMetCommandHandler");

    /* renamed from: a  reason: collision with root package name */
    final Context f5261a;

    /* renamed from: b  reason: collision with root package name */
    final int f5262b;

    /* renamed from: c  reason: collision with root package name */
    final String f5263c;

    /* renamed from: d  reason: collision with root package name */
    final e f5264d;

    /* renamed from: e  reason: collision with root package name */
    final androidx.work.impl.a.d f5265e;

    /* renamed from: f  reason: collision with root package name */
    PowerManager.WakeLock f5266f;

    /* renamed from: g  reason: collision with root package name */
    boolean f5267g = false;

    /* renamed from: i  reason: collision with root package name */
    private final Object f5268i = new Object();
    private int j = 0;

    d(Context context, int i2, String str, e eVar) {
        this.f5261a = context;
        this.f5262b = i2;
        this.f5264d = eVar;
        this.f5263c = str;
        this.f5265e = new androidx.work.impl.a.d(this.f5261a, eVar.f5271c, this);
    }

    public final void a(List<String> list) {
        if (list.contains(this.f5263c)) {
            synchronized (this.f5268i) {
                if (this.j == 0) {
                    this.j = 1;
                    l.a();
                    String.format("onAllConstraintsMet for %s", new Object[]{this.f5263c});
                    if (this.f5264d.f5273e.a(this.f5263c, (WorkerParameters.a) null)) {
                        n nVar = this.f5264d.f5272d;
                        String str = this.f5263c;
                        synchronized (nVar.f5487d) {
                            l.a();
                            String.format("Starting timer for %s", new Object[]{str});
                            nVar.a(str);
                            n.b bVar = new n.b(nVar, str);
                            nVar.f5485b.put(str, bVar);
                            nVar.f5486c.put(str, this);
                            nVar.f5484a.schedule(bVar, 600000, TimeUnit.MILLISECONDS);
                        }
                    } else {
                        b();
                    }
                } else {
                    l.a();
                    String.format("Already started work for %s", new Object[]{this.f5263c});
                }
            }
        }
    }

    public final void a(String str, boolean z) {
        l.a();
        String.format("onExecuted %s, %s", new Object[]{str, Boolean.valueOf(z)});
        b();
        if (z) {
            Intent a2 = b.a(this.f5261a, this.f5263c);
            e eVar = this.f5264d;
            eVar.a((Runnable) new e.a(eVar, a2, this.f5262b));
        }
        if (this.f5267g) {
            Intent a3 = b.a(this.f5261a);
            e eVar2 = this.f5264d;
            eVar2.a((Runnable) new e.a(eVar2, a3, this.f5262b));
        }
    }

    public final void a(String str) {
        l.a();
        String.format("Exceeded time limits on execution for %s", new Object[]{str});
        a();
    }

    public final void b(List<String> list) {
        a();
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        synchronized (this.f5268i) {
            if (this.j < 2) {
                this.j = 2;
                l.a();
                String.format("Stopping work for WorkSpec %s", new Object[]{this.f5263c});
                this.f5264d.a((Runnable) new e.a(this.f5264d, b.c(this.f5261a, this.f5263c), this.f5262b));
                if (this.f5264d.f5273e.f(this.f5263c)) {
                    l.a();
                    String.format("WorkSpec %s needs to be rescheduled", new Object[]{this.f5263c});
                    this.f5264d.a((Runnable) new e.a(this.f5264d, b.a(this.f5261a, this.f5263c), this.f5262b));
                } else {
                    l.a();
                    String.format("Processor does not have WorkSpec %s. No need to reschedule ", new Object[]{this.f5263c});
                }
            } else {
                l.a();
                String.format("Already stopped work for %s", new Object[]{this.f5263c});
            }
        }
    }

    private void b() {
        synchronized (this.f5268i) {
            this.f5265e.a();
            this.f5264d.f5272d.a(this.f5263c);
            if (this.f5266f != null && this.f5266f.isHeld()) {
                l.a();
                String.format("Releasing wakelock %s for WorkSpec %s", new Object[]{this.f5266f, this.f5263c});
                this.f5266f.release();
            }
        }
    }
}
