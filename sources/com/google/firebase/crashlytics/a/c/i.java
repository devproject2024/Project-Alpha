package com.google.firebase.crashlytics.a.c;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.a.d.b;
import com.google.firebase.crashlytics.a.e.v;
import com.google.firebase.crashlytics.a.i.b;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    static final FilenameFilter f38196a = new c("BeginSession") {
        public final boolean accept(File file, String str) {
            return super.accept(file, str) && str.endsWith(".cls");
        }
    };

    /* renamed from: b  reason: collision with root package name */
    static final FilenameFilter f38197b = j.a();

    /* renamed from: c  reason: collision with root package name */
    static final FilenameFilter f38198c = new FilenameFilter() {
        public final boolean accept(File file, String str) {
            return str.length() == 39 && str.endsWith(".cls");
        }
    };

    /* renamed from: d  reason: collision with root package name */
    static final Comparator<File> f38199d = new Comparator<File>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((File) obj2).getName().compareTo(((File) obj).getName());
        }
    };

    /* renamed from: e  reason: collision with root package name */
    static final Comparator<File> f38200e = new Comparator<File>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((File) obj).getName().compareTo(((File) obj2).getName());
        }
    };
    /* access modifiers changed from: private */
    public static final Pattern q = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    private static final Map<String, String> r = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    private static final String[] s = {"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
    /* access modifiers changed from: private */
    public final com.google.firebase.crashlytics.a.d.b A;
    /* access modifiers changed from: private */
    public final b.a B;
    private final com.google.firebase.crashlytics.a.a C;
    private final com.google.firebase.crashlytics.a.l.d D;
    /* access modifiers changed from: private */
    public final String E;
    /* access modifiers changed from: private */
    public final com.google.firebase.crashlytics.a.a.a F;
    /* access modifiers changed from: private */
    public final aa G;

    /* renamed from: f  reason: collision with root package name */
    public final Context f38201f;
    /* access modifiers changed from: package-private */

    /* renamed from: g  reason: collision with root package name */
    public final r f38202g;
    /* access modifiers changed from: package-private */

    /* renamed from: h  reason: collision with root package name */
    public final m f38203h;

    /* renamed from: i  reason: collision with root package name */
    public final ae f38204i;
    public final h j;
    /* access modifiers changed from: package-private */
    public final com.google.firebase.crashlytics.a.i.a k;
    p l;
    com.google.android.gms.tasks.f<Boolean> m = new com.google.android.gms.tasks.f<>();
    com.google.android.gms.tasks.f<Boolean> n = new com.google.android.gms.tasks.f<>();
    com.google.android.gms.tasks.f<Void> o = new com.google.android.gms.tasks.f<>();
    AtomicBoolean p = new AtomicBoolean(false);
    private final AtomicInteger t = new AtomicInteger(0);
    private final com.google.firebase.crashlytics.a.f.c u;
    private final v v;
    private final com.google.firebase.crashlytics.a.g.h w;
    /* access modifiers changed from: private */
    public final b x;
    /* access modifiers changed from: private */
    public final b.C0646b y;
    private final e z;

    interface b {
        void a(com.google.firebase.crashlytics.a.h.c cVar) throws Exception;
    }

    static File[] a(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    static class c implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        private final String f38267a;

        public c(String str) {
            this.f38267a = str;
        }

        public boolean accept(File file, String str) {
            return str.contains(this.f38267a) && !str.endsWith(".cls_temp");
        }
    }

    /* renamed from: com.google.firebase.crashlytics.a.c.i$i  reason: collision with other inner class name */
    static class C0628i implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        private final String f38275a;

        public C0628i(String str) {
            this.f38275a = str;
        }

        public final boolean accept(File file, String str) {
            if (!str.equals(this.f38275a + ".cls") && str.contains(this.f38275a) && !str.endsWith(".cls_temp")) {
                return true;
            }
            return false;
        }
    }

    static class a implements FilenameFilter {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final boolean accept(File file, String str) {
            return !i.f38198c.accept(file, str) && i.q.matcher(str).matches();
        }
    }

    static class d implements FilenameFilter {
        d() {
        }

        public final boolean accept(File file, String str) {
            return com.google.firebase.crashlytics.a.h.b.f38602a.accept(file, str) || str.contains("SessionMissingBinaryImages");
        }
    }

    i(Context context, h hVar, com.google.firebase.crashlytics.a.f.c cVar, v vVar, r rVar, com.google.firebase.crashlytics.a.g.h hVar2, m mVar, b bVar, com.google.firebase.crashlytics.a.a aVar, com.google.firebase.crashlytics.a.m.b bVar2, com.google.firebase.crashlytics.a.a.a aVar2, com.google.firebase.crashlytics.a.k.e eVar) {
        com.google.firebase.crashlytics.a.g.h hVar3 = hVar2;
        b bVar3 = bVar;
        this.f38201f = context;
        this.j = hVar;
        this.u = cVar;
        this.v = vVar;
        this.f38202g = rVar;
        this.w = hVar3;
        this.f38203h = mVar;
        this.x = bVar3;
        this.y = new b.C0646b() {
            public final com.google.firebase.crashlytics.a.i.b a(com.google.firebase.crashlytics.a.k.a.b bVar) {
                String str = bVar.f38663c;
                String str2 = bVar.f38664d;
                return new com.google.firebase.crashlytics.a.i.b(bVar.f38666f, i.this.x.f38170a, s.getState(bVar), i.this.k, g.b(i.this.f38201f, "com.crashlytics.ApiEndpoint"), i.this.B);
            }
        };
        this.C = aVar;
        this.E = bVar2.a();
        this.F = aVar2;
        this.f38204i = new ae();
        this.z = new e(hVar3);
        this.A = new com.google.firebase.crashlytics.a.d.b(context, this.z);
        this.k = new com.google.firebase.crashlytics.a.i.a(new f(this, (byte) 0));
        this.B = new g(this, (byte) 0);
        this.D = new com.google.firebase.crashlytics.a.l.a(new com.google.firebase.crashlytics.a.l.c(10));
        com.google.firebase.crashlytics.a.d.b bVar4 = this.A;
        ae aeVar = this.f38204i;
        com.google.firebase.crashlytics.a.l.d dVar = this.D;
        File file = new File(hVar2.b());
        this.G = new aa(new n(context, vVar, bVar3, dVar), new com.google.firebase.crashlytics.a.g.a(file, eVar), com.google.firebase.crashlytics.a.j.a.a(context), bVar4, aeVar);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(com.google.firebase.crashlytics.a.k.e eVar, Thread thread, Throwable th) {
        com.google.firebase.crashlytics.a.b a2 = com.google.firebase.crashlytics.a.b.a();
        StringBuilder sb = new StringBuilder("Crashlytics is handling uncaught exception \"");
        sb.append(th);
        sb.append("\" from thread ");
        sb.append(thread.getName());
        a2.a(3);
        final Date date = new Date();
        final Throwable th2 = th;
        final Thread thread2 = thread;
        final com.google.firebase.crashlytics.a.k.e eVar2 = eVar;
        try {
            af.a(this.j.b(new Callable<Task<Void>>() {
                public final /* synthetic */ Object call() throws Exception {
                    i.this.f38203h.a();
                    long a2 = i.b(date);
                    i.this.G.a(th2, thread2, "crash", a2, true);
                    i.a(i.this, thread2, th2, a2);
                    i.a(i.this, date.getTime());
                    com.google.firebase.crashlytics.a.k.a.e a3 = eVar2.a();
                    int i2 = a3.a().f38671a;
                    int i3 = a3.a().f38672b;
                    i.this.a(i2, true);
                    i.c(i.this);
                    i iVar = i.this;
                    int a4 = i3 - af.a(iVar.e(), iVar.f(), i3, i.f38200e);
                    af.a(iVar.d(), i.f38198c, a4 - af.a(iVar.g(), a4, i.f38200e), i.f38200e);
                    if (!i.this.f38202g.a()) {
                        return com.google.android.gms.tasks.h.a(null);
                    }
                    final ExecutorService executorService = i.this.j.f38186a;
                    return eVar2.b().a((Executor) executorService, new com.google.android.gms.tasks.e<com.google.firebase.crashlytics.a.k.a.b, Void>() {
                        public final /* synthetic */ Task a(Object obj) throws Exception {
                            com.google.firebase.crashlytics.a.k.a.b bVar = (com.google.firebase.crashlytics.a.k.a.b) obj;
                            if (bVar == null) {
                                com.google.firebase.crashlytics.a.b.a().a(5);
                                return com.google.android.gms.tasks.h.a(null);
                            }
                            i.a(i.this, bVar);
                            return com.google.android.gms.tasks.h.a((Task<?>[]) new Task[]{i.this.k(), i.this.G.a(executorService, s.getState(bVar))});
                        }
                    });
                }
            }));
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(final long j2, final String str) {
        this.j.a(new Callable<Void>() {
            public final /* synthetic */ Object call() throws Exception {
                if (i.this.c()) {
                    return null;
                }
                com.google.firebase.crashlytics.a.d.b k = i.this.A;
                k.f38333a.a(j2, str);
                return null;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        File[] i2 = i();
        if (i2.length > 0) {
            return a(i2[0]);
        }
        return null;
    }

    static String a(File file) {
        return file.getName().substring(0, 35);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(int i2) {
        this.j.a();
        if (c()) {
            com.google.firebase.crashlytics.a.b.a().a(3);
            return false;
        }
        com.google.firebase.crashlytics.a.b.a().a(3);
        try {
            a(i2, false);
            com.google.firebase.crashlytics.a.b.a().a(3);
            return true;
        } catch (Exception unused) {
            com.google.firebase.crashlytics.a.b.a().a(6);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, boolean z2) throws Exception {
        int i3 = !z2;
        b(i3 + 8);
        File[] i4 = i();
        if (i4.length <= i3) {
            com.google.firebase.crashlytics.a.b.a().a(3);
            return;
        }
        c(a(i4[i3]));
        if (z2) {
            this.G.f38156d = null;
        }
        a(i4, i3, i2);
        this.G.a(j());
    }

    private void a(File[] fileArr, int i2, int i3) {
        com.google.firebase.crashlytics.a.b.a().a(3);
        while (i2 < fileArr.length) {
            File file = fileArr[i2];
            String a2 = a(file);
            com.google.firebase.crashlytics.a.b a3 = com.google.firebase.crashlytics.a.b.a();
            "Closing session: ".concat(String.valueOf(a2));
            a3.a(3);
            a(file, a2, i3);
            i2++;
        }
    }

    private static void a(com.google.firebase.crashlytics.a.h.b bVar) {
        if (bVar != null) {
            try {
                bVar.a();
            } catch (IOException unused) {
                com.google.firebase.crashlytics.a.b.a().a(6);
            }
        }
    }

    private File[] b(String str) {
        return a((FilenameFilter) new C0628i(str));
    }

    /* access modifiers changed from: package-private */
    public final File[] b() {
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, a(f(), f38198c));
        Collections.addAll(linkedList, a(g(), f38198c));
        Collections.addAll(linkedList, a(d(), f38198c));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    /* access modifiers changed from: package-private */
    public final File[] a(FilenameFilter filenameFilter) {
        return a(d(), filenameFilter);
    }

    private static File[] a(File file, FilenameFilter filenameFilter) {
        return a(file.listFiles(filenameFilter));
    }

    private void a(String str, int i2) {
        File d2 = d();
        af.a(d2, (FilenameFilter) new c(str + "SessionEvent"), i2, f38200e);
    }

    private void b(int i2) {
        HashSet hashSet = new HashSet();
        File[] i3 = i();
        int min = Math.min(i2, i3.length);
        for (int i4 = 0; i4 < min; i4++) {
            hashSet.add(a(i3[i4]));
        }
        this.A.a((Set<String>) hashSet);
        a(a((FilenameFilter) new a((byte) 0)), (Set<String>) hashSet);
    }

    private static void a(File[] fileArr, Set<String> set) {
        for (File file : fileArr) {
            String name = file.getName();
            Matcher matcher = q.matcher(name);
            if (!matcher.matches()) {
                com.google.firebase.crashlytics.a.b a2 = com.google.firebase.crashlytics.a.b.a();
                "Deleting unknown file: ".concat(String.valueOf(name));
                a2.a(3);
                file.delete();
            } else if (!set.contains(matcher.group(1))) {
                com.google.firebase.crashlytics.a.b a3 = com.google.firebase.crashlytics.a.b.a();
                "Trimming session file: ".concat(String.valueOf(name));
                a3.a(3);
                file.delete();
            }
        }
    }

    private File[] a(String str, File[] fileArr, int i2) {
        if (fileArr.length <= i2) {
            return fileArr;
        }
        com.google.firebase.crashlytics.a.b a2 = com.google.firebase.crashlytics.a.b.a();
        String.format(Locale.US, "Trimming down to %d logged exceptions.", new Object[]{Integer.valueOf(i2)});
        a2.a(3);
        a(str, i2);
        return a((FilenameFilter) new c(str + "SessionEvent"));
    }

    private static long j() {
        return b(new Date());
    }

    /* access modifiers changed from: private */
    public static long b(Date date) {
        return date.getTime() / 1000;
    }

    private void a(String str, String str2, b bVar) throws Exception {
        com.google.firebase.crashlytics.a.h.b bVar2;
        com.google.firebase.crashlytics.a.h.c cVar = null;
        try {
            bVar2 = new com.google.firebase.crashlytics.a.h.b(d(), str + str2);
            try {
                cVar = com.google.firebase.crashlytics.a.h.c.a((OutputStream) bVar2);
                bVar.a(cVar);
                StringBuilder sb = new StringBuilder("Failed to flush to session ");
                sb.append(str2);
                sb.append(" file.");
                g.a((Flushable) cVar);
                StringBuilder sb2 = new StringBuilder("Failed to close session ");
                sb2.append(str2);
                sb2.append(" file.");
                g.a((Closeable) bVar2);
            } catch (Throwable th) {
                th = th;
                StringBuilder sb3 = new StringBuilder("Failed to flush to session ");
                sb3.append(str2);
                sb3.append(" file.");
                g.a((Flushable) cVar);
                StringBuilder sb4 = new StringBuilder("Failed to close session ");
                sb4.append(str2);
                sb4.append(" file.");
                g.a((Closeable) bVar2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bVar2 = null;
            StringBuilder sb32 = new StringBuilder("Failed to flush to session ");
            sb32.append(str2);
            sb32.append(" file.");
            g.a((Flushable) cVar);
            StringBuilder sb42 = new StringBuilder("Failed to close session ");
            sb42.append(str2);
            sb42.append(" file.");
            g.a((Closeable) bVar2);
            throw th;
        }
    }

    private void c(String str) throws Exception {
        final ae d2 = d(str);
        a(str, "SessionUser", (b) new b() {
            public final void a(com.google.firebase.crashlytics.a.h.c cVar) throws Exception {
                com.google.firebase.crashlytics.a.h.d.a(cVar, d2.f38161a);
            }
        });
    }

    private void a(com.google.firebase.crashlytics.a.h.c cVar, Thread thread, Throwable th, long j2, String str, boolean z2) throws Exception {
        Thread[] threadArr;
        TreeMap treeMap;
        Map<String, String> map;
        com.google.firebase.crashlytics.a.l.e eVar = new com.google.firebase.crashlytics.a.l.e(th, this.D);
        Context context = this.f38201f;
        e a2 = e.a(context);
        Float f2 = a2.f38178a;
        int a3 = a2.a();
        boolean d2 = g.d(context);
        int i2 = context.getResources().getConfiguration().orientation;
        long b2 = g.b() - g.c(context);
        long b3 = g.b(Environment.getDataDirectory().getPath());
        ActivityManager.RunningAppProcessInfo a4 = g.a(context.getPackageName(), context);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = eVar.f38708c;
        String str2 = this.x.f38171b;
        String str3 = this.v.f38323a;
        int i3 = 0;
        if (z2) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Thread[] threadArr2 = new Thread[allStackTraces.size()];
            for (Map.Entry next : allStackTraces.entrySet()) {
                threadArr2[i3] = (Thread) next.getKey();
                linkedList.add(this.D.a((StackTraceElement[]) next.getValue()));
                i3++;
            }
            threadArr = threadArr2;
        } else {
            threadArr = new Thread[0];
        }
        if (!g.a(context, "com.crashlytics.CollectCustomKeys")) {
            map = new TreeMap<>();
        } else {
            map = Collections.unmodifiableMap(this.f38204i.f38162b);
            if (map != null && map.size() > 1) {
                treeMap = new TreeMap(map);
                String str4 = str3;
                Map<String, String> map2 = treeMap;
                String str5 = str2;
                com.google.firebase.crashlytics.a.h.d.a(cVar, j2, str, eVar, thread, stackTraceElementArr, threadArr, linkedList, map2, this.A.f38333a.a(), a4, i2, str4, str5, f2, a3, d2, b2, b3);
                this.A.f38333a.d();
            }
        }
        treeMap = map;
        String str42 = str3;
        Map<String, String> map22 = treeMap;
        String str52 = str2;
        com.google.firebase.crashlytics.a.h.d.a(cVar, j2, str, eVar, thread, stackTraceElementArr, threadArr, linkedList, map22, this.A.f38333a.a(), a4, i2, str42, str52, f2, a3, d2, b2, b3);
        this.A.f38333a.d();
    }

    private void a(File file, String str, int i2) {
        com.google.firebase.crashlytics.a.b a2 = com.google.firebase.crashlytics.a.b.a();
        "Collecting session parts for ID ".concat(String.valueOf(str));
        a2.a(3);
        File[] a3 = a((FilenameFilter) new c(str + "SessionCrash"));
        boolean z2 = a3 != null && a3.length > 0;
        com.google.firebase.crashlytics.a.b a4 = com.google.firebase.crashlytics.a.b.a();
        String.format(Locale.US, "Session %s has fatal exception: %s", new Object[]{str, Boolean.valueOf(z2)});
        a4.a(3);
        File[] a5 = a((FilenameFilter) new c(str + "SessionEvent"));
        boolean z3 = a5 != null && a5.length > 0;
        com.google.firebase.crashlytics.a.b a6 = com.google.firebase.crashlytics.a.b.a();
        String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new Object[]{str, Boolean.valueOf(z3)});
        a6.a(3);
        if (z2 || z3) {
            a(file, str, a(str, a5, i2), z2 ? a3[0] : null);
        } else {
            com.google.firebase.crashlytics.a.b a7 = com.google.firebase.crashlytics.a.b.a();
            "No events present for session ID ".concat(String.valueOf(str));
            a7.a(3);
        }
        com.google.firebase.crashlytics.a.b a8 = com.google.firebase.crashlytics.a.b.a();
        "Removing session part files for ID ".concat(String.valueOf(str));
        a8.a(3);
        c(b(str));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:23|24|25|26) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r9 = com.google.firebase.crashlytics.a.b.a();
        "Failed to write session file for session ID: ".concat(java.lang.String.valueOf(r10));
        r9.a(6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0075, code lost:
        com.google.firebase.crashlytics.a.c.g.a((java.io.Flushable) null);
        a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007c, code lost:
        r9 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0064 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.io.File r9, java.lang.String r10, java.io.File[] r11, java.io.File r12) {
        /*
            r8 = this;
            r0 = 1
            if (r12 == 0) goto L_0x0005
            r1 = 1
            goto L_0x0006
        L_0x0005:
            r1 = 0
        L_0x0006:
            if (r1 == 0) goto L_0x000d
            java.io.File r2 = r8.f()
            goto L_0x0011
        L_0x000d:
            java.io.File r2 = r8.g()
        L_0x0011:
            boolean r3 = r2.exists()
            if (r3 != 0) goto L_0x001a
            r2.mkdirs()
        L_0x001a:
            r3 = 0
            com.google.firebase.crashlytics.a.h.b r4 = new com.google.firebase.crashlytics.a.h.b     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r4.<init>(r2, r10)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            com.google.firebase.crashlytics.a.h.c r3 = com.google.firebase.crashlytics.a.h.c.a((java.io.OutputStream) r4)     // Catch:{ Exception -> 0x0064 }
            com.google.firebase.crashlytics.a.b r2 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ Exception -> 0x0064 }
            java.lang.String r5 = "Collecting SessionStart data for session ID "
            java.lang.String r6 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x0064 }
            r5.concat(r6)     // Catch:{ Exception -> 0x0064 }
            r5 = 3
            r2.a(r5)     // Catch:{ Exception -> 0x0064 }
            a((com.google.firebase.crashlytics.a.h.c) r3, (java.io.File) r9)     // Catch:{ Exception -> 0x0064 }
            r9 = 4
            long r6 = j()     // Catch:{ Exception -> 0x0064 }
            r3.a((int) r9, (long) r6)     // Catch:{ Exception -> 0x0064 }
            r9 = 5
            r3.a((int) r9, (boolean) r1)     // Catch:{ Exception -> 0x0064 }
            r9 = 11
            r3.a((int) r9, (int) r0)     // Catch:{ Exception -> 0x0064 }
            r9 = 12
            r3.b((int) r9, (int) r5)     // Catch:{ Exception -> 0x0064 }
            r8.a((com.google.firebase.crashlytics.a.h.c) r3, (java.lang.String) r10)     // Catch:{ Exception -> 0x0064 }
            a((com.google.firebase.crashlytics.a.h.c) r3, (java.io.File[]) r11, (java.lang.String) r10)     // Catch:{ Exception -> 0x0064 }
            if (r1 == 0) goto L_0x0059
            a((com.google.firebase.crashlytics.a.h.c) r3, (java.io.File) r12)     // Catch:{ Exception -> 0x0064 }
        L_0x0059:
            com.google.firebase.crashlytics.a.c.g.a((java.io.Flushable) r3)
            com.google.firebase.crashlytics.a.c.g.a((java.io.Closeable) r4)
            return
        L_0x0060:
            r9 = move-exception
            r4 = r3
            goto L_0x007d
        L_0x0063:
            r4 = r3
        L_0x0064:
            com.google.firebase.crashlytics.a.b r9 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ all -> 0x007c }
            java.lang.String r11 = "Failed to write session file for session ID: "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x007c }
            r11.concat(r10)     // Catch:{ all -> 0x007c }
            r10 = 6
            r9.a(r10)     // Catch:{ all -> 0x007c }
            com.google.firebase.crashlytics.a.c.g.a((java.io.Flushable) r3)
            a((com.google.firebase.crashlytics.a.h.b) r4)
            return
        L_0x007c:
            r9 = move-exception
        L_0x007d:
            com.google.firebase.crashlytics.a.c.g.a((java.io.Flushable) r3)
            com.google.firebase.crashlytics.a.c.g.a((java.io.Closeable) r4)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.c.i.a(java.io.File, java.lang.String, java.io.File[], java.io.File):void");
    }

    private static void a(com.google.firebase.crashlytics.a.h.c cVar, File[] fileArr, String str) {
        Arrays.sort(fileArr, g.f38182a);
        for (File file : fileArr) {
            try {
                com.google.firebase.crashlytics.a.b a2 = com.google.firebase.crashlytics.a.b.a();
                String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[]{str, file.getName()});
                a2.a(3);
                a(cVar, file);
            } catch (Exception unused) {
                com.google.firebase.crashlytics.a.b.a().a(6);
            }
        }
    }

    private void a(com.google.firebase.crashlytics.a.h.c cVar, String str) throws IOException {
        for (String str2 : s) {
            File[] a2 = a((FilenameFilter) new c(str + str2 + ".cls"));
            if (a2.length == 0) {
                com.google.firebase.crashlytics.a.b a3 = com.google.firebase.crashlytics.a.b.a();
                StringBuilder sb = new StringBuilder("Can't find ");
                sb.append(str2);
                sb.append(" data for session ID ");
                sb.append(str);
                a3.a(3);
            } else {
                com.google.firebase.crashlytics.a.b a4 = com.google.firebase.crashlytics.a.b.a();
                StringBuilder sb2 = new StringBuilder("Collecting ");
                sb2.append(str2);
                sb2.append(" data for session ID ");
                sb2.append(str);
                a4.a(3);
                a(cVar, a2[0]);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(final String str, File file) throws Exception {
        FileOutputStream fileOutputStream;
        if (str != null) {
            AnonymousClass15 r2 = new b() {
                public final void a(com.google.firebase.crashlytics.a.h.c cVar) throws Exception {
                    com.google.firebase.crashlytics.a.h.d.b(cVar, str);
                }
            };
            com.google.firebase.crashlytics.a.h.c cVar = null;
            try {
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    cVar = com.google.firebase.crashlytics.a.h.c.a((OutputStream) fileOutputStream);
                    r2.a(cVar);
                    new StringBuilder("Failed to flush to append to ").append(file.getPath());
                    g.a((Flushable) cVar);
                    new StringBuilder("Failed to close ").append(file.getPath());
                    g.a((Closeable) fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    new StringBuilder("Failed to flush to append to ").append(file.getPath());
                    g.a((Flushable) cVar);
                    new StringBuilder("Failed to close ").append(file.getPath());
                    g.a((Closeable) fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                new StringBuilder("Failed to flush to append to ").append(file.getPath());
                g.a((Flushable) cVar);
                new StringBuilder("Failed to close ").append(file.getPath());
                g.a((Closeable) fileOutputStream);
                throw th;
            }
        }
    }

    private static void a(com.google.firebase.crashlytics.a.h.c cVar, File file) throws IOException {
        if (!file.exists()) {
            com.google.firebase.crashlytics.a.b a2 = com.google.firebase.crashlytics.a.b.a();
            new StringBuilder("Tried to include a file that doesn't exist: ").append(file.getName());
            a2.a(6);
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                a((InputStream) fileInputStream2, cVar, (int) file.length());
                g.a((Closeable) fileInputStream2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                g.a((Closeable) fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            g.a((Closeable) fileInputStream);
            throw th;
        }
    }

    private static void a(InputStream inputStream, com.google.firebase.crashlytics.a.h.c cVar, int i2) throws IOException {
        int read;
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < bArr.length && (read = inputStream.read(bArr, i3, bArr.length - i3)) >= 0) {
            i3 += read;
        }
        int length = bArr.length;
        if (cVar.f38608b - cVar.f38609c >= length) {
            System.arraycopy(bArr, 0, cVar.f38607a, cVar.f38609c, length);
            cVar.f38609c += length;
            return;
        }
        int i4 = cVar.f38608b - cVar.f38609c;
        System.arraycopy(bArr, 0, cVar.f38607a, cVar.f38609c, i4);
        int i5 = i4 + 0;
        int i6 = length - i4;
        cVar.f38609c = cVar.f38608b;
        cVar.b();
        if (i6 <= cVar.f38608b) {
            System.arraycopy(bArr, i5, cVar.f38607a, 0, i6);
            cVar.f38609c = i6;
            return;
        }
        cVar.f38610d.write(bArr, i5, i6);
    }

    private ae d(String str) {
        if (c()) {
            return this.f38204i;
        }
        return new y(d()).a(str);
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        p pVar = this.l;
        return pVar != null && pVar.f38301a.get();
    }

    /* access modifiers changed from: package-private */
    public final File d() {
        return this.w.a();
    }

    /* access modifiers changed from: package-private */
    public final File e() {
        return new File(d(), "native-sessions");
    }

    /* access modifiers changed from: package-private */
    public final File f() {
        return new File(d(), "fatal-sessions");
    }

    /* access modifiers changed from: package-private */
    public final File g() {
        return new File(d(), "nonfatal-sessions");
    }

    /* access modifiers changed from: private */
    public Task<Void> k() {
        Task task;
        ArrayList arrayList = new ArrayList();
        for (File file : a(f38197b)) {
            try {
                final long parseLong = Long.parseLong(file.getName().substring(3));
                if (l()) {
                    com.google.firebase.crashlytics.a.b.a().a(3);
                    task = com.google.android.gms.tasks.h.a(null);
                } else {
                    task = com.google.android.gms.tasks.h.a((Executor) new ScheduledThreadPoolExecutor(1), new Callable<Void>() {
                        public final /* synthetic */ Object call() throws Exception {
                            Bundle bundle = new Bundle();
                            bundle.putInt("fatal", 1);
                            bundle.putLong("timestamp", parseLong);
                            i.this.F.a("_ae", bundle);
                            return null;
                        }
                    });
                }
                arrayList.add(task);
            } catch (NumberFormatException unused) {
                com.google.firebase.crashlytics.a.b a2 = com.google.firebase.crashlytics.a.b.a();
                new StringBuilder("Could not parse timestamp from file ").append(file.getName());
                a2.a(3);
            }
            file.delete();
        }
        return com.google.android.gms.tasks.h.a((Collection<? extends Task<?>>) arrayList);
    }

    /* access modifiers changed from: private */
    public static void c(File[] fileArr) {
        if (fileArr != null) {
            for (File delete : fileArr) {
                delete.delete();
            }
        }
    }

    private static boolean l() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    final class g implements b.a {
        private g() {
        }

        /* synthetic */ g(i iVar, byte b2) {
            this();
        }

        public final boolean a() {
            return i.this.c();
        }
    }

    final class f implements b.c {
        private f() {
        }

        /* synthetic */ f(i iVar, byte b2) {
            this();
        }

        public final File[] a() {
            return i.this.b();
        }

        public final File[] b() {
            return i.a(i.this.e().listFiles());
        }
    }

    static final class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Context f38271a;

        /* renamed from: b  reason: collision with root package name */
        private final com.google.firebase.crashlytics.a.i.a.c f38272b;

        /* renamed from: c  reason: collision with root package name */
        private final com.google.firebase.crashlytics.a.i.b f38273c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f38274d = true;

        public h(Context context, com.google.firebase.crashlytics.a.i.a.c cVar, com.google.firebase.crashlytics.a.i.b bVar) {
            this.f38271a = context;
            this.f38272b = cVar;
            this.f38273c = bVar;
        }

        public final void run() {
            if (g.k(this.f38271a)) {
                com.google.firebase.crashlytics.a.b.a().a(3);
                this.f38273c.a(this.f38272b, this.f38274d);
            }
        }
    }

    static final class e implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private final com.google.firebase.crashlytics.a.g.h f38268a;

        public e(com.google.firebase.crashlytics.a.g.h hVar) {
            this.f38268a = hVar;
        }

        public final File a() {
            File file = new File(this.f38268a.a(), "log-files");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    private File[] i() {
        File[] a2 = a(f38196a);
        Arrays.sort(a2, f38199d);
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        com.google.firebase.crashlytics.a.b.a().a(6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        com.google.firebase.crashlytics.a.c.g.a((java.io.Flushable) r1);
        com.google.firebase.crashlytics.a.c.g.a((java.io.Closeable) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0058, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.google.firebase.crashlytics.a.c.i r13, java.lang.Thread r14, java.lang.Throwable r15, long r16) {
        /*
            r0 = 6
            r1 = 0
            java.lang.String r2 = r13.a()     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
            if (r2 != 0) goto L_0x0016
            com.google.firebase.crashlytics.a.b r2 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
            r2.a(r0)     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
            com.google.firebase.crashlytics.a.c.g.a((java.io.Flushable) r1)
            com.google.firebase.crashlytics.a.c.g.a((java.io.Closeable) r1)
            return
        L_0x0016:
            com.google.firebase.crashlytics.a.h.b r3 = new com.google.firebase.crashlytics.a.h.b     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
            java.io.File r4 = r13.d()     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
            r5.<init>()     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
            r5.append(r2)     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
            java.lang.String r2 = "SessionCrash"
            r5.append(r2)     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
            r3.<init>(r4, r2)     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
            com.google.firebase.crashlytics.a.h.c r1 = com.google.firebase.crashlytics.a.h.c.a((java.io.OutputStream) r3)     // Catch:{ Exception -> 0x004b }
            java.lang.String r11 = "crash"
            r12 = 1
            r5 = r13
            r6 = r1
            r7 = r14
            r8 = r15
            r9 = r16
            r5.a(r6, r7, r8, r9, r11, r12)     // Catch:{ Exception -> 0x004b }
            com.google.firebase.crashlytics.a.c.g.a((java.io.Flushable) r1)
            com.google.firebase.crashlytics.a.c.g.a((java.io.Closeable) r3)
            return
        L_0x0047:
            r0 = move-exception
            r3 = r1
            goto L_0x005a
        L_0x004a:
            r3 = r1
        L_0x004b:
            com.google.firebase.crashlytics.a.b r2 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ all -> 0x0059 }
            r2.a(r0)     // Catch:{ all -> 0x0059 }
            com.google.firebase.crashlytics.a.c.g.a((java.io.Flushable) r1)
            com.google.firebase.crashlytics.a.c.g.a((java.io.Closeable) r3)
            return
        L_0x0059:
            r0 = move-exception
        L_0x005a:
            com.google.firebase.crashlytics.a.c.g.a((java.io.Flushable) r1)
            com.google.firebase.crashlytics.a.c.g.a((java.io.Closeable) r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.c.i.a(com.google.firebase.crashlytics.a.c.i, java.lang.Thread, java.lang.Throwable, long):void");
    }

    static /* synthetic */ void a(i iVar, long j2) {
        try {
            new File(iVar.d(), ".ae".concat(String.valueOf(j2))).createNewFile();
        } catch (IOException unused) {
            com.google.firebase.crashlytics.a.b.a().a(3);
        }
    }

    static /* synthetic */ void c(i iVar) throws Exception {
        i iVar2 = iVar;
        long j2 = j();
        String fVar = new f(iVar2.v).toString();
        com.google.firebase.crashlytics.a.b a2 = com.google.firebase.crashlytics.a.b.a();
        "Opening a new session with ID ".concat(String.valueOf(fVar));
        a2.a(3);
        final String format = String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{"17.1.0"});
        i iVar3 = iVar;
        final String str = fVar;
        final long j3 = j2;
        iVar2.a(fVar, "BeginSession", (b) new b() {
            public final void a(com.google.firebase.crashlytics.a.h.c cVar) throws Exception {
                com.google.firebase.crashlytics.a.h.d.a(cVar, str, format, j3);
            }
        });
        final String str2 = iVar2.v.f38323a;
        final String str3 = iVar2.x.f38174e;
        final String str4 = iVar2.x.f38175f;
        final String a3 = iVar2.v.a();
        final int id = t.determineFrom(iVar2.x.f38172c).getId();
        iVar2.a(fVar, "SessionApp", (b) new b() {
            public final void a(com.google.firebase.crashlytics.a.h.c cVar) throws Exception {
                com.google.firebase.crashlytics.a.h.d.a(cVar, str2, str3, str4, a3, id, i.this.E);
            }
        });
        final String str5 = Build.VERSION.RELEASE;
        final String str6 = Build.VERSION.CODENAME;
        final boolean f2 = g.f(iVar2.f38201f);
        iVar2.a(fVar, "SessionOS", (b) new b() {
            public final void a(com.google.firebase.crashlytics.a.h.c cVar) throws Exception {
                com.google.firebase.crashlytics.a.h.d.a(cVar, str5, str6, f2);
            }
        });
        Context context = iVar2.f38201f;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        final int a4 = g.a();
        final String str7 = Build.MODEL;
        final int availableProcessors = Runtime.getRuntime().availableProcessors();
        final long b2 = g.b();
        String str8 = fVar;
        final long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        final boolean e2 = g.e(context);
        int g2 = g.g(context);
        long j4 = j2;
        AnonymousClass13 r14 = r0;
        final int i2 = g2;
        final String str9 = Build.MANUFACTURER;
        String str10 = str8;
        final String str11 = Build.PRODUCT;
        AnonymousClass13 r0 = new b() {
            public final void a(com.google.firebase.crashlytics.a.h.c cVar) throws Exception {
                com.google.firebase.crashlytics.a.h.d.a(cVar, a4, str7, availableProcessors, b2, blockCount, e2, i2, str9, str11);
            }
        };
        iVar2.a(str10, "SessionDevice", (b) r14);
        iVar2.A.a(str10);
        aa aaVar = iVar2.G;
        String replaceAll = str10.replaceAll("-", "");
        aaVar.f38156d = replaceAll;
        n nVar = aaVar.f38153a;
        v.a a5 = v.j().a("17.1.0").b(nVar.f38299d.f38170a).c(nVar.f38298c.a()).d(nVar.f38299d.f38174e).e(nVar.f38299d.f38175f).a(4);
        v.d.b a6 = v.d.m().a(j4).b(replaceAll).a(n.f38295a).a(v.d.a.f().a(nVar.f38298c.f38323a).b(nVar.f38299d.f38174e).c(nVar.f38299d.f38175f).d(nVar.f38298c.a()).a()).a(v.d.e.e().a(3).a(Build.VERSION.RELEASE).b(Build.VERSION.CODENAME).a(g.f(nVar.f38297b)).a());
        StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
        int a7 = n.a();
        int availableProcessors2 = Runtime.getRuntime().availableProcessors();
        long b3 = g.b();
        long blockCount2 = ((long) statFs2.getBlockCount()) * ((long) statFs2.getBlockSize());
        boolean e3 = g.e(nVar.f38297b);
        int g3 = g.g(nVar.f38297b);
        String str12 = Build.MANUFACTURER;
        v a8 = a5.a(a6.a(v.d.c.j().a(a7).a(Build.MODEL).b(availableProcessors2).a(b3).b(blockCount2).a(e3).c(g3).b(str12).c(Build.PRODUCT).a()).a(3).a()).a();
        com.google.firebase.crashlytics.a.g.a aVar = aaVar.f38154b;
        v.d g4 = a8.g();
        if (g4 == null) {
            com.google.firebase.crashlytics.a.b.a().a(3);
            return;
        }
        String b4 = g4.b();
        try {
            File a9 = com.google.firebase.crashlytics.a.g.a.a(aVar.b(b4));
            com.google.firebase.crashlytics.a.g.a.a(new File(a9, H5Param.MENU_REPORT), com.google.firebase.crashlytics.a.e.a.a.a(a8));
        } catch (IOException unused) {
            com.google.firebase.crashlytics.a.b a10 = com.google.firebase.crashlytics.a.b.a();
            "Could not persist report for session ".concat(String.valueOf(b4));
            a10.a(3);
        }
    }

    static /* synthetic */ void a(i iVar, com.google.firebase.crashlytics.a.k.a.b bVar) throws Exception {
        Context context = iVar.f38201f;
        com.google.firebase.crashlytics.a.i.b a2 = iVar.y.a(bVar);
        for (File file : iVar.b()) {
            b(bVar.f38666f, file);
            iVar.j.a((Runnable) new h(context, new com.google.firebase.crashlytics.a.i.a.d(file, r), a2));
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0074 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(com.google.firebase.crashlytics.a.c.i r13, java.lang.Thread r14, java.lang.Throwable r15, long r16) {
        /*
            r0 = r13
            java.lang.String r9 = r13.a()
            r1 = 3
            if (r9 != 0) goto L_0x0010
            com.google.firebase.crashlytics.a.b r0 = com.google.firebase.crashlytics.a.b.a()
            r0.a(r1)
            return
        L_0x0010:
            r10 = 6
            r2 = 0
            com.google.firebase.crashlytics.a.b r3 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            java.lang.String r5 = "Crashlytics is logging non-fatal exception \""
            r4.<init>(r5)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            r5 = r15
            r4.append(r15)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            java.lang.String r6 = "\" from thread "
            r4.append(r6)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            java.lang.String r6 = r14.getName()     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            r4.append(r6)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            r3.a(r1)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            java.util.concurrent.atomic.AtomicInteger r1 = r0.t     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            int r1 = r1.getAndIncrement()     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            java.lang.String r1 = com.google.firebase.crashlytics.a.c.g.a((int) r1)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            r3.<init>()     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            r3.append(r9)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            java.lang.String r4 = "SessionEvent"
            r3.append(r4)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            r3.append(r1)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            com.google.firebase.crashlytics.a.h.b r11 = new com.google.firebase.crashlytics.a.h.b     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            java.io.File r3 = r13.d()     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            r11.<init>(r3, r1)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            com.google.firebase.crashlytics.a.h.c r12 = com.google.firebase.crashlytics.a.h.c.a((java.io.OutputStream) r11)     // Catch:{ Exception -> 0x0074 }
            java.lang.String r7 = "error"
            r8 = 0
            r1 = r13
            r2 = r12
            r3 = r14
            r4 = r15
            r5 = r16
            r1.a(r2, r3, r4, r5, r7, r8)     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            com.google.firebase.crashlytics.a.c.g.a((java.io.Flushable) r12)
            goto L_0x007e
        L_0x006b:
            r0 = move-exception
            r2 = r12
            goto L_0x0090
        L_0x006e:
            r2 = r12
            goto L_0x0074
        L_0x0070:
            r0 = move-exception
            r11 = r2
            goto L_0x0090
        L_0x0073:
            r11 = r2
        L_0x0074:
            com.google.firebase.crashlytics.a.b r1 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ all -> 0x008f }
            r1.a(r10)     // Catch:{ all -> 0x008f }
            com.google.firebase.crashlytics.a.c.g.a((java.io.Flushable) r2)
        L_0x007e:
            com.google.firebase.crashlytics.a.c.g.a((java.io.Closeable) r11)
            r1 = 64
            r13.a((java.lang.String) r9, (int) r1)     // Catch:{ Exception -> 0x0087 }
            return
        L_0x0087:
            com.google.firebase.crashlytics.a.b r0 = com.google.firebase.crashlytics.a.b.a()
            r0.a(r10)
            return
        L_0x008f:
            r0 = move-exception
        L_0x0090:
            com.google.firebase.crashlytics.a.c.g.a((java.io.Flushable) r2)
            com.google.firebase.crashlytics.a.c.g.a((java.io.Closeable) r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.c.i.b(com.google.firebase.crashlytics.a.c.i, java.lang.Thread, java.lang.Throwable, long):void");
    }
}
