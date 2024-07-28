package com.google.android.material.imageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R;
import com.google.android.material.h.c;
import com.google.android.material.k.m;
import com.google.android.material.k.n;
import com.google.android.material.k.p;

public class ShapeableImageView extends AppCompatImageView implements p {

    /* renamed from: a  reason: collision with root package name */
    private static final int f36389a = R.style.Widget_MaterialComponents_ShapeableImageView;

    /* renamed from: b  reason: collision with root package name */
    private final n f36390b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final RectF f36391c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f36392d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f36393e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f36394f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f36395g;

    /* renamed from: h  reason: collision with root package name */
    private ColorStateList f36396h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public m f36397i;
    private float j;
    private Path k;

    public ShapeableImageView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public ShapeableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShapeableImageView(Context context, AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i2, f36389a), attributeSet, i2);
        this.f36390b = new n();
        this.f36395g = new Path();
        Context context2 = getContext();
        this.f36394f = new Paint();
        this.f36394f.setAntiAlias(true);
        this.f36394f.setColor(-1);
        this.f36394f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f36391c = new RectF();
        this.f36392d = new RectF();
        this.k = new Path();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.ShapeableImageView, i2, f36389a);
        this.f36396h = c.a(context2, obtainStyledAttributes, R.styleable.ShapeableImageView_strokeColor);
        this.j = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_strokeWidth, 0);
        this.f36393e = new Paint();
        this.f36393e.setStyle(Paint.Style.STROKE);
        this.f36393e.setAntiAlias(true);
        this.f36397i = m.a(context2, attributeSet, i2, f36389a).a();
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new a());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        setLayerType(0, (Paint) null);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, (Paint) null);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.k, this.f36394f);
        if (this.f36396h != null) {
            this.f36393e.setStrokeWidth(this.j);
            int colorForState = this.f36396h.getColorForState(getDrawableState(), this.f36396h.getDefaultColor());
            if (this.j > 0.0f && colorForState != 0) {
                this.f36393e.setColor(colorForState);
                canvas.drawPath(this.f36395g, this.f36393e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a(i2, i3);
    }

    public void setShapeAppearanceModel(m mVar) {
        this.f36397i = mVar;
        a(getWidth(), getHeight());
        invalidate();
    }

    public m getShapeAppearanceModel() {
        return this.f36397i;
    }

    private void a(int i2, int i3) {
        this.f36391c.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (i2 - getPaddingRight()), (float) (i3 - getPaddingBottom()));
        this.f36390b.a(this.f36397i, 1.0f, this.f36391c, this.f36395g);
        this.k.rewind();
        this.k.addPath(this.f36395g);
        this.f36392d.set(0.0f, 0.0f, (float) i2, (float) i3);
        this.k.addRect(this.f36392d, Path.Direction.CCW);
    }

    public void setStrokeColorResource(int i2) {
        setStrokeColor(androidx.appcompat.a.a.a.a(getContext(), i2));
    }

    public ColorStateList getStrokeColor() {
        return this.f36396h;
    }

    public void setStrokeWidth(float f2) {
        if (this.j != f2) {
            this.j = f2;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i2) {
        setStrokeWidth((float) getResources().getDimensionPixelSize(i2));
    }

    public float getStrokeWidth() {
        return this.j;
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f36396h = colorStateList;
        invalidate();
    }

    class a extends ViewOutlineProvider {

        /* renamed from: b  reason: collision with root package name */
        private Rect f36399b = new Rect();

        a() {
        }

        public final void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.f36397i != null && ShapeableImageView.this.f36397i.a(ShapeableImageView.this.f36391c)) {
                ShapeableImageView.this.f36391c.round(this.f36399b);
                outline.setRoundRect(this.f36399b, ShapeableImageView.this.f36397i.f36557i.a(ShapeableImageView.this.f36391c));
            }
        }
    }
}
