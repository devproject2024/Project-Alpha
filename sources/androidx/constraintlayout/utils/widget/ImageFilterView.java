package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R;

public class ImageFilterView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    ViewOutlineProvider f2443a;

    /* renamed from: b  reason: collision with root package name */
    RectF f2444b;

    /* renamed from: c  reason: collision with root package name */
    Drawable[] f2445c;

    /* renamed from: d  reason: collision with root package name */
    LayerDrawable f2446d;

    /* renamed from: e  reason: collision with root package name */
    private a f2447e = new a();

    /* renamed from: f  reason: collision with root package name */
    private boolean f2448f = true;

    /* renamed from: g  reason: collision with root package name */
    private float f2449g = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public float f2450h = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public float f2451i = Float.NaN;
    private Path j;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        float[] f2454a = new float[20];

        /* renamed from: b  reason: collision with root package name */
        ColorMatrix f2455b = new ColorMatrix();

        /* renamed from: c  reason: collision with root package name */
        ColorMatrix f2456c = new ColorMatrix();

        /* renamed from: d  reason: collision with root package name */
        float f2457d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        float f2458e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        float f2459f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        float f2460g = 1.0f;

        a() {
        }

        private void a(float f2) {
            float f3 = 1.0f - f2;
            float f4 = 0.2999f * f3;
            float f5 = 0.587f * f3;
            float f6 = f3 * 0.114f;
            float[] fArr = this.f2454a;
            fArr[0] = f4 + f2;
            fArr[1] = f5;
            fArr[2] = f6;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f4;
            fArr[6] = f5 + f2;
            fArr[7] = f6;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f4;
            fArr[11] = f5;
            fArr[12] = f6 + f2;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void b(float f2) {
            float f3;
            float f4;
            if (f2 <= 0.0f) {
                f2 = 0.01f;
            }
            float f5 = (5000.0f / f2) / 100.0f;
            if (f5 > 66.0f) {
                double d2 = (double) (f5 - 60.0f);
                f4 = ((float) Math.pow(d2, -0.13320475816726685d)) * 329.69873f;
                f3 = ((float) Math.pow(d2, 0.07551484555006027d)) * 288.12216f;
            } else {
                f3 = (((float) Math.log((double) f5)) * 99.4708f) - 161.11957f;
                f4 = 255.0f;
            }
            float log = f5 < 66.0f ? f5 > 19.0f ? (((float) Math.log((double) (f5 - 10.0f))) * 138.51773f) - 305.0448f : 0.0f : 255.0f;
            float min = Math.min(255.0f, Math.max(f4, 0.0f));
            float min2 = Math.min(255.0f, Math.max(f3, 0.0f));
            float min3 = Math.min(255.0f, Math.max(log, 0.0f));
            float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float min5 = Math.min(255.0f, Math.max((((float) Math.log(50.0d)) * 99.4708f) - 161.11957f, 0.0f));
            float min6 = min3 / Math.min(255.0f, Math.max((((float) Math.log(40.0d)) * 138.51773f) - 305.0448f, 0.0f));
            float[] fArr = this.f2454a;
            fArr[0] = min / min4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = min2 / min5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = min6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void c(float f2) {
            float[] fArr = this.f2454a;
            fArr[0] = f2;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f2;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f2;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        /* access modifiers changed from: package-private */
        public final void a(ImageView imageView) {
            boolean z;
            this.f2455b.reset();
            float f2 = this.f2458e;
            if (f2 != 1.0f) {
                a(f2);
                this.f2455b.set(this.f2454a);
                z = true;
            } else {
                z = false;
            }
            float f3 = this.f2459f;
            if (f3 != 1.0f) {
                this.f2456c.setScale(f3, f3, f3, 1.0f);
                this.f2455b.postConcat(this.f2456c);
                z = true;
            }
            float f4 = this.f2460g;
            if (f4 != 1.0f) {
                b(f4);
                this.f2456c.set(this.f2454a);
                this.f2455b.postConcat(this.f2456c);
                z = true;
            }
            float f5 = this.f2457d;
            if (f5 != 1.0f) {
                c(f5);
                this.f2456c.set(this.f2454a);
                this.f2455b.postConcat(this.f2456c);
                z = true;
            }
            if (z) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.f2455b));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public ImageFilterView(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.f2449g = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_round) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                    }
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                    }
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f2448f));
                }
            }
            obtainStyledAttributes.recycle();
            if (drawable != null) {
                this.f2445c = new Drawable[2];
                this.f2445c[0] = getDrawable();
                Drawable[] drawableArr = this.f2445c;
                drawableArr[1] = drawable;
                this.f2446d = new LayerDrawable(drawableArr);
                this.f2446d.getDrawable(1).setAlpha((int) (this.f2449g * 255.0f));
                super.setImageDrawable(this.f2446d);
            }
        }
    }

    private void setOverlay(boolean z) {
        this.f2448f = z;
    }

    public void setSaturation(float f2) {
        a aVar = this.f2447e;
        aVar.f2458e = f2;
        aVar.a((ImageView) this);
    }

    public float getSaturation() {
        return this.f2447e.f2458e;
    }

    public void setContrast(float f2) {
        a aVar = this.f2447e;
        aVar.f2459f = f2;
        aVar.a((ImageView) this);
    }

    public float getContrast() {
        return this.f2447e.f2459f;
    }

    public void setWarmth(float f2) {
        a aVar = this.f2447e;
        aVar.f2460g = f2;
        aVar.a((ImageView) this);
    }

    public float getWarmth() {
        return this.f2447e.f2460g;
    }

    public void setCrossfade(float f2) {
        this.f2449g = f2;
        if (this.f2445c != null) {
            if (!this.f2448f) {
                this.f2446d.getDrawable(0).setAlpha((int) ((1.0f - this.f2449g) * 255.0f));
            }
            this.f2446d.getDrawable(1).setAlpha((int) (this.f2449g * 255.0f));
            super.setImageDrawable(this.f2446d);
        }
    }

    public float getCrossfade() {
        return this.f2449g;
    }

    public void setBrightness(float f2) {
        a aVar = this.f2447e;
        aVar.f2457d = f2;
        aVar.a((ImageView) this);
    }

    public float getBrightness() {
        return this.f2447e.f2457d;
    }

    public void setRoundPercent(float f2) {
        boolean z = this.f2450h != f2;
        this.f2450h = f2;
        if (this.f2450h != 0.0f) {
            if (this.j == null) {
                this.j = new Path();
            }
            if (this.f2444b == null) {
                this.f2444b = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f2443a == null) {
                    this.f2443a = new ViewOutlineProvider() {
                        public final void getOutline(View view, Outline outline) {
                            int width = ImageFilterView.this.getWidth();
                            int height = ImageFilterView.this.getHeight();
                            outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * ImageFilterView.this.f2450h) / 2.0f);
                        }
                    };
                    setOutlineProvider(this.f2443a);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.f2450h) / 2.0f;
            this.f2444b.set(0.0f, 0.0f, (float) width, (float) height);
            this.j.reset();
            this.j.addRoundRect(this.f2444b, min, min, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setRound(float f2) {
        if (Float.isNaN(f2)) {
            this.f2451i = f2;
            float f3 = this.f2450h;
            this.f2450h = -1.0f;
            setRoundPercent(f3);
            return;
        }
        boolean z = this.f2451i != f2;
        this.f2451i = f2;
        if (this.f2451i != 0.0f) {
            if (this.j == null) {
                this.j = new Path();
            }
            if (this.f2444b == null) {
                this.f2444b = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f2443a == null) {
                    this.f2443a = new ViewOutlineProvider() {
                        public final void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.f2451i);
                        }
                    };
                    setOutlineProvider(this.f2443a);
                }
                setClipToOutline(true);
            }
            this.f2444b.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.j.reset();
            Path path = this.j;
            RectF rectF = this.f2444b;
            float f4 = this.f2451i;
            path.addRoundRect(rectF, f4, f4, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public float getRoundPercent() {
        return this.f2450h;
    }

    public float getRound() {
        return this.f2451i;
    }

    public void draw(Canvas canvas) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 21 || this.f2450h == 0.0f || this.j == null) {
            z = false;
        } else {
            z = true;
            canvas.save();
            canvas.clipPath(this.j);
        }
        super.draw(canvas);
        if (z) {
            canvas.restore();
        }
    }
}
