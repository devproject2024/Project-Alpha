package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.R;

public class MpFragmentSaveFeedbackBindingImpl extends MpFragmentSaveFeedbackBinding {
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
        sparseIntArray.put(R.id.iv_back, 1);
        sViewsWithIds.put(R.id.pfbTextView, 2);
        sViewsWithIds.put(R.id.textView6, 3);
        sViewsWithIds.put(R.id.iv_reason1, 4);
        sViewsWithIds.put(R.id.seperator_1, 5);
        sViewsWithIds.put(R.id.tv_reason2, 6);
        sViewsWithIds.put(R.id.iv_reason2, 7);
        sViewsWithIds.put(R.id.seperator_2, 8);
        sViewsWithIds.put(R.id.tv_reason_other, 9);
        sViewsWithIds.put(R.id.iv_reason_other, 10);
        sViewsWithIds.put(R.id.cl_response_box, 11);
        sViewsWithIds.put(R.id.tv_your_comments, 12);
        sViewsWithIds.put(R.id.et_response, 13);
        sViewsWithIds.put(R.id.btn_submit, 14);
    }

    public MpFragmentSaveFeedbackBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 15, sIncludes, sViewsWithIds));
    }

    public MpFragmentSaveFeedbackBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[14], objArr[11], objArr[13], objArr[1], objArr[4], objArr[7], objArr[10], objArr[2], objArr[5], objArr[8], objArr[3], objArr[6], objArr[9], objArr[12]);
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
