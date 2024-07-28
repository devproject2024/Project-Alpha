package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.R;

public final class ab extends aa {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f33811h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f33812i;
    private final ConstraintLayout j;
    private long k;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33812i = sparseIntArray;
        sparseIntArray.put(R.id.hello, 1);
        f33812i.put(R.id.hello_user, 2);
        f33812i.put(R.id.feed_date_text, 3);
        f33812i.put(R.id.feed_max_min, 4);
        f33812i.put(R.id.ask_location_bar, 5);
        f33812i.put(R.id.curr_temp_text, 6);
        f33812i.put(R.id.feed_weather_icon, 7);
    }

    public ab(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, f33811h, f33812i));
    }

    private ab(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[5], objArr[6], objArr[3], objArr[4], objArr[7], objArr[1], objArr[2]);
        this.k = -1;
        this.j = objArr[0];
        this.j.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.k = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.k != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.k = 0;
        }
    }
}
