package net.one97.paytm.wallet.splitbill.model;

import java.util.Objects;
import net.one97.paytm.network.CJRWalletDataModel;

public class SBContactDetail extends CJRWalletDataModel implements Cloneable {
    private String amount;
    private boolean isAdmin;
    private boolean isSelected;
    private boolean mIsSelectedForPay;
    private String mName;
    private String mPhotoUri;
    private String mThumbnail;
    private String mobile;
    private int position = -1;
    private String userId;

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getmPhotoUri() {
        return this.mPhotoUri;
    }

    public boolean ismIsSelectedForPay() {
        return this.mIsSelectedForPay;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i2) {
        this.position = i2;
    }

    public SBContactDetail(String str, String str2, String str3, boolean z) {
        this.mName = str;
        this.mobile = str2;
        this.mPhotoUri = str3;
        this.isSelected = z;
    }

    public SBContactDetail() {
    }

    public SBContactDetail(String str, String str2, Boolean bool) {
        this.isAdmin = bool.booleanValue();
        this.userId = str;
        this.mName = str2;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public boolean getmIsSelectedForPay() {
        return this.mIsSelectedForPay;
    }

    public void setmIsSelectedForPay(boolean z) {
        this.mIsSelectedForPay = z;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public String getmName() {
        return this.mName;
    }

    public void setmName(String str) {
        this.mName = str;
    }

    public String getmThumbnail() {
        return this.mThumbnail;
    }

    public void setmThumbnail(String str) {
        this.mThumbnail = str;
    }

    public String getmAmount() {
        return this.amount;
    }

    public void setmAmount(String str) {
        this.amount = str;
    }

    public String getPhotoUri() {
        return this.mPhotoUri;
    }

    public void setmPhotoUri(String str) {
        this.mPhotoUri = str;
    }

    public boolean isAdmin() {
        return this.isAdmin;
    }

    public void setAdmin(boolean z) {
        this.isAdmin = z;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            SBContactDetail sBContactDetail = (SBContactDetail) obj;
            return this.isSelected == sBContactDetail.isSelected && this.mIsSelectedForPay == sBContactDetail.mIsSelectedForPay && this.isAdmin == sBContactDetail.isAdmin && Objects.equals(this.mName, sBContactDetail.mName) && Objects.equals(this.mThumbnail, sBContactDetail.mThumbnail) && Objects.equals(this.mobile, sBContactDetail.mobile) && Objects.equals(this.amount, sBContactDetail.amount) && Objects.equals(this.mPhotoUri, sBContactDetail.mPhotoUri) && Objects.equals(this.userId, sBContactDetail.userId);
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mName, this.mThumbnail, this.mobile, this.amount, Boolean.valueOf(this.isSelected), this.mPhotoUri, Boolean.valueOf(this.mIsSelectedForPay), this.userId, Boolean.valueOf(this.isAdmin)});
    }
}
