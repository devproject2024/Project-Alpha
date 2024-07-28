package com.google.android.exoplayer2.c;

import android.media.MediaCodec;
import com.google.android.exoplayer2.g.ae;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f31290a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f31291b;

    /* renamed from: c  reason: collision with root package name */
    public int f31292c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f31293d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f31294e;

    /* renamed from: f  reason: collision with root package name */
    public int f31295f;

    /* renamed from: g  reason: collision with root package name */
    public int f31296g;

    /* renamed from: h  reason: collision with root package name */
    public int f31297h;

    /* renamed from: i  reason: collision with root package name */
    public final MediaCodec.CryptoInfo f31298i = new MediaCodec.CryptoInfo();
    private final a j;

    public b() {
        this.j = ae.f32499a >= 24 ? new a(this.f31298i, (byte) 0) : null;
    }

    public final void a(int i2, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i3, int i4, int i5) {
        this.f31295f = i2;
        this.f31293d = iArr;
        this.f31294e = iArr2;
        this.f31291b = bArr;
        this.f31290a = bArr2;
        this.f31292c = i3;
        this.f31296g = i4;
        this.f31297h = i5;
        MediaCodec.CryptoInfo cryptoInfo = this.f31298i;
        cryptoInfo.numSubSamples = i2;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i3;
        if (ae.f32499a >= 24) {
            a aVar = this.j;
            aVar.f31300b.set(i4, i5);
            aVar.f31299a.setPattern(aVar.f31300b);
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final MediaCodec.CryptoInfo f31299a;

        /* renamed from: b  reason: collision with root package name */
        final MediaCodec.CryptoInfo.Pattern f31300b;

        /* synthetic */ a(MediaCodec.CryptoInfo cryptoInfo, byte b2) {
            this(cryptoInfo);
        }

        private a(MediaCodec.CryptoInfo cryptoInfo) {
            this.f31299a = cryptoInfo;
            this.f31300b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }
    }
}
