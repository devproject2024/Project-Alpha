package com.paytm.business.merchantprofile.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.paytm.business.merchantprofile.R;

public class PrViewEditChangeInProgressNewBindingImpl extends PrViewEditChangeInProgressNewBinding {
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
        sparseIntArray.put(R.id.tv_upload, 1);
        sViewsWithIds.put(R.id.ivTicketStatus, 2);
        sViewsWithIds.put(R.id.progress, 3);
        sViewsWithIds.put(R.id.tv_description, 4);
    }

    public PrViewEditChangeInProgressNewBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 5, sIncludes, sViewsWithIds));
    }

    public PrViewEditChangeInProgressNewBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[2], objArr[0], objArr[3], objArr[4], objArr[1]);
        this.mDirtyFlags = -1;
        this.parent.setTag((Object) null);
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
