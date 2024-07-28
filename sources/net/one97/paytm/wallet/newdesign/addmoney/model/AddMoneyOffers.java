package net.one97.paytm.wallet.newdesign.addmoney.model;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.Date;
import net.one97.paytm.common.entity.IJRDataModel;

public class AddMoneyOffers extends IJRPaytmDataModel {
    @b(a = "codes")
    private ArrayList<AddMoneyCodeOffers> mOfferCodes;

    public void setOfferCodes(ArrayList<AddMoneyCodeOffers> arrayList) {
        this.mOfferCodes = arrayList;
    }

    public ArrayList<AddMoneyCodeOffers> getOfferCodes() {
        return this.mOfferCodes;
    }

    public static class AddMoneyCodeOffers implements IJRDataModel {
        private String betterOfferText;
        private String deeplink;
        private String errorMesage;
        private boolean isBetterOfferAvailableOnMall;
        private boolean isCouponError;
        private boolean isExpanded;
        private boolean isOfferApplied;
        @b(a = "code")
        private String mCode;
        @b(a = "effective_price")
        private double mEffectivePrice;
        @b(a = "offerText")
        private String mOfferText;
        @b(a = "promo_text")
        private String mPromoText;
        @b(a = "savings")
        private String mSavings;
        @b(a = "terms")
        private String mTerms;
        @b(a = "terms_title")
        private String mTermsTitle;
        @b(a = "valid_upto")
        private String mValidTill;
        private Date mValidUpTo;

        public AddMoneyCodeOffers(String str) {
            setCode(str);
        }

        public String getDeeplink() {
            return this.deeplink;
        }

        public void setDeeplink(String str) {
            this.deeplink = str;
        }

        public String getCode() {
            return this.mCode;
        }

        public String getTermsTitle() {
            return this.mTermsTitle;
        }

        public String getOfferText() {
            return this.mOfferText;
        }

        public void setOfferText(String str) {
            this.mOfferText = str;
        }

        public String getPromoText() {
            return this.mPromoText;
        }

        public String getTerms() {
            return this.mTerms;
        }

        public Date getValidUpTo() {
            return this.mValidUpTo;
        }

        public double getEffectivePrice() {
            return this.mEffectivePrice;
        }

        public String getSavingsPrice() {
            return this.mSavings;
        }

        public String getmValidTill() {
            return this.mValidTill;
        }

        public void setIsOfferApplied(boolean z) {
            this.isOfferApplied = z;
        }

        public boolean isExpanded() {
            return this.isExpanded;
        }

        public void setExpanded(boolean z) {
            this.isExpanded = z;
        }

        public boolean getIsOfferApplied() {
            return this.isOfferApplied;
        }

        public boolean isBetterOfferAvailableOnMall() {
            return this.isBetterOfferAvailableOnMall;
        }

        public String getBetterOfferText() {
            return this.betterOfferText;
        }

        public void setCode(String str) {
            this.mCode = str;
        }

        public void setSavingsPrice(String str) {
            this.mSavings = str;
        }

        public boolean equals(Object obj) {
            String str;
            if (obj == this) {
                return true;
            }
            AddMoneyCodeOffers addMoneyCodeOffers = (AddMoneyCodeOffers) obj;
            String str2 = this.mCode;
            if (str2 == null || (str = addMoneyCodeOffers.mCode) == null || !str2.equals(str)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            String str = this.mCode;
            if (str != null) {
                return str.hashCode();
            }
            return super.hashCode();
        }

        public String toString() {
            return TextUtils.isEmpty(this.mCode) ? super.toString() : this.mCode;
        }

        public boolean isCouponError() {
            return this.isCouponError;
        }

        public void setCouponError(boolean z) {
            this.isCouponError = z;
        }

        public String getErrorMesage() {
            return this.errorMesage;
        }

        public void setErrorMesage(String str) {
            this.errorMesage = str;
        }
    }
}
