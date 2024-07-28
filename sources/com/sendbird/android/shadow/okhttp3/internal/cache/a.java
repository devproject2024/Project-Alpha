package com.sendbird.android.shadow.okhttp3.internal.cache;

import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.ForwardingSink;
import com.sendbird.android.shadow.okio.Sink;
import java.io.IOException;

class a extends ForwardingSink {

    /* renamed from: a  reason: collision with root package name */
    private boolean f45073a;

    /* access modifiers changed from: protected */
    public void a() {
    }

    a(Sink sink) {
        super(sink);
    }

    public void write(Buffer buffer, long j) throws IOException {
        if (this.f45073a) {
            buffer.skip(j);
            return;
        }
        try {
            super.write(buffer, j);
        } catch (IOException unused) {
            this.f45073a = true;
            a();
        }
    }

    public void flush() throws IOException {
        if (!this.f45073a) {
            try {
                super.flush();
            } catch (IOException unused) {
                this.f45073a = true;
                a();
            }
        }
    }

    public void close() throws IOException {
        if (!this.f45073a) {
            try {
                super.close();
            } catch (IOException unused) {
                this.f45073a = true;
                a();
            }
        }
    }
}
