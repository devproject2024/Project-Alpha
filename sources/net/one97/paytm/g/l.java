package net.one97.paytm.g;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.paytm_finance.R;

public final class l extends k {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f50526h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f50527i;
    private final LinearLayout j;
    private long k;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f50527i = sparseIntArray;
        sparseIntArray.put(R.id.bs_title, 1);
        f50527i.put(R.id.failed_iv, 2);
        f50527i.put(R.id.tv_sub_title, 3);
        f50527i.put(R.id.disable_rl, 4);
        f50527i.put(R.id.tv_disable, 5);
        f50527i.put(R.id.loader, 6);
        f50527i.put(R.id.tv_cancel, 7);
    }

    public l(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, f50526h, f50527i));
    }

    private l(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[4], objArr[2], objArr[6], objArr[7], objArr[5], objArr[3]);
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
