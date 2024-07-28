package com.google.firebase.perf.network;

import com.google.android.gms.internal.p001firebaseperf.t;
import com.google.android.gms.internal.p001firebaseperf.zzbg;
import java.io.IOException;
import java.io.OutputStream;

public final class a extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private OutputStream f39280a;

    /* renamed from: b  reason: collision with root package name */
    private long f39281b = -1;

    /* renamed from: c  reason: collision with root package name */
    private t f39282c;

    /* renamed from: d  reason: collision with root package name */
    private final zzbg f39283d;

    public a(OutputStream outputStream, t tVar, zzbg zzbg) {
        this.f39280a = outputStream;
        this.f39282c = tVar;
        this.f39283d = zzbg;
    }

    public final void close() throws IOException {
        long j = this.f39281b;
        if (j != -1) {
            this.f39282c.a(j);
        }
        t tVar = this.f39282c;
        tVar.f9726a.d(this.f39283d.b());
        try {
            this.f39280a.close();
        } catch (IOException e2) {
            this.f39282c.d(this.f39283d.b());
            g.a(this.f39282c);
            throw e2;
        }
    }

    public final void flush() throws IOException {
        try {
            this.f39280a.flush();
        } catch (IOException e2) {
            this.f39282c.d(this.f39283d.b());
            g.a(this.f39282c);
            throw e2;
        }
    }

    public final void write(int i2) throws IOException {
        try {
            this.f39280a.write(i2);
            this.f39281b++;
            this.f39282c.a(this.f39281b);
        } catch (IOException e2) {
            this.f39282c.d(this.f39283d.b());
            g.a(this.f39282c);
            throw e2;
        }
    }

    public final void write(byte[] bArr) throws IOException {
        try {
            this.f39280a.write(bArr);
            this.f39281b += (long) bArr.length;
            this.f39282c.a(this.f39281b);
        } catch (IOException e2) {
            this.f39282c.d(this.f39283d.b());
            g.a(this.f39282c);
            throw e2;
        }
    }

    public final void write(byte[] bArr, int i2, int i3) throws IOException {
        try {
            this.f39280a.write(bArr, i2, i3);
            this.f39281b += (long) i3;
            this.f39282c.a(this.f39281b);
        } catch (IOException e2) {
            this.f39282c.d(this.f39283d.b());
            g.a(this.f39282c);
            throw e2;
        }
    }
}
