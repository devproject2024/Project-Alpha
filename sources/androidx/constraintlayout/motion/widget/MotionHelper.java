package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

public class MotionHelper extends ConstraintHelper implements MotionLayout.g {

    /* renamed from: a  reason: collision with root package name */
    boolean f2245a = false;

    /* renamed from: b  reason: collision with root package name */
    boolean f2246b = false;

    /* renamed from: c  reason: collision with root package name */
    protected View[] f2247c;

    /* renamed from: d  reason: collision with root package name */
    private float f2248d;

    public void setProgress(View view, float f2) {
    }

    public MotionHelper(Context context) {
        super(context);
    }

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    public final void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionHelper);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MotionHelper_onShow) {
                    this.f2245a = obtainStyledAttributes.getBoolean(index, this.f2245a);
                } else if (index == R.styleable.MotionHelper_onHide) {
                    this.f2246b = obtainStyledAttributes.getBoolean(index, this.f2246b);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public float getProgress() {
        return this.f2248d;
    }

    public void setProgress(float f2) {
        this.f2248d = f2;
        int i2 = 0;
        if (this.k > 0) {
            this.f2247c = c((ConstraintLayout) getParent());
            while (i2 < this.k) {
                setProgress(this.f2247c[i2], f2);
                i2++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i2 < childCount) {
            View childAt = viewGroup.getChildAt(i2);
            if (!(childAt instanceof MotionHelper)) {
                setProgress(childAt, f2);
            }
            i2++;
        }
    }
}
