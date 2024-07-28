package net.one97.paytm.upgradeKyc.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.upgradeKyc.R;

public final class b extends a {
    private static final ViewDataBinding.b t = null;
    private static final SparseIntArray u;
    private long v;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        u = sparseIntArray;
        sparseIntArray.put(R.id.footer_layout, 1);
        u.put(R.id.iv_close, 2);
        u.put(R.id.tv_heading, 3);
        u.put(R.id.iv1, 4);
        u.put(R.id.tv1, 5);
        u.put(R.id.cb_doc, 6);
        u.put(R.id.fl_wifi, 7);
        u.put(R.id.iv2, 8);
        u.put(R.id.iv_network_exception, 9);
        u.put(R.id.wifi_loader, 10);
        u.put(R.id.tv2, 11);
        u.put(R.id.cb_wifi, 12);
        u.put(R.id.iv3, 13);
        u.put(R.id.tv3, 14);
        u.put(R.id.cb_quiet_place, 15);
        u.put(R.id.tv_warning, 16);
        u.put(R.id.tv_confirm_pts, 17);
        u.put(R.id.btn_proceed, 18);
    }

    public b(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 19, t, u));
    }

    private b(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[18], objArr[6], objArr[15], objArr[12], objArr[7], objArr[1], objArr[4], objArr[8], objArr[13], objArr[2], objArr[9], objArr[0], objArr[5], objArr[11], objArr[14], objArr[17], objArr[3], objArr[16], objArr[10]);
        this.v = -1;
        this.l.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.v = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.v != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.v = 0;
        }
    }
}
