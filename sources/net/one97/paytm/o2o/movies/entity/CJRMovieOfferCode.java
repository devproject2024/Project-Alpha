package net.one97.paytm.o2o.movies.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Date;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieOfferCode extends IJRPaytmDataModel implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<CJRMovieOfferCode> CREATOR = new Parcelable.Creator<CJRMovieOfferCode>() {
        public final CJRMovieOfferCode createFromParcel(Parcel parcel) {
            return new CJRMovieOfferCode(parcel);
        }

        public final CJRMovieOfferCode[] newArray(int i2) {
            return new CJRMovieOfferCode[i2];
        }
    };
    private String betterOfferText;
    @b(a = "campaignType")
    public String campaignType;
    private String deeplink;
    public String filters;
    private boolean isBetterOfferAvailableOnMall;
    private boolean isChecked;
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
    @b(a = "offer")
    private CJROffer offer;

    public int describeContents() {
        return 0;
    }

    public CJRMovieOfferCode() {
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

    public CJROffer getOffer() {
        return this.offer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
        r4 = r4.mCode;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof net.one97.paytm.o2o.movies.entity.CJRMovieOfferCode
            r1 = 0
            if (r0 == 0) goto L_0x001a
            r0 = 1
            if (r4 != r3) goto L_0x0009
            return r0
        L_0x0009:
            net.one97.paytm.o2o.movies.entity.CJRMovieOfferCode r4 = (net.one97.paytm.o2o.movies.entity.CJRMovieOfferCode) r4
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.entity.CJRMovieOfferCode.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.mCode;
        return str != null ? str.hashCode() : super.hashCode();
    }

    public String toString() {
        return TextUtils.isEmpty(this.mCode) ? super.toString() : this.mCode;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    protected CJRMovieOfferCode(Parcel parcel) {
        this.mCode = parcel.readString();
        this.mTermsTitle = parcel.readString();
        this.mOfferText = parcel.readString();
        this.mPromoText = parcel.readString();
        this.mTerms = parcel.readString();
        boolean z = true;
        this.isBetterOfferAvailableOnMall = parcel.readByte() != 0;
        this.betterOfferText = parcel.readString();
        this.mEffectivePrice = parcel.readDouble();
        this.mSavings = parcel.readString();
        this.isOfferApplied = parcel.readByte() != 0;
        this.isExpanded = parcel.readByte() == 0 ? false : z;
        this.deeplink = parcel.readString();
        this.mValidTill = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mCode);
        parcel.writeString(this.mTermsTitle);
        parcel.writeString(this.mOfferText);
        parcel.writeString(this.mPromoText);
        parcel.writeString(this.mTerms);
        parcel.writeByte(this.isBetterOfferAvailableOnMall ? (byte) 1 : 0);
        parcel.writeString(this.betterOfferText);
        parcel.writeDouble(this.mEffectivePrice);
        parcel.writeString(this.mSavings);
        parcel.writeByte(this.isOfferApplied ? (byte) 1 : 0);
        parcel.writeByte(this.isExpanded ? (byte) 1 : 0);
        parcel.writeString(this.deeplink);
        parcel.writeString(this.mValidTill);
    }
}
