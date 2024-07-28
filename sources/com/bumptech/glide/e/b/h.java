package com.bumptech.glide.e.b;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.e.b.i;

public final class h<R> implements g<R> {

    /* renamed from: a  reason: collision with root package name */
    private final i.a f6552a;

    /* renamed from: b  reason: collision with root package name */
    private f<R> f6553b;

    public h(int i2) {
        this((i.a) new a(i2));
    }

    private h(i.a aVar) {
        this.f6552a = aVar;
    }

    public final f<R> a(com.bumptech.glide.load.a aVar, boolean z) {
        if (aVar == com.bumptech.glide.load.a.MEMORY_CACHE || !z) {
            return e.b();
        }
        if (this.f6553b == null) {
            this.f6553b = new i(this.f6552a);
        }
        return this.f6553b;
    }

    static class a implements i.a {

        /* renamed from: a  reason: collision with root package name */
        private final int f6554a;

        a(int i2) {
            this.f6554a = i2;
        }

        public final Animation a(Context context) {
            return AnimationUtils.loadAnimation(context, this.f6554a);
        }
    }
}
