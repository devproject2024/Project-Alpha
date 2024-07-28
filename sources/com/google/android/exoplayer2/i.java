package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g.a;
import java.io.IOException;

public final class i extends Exception {
    public static final int TYPE_OUT_OF_MEMORY = 4;
    public static final int TYPE_REMOTE = 3;
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_UNEXPECTED = 2;
    private final Throwable cause;
    public final int rendererIndex;
    public final int type;

    public static i createForSource(IOException iOException) {
        return new i(0, iOException, -1);
    }

    public static i createForRenderer(Exception exc, int i2) {
        return new i(1, exc, i2);
    }

    public static i createForUnexpected(RuntimeException runtimeException) {
        return new i(2, runtimeException, -1);
    }

    public static i createForRemote(String str) {
        return new i(3, str);
    }

    public static i createForOutOfMemoryError(OutOfMemoryError outOfMemoryError) {
        return new i(4, outOfMemoryError, -1);
    }

    private i(int i2, Throwable th, int i3) {
        super(th);
        this.type = i2;
        this.cause = th;
        this.rendererIndex = i3;
    }

    private i(int i2, String str) {
        super(str);
        this.type = i2;
        this.rendererIndex = -1;
        this.cause = null;
    }

    public final IOException getSourceException() {
        a.b(this.type == 0);
        return (IOException) a.a(this.cause);
    }

    public final Exception getRendererException() {
        boolean z = true;
        if (this.type != 1) {
            z = false;
        }
        a.b(z);
        return (Exception) a.a(this.cause);
    }

    public final RuntimeException getUnexpectedException() {
        a.b(this.type == 2);
        return (RuntimeException) a.a(this.cause);
    }

    public final OutOfMemoryError getOutOfMemoryError() {
        a.b(this.type == 4);
        return (OutOfMemoryError) a.a(this.cause);
    }
}
