package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.g;
import androidx.work.impl.b.h;
import androidx.work.impl.j;
import androidx.work.impl.utils.c;
import androidx.work.l;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5250a = l.a("Alarms");

    private static void a(Context context, String str, int i2) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i2, b.b(context, str), 536870912);
        if (service != null && alarmManager != null) {
            l.a();
            String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", new Object[]{str, Integer.valueOf(i2)});
            alarmManager.cancel(service);
        }
    }

    private static void a(Context context, String str, int i2, long j) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i2, b.b(context, str), 134217728);
        if (alarmManager == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            alarmManager.setExact(0, j, service);
        } else {
            alarmManager.set(0, j, service);
        }
    }

    public static void a(Context context, j jVar, String str, long j) {
        WorkDatabase workDatabase = jVar.f5361c;
        h e2 = workDatabase.e();
        g a2 = e2.a(str);
        if (a2 != null) {
            a(context, str, a2.f5160b);
            a(context, str, a2.f5160b, j);
            return;
        }
        int a3 = new c(workDatabase).a();
        e2.a(new g(str, a3));
        a(context, str, a3, j);
    }

    public static void a(Context context, j jVar, String str) {
        h e2 = jVar.f5361c.e();
        g a2 = e2.a(str);
        if (a2 != null) {
            a(context, str, a2.f5160b);
            l.a();
            String.format("Removing SystemIdInfo for workSpecId (%s)", new Object[]{str});
            e2.b(str);
        }
    }
}
