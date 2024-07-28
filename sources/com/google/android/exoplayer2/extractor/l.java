package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.a;
import java.io.EOFException;
import java.io.IOException;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    private final r f32145a = new r(10);

    public final Metadata a(h hVar, a.C0545a aVar) throws IOException, InterruptedException {
        Metadata metadata = null;
        int i2 = 0;
        while (true) {
            try {
                hVar.c(this.f32145a.f32566a, 0, 10);
                this.f32145a.c(0);
                if (this.f32145a.f() != a.f32718b) {
                    break;
                }
                this.f32145a.d(3);
                int m = this.f32145a.m();
                int i3 = m + 10;
                if (metadata == null) {
                    byte[] bArr = new byte[i3];
                    System.arraycopy(this.f32145a.f32566a, 0, bArr, 0, 10);
                    hVar.c(bArr, 10, m);
                    metadata = new a(aVar).a(bArr, i3);
                } else {
                    hVar.c(m);
                }
                i2 += i3;
            } catch (EOFException unused) {
            }
        }
        hVar.a();
        hVar.c(i2);
        return metadata;
    }
}
