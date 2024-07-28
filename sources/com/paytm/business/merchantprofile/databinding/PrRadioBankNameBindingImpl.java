package com.paytm.business.merchantprofile.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.paytm.business.merchantprofile.R;

public class PrRadioBankNameBindingImpl extends PrRadioBankNameBinding {
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
        sparseIntArray.put(R.id.radio, 1);
        sViewsWithIds.put(R.id.top_text, 2);
        sViewsWithIds.put(R.id.divier, 3);
    }

    public PrRadioBankNameBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 4, sIncludes, sViewsWithIds));
    }

    public PrRadioBankNameBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[3], objArr[1], objArr[2]);
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
