package com.business.merchant_payments;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.databinding.e;
import com.alipay.mobile.h5container.api.H5Param;
import com.business.merchant_payments.databinding.FragmentSettlementDetailBindingImpl;
import com.business.merchant_payments.databinding.MpActivityAddMobileOtpBindingImpl;
import com.business.merchant_payments.databinding.MpActivityEmailSmsNotificationBindingImpl;
import com.business.merchant_payments.databinding.MpActivityNotificationBindingImpl;
import com.business.merchant_payments.databinding.MpActivityPaymentLinkBindingImpl;
import com.business.merchant_payments.databinding.MpActivityPaymentListBindingImpl;
import com.business.merchant_payments.databinding.MpActivityPostQrScanBindingImpl;
import com.business.merchant_payments.databinding.MpActivityQrNotPrintedBindingImpl;
import com.business.merchant_payments.databinding.MpAddMobileActivityBindingImpl;
import com.business.merchant_payments.databinding.MpBottomsheetPracticesForSettleNowBindingImpl;
import com.business.merchant_payments.databinding.MpBottomsheetSettlementOnholdBindingImpl;
import com.business.merchant_payments.databinding.MpBwAlreadySettledElementBindingImpl;
import com.business.merchant_payments.databinding.MpBwItemSettlementDetailBindingImpl;
import com.business.merchant_payments.databinding.MpBwSettlementAmountToHoldDialogBindingImpl;
import com.business.merchant_payments.databinding.MpBwSettlementDetailItemBindingImpl;
import com.business.merchant_payments.databinding.MpBwSettlementDetailNewBindingImpl;
import com.business.merchant_payments.databinding.MpBwSettlementSingleBankElementBindingImpl;
import com.business.merchant_payments.databinding.MpBwSettlementSummaryCardBindingImpl;
import com.business.merchant_payments.databinding.MpCommonOverlayDialogBindingImpl;
import com.business.merchant_payments.databinding.MpCustomAlertDialogBindingImpl;
import com.business.merchant_payments.databinding.MpCustomSnackbarViewBindingImpl;
import com.business.merchant_payments.databinding.MpDialogDownloadBusinessAppBindingImpl;
import com.business.merchant_payments.databinding.MpDialogOrderQrCodeNowBindingImpl;
import com.business.merchant_payments.databinding.MpDotProgressBarLytBindingImpl;
import com.business.merchant_payments.databinding.MpEmailSmsListItemBindingImpl;
import com.business.merchant_payments.databinding.MpEmbedWebViewActivityBindingImpl;
import com.business.merchant_payments.databinding.MpFragmentMessageSheetBindingImpl;
import com.business.merchant_payments.databinding.MpFragmentOtpEditboxesLytBindingImpl;
import com.business.merchant_payments.databinding.MpFragmentRequestMoneyBindingImpl;
import com.business.merchant_payments.databinding.MpFragmentSaveFeedbackBindingImpl;
import com.business.merchant_payments.databinding.MpInitiateRefundNewBindingImpl;
import com.business.merchant_payments.databinding.MpLayoutVerifyQrPopupBindingImpl;
import com.business.merchant_payments.databinding.MpNoSettlementsDataViewBindingImpl;
import com.business.merchant_payments.databinding.MpNotificationItemViewBindingImpl;
import com.business.merchant_payments.databinding.MpOnlineSettlementElementBindingImpl;
import com.business.merchant_payments.databinding.MpOnlineSettlementSummaryCardBindingImpl;
import com.business.merchant_payments.databinding.MpPaymentInfoTileBindingImpl;
import com.business.merchant_payments.databinding.MpPaymentNotificationBottomsheetBindingImpl;
import com.business.merchant_payments.databinding.MpPaymentSettlementTabsBindingImpl;
import com.business.merchant_payments.databinding.MpPaymentsEmptyLayoutBindingImpl;
import com.business.merchant_payments.databinding.MpPaymentsHeaderLayoutBindingImpl;
import com.business.merchant_payments.databinding.MpPaymentsHomeHeaderBindingImpl;
import com.business.merchant_payments.databinding.MpPaymentsListEmptyLayoutBindingImpl;
import com.business.merchant_payments.databinding.MpPaymentsLoaderLayoutBindingImpl;
import com.business.merchant_payments.databinding.MpPaymentsPermissionDeniedLayoutBindingImpl;
import com.business.merchant_payments.databinding.MpPaymentsShowMoreLayoutBindingImpl;
import com.business.merchant_payments.databinding.MpPaymentsSummaryLayoutBindingImpl;
import com.business.merchant_payments.databinding.MpPaymentsTransactionItemBindingImpl;
import com.business.merchant_payments.databinding.MpPaymentssSummeryItemBindingImpl;
import com.business.merchant_payments.databinding.MpPendingSettlementCardItemBindingImpl;
import com.business.merchant_payments.databinding.MpProfileQrPagerItemLayoutBindingImpl;
import com.business.merchant_payments.databinding.MpQrDetailBindingImpl;
import com.business.merchant_payments.databinding.MpQrPaymentListHeaderBindingImpl;
import com.business.merchant_payments.databinding.MpQrViewBindingImpl;
import com.business.merchant_payments.databinding.MpQrViewNewBindingImpl;
import com.business.merchant_payments.databinding.MpRadioBankNameBindingImpl;
import com.business.merchant_payments.databinding.MpReceiveForItemViewBindingImpl;
import com.business.merchant_payments.databinding.MpRefundDetailSubviewBindingImpl;
import com.business.merchant_payments.databinding.MpRefundDetailsViewNewBindingImpl;
import com.business.merchant_payments.databinding.MpRefundInitiatedNewBindingImpl;
import com.business.merchant_payments.databinding.MpReportDownloadBottomSheetBindingImpl;
import com.business.merchant_payments.databinding.MpRequestMoneyShimmerBindingImpl;
import com.business.merchant_payments.databinding.MpReversalDetailSubViewBindingImpl;
import com.business.merchant_payments.databinding.MpReversalDetailsViewNewBindingImpl;
import com.business.merchant_payments.databinding.MpSettlementElementShimmerBindingImpl;
import com.business.merchant_payments.databinding.MpSettlementRangeSummeryBindingImpl;
import com.business.merchant_payments.databinding.MpSettlementSummaryShimmerCardBindingImpl;
import com.business.merchant_payments.databinding.MpSmartGridBindingImpl;
import com.business.merchant_payments.databinding.MpSuccessPopupBindingImpl;
import com.business.merchant_payments.databinding.MpTitleTileBindingImpl;
import com.business.merchant_payments.databinding.MpToolbarNotificationBindingImpl;
import com.business.merchant_payments.databinding.MpTransactionDetailBindingImpl;
import com.business.merchant_payments.databinding.MpTransactionDetailSubViewBindingImpl;
import com.business.merchant_payments.databinding.MpViewCustomCardBindingImpl;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends d {
    public static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    public static final int LAYOUT_FRAGMENTSETTLEMENTDETAIL = 1;
    public static final int LAYOUT_MPACTIVITYADDMOBILEOTP = 2;
    public static final int LAYOUT_MPACTIVITYEMAILSMSNOTIFICATION = 3;
    public static final int LAYOUT_MPACTIVITYNOTIFICATION = 4;
    public static final int LAYOUT_MPACTIVITYPAYMENTLINK = 5;
    public static final int LAYOUT_MPACTIVITYPAYMENTLIST = 6;
    public static final int LAYOUT_MPACTIVITYPOSTQRSCAN = 7;
    public static final int LAYOUT_MPACTIVITYQRNOTPRINTED = 8;
    public static final int LAYOUT_MPADDMOBILEACTIVITY = 9;
    public static final int LAYOUT_MPBOTTOMSHEETPRACTICESFORSETTLENOW = 10;
    public static final int LAYOUT_MPBOTTOMSHEETSETTLEMENTONHOLD = 11;
    public static final int LAYOUT_MPBWALREADYSETTLEDELEMENT = 12;
    public static final int LAYOUT_MPBWITEMSETTLEMENTDETAIL = 13;
    public static final int LAYOUT_MPBWSETTLEMENTAMOUNTTOHOLDDIALOG = 14;
    public static final int LAYOUT_MPBWSETTLEMENTDETAILITEM = 15;
    public static final int LAYOUT_MPBWSETTLEMENTDETAILNEW = 16;
    public static final int LAYOUT_MPBWSETTLEMENTSINGLEBANKELEMENT = 17;
    public static final int LAYOUT_MPBWSETTLEMENTSUMMARYCARD = 18;
    public static final int LAYOUT_MPCOMMONOVERLAYDIALOG = 19;
    public static final int LAYOUT_MPCUSTOMALERTDIALOG = 20;
    public static final int LAYOUT_MPCUSTOMSNACKBARVIEW = 21;
    public static final int LAYOUT_MPDIALOGDOWNLOADBUSINESSAPP = 22;
    public static final int LAYOUT_MPDIALOGORDERQRCODENOW = 23;
    public static final int LAYOUT_MPDOTPROGRESSBARLYT = 24;
    public static final int LAYOUT_MPEMAILSMSLISTITEM = 25;
    public static final int LAYOUT_MPEMBEDWEBVIEWACTIVITY = 26;
    public static final int LAYOUT_MPFRAGMENTMESSAGESHEET = 27;
    public static final int LAYOUT_MPFRAGMENTOTPEDITBOXESLYT = 28;
    public static final int LAYOUT_MPFRAGMENTREQUESTMONEY = 29;
    public static final int LAYOUT_MPFRAGMENTSAVEFEEDBACK = 30;
    public static final int LAYOUT_MPINITIATEREFUNDNEW = 31;
    public static final int LAYOUT_MPLAYOUTVERIFYQRPOPUP = 32;
    public static final int LAYOUT_MPNOSETTLEMENTSDATAVIEW = 33;
    public static final int LAYOUT_MPNOTIFICATIONITEMVIEW = 34;
    public static final int LAYOUT_MPONLINESETTLEMENTELEMENT = 35;
    public static final int LAYOUT_MPONLINESETTLEMENTSUMMARYCARD = 36;
    public static final int LAYOUT_MPPAYMENTINFOTILE = 37;
    public static final int LAYOUT_MPPAYMENTNOTIFICATIONBOTTOMSHEET = 38;
    public static final int LAYOUT_MPPAYMENTSEMPTYLAYOUT = 40;
    public static final int LAYOUT_MPPAYMENTSETTLEMENTTABS = 39;
    public static final int LAYOUT_MPPAYMENTSHEADERLAYOUT = 41;
    public static final int LAYOUT_MPPAYMENTSHOMEHEADER = 42;
    public static final int LAYOUT_MPPAYMENTSLISTEMPTYLAYOUT = 43;
    public static final int LAYOUT_MPPAYMENTSLOADERLAYOUT = 44;
    public static final int LAYOUT_MPPAYMENTSPERMISSIONDENIEDLAYOUT = 45;
    public static final int LAYOUT_MPPAYMENTSSHOWMORELAYOUT = 46;
    public static final int LAYOUT_MPPAYMENTSSSUMMERYITEM = 49;
    public static final int LAYOUT_MPPAYMENTSSUMMARYLAYOUT = 47;
    public static final int LAYOUT_MPPAYMENTSTRANSACTIONITEM = 48;
    public static final int LAYOUT_MPPENDINGSETTLEMENTCARDITEM = 50;
    public static final int LAYOUT_MPPROFILEQRPAGERITEMLAYOUT = 51;
    public static final int LAYOUT_MPQRDETAIL = 52;
    public static final int LAYOUT_MPQRPAYMENTLISTHEADER = 53;
    public static final int LAYOUT_MPQRVIEW = 54;
    public static final int LAYOUT_MPQRVIEWNEW = 55;
    public static final int LAYOUT_MPRADIOBANKNAME = 56;
    public static final int LAYOUT_MPRECEIVEFORITEMVIEW = 57;
    public static final int LAYOUT_MPREFUNDDETAILSUBVIEW = 58;
    public static final int LAYOUT_MPREFUNDDETAILSVIEWNEW = 59;
    public static final int LAYOUT_MPREFUNDINITIATEDNEW = 60;
    public static final int LAYOUT_MPREPORTDOWNLOADBOTTOMSHEET = 61;
    public static final int LAYOUT_MPREQUESTMONEYSHIMMER = 62;
    public static final int LAYOUT_MPREVERSALDETAILSUBVIEW = 63;
    public static final int LAYOUT_MPREVERSALDETAILSVIEWNEW = 64;
    public static final int LAYOUT_MPSETTLEMENTELEMENTSHIMMER = 65;
    public static final int LAYOUT_MPSETTLEMENTRANGESUMMERY = 66;
    public static final int LAYOUT_MPSETTLEMENTSUMMARYSHIMMERCARD = 67;
    public static final int LAYOUT_MPSMARTGRID = 68;
    public static final int LAYOUT_MPSUCCESSPOPUP = 69;
    public static final int LAYOUT_MPTITLETILE = 70;
    public static final int LAYOUT_MPTOOLBARNOTIFICATION = 71;
    public static final int LAYOUT_MPTRANSACTIONDETAIL = 72;
    public static final int LAYOUT_MPTRANSACTIONDETAILSUBVIEW = 73;
    public static final int LAYOUT_MPVIEWCUSTOMCARD = 74;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(74);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.fragment_settlement_detail, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_activity_add_mobile_otp, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_activity_email_sms_notification, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_activity_notification, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_activity_payment_link, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_activity_payment_list, 6);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_activity_post_qr_scan, 7);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_activity_qr_not_printed, 8);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_add_mobile_activity, 9);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_bottomsheet_practices_for_settle_now, 10);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_bottomsheet_settlement_onhold, 11);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_bw_already_settled_element, 12);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_bw_item_settlement_detail, 13);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_bw_settlement_amount_to_hold_dialog, 14);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_bw_settlement_detail_item, 15);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_bw_settlement_detail_new, 16);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_bw_settlement_single_bank_element, 17);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_bw_settlement_summary_card, 18);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_common_overlay_dialog, 19);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_custom_alert_dialog, 20);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_custom_snackbar_view, 21);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_dialog_download_business_app, 22);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_dialog_order_qr_code_now, 23);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_dot_progress_bar_lyt, 24);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_email_sms_list_item, 25);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_embed_web_view_activity, 26);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_fragment_message_sheet, 27);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_fragment_otp_editboxes_lyt, 28);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_fragment_request_money, 29);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_fragment_save_feedback, 30);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_initiate_refund_new, 31);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_layout_verify_qr_popup, 32);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_no_settlements_data_view, 33);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_notification_item_view, 34);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_online_settlement_element, 35);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_online_settlement_summary_card, 36);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_payment_info_tile, 37);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_payment_notification_bottomsheet, 38);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_payment_settlement_tabs, 39);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_payments_empty_layout, 40);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_payments_header_layout, 41);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_payments_home_header, 42);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_payments_list_empty_layout, 43);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_payments_loader_layout, 44);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_payments_permission_denied_layout, 45);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_payments_show_more_layout, 46);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_payments_summary_layout, 47);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_payments_transaction_item, 48);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_paymentss_summery_item, 49);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_pending_settlement_card_item, 50);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_profile_qr_pager_item_layout, 51);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_qr_detail, 52);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_qr_payment_list_header, 53);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_qr_view, 54);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_qr_view_new, 55);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_radio_bank_name, 56);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_receive_for_item_view, 57);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_refund_detail_subview, 58);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_refund_details_view_new, 59);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_refund_initiated_new, 60);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_report_download_bottom_sheet, 61);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_request_money_shimmer, 62);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_reversal_detail_sub_view, 63);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_reversal_details_view_new, 64);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_settlement_element_shimmer, 65);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_settlement_range_summery, 66);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_settlement_summary_shimmer_card, 67);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_smart_grid, 68);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_success_popup, 69);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_title_tile, 70);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_toolbar_notification, 71);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_transaction_detail, 72);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_transaction_detail_sub_view, 73);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.mp_view_custom_card, 74);
    }

    private final ViewDataBinding internalGetViewDataBinding0(e eVar, View view, int i2, Object obj) {
        switch (i2) {
            case 1:
                if ("layout/fragment_settlement_detail_0".equals(obj)) {
                    return new FragmentSettlementDetailBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_settlement_detail is invalid. Received: ".concat(String.valueOf(obj)));
            case 2:
                if ("layout/mp_activity_add_mobile_otp_0".equals(obj)) {
                    return new MpActivityAddMobileOtpBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_activity_add_mobile_otp is invalid. Received: ".concat(String.valueOf(obj)));
            case 3:
                if ("layout/mp_activity_email_sms_notification_0".equals(obj)) {
                    return new MpActivityEmailSmsNotificationBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_activity_email_sms_notification is invalid. Received: ".concat(String.valueOf(obj)));
            case 4:
                if ("layout/mp_activity_notification_0".equals(obj)) {
                    return new MpActivityNotificationBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_activity_notification is invalid. Received: ".concat(String.valueOf(obj)));
            case 5:
                if ("layout/mp_activity_payment_link_0".equals(obj)) {
                    return new MpActivityPaymentLinkBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_activity_payment_link is invalid. Received: ".concat(String.valueOf(obj)));
            case 6:
                if ("layout/mp_activity_payment_list_0".equals(obj)) {
                    return new MpActivityPaymentListBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_activity_payment_list is invalid. Received: ".concat(String.valueOf(obj)));
            case 7:
                if ("layout/mp_activity_post_qr_scan_0".equals(obj)) {
                    return new MpActivityPostQrScanBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_activity_post_qr_scan is invalid. Received: ".concat(String.valueOf(obj)));
            case 8:
                if ("layout/mp_activity_qr_not_printed_0".equals(obj)) {
                    return new MpActivityQrNotPrintedBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_activity_qr_not_printed is invalid. Received: ".concat(String.valueOf(obj)));
            case 9:
                if ("layout/mp_add_mobile_activity_0".equals(obj)) {
                    return new MpAddMobileActivityBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_add_mobile_activity is invalid. Received: ".concat(String.valueOf(obj)));
            case 10:
                if ("layout/mp_bottomsheet_practices_for_settle_now_0".equals(obj)) {
                    return new MpBottomsheetPracticesForSettleNowBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_bottomsheet_practices_for_settle_now is invalid. Received: ".concat(String.valueOf(obj)));
            case 11:
                if ("layout/mp_bottomsheet_settlement_onhold_0".equals(obj)) {
                    return new MpBottomsheetSettlementOnholdBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_bottomsheet_settlement_onhold is invalid. Received: ".concat(String.valueOf(obj)));
            case 12:
                if ("layout/mp_bw_already_settled_element_0".equals(obj)) {
                    return new MpBwAlreadySettledElementBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_bw_already_settled_element is invalid. Received: ".concat(String.valueOf(obj)));
            case 13:
                if ("layout/mp_bw_item_settlement_detail_0".equals(obj)) {
                    return new MpBwItemSettlementDetailBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_bw_item_settlement_detail is invalid. Received: ".concat(String.valueOf(obj)));
            case 14:
                if ("layout/mp_bw_settlement_amount_to_hold_dialog_0".equals(obj)) {
                    return new MpBwSettlementAmountToHoldDialogBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_bw_settlement_amount_to_hold_dialog is invalid. Received: ".concat(String.valueOf(obj)));
            case 15:
                if ("layout/mp_bw_settlement_detail_item_0".equals(obj)) {
                    return new MpBwSettlementDetailItemBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_bw_settlement_detail_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 16:
                if ("layout/mp_bw_settlement_detail_new_0".equals(obj)) {
                    return new MpBwSettlementDetailNewBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_bw_settlement_detail_new is invalid. Received: ".concat(String.valueOf(obj)));
            case 17:
                if ("layout/mp_bw_settlement_single_bank_element_0".equals(obj)) {
                    return new MpBwSettlementSingleBankElementBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_bw_settlement_single_bank_element is invalid. Received: ".concat(String.valueOf(obj)));
            case 18:
                if ("layout/mp_bw_settlement_summary_card_0".equals(obj)) {
                    return new MpBwSettlementSummaryCardBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_bw_settlement_summary_card is invalid. Received: ".concat(String.valueOf(obj)));
            case 19:
                if ("layout/mp_common_overlay_dialog_0".equals(obj)) {
                    return new MpCommonOverlayDialogBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_common_overlay_dialog is invalid. Received: ".concat(String.valueOf(obj)));
            case 20:
                if ("layout/mp_custom_alert_dialog_0".equals(obj)) {
                    return new MpCustomAlertDialogBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_custom_alert_dialog is invalid. Received: ".concat(String.valueOf(obj)));
            case 21:
                if ("layout/mp_custom_snackbar_view_0".equals(obj)) {
                    return new MpCustomSnackbarViewBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_custom_snackbar_view is invalid. Received: ".concat(String.valueOf(obj)));
            case 22:
                if ("layout/mp_dialog_download_business_app_0".equals(obj)) {
                    return new MpDialogDownloadBusinessAppBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_dialog_download_business_app is invalid. Received: ".concat(String.valueOf(obj)));
            case 23:
                if ("layout/mp_dialog_order_qr_code_now_0".equals(obj)) {
                    return new MpDialogOrderQrCodeNowBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_dialog_order_qr_code_now is invalid. Received: ".concat(String.valueOf(obj)));
            case 24:
                if ("layout/mp_dot_progress_bar_lyt_0".equals(obj)) {
                    return new MpDotProgressBarLytBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_dot_progress_bar_lyt is invalid. Received: ".concat(String.valueOf(obj)));
            case 25:
                if ("layout/mp_email_sms_list_item_0".equals(obj)) {
                    return new MpEmailSmsListItemBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_email_sms_list_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 26:
                if ("layout/mp_embed_web_view_activity_0".equals(obj)) {
                    return new MpEmbedWebViewActivityBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_embed_web_view_activity is invalid. Received: ".concat(String.valueOf(obj)));
            case 27:
                if ("layout/mp_fragment_message_sheet_0".equals(obj)) {
                    return new MpFragmentMessageSheetBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_fragment_message_sheet is invalid. Received: ".concat(String.valueOf(obj)));
            case 28:
                if ("layout/mp_fragment_otp_editboxes_lyt_0".equals(obj)) {
                    return new MpFragmentOtpEditboxesLytBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_fragment_otp_editboxes_lyt is invalid. Received: ".concat(String.valueOf(obj)));
            case 29:
                if ("layout/mp_fragment_request_money_0".equals(obj)) {
                    return new MpFragmentRequestMoneyBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_fragment_request_money is invalid. Received: ".concat(String.valueOf(obj)));
            case 30:
                if ("layout/mp_fragment_save_feedback_0".equals(obj)) {
                    return new MpFragmentSaveFeedbackBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_fragment_save_feedback is invalid. Received: ".concat(String.valueOf(obj)));
            case 31:
                if ("layout/mp_initiate_refund_new_0".equals(obj)) {
                    return new MpInitiateRefundNewBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_initiate_refund_new is invalid. Received: ".concat(String.valueOf(obj)));
            case 32:
                if ("layout/mp_layout_verify_qr_popup_0".equals(obj)) {
                    return new MpLayoutVerifyQrPopupBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_layout_verify_qr_popup is invalid. Received: ".concat(String.valueOf(obj)));
            case 33:
                if ("layout/mp_no_settlements_data_view_0".equals(obj)) {
                    return new MpNoSettlementsDataViewBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_no_settlements_data_view is invalid. Received: ".concat(String.valueOf(obj)));
            case 34:
                if ("layout/mp_notification_item_view_0".equals(obj)) {
                    return new MpNotificationItemViewBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_notification_item_view is invalid. Received: ".concat(String.valueOf(obj)));
            case 35:
                if ("layout/mp_online_settlement_element_0".equals(obj)) {
                    return new MpOnlineSettlementElementBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_online_settlement_element is invalid. Received: ".concat(String.valueOf(obj)));
            case 36:
                if ("layout/mp_online_settlement_summary_card_0".equals(obj)) {
                    return new MpOnlineSettlementSummaryCardBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_online_settlement_summary_card is invalid. Received: ".concat(String.valueOf(obj)));
            case 37:
                if ("layout/mp_payment_info_tile_0".equals(obj)) {
                    return new MpPaymentInfoTileBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_payment_info_tile is invalid. Received: ".concat(String.valueOf(obj)));
            case 38:
                if ("layout/mp_payment_notification_bottomsheet_0".equals(obj)) {
                    return new MpPaymentNotificationBottomsheetBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_payment_notification_bottomsheet is invalid. Received: ".concat(String.valueOf(obj)));
            case 39:
                if ("layout/mp_payment_settlement_tabs_0".equals(obj)) {
                    return new MpPaymentSettlementTabsBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_payment_settlement_tabs is invalid. Received: ".concat(String.valueOf(obj)));
            case 40:
                if ("layout/mp_payments_empty_layout_0".equals(obj)) {
                    return new MpPaymentsEmptyLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_payments_empty_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 41:
                if ("layout/mp_payments_header_layout_0".equals(obj)) {
                    return new MpPaymentsHeaderLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_payments_header_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 42:
                if ("layout/mp_payments_home_header_0".equals(obj)) {
                    return new MpPaymentsHomeHeaderBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_payments_home_header is invalid. Received: ".concat(String.valueOf(obj)));
            case 43:
                if ("layout/mp_payments_list_empty_layout_0".equals(obj)) {
                    return new MpPaymentsListEmptyLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_payments_list_empty_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 44:
                if ("layout/mp_payments_loader_layout_0".equals(obj)) {
                    return new MpPaymentsLoaderLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_payments_loader_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 45:
                if ("layout/mp_payments_permission_denied_layout_0".equals(obj)) {
                    return new MpPaymentsPermissionDeniedLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_payments_permission_denied_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 46:
                if ("layout/mp_payments_show_more_layout_0".equals(obj)) {
                    return new MpPaymentsShowMoreLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_payments_show_more_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 47:
                if ("layout/mp_payments_summary_layout_0".equals(obj)) {
                    return new MpPaymentsSummaryLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_payments_summary_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 48:
                if ("layout/mp_payments_transaction_item_0".equals(obj)) {
                    return new MpPaymentsTransactionItemBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_payments_transaction_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 49:
                if ("layout/mp_paymentss_summery_item_0".equals(obj)) {
                    return new MpPaymentssSummeryItemBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_paymentss_summery_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 50:
                if ("layout/mp_pending_settlement_card_item_0".equals(obj)) {
                    return new MpPendingSettlementCardItemBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_pending_settlement_card_item is invalid. Received: ".concat(String.valueOf(obj)));
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding1(e eVar, View view, int i2, Object obj) {
        switch (i2) {
            case 51:
                if ("layout/mp_profile_qr_pager_item_layout_0".equals(obj)) {
                    return new MpProfileQrPagerItemLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_profile_qr_pager_item_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 52:
                if ("layout/mp_qr_detail_0".equals(obj)) {
                    return new MpQrDetailBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_qr_detail is invalid. Received: ".concat(String.valueOf(obj)));
            case 53:
                if ("layout/mp_qr_payment_list_header_0".equals(obj)) {
                    return new MpQrPaymentListHeaderBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_qr_payment_list_header is invalid. Received: ".concat(String.valueOf(obj)));
            case 54:
                if ("layout/mp_qr_view_0".equals(obj)) {
                    return new MpQrViewBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_qr_view is invalid. Received: ".concat(String.valueOf(obj)));
            case 55:
                if ("layout/mp_qr_view_new_0".equals(obj)) {
                    return new MpQrViewNewBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_qr_view_new is invalid. Received: ".concat(String.valueOf(obj)));
            case 56:
                if ("layout/mp_radio_bank_name_0".equals(obj)) {
                    return new MpRadioBankNameBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_radio_bank_name is invalid. Received: ".concat(String.valueOf(obj)));
            case 57:
                if ("layout/mp_receive_for_item_view_0".equals(obj)) {
                    return new MpReceiveForItemViewBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_receive_for_item_view is invalid. Received: ".concat(String.valueOf(obj)));
            case 58:
                if ("layout/mp_refund_detail_subview_0".equals(obj)) {
                    return new MpRefundDetailSubviewBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_refund_detail_subview is invalid. Received: ".concat(String.valueOf(obj)));
            case 59:
                if ("layout/mp_refund_details_view_new_0".equals(obj)) {
                    return new MpRefundDetailsViewNewBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_refund_details_view_new is invalid. Received: ".concat(String.valueOf(obj)));
            case 60:
                if ("layout/mp_refund_initiated_new_0".equals(obj)) {
                    return new MpRefundInitiatedNewBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_refund_initiated_new is invalid. Received: ".concat(String.valueOf(obj)));
            case 61:
                if ("layout/mp_report_download_bottom_sheet_0".equals(obj)) {
                    return new MpReportDownloadBottomSheetBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_report_download_bottom_sheet is invalid. Received: ".concat(String.valueOf(obj)));
            case 62:
                if ("layout/mp_request_money_shimmer_0".equals(obj)) {
                    return new MpRequestMoneyShimmerBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_request_money_shimmer is invalid. Received: ".concat(String.valueOf(obj)));
            case 63:
                if ("layout/mp_reversal_detail_sub_view_0".equals(obj)) {
                    return new MpReversalDetailSubViewBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_reversal_detail_sub_view is invalid. Received: ".concat(String.valueOf(obj)));
            case 64:
                if ("layout/mp_reversal_details_view_new_0".equals(obj)) {
                    return new MpReversalDetailsViewNewBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_reversal_details_view_new is invalid. Received: ".concat(String.valueOf(obj)));
            case 65:
                if ("layout/mp_settlement_element_shimmer_0".equals(obj)) {
                    return new MpSettlementElementShimmerBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_settlement_element_shimmer is invalid. Received: ".concat(String.valueOf(obj)));
            case 66:
                if ("layout/mp_settlement_range_summery_0".equals(obj)) {
                    return new MpSettlementRangeSummeryBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_settlement_range_summery is invalid. Received: ".concat(String.valueOf(obj)));
            case 67:
                if ("layout/mp_settlement_summary_shimmer_card_0".equals(obj)) {
                    return new MpSettlementSummaryShimmerCardBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_settlement_summary_shimmer_card is invalid. Received: ".concat(String.valueOf(obj)));
            case 68:
                if ("layout/mp_smart_grid_0".equals(obj)) {
                    return new MpSmartGridBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_smart_grid is invalid. Received: ".concat(String.valueOf(obj)));
            case 69:
                if ("layout/mp_success_popup_0".equals(obj)) {
                    return new MpSuccessPopupBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_success_popup is invalid. Received: ".concat(String.valueOf(obj)));
            case 70:
                if ("layout/mp_title_tile_0".equals(obj)) {
                    return new MpTitleTileBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_title_tile is invalid. Received: ".concat(String.valueOf(obj)));
            case 71:
                if ("layout/mp_toolbar_notification_0".equals(obj)) {
                    return new MpToolbarNotificationBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_toolbar_notification is invalid. Received: ".concat(String.valueOf(obj)));
            case 72:
                if ("layout/mp_transaction_detail_0".equals(obj)) {
                    return new MpTransactionDetailBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_transaction_detail is invalid. Received: ".concat(String.valueOf(obj)));
            case 73:
                if ("layout/mp_transaction_detail_sub_view_0".equals(obj)) {
                    return new MpTransactionDetailSubViewBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_transaction_detail_sub_view is invalid. Received: ".concat(String.valueOf(obj)));
            case 74:
                if ("layout/mp_view_custom_card_0".equals(obj)) {
                    return new MpViewCustomCardBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for mp_view_custom_card is invalid. Received: ".concat(String.valueOf(obj)));
            default:
                return null;
        }
    }

    public ViewDataBinding getDataBinder(e eVar, View view, int i2) {
        int i3 = INTERNAL_LAYOUT_ID_LOOKUP.get(i2);
        if (i3 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            int i4 = (i3 - 1) / 50;
            if (i4 == 0) {
                return internalGetViewDataBinding0(eVar, view, i3, tag);
            }
            if (i4 == 1) {
                return internalGetViewDataBinding1(eVar, view, i3, tag);
            }
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public ViewDataBinding getDataBinder(e eVar, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return InnerBrLookup.sKeys.get(i2);
    }

    public List<d> collectDependencies() {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.paytm.business.merchantprofile.DataBinderMapperImpl());
        arrayList.add(new com.paytmmall.clpartifact.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.common.widgets.DataBinderMapperImpl());
        return arrayList;
    }

    public static class InnerBrLookup {
        public static final SparseArray<String> sKeys;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(94);
            sKeys = sparseArray;
            sparseArray.put(1, "IS_COLLAPSED");
            sKeys.put(0, "_all");
            sKeys.put(2, "adapter");
            sKeys.put(3, "audioAlertView");
            sKeys.put(4, "avgRating");
            sKeys.put(5, "backButtonClick");
            sKeys.put(6, "badgeImageUrl");
            sKeys.put(7, "badgeText");
            sKeys.put(8, "bindingUtils");
            sKeys.put(9, "cashback");
            sKeys.put(10, "checkChangeListener");
            sKeys.put(11, "clickHandler");
            sKeys.put(12, "clickhandler");
            sKeys.put(13, "data");
            sKeys.put(14, "dataModel");
            sKeys.put(15, "defaultItemData");
            sKeys.put(16, "dialogDataModel");
            sKeys.put(17, "embedWebViewViewModel");
            sKeys.put(18, "entityIdentifier");
            sKeys.put(19, "entityType");
            sKeys.put(20, "following");
            sKeys.put(21, "fragment");
            sKeys.put(22, "groupAdapter");
            sKeys.put(23, "handler");
            sKeys.put(24, "holder");
            sKeys.put(25, "iSCOLLAPSED");
            sKeys.put(26, H5Param.MENU_ICON);
            sKeys.put(27, "id");
            sKeys.put(28, "imageUrl");
            sKeys.put(29, "initialFrom");
            sKeys.put(30, "initialTo");
            sKeys.put(31, "initiateRefundViewModel");
            sKeys.put(32, "isApplied");
            sKeys.put(33, "isChecked");
            sKeys.put(34, "isCollapsed");
            sKeys.put(35, "isNegativeBtnVisible");
            sKeys.put(36, "isSelected");
            sKeys.put(37, "isTitleVisible");
            sKeys.put(38, "isWishListed");
            sKeys.put(39, "item");
            sKeys.put(40, "itemColor");
            sKeys.put(41, "label");
            sKeys.put(42, "layoutManager");
            sKeys.put(43, "levelToRateCount");
            sKeys.put(44, "listener");
            sKeys.put(45, "mTitle");
            sKeys.put(46, "message");
            sKeys.put(47, "model");
            sKeys.put(48, "modelData");
            sKeys.put(49, "msg");
            sKeys.put(50, "name");
            sKeys.put(51, "negativeText");
            sKeys.put(52, "noNetworkViewModel");
            sKeys.put(53, "notificationActive");
            sKeys.put(54, "offerTag");
            sKeys.put(55, "onClickAction");
            sKeys.put(56, "onNegativeClick");
            sKeys.put(57, "onPositiveClick");
            sKeys.put(58, "pagerIndicatorVisibility");
            sKeys.put(59, "parentViewModel");
            sKeys.put(60, CLPConstants.ARGUMENT_KEY_POSITION);
            sKeys.put(61, "positiveText");
            sKeys.put(62, "primaryViewVisibility");
            sKeys.put(63, "product");
            sKeys.put(64, "rating");
            sKeys.put(65, "ratingData");
            sKeys.put(66, "ratingModel");
            sKeys.put(67, "ratingTotal");
            sKeys.put(68, "receiver");
            sKeys.put(69, "redirect");
            sKeys.put(70, "refundDetailsViewModel");
            sKeys.put(71, "refundInitiatedViewModel");
            sKeys.put(72, "removeButtonVisibility");
            sKeys.put(73, "reviewDate");
            sKeys.put(74, "reviewDetail");
            sKeys.put(75, "seourl");
            sKeys.put(76, "showPrice");
            sKeys.put(77, "showRating");
            sKeys.put(78, "showRatingBar");
            sKeys.put(79, "showSeparation");
            sKeys.put(80, "showVerifyQrPopup");
            sKeys.put(81, "showWishListIcon");
            sKeys.put(82, "slider");
            sKeys.put(83, "starNumber");
            sKeys.put(84, "subCashback");
            sKeys.put(85, "subtitle");
            sKeys.put(86, "tickerText");
            sKeys.put(87, "title");
            sKeys.put(88, "totalRatings");
            sKeys.put(89, "totalReview");
            sKeys.put(90, "type");
            sKeys.put(91, "view");
            sKeys.put(92, "viewModel");
            sKeys.put(93, "viewmodel");
        }
    }

    public static class InnerLayoutIdLookup {
        public static final HashMap<String, Integer> sKeys;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(74);
            sKeys = hashMap;
            hashMap.put("layout/fragment_settlement_detail_0", Integer.valueOf(R.layout.fragment_settlement_detail));
            sKeys.put("layout/mp_activity_add_mobile_otp_0", Integer.valueOf(R.layout.mp_activity_add_mobile_otp));
            sKeys.put("layout/mp_activity_email_sms_notification_0", Integer.valueOf(R.layout.mp_activity_email_sms_notification));
            sKeys.put("layout/mp_activity_notification_0", Integer.valueOf(R.layout.mp_activity_notification));
            sKeys.put("layout/mp_activity_payment_link_0", Integer.valueOf(R.layout.mp_activity_payment_link));
            sKeys.put("layout/mp_activity_payment_list_0", Integer.valueOf(R.layout.mp_activity_payment_list));
            sKeys.put("layout/mp_activity_post_qr_scan_0", Integer.valueOf(R.layout.mp_activity_post_qr_scan));
            sKeys.put("layout/mp_activity_qr_not_printed_0", Integer.valueOf(R.layout.mp_activity_qr_not_printed));
            sKeys.put("layout/mp_add_mobile_activity_0", Integer.valueOf(R.layout.mp_add_mobile_activity));
            sKeys.put("layout/mp_bottomsheet_practices_for_settle_now_0", Integer.valueOf(R.layout.mp_bottomsheet_practices_for_settle_now));
            sKeys.put("layout/mp_bottomsheet_settlement_onhold_0", Integer.valueOf(R.layout.mp_bottomsheet_settlement_onhold));
            sKeys.put("layout/mp_bw_already_settled_element_0", Integer.valueOf(R.layout.mp_bw_already_settled_element));
            sKeys.put("layout/mp_bw_item_settlement_detail_0", Integer.valueOf(R.layout.mp_bw_item_settlement_detail));
            sKeys.put("layout/mp_bw_settlement_amount_to_hold_dialog_0", Integer.valueOf(R.layout.mp_bw_settlement_amount_to_hold_dialog));
            sKeys.put("layout/mp_bw_settlement_detail_item_0", Integer.valueOf(R.layout.mp_bw_settlement_detail_item));
            sKeys.put("layout/mp_bw_settlement_detail_new_0", Integer.valueOf(R.layout.mp_bw_settlement_detail_new));
            sKeys.put("layout/mp_bw_settlement_single_bank_element_0", Integer.valueOf(R.layout.mp_bw_settlement_single_bank_element));
            sKeys.put("layout/mp_bw_settlement_summary_card_0", Integer.valueOf(R.layout.mp_bw_settlement_summary_card));
            sKeys.put("layout/mp_common_overlay_dialog_0", Integer.valueOf(R.layout.mp_common_overlay_dialog));
            sKeys.put("layout/mp_custom_alert_dialog_0", Integer.valueOf(R.layout.mp_custom_alert_dialog));
            sKeys.put("layout/mp_custom_snackbar_view_0", Integer.valueOf(R.layout.mp_custom_snackbar_view));
            sKeys.put("layout/mp_dialog_download_business_app_0", Integer.valueOf(R.layout.mp_dialog_download_business_app));
            sKeys.put("layout/mp_dialog_order_qr_code_now_0", Integer.valueOf(R.layout.mp_dialog_order_qr_code_now));
            sKeys.put("layout/mp_dot_progress_bar_lyt_0", Integer.valueOf(R.layout.mp_dot_progress_bar_lyt));
            sKeys.put("layout/mp_email_sms_list_item_0", Integer.valueOf(R.layout.mp_email_sms_list_item));
            sKeys.put("layout/mp_embed_web_view_activity_0", Integer.valueOf(R.layout.mp_embed_web_view_activity));
            sKeys.put("layout/mp_fragment_message_sheet_0", Integer.valueOf(R.layout.mp_fragment_message_sheet));
            sKeys.put("layout/mp_fragment_otp_editboxes_lyt_0", Integer.valueOf(R.layout.mp_fragment_otp_editboxes_lyt));
            sKeys.put("layout/mp_fragment_request_money_0", Integer.valueOf(R.layout.mp_fragment_request_money));
            sKeys.put("layout/mp_fragment_save_feedback_0", Integer.valueOf(R.layout.mp_fragment_save_feedback));
            sKeys.put("layout/mp_initiate_refund_new_0", Integer.valueOf(R.layout.mp_initiate_refund_new));
            sKeys.put("layout/mp_layout_verify_qr_popup_0", Integer.valueOf(R.layout.mp_layout_verify_qr_popup));
            sKeys.put("layout/mp_no_settlements_data_view_0", Integer.valueOf(R.layout.mp_no_settlements_data_view));
            sKeys.put("layout/mp_notification_item_view_0", Integer.valueOf(R.layout.mp_notification_item_view));
            sKeys.put("layout/mp_online_settlement_element_0", Integer.valueOf(R.layout.mp_online_settlement_element));
            sKeys.put("layout/mp_online_settlement_summary_card_0", Integer.valueOf(R.layout.mp_online_settlement_summary_card));
            sKeys.put("layout/mp_payment_info_tile_0", Integer.valueOf(R.layout.mp_payment_info_tile));
            sKeys.put("layout/mp_payment_notification_bottomsheet_0", Integer.valueOf(R.layout.mp_payment_notification_bottomsheet));
            sKeys.put("layout/mp_payment_settlement_tabs_0", Integer.valueOf(R.layout.mp_payment_settlement_tabs));
            sKeys.put("layout/mp_payments_empty_layout_0", Integer.valueOf(R.layout.mp_payments_empty_layout));
            sKeys.put("layout/mp_payments_header_layout_0", Integer.valueOf(R.layout.mp_payments_header_layout));
            sKeys.put("layout/mp_payments_home_header_0", Integer.valueOf(R.layout.mp_payments_home_header));
            sKeys.put("layout/mp_payments_list_empty_layout_0", Integer.valueOf(R.layout.mp_payments_list_empty_layout));
            sKeys.put("layout/mp_payments_loader_layout_0", Integer.valueOf(R.layout.mp_payments_loader_layout));
            sKeys.put("layout/mp_payments_permission_denied_layout_0", Integer.valueOf(R.layout.mp_payments_permission_denied_layout));
            sKeys.put("layout/mp_payments_show_more_layout_0", Integer.valueOf(R.layout.mp_payments_show_more_layout));
            sKeys.put("layout/mp_payments_summary_layout_0", Integer.valueOf(R.layout.mp_payments_summary_layout));
            sKeys.put("layout/mp_payments_transaction_item_0", Integer.valueOf(R.layout.mp_payments_transaction_item));
            sKeys.put("layout/mp_paymentss_summery_item_0", Integer.valueOf(R.layout.mp_paymentss_summery_item));
            sKeys.put("layout/mp_pending_settlement_card_item_0", Integer.valueOf(R.layout.mp_pending_settlement_card_item));
            sKeys.put("layout/mp_profile_qr_pager_item_layout_0", Integer.valueOf(R.layout.mp_profile_qr_pager_item_layout));
            sKeys.put("layout/mp_qr_detail_0", Integer.valueOf(R.layout.mp_qr_detail));
            sKeys.put("layout/mp_qr_payment_list_header_0", Integer.valueOf(R.layout.mp_qr_payment_list_header));
            sKeys.put("layout/mp_qr_view_0", Integer.valueOf(R.layout.mp_qr_view));
            sKeys.put("layout/mp_qr_view_new_0", Integer.valueOf(R.layout.mp_qr_view_new));
            sKeys.put("layout/mp_radio_bank_name_0", Integer.valueOf(R.layout.mp_radio_bank_name));
            sKeys.put("layout/mp_receive_for_item_view_0", Integer.valueOf(R.layout.mp_receive_for_item_view));
            sKeys.put("layout/mp_refund_detail_subview_0", Integer.valueOf(R.layout.mp_refund_detail_subview));
            sKeys.put("layout/mp_refund_details_view_new_0", Integer.valueOf(R.layout.mp_refund_details_view_new));
            sKeys.put("layout/mp_refund_initiated_new_0", Integer.valueOf(R.layout.mp_refund_initiated_new));
            sKeys.put("layout/mp_report_download_bottom_sheet_0", Integer.valueOf(R.layout.mp_report_download_bottom_sheet));
            sKeys.put("layout/mp_request_money_shimmer_0", Integer.valueOf(R.layout.mp_request_money_shimmer));
            sKeys.put("layout/mp_reversal_detail_sub_view_0", Integer.valueOf(R.layout.mp_reversal_detail_sub_view));
            sKeys.put("layout/mp_reversal_details_view_new_0", Integer.valueOf(R.layout.mp_reversal_details_view_new));
            sKeys.put("layout/mp_settlement_element_shimmer_0", Integer.valueOf(R.layout.mp_settlement_element_shimmer));
            sKeys.put("layout/mp_settlement_range_summery_0", Integer.valueOf(R.layout.mp_settlement_range_summery));
            sKeys.put("layout/mp_settlement_summary_shimmer_card_0", Integer.valueOf(R.layout.mp_settlement_summary_shimmer_card));
            sKeys.put("layout/mp_smart_grid_0", Integer.valueOf(R.layout.mp_smart_grid));
            sKeys.put("layout/mp_success_popup_0", Integer.valueOf(R.layout.mp_success_popup));
            sKeys.put("layout/mp_title_tile_0", Integer.valueOf(R.layout.mp_title_tile));
            sKeys.put("layout/mp_toolbar_notification_0", Integer.valueOf(R.layout.mp_toolbar_notification));
            sKeys.put("layout/mp_transaction_detail_0", Integer.valueOf(R.layout.mp_transaction_detail));
            sKeys.put("layout/mp_transaction_detail_sub_view_0", Integer.valueOf(R.layout.mp_transaction_detail_sub_view));
            sKeys.put("layout/mp_view_custom_card_0", Integer.valueOf(R.layout.mp_view_custom_card));
        }
    }
}
