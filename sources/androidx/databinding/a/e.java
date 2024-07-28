package androidx.databinding.a;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

public final class e {
    public static int a(float f2) {
        int i2 = (int) (0.5f + f2);
        if (i2 != 0) {
            return i2;
        }
        int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i3 == 0) {
            return 0;
        }
        return i3 > 0 ? 1 : -1;
    }

    public static void a(View view, float f2) {
        view.setPadding(view.getPaddingLeft(), a(f2), view.getPaddingRight(), view.getPaddingBottom());
    }

    public static void a(View view, View.OnClickListener onClickListener, boolean z) {
        view.setOnClickListener(onClickListener);
        view.setClickable(z);
    }

    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }
}
