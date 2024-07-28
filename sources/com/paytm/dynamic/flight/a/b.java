package com.paytm.dynamic.flight.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.paytm_finance.R;

public final class b extends a {
    private static final ViewDataBinding.b u = null;
    private static final SparseIntArray v;
    private final ConstraintLayout w;
    private long x;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        v = sparseIntArray;
        sparseIntArray.put(R.id.tv_recharge_epurse, 1);
        v.put(R.id.iv_close_rechage_sheet, 2);
        v.put(R.id.llEPurseWalletContainer, 3);
        v.put(R.id.tv_epurse_wallet_label, 4);
        v.put(R.id.tvErrorMessage, 5);
        v.put(R.id.tv_epurse_balance, 6);
        v.put(R.id.view_card, 7);
        v.put(R.id.tv_enter_amount_label, 8);
        v.put(R.id.et_enter_amount, 9);
        v.put(R.id.view_horizon_line, 10);
        v.put(R.id.btn_add_100, 11);
        v.put(R.id.btn_add_200, 12);
        v.put(R.id.btn_add_500, 13);
        v.put(R.id.iv_check_fast, 14);
        v.put(R.id.iv_fast_forward_icon, 15);
        v.put(R.id.tv_fast_forward_label, 16);
        v.put(R.id.tv_instant_payment_label, 17);
        v.put(R.id.btn_proceed_pay, 18);
        v.put(R.id.frameLayout2, 19);
        v.put(R.id.lottieProgressBar, 20);
    }

    public b(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 21, u, v));
    }

    private b(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[11], objArr[12], objArr[13], objArr[18], objArr[9], objArr[19], objArr[14], objArr[2], objArr[15], objArr[3], objArr[20], objArr[8], objArr[6], objArr[4], objArr[5], objArr[16], objArr[17], objArr[1], objArr[7], objArr[10]);
        this.x = -1;
        this.w = objArr[0];
        this.w.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.x = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.x != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.x = 0;
        }
    }
}
