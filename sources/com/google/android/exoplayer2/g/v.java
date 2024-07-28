package com.google.android.exoplayer2.g;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class v extends BufferedOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private boolean f32576a;

    public v(OutputStream outputStream, int i2) {
        super(outputStream, i2);
    }

    public final void close() throws IOException {
        this.f32576a = true;
        try {
            flush();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.out.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th != null) {
            ae.a(th);
        }
    }

    public final void a(OutputStream outputStream) {
        a.b(this.f32576a);
        this.out = outputStream;
        this.count = 0;
        this.f32576a = false;
    }
}
