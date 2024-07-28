package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.a.c;
import java.io.Closeable;
import java.io.IOException;

abstract class s implements Closeable {

    interface a {
        a a(Context context);

        s a();
    }

    /* access modifiers changed from: package-private */
    public abstract q b();

    /* access modifiers changed from: package-private */
    public abstract c c();

    s() {
    }

    public void close() throws IOException {
        c().close();
    }
}
