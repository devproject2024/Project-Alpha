package net.one97.paytm.upi.util;

public final class Events {
    public static final Events INSTANCE = new Events();

    private Events() {
    }

    public static final class Category {
        public static final String COLLECT = "upi_collect_pay_v1";
        public static final Category INSTANCE = new Category();
        public static final String INTENT = "upi_intent_pay_v1";

        private Category() {
        }
    }

    public static final class Screen {
        public static final String BOTTOMSHEET = "/mt_bottomsheet";
        public static final String ENTER_AMOUNT = "/mt_enter_amt_screen";
        public static final Screen INSTANCE = new Screen();
        public static final String MT_HOMEPAGE = "/mt_homepage";
        public static final String NONE = "none";
        public static final String PAYMENT_REQUEST_PAGE = "/mt_upi_payment_requests_page";
        public static final String PAYTM_HOMEPAGE = "/homepage_pop_up";
        public static final String POST_TRANSACTION = "/mt_post-transaction";
        public static final String POST_TRANSACTION_BOTTOMSHEET = "/mt_post-transaction_bottom_sheet";
        public static final String SECURITY_POPUP = "/mt_enter_amt_screen-security-pop-up";
        public static final String SPAM_FOLDER = "/mt_upi_spam_folder_page";
        public static final String UPI_SETTINGS_PAGE = "/mt_upi_settings_page";

        private Screen() {
        }
    }

    public static final class Action {
        public static final String BACK_ARROW_CLICKED = "back_arrow_clicked";
        public static final String BACK_TO_HOME_CLICKED = "back_to_home_clicked";
        public static final String BOTTOMSHEET_PROCEED_CLICKED = "proceed_bottomsheet_clicked";
        public static final String BOTTOMSHEET_TAP_OUTSIDE = "bottomsheet_close_tap_outside";
        public static final String CHECK_BALANCE_CLICKED = "check_balance_clicked";
        public static final String COLLECT_REQ_DECLINE_CLICKED = "collect_request_decline_click";
        public static final String COLLECT_REQ_PAY_CLICKED = "collect_request_pay_click";
        public static final String COLLECT_REQ_SPAM_CLICKED = "collect_request_mark_spam_click";
        public static final String COLLECT_REQ_SPAM_CONFIRM_CLICKED = "collect_request_mark_spam_confirm_click";
        public static final String DEEPLINK_OPENED = "deeplink_opened";
        public static final String DOWN_ARROW_CLICKED = "down_arrow_clicked";
        public static final Action INSTANCE = new Action();
        public static final String INVITE_CLICKED = "invite_cta_clicked";
        public static final String MAKE_NEW_PAYMENT = "make_new_payment";
        public static final String NEED_HELP_CLICKED = "need_help_clicked";
        public static final String PROCEED_CLICKED = "proceed_clicked";
        public static final String REDIRECTED_TO_ONBOARDINNG = "redirected_to_onboarding";
        public static final String SCREEN_OPEN = "screen_open";
        public static final String SCREEN_OPEN_WITH_ERROR = "screen_open_with_error";
        public static final String SECURITY_POPUP_PROCEED_CLICKED = "security_pop_up_proceed_clicked";
        public static final String SHARE_CLICKED = "share_clicked";
        public static final String UPI_PAYMENT_HISTORY_CLICKED = "upi_payment_history_clicked";
        public static final String UPI_PIN_REENTERED = "UPI_pin_reentered";
        public static final String VIEW_TXN_DETAILS = "view_txn_details";

        private Action() {
        }
    }

    public static final class Label {
        public static final String ADD_N_PAY = "Add & pay";
        public static final String BANK_NOT_LINKED = "bank_not_linked";
        public static final String DEVICE_NOT_BINDED = "device_not_binded";
        public static final String HOMEPAGE_POPUP = "homepage_pop_up";
        public static final Label INSTANCE = new Label();
        public static final String LINK_BANK_ACCOUNT = "Link bank account";
        public static final String MPIN_NOT_SET = "mpin_not_set";
        public static final String MT_HOMEPAGE = "mt_homepage";
        public static final String NOT_ONBOARDED = "not_onboarded";
        public static final String PAY = "Pay";
        public static final String PAYMENT_REQ = "payment_request_screen";
        public static final String REACTIVATE = "Reactivate";

        private Label() {
        }
    }
}
