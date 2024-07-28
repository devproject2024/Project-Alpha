package com.google.android.material.transformation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.u;
import com.google.android.material.R;
import com.google.android.material.a.h;
import com.google.android.material.a.j;
import com.google.android.material.transformation.FabTransformationBehavior;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* renamed from: a  reason: collision with root package name */
    private Map<View, Integer> f36890a;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public final FabTransformationBehavior.a a(Context context, boolean z) {
        int i2;
        if (z) {
            i2 = R.animator.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            i2 = R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        }
        FabTransformationBehavior.a aVar = new FabTransformationBehavior.a();
        aVar.f36883a = h.a(context, i2);
        aVar.f36884b = new j();
        return aVar;
    }

    /* access modifiers changed from: protected */
    public final boolean a(View view, View view2, boolean z, boolean z2) {
        ViewParent parent = view2.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                this.f36890a = new HashMap(childCount);
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                boolean z3 = (childAt.getLayoutParams() instanceof CoordinatorLayout.d) && (((CoordinatorLayout.d) childAt.getLayoutParams()).f2603a instanceof FabTransformationScrimBehavior);
                if (childAt != view2 && !z3) {
                    if (!z) {
                        Map<View, Integer> map = this.f36890a;
                        if (map != null && map.containsKey(childAt)) {
                            u.c(childAt, this.f36890a.get(childAt).intValue());
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.f36890a.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        u.c(childAt, 4);
                    }
                }
            }
            if (!z) {
                this.f36890a = null;
            }
        }
        return super.a(view, view2, z, z2);
    }
}
