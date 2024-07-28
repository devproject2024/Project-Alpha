package net.one97.paytm.g;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.paytm_finance.R;

public final class j extends i {
    private static final ViewDataBinding.b m = null;
    private static final SparseIntArray n;
    private long o;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        n = sparseIntArray;
        sparseIntArray.put(R.id.iv_icon, 1);
        n.put(R.id.tv_title, 2);
        n.put(R.id.rl_success, 3);
        n.put(R.id.tv_status, 4);
        n.put(R.id.tv_download_percent, 5);
        n.put(R.id.pb_download, 6);
        n.put(R.id.ll_failed, 7);
        n.put(R.id.tv_failed, 8);
        n.put(R.id.tv_retry, 9);
        n.put(R.id.ll_back, 10);
        n.put(R.id.tv_back, 11);
    }

    public j(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 12, m, n));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private j(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[10], objArr[7], objArr[6], objArr[3], objArr[0], objArr[11], objArr[5], objArr[8], objArr[9], objArr[4], objArr[2]);
        this.o = -1;
        this.f50515f.setTag((Object) null);
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
