package com.bumptech.glide.d;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final List<ImageHeaderParser> f6491a = new ArrayList();

    public final synchronized List<ImageHeaderParser> a() {
        return this.f6491a;
    }

    public final synchronized void a(ImageHeaderParser imageHeaderParser) {
        this.f6491a.add(imageHeaderParser);
    }
}
