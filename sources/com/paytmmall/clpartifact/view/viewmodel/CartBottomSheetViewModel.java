package com.paytmmall.clpartifact.view.viewmodel;

import android.app.Application;
import android.graphics.Color;
import androidx.lifecycle.a;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CartUtils;
import com.paytmmall.clpartifact.common.StringUtils;
import com.paytmmall.clpartifact.modal.cart.CJRCart;
import com.paytmmall.clpartifact.modal.cart.CJRCartItem;
import java.util.Iterator;

public class CartBottomSheetViewModel extends a {
    private double exchangeAmount = getExchangeDoubleAmount();
    private boolean isHybridCart = isHybridCart();
    private CJRCart mCart = CartUtils.getCartCache();

    private boolean isCarNBike(long j) {
        return j == 49 || j == 118;
    }

    public CartBottomSheetViewModel(Application application) {
        super(application);
    }

    private boolean isHybridCart() {
        Iterator<CJRCartItem> it2 = this.mCart.getCartItems().iterator();
        boolean z = false;
        while (it2.hasNext()) {
            CJRCartItem next = it2.next();
            boolean isCarNBike = isCarNBike(next.getVerticalId());
            if (isCarNBike) {
                z = true;
            }
            if (next.isNeedShipping() && !isCarNBike) {
                return false;
            }
        }
        return z;
    }

    public String getShippingTitle() {
        return getApplication().getString(this.isHybridCart ? R.string.convenience_fee : R.string.shipping_charges);
    }

    public String getAggregateItemPrice() {
        return StringUtils.getRupeesFormat(String.valueOf(this.mCart.getAggregateItemPrice()));
    }

    public String getShippingCharges() {
        Double totalShippingCharges = this.mCart.getTotalShippingCharges();
        return (totalShippingCharges == null || totalShippingCharges.doubleValue() == 0.0d) ? getApplication().getString(R.string.free) : StringUtils.getRupeesFormat(String.valueOf(totalShippingCharges));
    }

    public String getPaytmDiscount() {
        return StringUtils.getRupeesFormat(String.valueOf(this.mCart.getPaytmDiscount()));
    }

    public String getFinalPrice() {
        return StringUtils.getRupeesFormat(String.valueOf(this.mCart.getFinalPrice()));
    }

    public String getPromoCashback() {
        return StringUtils.getRupeesFormat(String.valueOf(this.mCart.getPaytmCashback()));
    }

    public String getLoyalityGoldback() {
        return StringUtils.getRupeesFormat(String.valueOf(this.mCart.getPaytmGoldCashback()));
    }

    public String getEffectivePrice() {
        return StringUtils.getRupeesFormat(String.valueOf(this.mCart.getEffectivePrice()));
    }

    public String getExchangeAmount() {
        return StringUtils.getRupeesFormat(String.valueOf(this.exchangeAmount));
    }

    private double getExchangeAmount(CJRCartItem cJRCartItem) {
        try {
            return cJRCartItem.getExchange().getQuoteTotalAmount();
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    private double getExchangeDoubleAmount() {
        Iterator<CJRCartItem> it2 = this.mCart.getCartItems().iterator();
        double d2 = 0.0d;
        while (it2.hasNext()) {
            d2 += getExchangeAmount(it2.next());
        }
        return d2;
    }

    public int getShippingChargesValueColor() {
        return Color.parseColor(isShippingFree() ? "#26d07c" : "#1d252d");
    }

    private boolean isShippingFree() {
        return this.mCart.getTotalShippingCharges() == null || this.mCart.getTotalShippingCharges().doubleValue() == 0.0d;
    }

    public String getItemLabel() {
        int size = this.mCart.getCartItems().size();
        return String.format(getApplication().getResources().getQuantityString(R.plurals.cart_item, size), new Object[]{Integer.valueOf(size)});
    }

    public boolean showShippingCharges() {
        return this.mCart.getTotalShippingCharges() != null;
    }

    public boolean showPaytmDiscount() {
        return this.mCart.getPaytmDiscount() >= 1.0d;
    }

    public boolean showExchangeCashback() {
        return this.exchangeAmount >= 1.0d;
    }

    public boolean showPromoCashback() {
        return this.mCart.getPaytmCashback() >= 1.0d;
    }

    public boolean showGoldCashback() {
        return this.mCart.getPaytmGoldCashback() >= 1.0d;
    }

    public boolean showEffectivePrice() {
        return this.mCart.getEffectivePrice() >= 1.0d;
    }
}
