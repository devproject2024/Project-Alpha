package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.RemoteException;
import com.business.merchant_payments.common.utility.AppUtility;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.g;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.lang.reflect.Field;

public final class DynamiteModule {

    /* renamed from: a  reason: collision with root package name */
    public static final b f9008a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final b f9009b = new d();

    /* renamed from: c  reason: collision with root package name */
    public static final b f9010c = new c();

    /* renamed from: d  reason: collision with root package name */
    public static final b f9011d = new f();

    /* renamed from: e  reason: collision with root package name */
    public static final b f9012e = new e();

    /* renamed from: f  reason: collision with root package name */
    public static final b f9013f = new h();

    /* renamed from: h  reason: collision with root package name */
    private static Boolean f9014h = null;

    /* renamed from: i  reason: collision with root package name */
    private static k f9015i = null;
    private static m j = null;
    private static String k = null;
    private static int l = -1;
    private static final ThreadLocal<c> m = new ThreadLocal<>();
    private static final b.C0134b n = new b();
    private static final b o = new g();

    /* renamed from: g  reason: collision with root package name */
    public final Context f9016g;

    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    public interface b {

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public int f9017a = 0;

            /* renamed from: b  reason: collision with root package name */
            public int f9018b = 0;

            /* renamed from: c  reason: collision with root package name */
            public int f9019c = 0;
        }

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$b$b  reason: collision with other inner class name */
        public interface C0134b {
            int a(Context context, String str);

            int a(Context context, String str, boolean z) throws a;
        }

        a a(Context context, String str, C0134b bVar) throws a;
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        public Cursor f9020a;

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    public static DynamiteModule a(Context context, b bVar, String str) throws a {
        b.a a2;
        c cVar = m.get();
        c cVar2 = new c((byte) 0);
        m.set(cVar2);
        try {
            a2 = bVar.a(context, str, n);
            int i2 = a2.f9017a;
            int i3 = a2.f9018b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(AppConstants.COLON);
            sb.append(i2);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(AppConstants.COLON);
            sb.append(i3);
            if (a2.f9019c == 0 || ((a2.f9019c == -1 && a2.f9017a == 0) || (a2.f9019c == 1 && a2.f9018b == 0))) {
                int i4 = a2.f9017a;
                int i5 = a2.f9018b;
                StringBuilder sb2 = new StringBuilder(91);
                sb2.append("No acceptable module found. Local version is ");
                sb2.append(i4);
                sb2.append(" and remote version is ");
                sb2.append(i5);
                sb2.append(AppUtility.CENTER_DOT);
                throw new a(sb2.toString(), (b) null);
            } else if (a2.f9019c == -1) {
                DynamiteModule c2 = c(context, str);
                if (cVar2.f9020a != null) {
                    cVar2.f9020a.close();
                }
                m.set(cVar);
                return c2;
            } else if (a2.f9019c == 1) {
                DynamiteModule a3 = a(context, str, a2.f9018b);
                if (cVar2.f9020a != null) {
                    cVar2.f9020a.close();
                }
                m.set(cVar);
                return a3;
            } else {
                int i6 = a2.f9019c;
                StringBuilder sb3 = new StringBuilder(47);
                sb3.append("VersionPolicy returned invalid code:");
                sb3.append(i6);
                throw new a(sb3.toString(), (b) null);
            }
        } catch (a e2) {
            String valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                "Failed to load remote module: ".concat(valueOf);
            } else {
                new String("Failed to load remote module: ");
            }
            if (a2.f9017a == 0 || bVar.a(context, str, new d(a2.f9017a)).f9019c != -1) {
                throw new a("Remote load failed. No local fallback found.", e2, (b) null);
            }
            DynamiteModule c3 = c(context, str);
            if (cVar2.f9020a != null) {
                cVar2.f9020a.close();
            }
            m.set(cVar);
            return c3;
        } catch (Throwable th) {
            if (cVar2.f9020a != null) {
                cVar2.f9020a.close();
            }
            m.set(cVar);
            throw th;
        }
    }

    public static class a extends Exception {
        private a(String str) {
            super(str);
        }

        private a(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ a(String str, b bVar) {
            this(str);
        }

        /* synthetic */ a(String str, Throwable th, b bVar) {
            this(str, th);
        }
    }

    static class d implements b.C0134b {

        /* renamed from: a  reason: collision with root package name */
        private final int f9021a;

        /* renamed from: b  reason: collision with root package name */
        private final int f9022b = 0;

        public d(int i2) {
            this.f9021a = i2;
        }

        public final int a(Context context, String str, boolean z) {
            return 0;
        }

        public final int a(Context context, String str) {
            return this.f9021a;
        }
    }

    public static int a(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get((Object) null).equals(str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            return 0;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            if (valueOf2.length() != 0) {
                "Failed to load module descriptor class: ".concat(valueOf2);
            } else {
                new String("Failed to load module descriptor class: ");
            }
            return 0;
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:39:0x0091=Splitter:B:39:0x0091, B:23:0x0056=Splitter:B:23:0x0056, B:18:0x0039=Splitter:B:18:0x0039} */
    public static int a(android.content.Context r8, java.lang.String r9, boolean r10) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)     // Catch:{ all -> 0x00f6 }
            java.lang.Boolean r1 = f9014h     // Catch:{ all -> 0x00f3 }
            if (r1 != 0) goto L_0x00c6
            android.content.Context r1 = r8.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x00a6, IllegalAccessException -> 0x00a4, NoSuchFieldException -> 0x00a2 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00a6, IllegalAccessException -> 0x00a4, NoSuchFieldException -> 0x00a2 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r2 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r2 = r2.getName()     // Catch:{ ClassNotFoundException -> 0x00a6, IllegalAccessException -> 0x00a4, NoSuchFieldException -> 0x00a2 }
            java.lang.Class r1 = r1.loadClass(r2)     // Catch:{ ClassNotFoundException -> 0x00a6, IllegalAccessException -> 0x00a4, NoSuchFieldException -> 0x00a2 }
            java.lang.String r2 = "sClassLoader"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ ClassNotFoundException -> 0x00a6, IllegalAccessException -> 0x00a4, NoSuchFieldException -> 0x00a2 }
            java.lang.Class r2 = r1.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x00a6, IllegalAccessException -> 0x00a4, NoSuchFieldException -> 0x00a2 }
            monitor-enter(r2)     // Catch:{ ClassNotFoundException -> 0x00a6, IllegalAccessException -> 0x00a4, NoSuchFieldException -> 0x00a2 }
            r3 = 0
            java.lang.Object r4 = r1.get(r3)     // Catch:{ all -> 0x009f }
            java.lang.ClassLoader r4 = (java.lang.ClassLoader) r4     // Catch:{ all -> 0x009f }
            if (r4 == 0) goto L_0x003c
            java.lang.ClassLoader r1 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x009f }
            if (r4 != r1) goto L_0x0036
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x009f }
            goto L_0x009d
        L_0x0036:
            a((java.lang.ClassLoader) r4)     // Catch:{ a -> 0x0039 }
        L_0x0039:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x009f }
            goto L_0x009d
        L_0x003c:
            java.lang.String r4 = "com.google.android.gms"
            android.content.Context r5 = r8.getApplicationContext()     // Catch:{ all -> 0x009f }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ all -> 0x009f }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x009f }
            if (r4 == 0) goto L_0x0056
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x009f }
            r1.set(r3, r4)     // Catch:{ all -> 0x009f }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x009f }
            goto L_0x009d
        L_0x0056:
            int r4 = c(r8, r9, r10)     // Catch:{ a -> 0x0094 }
            java.lang.String r5 = k     // Catch:{ a -> 0x0094 }
            if (r5 == 0) goto L_0x0091
            java.lang.String r5 = k     // Catch:{ a -> 0x0094 }
            boolean r5 = r5.isEmpty()     // Catch:{ a -> 0x0094 }
            if (r5 == 0) goto L_0x0067
            goto L_0x0091
        L_0x0067:
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ a -> 0x0094 }
            r6 = 29
            if (r5 < r6) goto L_0x0079
            dalvik.system.DelegateLastClassLoader r5 = new dalvik.system.DelegateLastClassLoader     // Catch:{ a -> 0x0094 }
            java.lang.String r6 = k     // Catch:{ a -> 0x0094 }
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ a -> 0x0094 }
            r5.<init>(r6, r7)     // Catch:{ a -> 0x0094 }
            goto L_0x0084
        L_0x0079:
            com.google.android.gms.dynamite.i r5 = new com.google.android.gms.dynamite.i     // Catch:{ a -> 0x0094 }
            java.lang.String r6 = k     // Catch:{ a -> 0x0094 }
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ a -> 0x0094 }
            r5.<init>(r6, r7)     // Catch:{ a -> 0x0094 }
        L_0x0084:
            a((java.lang.ClassLoader) r5)     // Catch:{ a -> 0x0094 }
            r1.set(r3, r5)     // Catch:{ a -> 0x0094 }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ a -> 0x0094 }
            f9014h = r5     // Catch:{ a -> 0x0094 }
            monitor-exit(r2)     // Catch:{ all -> 0x009f }
            monitor-exit(r0)     // Catch:{ all -> 0x00f3 }
            return r4
        L_0x0091:
            monitor-exit(r2)     // Catch:{ all -> 0x009f }
            monitor-exit(r0)     // Catch:{ all -> 0x00f3 }
            return r4
        L_0x0094:
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x009f }
            r1.set(r3, r4)     // Catch:{ all -> 0x009f }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x009f }
        L_0x009d:
            monitor-exit(r2)     // Catch:{ all -> 0x009f }
            goto L_0x00c4
        L_0x009f:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x009f }
            throw r1     // Catch:{ ClassNotFoundException -> 0x00a6, IllegalAccessException -> 0x00a4, NoSuchFieldException -> 0x00a2 }
        L_0x00a2:
            r1 = move-exception
            goto L_0x00a7
        L_0x00a4:
            r1 = move-exception
            goto L_0x00a7
        L_0x00a6:
            r1 = move-exception
        L_0x00a7:
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00f3 }
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00f3 }
            int r2 = r2.length()     // Catch:{ all -> 0x00f3 }
            int r2 = r2 + 30
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f3 }
            r3.<init>(r2)     // Catch:{ all -> 0x00f3 }
            java.lang.String r2 = "Failed to load module via V2: "
            r3.append(r2)     // Catch:{ all -> 0x00f3 }
            r3.append(r1)     // Catch:{ all -> 0x00f3 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00f3 }
        L_0x00c4:
            f9014h = r1     // Catch:{ all -> 0x00f3 }
        L_0x00c6:
            monitor-exit(r0)     // Catch:{ all -> 0x00f3 }
            boolean r0 = r1.booleanValue()     // Catch:{ all -> 0x00f6 }
            if (r0 == 0) goto L_0x00ee
            int r8 = c(r8, r9, r10)     // Catch:{ a -> 0x00d2 }
            return r8
        L_0x00d2:
            r9 = move-exception
            java.lang.String r10 = "Failed to retrieve remote module version: "
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x00f6 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00f6 }
            int r0 = r9.length()     // Catch:{ all -> 0x00f6 }
            if (r0 == 0) goto L_0x00e7
            r10.concat(r9)     // Catch:{ all -> 0x00f6 }
            goto L_0x00ec
        L_0x00e7:
            java.lang.String r9 = new java.lang.String     // Catch:{ all -> 0x00f6 }
            r9.<init>(r10)     // Catch:{ all -> 0x00f6 }
        L_0x00ec:
            r8 = 0
            return r8
        L_0x00ee:
            int r8 = b((android.content.Context) r8, (java.lang.String) r9, (boolean) r10)     // Catch:{ all -> 0x00f6 }
            return r8
        L_0x00f3:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00f3 }
            throw r9     // Catch:{ all -> 0x00f6 }
        L_0x00f6:
            r9 = move-exception
            com.google.android.gms.common.util.g.a(r8, r9)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.a(android.content.Context, java.lang.String, boolean):int");
    }

    private static int b(Context context, String str, boolean z) {
        k a2 = a(context);
        if (a2 == null) {
            return 0;
        }
        try {
            if (a2.a() >= 2) {
                return a2.b(com.google.android.gms.b.d.a(context), str, z);
            }
            return a2.a(com.google.android.gms.b.d.a(context), str, z);
        } catch (RemoteException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                "Failed to retrieve remote module version: ".concat(valueOf);
            } else {
                new String("Failed to retrieve remote module version: ");
            }
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int c(android.content.Context r8, java.lang.String r9, boolean r10) throws com.google.android.gms.dynamite.DynamiteModule.a {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            if (r10 == 0) goto L_0x000a
            java.lang.String r8 = "api_force_staging"
            goto L_0x000c
        L_0x000a:
            java.lang.String r8 = "api"
        L_0x000c:
            int r10 = r8.length()     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            int r10 = r10 + 42
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            int r2 = r2.length()     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            int r10 = r10 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            r2.<init>(r10)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            java.lang.String r10 = "content://com.google.android.gms.chimera/"
            r2.append(r10)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            r2.append(r8)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            java.lang.String r8 = "/"
            r2.append(r8)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            r2.append(r9)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            java.lang.String r8 = r2.toString()     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            if (r8 == 0) goto L_0x0083
            boolean r9 = r8.moveToFirst()     // Catch:{ Exception -> 0x008f, all -> 0x008b }
            if (r9 == 0) goto L_0x0083
            r9 = 0
            int r9 = r8.getInt(r9)     // Catch:{ Exception -> 0x008f, all -> 0x008b }
            if (r9 <= 0) goto L_0x007d
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r10 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r10)     // Catch:{ Exception -> 0x008f, all -> 0x008b }
            r1 = 2
            java.lang.String r1 = r8.getString(r1)     // Catch:{ all -> 0x007a }
            k = r1     // Catch:{ all -> 0x007a }
            java.lang.String r1 = "loaderVersion"
            int r1 = r8.getColumnIndex(r1)     // Catch:{ all -> 0x007a }
            if (r1 < 0) goto L_0x0067
            int r1 = r8.getInt(r1)     // Catch:{ all -> 0x007a }
            l = r1     // Catch:{ all -> 0x007a }
        L_0x0067:
            monitor-exit(r10)     // Catch:{ all -> 0x007a }
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$c> r10 = m     // Catch:{ Exception -> 0x008f, all -> 0x008b }
            java.lang.Object r10 = r10.get()     // Catch:{ Exception -> 0x008f, all -> 0x008b }
            com.google.android.gms.dynamite.DynamiteModule$c r10 = (com.google.android.gms.dynamite.DynamiteModule.c) r10     // Catch:{ Exception -> 0x008f, all -> 0x008b }
            if (r10 == 0) goto L_0x007d
            android.database.Cursor r1 = r10.f9020a     // Catch:{ Exception -> 0x008f, all -> 0x008b }
            if (r1 != 0) goto L_0x007d
            r10.f9020a = r8     // Catch:{ Exception -> 0x008f, all -> 0x008b }
            r8 = r0
            goto L_0x007d
        L_0x007a:
            r9 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x007a }
            throw r9     // Catch:{ Exception -> 0x008f, all -> 0x008b }
        L_0x007d:
            if (r8 == 0) goto L_0x0082
            r8.close()
        L_0x0082:
            return r9
        L_0x0083:
            com.google.android.gms.dynamite.DynamiteModule$a r9 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ Exception -> 0x008f, all -> 0x008b }
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>((java.lang.String) r10, (com.google.android.gms.dynamite.b) r0)     // Catch:{ Exception -> 0x008f, all -> 0x008b }
            throw r9     // Catch:{ Exception -> 0x008f, all -> 0x008b }
        L_0x008b:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto L_0x00a7
        L_0x008f:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x0098
        L_0x0094:
            r8 = move-exception
            goto L_0x00a7
        L_0x0096:
            r8 = move-exception
            r9 = r0
        L_0x0098:
            boolean r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.a     // Catch:{ all -> 0x00a5 }
            if (r10 == 0) goto L_0x009d
            throw r8     // Catch:{ all -> 0x00a5 }
        L_0x009d:
            com.google.android.gms.dynamite.DynamiteModule$a r10 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ all -> 0x00a5 }
            java.lang.String r1 = "V2 version check failed"
            r10.<init>(r1, r8, r0)     // Catch:{ all -> 0x00a5 }
            throw r10     // Catch:{ all -> 0x00a5 }
        L_0x00a5:
            r8 = move-exception
            r0 = r9
        L_0x00a7:
            if (r0 == 0) goto L_0x00ac
            r0.close()
        L_0x00ac:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.c(android.content.Context, java.lang.String, boolean):int");
    }

    public static int b(Context context, String str) {
        return a(context, str, false);
    }

    private static DynamiteModule c(Context context, String str) {
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            "Selected local version of ".concat(valueOf);
        } else {
            new String("Selected local version of ");
        }
        return new DynamiteModule(context.getApplicationContext());
    }

    private static DynamiteModule a(Context context, String str, int i2) throws a {
        Boolean bool;
        com.google.android.gms.b.b bVar;
        try {
            synchronized (DynamiteModule.class) {
                bool = f9014h;
            }
            if (bool == null) {
                throw new a("Failed to determine which loading route to use.", (b) null);
            } else if (bool.booleanValue()) {
                return b(context, str, i2);
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
                sb.append("Selected remote version of ");
                sb.append(str);
                sb.append(", version >= ");
                sb.append(i2);
                k a2 = a(context);
                if (a2 != null) {
                    if (a2.a() >= 2) {
                        bVar = a2.b(com.google.android.gms.b.d.a(context), str, i2);
                    } else {
                        bVar = a2.a(com.google.android.gms.b.d.a(context), str, i2);
                    }
                    if (com.google.android.gms.b.d.a(bVar) != null) {
                        return new DynamiteModule((Context) com.google.android.gms.b.d.a(bVar));
                    }
                    throw new a("Failed to load remote module.", (b) null);
                }
                throw new a("Failed to create IDynamiteLoader.", (b) null);
            }
        } catch (RemoteException e2) {
            throw new a("Failed to load remote module.", e2, (b) null);
        } catch (a e3) {
            throw e3;
        } catch (Throwable th) {
            g.a(context, th);
            throw new a("Failed to load remote module.", th, (b) null);
        }
    }

    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.IInterface] */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005c, code lost:
        return null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.dynamite.k a(android.content.Context r4) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)
            com.google.android.gms.dynamite.k r1 = f9015i     // Catch:{ all -> 0x005d }
            if (r1 == 0) goto L_0x000b
            com.google.android.gms.dynamite.k r4 = f9015i     // Catch:{ all -> 0x005d }
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            return r4
        L_0x000b:
            r1 = 0
            java.lang.String r2 = "com.google.android.gms"
            r3 = 3
            android.content.Context r4 = r4.createPackageContext(r2, r3)     // Catch:{ Exception -> 0x0041 }
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch:{ Exception -> 0x0041 }
            java.lang.String r2 = "com.google.android.gms.chimera.container.DynamiteLoaderImpl"
            java.lang.Class r4 = r4.loadClass(r2)     // Catch:{ Exception -> 0x0041 }
            java.lang.Object r4 = r4.newInstance()     // Catch:{ Exception -> 0x0041 }
            android.os.IBinder r4 = (android.os.IBinder) r4     // Catch:{ Exception -> 0x0041 }
            if (r4 != 0) goto L_0x0027
            r4 = r1
            goto L_0x003b
        L_0x0027:
            java.lang.String r2 = "com.google.android.gms.dynamite.IDynamiteLoader"
            android.os.IInterface r2 = r4.queryLocalInterface(r2)     // Catch:{ Exception -> 0x0041 }
            boolean r3 = r2 instanceof com.google.android.gms.dynamite.k     // Catch:{ Exception -> 0x0041 }
            if (r3 == 0) goto L_0x0035
            r4 = r2
            com.google.android.gms.dynamite.k r4 = (com.google.android.gms.dynamite.k) r4     // Catch:{ Exception -> 0x0041 }
            goto L_0x003b
        L_0x0035:
            com.google.android.gms.dynamite.j r2 = new com.google.android.gms.dynamite.j     // Catch:{ Exception -> 0x0041 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0041 }
            r4 = r2
        L_0x003b:
            if (r4 == 0) goto L_0x005b
            f9015i = r4     // Catch:{ Exception -> 0x0041 }
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            return r4
        L_0x0041:
            r4 = move-exception
            java.lang.String r2 = "Failed to load IDynamiteLoader from GmsCore: "
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x005d }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x005d }
            int r3 = r4.length()     // Catch:{ all -> 0x005d }
            if (r3 == 0) goto L_0x0056
            r2.concat(r4)     // Catch:{ all -> 0x005d }
            goto L_0x005b
        L_0x0056:
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x005d }
            r4.<init>(r2)     // Catch:{ all -> 0x005d }
        L_0x005b:
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            return r1
        L_0x005d:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.a(android.content.Context):com.google.android.gms.dynamite.k");
    }

    private static DynamiteModule b(Context context, String str, int i2) throws a, RemoteException {
        m mVar;
        com.google.android.gms.b.b bVar;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i2);
        synchronized (DynamiteModule.class) {
            mVar = j;
        }
        if (mVar != null) {
            c cVar = m.get();
            if (cVar == null || cVar.f9020a == null) {
                throw new a("No result cursor", (b) null);
            }
            Context applicationContext = context.getApplicationContext();
            Cursor cursor = cVar.f9020a;
            com.google.android.gms.b.d.a(null);
            if (a().booleanValue()) {
                bVar = mVar.b(com.google.android.gms.b.d.a(applicationContext), str, i2, com.google.android.gms.b.d.a(cursor));
            } else {
                bVar = mVar.a(com.google.android.gms.b.d.a(applicationContext), str, i2, com.google.android.gms.b.d.a(cursor));
            }
            Context context2 = (Context) com.google.android.gms.b.d.a(bVar);
            if (context2 != null) {
                return new DynamiteModule(context2);
            }
            throw new a("Failed to get module context", (b) null);
        }
        throw new a("DynamiteLoaderV2 was not cached.", (b) null);
    }

    private static Boolean a() {
        Boolean valueOf;
        synchronized (DynamiteModule.class) {
            valueOf = Boolean.valueOf(l >= 2);
        }
        return valueOf;
    }

    /* JADX WARNING: type inference failed for: r1v5, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.lang.ClassLoader r3) throws com.google.android.gms.dynamite.DynamiteModule.a {
        /*
            r0 = 0
            java.lang.String r1 = "com.google.android.gms.dynamiteloader.DynamiteLoaderV2"
            java.lang.Class r3 = r3.loadClass(r1)     // Catch:{ ClassNotFoundException -> 0x0039, IllegalAccessException -> 0x0037, InstantiationException -> 0x0035, InvocationTargetException -> 0x0033, NoSuchMethodException -> 0x0031 }
            r1 = 0
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x0039, IllegalAccessException -> 0x0037, InstantiationException -> 0x0035, InvocationTargetException -> 0x0033, NoSuchMethodException -> 0x0031 }
            java.lang.reflect.Constructor r3 = r3.getConstructor(r2)     // Catch:{ ClassNotFoundException -> 0x0039, IllegalAccessException -> 0x0037, InstantiationException -> 0x0035, InvocationTargetException -> 0x0033, NoSuchMethodException -> 0x0031 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x0039, IllegalAccessException -> 0x0037, InstantiationException -> 0x0035, InvocationTargetException -> 0x0033, NoSuchMethodException -> 0x0031 }
            java.lang.Object r3 = r3.newInstance(r1)     // Catch:{ ClassNotFoundException -> 0x0039, IllegalAccessException -> 0x0037, InstantiationException -> 0x0035, InvocationTargetException -> 0x0033, NoSuchMethodException -> 0x0031 }
            android.os.IBinder r3 = (android.os.IBinder) r3     // Catch:{ ClassNotFoundException -> 0x0039, IllegalAccessException -> 0x0037, InstantiationException -> 0x0035, InvocationTargetException -> 0x0033, NoSuchMethodException -> 0x0031 }
            if (r3 != 0) goto L_0x001a
            r3 = r0
            goto L_0x002e
        L_0x001a:
            java.lang.String r1 = "com.google.android.gms.dynamite.IDynamiteLoaderV2"
            android.os.IInterface r1 = r3.queryLocalInterface(r1)     // Catch:{ ClassNotFoundException -> 0x0039, IllegalAccessException -> 0x0037, InstantiationException -> 0x0035, InvocationTargetException -> 0x0033, NoSuchMethodException -> 0x0031 }
            boolean r2 = r1 instanceof com.google.android.gms.dynamite.m     // Catch:{ ClassNotFoundException -> 0x0039, IllegalAccessException -> 0x0037, InstantiationException -> 0x0035, InvocationTargetException -> 0x0033, NoSuchMethodException -> 0x0031 }
            if (r2 == 0) goto L_0x0028
            r3 = r1
            com.google.android.gms.dynamite.m r3 = (com.google.android.gms.dynamite.m) r3     // Catch:{ ClassNotFoundException -> 0x0039, IllegalAccessException -> 0x0037, InstantiationException -> 0x0035, InvocationTargetException -> 0x0033, NoSuchMethodException -> 0x0031 }
            goto L_0x002e
        L_0x0028:
            com.google.android.gms.dynamite.l r1 = new com.google.android.gms.dynamite.l     // Catch:{ ClassNotFoundException -> 0x0039, IllegalAccessException -> 0x0037, InstantiationException -> 0x0035, InvocationTargetException -> 0x0033, NoSuchMethodException -> 0x0031 }
            r1.<init>(r3)     // Catch:{ ClassNotFoundException -> 0x0039, IllegalAccessException -> 0x0037, InstantiationException -> 0x0035, InvocationTargetException -> 0x0033, NoSuchMethodException -> 0x0031 }
            r3 = r1
        L_0x002e:
            j = r3     // Catch:{ ClassNotFoundException -> 0x0039, IllegalAccessException -> 0x0037, InstantiationException -> 0x0035, InvocationTargetException -> 0x0033, NoSuchMethodException -> 0x0031 }
            return
        L_0x0031:
            r3 = move-exception
            goto L_0x003a
        L_0x0033:
            r3 = move-exception
            goto L_0x003a
        L_0x0035:
            r3 = move-exception
            goto L_0x003a
        L_0x0037:
            r3 = move-exception
            goto L_0x003a
        L_0x0039:
            r3 = move-exception
        L_0x003a:
            com.google.android.gms.dynamite.DynamiteModule$a r1 = new com.google.android.gms.dynamite.DynamiteModule$a
            java.lang.String r2 = "Failed to instantiate dynamite loader"
            r1.<init>(r2, r3, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.a(java.lang.ClassLoader):void");
    }

    public final IBinder a(String str) throws a {
        try {
            return (IBinder) this.f9016g.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            String valueOf = String.valueOf(str);
            throw new a(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e2, (b) null);
        }
    }

    private DynamiteModule(Context context) {
        this.f9016g = (Context) s.a(context);
    }
}
