package com.jackpocket.scratchoff;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;

public final class d {
    public static void a(final View view, final Runnable runnable) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
                View view = view;
                if (Build.VERSION.SDK_INT < 16) {
                    view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        });
        view.requestLayout();
    }
}
