package com.paytm.android.chat.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.paytm.android.chat.R;

public class RoundCornerImageView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private Paint f42519a;

    /* renamed from: b  reason: collision with root package name */
    private float[] f42520b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f42521c;

    /* renamed from: d  reason: collision with root package name */
    private Path f42522d;

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f42523e;

    /* renamed from: f  reason: collision with root package name */
    private Shader f42524f;

    /* renamed from: g  reason: collision with root package name */
    private Matrix f42525g;

    /* renamed from: h  reason: collision with root package name */
    private float f42526h;

    public RoundCornerImageView(Context context) {
        this(context, (AttributeSet) null);
        a(context, (AttributeSet) null);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        a(context, attributeSet);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f42520b = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.f42526h = 1.0f;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, (Paint) null);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundCornerImageView);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundCornerImageView_radius, 0);
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundCornerImageView_left_top_radius, 0);
        int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundCornerImageView_right_top_radius, 0);
        int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundCornerImageView_right_bottom_radius, 0);
        int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundCornerImageView_left_bottom_radius, 0);
        if (dimensionPixelOffset2 == 0) {
            dimensionPixelOffset2 = dimensionPixelOffset;
        }
        if (dimensionPixelOffset3 == 0) {
            dimensionPixelOffset3 = dimensionPixelOffset;
        }
        if (dimensionPixelOffset4 == 0) {
            dimensionPixelOffset4 = dimensionPixelOffset;
        }
        if (dimensionPixelOffset5 != 0) {
            dimensionPixelOffset = dimensionPixelOffset5;
        }
        obtainStyledAttributes.recycle();
        float[] fArr = this.f42520b;
        float f2 = (float) dimensionPixelOffset2;
        fArr[1] = f2;
        fArr[0] = f2;
        float f3 = (float) dimensionPixelOffset3;
        fArr[3] = f3;
        fArr[2] = f3;
        float f4 = (float) dimensionPixelOffset4;
        fArr[5] = f4;
        fArr[4] = f4;
        float f5 = (float) dimensionPixelOffset;
        fArr[7] = f5;
        fArr[6] = f5;
        this.f42519a = new Paint(1);
        this.f42522d = new Path();
        this.f42525g = new Matrix();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        if (getDrawable() != null) {
            if (this.f42521c == null) {
                this.f42521c = new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            }
            if (this.f42523e == null) {
                Drawable drawable = getDrawable();
                if (drawable instanceof BitmapDrawable) {
                    bitmap = ((BitmapDrawable) drawable).getBitmap();
                } else {
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = drawable.getIntrinsicHeight();
                    int i2 = 1;
                    int i3 = intrinsicWidth <= 0 ? 1 : intrinsicWidth;
                    if (intrinsicHeight > 0) {
                        i2 = intrinsicHeight;
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(i3, i2, Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                    drawable.draw(canvas2);
                    bitmap = createBitmap;
                }
                this.f42523e = bitmap;
            }
            this.f42526h = Math.max((((float) getMeasuredWidth()) * 1.0f) / ((float) this.f42523e.getWidth()), (((float) getMeasuredHeight()) * 1.0f) / ((float) this.f42523e.getHeight()));
            Matrix matrix = this.f42525g;
            float f2 = this.f42526h;
            matrix.setScale(f2, f2);
            if (this.f42524f == null) {
                Bitmap bitmap2 = this.f42523e;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.f42524f = new BitmapShader(bitmap2, tileMode, tileMode);
            }
            this.f42524f.setLocalMatrix(this.f42525g);
            this.f42519a.setShader(this.f42524f);
            this.f42522d.addRoundRect(this.f42521c, this.f42520b, Path.Direction.CW);
            canvas.drawPath(this.f42522d, this.f42519a);
        }
    }
}
