package net.one97.paytm.g;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.paytm_finance.R;

public final class h extends g {
    private static final ViewDataBinding.b k = null;
    private static final SparseIntArray l;
    private long m;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        l = sparseIntArray;
        sparseIntArray.put(R.id.iv_icon, 1);
        l.put(R.id.tv_title, 2);
        l.put(R.id.rl_success, 3);
        l.put(R.id.tv_status, 4);
        l.put(R.id.tv_download_percent, 5);
        l.put(R.id.pb_download, 6);
        l.put(R.id.ll_failed, 7);
        l.put(R.id.tv_failed, 8);
        l.put(R.id.tv_retry, 9);
    }

    public h(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 10, k, l));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private h(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[7], objArr[6], objArr[3], objArr[0], objArr[5], objArr[8], objArr[9], objArr[4], objArr[2]);
        this.m = -1;
        this.f50505e.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.m = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.m != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.m = 0;
        }
    }
}
