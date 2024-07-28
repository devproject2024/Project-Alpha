package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.view.viewmodel.CartBottomSheetViewModel;

public class CartBottomSheetBindingImpl extends CartBottomSheetBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.crossIcon, 16);
        sViewsWithIds.put(R.id.payment_summary_text, 17);
        sViewsWithIds.put(R.id.cart_total_label, 18);
        sViewsWithIds.put(R.id.paytm_discount_label, 19);
        sViewsWithIds.put(R.id.amount_payable_label, 20);
        sViewsWithIds.put(R.id.amount_payable_divider, 21);
        sViewsWithIds.put(R.id.exchange_cashback_label, 22);
        sViewsWithIds.put(R.id.promocode_cashback_label, 23);
        sViewsWithIds.put(R.id.gold_cashback_label, 24);
        sViewsWithIds.put(R.id.promocode_cashback_divider, 25);
        sViewsWithIds.put(R.id.effective_price_label, 26);
    }

    public CartBottomSheetBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 27, sIncludes, sViewsWithIds));
    }

    private CartBottomSheetBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[21], objArr[20], objArr[5], objArr[18], objArr[1], objArr[16], objArr[11], objArr[15], objArr[26], objArr[9], objArr[12], objArr[22], objArr[6], objArr[24], objArr[8], objArr[14], objArr[17], objArr[19], objArr[4], objArr[25], objArr[13], objArr[23], objArr[7], objArr[10], objArr[2], objArr[3]);
        this.mDirtyFlags = -1;
        this.amountPayableValue.setTag((Object) null);
        this.cartTotalValue.setTag((Object) null);
        this.discountGroup.setTag((Object) null);
        this.effectivePriceGroup.setTag((Object) null);
        this.effectivePriceValue.setTag((Object) null);
        this.exchangeCashbackGroup.setTag((Object) null);
        this.exchangeCashbackValue.setTag((Object) null);
        this.goldCashbackValue.setTag((Object) null);
        this.loyalityGoldbackGroup.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.paytmDiscountValue.setTag((Object) null);
        this.promocodeCashbackGroup.setTag((Object) null);
        this.promocodeCashbackValue.setTag((Object) null);
        this.shippingChargesGroup.setTag((Object) null);
        this.shippingChargesLabel.setTag((Object) null);
        this.shippingChargesValue.setTag((Object) null);
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
        if (BR.viewModel != i2) {
            return false;
        }
        setViewModel((CartBottomSheetViewModel) obj);
        return true;
    }

    public void setViewModel(CartBottomSheetViewModel cartBottomSheetViewModel) {
        this.mViewModel = cartBottomSheetViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    public void executeBindings() {
        long j;
        int i2;
        String str;
        String str2;
        int i3;
        String str3;
        int i4;
        String str4;
        int i5;
        int i6;
        String str5;
        String str6;
        int i7;
        String str7;
        String str8;
        String str9;
        String str10;
        boolean z;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        boolean z2;
        boolean z3;
        int i8;
        boolean z4;
        boolean z5;
        boolean z6;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CartBottomSheetViewModel cartBottomSheetViewModel = this.mViewModel;
        String str16 = null;
        int i9 = 0;
        int i10 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i10 != 0) {
            if (cartBottomSheetViewModel != null) {
                str16 = cartBottomSheetViewModel.getShippingTitle();
                str7 = cartBottomSheetViewModel.getFinalPrice();
                z5 = cartBottomSheetViewModel.showExchangeCashback();
                z4 = cartBottomSheetViewModel.showEffectivePrice();
                i8 = cartBottomSheetViewModel.getShippingChargesValueColor();
                z3 = cartBottomSheetViewModel.showPaytmDiscount();
                z2 = cartBottomSheetViewModel.showPromoCashback();
                str15 = cartBottomSheetViewModel.getExchangeAmount();
                str14 = cartBottomSheetViewModel.getEffectivePrice();
                str13 = cartBottomSheetViewModel.getShippingCharges();
                str12 = cartBottomSheetViewModel.getAggregateItemPrice();
                str11 = cartBottomSheetViewModel.getPromoCashback();
                z = cartBottomSheetViewModel.showShippingCharges();
                str10 = cartBottomSheetViewModel.getPaytmDiscount();
                str9 = cartBottomSheetViewModel.getLoyalityGoldback();
                z6 = cartBottomSheetViewModel.showGoldCashback();
            } else {
                str7 = null;
                str15 = null;
                str14 = null;
                str13 = null;
                str12 = null;
                str11 = null;
                str10 = null;
                str9 = null;
                z6 = false;
                z5 = false;
                z4 = false;
                i8 = 0;
                z3 = false;
                z2 = false;
                z = false;
            }
            if (i10 != 0) {
                j |= z5 ? 32 : 16;
            }
            if ((j & 3) != 0) {
                j |= z4 ? 2048 : 1024;
            }
            if ((j & 3) != 0) {
                j |= z3 ? 8192 : 4096;
            }
            if ((j & 3) != 0) {
                j |= z2 ? 512 : 256;
            }
            if ((j & 3) != 0) {
                j |= z ? 8 : 4;
            }
            if ((j & 3) != 0) {
                j |= z6 ? 128 : 64;
            }
            i7 = z5 ? 0 : 8;
            int i11 = z4 ? 0 : 8;
            i5 = z3 ? 0 : 8;
            int i12 = z2 ? 0 : 8;
            int i13 = z ? 0 : 8;
            if (!z6) {
                i9 = 8;
            }
            str2 = str16;
            i2 = i8;
            i4 = i12;
            str6 = str15;
            str8 = str14;
            str = str13;
            str16 = str12;
            str3 = str11;
            i3 = i13;
            str4 = str10;
            i6 = i9;
            i9 = i11;
            str5 = str9;
        } else {
            str8 = null;
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i7 = 0;
            i6 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
        }
        if ((j & 3) != 0) {
            d.a(this.amountPayableValue, (CharSequence) str7);
            d.a(this.cartTotalValue, (CharSequence) str16);
            this.discountGroup.setVisibility(i5);
            this.effectivePriceGroup.setVisibility(i9);
            d.a(this.effectivePriceValue, (CharSequence) str8);
            this.exchangeCashbackGroup.setVisibility(i7);
            d.a(this.exchangeCashbackValue, (CharSequence) str6);
            d.a(this.goldCashbackValue, (CharSequence) str5);
            this.loyalityGoldbackGroup.setVisibility(i6);
            d.a(this.paytmDiscountValue, (CharSequence) str4);
            this.promocodeCashbackGroup.setVisibility(i4);
            d.a(this.promocodeCashbackValue, (CharSequence) str3);
            this.shippingChargesGroup.setVisibility(i3);
            d.a(this.shippingChargesLabel, (CharSequence) str2);
            d.a(this.shippingChargesValue, (CharSequence) str);
            this.shippingChargesValue.setTextColor(i2);
        }
    }
}
