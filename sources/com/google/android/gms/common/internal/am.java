package com.google.android.gms.common.internal;

import android.os.Parcelable;

public final class am implements Parcelable.Creator<GetServiceRequest> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new GetServiceRequest[i2];
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v5, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r2v6, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r18) {
        /*
            r17 = this;
            r0 = r18
            int r1 = com.google.android.gms.common.internal.safeparcel.a.a(r18)
            r2 = 0
            r3 = 0
            r8 = r3
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r5 = 0
            r6 = 0
            r7 = 0
            r15 = 0
            r16 = 0
        L_0x0015:
            int r2 = r18.dataPosition()
            if (r2 >= r1) goto L_0x007a
            int r2 = r18.readInt()
            r3 = 65535(0xffff, float:9.1834E-41)
            r3 = r3 & r2
            switch(r3) {
                case 1: goto L_0x0075;
                case 2: goto L_0x0070;
                case 3: goto L_0x006b;
                case 4: goto L_0x0066;
                case 5: goto L_0x0061;
                case 6: goto L_0x0057;
                case 7: goto L_0x0052;
                case 8: goto L_0x0048;
                case 9: goto L_0x0026;
                case 10: goto L_0x003e;
                case 11: goto L_0x0034;
                case 12: goto L_0x002f;
                case 13: goto L_0x002a;
                default: goto L_0x0026;
            }
        L_0x0026:
            com.google.android.gms.common.internal.safeparcel.a.b(r0, r2)
            goto L_0x0015
        L_0x002a:
            int r16 = com.google.android.gms.common.internal.safeparcel.a.e(r0, r2)
            goto L_0x0015
        L_0x002f:
            boolean r15 = com.google.android.gms.common.internal.safeparcel.a.c(r0, r2)
            goto L_0x0015
        L_0x0034:
            android.os.Parcelable$Creator<com.google.android.gms.common.Feature> r3 = com.google.android.gms.common.Feature.CREATOR
            java.lang.Object[] r2 = com.google.android.gms.common.internal.safeparcel.a.b((android.os.Parcel) r0, (int) r2, r3)
            r14 = r2
            com.google.android.gms.common.Feature[] r14 = (com.google.android.gms.common.Feature[]) r14
            goto L_0x0015
        L_0x003e:
            android.os.Parcelable$Creator<com.google.android.gms.common.Feature> r3 = com.google.android.gms.common.Feature.CREATOR
            java.lang.Object[] r2 = com.google.android.gms.common.internal.safeparcel.a.b((android.os.Parcel) r0, (int) r2, r3)
            r13 = r2
            com.google.android.gms.common.Feature[] r13 = (com.google.android.gms.common.Feature[]) r13
            goto L_0x0015
        L_0x0048:
            android.os.Parcelable$Creator r3 = android.accounts.Account.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.a.a((android.os.Parcel) r0, (int) r2, r3)
            r12 = r2
            android.accounts.Account r12 = (android.accounts.Account) r12
            goto L_0x0015
        L_0x0052:
            android.os.Bundle r11 = com.google.android.gms.common.internal.safeparcel.a.p(r0, r2)
            goto L_0x0015
        L_0x0057:
            android.os.Parcelable$Creator<com.google.android.gms.common.api.Scope> r3 = com.google.android.gms.common.api.Scope.CREATOR
            java.lang.Object[] r2 = com.google.android.gms.common.internal.safeparcel.a.b((android.os.Parcel) r0, (int) r2, r3)
            r10 = r2
            com.google.android.gms.common.api.Scope[] r10 = (com.google.android.gms.common.api.Scope[]) r10
            goto L_0x0015
        L_0x0061:
            android.os.IBinder r9 = com.google.android.gms.common.internal.safeparcel.a.o(r0, r2)
            goto L_0x0015
        L_0x0066:
            java.lang.String r8 = com.google.android.gms.common.internal.safeparcel.a.n(r0, r2)
            goto L_0x0015
        L_0x006b:
            int r7 = com.google.android.gms.common.internal.safeparcel.a.e(r0, r2)
            goto L_0x0015
        L_0x0070:
            int r6 = com.google.android.gms.common.internal.safeparcel.a.e(r0, r2)
            goto L_0x0015
        L_0x0075:
            int r5 = com.google.android.gms.common.internal.safeparcel.a.e(r0, r2)
            goto L_0x0015
        L_0x007a:
            com.google.android.gms.common.internal.safeparcel.a.A(r0, r1)
            com.google.android.gms.common.internal.GetServiceRequest r0 = new com.google.android.gms.common.internal.GetServiceRequest
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.am.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
