package net.one97.paytm.common.widgets;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class h extends Animation {

    /* renamed from: a  reason: collision with root package name */
    int f49909a;

    /* renamed from: b  reason: collision with root package name */
    private final float f49910b;

    /* renamed from: c  reason: collision with root package name */
    private final float f49911c;

    /* renamed from: d  reason: collision with root package name */
    private final float f49912d;

    /* renamed from: e  reason: collision with root package name */
    private final float f49913e;

    /* renamed from: f  reason: collision with root package name */
    private Camera f49914f;

    /* renamed from: g  reason: collision with root package name */
    private final a f49915g;

    /* renamed from: h  reason: collision with root package name */
    private float f49916h = 0.75f;

    public h(float f2, float f3, float f4, float f5, a aVar) {
        this.f49910b = f2;
        this.f49911c = f3;
        this.f49912d = f4;
        this.f49913e = f5;
        this.f49915g = aVar == null ? a.SCALE_CYCLE : aVar;
        this.f49909a = 1;
    }

    public final void initialize(int i2, int i3, int i4, int i5) {
        super.initialize(i2, i3, i4, i5);
        this.f49914f = new Camera();
    }

    /* access modifiers changed from: protected */
    public final void applyTransformation(float f2, Transformation transformation) {
        float f3 = this.f49910b;
        float f4 = f3 + ((this.f49911c - f3) * f2);
        float f5 = this.f49912d;
        float f6 = this.f49913e;
        Camera camera = this.f49914f;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.f49909a == 0) {
            camera.rotateX(f4);
        } else {
            camera.rotateY(f4);
        }
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-f5, -f6);
        matrix.postTranslate(f5, f6);
        matrix.preScale(this.f49915g.getScale(this.f49916h, f2), this.f49915g.getScale(this.f49916h, f2), f5, f6);
    }

    /* renamed from: net.one97.paytm.common.widgets.h$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f49917a = new int[a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                net.one97.paytm.common.widgets.h$a[] r0 = net.one97.paytm.common.widgets.h.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f49917a = r0
                int[] r0 = f49917a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.common.widgets.h$a r1 = net.one97.paytm.common.widgets.h.a.SCALE_UP     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f49917a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.common.widgets.h$a r1 = net.one97.paytm.common.widgets.h.a.SCALE_DOWN     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f49917a     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.common.widgets.h$a r1 = net.one97.paytm.common.widgets.h.a.SCALE_CYCLE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.widgets.h.AnonymousClass1.<clinit>():void");
        }
    }

    public enum a {
        SCALE_UP,
        SCALE_DOWN,
        SCALE_CYCLE,
        SCALE_NONE;

        public final float getScale(float f2, float f3) {
            float f4;
            float f5;
            int i2 = AnonymousClass1.f49917a[ordinal()];
            boolean z = true;
            if (i2 != 1) {
                if (i2 == 2) {
                    f5 = 1.0f - f2;
                } else if (i2 != 3) {
                    return 1.0f;
                } else {
                    if (((double) f3) <= 0.5d) {
                        z = false;
                    }
                    if (z) {
                        f4 = (1.0f - f2) * (f3 - 0.5f) * 2.0f;
                    } else {
                        f5 = 1.0f - f2;
                        f3 *= 2.0f;
                    }
                }
                return 1.0f - (f5 * f3);
            }
            f4 = (1.0f - f2) * f3;
            return f2 + f4;
        }
    }
}
