package com.google.android.gms.measurement.internal;

import android.os.Parcelable;

public final class p implements Parcelable.Creator<zzan> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzan[i2];
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r11) {
        /*
            r10 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.a.a(r11)
            r1 = 0
            r2 = 0
            r5 = r1
            r6 = r5
            r7 = r6
            r8 = r2
        L_0x000b:
            int r1 = r11.dataPosition()
            if (r1 >= r0) goto L_0x0042
            int r1 = r11.readInt()
            r2 = 65535(0xffff, float:9.1834E-41)
            r2 = r2 & r1
            r3 = 2
            if (r2 == r3) goto L_0x003d
            r3 = 3
            if (r2 == r3) goto L_0x0033
            r3 = 4
            if (r2 == r3) goto L_0x002e
            r3 = 5
            if (r2 == r3) goto L_0x0029
            com.google.android.gms.common.internal.safeparcel.a.b(r11, r1)
            goto L_0x000b
        L_0x0029:
            long r8 = com.google.android.gms.common.internal.safeparcel.a.g(r11, r1)
            goto L_0x000b
        L_0x002e:
            java.lang.String r7 = com.google.android.gms.common.internal.safeparcel.a.n(r11, r1)
            goto L_0x000b
        L_0x0033:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzam> r2 = com.google.android.gms.measurement.internal.zzam.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.a.a((android.os.Parcel) r11, (int) r1, r2)
            r6 = r1
            com.google.android.gms.measurement.internal.zzam r6 = (com.google.android.gms.measurement.internal.zzam) r6
            goto L_0x000b
        L_0x003d:
            java.lang.String r5 = com.google.android.gms.common.internal.safeparcel.a.n(r11, r1)
            goto L_0x000b
        L_0x0042:
            com.google.android.gms.common.internal.safeparcel.a.A(r11, r0)
            com.google.android.gms.measurement.internal.zzan r11 = new com.google.android.gms.measurement.internal.zzan
            r4 = r11
            r4.<init>(r5, r6, r7, r8)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.p.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
