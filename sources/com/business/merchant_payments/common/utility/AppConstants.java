package com.business.merchant_payments.common.utility;

import android.graphics.Color;
import com.business.merchant_payments.PaymentsConfig;
import java.util.HashMap;
import net.one97.paytm.upi.util.GAConstants;

public class AppConstants {
    public static final String ADD_MOBILE_OTP_SCREEN = "ADD_MOBILE_OTP_SCREEN";
    public static final String AGGREGATE_CUSTOM_KEY = "custom";
    public static final String AGGREGATE_END_KEY = "endDate";
    public static final String AGGREGATE_START_KEY = "startDate";
    public static int API_PAGESIZE = 20;
    public static final String APPLICATION_JSON = "application/json";
    public static final String APPLICATION_URLENCODED = "application/x-www-form-urlencoded";
    public static final String AUTHORIZATION = "Authorization";
    public static final String BANGALI_CODE = "bn";
    public static final String CALENDAR_TYPE = "CALENDAR_TYPE";
    public static final String CASH_WITHDRAWAL = "CASH WITHDRAWAL";
    public static final String CASH_WITHDRAWAL_INCENTIVE = "CASH WITHDRAWAL INCENTIVE";
    public static final String CLIENT_ID = "client_id";
    public static final String CODE = "code";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String CREDIT_CARD = "CREDIT CARD";
    public static final String CURRENT_SELECTION = "current_selection";
    public static final String CUSTOM_DATE = "custom_date";
    public static final float CUSTOM_DIALOG_WIDTH_PERCENTAGE = 0.85f;
    public static final String DEBIT_CARD = "DEBIT CARD";
    public static final String DIRECT_SETTLE_TYPE = "INSTANT";
    public static final String DO_NOT_REDIRECT = "do_not_redirect";
    public static final String DURATION = "duration";
    public static String EDC_MESSAGE_BUNDLE = "edcMessageBundle";
    public static final int EMAIL_NOTIFICATION = 1;
    public static final String EMAIL_REG_EX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String EMI = "EMI";
    public static final String EMI_CC = "EMI CC";
    public static final String EMI_DC = "EMI DC";
    public static final String END_KEY = "end";
    public static final String ENGLISH_CODE = "en";
    public static final String EXTRA_FIRST_TITLE = "TITLE";
    public static final String EXTRA_SELECTED_START_DATE = "START_DATE";
    public static final String FONT_FAMILY_SANS_SERIF = "sans-serif";
    public static final String FONT_FAMILY_SANS_SERIF_LIGHT = "sans-serif-light";
    public static final String FONT_FAMILY_SANS_SERIF_MEDIUM = "sans-serif-medium";
    public static final String FORMATTED_BANK_ACCOUNNT_NUMBER = "formatted_bank_account_number";
    public static String FROM_SCREEN = "from_screen";
    public static final String GUJRATI_CODE = "gu";
    public static final String HINDI_CODE = "hi";
    public static String HOME_HELP_SCREEN = "home_help_screen";
    public static final String ICON_URL = "icon_url";
    public static String INITIATE_REFUND_SCREEN = "initiate_refund_screen";
    public static final String INTENT_EXTRA_END_DATE = "endDate";
    public static final String INTENT_EXTRA_PAGE_TITLE = "intent_extra_page_title";
    public static final String INTENT_EXTRA_START_DATE = "startDate";
    public static final String INTENT_EXTRA_URL = "intent_extra_url";
    public static String INVALID_TOKEN = "INVALID_TOKEN";
    public static final String IS_CANCEL = "is_cancel";
    public static String IS_FROM_MULTIPLE_QR = "isMultipleQR";
    public static final String IS_PCF_TRANSACTION = "IS_PCF_TRANSACTION";
    public static final String IS_SETTLED_IN_MULTIPLE_BANK = "is_settled_in_multiple_bank";
    public static final String IS_TOKEN_REQUIRED_IN_WEBVIEW = "is_token_required_in_webview";
    public static final String KANNADA_CODE = "kn";
    public static final String KEY_DATA_PAYMENT_LINK = "key_data_payment_link";
    public static final String KEY_DEEPLINK_DATA = "key_deeplink_data";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_IS_FROM_DEEPLINK = "is_from_deepLink";
    public static final String KEY_MOBILE = "mobile";
    public static final String KEY_OFFLINE_ORDER_ID = "ORDER_ID";
    public static final String KEY_ONLINE_ORDER_ID = "orderId";
    public static final String KEY_OPEN_SCREEN = "key_open_screen";
    public static final String KEY_SCREEN_PAYMENTS = "open_payment_screen";
    public static final String KEY_SCREEN_PAYMENTS_FOR_TWO_WEEKS = "open_payment_screen_for_two_weeks";
    public static final String KEY_SEARCH_BY = "searchBy";
    public static final String KEY_SEARCH_VALUE = "searchVal";
    public static String LAST_COLLECTED_PAYMENTS_LIMIT = "100";
    public static final String LEGAL_PRIVACY = "/legal_privacy";
    public static final String LIMIT = "limit";
    public static final String LOAN_INSTALLMENT = "LOAN";
    public static final String MALYALAM_CODE = "ml";
    public static final String MARATHI_CODE = "mr";
    public static final String MESSAGE = "message";
    public static final String MOBILE_NUMBER = "mobileNumber";
    public static final String MOB_NO_REG_EX_NEW = "^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[56789]\\d{9}$";
    public static final String MULTIPLE_NUMBERS = "multiple_numbers";
    public static String NETWORK_RETRY_CLICK = GAConstants.ACTION.RETRY;
    public static final String NET_AMOUNT = "net_amount";
    public static final String NOTIFICATION_LIST = "NOTIFICATION_LIST";
    public static final String NOTIFICATION_SETIINGS = "NOTIFICATION_SETIINGS";
    public static final String NOTIFICATION_TYPE = "NOTIFICATION_TYPE";
    public static final String ORIYA_CODE = "or";
    public static final String OS_TYPE_ANDROID = "android";
    public static final String OTP = "OTP";
    public static final String OTP_STATE = "OTP_STATE";
    public static final String OTP_TYPE = "otp_type";
    public static final String PARSE_ERROR = "parsing_error";
    public static final String PASSWORD = "password";
    public static final int PASSWORD_LENGTH = 4;
    public static final String PAYMENTLIN_DATE_FORMAT = "dd-MMM-hh:mm a";
    public static final String PAYMENTS_LINK_RECV_SCREEN = "payments_link_recv_screen";
    public static final String PAYOUT_SETTLED = "PAYOUT_SETTLED";
    public static final String PAYTM = "paytm";
    public static final String PAYTM_TERMINAL = "EDC_RENTAL";
    public static final String PREFERENCE_KEY = "preferenceKey";
    public static final String PREFERENCE_VALUE = "preferenceValue";
    public static final String PRICE_PATTERN = "##,##,##,##,###.##";
    public static final String PRICE_PATTERN_INT = "##,##,##,##,###";
    public static final String PUNJABI_CODE = "pa";
    public static final int QR_KEY_BLACK = Color.parseColor("#222222");
    public static final int QR_KEY_WHITE = -1;
    public static String REFUND_DETAILS_SCREEN = "refund_details_screen";
    public static final String REQUEST_KEY = "request";
    public static final String REQUEST_MONEY_ITEM = "REQUEST_MONEY_ITEM";
    public static final String RESPONSE_TYPE = "response_type";
    public static final String SCOPE = "scope";
    public static final String SCREEN_NAME = "SCREEN_NAME";
    public static final String SELECT = "select";
    public static final String SESSION_TOKEN = "session_token";
    public static final String SETTLEMENT = "settled";
    public static final int SETTLEMENT_PAGE_SIZE = 50;
    public static final String SETTLEMENT_TYPE = "settlement_type";
    public static final int SMS_NOTIFICATION = 2;
    public static final String SOURCE = "source";
    public static String START_DATE = "start_date";
    public static final String START_KEY = "start";
    public static final String TAG_AMOUNT = "amount";
    public static final String TAG_APP_LANGUAGE = "applanguage";
    public static final String TAG_APP_VERSION = "appVersion";
    public static final String TAG_CHILD_SITE_ID = "child_site_id";
    public static final String TAG_CLIENT = "client";
    public static final String TAG_DEVICE = "device";
    public static final String TAG_DEVICE_IDENTIFIER = "deviceIdentifier";
    public static final String TAG_DEVICE_MANUFACTURER = "deviceManufacturer";
    public static final String TAG_DEVICE_NAME = "deviceName";
    public static final String TAG_GEOLOCATION_PARAMS = "geoLocationParams";
    public static final String TAG_IMEI = "imei";
    public static final String TAG_LANGUAGE = "language";
    public static final String TAG_LANG_ID = "lang_id";
    public static final String TAG_LAT = "lat";
    public static final String TAG_LATITUDE = "latitude";
    public static final String TAG_LINK_DESCRIPTION = "linkDescription";
    public static final String TAG_LINK_NAME = "linkName";
    public static final String TAG_LONG = "long";
    public static final String TAG_LONGITUDE = "longitude";
    public static final String TAG_MID = "mid";
    public static final String TAG_NETWORK_TYPE = "networkType";
    public static final String TAG_OS_VERSION = "osVersion";
    public static final String TAG_PLAY_STORE_INSTALL = "playStore";
    public static final String TAG_RESOLUTION = "resolution";
    public static final String TAG_SCREEN_NAME = "screen_name";
    public static final String TAG_SIM_1 = "sim1";
    public static final String TAG_SITE_ID = "site_id";
    public static final String TAG_TRANSACTION_STATUS = "status";
    public static final String TAG_VERSION = "version";
    public static final String TAMIL_CODE = "ta";
    public static final String TARGET_MAIL_TO = "mailto:";
    public static final String TELUGU_CODE = "te";
    public static String TIME_ZONE_INDIA = "+05:30";
    public static final String TITLE = "title";
    public static final String TODAY = "today";
    public static final String TRANSACTION = "txn";
    public static final String TRANSACTION_OBJECT = "transaction_object";
    public static final String TRANSACTION_OBJECT_V2 = "transaction_object_v2";
    public static final String TRANSACTION_STATUS_CLIENT_PENDING = "CLIENT_PENDING";
    public static final String TRANSACTION_STATUS_FAILURE = "FAILURE";
    public static final String TRANSACTION_STATUS_PENDING = "PENDING";
    public static final String TRANSACTION_STATUS_REFUND_FAILURE = "REFUND_FAILURE";
    public static final String TRANSACTION_STATUS_REFUND_PENDING = "REFUND_PENDING";
    public static final String TRANSACTION_STATUS_REFUND_SUCCESS = "REFUND_SUCCESS";
    public static final String TRANSACTION_STATUS_SUCCESS = "SUCCESS";
    public static final String TRANSACTION_STATUS_TXN_FAILURE = "TXN_FAILURE";
    public static final String TRANSACTION_STATUS_TXN_PENDING = "TXN_PENDING";
    public static final String TRANSACTION_STATUS_TXN_SUCCESS = "TXN_SUCCESS";
    public static final String TXN_OBJECT = "txn_object";
    public static final String TYPE = "type";
    public static final String UPI_QR_CODE = "UPI_QR_CODE";
    public static final String UPS_DEVICE_ID = "deviceId";
    public static final String UPS_REQUEST_ID = "requestId";
    public static final String UPS_SSO_TOKEN = "sso-token";
    public static final String URL = "url";
    public static final String USERNAME = "username";
    public static final String VERSION = "is_supported";
    public static final String VERSION_CODE = "versionCode";
    public static final String VERSION_NAME = "versionName";
    public static final String WEEK = "week";
    public static final String WITHDRAW = "withdraw";
    public static final String XAUTHUMP = "x-auth-ump";
    public static final String XUSERMID = "x-user-mid";
    public static final String XUSERTOKEN = "x-user-token";
    public static final String X_APP_RID = "x-app-rid";
    public static final String YESTERDAY = "yesterday";
    public static HashMap<String, String> domainPinsMap;

    public interface ApiNames {
        public static final String CHARGEBACK = "CHARGEBACK";
        public static final String MERCHANT_TO_PAYER_REFUND = "MERCHANT_TO_PAYER_REFUND";
        public static final String REFUND = "REFUND";
        public static final String REVERSAL = "REVERSAL";
        public static final String Refund_Report = "Refund Report";
        public static final String VOID = "VOID";
    }

    public interface KeyValues {
        public static final String APP_CLIENT = PaymentsConfig.getInstance().getAppKeys().f7318a;
        public static final String AUTHORIZATION_VALUE = PaymentsConfig.getInstance().getAppKeys().f7321d;
        public static final String CLIENT_ID = PaymentsConfig.getInstance().getAppKeys().f7319b;
        public static final String CLIENT_SECRET = PaymentsConfig.getInstance().getAppKeys().f7320c;
        public static final String HEADER_CLIENT_ID_VALUE = PaymentsConfig.getInstance().getAppKeys().f7322e;
    }

    public interface MapQrConstants {
        public static final int QR_KEY_BLACK = Color.parseColor("#222222");
        public static final String SUCCESS = "SUCCESS";
        public static final String UPI = "upi://pay?";
    }

    public interface NOTIFICATION_DETAILS {
        public static final String ADDITIONAL_CONTACT = "removeAdditionalContact";
        public static final String ADD_ADDITIONAL_CONTACT = "additionalContact";
        public static final String BUSINESS_DETAILS = "business_details";
        public static final String EMAIL_ALLOWED = "emailAllowed";
        public static final String EVENT = "event";
        public static final String FROM = "from";
        public static final String MOBILE_EDIT_QR = "mobile_edit_qr";
        public static final String PRIMARY_EMAIL = "primary_email_text";
        public static final String PRIMARY_MOBILE = "primary_mobile_num";
        public static final String REFUND = "refund";
        public static final String SMS_ALLOWED = "smsAllowed";
        public static final String TRANSACTION = "transaction";
        public static final String TYPE = "type";
        public static final String TYPE_PRIMARY_EMAIL = "update_primary_email";
        public static final String TYPE_PRIMARY_MOBILE = "update_primary_mobile";
        public static final String TYPE_SECONDARY_EMAIL = "update_secondary_email";
        public static final String TYPE_SECONDARY_MOBILE = "update_secondary_mobile";
        public static final String UPDATED_VALUE = "updated_value";
    }

    public interface QR_Constants {
        public static final String KEY_EDIT_QR = "edit_qr_code";
    }

    public interface QueryParams {
        public static final String EXCLUDE = "exclude";
        public static final String SHOW_SETTLEMENT_CARDS = "showSettlementCards";
        public static final String TYPE = "type";
    }

    public interface REQUEST_CODE {
        public static final int ADD_MOBILE_NOTIFICATIONS = 234;
        public static final int ADD_PRIMARY_EMAIL = 1101;
        public static final int ADD_SECONDARY_EMAIL = 1102;
    }

    public interface REQUEST_CODE_FOR_SYSTEM {
        public static final int LOCATION_SETTINGS_DIALOG = 6000;
    }
}
