package com.paytm.business.merchantprofile.common.utility;

import com.paytm.business.merchantprofile.ProfileConfig;
import java.util.HashMap;

public class AppConstants {
    public static final String ADD_MOBILE_OTP_SCREEN = "ADD_MOBILE_OTP_SCREEN";
    public static final String APPLICATION_JSON = "application/json";
    public static final String APPLICATION_URLENCODED = "application/x-www-form-urlencoded";
    public static final String AUTHORIZATION = "Authorization";
    public static final String BANGALI_CODE = "bn";
    public static final String BOTTOM_SHEET_SELECTED_INDEX = "selected_index";
    public static final String BUSINESS_NAME = "businessName";
    public static final String CLIENT_ID = "client_id";
    public static final String CODE = "code";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String DO_NOT_REDIRECT = "do_not_redirect";
    public static final String EDIT_OBJECT = "edit_object";
    public static final String ENGLISH_CODE = "en";
    public static final String FONT_FAMILY_SANS_SERIF_LIGHT = "sans-serif-light";
    public static String FROM_SCREEN = "from_screen";
    public static final String GUJRATI_CODE = "gu";
    public static final String HINDI_CODE = "hi";
    public static final String INTENT_EXTRA_PAGE_TITLE = "intent_extra_page_title";
    public static final String INTENT_EXTRA_URL = "intent_extra_url";
    public static String INVALID_TOKEN = "INVALID_TOKEN";
    public static final String IS_TOKEN_REQUIRED_IN_WEBVIEW = "is_token_required_in_webview";
    public static final String KANNADA_CODE = "kn";
    public static final String KEY_IS_FROM_DEEPLINK = "is_from_deepLink";
    public static final String KEY_MOBILE = "mobile";
    public static final String LEGAL_PRIVACY = "/legal_privacy";
    public static final String MALYALAM_CODE = "ml";
    public static final String MARATHI_CODE = "mr";
    public static final String MESSAGE = "message";
    public static final String MOBILE_NUMBER = "mobileNumber";
    public static final String ORIYA_CODE = "or";
    public static final String OTP = "OTP";
    public static final String OTP_STATE = "OTP_STATE";
    public static final String OTP_TYPE = "otp_type";
    public static final String PARSE_ERROR = "parsing_error";
    public static final String PASSWORD = "password";
    public static final String PAYTM = "paytm";
    public static final String PRICE_PATTERN_INT = "##,##,##,##,###";
    public static final String PUNJABI_CODE = "pa";
    public static final String RENTAL_SERIALIZABLE_DATA = "edc_rental_data";
    public static final String RESPONSE_TYPE = "response_type";
    public static final String SCOPE = "scope";
    public static final String SESSION_TOKEN = "session_token";
    public static final String SSO_TOKEN = "sso_token";
    public static final int START_OTP_FLOW = 10000;
    public static final String TAG_APP_LANGUAGE = "applanguage";
    public static final String TAG_APP_VERSION = "appVersion";
    public static final String TAG_CLIENT = "client";
    public static final String TAG_DEVICE_IDENTIFIER = "deviceIdentifier";
    public static final String TAG_DEVICE_MANUFACTURER = "deviceManufacturer";
    public static final String TAG_DEVICE_NAME = "deviceName";
    public static final String TAG_IMEI = "imei";
    public static final String TAG_LANGUAGE = "language";
    public static final String TAG_LAT = "lat";
    public static final String TAG_LATITUDE = "latitude";
    public static final String TAG_LONG = "long";
    public static final String TAG_LONGITUDE = "longitude";
    public static final String TAG_NETWORK_TYPE = "networkType";
    public static final String TAG_OS_VERSION = "osVersion";
    public static final String TAG_PLAY_STORE_INSTALL = "playStore";
    public static final String TAG_SIM_1 = "sim1";
    public static final String TAG_VERSION = "version";
    public static final String TAMIL_CODE = "ta";
    public static final String TARGET_MAIL_TO = "mailto:";
    public static final String TELUGU_CODE = "te";
    public static final String TITLE = "title";
    public static final String TRANSACTION_STATUS_ERROR = "ERROR";
    public static final String TRANSACTION_STATUS_FAILED = "FAILED";
    public static final String TRANSACTION_STATUS_FAILURE = "FAILURE";
    public static final String TRANSACTION_STATUS_PENDING = "PENDING";
    public static final String TRANSACTION_STATUS_SUCCESS = "SUCCESS";
    public static final String TYPE = "type";
    public static final String TYPE_OTP_GSTIN = "GSTIN";
    public static final String USERNAME = "username";
    public static final String VALUE = "value";
    public static final String XAUTHUMP = "x-auth-ump";
    public static final String XUSERMID = "x-user-mid";
    public static final String XUSERTOKEN = "x-user-token";
    public static HashMap<String, String> domainPinsMap = null;
    public static boolean showBlockedWalletBottomSheet = true;

    public interface DeepLinkConstants {
        public static final String KEY_DEEPLINK_HIGHLIGHT_SECTION = "key_deeplink_highlight_section";
        public static final String KEY_DEEPLINK_TARGET_SCREEN_ID = "key_deeplink_target_screen_id";
    }

    public interface KeyValues {
        public static final String APP_CLIENT = ProfileConfig.getInstance().getAppKeys().f7318a;
        public static final String AUTHORIZATION_VALUE = ProfileConfig.getInstance().getAppKeys().f7321d;
        public static final String CLIENT_ID = ProfileConfig.getInstance().getAppKeys().f7319b;
        public static final String CLIENT_SECRET = ProfileConfig.getInstance().getAppKeys().f7320c;
        public static final String HEADER_CLIENT_ID_VALUE = ProfileConfig.getInstance().getAppKeys().f7322e;
    }

    public interface NOTIFICATION_DETAILS {
    }

    public interface REQUEST_CODE {
        public static final int BOTTOM_SHEET_ITEM_SELECTED = 130;
        public static final int EDIT_DETAILS = 125;
    }

    public interface RESULT_CODE {
        public static final int PPBL_FAILURE = 201;
    }

    public interface UPDATE_DETAILS {
        public static final String ADDRESS = "update_address";
        public static final String GSTIN = "update_gstin";
    }
}
