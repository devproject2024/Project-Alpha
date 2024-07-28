package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.f.l;
import com.google.android.exoplayer2.g.ae;
import java.io.IOException;
import java.util.Arrays;

public abstract class j extends d {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f32851a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f32852b;

    /* access modifiers changed from: protected */
    public abstract void a(byte[] bArr, int i2) throws IOException;

    public j(i iVar, l lVar, Format format, int i2, Object obj, byte[] bArr) {
        super(iVar, lVar, 3, format, i2, obj, -9223372036854775807L, -9223372036854775807L);
        this.f32851a = bArr;
    }

    public final void a() {
        this.f32852b = true;
    }

    public final void b() throws IOException, InterruptedException {
        try {
            this.l.a(this.f32814e);
            int i2 = 0;
            int i3 = 0;
            while (i2 != -1 && !this.f32852b) {
                if (this.f32851a == null) {
                    this.f32851a = new byte[16384];
                } else if (this.f32851a.length < i3 + 16384) {
                    this.f32851a = Arrays.copyOf(this.f32851a, this.f32851a.length + 16384);
                }
                i2 = this.l.a(this.f32851a, i3, 16384);
                if (i2 != -1) {
                    i3 += i2;
                }
            }
            if (!this.f32852b) {
                a(this.f32851a, i3);
            }
        } finally {
            ae.a((i) this.l);
        }
    }
}
