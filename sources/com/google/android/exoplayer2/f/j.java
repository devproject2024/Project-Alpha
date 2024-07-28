package com.google.android.exoplayer2.f;

import java.io.IOException;

public final class j extends IOException {
    public static final int POSITION_OUT_OF_RANGE = 0;
    public final int reason;

    public j(int i2) {
        this.reason = i2;
    }
}
