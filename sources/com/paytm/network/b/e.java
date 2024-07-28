package com.paytm.network.b;

import android.os.StatFs;
import java.io.File;

public final class e {
    public static long a(File file) {
        long j;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 50;
        } catch (IllegalArgumentException unused) {
            j = 10485760;
        }
        return Math.max(Math.min(j, 104857600), 31457280);
    }
}
