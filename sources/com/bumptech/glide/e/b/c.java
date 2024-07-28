package com.bumptech.glide.e.b;

import android.graphics.drawable.Drawable;

public final class c implements g<Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f6543a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f6544b;

    /* renamed from: c  reason: collision with root package name */
    private d f6545c;

    protected c(int i2, boolean z) {
        this.f6543a = i2;
        this.f6544b = z;
    }

    public final f<Drawable> a(com.bumptech.glide.load.a aVar, boolean z) {
        if (aVar == com.bumptech.glide.load.a.MEMORY_CACHE) {
            return e.b();
        }
        if (this.f6545c == null) {
            this.f6545c = new d(this.f6543a, this.f6544b);
        }
        return this.f6545c;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f6546a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f6547b;

        public a() {
            this(300);
        }

        public a(int i2) {
            this.f6546a = i2;
        }

        public final c a() {
            return new c(this.f6546a, this.f6547b);
        }
    }
}
