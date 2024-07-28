package com.airbnb.lottie.c.a;

import com.airbnb.lottie.g.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract class n<V, O> implements m<V, O> {

    /* renamed from: a  reason: collision with root package name */
    final List<a<V>> f5826a;

    n(V v) {
        this(Collections.singletonList(new a(v)));
    }

    n(List<a<V>> list) {
        this.f5826a = list;
    }

    public List<a<V>> c() {
        return this.f5826a;
    }

    public boolean b() {
        return this.f5826a.isEmpty() || (this.f5826a.size() == 1 && this.f5826a.get(0).d());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f5826a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f5826a.toArray()));
        }
        return sb.toString();
    }
}
