package com.google.android.exoplayer2;

public final class p extends IllegalStateException {
    public final long positionMs;
    public final ah timeline;
    public final int windowIndex;

    public p(ah ahVar, int i2, long j) {
        this.timeline = ahVar;
        this.windowIndex = i2;
        this.positionMs = j;
    }
}
