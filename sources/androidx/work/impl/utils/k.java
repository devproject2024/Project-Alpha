package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.l;
import java.util.HashMap;
import java.util.WeakHashMap;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5466a = l.a("WakeLocks");

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<PowerManager.WakeLock, String> f5467b = new WeakHashMap<>();

    public static PowerManager.WakeLock a(Context context, String str) {
        String concat = "WorkManager: ".concat(String.valueOf(str));
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getApplicationContext().getSystemService("power")).newWakeLock(1, concat);
        synchronized (f5467b) {
            f5467b.put(newWakeLock, concat);
        }
        return newWakeLock;
    }

    public static void a() {
        HashMap hashMap = new HashMap();
        synchronized (f5467b) {
            hashMap.putAll(f5467b);
        }
        for (PowerManager.WakeLock wakeLock : hashMap.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                String.format("WakeLock held for %s", new Object[]{hashMap.get(wakeLock)});
                l.a();
            }
        }
    }
}
