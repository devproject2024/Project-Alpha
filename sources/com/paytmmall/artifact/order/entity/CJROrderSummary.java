package com.paytmmall.artifact.order.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.artifact.cart.entity.CJRAddress;
import com.paytmmall.artifact.cart.entity.CJRReverseItemInfo;
import com.paytmmall.artifact.common.entity.CJRStatusError;
import java.util.ArrayList;
import java.util.Iterator;

public class CJROrderSummary extends IJRPaytmDataModel {
    public static final int ORDER_STATUS_CANCELED = 8;
    public static final int ORDER_STATUS_FAILED = 4;
    public static final int ORDER_STATUS_PENDING_1 = 1;
    public static final int ORDER_STATUS_PENDING_2 = 3;
    public static final int ORDER_STATUS_SUCCESS = 2;
    private static final long serialVersionUID = 1;
    @b(a = "cashback_label")
    private String cashBackLabel;
    @b(a = "cashback_text")
    private String cashBackText;
    @b(a = "exchangeSubtitle")
    private String exchangeSubtitle;
    @b(a = "exchangeText")
    private String exchangeText;
    @b(a = "exchangeTitle")
    private String exchangeTitle;
    @b(a = "express_checkout_text")
    private String expressCheckoutText;
    @b(a = "has_lifafa")
    private boolean hasLifafa;
    @b(a = "isExchangeOrder")
    private int isExchangeForwardItem;
    @b(a = "isZeroEMIOrder")
    private int isZeroEMIOrder;
    @b(a = "get_lifafa_url")
    private String lifafaURL;
    @b(a = "aggregate_item_price")
    private String mAggregateItemPrice;
    @b(a = "amount_bfr_tax")
    private double mAmountBfrTax;
    @b(a = "banner")
    private CJROrdersummaryReferral mBanner;
    @b(a = "billing_address")
    private CJROrderSummaryAddress mBillingAddress;
    @b(a = "channel_id")
    private String mChannelId;
    @b(a = "total_conv_fee")
    private double mConFee;
    @b(a = "conv_fee")
    private double mConvFee;
    @b(a = "created_at")
    private String mCreatedAt;
    @b(a = "customer_email")
    private String mCustomerEmail;
    @b(a = "customer_firstname")
    private String mCustomerFirstName;
    @b(a = "customer_lastname")
    private String mCustomerLastName;
    @b(a = "customer_middlename")
    private String mCustomerMiddleName;
    @b(a = "customer_type")
    private String mCustomerType;
    @b(a = "discount_amount")
    private double mDiscountAmount;
    @b(a = "discount_surcharge_amount")
    private double mDiscountSurchargeAmount;
    @b(a = "discount_tax_amount")
    private double mDiscountTaxAmount;
    @b(a = "error")
    private CJRStatusError mError;
    @b(a = "footer")
    private CJROrdersummaryFooter mFooter;
    @b(a = "grandtotal")
    private double mGrandTotal;
    @b(a = "id")
    private String mId;
    @b(a = "label")
    private String mLabel;
    @b(a = "lifafa")
    private CJRLifafa mLifafa;
    @b(a = "need_shipping")
    private boolean mNeedShipping;
    @b(a = "order_discount")
    private double mOrderDiscount;
    @b(a = "items")
    private ArrayList<CJROrderedCart> mOrderedCartList;
    @b(a = "payments")
    private ArrayList<CJROrderSummaryPayment> mPaymentInfo;
    @b(a = "payment_status")
    private String mPaymentStatus;
    @b(a = "payment_summary")
    private String mPaymentSummary;
    @b(a = "payment_text")
    private String mPaymentText;
    @b(a = "promo_code")
    private String mPromoCode;
    @b(a = "promo_description")
    private String mPromoDescription;
    @b(a = "refund")
    private CJROrderSummaryRefundToBank mRefundToBank;
    @b(a = "remote_ip")
    private String mRemoteIP;
    @b(a = "result")
    private String mResult;
    @b(a = "shipping_address")
    private CJRAddress mShippingAddress;
    @b(a = "shipping_amount")
    private double mShippingAmount;
    @b(a = "shipping_description")
    private String mShippingDescription;
    @b(a = "shipping_method")
    private String mShippingMethod;
    @b(a = "shipping_tax_amount")
    private double mShippingTaxAmount;
    @b(a = "status")
    private String mStatus;
    @b(a = "status_icon")
    private String mStatusIcon;
    @b(a = "subtotal")
    private double mSubTotal;
    @b(a = "subtotal_incl_tax")
    private double mSubTotalInclTax;
    @b(a = "surcharge_amount")
    private double mSurChargeAmount;
    @b(a = "tax_amount")
    private double mTaxAmount;
    @b(a = "transaction_details")
    private ArrayList<CJROrderSummaryTransaction> mTransactionDetails;
    private String movieImageText;
    @b(a = "order_status")
    private int orderStatus;
    @b(a = "product_promise_logo_url")
    private String ppLogoUrl;
    private String qrBitmapText;
    @b(a = "refund_source_text")
    private String refundSourceText;
    @b(a = "reverseItemInfo")
    private CJRReverseItemInfo reverseItemInfo;
    @b(a = "total_cashback")
    private String totalCashBack;
    @b(a = "total_exchange_cashback")
    private String totalExchangeCashback;
    @b(a = "total_markup_amount")
    private String totalMarkupAmount;
    @b(a = "total_zero_emi_cashback")
    private int zeroEMICashback;
    @b(a = "zero_emi_cashback_text")
    private String zeroEMICashbackText;
    @b(a = "zero_emi_cashback_title")
    private String zeroEMICashbackTitle;

    public String getmStatusIcon() {
        return this.mStatusIcon;
    }

    public void setmStatusIcon(String str) {
        this.mStatusIcon = str;
    }

    public double getmConFee() {
        return this.mConFee;
    }

    public void setmConFee(double d2) {
        this.mConFee = d2;
    }

    public int getOrderStatus() {
        return this.orderStatus;
    }

    public String getPpLogoUrl() {
        return this.ppLogoUrl;
    }

    public ArrayList<CJROrderSummaryTransaction> getTransactionDetails() {
        return this.mTransactionDetails;
    }

    public String getZeroEMICashbackTitle() {
        return this.zeroEMICashbackTitle;
    }

    public String getZeroEMICashbackText() {
        return this.zeroEMICashbackText;
    }

    public int getZeroEMICashback() {
        return this.zeroEMICashback;
    }

    public int getIsZeroEMIOrder() {
        return this.isZeroEMIOrder;
    }

    public String getTotalExchangeCashback() {
        return this.totalExchangeCashback;
    }

    public String getExchangeText() {
        return this.exchangeText;
    }

    public String getExchangeSubtitle() {
        return this.exchangeSubtitle;
    }

    public String getTotalMarkupAmount() {
        return this.totalMarkupAmount;
    }

    public String getExchangeTitle() {
        return this.exchangeTitle;
    }

    public int getIsExchangeForwardItem() {
        return this.isExchangeForwardItem;
    }

    public CJRReverseItemInfo getReverseItemInfo() {
        return this.reverseItemInfo;
    }

    public String getCashBackText() {
        return this.cashBackText;
    }

    public String getTotalCashback() {
        return this.totalCashBack;
    }

    public String getCashBackLabel() {
        return this.cashBackLabel;
    }

    public String getExpressCheckoutText() {
        return this.expressCheckoutText;
    }

    public String getLifafaURL() {
        return this.lifafaURL;
    }

    public boolean getHasLifafa() {
        return this.hasLifafa;
    }

    public CJROrdersummaryReferral getBanner() {
        return this.mBanner;
    }

    public CJRStatusError getError() {
        return this.mError;
    }

    public CJROrdersummaryFooter getFooter() {
        return this.mFooter;
    }

    public String getPaymentStatus() {
        return this.mPaymentStatus;
    }

    public void setPaymentStatus(String str) {
        this.mPaymentStatus = str;
    }

    public boolean getNeedShipping() {
        return this.mNeedShipping;
    }

    public double getOrderDiscount() {
        return this.mOrderDiscount;
    }

    public String getPaymentSummary() {
        return this.mPaymentSummary;
    }

    public void setPaymentSummary(String str) {
        this.mPaymentSummary = str;
    }

    public String getResult() {
        return this.mResult;
    }

    public ArrayList<CJROrderedCart> getOrderedCartList() {
        return this.mOrderedCartList;
    }

    public CJROrderSummaryAddress getBillingAddress() {
        return this.mBillingAddress;
    }

    public CJRAddress getShippingAddress() {
        return this.mShippingAddress;
    }

    public ArrayList<CJROrderSummaryPayment> getPaymentInfo() {
        return this.mPaymentInfo;
    }

    public String getId() {
        return this.mId;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public void setStatus(String str) {
        this.mStatus = str;
    }

    public String getPromoCode() {
        return this.mPromoCode;
    }

    public String getPromoDescription() {
        return this.mPromoDescription;
    }

    public String getShippingMethod() {
        return this.mShippingMethod;
    }

    public String getShippingDescription() {
        return this.mShippingDescription;
    }

    public String getCustomerEmail() {
        return this.mCustomerEmail;
    }

    public String getCustomerFirstName() {
        return this.mCustomerFirstName;
    }

    public String getCustomerLastName() {
        return this.mCustomerLastName;
    }

    public String getCustomerMiddleName() {
        return this.mCustomerMiddleName;
    }

    public String getCustomerType() {
        return this.mCustomerType;
    }

    public String getRemoteIP() {
        return this.mRemoteIP;
    }

    public String getCreatedAt() {
        return this.mCreatedAt;
    }

    public double getDiscountAmount() {
        return this.mDiscountAmount;
    }

    public double getDiscountTaxAmount() {
        return this.mDiscountTaxAmount;
    }

    public double getDiscountSurchargeAmount() {
        return this.mDiscountSurchargeAmount;
    }

    public double getShippingAmount() {
        return this.mShippingAmount;
    }

    public double getShippingTaxAmount() {
        return this.mShippingTaxAmount;
    }

    public double getSubTotal() {
        return this.mSubTotal;
    }

    public double getSubTotalInclTax() {
        return this.mSubTotalInclTax;
    }

    public double getAmountBfrTax() {
        return this.mAmountBfrTax;
    }

    public double getTaxAmount() {
        return this.mTaxAmount;
    }

    public double getSurChargeAmount() {
        return this.mSurChargeAmount;
    }

    public double getGrandTotal() {
        return this.mGrandTotal;
    }

    public String getPaymentText() {
        return this.mPaymentText;
    }

    public String getChannelId() {
        return this.mChannelId;
    }

    public CJROrderSummaryRefundToBank getRefund() {
        return this.mRefundToBank;
    }

    public boolean checkPaymentMethod(String str) {
        Iterator<CJROrderSummaryPayment> it2 = this.mPaymentInfo.iterator();
        while (it2.hasNext()) {
            if (it2.next().getPaymentMethod().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public String getPaymentMethodForGA() {
        StringBuilder sb = new StringBuilder();
        ArrayList<CJROrderSummaryPayment> arrayList = this.mPaymentInfo;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<CJROrderSummaryPayment> it2 = this.mPaymentInfo.iterator();
            while (it2.hasNext()) {
                sb.append(it2.next().getPaymentMethod());
                if (it2.hasNext()) {
                    sb.append(" | ");
                }
            }
        }
        return sb.toString();
    }

    public String getShippingAndBillingAddressForGA() {
        StringBuilder sb = new StringBuilder();
        CJRAddress cJRAddress = this.mShippingAddress;
        if (!(cJRAddress == null || cJRAddress.getCity() == null)) {
            sb.append(this.mShippingAddress.getCity());
            sb.append(" | ");
            sb.append(this.mBillingAddress.getCity());
        }
        return sb.toString();
    }

    public double getConvFee() {
        return this.mConvFee;
    }

    public String getAggregateItemPrice() {
        return this.mAggregateItemPrice;
    }

    public String getQrBitmapText() {
        return this.qrBitmapText;
    }

    public void setQrBitmapText(String str) {
        this.qrBitmapText = str;
    }

    public String getMovieImageText() {
        return this.movieImageText;
    }

    public void setMovieImageText(String str) {
        this.movieImageText = str;
    }

    public void setmPaymentStatus(String str) {
        this.mPaymentStatus = str;
    }

    public CJRLifafa getmLifafa() {
        return this.mLifafa;
    }

    public void setmLifafa(CJRLifafa cJRLifafa) {
        this.mLifafa = cJRLifafa;
    }

    public String getRefundSourceText() {
        return this.refundSourceText;
    }
}
