package net.one97.paytm.landingpage.utils.croptool;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;

final class d extends Animation implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f52985a;

    /* renamed from: b  reason: collision with root package name */
    private final CropOverlayView f52986b;

    /* renamed from: c  reason: collision with root package name */
    private final float[] f52987c = new float[8];

    /* renamed from: d  reason: collision with root package name */
    private final float[] f52988d = new float[8];

    /* renamed from: e  reason: collision with root package name */
    private final RectF f52989e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    private final RectF f52990f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private final float[] f52991g = new float[9];

    /* renamed from: h  reason: collision with root package name */
    private final float[] f52992h = new float[9];

    /* renamed from: i  reason: collision with root package name */
    private final RectF f52993i = new RectF();
    private final float[] j = new float[8];
    private final float[] k = new float[9];

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    public d(ImageView imageView, CropOverlayView cropOverlayView) {
        this.f52985a = imageView;
        this.f52986b = cropOverlayView;
        setDuration(300);
        setFillAfter(true);
        setInterpolator(new AccelerateDecelerateInterpolator());
        setAnimationListener(this);
    }

    public final void a(float[] fArr, Matrix matrix) {
        reset();
        System.arraycopy(fArr, 0, this.f52987c, 0, 8);
        this.f52989e.set(this.f52986b.getCropWindowRect());
        matrix.getValues(this.f52991g);
    }

    public final void b(float[] fArr, Matrix matrix) {
        System.arraycopy(fArr, 0, this.f52988d, 0, 8);
        this.f52990f.set(this.f52986b.getCropWindowRect());
        matrix.getValues(this.f52992h);
    }

    /* access modifiers changed from: protected */
    public final void applyTransformation(float f2, Transformation transformation) {
        float[] fArr;
        this.f52993i.left = this.f52989e.left + ((this.f52990f.left - this.f52989e.left) * f2);
        this.f52993i.top = this.f52989e.top + ((this.f52990f.top - this.f52989e.top) * f2);
        this.f52993i.right = this.f52989e.right + ((this.f52990f.right - this.f52989e.right) * f2);
        this.f52993i.bottom = this.f52989e.bottom + ((this.f52990f.bottom - this.f52989e.bottom) * f2);
        this.f52986b.setCropWindowRect(this.f52993i);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            fArr = this.j;
            if (i3 >= fArr.length) {
                break;
            }
            float[] fArr2 = this.f52987c;
            fArr[i3] = fArr2[i3] + ((this.f52988d[i3] - fArr2[i3]) * f2);
            i3++;
        }
        this.f52986b.setBounds(fArr, this.f52985a.getWidth(), this.f52985a.getHeight());
        while (true) {
            float[] fArr3 = this.k;
            if (i2 < fArr3.length) {
                float[] fArr4 = this.f52991g;
                fArr3[i2] = fArr4[i2] + ((this.f52992h[i2] - fArr4[i2]) * f2);
                i2++;
            } else {
                Matrix imageMatrix = this.f52985a.getImageMatrix();
                imageMatrix.setValues(this.k);
                this.f52985a.setImageMatrix(imageMatrix);
                this.f52985a.invalidate();
                this.f52986b.invalidate();
                return;
            }
        }
    }

    public final void onAnimationEnd(Animation animation) {
        this.f52985a.clearAnimation();
    }
}
