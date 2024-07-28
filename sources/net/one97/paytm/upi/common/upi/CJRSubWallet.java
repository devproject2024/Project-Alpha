package net.one97.paytm.upi.common.upi;

import android.text.TextUtils;
import com.google.gson.a.c;
import com.google.gson.f;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class CJRSubWallet implements UpiBaseDataModel {
    private static final long serialVersionUID = 1;
    @c(a = "issuedOn")
    private String issuedOn;
    @c(a = "accountNumber")
    private String mAccountNumber;
    @c(a = "balance")
    private double mBalance;
    @c(a = "displayName")
    private String mDisplayName;
    @c(a = "expiry")
    private String mExpiry;
    @c(a = "id")
    private int mId;
    @c(a = "imageUrl")
    private String mImageUrl;
    @c(a = "issuerMetadata")
    private String mIssuerMetadata;
    private String mMetaData;
    private String mSubTitle;
    @c(a = "subWalletType")
    private int mSubWalletType;
    @c(a = "walletType")
    private String mWalletType;
    @c(a = "subWalletName")
    private String subWalletName;
    private Object tag;

    public String getAccountNumber() {
        return this.mAccountNumber;
    }

    public void setAccountNumber(String str) {
        this.mAccountNumber = str;
    }

    public int getId() {
        return this.mId;
    }

    public void setId(int i2) {
        this.mId = i2;
    }

    public String getDisplayName() {
        return this.mDisplayName;
    }

    public void setDisplayName(String str) {
        this.mDisplayName = str;
    }

    public double getBalance() {
        return this.mBalance;
    }

    public void setBalance(double d2) {
        this.mBalance = d2;
    }

    public String getIssuerMetadata() {
        return this.mIssuerMetadata;
    }

    public void setIssuerMetadata(String str) {
        this.mIssuerMetadata = str;
    }

    public String getExpiry() {
        return this.mExpiry;
    }

    public void setExpiry(String str) {
        this.mExpiry = str;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public void setImageUrl(String str) {
        this.mImageUrl = str;
    }

    public String getWalletType() {
        return this.mWalletType;
    }

    public void setWalletType(String str) {
        this.mWalletType = str;
    }

    public int getSubWalletType() {
        return this.mSubWalletType;
    }

    public void setSubWalletType(Integer num) {
        this.mSubWalletType = num.intValue();
    }

    public void setSubWalletType(int i2) {
        this.mSubWalletType = i2;
    }

    public String getSubTitle() {
        return this.mSubTitle;
    }

    public void setSubTitle(String str) {
        this.mSubTitle = str;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public Object getTag() {
        return this.tag;
    }

    public String getIssuedOn() {
        return this.issuedOn;
    }

    public String getMetaData() {
        return this.mMetaData;
    }

    public void setMetaData(String str) {
        this.mMetaData = str;
    }

    public long getIssuedOnTime() {
        if (TextUtils.isEmpty(getIssuedOn())) {
            return 0;
        }
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(getIssuedOn()).getTime();
        } catch (ParseException unused) {
            return 0;
        }
    }

    public String getSubWalletName() {
        return this.subWalletName;
    }

    public boolean isExpired() {
        if (TextUtils.isEmpty(this.mExpiry)) {
            return false;
        }
        try {
            if (System.currentTimeMillis() > new SimpleDateFormat("dd-MM-yyyy").parse(this.mExpiry).getTime()) {
                return true;
            }
            return false;
        } catch (ParseException unused) {
        }
    }

    public String toString() {
        new f().b(this);
        return super.toString();
    }
}
