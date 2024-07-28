package com.bumptech.glide;

import com.bumptech.glide.e.b.e;
import com.bumptech.glide.e.b.g;
import com.bumptech.glide.j;

public abstract class j<CHILD extends j<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    g<? super TranscodeType> f6674a = e.a();

    /* renamed from: a */
    public final CHILD clone() {
        try {
            return (j) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final CHILD a(g<? super TranscodeType> gVar) {
        this.f6674a = (g) com.bumptech.glide.g.j.a(gVar, "Argument must not be null");
        return this;
    }
}
