package com.paytmmoney.lite.mod.util;

public final class PMConstants {
    public static final String BLOG_PATH = "/blog";
    public static final String H5_MONEY_ID = "3599887a2b32b6ba4c91b1564844248bb321f6d7";
    public static final String HAS_INVESTED_KEY = "hasInvested";
    public static final PMConstants INSTANCE = new PMConstants();
    public static final String INTENT_EXTRA_URI = "intent_extra_uri";
    public static final String INTENT_URI = "intent_uri";
    public static final String IS_INVESTMENT_READY_KEY = "isInvestmentReady";
    public static final String KYC_STATUS_KEY = "kycStatus";
    public static final int MAX_UPLOAD_IMG_SIZE = 8;
    public static final String MIME_TYPE = "MIME_TYPE";
    public static final String MONEY_VERTICAL_NAME = "paytm_money";
    public static final String ORIGINAL_FILE_NAME = "ORIGINAL_FILE_NAME";
    public static final String PAYTM_MONEY_APP_URI = "paytmmoney://";
    public static final String PAYTM_MONEY_NATIVE_PACKAGE_NAME = "com.paytmmoney";
    public static final String PAYTM_MONEY_SMART_LINK = "http://pytm.my/";
    public static final String PM_MINI_DEEPLINK_URL = "paytmmp://paytmmoney/pm-mini";
    public static final String PM_MINI_PROD_BUNDLE_URL = "https://mini.paytmmoney.com/";
    public static final String PM_MINI_STAGING_BUNDLE_URL = "https://mini-staging.paytmmoney.com/";
    public static final String PM_MINI_UNIQUE_ID = "8cc7a6ac4e344a17a7b3ff069929b557";
    public static final String SIGNATURE = "Signature";
    public static final String SIGNATURE_FILE_NAME_PNG = "signature.png";
    public static final int SIGN_REQ_CODE = 3;
    public static final String SLEEK_CARD_TIME_STAMP_KEY = "sleekCardTimeStamp";
    public static final String TITLE = "title";
    public static final String USERNAME_KEY = "username";
    public static final String USER_CONSENT_COMPLETED_KEY = "isUserConsentCompleted";
    public static final String USER_UPLOADED_PAN_IMAGE_KEY = "userUploadedPanImage";
    public static final String VIDEO_CAPTURE_CAMERA = "com.paytm.money.video.camera.click";
    public static final int WRITE_STORAGE_ACCESS_CODE = 5;

    private PMConstants() {
    }

    public static final class UploadTypes {
        public static final String ADDRESS_UPLOAD = "address_upload";
        public static final String BANK_DOC = "bank_doc";
        public static final String DOC = "doc";
        public static final UploadTypes INSTANCE = new UploadTypes();
        public static final String SINGLE_ADDRESS_UPLOAD = "single_address_upload";

        private UploadTypes() {
        }
    }
}
