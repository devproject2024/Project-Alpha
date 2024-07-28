package com.bumptech.glide.e.a;

import com.bumptech.glide.g.k;

@Deprecated
public abstract class h<Z> extends a<Z> {

    /* renamed from: a  reason: collision with root package name */
    private final int f6519a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6520b;

    public final void b(i iVar) {
    }

    public h() {
        this((byte) 0);
    }

    private h(byte b2) {
        this.f6519a = Integer.MIN_VALUE;
        this.f6520b = Integer.MIN_VALUE;
    }

    public final void a(i iVar) {
        if (k.a(this.f6519a, this.f6520b)) {
            iVar.a(this.f6519a, this.f6520b);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f6519a + " and height: " + this.f6520b + ", either provide dimensions in the constructor or call override()");
    }
}
