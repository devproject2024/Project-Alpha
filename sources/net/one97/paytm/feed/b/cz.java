package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.R;

public final class cz extends cy {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f34120f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f34121g;

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f34122h;

    /* renamed from: i  reason: collision with root package name */
    private long f34123i;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34121g = sparseIntArray;
        sparseIntArray.put(R.id.feed_weather_temp, 1);
        f34121g.put(R.id.feed_weather_text, 2);
        f34121g.put(R.id.feed_max_min, 3);
        f34121g.put(R.id.feed_date_text, 4);
        f34121g.put(R.id.feed_weather_icon, 5);
    }

    public cz(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, f34120f, f34121g));
    }

    private cz(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[4], objArr[3], objArr[5], objArr[1], objArr[2]);
        this.f34123i = -1;
        this.f34122h = objArr[0];
        this.f34122h.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f34123i = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f34123i != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f34123i = 0;
        }
    }
}
