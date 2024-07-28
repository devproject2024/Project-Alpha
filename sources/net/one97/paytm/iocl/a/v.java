package net.one97.paytm.iocl.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.iocl.R;

public final class v extends u {
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
        sparseIntArray.put(R.id.minimum_redeem_message, 1);
        y.put(R.id.reward_points_container, 2);
        y.put(R.id.iocl_redeem_points_text, 3);
        y.put(R.id.secondary_message, 4);
        y.put(R.id.updated_date, 5);
        y.put(R.id.iocl_logo, 6);
        y.put(R.id.iocl_profile_image, 7);
        y.put(R.id.other_message, 8);
        y.put(R.id.primary_message_container, 9);
        y.put(R.id.primary_message, 10);
        y.put(R.id.registered_container, 11);
        y.put(R.id.iocl_redeem_points_btn, 12);
        y.put(R.id.iocl_wallet_btn, 13);
        y.put(R.id.wallet_sep_line, 14);
        y.put(R.id.non_registered_container, 15);
        y.put(R.id.iocl_enroll_btn, 16);
        y.put(R.id.requested_container, 17);
        y.put(R.id.iocl_pay_btn, 18);
        y.put(R.id.profile_failed_container, 19);
        y.put(R.id.iocl_profile_failed__btn, 20);
        y.put(R.id.iocl_know_more_btn, 21);
        y.put(R.id.video_container, 22);
    }

    public v(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 23, x, y));
    }

    private v(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[16], objArr[21], objArr[6], objArr[18], objArr[20], objArr[7], objArr[12], objArr[3], objArr[13], objArr[1], objArr[0], objArr[15], objArr[8], objArr[10], objArr[9], objArr[19], objArr[11], objArr[17], objArr[2], objArr[4], objArr[5], objArr[22], objArr[14]);
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
