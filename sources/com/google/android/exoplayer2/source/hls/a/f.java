package com.google.android.exoplayer2.source.hls.a;

import com.google.android.exoplayer2.offline.a;
import java.util.Collections;
import java.util.List;

public abstract class f implements a<f> {
    public final String n;
    public final List<String> o;
    public final boolean p;

    protected f(String str, List<String> list, boolean z) {
        this.n = str;
        this.o = Collections.unmodifiableList(list);
        this.p = z;
    }
}
