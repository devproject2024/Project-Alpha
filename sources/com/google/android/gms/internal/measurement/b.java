package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.mk;

final class b extends mk.a {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f10474c = null;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f10475d = null;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Context f10476e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ Bundle f10477f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ mk f10478g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    b(mk mkVar, Context context, Bundle bundle) {
        super(mkVar);
        this.f10478g = mkVar;
        this.f10476e = context;
        this.f10477f = bundle;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006a, code lost:
        if (r4 < r3) goto L_0x006c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0052 A[Catch:{ Exception -> 0x0096 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058 A[Catch:{ Exception -> 0x0096 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r14 = this;
            r0 = 0
            r1 = 1
            com.google.android.gms.internal.measurement.mk r2 = r14.f10478g     // Catch:{ Exception -> 0x0096 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0096 }
            r3.<init>()     // Catch:{ Exception -> 0x0096 }
            java.util.List unused = r2.f10912f = r3     // Catch:{ Exception -> 0x0096 }
            java.lang.String r2 = r14.f10474c     // Catch:{ Exception -> 0x0096 }
            java.lang.String r3 = r14.f10475d     // Catch:{ Exception -> 0x0096 }
            boolean r2 = com.google.android.gms.internal.measurement.mk.b(r2, r3)     // Catch:{ Exception -> 0x0096 }
            r3 = 0
            if (r2 == 0) goto L_0x0025
            java.lang.String r3 = r14.f10475d     // Catch:{ Exception -> 0x0096 }
            java.lang.String r2 = r14.f10474c     // Catch:{ Exception -> 0x0096 }
            com.google.android.gms.internal.measurement.mk r4 = r14.f10478g     // Catch:{ Exception -> 0x0096 }
            java.lang.String r4 = r4.f10909c     // Catch:{ Exception -> 0x0096 }
            r10 = r2
            r11 = r3
            r9 = r4
            goto L_0x0028
        L_0x0025:
            r9 = r3
            r10 = r9
            r11 = r10
        L_0x0028:
            android.content.Context r2 = r14.f10476e     // Catch:{ Exception -> 0x0096 }
            com.google.android.gms.internal.measurement.mk.g(r2)     // Catch:{ Exception -> 0x0096 }
            java.lang.Boolean r2 = com.google.android.gms.internal.measurement.mk.f10907i     // Catch:{ Exception -> 0x0096 }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x0096 }
            if (r2 != 0) goto L_0x003c
            if (r10 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r2 = 0
            goto L_0x003d
        L_0x003c:
            r2 = 1
        L_0x003d:
            com.google.android.gms.internal.measurement.mk r3 = r14.f10478g     // Catch:{ Exception -> 0x0096 }
            com.google.android.gms.internal.measurement.mk r4 = r14.f10478g     // Catch:{ Exception -> 0x0096 }
            android.content.Context r5 = r14.f10476e     // Catch:{ Exception -> 0x0096 }
            com.google.android.gms.internal.measurement.kv r4 = r4.a((android.content.Context) r5, (boolean) r2)     // Catch:{ Exception -> 0x0096 }
            com.google.android.gms.internal.measurement.kv unused = r3.r = r4     // Catch:{ Exception -> 0x0096 }
            com.google.android.gms.internal.measurement.mk r3 = r14.f10478g     // Catch:{ Exception -> 0x0096 }
            com.google.android.gms.internal.measurement.kv r3 = r3.r     // Catch:{ Exception -> 0x0096 }
            if (r3 != 0) goto L_0x0058
            com.google.android.gms.internal.measurement.mk r2 = r14.f10478g     // Catch:{ Exception -> 0x0096 }
            java.lang.String unused = r2.f10909c     // Catch:{ Exception -> 0x0096 }
            return
        L_0x0058:
            android.content.Context r3 = r14.f10476e     // Catch:{ Exception -> 0x0096 }
            int r3 = com.google.android.gms.dynamite.DynamiteModule.a(r3, com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor.MODULE_ID)     // Catch:{ Exception -> 0x0096 }
            android.content.Context r4 = r14.f10476e     // Catch:{ Exception -> 0x0096 }
            int r4 = com.google.android.gms.dynamite.DynamiteModule.b(r4, com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor.MODULE_ID)     // Catch:{ Exception -> 0x0096 }
            if (r2 == 0) goto L_0x0071
            int r2 = java.lang.Math.max(r3, r4)     // Catch:{ Exception -> 0x0096 }
            if (r4 >= r3) goto L_0x006e
        L_0x006c:
            r3 = 1
            goto L_0x006f
        L_0x006e:
            r3 = 0
        L_0x006f:
            r8 = r3
            goto L_0x0079
        L_0x0071:
            if (r3 <= 0) goto L_0x0075
            r2 = r3
            goto L_0x0076
        L_0x0075:
            r2 = r4
        L_0x0076:
            if (r3 <= 0) goto L_0x006e
            goto L_0x006c
        L_0x0079:
            com.google.android.gms.internal.measurement.zzv r13 = new com.google.android.gms.internal.measurement.zzv     // Catch:{ Exception -> 0x0096 }
            r4 = 19000(0x4a38, double:9.3872E-320)
            long r6 = (long) r2     // Catch:{ Exception -> 0x0096 }
            android.os.Bundle r12 = r14.f10477f     // Catch:{ Exception -> 0x0096 }
            r3 = r13
            r3.<init>(r4, r6, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0096 }
            com.google.android.gms.internal.measurement.mk r2 = r14.f10478g     // Catch:{ Exception -> 0x0096 }
            com.google.android.gms.internal.measurement.kv r2 = r2.r     // Catch:{ Exception -> 0x0096 }
            android.content.Context r3 = r14.f10476e     // Catch:{ Exception -> 0x0096 }
            com.google.android.gms.b.b r3 = com.google.android.gms.b.d.a(r3)     // Catch:{ Exception -> 0x0096 }
            long r4 = r14.f10914a     // Catch:{ Exception -> 0x0096 }
            r2.initialize(r3, r13, r4)     // Catch:{ Exception -> 0x0096 }
            return
        L_0x0096:
            r2 = move-exception
            com.google.android.gms.internal.measurement.mk r3 = r14.f10478g
            r3.a(r2, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.b.a():void");
    }
}
