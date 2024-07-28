package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.R;

public class MpActivityAddMobileOtpBindingImpl extends MpActivityAddMobileOtpBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.header_outer_most_container, 1);
        sViewsWithIds.put(R.id.iv_close, 2);
        sViewsWithIds.put(R.id.ll_login_page_outer_container, 3);
        sViewsWithIds.put(R.id.tv_otp_num, 4);
        sViewsWithIds.put(R.id.container_id, 5);
        sViewsWithIds.put(R.id.tv_resend_otp, 6);
        sViewsWithIds.put(R.id.tv_confirm, 7);
    }

    public MpActivityAddMobileOtpBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 8, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpActivityAddMobileOtpBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[5], objArr[0], objArr[1], objArr[2], objArr[3], objArr[7], objArr[4], objArr[6]);
        this.mDirtyFlags = -1;
        this.coordinatorLayout.setTag((Object) null);
        View view2 = view;
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
