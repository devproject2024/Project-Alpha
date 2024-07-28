package net.one97.paytm.upgradeKyc.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.upgradeKyc.R;

public final class h extends g {
    private static final ViewDataBinding.b o = null;
    private static final SparseIntArray p;
    private final ConstraintLayout q;
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
        p = sparseIntArray;
        sparseIntArray.put(R.id.back_btn, 2);
        p.put(R.id.scrollView, 3);
        p.put(R.id.kyc_left_guideline, 4);
        p.put(R.id.kyc_right_guideline, 5);
        p.put(R.id.kyc_upper_guideline, 6);
        p.put(R.id.kyc_bottom_guideline, 7);
        p.put(R.id.iv, 8);
        p.put(R.id.tv_title, 9);
        p.put(R.id.tv_desc, 10);
        p.put(R.id.tv_appointment_time, 11);
        p.put(R.id.tv_dont_wait, 12);
        p.put(R.id.tv_click, 13);
        p.put(R.id.tv_do_kyc_now, 14);
        p.put(R.id.tv_comeback_later, 15);
    }

    public h(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 16, o, p));
    }

    private h(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[8], objArr[7], objArr[4], objArr[5], objArr[6], objArr[3], objArr[11], objArr[13], objArr[15], objArr[10], objArr[14], objArr[12], objArr[9]);
        this.s = -1;
        this.q = objArr[0];
        this.q.setTag((Object) null);
        this.r = objArr[1];
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
