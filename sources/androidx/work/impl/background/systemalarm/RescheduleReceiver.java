package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.impl.j;
import androidx.work.l;

public class RescheduleReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5246a = l.a("RescheduleReceiver");

    public void onReceive(Context context, Intent intent) {
        l.a();
        String.format("Received intent %s", new Object[]{intent});
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                j.b(context).a(goAsync());
            } catch (IllegalStateException unused) {
                l.a();
            }
        } else {
            context.startService(b.b(context));
        }
    }
}
