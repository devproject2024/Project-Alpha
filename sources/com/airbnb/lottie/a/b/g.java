package com.airbnb.lottie.a.b;

import android.graphics.Path;
import com.airbnb.lottie.c.b.l;
import java.util.ArrayList;
import java.util.List;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final List<a<l, Path>> f5764a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a<Integer, Integer>> f5765b;

    /* renamed from: c  reason: collision with root package name */
    public final List<com.airbnb.lottie.c.b.g> f5766c;

    public g(List<com.airbnb.lottie.c.b.g> list) {
        this.f5766c = list;
        this.f5764a = new ArrayList(list.size());
        this.f5765b = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f5764a.add(list.get(i2).f5862b.a());
            this.f5765b.add(list.get(i2).f5863c.a());
        }
    }
}
