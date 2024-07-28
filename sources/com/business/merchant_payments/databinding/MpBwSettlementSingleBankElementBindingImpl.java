package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;

public class MpBwSettlementSingleBankElementBindingImpl extends MpBwSettlementSingleBankElementBinding {
    public static final ViewDataBinding.b sIncludes;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;

    public boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(30);
        sIncludes = bVar;
        bVar.a(0, new String[]{"mp_pending_settlement_card_item"}, new int[]{1}, new int[]{R.layout.mp_pending_settlement_card_item});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bwSettlementDateHeader, 2);
        sViewsWithIds.put(R.id.bwSettlementElementSubHeader, 3);
        sViewsWithIds.put(R.id.bwMultipleAccountText, 4);
        sViewsWithIds.put(R.id.bwSettlementToLabel, 5);
        sViewsWithIds.put(R.id.bwSettlementMultiBankLogo, 6);
        sViewsWithIds.put(R.id.bwSettlementMultiBankAccountNumber, 7);
        sViewsWithIds.put(R.id.bwSettlementStatusIcon, 8);
        sViewsWithIds.put(R.id.bwSettlementTotalAmount, 9);
        sViewsWithIds.put(R.id.bwSettlementArrow, 10);
        sViewsWithIds.put(R.id.bwSettlementMultiBankName, 11);
        sViewsWithIds.put(R.id.bwFailedSettlementText, 12);
        sViewsWithIds.put(R.id.bwPendingSettlementText, 13);
        sViewsWithIds.put(R.id.bwSettlementElementContactUsPending, 14);
        sViewsWithIds.put(R.id.contactUsClickableText, 15);
        sViewsWithIds.put(R.id.bwSettlementDetailContainer, 16);
        sViewsWithIds.put(R.id.bwSettlementDetailsHeaderText, 17);
        sViewsWithIds.put(R.id.tv_view_all, 18);
        sViewsWithIds.put(R.id.bwSettlementAmountDetailsContainer, 19);
        sViewsWithIds.put(R.id.bwSettlementAmountDetailHeader, 20);
        sViewsWithIds.put(R.id.bwSettlementAmountTopDivider, 21);
        sViewsWithIds.put(R.id.bwSettlementAmountBottomDivider, 22);
        sViewsWithIds.put(R.id.bwSettlementOverallAmountContainer, 23);
        sViewsWithIds.put(R.id.bwSettlementOverAllAmountText, 24);
        sViewsWithIds.put(R.id.bwSettlementOverAllAmountData, 25);
        sViewsWithIds.put(R.id.bwSettlementSingleBankListItemDetailContainer, 26);
        sViewsWithIds.put(R.id.bwSingleBankSettlementStatusImage, 27);
        sViewsWithIds.put(R.id.bwSingleBankSettlementTimeText, 28);
        sViewsWithIds.put(R.id.bwSingleBankSettlementUTRText, 29);
    }

    public MpBwSettlementSingleBankElementBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 30, sIncludes, sViewsWithIds));
    }

    public MpBwSettlementSingleBankElementBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[12], objArr[4], objArr[13], objArr[22], objArr[20], objArr[19], objArr[21], objArr[10], objArr[2], objArr[16], objArr[17], objArr[14], objArr[0], objArr[3], objArr[7], objArr[6], objArr[11], objArr[25], objArr[24], objArr[23], objArr[26], objArr[8], objArr[5], objArr[9], objArr[27], objArr[28], objArr[29], objArr[15], objArr[1], objArr[18]);
        this.mDirtyFlags = -1;
        this.bwSettlementElementRoot.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
        }
        this.pendingSettlementCard.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.pendingSettlementCard.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.mDirtyFlags     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            com.business.merchant_payments.databinding.MpPendingSettlementCardItemBinding r0 = r6.pendingSettlementCard
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpBwSettlementSingleBankElementBindingImpl.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.pendingSettlementCard.setLifecycleOwner(qVar);
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return onChangePendingSettlementCard((MpPendingSettlementCardItemBinding) obj, i3);
    }

    private boolean onChangePendingSettlementCard(MpPendingSettlementCardItemBinding mpPendingSettlementCardItemBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
        ViewDataBinding.executeBindingsOn(this.pendingSettlementCard);
    }
}
