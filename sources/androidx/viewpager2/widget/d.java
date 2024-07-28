package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

final class d extends ViewPager2.e {

    /* renamed from: a  reason: collision with root package name */
    ViewPager2.g f5021a;

    /* renamed from: b  reason: collision with root package name */
    private final LinearLayoutManager f5022b;

    public final void a(int i2) {
    }

    public final void b(int i2) {
    }

    d(LinearLayoutManager linearLayoutManager) {
        this.f5022b = linearLayoutManager;
    }

    public final void a(int i2, float f2, int i3) {
        if (this.f5021a != null) {
            int i4 = 0;
            while (i4 < this.f5022b.getChildCount()) {
                View childAt = this.f5022b.getChildAt(i4);
                if (childAt != null) {
                    this.f5022b.getPosition(childAt);
                    i4++;
                } else {
                    throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[]{Integer.valueOf(i4), Integer.valueOf(this.f5022b.getChildCount())}));
                }
            }
        }
    }
}
