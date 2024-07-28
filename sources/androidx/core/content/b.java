package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.util.TypedValue;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2824a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static TypedValue f2825b;

    public static boolean a(Context context, Intent[] intentArr) {
        if (Build.VERSION.SDK_INT >= 16) {
            context.startActivities(intentArr, (Bundle) null);
            return true;
        }
        context.startActivities(intentArr);
        return true;
    }

    public static void a(Context context, Intent intent, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            context.startActivity(intent, bundle);
        } else {
            context.startActivity(intent);
        }
    }

    public static File[] a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return context.getExternalFilesDirs((String) null);
        }
        return new File[]{context.getExternalFilesDir((String) null)};
    }

    public static File[] b(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return context.getExternalCacheDirs();
        }
        return new File[]{context.getExternalCacheDir()};
    }

    public static Drawable a(Context context, int i2) {
        int i3;
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getDrawable(i2);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return context.getResources().getDrawable(i2);
        }
        synchronized (f2824a) {
            if (f2825b == null) {
                f2825b = new TypedValue();
            }
            context.getResources().getValue(i2, f2825b, true);
            i3 = f2825b.resourceId;
        }
        return context.getResources().getDrawable(i3);
    }

    public static ColorStateList b(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i2);
        }
        return context.getResources().getColorStateList(i2);
    }

    public static int c(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColor(i2);
        }
        return context.getResources().getColor(i2);
    }

    public static int a(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static File c(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getNoBackupFilesDir();
        }
        return a(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.io.File a(java.io.File r3) {
        /*
            java.lang.Class<androidx.core.content.b> r0 = androidx.core.content.b.class
            monitor-enter(r0)
            boolean r1 = r3.exists()     // Catch:{ all -> 0x002a }
            if (r1 != 0) goto L_0x0028
            boolean r1 = r3.mkdirs()     // Catch:{ all -> 0x002a }
            if (r1 != 0) goto L_0x0028
            boolean r1 = r3.exists()     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0017
            monitor-exit(r0)
            return r3
        L_0x0017:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
            java.lang.String r2 = "Unable to create files subdir "
            r1.<init>(r2)     // Catch:{ all -> 0x002a }
            java.lang.String r3 = r3.getPath()     // Catch:{ all -> 0x002a }
            r1.append(r3)     // Catch:{ all -> 0x002a }
            r3 = 0
            monitor-exit(r0)
            return r3
        L_0x0028:
            monitor-exit(r0)
            return r3
        L_0x002a:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.b.a(java.io.File):java.io.File");
    }

    public static Context d(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext();
        }
        return null;
    }

    public static boolean e(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.isDeviceProtectedStorage();
        }
        return false;
    }

    public static Executor f(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return context.getMainExecutor();
        }
        return new a(new Handler(context.getMainLooper()));
    }

    static class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f2826a;

        a(Handler handler) {
            this.f2826a = handler;
        }

        public final void execute(Runnable runnable) {
            if (!this.f2826a.post(runnable)) {
                throw new RejectedExecutionException(this.f2826a + " is shutting down");
            }
        }
    }

    public static void a(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }
}
