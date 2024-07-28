package com.google.android.exoplayer2.extractor.b;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.b.d;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.c;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.v;
import java.util.Collections;
import java.util.List;

final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f31687a = {5512, 11025, 22050, 44100};

    /* renamed from: c  reason: collision with root package name */
    private boolean f31688c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f31689d;

    /* renamed from: e  reason: collision with root package name */
    private int f31690e;

    public a(q qVar) {
        super(qVar);
    }

    /* access modifiers changed from: protected */
    public final boolean a(r rVar) throws d.a {
        if (!this.f31688c) {
            int c2 = rVar.c();
            this.f31690e = (c2 >> 4) & 15;
            int i2 = this.f31690e;
            if (i2 == 2) {
                this.f31701b.a(Format.a((String) null, "audio/mpeg", -1, -1, 1, f31687a[(c2 >> 2) & 3], (List<byte[]>) null, (DrmInitData) null, (String) null));
                this.f31689d = true;
            } else if (i2 == 7 || i2 == 8) {
                this.f31701b.a(Format.a((String) null, this.f31690e == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", -1, -1, 1, 8000, (c2 & 1) == 1 ? 2 : 3, (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
                this.f31689d = true;
            } else if (i2 != 10) {
                throw new d.a("Audio format not supported: " + this.f31690e);
            }
            this.f31688c = true;
        } else {
            rVar.d(1);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean a(r rVar, long j) throws v {
        if (this.f31690e == 2) {
            int b2 = rVar.b();
            this.f31701b.a(rVar, b2);
            this.f31701b.a(j, 1, b2, 0, (q.a) null);
            return true;
        }
        int c2 = rVar.c();
        if (c2 == 0 && !this.f31689d) {
            byte[] bArr = new byte[rVar.b()];
            rVar.a(bArr, 0, bArr.length);
            Pair<Integer, Integer> a2 = c.a(bArr);
            this.f31701b.a(Format.a((String) null, "audio/mp4a-latm", -1, -1, ((Integer) a2.second).intValue(), ((Integer) a2.first).intValue(), (List<byte[]>) Collections.singletonList(bArr), (DrmInitData) null, (String) null));
            this.f31689d = true;
            return false;
        } else if (this.f31690e == 10 && c2 != 1) {
            return false;
        } else {
            int b3 = rVar.b();
            this.f31701b.a(rVar, b3);
            this.f31701b.a(j, 1, b3, 0, (q.a) null);
            return true;
        }
    }
}
