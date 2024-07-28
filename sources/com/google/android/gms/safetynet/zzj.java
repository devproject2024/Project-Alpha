package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzj implements Parcelable.Creator<SafeBrowsingData> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new SafeBrowsingData[i2];
    }

    static void zza(SafeBrowsingData safeBrowsingData, Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, safeBrowsingData.getMetadata(), false);
        b.a(parcel, 3, safeBrowsingData.getBlacklistsDataHolder(), i2, false);
        b.a(parcel, 4, safeBrowsingData.getFileDescriptor(), i2, false);
        b.a(parcel, 5, safeBrowsingData.getLastUpdateTimeMs());
        b.a(parcel, 6, safeBrowsingData.getState(), false);
        b.b(parcel, a2);
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r12) {
        /*
            r11 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.a.a(r12)
            r1 = 0
            r2 = 0
            r5 = r1
            r6 = r5
            r7 = r6
            r10 = r7
            r8 = r2
        L_0x000c:
            int r1 = r12.dataPosition()
            if (r1 >= r0) goto L_0x0050
            int r1 = r12.readInt()
            r2 = 65535(0xffff, float:9.1834E-41)
            r2 = r2 & r1
            r3 = 2
            if (r2 == r3) goto L_0x004b
            r3 = 3
            if (r2 == r3) goto L_0x0041
            r3 = 4
            if (r2 == r3) goto L_0x0037
            r3 = 5
            if (r2 == r3) goto L_0x0032
            r3 = 6
            if (r2 == r3) goto L_0x002d
            com.google.android.gms.common.internal.safeparcel.a.b(r12, r1)
            goto L_0x000c
        L_0x002d:
            byte[] r10 = com.google.android.gms.common.internal.safeparcel.a.q(r12, r1)
            goto L_0x000c
        L_0x0032:
            long r8 = com.google.android.gms.common.internal.safeparcel.a.g(r12, r1)
            goto L_0x000c
        L_0x0037:
            android.os.Parcelable$Creator r2 = android.os.ParcelFileDescriptor.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.a.a((android.os.Parcel) r12, (int) r1, r2)
            r7 = r1
            android.os.ParcelFileDescriptor r7 = (android.os.ParcelFileDescriptor) r7
            goto L_0x000c
        L_0x0041:
            android.os.Parcelable$Creator<com.google.android.gms.common.data.DataHolder> r2 = com.google.android.gms.common.data.DataHolder.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.a.a((android.os.Parcel) r12, (int) r1, r2)
            r6 = r1
            com.google.android.gms.common.data.DataHolder r6 = (com.google.android.gms.common.data.DataHolder) r6
            goto L_0x000c
        L_0x004b:
            java.lang.String r5 = com.google.android.gms.common.internal.safeparcel.a.n(r12, r1)
            goto L_0x000c
        L_0x0050:
            com.google.android.gms.common.internal.safeparcel.a.A(r12, r0)
            com.google.android.gms.safetynet.SafeBrowsingData r12 = new com.google.android.gms.safetynet.SafeBrowsingData
            r4 = r12
            r4.<init>(r5, r6, r7, r8, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.safetynet.zzj.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
