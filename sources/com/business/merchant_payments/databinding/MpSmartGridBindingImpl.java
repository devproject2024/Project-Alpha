package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.R;

public class MpSmartGridBindingImpl extends MpSmartGridBinding {
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
        sparseIntArray.put(R.id.item0_icon, 1);
        sViewsWithIds.put(R.id.item0_text, 2);
        sViewsWithIds.put(R.id.item1_icon, 3);
        sViewsWithIds.put(R.id.item1_text, 4);
        sViewsWithIds.put(R.id.item2_icon, 5);
        sViewsWithIds.put(R.id.item2_text, 6);
        sViewsWithIds.put(R.id.item3_icon, 7);
        sViewsWithIds.put(R.id.item3_text, 8);
    }

    public MpSmartGridBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 9, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpSmartGridBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
        this.mDirtyFlags = -1;
        this.grid.setTag((Object) null);
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
