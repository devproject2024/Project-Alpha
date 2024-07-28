package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

final class b extends ViewPager2.e {

    /* renamed from: a  reason: collision with root package name */
    private final List<ViewPager2.e> f5017a = new ArrayList(3);

    b() {
    }

    /* access modifiers changed from: package-private */
    public final void a(ViewPager2.e eVar) {
        this.f5017a.add(eVar);
    }

    public final void a(int i2, float f2, int i3) {
        try {
            for (ViewPager2.e a2 : this.f5017a) {
                a2.a(i2, f2, i3);
            }
        } catch (ConcurrentModificationException e2) {
            a(e2);
        }
    }

    public final void a(int i2) {
        try {
            for (ViewPager2.e a2 : this.f5017a) {
                a2.a(i2);
            }
        } catch (ConcurrentModificationException e2) {
            a(e2);
        }
    }

    public final void b(int i2) {
        try {
            for (ViewPager2.e b2 : this.f5017a) {
                b2.b(i2);
            }
        } catch (ConcurrentModificationException e2) {
            a(e2);
        }
    }

    private static void a(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }
}
