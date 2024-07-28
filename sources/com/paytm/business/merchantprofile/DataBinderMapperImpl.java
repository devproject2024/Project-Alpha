package com.paytm.business.merchantprofile;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.databinding.e;
import com.paytm.business.merchantprofile.databinding.PrActivityAddMobileOtpBindingImpl;
import com.paytm.business.merchantprofile.databinding.PrActivityEditBusinessProfileDetailsBindingImpl;
import com.paytm.business.merchantprofile.databinding.PrActivityProfileBusinessDetailsNewBindingImpl;
import com.paytm.business.merchantprofile.databinding.PrActivityProfileBusinessDetailsShimmerBindingImpl;
import com.paytm.business.merchantprofile.databinding.PrDeativateAccountBottomsheetBindingImpl;
import com.paytm.business.merchantprofile.databinding.PrEmbedWebViewActivityBindingImpl;
import com.paytm.business.merchantprofile.databinding.PrFragmentConfirmGstinAddressBindingImpl;
import com.paytm.business.merchantprofile.databinding.PrFragmentEditAddressBindingImpl;
import com.paytm.business.merchantprofile.databinding.PrFragmentEditBasicDetailsBindingImpl;
import com.paytm.business.merchantprofile.databinding.PrFragmentEditGstinBindingImpl;
import com.paytm.business.merchantprofile.databinding.PrFragmentMessageSheetBindingImpl;
import com.paytm.business.merchantprofile.databinding.PrFragmentOtpEditboxesLytBindingImpl;
import com.paytm.business.merchantprofile.databinding.PrFragmentRequestConfirmationBindingImpl;
import com.paytm.business.merchantprofile.databinding.PrMerchantSwitchBottomSheetBindingImpl;
import com.paytm.business.merchantprofile.databinding.PrOtpDialogViewBindingImpl;
import com.paytm.business.merchantprofile.databinding.PrPastPaymentBindingImpl;
import com.paytm.business.merchantprofile.databinding.PrPaymentAcceptanceHoldBsBindingImpl;
import com.paytm.business.merchantprofile.databinding.PrPaymentsInActiveMerchantBindingImpl;
import com.paytm.business.merchantprofile.databinding.PrProfileReactivateBindingImpl;
import com.paytm.business.merchantprofile.databinding.PrProfileScreenHeaderBindingImpl;
import com.paytm.business.merchantprofile.databinding.PrRadioBankNameBindingImpl;
import com.paytm.business.merchantprofile.databinding.PrReactivationFailedBindingImpl;
import com.paytm.business.merchantprofile.databinding.PrViewEditChangeInProgressNewBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends d {
    public static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    public static final int LAYOUT_PRACTIVITYADDMOBILEOTP = 1;
    public static final int LAYOUT_PRACTIVITYEDITBUSINESSPROFILEDETAILS = 2;
    public static final int LAYOUT_PRACTIVITYPROFILEBUSINESSDETAILSNEW = 3;
    public static final int LAYOUT_PRACTIVITYPROFILEBUSINESSDETAILSSHIMMER = 4;
    public static final int LAYOUT_PRDEATIVATEACCOUNTBOTTOMSHEET = 5;
    public static final int LAYOUT_PREMBEDWEBVIEWACTIVITY = 6;
    public static final int LAYOUT_PRFRAGMENTCONFIRMGSTINADDRESS = 7;
    public static final int LAYOUT_PRFRAGMENTEDITADDRESS = 8;
    public static final int LAYOUT_PRFRAGMENTEDITBASICDETAILS = 9;
    public static final int LAYOUT_PRFRAGMENTEDITGSTIN = 10;
    public static final int LAYOUT_PRFRAGMENTMESSAGESHEET = 11;
    public static final int LAYOUT_PRFRAGMENTOTPEDITBOXESLYT = 12;
    public static final int LAYOUT_PRFRAGMENTREQUESTCONFIRMATION = 13;
    public static final int LAYOUT_PRMERCHANTSWITCHBOTTOMSHEET = 14;
    public static final int LAYOUT_PROTPDIALOGVIEW = 15;
    public static final int LAYOUT_PRPASTPAYMENT = 16;
    public static final int LAYOUT_PRPAYMENTACCEPTANCEHOLDBS = 17;
    public static final int LAYOUT_PRPAYMENTSINACTIVEMERCHANT = 18;
    public static final int LAYOUT_PRPROFILEREACTIVATE = 19;
    public static final int LAYOUT_PRPROFILESCREENHEADER = 20;
    public static final int LAYOUT_PRRADIOBANKNAME = 21;
    public static final int LAYOUT_PRREACTIVATIONFAILED = 22;
    public static final int LAYOUT_PRVIEWEDITCHANGEINPROGRESSNEW = 23;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(23);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.pr_activity_add_mobile_otp, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pr_activity_edit_business_profile_details, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pr_activity_profile_business_details_new, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pr_activity_profile_business_details_shimmer, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pr_deativate_account_bottomsheet, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pr_embed_web_view_activity, 6);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pr_fragment_confirm_gstin_address, 7);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pr_fragment_edit_address, 8);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pr_fragment_edit_basic_details, 9);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pr_fragment_edit_gstin, 10);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pr_fragment_message_sheet, 11);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pr_fragment_otp_editboxes_lyt, 12);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pr_fragment_request_confirmation, 13);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pr_merchant_switch_bottom_sheet, 14);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pr_otp_dialog_view, 15);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pr_past_payment, 16);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pr_payment_acceptance_hold_bs, 17);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pr_payments_in_active_merchant, 18);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pr_profile_reactivate, 19);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pr_profile_screen_header, 20);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pr_radio_bank_name, 21);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pr_reactivation_failed, 22);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pr_view_edit_change_in_progress_new, 23);
    }

    public ViewDataBinding getDataBinder(e eVar, View view, int i2) {
        int i3 = INTERNAL_LAYOUT_ID_LOOKUP.get(i2);
        if (i3 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            switch (i3) {
                case 1:
                    if ("layout/pr_activity_add_mobile_otp_0".equals(tag)) {
                        return new PrActivityAddMobileOtpBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_activity_add_mobile_otp is invalid. Received: ".concat(String.valueOf(tag)));
                case 2:
                    if ("layout/pr_activity_edit_business_profile_details_0".equals(tag)) {
                        return new PrActivityEditBusinessProfileDetailsBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_activity_edit_business_profile_details is invalid. Received: ".concat(String.valueOf(tag)));
                case 3:
                    if ("layout/pr_activity_profile_business_details_new_0".equals(tag)) {
                        return new PrActivityProfileBusinessDetailsNewBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_activity_profile_business_details_new is invalid. Received: ".concat(String.valueOf(tag)));
                case 4:
                    if ("layout/pr_activity_profile_business_details_shimmer_0".equals(tag)) {
                        return new PrActivityProfileBusinessDetailsShimmerBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_activity_profile_business_details_shimmer is invalid. Received: ".concat(String.valueOf(tag)));
                case 5:
                    if ("layout/pr_deativate_account_bottomsheet_0".equals(tag)) {
                        return new PrDeativateAccountBottomsheetBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_deativate_account_bottomsheet is invalid. Received: ".concat(String.valueOf(tag)));
                case 6:
                    if ("layout/pr_embed_web_view_activity_0".equals(tag)) {
                        return new PrEmbedWebViewActivityBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_embed_web_view_activity is invalid. Received: ".concat(String.valueOf(tag)));
                case 7:
                    if ("layout/pr_fragment_confirm_gstin_address_0".equals(tag)) {
                        return new PrFragmentConfirmGstinAddressBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_fragment_confirm_gstin_address is invalid. Received: ".concat(String.valueOf(tag)));
                case 8:
                    if ("layout/pr_fragment_edit_address_0".equals(tag)) {
                        return new PrFragmentEditAddressBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_fragment_edit_address is invalid. Received: ".concat(String.valueOf(tag)));
                case 9:
                    if ("layout/pr_fragment_edit_basic_details_0".equals(tag)) {
                        return new PrFragmentEditBasicDetailsBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_fragment_edit_basic_details is invalid. Received: ".concat(String.valueOf(tag)));
                case 10:
                    if ("layout/pr_fragment_edit_gstin_0".equals(tag)) {
                        return new PrFragmentEditGstinBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_fragment_edit_gstin is invalid. Received: ".concat(String.valueOf(tag)));
                case 11:
                    if ("layout/pr_fragment_message_sheet_0".equals(tag)) {
                        return new PrFragmentMessageSheetBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_fragment_message_sheet is invalid. Received: ".concat(String.valueOf(tag)));
                case 12:
                    if ("layout/pr_fragment_otp_editboxes_lyt_0".equals(tag)) {
                        return new PrFragmentOtpEditboxesLytBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_fragment_otp_editboxes_lyt is invalid. Received: ".concat(String.valueOf(tag)));
                case 13:
                    if ("layout/pr_fragment_request_confirmation_0".equals(tag)) {
                        return new PrFragmentRequestConfirmationBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_fragment_request_confirmation is invalid. Received: ".concat(String.valueOf(tag)));
                case 14:
                    if ("layout/pr_merchant_switch_bottom_sheet_0".equals(tag)) {
                        return new PrMerchantSwitchBottomSheetBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_merchant_switch_bottom_sheet is invalid. Received: ".concat(String.valueOf(tag)));
                case 15:
                    if ("layout/pr_otp_dialog_view_0".equals(tag)) {
                        return new PrOtpDialogViewBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_otp_dialog_view is invalid. Received: ".concat(String.valueOf(tag)));
                case 16:
                    if ("layout/pr_past_payment_0".equals(tag)) {
                        return new PrPastPaymentBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_past_payment is invalid. Received: ".concat(String.valueOf(tag)));
                case 17:
                    if ("layout/pr_payment_acceptance_hold_bs_0".equals(tag)) {
                        return new PrPaymentAcceptanceHoldBsBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_payment_acceptance_hold_bs is invalid. Received: ".concat(String.valueOf(tag)));
                case 18:
                    if ("layout/pr_payments_in_active_merchant_0".equals(tag)) {
                        return new PrPaymentsInActiveMerchantBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_payments_in_active_merchant is invalid. Received: ".concat(String.valueOf(tag)));
                case 19:
                    if ("layout/pr_profile_reactivate_0".equals(tag)) {
                        return new PrProfileReactivateBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_profile_reactivate is invalid. Received: ".concat(String.valueOf(tag)));
                case 20:
                    if ("layout/pr_profile_screen_header_0".equals(tag)) {
                        return new PrProfileScreenHeaderBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_profile_screen_header is invalid. Received: ".concat(String.valueOf(tag)));
                case 21:
                    if ("layout/pr_radio_bank_name_0".equals(tag)) {
                        return new PrRadioBankNameBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_radio_bank_name is invalid. Received: ".concat(String.valueOf(tag)));
                case 22:
                    if ("layout/pr_reactivation_failed_0".equals(tag)) {
                        return new PrReactivationFailedBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_reactivation_failed is invalid. Received: ".concat(String.valueOf(tag)));
                case 23:
                    if ("layout/pr_view_edit_change_in_progress_new_0".equals(tag)) {
                        return new PrViewEditChangeInProgressNewBindingImpl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for pr_view_edit_change_in_progress_new is invalid. Received: ".concat(String.valueOf(tag)));
                default:
                    return null;
            }
        } else {
            throw new RuntimeException("view must have a tag");
        }
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
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.common.widgets.DataBinderMapperImpl());
        return arrayList;
    }

    public static class InnerBrLookup {
        public static final SparseArray<String> sKeys;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(5);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sKeys.put(1, "data");
            sKeys.put(2, "embedWebViewViewModel");
            sKeys.put(3, "listener");
            sKeys.put(4, "viewModel");
        }
    }

    public static class InnerLayoutIdLookup {
        public static final HashMap<String, Integer> sKeys;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(23);
            sKeys = hashMap;
            hashMap.put("layout/pr_activity_add_mobile_otp_0", Integer.valueOf(R.layout.pr_activity_add_mobile_otp));
            sKeys.put("layout/pr_activity_edit_business_profile_details_0", Integer.valueOf(R.layout.pr_activity_edit_business_profile_details));
            sKeys.put("layout/pr_activity_profile_business_details_new_0", Integer.valueOf(R.layout.pr_activity_profile_business_details_new));
            sKeys.put("layout/pr_activity_profile_business_details_shimmer_0", Integer.valueOf(R.layout.pr_activity_profile_business_details_shimmer));
            sKeys.put("layout/pr_deativate_account_bottomsheet_0", Integer.valueOf(R.layout.pr_deativate_account_bottomsheet));
            sKeys.put("layout/pr_embed_web_view_activity_0", Integer.valueOf(R.layout.pr_embed_web_view_activity));
            sKeys.put("layout/pr_fragment_confirm_gstin_address_0", Integer.valueOf(R.layout.pr_fragment_confirm_gstin_address));
            sKeys.put("layout/pr_fragment_edit_address_0", Integer.valueOf(R.layout.pr_fragment_edit_address));
            sKeys.put("layout/pr_fragment_edit_basic_details_0", Integer.valueOf(R.layout.pr_fragment_edit_basic_details));
            sKeys.put("layout/pr_fragment_edit_gstin_0", Integer.valueOf(R.layout.pr_fragment_edit_gstin));
            sKeys.put("layout/pr_fragment_message_sheet_0", Integer.valueOf(R.layout.pr_fragment_message_sheet));
            sKeys.put("layout/pr_fragment_otp_editboxes_lyt_0", Integer.valueOf(R.layout.pr_fragment_otp_editboxes_lyt));
            sKeys.put("layout/pr_fragment_request_confirmation_0", Integer.valueOf(R.layout.pr_fragment_request_confirmation));
            sKeys.put("layout/pr_merchant_switch_bottom_sheet_0", Integer.valueOf(R.layout.pr_merchant_switch_bottom_sheet));
            sKeys.put("layout/pr_otp_dialog_view_0", Integer.valueOf(R.layout.pr_otp_dialog_view));
            sKeys.put("layout/pr_past_payment_0", Integer.valueOf(R.layout.pr_past_payment));
            sKeys.put("layout/pr_payment_acceptance_hold_bs_0", Integer.valueOf(R.layout.pr_payment_acceptance_hold_bs));
            sKeys.put("layout/pr_payments_in_active_merchant_0", Integer.valueOf(R.layout.pr_payments_in_active_merchant));
            sKeys.put("layout/pr_profile_reactivate_0", Integer.valueOf(R.layout.pr_profile_reactivate));
            sKeys.put("layout/pr_profile_screen_header_0", Integer.valueOf(R.layout.pr_profile_screen_header));
            sKeys.put("layout/pr_radio_bank_name_0", Integer.valueOf(R.layout.pr_radio_bank_name));
            sKeys.put("layout/pr_reactivation_failed_0", Integer.valueOf(R.layout.pr_reactivation_failed));
            sKeys.put("layout/pr_view_edit_change_in_progress_new_0", Integer.valueOf(R.layout.pr_view_edit_change_in_progress_new));
        }
    }
}
