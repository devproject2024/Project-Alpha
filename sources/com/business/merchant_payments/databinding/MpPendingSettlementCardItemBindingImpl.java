package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.settlement.model.PendingSettlementCardModel;

public class MpPendingSettlementCardItemBindingImpl extends MpPendingSettlementCardItemBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds = null;
    public long mDirtyFlags;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public MpPendingSettlementCardItemBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 3, sIncludes, sViewsWithIds));
    }

    public MpPendingSettlementCardItemBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[0], objArr[1], objArr[2]);
        this.mDirtyFlags = -1;
        this.pendingCard.setTag((Object) null);
        this.pendingCardHeader.setTag((Object) null);
        this.pendingCardSummary.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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

    public boolean setVariable(int i2, Object obj) {
        if (BR.model != i2) {
            return false;
        }
        setModel((PendingSettlementCardModel) obj);
        return true;
    }

    public void setModel(PendingSettlementCardModel pendingSettlementCardModel) {
        this.mModel = pendingSettlementCardModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    public void executeBindings() {
        long j;
        String str;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        PendingSettlementCardModel pendingSettlementCardModel = this.mModel;
        int i2 = 0;
        String str2 = null;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (pendingSettlementCardModel != null) {
                String summary = pendingSettlementCardModel.getSummary();
                z = pendingSettlementCardModel.isCardVisible();
                str = pendingSettlementCardModel.getHeader();
                str2 = summary;
            } else {
                str = null;
                z = false;
            }
            if (i3 != 0) {
                j |= z ? 8 : 4;
            }
            if (!z) {
                i2 = 8;
            }
        } else {
            str = null;
        }
        if ((j & 3) != 0) {
            this.pendingCard.setVisibility(i2);
            d.a((TextView) this.pendingCardHeader, (CharSequence) str);
            d.a((TextView) this.pendingCardSummary, (CharSequence) str2);
        }
    }
}
