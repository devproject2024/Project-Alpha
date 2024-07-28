package com.bumptech.glide.load.b.a;

import android.graphics.Bitmap;
import com.bumptech.glide.g.k;

final class c implements l {

    /* renamed from: a  reason: collision with root package name */
    private final b f6731a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final h<a, Bitmap> f6732b = new h<>();

    c() {
    }

    public final void a(Bitmap bitmap) {
        this.f6732b.a(this.f6731a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public final Bitmap a(int i2, int i3, Bitmap.Config config) {
        return this.f6732b.a(this.f6731a.a(i2, i3, config));
    }

    public final Bitmap a() {
        return this.f6732b.a();
    }

    public final String b(int i2, int i3, Bitmap.Config config) {
        return c(i2, i3, config);
    }

    public final int c(Bitmap bitmap) {
        return k.a(bitmap);
    }

    public final String toString() {
        return "AttributeStrategy:\n  " + this.f6732b;
    }

    static String c(int i2, int i3, Bitmap.Config config) {
        return "[" + i2 + "x" + i3 + "], " + config;
    }

    static class b extends d<a> {
        b() {
        }

        /* access modifiers changed from: package-private */
        public final a a(int i2, int i3, Bitmap.Config config) {
            a aVar = (a) b();
            aVar.a(i2, i3, config);
            return aVar;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ m a() {
            return new a(this);
        }
    }

    static class a implements m {

        /* renamed from: a  reason: collision with root package name */
        private final b f6733a;

        /* renamed from: b  reason: collision with root package name */
        private int f6734b;

        /* renamed from: c  reason: collision with root package name */
        private int f6735c;

        /* renamed from: d  reason: collision with root package name */
        private Bitmap.Config f6736d;

        public a(b bVar) {
            this.f6733a = bVar;
        }

        public final void a(int i2, int i3, Bitmap.Config config) {
            this.f6734b = i2;
            this.f6735c = i3;
            this.f6736d = config;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f6734b == aVar.f6734b && this.f6735c == aVar.f6735c && this.f6736d == aVar.f6736d) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public final int hashCode() {
            int i2 = ((this.f6734b * 31) + this.f6735c) * 31;
            Bitmap.Config config = this.f6736d;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public final String toString() {
            return c.c(this.f6734b, this.f6735c, this.f6736d);
        }

        public final void a() {
            this.f6733a.a(this);
        }
    }

    public final String b(Bitmap bitmap) {
        return c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }
}
