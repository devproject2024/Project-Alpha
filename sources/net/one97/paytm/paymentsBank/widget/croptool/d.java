package net.one97.paytm.paymentsBank.widget.croptool;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;

final class d extends Animation implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f19726a;

    /* renamed from: b  reason: collision with root package name */
    private final CropOverlayView f19727b;

    /* renamed from: c  reason: collision with root package name */
    private final float[] f19728c = new float[8];

    /* renamed from: d  reason: collision with root package name */
    private final float[] f19729d = new float[8];

    /* renamed from: e  reason: collision with root package name */
    private final RectF f19730e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    private final RectF f19731f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private final float[] f19732g = new float[9];

    /* renamed from: h  reason: collision with root package name */
    private final float[] f19733h = new float[9];

    /* renamed from: i  reason: collision with root package name */
    private final RectF f19734i = new RectF();
    private final float[] j = new float[8];
    private final float[] k = new float[9];

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    public d(ImageView imageView, CropOverlayView cropOverlayView) {
        this.f19726a = imageView;
        this.f19727b = cropOverlayView;
        setDuration(300);
        setFillAfter(true);
        setInterpolator(new AccelerateDecelerateInterpolator());
        setAnimationListener(this);
    }

    public final void a(float[] fArr, Matrix matrix) {
        reset();
        System.arraycopy(fArr, 0, this.f19728c, 0, 8);
        this.f19730e.set(this.f19727b.getCropWindowRect());
        matrix.getValues(this.f19732g);
    }

    public final void b(float[] fArr, Matrix matrix) {
        System.arraycopy(fArr, 0, this.f19729d, 0, 8);
        this.f19731f.set(this.f19727b.getCropWindowRect());
        matrix.getValues(this.f19733h);
    }

    /* access modifiers changed from: protected */
    public final void applyTransformation(float f2, Transformation transformation) {
        float[] fArr;
        this.f19734i.left = this.f19730e.left + ((this.f19731f.left - this.f19730e.left) * f2);
        this.f19734i.top = this.f19730e.top + ((this.f19731f.top - this.f19730e.top) * f2);
        this.f19734i.right = this.f19730e.right + ((this.f19731f.right - this.f19730e.right) * f2);
        this.f19734i.bottom = this.f19730e.bottom + ((this.f19731f.bottom - this.f19730e.bottom) * f2);
        this.f19727b.setCropWindowRect(this.f19734i);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            fArr = this.j;
            if (i3 >= fArr.length) {
                break;
            }
            float[] fArr2 = this.f19728c;
            fArr[i3] = fArr2[i3] + ((this.f19729d[i3] - fArr2[i3]) * f2);
            i3++;
        }
        this.f19727b.setBounds(fArr, this.f19726a.getWidth(), this.f19726a.getHeight());
        while (true) {
            float[] fArr3 = this.k;
            if (i2 < fArr3.length) {
                float[] fArr4 = this.f19732g;
                fArr3[i2] = fArr4[i2] + ((this.f19733h[i2] - fArr4[i2]) * f2);
                i2++;
            } else {
                Matrix imageMatrix = this.f19726a.getImageMatrix();
                imageMatrix.setValues(this.k);
                this.f19726a.setImageMatrix(imageMatrix);
                this.f19726a.invalidate();
                this.f19727b.invalidate();
                return;
            }
        }
    }

    public final void onAnimationEnd(Animation animation) {
        this.f19726a.clearAnimation();
    }
}
