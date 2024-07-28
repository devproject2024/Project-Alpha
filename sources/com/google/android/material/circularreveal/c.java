package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.circularreveal.b;

public interface c extends b.a {
    void a();

    void b();

    int getCircularRevealScrimColor();

    d getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i2);

    void setRevealInfo(d dVar);

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public float f36132a;

        /* renamed from: b  reason: collision with root package name */
        public float f36133b;

        /* renamed from: c  reason: collision with root package name */
        public float f36134c;

        /* synthetic */ d(byte b2) {
            this();
        }

        private d() {
        }

        public d(float f2, float f3, float f4) {
            this.f36132a = f2;
            this.f36133b = f3;
            this.f36134c = f4;
        }

        public d(d dVar) {
            this(dVar.f36132a, dVar.f36133b, dVar.f36134c);
        }

        public final void a(float f2, float f3, float f4) {
            this.f36132a = f2;
            this.f36133b = f3;
            this.f36134c = f4;
        }

        public final void a(d dVar) {
            a(dVar.f36132a, dVar.f36133b, dVar.f36134c);
        }

        public final boolean a() {
            return this.f36134c == Float.MAX_VALUE;
        }
    }

    public static class b extends Property<c, d> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<c, d> f36130a = new b("circularReveal");

        public final /* synthetic */ Object get(Object obj) {
            return ((c) obj).getRevealInfo();
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            ((c) obj).setRevealInfo((d) obj2);
        }

        private b(String str) {
            super(d.class, str);
        }
    }

    public static class a implements TypeEvaluator<d> {

        /* renamed from: a  reason: collision with root package name */
        public static final TypeEvaluator<d> f36128a = new a();

        /* renamed from: b  reason: collision with root package name */
        private final d f36129b = new d((byte) 0);

        public final /* synthetic */ Object evaluate(float f2, Object obj, Object obj2) {
            d dVar = (d) obj;
            d dVar2 = (d) obj2;
            this.f36129b.a(com.google.android.material.g.a.a(dVar.f36132a, dVar2.f36132a, f2), com.google.android.material.g.a.a(dVar.f36133b, dVar2.f36133b, f2), com.google.android.material.g.a.a(dVar.f36134c, dVar2.f36134c, f2));
            return this.f36129b;
        }
    }

    /* renamed from: com.google.android.material.circularreveal.c$c  reason: collision with other inner class name */
    public static class C0604c extends Property<c, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<c, Integer> f36131a = new C0604c("circularRevealScrimColor");

        public final /* synthetic */ Object get(Object obj) {
            return Integer.valueOf(((c) obj).getCircularRevealScrimColor());
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            ((c) obj).setCircularRevealScrimColor(((Integer) obj2).intValue());
        }

        private C0604c(String str) {
            super(Integer.class, str);
        }
    }
}
