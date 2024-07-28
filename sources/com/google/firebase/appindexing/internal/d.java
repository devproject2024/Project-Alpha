package com.google.firebase.appindexing.internal;

import android.os.Parcelable;

public final class d implements Parcelable.Creator<Thing> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new Thing[i2];
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r10) {
        /*
            r9 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.a.a(r10)
            r1 = 0
            r2 = 0
            r5 = r1
            r6 = r5
            r7 = r6
            r8 = r7
            r4 = 0
        L_0x000b:
            int r1 = r10.dataPosition()
            if (r1 >= r0) goto L_0x004b
            int r1 = r10.readInt()
            r2 = 65535(0xffff, float:9.1834E-41)
            r2 = r2 & r1
            r3 = 1
            if (r2 == r3) goto L_0x0046
            r3 = 2
            if (r2 == r3) goto L_0x003c
            r3 = 3
            if (r2 == r3) goto L_0x0037
            r3 = 4
            if (r2 == r3) goto L_0x0032
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r2 == r3) goto L_0x002d
            com.google.android.gms.common.internal.safeparcel.a.b(r10, r1)
            goto L_0x000b
        L_0x002d:
            int r4 = com.google.android.gms.common.internal.safeparcel.a.e(r10, r1)
            goto L_0x000b
        L_0x0032:
            java.lang.String r8 = com.google.android.gms.common.internal.safeparcel.a.n(r10, r1)
            goto L_0x000b
        L_0x0037:
            java.lang.String r7 = com.google.android.gms.common.internal.safeparcel.a.n(r10, r1)
            goto L_0x000b
        L_0x003c:
            android.os.Parcelable$Creator<com.google.firebase.appindexing.internal.Thing$zza> r2 = com.google.firebase.appindexing.internal.Thing.zza.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.a.a((android.os.Parcel) r10, (int) r1, r2)
            r6 = r1
            com.google.firebase.appindexing.internal.Thing$zza r6 = (com.google.firebase.appindexing.internal.Thing.zza) r6
            goto L_0x000b
        L_0x0046:
            android.os.Bundle r5 = com.google.android.gms.common.internal.safeparcel.a.p(r10, r1)
            goto L_0x000b
        L_0x004b:
            com.google.android.gms.common.internal.safeparcel.a.A(r10, r0)
            com.google.firebase.appindexing.internal.Thing r10 = new com.google.firebase.appindexing.internal.Thing
            r3 = r10
            r3.<init>(r4, r5, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.appindexing.internal.d.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
