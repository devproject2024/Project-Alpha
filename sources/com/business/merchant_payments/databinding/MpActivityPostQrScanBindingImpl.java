package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.R;

public class MpActivityPostQrScanBindingImpl extends MpActivityPostQrScanBinding {
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
        sparseIntArray.put(R.id.iv_close, 1);
        sViewsWithIds.put(R.id.tv_scan_status_text, 2);
        sViewsWithIds.put(R.id.tv_sub_title, 3);
        sViewsWithIds.put(R.id.cl_order_qr_accessories, 4);
        sViewsWithIds.put(R.id.tv_order_qr_accessories, 5);
        sViewsWithIds.put(R.id.guideline, 6);
        sViewsWithIds.put(R.id.cl_print_qr, 7);
        sViewsWithIds.put(R.id.tv_print_qr, 8);
        sViewsWithIds.put(R.id.cl_earn_cashback, 9);
        sViewsWithIds.put(R.id.tv_earn_cashback, 10);
        sViewsWithIds.put(R.id.cl_watch_ad, 11);
        sViewsWithIds.put(R.id.tv_watch_ad, 12);
        sViewsWithIds.put(R.id.tv_btn_scan_again, 13);
    }

    public MpActivityPostQrScanBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 14, sIncludes, sViewsWithIds));
    }

    public MpActivityPostQrScanBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[9], objArr[4], objArr[7], objArr[11], objArr[6], objArr[1], objArr[13], objArr[10], objArr[5], objArr[8], objArr[2], objArr[3], objArr[12]);
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
