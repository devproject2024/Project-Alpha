package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.l;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f32266a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32267b;

    /* renamed from: c  reason: collision with root package name */
    public final q.a f32268c;

    /* renamed from: d  reason: collision with root package name */
    public final int f32269d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f32270e;

    public k(boolean z, String str, int i2, byte[] bArr, int i3, int i4, byte[] bArr2) {
        int i5 = 1;
        a.a((i2 == 0) ^ (bArr2 == null));
        this.f32266a = z;
        this.f32267b = str;
        this.f32269d = i2;
        this.f32270e = bArr2;
        if (str != null) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case 3046605:
                    if (str.equals("cbc1")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3046671:
                    if (str.equals("cbcs")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3049879:
                    if (str.equals("cenc")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3049895:
                    if (str.equals("cens")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (!(c2 == 0 || c2 == 1)) {
                if (c2 == 2 || c2 == 3) {
                    i5 = 2;
                } else {
                    StringBuilder sb = new StringBuilder("Unsupported protection scheme type '");
                    sb.append(str);
                    sb.append("'. Assuming AES-CTR crypto mode.");
                    l.c();
                }
            }
        }
        this.f32268c = new q.a(i5, bArr, i3, i4);
    }
}
