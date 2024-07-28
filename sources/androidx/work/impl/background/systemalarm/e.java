package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.p;
import androidx.work.impl.d;
import androidx.work.impl.j;
import androidx.work.impl.utils.g;
import androidx.work.impl.utils.k;
import androidx.work.impl.utils.n;
import androidx.work.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e implements androidx.work.impl.b {

    /* renamed from: a  reason: collision with root package name */
    static final String f5269a = l.a("SystemAlarmDispatcher");

    /* renamed from: b  reason: collision with root package name */
    final Context f5270b;

    /* renamed from: c  reason: collision with root package name */
    final androidx.work.impl.utils.b.a f5271c;

    /* renamed from: d  reason: collision with root package name */
    final n f5272d;

    /* renamed from: e  reason: collision with root package name */
    final d f5273e;

    /* renamed from: f  reason: collision with root package name */
    final j f5274f;

    /* renamed from: g  reason: collision with root package name */
    final b f5275g;

    /* renamed from: h  reason: collision with root package name */
    final List<Intent> f5276h;

    /* renamed from: i  reason: collision with root package name */
    Intent f5277i;
    b j;
    private final Handler k;

    interface b {
        void a();
    }

    e(Context context) {
        this(context, (byte) 0);
    }

    private e(Context context, byte b2) {
        this.f5270b = context.getApplicationContext();
        this.f5275g = new b(this.f5270b);
        this.f5272d = new n();
        this.f5274f = j.b(context);
        this.f5273e = this.f5274f.f5364f;
        this.f5271c = this.f5274f.f5362d;
        this.f5273e.a((androidx.work.impl.b) this);
        this.f5276h = new ArrayList();
        this.f5277i = null;
        this.k = new Handler(Looper.getMainLooper());
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        l.a();
        this.f5273e.b((androidx.work.impl.b) this);
        n nVar = this.f5272d;
        if (!nVar.f5484a.isShutdown()) {
            nVar.f5484a.shutdownNow();
        }
        this.j = null;
    }

    public final void a(String str, boolean z) {
        a((Runnable) new a(this, b.a(this.f5270b, str, z), 0));
    }

    public final boolean a(Intent intent, int i2) {
        l.a();
        boolean z = false;
        String.format("Adding command %s (%s)", new Object[]{intent, Integer.valueOf(i2)});
        c();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            l.a();
            return false;
        } else if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && a("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        } else {
            intent.putExtra("KEY_START_ID", i2);
            synchronized (this.f5276h) {
                if (!this.f5276h.isEmpty()) {
                    z = true;
                }
                this.f5276h.add(intent);
                if (!z) {
                    b();
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(b bVar) {
        if (this.j != null) {
            l.a();
        } else {
            this.j = bVar;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Runnable runnable) {
        this.k.post(runnable);
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        c();
        PowerManager.WakeLock a2 = k.a(this.f5270b, "ProcessCommand");
        try {
            a2.acquire();
            this.f5274f.f5362d.a(new Runnable() {
                public final void run() {
                    e eVar;
                    c cVar;
                    WorkDatabase workDatabase;
                    synchronized (e.this.f5276h) {
                        e.this.f5277i = e.this.f5276h.get(0);
                    }
                    if (e.this.f5277i != null) {
                        String action = e.this.f5277i.getAction();
                        int intExtra = e.this.f5277i.getIntExtra("KEY_START_ID", 0);
                        l.a();
                        String str = e.f5269a;
                        String.format("Processing command %s, %s", new Object[]{e.this.f5277i, Integer.valueOf(intExtra)});
                        PowerManager.WakeLock a2 = k.a(e.this.f5270b, String.format("%s (%s)", new Object[]{action, Integer.valueOf(intExtra)}));
                        try {
                            l.a();
                            String str2 = e.f5269a;
                            String.format("Acquiring operation wake lock (%s) %s", new Object[]{action, a2});
                            a2.acquire();
                            b bVar = e.this.f5275g;
                            Intent intent = e.this.f5277i;
                            e eVar2 = e.this;
                            String action2 = intent.getAction();
                            if ("ACTION_CONSTRAINTS_CHANGED".equals(action2)) {
                                l.a();
                                String.format("Handling constraints changed %s", new Object[]{intent});
                                c cVar2 = new c(bVar.f5252a, intExtra, eVar2);
                                List<p> d2 = cVar2.f5258c.f5274f.f5361c.b().d();
                                ConstraintProxy.a(cVar2.f5256a, d2);
                                cVar2.f5259d.a((Iterable<p>) d2);
                                ArrayList<p> arrayList = new ArrayList<>(d2.size());
                                long currentTimeMillis = System.currentTimeMillis();
                                for (p next : d2) {
                                    String str3 = next.f5180a;
                                    if (currentTimeMillis >= next.c() && (!next.d() || cVar2.f5259d.a(str3))) {
                                        arrayList.add(next);
                                    }
                                }
                                for (p pVar : arrayList) {
                                    String str4 = pVar.f5180a;
                                    Intent b2 = b.b(cVar2.f5256a, str4);
                                    l.a();
                                    String.format("Creating a delay_met command for workSpec with id (%s)", new Object[]{str4});
                                    cVar2.f5258c.a((Runnable) new a(cVar2.f5258c, b2, cVar2.f5257b));
                                }
                                cVar2.f5259d.a();
                            } else if ("ACTION_RESCHEDULE".equals(action2)) {
                                l.a();
                                String.format("Handling reschedule %s, %s", new Object[]{intent, Integer.valueOf(intExtra)});
                                eVar2.f5274f.d();
                            } else if (!b.a(intent.getExtras(), "KEY_WORKSPEC_ID")) {
                                l.a();
                                String.format("Invalid request for %s, requires %s.", new Object[]{action2, "KEY_WORKSPEC_ID"});
                            } else if ("ACTION_SCHEDULE_WORK".equals(action2)) {
                                String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
                                l.a();
                                String.format("Handling schedule work for %s", new Object[]{string});
                                workDatabase = eVar2.f5274f.f5361c;
                                workDatabase.beginTransaction();
                                p b3 = workDatabase.b().b(string);
                                if (b3 == null) {
                                    l.a();
                                    StringBuilder sb = new StringBuilder("Skipping scheduling ");
                                    sb.append(string);
                                    sb.append(" because it's no longer in the DB");
                                } else if (b3.f5181b.isFinished()) {
                                    l.a();
                                    StringBuilder sb2 = new StringBuilder("Skipping scheduling ");
                                    sb2.append(string);
                                    sb2.append("because it is finished.");
                                } else {
                                    long c2 = b3.c();
                                    if (!b3.d()) {
                                        l.a();
                                        String.format("Setting up Alarms for %s at %s", new Object[]{string, Long.valueOf(c2)});
                                        a.a(bVar.f5252a, eVar2.f5274f, string, c2);
                                    } else {
                                        l.a();
                                        String.format("Opportunistically setting an alarm for %s at %s", new Object[]{string, Long.valueOf(c2)});
                                        a.a(bVar.f5252a, eVar2.f5274f, string, c2);
                                        eVar2.a((Runnable) new a(eVar2, b.a(bVar.f5252a), intExtra));
                                    }
                                    workDatabase.setTransactionSuccessful();
                                }
                                workDatabase.endTransaction();
                            } else if ("ACTION_DELAY_MET".equals(action2)) {
                                Bundle extras = intent.getExtras();
                                synchronized (bVar.f5254c) {
                                    String string2 = extras.getString("KEY_WORKSPEC_ID");
                                    l.a();
                                    String.format("Handing delay met for %s", new Object[]{string2});
                                    if (!bVar.f5253b.containsKey(string2)) {
                                        d dVar = new d(bVar.f5252a, intExtra, string2, eVar2);
                                        bVar.f5253b.put(string2, dVar);
                                        dVar.f5266f = k.a(dVar.f5261a, String.format("%s (%s)", new Object[]{dVar.f5263c, Integer.valueOf(dVar.f5262b)}));
                                        l.a();
                                        String.format("Acquiring wakelock %s for WorkSpec %s", new Object[]{dVar.f5266f, dVar.f5263c});
                                        dVar.f5266f.acquire();
                                        p b4 = dVar.f5264d.f5274f.f5361c.b().b(dVar.f5263c);
                                        if (b4 == null) {
                                            dVar.a();
                                        } else {
                                            dVar.f5267g = b4.d();
                                            if (!dVar.f5267g) {
                                                l.a();
                                                String.format("No constraints for %s", new Object[]{dVar.f5263c});
                                                dVar.a((List<String>) Collections.singletonList(dVar.f5263c));
                                            } else {
                                                dVar.f5265e.a((Iterable<p>) Collections.singletonList(b4));
                                            }
                                        }
                                    } else {
                                        l.a();
                                        String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", new Object[]{string2});
                                    }
                                }
                            } else if ("ACTION_STOP_WORK".equals(action2)) {
                                String string3 = intent.getExtras().getString("KEY_WORKSPEC_ID");
                                l.a();
                                String.format("Handing stopWork work for %s", new Object[]{string3});
                                eVar2.f5274f.d(string3);
                                a.a(bVar.f5252a, eVar2.f5274f, string3);
                                eVar2.a(string3, false);
                            } else if ("ACTION_EXECUTION_COMPLETED".equals(action2)) {
                                Bundle extras2 = intent.getExtras();
                                String string4 = extras2.getString("KEY_WORKSPEC_ID");
                                boolean z = extras2.getBoolean("KEY_NEEDS_RESCHEDULE");
                                l.a();
                                String.format("Handling onExecutionCompleted %s, %s", new Object[]{intent, Integer.valueOf(intExtra)});
                                bVar.a(string4, z);
                            } else {
                                l.a();
                                String.format("Ignoring intent %s", new Object[]{intent});
                            }
                            l.a();
                            String str5 = e.f5269a;
                            String.format("Releasing operation wake lock (%s) %s", new Object[]{action, a2});
                            a2.release();
                            eVar = e.this;
                            cVar = new c(eVar);
                        } catch (Throwable th) {
                            try {
                                l.a();
                                String str6 = e.f5269a;
                                new Throwable[1][0] = th;
                                l.a();
                                String str7 = e.f5269a;
                                String.format("Releasing operation wake lock (%s) %s", new Object[]{action, a2});
                                a2.release();
                                eVar = e.this;
                                cVar = new c(eVar);
                            } catch (Throwable th2) {
                                l.a();
                                String str8 = e.f5269a;
                                String.format("Releasing operation wake lock (%s) %s", new Object[]{action, a2});
                                a2.release();
                                e eVar3 = e.this;
                                eVar3.a((Runnable) new c(eVar3));
                                throw th2;
                            }
                        }
                        eVar.a((Runnable) cVar);
                    }
                }
            });
        } finally {
            a2.release();
        }
    }

    private boolean a(String str) {
        c();
        synchronized (this.f5276h) {
            for (Intent action : this.f5276h) {
                if (str.equals(action.getAction())) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        if (this.k.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final e f5282a;

        c(e eVar) {
            this.f5282a = eVar;
        }

        public final void run() {
            e eVar = this.f5282a;
            l.a();
            eVar.c();
            synchronized (eVar.f5276h) {
                if (eVar.f5277i != null) {
                    l.a();
                    String.format("Removing command %s", new Object[]{eVar.f5277i});
                    if (eVar.f5276h.remove(0).equals(eVar.f5277i)) {
                        eVar.f5277i = null;
                    } else {
                        throw new IllegalStateException("Dequeue-d command is not the first.");
                    }
                }
                g b2 = eVar.f5271c.b();
                if (!eVar.f5275g.a() && eVar.f5276h.isEmpty() && !b2.b()) {
                    l.a();
                    if (eVar.j != null) {
                        eVar.j.a();
                    }
                } else if (!eVar.f5276h.isEmpty()) {
                    eVar.b();
                }
            }
        }
    }

    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final e f5279a;

        /* renamed from: b  reason: collision with root package name */
        private final Intent f5280b;

        /* renamed from: c  reason: collision with root package name */
        private final int f5281c;

        a(e eVar, Intent intent, int i2) {
            this.f5279a = eVar;
            this.f5280b = intent;
            this.f5281c = i2;
        }

        public final void run() {
            this.f5279a.a(this.f5280b, this.f5281c);
        }
    }
}
