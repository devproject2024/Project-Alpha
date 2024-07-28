package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.R;

public class MpFragmentRequestMoneyBindingImpl extends MpFragmentRequestMoneyBinding {
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
        sparseIntArray.put(R.id.request_money_layout, 1);
        sViewsWithIds.put(R.id.merhcant_link_rv, 2);
        sViewsWithIds.put(R.id.no_item_container, 3);
        sViewsWithIds.put(R.id.no_img, 4);
        sViewsWithIds.put(R.id.tv_no_data_text, 5);
        sViewsWithIds.put(R.id.progress_bar_lyt, 6);
    }

    public MpFragmentRequestMoneyBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 7, sIncludes, sViewsWithIds));
    }

    public MpFragmentRequestMoneyBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[2], objArr[4], objArr[3], objArr[6], objArr[0], objArr[1], objArr[5]);
        this.mDirtyFlags = -1;
        this.requestMoneyContainerCl.setTag((Object) null);
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
