package net.one97.paytm.landingpage.utils.croptool;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;

final class f {

    /* renamed from: c  reason: collision with root package name */
    private static final Matrix f53003c = new Matrix();

    /* renamed from: a  reason: collision with root package name */
    final a f53004a;

    /* renamed from: b  reason: collision with root package name */
    final PointF f53005b = new PointF();

    /* renamed from: d  reason: collision with root package name */
    private final float f53006d;

    /* renamed from: e  reason: collision with root package name */
    private final float f53007e;

    /* renamed from: f  reason: collision with root package name */
    private final float f53008f;

    /* renamed from: g  reason: collision with root package name */
    private final float f53009g;

    public enum a {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        CENTER
    }

    static float a(float f2, float f3, float f4, float f5) {
        return (f4 - f2) / (f5 - f3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x006c, code lost:
        r2 = r2 - r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006d, code lost:
        r3 = r1.f53005b;
        r3.x = r0;
        r3.y = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0073, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004e, code lost:
        r0 = r2 - r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(net.one97.paytm.landingpage.utils.croptool.f.a r2, net.one97.paytm.landingpage.utils.croptool.e r3, float r4, float r5) {
        /*
            r1 = this;
            r1.<init>()
            android.graphics.PointF r0 = new android.graphics.PointF
            r0.<init>()
            r1.f53005b = r0
            r1.f53004a = r2
            float r2 = r3.b()
            r1.f53006d = r2
            float r2 = r3.c()
            r1.f53007e = r2
            float r2 = r3.d()
            r1.f53008f = r2
            float r2 = r3.e()
            r1.f53009g = r2
            android.graphics.RectF r2 = r3.a()
            int[] r3 = net.one97.paytm.landingpage.utils.croptool.f.AnonymousClass1.f53010a
            net.one97.paytm.landingpage.utils.croptool.f$a r0 = r1.f53004a
            int r0 = r0.ordinal()
            r3 = r3[r0]
            r0 = 0
            switch(r3) {
                case 1: goto L_0x0066;
                case 2: goto L_0x005f;
                case 3: goto L_0x0058;
                case 4: goto L_0x0051;
                case 5: goto L_0x004c;
                case 6: goto L_0x0049;
                case 7: goto L_0x0046;
                case 8: goto L_0x0043;
                case 9: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            r2 = 0
            goto L_0x006d
        L_0x0038:
            float r3 = r2.centerX()
            float r0 = r3 - r4
            float r2 = r2.centerY()
            goto L_0x006c
        L_0x0043:
            float r2 = r2.bottom
            goto L_0x006c
        L_0x0046:
            float r2 = r2.right
            goto L_0x004e
        L_0x0049:
            float r2 = r2.top
            goto L_0x006c
        L_0x004c:
            float r2 = r2.left
        L_0x004e:
            float r2 = r2 - r4
            r0 = r2
            goto L_0x0036
        L_0x0051:
            float r3 = r2.right
            float r0 = r3 - r4
            float r2 = r2.bottom
            goto L_0x006c
        L_0x0058:
            float r3 = r2.left
            float r0 = r3 - r4
            float r2 = r2.bottom
            goto L_0x006c
        L_0x005f:
            float r3 = r2.right
            float r0 = r3 - r4
            float r2 = r2.top
            goto L_0x006c
        L_0x0066:
            float r3 = r2.left
            float r0 = r3 - r4
            float r2 = r2.top
        L_0x006c:
            float r2 = r2 - r5
        L_0x006d:
            android.graphics.PointF r3 = r1.f53005b
            r3.x = r0
            r3.y = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.landingpage.utils.croptool.f.<init>(net.one97.paytm.landingpage.utils.croptool.f$a, net.one97.paytm.landingpage.utils.croptool.e, float, float):void");
    }

    static void a(RectF rectF, RectF rectF2, float f2) {
        if (rectF.left < rectF2.left + f2) {
            rectF.offset(rectF2.left - rectF.left, 0.0f);
        }
        if (rectF.top < rectF2.top + f2) {
            rectF.offset(0.0f, rectF2.top - rectF.top);
        }
        if (rectF.right > rectF2.right - f2) {
            rectF.offset(rectF2.right - rectF.right, 0.0f);
        }
        if (rectF.bottom > rectF2.bottom - f2) {
            rectF.offset(0.0f, rectF2.bottom - rectF.bottom);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(RectF rectF, float f2, RectF rectF2, float f3, float f4, boolean z, boolean z2) {
        if (f2 < 0.0f) {
            f2 /= 1.05f;
            this.f53005b.x -= f2 / 1.1f;
        }
        if (f2 < rectF2.left) {
            this.f53005b.x -= (f2 - rectF2.left) / 2.0f;
        }
        if (f2 - rectF2.left < f3) {
            f2 = rectF2.left;
        }
        if (rectF.right - f2 < this.f53006d) {
            f2 = rectF.right - this.f53006d;
        }
        if (rectF.right - f2 > this.f53008f) {
            f2 = rectF.right - this.f53008f;
        }
        if (f2 - rectF2.left < f3) {
            f2 = rectF2.left;
        }
        if (f4 > 0.0f) {
            float f5 = (rectF.right - f2) / f4;
            if (f5 < this.f53007e) {
                f2 = Math.max(rectF2.left, rectF.right - (this.f53007e * f4));
                f5 = (rectF.right - f2) / f4;
            }
            if (f5 > this.f53009g) {
                f2 = Math.max(rectF2.left, rectF.right - (this.f53009g * f4));
                f5 = (rectF.right - f2) / f4;
            }
            if (!z || !z2) {
                if (z && rectF.bottom - f5 < rectF2.top) {
                    f2 = Math.max(rectF2.left, rectF.right - ((rectF.bottom - rectF2.top) * f4));
                    f5 = (rectF.right - f2) / f4;
                }
                if (z2 && rectF.top + f5 > rectF2.bottom) {
                    f2 = Math.max(f2, Math.max(rectF2.left, rectF.right - ((rectF2.bottom - rectF.top) * f4)));
                }
            } else {
                f2 = Math.max(f2, Math.max(rectF2.left, rectF.right - (rectF2.height() * f4)));
            }
        }
        rectF.left = f2;
    }

    /* access modifiers changed from: package-private */
    public final void a(RectF rectF, float f2, RectF rectF2, int i2, float f3, float f4, boolean z, boolean z2) {
        float f5 = (float) i2;
        if (f2 > f5) {
            f2 = ((f2 - f5) / 1.05f) + f5;
            this.f53005b.x -= (f2 - f5) / 1.1f;
        }
        if (f2 > rectF2.right) {
            this.f53005b.x -= (f2 - rectF2.right) / 2.0f;
        }
        if (rectF2.right - f2 < f3) {
            f2 = rectF2.right;
        }
        if (f2 - rectF.left < this.f53006d) {
            f2 = rectF.left + this.f53006d;
        }
        if (f2 - rectF.left > this.f53008f) {
            f2 = rectF.left + this.f53008f;
        }
        if (rectF2.right - f2 < f3) {
            f2 = rectF2.right;
        }
        if (f4 > 0.0f) {
            float f6 = (f2 - rectF.left) / f4;
            if (f6 < this.f53007e) {
                f2 = Math.min(rectF2.right, rectF.left + (this.f53007e * f4));
                f6 = (f2 - rectF.left) / f4;
            }
            if (f6 > this.f53009g) {
                f2 = Math.min(rectF2.right, rectF.left + (this.f53009g * f4));
                f6 = (f2 - rectF.left) / f4;
            }
            if (!z || !z2) {
                if (z && rectF.bottom - f6 < rectF2.top) {
                    f2 = Math.min(rectF2.right, rectF.left + ((rectF.bottom - rectF2.top) * f4));
                    f6 = (f2 - rectF.left) / f4;
                }
                if (z2 && rectF.top + f6 > rectF2.bottom) {
                    f2 = Math.min(f2, Math.min(rectF2.right, rectF.left + ((rectF2.bottom - rectF.top) * f4)));
                }
            } else {
                f2 = Math.min(f2, Math.min(rectF2.right, rectF.left + (rectF2.height() * f4)));
            }
        }
        rectF.right = f2;
    }

    /* access modifiers changed from: package-private */
    public final void b(RectF rectF, float f2, RectF rectF2, float f3, float f4, boolean z, boolean z2) {
        if (f2 < 0.0f) {
            f2 /= 1.05f;
            this.f53005b.y -= f2 / 1.1f;
        }
        if (f2 < rectF2.top) {
            this.f53005b.y -= (f2 - rectF2.top) / 2.0f;
        }
        if (f2 - rectF2.top < f3) {
            f2 = rectF2.top;
        }
        if (rectF.bottom - f2 < this.f53007e) {
            f2 = rectF.bottom - this.f53007e;
        }
        if (rectF.bottom - f2 > this.f53009g) {
            f2 = rectF.bottom - this.f53009g;
        }
        if (f2 - rectF2.top < f3) {
            f2 = rectF2.top;
        }
        if (f4 > 0.0f) {
            float f5 = (rectF.bottom - f2) * f4;
            if (f5 < this.f53006d) {
                f2 = Math.max(rectF2.top, rectF.bottom - (this.f53006d / f4));
                f5 = (rectF.bottom - f2) * f4;
            }
            if (f5 > this.f53008f) {
                f2 = Math.max(rectF2.top, rectF.bottom - (this.f53008f / f4));
                f5 = (rectF.bottom - f2) * f4;
            }
            if (!z || !z2) {
                if (z && rectF.right - f5 < rectF2.left) {
                    f2 = Math.max(rectF2.top, rectF.bottom - ((rectF.right - rectF2.left) / f4));
                    f5 = (rectF.bottom - f2) * f4;
                }
                if (z2 && rectF.left + f5 > rectF2.right) {
                    f2 = Math.max(f2, Math.max(rectF2.top, rectF.bottom - ((rectF2.right - rectF.left) / f4)));
                }
            } else {
                f2 = Math.max(f2, Math.max(rectF2.top, rectF.bottom - (rectF2.width() / f4)));
            }
        }
        rectF.top = f2;
    }

    /* access modifiers changed from: package-private */
    public final void b(RectF rectF, float f2, RectF rectF2, int i2, float f3, float f4, boolean z, boolean z2) {
        float f5 = (float) i2;
        if (f2 > f5) {
            f2 = ((f2 - f5) / 1.05f) + f5;
            this.f53005b.y -= (f2 - f5) / 1.1f;
        }
        if (f2 > rectF2.bottom) {
            this.f53005b.y -= (f2 - rectF2.bottom) / 2.0f;
        }
        if (rectF2.bottom - f2 < f3) {
            f2 = rectF2.bottom;
        }
        if (f2 - rectF.top < this.f53007e) {
            f2 = rectF.top + this.f53007e;
        }
        if (f2 - rectF.top > this.f53009g) {
            f2 = rectF.top + this.f53009g;
        }
        if (rectF2.bottom - f2 < f3) {
            f2 = rectF2.bottom;
        }
        if (f4 > 0.0f) {
            float f6 = (f2 - rectF.top) * f4;
            if (f6 < this.f53006d) {
                f2 = Math.min(rectF2.bottom, rectF.top + (this.f53006d / f4));
                f6 = (f2 - rectF.top) * f4;
            }
            if (f6 > this.f53008f) {
                f2 = Math.min(rectF2.bottom, rectF.top + (this.f53008f / f4));
                f6 = (f2 - rectF.top) * f4;
            }
            if (!z || !z2) {
                if (z && rectF.right - f6 < rectF2.left) {
                    f2 = Math.min(rectF2.bottom, rectF.top + ((rectF.right - rectF2.left) / f4));
                    f6 = (f2 - rectF.top) * f4;
                }
                if (z2 && rectF.left + f6 > rectF2.right) {
                    f2 = Math.min(f2, Math.min(rectF2.bottom, rectF.top + ((rectF2.right - rectF.left) / f4)));
                }
            } else {
                f2 = Math.min(f2, Math.min(rectF2.bottom, rectF.top + (rectF2.width() / f4)));
            }
        }
        rectF.bottom = f2;
    }

    static void a(RectF rectF, float f2) {
        rectF.left = rectF.right - (rectF.height() * f2);
    }

    static void b(RectF rectF, float f2) {
        rectF.top = rectF.bottom - (rectF.width() / f2);
    }

    static void c(RectF rectF, float f2) {
        rectF.right = rectF.left + (rectF.height() * f2);
    }

    static void d(RectF rectF, float f2) {
        rectF.bottom = rectF.top + (rectF.width() / f2);
    }

    static void b(RectF rectF, RectF rectF2, float f2) {
        rectF.inset((rectF.width() - (rectF.height() * f2)) / 2.0f, 0.0f);
        if (rectF.left < rectF2.left) {
            rectF.offset(rectF2.left - rectF.left, 0.0f);
        }
        if (rectF.right > rectF2.right) {
            rectF.offset(rectF2.right - rectF.right, 0.0f);
        }
    }

    static void c(RectF rectF, RectF rectF2, float f2) {
        rectF.inset(0.0f, (rectF.height() - (rectF.width() / f2)) / 2.0f);
        if (rectF.top < rectF2.top) {
            rectF.offset(0.0f, rectF2.top - rectF.top);
        }
        if (rectF.bottom > rectF2.bottom) {
            rectF.offset(0.0f, rectF2.bottom - rectF.bottom);
        }
    }
}
