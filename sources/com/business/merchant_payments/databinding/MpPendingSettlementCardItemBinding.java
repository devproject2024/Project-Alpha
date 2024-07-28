package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.settlement.model.PendingSettlementCardModel;

public abstract class MpPendingSettlementCardItemBinding extends ViewDataBinding {
    public PendingSettlementCardModel mModel;
    public final ConstraintLayout pendingCard;
    public final AppCompatTextView pendingCardHeader;
    public final AppCompatTextView pendingCardSummary;

    public abstract void setModel(PendingSettlementCardModel pendingSettlementCardModel);

    public MpPendingSettlementCardItemBinding(Object obj, View view, int i2, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i2);
        this.pendingCard = constraintLayout;
        this.pendingCardHeader = appCompatTextView;
        this.pendingCardSummary = appCompatTextView2;
    }

    public PendingSettlementCardModel getModel() {
        return this.mModel;
    }

    public static MpPendingSettlementCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpPendingSettlementCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpPendingSettlementCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_pending_settlement_card_item, viewGroup, z, obj);
    }

    public static MpPendingSettlementCardItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpPendingSettlementCardItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpPendingSettlementCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_pending_settlement_card_item, (ViewGroup) null, false, obj);
    }

    public static MpPendingSettlementCardItemBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpPendingSettlementCardItemBinding bind(View view, Object obj) {
        return (MpPendingSettlementCardItemBinding) ViewDataBinding.bind(obj, view, R.layout.mp_pending_settlement_card_item);
    }
}
