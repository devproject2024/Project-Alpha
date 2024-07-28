package net.one97.paytm.upgradeKyc.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.upgradeKyc.R;

public final class d extends c {
    private static final ViewDataBinding.b q = null;
    private static final SparseIntArray r;
    private final ConstraintLayout s;
    private final ConstraintLayout t;
    private long u;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        r = sparseIntArray;
        sparseIntArray.put(R.id.back_btn, 2);
        r.put(R.id.scrollView, 3);
        r.put(R.id.kyc_left_guideline, 4);
        r.put(R.id.kyc_right_guideline, 5);
        r.put(R.id.kyc_upper_guideline, 6);
        r.put(R.id.kyc_bottom_guideline, 7);
        r.put(R.id.iv, 8);
        r.put(R.id.tv_title, 9);
        r.put(R.id.tv_desc, 10);
        r.put(R.id.user_early_view, 11);
        r.put(R.id.tv_upcoming_appointment_due, 12);
        r.put(R.id.tv_upcoming_appointment_info, 13);
        r.put(R.id.tv_come_back_later, 14);
        r.put(R.id.appointment_book_tv, 15);
        r.put(R.id.btn_try_later, 16);
        r.put(R.id.ll_call_us, 17);
    }

    public d(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 18, q, r));
    }

    private d(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[15], objArr[2], objArr[16], objArr[8], objArr[7], objArr[4], objArr[5], objArr[6], objArr[17], objArr[3], objArr[14], objArr[10], objArr[9], objArr[12], objArr[13], objArr[11]);
        this.u = -1;
        this.s = objArr[0];
        this.s.setTag((Object) null);
        this.t = objArr[1];
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
