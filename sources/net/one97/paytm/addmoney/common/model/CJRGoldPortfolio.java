package net.one97.paytm.addmoney.common.model;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRGoldPortfolio implements IJRDataModel {
    @b(a = "customer_balance")
    private String customerBalance;
    @b(a = "customer_name")
    private String customerName;
    @b(a = "customer_pincode")
    private String customerPincode;
    @b(a = "error")
    private String error;
    @b(a = "gold_buy_price")
    private String goldBuyPrice;
    @b(a = "is_new_customer")
    private Boolean isNewCustomer;
    @b(a = "kyc_status")
    private String kycStatus;
    @b(a = "maximum_limit_for_pay_with_gold")
    private Integer maximumLimitForPayWithGold;
    @b(a = "merchant_name")
    private String merchantName;
    @b(a = "minimum_limit_for_pay_with_gold")
    private Integer minimumLimitForPayWithGold;
    @b(a = "net_worth")
    private String netWorth;

    public Boolean getIsNewCustomer() {
        return this.isNewCustomer;
    }

    public void setIsNewCustomer(Boolean bool) {
        this.isNewCustomer = bool;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String str) {
        this.customerName = str;
    }

    public String getKycStatus() {
        return this.kycStatus;
    }

    public void setKycStatus(String str) {
        this.kycStatus = str;
    }

    public String getCustomerPincode() {
        return this.customerPincode;
    }

    public void setCustomerPincode(String str) {
        this.customerPincode = str;
    }

    public String getCustomerBalance() {
        if (TextUtils.isEmpty(this.customerBalance)) {
            this.customerBalance = "0";
        }
        return this.customerBalance;
    }

    public void setCustomerBalance(String str) {
        this.customerBalance = str;
    }

    public String getNetWorth() {
        if (TextUtils.isEmpty(this.netWorth)) {
            this.netWorth = "0";
        }
        return this.netWorth;
    }

    public void setNetWorth(String str) {
        this.netWorth = str;
    }

    public String getGoldBuyPrice() {
        if (TextUtils.isEmpty(this.goldBuyPrice)) {
            this.goldBuyPrice = "0";
        }
        return this.goldBuyPrice;
    }

    public void setGoldBuyPrice(String str) {
        this.goldBuyPrice = str;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public int getMinimumLimitForPayWithGold() {
        if (this.minimumLimitForPayWithGold == null) {
            this.minimumLimitForPayWithGold = 1;
        }
        return this.minimumLimitForPayWithGold.intValue();
    }

    public void setMinimumLimitForPayWithGold(Integer num) {
        this.minimumLimitForPayWithGold = num;
    }

    public Integer getMaximumLimitForPayWithGold() {
        if (this.maximumLimitForPayWithGold == null) {
            this.maximumLimitForPayWithGold = 25000;
        }
        return this.maximumLimitForPayWithGold;
    }

    public void setMaximumLimitForPayWithGold(Integer num) {
        this.maximumLimitForPayWithGold = num;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String str) {
        this.error = str;
    }
}
