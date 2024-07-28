package com.sendbird.android.shadow.okio;

import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

final class d {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f45273a;

    /* renamed from: b  reason: collision with root package name */
    int f45274b;

    /* renamed from: c  reason: collision with root package name */
    int f45275c;

    /* renamed from: d  reason: collision with root package name */
    boolean f45276d;

    /* renamed from: e  reason: collision with root package name */
    boolean f45277e;

    /* renamed from: f  reason: collision with root package name */
    d f45278f;

    /* renamed from: g  reason: collision with root package name */
    d f45279g;

    d() {
        this.f45273a = new byte[FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE];
        this.f45277e = true;
        this.f45276d = false;
    }

    d(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.f45273a = bArr;
        this.f45274b = i2;
        this.f45275c = i3;
        this.f45276d = z;
        this.f45277e = z2;
    }

    /* access modifiers changed from: package-private */
    public final d a() {
        this.f45276d = true;
        return new d(this.f45273a, this.f45274b, this.f45275c, true, false);
    }

    /* access modifiers changed from: package-private */
    public final d b() {
        return new d((byte[]) this.f45273a.clone(), this.f45274b, this.f45275c, false, true);
    }

    public final d c() {
        d dVar = this.f45278f;
        if (dVar == this) {
            dVar = null;
        }
        d dVar2 = this.f45279g;
        dVar2.f45278f = this.f45278f;
        this.f45278f.f45279g = dVar2;
        this.f45278f = null;
        this.f45279g = null;
        return dVar;
    }

    public final d a(d dVar) {
        dVar.f45279g = this;
        dVar.f45278f = this.f45278f;
        this.f45278f.f45279g = dVar;
        this.f45278f = dVar;
        return dVar;
    }

    public final void a(d dVar, int i2) {
        if (dVar.f45277e) {
            int i3 = dVar.f45275c;
            if (i3 + i2 > 8192) {
                if (!dVar.f45276d) {
                    int i4 = dVar.f45274b;
                    if ((i3 + i2) - i4 <= 8192) {
                        byte[] bArr = dVar.f45273a;
                        System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
                        dVar.f45275c -= dVar.f45274b;
                        dVar.f45274b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f45273a, this.f45274b, dVar.f45273a, dVar.f45275c, i2);
            dVar.f45275c += i2;
            this.f45274b += i2;
            return;
        }
        throw new IllegalArgumentException();
    }
}
