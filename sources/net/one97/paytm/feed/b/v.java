package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.a;

public final class v extends u {
    private static final ViewDataBinding.b l = null;
    private static final SparseIntArray m;
    private final ConstraintLayout n;
    private long o;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        m = sparseIntArray;
        sparseIntArray.put(R.id.tvTitle, 2);
        m.put(R.id.feed_swipe_refresh_layout, 3);
        m.put(R.id.recyclerview, 4);
        m.put(R.id.feedNoData, 5);
        m.put(R.id.feed_login_image, 6);
        m.put(R.id.feed_login_text, 7);
        m.put(R.id.feed_login, 8);
        m.put(R.id.feed_error, 9);
    }

    public v(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 10, l, m));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private v(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[9], objArr[1], objArr[8], objArr[6], objArr[7], objArr[5], objArr[3], objArr[4], objArr[2]);
        this.o = -1;
        this.f34225b.setTag((Object) null);
        this.n = objArr[0];
        this.n.setTag((Object) null);
        View view2 = view;
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.o = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.o != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.u == i2) {
            a((Integer) obj);
        } else if (a.z != i2) {
            return false;
        } else {
            this.j = (net.one97.paytm.feed.ui.feed.e) obj;
        }
        return true;
    }

    public final void a(Integer num) {
        this.k = num;
        synchronized (this) {
            this.o |= 1;
        }
        notifyPropertyChanged(a.u);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.o;
            this.o = 0;
        }
        Integer num = this.k;
        int i2 = 0;
        int i3 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i3 != 0) {
            i2 = ViewDataBinding.safeUnbox(num);
        }
        if (i3 != 0) {
            this.f34225b.setVisibility(i2);
        }
    }
}
