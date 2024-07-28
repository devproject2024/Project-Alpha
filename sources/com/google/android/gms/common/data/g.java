package com.google.android.gms.common.data;

import android.os.Parcelable;

public final class g implements Parcelable.Creator<DataHolder> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new DataHolder[i2];
    }

    /* JADX WARNING: type inference failed for: r1v13, types: [java.lang.Object[]] */
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
            r8 = r6
            r4 = 0
            r7 = 0
        L_0x000b:
            int r1 = r11.dataPosition()
            if (r1 >= r0) goto L_0x004b
            int r1 = r11.readInt()
            r3 = 65535(0xffff, float:9.1834E-41)
            r3 = r3 & r1
            r9 = 1
            if (r3 == r9) goto L_0x0046
            r9 = 2
            if (r3 == r9) goto L_0x003c
            r9 = 3
            if (r3 == r9) goto L_0x0037
            r9 = 4
            if (r3 == r9) goto L_0x0032
            r9 = 1000(0x3e8, float:1.401E-42)
            if (r3 == r9) goto L_0x002d
            com.google.android.gms.common.internal.safeparcel.a.b(r11, r1)
            goto L_0x000b
        L_0x002d:
            int r4 = com.google.android.gms.common.internal.safeparcel.a.e(r11, r1)
            goto L_0x000b
        L_0x0032:
            android.os.Bundle r8 = com.google.android.gms.common.internal.safeparcel.a.p(r11, r1)
            goto L_0x000b
        L_0x0037:
            int r7 = com.google.android.gms.common.internal.safeparcel.a.e(r11, r1)
            goto L_0x000b
        L_0x003c:
            android.os.Parcelable$Creator r3 = android.database.CursorWindow.CREATOR
            java.lang.Object[] r1 = com.google.android.gms.common.internal.safeparcel.a.b((android.os.Parcel) r11, (int) r1, r3)
            r6 = r1
            android.database.CursorWindow[] r6 = (android.database.CursorWindow[]) r6
            goto L_0x000b
        L_0x0046:
            java.lang.String[] r5 = com.google.android.gms.common.internal.safeparcel.a.v(r11, r1)
            goto L_0x000b
        L_0x004b:
            com.google.android.gms.common.internal.safeparcel.a.A(r11, r0)
            com.google.android.gms.common.data.DataHolder r11 = new com.google.android.gms.common.data.DataHolder
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            r11.f8666b = r0
            r0 = 0
        L_0x005c:
            java.lang.String[] r1 = r11.f8665a
            int r1 = r1.length
            if (r0 >= r1) goto L_0x006d
            android.os.Bundle r1 = r11.f8666b
            java.lang.String[] r3 = r11.f8665a
            r3 = r3[r0]
            r1.putInt(r3, r0)
            int r0 = r0 + 1
            goto L_0x005c
        L_0x006d:
            android.database.CursorWindow[] r0 = r11.f8667c
            int r0 = r0.length
            int[] r0 = new int[r0]
            r11.f8668d = r0
            r0 = 0
        L_0x0075:
            android.database.CursorWindow[] r1 = r11.f8667c
            int r1 = r1.length
            if (r2 >= r1) goto L_0x0095
            int[] r1 = r11.f8668d
            r1[r2] = r0
            android.database.CursorWindow[] r1 = r11.f8667c
            r1 = r1[r2]
            int r1 = r1.getStartPosition()
            int r1 = r0 - r1
            android.database.CursorWindow[] r3 = r11.f8667c
            r3 = r3[r2]
            int r3 = r3.getNumRows()
            int r3 = r3 - r1
            int r0 = r0 + r3
            int r2 = r2 + 1
            goto L_0x0075
        L_0x0095:
            r11.f8669e = r0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.g.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
