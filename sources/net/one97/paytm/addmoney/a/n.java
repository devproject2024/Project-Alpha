package net.one97.paytm.addmoney.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.addmoney.R;

public final class n extends m {
    private static final ViewDataBinding.b r = null;
    private static final SparseIntArray s;
    private final NestedScrollView t;
    private long u;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        s = sparseIntArray;
        sparseIntArray.put(R.id.apply_promo_header, 1);
        s.put(R.id.txt_apply_promo, 2);
        s.put(R.id.close_img, 3);
        s.put(R.id.rl_promo_code, 4);
        s.put(R.id.et_promo, 5);
        s.put(R.id.txt_coupon_paste, 6);
        s.put(R.id.rl_apply, 7);
        s.put(R.id.seprator_view, 8);
        s.put(R.id.v_divider_1, 9);
        s.put(R.id.tv_error, 10);
        s.put(R.id.tv_choose_offer, 11);
        s.put(R.id.rv_offer_list, 12);
        s.put(R.id.ll_no_offers, 13);
        s.put(R.id.v_divider_2, 14);
        s.put(R.id.tv_cash_back_text, 15);
        s.put(R.id.v_divider_3, 16);
        s.put(R.id.tv_wallet_loyality_cash_back_text, 17);
    }

    public n(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 18, r, s));
    }

    private n(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[3], objArr[5], objArr[13], objArr[7], objArr[4], objArr[12], objArr[8], objArr[15], objArr[11], objArr[10], objArr[17], objArr[2], objArr[6], objArr[9], objArr[14], objArr[16]);
        this.u = -1;
        this.t = objArr[0];
        this.t.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.u = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.u != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.u = 0;
        }
    }
}
