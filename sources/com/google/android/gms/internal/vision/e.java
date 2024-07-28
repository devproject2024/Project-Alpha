package com.google.android.gms.internal.vision;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.b.d;

public final class e extends ib<ig> {

    /* renamed from: a  reason: collision with root package name */
    private final zzah f11078a;

    public e(Context context, zzah zzah) {
        super(context, "TextNativeHandle", "ocr");
        this.f11078a = zzah;
        d();
    }

    public final zzac[] a(Bitmap bitmap, zzp zzp, zzae zzae) {
        if (!b()) {
            return new zzac[0];
        }
        try {
            return ((ig) d()).a(d.a(bitmap), zzp, zzae);
        } catch (RemoteException unused) {
            return new zzac[0];
        }
    }

    /* access modifiers changed from: protected */
    public final void a() throws RemoteException {
        ((ig) d()).b();
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object a(com.google.android.gms.dynamite.DynamiteModule r4, android.content.Context r5) throws android.os.RemoteException, com.google.android.gms.dynamite.DynamiteModule.a {
        /*
            r3 = this;
            java.lang.String r0 = "com.google.android.gms.vision.text.ChimeraNativeTextRecognizerCreator"
            android.os.IBinder r4 = r4.a((java.lang.String) r0)
            r0 = 0
            if (r4 != 0) goto L_0x000b
            r4 = r0
            goto L_0x001f
        L_0x000b:
            java.lang.String r1 = "com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator"
            android.os.IInterface r1 = r4.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.vision.a
            if (r2 == 0) goto L_0x0019
            r4 = r1
            com.google.android.gms.internal.vision.a r4 = (com.google.android.gms.internal.vision.a) r4
            goto L_0x001f
        L_0x0019:
            com.google.android.gms.internal.vision.ih r1 = new com.google.android.gms.internal.vision.ih
            r1.<init>(r4)
            r4 = r1
        L_0x001f:
            if (r4 != 0) goto L_0x0022
            return r0
        L_0x0022:
            com.google.android.gms.b.b r5 = com.google.android.gms.b.d.a(r5)
            com.google.android.gms.internal.vision.zzah r0 = r3.f11078a
            com.google.android.gms.internal.vision.ig r4 = r4.a(r5, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.e.a(com.google.android.gms.dynamite.DynamiteModule, android.content.Context):java.lang.Object");
    }
}
