package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.R;

public class MpQrDetailBindingImpl extends MpQrDetailBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final RelativeLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.iv_close_icon, 1);
        sViewsWithIds.put(R.id.tv_get_all_qr_text, 2);
        sViewsWithIds.put(R.id.tv_instant_settlement, 3);
        sViewsWithIds.put(R.id.imageView2, 4);
        sViewsWithIds.put(R.id.tv_download_print_qr, 5);
        sViewsWithIds.put(R.id.tv_order_all_in_one_qr, 6);
        sViewsWithIds.put(R.id.cl_all_in_one_qr, 7);
        sViewsWithIds.put(R.id.iv_all_in_one, 8);
        sViewsWithIds.put(R.id.tv_all_in_one_heading, 9);
        sViewsWithIds.put(R.id.tv_all_in_one_subheading, 10);
        sViewsWithIds.put(R.id.cl_zero_cost, 11);
        sViewsWithIds.put(R.id.iv_zero_cost, 12);
        sViewsWithIds.put(R.id.tv_zero_cost_heading, 13);
        sViewsWithIds.put(R.id.tv_zero_cost_subheading, 14);
        sViewsWithIds.put(R.id.cl_unlimited_payments, 15);
        sViewsWithIds.put(R.id.iv_unlimited_payments, 16);
        sViewsWithIds.put(R.id.tv_unlimited_payments_heading, 17);
        sViewsWithIds.put(R.id.tv_unlimited_payments_subheading, 18);
        sViewsWithIds.put(R.id.cl_quick_settlement, 19);
        sViewsWithIds.put(R.id.iv_quick_settlement, 20);
        sViewsWithIds.put(R.id.tv_quick_settlement_heading, 21);
        sViewsWithIds.put(R.id.tv_quick_settlement_subheading, 22);
    }

    public MpQrDetailBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 23, sIncludes, sViewsWithIds));
    }

    public MpQrDetailBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[7], objArr[19], objArr[15], objArr[11], objArr[4], objArr[8], objArr[1], objArr[20], objArr[16], objArr[12], objArr[9], objArr[10], objArr[5], objArr[2], objArr[3], objArr[6], objArr[21], objArr[22], objArr[17], objArr[18], objArr[13], objArr[14]);
        this.mDirtyFlags = -1;
        RelativeLayout relativeLayout = objArr[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag((Object) null);
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
