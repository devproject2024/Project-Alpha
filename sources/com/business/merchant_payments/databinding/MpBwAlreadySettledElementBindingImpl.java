package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.R;

public class MpBwAlreadySettledElementBindingImpl extends MpBwAlreadySettledElementBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final LinearLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bwAlreadySettledDetails, 1);
        sViewsWithIds.put(R.id.bwAlreadySettledTickImage, 2);
        sViewsWithIds.put(R.id.bwAlreadySettledTime, 3);
        sViewsWithIds.put(R.id.bwAlreadySettledAmount, 4);
        sViewsWithIds.put(R.id.bwVerticalSpace, 5);
        sViewsWithIds.put(R.id.bwAlreadySettledUTRNumber, 6);
        sViewsWithIds.put(R.id.bwPendingSettlementTime, 7);
        sViewsWithIds.put(R.id.ll_bank_details, 8);
        sViewsWithIds.put(R.id.bwAlreadySettledlBankLogoImage, 9);
        sViewsWithIds.put(R.id.bwAlreadySettledBankAccountNumber, 10);
        sViewsWithIds.put(R.id.bwAlreadySettledDivider, 11);
    }

    public MpBwAlreadySettledElementBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 12, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpBwAlreadySettledElementBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[4], objArr[10], objArr[1], objArr[11], objArr[2], objArr[3], objArr[6], objArr[9], objArr[7], objArr[5], objArr[8]);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag((Object) null);
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
