package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;

public class Constraints extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    c f2501a;

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    public Constraints(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        super.setVisibility(8);
    }

    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public float aA;
        public float aB;
        public float ap;
        public boolean aq;
        public float ar;
        public float as;
        public float at;
        public float au;
        public float av;
        public float aw;
        public float ax;
        public float ay;
        public float az;

        public LayoutParams(int i2) {
            super(i2, -2);
            this.ap = 1.0f;
            this.aq = false;
            this.ar = 0.0f;
            this.as = 0.0f;
            this.at = 0.0f;
            this.au = 0.0f;
            this.av = 1.0f;
            this.aw = 1.0f;
            this.ax = 0.0f;
            this.ay = 0.0f;
            this.az = 0.0f;
            this.aA = 0.0f;
            this.aB = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.ap = 1.0f;
            this.aq = false;
            this.ar = 0.0f;
            this.as = 0.0f;
            this.at = 0.0f;
            this.au = 0.0f;
            this.av = 1.0f;
            this.aw = 1.0f;
            this.ax = 0.0f;
            this.ay = 0.0f;
            this.az = 0.0f;
            this.aA = 0.0f;
            this.aB = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintSet_android_alpha) {
                    this.ap = obtainStyledAttributes.getFloat(index, this.ap);
                } else if (index == R.styleable.ConstraintSet_android_elevation) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.ar = obtainStyledAttributes.getFloat(index, this.ar);
                        this.aq = true;
                    }
                } else if (index == R.styleable.ConstraintSet_android_rotationX) {
                    this.at = obtainStyledAttributes.getFloat(index, this.at);
                } else if (index == R.styleable.ConstraintSet_android_rotationY) {
                    this.au = obtainStyledAttributes.getFloat(index, this.au);
                } else if (index == R.styleable.ConstraintSet_android_rotation) {
                    this.as = obtainStyledAttributes.getFloat(index, this.as);
                } else if (index == R.styleable.ConstraintSet_android_scaleX) {
                    this.av = obtainStyledAttributes.getFloat(index, this.av);
                } else if (index == R.styleable.ConstraintSet_android_scaleY) {
                    this.aw = obtainStyledAttributes.getFloat(index, this.aw);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotX) {
                    this.ax = obtainStyledAttributes.getFloat(index, this.ax);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotY) {
                    this.ay = obtainStyledAttributes.getFloat(index, this.ay);
                } else if (index == R.styleable.ConstraintSet_android_translationX) {
                    this.az = obtainStyledAttributes.getFloat(index, this.az);
                } else if (index == R.styleable.ConstraintSet_android_translationY) {
                    this.aA = obtainStyledAttributes.getFloat(index, this.aA);
                } else if (index == R.styleable.ConstraintSet_android_translationZ && Build.VERSION.SDK_INT >= 21) {
                    this.aB = obtainStyledAttributes.getFloat(index, this.aB);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    public c getConstraintSet() {
        if (this.f2501a == null) {
            this.f2501a = new c();
        }
        c cVar = this.f2501a;
        int childCount = getChildCount();
        cVar.f2536c.clear();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!cVar.f2535b || id != -1) {
                if (!cVar.f2536c.containsKey(Integer.valueOf(id))) {
                    cVar.f2536c.put(Integer.valueOf(id), new c.a());
                }
                c.a aVar = cVar.f2536c.get(Integer.valueOf(id));
                if (childAt instanceof ConstraintHelper) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) childAt;
                    aVar.a(id, layoutParams);
                    if (constraintHelper instanceof Barrier) {
                        aVar.f2541d.ad = 1;
                        Barrier barrier = (Barrier) constraintHelper;
                        aVar.f2541d.ab = barrier.getType();
                        aVar.f2541d.ae = barrier.getReferencedIds();
                        aVar.f2541d.ac = barrier.getMargin();
                    }
                }
                aVar.a(id, layoutParams);
                i2++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
        return this.f2501a;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2);
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
