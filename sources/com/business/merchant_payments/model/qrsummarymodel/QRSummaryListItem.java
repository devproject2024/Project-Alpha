package com.business.merchant_payments.model.qrsummarymodel;

import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.model.BaseModel;
import com.google.gson.a.c;

public class QRSummaryListItem extends BaseModel {
    @c(a = "totalPrice")
    public String mAmmount;
    @c(a = "deepLink")
    public String mDeepLink;
    @c(a = "displayName")
    public String mDisplayName;
    @c(a = "expiryDate")
    public String mExpiryDate;
    @c(a = "mappingId")
    public String mMappingID;
    @c(a = "mobileNo")
    public String mMobileNumber;
    @c(a = "path")
    public String mPath;
    @c(a = "posId")
    public String mPosID;
    @c(a = "productDetails")
    public String mProductDetails;
    @c(a = "productId")
    public String mProductID;
    @c(a = "productType")
    public String mProductTYpe;
    @c(a = "qrCodeId")
    public String mQRCodeID;
    @c(a = "qrType")
    public String mQRType;
    @c(a = "secondaryPhoneNumber")
    public String mSecondaryPhoneNumber;
    @c(a = "sourceId")
    public String mSourceID;
    @c(a = "sourceName")
    public String mSourceName;
    @c(a = "stickerId")
    public String mStickerID;
    @c(a = "tagline")
    public String mTagLine;

    public String getmStickerID() {
        return this.mStickerID;
    }

    public String getmQRCodeID() {
        return this.mQRCodeID;
    }

    public void setmQRCodeID(String str) {
        this.mQRCodeID = str;
    }

    public String getmSecondaryPhoneNumber() {
        return this.mSecondaryPhoneNumber;
    }

    public String getmDisplayName() {
        return this.mDisplayName;
    }

    public void setmDisplayName(String str) {
        this.mDisplayName = str;
    }

    public String getmTagLine() {
        return this.mTagLine;
    }

    public String getmPath() {
        return this.mPath;
    }

    public String getmPosID() {
        return this.mPosID;
    }

    public String getmQRType() {
        return this.mQRType;
    }

    public String getmSourceName() {
        return this.mSourceName;
    }

    public String getmSourceID() {
        return this.mSourceID;
    }

    public String getmMappingID() {
        return this.mMappingID;
    }

    public String getmDeepLink() {
        return this.mDeepLink;
    }

    public String getmProductID() {
        return this.mProductID;
    }

    public String getmAmmount() {
        return this.mAmmount;
    }

    public String getmProductTYpe() {
        return this.mProductTYpe;
    }

    public String getmProductDetails() {
        return this.mProductDetails;
    }

    public String getmExpiryDate() {
        return this.mExpiryDate;
    }

    public String getmMobileNumber() {
        return this.mMobileNumber;
    }

    public void setmMobileNumber(String str) {
        this.mMobileNumber = str;
    }

    public boolean isUpiQr() {
        return AppConstants.UPI_QR_CODE.equalsIgnoreCase(this.mQRType);
    }

    public void setmDeepLink(String str) {
        this.mDeepLink = str;
    }

    public void setmQRType(String str) {
        this.mQRType = str;
    }
}
