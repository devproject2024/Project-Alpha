package com.paytm.erroranalytics.c.a;

public final class b<T> extends a {

    /* renamed from: a  reason: collision with root package name */
    public final String f42741a;

    /* renamed from: b  reason: collision with root package name */
    public final String f42742b;

    /* renamed from: c  reason: collision with root package name */
    public final String f42743c;

    /* renamed from: d  reason: collision with root package name */
    public final T f42744d;

    /* renamed from: e  reason: collision with root package name */
    public final int f42745e;

    /* renamed from: f  reason: collision with root package name */
    public final long f42746f;

    /* renamed from: g  reason: collision with root package name */
    public final long f42747g;

    /* renamed from: h  reason: collision with root package name */
    public final String f42748h;

    /* synthetic */ b(a aVar, byte b2) {
        this(aVar);
    }

    private b(a<T> aVar) {
        this.f42741a = aVar.f42749a;
        this.f42742b = aVar.f42750b;
        this.f42743c = aVar.f42751c;
        this.f42744d = aVar.f42752d;
        this.f42745e = aVar.f42753e;
        this.f42746f = aVar.f42754f;
        this.f42747g = aVar.f42755g;
        this.f42748h = aVar.f42756h;
    }

    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        String f42749a;

        /* renamed from: b  reason: collision with root package name */
        String f42750b;

        /* renamed from: c  reason: collision with root package name */
        String f42751c;

        /* renamed from: d  reason: collision with root package name */
        public T f42752d;

        /* renamed from: e  reason: collision with root package name */
        int f42753e = 1;

        /* renamed from: f  reason: collision with root package name */
        long f42754f;

        /* renamed from: g  reason: collision with root package name */
        long f42755g = System.currentTimeMillis();

        /* renamed from: h  reason: collision with root package name */
        String f42756h;

        public a(String str) {
            this.f42749a = str;
        }

        public final b a() {
            return new b(this, (byte) 0);
        }
    }
}
