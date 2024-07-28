package com.google.android.material.k;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import java.util.ArrayList;
import java.util.List;

public final class o {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public float f36581a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public float f36582b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public float f36583c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public float f36584d;
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public float f36585e;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public float f36586f;

    /* renamed from: g  reason: collision with root package name */
    boolean f36587g;

    /* renamed from: h  reason: collision with root package name */
    private final List<e> f36588h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private final List<f> f36589i = new ArrayList();

    public static abstract class e {

        /* renamed from: g  reason: collision with root package name */
        protected final Matrix f36606g = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public o() {
        a(0.0f, 0.0f);
    }

    public final void a(float f2, float f3) {
        a(f2, f3, 270.0f, 0.0f);
    }

    public final void b(float f2, float f3) {
        d dVar = new d();
        dVar.f36604a = f2;
        dVar.f36605b = f3;
        this.f36588h.add(dVar);
        b bVar = new b(dVar, this.f36583c, this.f36584d);
        a(bVar, bVar.a() + 270.0f, bVar.a() + 270.0f);
        this.f36583c = f2;
        this.f36584d = f3;
    }

    public final void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        c cVar = new c(f2, f3, f4, f5);
        cVar.f36602e = f6;
        cVar.f36603f = f7;
        this.f36588h.add(cVar);
        a aVar = new a(cVar);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        a(aVar, f6, z ? (180.0f + f8) % 360.0f : f8);
        double d2 = (double) f8;
        this.f36583c = ((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2))));
        this.f36584d = ((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2))));
    }

    public final void a(Matrix matrix, Path path) {
        int size = this.f36588h.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f36588h.get(i2).a(matrix, path);
        }
    }

    private void a(f fVar, float f2, float f3) {
        a(f2);
        this.f36589i.add(fVar);
        this.f36585e = f3;
    }

    static abstract class f {

        /* renamed from: d  reason: collision with root package name */
        static final Matrix f36607d = new Matrix();

        public abstract void a(Matrix matrix, com.google.android.material.j.a aVar, int i2, Canvas canvas);

        f() {
        }

        public final void a(com.google.android.material.j.a aVar, int i2, Canvas canvas) {
            a(f36607d, aVar, i2, canvas);
        }
    }

    static class b extends f {

        /* renamed from: a  reason: collision with root package name */
        private final d f36594a;

        /* renamed from: b  reason: collision with root package name */
        private final float f36595b;

        /* renamed from: c  reason: collision with root package name */
        private final float f36596c;

        public b(d dVar, float f2, float f3) {
            this.f36594a = dVar;
            this.f36595b = f2;
            this.f36596c = f3;
        }

        public final void a(Matrix matrix, com.google.android.material.j.a aVar, int i2, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot((double) (this.f36594a.f36605b - this.f36596c), (double) (this.f36594a.f36604a - this.f36595b)), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f36595b, this.f36596c);
            matrix2.preRotate(a());
            rectF.bottom += (float) i2;
            rectF.offset(0.0f, (float) (-i2));
            com.google.android.material.j.a.f36510g[0] = aVar.f36518f;
            com.google.android.material.j.a.f36510g[1] = aVar.f36517e;
            com.google.android.material.j.a.f36510g[2] = aVar.f36516d;
            aVar.f36515c.setShader(new LinearGradient(rectF.left, rectF.top, rectF.left, rectF.bottom, com.google.android.material.j.a.f36510g, com.google.android.material.j.a.f36511h, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix2);
            canvas.drawRect(rectF, aVar.f36515c);
            canvas.restore();
        }

        /* access modifiers changed from: package-private */
        public final float a() {
            return (float) Math.toDegrees(Math.atan((double) ((this.f36594a.f36605b - this.f36596c) / (this.f36594a.f36604a - this.f36595b))));
        }
    }

    static class a extends f {

        /* renamed from: a  reason: collision with root package name */
        private final c f36593a;

        public a(c cVar) {
            this.f36593a = cVar;
        }

        public final void a(Matrix matrix, com.google.android.material.j.a aVar, int i2, Canvas canvas) {
            com.google.android.material.j.a aVar2 = aVar;
            int i3 = i2;
            Canvas canvas2 = canvas;
            float a2 = this.f36593a.f36602e;
            float b2 = this.f36593a.f36603f;
            RectF rectF = new RectF(this.f36593a.f36598a, this.f36593a.f36599b, this.f36593a.f36600c, this.f36593a.f36601d);
            boolean z = b2 < 0.0f;
            Path path = aVar2.k;
            if (z) {
                com.google.android.material.j.a.f36512i[0] = 0;
                com.google.android.material.j.a.f36512i[1] = aVar2.f36518f;
                com.google.android.material.j.a.f36512i[2] = aVar2.f36517e;
                com.google.android.material.j.a.f36512i[3] = aVar2.f36516d;
            } else {
                path.rewind();
                path.moveTo(rectF.centerX(), rectF.centerY());
                path.arcTo(rectF, a2, b2);
                path.close();
                float f2 = (float) (-i3);
                rectF.inset(f2, f2);
                com.google.android.material.j.a.f36512i[0] = 0;
                com.google.android.material.j.a.f36512i[1] = aVar2.f36516d;
                com.google.android.material.j.a.f36512i[2] = aVar2.f36517e;
                com.google.android.material.j.a.f36512i[3] = aVar2.f36518f;
            }
            float width = rectF.width() / 2.0f;
            if (width > 0.0f) {
                float f3 = 1.0f - (((float) i3) / width);
                com.google.android.material.j.a.j[1] = f3;
                com.google.android.material.j.a.j[2] = ((1.0f - f3) / 2.0f) + f3;
                aVar2.f36514b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, com.google.android.material.j.a.f36512i, com.google.android.material.j.a.j, Shader.TileMode.CLAMP));
                canvas.save();
                canvas2.concat(matrix);
                if (!z) {
                    canvas2.clipPath(path, Region.Op.DIFFERENCE);
                    canvas2.drawPath(path, aVar2.l);
                }
                canvas.drawArc(rectF, a2, b2, true, aVar2.f36514b);
                canvas.restore();
            }
        }
    }

    public static class d extends e {

        /* renamed from: a  reason: collision with root package name */
        float f36604a;

        /* renamed from: b  reason: collision with root package name */
        float f36605b;

        public final void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f36606g;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f36604a, this.f36605b);
            path.transform(matrix);
        }
    }

    public static class c extends e {

        /* renamed from: h  reason: collision with root package name */
        private static final RectF f36597h = new RectF();
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public float f36598a;
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public float f36599b;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        public float f36600c;
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        public float f36601d;
        @Deprecated

        /* renamed from: e  reason: collision with root package name */
        public float f36602e;
        @Deprecated

        /* renamed from: f  reason: collision with root package name */
        public float f36603f;

        public c(float f2, float f3, float f4, float f5) {
            this.f36598a = f2;
            this.f36599b = f3;
            this.f36600c = f4;
            this.f36601d = f5;
        }

        public final void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f36606g;
            matrix.invert(matrix2);
            path.transform(matrix2);
            f36597h.set(this.f36598a, this.f36599b, this.f36600c, this.f36601d);
            path.arcTo(f36597h, this.f36602e, this.f36603f, false);
            path.transform(matrix);
        }
    }

    public final void a(float f2, float f3, float f4, float f5) {
        this.f36581a = f2;
        this.f36582b = f3;
        this.f36583c = f2;
        this.f36584d = f3;
        this.f36585e = f4;
        this.f36586f = (f4 + f5) % 360.0f;
        this.f36588h.clear();
        this.f36589i.clear();
        this.f36587g = false;
    }

    /* access modifiers changed from: package-private */
    public final f a(final Matrix matrix) {
        a(this.f36586f);
        final ArrayList arrayList = new ArrayList(this.f36589i);
        return new f() {
            public final void a(Matrix matrix, com.google.android.material.j.a aVar, int i2, Canvas canvas) {
                for (f a2 : arrayList) {
                    a2.a(matrix, aVar, i2, canvas);
                }
            }
        };
    }

    private void a(float f2) {
        float f3 = this.f36585e;
        if (f3 != f2) {
            float f4 = ((f2 - f3) + 360.0f) % 360.0f;
            if (f4 <= 180.0f) {
                float f5 = this.f36583c;
                float f6 = this.f36584d;
                c cVar = new c(f5, f6, f5, f6);
                cVar.f36602e = this.f36585e;
                cVar.f36603f = f4;
                this.f36589i.add(new a(cVar));
                this.f36585e = f2;
            }
        }
    }
}
