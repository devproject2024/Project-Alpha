package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

public class Layer extends ConstraintHelper {

    /* renamed from: a  reason: collision with root package name */
    ConstraintLayout f2185a;

    /* renamed from: b  reason: collision with root package name */
    protected float f2186b = Float.NaN;

    /* renamed from: c  reason: collision with root package name */
    protected float f2187c = Float.NaN;

    /* renamed from: d  reason: collision with root package name */
    protected float f2188d = Float.NaN;

    /* renamed from: e  reason: collision with root package name */
    protected float f2189e = Float.NaN;

    /* renamed from: f  reason: collision with root package name */
    protected float f2190f = Float.NaN;

    /* renamed from: g  reason: collision with root package name */
    protected float f2191g = Float.NaN;

    /* renamed from: h  reason: collision with root package name */
    boolean f2192h = true;

    /* renamed from: i  reason: collision with root package name */
    View[] f2193i = null;
    private float q = Float.NaN;
    private float r = Float.NaN;
    private float s = Float.NaN;
    private float t = 1.0f;
    private float u = 1.0f;
    private float v = 0.0f;
    private float w = 0.0f;
    private boolean x;
    private boolean y;

    public Layer(Context context) {
        super(context);
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Layer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public final void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        this.n = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_android_visibility) {
                    this.x = true;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_elevation) {
                    this.y = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2185a = (ConstraintLayout) getParent();
        if (this.x || this.y) {
            int visibility = getVisibility();
            float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
            for (int i2 = 0; i2 < this.k; i2++) {
                View viewById = this.f2185a.getViewById(this.j[i2]);
                if (viewById != null) {
                    if (this.x) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.y && elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public final void a(ConstraintLayout constraintLayout) {
        this.f2185a = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f || !Float.isNaN(this.s)) {
            this.s = rotation;
        }
    }

    public void setRotation(float f2) {
        this.s = f2;
        f();
    }

    public void setScaleX(float f2) {
        this.t = f2;
        f();
    }

    public void setScaleY(float f2) {
        this.u = f2;
        f();
    }

    public void setPivotX(float f2) {
        this.q = f2;
        f();
    }

    public void setPivotY(float f2) {
        this.r = f2;
        f();
    }

    public void setTranslationX(float f2) {
        this.v = f2;
        f();
    }

    public void setTranslationY(float f2) {
        this.w = f2;
        f();
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        c();
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        c();
    }

    public final void a() {
        d();
        this.f2186b = Float.NaN;
        this.f2187c = Float.NaN;
        e eVar = ((ConstraintLayout.LayoutParams) getLayoutParams()).an;
        eVar.g(0);
        eVar.h(0);
        e();
        layout(((int) this.f2190f) - getPaddingLeft(), ((int) this.f2191g) - getPaddingTop(), ((int) this.f2188d) + getPaddingRight(), ((int) this.f2189e) + getPaddingBottom());
        f();
    }

    private void d() {
        if (this.f2185a != null && this.k != 0) {
            View[] viewArr = this.f2193i;
            if (viewArr == null || viewArr.length != this.k) {
                this.f2193i = new View[this.k];
            }
            for (int i2 = 0; i2 < this.k; i2++) {
                this.f2193i[i2] = this.f2185a.getViewById(this.j[i2]);
            }
        }
    }

    private void e() {
        if (this.f2185a != null) {
            if (!this.f2192h && !Float.isNaN(this.f2186b) && !Float.isNaN(this.f2187c)) {
                return;
            }
            if (Float.isNaN(this.q) || Float.isNaN(this.r)) {
                View[] c2 = c(this.f2185a);
                int left = c2[0].getLeft();
                int top = c2[0].getTop();
                int right = c2[0].getRight();
                int bottom = c2[0].getBottom();
                for (int i2 = 0; i2 < this.k; i2++) {
                    View view = c2[i2];
                    left = Math.min(left, view.getLeft());
                    top = Math.min(top, view.getTop());
                    right = Math.max(right, view.getRight());
                    bottom = Math.max(bottom, view.getBottom());
                }
                this.f2188d = (float) right;
                this.f2189e = (float) bottom;
                this.f2190f = (float) left;
                this.f2191g = (float) top;
                if (Float.isNaN(this.q)) {
                    this.f2186b = (float) ((left + right) / 2);
                } else {
                    this.f2186b = this.q;
                }
                if (Float.isNaN(this.r)) {
                    this.f2187c = (float) ((top + bottom) / 2);
                } else {
                    this.f2187c = this.r;
                }
            } else {
                this.f2187c = this.r;
                this.f2186b = this.q;
            }
        }
    }

    private void f() {
        if (this.f2185a != null) {
            if (this.f2193i == null) {
                d();
            }
            e();
            double radians = Float.isNaN(this.s) ? 0.0d : Math.toRadians((double) this.s);
            float sin = (float) Math.sin(radians);
            float cos = (float) Math.cos(radians);
            float f2 = this.t;
            float f3 = f2 * cos;
            float f4 = this.u;
            float f5 = (-f4) * sin;
            float f6 = f2 * sin;
            float f7 = f4 * cos;
            for (int i2 = 0; i2 < this.k; i2++) {
                View view = this.f2193i[i2];
                float left = ((float) ((view.getLeft() + view.getRight()) / 2)) - this.f2186b;
                float top = ((float) ((view.getTop() + view.getBottom()) / 2)) - this.f2187c;
                view.setTranslationX((((f3 * left) + (f5 * top)) - left) + this.v);
                view.setTranslationY((((left * f6) + (f7 * top)) - top) + this.w);
                view.setScaleY(this.u);
                view.setScaleX(this.t);
                if (!Float.isNaN(this.s)) {
                    view.setRotation(this.s);
                }
            }
        }
    }
}
