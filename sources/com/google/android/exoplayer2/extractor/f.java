package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.r;
import java.io.EOFException;
import java.io.IOException;

public final class f implements q {
    public final void a(long j, int i2, int i3, int i4, q.a aVar) {
    }

    public final void a(Format format) {
    }

    public final int a(h hVar, int i2, boolean z) throws IOException, InterruptedException {
        int a2 = hVar.a(i2);
        if (a2 != -1) {
            return a2;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public final void a(r rVar, int i2) {
        rVar.d(i2);
    }
}
