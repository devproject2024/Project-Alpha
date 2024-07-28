package net.one97.paytm.common.entity.wallet;

import android.content.Context;
import android.text.TextUtils;
import net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes;
import org.json.JSONException;
import org.json.JSONObject;

public class CJRQRScanResultModel {
    private static final String AUTH_MDOE = "USRPWD";
    private static final String CHANNEL_ID = "QRCODE";
    public static final String CURRENCY_INDIA = "INR";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String KEY_ADDRESS_1 = "ADDRESS_1";
    public static final String KEY_ADDRESS_2 = "ADDRESS_2";
    public static final String KEY_AUTH_MDOE = "AUTH_MODE";
    public static final String KEY_CHANNEL_ID = "CHANNEL_ID";
    public static final String KEY_CHECKSUMHASH = "CHECKSUMHASH";
    public static final String KEY_CITY = "CITY";
    public static final String KEY_COMMENT = "COMMENT";
    public static final String KEY_COMMENT_SMALL = "comment";
    public static final String KEY_CURRENCY = "Currency";
    public static final String KEY_CURRENCY_CODE = "currencyCode";
    public static final String KEY_CUST_ID = "CUST_ID";
    public static final String KEY_DEVICE_ID = "DeviceId";
    public static final String KEY_EMAIL = "EMAIL";
    public static final String KEY_EXPIRY_DATE = "EXPIRY_DATE";
    public static final String KEY_EXTENDED_INFO = "extendedInfo";
    public static final String KEY_ID = "link_invoice_id";
    public static final String KEY_INDUSTRY_TYPE = "industryType";
    public static final String KEY_INDUSTRY_TYPE_ID = "INDUSTRY_TYPE_ID";
    public static final String KEY_IS_FROM_UPI_INTENT = "is_from_upi_intent";
    public static final String KEY_IS_GOLD = "isGold";
    public static final String KEY_LINK_TYPE = "linkType";
    public static final String KEY_LOGO_URL = "logoURL";
    public static final String KEY_MAPPING_ID = "mappingId";
    public static final String KEY_MERCHANT_GUID = "merchantGuid";
    public static final String KEY_MERCHANT_GUID_READ = "MERCHANT_GUID";
    public static final String KEY_MERCHANT_NAME = "MERCHANT_NAME";
    public static final String KEY_MERCHANT_ORDER_ID = "merchantOrderId";
    public static final String KEY_MERCHANT_STATUS = "MERCHANT_STATUS";
    public static final String KEY_MERCHANT_TRANS_ID = "merchantTransId";
    public static final String KEY_MID = "MID";
    public static final String KEY_MOBILE_NO = "MOBILE_NO";
    public static final String KEY_MSISDN = "MSISDN";
    public static final String KEY_NAME = "NAME";
    public static final String KEY_OFFLINE_POST_CONVENIENCE = "offlinePostConvenience";
    public static final String KEY_ORDER_DETAILS = "ORDER_DETAILS";
    public static final String KEY_ORDER_ID = "ORDER_ID";
    public static final String KEY_ORIGIN = "ORIGIN";
    public static final String KEY_PAYEE_TYPE = "payeeType";
    public static final String KEY_PAYMENT_TYPE_ID = "PAYMENT_TYPE_ID";
    public static final String KEY_PG_ENABLED = "pgEnabled";
    public static final String KEY_PINCODE = "PINCODE";
    private static final String KEY_POS_ID = "posId";
    public static final String KEY_PRODUCT_DETAILS = "PRODUCT_DETAILS";
    public static final String KEY_PRODUCT_ID = "PRODUCT_ID";
    public static final String KEY_PRODUCT_TYPE = "PRODUCT_TYPE";
    public static final String KEY_QR_CODE_ID = "qr_code_id";
    public static final String KEY_QUANTITY = "QUANTITY";
    public static final String KEY_REQUEST_TYPE = "REQUEST_TYPE";
    public static final String KEY_REQ_TYPE = "ReqType";
    public static final String KEY_SSO_TOKEN = "SSO_TOKEN";
    public static final String KEY_STATE = "STATE";
    public static final String KEY_TAG_LINE = "tagLine";
    public static final String KEY_TOTAL_AMOUNT = "totalAmount";
    public static final String KEY_TXN_AMOUNT = "TXN_AMOUNT";
    public static final String KEY_WEBSITE = "WEBSITE";
    private static final String PAYMENT_TYPE_ID = "PPI";
    public static final String REQ_TYPE = "QR";
    private boolean isFromUPIIntent;
    private String linkId;
    private String linkType;
    private String mAddress1;
    private String mAddress2;
    private String mAuthMode;
    private String mChannelID;
    private String mChecksumHash;
    private String mCity;
    public String mComment;
    private String mCommentSmall;
    private String mCurrency;
    private String mEmail;
    private String mExpiryDate;
    private String mIndustryTypeID;
    private boolean mIsGold;
    JSONObject mJson;
    private String mLogoUrl;
    private String mMID;
    private String mMSISDN;
    private String mMappingId;
    private String mMerchantGUID;
    private String mMerchantName;
    private String mMerchantStatus;
    private String mMerchantTransId;
    private String mMobileNo;
    private String mName;
    private boolean mOfflinePostConvenience;
    private String mOrderDetails;
    private String mOrderID;
    private String mPayeeType;
    private String mPaymentTypeID;
    private boolean mPgEnabled;
    private String mPinCode;
    private String mPosId;
    private String mProductDetails;
    private String mProductID;
    private String mProductType;
    private String mQuantity;
    private String mRequestType;
    private String mState;
    private String mTagLine;
    public String mTxnAmount;
    private String mWebsite;
    private String qrCodeId;

    public String getMerchantStatus() {
        return this.mMerchantStatus;
    }

    public String getQrCodeId() {
        return this.qrCodeId;
    }

    public void setQrCodeId(String str) {
        this.qrCodeId = str;
    }

    public String getMerchantTransId() {
        return this.mMerchantTransId;
    }

    public String getPayeeType() {
        return this.mPayeeType;
    }

    public String getCurrency() {
        return this.mCurrency;
    }

    public String getMerchantName() {
        return this.mMerchantName;
    }

    public String getTagLine() {
        return this.mTagLine;
    }

    public String getMSISDN() {
        return this.mMSISDN;
    }

    public String getMerchantGUID() {
        return this.mMerchantGUID;
    }

    public void parseData(JSONObject jSONObject, Context context) throws JSONException {
        this.mJson = jSONObject;
        this.mMID = jSONObject.optString("MID");
        this.mPayeeType = jSONObject.optString(KEY_PAYEE_TYPE);
        this.mMerchantGUID = jSONObject.optString(KEY_MERCHANT_GUID_READ);
        this.mOfflinePostConvenience = jSONObject.optBoolean(KEY_OFFLINE_POST_CONVENIENCE, false);
        this.mRequestType = jSONObject.optString("REQUEST_TYPE");
        this.mIndustryTypeID = jSONObject.optString("INDUSTRY_TYPE_ID");
        this.mChannelID = jSONObject.optString("CHANNEL_ID", CHANNEL_ID);
        this.mPgEnabled = jSONObject.optBoolean(KEY_PG_ENABLED);
        this.mMerchantTransId = jSONObject.optString(KEY_MERCHANT_TRANS_ID);
        this.isFromUPIIntent = jSONObject.optBoolean(KEY_IS_FROM_UPI_INTENT);
        this.mComment = jSONObject.optString(KEY_COMMENT);
        if (!this.mPgEnabled) {
            if (TextUtils.isEmpty(this.mMerchantTransId)) {
                this.mOrderID = jSONObject.optString("ORDER_ID", generateOrderID(context));
            } else {
                this.mOrderID = this.mMerchantTransId;
            }
        } else if (this.isFromUPIIntent) {
            String optString = jSONObject.optString(DESCRIPTION);
            if (!TextUtils.isEmpty(optString)) {
                this.mComment = optString;
            }
        }
        this.mTxnAmount = jSONObject.optString("TXN_AMOUNT");
        this.mOrderDetails = jSONObject.optString(KEY_ORDER_DETAILS);
        this.mProductID = jSONObject.optString("PRODUCT_ID");
        this.mProductType = jSONObject.optString(KEY_PRODUCT_TYPE);
        this.mProductDetails = jSONObject.optString(KEY_PRODUCT_DETAILS);
        this.mQuantity = jSONObject.optString(KEY_QUANTITY);
        this.mCommentSmall = jSONObject.optString(KEY_COMMENT_SMALL);
        this.mWebsite = jSONObject.optString("WEBSITE");
        this.mChecksumHash = jSONObject.optString("CHECKSUMHASH");
        this.mAuthMode = jSONObject.optString("AUTH_MODE", AUTH_MDOE);
        this.mPaymentTypeID = jSONObject.optString("PAYMENT_TYPE_ID", PAYMENT_TYPE_ID);
        this.mAddress1 = jSONObject.optString("ADDRESS_1");
        this.mAddress2 = jSONObject.optString(KEY_ADDRESS_2);
        this.mCity = jSONObject.optString("CITY");
        this.mState = jSONObject.optString("STATE");
        this.mPinCode = jSONObject.optString("PINCODE");
        this.mEmail = jSONObject.optString("EMAIL");
        this.mMobileNo = jSONObject.optString(KEY_MOBILE_NO);
        this.mName = jSONObject.optString("NAME");
        this.mExpiryDate = jSONObject.optString(KEY_EXPIRY_DATE);
        this.mMerchantName = jSONObject.optString(KEY_MERCHANT_NAME);
        this.mTagLine = jSONObject.optString(KEY_TAG_LINE);
        this.mCurrency = jSONObject.optString(KEY_CURRENCY, "INR");
        this.mMappingId = jSONObject.optString(KEY_MAPPING_ID);
        this.mPosId = jSONObject.optString(KEY_POS_ID);
        this.qrCodeId = jSONObject.optString(KEY_QR_CODE_ID);
        this.linkId = jSONObject.optString(KEY_ID);
        this.linkType = jSONObject.optString(KEY_LINK_TYPE);
        this.mMerchantStatus = jSONObject.optString(KEY_MERCHANT_STATUS);
        parseExtendedInfo(this.mJson);
    }

    public void parseData(ConsolidatePaymentInstrumentationRes consolidatePaymentInstrumentationRes, Context context) throws JSONException {
        this.mMID = consolidatePaymentInstrumentationRes.getMerchantId();
        this.mMappingId = consolidatePaymentInstrumentationRes.getMerchantId();
        this.mMerchantTransId = "";
        this.mName = consolidatePaymentInstrumentationRes.getMerchantInfo().getMerBusName();
        this.mMerchantName = consolidatePaymentInstrumentationRes.getMerchantInfo().getMerDispname();
    }

    private void parseExtendedInfo(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("extendedInfo");
        if (optJSONObject != null) {
            this.mLogoUrl = optJSONObject.optString(KEY_LOGO_URL);
            this.mIsGold = optJSONObject.optBoolean(KEY_IS_GOLD);
        }
    }

    public JSONObject getJson() {
        return this.mJson;
    }

    public void setJson(JSONObject jSONObject) {
        this.mJson = jSONObject;
    }

    private String generateOrderID(Context context) {
        return REQ_TYPE + System.currentTimeMillis();
    }

    public long getExpiryDate() {
        if (TextUtils.isEmpty(this.mExpiryDate)) {
            return 0;
        }
        return Long.parseLong(this.mExpiryDate);
    }

    public boolean isGold() {
        return this.mIsGold;
    }

    public String getLogoURL() {
        return this.mLogoUrl;
    }

    public String getName() {
        return this.mName;
    }

    public String getMID() {
        return this.mMID;
    }

    public void setmRequestType(String str) {
        this.mRequestType = str;
    }

    public String getRequestType() {
        return this.mRequestType;
    }

    public String getIndustryTypeID() {
        return this.mIndustryTypeID;
    }

    public String getChannelID() {
        return this.mChannelID;
    }

    public String getOrderID() {
        return this.mOrderID;
    }

    public String getTxnAmount() {
        return this.mTxnAmount;
    }

    public void setmTxnAmount(String str) {
        this.mTxnAmount = str;
    }

    public String getOrderDetails() {
        return this.mOrderDetails;
    }

    public String getProductID() {
        return this.mProductID;
    }

    public String getProductType() {
        return this.mProductType;
    }

    public String getProductDetails() {
        return this.mProductDetails;
    }

    public String getQuantity() {
        return this.mQuantity;
    }

    public String getComment() {
        return TextUtils.isEmpty(this.mComment) ? this.mCommentSmall : this.mComment;
    }

    public String getWebsite() {
        return this.mWebsite;
    }

    public String getChecksumHash() {
        return this.mChecksumHash;
    }

    public String getAuthMode() {
        return this.mAuthMode;
    }

    public String getPaymentTypeID() {
        return this.mPaymentTypeID;
    }

    public String getAddress1() {
        return this.mAddress1;
    }

    public String getAddress2() {
        return this.mAddress2;
    }

    public String getCity() {
        return this.mCity;
    }

    public String getState() {
        return this.mState;
    }

    public String getPinCode() {
        return this.mPinCode;
    }

    public String getEmail() {
        return this.mEmail;
    }

    public void setmMobileNo(String str) {
        this.mMobileNo = str;
    }

    public String getMobileNo() {
        return this.mMobileNo;
    }

    public boolean isOfflinePostConvenience() {
        return this.mOfflinePostConvenience;
    }

    public boolean isPgEnabled() {
        return this.mPgEnabled;
    }

    public void setPgEnabled(boolean z) {
        this.mPgEnabled = z;
    }

    public String getMappingId() {
        return this.mMappingId;
    }

    public String getPosId() {
        return this.mPosId;
    }

    public String getLinkType() {
        return this.linkType;
    }

    public String getId() {
        return this.linkId;
    }

    public void setMappingId(String str) {
        this.mMappingId = str;
    }

    public void setmComment(String str) {
        this.mComment = str;
    }

    public void setmMerchantName(String str) {
        this.mMerchantName = str;
    }

    public void setMerchantTransId(String str) {
        this.mMerchantTransId = str;
    }

    public void setmLogoUrl(String str) {
        this.mLogoUrl = str;
    }
}
