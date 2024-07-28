package androidx.work;

import android.os.Build;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f5072a = new a().b();

    /* renamed from: b  reason: collision with root package name */
    public m f5073b = m.NOT_REQUIRED;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5074c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5075d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5076e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5077f;

    /* renamed from: g  reason: collision with root package name */
    public long f5078g = -1;

    /* renamed from: h  reason: collision with root package name */
    public long f5079h = -1;

    /* renamed from: i  reason: collision with root package name */
    public d f5080i = new d();

    public c() {
    }

    c(a aVar) {
        this.f5074c = aVar.f5081a;
        this.f5075d = Build.VERSION.SDK_INT >= 23 && aVar.f5082b;
        this.f5073b = aVar.f5083c;
        this.f5076e = aVar.f5084d;
        this.f5077f = aVar.f5085e;
        if (Build.VERSION.SDK_INT >= 24) {
            this.f5080i = aVar.f5088h;
            this.f5078g = aVar.f5086f;
            this.f5079h = aVar.f5087g;
        }
    }

    public c(c cVar) {
        this.f5074c = cVar.f5074c;
        this.f5075d = cVar.f5075d;
        this.f5073b = cVar.f5073b;
        this.f5076e = cVar.f5076e;
        this.f5077f = cVar.f5077f;
        this.f5080i = cVar.f5080i;
    }

    public final boolean a() {
        return this.f5080i.a() > 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f5074c == cVar.f5074c && this.f5075d == cVar.f5075d && this.f5076e == cVar.f5076e && this.f5077f == cVar.f5077f && this.f5078g == cVar.f5078g && this.f5079h == cVar.f5079h && this.f5073b == cVar.f5073b) {
            return this.f5080i.equals(cVar.f5080i);
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f5078g;
        long j2 = this.f5079h;
        return (((((((((((((this.f5073b.hashCode() * 31) + (this.f5074c ? 1 : 0)) * 31) + (this.f5075d ? 1 : 0)) * 31) + (this.f5076e ? 1 : 0)) * 31) + (this.f5077f ? 1 : 0)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f5080i.hashCode();
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f5081a = false;

        /* renamed from: b  reason: collision with root package name */
        boolean f5082b = false;

        /* renamed from: c  reason: collision with root package name */
        public m f5083c = m.NOT_REQUIRED;

        /* renamed from: d  reason: collision with root package name */
        public boolean f5084d = false;

        /* renamed from: e  reason: collision with root package name */
        boolean f5085e = false;

        /* renamed from: f  reason: collision with root package name */
        long f5086f = -1;

        /* renamed from: g  reason: collision with root package name */
        long f5087g = -1;

        /* renamed from: h  reason: collision with root package name */
        d f5088h = new d();

        public final a a(m mVar) {
            this.f5083c = mVar;
            return this;
        }

        public final a a() {
            this.f5084d = true;
            return this;
        }

        public final c b() {
            return new c(this);
        }
    }
}
