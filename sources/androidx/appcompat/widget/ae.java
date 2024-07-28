package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;

public final class ae {
    public static void a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            af.a(view, charSequence);
        }
    }
}
