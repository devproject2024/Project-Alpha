package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.R;

public class MpSettlementSummaryShimmerCardBindingImpl extends MpSettlementSummaryShimmerCardBinding {
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
        sparseIntArray.put(R.id.settlementSummaryCardShimmer, 1);
        sViewsWithIds.put(R.id.settlementTotalPaymentsShimmer, 2);
        sViewsWithIds.put(R.id.leftLabel1, 3);
        sViewsWithIds.put(R.id.rightLabel1, 4);
        sViewsWithIds.put(R.id.leftLabel2, 5);
        sViewsWithIds.put(R.id.rightLabel2, 6);
        sViewsWithIds.put(R.id.leftLabel3, 7);
        sViewsWithIds.put(R.id.rightLabel3, 8);
        sViewsWithIds.put(R.id.leftLabel4, 9);
        sViewsWithIds.put(R.id.rightLabel4, 10);
        sViewsWithIds.put(R.id.leftLabel5, 11);
        sViewsWithIds.put(R.id.rightLabel5, 12);
        sViewsWithIds.put(R.id.leftLabel6, 13);
        sViewsWithIds.put(R.id.rightLabel6, 14);
        sViewsWithIds.put(R.id.settlementBottomShimmer, 15);
    }

    public MpSettlementSummaryShimmerCardBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 16, sIncludes, sViewsWithIds));
    }

    public MpSettlementSummaryShimmerCardBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[3], objArr[5], objArr[7], objArr[9], objArr[11], objArr[13], objArr[4], objArr[6], objArr[8], objArr[10], objArr[12], objArr[14], objArr[15], objArr[1], objArr[2]);
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
