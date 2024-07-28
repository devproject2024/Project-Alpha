package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.R;

public class MpCommonOverlayDialogBindingImpl extends MpCommonOverlayDialogBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final FrameLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title, 1);
        sViewsWithIds.put(R.id.description, 2);
        sViewsWithIds.put(R.id.btn_txt, 3);
        sViewsWithIds.put(R.id.cross_btn, 4);
    }

    public MpCommonOverlayDialogBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 5, sIncludes, sViewsWithIds));
    }

    public MpCommonOverlayDialogBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[3], objArr[4], objArr[2], objArr[1]);
        this.mDirtyFlags = -1;
        FrameLayout frameLayout = objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag((Object) null);
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
