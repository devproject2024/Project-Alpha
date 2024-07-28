package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.ab;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.v;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class n implements g {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f33194a = Pattern.compile("LOCAL:([^,]+)");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f33195b = Pattern.compile("MPEGTS:(\\d+)");

    /* renamed from: c  reason: collision with root package name */
    private final String f33196c;

    /* renamed from: d  reason: collision with root package name */
    private final ab f33197d;

    /* renamed from: e  reason: collision with root package name */
    private final r f33198e = new r();

    /* renamed from: f  reason: collision with root package name */
    private i f33199f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f33200g = new byte[TarConstants.EOF_BLOCK];

    /* renamed from: h  reason: collision with root package name */
    private int f33201h;

    public n(String str, ab abVar) {
        this.f33196c = str;
        this.f33197d = abVar;
    }

    public final boolean a(h hVar) throws IOException, InterruptedException {
        hVar.b(this.f33200g, 0, 6, false);
        this.f33198e.a(this.f33200g, 6);
        if (com.google.android.exoplayer2.e.h.h.b(this.f33198e)) {
            return true;
        }
        hVar.b(this.f33200g, 6, 3, false);
        this.f33198e.a(this.f33200g, 9);
        return com.google.android.exoplayer2.e.h.h.b(this.f33198e);
    }

    public final void a(i iVar) {
        this.f33199f = iVar;
        iVar.a(new o.b(-9223372036854775807L));
    }

    public final void a(long j, long j2) {
        throw new IllegalStateException();
    }

    public final int a(h hVar, com.google.android.exoplayer2.extractor.n nVar) throws IOException, InterruptedException {
        int i2;
        int d2 = (int) hVar.d();
        int i3 = this.f33201h;
        byte[] bArr = this.f33200g;
        if (i3 == bArr.length) {
            if (d2 != -1) {
                i2 = d2;
            } else {
                i2 = bArr.length;
            }
            this.f33200g = Arrays.copyOf(bArr, (i2 * 3) / 2);
        }
        byte[] bArr2 = this.f33200g;
        int i4 = this.f33201h;
        int a2 = hVar.a(bArr2, i4, bArr2.length - i4);
        if (a2 != -1) {
            this.f33201h += a2;
            if (d2 == -1 || this.f33201h != d2) {
                return 0;
            }
        }
        r rVar = new r(this.f33200g);
        com.google.android.exoplayer2.e.h.h.a(rVar);
        long j = 0;
        long j2 = 0;
        while (true) {
            String r = rVar.r();
            if (TextUtils.isEmpty(r)) {
                Matcher c2 = com.google.android.exoplayer2.e.h.h.c(rVar);
                if (c2 == null) {
                    a(0);
                } else {
                    long a3 = com.google.android.exoplayer2.e.h.h.a(c2.group(1));
                    long b2 = this.f33197d.b(ab.e((j + a3) - j2));
                    q a4 = a(b2 - a3);
                    this.f33198e.a(this.f33200g, this.f33201h);
                    a4.a(this.f33198e, this.f33201h);
                    a4.a(b2, 1, this.f33201h, 0, (q.a) null);
                }
                return -1;
            } else if (r.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = f33194a.matcher(r);
                if (matcher.find()) {
                    Matcher matcher2 = f33195b.matcher(r);
                    if (matcher2.find()) {
                        j2 = com.google.android.exoplayer2.e.h.h.a(matcher.group(1));
                        j = ab.d(Long.parseLong(matcher2.group(1)));
                    } else {
                        throw new v("X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(String.valueOf(r)));
                    }
                } else {
                    throw new v("X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(String.valueOf(r)));
                }
            }
        }
    }

    private q a(long j) {
        q a2 = this.f33199f.a(0, 3);
        a2.a(Format.a("text/vtt", this.f33196c, j));
        this.f33199f.a();
        return a2;
    }
}
