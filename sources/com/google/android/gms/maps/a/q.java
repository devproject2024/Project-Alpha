package com.google.android.gms.maps.a;

import com.google.android.gms.internal.h.e;

public abstract class q extends e implements p {
    public q() {
        super("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
    }

    /* JADX WARNING: type inference failed for: r4v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int r3, android.os.Parcel r4, android.os.Parcel r5) throws android.os.RemoteException {
        /*
            r2 = this;
            r0 = 1
            if (r3 != r0) goto L_0x0026
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x000b
            r3 = 0
            goto L_0x001f
        L_0x000b:
            java.lang.String r4 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
            android.os.IInterface r4 = r3.queryLocalInterface(r4)
            boolean r1 = r4 instanceof com.google.android.gms.maps.a.e
            if (r1 == 0) goto L_0x0019
            r3 = r4
            com.google.android.gms.maps.a.e r3 = (com.google.android.gms.maps.a.e) r3
            goto L_0x001f
        L_0x0019:
            com.google.android.gms.maps.a.r r4 = new com.google.android.gms.maps.a.r
            r4.<init>(r3)
            r3 = r4
        L_0x001f:
            r2.a(r3)
            r5.writeNoException()
            return r0
        L_0x0026:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.a.q.a(int, android.os.Parcel, android.os.Parcel):boolean");
    }
}
