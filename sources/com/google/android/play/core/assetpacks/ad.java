package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.b.b;
import com.google.android.play.core.b.bg;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

final class ad {

    /* renamed from: a  reason: collision with root package name */
    static final b f36951a = new b("AssetPackStorage");

    /* renamed from: c  reason: collision with root package name */
    private static final long f36952c = TimeUnit.DAYS.toMillis(14);

    /* renamed from: d  reason: collision with root package name */
    private static final long f36953d = TimeUnit.DAYS.toMillis(28);

    /* renamed from: b  reason: collision with root package name */
    final cg f36954b;

    /* renamed from: e  reason: collision with root package name */
    private final Context f36955e;

    ad(Context context, cg cgVar) {
        this.f36955e = context;
        this.f36954b = cgVar;
    }

    private final File a(String str, int i2) {
        return new File(a(str), String.valueOf(i2));
    }

    static void a(File file) {
        if (file.listFiles() != null && file.listFiles().length > 1) {
            long b2 = b(file);
            for (File file2 : file.listFiles()) {
                if (!file2.getName().equals(String.valueOf(b2)) && !file2.getName().equals("stale.tmp")) {
                    c(file2);
                }
            }
        }
    }

    static long b(File file) {
        if (file.exists()) {
            ArrayList arrayList = new ArrayList();
            try {
                for (File file2 : file.listFiles()) {
                    if (!file2.getName().equals("stale.tmp")) {
                        arrayList.add(Long.valueOf(file2.getName()));
                    }
                }
            } catch (NumberFormatException unused) {
                f36951a.c("Corrupt asset pack directories.", new Object[0]);
            }
            if (!arrayList.isEmpty()) {
                Collections.sort(arrayList);
                return ((Long) arrayList.get(arrayList.size() - 1)).longValue();
            }
        }
        return -1;
    }

    static boolean c(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            boolean z2 = true;
            for (File c2 : listFiles) {
                if (!c(c2)) {
                    z2 = false;
                }
            }
            z = z2;
        }
        if (file.delete()) {
            return z;
        }
        return false;
    }

    private final File d() {
        return new File(c(), "_tmp");
    }

    private String d(String str) throws IOException {
        int length;
        File file = new File(c(), str);
        if (!file.exists()) {
            f36951a.a("Pack not found with pack name: %s", str);
            return null;
        }
        File file2 = new File(file, String.valueOf(this.f36954b.a()));
        if (!file2.exists()) {
            f36951a.a("Pack not found with pack name: %s app version: %s", str, Integer.valueOf(this.f36954b.a()));
            return null;
        }
        File[] listFiles = file2.listFiles();
        if (listFiles == null || (length = listFiles.length) == 0) {
            f36951a.a("No pack version found for pack name: %s app version: %s", str, Integer.valueOf(this.f36954b.a()));
            return null;
        } else if (length <= 1) {
            return listFiles[0].getCanonicalPath();
        } else {
            f36951a.b("Multiple pack versions found for pack name: %s app version: %s", str, Integer.valueOf(this.f36954b.a()));
            return null;
        }
    }

    private final File h(String str, int i2, long j) {
        return new File(new File(new File(d(), str), String.valueOf(i2)), String.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final File a(String str) {
        return new File(c(), str);
    }

    /* access modifiers changed from: package-private */
    public final File a(String str, int i2, long j) {
        return new File(a(str, i2), String.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final File a(String str, int i2, long j, String str2) {
        return new File(new File(new File(h(str, i2, j), "_slices"), "_unverified"), str2);
    }

    /* access modifiers changed from: package-private */
    public final int b(String str) {
        return (int) b(a(str));
    }

    /* access modifiers changed from: package-private */
    public final File b(String str, int i2, long j) {
        return new File(a(str, i2, j), "_metadata");
    }

    /* access modifiers changed from: package-private */
    public final File b(String str, int i2, long j, String str2) {
        return new File(new File(new File(h(str, i2, j), "_slices"), "_verified"), str2);
    }

    /* access modifiers changed from: package-private */
    public final List<File> b() {
        ArrayList arrayList = new ArrayList();
        try {
            if (!c().exists() || c().listFiles() == null) {
                return arrayList;
            }
            for (File file : c().listFiles()) {
                if (!file.getCanonicalPath().equals(d().getCanonicalPath())) {
                    arrayList.add(file);
                }
            }
            return arrayList;
        } catch (IOException e2) {
            f36951a.b("Could not process directory while scanning installed packs. %s", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final long c(String str) {
        return b(a(str, b(str)));
    }

    /* access modifiers changed from: package-private */
    public final File c() {
        return new File(this.f36955e.getFilesDir(), "assetpacks");
    }

    /* access modifiers changed from: package-private */
    public final File c(String str, int i2, long j) {
        return new File(h(str, i2, j), "_packs");
    }

    /* access modifiers changed from: package-private */
    public final File c(String str, int i2, long j, String str2) {
        return new File(f(str, i2, j, str2), "checkpoint.dat");
    }

    /* access modifiers changed from: package-private */
    public final File d(String str, int i2, long j) {
        return new File(c(str, i2, j), "merge.tmp");
    }

    /* access modifiers changed from: package-private */
    public final File d(String str, int i2, long j, String str2) {
        return new File(f(str, i2, j, str2), "checkpoint_ext.dat");
    }

    /* access modifiers changed from: package-private */
    public final int e(String str, int i2, long j) throws IOException {
        File d2 = d(str, i2, j);
        if (!d2.exists()) {
            return 0;
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(d2);
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("numberOfMerges") != null) {
                try {
                    return Integer.parseInt(properties.getProperty("numberOfMerges"));
                } catch (NumberFormatException e2) {
                    throw new ax("Merge checkpoint file corrupt.", (Exception) e2);
                }
            } else {
                throw new ax("Merge checkpoint file corrupt.");
            }
        } catch (Throwable th) {
            bg.a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    public final File e(String str, int i2, long j, String str2) {
        return new File(f(str, i2, j, str2), "slice.zip");
    }

    /* access modifiers changed from: package-private */
    public final File f(String str, int i2, long j) {
        return new File(new File(h(str, i2, j), "_slices"), "_metadata");
    }

    /* access modifiers changed from: package-private */
    public final File f(String str, int i2, long j, String str2) {
        return new File(f(str, i2, j), str2);
    }

    /* access modifiers changed from: package-private */
    public final void g(String str, int i2, long j) {
        if (h(str, i2, j).exists()) {
            c(h(str, i2, j));
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004a A[Catch:{ IOException -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x000f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, com.google.android.play.core.assetpacks.b> a() {
        /*
            r8 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1 = 0
            r2 = 1
            java.util.List r3 = r8.b()     // Catch:{ IOException -> 0x0052 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ IOException -> 0x0052 }
        L_0x000f:
            boolean r4 = r3.hasNext()     // Catch:{ IOException -> 0x0052 }
            if (r4 == 0) goto L_0x005e
            java.lang.Object r4 = r3.next()     // Catch:{ IOException -> 0x0052 }
            java.io.File r4 = (java.io.File) r4     // Catch:{ IOException -> 0x0052 }
            java.lang.String r5 = r4.getName()     // Catch:{ IOException -> 0x0052 }
            java.lang.String r5 = r8.d(r5)     // Catch:{ IOException -> 0x0052 }
            if (r5 == 0) goto L_0x0047
            java.io.File r6 = new java.io.File     // Catch:{ IOException -> 0x0052 }
            java.lang.String r7 = "assets"
            r6.<init>(r5, r7)     // Catch:{ IOException -> 0x0052 }
            boolean r7 = r6.isDirectory()     // Catch:{ IOException -> 0x0052 }
            if (r7 != 0) goto L_0x003e
            com.google.android.play.core.b.b r5 = f36951a     // Catch:{ IOException -> 0x0052 }
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x0052 }
            r7[r1] = r6     // Catch:{ IOException -> 0x0052 }
            java.lang.String r6 = "Failed to find assets directory: %s"
            r5.b(r6, r7)     // Catch:{ IOException -> 0x0052 }
            goto L_0x0047
        L_0x003e:
            java.lang.String r6 = r6.getCanonicalPath()     // Catch:{ IOException -> 0x0052 }
            com.google.android.play.core.assetpacks.b r5 = com.google.android.play.core.assetpacks.b.a(r5, r6)     // Catch:{ IOException -> 0x0052 }
            goto L_0x0048
        L_0x0047:
            r5 = 0
        L_0x0048:
            if (r5 == 0) goto L_0x000f
            java.lang.String r4 = r4.getName()     // Catch:{ IOException -> 0x0052 }
            r0.put(r4, r5)     // Catch:{ IOException -> 0x0052 }
            goto L_0x000f
        L_0x0052:
            r3 = move-exception
            com.google.android.play.core.b.b r4 = f36951a
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r1] = r3
            java.lang.String r1 = "Could not process directory while scanning installed packs: %s"
            r4.b(r1, r2)
        L_0x005e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.ad.a():java.util.Map");
    }
}
