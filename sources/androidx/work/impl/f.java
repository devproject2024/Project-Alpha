package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.work.b;
import androidx.work.impl.b.p;
import androidx.work.impl.b.q;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.utils.e;
import androidx.work.l;
import java.util.List;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5311a = l.a("Schedulers");

    /* JADX INFO: finally extract failed */
    public static void a(b bVar, WorkDatabase workDatabase, List<e> list) {
        if (list != null && list.size() != 0) {
            q b2 = workDatabase.b();
            workDatabase.beginTransaction();
            try {
                List<p> a2 = b2.a(bVar.a());
                List<p> c2 = b2.c();
                if (a2.size() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (p pVar : a2) {
                        b2.b(pVar.f5180a, currentTimeMillis);
                    }
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                if (a2.size() > 0) {
                    p[] pVarArr = (p[]) a2.toArray(new p[a2.size()]);
                    for (e next : list) {
                        if (next.a()) {
                            next.a(pVarArr);
                        }
                    }
                }
                if (c2.size() > 0) {
                    p[] pVarArr2 = (p[]) c2.toArray(new p[c2.size()]);
                    for (e next2 : list) {
                        if (!next2.a()) {
                            next2.a(pVarArr2);
                        }
                    }
                }
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    static e a(Context context, j jVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            androidx.work.impl.background.systemjob.b bVar = new androidx.work.impl.background.systemjob.b(context, jVar);
            e.a(context, SystemJobService.class, true);
            l.a();
            return bVar;
        }
        e a2 = a(context);
        if (a2 != null) {
            return a2;
        }
        androidx.work.impl.background.systemalarm.f fVar = new androidx.work.impl.background.systemalarm.f(context);
        e.a(context, SystemAlarmService.class, true);
        l.a();
        return fVar;
    }

    private static e a(Context context) {
        try {
            e eVar = (e) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
            l.a();
            String.format("Created %s", new Object[]{"androidx.work.impl.background.gcm.GcmScheduler"});
            return eVar;
        } catch (Throwable th) {
            l.a();
            new Throwable[1][0] = th;
            return null;
        }
    }
}
