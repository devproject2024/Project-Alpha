package com.google.firebase.appindexing.internal;

import android.content.Context;
import com.google.android.gms.common.api.d;
import com.google.firebase.appindexing.b;

public final class k extends b {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f38025a = {"com.google.android.googlequicksearchbox", "com.google.android.gms"};

    /* renamed from: b  reason: collision with root package name */
    private final d<?> f38026b;

    /* renamed from: c  reason: collision with root package name */
    private final m f38027c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f38028d;

    public k(Context context) {
        this(context, new j(context));
    }

    private k(Context context, d<Object> dVar) {
        this.f38026b = dVar;
        this.f38028d = context;
        this.f38027c = new m(dVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0052 A[Catch:{ ArrayStoreException -> 0x00c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0054 A[Catch:{ ArrayStoreException -> 0x00c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005d A[Catch:{ ArrayStoreException -> 0x00c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0077 A[Catch:{ ArrayStoreException -> 0x00c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0079 A[Catch:{ ArrayStoreException -> 0x00c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0086 A[Catch:{ ArrayStoreException -> 0x00c3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.tasks.Task<java.lang.Void> a(com.google.firebase.appindexing.g... r12) {
        /*
            r11 = this;
            r0 = 1
            com.google.firebase.appindexing.internal.Thing[] r1 = new com.google.firebase.appindexing.internal.Thing[r0]     // Catch:{ ArrayStoreException -> 0x00c3 }
            r2 = 0
            java.lang.System.arraycopy(r12, r2, r1, r2, r0)     // Catch:{ ArrayStoreException -> 0x00c3 }
            boolean r12 = com.google.android.gms.internal.icing.fh.a()     // Catch:{ ArrayStoreException -> 0x00c3 }
            if (r12 == 0) goto L_0x00b7
            boolean r12 = com.google.android.gms.common.util.n.b()     // Catch:{ ArrayStoreException -> 0x00c3 }
            if (r12 == 0) goto L_0x00b7
            android.content.Context r12 = r11.f38028d     // Catch:{ ArrayStoreException -> 0x00c3 }
            if (r12 == 0) goto L_0x00b7
            android.content.Context r12 = r11.f38028d     // Catch:{ ArrayStoreException -> 0x00c3 }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ ArrayStoreException -> 0x00c3 }
            r4 = 28
            if (r3 < r4) goto L_0x0025
            com.google.firebase.appindexing.internal.b r3 = new com.google.firebase.appindexing.internal.b     // Catch:{ ArrayStoreException -> 0x00c3 }
            r3.<init>(r12)     // Catch:{ ArrayStoreException -> 0x00c3 }
            goto L_0x002a
        L_0x0025:
            com.google.firebase.appindexing.internal.aa r3 = new com.google.firebase.appindexing.internal.aa     // Catch:{ ArrayStoreException -> 0x00c3 }
            r3.<init>(r12)     // Catch:{ ArrayStoreException -> 0x00c3 }
        L_0x002a:
            r12 = 0
        L_0x002b:
            if (r12 > 0) goto L_0x00b7
            r4 = r1[r12]     // Catch:{ ArrayStoreException -> 0x00c3 }
            if (r4 == 0) goto L_0x00b3
            com.google.firebase.appindexing.internal.Thing$zza r5 = r4.f38011a     // Catch:{ ArrayStoreException -> 0x00c3 }
            java.lang.String r6 = "sliceUri"
            android.os.Bundle r7 = r5.f38016a     // Catch:{ ArrayStoreException -> 0x00c3 }
            r8 = 0
            if (r7 == 0) goto L_0x004c
            android.os.Bundle r7 = r5.f38016a     // Catch:{ ArrayStoreException -> 0x00c3 }
            java.lang.Object r7 = r7.get(r6)     // Catch:{ ArrayStoreException -> 0x00c3 }
            boolean r7 = r7 instanceof java.lang.String[]     // Catch:{ ArrayStoreException -> 0x00c3 }
            if (r7 != 0) goto L_0x0045
            goto L_0x004c
        L_0x0045:
            android.os.Bundle r5 = r5.f38016a     // Catch:{ ArrayStoreException -> 0x00c3 }
            java.lang.String[] r5 = r5.getStringArray(r6)     // Catch:{ ArrayStoreException -> 0x00c3 }
            goto L_0x004d
        L_0x004c:
            r5 = r8
        L_0x004d:
            if (r5 == 0) goto L_0x0054
            int r6 = r5.length     // Catch:{ ArrayStoreException -> 0x00c3 }
            if (r6 <= 0) goto L_0x0054
            r6 = 1
            goto L_0x0055
        L_0x0054:
            r6 = 0
        L_0x0055:
            com.google.firebase.appindexing.internal.Thing$zza r4 = r4.f38011a     // Catch:{ ArrayStoreException -> 0x00c3 }
            java.lang.String r7 = "grantSlicePermission"
            android.os.Bundle r9 = r4.f38016a     // Catch:{ ArrayStoreException -> 0x00c3 }
            if (r9 == 0) goto L_0x006e
            android.os.Bundle r9 = r4.f38016a     // Catch:{ ArrayStoreException -> 0x00c3 }
            java.lang.Object r9 = r9.get(r7)     // Catch:{ ArrayStoreException -> 0x00c3 }
            boolean r9 = r9 instanceof boolean[]     // Catch:{ ArrayStoreException -> 0x00c3 }
            if (r9 != 0) goto L_0x0068
            goto L_0x006e
        L_0x0068:
            android.os.Bundle r4 = r4.f38016a     // Catch:{ ArrayStoreException -> 0x00c3 }
            boolean[] r8 = r4.getBooleanArray(r7)     // Catch:{ ArrayStoreException -> 0x00c3 }
        L_0x006e:
            if (r8 == 0) goto L_0x0079
            int r4 = r8.length     // Catch:{ ArrayStoreException -> 0x00c3 }
            if (r4 <= 0) goto L_0x0079
            boolean r4 = r8[r2]     // Catch:{ ArrayStoreException -> 0x00c3 }
            if (r4 == 0) goto L_0x0079
            r4 = 1
            goto L_0x007a
        L_0x0079:
            r4 = 0
        L_0x007a:
            if (r6 == 0) goto L_0x00b3
            if (r4 == 0) goto L_0x00b3
            r4 = r5[r2]     // Catch:{ ArrayStoreException -> 0x00c3 }
            java.lang.String[] r5 = f38025a     // Catch:{ ArrayStoreException -> 0x00c3 }
            int r6 = r5.length     // Catch:{ ArrayStoreException -> 0x00c3 }
            r7 = 0
        L_0x0084:
            if (r7 >= r6) goto L_0x00b3
            r8 = r5[r7]     // Catch:{ ArrayStoreException -> 0x00c3 }
            android.net.Uri r9 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x0090 }
            r3.a(r8, r9)     // Catch:{ Exception -> 0x0090 }
            goto L_0x00b0
        L_0x0090:
            r8 = move-exception
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ ArrayStoreException -> 0x00c3 }
            java.lang.String r9 = java.lang.String.valueOf(r8)     // Catch:{ ArrayStoreException -> 0x00c3 }
            int r9 = r9.length()     // Catch:{ ArrayStoreException -> 0x00c3 }
            int r9 = r9 + 48
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ ArrayStoreException -> 0x00c3 }
            r10.<init>(r9)     // Catch:{ ArrayStoreException -> 0x00c3 }
            java.lang.String r9 = "Error trying to grant permission to Slice Uris: "
            r10.append(r9)     // Catch:{ ArrayStoreException -> 0x00c3 }
            r10.append(r8)     // Catch:{ ArrayStoreException -> 0x00c3 }
            r8 = 5
            com.google.firebase.appindexing.internal.v.a((int) r8)     // Catch:{ ArrayStoreException -> 0x00c3 }
        L_0x00b0:
            int r7 = r7 + 1
            goto L_0x0084
        L_0x00b3:
            int r12 = r12 + 1
            goto L_0x002b
        L_0x00b7:
            com.google.firebase.appindexing.internal.zzy r12 = new com.google.firebase.appindexing.internal.zzy
            r12.<init>(r1)
            com.google.firebase.appindexing.internal.m r0 = r11.f38027c
            com.google.android.gms.tasks.Task r12 = r0.a((com.google.firebase.appindexing.internal.zzy) r12)
            return r12
        L_0x00c3:
            com.google.firebase.appindexing.d r12 = new com.google.firebase.appindexing.d
            java.lang.String r0 = "Custom Indexable-objects are not allowed. Please use the 'Indexables'-class for creating the objects."
            r12.<init>(r0)
            com.google.android.gms.tasks.Task r12 = com.google.android.gms.tasks.h.a((java.lang.Exception) r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.appindexing.internal.k.a(com.google.firebase.appindexing.g[]):com.google.android.gms.tasks.Task");
    }
}
