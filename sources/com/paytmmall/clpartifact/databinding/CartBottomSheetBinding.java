package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.view.viewmodel.CartBottomSheetViewModel;

public abstract class CartBottomSheetBinding extends ViewDataBinding {
    public final View amountPayableDivider;
    public final TextView amountPayableLabel;
    public final TextView amountPayableValue;
    public final TextView cartTotalLabel;
    public final TextView cartTotalValue;
    public final View crossIcon;
    public final Group discountGroup;
    public final Group effectivePriceGroup;
    public final TextView effectivePriceLabel;
    public final TextView effectivePriceValue;
    public final Group exchangeCashbackGroup;
    public final TextView exchangeCashbackLabel;
    public final TextView exchangeCashbackValue;
    public final TextView goldCashbackLabel;
    public final TextView goldCashbackValue;
    public final Group loyalityGoldbackGroup;
    protected CartBottomSheetViewModel mViewModel;
    public final TextView paymentSummaryText;
    public final TextView paytmDiscountLabel;
    public final TextView paytmDiscountValue;
    public final View promocodeCashbackDivider;
    public final Group promocodeCashbackGroup;
    public final TextView promocodeCashbackLabel;
    public final TextView promocodeCashbackValue;
    public final Group shippingChargesGroup;
    public final TextView shippingChargesLabel;
    public final TextView shippingChargesValue;

    public abstract void setViewModel(CartBottomSheetViewModel cartBottomSheetViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected CartBottomSheetBinding(e eVar, View view, int i2, View view2, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view3, Group group, Group group2, TextView textView5, TextView textView6, Group group3, TextView textView7, TextView textView8, TextView textView9, TextView textView10, Group group4, TextView textView11, TextView textView12, TextView textView13, View view4, Group group5, TextView textView14, TextView textView15, Group group6, TextView textView16, TextView textView17) {
        super(eVar, view, i2);
        this.amountPayableDivider = view2;
        this.amountPayableLabel = textView;
        this.amountPayableValue = textView2;
        this.cartTotalLabel = textView3;
        this.cartTotalValue = textView4;
        this.crossIcon = view3;
        this.discountGroup = group;
        this.effectivePriceGroup = group2;
        this.effectivePriceLabel = textView5;
        this.effectivePriceValue = textView6;
        this.exchangeCashbackGroup = group3;
        this.exchangeCashbackLabel = textView7;
        this.exchangeCashbackValue = textView8;
        this.goldCashbackLabel = textView9;
        this.goldCashbackValue = textView10;
        this.loyalityGoldbackGroup = group4;
        this.paymentSummaryText = textView11;
        this.paytmDiscountLabel = textView12;
        this.paytmDiscountValue = textView13;
        this.promocodeCashbackDivider = view4;
        this.promocodeCashbackGroup = group5;
        this.promocodeCashbackLabel = textView14;
        this.promocodeCashbackValue = textView15;
        this.shippingChargesGroup = group6;
        this.shippingChargesLabel = textView16;
        this.shippingChargesValue = textView17;
    }

    public CartBottomSheetViewModel getViewModel() {
        return this.mViewModel;
    }

    public static CartBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static CartBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (CartBottomSheetBinding) f.a(layoutInflater, R.layout.cart_bottom_sheet, viewGroup, z, eVar);
    }

    public static CartBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static CartBottomSheetBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (CartBottomSheetBinding) f.a(layoutInflater, R.layout.cart_bottom_sheet, (ViewGroup) null, false, eVar);
    }

    public static CartBottomSheetBinding bind(View view) {
        return bind(view, f.a());
    }

    public static CartBottomSheetBinding bind(View view, e eVar) {
        return (CartBottomSheetBinding) bind(eVar, view, R.layout.cart_bottom_sheet);
    }
}
