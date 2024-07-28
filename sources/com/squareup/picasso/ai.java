package com.squareup.picasso;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import i.e;
import i.f;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadFactory;

final class ai {

    /* renamed from: a  reason: collision with root package name */
    static final StringBuilder f45386a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    private static final f f45387b = f.encodeUtf8("RIFF");

    /* renamed from: c  reason: collision with root package name */
    private static final f f45388c = f.encodeUtf8("WEBP");

    static int a(Bitmap bitmap) {
        int allocationByteCount = Build.VERSION.SDK_INT >= 19 ? bitmap.getAllocationByteCount() : bitmap.getByteCount();
        if (allocationByteCount >= 0) {
            return allocationByteCount;
        }
        throw new IllegalStateException("Negative size: ".concat(String.valueOf(bitmap)));
    }

    static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static void a() {
        if (c()) {
            throw new IllegalStateException("Method call should not happen from the main thread.");
        }
    }

    static void b() {
        if (!c()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    private static boolean c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    static String a(c cVar) {
        return a(cVar, "");
    }

    static String a(c cVar, String str) {
        StringBuilder sb = new StringBuilder(str);
        a aVar = cVar.k;
        if (aVar != null) {
            sb.append(aVar.f45342b.a());
        }
        List<a> list = cVar.l;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 > 0 || aVar != null) {
                    sb.append(", ");
                }
                sb.append(list.get(i2).f45342b.a());
            }
        }
        return sb.toString();
    }

    static void a(String str, String str2, String str3) {
        a(str, str2, str3, "");
    }

    static void a(String str, String str2, String str3, String str4) {
        String.format("%1$-11s %2$-12s %3$s %4$s", new Object[]{str, str2, str3, str4});
    }

    static String a(z zVar) {
        String a2 = a(zVar, f45386a);
        f45386a.setLength(0);
        return a2;
    }

    static String a(z zVar, StringBuilder sb) {
        if (zVar.f45481f != null) {
            sb.ensureCapacity(zVar.f45481f.length() + 50);
            sb.append(zVar.f45481f);
        } else if (zVar.f45479d != null) {
            String uri = zVar.f45479d.toString();
            sb.ensureCapacity(uri.length() + 50);
            sb.append(uri);
        } else {
            sb.ensureCapacity(50);
            sb.append(zVar.f45480e);
        }
        sb.append(10);
        if (zVar.n != 0.0f) {
            sb.append("rotation:");
            sb.append(zVar.n);
            if (zVar.q) {
                sb.append('@');
                sb.append(zVar.o);
                sb.append('x');
                sb.append(zVar.p);
            }
            sb.append(10);
        }
        if (zVar.c()) {
            sb.append("resize:");
            sb.append(zVar.f45483h);
            sb.append('x');
            sb.append(zVar.f45484i);
            sb.append(10);
        }
        if (zVar.j) {
            sb.append("centerCrop:");
            sb.append(zVar.k);
            sb.append(10);
        } else if (zVar.l) {
            sb.append("centerInside\n");
        }
        if (zVar.f45482g != null) {
            int size = zVar.f45482g.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(zVar.f45482g.get(i2).key());
                sb.append(10);
            }
        }
        return sb.toString();
    }

    static File a(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    static long a(File file) {
        long j;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j = ((Build.VERSION.SDK_INT < 18 ? (long) statFs.getBlockCount() : statFs.getBlockCountLong()) * (Build.VERSION.SDK_INT < 18 ? (long) statFs.getBlockSize() : statFs.getBlockSizeLong())) / 50;
        } catch (IllegalArgumentException unused) {
            j = 5242880;
        }
        return Math.max(Math.min(j, 52428800), 5242880);
    }

    static boolean c(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            if (Build.VERSION.SDK_INT < 17) {
                if (Settings.System.getInt(contentResolver, "airplane_mode_on", 0) != 0) {
                    return true;
                }
                return false;
            } else if (Settings.Global.getInt(contentResolver, "airplane_mode_on", 0) != 0) {
                return true;
            } else {
                return false;
            }
        } catch (NullPointerException | SecurityException unused) {
        }
    }

    static <T> T a(Context context, String str) {
        return context.getSystemService(str);
    }

    static boolean b(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    static boolean a(e eVar) throws IOException {
        return eVar.a(0, f45387b) && eVar.a(8, f45388c);
    }

    static int a(Resources resources, z zVar) throws FileNotFoundException {
        if (zVar.f45480e != 0 || zVar.f45479d == null) {
            return zVar.f45480e;
        }
        String authority = zVar.f45479d.getAuthority();
        if (authority != null) {
            List<String> pathSegments = zVar.f45479d.getPathSegments();
            if (pathSegments == null || pathSegments.isEmpty()) {
                throw new FileNotFoundException("No path segments: " + zVar.f45479d);
            } else if (pathSegments.size() == 1) {
                try {
                    return Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Last path segment is not a resource ID: " + zVar.f45479d);
                }
            } else if (pathSegments.size() == 2) {
                return resources.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + zVar.f45479d);
            }
        } else {
            throw new FileNotFoundException("No package provided: " + zVar.f45479d);
        }
    }

    static Resources a(Context context, z zVar) throws FileNotFoundException {
        if (zVar.f45480e != 0 || zVar.f45479d == null) {
            return context.getResources();
        }
        String authority = zVar.f45479d.getAuthority();
        if (authority != null) {
            try {
                return context.getPackageManager().getResourcesForApplication(authority);
            } catch (PackageManager.NameNotFoundException unused) {
                throw new FileNotFoundException("Unable to obtain resources for package: " + zVar.f45479d);
            }
        } else {
            throw new FileNotFoundException("No package provided: " + zVar.f45479d);
        }
    }

    static void a(Looper looper) {
        AnonymousClass1 r0 = new Handler(looper) {
            public final void handleMessage(Message message) {
                sendMessageDelayed(obtainMessage(), 1000);
            }
        };
        r0.sendMessageDelayed(r0.obtainMessage(), 1000);
    }

    static class b implements ThreadFactory {
        b() {
        }

        public final Thread newThread(Runnable runnable) {
            return new a(runnable);
        }
    }

    static class a extends Thread {
        a(Runnable runnable) {
            super(runnable);
        }

        public final void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    static int b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        return (int) ((((long) ((context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass())) * 1048576) / 7);
    }
}
