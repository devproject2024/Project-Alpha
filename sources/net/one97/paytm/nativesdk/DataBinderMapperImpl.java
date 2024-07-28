package net.one97.paytm.nativesdk;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.databinding.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.nativesdk.databinding.ActivityLoginBindingImpl;
import net.one97.paytm.nativesdk.databinding.ActivityUpiAppsBindingImpl;
import net.one97.paytm.nativesdk.databinding.AoaWalletLayoutBindingImpl;
import net.one97.paytm.nativesdk.databinding.BankEMandateAuthItemBindingImpl;
import net.one97.paytm.nativesdk.databinding.BankEMandateAuthUsingViewBindingImpl;
import net.one97.paytm.nativesdk.databinding.BankEMandateBankItemBindingImpl;
import net.one97.paytm.nativesdk.databinding.BankEMandateNewAcBindingImpl;
import net.one97.paytm.nativesdk.databinding.BankEMandateSavedBankBindingImpl;
import net.one97.paytm.nativesdk.databinding.CodLayoutBindingImpl;
import net.one97.paytm.nativesdk.databinding.CvvHelpCardLayoutBindingImpl;
import net.one97.paytm.nativesdk.databinding.CvvHelpLayoutBindingImpl;
import net.one97.paytm.nativesdk.databinding.CvvPinLayoutBindingImpl;
import net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBindingImpl;
import net.one97.paytm.nativesdk.databinding.DigitalCreditInfoLytBindingImpl;
import net.one97.paytm.nativesdk.databinding.EmiDetailsLayoutBindingImpl;
import net.one97.paytm.nativesdk.databinding.EmiLayoutBindingImpl;
import net.one97.paytm.nativesdk.databinding.FragmentAllBankMandateListBindingImpl;
import net.one97.paytm.nativesdk.databinding.FragmentBankMandateFindIfscBindingImpl;
import net.one97.paytm.nativesdk.databinding.FragmentBankMandateStateListBindingImpl;
import net.one97.paytm.nativesdk.databinding.FragmentBankMandateSubDetailsBindingImpl;
import net.one97.paytm.nativesdk.databinding.FragmentVerifyOtpNativeBindingImpl;
import net.one97.paytm.nativesdk.databinding.LayoutPostpaidTermsBindingImpl;
import net.one97.paytm.nativesdk.databinding.LoginFragmentLayoutBindingImpl;
import net.one97.paytm.nativesdk.databinding.LytInstrumentSelectedSheetBindingImpl;
import net.one97.paytm.nativesdk.databinding.LytPaymentStatusSheetBindingImpl;
import net.one97.paytm.nativesdk.databinding.NativeInstrumentBindingImpl;
import net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBindingImpl;
import net.one97.paytm.nativesdk.databinding.NativeInstrumentLoadingSheetBindingImpl;
import net.one97.paytm.nativesdk.databinding.NativeNetBankingLayoutBindingImpl;
import net.one97.paytm.nativesdk.databinding.NativeSdkNetbankingBankListBindingImpl;
import net.one97.paytm.nativesdk.databinding.NativesdkBankMandateListProviderItemBindingImpl;
import net.one97.paytm.nativesdk.databinding.NativesdkBankMandateSectionItemBindingImpl;
import net.one97.paytm.nativesdk.databinding.NativesdkBankMandateStateItemBindingImpl;
import net.one97.paytm.nativesdk.databinding.NativesdkItemBankProviderListBindingImpl;
import net.one97.paytm.nativesdk.databinding.NativesdkItemBankSectionBindingImpl;
import net.one97.paytm.nativesdk.databinding.NativesdkPaymentsBankInfoBindingImpl;
import net.one97.paytm.nativesdk.databinding.NewCardBankOffersBindingImpl;
import net.one97.paytm.nativesdk.databinding.PaytmBankInfoBankofferBindingImpl;
import net.one97.paytm.nativesdk.databinding.RowNetBankingLayoutBindingImpl;
import net.one97.paytm.nativesdk.databinding.SaveCardLayout2BindingImpl;
import net.one97.paytm.nativesdk.databinding.SaveCardLayoutBindingImpl;
import net.one97.paytm.nativesdk.databinding.SavedCardBankOfferBindingImpl;
import net.one97.paytm.nativesdk.databinding.SavedMandateLayoutBindingImpl;
import net.one97.paytm.nativesdk.databinding.SingleEmiDetailsBindingImpl;
import net.one97.paytm.nativesdk.databinding.SingleVpaLayoutBindingImpl;
import net.one97.paytm.nativesdk.databinding.UpiCollectLayoutNewBindingImpl;
import net.one97.paytm.nativesdk.databinding.UpiHelpCardLayoutBindingImpl;
import net.one97.paytm.nativesdk.databinding.UpiHelpLayoutBindingImpl;
import net.one97.paytm.nativesdk.databinding.UpiHelpLayoutMainBindingImpl;
import net.one97.paytm.nativesdk.databinding.UpiOnboardingLayoutBindingImpl;
import net.one97.paytm.nativesdk.databinding.VpaLayoutContainerBindingImpl;
import net.one97.paytm.nativesdk.databinding.WalletLytInstrumentInfoBindingImpl;

public class DataBinderMapperImpl extends d {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYLOGIN = 1;
    private static final int LAYOUT_ACTIVITYUPIAPPS = 2;
    private static final int LAYOUT_AOAWALLETLAYOUT = 3;
    private static final int LAYOUT_BANKEMANDATEAUTHITEM = 4;
    private static final int LAYOUT_BANKEMANDATEAUTHUSINGVIEW = 5;
    private static final int LAYOUT_BANKEMANDATEBANKITEM = 6;
    private static final int LAYOUT_BANKEMANDATENEWAC = 7;
    private static final int LAYOUT_BANKEMANDATESAVEDBANK = 8;
    private static final int LAYOUT_CODLAYOUT = 9;
    private static final int LAYOUT_CVVHELPCARDLAYOUT = 10;
    private static final int LAYOUT_CVVHELPLAYOUT = 11;
    private static final int LAYOUT_CVVPINLAYOUT = 12;
    private static final int LAYOUT_DEBITCREDITCARDLAYOUT = 13;
    private static final int LAYOUT_DIGITALCREDITINFOLYT = 14;
    private static final int LAYOUT_EMIDETAILSLAYOUT = 15;
    private static final int LAYOUT_EMILAYOUT = 16;
    private static final int LAYOUT_FRAGMENTALLBANKMANDATELIST = 17;
    private static final int LAYOUT_FRAGMENTBANKMANDATEFINDIFSC = 18;
    private static final int LAYOUT_FRAGMENTBANKMANDATESTATELIST = 19;
    private static final int LAYOUT_FRAGMENTBANKMANDATESUBDETAILS = 20;
    private static final int LAYOUT_FRAGMENTVERIFYOTPNATIVE = 21;
    private static final int LAYOUT_LAYOUTPOSTPAIDTERMS = 22;
    private static final int LAYOUT_LOGINFRAGMENTLAYOUT = 23;
    private static final int LAYOUT_LYTINSTRUMENTSELECTEDSHEET = 24;
    private static final int LAYOUT_LYTPAYMENTSTATUSSHEET = 25;
    private static final int LAYOUT_NATIVEINSTRUMENT = 26;
    private static final int LAYOUT_NATIVEINSTRUMENTCASHIERSHEET = 27;
    private static final int LAYOUT_NATIVEINSTRUMENTLOADINGSHEET = 28;
    private static final int LAYOUT_NATIVENETBANKINGLAYOUT = 29;
    private static final int LAYOUT_NATIVESDKBANKMANDATELISTPROVIDERITEM = 31;
    private static final int LAYOUT_NATIVESDKBANKMANDATESECTIONITEM = 32;
    private static final int LAYOUT_NATIVESDKBANKMANDATESTATEITEM = 33;
    private static final int LAYOUT_NATIVESDKITEMBANKPROVIDERLIST = 34;
    private static final int LAYOUT_NATIVESDKITEMBANKSECTION = 35;
    private static final int LAYOUT_NATIVESDKNETBANKINGBANKLIST = 30;
    private static final int LAYOUT_NATIVESDKPAYMENTSBANKINFO = 36;
    private static final int LAYOUT_NEWCARDBANKOFFERS = 37;
    private static final int LAYOUT_PAYTMBANKINFOBANKOFFER = 38;
    private static final int LAYOUT_ROWNETBANKINGLAYOUT = 39;
    private static final int LAYOUT_SAVECARDLAYOUT = 40;
    private static final int LAYOUT_SAVECARDLAYOUT2 = 41;
    private static final int LAYOUT_SAVEDCARDBANKOFFER = 42;
    private static final int LAYOUT_SAVEDMANDATELAYOUT = 43;
    private static final int LAYOUT_SINGLEEMIDETAILS = 44;
    private static final int LAYOUT_SINGLEVPALAYOUT = 45;
    private static final int LAYOUT_UPICOLLECTLAYOUTNEW = 46;
    private static final int LAYOUT_UPIHELPCARDLAYOUT = 47;
    private static final int LAYOUT_UPIHELPLAYOUT = 48;
    private static final int LAYOUT_UPIHELPLAYOUTMAIN = 49;
    private static final int LAYOUT_UPIONBOARDINGLAYOUT = 50;
    private static final int LAYOUT_VPALAYOUTCONTAINER = 51;
    private static final int LAYOUT_WALLETLYTINSTRUMENTINFO = 52;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(52);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_login, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.activity_upi_apps, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.aoa_wallet_layout, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.bank_e_mandate_auth_item, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.bank_e_mandate_auth_using_view, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.bank_e_mandate_bank_item, 6);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.bank_e_mandate_new_ac, 7);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.bank_e_mandate_saved_bank, 8);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.cod_layout, 9);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.cvv_help_card_layout, 10);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.cvv_help_layout, 11);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.cvv_pin_layout, 12);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.debit_credit_card_layout, 13);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.digital_credit_info_lyt, 14);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.emi_details_layout, 15);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.emi_layout, 16);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_all_bank_mandate_list, 17);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_bank_mandate_find_ifsc, 18);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_bank_mandate_state_list, 19);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_bank_mandate_sub_details, 20);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_verify_otp_native, 21);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.layout_postpaid_terms, 22);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.login_fragment_layout, 23);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.lyt_instrument_selected_sheet, 24);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.lyt_payment_status_sheet, 25);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.native_instrument, 26);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.native_instrument_cashier_sheet, 27);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.native_instrument_loading_sheet, 28);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.native_net_banking_layout, 29);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.native_sdk_netbanking_bank_list, 30);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.nativesdk_bank_mandate_list_provider_item, 31);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.nativesdk_bank_mandate_section_item, 32);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.nativesdk_bank_mandate_state_item, 33);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.nativesdk_item_bank_provider_list, 34);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.nativesdk_item_bank_section, 35);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.nativesdk_payments_bank_info, 36);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.new_card_bank_offers, 37);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.paytm_bank_info_bankoffer, 38);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.row_net_banking_layout, 39);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.save_card_layout, 40);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.save_card_layout_2, 41);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.saved_card_bank_offer, 42);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.saved_mandate_layout, 43);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.single_emi_details, 44);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.single_vpa_layout, 45);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.upi_collect_layout_new, 46);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.upi_help_card_layout, 47);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.upi_help_layout, 48);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.upi_help_layout_main, 49);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.upi_onboarding_layout, 50);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.vpa_layout_container, 51);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.wallet_lyt_instrument_info, 52);
    }

    private final ViewDataBinding internalGetViewDataBinding0(e eVar, View view, int i2, Object obj) {
        switch (i2) {
            case 1:
                if ("layout/activity_login_0".equals(obj)) {
                    return new ActivityLoginBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_login is invalid. Received: ".concat(String.valueOf(obj)));
            case 2:
                if ("layout/activity_upi_apps_0".equals(obj)) {
                    return new ActivityUpiAppsBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_upi_apps is invalid. Received: ".concat(String.valueOf(obj)));
            case 3:
                if ("layout/aoa_wallet_layout_0".equals(obj)) {
                    return new AoaWalletLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for aoa_wallet_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 4:
                if ("layout/bank_e_mandate_auth_item_0".equals(obj)) {
                    return new BankEMandateAuthItemBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for bank_e_mandate_auth_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 5:
                if ("layout/bank_e_mandate_auth_using_view_0".equals(obj)) {
                    return new BankEMandateAuthUsingViewBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for bank_e_mandate_auth_using_view is invalid. Received: ".concat(String.valueOf(obj)));
            case 6:
                if ("layout/bank_e_mandate_bank_item_0".equals(obj)) {
                    return new BankEMandateBankItemBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for bank_e_mandate_bank_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 7:
                if ("layout/bank_e_mandate_new_ac_0".equals(obj)) {
                    return new BankEMandateNewAcBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for bank_e_mandate_new_ac is invalid. Received: ".concat(String.valueOf(obj)));
            case 8:
                if ("layout/bank_e_mandate_saved_bank_0".equals(obj)) {
                    return new BankEMandateSavedBankBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for bank_e_mandate_saved_bank is invalid. Received: ".concat(String.valueOf(obj)));
            case 9:
                if ("layout/cod_layout_0".equals(obj)) {
                    return new CodLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for cod_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 10:
                if ("layout/cvv_help_card_layout_0".equals(obj)) {
                    return new CvvHelpCardLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for cvv_help_card_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 11:
                if ("layout/cvv_help_layout_0".equals(obj)) {
                    return new CvvHelpLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for cvv_help_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 12:
                if ("layout/cvv_pin_layout_0".equals(obj)) {
                    return new CvvPinLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for cvv_pin_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 13:
                if ("layout/debit_credit_card_layout_0".equals(obj)) {
                    return new DebitCreditCardLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for debit_credit_card_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 14:
                if ("layout/digital_credit_info_lyt_0".equals(obj)) {
                    return new DigitalCreditInfoLytBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for digital_credit_info_lyt is invalid. Received: ".concat(String.valueOf(obj)));
            case 15:
                if ("layout/emi_details_layout_0".equals(obj)) {
                    return new EmiDetailsLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for emi_details_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 16:
                if ("layout/emi_layout_0".equals(obj)) {
                    return new EmiLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for emi_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 17:
                if ("layout/fragment_all_bank_mandate_list_0".equals(obj)) {
                    return new FragmentAllBankMandateListBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_all_bank_mandate_list is invalid. Received: ".concat(String.valueOf(obj)));
            case 18:
                if ("layout/fragment_bank_mandate_find_ifsc_0".equals(obj)) {
                    return new FragmentBankMandateFindIfscBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_bank_mandate_find_ifsc is invalid. Received: ".concat(String.valueOf(obj)));
            case 19:
                if ("layout/fragment_bank_mandate_state_list_0".equals(obj)) {
                    return new FragmentBankMandateStateListBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_bank_mandate_state_list is invalid. Received: ".concat(String.valueOf(obj)));
            case 20:
                if ("layout/fragment_bank_mandate_sub_details_0".equals(obj)) {
                    return new FragmentBankMandateSubDetailsBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_bank_mandate_sub_details is invalid. Received: ".concat(String.valueOf(obj)));
            case 21:
                if ("layout/fragment_verify_otp_native_0".equals(obj)) {
                    return new FragmentVerifyOtpNativeBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_verify_otp_native is invalid. Received: ".concat(String.valueOf(obj)));
            case 22:
                if ("layout/layout_postpaid_terms_0".equals(obj)) {
                    return new LayoutPostpaidTermsBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for layout_postpaid_terms is invalid. Received: ".concat(String.valueOf(obj)));
            case 23:
                if ("layout/login_fragment_layout_0".equals(obj)) {
                    return new LoginFragmentLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for login_fragment_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 24:
                if ("layout/lyt_instrument_selected_sheet_0".equals(obj)) {
                    return new LytInstrumentSelectedSheetBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for lyt_instrument_selected_sheet is invalid. Received: ".concat(String.valueOf(obj)));
            case 25:
                if ("layout/lyt_payment_status_sheet_0".equals(obj)) {
                    return new LytPaymentStatusSheetBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for lyt_payment_status_sheet is invalid. Received: ".concat(String.valueOf(obj)));
            case 26:
                if ("layout/native_instrument_0".equals(obj)) {
                    return new NativeInstrumentBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for native_instrument is invalid. Received: ".concat(String.valueOf(obj)));
            case 27:
                if ("layout/native_instrument_cashier_sheet_0".equals(obj)) {
                    return new NativeInstrumentCashierSheetBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for native_instrument_cashier_sheet is invalid. Received: ".concat(String.valueOf(obj)));
            case 28:
                if ("layout/native_instrument_loading_sheet_0".equals(obj)) {
                    return new NativeInstrumentLoadingSheetBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for native_instrument_loading_sheet is invalid. Received: ".concat(String.valueOf(obj)));
            case 29:
                if ("layout/native_net_banking_layout_0".equals(obj)) {
                    return new NativeNetBankingLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for native_net_banking_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 30:
                if ("layout/native_sdk_netbanking_bank_list_0".equals(obj)) {
                    return new NativeSdkNetbankingBankListBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for native_sdk_netbanking_bank_list is invalid. Received: ".concat(String.valueOf(obj)));
            case 31:
                if ("layout/nativesdk_bank_mandate_list_provider_item_0".equals(obj)) {
                    return new NativesdkBankMandateListProviderItemBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for nativesdk_bank_mandate_list_provider_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 32:
                if ("layout/nativesdk_bank_mandate_section_item_0".equals(obj)) {
                    return new NativesdkBankMandateSectionItemBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for nativesdk_bank_mandate_section_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 33:
                if ("layout/nativesdk_bank_mandate_state_item_0".equals(obj)) {
                    return new NativesdkBankMandateStateItemBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for nativesdk_bank_mandate_state_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 34:
                if ("layout/nativesdk_item_bank_provider_list_0".equals(obj)) {
                    return new NativesdkItemBankProviderListBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for nativesdk_item_bank_provider_list is invalid. Received: ".concat(String.valueOf(obj)));
            case 35:
                if ("layout/nativesdk_item_bank_section_0".equals(obj)) {
                    return new NativesdkItemBankSectionBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for nativesdk_item_bank_section is invalid. Received: ".concat(String.valueOf(obj)));
            case 36:
                if ("layout/nativesdk_payments_bank_info_0".equals(obj)) {
                    return new NativesdkPaymentsBankInfoBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for nativesdk_payments_bank_info is invalid. Received: ".concat(String.valueOf(obj)));
            case 37:
                if ("layout/new_card_bank_offers_0".equals(obj)) {
                    return new NewCardBankOffersBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for new_card_bank_offers is invalid. Received: ".concat(String.valueOf(obj)));
            case 38:
                if ("layout/paytm_bank_info_bankoffer_0".equals(obj)) {
                    return new PaytmBankInfoBankofferBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for paytm_bank_info_bankoffer is invalid. Received: ".concat(String.valueOf(obj)));
            case 39:
                if ("layout/row_net_banking_layout_0".equals(obj)) {
                    return new RowNetBankingLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for row_net_banking_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 40:
                if ("layout/save_card_layout_0".equals(obj)) {
                    return new SaveCardLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for save_card_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 41:
                if ("layout/save_card_layout_2_0".equals(obj)) {
                    return new SaveCardLayout2BindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for save_card_layout_2 is invalid. Received: ".concat(String.valueOf(obj)));
            case 42:
                if ("layout/saved_card_bank_offer_0".equals(obj)) {
                    return new SavedCardBankOfferBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for saved_card_bank_offer is invalid. Received: ".concat(String.valueOf(obj)));
            case 43:
                if ("layout/saved_mandate_layout_0".equals(obj)) {
                    return new SavedMandateLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for saved_mandate_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 44:
                if ("layout/single_emi_details_0".equals(obj)) {
                    return new SingleEmiDetailsBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for single_emi_details is invalid. Received: ".concat(String.valueOf(obj)));
            case 45:
                if ("layout/single_vpa_layout_0".equals(obj)) {
                    return new SingleVpaLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for single_vpa_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 46:
                if ("layout/upi_collect_layout_new_0".equals(obj)) {
                    return new UpiCollectLayoutNewBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for upi_collect_layout_new is invalid. Received: ".concat(String.valueOf(obj)));
            case 47:
                if ("layout/upi_help_card_layout_0".equals(obj)) {
                    return new UpiHelpCardLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for upi_help_card_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 48:
                if ("layout/upi_help_layout_0".equals(obj)) {
                    return new UpiHelpLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for upi_help_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 49:
                if ("layout/upi_help_layout_main_0".equals(obj)) {
                    return new UpiHelpLayoutMainBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for upi_help_layout_main is invalid. Received: ".concat(String.valueOf(obj)));
            case 50:
                if ("layout/upi_onboarding_layout_0".equals(obj)) {
                    return new UpiOnboardingLayoutBindingImpl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for upi_onboarding_layout is invalid. Received: ".concat(String.valueOf(obj)));
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding1(e eVar, View view, int i2, Object obj) {
        if (i2 != 51) {
            if (i2 != 52) {
                return null;
            }
            if ("layout/wallet_lyt_instrument_info_0".equals(obj)) {
                return new WalletLytInstrumentInfoBindingImpl(eVar, view);
            }
            throw new IllegalArgumentException("The tag for wallet_lyt_instrument_info is invalid. Received: ".concat(String.valueOf(obj)));
        } else if ("layout/vpa_layout_container_0".equals(obj)) {
            return new VpaLayoutContainerBindingImpl(eVar, view);
        } else {
            throw new IllegalArgumentException("The tag for vpa_layout_container is invalid. Received: ".concat(String.valueOf(obj)));
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
            if (i4 != 1) {
                return null;
            }
            return internalGetViewDataBinding1(eVar, view, i3, tag);
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
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(31);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sKeys.put(1, "emiViewModel");
            sKeys.put(2, "instrumentSheetViewModel");
            sKeys.put(3, "section");
            sKeys.put(4, "transcationViewModel");
            sKeys.put(5, "allNetBankingViewModel");
            sKeys.put(6, "bankMandateIfscCodeViewModel");
            sKeys.put(7, "codViewModel");
            sKeys.put(8, "view");
            sKeys.put(9, "netBankingViewModel");
            sKeys.put(10, "netbanking");
            sKeys.put(11, "saveCardModel");
            sKeys.put(12, "model");
            sKeys.put(13, "showInstrumentInfoMsg");
            sKeys.put(14, "a");
            sKeys.put(15, "otpViewholder");
            sKeys.put(16, "pincvvmodel");
            sKeys.put(17, "bank_mandate");
            sKeys.put(18, "debitCardModel");
            sKeys.put(19, "selectedInstrumentSheetViewModel");
            sKeys.put(20, "typeface");
            sKeys.put(21, "aoaWalletViewModel");
            sKeys.put(22, "bankViewModel");
            sKeys.put(23, "landingPageViewModel");
            sKeys.put(24, "walletViewModel");
            sKeys.put(25, "digitalCreditModel");
            sKeys.put(26, "cvvHelpModel");
            sKeys.put(27, "bankMandateSubDetailsViewModel");
            sKeys.put(28, "upiHelpModel");
            sKeys.put(29, "upiCollectModel");
        }
    }

    static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(52);
            sKeys = hashMap;
            hashMap.put("layout/activity_login_0", Integer.valueOf(R.layout.activity_login));
            sKeys.put("layout/activity_upi_apps_0", Integer.valueOf(R.layout.activity_upi_apps));
            sKeys.put("layout/aoa_wallet_layout_0", Integer.valueOf(R.layout.aoa_wallet_layout));
            sKeys.put("layout/bank_e_mandate_auth_item_0", Integer.valueOf(R.layout.bank_e_mandate_auth_item));
            sKeys.put("layout/bank_e_mandate_auth_using_view_0", Integer.valueOf(R.layout.bank_e_mandate_auth_using_view));
            sKeys.put("layout/bank_e_mandate_bank_item_0", Integer.valueOf(R.layout.bank_e_mandate_bank_item));
            sKeys.put("layout/bank_e_mandate_new_ac_0", Integer.valueOf(R.layout.bank_e_mandate_new_ac));
            sKeys.put("layout/bank_e_mandate_saved_bank_0", Integer.valueOf(R.layout.bank_e_mandate_saved_bank));
            sKeys.put("layout/cod_layout_0", Integer.valueOf(R.layout.cod_layout));
            sKeys.put("layout/cvv_help_card_layout_0", Integer.valueOf(R.layout.cvv_help_card_layout));
            sKeys.put("layout/cvv_help_layout_0", Integer.valueOf(R.layout.cvv_help_layout));
            sKeys.put("layout/cvv_pin_layout_0", Integer.valueOf(R.layout.cvv_pin_layout));
            sKeys.put("layout/debit_credit_card_layout_0", Integer.valueOf(R.layout.debit_credit_card_layout));
            sKeys.put("layout/digital_credit_info_lyt_0", Integer.valueOf(R.layout.digital_credit_info_lyt));
            sKeys.put("layout/emi_details_layout_0", Integer.valueOf(R.layout.emi_details_layout));
            sKeys.put("layout/emi_layout_0", Integer.valueOf(R.layout.emi_layout));
            sKeys.put("layout/fragment_all_bank_mandate_list_0", Integer.valueOf(R.layout.fragment_all_bank_mandate_list));
            sKeys.put("layout/fragment_bank_mandate_find_ifsc_0", Integer.valueOf(R.layout.fragment_bank_mandate_find_ifsc));
            sKeys.put("layout/fragment_bank_mandate_state_list_0", Integer.valueOf(R.layout.fragment_bank_mandate_state_list));
            sKeys.put("layout/fragment_bank_mandate_sub_details_0", Integer.valueOf(R.layout.fragment_bank_mandate_sub_details));
            sKeys.put("layout/fragment_verify_otp_native_0", Integer.valueOf(R.layout.fragment_verify_otp_native));
            sKeys.put("layout/layout_postpaid_terms_0", Integer.valueOf(R.layout.layout_postpaid_terms));
            sKeys.put("layout/login_fragment_layout_0", Integer.valueOf(R.layout.login_fragment_layout));
            sKeys.put("layout/lyt_instrument_selected_sheet_0", Integer.valueOf(R.layout.lyt_instrument_selected_sheet));
            sKeys.put("layout/lyt_payment_status_sheet_0", Integer.valueOf(R.layout.lyt_payment_status_sheet));
            sKeys.put("layout/native_instrument_0", Integer.valueOf(R.layout.native_instrument));
            sKeys.put("layout/native_instrument_cashier_sheet_0", Integer.valueOf(R.layout.native_instrument_cashier_sheet));
            sKeys.put("layout/native_instrument_loading_sheet_0", Integer.valueOf(R.layout.native_instrument_loading_sheet));
            sKeys.put("layout/native_net_banking_layout_0", Integer.valueOf(R.layout.native_net_banking_layout));
            sKeys.put("layout/native_sdk_netbanking_bank_list_0", Integer.valueOf(R.layout.native_sdk_netbanking_bank_list));
            sKeys.put("layout/nativesdk_bank_mandate_list_provider_item_0", Integer.valueOf(R.layout.nativesdk_bank_mandate_list_provider_item));
            sKeys.put("layout/nativesdk_bank_mandate_section_item_0", Integer.valueOf(R.layout.nativesdk_bank_mandate_section_item));
            sKeys.put("layout/nativesdk_bank_mandate_state_item_0", Integer.valueOf(R.layout.nativesdk_bank_mandate_state_item));
            sKeys.put("layout/nativesdk_item_bank_provider_list_0", Integer.valueOf(R.layout.nativesdk_item_bank_provider_list));
            sKeys.put("layout/nativesdk_item_bank_section_0", Integer.valueOf(R.layout.nativesdk_item_bank_section));
            sKeys.put("layout/nativesdk_payments_bank_info_0", Integer.valueOf(R.layout.nativesdk_payments_bank_info));
            sKeys.put("layout/new_card_bank_offers_0", Integer.valueOf(R.layout.new_card_bank_offers));
            sKeys.put("layout/paytm_bank_info_bankoffer_0", Integer.valueOf(R.layout.paytm_bank_info_bankoffer));
            sKeys.put("layout/row_net_banking_layout_0", Integer.valueOf(R.layout.row_net_banking_layout));
            sKeys.put("layout/save_card_layout_0", Integer.valueOf(R.layout.save_card_layout));
            sKeys.put("layout/save_card_layout_2_0", Integer.valueOf(R.layout.save_card_layout_2));
            sKeys.put("layout/saved_card_bank_offer_0", Integer.valueOf(R.layout.saved_card_bank_offer));
            sKeys.put("layout/saved_mandate_layout_0", Integer.valueOf(R.layout.saved_mandate_layout));
            sKeys.put("layout/single_emi_details_0", Integer.valueOf(R.layout.single_emi_details));
            sKeys.put("layout/single_vpa_layout_0", Integer.valueOf(R.layout.single_vpa_layout));
            sKeys.put("layout/upi_collect_layout_new_0", Integer.valueOf(R.layout.upi_collect_layout_new));
            sKeys.put("layout/upi_help_card_layout_0", Integer.valueOf(R.layout.upi_help_card_layout));
            sKeys.put("layout/upi_help_layout_0", Integer.valueOf(R.layout.upi_help_layout));
            sKeys.put("layout/upi_help_layout_main_0", Integer.valueOf(R.layout.upi_help_layout_main));
            sKeys.put("layout/upi_onboarding_layout_0", Integer.valueOf(R.layout.upi_onboarding_layout));
            sKeys.put("layout/vpa_layout_container_0", Integer.valueOf(R.layout.vpa_layout_container));
            sKeys.put("layout/wallet_lyt_instrument_info_0", Integer.valueOf(R.layout.wallet_lyt_instrument_info));
        }
    }
}
