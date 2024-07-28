package com.bumptech.glide.g.a;

public abstract class b {
    public abstract void a();

    /* access modifiers changed from: package-private */
    public abstract void a(boolean z);

    /* synthetic */ b(byte b2) {
        this();
    }

    private b() {
    }

    public static class a extends b {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f6605a;

        public a() {
            super((byte) 0);
        }

        public final void a() {
            if (this.f6605a) {
                throw new IllegalStateException("Already released");
            }
        }

        public final void a(boolean z) {
            this.f6605a = z;
        }
    }
}
