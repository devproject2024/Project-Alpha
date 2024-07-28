package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.play.core.b.al;
import com.google.android.play.core.b.o;
import com.google.android.play.core.b.p;
import com.google.android.play.core.b.r;
import com.google.android.play.core.d.at;
import com.google.android.play.core.d.av;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReference<a> f37494a = new AtomicReference<>((Object) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final e f37495b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<String> f37496c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    private final b f37497d;

    private a(Context context) {
        try {
            this.f37495b = new e(context);
            this.f37497d = new b(this.f37495b);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new al("Failed to initialize FileStorage", e2);
        }
    }

    public static boolean a() {
        return f37494a.get() != null;
    }

    public static boolean a(Context context) {
        return a(context, false);
    }

    private static boolean a(Context context, boolean z) {
        if (!b()) {
            boolean compareAndSet = f37494a.compareAndSet((Object) null, new a(context));
            a aVar = f37494a.get();
            if (compareAndSet) {
                at.f37361a.a(new o(context, r.a(), new p(context, aVar.f37495b, new r()), aVar.f37495b, new r()));
                av.a(new n(aVar));
                r.a().execute(new o(context));
            }
            try {
                aVar.b(context, z);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static boolean b() {
        return Build.VERSION.SDK_INT < 21;
    }

    public static boolean b(Context context) {
        if (b()) {
            return false;
        }
        a aVar = f37494a.get();
        if (aVar != null) {
            return aVar.f37497d.a(context, aVar.c());
        }
        throw new IllegalStateException("SplitCompat.installActivity can only be called if SplitCompat.install is first called at startup on application context.");
    }

    /* access modifiers changed from: private */
    public final Set<String> c() {
        HashSet hashSet;
        synchronized (this.f37496c) {
            hashSet = new HashSet(this.f37496c);
        }
        return hashSet;
    }

    public static boolean c(Context context) {
        return a(context, true);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0200 A[SYNTHETIC, Splitter:B:97:0x0200] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void b(android.content.Context r12, boolean r13) throws java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            if (r13 != 0) goto L_0x0010
            java.util.concurrent.Executor r0 = com.google.android.play.core.splitcompat.r.a()     // Catch:{ all -> 0x029b }
            com.google.android.play.core.splitcompat.p r1 = new com.google.android.play.core.splitcompat.p     // Catch:{ all -> 0x029b }
            r1.<init>(r11)     // Catch:{ all -> 0x029b }
            r0.execute(r1)     // Catch:{ all -> 0x029b }
            goto L_0x0015
        L_0x0010:
            com.google.android.play.core.splitcompat.e r0 = r11.f37495b     // Catch:{ all -> 0x029b }
            r0.a()     // Catch:{ all -> 0x029b }
        L_0x0015:
            java.lang.String r0 = r12.getPackageName()     // Catch:{ all -> 0x029b }
            r1 = 1
            r2 = 0
            android.content.pm.PackageManager r3 = r12.getPackageManager()     // Catch:{ NameNotFoundException -> 0x028a }
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r0, r2)     // Catch:{ NameNotFoundException -> 0x028a }
            java.lang.String[] r4 = r3.splitNames     // Catch:{ NameNotFoundException -> 0x028a }
            if (r4 != 0) goto L_0x002d
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ NameNotFoundException -> 0x028a }
            r3.<init>()     // Catch:{ NameNotFoundException -> 0x028a }
            goto L_0x0033
        L_0x002d:
            java.lang.String[] r3 = r3.splitNames     // Catch:{ NameNotFoundException -> 0x028a }
            java.util.List r3 = java.util.Arrays.asList(r3)     // Catch:{ NameNotFoundException -> 0x028a }
        L_0x0033:
            com.google.android.play.core.splitcompat.e r0 = r11.f37495b     // Catch:{ all -> 0x029b }
            java.util.Set r0 = r0.f()     // Catch:{ all -> 0x029b }
            java.util.HashSet r4 = new java.util.HashSet     // Catch:{ all -> 0x029b }
            r4.<init>()     // Catch:{ all -> 0x029b }
            java.util.Iterator r5 = r0.iterator()     // Catch:{ all -> 0x029b }
        L_0x0042:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x029b }
            if (r6 == 0) goto L_0x0067
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x029b }
            com.google.android.play.core.splitcompat.s r6 = (com.google.android.play.core.splitcompat.s) r6     // Catch:{ all -> 0x029b }
            java.lang.String r6 = r6.b()     // Catch:{ all -> 0x029b }
            boolean r7 = r3.contains(r6)     // Catch:{ all -> 0x029b }
            if (r7 == 0) goto L_0x0042
            if (r13 != 0) goto L_0x005e
            r4.add(r6)     // Catch:{ all -> 0x029b }
            goto L_0x0063
        L_0x005e:
            com.google.android.play.core.splitcompat.e r7 = r11.f37495b     // Catch:{ all -> 0x029b }
            r7.f(r6)     // Catch:{ all -> 0x029b }
        L_0x0063:
            r5.remove()     // Catch:{ all -> 0x029b }
            goto L_0x0042
        L_0x0067:
            boolean r5 = r4.isEmpty()     // Catch:{ all -> 0x029b }
            if (r5 != 0) goto L_0x0079
            java.util.concurrent.Executor r5 = com.google.android.play.core.splitcompat.r.a()     // Catch:{ all -> 0x029b }
            com.google.android.play.core.splitcompat.q r6 = new com.google.android.play.core.splitcompat.q     // Catch:{ all -> 0x029b }
            r6.<init>(r11, r4)     // Catch:{ all -> 0x029b }
            r5.execute(r6)     // Catch:{ all -> 0x029b }
        L_0x0079:
            java.util.HashSet r4 = new java.util.HashSet     // Catch:{ all -> 0x029b }
            r4.<init>()     // Catch:{ all -> 0x029b }
            java.util.Iterator r5 = r0.iterator()     // Catch:{ all -> 0x029b }
        L_0x0082:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x029b }
            if (r6 == 0) goto L_0x009c
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x029b }
            com.google.android.play.core.splitcompat.s r6 = (com.google.android.play.core.splitcompat.s) r6     // Catch:{ all -> 0x029b }
            java.lang.String r6 = r6.b()     // Catch:{ all -> 0x029b }
            boolean r7 = com.google.android.play.core.d.aw.b(r6)     // Catch:{ all -> 0x029b }
            if (r7 != 0) goto L_0x0082
            r4.add(r6)     // Catch:{ all -> 0x029b }
            goto L_0x0082
        L_0x009c:
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x029b }
        L_0x00a0:
            boolean r5 = r3.hasNext()     // Catch:{ all -> 0x029b }
            if (r5 == 0) goto L_0x00b6
            java.lang.Object r5 = r3.next()     // Catch:{ all -> 0x029b }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x029b }
            boolean r6 = com.google.android.play.core.d.aw.b(r5)     // Catch:{ all -> 0x029b }
            if (r6 != 0) goto L_0x00a0
            r4.add(r5)     // Catch:{ all -> 0x029b }
            goto L_0x00a0
        L_0x00b6:
            java.util.HashSet r3 = new java.util.HashSet     // Catch:{ all -> 0x029b }
            int r5 = r0.size()     // Catch:{ all -> 0x029b }
            r3.<init>(r5)     // Catch:{ all -> 0x029b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x029b }
        L_0x00c3:
            boolean r5 = r0.hasNext()     // Catch:{ all -> 0x029b }
            if (r5 == 0) goto L_0x00f9
            java.lang.Object r5 = r0.next()     // Catch:{ all -> 0x029b }
            com.google.android.play.core.splitcompat.s r5 = (com.google.android.play.core.splitcompat.s) r5     // Catch:{ all -> 0x029b }
            java.lang.String r6 = r5.b()     // Catch:{ all -> 0x029b }
            boolean r6 = com.google.android.play.core.d.aw.a(r6)     // Catch:{ all -> 0x029b }
            if (r6 != 0) goto L_0x00f5
            java.lang.String r6 = r5.b()     // Catch:{ all -> 0x029b }
            boolean r7 = com.google.android.play.core.d.aw.a(r6)     // Catch:{ all -> 0x029b }
            if (r7 != 0) goto L_0x00ed
            java.lang.String r7 = "\\.config\\."
            r8 = 2
            java.lang.String[] r6 = r6.split(r7, r8)     // Catch:{ all -> 0x029b }
            r6 = r6[r2]     // Catch:{ all -> 0x029b }
            goto L_0x00ef
        L_0x00ed:
            java.lang.String r6 = ""
        L_0x00ef:
            boolean r6 = r4.contains(r6)     // Catch:{ all -> 0x029b }
            if (r6 == 0) goto L_0x00c3
        L_0x00f5:
            r3.add(r5)     // Catch:{ all -> 0x029b }
            goto L_0x00c3
        L_0x00f9:
            com.google.android.play.core.splitcompat.m r0 = new com.google.android.play.core.splitcompat.m     // Catch:{ all -> 0x029b }
            com.google.android.play.core.splitcompat.e r2 = r11.f37495b     // Catch:{ all -> 0x029b }
            r0.<init>(r2)     // Catch:{ all -> 0x029b }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x029b }
            r4 = 21
            if (r2 < r4) goto L_0x0282
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x029b }
            switch(r2) {
                case 21: goto L_0x0134;
                case 22: goto L_0x012e;
                case 23: goto L_0x0128;
                case 24: goto L_0x0122;
                case 25: goto L_0x011c;
                case 26: goto L_0x0116;
                case 27: goto L_0x010c;
                default: goto L_0x010b;
            }     // Catch:{ all -> 0x029b }
        L_0x010b:
            goto L_0x013a
        L_0x010c:
            int r2 = android.os.Build.VERSION.PREVIEW_SDK_INT     // Catch:{ all -> 0x029b }
            if (r2 != 0) goto L_0x013a
            com.google.android.play.core.b.ai r2 = new com.google.android.play.core.b.ai     // Catch:{ all -> 0x029b }
            r2.<init>()     // Catch:{ all -> 0x029b }
            goto L_0x013f
        L_0x0116:
            com.google.android.play.core.b.ah r2 = new com.google.android.play.core.b.ah     // Catch:{ all -> 0x029b }
            r2.<init>()     // Catch:{ all -> 0x029b }
            goto L_0x013f
        L_0x011c:
            com.google.android.play.core.b.ae r2 = new com.google.android.play.core.b.ae     // Catch:{ all -> 0x029b }
            r2.<init>()     // Catch:{ all -> 0x029b }
            goto L_0x013f
        L_0x0122:
            com.google.android.play.core.b.ad r2 = new com.google.android.play.core.b.ad     // Catch:{ all -> 0x029b }
            r2.<init>()     // Catch:{ all -> 0x029b }
            goto L_0x013f
        L_0x0128:
            com.google.android.play.core.b.ac r2 = new com.google.android.play.core.b.ac     // Catch:{ all -> 0x029b }
            r2.<init>()     // Catch:{ all -> 0x029b }
            goto L_0x013f
        L_0x012e:
            com.google.android.play.core.b.x r2 = new com.google.android.play.core.b.x     // Catch:{ all -> 0x029b }
            r2.<init>()     // Catch:{ all -> 0x029b }
            goto L_0x013f
        L_0x0134:
            com.google.android.play.core.b.w r2 = new com.google.android.play.core.b.w     // Catch:{ all -> 0x029b }
            r2.<init>()     // Catch:{ all -> 0x029b }
            goto L_0x013f
        L_0x013a:
            com.google.android.play.core.b.ak r2 = new com.google.android.play.core.b.ak     // Catch:{ all -> 0x029b }
            r2.<init>()     // Catch:{ all -> 0x029b }
        L_0x013f:
            java.lang.ClassLoader r4 = r12.getClassLoader()     // Catch:{ all -> 0x029b }
            r5 = 0
            if (r13 == 0) goto L_0x014e
            java.util.Set r0 = r0.a()     // Catch:{ all -> 0x029b }
            r2.a(r4, r0)     // Catch:{ all -> 0x029b }
            goto L_0x0182
        L_0x014e:
            java.util.Iterator r6 = r3.iterator()     // Catch:{ all -> 0x029b }
        L_0x0152:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x029b }
            if (r7 == 0) goto L_0x0182
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x029b }
            com.google.android.play.core.splitcompat.s r7 = (com.google.android.play.core.splitcompat.s) r7     // Catch:{ all -> 0x029b }
            java.util.concurrent.atomic.AtomicBoolean r8 = new java.util.concurrent.atomic.AtomicBoolean     // Catch:{ all -> 0x029b }
            r8.<init>(r1)     // Catch:{ all -> 0x029b }
            java.util.HashSet r9 = new java.util.HashSet     // Catch:{ all -> 0x029b }
            r9.<init>()     // Catch:{ all -> 0x029b }
            com.google.android.play.core.splitcompat.g r10 = new com.google.android.play.core.splitcompat.g     // Catch:{ all -> 0x029b }
            r10.<init>(r0, r7, r9, r8)     // Catch:{ all -> 0x029b }
            com.google.android.play.core.splitcompat.m.a(r7, r10)     // Catch:{ all -> 0x029b }
            boolean r7 = r8.get()     // Catch:{ all -> 0x029b }
            if (r7 == 0) goto L_0x0177
            goto L_0x0178
        L_0x0177:
            r9 = r5
        L_0x0178:
            if (r9 != 0) goto L_0x017e
            r6.remove()     // Catch:{ all -> 0x029b }
            goto L_0x0152
        L_0x017e:
            r2.a(r4, r9)     // Catch:{ all -> 0x029b }
            goto L_0x0152
        L_0x0182:
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ all -> 0x029b }
            r0.<init>()     // Catch:{ all -> 0x029b }
            java.util.Iterator r1 = r3.iterator()     // Catch:{ all -> 0x029b }
        L_0x018b:
            boolean r6 = r1.hasNext()     // Catch:{ all -> 0x029b }
            if (r6 == 0) goto L_0x0209
            java.lang.Object r6 = r1.next()     // Catch:{ all -> 0x029b }
            com.google.android.play.core.splitcompat.s r6 = (com.google.android.play.core.splitcompat.s) r6     // Catch:{ all -> 0x029b }
            java.util.zip.ZipFile r7 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x01fd }
            java.io.File r8 = r6.a()     // Catch:{ IOException -> 0x01fd }
            r7.<init>(r8)     // Catch:{ IOException -> 0x01fd }
            java.lang.String r8 = "classes.dex"
            java.util.zip.ZipEntry r8 = r7.getEntry(r8)     // Catch:{ IOException -> 0x01fa }
            r7.close()     // Catch:{ IOException -> 0x01fa }
            if (r8 == 0) goto L_0x01f2
            com.google.android.play.core.splitcompat.e r7 = r11.f37495b     // Catch:{ all -> 0x029b }
            java.lang.String r8 = r6.b()     // Catch:{ all -> 0x029b }
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x029b }
            java.io.File r7 = r7.d()     // Catch:{ all -> 0x029b }
            java.lang.String r10 = "dex"
            r9.<init>(r7, r10)     // Catch:{ all -> 0x029b }
            com.google.android.play.core.splitcompat.e.b((java.io.File) r9)     // Catch:{ all -> 0x029b }
            java.io.File r7 = com.google.android.play.core.splitcompat.e.a(r9, r8)     // Catch:{ all -> 0x029b }
            com.google.android.play.core.splitcompat.e.b((java.io.File) r7)     // Catch:{ all -> 0x029b }
            java.io.File r8 = r6.a()     // Catch:{ all -> 0x029b }
            boolean r7 = r2.a(r4, r7, r8, r13)     // Catch:{ all -> 0x029b }
            if (r7 == 0) goto L_0x01d1
            goto L_0x01f2
        L_0x01d1:
            java.io.File r6 = r6.a()     // Catch:{ all -> 0x029b }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x029b }
            java.lang.String r7 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x029b }
            int r7 = r7.length()     // Catch:{ all -> 0x029b }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x029b }
            int r7 = r7 + 24
            r8.<init>(r7)     // Catch:{ all -> 0x029b }
            java.lang.String r7 = "split was not installed "
            r8.append(r7)     // Catch:{ all -> 0x029b }
            r8.append(r6)     // Catch:{ all -> 0x029b }
            goto L_0x018b
        L_0x01f2:
            java.io.File r6 = r6.a()     // Catch:{ all -> 0x029b }
            r0.add(r6)     // Catch:{ all -> 0x029b }
            goto L_0x018b
        L_0x01fa:
            r12 = move-exception
            r5 = r7
            goto L_0x01fe
        L_0x01fd:
            r12 = move-exception
        L_0x01fe:
            if (r5 == 0) goto L_0x0208
            r5.close()     // Catch:{ IOException -> 0x0204 }
            goto L_0x0208
        L_0x0204:
            r13 = move-exception
            com.google.android.play.core.b.bg.a(r12, r13)     // Catch:{ all -> 0x029b }
        L_0x0208:
            throw r12     // Catch:{ all -> 0x029b }
        L_0x0209:
            com.google.android.play.core.splitcompat.b.b(r12, r0)     // Catch:{ all -> 0x029b }
            java.util.HashSet r12 = new java.util.HashSet     // Catch:{ all -> 0x029b }
            r12.<init>()     // Catch:{ all -> 0x029b }
            java.util.Iterator r13 = r3.iterator()     // Catch:{ all -> 0x029b }
        L_0x0215:
            boolean r1 = r13.hasNext()     // Catch:{ all -> 0x029b }
            if (r1 == 0) goto L_0x0274
            java.lang.Object r1 = r13.next()     // Catch:{ all -> 0x029b }
            com.google.android.play.core.splitcompat.s r1 = (com.google.android.play.core.splitcompat.s) r1     // Catch:{ all -> 0x029b }
            java.io.File r2 = r1.a()     // Catch:{ all -> 0x029b }
            boolean r2 = r0.contains(r2)     // Catch:{ all -> 0x029b }
            if (r2 == 0) goto L_0x0253
            java.lang.String r2 = r1.b()     // Catch:{ all -> 0x029b }
            java.lang.String r3 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x029b }
            int r3 = r3.length()     // Catch:{ all -> 0x029b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x029b }
            int r3 = r3 + 30
            r4.<init>(r3)     // Catch:{ all -> 0x029b }
            java.lang.String r3 = "Split '"
            r4.append(r3)     // Catch:{ all -> 0x029b }
            r4.append(r2)     // Catch:{ all -> 0x029b }
            java.lang.String r2 = "' installation emulated"
            r4.append(r2)     // Catch:{ all -> 0x029b }
            java.lang.String r1 = r1.b()     // Catch:{ all -> 0x029b }
            r12.add(r1)     // Catch:{ all -> 0x029b }
            goto L_0x0215
        L_0x0253:
            java.lang.String r1 = r1.b()     // Catch:{ all -> 0x029b }
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x029b }
            int r2 = r2.length()     // Catch:{ all -> 0x029b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x029b }
            int r2 = r2 + 35
            r3.<init>(r2)     // Catch:{ all -> 0x029b }
            java.lang.String r2 = "Split '"
            r3.append(r2)     // Catch:{ all -> 0x029b }
            r3.append(r1)     // Catch:{ all -> 0x029b }
            java.lang.String r1 = "' installation not emulated."
            r3.append(r1)     // Catch:{ all -> 0x029b }
            goto L_0x0215
        L_0x0274:
            java.util.Set<java.lang.String> r13 = r11.f37496c     // Catch:{ all -> 0x029b }
            monitor-enter(r13)     // Catch:{ all -> 0x029b }
            java.util.Set<java.lang.String> r0 = r11.f37496c     // Catch:{ all -> 0x027f }
            r0.addAll(r12)     // Catch:{ all -> 0x027f }
            monitor-exit(r13)     // Catch:{ all -> 0x027f }
            monitor-exit(r11)
            return
        L_0x027f:
            r12 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x027f }
            throw r12     // Catch:{ all -> 0x029b }
        L_0x0282:
            java.lang.AssertionError r12 = new java.lang.AssertionError     // Catch:{ all -> 0x029b }
            java.lang.String r13 = "Unsupported Android Version"
            r12.<init>(r13)     // Catch:{ all -> 0x029b }
            throw r12     // Catch:{ all -> 0x029b }
        L_0x028a:
            r12 = move-exception
            java.io.IOException r13 = new java.io.IOException     // Catch:{ all -> 0x029b }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x029b }
            r1[r2] = r0     // Catch:{ all -> 0x029b }
            java.lang.String r0 = "Cannot load data for application '%s'"
            java.lang.String r0 = java.lang.String.format(r0, r1)     // Catch:{ all -> 0x029b }
            r13.<init>(r0, r12)     // Catch:{ all -> 0x029b }
            throw r13     // Catch:{ all -> 0x029b }
        L_0x029b:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitcompat.a.b(android.content.Context, boolean):void");
    }
}
