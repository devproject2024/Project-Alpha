package com.alibaba.wireless.security.a;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.alibaba.wireless.security.a.a.b;
import com.alibaba.wireless.security.a.a.d;
import com.alibaba.wireless.security.a.a.e;
import com.alipay.mobile.h5container.api.H5Param;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class h implements c {
    private static String[] n = {"armeabi", "armeabi-v7a", "x86", "arm64-v8a", "x86_64"};
    private static String o = null;
    private static volatile boolean p = true;

    /* renamed from: a  reason: collision with root package name */
    public Context f14624a;

    /* renamed from: b  reason: collision with root package name */
    HashMap<Class, Object> f14625b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    d f14626c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f14627d = true;

    /* renamed from: e  reason: collision with root package name */
    public String f14628e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f14629f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14630g = false;

    /* renamed from: h  reason: collision with root package name */
    private final HashMap<String, g> f14631h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private a f14632i = null;
    private f j = null;
    private File k = null;
    private File l = null;
    private File m = null;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        File f14633a;

        /* renamed from: b  reason: collision with root package name */
        File f14634b;

        /* renamed from: c  reason: collision with root package name */
        File f14635c;

        /* renamed from: d  reason: collision with root package name */
        boolean f14636d;

        public a(File file, File file2, File file3, boolean z) {
            this.f14633a = file;
            this.f14634b = file2;
            this.f14635c = file3;
            this.f14636d = z;
        }
    }

    private static int a(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int length = split.length < split2.length ? split.length : split2.length;
        for (int i2 = 0; i2 < length; i2++) {
            int parseInt = Integer.parseInt(split[i2]);
            int parseInt2 = Integer.parseInt(split2[i2]);
            if (parseInt > parseInt2) {
                return 1;
            }
            if (parseInt < parseInt2) {
                return -1;
            }
        }
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0080 A[SYNTHETIC, Splitter:B:29:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0087 A[SYNTHETIC, Splitter:B:35:0x0087] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.File a(java.lang.String r12, java.io.File r13) {
        /*
            r11 = this;
            r0 = 0
            android.content.Context r1 = r11.f14624a     // Catch:{ Exception -> 0x000a }
            android.content.pm.ApplicationInfo r1 = r1.getApplicationInfo()     // Catch:{ Exception -> 0x000a }
            java.lang.String r1 = r1.sourceDir     // Catch:{ Exception -> 0x000a }
            goto L_0x000b
        L_0x000a:
            r1 = r0
        L_0x000b:
            if (r1 != 0) goto L_0x000e
            return r0
        L_0x000e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "libsg"
            r2.<init>(r3)
            r2.append(r12)
            java.lang.String r3 = ".so"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.alibaba.wireless.security.a.a.b.b()     // Catch:{ IOException -> 0x0065, all -> 0x0062 }
            java.util.zip.ZipFile r3 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x0065, all -> 0x0062 }
            r3.<init>(r1)     // Catch:{ IOException -> 0x0065, all -> 0x0062 }
            java.lang.String[] r4 = n     // Catch:{ IOException -> 0x0060 }
            int r5 = r4.length     // Catch:{ IOException -> 0x0060 }
            r6 = 0
        L_0x002d:
            if (r6 >= r5) goto L_0x005c
            r7 = r4[r6]     // Catch:{ IOException -> 0x0060 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0060 }
            java.lang.String r9 = "lib"
            r8.<init>(r9)     // Catch:{ IOException -> 0x0060 }
            java.lang.String r9 = java.io.File.separator     // Catch:{ IOException -> 0x0060 }
            r8.append(r9)     // Catch:{ IOException -> 0x0060 }
            r8.append(r7)     // Catch:{ IOException -> 0x0060 }
            java.lang.String r9 = java.io.File.separator     // Catch:{ IOException -> 0x0060 }
            r8.append(r9)     // Catch:{ IOException -> 0x0060 }
            r8.append(r2)     // Catch:{ IOException -> 0x0060 }
            java.lang.String r8 = r8.toString()     // Catch:{ IOException -> 0x0060 }
            java.util.zip.ZipEntry r9 = r3.getEntry(r8)     // Catch:{ IOException -> 0x0060 }
            if (r9 == 0) goto L_0x0059
            o = r7     // Catch:{ IOException -> 0x0060 }
            java.io.File r0 = a((java.lang.String) r12, (java.io.File) r13, (java.util.zip.ZipFile) r3, (java.lang.String) r8)     // Catch:{ IOException -> 0x0060 }
            goto L_0x005c
        L_0x0059:
            int r6 = r6 + 1
            goto L_0x002d
        L_0x005c:
            r3.close()     // Catch:{ Exception -> 0x005f }
        L_0x005f:
            return r0
        L_0x0060:
            r13 = move-exception
            goto L_0x0067
        L_0x0062:
            r12 = move-exception
            r3 = r0
            goto L_0x0085
        L_0x0065:
            r13 = move-exception
            r3 = r0
        L_0x0067:
            com.alibaba.wireless.security.a.a.b.c()     // Catch:{ all -> 0x0084 }
            r4 = 100047(0x186cf, float:1.40196E-40)
            r5 = 3
            java.lang.String r6 = r13.toString()     // Catch:{ all -> 0x0084 }
            java.lang.String r8 = c((java.lang.String) r1)     // Catch:{ all -> 0x0084 }
            java.lang.String r9 = ""
            java.lang.String r10 = ""
            r7 = r12
            a(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0084 }
            if (r3 == 0) goto L_0x0083
            r3.close()     // Catch:{ Exception -> 0x0083 }
        L_0x0083:
            return r0
        L_0x0084:
            r12 = move-exception
        L_0x0085:
            if (r3 == 0) goto L_0x008a
            r3.close()     // Catch:{ Exception -> 0x008a }
        L_0x008a:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.a.h.a(java.lang.String, java.io.File):java.io.File");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        if (r1 != null) goto L_0x0012;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003b A[SYNTHETIC, Splitter:B:21:0x003b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.File a(java.lang.String r9, java.io.File r10, java.lang.String r11, java.lang.String r12) {
        /*
            r0 = 0
            if (r11 == 0) goto L_0x003f
            if (r12 != 0) goto L_0x0006
            goto L_0x003f
        L_0x0006:
            com.alibaba.wireless.security.a.a.b.b()     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
            r1.<init>(r11)     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
            java.io.File r0 = a((java.lang.String) r9, (java.io.File) r10, (java.util.zip.ZipFile) r1, (java.lang.String) r12)     // Catch:{ IOException -> 0x0016 }
        L_0x0012:
            r1.close()     // Catch:{ Exception -> 0x0037 }
            goto L_0x0037
        L_0x0016:
            r10 = move-exception
            goto L_0x001d
        L_0x0018:
            r9 = move-exception
            r1 = r0
            goto L_0x0039
        L_0x001b:
            r10 = move-exception
            r1 = r0
        L_0x001d:
            com.alibaba.wireless.security.a.a.b.c()     // Catch:{ all -> 0x0038 }
            r2 = 100047(0x186cf, float:1.40196E-40)
            r3 = 3
            java.lang.String r4 = r10.toString()     // Catch:{ all -> 0x0038 }
            java.lang.String r6 = c((java.lang.String) r11)     // Catch:{ all -> 0x0038 }
            java.lang.String r7 = ""
            java.lang.String r8 = ""
            r5 = r9
            a(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0038 }
            if (r1 == 0) goto L_0x0037
            goto L_0x0012
        L_0x0037:
            return r0
        L_0x0038:
            r9 = move-exception
        L_0x0039:
            if (r1 == 0) goto L_0x003e
            r1.close()     // Catch:{ Exception -> 0x003e }
        L_0x003e:
            throw r9
        L_0x003f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.a.h.a(java.lang.String, java.io.File, java.lang.String, java.lang.String):java.io.File");
    }

    private static File a(String str, File file, ZipFile zipFile, String str2) throws IOException {
        ZipEntry entry;
        File file2 = null;
        if (!(str2 == null || (entry = zipFile.getEntry(str2)) == null)) {
            new StringBuilder("Plugin existed  in ").append(entry.getName());
            b.b();
            File file3 = new File(file, "libsg" + str + "_inner" + entry.getTime() + ".zip");
            if ((file3.exists() && file3.length() == entry.getSize()) || e.a(zipFile, entry, file3)) {
                file2 = file3;
            }
            b.b();
        }
        return file2;
    }

    private static Class<?> a(ClassLoader classLoader, String str) {
        Class<?> cls;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            cls = Class.forName(str, true, classLoader);
        } catch (Throwable th) {
            a(100042, 199, "Class.forName failed", String.valueOf(th), str, classLoader.toString(), "");
            cls = null;
        }
        StringBuilder sb = new StringBuilder("    loadClassFromClassLoader( ");
        sb.append(str);
        sb.append(" ) used time: ");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        sb.append(" ms");
        b.b();
        return cls;
    }

    private static void a(int i2, int i3, String str, String str2, String str3, String str4, String str5) {
        com.alibaba.wireless.security.a.a.a.a(String.valueOf(i2), i3, com.alibaba.wireless.security.b.e.e.a(), str, str2, str3, str4, str5);
    }

    /* access modifiers changed from: private */
    public void a(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String file2 : list) {
                a(new File(file, file2));
            }
        }
        file.delete();
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ba A[SYNTHETIC, Splitter:B:40:0x00ba] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c3 A[SYNTHETIC, Splitter:B:45:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00cf A[SYNTHETIC, Splitter:B:52:0x00cf] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d8 A[SYNTHETIC, Splitter:B:57:0x00d8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(java.io.File r14, java.io.File r15) {
        /*
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r15.getAbsolutePath()
            r0.append(r3)
            java.lang.String r3 = ".tmp."
            r0.append(r3)
            int r3 = android.os.Process.myPid()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            r3 = 0
            r4 = 0
            boolean r0 = r2.exists()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            if (r0 == 0) goto L_0x002c
            r2.delete()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
        L_0x002c:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            r0.<init>(r14)     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            java.nio.channels.FileChannel r12 = r0.getChannel()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            java.nio.channels.FileChannel r13 = r0.getChannel()     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            r8 = 0
            long r10 = r12.size()     // Catch:{ Exception -> 0x007e, all -> 0x007c }
            r6 = r13
            r7 = r12
            r6.transferFrom(r7, r8, r10)     // Catch:{ Exception -> 0x007e, all -> 0x007c }
            r12.close()     // Catch:{ Exception -> 0x007e, all -> 0x007c }
            r13.close()     // Catch:{ Exception -> 0x007a }
            long r6 = r2.length()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            long r8 = r14.length()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 != 0) goto L_0x0076
            boolean r0 = r15.exists()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            if (r0 == 0) goto L_0x0072
            long r6 = r15.length()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            long r8 = r14.length()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 != 0) goto L_0x006f
            r3 = 1
            goto L_0x0076
        L_0x006f:
            r15.delete()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
        L_0x0072:
            boolean r3 = r2.renameTo(r15)     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
        L_0x0076:
            r2.delete()
            goto L_0x00cb
        L_0x007a:
            r0 = move-exception
            goto L_0x008d
        L_0x007c:
            r0 = move-exception
            goto L_0x0082
        L_0x007e:
            r0 = move-exception
            goto L_0x0086
        L_0x0080:
            r0 = move-exception
            r13 = r4
        L_0x0082:
            r4 = r12
            goto L_0x00cd
        L_0x0084:
            r0 = move-exception
            r13 = r4
        L_0x0086:
            r4 = r12
            goto L_0x008d
        L_0x0088:
            r0 = move-exception
            r13 = r4
            goto L_0x00cd
        L_0x008b:
            r0 = move-exception
            r13 = r4
        L_0x008d:
            com.alibaba.wireless.security.a.a.b.c()     // Catch:{ all -> 0x00cc }
            r6 = 100047(0x186cf, float:1.40196E-40)
            r7 = 2
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00cc }
            java.lang.String r5 = r14.getAbsolutePath()     // Catch:{ all -> 0x00cc }
            java.lang.String r8 = c((java.lang.String) r5)     // Catch:{ all -> 0x00cc }
            java.lang.String r1 = r15.getAbsolutePath()     // Catch:{ all -> 0x00cc }
            java.lang.String r9 = c((java.lang.String) r1)     // Catch:{ all -> 0x00cc }
            java.lang.String r1 = r2.getAbsolutePath()     // Catch:{ all -> 0x00cc }
            java.lang.String r10 = c((java.lang.String) r1)     // Catch:{ all -> 0x00cc }
            java.lang.String r11 = ""
            r5 = r6
            r6 = r7
            r7 = r0
            a(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x00cc }
            if (r4 == 0) goto L_0x00c1
            r4.close()     // Catch:{ Exception -> 0x00be }
            goto L_0x00c1
        L_0x00be:
            com.alibaba.wireless.security.a.a.b.c()
        L_0x00c1:
            if (r13 == 0) goto L_0x0076
            r13.close()     // Catch:{ Exception -> 0x00c7 }
            goto L_0x0076
        L_0x00c7:
            com.alibaba.wireless.security.a.a.b.c()
            goto L_0x0076
        L_0x00cb:
            return r3
        L_0x00cc:
            r0 = move-exception
        L_0x00cd:
            if (r4 == 0) goto L_0x00d6
            r4.close()     // Catch:{ Exception -> 0x00d3 }
            goto L_0x00d6
        L_0x00d3:
            com.alibaba.wireless.security.a.a.b.c()
        L_0x00d6:
            if (r13 == 0) goto L_0x00df
            r13.close()     // Catch:{ Exception -> 0x00dc }
            goto L_0x00df
        L_0x00dc:
            com.alibaba.wireless.security.a.a.b.c()
        L_0x00df:
            r2.delete()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.a.h.a(java.io.File, java.io.File):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0053, code lost:
        return true;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x0103 */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00c9 A[Catch:{ all -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00d2 A[Catch:{ all -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00d7 A[Catch:{ all -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e0 A[Catch:{ all -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00eb A[SYNTHETIC, Splitter:B:81:0x00eb] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f2 A[SYNTHETIC, Splitter:B:84:0x00f2] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00f9 A[SYNTHETIC, Splitter:B:90:0x00f9] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0100 A[SYNTHETIC, Splitter:B:93:0x0100] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean a(java.lang.String r16, java.lang.String r17, java.io.File r18, java.lang.String r19, boolean r20) {
        /*
            r15 = this;
            r1 = r15
            r0 = r19
            monitor-enter(r15)
            android.content.Context r2 = r1.f14624a     // Catch:{ all -> 0x0104 }
            boolean r2 = com.alibaba.wireless.security.a.a.e.a(r2)     // Catch:{ all -> 0x0104 }
            r3 = 1
            if (r2 == 0) goto L_0x0015
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0104 }
            r4 = 19
            if (r2 <= r4) goto L_0x0015
            monitor-exit(r15)
            return r3
        L_0x0015:
            java.lang.String r2 = r1.f14628e     // Catch:{ all -> 0x0104 }
            if (r2 == 0) goto L_0x001b
            monitor-exit(r15)
            return r3
        L_0x001b:
            if (r18 == 0) goto L_0x0033
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0104 }
            java.lang.String r4 = r18.getParent()     // Catch:{ all -> 0x0104 }
            r2.<init>(r4, r0)     // Catch:{ all -> 0x0104 }
            boolean r2 = r2.exists()     // Catch:{ all -> 0x0104 }
            if (r2 == 0) goto L_0x002e
            monitor-exit(r15)
            return r3
        L_0x002e:
            java.lang.String r2 = r18.getAbsolutePath()     // Catch:{ all -> 0x0104 }
            goto L_0x0035
        L_0x0033:
            r2 = r16
        L_0x0035:
            if (r20 != 0) goto L_0x003c
            com.alibaba.wireless.security.a.a.d r4 = r1.f14626c     // Catch:{ all -> 0x0104 }
            r4.a()     // Catch:{ all -> 0x0104 }
        L_0x003c:
            r4 = 0
            r5 = 0
            java.io.File r6 = new java.io.File     // Catch:{ IOException -> 0x00b4 }
            r7 = r17
            r6.<init>(r7, r0)     // Catch:{ IOException -> 0x00b4 }
            boolean r7 = r6.exists()     // Catch:{ IOException -> 0x00af }
            if (r7 == 0) goto L_0x0054
            if (r20 != 0) goto L_0x0052
            com.alibaba.wireless.security.a.a.d r0 = r1.f14626c     // Catch:{ all -> 0x0104 }
            r0.b()     // Catch:{ all -> 0x0104 }
        L_0x0052:
            monitor-exit(r15)
            return r3
        L_0x0054:
            java.util.zip.ZipFile r3 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x00af }
            r3.<init>(r2)     // Catch:{ IOException -> 0x00af }
            java.lang.String[] r5 = n     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            int r7 = r5.length     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            r8 = 0
        L_0x005d:
            if (r8 >= r7) goto L_0x009f
            r9 = r5[r8]     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            java.lang.String r11 = "lib"
            r10.<init>(r11)     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            java.lang.String r11 = java.io.File.separator     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            r10.append(r11)     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            r10.append(r9)     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            java.lang.String r9 = java.io.File.separator     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            r10.append(r9)     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            r10.append(r0)     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            java.lang.String r9 = r10.toString()     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            java.util.zip.ZipEntry r9 = r3.getEntry(r9)     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            if (r9 == 0) goto L_0x009c
            long r10 = r9.getSize()     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            r12 = 0
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 == 0) goto L_0x009c
            boolean r0 = com.alibaba.wireless.security.a.a.e.a((java.util.zip.ZipFile) r3, (java.util.zip.ZipEntry) r9, (java.io.File) r6)     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            if (r20 != 0) goto L_0x0097
            com.alibaba.wireless.security.a.a.d r2 = r1.f14626c     // Catch:{ all -> 0x0104 }
            r2.b()     // Catch:{ all -> 0x0104 }
        L_0x0097:
            r3.close()     // Catch:{ IOException -> 0x009a }
        L_0x009a:
            monitor-exit(r15)
            return r0
        L_0x009c:
            int r8 = r8 + 1
            goto L_0x005d
        L_0x009f:
            if (r20 != 0) goto L_0x00a6
            com.alibaba.wireless.security.a.a.d r0 = r1.f14626c     // Catch:{ all -> 0x0104 }
            r0.b()     // Catch:{ all -> 0x0104 }
        L_0x00a6:
            r3.close()     // Catch:{ IOException -> 0x00f5 }
            goto L_0x00f5
        L_0x00aa:
            r0 = move-exception
            goto L_0x00f7
        L_0x00ac:
            r0 = move-exception
            r5 = r3
            goto L_0x00b6
        L_0x00af:
            r0 = move-exception
            goto L_0x00b6
        L_0x00b1:
            r0 = move-exception
            r3 = r5
            goto L_0x00f7
        L_0x00b4:
            r0 = move-exception
            r6 = r5
        L_0x00b6:
            r7 = 100039(0x186c7, float:1.40184E-40)
            r8 = 107(0x6b, float:1.5E-43)
            java.lang.String r9 = r0.toString()     // Catch:{ all -> 0x00b1 }
            java.lang.String r10 = r15.d()     // Catch:{ all -> 0x00b1 }
            java.lang.String r11 = c((java.lang.String) r2)     // Catch:{ all -> 0x00b1 }
            if (r6 == 0) goto L_0x00d2
            java.lang.String r0 = r6.getAbsolutePath()     // Catch:{ all -> 0x00b1 }
            java.lang.String r0 = c((java.lang.String) r0)     // Catch:{ all -> 0x00b1 }
            goto L_0x00d4
        L_0x00d2:
            java.lang.String r0 = ""
        L_0x00d4:
            r12 = r0
            if (r18 == 0) goto L_0x00e0
            java.lang.String r0 = r18.getAbsolutePath()     // Catch:{ all -> 0x00b1 }
            java.lang.String r0 = c((java.lang.String) r0)     // Catch:{ all -> 0x00b1 }
            goto L_0x00e2
        L_0x00e0:
            java.lang.String r0 = ""
        L_0x00e2:
            r13 = r0
            a(r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x00b1 }
            com.alibaba.wireless.security.a.a.b.c()     // Catch:{ all -> 0x00b1 }
            if (r20 != 0) goto L_0x00f0
            com.alibaba.wireless.security.a.a.d r0 = r1.f14626c     // Catch:{ all -> 0x0104 }
            r0.b()     // Catch:{ all -> 0x0104 }
        L_0x00f0:
            if (r5 == 0) goto L_0x00f5
            r5.close()     // Catch:{ IOException -> 0x00f5 }
        L_0x00f5:
            monitor-exit(r15)
            return r4
        L_0x00f7:
            if (r20 != 0) goto L_0x00fe
            com.alibaba.wireless.security.a.a.d r2 = r1.f14626c     // Catch:{ all -> 0x0104 }
            r2.b()     // Catch:{ all -> 0x0104 }
        L_0x00fe:
            if (r3 == 0) goto L_0x0103
            r3.close()     // Catch:{ IOException -> 0x0103 }
        L_0x0103:
            throw r0     // Catch:{ all -> 0x0104 }
        L_0x0104:
            r0 = move-exception
            monitor-exit(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.a.h.a(java.lang.String, java.lang.String, java.io.File, java.lang.String, boolean):boolean");
    }

    /* access modifiers changed from: private */
    public boolean a(String str, String str2, boolean z) throws com.alibaba.wireless.security.b.b {
        String str3 = str2;
        if (str.trim().length() == 0) {
            return true;
        }
        String[] split = str.split(";");
        for (int i2 = 0; i2 < split.length; i2++) {
            String trim = split[i2].trim();
            if (trim.length() != 0) {
                String[] split2 = trim.split(AppConstants.COLON);
                if (split2.length == 2) {
                    int indexOf = str3.indexOf(split2[0]);
                    if (indexOf >= 0) {
                        int indexOf2 = str3.indexOf("(", indexOf);
                        int indexOf3 = str3.indexOf(")", indexOf);
                        if (indexOf2 < 0 || indexOf3 < 0 || indexOf2 > indexOf3) {
                            a(100040, 199, "indexLeftP < 0 || indexRightP < 0 || indexLeftP > indexRightP", String.valueOf(indexOf2), String.valueOf(indexOf3), "", String.valueOf(i2));
                            throw new com.alibaba.wireless.security.b.b(199);
                        }
                        String substring = str3.substring(indexOf2 + 1, indexOf3);
                        if (a(substring, split2[1]) < 0) {
                            String str4 = "version " + substring + " of " + split2[0] + " is not meet the requirement: " + split2[1];
                            if (str2.length() != 0) {
                                str4 = str4 + ", depended by: " + str3;
                            }
                            if (!z) {
                                a(100040, 113, "versionCompare(parentPluginVersion, nameVersionPair[1]) < 0", substring, split2[0], split2[1], String.valueOf(i2));
                            }
                            throw new com.alibaba.wireless.security.b.b(str4, 113);
                        }
                    } else {
                        b bVar = this.f14631h.get(split2[0]);
                        if (bVar == null) {
                            try {
                                bVar = c(split2[0], str3, !z);
                                th = null;
                            } catch (Throwable th) {
                                th = th;
                            }
                            if (bVar == null) {
                                if (!z) {
                                    if (th instanceof com.alibaba.wireless.security.b.b) {
                                        throw th;
                                    }
                                    a(100040, 199, "throwable in loadPluginInner", String.valueOf(th), str, str2, String.valueOf(i2));
                                    throw new com.alibaba.wireless.security.b.b(str3, 199);
                                }
                            }
                        }
                        if (a(bVar.a(), split2[1]) < 0) {
                            String str5 = "version " + bVar.a() + " of " + split2[0] + " is not meet the requirement: " + split2[1];
                            if (str2.length() != 0) {
                                str5 = str5 + ", depended by: " + str3;
                            }
                            if (!z) {
                                a(100040, 113, "versionCompare(dependPlugin.getVersion(), nameVersionPair[1]) < 0", bVar.a(), split2[0], split2[1], String.valueOf(i2));
                            }
                            throw new com.alibaba.wireless.security.b.b(str5, 113);
                        }
                    }
                } else {
                    a(100040, 199, "nameVersionPair.length != 2", trim, str2, String.valueOf(z), String.valueOf(i2));
                    throw new com.alibaba.wireless.security.b.b(199);
                }
            }
        }
        return true;
    }

    private DexClassLoader b(String str, String str2, boolean z) {
        if (!z) {
            try {
                this.f14626c.a();
            } catch (Throwable th) {
                if (!z) {
                    this.f14626c.b();
                }
                throw th;
            }
        }
        String str3 = this.f14624a.getApplicationInfo().nativeLibraryDir + File.pathSeparator + str2;
        if (this.f14628e != null) {
            str3 = str3 + File.pathSeparator + this.f14628e;
            b.b();
        }
        if (o != null) {
            str3 = str3 + File.pathSeparator + this.f14624a.getApplicationInfo().sourceDir + "!/lib/" + o;
        }
        DexClassLoader dexClassLoader = new DexClassLoader(str, str2, str3, h.class.getClassLoader());
        if (!z) {
            this.f14626c.b();
        }
        return dexClassLoader;
    }

    private File b(String str) {
        String str2 = this.f14628e;
        if (str2 == null) {
            try {
                str2 = this.f14624a.getApplicationInfo().nativeLibraryDir;
            } catch (Exception unused) {
            }
        }
        if (str2 != null && str2.length() > 0) {
            File file = new File(str2 + File.separator + "libsg" + str + ".so");
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    public static String b() {
        return "main";
    }

    private static boolean b(File file) {
        try {
            if (!file.getParentFile().getCanonicalPath().equals(file.getCanonicalFile().getParentFile().getCanonicalPath())) {
                return true;
            }
            return true ^ file.getName().equals(file.getCanonicalFile().getName());
        } catch (Exception e2) {
            b.c();
            a(100047, 0, e2.toString(), file.getAbsolutePath(), "", "", "");
            return false;
        }
    }

    private static boolean b(File file, File file2) {
        Method method;
        try {
            Object obj = null;
            if (Build.VERSION.SDK_INT >= 21) {
                method = Class.forName("android.system.Os").getDeclaredMethod("symlink", new Class[]{String.class, String.class});
            } else {
                Field declaredField = Class.forName("libcore.io.Libcore").getDeclaredField("os");
                declaredField.setAccessible(true);
                obj = declaredField.get((Object) null);
                method = obj.getClass().getMethod("symlink", new Class[]{String.class, String.class});
            }
            method.invoke(obj, new Object[]{file.getAbsolutePath(), file2.getAbsolutePath()});
            return true;
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder("create symbolic link( ");
            sb.append(file2.getAbsolutePath());
            sb.append(" -> ");
            sb.append(file.getAbsolutePath());
            sb.append(" ) failed");
            b.c();
            String exc = e2.toString();
            String absolutePath = file.getAbsolutePath();
            String absolutePath2 = file2.getAbsolutePath();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Build.VERSION.SDK_INT);
            a(100047, 1, exc, absolutePath, absolutePath2, sb2.toString(), "");
            return false;
        }
    }

    private f c() {
        f fVar;
        File file = new File(this.k, "update.config");
        File file2 = new File(this.k, "init.config");
        if (this.f14630g) {
            fVar = f.a(file);
            if (fVar == null) {
                return f.a(file2);
            }
            try {
                this.f14626c.a();
                file2.delete();
                file.renameTo(file2);
            } catch (Throwable th) {
                this.f14626c.b();
                throw th;
            }
        } else {
            try {
                this.f14626c.a();
                fVar = f.a(file2);
            } catch (Throwable th2) {
                this.f14626c.b();
                throw th2;
            }
        }
        this.f14626c.b();
        return fVar;
    }

    private static String c(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (b(file)) {
            sb.append("->");
            try {
                sb.append(file.getCanonicalPath());
            } catch (Exception unused) {
            }
        }
        sb.append('[');
        sb.append("exists:" + file.exists() + AppConstants.COMMA);
        sb.append("size:" + file.length() + AppConstants.COMMA);
        sb.append("canRead:" + file.canRead() + AppConstants.COMMA);
        sb.append("canWrite:" + file.canWrite() + AppConstants.COMMA);
        sb.append("totalSpace:" + file.getTotalSpace() + AppConstants.COMMA);
        sb.append("freeSpace:" + file.getFreeSpace() + AppConstants.COMMA);
        sb.append(']');
        return sb.toString();
    }

    private boolean c(File file) {
        if (file != null) {
            try {
                String absolutePath = file.getAbsolutePath();
                if (absolutePath != null) {
                    if (absolutePath.length() > 0) {
                        if (e.a(this.f14624a) || !absolutePath.startsWith("/system/")) {
                            return true;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static boolean c(File file, File file2) {
        try {
            return file.getCanonicalPath().equals(file2.getCanonicalPath());
        } catch (Exception e2) {
            b.c();
            a(100046, 0, e2.toString(), file.getAbsolutePath(), file2.getAbsolutePath(), "", "");
            return false;
        }
    }

    private File d(File file) {
        if (!file.exists() || !file.isDirectory() || !this.f14630g) {
            return file;
        }
        File file2 = new File(file, "main");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2.exists() ? file2 : file;
    }

    private String d() {
        StringBuilder sb = new StringBuilder();
        File file = this.k;
        if (file == null || !file.exists() || !file.isDirectory()) {
            sb.append("not exists!");
        } else {
            try {
                sb.append("[");
                File[] listFiles = file.listFiles();
                int i2 = 0;
                while (listFiles != null && i2 < listFiles.length) {
                    File file2 = listFiles[i2];
                    if (file2.getName().startsWith("libsg") && (file2.getName().endsWith("zip") || file2.getName().endsWith(".so"))) {
                        sb.append(file2.getName());
                        sb.append("(");
                        sb.append(b(file2) + " , ");
                        sb.append(file2.length());
                        sb.append(") , ");
                    }
                    i2++;
                }
                sb.append("]");
            } catch (Throwable unused) {
            }
        }
        return sb.toString();
    }

    public final b a(String str) throws com.alibaba.wireless.security.b.b {
        return c(str, "", true);
    }

    public final void a() throws com.alibaba.wireless.security.b.b {
        this.k = a(this.f14624a);
        if (this.k != null) {
            this.f14626c = new d(this.k + File.separator + "lock.lock");
            this.j = c();
            Context context = this.f14624a;
            f fVar = this.j;
            File file = null;
            if (!(e.a(context) || fVar == null || fVar.a() == 0 || fVar.b() == null || fVar.b().length() <= 0)) {
                File file2 = new File(this.k.getAbsolutePath() + File.separator + "libs" + File.separator + fVar.a() + File.separator + fVar.b());
                if (file2.exists()) {
                    file = file2;
                }
            }
            this.m = file;
        }
    }

    private File a(Context context) throws com.alibaba.wireless.security.b.b {
        if (context != null) {
            String str = null;
            if (context != null) {
                try {
                    String str2 = context.getApplicationInfo().sourceDir;
                    if (str2 != null) {
                        File file = new File(str2);
                        if (file.exists()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(file.lastModified() / 1000);
                            str = sb.toString();
                        }
                    }
                } catch (Exception e2) {
                    a(100038, 115, "", String.valueOf(e2), "", "", "");
                    throw new com.alibaba.wireless.security.b.b((Throwable) e2, 115);
                }
            }
            if (str != null) {
                this.l = context.getDir("SGLib", 0);
                File file2 = this.l;
                if (file2 == null || !file2.exists()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.l);
                    a(100038, 109, "", sb2.toString(), "", "", "");
                    throw new com.alibaba.wireless.security.b.b(109);
                }
                File file3 = new File(this.l.getAbsolutePath(), "app_".concat(String.valueOf(str)));
                if (!file3.exists()) {
                    file3.mkdirs();
                    if (!file3.exists()) {
                        file3.mkdirs();
                    }
                    if (p) {
                        p = false;
                        new Thread(new i(this, this.l, "app_".concat(String.valueOf(str)))).start();
                    }
                }
                if (file3.exists()) {
                    return file3;
                }
                a(100038, 114, "", "", "", "", "");
                throw new com.alibaba.wireless.security.b.b(114);
            }
            throw new com.alibaba.wireless.security.b.b(115);
        }
        a(100038, 116, "", "", "", "", "");
        throw new com.alibaba.wireless.security.b.b(116);
    }

    private boolean b(String str, String str2) throws com.alibaba.wireless.security.b.b {
        for (Map.Entry next : this.f14631h.entrySet()) {
            String str3 = (String) next.getKey();
            g gVar = (g) next.getValue();
            String a2 = gVar.a("reversedependencies");
            if (a2 != null) {
                String[] split = a2.split(";");
                for (int i2 = 0; i2 < split.length; i2++) {
                    String trim = split[i2].trim();
                    if (trim.length() != 0) {
                        String[] split2 = trim.split(AppConstants.COLON);
                        if (split2.length != 2) {
                            a(100041, 199, "nameVersionPair.length != 2", str + "(" + str2 + ")", str3 + "(" + gVar.f14619b.versionName + ")", c(gVar.f14618a), a2);
                            throw new com.alibaba.wireless.security.b.b(199);
                        } else if (split2[0].equalsIgnoreCase(str) && a(str2, split2[1]) < 0) {
                            String str4 = "plugin " + str + "(" + str2 + ") is not meet the reverse dependency of " + str3 + "(" + gVar.f14619b.versionName + "): " + split2[0] + "(" + split2[1] + ")";
                            a(100041, 117, str4, h.class.getClassLoader().toString(), c(gVar.f14618a), a2, String.valueOf(i2));
                            throw new com.alibaba.wireless.security.b.b(str4, 117);
                        }
                    }
                }
                continue;
            }
        }
        return true;
    }

    /* JADX WARNING: type inference failed for: r15v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r15v3 */
    /* JADX WARNING: type inference failed for: r15v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0398, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0399, code lost:
        r28 = r4;
        r30 = r6;
        r31 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x03c4, code lost:
        r22 = r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x03d3, code lost:
        if (r35.length() == 0) goto L_0x03d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x03d5, code lost:
        r23 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03d8, code lost:
        r23 = r11 + r31 + r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x03f0, code lost:
        if (r10.f14635c != null) goto L_0x03f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x03f2, code lost:
        r2 = new java.lang.StringBuilder("src:");
        r2.append(c(r10.f14635c.getAbsolutePath()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0405, code lost:
        r2 = new java.lang.StringBuilder("zipfile:");
        r2.append(c(r10.f14633a.getAbsolutePath()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0417, code lost:
        a(100043, 103, "", r22, r23, r2.toString(), c(r1.getAbsolutePath()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x042a, code lost:
        if (r10.f14636d == false) goto L_0x042c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x042c, code lost:
        r8.f14626c.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0435, code lost:
        if (r1.exists() != false) goto L_0x0437;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0437, code lost:
        r1.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x043c, code lost:
        if (r10.f14636d == false) goto L_0x043e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x043e, code lost:
        r8.f14626c.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x044f, code lost:
        a(100043, 199, "native exception occurred", r0.toString(), "soName=" + r3 + ", authCode=" + r8.f14629f + ", errorCode=" + r0.getErrorCode(), c(r10.f14633a.getAbsolutePath()), c(r1.getAbsolutePath()));
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x03c4 A[Catch:{ b -> 0x04a2, all -> 0x0444, all -> 0x0034, all -> 0x0505 }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x044f A[Catch:{ b -> 0x04a2, all -> 0x0444, all -> 0x0034, all -> 0x0505 }] */
    /* JADX WARNING: Removed duplicated region for block: B:148:? A[ExcHandler: IllegalAccessException | InstantiationException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:80:0x030f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.alibaba.wireless.security.a.g a(java.lang.String r33, com.alibaba.wireless.security.a.h.a r34, java.lang.String r35) throws com.alibaba.wireless.security.b.b {
        /*
            r32 = this;
            r8 = r32
            r9 = r33
            r10 = r34
            r11 = r35
            java.lang.String r12 = "so-"
            java.lang.String r13 = "src:"
            java.lang.String r14 = "zipfile:"
            java.lang.String r15 = ""
            java.io.File r0 = r10.f14633a
            java.lang.String r7 = r0.getAbsolutePath()
            java.io.File r0 = r10.f14634b
            java.lang.String r6 = r0.getAbsolutePath()
            r16 = 0
            r17 = 0
            android.content.Context r0 = r8.f14624a     // Catch:{ all -> 0x0034 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x0034 }
            r1 = 133(0x85, float:1.86E-43)
            android.content.pm.PackageInfo r0 = r0.getPackageArchiveInfo(r7, r1)     // Catch:{ all -> 0x0034 }
            r19 = r6
            r20 = r7
            goto L_0x0087
        L_0x0034:
            r0 = move-exception
            r1 = 100043(0x186cb, float:1.4019E-40)
            r2 = 199(0xc7, float:2.79E-43)
            java.lang.String r3 = "getPackageArchiveInfo failed"
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0505 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            r0.<init>()     // Catch:{ all -> 0x0505 }
            java.io.File r5 = r10.f14633a     // Catch:{ all -> 0x0505 }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ all -> 0x0505 }
            r0.append(r5)     // Catch:{ all -> 0x0505 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0505 }
            java.lang.String r5 = c((java.lang.String) r0)     // Catch:{ all -> 0x0505 }
            java.io.File r0 = r10.f14635c     // Catch:{ all -> 0x0505 }
            if (r0 == 0) goto L_0x0065
            java.io.File r0 = r10.f14635c     // Catch:{ all -> 0x0505 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0505 }
            java.lang.String r0 = c((java.lang.String) r0)     // Catch:{ all -> 0x0505 }
            goto L_0x0066
        L_0x0065:
            r0 = r15
        L_0x0066:
            r19 = r6
            r6 = r0
            r20 = r7
            r7 = r35
            a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0505 }
            java.io.File r0 = r10.f14633a     // Catch:{ all -> 0x0505 }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x0505 }
            if (r0 == 0) goto L_0x0085
            java.io.File r0 = r10.f14633a     // Catch:{ all -> 0x0505 }
            boolean r0 = b((java.io.File) r0)     // Catch:{ all -> 0x0505 }
            if (r0 != 0) goto L_0x0085
            java.io.File r0 = r10.f14633a     // Catch:{ all -> 0x0505 }
            r0.delete()     // Catch:{ all -> 0x0505 }
        L_0x0085:
            r0 = r16
        L_0x0087:
            r7 = 199(0xc7, float:2.79E-43)
            if (r0 != 0) goto L_0x00d2
            r21 = 100043(0x186cb, float:1.4019E-40)
            r22 = 199(0xc7, float:2.79E-43)
            java.lang.String r23 = "packageInfo == null"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            r0.<init>()     // Catch:{ all -> 0x0505 }
            r0.append(r9)     // Catch:{ all -> 0x0505 }
            java.lang.String r1 = "["
            r0.append(r1)     // Catch:{ all -> 0x0505 }
            r0.append(r11)     // Catch:{ all -> 0x0505 }
            java.lang.String r1 = "]"
            r0.append(r1)     // Catch:{ all -> 0x0505 }
            java.lang.String r24 = r0.toString()     // Catch:{ all -> 0x0505 }
            java.io.File r0 = r10.f14633a     // Catch:{ all -> 0x0505 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0505 }
            java.lang.String r25 = c((java.lang.String) r0)     // Catch:{ all -> 0x0505 }
            java.io.File r0 = r10.f14635c     // Catch:{ all -> 0x0505 }
            if (r0 == 0) goto L_0x00c3
            java.io.File r0 = r10.f14635c     // Catch:{ all -> 0x0505 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0505 }
            java.lang.String r15 = c((java.lang.String) r0)     // Catch:{ all -> 0x0505 }
        L_0x00c3:
            r26 = r15
            java.lang.String r27 = r32.d()     // Catch:{ all -> 0x0505 }
            a(r21, r22, r23, r24, r25, r26, r27)     // Catch:{ all -> 0x0505 }
            com.alibaba.wireless.security.b.b r0 = new com.alibaba.wireless.security.b.b     // Catch:{ all -> 0x0505 }
            r0.<init>(r7)     // Catch:{ all -> 0x0505 }
            throw r0     // Catch:{ all -> 0x0505 }
        L_0x00d2:
            java.lang.String r6 = r0.versionName     // Catch:{ all -> 0x0505 }
            android.content.pm.ApplicationInfo r1 = r0.applicationInfo     // Catch:{ all -> 0x0505 }
            android.os.Bundle r1 = r1.metaData     // Catch:{ all -> 0x0505 }
            java.lang.String r2 = "dependencies"
            java.lang.String r5 = r1.getString(r2)     // Catch:{ all -> 0x0505 }
            android.content.pm.ApplicationInfo r1 = r0.applicationInfo     // Catch:{ all -> 0x0505 }
            android.os.Bundle r1 = r1.metaData     // Catch:{ all -> 0x0505 }
            java.lang.String r2 = "hasso"
            r4 = 0
            boolean r1 = r1.getBoolean(r2, r4)     // Catch:{ all -> 0x0505 }
            java.lang.Boolean r21 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0505 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            r1.<init>()     // Catch:{ all -> 0x0505 }
            r1.append(r9)     // Catch:{ all -> 0x0505 }
            java.lang.String r2 = "("
            r1.append(r2)     // Catch:{ all -> 0x0505 }
            r1.append(r6)     // Catch:{ all -> 0x0505 }
            java.lang.String r2 = ")"
            r1.append(r2)     // Catch:{ all -> 0x0505 }
            java.lang.String r3 = r1.toString()     // Catch:{ all -> 0x0505 }
            int r1 = r35.length()     // Catch:{ all -> 0x0505 }
            java.lang.String r2 = "->"
            if (r1 != 0) goto L_0x0110
            r1 = r3
            goto L_0x0122
        L_0x0110:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            r1.<init>()     // Catch:{ all -> 0x0505 }
            r1.append(r11)     // Catch:{ all -> 0x0505 }
            r1.append(r2)     // Catch:{ all -> 0x0505 }
            r1.append(r3)     // Catch:{ all -> 0x0505 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0505 }
        L_0x0122:
            r8.a((java.lang.String) r5, (java.lang.String) r1, (boolean) r4)     // Catch:{ all -> 0x0505 }
            r8.b((java.lang.String) r9, (java.lang.String) r6)     // Catch:{ b -> 0x04a2 }
            boolean r1 = r21.booleanValue()     // Catch:{ all -> 0x0505 }
            if (r1 == 0) goto L_0x01e6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            java.lang.String r4 = "libsg"
            r1.<init>(r4)     // Catch:{ all -> 0x0505 }
            r1.append(r9)     // Catch:{ all -> 0x0505 }
            r1.append(r12)     // Catch:{ all -> 0x0505 }
            r1.append(r6)     // Catch:{ all -> 0x0505 }
            java.lang.String r4 = ".so"
            r1.append(r4)     // Catch:{ all -> 0x0505 }
            java.lang.String r23 = r1.toString()     // Catch:{ all -> 0x0505 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            java.lang.String r4 = "sg"
            r1.<init>(r4)     // Catch:{ all -> 0x0505 }
            r1.append(r9)     // Catch:{ all -> 0x0505 }
            r1.append(r12)     // Catch:{ all -> 0x0505 }
            r1.append(r6)     // Catch:{ all -> 0x0505 }
            java.lang.String r12 = r1.toString()     // Catch:{ all -> 0x0505 }
            java.io.File r4 = r10.f14635c     // Catch:{ all -> 0x0505 }
            boolean r1 = r10.f14636d     // Catch:{ all -> 0x0505 }
            r24 = r1
            r1 = r32
            r7 = r2
            r2 = r20
            r25 = r12
            r12 = r3
            r3 = r19
            r26 = r15
            r15 = 0
            r27 = r5
            r5 = r23
            r22 = r6
            r6 = r24
            boolean r1 = r1.a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0505 }
            if (r1 != 0) goto L_0x01e1
            r21 = 100043(0x186cb, float:1.4019E-40)
            r22 = 107(0x6b, float:1.5E-43)
            java.lang.String r23 = ""
            int r0 = r35.length()     // Catch:{ all -> 0x0505 }
            if (r0 != 0) goto L_0x018d
            r25 = r12
            goto L_0x01a1
        L_0x018d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            r0.<init>()     // Catch:{ all -> 0x0505 }
            r0.append(r11)     // Catch:{ all -> 0x0505 }
            r0.append(r7)     // Catch:{ all -> 0x0505 }
            r0.append(r12)     // Catch:{ all -> 0x0505 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0505 }
            r25 = r0
        L_0x01a1:
            java.io.File r0 = r10.f14635c     // Catch:{ all -> 0x0505 }
            if (r0 == 0) goto L_0x01b8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            r0.<init>(r13)     // Catch:{ all -> 0x0505 }
            java.io.File r1 = r10.f14635c     // Catch:{ all -> 0x0505 }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ all -> 0x0505 }
            java.lang.String r1 = c((java.lang.String) r1)     // Catch:{ all -> 0x0505 }
            r0.append(r1)     // Catch:{ all -> 0x0505 }
            goto L_0x01ca
        L_0x01b8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            r0.<init>(r14)     // Catch:{ all -> 0x0505 }
            java.io.File r1 = r10.f14633a     // Catch:{ all -> 0x0505 }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ all -> 0x0505 }
            java.lang.String r1 = c((java.lang.String) r1)     // Catch:{ all -> 0x0505 }
            r0.append(r1)     // Catch:{ all -> 0x0505 }
        L_0x01ca:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0505 }
            r26 = r0
            java.lang.String r0 = ""
            r24 = r27
            r27 = r0
            a(r21, r22, r23, r24, r25, r26, r27)     // Catch:{ all -> 0x0505 }
            com.alibaba.wireless.security.b.b r0 = new com.alibaba.wireless.security.b.b     // Catch:{ all -> 0x0505 }
            r1 = 107(0x6b, float:1.5E-43)
            r0.<init>(r1)     // Catch:{ all -> 0x0505 }
            throw r0     // Catch:{ all -> 0x0505 }
        L_0x01e1:
            r6 = r23
            r5 = r25
            goto L_0x01f2
        L_0x01e6:
            r7 = r2
            r12 = r3
            r27 = r5
            r22 = r6
            r26 = r15
            r15 = 0
            r5 = r26
            r6 = r5
        L_0x01f2:
            android.content.pm.ApplicationInfo r1 = r0.applicationInfo     // Catch:{ all -> 0x0505 }
            android.os.Bundle r1 = r1.metaData     // Catch:{ all -> 0x0505 }
            java.lang.String r2 = "pluginclass"
            java.lang.String r1 = r1.getString(r2)     // Catch:{ all -> 0x0505 }
            if (r1 != 0) goto L_0x0262
            r21 = 100043(0x186cb, float:1.4019E-40)
            r22 = 199(0xc7, float:2.79E-43)
            java.lang.String r23 = "miss pluginclass"
            int r0 = r35.length()     // Catch:{ all -> 0x0505 }
            if (r0 != 0) goto L_0x020e
            r25 = r12
            goto L_0x0222
        L_0x020e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            r0.<init>()     // Catch:{ all -> 0x0505 }
            r0.append(r11)     // Catch:{ all -> 0x0505 }
            r0.append(r7)     // Catch:{ all -> 0x0505 }
            r0.append(r12)     // Catch:{ all -> 0x0505 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0505 }
            r25 = r0
        L_0x0222:
            java.io.File r0 = r10.f14635c     // Catch:{ all -> 0x0505 }
            if (r0 == 0) goto L_0x0239
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            r0.<init>(r13)     // Catch:{ all -> 0x0505 }
            java.io.File r1 = r10.f14635c     // Catch:{ all -> 0x0505 }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ all -> 0x0505 }
            java.lang.String r1 = c((java.lang.String) r1)     // Catch:{ all -> 0x0505 }
            r0.append(r1)     // Catch:{ all -> 0x0505 }
            goto L_0x024b
        L_0x0239:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            r0.<init>(r14)     // Catch:{ all -> 0x0505 }
            java.io.File r1 = r10.f14633a     // Catch:{ all -> 0x0505 }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ all -> 0x0505 }
            java.lang.String r1 = c((java.lang.String) r1)     // Catch:{ all -> 0x0505 }
            r0.append(r1)     // Catch:{ all -> 0x0505 }
        L_0x024b:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0505 }
            r26 = r0
            java.lang.String r0 = ""
            r24 = r27
            r27 = r0
            a(r21, r22, r23, r24, r25, r26, r27)     // Catch:{ all -> 0x0505 }
            com.alibaba.wireless.security.b.b r0 = new com.alibaba.wireless.security.b.b     // Catch:{ all -> 0x0505 }
            r1 = 199(0xc7, float:2.79E-43)
            r0.<init>(r1)     // Catch:{ all -> 0x0505 }
            throw r0     // Catch:{ all -> 0x0505 }
        L_0x0262:
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x0505 }
            boolean r2 = r10.f14636d     // Catch:{ all -> 0x0505 }
            r4 = r19
            r3 = r20
            dalvik.system.DexClassLoader r2 = r8.b(r3, r4, r2)     // Catch:{ all -> 0x0505 }
            java.lang.Class r19 = a((java.lang.ClassLoader) r2, (java.lang.String) r1)     // Catch:{ all -> 0x0505 }
            if (r19 != 0) goto L_0x02ea
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            java.lang.String r2 = "load "
            r0.<init>(r2)     // Catch:{ all -> 0x0505 }
            r0.append(r1)     // Catch:{ all -> 0x0505 }
            java.lang.String r2 = " failed from plugin "
            r0.append(r2)     // Catch:{ all -> 0x0505 }
            com.alibaba.wireless.security.a.a.b.b()     // Catch:{ all -> 0x0505 }
            r21 = 100043(0x186cb, float:1.4019E-40)
            r22 = 199(0xc7, float:2.79E-43)
            java.lang.String r23 = "clazz == null"
            int r0 = r35.length()     // Catch:{ all -> 0x0505 }
            if (r0 != 0) goto L_0x0298
            r25 = r12
            goto L_0x02ac
        L_0x0298:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            r0.<init>()     // Catch:{ all -> 0x0505 }
            r0.append(r11)     // Catch:{ all -> 0x0505 }
            r0.append(r7)     // Catch:{ all -> 0x0505 }
            r0.append(r12)     // Catch:{ all -> 0x0505 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0505 }
            r25 = r0
        L_0x02ac:
            java.io.File r0 = r10.f14635c     // Catch:{ all -> 0x0505 }
            if (r0 == 0) goto L_0x02c3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            r0.<init>(r13)     // Catch:{ all -> 0x0505 }
            java.io.File r2 = r10.f14635c     // Catch:{ all -> 0x0505 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x0505 }
            java.lang.String r2 = c((java.lang.String) r2)     // Catch:{ all -> 0x0505 }
            r0.append(r2)     // Catch:{ all -> 0x0505 }
            goto L_0x02d5
        L_0x02c3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            r0.<init>(r14)     // Catch:{ all -> 0x0505 }
            java.io.File r2 = r10.f14633a     // Catch:{ all -> 0x0505 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x0505 }
            java.lang.String r2 = c((java.lang.String) r2)     // Catch:{ all -> 0x0505 }
            r0.append(r2)     // Catch:{ all -> 0x0505 }
        L_0x02d5:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0505 }
            r26 = r0
            r24 = r27
            r27 = r1
            a(r21, r22, r23, r24, r25, r26, r27)     // Catch:{ all -> 0x0505 }
            com.alibaba.wireless.security.b.b r0 = new com.alibaba.wireless.security.b.b     // Catch:{ all -> 0x0505 }
            r1 = 199(0xc7, float:2.79E-43)
            r0.<init>(r1)     // Catch:{ all -> 0x0505 }
            throw r0     // Catch:{ all -> 0x0505 }
        L_0x02ea:
            java.lang.Object r1 = r19.newInstance()     // Catch:{ InstantiationException -> 0x049c, IllegalAccessException -> 0x0496, b -> 0x0398 }
            r19 = r1
            com.alibaba.wireless.security.b.e.b r19 = (com.alibaba.wireless.security.b.e.b) r19     // Catch:{ InstantiationException -> 0x049c, IllegalAccessException -> 0x0496, b -> 0x0398 }
            com.alibaba.wireless.security.a.g r20 = new com.alibaba.wireless.security.a.g     // Catch:{ InstantiationException -> 0x049c, IllegalAccessException -> 0x0496, b -> 0x0398 }
            r1 = r20
            r23 = r2
            r2 = r3
            r3 = r32
            r28 = r4
            r4 = r33
            r29 = r5
            r5 = r23
            r30 = r6
            r6 = r0
            r31 = r7
            r7 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ InstantiationException -> 0x049c, IllegalAccessException -> 0x0496, b -> 0x0396 }
            java.lang.String r1 = "main"
            boolean r1 = r9.equalsIgnoreCase(r1)     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            r2 = 1
            r3 = 3
            r4 = 2
            if (r1 == 0) goto L_0x036f
            boolean r1 = r8.f14627d     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            boolean r5 = r8.f14630g     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            if (r5 == 0) goto L_0x0320
            r1 = r1 | 2
        L_0x0320:
            java.lang.String r5 = r8.f14628e     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            if (r5 == 0) goto L_0x032e
            java.lang.String r5 = r8.f14628e     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            int r5 = r5.length()     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            if (r5 <= 0) goto L_0x032e
            r1 = r1 | 4
        L_0x032e:
            android.content.Context r5 = r8.f14624a     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            boolean r5 = com.alibaba.wireless.security.a.a.e.a(r5)     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            if (r5 == 0) goto L_0x0338
            r1 = r1 | 8
        L_0x0338:
            android.content.Context r5 = r8.f14624a     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            boolean r5 = com.alibaba.wireless.security.a.a.e.b(r5)     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            if (r5 == 0) goto L_0x0342
            r1 = r1 | 16
        L_0x0342:
            com.alibaba.wireless.security.a.f r5 = r8.j     // Catch:{ Exception -> 0x034f, IllegalAccessException | InstantiationException -> 0x0498 }
            if (r5 == 0) goto L_0x034f
            com.alibaba.wireless.security.a.f r5 = r8.j     // Catch:{ Exception -> 0x034f, IllegalAccessException | InstantiationException -> 0x0498 }
            org.json.JSONObject r5 = r5.f14613a     // Catch:{ Exception -> 0x034f, IllegalAccessException | InstantiationException -> 0x0498 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x034f, IllegalAccessException | InstantiationException -> 0x0498 }
            goto L_0x0351
        L_0x034f:
            r5 = r26
        L_0x0351:
            r6 = 4
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            r6[r15] = r1     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            r6[r2] = r5     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            java.io.File r1 = r8.l     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            r6[r4] = r1     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            java.lang.String r1 = r8.f14629f     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            r6[r3] = r1     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            com.alibaba.wireless.security.a.a r1 = r19.a()     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            r8.f14632i = r1     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            goto L_0x0371
        L_0x036f:
            com.alibaba.wireless.security.a.e.f14608a = r17     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
        L_0x0371:
            boolean r1 = r21.booleanValue()     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            if (r1 == 0) goto L_0x049f
            android.content.pm.ApplicationInfo r0 = r0.applicationInfo     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            android.os.Bundle r0 = r0.metaData     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            java.lang.String r1 = "thirdpartyso"
            boolean r0 = r0.getBoolean(r1, r15)     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            if (r0 != 0) goto L_0x049f
            r0 = r23
            r1 = r29
            java.lang.String r0 = com.alibaba.wireless.security.a.a.e.a(r0, r1)     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            r1[r15] = r9     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            r1[r2] = r22     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            r1[r4] = r0     // Catch:{ IllegalAccessException | InstantiationException -> 0x0498, b -> 0x0396 }
            goto L_0x049f
        L_0x0396:
            r0 = move-exception
            goto L_0x039f
        L_0x0398:
            r0 = move-exception
            r28 = r4
            r30 = r6
            r31 = r7
        L_0x039f:
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x0505 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            r2.<init>()     // Catch:{ all -> 0x0505 }
            r3 = r28
            r2.append(r3)     // Catch:{ all -> 0x0505 }
            java.lang.String r3 = java.io.File.separator     // Catch:{ all -> 0x0505 }
            r2.append(r3)     // Catch:{ all -> 0x0505 }
            r3 = r30
            r2.append(r3)     // Catch:{ all -> 0x0505 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0505 }
            r1.<init>(r2)     // Catch:{ all -> 0x0505 }
            int r2 = r0.getErrorCode()     // Catch:{ all -> 0x0505 }
            r4 = 103(0x67, float:1.44E-43)
            if (r2 != r4) goto L_0x044f
            r19 = 100043(0x186cb, float:1.4019E-40)
            r20 = 103(0x67, float:1.44E-43)
            java.lang.String r21 = ""
            java.lang.String r22 = r0.toString()     // Catch:{ all -> 0x0505 }
            int r2 = r35.length()     // Catch:{ all -> 0x0505 }
            if (r2 != 0) goto L_0x03d8
            r23 = r12
            goto L_0x03ee
        L_0x03d8:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            r2.<init>()     // Catch:{ all -> 0x0505 }
            r2.append(r11)     // Catch:{ all -> 0x0505 }
            r3 = r31
            r2.append(r3)     // Catch:{ all -> 0x0505 }
            r2.append(r12)     // Catch:{ all -> 0x0505 }
            java.lang.String r3 = r2.toString()     // Catch:{ all -> 0x0505 }
            r23 = r3
        L_0x03ee:
            java.io.File r2 = r10.f14635c     // Catch:{ all -> 0x0505 }
            if (r2 == 0) goto L_0x0405
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            r2.<init>(r13)     // Catch:{ all -> 0x0505 }
            java.io.File r3 = r10.f14635c     // Catch:{ all -> 0x0505 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x0505 }
            java.lang.String r3 = c((java.lang.String) r3)     // Catch:{ all -> 0x0505 }
            r2.append(r3)     // Catch:{ all -> 0x0505 }
            goto L_0x0417
        L_0x0405:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            r2.<init>(r14)     // Catch:{ all -> 0x0505 }
            java.io.File r3 = r10.f14633a     // Catch:{ all -> 0x0505 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x0505 }
            java.lang.String r3 = c((java.lang.String) r3)     // Catch:{ all -> 0x0505 }
            r2.append(r3)     // Catch:{ all -> 0x0505 }
        L_0x0417:
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0505 }
            r24 = r2
            java.lang.String r2 = r1.getAbsolutePath()     // Catch:{ all -> 0x0505 }
            java.lang.String r25 = c((java.lang.String) r2)     // Catch:{ all -> 0x0505 }
            a(r19, r20, r21, r22, r23, r24, r25)     // Catch:{ all -> 0x0505 }
            boolean r2 = r10.f14636d     // Catch:{ all -> 0x0444 }
            if (r2 != 0) goto L_0x0431
            com.alibaba.wireless.security.a.a.d r2 = r8.f14626c     // Catch:{ all -> 0x0444 }
            r2.a()     // Catch:{ all -> 0x0444 }
        L_0x0431:
            boolean r2 = r1.exists()     // Catch:{ all -> 0x0444 }
            if (r2 == 0) goto L_0x043a
            r1.delete()     // Catch:{ all -> 0x0444 }
        L_0x043a:
            boolean r1 = r10.f14636d     // Catch:{ all -> 0x0505 }
            if (r1 != 0) goto L_0x0495
            com.alibaba.wireless.security.a.a.d r1 = r8.f14626c     // Catch:{ all -> 0x0505 }
            r1.b()     // Catch:{ all -> 0x0505 }
            goto L_0x0495
        L_0x0444:
            r0 = move-exception
            boolean r1 = r10.f14636d     // Catch:{ all -> 0x0505 }
            if (r1 != 0) goto L_0x044e
            com.alibaba.wireless.security.a.a.d r1 = r8.f14626c     // Catch:{ all -> 0x0505 }
            r1.b()     // Catch:{ all -> 0x0505 }
        L_0x044e:
            throw r0     // Catch:{ all -> 0x0505 }
        L_0x044f:
            r9 = 100043(0x186cb, float:1.4019E-40)
            r2 = 199(0xc7, float:2.79E-43)
            java.lang.String r11 = "native exception occurred"
            java.lang.String r12 = r0.toString()     // Catch:{ all -> 0x0505 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            java.lang.String r5 = "soName="
            r4.<init>(r5)     // Catch:{ all -> 0x0505 }
            r4.append(r3)     // Catch:{ all -> 0x0505 }
            java.lang.String r3 = ", authCode="
            r4.append(r3)     // Catch:{ all -> 0x0505 }
            java.lang.String r3 = r8.f14629f     // Catch:{ all -> 0x0505 }
            r4.append(r3)     // Catch:{ all -> 0x0505 }
            java.lang.String r3 = ", errorCode="
            r4.append(r3)     // Catch:{ all -> 0x0505 }
            int r3 = r0.getErrorCode()     // Catch:{ all -> 0x0505 }
            r4.append(r3)     // Catch:{ all -> 0x0505 }
            java.lang.String r13 = r4.toString()     // Catch:{ all -> 0x0505 }
            java.io.File r3 = r10.f14633a     // Catch:{ all -> 0x0505 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x0505 }
            java.lang.String r14 = c((java.lang.String) r3)     // Catch:{ all -> 0x0505 }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ all -> 0x0505 }
            java.lang.String r15 = c((java.lang.String) r1)     // Catch:{ all -> 0x0505 }
            r10 = r2
            a(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0505 }
        L_0x0495:
            throw r0     // Catch:{ all -> 0x0505 }
        L_0x0496:
            r20 = r16
        L_0x0498:
            com.alibaba.wireless.security.a.a.b.c()     // Catch:{ all -> 0x0505 }
            goto L_0x049f
        L_0x049c:
            r20 = r16
            goto L_0x0498
        L_0x049f:
            com.alibaba.wireless.security.a.e.f14608a = r17
            return r20
        L_0x04a2:
            r0 = move-exception
            r12 = r3
            r27 = r5
            r3 = r2
            r1 = r0
            r21 = 100043(0x186cb, float:1.4019E-40)
            r22 = 199(0xc7, float:2.79E-43)
            java.lang.String r23 = "isMeetReverseDependencies failed"
            int r0 = r35.length()     // Catch:{ all -> 0x0505 }
            if (r0 != 0) goto L_0x04b8
            r25 = r12
            goto L_0x04cc
        L_0x04b8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            r0.<init>()     // Catch:{ all -> 0x0505 }
            r0.append(r11)     // Catch:{ all -> 0x0505 }
            r0.append(r3)     // Catch:{ all -> 0x0505 }
            r0.append(r12)     // Catch:{ all -> 0x0505 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0505 }
            r25 = r0
        L_0x04cc:
            java.io.File r0 = r10.f14635c     // Catch:{ all -> 0x0505 }
            if (r0 == 0) goto L_0x04e3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            r0.<init>(r13)     // Catch:{ all -> 0x0505 }
            java.io.File r2 = r10.f14635c     // Catch:{ all -> 0x0505 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x0505 }
            java.lang.String r2 = c((java.lang.String) r2)     // Catch:{ all -> 0x0505 }
            r0.append(r2)     // Catch:{ all -> 0x0505 }
            goto L_0x04f5
        L_0x04e3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0505 }
            r0.<init>(r14)     // Catch:{ all -> 0x0505 }
            java.io.File r2 = r10.f14633a     // Catch:{ all -> 0x0505 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x0505 }
            java.lang.String r2 = c((java.lang.String) r2)     // Catch:{ all -> 0x0505 }
            r0.append(r2)     // Catch:{ all -> 0x0505 }
        L_0x04f5:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0505 }
            r26 = r0
            java.lang.String r0 = ""
            r24 = r27
            r27 = r0
            a(r21, r22, r23, r24, r25, r26, r27)     // Catch:{ all -> 0x0505 }
            throw r1     // Catch:{ all -> 0x0505 }
        L_0x0505:
            r0 = move-exception
            com.alibaba.wireless.security.a.e.f14608a = r17
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.a.h.a(java.lang.String, com.alibaba.wireless.security.a.h$a, java.lang.String):com.alibaba.wireless.security.a.g");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0053 A[SYNTHETIC, Splitter:B:17:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a4 A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d9 A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00d7 A[EDGE_INSN: B:83:0x00d7->B:43:0x00d7 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.alibaba.wireless.security.a.h.a a(java.lang.String r17, boolean r18) throws com.alibaba.wireless.security.b.b {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            java.lang.String r2 = "!/"
            java.lang.String r3 = ".zip"
            java.io.File r4 = r1.m
            java.lang.String r5 = ".so"
            r6 = 1
            java.lang.String r7 = "libsg"
            r8 = 0
            if (r4 == 0) goto L_0x0038
            java.io.File r10 = new java.io.File
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r7)
            r11.append(r0)
            r11.append(r5)
            java.lang.String r11 = r11.toString()
            r10.<init>(r4, r11)
            boolean r4 = r10.exists()
            if (r4 == 0) goto L_0x0038
            java.io.File r4 = r1.m
            java.io.File r4 = r1.d(r4)
            java.io.File r11 = r1.m
            if (r4 == r11) goto L_0x003a
            r11 = 1
            goto L_0x003b
        L_0x0038:
            r4 = 0
            r10 = 0
        L_0x003a:
            r11 = 0
        L_0x003b:
            if (r4 != 0) goto L_0x004a
            java.io.File r4 = r1.k
            java.io.File r4 = r1.d(r4)
            java.io.File r11 = r1.k
            if (r4 == r11) goto L_0x0049
            r11 = 1
            goto L_0x004a
        L_0x0049:
            r11 = 0
        L_0x004a:
            if (r11 != 0) goto L_0x0051
            com.alibaba.wireless.security.a.a.d r12 = r1.f14626c
            r12.a()
        L_0x0051:
            if (r10 != 0) goto L_0x0088
            java.lang.String r10 = r1.f14628e     // Catch:{ all -> 0x0085 }
            if (r10 == 0) goto L_0x0059
        L_0x0057:
            r12 = 0
            goto L_0x007b
        L_0x0059:
            java.lang.String r10 = "sg"
            java.lang.String r12 = java.lang.String.valueOf(r17)     // Catch:{ all -> 0x0085 }
            java.lang.String r10 = r10.concat(r12)     // Catch:{ all -> 0x0085 }
            java.lang.Class<com.alibaba.wireless.security.a.h> r12 = com.alibaba.wireless.security.a.h.class
            java.lang.ClassLoader r12 = r12.getClassLoader()     // Catch:{ all -> 0x0085 }
            java.lang.String r10 = com.alibaba.wireless.security.a.a.e.a(r12, r10)     // Catch:{ all -> 0x0085 }
            if (r10 == 0) goto L_0x0057
            int r12 = r10.length()     // Catch:{ all -> 0x0085 }
            if (r12 <= 0) goto L_0x0057
            java.io.File r12 = new java.io.File     // Catch:{ all -> 0x0085 }
            r12.<init>(r10)     // Catch:{ all -> 0x0085 }
        L_0x007b:
            boolean r10 = r1.c((java.io.File) r12)     // Catch:{ all -> 0x0085 }
            if (r10 != 0) goto L_0x0083
            r10 = 0
            goto L_0x0088
        L_0x0083:
            r10 = r12
            goto L_0x0088
        L_0x0085:
            r0 = move-exception
            goto L_0x019f
        L_0x0088:
            if (r10 == 0) goto L_0x00d7
            java.lang.String r12 = r10.getAbsolutePath()     // Catch:{ all -> 0x0085 }
            if (r12 == 0) goto L_0x00d7
            boolean r13 = r12.contains(r2)     // Catch:{ all -> 0x0085 }
            if (r13 == 0) goto L_0x00d7
            r13 = 2
            java.lang.String[] r2 = r12.split(r2, r13)     // Catch:{ all -> 0x0085 }
            r12 = r2[r8]     // Catch:{ all -> 0x0085 }
            r2 = r2[r6]     // Catch:{ all -> 0x0085 }
            java.lang.String[] r6 = n     // Catch:{ all -> 0x0085 }
            int r13 = r6.length     // Catch:{ all -> 0x0085 }
        L_0x00a2:
            if (r8 >= r13) goto L_0x00d7
            r14 = r6[r8]     // Catch:{ all -> 0x0085 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            java.lang.String r9 = "lib"
            r15.<init>(r9)     // Catch:{ all -> 0x0085 }
            java.lang.String r9 = java.io.File.separator     // Catch:{ all -> 0x0085 }
            r15.append(r9)     // Catch:{ all -> 0x0085 }
            r15.append(r14)     // Catch:{ all -> 0x0085 }
            java.lang.String r9 = java.io.File.separator     // Catch:{ all -> 0x0085 }
            r15.append(r9)     // Catch:{ all -> 0x0085 }
            r15.append(r7)     // Catch:{ all -> 0x0085 }
            r15.append(r0)     // Catch:{ all -> 0x0085 }
            r15.append(r5)     // Catch:{ all -> 0x0085 }
            java.lang.String r9 = r15.toString()     // Catch:{ all -> 0x0085 }
            boolean r9 = r9.equals(r2)     // Catch:{ all -> 0x0085 }
            if (r9 == 0) goto L_0x00d4
            o = r14     // Catch:{ all -> 0x0085 }
            java.io.File r10 = a((java.lang.String) r0, (java.io.File) r4, (java.lang.String) r12, (java.lang.String) r2)     // Catch:{ all -> 0x0085 }
            goto L_0x00d7
        L_0x00d4:
            int r8 = r8 + 1
            goto L_0x00a2
        L_0x00d7:
            if (r10 != 0) goto L_0x00dd
            java.io.File r10 = r16.b((java.lang.String) r17)     // Catch:{ all -> 0x0085 }
        L_0x00dd:
            if (r10 != 0) goto L_0x00e5
            if (r18 == 0) goto L_0x00e5
            java.io.File r10 = r1.a((java.lang.String) r0, (java.io.File) r4)     // Catch:{ all -> 0x0085 }
        L_0x00e5:
            if (r10 != 0) goto L_0x00f0
            if (r11 != 0) goto L_0x00ee
            com.alibaba.wireless.security.a.a.d r0 = r1.f14626c
            r0.b()
        L_0x00ee:
            r2 = 0
            return r2
        L_0x00f0:
            r2 = 0
            java.lang.String r5 = r10.getAbsolutePath()     // Catch:{ all -> 0x0085 }
            boolean r5 = r5.endsWith(r3)     // Catch:{ all -> 0x0085 }
            if (r5 == 0) goto L_0x0102
            com.alibaba.wireless.security.a.h$a r9 = new com.alibaba.wireless.security.a.h$a     // Catch:{ all -> 0x0085 }
            r9.<init>(r10, r4, r2, r11)     // Catch:{ all -> 0x0085 }
            goto L_0x0197
        L_0x0102:
            boolean r2 = com.alibaba.wireless.security.a.a.e.a()     // Catch:{ all -> 0x0085 }
            if (r2 == 0) goto L_0x0110
            com.alibaba.wireless.security.a.h$a r9 = new com.alibaba.wireless.security.a.h$a     // Catch:{ all -> 0x0085 }
            r2 = 0
            r9.<init>(r10, r4, r2, r11)     // Catch:{ all -> 0x0085 }
            goto L_0x0197
        L_0x0110:
            r2 = 0
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x0085 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            r6.<init>(r7)     // Catch:{ all -> 0x0085 }
            r6.append(r0)     // Catch:{ all -> 0x0085 }
            java.lang.String r8 = "_"
            r6.append(r8)     // Catch:{ all -> 0x0085 }
            long r8 = r10.lastModified()     // Catch:{ all -> 0x0085 }
            r6.append(r8)     // Catch:{ all -> 0x0085 }
            r6.append(r3)     // Catch:{ all -> 0x0085 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0085 }
            r5.<init>(r4, r6)     // Catch:{ all -> 0x0085 }
            boolean r6 = r5.exists()     // Catch:{ all -> 0x0085 }
            if (r6 == 0) goto L_0x0149
            boolean r6 = b((java.io.File) r5)     // Catch:{ all -> 0x0085 }
            if (r6 == 0) goto L_0x0149
            boolean r6 = c(r5, r10)     // Catch:{ all -> 0x0085 }
            if (r6 != 0) goto L_0x0149
            com.alibaba.wireless.security.a.h$a r9 = new com.alibaba.wireless.security.a.h$a     // Catch:{ all -> 0x0085 }
            r9.<init>(r5, r4, r10, r11)     // Catch:{ all -> 0x0085 }
            goto L_0x0197
        L_0x0149:
            r5.delete()     // Catch:{ all -> 0x0085 }
            boolean r6 = b((java.io.File) r10, (java.io.File) r5)     // Catch:{ all -> 0x0085 }
            if (r6 == 0) goto L_0x0158
            com.alibaba.wireless.security.a.h$a r9 = new com.alibaba.wireless.security.a.h$a     // Catch:{ all -> 0x0085 }
            r9.<init>(r5, r4, r10, r11)     // Catch:{ all -> 0x0085 }
            goto L_0x0197
        L_0x0158:
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x0085 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            r6.<init>(r7)     // Catch:{ all -> 0x0085 }
            r6.append(r0)     // Catch:{ all -> 0x0085 }
            java.lang.String r0 = "_cp"
            r6.append(r0)     // Catch:{ all -> 0x0085 }
            long r7 = r10.lastModified()     // Catch:{ all -> 0x0085 }
            r6.append(r7)     // Catch:{ all -> 0x0085 }
            r6.append(r3)     // Catch:{ all -> 0x0085 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0085 }
            r5.<init>(r4, r0)     // Catch:{ all -> 0x0085 }
            boolean r0 = r5.exists()     // Catch:{ all -> 0x0085 }
            if (r0 == 0) goto L_0x018a
            long r6 = r5.length()     // Catch:{ all -> 0x0085 }
            long r8 = r10.length()     // Catch:{ all -> 0x0085 }
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x0190
        L_0x018a:
            boolean r0 = a((java.io.File) r10, (java.io.File) r5)     // Catch:{ all -> 0x0085 }
            if (r0 == 0) goto L_0x0196
        L_0x0190:
            com.alibaba.wireless.security.a.h$a r9 = new com.alibaba.wireless.security.a.h$a     // Catch:{ all -> 0x0085 }
            r9.<init>(r5, r4, r10, r11)     // Catch:{ all -> 0x0085 }
            goto L_0x0197
        L_0x0196:
            r9 = r2
        L_0x0197:
            if (r11 != 0) goto L_0x019e
            com.alibaba.wireless.security.a.a.d r0 = r1.f14626c
            r0.b()
        L_0x019e:
            return r9
        L_0x019f:
            if (r11 != 0) goto L_0x01a6
            com.alibaba.wireless.security.a.a.d r2 = r1.f14626c
            r2.b()
        L_0x01a6:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.a.h.a(java.lang.String, boolean):com.alibaba.wireless.security.a.h$a");
    }

    private synchronized b c(String str, String str2, boolean z) throws com.alibaba.wireless.security.b.b {
        StringBuilder sb;
        g gVar = this.f14631h.get(str);
        if (gVar != null) {
            return gVar;
        }
        if (this.k == null || !this.k.exists()) {
            a();
        }
        a a2 = a(str, z);
        if (!(a2 == null || a2.f14633a == null)) {
            if (a2.f14633a.exists()) {
                g a3 = a(str, a2, str2);
                if (a3 == null) {
                    if (a2.f14635c != null) {
                        sb = new StringBuilder("src:");
                        sb.append(c(a2.f14635c.getAbsolutePath()));
                    } else {
                        sb = new StringBuilder("zipfile:");
                        sb.append(c(a2.f14633a.getAbsolutePath()));
                    }
                    a(100044, 110, "", str, str2, sb.toString(), "");
                    throw new com.alibaba.wireless.security.b.b(str, 111);
                }
                this.f14631h.put(str, a3);
                String str3 = str + "(" + a3.f14619b.versionName + ")";
                String a4 = a3.a("weakdependencies");
                if (str2.length() != 0) {
                    str3 = str2 + "->" + str3;
                }
                Looper myLooper = Looper.myLooper();
                if (myLooper == null || myLooper == Looper.getMainLooper()) {
                    b.a();
                    HandlerThread handlerThread = new HandlerThread("SGBackgroud");
                    handlerThread.start();
                    myLooper = handlerThread.getLooper();
                }
                new Handler(myLooper).postDelayed(new j(this, a4, str3), 2000);
                return a3;
            }
        }
        if (!z) {
            return null;
        }
        String str4 = "plugin " + str + " not existed";
        if (str2.length() != 0) {
            str4 = str4 + ", depended by " + str2;
        }
        a(100044, 110, "", str, str2, "", "");
        throw new com.alibaba.wireless.security.b.b(str4, 110);
    }

    public final synchronized <T> T a(Class<T> cls) throws com.alibaba.wireless.security.b.b {
        String str;
        Object obj = this.f14625b.get(cls);
        if (obj != null) {
            return cls.cast(obj);
        }
        String str2 = null;
        if (this.j != null) {
            str = this.j.c();
            if (str == null || str.length() == 0) {
                str = this.j.a(cls.getName());
            }
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            d dVar = (d) cls.getAnnotation(d.class);
            if (dVar != null) {
                str2 = dVar.a();
            }
            str = str2;
        }
        if (str == null || str.length() == 0) {
            throw new com.alibaba.wireless.security.b.b(H5Param.WEBVIEW_FONT_SIZE_LARGER);
        }
        b a2 = a(str);
        if (a2 != null) {
            Object b2 = a2.c().b();
            if (b2 != null) {
                this.f14625b.put(cls, b2);
                return cls.cast(b2);
            }
            a(100045, 112, "", cls.getName(), str + "(" + a2.a() + ")", c(a2.b()), "");
            throw new com.alibaba.wireless.security.b.b(112);
        }
        throw new com.alibaba.wireless.security.b.b(110);
    }
}
