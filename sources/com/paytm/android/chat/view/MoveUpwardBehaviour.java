package com.paytm.android.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.u;
import com.google.android.material.snackbar.Snackbar;

public class MoveUpwardBehaviour extends CoordinatorLayout.Behavior<View> {
    public MoveUpwardBehaviour() {
    }

    public MoveUpwardBehaviour(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof Snackbar.SnackbarLayout;
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        float min = Math.min(0.0f, u.p(view2) - ((float) view2.getHeight()));
        u.s(view).b();
        u.b(view, min);
        view.setPadding(0, -Math.round(min), 0, 0);
        return true;
    }

    public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, View view, View view2) {
        view.setPadding(0, 0, 0, 0);
        u.s(view).c(0.0f).c();
    }
}
