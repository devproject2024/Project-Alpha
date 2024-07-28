package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.R;

public class MpBwSettlementDetailNewBindingImpl extends MpBwSettlementDetailNewBinding {
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
        sViewsWithIds.put(R.id.bwSettlementDetailNewSettledAtContainer, 2);
        sViewsWithIds.put(R.id.bwSettlementDetailItemStatusText, 3);
        sViewsWithIds.put(R.id.bwSettlementDetailItemStatusIcon, 4);
        sViewsWithIds.put(R.id.bwSettlementDetailAmountText, 5);
        sViewsWithIds.put(R.id.bwDetailBankLogoAccNumberContainer, 6);
        sViewsWithIds.put(R.id.bwSettlementDetailBankLogoImage, 7);
        sViewsWithIds.put(R.id.bwSettlementDetailAccountNumberText, 8);
        sViewsWithIds.put(R.id.bwSettlementDetailBankNameContainer, 9);
        sViewsWithIds.put(R.id.bwSettlementDetailBankNameText, 10);
        sViewsWithIds.put(R.id.bwPipe, 11);
        sViewsWithIds.put(R.id.bwSettlementUTRText2, 12);
        sViewsWithIds.put(R.id.bwSettlementUTRText, 13);
        sViewsWithIds.put(R.id.view_all_pending_settlement_time, 14);
    }

    public MpBwSettlementDetailNewBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 15, sIncludes, sViewsWithIds));
    }

    public MpBwSettlementDetailNewBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[6], objArr[11], objArr[8], objArr[5], objArr[7], objArr[9], objArr[10], objArr[1], objArr[4], objArr[3], objArr[2], objArr[13], objArr[12], objArr[14]);
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
