package com.jackpocket.scratchoff.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.jackpocket.scratchoff.c;
import java.util.List;

public final class d extends b {

    /* renamed from: a  reason: collision with root package name */
    c f40784a;

    /* renamed from: c  reason: collision with root package name */
    a f40785c;

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f40786d;

    /* renamed from: e  reason: collision with root package name */
    private Canvas f40787e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f40788f = new Paint();

    /* renamed from: g  reason: collision with root package name */
    private double f40789g = -1.0d;

    /* renamed from: h  reason: collision with root package name */
    private boolean f40790h = false;

    public interface a {
        void a(double d2);
    }

    public d(c cVar) {
        this.f40784a = cVar;
        this.f40788f.setAntiAlias(true);
        this.f40788f.setStyle(Paint.Style.STROKE);
        this.f40788f.setStrokeCap(Paint.Cap.ROUND);
        this.f40788f.setStrokeJoin(Paint.Join.ROUND);
    }

    public final void b() {
        this.f40788f.setStrokeWidth((float) (this.f40784a.f40810c * 2));
        this.f40790h = false;
        d();
        super.b();
    }

    public final void a(List<Path> list) {
        Bitmap bitmap = this.f40786d;
        if (bitmap != null) {
            synchronized (bitmap) {
                for (Path drawPath : list) {
                    this.f40787e.drawPath(drawPath, this.f40788f);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005a, code lost:
        r2 = r6.f40785c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() throws java.lang.Exception {
        /*
            r6 = this;
            r0 = 100
            java.lang.Thread.sleep(r0)
            com.jackpocket.scratchoff.c r0 = r6.f40784a
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x0028
            com.jackpocket.scratchoff.c r0 = r6.f40784a
            com.jackpocket.scratchoff.b r0 = r0.f40808a
            android.graphics.Bitmap r0 = r0.f40797c
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0)
            r6.f40786d = r0
            android.graphics.Canvas r0 = new android.graphics.Canvas
            android.graphics.Bitmap r1 = r6.f40786d
            r0.<init>(r1)
            r6.f40787e = r0
            android.graphics.Canvas r0 = r6.f40787e
            r1 = -1
            r0.drawColor(r1)
        L_0x0028:
            boolean r0 = r6.f40776b
            if (r0 == 0) goto L_0x0085
            com.jackpocket.scratchoff.c r0 = r6.f40784a
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x0085
            boolean r0 = r6.f40790h
            if (r0 != 0) goto L_0x007f
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            android.graphics.Bitmap r2 = r6.f40786d
            double r2 = a((android.graphics.Bitmap) r2)
            android.graphics.Bitmap r4 = r6.f40786d
            int r4 = r4.getWidth()
            android.graphics.Bitmap r5 = r6.f40786d
            int r5 = r5.getHeight()
            int r4 = r4 * r5
            double r4 = (double) r4
            double r2 = r2 / r4
            double r0 = java.lang.Math.min(r0, r2)
            double r2 = r6.f40789g
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0068
            com.jackpocket.scratchoff.a.d$a r2 = r6.f40785c
            if (r2 == 0) goto L_0x0068
            com.jackpocket.scratchoff.c r3 = r6.f40784a
            com.jackpocket.scratchoff.a.d$2 r4 = new com.jackpocket.scratchoff.a.d$2
            r4.<init>(r2, r0)
            r3.b(r4)
        L_0x0068:
            com.jackpocket.scratchoff.c r2 = r6.f40784a
            double r2 = r2.f40812e
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 >= 0) goto L_0x007d
            r2 = 1
            r6.f40790h = r2
            com.jackpocket.scratchoff.c r2 = r6.f40784a
            com.jackpocket.scratchoff.a.d$1 r3 = new com.jackpocket.scratchoff.a.d$1
            r3.<init>()
            r2.b(r3)
        L_0x007d:
            r6.f40789g = r0
        L_0x007f:
            r0 = 50
            java.lang.Thread.sleep(r0)
            goto L_0x0028
        L_0x0085:
            r6.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jackpocket.scratchoff.a.d.a():void");
    }

    private static double a(Bitmap bitmap) {
        int[] iArr = new int[(bitmap.getWidth() * bitmap.getHeight())];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        double d2 = 0.0d;
        for (int i2 : iArr) {
            if (i2 == -16777216) {
                d2 += 1.0d;
            }
        }
        return d2;
    }

    public final void c() {
        super.c();
        d();
    }

    private void d() {
        try {
            if (this.f40786d != null) {
                this.f40786d.recycle();
                this.f40786d = null;
                this.f40787e = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
