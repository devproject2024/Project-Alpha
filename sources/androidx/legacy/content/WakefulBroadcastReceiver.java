package androidx.legacy.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.SparseArray;

@Deprecated
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final SparseArray<PowerManager.WakeLock> f3575a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private static int f3576b = 1;

    public static ComponentName a_(Context context, Intent intent) {
        synchronized (f3575a) {
            int i2 = f3576b;
            int i3 = f3576b + 1;
            f3576b = i3;
            if (i3 <= 0) {
                f3576b = 1;
            }
            intent.putExtra("androidx.contentpager.content.wakelockid", i2);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "androidx.core:wake:" + startService.flattenToShortString());
            newWakeLock.setReferenceCounted(false);
            newWakeLock.acquire(60000);
            f3575a.put(i2, newWakeLock);
            return startService;
        }
    }

    public static boolean a(Intent intent) {
        int intExtra = intent.getIntExtra("androidx.contentpager.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        synchronized (f3575a) {
            PowerManager.WakeLock wakeLock = f3575a.get(intExtra);
            if (wakeLock == null) {
                return true;
            }
            wakeLock.release();
            f3575a.remove(intExtra);
            return true;
        }
    }
}
