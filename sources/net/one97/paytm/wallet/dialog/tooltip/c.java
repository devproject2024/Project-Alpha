package net.one97.paytm.wallet.dialog.tooltip;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

public final class c {
    public static RectF a(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF((float) iArr[0], (float) iArr[1], (float) (iArr[0] + view.getMeasuredWidth()), (float) (iArr[1] + view.getMeasuredHeight()));
    }

    public static RectF b(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return new RectF((float) iArr[0], (float) iArr[1], (float) (iArr[0] + view.getMeasuredWidth()), (float) (iArr[1] + view.getMeasuredHeight()));
    }

    public static float a() {
        return Resources.getSystem().getDisplayMetrics().density * 2.0f;
    }

    static ViewGroup.MarginLayoutParams c(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return new ViewGroup.MarginLayoutParams(view.getWidth(), view.getHeight());
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return (ViewGroup.MarginLayoutParams) layoutParams;
        }
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public static void a(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        } else {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }

    public static int a(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColor(i2);
        }
        return context.getResources().getColor(i2);
    }
}
