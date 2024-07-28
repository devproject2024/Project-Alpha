package androidx.recyclerview.widget;

import android.os.Build;
import android.view.View;
import androidx.core.h.u;
import androidx.recyclerview.R;

public final class n implements m {

    /* renamed from: a  reason: collision with root package name */
    public static final m f4338a = new n();

    n() {
    }

    public final void a(RecyclerView recyclerView, View view, float f2, float f3, boolean z) {
        if (Build.VERSION.SDK_INT >= 21 && z && view.getTag(R.id.item_touch_helper_previous_elevation) == null) {
            Float valueOf = Float.valueOf(u.v(view));
            int childCount = recyclerView.getChildCount();
            float f4 = 0.0f;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                if (childAt != view) {
                    float v = u.v(childAt);
                    if (v > f4) {
                        f4 = v;
                    }
                }
            }
            u.g(view, 1.0f + f4);
            view.setTag(R.id.item_touch_helper_previous_elevation, valueOf);
        }
        view.setTranslationX(f2);
        view.setTranslationY(f3);
    }

    public final void a(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            Object tag = view.getTag(R.id.item_touch_helper_previous_elevation);
            if (tag instanceof Float) {
                u.g(view, ((Float) tag).floatValue());
            }
            view.setTag(R.id.item_touch_helper_previous_elevation, (Object) null);
        }
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }
}
