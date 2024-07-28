package com.google.android.material.k;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private final o[] f36567a = new o[4];

    /* renamed from: b  reason: collision with root package name */
    private final Matrix[] f36568b = new Matrix[4];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix[] f36569c = new Matrix[4];

    /* renamed from: d  reason: collision with root package name */
    private final PointF f36570d = new PointF();

    /* renamed from: e  reason: collision with root package name */
    private final Path f36571e = new Path();

    /* renamed from: f  reason: collision with root package name */
    private final Path f36572f = new Path();

    /* renamed from: g  reason: collision with root package name */
    private final o f36573g = new o();

    /* renamed from: h  reason: collision with root package name */
    private final float[] f36574h = new float[2];

    /* renamed from: i  reason: collision with root package name */
    private final float[] f36575i = new float[2];
    private boolean j = true;

    public interface a {
        void a(o oVar, Matrix matrix, int i2);

        void b(o oVar, Matrix matrix, int i2);
    }

    public n() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.f36567a[i2] = new o();
            this.f36568b[i2] = new Matrix();
            this.f36569c[i2] = new Matrix();
        }
    }

    public final void a(m mVar, float f2, RectF rectF, Path path) {
        a(mVar, f2, rectF, (a) null, path);
    }

    public final void a(m mVar, float f2, RectF rectF, a aVar, Path path) {
        path.rewind();
        this.f36571e.rewind();
        this.f36572f.rewind();
        this.f36572f.addRect(rectF, Path.Direction.CW);
        b bVar = new b(mVar, f2, rectF, aVar, path);
        for (int i2 = 0; i2 < 4; i2++) {
            a(bVar, i2);
            a(i2);
        }
        for (int i3 = 0; i3 < 4; i3++) {
            b(bVar, i3);
            c(bVar, i3);
        }
        path.close();
        this.f36571e.close();
        if (Build.VERSION.SDK_INT >= 19 && !this.f36571e.isEmpty()) {
            path.op(this.f36571e, Path.Op.UNION);
        }
    }

    private void a(b bVar, int i2) {
        a(i2, bVar.f36576a).a(this.f36567a[i2], bVar.f36580e, bVar.f36578c, b(i2, bVar.f36576a));
        this.f36568b[i2].reset();
        a(i2, bVar.f36578c, this.f36570d);
        this.f36568b[i2].setTranslate(this.f36570d.x, this.f36570d.y);
        this.f36568b[i2].preRotate((float) ((i2 + 1) * 90));
    }

    private void a(int i2) {
        this.f36574h[0] = this.f36567a[i2].f36583c;
        this.f36574h[1] = this.f36567a[i2].f36584d;
        this.f36568b[i2].mapPoints(this.f36574h);
        this.f36569c[i2].reset();
        Matrix matrix = this.f36569c[i2];
        float[] fArr = this.f36574h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f36569c[i2].preRotate((float) ((i2 + 1) * 90));
    }

    private void b(b bVar, int i2) {
        this.f36574h[0] = this.f36567a[i2].f36581a;
        this.f36574h[1] = this.f36567a[i2].f36582b;
        this.f36568b[i2].mapPoints(this.f36574h);
        if (i2 == 0) {
            Path path = bVar.f36577b;
            float[] fArr = this.f36574h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = bVar.f36577b;
            float[] fArr2 = this.f36574h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f36567a[i2].a(this.f36568b[i2], bVar.f36577b);
        if (bVar.f36579d != null) {
            bVar.f36579d.a(this.f36567a[i2], this.f36568b[i2], i2);
        }
    }

    private void c(b bVar, int i2) {
        int i3 = (i2 + 1) % 4;
        this.f36574h[0] = this.f36567a[i2].f36583c;
        this.f36574h[1] = this.f36567a[i2].f36584d;
        this.f36568b[i2].mapPoints(this.f36574h);
        this.f36575i[0] = this.f36567a[i3].f36581a;
        this.f36575i[1] = this.f36567a[i3].f36582b;
        this.f36568b[i3].mapPoints(this.f36575i);
        float[] fArr = this.f36574h;
        float f2 = fArr[0];
        float[] fArr2 = this.f36575i;
        float max = Math.max(((float) Math.hypot((double) (f2 - fArr2[0]), (double) (fArr[1] - fArr2[1]))) - 0.001f, 0.0f);
        float a2 = a(bVar.f36578c, i2);
        this.f36573g.a(0.0f, 0.0f);
        f c2 = c(i2, bVar.f36576a);
        c2.a(max, a2, bVar.f36580e, this.f36573g);
        Path path = new Path();
        this.f36573g.a(this.f36569c[i2], path);
        if (!this.j || Build.VERSION.SDK_INT < 19 || (!c2.a() && !a(path, i2) && !a(path, i3))) {
            this.f36573g.a(this.f36569c[i2], bVar.f36577b);
        } else {
            path.op(path, this.f36572f, Path.Op.DIFFERENCE);
            this.f36574h[0] = this.f36573g.f36581a;
            this.f36574h[1] = this.f36573g.f36582b;
            this.f36569c[i2].mapPoints(this.f36574h);
            Path path2 = this.f36571e;
            float[] fArr3 = this.f36574h;
            path2.moveTo(fArr3[0], fArr3[1]);
            this.f36573g.a(this.f36569c[i2], this.f36571e);
        }
        if (bVar.f36579d != null) {
            bVar.f36579d.b(this.f36573g, this.f36569c[i2], i2);
        }
    }

    private boolean a(Path path, int i2) {
        Path path2 = new Path();
        this.f36567a[i2].a(this.f36568b[i2], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (!rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f)) {
            return true;
        }
        return false;
    }

    private float a(RectF rectF, int i2) {
        this.f36574h[0] = this.f36567a[i2].f36583c;
        this.f36574h[1] = this.f36567a[i2].f36584d;
        this.f36568b[i2].mapPoints(this.f36574h);
        if (i2 == 1 || i2 == 3) {
            return Math.abs(rectF.centerX() - this.f36574h[0]);
        }
        return Math.abs(rectF.centerY() - this.f36574h[1]);
    }

    private static void a(int i2, RectF rectF, PointF pointF) {
        if (i2 == 1) {
            pointF.set(rectF.right, rectF.bottom);
        } else if (i2 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i2 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final m f36576a;

        /* renamed from: b  reason: collision with root package name */
        public final Path f36577b;

        /* renamed from: c  reason: collision with root package name */
        public final RectF f36578c;

        /* renamed from: d  reason: collision with root package name */
        public final a f36579d;

        /* renamed from: e  reason: collision with root package name */
        public final float f36580e;

        b(m mVar, float f2, RectF rectF, a aVar, Path path) {
            this.f36579d = aVar;
            this.f36576a = mVar;
            this.f36580e = f2;
            this.f36578c = rectF;
            this.f36577b = path;
        }
    }

    private static d a(int i2, m mVar) {
        if (i2 == 1) {
            return mVar.f36552d;
        }
        if (i2 == 2) {
            return mVar.f36553e;
        }
        if (i2 != 3) {
            return mVar.f36551c;
        }
        return mVar.f36550b;
    }

    private static c b(int i2, m mVar) {
        if (i2 == 1) {
            return mVar.f36556h;
        }
        if (i2 == 2) {
            return mVar.f36557i;
        }
        if (i2 != 3) {
            return mVar.f36555g;
        }
        return mVar.f36554f;
    }

    private static f c(int i2, m mVar) {
        if (i2 == 1) {
            return mVar.l;
        }
        if (i2 == 2) {
            return mVar.m;
        }
        if (i2 != 3) {
            return mVar.k;
        }
        return mVar.j;
    }
}
