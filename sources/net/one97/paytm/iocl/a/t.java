package net.one97.paytm.iocl.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.iocl.R;

public final class t extends s {
    private static final ViewDataBinding.b y = null;
    private static final SparseIntArray z;
    private long A;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        z = sparseIntArray;
        sparseIntArray.put(R.id.minimum_redeem_message, 1);
        z.put(R.id.reward_points_container, 2);
        z.put(R.id.tv_member_id, 3);
        z.put(R.id.iocl_redeem_points_text, 4);
        z.put(R.id.secondary_message, 5);
        z.put(R.id.updated_date, 6);
        z.put(R.id.iocl_logo, 7);
        z.put(R.id.iocl_profile_image, 8);
        z.put(R.id.other_message, 9);
        z.put(R.id.primary_message_container, 10);
        z.put(R.id.primary_message, 11);
        z.put(R.id.registered_container, 12);
        z.put(R.id.iocl_redeem_points_btn, 13);
        z.put(R.id.iocl_wallet_btn, 14);
        z.put(R.id.wallet_sep_line, 15);
        z.put(R.id.non_registered_container, 16);
        z.put(R.id.iocl_enroll_btn, 17);
        z.put(R.id.requested_container, 18);
        z.put(R.id.iocl_pay_btn, 19);
        z.put(R.id.profile_failed_container, 20);
        z.put(R.id.iocl_profile_failed__btn, 21);
        z.put(R.id.iocl_know_more_btn, 22);
        z.put(R.id.video_container, 23);
    }

    public t(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 24, y, z));
    }

    private t(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[17], objArr[22], objArr[7], objArr[19], objArr[21], objArr[8], objArr[13], objArr[4], objArr[14], objArr[1], objArr[0], objArr[16], objArr[9], objArr[11], objArr[10], objArr[20], objArr[12], objArr[18], objArr[2], objArr[5], objArr[3], objArr[6], objArr[23], objArr[15]);
        this.A = -1;
        this.k.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.A = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.A != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.A = 0;
        }
    }
}
