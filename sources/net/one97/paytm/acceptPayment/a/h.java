package net.one97.paytm.acceptPayment.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.acceptPayment.R;

public final class h extends g {
    private static final ViewDataBinding.b l = null;
    private static final SparseIntArray m;
    private final FrameLayout n;
    private long o;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        m = sparseIntArray;
        sparseIntArray.put(R.id.parent_view, 1);
        m.put(R.id.back_arrow_home, 2);
        m.put(R.id.drawer_img, 3);
        m.put(R.id.header_name, 4);
        m.put(R.id.account_area, 5);
        m.put(R.id.header_bank_icon, 6);
        m.put(R.id.header_bank_name, 7);
        m.put(R.id.header_account, 8);
        m.put(R.id.account_area_shimmer, 9);
        m.put(R.id.reward_points_shimmer, 10);
        m.put(R.id.reward_points, 11);
    }

    public h(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 12, l, m));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private h(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[5], objArr[9], objArr[2], objArr[3], objArr[8], objArr[6], objArr[7], objArr[4], objArr[1], objArr[11], objArr[10]);
        this.o = -1;
        FrameLayout frameLayout = objArr[0];
        this.n = frameLayout;
        frameLayout.setTag((Object) null);
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
