package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class q extends o {

    /* renamed from: b  reason: collision with root package name */
    private static final WeakReference<byte[]> f8889b = new WeakReference<>((Object) null);

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<byte[]> f8890a = f8889b;

    q(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: protected */
    public abstract byte[] d();

    /* access modifiers changed from: package-private */
    public final byte[] c() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.f8890a.get();
            if (bArr == null) {
                bArr = d();
                this.f8890a = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }
}
