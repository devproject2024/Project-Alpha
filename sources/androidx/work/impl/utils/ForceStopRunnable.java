package androidx.work.impl.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.d;
import androidx.work.impl.b.n;
import androidx.work.impl.b.p;
import androidx.work.impl.b.q;
import androidx.work.impl.background.systemjob.b;
import androidx.work.impl.f;
import androidx.work.impl.i;
import androidx.work.impl.j;
import androidx.work.l;
import androidx.work.u;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class ForceStopRunnable implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5392a = l.a("ForceStopRunnable");

    /* renamed from: b  reason: collision with root package name */
    private static final long f5393b = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: c  reason: collision with root package name */
    private final Context f5394c;

    /* renamed from: d  reason: collision with root package name */
    private final j f5395d;

    public ForceStopRunnable(Context context, j jVar) {
        this.f5394c = context.getApplicationContext();
        this.f5395d = jVar;
    }

    public final void run() {
        boolean z;
        i.a(this.f5394c);
        l.a();
        try {
            boolean a2 = a();
            Long a3 = this.f5395d.f5365g.f5449a.h().a("reschedule_needed");
            if (a3 != null && a3.longValue() == 1) {
                l.a();
                this.f5395d.d();
                this.f5395d.f5365g.f5449a.h().a(new d("reschedule_needed"));
            } else {
                if (a(this.f5394c, 536870912) == null) {
                    a(this.f5394c);
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    l.a();
                    this.f5395d.d();
                } else if (a2) {
                    l.a();
                    f.a(this.f5395d.f5360b, this.f5395d.f5361c, this.f5395d.f5363e);
                }
            }
            this.f5395d.e();
        } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteDatabaseCorruptException e2) {
            l.a();
            new Throwable[1][0] = e2;
            throw new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
        }
    }

    private boolean a() {
        if (Build.VERSION.SDK_INT >= 23) {
            b.b(this.f5394c);
        }
        WorkDatabase workDatabase = this.f5395d.f5361c;
        q b2 = workDatabase.b();
        n g2 = workDatabase.g();
        workDatabase.beginTransaction();
        try {
            List<p> e2 = b2.e();
            boolean z = !e2.isEmpty();
            if (z) {
                for (p next : e2) {
                    b2.a(u.a.ENQUEUED, next.f5180a);
                    b2.b(next.f5180a, -1);
                }
            }
            g2.a();
            workDatabase.setTransactionSuccessful();
            return z;
        } finally {
            workDatabase.endTransaction();
        }
    }

    private static PendingIntent a(Context context, int i2) {
        return PendingIntent.getBroadcast(context, -1, b(context), i2);
    }

    private static Intent b(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    static void a(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent a2 = a(context, 134217728);
        long currentTimeMillis = System.currentTimeMillis() + f5393b;
        if (alarmManager == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            alarmManager.setExact(0, currentTimeMillis, a2);
        } else {
            alarmManager.set(0, currentTimeMillis, a2);
        }
    }

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private static final String f5396a = l.a("ForceStopRunnable$Rcvr");

        public void onReceive(Context context, Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                l.a();
                ForceStopRunnable.a(context);
            }
        }
    }
}
