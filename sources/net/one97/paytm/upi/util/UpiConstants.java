package net.one97.paytm.upi.util;

import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.R;

public class UpiConstants {
    public static final String ACCEPT = "Accept";
    public static final String APPLICATION_JSON = "application/json";
    public static final String APPLICATION_URLENCODED = "application/x-www-form-urlencoded";
    public static final String APP_VERSION = "appVersion";
    public static final String ARG_BANK_LIST = "bank_list";
    public static final String ARG_IS_PROFILE_CREATED = "profile_created";
    public static final String ARG_RES_CODE = "res_code";
    public static final String ARG_RES_MSG = "res_msg";
    public static final String ARG_VPA = "vpa";
    public static final String AT_PAYTM = "@paytm";
    public static final String AUTHORIZATION = "Authorization";
    public static final String B2C_ANDROID = "B2C_ANDROID";
    public static final String BANK_HEALTH_STATUS_ALLOW = "ALLOW";
    public static final String BANK_HEALTH_STATUS_BLOCK = "BLOCK";
    public static final String CACHE_CONTROL = "cache-control";
    public static final String CAME_FROM_INCORRECT_PIN_DIALOG = "came_from_incorrect_mpin_dialog";
    public static final String CHANNEL = "channel";
    public static final String CHANNEL_TOKEN = "channel-token";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String CST_DEEPLINK = "paytmmp://cst_flow?featuretype=vertical_detail&verticalId=5";
    public static final int CST_UPI_ID = 1000517;
    public static final String DATA = "data";
    public static final String DEFAULT_ACCOUNT_CONSTANT = "D";
    public static final String DEFAULT_ACCOUNT_NA_CONSTANT = "N";
    public static final String DESTINATION_PHONE = "destinationphone";
    public static final String DEVICE_ID = "deviceId";
    public static final String DISABLE = "DISABLE";
    public static final String ENABLE = "ENABLE";
    public static final String EVENT_SCAN_TIME = "eventScanTime";
    public static final String EVENT_START_TIME = "eventStartTime";
    public static final String EXTRA_ACCOUNT_NAME = "beneficiary_acc_name";
    public static final String EXTRA_ACCOUNT_PROVIDER = "account_provider";
    public static final String EXTRA_ACCOUNT_TYPE = "account_type";
    public static final String EXTRA_ACCOUNT_TYPE_LINKED = "account_type_linked";
    public static final String EXTRA_ACTION_MT_REFRESH_PROFILE = "mt_refresh_profile";
    public static final String EXTRA_ACTION_MT_REFRESH_UPI_ACCOUNTS = "mt_refresh_upi_accounts";
    public static final String EXTRA_ACTION_RELOAD_UPI = "action_reload_upi";
    public static final String EXTRA_ACTION_UPI_LANDING_SHOW_PENDING = "action_upi_landing_show_pending_request";
    public static final String EXTRA_ACTION_UPI_PASSBOOK_REFRESH_RECEIVED_TRANSACTIONS = "action_upi_passbook_refresh_received_transactions";
    public static final String EXTRA_ACTION_UPI_PASSBOOK_REFRESH_SENT_TRANSACTIONS = "action_upi_passbook_refresh_sent_transactions";
    public static final String EXTRA_ACTION_UPI_PASSBOOK_REFRESH_SPAM = "action_upi_passbook_refresh_spam";
    public static final String EXTRA_ACTION_UPI_PASSBOOK_REFRESH_TRANSACTIONS = "action_upi_passbook_refresh_transactions";
    public static final String EXTRA_ACTION_UPI_PASSBOOK_TAB_CHANGED = "action_upi_passbook_tab_changed";
    public static final String EXTRA_ADD_BANK_DEFAULT = "add_bank_default";
    public static final String EXTRA_AMOUNT = "amount";
    public static final String EXTRA_BANK_ACCOUNT_LIST = "bank_account_list";
    public static final String EXTRA_BANK_NAME = "beneficiary_bank_name";
    public static final String EXTRA_BENEFICIARY_ID = "extra_beneficiary_id";
    public static final String EXTRA_COLLECT_REQUEST_BANK_LIST_SIZE = "collect_bank_list_size";
    public static final String EXTRA_COMMENTS_UNIV_P2P = "comments_from_univ_p2p";
    public static final String EXTRA_CREDS_ALLOWED = "creds_allowed";
    public static final String EXTRA_DEEPLINK_TXN_ID = "extra_key_deeplink_txn_id";
    public static final String EXTRA_DEEP_LINK_DATA = "EXTRA_DEEP_LINK_DATA";
    public static final String EXTRA_DEEP_LINK_FLAG = "EXTRA_DEEP_LINK_FLAG";
    public static final String EXTRA_DELETED_VPA = "deleted_vpa";
    public static final String EXTRA_DEVICE_BIND_MODEL = "device_bind_model";
    public static final String EXTRA_DO_SHOW = "do_show";
    public static final String EXTRA_DO_SHOW_SKIP = "do_show_skip";
    public static final String EXTRA_EXPIRY_TIME = "expiry_time";
    public static final String EXTRA_EXPIRY_TIME_HINT = "expiry_time_hint";
    public static final String EXTRA_FLAG_REDIRECT = "upi_flag_redirect";
    public static final String EXTRA_IFSC = "beneficiary_ifsc";
    public static final String EXTRA_IFSC_UNIV_P2P = "ifsc_from_univ_p2p";
    public static final String EXTRA_IMAGE_URL = "image_url";
    public static final String EXTRA_INTENT_INITIATION_MODE = "extra_key_intent_mode";
    public static final String EXTRA_INTENT_MID = "extra_key_intent_mid";
    public static final String EXTRA_INTENT_MSID = "extra_key_intent_msid";
    public static final String EXTRA_INTENT_MTID = "extra_key_intent_mtid";
    public static final String EXTRA_INTENT_ORD_ID = "extra_key_intent_orgid";
    public static final String EXTRA_INTENT_SIGN = "extra_key_intent_sign";
    public static final String EXTRA_INTENT_UPI_FROM_CST = "is_from_cst";
    public static final String EXTRA_INTENT_UPI_PASSBOOK_TAB = "upi_passbook_tab";
    public static final String EXTRA_IS_COLLECT_REQUEST = "is_collect_request";
    public static final String EXTRA_IS_FOR_FORGOT_MPIN = "forgot_mpin";
    public static final String EXTRA_IS_FOR_IMPS_FROM_UNIV_P2P = "is_for_imps_from_univ_p2p";
    public static final String EXTRA_IS_FROM_BENEFICIARY = "is_from_beneficiary";
    public static final String EXTRA_IS_FROM_REFUND = "is_from_refund";
    public static final String EXTRA_IS_FROM_SCHEDULER = "is_from_scheduler";
    public static final String EXTRA_IS_FROM_UNIV_P2P = "is_from_univ_p2p";
    public static final String EXTRA_IS_MPIN_SET = "mpin_set";
    public static final String EXTRA_IS_SUCCESS = "is_success";
    public static final String EXTRA_IS_UPI_PUSH = "upi_push";
    public static final String EXTRA_KEY_COMMENTS = "extra_key_comments";
    public static final String EXTRA_KEY_DEEPLINK_BUNDLE = "deeplink_bundle";
    public static final String EXTRA_KEY_IS_FROM_ON_BOARDING = "is_from_on_boarding";
    public static final String EXTRA_KEY_IS_FROM_PASSBOOK = "is_from_passbook";
    public static final String EXTRA_KEY_MCC = "extra_key_mcc";
    public static final String EXTRA_KEY_MIN_AMOUNT_DEEP_LINK = "extra_key_upi_min_amount";
    public static final String EXTRA_KEY_MPIN = "extra_key_mpin";
    public static final String EXTRA_KEY_REF_ID = "extra_key_ref_id";
    public static final String EXTRA_KEY_REF_URL = "extra_key_ref_url";
    public static final String EXTRA_MERCHANT_CODE = "merchant_code";
    public static final String EXTRA_MESSAGE = "message";
    public static final String EXTRA_MONEY_TRANSFER_PAYMENT_OPTION = "money_transfer_payment_option";
    public static final String EXTRA_MT_REFRESH_DO_SHOW_UPI_FORM = "do_show_upi";
    public static final String EXTRA_ON_BOARDING_SOURCE = "on_boarding_flow";
    public static final String EXTRA_OPTIONAL_DESC = "optional_desc";
    public static final String EXTRA_PAYEE_ACC_NUMBER = "beneficiary_acc_no";
    public static final String EXTRA_PAYEE_NAME = "payee_name";
    public static final String EXTRA_PAYEE_VPA = "payee_vpa";
    public static final String EXTRA_PAYEE_VPA_OR_ACC_NUMBER = "payee_vpa_or_acc_no";
    public static final String EXTRA_PAYER_NAME = "payer_name";
    public static final String EXTRA_PAYER_VPA = "payer_vpa";
    public static final String EXTRA_PHONE_NUMBER_FROM_P2P = "phone_number";
    public static final String EXTRA_PROFILE_SECTION = "upi_profile_section";
    public static final String EXTRA_PROFILE_STATE = "upi_profile_state";
    public static final String EXTRA_REFRESH_BANK_ACCOUNT = "refresh_bank_account";
    public static final String EXTRA_REGISTRATION_DO_CREATE_PROFILE = "create_profile";
    public static final String EXTRA_REGISTRATION_REDIRECT = "redirect";
    public static final String EXTRA_REGISTRATION_REDIRECT_URL = "redirect_url";
    public static final String EXTRA_REG_ERROR_CAUSE = "registration_error_cause";
    public static final String EXTRA_RELOAD_UPI_PENDING_REQUESTS = "reload_upi_pending_requests";
    public static final String EXTRA_RELOAD_UPI_TRANSACTIONS = "reload_upi_transactions";
    public static final String EXTRA_RESPONSE_CODE = "response_code";
    public static final String EXTRA_RRN = "rrn";
    public static final String EXTRA_SELECTED_BANK = "selected_bank";
    public static final String EXTRA_SELECTED_MOB_NUM = "selected_mobile_num";
    public static final String EXTRA_SELECTED_VPA = "selected_vpa";
    public static final String EXTRA_SEQ_NO = "seq_no";
    public static final String EXTRA_SOURCE_DYNAMIC_QR = "source_dynamic_qr";
    public static final String EXTRA_SUBSCRIPTION_ID = "subscription_id";
    public static final String EXTRA_UPI_MPIN = "upi_mpin";
    public static final String EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN = "show_full_screen";
    public static final String EXTRA_UPI_P2P_PAYMENT_ROUTE = "upi_p2p_payment_route";
    public static final String EXTRA_UPI_PENDING_REQUEST = "pending_request";
    public static final String EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID = "transaction_id";
    public static final String EXTRA_UPI_REFER_DEEPLINK = "upi_landing_refferer_deeplink";
    public static final String EXTRA_UPI_SEQ_NO = "upi_seq_no";
    public static final String EXTRA_UPI_SHOW_DO_IT_LATER = "upiShowDoItLater";
    public static final String EXTRA_UPI_TRANSACTION = "transaction";
    public static final String EXTRA_UPI_TRAN_LOG_ID = "upi_tran_log_id";
    public static final String EXTRA_USER_UPI_DETAILS = "user_upi_details";
    public static final String EXTRA_VPA = "vpa";
    public static final String EXTRA_VPA_DATA = "vpa-data";
    public static String FACEBOOK_PACKAGE_NAME = "com.facebook.katana";
    public static final String FEATURE_TYPE_LINK_BANK_LIST = "linkBank";
    public static final String FEATURE_TYPE_REQUEST_MONEY = "request";
    public static final String FEATURE_TYPE_TRANSACTION_DETAIL = "transactiondetail";
    public static final String FEATURE_TYPE_VIEW_LINKED_BANK_ACCOUNTS = "viewLinkedBanks";
    public static final String FLAG_ACTIVITY_CLEAR_TOP = "FLAG_ACTIVITY_CLEAR_TOP";
    public static final String FLAG_ACTIVITY_NEW_TASK = "FLAG_ACTIVITY_CLEAR_TOP";
    public static final String FONT_FAMILY_SANS_SERIF = "sans-serif";
    public static final String FONT_FAMILY_SANS_SERIF_LIGHT = "sans-serif-light";
    public static final String FONT_FAMILY_SANS_SERIF_MEDIUM = "sans-serif-medium";
    public static final String FROM = "From";
    public static final String GTM_EVENT_ACTION_BANK_SELECTED = "bank_selected";
    public static final String GTM_EVENT_ACTION_CREATE_UPI_CLICKED = "create_upi_proceed_clicked";
    public static final int GTM_FROM_BANK = 100;
    public static final String GTM_SCREEN_VIEW_BANK_ACCOUNT_LINKED_SUCCESS = "/vpa-bank/success";
    public static final String GTM_SCREEN_VIEW_CREATE_VPA = "/vpa-bank/create-upi";
    public static final String GTM_SCREEN_VIEW_LINK_BANK_DIALOG = "/vpa-bank";
    public static final String GTM_SCREEN_VIEW_SENDING_SMS = "/vpa-bank/sms";
    public static final String INACTIVE_USER = "inactive_User";
    public static final String INTENT_ACTION_REFRESH_LINKED_ACCOUNTS = "action_refresh_linked_accounts";
    public static final String INTENT_EXTRA_CST_MINIMIZE_TRANSACTION = "intent_extra_cst_minimize_transaction";
    public static final String INTENT_EXTRA_CST_ORDER_ITEM = "intent_extra_cst_order_item";
    public static final String INTENT_EXTRA_CST_ORDER_REASONS = "intent_extra_cst_order_reasons";
    public static final String INTENT_EXTRA_CST_ORDER_REASONS_L2 = "intent_extra_cst_order_reasons_l2";
    public static final String IS_FROM_SCAN = "is_from_scan";
    public static final String IS_GALLERY_SCAN = "isGalleryScan";
    public static final String IS_MID_SCAN = "isMidScan";
    public static final String KEY_CHANNEL = "channel";
    public static final String KEY_INTENT_PARAMS = "key_intent_params";
    public static final String KEY_IS_SCAN_ONLY = "scan_only";
    public static final String KEY_LIST_KEYS_RESPONSE = "list_keys_response";
    public static final String KEY_MOBILE = "mobile";
    public static final String KEY_PROFILE_VPA_INFO = "profile_vpa_info";
    public static final String KEY_SHARED_PREF_UPI_REQUEST_NOTIFICATION_COUNT = "notification_icon_count";
    public static final String KEY_SHARED_PREF_UPI_TOKEN = "upi_token";
    public static final String KEY_SHARED_PREF_UPI_TOKEN_CREATION_TIME = "upi_token_creation_time";
    public static final String KEY_SHARED_PREF_VPA_INFO = "vpa_info";
    public static final String KEY_STORE_CURRENT_STATUS = "upi_current_status";
    public static final String KEY_UPI_ITEM_TYPE = "upi_item_type";
    public static final String KEY_UPI_PROFILE_INFO = "profile_info";
    public static final String KEY_VERSION = "version";
    public static final String LOCAL_BROADCAST_ACTION_UPI_PAYMENT_VIA_MERCHANT = "action_payment_via_merchant";
    public static final int MANAGING_MY_PAYTM_BHIM_UPI_PROFILE = 1000520;
    public static final String MONEY_TRANSFER_HEADER = "money_transfer_header";
    public static final String MP_ANDROID = "MP-ANDROID";
    public static String MSG_PACKAGE_NAME = "com.facebook.orca";
    public static final String NETWORK_ERROR_CODE = "700";
    public static final String PAYTM_ORG_ID = "153006";
    public static final String PENDING_REQUEST_CHANNEL = "channel";
    public static final String PENDING_REQUEST_CUST_ID = "cust-id";
    public static final int PERMISSIONS_REQUEST_READ_PHONE_STATE = 16;
    public static final int PERMISSIONS_REQUEST_SEND_SMS = 32;
    public static final int PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 48;
    public static final String PREF_KEY_IS_BANK_ACCOUNT_ADDED = "is_bank_account_added";
    public static final String PREF_KEY_IS_MPIN_SET = "is_mpin_set";
    public static final String PREF_KEY_IS_PROFILE_EXIST = "is_profile_exist";
    public static final String PREF_KEY_IS_SAME_DEVICE = "is_same_device";
    public static final String PREF_KEY_IS_SELECT_BANK_DIALOG_INTERVAL = "is_select_bank_interval";
    public static final String PREF_KEY_IS_SELECT_BANK_DIALOG_TIME = "is_select_bank_time";
    public static final String PREF_KEY_IS_UPI_PROFILE_TIP_CLICKED = "is_upi_profile_tip_clicked";
    public static final String PREF_KEY_IS_UPI_USER = "is_upi_user";
    public static final String PREF_KEY_SETMPIN_VISIBLE_FLAG = "setmpin_dialog_flag";
    public static final String PREF_KEY_UPI_QR_HOME_DIALOG_TIME = "upi_qr_home_dialog_time";
    public static final String PREF_UPI_SCAN_PAY_POPUP = "upi_scan_pay_popup";
    public static final String PREF_UPI_SECURITY_POPUP = "upi_security_popup";
    public static final String PUSH_FEATURE_TYPE = "featuretype";
    public static final String QR_KEY = "1234567890123456";
    public static final int QR_KEY_BLACK = -16777216;
    public static final int QR_KEY_BLUE = -16700558;
    public static final long QR_KEY_EXPIRE = 21600000;
    public static final int QR_KEY_WHITE = -1;
    public static final String REFUND_TO_SOURCE = "refund_to_source";
    public static final int REQUEST_CODE_ADD_BANK = 304;
    public static final int REQUEST_CODE_BANK_DETAIL = 320;
    public static final int REQUEST_CODE_DEREGISTER = 5001;
    public static final int REQUEST_CODE_MONEY_TRANSFER = 50001;
    public static final int REQUEST_CODE_SELECT_BANK = 288;
    public static final int REQUEST_CODE_UPI_LANDING_PAGE = 1212;
    public static final int REQUEST_CODE_UPI_ONBOARDING = 352;
    public static final int REQUEST_DEVICE_REGISTRATION_FROM_MONEY_TRANSFER_CONTACT_LIST = 128;
    public static final int REQUEST_DEVICE_REGISTRATION_FROM_MONEY_TRANSFER_LINKED_ACCOUNT = 112;
    public static final int REQUEST_DEVICE_REGISTRATION_FROM_REQUEST_MONEY = 64;
    public static final int REQUEST_DEVICE_REGISTRATION_FROM_TRANSFER_MONEY = 80;
    public static final int REQUEST_DEVICE_REGISTRATION_FROM_UPI_PROFILE = 144;
    public static final int REQUEST_DEVICE_REGISTRATION_SKIP_SIM_SELECTION = 288;
    public static final String REQUEST_ID = "requestId";
    public static final int REQUEST_OPEN_APP_PERMISSION_READ_PHONE_STATE = 272;
    public static final int REQUEST_OPEN_APP_PERMISSION_READ_SMS = 256;
    public static final String REQUEST_TOKEN = "Request-Token";
    public static final String SESSION_TOKEN = "session_token";
    public static final int SIX_DIGIT_CARD_LEN = 6;
    public static final int SOURCE_SELF_ACCOUNT_ON_UPI_DISABLE = 113;
    public static final String SSO_TOKEN = "sso-token";
    public static final int START_INDEX_ONE = 1;
    public static final int START_INDEX_THREE = 3;
    public static final int START_INDEX_TWO = 2;
    public static final int START_INDEX_ZERO = 0;
    public static final String SUCCESS = "SUCCESS";
    public static final String TIMESTAMP = "timestamp";
    public static final int TWO_DIGIT_MONTH = 2;
    public static final int TWO_DIGIT_YEAR = 2;
    public static String TW_PACKAGE_NAME = "com.twitter.android";
    public static final String UPI_APP_ID = "net.one97.paytm";
    public static final String UPI_INITIAL_TOKEN = "initial";
    public static final String UPI_IS_SHOW_SELECT_BANK_BOTTOM_SHEET_ON_LAUNCH = "isToShowSelectBankBottomSheetOnLaunch";
    public static final String UPI_IS_VERIFIED_MERCHANT = "isVerifiedMerchant";
    public static final String UPI_NEED_HELP_URL = "https://paytm.com/offer/paytm-upi-faq/#account-setup";
    public static final String UPI_ONBOARDING_SELF_DESTROY = "paytmmp://self_destroy";
    public static final String UPI_RESET_TOKEN = "reset";
    public static final String UPI_ROTATE_TOKEN = "rotate_assist";
    public static final String UPI_SETTINGS_SMART_TRANSFER_PREFERENCE = "SMART_ACCOUNT_SELECTION";
    public static final String UPI_SETTINGS_WALLET_USER_PREFERENCE = "ppbl.money_transfer.receive_money.wallet_preference";
    public static final String UPI_SOURCE = "upi_source";
    public static final String URI_IS_ORDER_CREATED_KEY = "orderAlreadyCreated";
    public static final String URI_MID_KEY = "mid";
    public static final String URL = "url";
    public static final String URL_TYPE_BRANCH_SHARE = "branchShare";
    public static final String URL_TYPE_CASH_WALLET = "cash_wallet";
    public static final String URL_TYPE_QR_LANDING = "upi_qr_landing";
    public static final String USER_PROFILE_PIC_FILENAME = "/profilePicture.jpg";
    public static final String USER_TOKEN = "usertoken";
    public static final int VPA_CREATIION_FROM_REQUEST_MONEY = 96;
    public static final String WALLET_TYPE_MONEY_TRANSFER = "money_transfer";
    public static String WT_PACKAGE_NAME = "com.whatsapp";

    public static class CLConstants {
        public static final String KEY_ATMPIN = "ATMPIN";
        public static final String KEY_MPIN = "MPIN";
        public static final String KEY_NEW_MPIN = "NMPIN";
        public static final String KEY_OTP = "OTP";
        public static final String KEY_SMS = "SMS";
        public static final String SALT_DELIMETER = "|";
    }

    public enum MoneyTransferPaymentOption {
        IMPS,
        UPI,
        ALL
    }

    public enum PROFILE_STATE {
        CHECK_VPA,
        ADD_BANK
    }

    public static class RefreshAccountOperations {
        public static final String SYNC_BANK_FORMAT = "SYNC_BANK_FORMAT";
        public static final String SYNC_MPIN_ACCOUNT = "SYNC_MPIN_ACCOUNT";
    }

    public enum RegistrationErrorOrigin {
        SMS_NOT_SENT,
        MOBIlE_NOT_REGISTERED,
        VERIFY_MOBILE_NUMBER,
        NO_SIM_INSTALLED,
        SMS_NOT_RECEIVED,
        SMS_TOKEN_EXPIRED,
        NPCI_OR_TOKEN_ERROR,
        ADD_ACCOUNT_TECHNICAL_ERROR,
        ADD_ACCOUNT_CONNECTION_ERROR,
        OTHER_ERROR,
        NETWORK_CONNECTION_ERROR,
        SETUP_PROFILE_ERROR,
        NON_COMPLIANT_APP_VERSION_FOR_DEVICE_BINDING,
        UNIQUE_MOBILE_NUMBER_ALLOWED_LIMIT_AGAINST_DEVICE_ID_BREACHED
    }

    public static class SignUpStepCodes {
        public static final String CREATE_VPA = "CREATE_VPA";
        public static final String FETCH_ACCOUNT = "FETCH_ACCOUNT";
        public static final String LINK_ACCOUNT = "LINK_ACCOUNT";
        public static final String REGISTER_DEVICE = "REGISTER_DEVICE";
    }

    public static class UPI_GA_CONSTANTS {
        public static final String ACTIVE_USER = "activeUser";
        public static final String DEVICE_NOT_REGISTERED = "deviceNotRegistered";
        public static final String INACTIVE_USER = "inactiveUser";
        public static final String MPIN_AND_DEVICE_BINDING_NOT_FOUND = "mpinAndDeviceBindingNotFound";
        public static final String MPIN_NOT_FOUND = "mpinNotFound";
        public static final String NO_BANK_AND_DEVICE_BINDING_FOUND = "noBankAndDeviceBindingFound";
        public static final String NO_BANK_FOUND = "noBankFound";
        public static final String USER_NOT_ONBOARDED = "userNotOnboarded";
        public static final String USER_STATE_DEFAULT = "userStateDefault";
    }

    public static class UPI_SIGNUP_ONBOARDING_CALLBACKS {
        public static final int BACK = 3;
        public static final int FAILURE = 1;
        public static final int SKIP = 2;
        public static final int SUCCESS = 0;
    }

    public static class UPI_SIGNUP_ONBOARDING_CASES {
        public static final int ACCOUNT_LINKED_SUCCESSFULLY = 3;
        public static final int BANK_NOT_LINKED = 2;
        public static final int COMMON_ERROR = 0;
        public static final int MPIN_NOT_SET = 1;
    }

    public static class UPI_SOURCE_MAPPING {
        public static final String BHARAT_QR_SCAN_SOURCE = "bharat_qr";
        public static final String DEEPLINK_SOURCE = "deep_link";
        public static final String DEFAULT_SOURCE = "source_default";
        public static final String INTENT_FLOW_SOURCE = "intent";
        public static final String PAYTM_QR_SCAN_SOURCE = "paytm_qr";
    }

    public static class UPI_SOURCE_VALUES {
        public static final int BHARAT_QR_SCAN_SOURCE = 2;
        public static final int DEEPLINK_SOURCE = 3;
        public static final int INTENT_FLOW_SOURCE = 0;
        public static final int PAYTM_QR_SCAN_SOURCE = 1;
    }

    public enum UpiDeviceBindingState {
        NO_RESPONSE,
        IN_PROGRESS,
        DEVICE_BINDING_SUCCESS,
        DEVICE_BINDING_FAILED
    }

    public enum UpiExpireSmsTokenState {
        NO_RESPONSE,
        IN_PROGRESS,
        TOKEN_EXPIRE_SUCCESS,
        TOKEN_EXPIRE_FAILED
    }

    public enum UpiItemType {
        TRANSACTIONS,
        PENDING_REQUESTS,
        PENDING_REQUESTS_RECEIVED,
        PENDING_REQUESTS_SENT,
        SPAM_REQUESTS
    }

    public enum UpiVpaValidationError {
        EMPTY_VPA,
        MAX_LENGTH_BREACH,
        ALPHANUMERIC_ERROR,
        INVALID_CHARS
    }

    public enum SourceOfOnBoarding {
        MONEY_TRANSFER(1),
        WALLET_SIGNUP(2),
        UPI_ONBOARDING(3);
        
        private int getVal;

        private SourceOfOnBoarding(int i2) {
            this.getVal = i2;
        }

        public final int getVal() {
            return this.getVal;
        }
    }

    public enum FAVORITE_BANKS {
        PAYTM_PAYMENT_BANK(1, "PYTM", "Paytm Payments Bank", "", -1),
        HDFC_BANK(2, "HDFC", "HDFC", "ic_bank_hdfc", R.drawable.ic_bank_hdfc),
        ICICI_BANK(3, "ICIC", "ICICI", "ic_bank_icici", R.drawable.ic_bank_icici),
        AXIS_BANK(4, "UTIB", "AXIS", "ic_bank_axis_bank", R.drawable.ic_bank_axis_bank),
        SBI_BANK(5, "SBIN", "State Bank of India", "ic_bank_sbi", R.drawable.ic_bank_sbi),
        YES_BANK(6, "YESB", "YesBank", "ic_bank_yes_bank", R.drawable.ic_bank_yes_bank),
        PNB(7, "PUNB", "Punjab National Bank", "", -1),
        BOB(8, "BARB", "Bank of Baroda", "ic_bank_of_baroda", R.drawable.ic_bank_of_baroda);
        
        private final String mAccountProvider;
        private final int mBankPriority;
        private final String mDrawableName;
        private final int mIconId;
        private final String mIfscCode;

        private FAVORITE_BANKS(int i2, String str, String str2, String str3, int i3) {
            this.mBankPriority = i2;
            this.mIfscCode = str;
            this.mAccountProvider = str2;
            this.mDrawableName = str3;
            this.mIconId = i3;
        }

        public final String getIfscCode() {
            return this.mIfscCode;
        }

        public final String getAccountProvider() {
            return this.mAccountProvider;
        }

        public final String getDrawableName() {
            return this.mDrawableName;
        }

        public final int getDrawableId() {
            return this.mIconId;
        }
    }

    public enum PROFILE_VPA_ACCOUNT_TYPE {
        DEBIT("debit"),
        CREDIT("credit");
        
        private final String type;

        private PROFILE_VPA_ACCOUNT_TYPE(String str) {
            this.type = str;
        }

        public final String getType() {
            return this.type;
        }
    }

    public enum BANK_ACCOUNT_TYPE {
        SAVINGS("SAVINGS", R.string.upi_savings_account_type_placeholder, R.string.upi_savings_account_name),
        CURRENT("CURRENT", R.string.upi_current_account_type_placeholder, R.string.upi_current_account_name),
        DEFAULT(SDKConstants.GA_KEY_DEFAULT, R.string.upi_default_account_type_placeholder, R.string.upi_default_account_name),
        NRE("NRE", R.string.upi_nre_account_type_placeholder, R.string.upi_nre_account_name),
        NRO("NRO", R.string.upi_nro_account_type_placeholder, R.string.upi_nro_account_name),
        CREDIT("CREDIT", R.string.upi_credit_account_type_placeholder, R.string.upi_credit_account_name),
        PPIWALLET("PPIWALLET", R.string.upi_wallet_account_type_placeholder, R.string.upi_wallet_account_name),
        BANKWALLET("BANKWALLET", R.string.upi_wallet_account_type_placeholder, R.string.upi_wallet_account_name),
        SOD("SOD", R.string.upi_sod_account_type_placeholder, R.string.upi_sod_account_name),
        UOD("UOD", R.string.upi_uod_account_type_placeholder, R.string.upi_uod_account_name);
        
        private final int accDisplayStringId;
        private final int nameDisplayStringId;
        private final String type;

        private BANK_ACCOUNT_TYPE(String str, int i2, int i3) {
            this.type = str;
            this.accDisplayStringId = i2;
            this.nameDisplayStringId = i3;
        }

        public final int getAccDisplayStringId() {
            return this.accDisplayStringId;
        }

        public final int getNameDisplayStringId() {
            return this.nameDisplayStringId;
        }

        public final String getType() {
            return this.type;
        }
    }

    public enum UpiTxnHistoryV2Entity {
        VPA("vpa"),
        ACC_NO("bankAccount"),
        MOBILE("mobileNumber"),
        TXNID("txnId");
        
        public final String type;

        private UpiTxnHistoryV2Entity(String str) {
            this.type = str;
        }

        public final String getType() {
            return this.type;
        }
    }
}
