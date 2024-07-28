package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.R;

public class MpOnlineSettlementSummaryCardBindingImpl extends MpOnlineSettlementSummaryCardBinding {
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
        sparseIntArray.put(R.id.onlineSettlementTotalPaymentsContainer, 1);
        sViewsWithIds.put(R.id.onlineSettlementTotalPaymentsText, 2);
        sViewsWithIds.put(R.id.online_settlement_dynamic_data, 3);
        sViewsWithIds.put(R.id.bottomDivider, 4);
        sViewsWithIds.put(R.id.online_settlement_summary_total_amount_text, 5);
        sViewsWithIds.put(R.id.settlement_summary_card_amount, 6);
        sViewsWithIds.put(R.id.online_settlement_by_texts, 7);
    }

    public MpOnlineSettlementSummaryCardBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 8, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpOnlineSettlementSummaryCardBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[4], objArr[7], objArr[3], objArr[0], objArr[5], objArr[1], objArr[2], objArr[6]);
        this.mDirtyFlags = -1;
        this.onlineSettlementSummaryRoot.setTag((Object) null);
        View view2 = view;
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
