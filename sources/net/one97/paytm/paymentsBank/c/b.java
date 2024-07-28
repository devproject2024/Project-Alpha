package net.one97.paytm.paymentsBank.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.paymentsBank.R;

public final class b extends a {
    private static final ViewDataBinding.b x = null;
    private static final SparseIntArray y;
    private long z;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        y = sparseIntArray;
        sparseIntArray.put(R.id.appbar, 1);
        y.put(R.id.ctl_toolbar, 2);
        y.put(R.id.ll_passbook_wallet_amount, 3);
        y.put(R.id.back_arrow, 4);
        y.put(R.id.bankName, 5);
        y.put(R.id.rupeesTv, 6);
        y.put(R.id.frequencyTv, 7);
        y.put(R.id.dateTv, 8);
        y.put(R.id.lineView, 9);
        y.put(R.id.regNoTv, 10);
        y.put(R.id.rl_add_money_layout, 11);
        y.put(R.id.send_money_view, 12);
        y.put(R.id.rl_send_money_layout, 13);
        y.put(R.id.tvsendMoney, 14);
        y.put(R.id.toolbar, 15);
        y.put(R.id.tool_bar_back, 16);
        y.put(R.id.txt_user_name_toolbar, 17);
        y.put(R.id.list_fragment_container, 18);
        y.put(R.id.paymentHistoryTitle, 19);
        y.put(R.id.loader, 20);
        y.put(R.id.noItemTv, 21);
        y.put(R.id.transRV, 22);
    }

    public b(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 23, x, y));
    }

    private b(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[4], objArr[5], objArr[2], objArr[8], objArr[7], objArr[9], objArr[18], objArr[3], objArr[20], objArr[0], objArr[21], objArr[19], objArr[10], objArr[11], objArr[13], objArr[6], objArr[12], objArr[16], objArr[15], objArr[22], objArr[14], objArr[17]);
        this.z = -1;
        this.k.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.z = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.z != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.z = 0;
        }
    }
}
