package com.bumptech.glide.e;

import com.bumptech.glide.e.a.j;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.b.q;

public interface g<R> {
    boolean onLoadFailed(q qVar, Object obj, j<R> jVar, boolean z);

    boolean onResourceReady(R r, Object obj, j<R> jVar, a aVar, boolean z);
}
