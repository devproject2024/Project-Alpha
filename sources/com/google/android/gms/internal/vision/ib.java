package com.google.android.gms.internal.vision;

import android.content.Context;
import android.os.RemoteException;
import com.business.merchant_payments.common.utility.AppUtility;
import com.google.android.gms.dynamite.DynamiteModule;

public abstract class ib<T> {

    /* renamed from: a  reason: collision with root package name */
    private static String f11243a = "com.google.android.gms.vision.dynamite";

    /* renamed from: b  reason: collision with root package name */
    private final Context f11244b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f11245c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final String f11246d;

    /* renamed from: e  reason: collision with root package name */
    private final String f11247e;

    /* renamed from: f  reason: collision with root package name */
    private final String f11248f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f11249g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11250h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f11251i;
    private T j;

    public ib(Context context, String str, String str2) {
        boolean z = false;
        this.f11250h = false;
        this.f11251i = false;
        this.f11244b = context;
        this.f11246d = str;
        String str3 = f11243a;
        StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 1 + String.valueOf(str2).length());
        sb.append(str3);
        sb.append(AppUtility.CENTER_DOT);
        sb.append(str2);
        this.f11247e = sb.toString();
        this.f11248f = str2;
        if (context != null) {
            z.a(context);
            az zza = az.zza("barcode", Boolean.valueOf(hz.a()), "face", Boolean.TRUE, "ica", Boolean.valueOf(hz.b()), "ocr", Boolean.TRUE);
            if (zza.containsKey(str2) && ((Boolean) zza.get(str2)).booleanValue()) {
                z = true;
            }
        }
        this.f11249g = z;
    }

    /* access modifiers changed from: protected */
    public abstract T a(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.a;

    /* access modifiers changed from: protected */
    public abstract void a() throws RemoteException;

    public final boolean b() {
        return d() != null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:7|8|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x000c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f11245c
            monitor-enter(r0)
            T r1 = r2.j     // Catch:{ all -> 0x000e }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            return
        L_0x0009:
            r2.a()     // Catch:{ RemoteException -> 0x000c }
        L_0x000c:
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            return
        L_0x000e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.ib.c():void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r2 = com.google.android.gms.internal.vision.id.a(r7.f11244b, r7.f11248f, r7.f11249g);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
        r4 = java.lang.String.valueOf(r7.f11248f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
        if (r4.length() != 0) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0039, code lost:
        "Broadcasting download intent for dependency ".concat(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003d, code lost:
        new java.lang.String("Broadcasting download intent for dependency ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0042, code lost:
        r3 = r7.f11248f;
        r4 = new android.content.Intent();
        r4.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
        r4.putExtra("com.google.android.gms.vision.DEPENDENCIES", r3);
        r4.setAction("com.google.android.gms.vision.DEPENDENCY");
        r7.f11244b.sendBroadcast(r4);
        r7.f11250h = true;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0017 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x006b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T d() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f11245c
            monitor-enter(r0)
            T r1 = r7.j     // Catch:{ all -> 0x0079 }
            if (r1 == 0) goto L_0x000b
            T r1 = r7.j     // Catch:{ all -> 0x0079 }
            monitor-exit(r0)     // Catch:{ all -> 0x0079 }
            return r1
        L_0x000b:
            r1 = 1
            android.content.Context r2 = r7.f11244b     // Catch:{ a -> 0x0017 }
            com.google.android.gms.dynamite.DynamiteModule$b r3 = com.google.android.gms.dynamite.DynamiteModule.f9013f     // Catch:{ a -> 0x0017 }
            java.lang.String r4 = r7.f11247e     // Catch:{ a -> 0x0017 }
            com.google.android.gms.dynamite.DynamiteModule r2 = com.google.android.gms.dynamite.DynamiteModule.a((android.content.Context) r2, (com.google.android.gms.dynamite.DynamiteModule.b) r3, (java.lang.String) r4)     // Catch:{ a -> 0x0017 }
            goto L_0x0061
        L_0x0017:
            android.content.Context r2 = r7.f11244b     // Catch:{ all -> 0x0079 }
            java.lang.String r3 = r7.f11248f     // Catch:{ all -> 0x0079 }
            boolean r4 = r7.f11249g     // Catch:{ all -> 0x0079 }
            com.google.android.gms.dynamite.DynamiteModule r2 = com.google.android.gms.internal.vision.id.a(r2, r3, r4)     // Catch:{ all -> 0x0079 }
            if (r2 != 0) goto L_0x0061
            boolean r3 = r7.f11249g     // Catch:{ all -> 0x0079 }
            if (r3 == 0) goto L_0x0061
            boolean r3 = r7.f11250h     // Catch:{ all -> 0x0079 }
            if (r3 != 0) goto L_0x0061
            java.lang.String r3 = "Broadcasting download intent for dependency "
            java.lang.String r4 = r7.f11248f     // Catch:{ all -> 0x0079 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0079 }
            int r5 = r4.length()     // Catch:{ all -> 0x0079 }
            if (r5 == 0) goto L_0x003d
            r3.concat(r4)     // Catch:{ all -> 0x0079 }
            goto L_0x0042
        L_0x003d:
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x0079 }
            r4.<init>(r3)     // Catch:{ all -> 0x0079 }
        L_0x0042:
            java.lang.String r3 = r7.f11248f     // Catch:{ all -> 0x0079 }
            android.content.Intent r4 = new android.content.Intent     // Catch:{ all -> 0x0079 }
            r4.<init>()     // Catch:{ all -> 0x0079 }
            java.lang.String r5 = "com.google.android.gms"
            java.lang.String r6 = "com.google.android.gms.vision.DependencyBroadcastReceiverProxy"
            r4.setClassName(r5, r6)     // Catch:{ all -> 0x0079 }
            java.lang.String r5 = "com.google.android.gms.vision.DEPENDENCIES"
            r4.putExtra(r5, r3)     // Catch:{ all -> 0x0079 }
            java.lang.String r3 = "com.google.android.gms.vision.DEPENDENCY"
            r4.setAction(r3)     // Catch:{ all -> 0x0079 }
            android.content.Context r3 = r7.f11244b     // Catch:{ all -> 0x0079 }
            r3.sendBroadcast(r4)     // Catch:{ all -> 0x0079 }
            r7.f11250h = r1     // Catch:{ all -> 0x0079 }
        L_0x0061:
            if (r2 == 0) goto L_0x006b
            android.content.Context r3 = r7.f11244b     // Catch:{ RemoteException | a -> 0x006b }
            java.lang.Object r2 = r7.a(r2, r3)     // Catch:{ RemoteException | a -> 0x006b }
            r7.j = r2     // Catch:{ RemoteException | a -> 0x006b }
        L_0x006b:
            boolean r2 = r7.f11251i     // Catch:{ all -> 0x0079 }
            if (r2 != 0) goto L_0x0075
            T r2 = r7.j     // Catch:{ all -> 0x0079 }
            if (r2 != 0) goto L_0x0075
            r7.f11251i = r1     // Catch:{ all -> 0x0079 }
        L_0x0075:
            T r1 = r7.j     // Catch:{ all -> 0x0079 }
            monitor-exit(r0)     // Catch:{ all -> 0x0079 }
            return r1
        L_0x0079:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0079 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.ib.d():java.lang.Object");
    }
}
