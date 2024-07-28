package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.source.v;
import com.google.android.exoplayer2.trackselection.f;
import java.io.IOException;

public interface n extends v {

    public interface a extends v.a<n> {
        void a(n nVar);
    }

    long a(long j, af afVar);

    long a(f[] fVarArr, boolean[] zArr, u[] uVarArr, boolean[] zArr2, long j);

    void a(long j);

    void a(long j, boolean z);

    void a(a aVar, long j);

    long b(long j);

    TrackGroupArray b();

    long c();

    boolean c(long j);

    long d();

    long e();

    void i_() throws IOException;
}
