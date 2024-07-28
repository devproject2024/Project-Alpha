package net.one97.paytm.addmoney.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.addmoney.R;

public final class v extends u {
    private static final ViewDataBinding.b w = null;
    private static final SparseIntArray x;
    private long y;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        x = sparseIntArray;
        sparseIntArray.put(R.id.wallet_loader, 1);
        x.put(R.id.card_container, 2);
        x.put(R.id.newCardContainer, 3);
        x.put(R.id.tv_enter_card_number, 4);
        x.put(R.id.etCardNumber, 5);
        x.put(R.id.iv_card_logo, 6);
        x.put(R.id.iv_cross, 7);
        x.put(R.id.tvExipary, 8);
        x.put(R.id.et_expiry_validity, 9);
        x.put(R.id.cvvLayout, 10);
        x.put(R.id.tvCvv, 11);
        x.put(R.id.tv_cvv_help, 12);
        x.put(R.id.etCvv, 13);
        x.put(R.id.lowSuccessRateTv, 14);
        x.put(R.id.two_mode_auth_layout, 15);
        x.put(R.id.rb_atm_pin, 16);
        x.put(R.id.rb_otp, 17);
        x.put(R.id.saveCardForFutureCB, 18);
        x.put(R.id.btnProceed, 19);
        x.put(R.id.newCardAddBtn, 20);
        x.put(R.id.tvPayWithNewDebitCard, 21);
    }

    public v(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 22, w, x));
    }

    private v(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[19], objArr[2], objArr[10], objArr[5], objArr[13], objArr[9], objArr[6], objArr[7], objArr[14], objArr[20], objArr[3], objArr[16], objArr[17], objArr[18], objArr[0], objArr[11], objArr[12], objArr[4], objArr[8], objArr[21], objArr[15], objArr[1]);
        this.y = -1;
        this.o.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.y = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.y != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.y = 0;
        }
    }
}
