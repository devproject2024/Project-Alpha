package com.paytm.dynamic.flight.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.paytm_finance.R;

public final class d extends c {
    private static final ViewDataBinding.b p = null;
    private static final SparseIntArray q;
    private final ConstraintLayout r;
    private long s;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        q = sparseIntArray;
        sparseIntArray.put(R.id.iv_wallet_back_button, 1);
        q.put(R.id.tv_add_money_label, 2);
        q.put(R.id.tv_best_label, 3);
        q.put(R.id.iv_epurse_icon, 4);
        q.put(R.id.tv_epurse_avail_balance, 5);
        q.put(R.id.tv_rupee_symbol, 6);
        q.put(R.id.et_enter_amount, 7);
        q.put(R.id.view_horizontal_five, 8);
        q.put(R.id.tv_error_message, 9);
        q.put(R.id.btn_hint_100, 10);
        q.put(R.id.btn_hint_200, 11);
        q.put(R.id.btn_hint_500, 12);
        q.put(R.id.btn_proceed, 13);
        q.put(R.id.frameLayout2, 14);
        q.put(R.id.lottieProgressBar, 15);
    }

    public d(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 16, p, q));
    }

    private d(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[10], objArr[11], objArr[12], objArr[13], objArr[7], objArr[14], objArr[4], objArr[1], objArr[15], objArr[2], objArr[3], objArr[5], objArr[9], objArr[6], objArr[8]);
        this.s = -1;
        this.r = objArr[0];
        this.r.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.s = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.s != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.s = 0;
        }
    }
}
