package i;

import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

final class r {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f46320a;

    /* renamed from: b  reason: collision with root package name */
    int f46321b;

    /* renamed from: c  reason: collision with root package name */
    int f46322c;

    /* renamed from: d  reason: collision with root package name */
    boolean f46323d;

    /* renamed from: e  reason: collision with root package name */
    boolean f46324e;

    /* renamed from: f  reason: collision with root package name */
    r f46325f;

    /* renamed from: g  reason: collision with root package name */
    r f46326g;

    r() {
        this.f46320a = new byte[FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE];
        this.f46324e = true;
        this.f46323d = false;
    }

    r(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.f46320a = bArr;
        this.f46321b = i2;
        this.f46322c = i3;
        this.f46323d = z;
        this.f46324e = z2;
    }

    /* access modifiers changed from: package-private */
    public final r a() {
        this.f46323d = true;
        return new r(this.f46320a, this.f46321b, this.f46322c, true, false);
    }

    /* access modifiers changed from: package-private */
    public final r b() {
        return new r((byte[]) this.f46320a.clone(), this.f46321b, this.f46322c, false, true);
    }

    public final r c() {
        r rVar = this.f46325f;
        if (rVar == this) {
            rVar = null;
        }
        r rVar2 = this.f46326g;
        rVar2.f46325f = this.f46325f;
        this.f46325f.f46326g = rVar2;
        this.f46325f = null;
        this.f46326g = null;
        return rVar;
    }

    public final r a(r rVar) {
        rVar.f46326g = this;
        rVar.f46325f = this.f46325f;
        this.f46325f.f46326g = rVar;
        this.f46325f = rVar;
        return rVar;
    }

    public final void a(r rVar, int i2) {
        if (rVar.f46324e) {
            int i3 = rVar.f46322c;
            if (i3 + i2 > 8192) {
                if (!rVar.f46323d) {
                    int i4 = rVar.f46321b;
                    if ((i3 + i2) - i4 <= 8192) {
                        byte[] bArr = rVar.f46320a;
                        System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
                        rVar.f46322c -= rVar.f46321b;
                        rVar.f46321b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f46320a, this.f46321b, rVar.f46320a, rVar.f46322c, i2);
            rVar.f46322c += i2;
            this.f46321b += i2;
            return;
        }
        throw new IllegalArgumentException();
    }
}
