package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class l implements i {

    /* renamed from: a  reason: collision with root package name */
    private final i f33211a;

    /* renamed from: b  reason: collision with root package name */
    private final int f33212b;

    /* renamed from: c  reason: collision with root package name */
    private final a f33213c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f33214d;

    /* renamed from: e  reason: collision with root package name */
    private int f33215e;

    public interface a {
        void a(r rVar);
    }

    public l(i iVar, int i2, a aVar) {
        com.google.android.exoplayer2.g.a.a(i2 > 0);
        this.f33211a = iVar;
        this.f33212b = i2;
        this.f33213c = aVar;
        this.f33214d = new byte[1];
        this.f33215e = i2;
    }

    public final void a(ad adVar) {
        this.f33211a.a(adVar);
    }

    public final long a(com.google.android.exoplayer2.f.l lVar) throws IOException {
        throw new UnsupportedOperationException();
    }

    public final int a(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f33215e == 0) {
            boolean z = false;
            if (this.f33211a.a(this.f33214d, 0, 1) != -1) {
                int i4 = (this.f33214d[0] & 255) << 4;
                if (i4 != 0) {
                    byte[] bArr2 = new byte[i4];
                    int i5 = i4;
                    int i6 = 0;
                    while (true) {
                        if (i5 <= 0) {
                            while (i4 > 0 && bArr2[i4 - 1] == 0) {
                                i4--;
                            }
                            if (i4 > 0) {
                                this.f33213c.a(new r(bArr2, i4));
                            }
                        } else {
                            int a2 = this.f33211a.a(bArr2, i6, i5);
                            if (a2 == -1) {
                                break;
                            }
                            i6 += a2;
                            i5 -= a2;
                        }
                    }
                }
                z = true;
            }
            if (!z) {
                return -1;
            }
            this.f33215e = this.f33212b;
        }
        int a3 = this.f33211a.a(bArr, i2, Math.min(this.f33215e, i3));
        if (a3 != -1) {
            this.f33215e -= a3;
        }
        return a3;
    }

    public final Uri a() {
        return this.f33211a.a();
    }

    public final Map<String, List<String>> b() {
        return this.f33211a.b();
    }

    public final void c() throws IOException {
        throw new UnsupportedOperationException();
    }
}
