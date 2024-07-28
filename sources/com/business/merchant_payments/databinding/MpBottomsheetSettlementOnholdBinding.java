package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.widget.MpRoboTextView;

public abstract class MpBottomsheetSettlementOnholdBinding extends ViewDataBinding {
    public final MpRoboTextView btnOk;
    public final ImageView ivClose;
    public final ImageView ivWarning;
    public final MpRoboTextView tvHeading;
    public final MpRoboTextView tvSubheading;

    public MpBottomsheetSettlementOnholdBinding(Object obj, View view, int i2, MpRoboTextView mpRoboTextView, ImageView imageView, ImageView imageView2, MpRoboTextView mpRoboTextView2, MpRoboTextView mpRoboTextView3) {
        super(obj, view, i2);
        this.btnOk = mpRoboTextView;
        this.ivClose = imageView;
        this.ivWarning = imageView2;
        this.tvHeading = mpRoboTextView2;
        this.tvSubheading = mpRoboTextView3;
    }

    public static MpBottomsheetSettlementOnholdBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpBottomsheetSettlementOnholdBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpBottomsheetSettlementOnholdBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_bottomsheet_settlement_onhold, viewGroup, z, obj);
    }

    public static MpBottomsheetSettlementOnholdBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpBottomsheetSettlementOnholdBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpBottomsheetSettlementOnholdBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_bottomsheet_settlement_onhold, (ViewGroup) null, false, obj);
    }

    public static MpBottomsheetSettlementOnholdBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpBottomsheetSettlementOnholdBinding bind(View view, Object obj) {
        return (MpBottomsheetSettlementOnholdBinding) ViewDataBinding.bind(obj, view, R.layout.mp_bottomsheet_settlement_onhold);
    }
}
