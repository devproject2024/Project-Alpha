package net.one97.paytm.upi.util;

public class GAConstants {

    public static class CATEGORY {
        public static final String MT_ONB_DEVICE_BINDING = "mt_onb_device_binding";
        public static final String MT_ONB_V1 = "mt_onb_new_v1_onb";
        public static final String MT_P2P_NEW_V1 = "mt_p2p_new_v1";
        public static final String UPI_MT_AUTOMATIC_PAYMENTS = "/Automatic_Payment_Section";
        public static final String UPI_MT_AUTOMATIC_PAYMENT_COLLECT = "/Automatic_Payment_Collect_Creation";
        public static final String UPI_MT_AUTOMATIC_PAYMENT_COLLECT_EXECUTION = "/Automatic_Payment_Collect_Execution";
        public static final String UPI_MT_AUTOMATIC_PAYMENT_INTENT = "/Automatic_Payment_Intent_Creation";
        public static final String UPI_MT_AUTOMATIC_PAYMENT_UPDATE = "/Automatic_Payment_Collect_Update";
        public static final String UPI_ONB_V1 = "upi_onb_v1";
    }

    public static class CommonAction {
        public static final String SCREEN_OPEN = "screen_open";
    }

    public static class SCREEN_NAME {
        public static final String BANK_DETAIL_PAGE = "/upi_profile_bank_page";
        public static final String BANK_LIST_SCREEN = "/upi_bank_list";
        public static final String UPI_ACC_SWITCH_LOGIN = "/bank_account_not_found_dropup_opened";
        public static final String UPI_ADD_BANK_POPUP = "/upi_add_bank_acc_popup";
        public static final String UPI_ADD_NEW_BANK = "/add_new_bank_account_list";
        public static final String UPI_BENEFITS = "/upi_benefits_page_onboarding_new";
        public static final String UPI_FETCH_ACCOUNTS = "/fetching_bank_account_half_screen_timer";
        public static final String UPI_LANDING_PAGE = "/upi_profile";
        public static final String UPI_MT_AUTOMATIC_DECLINE_BS = "/Automatic_Payment_create_Decline bottomsheet";
        public static final String UPI_MT_AUTOMATIC_PAYMENTS = "/mt_upi_automatic_payments";
        public static final String UPI_MT_AUTOMATIC_PAYMENT_CREATE_BS = "/Automatic_Payment_create_bottomsheet";
        public static final String UPI_MT_AUTOMATIC_PAYMENT_CREATE_CONFIRMATION = "/Automatic_Payment_create_confirmation";
        public static final String UPI_MT_AUTOMATIC_PAYMENT_EXECUTION_BS = "/Automatic_Payment_Execution_bottomsheet";
        public static final String UPI_MT_AUTOMATIC_PAYMENT_EXECUTION_POST_TXN = "/Automatic_Payment_Execution_post-transaction";
        public static final String UPI_MT_AUTOMATIC_PAYMENT_INTENT = "/Automatic_Payment_create_confirmation_Intent";
        public static final String UPI_MT_AUTOMATIC_PAYMENT_PAUSE_BS = "/mt_upi_automatic_payments_pause_bottomsheet";
        public static final String UPI_MT_AUTOMATIC_PAYMENT_PAUSE_POST_TXN = "/mt_upi_automatic_payments_pause_post-transaction";
        public static final String UPI_MT_AUTOMATIC_PAYMENT_PAYER_UPDATE_BS = "/mt_upi_automatic_payments_payer-update_bottomsheet";
        public static final String UPI_MT_AUTOMATIC_PAYMENT_POST_TXN = "/Automatic_Payment_create_post-transaction";
        public static final String UPI_MT_AUTOMATIC_PAYMENT_RESUME_BS = "/mt_upi_automatic_payments_Resume_bottomsheet";
        public static final String UPI_MT_AUTOMATIC_PAYMENT_RESUME_POST_TXN = "/mt_upi_automatic_payments_Resume_post-transaction";
        public static final String UPI_MT_AUTOMATIC_PAYMENT_REVOKE_BS = "/mt_upi_automatic_payments_Revoke_bottomsheet";
        public static final String UPI_MT_AUTOMATIC_PAYMENT_REVOKE_POST_TXN = "/mt_upi_automatic_payments_Revoke_post-transaction";
        public static final String UPI_MT_AUTOMATIC_PAYMENT_UPDATE_POST_TXN = "/mt_upi_automatic_payments_payer-update_post-transaction";
        public static final String UPI_MULTIPLE_ACC_LINK = "/bank_account_linked_final_screen";
        public static final String UPI_NO_BANK_ACC_FOUND = "/bank_account_not_found";
        public static final String UPI_ONBOARDING_COMPLETED = "/upi_onb_congrats";
        public static final String UPI_ONB_BANK_ACCOUNT_DISCOVERED = "/upi_onb_bank_account_discovered";
        public static final String UPI_ONB_CONGRATS = "/upi_onb_congrats";
        public static final String UPI_ONB_DEVICE_BINDING_PROCESS = "/upi_onb_device_binding_process";
        public static final String UPI_ONB_SET_MPIN = "/upi_onb_set_mpin";
        public static final String UPI_ONB_SET_PRIMARY_ACCOUNT = "/upi_onb_select_primary_account";
        public static final String UPI_ONB_SIM_SELECTION_INTERNAL = "/upi_onb_sim_selection_internal_flow";
        public static final String UPI_ONB_SIM_SELECTION_SIGN_UP = "/upi_onb_sim_selection_signup_flow";
        public static final String UPI_PROFILE_INVITE_PAGE = "/upi_profile_invitiation_screen";
        public static final String UPI_TRANSFER_TO_BANK_ACC = "/mt_p2p_to_bank_acc";
    }

    public class ACTION {
        public static final String ACCOUNT_SWITCH_LOGIN = "account_switch_login";
        public static final String ADD_BANK_ACC_CLICKED_LINK_ACC_SCREEN = "add_new_bank_account_clicked_on_linked_bank_screen";
        public static final String BANK_ACC_DROPUP_ACTION_CLICKED = "bank_account_drop_up_action_clicked";
        public static final String BANK_ACC_LINKED_FAILURE = "bank_account_linked_failure";
        public static final String BANK_ACC_LINKED_SUCCESS = "bank_account_linked_sucess";
        public static final String BANK_ACC_NOT_FOUND_CTA_CLICK = "bank_account_not_found_action";
        public static final String BANK_AC_LINKED_PROCEED_CLICKED = "link_bank_proceed_clicked";
        public static final String BANNER_CLICKED = "banner_clicked";
        public static final String LINK_ACC_PROCEED_CLICKED = "proceed_on_linked_bank_clicked";
        public static final String ONB_APP_BACK_BUTTON_CLICKED = "app_back_button_clicked";
        public static final String ONB_BACK_BUTTON_CLICKED = "back_button_clicked";
        public static final String OTHER_BANK_SELECTED = "other_bank_selected";
        public static final String RETRY = "retry";
        public static final String SCREEN_OPEN = "screen_open";
        public static final String SIM_ICON_CLICKED = "sim_icon_clicked";
        public static final String SIM_SELECTED_SLOT = "sim_selected_slot";
        public static final String SKIP_CLICKED = "skip_clicked";
        public static final String TOP_BANK_SELECTED = "top_bank_selected";

        public ACTION() {
        }
    }

    public class LABEL {
        public static final String ACCOUNT_LOGIN = "account_login";
        public static final String ACCOUNT_REPLACE = "account_replace";

        public LABEL() {
        }
    }
}
