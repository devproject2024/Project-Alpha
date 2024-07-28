package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.R;

public class MpBottomsheetPracticesForSettleNowBindingImpl extends MpBottomsheetPracticesForSettleNowBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final ConstraintLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.heading, 1);
        sViewsWithIds.put(R.id.mp_ic_1, 2);
        sViewsWithIds.put(R.id.practice_1, 3);
        sViewsWithIds.put(R.id.tick_1, 4);
        sViewsWithIds.put(R.id.practice_2, 5);
        sViewsWithIds.put(R.id.tick_2, 6);
        sViewsWithIds.put(R.id.practice_3, 7);
        sViewsWithIds.put(R.id.tick_3, 8);
        sViewsWithIds.put(R.id.practice_4, 9);
        sViewsWithIds.put(R.id.btn_got_it, 10);
    }

    public MpBottomsheetPracticesForSettleNowBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 11, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpBottomsheetPracticesForSettleNowBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[10], objArr[1], objArr[2], objArr[3], objArr[5], objArr[7], objArr[9], objArr[4], objArr[6], objArr[8]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
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
