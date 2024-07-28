package com.google.android.gms.auth.api.proxy;

import android.os.Parcelable;

public final class c implements Parcelable.Creator<ProxyResponse> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new ProxyResponse[i2];
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
            r6 = r1
            r8 = r6
            r9 = r8
            r4 = 0
            r5 = 0
            r7 = 0
        L_0x000c:
            int r1 = r11.dataPosition()
            if (r1 >= r0) goto L_0x0054
            int r1 = r11.readInt()
            r2 = 65535(0xffff, float:9.1834E-41)
            r2 = r2 & r1
            r3 = 1
            if (r2 == r3) goto L_0x004f
            r3 = 2
            if (r2 == r3) goto L_0x0045
            r3 = 3
            if (r2 == r3) goto L_0x0040
            r3 = 4
            if (r2 == r3) goto L_0x003b
            r3 = 5
            if (r2 == r3) goto L_0x0036
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r2 == r3) goto L_0x0031
            com.google.android.gms.common.internal.safeparcel.a.b(r11, r1)
            goto L_0x000c
        L_0x0031:
            int r4 = com.google.android.gms.common.internal.safeparcel.a.e(r11, r1)
            goto L_0x000c
        L_0x0036:
            byte[] r9 = com.google.android.gms.common.internal.safeparcel.a.q(r11, r1)
            goto L_0x000c
        L_0x003b:
            android.os.Bundle r8 = com.google.android.gms.common.internal.safeparcel.a.p(r11, r1)
            goto L_0x000c
        L_0x0040:
            int r7 = com.google.android.gms.common.internal.safeparcel.a.e(r11, r1)
            goto L_0x000c
        L_0x0045:
            android.os.Parcelable$Creator r2 = android.app.PendingIntent.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.a.a((android.os.Parcel) r11, (int) r1, r2)
            r6 = r1
            android.app.PendingIntent r6 = (android.app.PendingIntent) r6
            goto L_0x000c
        L_0x004f:
            int r5 = com.google.android.gms.common.internal.safeparcel.a.e(r11, r1)
            goto L_0x000c
        L_0x0054:
            com.google.android.gms.common.internal.safeparcel.a.A(r11, r0)
            com.google.android.gms.auth.api.proxy.ProxyResponse r11 = new com.google.android.gms.auth.api.proxy.ProxyResponse
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.proxy.c.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
