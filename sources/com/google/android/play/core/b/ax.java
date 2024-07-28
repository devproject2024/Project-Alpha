package com.google.android.play.core.b;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public abstract class ax implements Closeable {
    public abstract long a();

    /* access modifiers changed from: protected */
    public abstract InputStream a(long j, long j2) throws IOException;

    public final synchronized InputStream b() throws IOException {
        return a(0, a());
    }
}
