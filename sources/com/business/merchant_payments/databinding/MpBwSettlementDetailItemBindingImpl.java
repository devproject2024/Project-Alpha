package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.R;

public class MpBwSettlementDetailItemBindingImpl extends MpBwSettlementDetailItemBinding {
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
        sparseIntArray.put(R.id.bwSettlementDetailItemDivider, 1);
        sViewsWithIds.put(R.id.bwSettlementSuccessContainer, 2);
        sViewsWithIds.put(R.id.bwSettlementDetailItemStatusIcon, 3);
        sViewsWithIds.put(R.id.bwsDetailFlowLayout, 4);
        sViewsWithIds.put(R.id.bwSettlementDetailItemStatusText, 5);
        sViewsWithIds.put(R.id.bwSettlementDetailBankLogoImage, 6);
        sViewsWithIds.put(R.id.bwSettlementDetailBankNameText, 7);
        sViewsWithIds.put(R.id.bwSettlementDetailAccountNumberText, 8);
        sViewsWithIds.put(R.id.bwSettlementDetailAmountText, 9);
        sViewsWithIds.put(R.id.bwSettlementUTRText, 10);
    }

    public MpBwSettlementDetailItemBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 11, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpBwSettlementDetailItemBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[8], objArr[9], objArr[6], objArr[7], objArr[1], objArr[3], objArr[5], objArr[2], objArr[10], objArr[4]);
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
