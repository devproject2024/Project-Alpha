package net.one97.paytm.recharge.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.recharge.R;

public final class b extends a {
    private static final ViewDataBinding.b k = null;
    private static final SparseIntArray l;
    private final CoordinatorLayout m;
    private final NestedScrollView n;
    private long o;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        l = sparseIntArray;
        sparseIntArray.put(R.id.app_bar_layout, 2);
        l.put(R.id.collapsing_toolbar, 3);
        l.put(R.id.txt_title, 4);
        l.put(R.id.vendor_logo, 5);
        l.put(R.id.recharge_number, 6);
        l.put(R.id.recharge_operator, 7);
        l.put(R.id.toolbar, 8);
        l.put(R.id.toolbar_title, 9);
        l.put(R.id.toolbar_recharge_number, 10);
        l.put(R.id.toolbar_recharge_operator, 11);
    }

    public b(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 12, k, l));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private b(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[3], objArr[6], objArr[7], objArr[8], objArr[10], objArr[11], objArr[9], objArr[4], objArr[5]);
        this.o = -1;
        this.m = objArr[0];
        this.m.setTag("layout/activity_automatic_history_0");
        this.n = objArr[1];
        this.n.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.o = 1;
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

    public final void executeBindings() {
        synchronized (this) {
            this.o = 0;
        }
    }
}
