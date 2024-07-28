package net.one97.paytm.wallet.newdesign.addmoney.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRExtendedInfoData implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "deepLink")
    private String mDeepLink;
    @b(a = "logoUrl")
    private String mLogoUrl;
    @b(a = "ORDER_ID")
    private String mQRCodeRefrenceOrderID;
    @b(a = "qr_code_timeStamp")
    private String mQrCodeTimestamp;
    @b(a = "merchantQrTag")
    private String merchantQRTag;
    @b(a = "qrCodeid")
    private String qrCodeId;

    public String getmQrCodeTimestamp() {
        return this.mQrCodeTimestamp;
    }

    public String getDeepLink() {
        return this.mDeepLink;
    }

    public String getMerchantQRTag() {
        return this.merchantQRTag;
    }

    public String getLogoUrl() {
        return this.mLogoUrl;
    }

    public String getmQRCodeRefrenceOrderID() {
        return this.mQRCodeRefrenceOrderID;
    }

    public String getQrCodeId() {
        return this.qrCodeId;
    }

    public void setmQRCodeRefrenceOrderID(String str) {
        this.mQRCodeRefrenceOrderID = str;
    }

    public void setQrCodeId(String str) {
        this.qrCodeId = str;
    }

    public void setmQrCodeTimestamp(String str) {
        this.mQrCodeTimestamp = str;
    }
}
