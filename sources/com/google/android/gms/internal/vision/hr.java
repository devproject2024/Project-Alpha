package com.google.android.gms.internal.vision;

import android.os.IBinder;

public final class hr extends u implements fq {
    hr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.vision.dq a(com.google.android.gms.b.b r3, com.google.android.gms.internal.vision.zzf r4) throws android.os.RemoteException {
        /*
            r2 = this;
            android.os.Parcel r0 = r2.a()
            com.google.android.gms.internal.vision.as.a((android.os.Parcel) r0, (android.os.IInterface) r3)
            com.google.android.gms.internal.vision.as.a((android.os.Parcel) r0, (android.os.Parcelable) r4)
            r3 = 1
            android.os.Parcel r3 = r2.a(r3, r0)
            android.os.IBinder r4 = r3.readStrongBinder()
            if (r4 != 0) goto L_0x0017
            r4 = 0
            goto L_0x002b
        L_0x0017:
            java.lang.String r0 = "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector"
            android.os.IInterface r0 = r4.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.vision.dq
            if (r1 == 0) goto L_0x0025
            r4 = r0
            com.google.android.gms.internal.vision.dq r4 = (com.google.android.gms.internal.vision.dq) r4
            goto L_0x002b
        L_0x0025:
            com.google.android.gms.internal.vision.gr r0 = new com.google.android.gms.internal.vision.gr
            r0.<init>(r4)
            r4 = r0
        L_0x002b:
            r3.recycle()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.hr.a(com.google.android.gms.b.b, com.google.android.gms.internal.vision.zzf):com.google.android.gms.internal.vision.dq");
    }
}
