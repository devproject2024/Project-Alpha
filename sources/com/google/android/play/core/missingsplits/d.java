package com.google.android.play.core.missingsplits;

import android.app.ActivityManager;
import android.content.Context;
import com.google.android.play.core.b.b;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

final class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final b f37489a = new b("MissingSplitsManagerImpl");

    /* renamed from: b  reason: collision with root package name */
    private final Context f37490b;

    /* renamed from: c  reason: collision with root package name */
    private final Runtime f37491c;

    /* renamed from: d  reason: collision with root package name */
    private final c f37492d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicReference<Boolean> f37493e;

    d(Context context, Runtime runtime, c cVar, AtomicReference<Boolean> atomicReference) {
        this.f37490b = context;
        this.f37491c = runtime;
        this.f37492d = cVar;
        this.f37493e = atomicReference;
    }

    private final List<ActivityManager.AppTask> b() {
        List<ActivityManager.AppTask> appTasks = ((ActivityManager) this.f37490b.getSystemService("activity")).getAppTasks();
        return appTasks == null ? Collections.emptyList() : appTasks;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        f37489a.e("App '%s' is not found in PackageManager", r8.f37490b.getPackageName());
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006a */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0085 A[Catch:{ NameNotFoundException -> 0x0096 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() {
        /*
            r8 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            r2 = 0
            if (r0 < r1) goto L_0x01dc
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r0 = r8.f37493e
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r3 = r8.f37493e     // Catch:{ all -> 0x01d9 }
            java.lang.Object r3 = r3.get()     // Catch:{ all -> 0x01d9 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x01d9 }
            r4 = 1
            if (r3 == 0) goto L_0x0017
            goto L_0x00af
        L_0x0017:
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r3 = r8.f37493e     // Catch:{ all -> 0x01d9 }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01d9 }
            if (r5 < r1) goto L_0x00a7
            android.content.Context r5 = r8.f37490b     // Catch:{ all -> 0x01d9 }
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch:{ all -> 0x01d9 }
            android.content.Context r6 = r8.f37490b     // Catch:{ NameNotFoundException -> 0x0096 }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ NameNotFoundException -> 0x0096 }
            r7 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo(r6, r7)     // Catch:{ NameNotFoundException -> 0x0096 }
            if (r5 == 0) goto L_0x00a7
            android.os.Bundle r6 = r5.metaData     // Catch:{ NameNotFoundException -> 0x0096 }
            if (r6 == 0) goto L_0x00a7
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ NameNotFoundException -> 0x0096 }
            android.os.Bundle r5 = r5.metaData     // Catch:{ NameNotFoundException -> 0x0096 }
            java.lang.String r7 = "com.android.vending.splits.required"
            java.lang.Object r5 = r5.get(r7)     // Catch:{ NameNotFoundException -> 0x0096 }
            boolean r5 = r6.equals(r5)     // Catch:{ NameNotFoundException -> 0x0096 }
            if (r5 == 0) goto L_0x00a7
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01d9 }
            if (r5 < r1) goto L_0x007b
            android.content.Context r1 = r8.f37490b     // Catch:{ NameNotFoundException -> 0x006a }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ NameNotFoundException -> 0x006a }
            android.content.Context r5 = r8.f37490b     // Catch:{ NameNotFoundException -> 0x006a }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ NameNotFoundException -> 0x006a }
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r5, r2)     // Catch:{ NameNotFoundException -> 0x006a }
            java.util.HashSet r5 = new java.util.HashSet     // Catch:{ NameNotFoundException -> 0x006a }
            r5.<init>()     // Catch:{ NameNotFoundException -> 0x006a }
            if (r1 == 0) goto L_0x007f
            java.lang.String[] r6 = r1.splitNames     // Catch:{ NameNotFoundException -> 0x006a }
            if (r6 == 0) goto L_0x007f
            java.lang.String[] r1 = r1.splitNames     // Catch:{ NameNotFoundException -> 0x006a }
            java.util.Collections.addAll(r5, r1)     // Catch:{ NameNotFoundException -> 0x006a }
            goto L_0x007f
        L_0x006a:
            com.google.android.play.core.b.b r1 = f37489a     // Catch:{ all -> 0x01d9 }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x01d9 }
            android.content.Context r6 = r8.f37490b     // Catch:{ all -> 0x01d9 }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ all -> 0x01d9 }
            r5[r2] = r6     // Catch:{ all -> 0x01d9 }
            java.lang.String r6 = "App '%s' is not found in PackageManager"
            r1.e(r6, r5)     // Catch:{ all -> 0x01d9 }
        L_0x007b:
            java.util.Set r5 = java.util.Collections.emptySet()     // Catch:{ all -> 0x01d9 }
        L_0x007f:
            boolean r1 = r5.isEmpty()     // Catch:{ all -> 0x01d9 }
            if (r1 != 0) goto L_0x0094
            int r1 = r5.size()     // Catch:{ all -> 0x01d9 }
            if (r1 != r4) goto L_0x00a7
            java.lang.String r1 = ""
            boolean r1 = r5.contains(r1)     // Catch:{ all -> 0x01d9 }
            if (r1 != 0) goto L_0x0094
            goto L_0x00a7
        L_0x0094:
            r1 = 1
            goto L_0x00a8
        L_0x0096:
            com.google.android.play.core.b.b r1 = f37489a     // Catch:{ all -> 0x01d9 }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x01d9 }
            android.content.Context r6 = r8.f37490b     // Catch:{ all -> 0x01d9 }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ all -> 0x01d9 }
            r5[r2] = r6     // Catch:{ all -> 0x01d9 }
            java.lang.String r6 = "App '%s' is not found in the PackageManager"
            r1.e(r6, r5)     // Catch:{ all -> 0x01d9 }
        L_0x00a7:
            r1 = 0
        L_0x00a8:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x01d9 }
            r3.set(r1)     // Catch:{ all -> 0x01d9 }
        L_0x00af:
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r1 = r8.f37493e     // Catch:{ all -> 0x01d9 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x01d9 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x01d9 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x01d9 }
            monitor-exit(r0)     // Catch:{ all -> 0x01d9 }
            if (r1 == 0) goto L_0x01c6
            java.util.List r0 = r8.b()
            java.util.Iterator r0 = r0.iterator()
        L_0x00c6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0108
            java.lang.Object r1 = r0.next()
            android.app.ActivityManager$AppTask r1 = (android.app.ActivityManager.AppTask) r1
            android.app.ActivityManager$RecentTaskInfo r3 = r1.getTaskInfo()
            if (r3 == 0) goto L_0x00c6
            android.app.ActivityManager$RecentTaskInfo r3 = r1.getTaskInfo()
            android.content.Intent r3 = r3.baseIntent
            if (r3 == 0) goto L_0x00c6
            android.app.ActivityManager$RecentTaskInfo r3 = r1.getTaskInfo()
            android.content.Intent r3 = r3.baseIntent
            android.content.ComponentName r3 = r3.getComponent()
            if (r3 == 0) goto L_0x00c6
            android.app.ActivityManager$RecentTaskInfo r1 = r1.getTaskInfo()
            android.content.Intent r1 = r1.baseIntent
            android.content.ComponentName r1 = r1.getComponent()
            java.lang.String r1 = r1.getClassName()
            java.lang.Class<com.google.android.play.core.missingsplits.PlayCoreMissingSplitsActivity> r3 = com.google.android.play.core.missingsplits.PlayCoreMissingSplitsActivity.class
            java.lang.String r3 = r3.getName()
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x00c6
            goto L_0x01c5
        L_0x0108:
            java.util.List r0 = r8.b()
            java.util.Iterator r0 = r0.iterator()
        L_0x0110:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x016c
            java.lang.Object r1 = r0.next()
            android.app.ActivityManager$AppTask r1 = (android.app.ActivityManager.AppTask) r1
            android.app.ActivityManager$RecentTaskInfo r1 = r1.getTaskInfo()
            if (r1 == 0) goto L_0x0110
            android.content.Intent r3 = r1.baseIntent
            if (r3 == 0) goto L_0x0110
            android.content.Intent r3 = r1.baseIntent
            android.content.ComponentName r3 = r3.getComponent()
            if (r3 == 0) goto L_0x0110
            android.content.Intent r1 = r1.baseIntent
            android.content.ComponentName r1 = r1.getComponent()
            java.lang.String r3 = r1.getClassName()
            java.lang.Class r1 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x0152 }
        L_0x013c:
            if (r1 == 0) goto L_0x0110
            java.lang.Class<android.app.Activity> r3 = android.app.Activity.class
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0150
            java.lang.Class r3 = r1.getSuperclass()
            if (r3 == r1) goto L_0x014e
            r1 = r3
            goto L_0x013c
        L_0x014e:
            r1 = 0
            goto L_0x013c
        L_0x0150:
            r0 = 1
            goto L_0x016d
        L_0x0152:
            com.google.android.play.core.b.b r5 = f37489a
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r6[r2] = r3
            java.lang.String r3 = "ClassNotFoundException when scanning class hierarchy of '%s'"
            r5.e(r3, r6)
            android.content.Context r3 = r8.f37490b     // Catch:{ NameNotFoundException -> 0x016a }
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ NameNotFoundException -> 0x016a }
            android.content.pm.ActivityInfo r1 = r3.getActivityInfo(r1, r2)     // Catch:{ NameNotFoundException -> 0x016a }
            if (r1 == 0) goto L_0x0110
            goto L_0x0150
        L_0x016a:
            goto L_0x0110
        L_0x016c:
            r0 = 0
        L_0x016d:
            com.google.android.play.core.missingsplits.c r1 = r8.f37492d
            com.google.android.play.core.b.b r3 = com.google.android.play.core.missingsplits.c.f37486a
            java.lang.Object[] r5 = new java.lang.Object[r2]
            java.lang.String r6 = "Disabling all non-activity components"
            r3.d(r6, r5)
            java.util.List r3 = r1.c()
            r5 = 2
            r1.a(r3, r5)
            java.util.List r1 = r8.b()
            java.util.Iterator r1 = r1.iterator()
        L_0x0188:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0198
            java.lang.Object r3 = r1.next()
            android.app.ActivityManager$AppTask r3 = (android.app.ActivityManager.AppTask) r3
            r3.finishAndRemoveTask()
            goto L_0x0188
        L_0x0198:
            if (r0 == 0) goto L_0x01c0
            android.content.Context r0 = r8.f37490b
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            android.content.ComponentName r1 = new android.content.ComponentName
            android.content.Context r3 = r8.f37490b
            java.lang.Class<com.google.android.play.core.missingsplits.PlayCoreMissingSplitsActivity> r5 = com.google.android.play.core.missingsplits.PlayCoreMissingSplitsActivity.class
            r1.<init>(r3, r5)
            r0.setComponentEnabledSetting(r1, r4, r4)
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r1 = r8.f37490b
            java.lang.Class<com.google.android.play.core.missingsplits.PlayCoreMissingSplitsActivity> r3 = com.google.android.play.core.missingsplits.PlayCoreMissingSplitsActivity.class
            r0.<init>(r1, r3)
            r1 = 884998144(0x34c00000, float:3.5762787E-7)
            android.content.Intent r0 = r0.addFlags(r1)
            android.content.Context r1 = r8.f37490b
            r1.startActivity(r0)
        L_0x01c0:
            java.lang.Runtime r0 = r8.f37491c
            r0.exit(r2)
        L_0x01c5:
            return r4
        L_0x01c6:
            com.google.android.play.core.missingsplits.c r0 = r8.f37492d
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x01d8
            com.google.android.play.core.missingsplits.c r0 = r8.f37492d
            r0.b()
            java.lang.Runtime r0 = r8.f37491c
            r0.exit(r2)
        L_0x01d8:
            return r2
        L_0x01d9:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01d9 }
            throw r1
        L_0x01dc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.missingsplits.d.a():boolean");
    }
}
