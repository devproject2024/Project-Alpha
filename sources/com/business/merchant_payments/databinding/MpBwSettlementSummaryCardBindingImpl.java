package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.R;

public class MpBwSettlementSummaryCardBindingImpl extends MpBwSettlementSummaryCardBinding {
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
        sparseIntArray.put(R.id.bwSettlementTotalPaymentsToday, 1);
        sViewsWithIds.put(R.id.bwAlreadySettledToBankContainer, 2);
        sViewsWithIds.put(R.id.bwAlreadySettledToBankText, 3);
        sViewsWithIds.put(R.id.bwSettlementSummaryAlreadySettledArrowImage, 4);
        sViewsWithIds.put(R.id.bwAlreadySettledAmountValue, 5);
        sViewsWithIds.put(R.id.rl_summary_header, 6);
        sViewsWithIds.put(R.id.tv_settlement_detail_txt, 7);
        sViewsWithIds.put(R.id.tv_settled_view_all, 8);
        sViewsWithIds.put(R.id.bwAlreadySettledAmountDetailsContainer, 9);
        sViewsWithIds.put(R.id.bwPendingToBankContainer, 10);
        sViewsWithIds.put(R.id.bwPendingToBankText, 11);
        sViewsWithIds.put(R.id.bwSettlementSummaryPendingArrowImage, 12);
        sViewsWithIds.put(R.id.bwPendingAmountValue, 13);
        sViewsWithIds.put(R.id.rl_pending_header, 14);
        sViewsWithIds.put(R.id.tv_pending_view_all, 15);
        sViewsWithIds.put(R.id.bwPendingAmountDetailsContainer, 16);
        sViewsWithIds.put(R.id.bwSummaryCardDivider1, 17);
        sViewsWithIds.put(R.id.bwAvailableBalanceContainer, 18);
        sViewsWithIds.put(R.id.bwAvailableBalanceText, 19);
        sViewsWithIds.put(R.id.bwAvailableBalanceValue, 20);
        sViewsWithIds.put(R.id.bwSummaryCardDivider2, 21);
        sViewsWithIds.put(R.id.bwSettleNowContainer, 22);
        sViewsWithIds.put(R.id.bwMinAmtNextSettlementText, 23);
        sViewsWithIds.put(R.id.bwNextSettlementText, 24);
        sViewsWithIds.put(R.id.bwSettleNowBankImage, 25);
        sViewsWithIds.put(R.id.bwBankAccountNumberText, 26);
        sViewsWithIds.put(R.id.bwSettleNowButton, 27);
        sViewsWithIds.put(R.id.ic_lock, 28);
        sViewsWithIds.put(R.id.tv_settle_now, 29);
        sViewsWithIds.put(R.id.tag_instant_settlement, 30);
        sViewsWithIds.put(R.id.cl_disable_settle_now_info, 31);
        sViewsWithIds.put(R.id.tv_disable_settle_now_info, 32);
        sViewsWithIds.put(R.id.bwSettlementToolTip, 33);
        sViewsWithIds.put(R.id.bwSettlementSumaryBankDetailShimmer, 34);
        sViewsWithIds.put(R.id.bwShimerSettlementFreq, 35);
        sViewsWithIds.put(R.id.bwShimmerSettleNowBtn, 36);
        sViewsWithIds.put(R.id.bwShimmerBankImage, 37);
        sViewsWithIds.put(R.id.bwShimmerBankDetail, 38);
    }

    public MpBwSettlementSummaryCardBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 39, sIncludes, sViewsWithIds));
    }

    public MpBwSettlementSummaryCardBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[9], objArr[5], objArr[2], objArr[3], objArr[18], objArr[19], objArr[20], objArr[26], objArr[23], objArr[24], objArr[16], objArr[13], objArr[10], objArr[11], objArr[25], objArr[27], objArr[22], objArr[34], objArr[4], objArr[12], objArr[33], objArr[1], objArr[35], objArr[38], objArr[37], objArr[36], objArr[17], objArr[21], objArr[31], objArr[28], objArr[14], objArr[6], objArr[30], objArr[32], objArr[15], objArr[29], objArr[8], objArr[7]);
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
