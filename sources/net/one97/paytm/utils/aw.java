package net.one97.paytm.utils;

import android.content.Context;
import android.os.StatFs;
import java.io.File;

public final class aw {
    public static long a(Context context) {
        long j;
        final File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        new Thread() {
            public final void run() {
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
        }.start();
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 50;
        } catch (IllegalArgumentException unused) {
            j = 5242880;
        }
        return Math.max(Math.min(j, 52428800), 5242880);
    }
}
