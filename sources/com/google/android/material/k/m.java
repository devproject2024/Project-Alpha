package com.google.android.material.k;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final c f36549a = new k(0.5f);

    /* renamed from: b  reason: collision with root package name */
    public d f36550b;

    /* renamed from: c  reason: collision with root package name */
    public d f36551c;

    /* renamed from: d  reason: collision with root package name */
    public d f36552d;

    /* renamed from: e  reason: collision with root package name */
    public d f36553e;

    /* renamed from: f  reason: collision with root package name */
    public c f36554f;

    /* renamed from: g  reason: collision with root package name */
    public c f36555g;

    /* renamed from: h  reason: collision with root package name */
    public c f36556h;

    /* renamed from: i  reason: collision with root package name */
    public c f36557i;
    public f j;
    f k;
    f l;
    f m;

    public interface b {
        c a(c cVar);
    }

    /* synthetic */ m(a aVar, byte b2) {
        this(aVar);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        d f36558a = new l();

        /* renamed from: b  reason: collision with root package name */
        d f36559b = new l();

        /* renamed from: c  reason: collision with root package name */
        d f36560c = new l();

        /* renamed from: d  reason: collision with root package name */
        d f36561d = new l();

        /* renamed from: e  reason: collision with root package name */
        public c f36562e = new a(0.0f);

        /* renamed from: f  reason: collision with root package name */
        public c f36563f = new a(0.0f);

        /* renamed from: g  reason: collision with root package name */
        public c f36564g = new a(0.0f);

        /* renamed from: h  reason: collision with root package name */
        public c f36565h = new a(0.0f);

        /* renamed from: i  reason: collision with root package name */
        public f f36566i = new f();
        f j = new f();
        public f k = new f();
        f l = new f();

        public a() {
        }

        public a(m mVar) {
            this.f36558a = mVar.f36550b;
            this.f36559b = mVar.f36551c;
            this.f36560c = mVar.f36552d;
            this.f36561d = mVar.f36553e;
            this.f36562e = mVar.f36554f;
            this.f36563f = mVar.f36555g;
            this.f36564g = mVar.f36556h;
            this.f36565h = mVar.f36557i;
            this.f36566i = mVar.j;
            this.j = mVar.k;
            this.k = mVar.l;
            this.l = mVar.m;
        }

        public final a a(float f2) {
            return b(f2).c(f2).d(f2).e(f2);
        }

        public final a b(float f2) {
            this.f36562e = new a(f2);
            return this;
        }

        public final a c(float f2) {
            this.f36563f = new a(f2);
            return this;
        }

        public final a d(float f2) {
            this.f36564g = new a(f2);
            return this;
        }

        public final a e(float f2) {
            this.f36565h = new a(f2);
            return this;
        }

        public final a a(d dVar) {
            this.f36558a = dVar;
            float e2 = e(dVar);
            if (e2 != -1.0f) {
                b(e2);
            }
            return this;
        }

        public final a b(d dVar) {
            this.f36559b = dVar;
            float e2 = e(dVar);
            if (e2 != -1.0f) {
                c(e2);
            }
            return this;
        }

        public final a c(d dVar) {
            this.f36560c = dVar;
            float e2 = e(dVar);
            if (e2 != -1.0f) {
                d(e2);
            }
            return this;
        }

        public final a d(d dVar) {
            this.f36561d = dVar;
            float e2 = e(dVar);
            if (e2 != -1.0f) {
                e(e2);
            }
            return this;
        }

        private static float e(d dVar) {
            if (dVar instanceof l) {
                return ((l) dVar).f36548a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).f36522a;
            }
            return -1.0f;
        }

        public final m a() {
            return new m(this, (byte) 0);
        }
    }

    public static a a() {
        return new a();
    }

    public static a a(Context context, AttributeSet attributeSet, int i2, int i3, c cVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, i2, i3);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, cVar);
    }

    private static a a(Context context, int i2, int i3, c cVar) {
        if (i3 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i2);
            i2 = i3;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.ShapeAppearance);
        try {
            int i4 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);
            int i5 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, i4);
            int i6 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, i4);
            int i7 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, i4);
            int i8 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, i4);
            c a2 = a(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSize, cVar);
            c a3 = a(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopLeft, a2);
            c a4 = a(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopRight, a2);
            c a5 = a(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomRight, a2);
            c a6 = a(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomLeft, a2);
            a a7 = new a().a(i.a(i5));
            a7.f36562e = a3;
            a b2 = a7.b(i.a(i6));
            b2.f36563f = a4;
            a c2 = b2.c(i.a(i7));
            c2.f36564g = a5;
            a d2 = c2.d(i.a(i8));
            d2.f36565h = a6;
            return d2;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private static c a(TypedArray typedArray, int i2, c cVar) {
        TypedValue peekValue = typedArray.peekValue(i2);
        if (peekValue == null) {
            return cVar;
        }
        if (peekValue.type == 5) {
            return new a((float) TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return peekValue.type == 6 ? new k(peekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    private m(a aVar) {
        this.f36550b = aVar.f36558a;
        this.f36551c = aVar.f36559b;
        this.f36552d = aVar.f36560c;
        this.f36553e = aVar.f36561d;
        this.f36554f = aVar.f36562e;
        this.f36555g = aVar.f36563f;
        this.f36556h = aVar.f36564g;
        this.f36557i = aVar.f36565h;
        this.j = aVar.f36566i;
        this.k = aVar.j;
        this.l = aVar.k;
        this.m = aVar.l;
    }

    public m() {
        this.f36550b = new l();
        this.f36551c = new l();
        this.f36552d = new l();
        this.f36553e = new l();
        this.f36554f = new a(0.0f);
        this.f36555g = new a(0.0f);
        this.f36556h = new a(0.0f);
        this.f36557i = new a(0.0f);
        this.j = new f();
        this.k = new f();
        this.l = new f();
        this.m = new f();
    }

    public final a b() {
        return new a(this);
    }

    public final m a(float f2) {
        return b().a(f2).a();
    }

    public final boolean a(RectF rectF) {
        boolean z = this.m.getClass().equals(f.class) && this.k.getClass().equals(f.class) && this.j.getClass().equals(f.class) && this.l.getClass().equals(f.class);
        float a2 = this.f36554f.a(rectF);
        return z && ((this.f36555g.a(rectF) > a2 ? 1 : (this.f36555g.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f36557i.a(rectF) > a2 ? 1 : (this.f36557i.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f36556h.a(rectF) > a2 ? 1 : (this.f36556h.a(rectF) == a2 ? 0 : -1)) == 0) && ((this.f36551c instanceof l) && (this.f36550b instanceof l) && (this.f36552d instanceof l) && (this.f36553e instanceof l));
    }

    public static a a(Context context, AttributeSet attributeSet, int i2, int i3) {
        return a(context, attributeSet, i2, i3, new a(0.0f));
    }

    public static a a(Context context, int i2, int i3) {
        return a(context, i2, i3, (c) new a(0.0f));
    }
}
