package com.google.android.exoplayer2.drm;

import android.os.Looper;
import com.google.android.exoplayer2.drm.g;

public interface e<T extends g> {
    d<T> a(Looper looper, DrmInitData drmInitData);

    void a(d<T> dVar);

    boolean a(DrmInitData drmInitData);
}
