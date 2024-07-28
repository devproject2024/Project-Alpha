package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.R;

public class MpOnlineSettlementElementBindingImpl extends MpOnlineSettlementElementBinding {
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
        sparseIntArray.put(R.id.online_settlement_date, 1);
        sViewsWithIds.put(R.id.online_settlement_status_text, 2);
        sViewsWithIds.put(R.id.online_settlement_bank_image, 3);
        sViewsWithIds.put(R.id.online_settlement_account_number_text, 4);
        sViewsWithIds.put(R.id.online_settlement_status_image, 5);
        sViewsWithIds.put(R.id.online_settlement_amount, 6);
        sViewsWithIds.put(R.id.online_settlement_arrow, 7);
        sViewsWithIds.put(R.id.online_settlement_bank_text, 8);
        sViewsWithIds.put(R.id.online_settlement_pending_text, 9);
        sViewsWithIds.put(R.id.online_pending_message_container, 10);
        sViewsWithIds.put(R.id.online_settlement_in_progress_text, 11);
        sViewsWithIds.put(R.id.online_settlement_pending_contact_us, 12);
        sViewsWithIds.put(R.id.online_settlement_detail_container, 13);
        sViewsWithIds.put(R.id.online_settlement_amount_details_text, 14);
        sViewsWithIds.put(R.id.onlineSettlementDetailDividerTop, 15);
        sViewsWithIds.put(R.id.onlineSettlementDetailDividerBottom, 16);
        sViewsWithIds.put(R.id.settlement_amount_text, 17);
        sViewsWithIds.put(R.id.settlement_amount_value, 18);
        sViewsWithIds.put(R.id.online_settlement_status_image_bottom, 19);
        sViewsWithIds.put(R.id.online_settlement_time_text, 20);
        sViewsWithIds.put(R.id.online_settlement_utr_number, 21);
    }

    public MpOnlineSettlementElementBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 22, sIncludes, sViewsWithIds));
    }

    public MpOnlineSettlementElementBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[10], objArr[4], objArr[6], objArr[14], objArr[7], objArr[3], objArr[8], objArr[1], objArr[13], objArr[16], objArr[15], objArr[11], objArr[12], objArr[9], objArr[5], objArr[19], objArr[2], objArr[20], objArr[21], objArr[17], objArr[18]);
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
