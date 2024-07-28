package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.R;

public class ImageFilterButton extends AppCompatImageButton {

    /* renamed from: a  reason: collision with root package name */
    ViewOutlineProvider f2432a;

    /* renamed from: b  reason: collision with root package name */
    RectF f2433b;

    /* renamed from: c  reason: collision with root package name */
    Drawable[] f2434c;

    /* renamed from: d  reason: collision with root package name */
    LayerDrawable f2435d;

    /* renamed from: e  reason: collision with root package name */
    private ImageFilterView.a f2436e = new ImageFilterView.a();

    /* renamed from: f  reason: collision with root package name */
    private float f2437f = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public float f2438g = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public float f2439h = Float.NaN;

    /* renamed from: i  reason: collision with root package name */
    private Path f2440i;
    private boolean j = true;

    public ImageFilterButton(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.f2437f = obtainStyledAttributes.getFloat(index, 0.0f);
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
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.j));
                }
            }
            obtainStyledAttributes.recycle();
            if (drawable != null) {
                this.f2434c = new Drawable[2];
                this.f2434c[0] = getDrawable();
                Drawable[] drawableArr = this.f2434c;
                drawableArr[1] = drawable;
                this.f2435d = new LayerDrawable(drawableArr);
                this.f2435d.getDrawable(1).setAlpha((int) (this.f2437f * 255.0f));
                super.setImageDrawable(this.f2435d);
            }
        }
    }

    private void setOverlay(boolean z) {
        this.j = z;
    }

    public void setSaturation(float f2) {
        ImageFilterView.a aVar = this.f2436e;
        aVar.f2458e = f2;
        aVar.a((ImageView) this);
    }

    public float getSaturation() {
        return this.f2436e.f2458e;
    }

    public void setContrast(float f2) {
        ImageFilterView.a aVar = this.f2436e;
        aVar.f2459f = f2;
        aVar.a((ImageView) this);
    }

    public float getContrast() {
        return this.f2436e.f2459f;
    }

    public void setWarmth(float f2) {
        ImageFilterView.a aVar = this.f2436e;
        aVar.f2460g = f2;
        aVar.a((ImageView) this);
    }

    public float getWarmth() {
        return this.f2436e.f2460g;
    }

    public void setCrossfade(float f2) {
        this.f2437f = f2;
        if (this.f2434c != null) {
            if (!this.j) {
                this.f2435d.getDrawable(0).setAlpha((int) ((1.0f - this.f2437f) * 255.0f));
            }
            this.f2435d.getDrawable(1).setAlpha((int) (this.f2437f * 255.0f));
            super.setImageDrawable(this.f2435d);
        }
    }

    public float getCrossfade() {
        return this.f2437f;
    }

    public void setBrightness(float f2) {
        ImageFilterView.a aVar = this.f2436e;
        aVar.f2457d = f2;
        aVar.a((ImageView) this);
    }

    public void setRoundPercent(float f2) {
        boolean z = this.f2438g != f2;
        this.f2438g = f2;
        if (this.f2438g != 0.0f) {
            if (this.f2440i == null) {
                this.f2440i = new Path();
            }
            if (this.f2433b == null) {
                this.f2433b = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f2432a == null) {
                    this.f2432a = new ViewOutlineProvider() {
                        public final void getOutline(View view, Outline outline) {
                            int width = ImageFilterButton.this.getWidth();
                            int height = ImageFilterButton.this.getHeight();
                            outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * ImageFilterButton.this.f2438g) / 2.0f);
                        }
                    };
                    setOutlineProvider(this.f2432a);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.f2438g) / 2.0f;
            this.f2433b.set(0.0f, 0.0f, (float) width, (float) height);
            this.f2440i.reset();
            this.f2440i.addRoundRect(this.f2433b, min, min, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setRound(float f2) {
        if (Float.isNaN(f2)) {
            this.f2439h = f2;
            float f3 = this.f2438g;
            this.f2438g = -1.0f;
            setRoundPercent(f3);
            return;
        }
        boolean z = this.f2439h != f2;
        this.f2439h = f2;
        if (this.f2439h != 0.0f) {
            if (this.f2440i == null) {
                this.f2440i = new Path();
            }
            if (this.f2433b == null) {
                this.f2433b = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f2432a == null) {
                    this.f2432a = new ViewOutlineProvider() {
                        public final void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.f2439h);
                        }
                    };
                    setOutlineProvider(this.f2432a);
                }
                setClipToOutline(true);
            }
            this.f2433b.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f2440i.reset();
            Path path = this.f2440i;
            RectF rectF = this.f2433b;
            float f4 = this.f2439h;
            path.addRoundRect(rectF, f4, f4, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public float getRoundPercent() {
        return this.f2438g;
    }

    public float getRound() {
        return this.f2439h;
    }

    public void draw(Canvas canvas) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 21 || this.f2439h == 0.0f || this.f2440i == null) {
            z = false;
        } else {
            z = true;
            canvas.save();
            canvas.clipPath(this.f2440i);
        }
        super.draw(canvas);
        if (z) {
            canvas.restore();
        }
    }
}
