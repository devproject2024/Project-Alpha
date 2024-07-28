package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.work.l;
import java.io.File;
import java.util.HashMap;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5357a = l.a("WrkDbPathHelper");

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f5358b = {"-journal", "-shm", "-wal"};

    public static String a() {
        return "androidx.work.workdb";
    }

    public static void a(Context context) {
        File file;
        File databasePath = context.getDatabasePath("androidx.work.workdb");
        if (Build.VERSION.SDK_INT >= 23 && databasePath.exists()) {
            l.a();
            HashMap hashMap = new HashMap();
            if (Build.VERSION.SDK_INT >= 23) {
                File databasePath2 = context.getDatabasePath("androidx.work.workdb");
                if (Build.VERSION.SDK_INT < 23) {
                    file = context.getDatabasePath("androidx.work.workdb");
                } else {
                    file = new File(context.getNoBackupFilesDir(), "androidx.work.workdb");
                }
                hashMap.put(databasePath2, file);
                for (String str : f5358b) {
                    hashMap.put(new File(databasePath2.getPath() + str), new File(file.getPath() + str));
                }
            }
            for (File file2 : hashMap.keySet()) {
                File file3 = (File) hashMap.get(file2);
                if (file2.exists() && file3 != null) {
                    if (file3.exists()) {
                        String.format("Over-writing contents of %s", new Object[]{file3});
                        l.a();
                    }
                    if (file2.renameTo(file3)) {
                        String.format("Migrated %s to %s", new Object[]{file2, file3});
                    } else {
                        String.format("Renaming %s to %s failed", new Object[]{file2, file3});
                    }
                    l.a();
                }
            }
        }
    }
}
