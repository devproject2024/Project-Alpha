package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.h.u;
import androidx.swiperefreshlayout.R;

final class a extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    Animation.AnimationListener f4591a;

    /* renamed from: b  reason: collision with root package name */
    private int f4592b;

    /* renamed from: c  reason: collision with root package name */
    private int f4593c;

    a(Context context) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (1.75f * f2);
        int i3 = (int) (0.0f * f2);
        this.f4592b = (int) (3.5f * f2);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(R.styleable.SwipeRefreshLayout);
        this.f4593c = obtainStyledAttributes.getColor(R.styleable.SwipeRefreshLayout_swipeRefreshLayoutProgressSpinnerBackgroundColor, -328966);
        obtainStyledAttributes.recycle();
        if (a()) {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new OvalShape());
            u.g((View) this, f2 * 4.0f);
            shapeDrawable = shapeDrawable2;
        } else {
            shapeDrawable = new ShapeDrawable(new C0073a(this, this.f4592b));
            setLayerType(1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float) this.f4592b, (float) i3, (float) i2, 503316480);
            int i4 = this.f4592b;
            setPadding(i4, i4, i4, i4);
        }
        shapeDrawable.getPaint().setColor(this.f4593c);
        u.a((View) this, (Drawable) shapeDrawable);
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (!a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f4592b * 2), getMeasuredHeight() + (this.f4592b * 2));
        }
    }

    public final void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f4591a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    public final void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f4591a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public final void setBackgroundColor(int i2) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i2);
            this.f4593c = i2;
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.a$a  reason: collision with other inner class name */
    static class C0073a extends OvalShape {

        /* renamed from: a  reason: collision with root package name */
        private Paint f4594a = new Paint();

        /* renamed from: b  reason: collision with root package name */
        private int f4595b;

        /* renamed from: c  reason: collision with root package name */
        private a f4596c;

        C0073a(a aVar, int i2) {
            this.f4596c = aVar;
            this.f4595b = i2;
            a((int) rect().width());
        }

        /* access modifiers changed from: protected */
        public final void onResize(float f2, float f3) {
            super.onResize(f2, f3);
            a((int) f2);
        }

        public final void draw(Canvas canvas, Paint paint) {
            int width = this.f4596c.getWidth() / 2;
            float f2 = (float) width;
            float height = (float) (this.f4596c.getHeight() / 2);
            canvas.drawCircle(f2, height, f2, this.f4594a);
            canvas.drawCircle(f2, height, (float) (width - this.f4595b), paint);
        }

        private void a(int i2) {
            float f2 = (float) (i2 / 2);
            this.f4594a.setShader(new RadialGradient(f2, f2, (float) this.f4595b, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP));
        }
    }
}
