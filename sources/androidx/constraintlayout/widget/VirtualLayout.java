package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.a.a.l;

public abstract class VirtualLayout extends ConstraintHelper {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2505a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2506b;

    public void a(l lVar, int i2, int i3) {
    }

    public VirtualLayout(Context context) {
        super(context);
    }

    public VirtualLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VirtualLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_android_visibility) {
                    this.f2505a = true;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_elevation) {
                    this.f2506b = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void onAttachedToWindow() {
        ViewParent parent;
        super.onAttachedToWindow();
        if ((this.f2505a || this.f2506b) && (parent = getParent()) != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
            for (int i2 = 0; i2 < this.k; i2++) {
                View viewById = constraintLayout.getViewById(this.j[i2]);
                if (viewById != null) {
                    if (this.f2505a) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.f2506b && elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        c();
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        c();
    }
}
