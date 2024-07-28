package com.google.android.exoplayer2.extractor.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.b.d;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.p;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.v;
import com.google.android.exoplayer2.video.a;

final class e extends d {

    /* renamed from: a  reason: collision with root package name */
    private final r f31702a = new r(p.f32546a);

    /* renamed from: c  reason: collision with root package name */
    private final r f31703c = new r(4);

    /* renamed from: d  reason: collision with root package name */
    private int f31704d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f31705e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f31706f;

    /* renamed from: g  reason: collision with root package name */
    private int f31707g;

    public e(q qVar) {
        super(qVar);
    }

    /* access modifiers changed from: protected */
    public final boolean a(r rVar) throws d.a {
        int c2 = rVar.c();
        int i2 = (c2 >> 4) & 15;
        int i3 = c2 & 15;
        if (i3 == 7) {
            this.f31707g = i2;
            return i2 != 5;
        }
        throw new d.a("Video format not supported: ".concat(String.valueOf(i3)));
    }

    /* access modifiers changed from: protected */
    public final boolean a(r rVar, long j) throws v {
        int c2 = rVar.c();
        byte[] bArr = rVar.f32566a;
        int i2 = rVar.f32567b;
        rVar.f32567b = i2 + 1;
        byte[] bArr2 = rVar.f32566a;
        int i3 = rVar.f32567b;
        rVar.f32567b = i3 + 1;
        byte b2 = (((bArr[i2] & 255) << 24) >> 8) | ((bArr2[i3] & 255) << 8);
        byte[] bArr3 = rVar.f32566a;
        int i4 = rVar.f32567b;
        rVar.f32567b = i4 + 1;
        long j2 = j + (((long) (b2 | (bArr3[i4] & 255))) * 1000);
        if (c2 == 0 && !this.f31705e) {
            r rVar2 = new r(new byte[rVar.b()]);
            rVar.a(rVar2.f32566a, 0, rVar.b());
            a a2 = a.a(rVar2);
            this.f31704d = a2.f33663b;
            this.f31701b.a(Format.a((String) null, "video/avc", (String) null, a2.f33664c, a2.f33665d, a2.f33662a, a2.f33666e));
            this.f31705e = true;
            return false;
        } else if (c2 != 1 || !this.f31705e) {
            return false;
        } else {
            int i5 = this.f31707g == 1 ? 1 : 0;
            if (!this.f31706f && i5 == 0) {
                return false;
            }
            byte[] bArr4 = this.f31703c.f32566a;
            bArr4[0] = 0;
            bArr4[1] = 0;
            bArr4[2] = 0;
            int i6 = 4 - this.f31704d;
            int i7 = 0;
            while (rVar.b() > 0) {
                rVar.a(this.f31703c.f32566a, i6, this.f31704d);
                this.f31703c.c(0);
                int n = this.f31703c.n();
                this.f31702a.c(0);
                this.f31701b.a(this.f31702a, 4);
                this.f31701b.a(rVar, n);
                i7 = i7 + 4 + n;
            }
            this.f31701b.a(j2, i5, i7, 0, (q.a) null);
            this.f31706f = true;
            return true;
        }
    }
}
