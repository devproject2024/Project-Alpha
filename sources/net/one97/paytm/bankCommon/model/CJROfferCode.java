package net.one97.paytm.bankCommon.model;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import java.util.Date;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROfferCode implements IJRDataModel {
    private String betterOfferText;
    private String deeplink;
    private boolean isBetterOfferAvailableOnMall;
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

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
        r4 = r4.mCode;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof net.one97.paytm.bankCommon.model.CJROfferCode
            r1 = 0
            if (r0 == 0) goto L_0x001a
            r0 = 1
            if (r4 != r3) goto L_0x0009
            return r0
        L_0x0009:
            net.one97.paytm.bankCommon.model.CJROfferCode r4 = (net.one97.paytm.bankCommon.model.CJROfferCode) r4
            java.lang.String r2 = r3.mCode
            if (r2 == 0) goto L_0x001a
            java.lang.String r4 = r4.mCode
            if (r4 == 0) goto L_0x001a
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x001a
            return r0
        L_0x001a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.bankCommon.model.CJROfferCode.equals(java.lang.Object):boolean");
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
}
