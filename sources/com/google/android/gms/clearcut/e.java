package com.google.android.gms.clearcut;

import android.os.Parcelable;

public final class e implements Parcelable.Creator<zze> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zze[i2];
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r13) {
        /*
            r12 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.a.a(r13)
            r1 = 0
            r2 = 1
            r4 = r1
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r11 = r9
            r10 = 1
        L_0x000e:
            int r1 = r13.dataPosition()
            if (r1 >= r0) goto L_0x0055
            int r1 = r13.readInt()
            r2 = 65535(0xffff, float:9.1834E-41)
            r2 = r2 & r1
            switch(r2) {
                case 2: goto L_0x004b;
                case 3: goto L_0x0046;
                case 4: goto L_0x0041;
                case 5: goto L_0x003c;
                case 6: goto L_0x0037;
                case 7: goto L_0x0032;
                case 8: goto L_0x002d;
                case 9: goto L_0x0023;
                default: goto L_0x001f;
            }
        L_0x001f:
            com.google.android.gms.common.internal.safeparcel.a.b(r13, r1)
            goto L_0x000e
        L_0x0023:
            android.os.Parcelable$Creator<com.google.android.gms.phenotype.ExperimentTokens> r2 = com.google.android.gms.phenotype.ExperimentTokens.CREATOR
            java.lang.Object[] r1 = com.google.android.gms.common.internal.safeparcel.a.b((android.os.Parcel) r13, (int) r1, r2)
            r11 = r1
            com.google.android.gms.phenotype.ExperimentTokens[] r11 = (com.google.android.gms.phenotype.ExperimentTokens[]) r11
            goto L_0x000e
        L_0x002d:
            boolean r10 = com.google.android.gms.common.internal.safeparcel.a.c(r13, r1)
            goto L_0x000e
        L_0x0032:
            byte[][] r9 = com.google.android.gms.common.internal.safeparcel.a.r(r13, r1)
            goto L_0x000e
        L_0x0037:
            int[] r8 = com.google.android.gms.common.internal.safeparcel.a.s(r13, r1)
            goto L_0x000e
        L_0x003c:
            java.lang.String[] r7 = com.google.android.gms.common.internal.safeparcel.a.v(r13, r1)
            goto L_0x000e
        L_0x0041:
            int[] r6 = com.google.android.gms.common.internal.safeparcel.a.s(r13, r1)
            goto L_0x000e
        L_0x0046:
            byte[] r5 = com.google.android.gms.common.internal.safeparcel.a.q(r13, r1)
            goto L_0x000e
        L_0x004b:
            android.os.Parcelable$Creator<com.google.android.gms.internal.clearcut.zzr> r2 = com.google.android.gms.internal.clearcut.zzr.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.a.a((android.os.Parcel) r13, (int) r1, r2)
            r4 = r1
            com.google.android.gms.internal.clearcut.zzr r4 = (com.google.android.gms.internal.clearcut.zzr) r4
            goto L_0x000e
        L_0x0055:
            com.google.android.gms.common.internal.safeparcel.a.A(r13, r0)
            com.google.android.gms.clearcut.zze r13 = new com.google.android.gms.clearcut.zze
            r3 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.clearcut.e.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
