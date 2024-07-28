package net.one97.paytm.nativesdk.instruments.savedCard.view;

import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import com.alipay.mobile.h5container.api.H5Param;
import com.android.volley.VolleyError;
import com.bumptech.glide.b;
import com.bumptech.glide.e.a;
import com.bumptech.glide.e.h;
import com.bumptech.glide.load.b.j;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import easypay.manager.Constants;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ConvenienceFeeController;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.CardData;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.Utils.SharedPreferenceUtil;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.helpers.GTMLoader;
import net.one97.paytm.nativesdk.common.helpers.VisaEnrollmentHelper;
import net.one97.paytm.nativesdk.common.listeners.ActivityInteractor;
import net.one97.paytm.nativesdk.common.listeners.EnrollmentData;
import net.one97.paytm.nativesdk.common.listeners.EnrollmentListener;
import net.one97.paytm.nativesdk.common.model.ApplyPromoResponse;
import net.one97.paytm.nativesdk.common.model.CardDetails;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.common.model.RiskConvenienceFeeItem;
import net.one97.paytm.nativesdk.common.model.SavedInstruments;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.databinding.SaveCardLayout2Binding;
import net.one97.paytm.nativesdk.emiSubvention.EMIConstants;
import net.one97.paytm.nativesdk.emiSubvention.ISubventionProvider;
import net.one97.paytm.nativesdk.emiSubvention.models.BankData;
import net.one97.paytm.nativesdk.emiSubvention.models.EmiValidatePlan;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.listeners.SetOnEmiClickListener;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.EmiChannelInfo;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.PromoCodeResponse;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.utility.DebitCreditCardUtility;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.view.AddMoneyFeeBottomSheet;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.view.EmiDetailsBottomSheet;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.view.VisaInfoBottomSheet;
import net.one97.paytm.nativesdk.instruments.savedCard.listeners.SavedCardClickListener;
import net.one97.paytm.nativesdk.instruments.savedCard.viewmodel.SavedCardViewModel;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.paymethods.listeners.UpiEncouragementListener;
import net.one97.paytm.nativesdk.paymethods.model.PaytmAssistParams;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public class SavedCardView extends PaytmBaseView implements AddMoneyFeeBottomSheet.AddMoneyBottomSheetListener, EmiDetailsBottomSheet.EmiConvenienceFeeListener, SavedCardClickListener {
    public static final int REQUEST_TENURE_FROM_SAVED_CARD = 2049;
    public static final int REQUEST_TENURE_FROM_SAVED_CARD_EMI_VIEW = 2050;
    public static final String SAVED_CARD_SELECTED = "SAVED_CARD_SELECTED";
    private static final String otp = "otp";
    private String bankCode = "";
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (SDKConstants.UNREGISTER_BROADCAST_PBP.equalsIgnoreCase(intent.getAction())) {
                SavedCardView.this.unregisterBroadCast(context);
            } else if (SDKConstants.HYBRID_WALLET_CHECKED_UNCHECKED.equalsIgnoreCase(intent.getAction())) {
                SavedCardView.this.hybridCheckChanged();
            }
        }
    };
    private String currentEmiPlanId;
    private char dash = '-';
    /* access modifiers changed from: private */
    public EmiChannelInfo emiChannelInfo;
    /* access modifiers changed from: private */
    public String emiPlanData;
    /* access modifiers changed from: private */
    public String fetchPlanResponse;
    private String fourDots = " •••• ";
    /* access modifiers changed from: private */
    public VisaEnrollmentHelper helper;
    /* access modifiers changed from: private */
    public boolean isCreditCardLayout;
    /* access modifiers changed from: private */
    public boolean isEmiView;
    private boolean isVisaOptionDisplayed;
    /* access modifiers changed from: private */
    public SaveCardLayout2Binding lastRadioChecked;
    private EnrollmentListener listener;
    private String mode;
    private BroadcastReceiver networkConnectivityReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equalsIgnoreCase(intent.getAction()) && SDKUtility.isNetworkAvailable(context) && SavedCardView.this.savedCardViewModel != null && SavedCardView.this.savedCardViewModel.isSelected()) {
                SavedCardView.this.savedCardViewModel.fetchConvenienceFee();
            }
        }
    };
    /* access modifiers changed from: private */
    public int prevEmiSelectedPosition = -1;
    private boolean requestTenure;
    /* access modifiers changed from: private */
    public SaveCardLayout2Binding saveCardLayoutBinding;
    private boolean saveNewCard = true;
    /* access modifiers changed from: private */
    public SavedInstruments savedCard;
    /* access modifiers changed from: private */
    public SavedCardViewModel savedCardViewModel;
    private char slash = '/';
    private VpaBankAccountDetail vpaDetail;

    public void changeArrowIcon(boolean z) {
    }

    public void changeRemainingAmt(String str) {
    }

    public void closeKeyboard() {
    }

    public SavedCardView(Context context, SavedInstruments savedInstruments, Instruments instruments, boolean z) {
        super(instruments);
        this.context = context;
        this.savedCard = savedInstruments;
        this.isEmiView = z;
    }

    public void setEmiChannelInfo(EmiChannelInfo emiChannelInfo2) {
        this.emiChannelInfo = emiChannelInfo2;
    }

    public void refreshLayout() {
        setAmountIfNeeded();
        setPaySecurelyText();
        this.savedCardViewModel.invalidatePaymentIntent();
        showEmiAvailable();
        showUpiConsentCheckbox();
        this.saveCardLayoutBinding.emiDetailsLayout.setVisibility(8);
        this.emiChannelInfo = null;
        this.emiPlanData = null;
        this.currentEmiPlanId = null;
        this.savedCardViewModel.setSubventedOfferText((String) null);
        this.savedCardViewModel.setEmiEnabled(false);
        this.prevEmiSelectedPosition = -1;
        this.savedCardViewModel.hideOffer();
        if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
            this.savedCardViewModel.getBankOffers();
        } else {
            this.savedCardViewModel.fetchConvenienceFee();
        }
        this.fetchPlanResponse = null;
    }

    public void selectView() {
        savedCardSelected(true);
    }

    private void setPaySecurelyText() {
        this.savedCardViewModel.setPaySecurelyText();
    }

    /* access modifiers changed from: private */
    public void showEmiAvailable() {
        double diffAmount = SDKUtility.getDiffAmount();
        if (!this.savedCard.isEmiAvailable()) {
            this.saveCardLayoutBinding.tvEmiAvailbale.setVisibility(8);
        } else if (DirectPaymentBL.getInstance().isMultiItemEmiFlow()) {
            this.saveCardLayoutBinding.tvEmiAvailbale.setVisibility(0);
            if (!TextUtils.isEmpty(this.savedCard.getSubventionType())) {
                this.saveCardLayoutBinding.tvEmiAvailbale.setText(SDKUtility.getEmiAvailableText(this.context, this.savedCard.getSubventionType()));
            } else if (this.isEmiView) {
                this.saveCardLayoutBinding.tvEmiAvailbale.setText(this.context.getString(R.string.select_emi_plan));
            } else {
                this.saveCardLayoutBinding.tvEmiAvailbale.setText(this.context.getString(R.string.emi_option_available));
            }
        } else {
            double parseDouble = SDKUtility.parseDouble(this.savedCard.getMinAmount().getValue());
            double parseDouble2 = SDKUtility.parseDouble(this.savedCard.getMaxAmount().getValue());
            if (diffAmount >= parseDouble && diffAmount <= parseDouble2) {
                this.saveCardLayoutBinding.tvEmiAvailbale.setVisibility(0);
                if (this.isEmiView) {
                    this.saveCardLayoutBinding.tvEmiAvailbale.setText(this.context.getString(R.string.select_emi_plan));
                } else {
                    this.saveCardLayoutBinding.tvEmiAvailbale.setText(this.context.getString(R.string.emi_option_available));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void hybridCheckChanged() {
        SavedCardViewModel savedCardViewModel2 = this.savedCardViewModel;
        if (savedCardViewModel2 != null) {
            savedCardViewModel2.hybridCheckChanged();
        }
    }

    /* access modifiers changed from: private */
    public void showUpiConsentCheckbox() {
        if (!SDKConstants.DEBIT.equalsIgnoreCase(this.savedCard.getCardDetails().getCardType())) {
            return;
        }
        if (!this.savedCardViewModel.isToShowUpiConsent(this.savedCard.getIssuingBank()) || this.savedCardViewModel.isEmiEnabled) {
            hideUpiConsentCheckbox();
            showUpiPayOption();
            return;
        }
        this.saveCardLayoutBinding.llUpiCheckbox.setVisibility(0);
        this.saveCardLayoutBinding.cbUpiCheckbox.setChecked(true);
        TextView textView = this.saveCardLayoutBinding.tvUpiCheckbox;
        Context context = this.context;
        int i2 = R.string.native_upi_consent_text;
        textView.setText(context.getString(i2, new Object[]{this.savedCard.getIssuingBank() + " Bank"}));
    }

    private void hideUpiPayOption() {
        this.saveCardLayoutBinding.upiPayOption.setVisibility(8);
    }

    private void showUpiPayOption() {
        this.vpaDetail = SDKUtils.isToShowUpiPayOption(this.savedCard.getIssuingBank(), this.context);
        VpaBankAccountDetail vpaBankAccountDetail = this.vpaDetail;
        if ((vpaBankAccountDetail == null || vpaBankAccountDetail.getBankMetaData() == null || TextUtils.isEmpty(this.vpaDetail.getBankMetaData().getPerTxnLimit()) || Double.parseDouble(this.vpaDetail.getBankMetaData().getPerTxnLimit()) >= SDKUtility.getDiffAmount()) && SDKUtility.isPaytmApp(this.context) && SDKUtility.isUpiPushEnabled() && this.vpaDetail != null) {
            this.saveCardLayoutBinding.upiPayOption.setVisibility(0);
            TextView textView = this.saveCardLayoutBinding.upiPayText;
            Context context = this.context;
            int i2 = R.string.native_upi_option_text;
            textView.setText(context.getString(i2, new Object[]{this.savedCard.getIssuingBank() + " Bank"}));
            return;
        }
        hideUpiPayOption();
    }

    /* access modifiers changed from: private */
    public void hideUpiConsentCheckbox() {
        this.saveCardLayoutBinding.llUpiCheckbox.setVisibility(8);
        this.saveCardLayoutBinding.cbUpiCheckbox.setChecked(false);
    }

    public PaytmBaseView getSavedCardView() {
        boolean z;
        this.saveCardLayoutBinding = (SaveCardLayout2Binding) f.a((LayoutInflater) this.context.getSystemService("layout_inflater"), R.layout.save_card_layout_2, (ViewGroup) null, false);
        this.saveCardLayoutBinding.tvBankOffer.setMovementMethod(LinkMovementMethod.getInstance());
        this.saveCardLayoutBinding.tvBankOfferBottom.setMovementMethod(LinkMovementMethod.getInstance());
        this.saveCardLayoutBinding.tvConvFee.setMovementMethod(LinkMovementMethod.getInstance());
        this.isCreditCardLayout = this.savedCard.getCardDetails().getCardType().contains(SDKConstants.CREDIT);
        String substring = this.savedCard.getCardDetails().getFirstSixDigit().substring(0, 4);
        String lastFourDigit = this.savedCard.getCardDetails().getLastFourDigit();
        this.helper = new VisaEnrollmentHelper();
        Context context = this.context;
        this.savedCardViewModel = new SavedCardViewModel(context, substring + this.fourDots + this.fourDots + lastFourDigit, this.savedCard.getDisplayName(), this.savedCard.getIconUrl(), this.savedCard, this.isEmiView, this);
        this.saveCardLayoutBinding.setSaveCardModel(this.savedCardViewModel);
        this.view = this.saveCardLayoutBinding.getRoot();
        setPaySecurelyText();
        if (this.isEmiView) {
            this.saveCardLayoutBinding.imgEmiCross.setVisibility(8);
        } else {
            this.saveCardLayoutBinding.imgEmiCross.setVisibility(0);
        }
        if (!SDKUtils.isRiskConvFeeApplicable(this.savedCardViewModel.getCardHash())) {
            SDKUtility.handlePromotionVisibility(this.saveCardLayoutBinding.tvPromotion, 0);
        } else {
            SDKUtility.handlePromotionVisibility(this.saveCardLayoutBinding.tvPromotion, 8);
        }
        this.saveCardLayoutBinding.upiPayOption.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventUPI(SDKConstants.GA_UPI_ENCOURAGEMENT, SDKConstants.UPI_SAVED_DC_SELECTED, MerchantBL.getMerchantInstance().getOrderId(), SavedCardView.this.savedCardViewModel.bankName.get(), MerchantBL.getMerchantInstance().getMid()));
                SavedCardView.this.onUpiPayClick();
            }
        });
        this.saveCardLayoutBinding.imgEmiCross.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SavedCardView.this.saveCardLayoutBinding.emiDetailsLayout.setVisibility(8);
                SavedCardView.this.showEmiAvailable();
                SavedCardView.this.saveCardLayoutBinding.tvChangePlan.setVisibility(8);
                SavedCardView.this.saveCardLayoutBinding.tvTotalAmount.setVisibility(8);
                SavedCardView.this.savedCardViewModel.setSubventedOfferText((String) null);
                SavedCardView.this.savedCardViewModel.setEmiEnabled(false);
                SavedCardView.this.showUpiConsentCheckbox();
                int unused = SavedCardView.this.prevEmiSelectedPosition = -1;
                EmiChannelInfo unused2 = SavedCardView.this.emiChannelInfo = null;
                String unused3 = SavedCardView.this.emiPlanData = null;
                if (SavedCardView.this.isEmiView) {
                    SavedCardView.this.hideCvvLayout();
                } else {
                    SavedCardView.this.showCvvLayout();
                }
                SavedCardView.this.savedCardViewModel.getBankOffers();
                SavedCardView.this.savedCardViewModel.fetchConvenienceFee();
            }
        });
        this.saveCardLayoutBinding.tvEmiAvailbale.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SavedCardView.this.sendEmiGAEvent();
                if (!DirectPaymentBL.getInstance().isPaytmWalletChecked() || (!SavedCardView.this.savedCardViewModel.isHybridDisabled() && !SavedCardView.this.savedCardViewModel.isEmiHybridDisabled())) {
                    SavedCardView.this.selectSavedCard();
                    return;
                }
                Context access$1400 = SavedCardView.this.context;
                SDKUtility.showErrorInSnackBar(access$1400, "", "Paytm Wallet and " + SavedCardView.this.savedCardViewModel.bankName.get() + " cannot be used together for this payment.Please select your EMI plan again");
                SavedCardView.this.deselectWallet();
            }
        });
        this.saveCardLayoutBinding.tvChangePlan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SavedCardView.this.selectSavedCard();
            }
        });
        double diffAmount = SDKUtility.getDiffAmount();
        this.saveCardLayoutBinding.getRoot().setTag(this.savedCard);
        if (diffAmount < DirectPaymentBL.getInstance().getEmiMin() || diffAmount > DirectPaymentBL.getInstance().getEmiMax() || z) {
            this.saveCardLayoutBinding.tvEmiAvailbale.setVisibility(8);
        } else if (!(z = this.isEmiView) && this.savedCard.isEmiAvailable()) {
            showEmiAvailable();
        }
        b.b(this.context).a(Integer.valueOf(SDKUtility.getCardImage(this.savedCard.getChannelCode()))).b((a<?>) new h().a(j.f6875a)).a(this.saveCardLayoutBinding.ivSavedCard);
        this.saveCardLayoutBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SavedCardView.this.savedCardSelected();
            }
        });
        this.saveCardLayoutBinding.tvOneClickMsg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (SavedCardView.this.saveCardLayoutBinding.cbOneClick.isChecked()) {
                    SavedCardView.this.savedCardViewModel.isSingleVisaClickChecked.set(false);
                } else {
                    SavedCardView.this.savedCardViewModel.isSingleVisaClickChecked.set(true);
                }
            }
        });
        this.saveCardLayoutBinding.iconVscpInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SavedCardView.this.inflateInfoBottomSheet(true);
            }
        });
        this.saveCardLayoutBinding.tvOneClickDetail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SavedCardView.this.inflateInfoBottomSheet(false);
            }
        });
        this.view = this.saveCardLayoutBinding.getRoot();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SDKConstants.UNREGISTER_BROADCAST);
        intentFilter.addAction(SDKConstants.HYBRID_WALLET_CHECKED_UNCHECKED);
        androidx.localbroadcastmanager.a.a.a(this.context.getApplicationContext()).a(this.broadcastReceiver, intentFilter);
        if (this.context != null) {
            this.context.registerReceiver(this.networkConnectivityReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if (DirectPaymentBL.getInstance().getGtmStringValues() != null) {
            String string = GTMLoader.getString(SDKConstants.KEY_ENABLE_SCP_TEXT);
            if (!TextUtils.isEmpty(string)) {
                this.saveCardLayoutBinding.tvOneClickMsg.setText(string);
            }
            String string2 = GTMLoader.getString(SDKConstants.KEY_SCP_ENABLED_TEXT);
            if (!TextUtils.isEmpty(string2)) {
                this.saveCardLayoutBinding.tvOneClickEnabled.setText(string2);
            }
        }
        return this;
    }

    /* access modifiers changed from: private */
    public void inflateInfoBottomSheet(boolean z) {
        VisaInfoBottomSheet visaInfoBottomSheet = new VisaInfoBottomSheet();
        Bundle bundle = new Bundle();
        if (!(DirectPaymentBL.getInstance().getCjPayMethodResponse() == null || DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody() == null)) {
            bundle.putString("amount", DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getOneClickMaxAmount());
        }
        boolean z2 = this.isCreditCardLayout;
        String str = SDKConstants.GA_SAVED_CC;
        bundle.putString(VisaInfoBottomSheet.KEY_CARD_TYPE, z2 ? str : SDKConstants.GA_SAVED_DC);
        if (z) {
            if (!this.isCreditCardLayout) {
                str = SDKConstants.GA_SAVED_DC;
            }
            SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_INFO_CLICKED, SDKConstants.GA_REPEAT, str));
            bundle.putString(VisaInfoBottomSheet.KEY_INFO_MESSAGE, GTMLoader.getString(SDKConstants.KEY_SCP_ENABLED_INFO_DESCRIPTION));
            bundle.putString(VisaInfoBottomSheet.KEY_INFO_NOTE, GTMLoader.getString(SDKConstants.KEY_SCP_ENABLED_INFO_NOTE));
            bundle.putString(VisaInfoBottomSheet.KEY_FLOW_TYPE, SDKConstants.GA_REPEAT);
        } else {
            if (!this.isCreditCardLayout) {
                str = SDKConstants.GA_SAVED_DC;
            }
            SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_INFO_CLICKED, SDKConstants.GA_ENROLLMENT, str));
            bundle.putString(VisaInfoBottomSheet.KEY_INFO_MESSAGE, GTMLoader.getString(SDKConstants.KEY_SCP_ENABLED_INFO_DESCRIPTION));
            bundle.putString(VisaInfoBottomSheet.KEY_INFO_NOTE, GTMLoader.getString(SDKConstants.KEY_ENABLE_SCP_INFO_NOTE));
            bundle.putString(VisaInfoBottomSheet.KEY_FLOW_TYPE, SDKConstants.GA_ENROLLMENT);
        }
        visaInfoBottomSheet.setArguments(bundle);
        visaInfoBottomSheet.show(((AppCompatActivity) this.context).getSupportFragmentManager(), "");
    }

    /* access modifiers changed from: private */
    public void deselectWallet() {
        try {
            Intent intent = new Intent();
            intent.setAction(SDKConstants.DESELECT_WALLET);
            androidx.localbroadcastmanager.a.a.a(this.context).a(intent);
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    /* access modifiers changed from: private */
    public void sendEmiGAEvent() {
        final String str;
        if (DirectPaymentBL.getInstance().isMultiItemEmiFlow()) {
            String subventionType = this.savedCard.getSubventionType();
            if (SDKConstants.EmiSubventionType.ZERO_COST.name().equalsIgnoreCase(subventionType)) {
                str = "zero cost emi";
            } else {
                str = SDKConstants.EmiSubventionType.LOW_COST.name().equalsIgnoreCase(subventionType) ? "low cost emi" : "emi available";
            }
            SDKUtility.sendGaEvents(new HashMap<String, Object>() {
                {
                    put("event_category", "emi");
                    put("event_action", "emi_available_clicked");
                    put("event_label", str);
                    put("event_label2", "normal checkout");
                    put("vertical_name", "emi");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void selectSavedCard() {
        if (DirectPaymentBL.getInstance().isMultiItemEmiFlow()) {
            openMultiItemPlanSelectionScreen();
        } else {
            openEmiDetailsBottomSheet();
        }
        if (!isSelected()) {
            savedCardSelected();
        }
        this.savedCardViewModel.setSubventedOfferText((String) null);
    }

    private void openEmiDetailsBottomSheet() {
        EmiDetailsBottomSheet instance = EmiDetailsBottomSheet.getInstance(this.savedCard.getIssuingBank(), getEmiType(), this.savedCard.getCardDetails().getCardId(), (String) null, this.prevEmiSelectedPosition, this.savedCardViewModel.getEmiConvenienceFee(), this.savedCardViewModel.getCardHash(), this.savedCardViewModel.getInstantDiscount(), new SetOnEmiClickListener() {
            public void onClick(EmiChannelInfo emiChannelInfo, int i2, String str) {
                SavedCardView.this.changeEMIUi(emiChannelInfo, i2, str);
                SavedCardView.this.savedCardViewModel.setEmiEnabled(true);
                SavedCardView.this.hideUpiConsentCheckbox();
            }
        }, this);
        q a2 = ((AppCompatActivity) this.context).getSupportFragmentManager().a();
        a2.a("emisheet");
        instance.show(a2, (String) null);
        if (instance.getDialog() != null) {
            instance.getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    SavedCardView.this.savedCardViewModel.setEmiEnabled(false);
                    SavedCardView.this.showUpiConsentCheckbox();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void startTenureActivity() {
        if (this.savedCardViewModel.isSelected()) {
            String str = null;
            ApplyPromoResponse.PaymentOffer emiBankOffer = this.savedCardViewModel.getEmiBankOffer();
            String priceWithoutDecimal = SDKUtility.priceWithoutDecimal(SDKUtility.getDiffAmount());
            if (SDKUtility.isOfferValid(emiBankOffer)) {
                str = new com.google.gson.f().b(emiBankOffer);
                priceWithoutDecimal = MerchantBL.getMerchantInstance().getWithoutDoubleAmount(SDKUtility.getEffectAfterOfferAmount(emiBankOffer.getTotalInstantDiscount()));
            }
            String str2 = str;
            String str3 = priceWithoutDecimal;
            if (this.isEmiView) {
                EmiUtil.startEmiPlanActivity(this.context, this.fetchPlanResponse, str3, this.savedCard.getCardDetails().getCardId(), REQUEST_TENURE_FROM_SAVED_CARD_EMI_VIEW, this.savedCardViewModel.getEmiPaymentIntent(), str2, this.currentEmiPlanId);
            } else {
                EmiUtil.startEmiPlanActivity(this.context, this.fetchPlanResponse, str3, this.savedCard.getCardDetails().getCardId(), REQUEST_TENURE_FROM_SAVED_CARD, this.savedCardViewModel.getEmiPaymentIntent(), str2, this.currentEmiPlanId);
            }
        }
    }

    private void fetchMultiEmiTenures() {
        this.savedCardViewModel.buildEmiPaymentIntent();
        if (this.fetchPlanResponse != null) {
            startTenureActivity();
            this.saveCardLayoutBinding.pbSelectPlan.setVisibility(8);
            return;
        }
        BankData bankData = new BankData();
        bankData.setType(this.savedCard.getSubventionType());
        bankData.setBankName(this.savedCard.getIssuingBank());
        bankData.setBankCode(this.savedCard.getIssuingBank());
        bankData.setCardType(this.savedCard.getCardDetails().getCardType());
        String str = null;
        if (SDKUtility.isOfferValid(this.savedCardViewModel.getEmiBankOffer())) {
            str = new com.google.gson.f().b(this.savedCardViewModel.getEmiBankOffer());
        }
        if (!SDKUtility.isNetworkAvailable(this.context)) {
            SDKUtility.showErrorInSnackBar(this.context, this.context.getResources().getString(R.string.no_connection), this.context.getResources().getString(R.string.no_internet));
        } else {
            EmiUtil.fetchTenuresWithOffers(bankData, new ISubventionProvider.IBankTenureListener() {
                public void onBankSuccessResponse(String str) {
                    String unused = SavedCardView.this.fetchPlanResponse = str;
                    SavedCardView.this.startTenureActivity();
                    SavedCardView.this.saveCardLayoutBinding.pbSelectPlan.setVisibility(8);
                }

                public void onBankError(String str, String str2) {
                    SavedCardView.this.saveCardLayoutBinding.pbSelectPlan.setVisibility(8);
                    SDKUtility.showErrorInSnackBar(SavedCardView.this.context, str, str2);
                }

                public void onBankNetworkError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
                    if (EmiUtil.isAuthError(apiResponseError)) {
                        SDKUtility.handleVerticalError(apiResponseError, SavedCardView.this.context);
                        return;
                    }
                    SavedCardView.this.saveCardLayoutBinding.pbSelectPlan.setVisibility(8);
                    SDKUtility.showErrorInSnackBar(SavedCardView.this.context, apiResponseError.getErrorTitle(), apiResponseError.getErrorMsg());
                }
            }, this.savedCardViewModel.getEmiPaymentIntent(), str);
        }
    }

    private void openMultiItemPlanSelectionScreen() {
        if (this.saveCardLayoutBinding.pbSelectPlan.getVisibility() != 0) {
            this.saveCardLayoutBinding.pbSelectPlan.setVisibility(0);
            if (!DirectPaymentBL.getInstance().isBankOffersAvailable() || this.savedCardViewModel.getEmiBankOffer() != null) {
                fetchMultiEmiTenures();
            } else {
                this.savedCardViewModel.fetchEmiBankOffer();
            }
        }
    }

    private void uncheckLastSavedCardEmi() {
        if (DirectPaymentBL.getInstance().getLastSelectedEmiSavedView() != null) {
            DirectPaymentBL.getInstance().getLastSelectedEmiSavedView().deselectView();
            DirectPaymentBL.getInstance().setLastSelectedEmiSavedView((SavedCardView) null);
        }
        DirectPaymentBL.getInstance().setLastSelectedEmiSavedView(this);
    }

    private String getEmiType() {
        return (this.isCreditCardLayout ? PayMethodType.CREDIT_CARD : PayMethodType.DEBIT_CARD).name();
    }

    /* access modifiers changed from: private */
    public void hideCvvLayout() {
        if (!SDKUtils.isRiskConvFeeApplicable(this.savedCardViewModel.getCardHash())) {
            SDKUtility.handlePromotionVisibility(this.saveCardLayoutBinding.tvPromotion, 0);
        }
        this.saveCardLayoutBinding.cvvLayout.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void showCvvLayout() {
        SDKUtility.handlePromotionVisibility(this.saveCardLayoutBinding.tvPromotion, 8);
        this.saveCardLayoutBinding.cvvLayout.setVisibility(0);
        setLeftRightMargin(28, this.saveCardLayoutBinding.cvvLayout);
        this.mode = "otp";
        this.mode = "otp";
        if (this.savedCard.getChannelCode().equalsIgnoreCase(SDKConstants.MAESTRO)) {
            this.saveCardLayoutBinding.cvvLayout.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void savedCardSelected() {
        savedCardSelected(false);
    }

    private void savedCardSelected(boolean z) {
        if (!isSelected()) {
            if (this.isEmiView && !z) {
                Intent intent = new Intent();
                intent.setAction(SAVED_CARD_SELECTED);
                androidx.localbroadcastmanager.a.a.a(this.context).a(intent);
            }
            if (DirectPaymentBL.getInstance().lastInsufficuentAmountError != null) {
                DirectPaymentBL.getInstance().lastInsufficuentAmountError.set("");
            }
            setPaySecurelyText();
            if (!this.isEmiView) {
                DirectPaymentBL.getInstance().closeOpnedView();
                DirectPaymentBL.getInstance().setPaytmBaseView(this);
            } else {
                uncheckLastSavedCardEmi();
            }
            setSelected(true);
            this.savedCardViewModel.setSelected(true);
            if (SDKUtility.isAppInvokeFlow()) {
                String str = this.isCreditCardLayout ? SDKConstants.AI_KEY_SAVED_CC : SDKConstants.AI_KEY_SAVED_DC;
                SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAYMODE_CLICKED, str, H5Param.DEFAULT_LONG_PRESSO_LOGIN));
                if (DirectPaymentBL.getInstance().getPaymentFlowAvailable() != null && DirectPaymentBL.getInstance().getPaymentFlowAvailable().equals(SDKConstants.ADDANDPAY) && DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAYMODE_ADDANDPAY_CLICKED, str));
                }
            }
            if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
                this.savedCardViewModel.getBankOffers();
            } else {
                this.savedCardViewModel.fetchConvenienceFee();
            }
            if (!DirectPaymentBL.getInstance().isOpeningAuto()) {
                if (SDKConstants.GA_KEY_SAVED_CARDS.equalsIgnoreCase(DirectPaymentBL.getInstance().getDefaultSelectedPayOption())) {
                    if (SDKUtility.isHybridCase()) {
                        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_SAVED_CARDS, SDKConstants.GA_KEY_HYBRID));
                    } else {
                        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_SAVED_CARDS, SDKConstants.GA_KEY_DEFAULT));
                    }
                } else if (SDKUtility.isHybridCase()) {
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_SAVED_CARDS, SDKConstants.GA_KEY_HYBRID));
                } else {
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_SAVED_CARDS, SDKConstants.GA_KEY_SAVED_CARDS));
                }
            }
            SavedInstruments savedInstruments = this.savedCard;
            if (savedInstruments == null || savedInstruments.getIsDisabled() == null || !this.savedCard.getIsDisabled().getStatus()) {
                if (!(DirectPaymentBL.getInstance().getSelectedInstrument() == null || DirectPaymentBL.getInstance().getSelectedInstrument().getBaseViewModel() == null)) {
                    DirectPaymentBL.getInstance().getSelectedInstrument().getBaseViewModel().deselectView();
                }
                this.saveCardLayoutBinding.btnProceed.setVisibility(0);
                this.saveCardLayoutBinding.rbCardNumber.setChecked(true);
                this.saveCardLayoutBinding.rbCardNumber.setTypeface((Typeface) null, 1);
                this.saveCardLayoutBinding.rbCardNumber.setTag(this.savedCard);
                if (this.isEmiView) {
                    if (this.emiChannelInfo != null) {
                        this.saveCardLayoutBinding.txtEmiDetails.setText(this.context.getResources().getString(R.string.emi_details, new Object[]{this.emiChannelInfo.getEmiPerMonth(), this.emiChannelInfo.getOfMonths(), new DecimalFormat(".##", new DecimalFormatSymbols(Locale.US)).format(Double.valueOf(this.emiChannelInfo.getInterestRate()))}));
                        this.saveCardLayoutBinding.txtEmiDetails.setVisibility(0);
                        this.saveCardLayoutBinding.emiDetailsLayout.setVisibility(0);
                    } else {
                        showEmiAvailable();
                    }
                } else if (this.savedCard.isEmiAvailable()) {
                    double diffAmount = SDKUtility.getDiffAmount();
                    if (diffAmount < DirectPaymentBL.getInstance().getEmiMin() || diffAmount > DirectPaymentBL.getInstance().getEmiMax()) {
                        this.saveCardLayoutBinding.tvEmiAvailbale.setVisibility(8);
                    } else {
                        showEmiAvailable();
                    }
                }
                if (!this.isEmiView) {
                    showCvvLayout();
                }
                if (this.emiChannelInfo != null) {
                    showCvvLayout();
                }
                this.saveCardLayoutBinding.tvUpiCheckbox.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        SavedCardView.this.saveCardLayoutBinding.cbUpiCheckbox.setChecked(!SavedCardView.this.saveCardLayoutBinding.cbUpiCheckbox.isChecked());
                    }
                });
                this.lastRadioChecked = this.saveCardLayoutBinding;
                if (this.savedCard.getChannelCode().equalsIgnoreCase(SDKConstants.AMEX)) {
                    this.saveCardLayoutBinding.etCvv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
                } else {
                    this.saveCardLayoutBinding.etCvv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
                }
                this.saveCardLayoutBinding.etCvv.addTextChangedListener(new TextWatcher() {
                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }

                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }

                    public void afterTextChanged(Editable editable) {
                        SavedCardView savedCardView = SavedCardView.this;
                        savedCardView.makeCvvErrorMessageNormal(savedCardView.saveCardLayoutBinding);
                        if (SavedCardView.this.savedCard.getChannelCode().equalsIgnoreCase(SDKConstants.AMEX)) {
                            if (editable.toString().trim().length() == 4) {
                                SDKUtility.hideKeyboard(SavedCardView.this.saveCardLayoutBinding.etCvv, SavedCardView.this.context);
                            }
                        } else if (editable.toString().trim().length() == 3) {
                            SDKUtility.hideKeyboard(SavedCardView.this.saveCardLayoutBinding.etCvv, SavedCardView.this.context);
                        }
                    }
                });
                if (this.savedCard.getHasLowSuccess() == null || !this.savedCard.getHasLowSuccess().getStatus()) {
                    this.savedCardViewModel.lowSuccess.set(8);
                } else {
                    this.savedCardViewModel.lowSuccess.set(0);
                    this.saveCardLayoutBinding.textViewLowSuccess.setText(this.savedCard.getHasLowSuccess().getMsg());
                }
                this.saveCardLayoutBinding.btnProceed.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        SavedCardView.this.proceedClicked(true);
                    }
                });
                if (this.saveCardLayoutBinding.cvvLayout.getVisibility() != 0) {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            SDKUtility.hideKeyboard(SavedCardView.this.saveCardLayoutBinding.etCvv, SavedCardView.this.context);
                        }
                    }, 200);
                }
                this.bankCode = this.savedCard.getIssuingBank();
                scrollTo(this.saveCardLayoutBinding.getRoot());
                isOnceClicked = true;
                SDKUtility.expand(this.saveCardLayoutBinding.getRoot(), (Integer) null);
                hitPromoCodeApiForSavedCard(this.saveCardLayoutBinding, this.savedCard.getCardDetails().getCardId(), this.savedCard.getCardDetails().getCardType().equalsIgnoreCase(SDKConstants.CREDIT));
                showUpiConsentCheckbox();
                if (isVisaSingleClickEnabled()) {
                    checkVisaConsentFlow();
                }
                updateVisaSingleClickUI();
                return;
            }
            DialogUtility.showErrorInstrumentDialog(this.context.getResources().getString(R.string.your_card_is_blocked), this.savedCard.getIsDisabled().getMsg(), this.context);
            this.saveCardLayoutBinding.rbCardNumber.setChecked(false);
        }
    }

    private void checkVisaConsentFlow() {
        if (this.savedCard != null) {
            int consentFlagType = SDKUtils.getConsentFlagType();
            if (consentFlagType == SDKConstants.CONDITIONAL_VISA_SELECTION.intValue()) {
                CardDetails cardDetails = this.savedCard.getCardDetails();
                if (cardDetails != null && DirectPaymentBL.getInstance().getCustomerId() != null) {
                    if (SharedPreferenceUtil.getInstance().getBoolean(SDKUtils.getVisaAlias(cardDetails.getFirstSixDigit(), cardDetails.getLastFourDigit(), DirectPaymentBL.getInstance().getCustomerId()), false)) {
                        this.savedCardViewModel.isSingleVisaClickChecked.set(true);
                    }
                }
            } else if (consentFlagType == SDKConstants.PRE_VISA_SELECTION.intValue()) {
                this.savedCardViewModel.isSingleVisaClickChecked.set(true);
            }
        }
    }

    public void updateVisaSingleClickUI() {
        if (this.savedCardViewModel != null) {
            final CardData cardData = new CardData(this.savedCard.getCardDetails().getFirstSixDigit(), this.savedCard.getCardDetails().getLastFourDigit(), this.savedCard.getCardDetails().getExpiryDate());
            if (isVisaSingleClickEnabled()) {
                if (this.listener == null) {
                    this.listener = new EnrollmentListener() {
                        public void isEnrolled(EnrollmentData enrollmentData) {
                            if (!enrollmentData.isEligible() || !(SavedCardView.this.context instanceof ActivityInteractor) || !((ActivityInteractor) SavedCardView.this.context).isUIEnable()) {
                                SavedCardView.this.upateSavedCardViewWithCvv();
                            } else if (!SavedCardView.this.isSelected()) {
                                if (enrollmentData.isEnrolled()) {
                                    SavedCardView.this.savedCardViewModel.showVisaOneClick.set(0);
                                    SavedCardView.this.enableVisaSingleClickEnrolledView();
                                } else {
                                    SavedCardView.this.savedCardViewModel.showVisaOneClick.set(8);
                                }
                                SavedCardView.this.hideCvvLayout();
                            } else {
                                SavedCardView.this.savedCardViewModel.showVisaOneClick.set(0);
                                if (enrollmentData.isEnrolled()) {
                                    SavedCardView.this.helper.createOnClickInfoObject(cardData);
                                    SavedCardView.this.enableVisaSingleClickEnrolledView();
                                    return;
                                }
                                SavedCardView.this.addAnimationVisa();
                                SavedCardView.this.showCvvLayout();
                                SavedCardView savedCardView = SavedCardView.this;
                                savedCardView.preInitCardEnrollment(savedCardView.context, cardData);
                            }
                        }
                    };
                }
                if (this.helper.isVisaCardEnrolled(this.context, cardData, this.isCreditCardLayout ? SDKConstants.GA_SAVED_CC : SDKConstants.GA_SAVED_DC, this.listener, this.savedCardViewModel.netPayableAmount.doubleValue(), getPayMode()) == null) {
                    upateSavedCardViewWithCvv();
                    return;
                }
                return;
            }
            upateSavedCardViewWithCvv();
        }
    }

    private boolean isVisaSingleClickEnabled() {
        return DirectPaymentBL.getInstance().isVisaOneClickEnabled() && this.savedCard.isOneClickSupported() && isVSCPEligible();
    }

    /* access modifiers changed from: private */
    public void upateSavedCardViewWithCvv() {
        if (isSelected()) {
            showCvvLayout();
        } else {
            hideCvvLayout();
        }
        this.savedCardViewModel.showVisaOneClick.set(8);
        this.savedCardViewModel.isSingleVisaClickChecked.set(false);
    }

    public void preInitCardEnrollment(Context context, CardData cardData) {
        this.helper.createOnClickInfoObject(cardData);
    }

    /* access modifiers changed from: private */
    public void enableVisaSingleClickEnrolledView() {
        if (!this.isVisaOptionDisplayed) {
            SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_CHECKBOX_DISPLAYED, SDKConstants.GA_REPEAT, this.isCreditCardLayout ? SDKConstants.GA_SAVED_CC : SDKConstants.GA_SAVED_DC));
            this.isVisaOptionDisplayed = true;
        }
        this.saveCardLayoutBinding.cbOneClick.setVisibility(8);
        this.saveCardLayoutBinding.tvOneClickDetail.setVisibility(8);
        this.saveCardLayoutBinding.cvvLayout.setVisibility(8);
        this.saveCardLayoutBinding.tvOneClickMsg.setVisibility(8);
        this.saveCardLayoutBinding.tvOneClickEnabled.setVisibility(0);
        this.saveCardLayoutBinding.iconVscpInfo.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void addAnimationVisa() {
        if (!this.isVisaOptionDisplayed) {
            SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_CHECKBOX_DISPLAYED, SDKConstants.GA_ENROLLMENT, this.isCreditCardLayout ? SDKConstants.GA_SAVED_CC : SDKConstants.GA_SAVED_DC));
            this.isVisaOptionDisplayed = true;
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (SavedCardView.this.saveCardLayoutBinding.oneClickContainer != null) {
                    SavedCardView.this.saveCardLayoutBinding.oneClickContainer.startAnimation(AnimationUtils.loadAnimation(SavedCardView.this.context, R.anim.shake_animation));
                }
            }
        }, 500);
    }

    /* access modifiers changed from: private */
    public void proceedClicked(boolean z) {
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventUPI(SDKConstants.GA_UPI_CONSENT, SDKConstants.GA_UPI_CONSENT_STATUS, String.valueOf(this.saveCardLayoutBinding.cbUpiCheckbox.isChecked()), "saved_dc_selected|" + this.savedCardViewModel.bankName.get(), MerchantBL.getMerchantInstance().getMid()));
        if (SDKUtility.shouldShowValidatePromoError() && (this.savedCardViewModel.applyPromoFailed || DirectPaymentBL.getInstance().getPaymentFlowBankOffer().equals(SDKConstants.ADDANDPAY))) {
            this.savedCardViewModel.setValidatePromoText();
        } else if (this.isEmiView && this.emiChannelInfo == null) {
            Toast.makeText(this.context, "Please select EMI plan.", 1).show();
        } else if (!TextUtils.isEmpty(this.mode)) {
            if (this.saveCardLayoutBinding.cvvLayout.getVisibility() == 0) {
                String str = "Credit Card";
                if (this.savedCard.getChannelCode().equalsIgnoreCase(SDKConstants.AMEX)) {
                    if (this.saveCardLayoutBinding.etCvv.getText().toString().trim().length() != 4) {
                        changeCvvUi(this.saveCardLayoutBinding, true);
                        if (!this.isCreditCardLayout) {
                            str = "Debit Card";
                        }
                        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_PAY_CLICKED_ERROR, str, "CVV Not Entered (Saved Cards)"));
                        return;
                    }
                } else if (this.saveCardLayoutBinding.etCvv.getText().toString().trim().length() != 3) {
                    changeCvvUi(this.saveCardLayoutBinding, true);
                    if (!this.isCreditCardLayout) {
                        str = "Debit Card";
                    }
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_PAY_CLICKED_ERROR, str, "Invalid CVV (Save Cards)"));
                    return;
                }
            } else {
                changeCvvUi(this.saveCardLayoutBinding, false);
                this.saveCardLayoutBinding.etCvv.setText("");
            }
            String str2 = this.savedCard.getCardDetails().getCardId() + "||" + this.saveCardLayoutBinding.etCvv.getText().toString().trim() + "|";
            if (SDKUtility.isHybridCase()) {
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", "pay_clicked", SDKConstants.GA_KEY_SAVED_CARDS, SDKConstants.GA_KEY_HYBRID, sb.toString(), ""));
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(System.currentTimeMillis());
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", "pay_clicked", SDKConstants.GA_KEY_SAVED_CARDS, SDKConstants.GA_KEY_SAVED_CARDS, sb2.toString(), ""));
            }
            if (!DirectPaymentBL.getInstance().isRiskConvenienceFeeApplied(getPayMode()) || !z) {
                if (SDKUtility.isAppInvokeFlow()) {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAY_BUTTON_CLICKED, this.isCreditCardLayout ? SDKConstants.AI_KEY_SAVED_CC : SDKConstants.AI_KEY_SAVED_DC));
                }
                if (!DirectPaymentBL.getInstance().isSubsCriptionFlow() || !DirectPaymentBL.getInstance().isWalletChecked() || DirectPaymentBL.getInstance().isWalletOtpValidated() || this.context == null) {
                    goForTransaction(this.mode, str2, this.savedCard.getChannelCode(), this.saveCardLayoutBinding.btnProceed);
                } else {
                    Toast.makeText(this.context, this.context.getString(R.string.otp_not_validated), 0).show();
                }
            } else {
                showRiskConvenienceFeeInfo();
            }
        }
    }

    private void showRiskConvenienceFeeInfo() {
        RiskConvenienceFeeItem riskConvenienceFeeItem = DirectPaymentBL.getInstance().getRiskConvenienceFeeItem(getPayMode());
        AddMoneyFeeBottomSheet instance = AddMoneyFeeBottomSheet.Companion.getInstance(riskConvenienceFeeItem.getFeePercent(), riskConvenienceFeeItem.getReason(), getPayMode());
        if (this.context instanceof AppCompatActivity) {
            try {
                q a2 = ((AppCompatActivity) this.context).getSupportFragmentManager().a();
                a2.a((Fragment) instance, AddMoneyFeeBottomSheet.TAG);
                a2.c();
            } catch (Exception e2) {
                LogUtility.printStackTrace(e2);
            }
            instance.setCallbackListener(this);
        }
    }

    private void hitPromoCodeApiForSavedCard(final SaveCardLayout2Binding saveCardLayout2Binding, String str, boolean z) {
        if (DirectPaymentBL.getInstance().isPromoCodeExist()) {
            final String promoCodeApiUrl = NativeSdkGtmLoader.getPromoCodeApiUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId());
            NativeSDKRepository.getInstance().fetchPromoCodeDetail(str.replace(String.valueOf(this.dash), ""), z ? SDKConstants.CREDIT : SDKConstants.DEBIT, new PaymentMethodDataSource.Callback<PromoCodeResponse>() {
                public void onResponse(PromoCodeResponse promoCodeResponse) {
                    if (saveCardLayout2Binding != null && SavedCardView.this.lastRadioChecked != null) {
                        if (promoCodeResponse == null || promoCodeResponse.getBody() == null || promoCodeResponse.getBody().getPromoCodeDetail() == null || TextUtils.isEmpty(promoCodeResponse.getBody().getPromoCodeDetail().getPromoMsg())) {
                            saveCardLayout2Binding.tvPromoMessage.setVisibility(8);
                        } else if (promoCodeResponse.getBody().getResultInfo().getResultStatus().equalsIgnoreCase("FAILURE")) {
                            saveCardLayout2Binding.tvPromoMessage.setText(promoCodeResponse.getBody().getPromoCodeDetail().getPromoErrorMsg());
                            saveCardLayout2Binding.tvPromoMessage.setVisibility(0);
                            saveCardLayout2Binding.tvPromoMessage.setBackgroundColor(Color.parseColor("#fdfbd3"));
                            saveCardLayout2Binding.tvPromoMessage.setTextColor(Color.parseColor("#666666"));
                        } else {
                            saveCardLayout2Binding.tvPromoMessage.setText(promoCodeResponse.getBody().getPromoCodeDetail().getPromoMsg());
                            saveCardLayout2Binding.tvPromoMessage.setVisibility(0);
                            saveCardLayout2Binding.tvPromoMessage.setBackgroundColor(Color.parseColor("#e8f8f1"));
                            saveCardLayout2Binding.tvPromoMessage.setTextColor(Color.parseColor("#222222"));
                        }
                    }
                }

                public void onErrorResponse(VolleyError volleyError, PromoCodeResponse promoCodeResponse) {
                    SavedCardView.this.showServerFailureAlert(volleyError);
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.API_TIME_OUT, SavedCardView.this.isCreditCardLayout ? "Credit Card" : "Debit Card", promoCodeApiUrl));
                }
            });
        }
    }

    public void openAutoInstrument() {
        savedCardSelected();
    }

    public void closeView() {
        closeKeyboard();
        this.savedCardViewModel.setEmiEnabled(false);
        this.saveCardLayoutBinding.rbCardNumber.setChecked(false);
        this.saveCardLayoutBinding.rbCardNumber.setTypeface((Typeface) null, 0);
        this.saveCardLayoutBinding.etCvv.setText("");
        this.savedCardViewModel.setSubventedOfferText((String) null);
        if (this.isEmiView) {
            this.saveCardLayoutBinding.tvEmiAvailbale.setVisibility(8);
        } else {
            showEmiAvailable();
        }
        this.saveCardLayoutBinding.cvvLayout.setVisibility(8);
        this.saveCardLayoutBinding.btnProceed.setVisibility(8);
        this.saveCardLayoutBinding.textViewLowSuccess.setVisibility(8);
        this.saveCardLayoutBinding.txtamount.setVisibility(8);
        this.saveCardLayoutBinding.tvPromoMessage.setVisibility(8);
        this.prevEmiSelectedPosition = -1;
        if (this.saveCardLayoutBinding.emiDetailsLayout.getVisibility() == 0) {
            this.saveCardLayoutBinding.emiDetailsLayout.setVisibility(8);
        }
        this.savedCardViewModel.hideOffer();
        if (this.isEmiView) {
            this.savedCardViewModel.hideOfferAvailabilityInfo();
        }
        this.savedCardViewModel.convFeeTextVisibility.set(8);
        this.savedCardViewModel.hideLoading();
        this.savedCardViewModel.setSelected(false);
        setSelected(false);
        updateVisaSingleClickUI();
        this.savedCardViewModel.isSingleVisaClickChecked.set(false);
        hideUpiConsentCheckbox();
        hideUpiPayOption();
    }

    public void showAnimation(boolean z) {
        if (!z && isOnceClicked) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ObjectAnimator.ofInt(SavedCardView.this.instruments.getScrollView(), "scrollY", new int[]{(int) SavedCardView.this.getView().getY()}).setDuration(500).start();
                }
            }, 1000);
        }
    }

    public void bankEmiOfferReceived() {
        fetchMultiEmiTenures();
    }

    public void bankEmiOfferError() {
        fetchMultiEmiTenures();
    }

    public void setAmountIfNeeded() {
        this.saveCardLayoutBinding.txtamount.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void showServerFailureAlert(VolleyError volleyError) {
        String str;
        if (!SDKUtility.isNetworkAvailable(this.context)) {
            DialogUtility.showNoInternetDialog(this.context, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            return;
        }
        try {
            str = DebitCreditCardUtility.getFailureReponse(new String(volleyError.networkResponse.data, AppConstants.UTF_8), this.context);
        } catch (Exception unused) {
            str = this.context.getResources().getString(R.string.server_communication_failed);
        }
        DialogUtility.showDialog(this.context, this.context.getResources().getString(R.string.unknown_error), str, (DialogInterface.OnClickListener) null);
    }

    /* access modifiers changed from: private */
    public void changeEMIUi(EmiChannelInfo emiChannelInfo2, int i2, String str) {
        showCvvLayout();
        this.prevEmiSelectedPosition = i2;
        DecimalFormat decimalFormat = new DecimalFormat(".##", new DecimalFormatSymbols(Locale.US));
        this.emiChannelInfo = emiChannelInfo2;
        if (!TextUtils.isEmpty(str)) {
            this.saveCardLayoutBinding.tvTotalAmount.setVisibility(0);
            RoboTextView roboTextView = this.saveCardLayoutBinding.tvTotalAmount;
            roboTextView.setText("Total " + this.context.getString(R.string.nativesdk_amount, new Object[]{str}));
        } else {
            this.saveCardLayoutBinding.tvTotalAmount.setVisibility(8);
        }
        this.saveCardLayoutBinding.tvChangePlan.setVisibility(0);
        this.saveCardLayoutBinding.emiDetailsLayout.setVisibility(0);
        this.saveCardLayoutBinding.tvEmiAvailbale.setVisibility(8);
        this.saveCardLayoutBinding.txtEmiDetails.setText(this.context.getResources().getString(R.string.emi_details, new Object[]{this.emiChannelInfo.getEmiPerMonth(), this.emiChannelInfo.getOfMonths(), decimalFormat.format(Double.valueOf(this.emiChannelInfo.getInterestRate()))}));
    }

    private void setLeftRightMargin(int i2, LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.setMargins(convertDpToPixel(i2), convertDpToPixel(10), convertDpToPixel(0), convertDpToPixel(0));
        linearLayout.setLayoutParams(layoutParams);
    }

    private int convertDpToPixel(int i2) {
        return (int) TypedValue.applyDimension(1, (float) i2, this.context.getResources().getDisplayMetrics());
    }

    /* access modifiers changed from: private */
    public void makeCvvErrorMessageNormal(SaveCardLayout2Binding saveCardLayout2Binding) {
        saveCardLayout2Binding.txtErrMsg.setVisibility(8);
        saveCardLayout2Binding.txtErrMsg.setText("");
        saveCardLayout2Binding.cvvLayout.setBackgroundResource(R.drawable.white_background_with_border);
    }

    private void changeCvvUi(SaveCardLayout2Binding saveCardLayout2Binding, boolean z) {
        if (z) {
            saveCardLayout2Binding.cvvLayout.setBackgroundResource(R.drawable.edit_text_error_bg);
            saveCardLayout2Binding.txtErrMsg.setVisibility(0);
            saveCardLayout2Binding.txtErrMsg.setText(this.context.getResources().getString(R.string.native_enter_valid_cvv));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) saveCardLayout2Binding.txtErrMsg.getLayoutParams();
            layoutParams.setMargins(convertDpToPixel(30), convertDpToPixel(10), convertDpToPixel(H5Param.WEBVIEW_FONT_SIZE_LARGER), convertDpToPixel(0));
            saveCardLayout2Binding.txtErrMsg.setLayoutParams(layoutParams);
            saveCardLayout2Binding.txtErrMsg.setLayoutParams(layoutParams);
            return;
        }
        saveCardLayout2Binding.txtErrMsg.setVisibility(8);
        saveCardLayout2Binding.txtErrMsg.setText("");
        saveCardLayout2Binding.cvvLayout.setBackgroundResource(R.drawable.white_background_with_border);
    }

    private void goForTransaction(String str, String str2, String str3, View view) {
        String str4;
        String str5 = str;
        String str6 = str3;
        this.savedCardViewModel.cashBackTextVisibility.set(8);
        boolean z = this.isCreditCardLayout;
        String str7 = SDKConstants.CREDIT;
        String str8 = z ? str7 : SDKConstants.DEBIT;
        String str9 = "EMI";
        if (this.isEmiView) {
            EmiChannelInfo emiChannelInfo2 = this.emiChannelInfo;
            if (emiChannelInfo2 != null) {
                str4 = emiChannelInfo2.getPlanId();
            } else {
                Toast.makeText(this.context, "Please select EMI plan.", 1).show();
                return;
            }
        } else {
            EmiChannelInfo emiChannelInfo3 = this.emiChannelInfo;
            if (emiChannelInfo3 != null) {
                str4 = emiChannelInfo3.getPlanId();
            } else {
                str9 = str8;
                str4 = null;
            }
        }
        HashMap<String, String> cardsTranscationParam = PayUtility.getCardsTranscationParam(str5, str9, str2, this.saveNewCard ? "1" : "0", str4);
        if (DirectPaymentBL.getInstance().isNativeJsonRequestSupported()) {
            if (!this.isCreditCardLayout) {
                str7 = SDKConstants.DEBIT;
            }
            cardsTranscationParam.put("emiType", str7);
        } else {
            if (!this.isCreditCardLayout) {
                str7 = SDKConstants.DEBIT;
            }
            cardsTranscationParam.put(PayUtility.EMI_TYPE, str7);
        }
        PaytmAssistParams paytmAssistParams = new PaytmAssistParams();
        if (!TextUtils.isEmpty(this.bankCode)) {
            paytmAssistParams.setBankCode(this.bankCode);
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        String str10 = Constants.EASYPAY_PAYTYPE_CREDIT_CARD;
        if (!isEmpty && str5.equalsIgnoreCase("otp")) {
            paytmAssistParams.setPayType(this.isCreditCardLayout ? str10 : Constants.EASYPAY_PAYTYPE_DEBIT_CARD);
        }
        if (!TextUtils.isEmpty(str3)) {
            paytmAssistParams.setCardType(str6);
        }
        PaymentInstrument paymentInstrument = new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), SDKUtility.addAuthDefaultParams(this.context, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId())), cardsTranscationParam);
        if (!TextUtils.isEmpty(this.bankCode)) {
            paymentInstrument.setBankCode(this.bankCode);
        }
        if (!TextUtils.isEmpty(str) && str5.equalsIgnoreCase("otp")) {
            if (!this.isCreditCardLayout) {
                str10 = Constants.EASYPAY_PAYTYPE_DEBIT_CARD;
            }
            paymentInstrument.setPayType(str10);
        }
        if (!TextUtils.isEmpty(str3)) {
            paymentInstrument.setCardType(str6);
        }
        boolean z2 = this.isCreditCardLayout;
        String str11 = SDKConstants.GA_SAVED_CC;
        paymentInstrument.setGaVisaPaymentMode(z2 ? str11 : SDKConstants.GA_SAVED_DC);
        paymentInstrument.setGaPaymentMethod(this.isCreditCardLayout ? "Credit Card" : "Debit Card");
        paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_SAVED_CARDS);
        TransactionProcessor transactionProcessor = new TransactionProcessor(this.context, BaseViewModel.PaymentType.CARD, paymentInstrument);
        transactionProcessor.setAssistParams(paytmAssistParams);
        if (this.savedCardViewModel.getPaymentOffer() != null && SDKUtility.isOfferValid(this.savedCardViewModel.getPaymentOffer())) {
            transactionProcessor.setOfferBody(new com.google.gson.f().b(this.savedCardViewModel.getPaymentOffer()));
        }
        if (this.isEmiView) {
            transactionProcessor.setEmiPlanData(this.emiPlanData);
            transactionProcessor.setPaymentIntent(this.savedCardViewModel.getEmiPaymentIntent());
        } else if (this.emiChannelInfo != null) {
            transactionProcessor.setEmiPlanData(this.emiPlanData);
            transactionProcessor.setPaymentIntent(this.savedCardViewModel.getEmiPaymentIntent());
        } else {
            transactionProcessor.setPaymentIntent(this.savedCardViewModel.getPaymentIntent());
        }
        if (DirectPaymentBL.getInstance().isRiskConvenienceFeeApplied(getPayMode()) || (this.savedCardViewModel.getPayableConvenienceFee() > 0.0d && DirectPaymentBL.getInstance().isAddMoney())) {
            String riskConvenienceFeeAmount = DirectPaymentBL.getInstance().getRiskConvenienceFeeAmount(getPayMode());
            transactionProcessor.setRiskExtendInfo(SDKConstants.RISK_CONV_FEE_API_PARAM);
            transactionProcessor.setRiskConvenienveFee(riskConvenienceFeeAmount);
        }
        boolean z3 = this.savedCardViewModel.showVisaOneClick.get() == 0 && this.saveCardLayoutBinding.tvOneClickEnabled.getVisibility() == 0;
        if (!DirectPaymentBL.getInstance().isVisaOneClickEnabled() || !this.savedCard.isOneClickSupported() || ((this.savedCardViewModel.showVisaOneClick.get() != 0 || !this.savedCardViewModel.isSingleVisaClickChecked.get()) && !z3)) {
            transactionProcessor.startTransaction(view);
        } else {
            transactionProcessor.setVisaSingleClickEnabled(true);
            transactionProcessor.isEnrolled(z3);
            transactionProcessor.setSavedCardTransaction(true);
            transactionProcessor.setCardDetails(new CardData(this.savedCard.getCardDetails().getFirstSixDigit(), this.savedCard.getCardDetails().getLastFourDigit(), this.savedCard.getCardDetails().getExpiryDate()));
            if (!z3) {
                if (!this.isCreditCardLayout) {
                    str11 = SDKConstants.GA_SAVED_DC;
                }
                SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_PAY_CLICKED, SDKConstants.GA_ENROLLMENT, str11));
            } else {
                if (!this.isCreditCardLayout) {
                    str11 = SDKConstants.GA_SAVED_DC;
                }
                SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_PAY_CLICKED, SDKConstants.GA_REPEAT, str11));
            }
            this.helper.proceedForTranscation(getContext(), transactionProcessor, paymentInstrument, !z3 ? view : null, this.savedCard.getChannelCode());
        }
        if (this.saveCardLayoutBinding.llUpiCheckbox.getVisibility() == 0) {
            this.savedCardViewModel.makeUpiConsentApiRequest(this.savedCard.getIssuingBank(), this.saveCardLayoutBinding.cbUpiCheckbox.isChecked());
        }
    }

    private String getPayMode() {
        if (this.isCreditCardLayout) {
            return PayMethodType.CREDIT_CARD.name();
        }
        return PayMethodType.DEBIT_CARD.name();
    }

    public void checkBoxChanged(CompoundButton compoundButton, boolean z) {
        this.saveNewCard = z;
    }

    public void scrollTo(final View view) {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                ObjectAnimator.ofInt(SavedCardView.this.instruments.getScrollView(), "scrollY", new int[]{((int) view.getY()) - 50}).setDuration(500).start();
            }
        }, 200);
    }

    public void deselectView() {
        setSelected(false);
        closeView();
    }

    /* access modifiers changed from: private */
    public void unregisterBroadCast(Context context) {
        try {
            androidx.localbroadcastmanager.a.a.a(context).a(this.broadcastReceiver);
        } catch (IllegalArgumentException unused) {
        }
    }

    public void enableProceedButton() {
        this.saveCardLayoutBinding.btnProceed.setEnabled(true);
        this.saveCardLayoutBinding.btnProceed.setClickable(true);
    }

    public void disableProceedButton() {
        this.saveCardLayoutBinding.btnProceed.setEnabled(false);
        this.saveCardLayoutBinding.btnProceed.setClickable(false);
    }

    public void startCheckingOfferAnimation() {
        SDKUtility.startAnimation(this.saveCardLayoutBinding.ltvGetOffers);
    }

    public void stopCheckingOfferAnimation() {
        SDKUtility.stopAnimation(this.saveCardLayoutBinding.ltvGetOffers);
    }

    public void changeOfferTextBgColor(int i2, int i3, boolean z) {
        this.saveCardLayoutBinding.tvBankOfferBottom.setTextColor(i3);
        this.saveCardLayoutBinding.llOfferViewBottom.setBackgroundColor(i2);
        this.saveCardLayoutBinding.tvBankOffer.setTextColor(i3);
        this.saveCardLayoutBinding.llOfferView.setBackgroundColor(i2);
        SDKUtility.setPaddingBankOffer(this.saveCardLayoutBinding.tvBankOffer, z, this.context, 0, 0, 0, 10);
    }

    public Object getVerifyResponseModel() {
        return this.savedCardViewModel.getVerifyResponseModel();
    }

    public void setEmiConvenienceFeeResponse(Object obj, ArrayList<PaymentIntent> arrayList, String str) {
        this.savedCardViewModel.setEmiPaymentIntent(arrayList);
        this.savedCardViewModel.configureConvFeeView();
    }

    public void onAddMoneyProceedClicked() {
        proceedClicked(false);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        PaytmSDKRequestClient.ApiResponseError apiResponseError;
        super.onActivityResult(i2, i3, intent);
        if (i3 == 0 && intent != null && (apiResponseError = (PaytmSDKRequestClient.ApiResponseError) intent.getSerializableExtra(EMIConstants.AUTH_ERROR)) != null) {
            SDKUtility.handleVerticalError(apiResponseError, this.context);
        } else if ((i2 == 2049 || (this.isEmiView && i2 == 2050)) && i3 == -1 && intent != null && this.savedCard.getCardDetails().getCardId().equalsIgnoreCase(intent.getStringExtra(EMIConstants.FROM_VIEW))) {
            EmiChannelInfo emiChannelInfo2 = new EmiChannelInfo();
            String stringExtra = intent.getStringExtra(EMIConstants.VALIDATED_DATA);
            EmiValidatePlan emiValidatePlan = (EmiValidatePlan) intent.getSerializableExtra(EMIConstants.VALIDATED_RESPONSE);
            StringBuilder sb = new StringBuilder();
            sb.append(emiValidatePlan.getEmi());
            emiChannelInfo2.setEmiPerMonth(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(emiValidatePlan.getRate());
            emiChannelInfo2.setInterestRate(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(emiValidatePlan.getInterval());
            emiChannelInfo2.setOfMonths(sb3.toString());
            emiChannelInfo2.setPlanId(emiValidatePlan.getPgPlanId());
            this.currentEmiPlanId = emiValidatePlan.getPlanId();
            this.emiChannelInfo = emiChannelInfo2;
            this.emiPlanData = stringExtra;
            changeEMIUi(this.emiChannelInfo, this.prevEmiSelectedPosition, intent.getStringExtra(EMIConstants.EFFECTIVE_PRICE));
            this.savedCardViewModel.setSubventedOfferText(intent.getStringExtra(EMIConstants.OFFER_MSG));
            this.savedCardViewModel.setEmiEnabled(true);
            hideUpiConsentCheckbox();
            this.savedCardViewModel.handleEmiOfferText();
            this.savedCardViewModel.updateSubventedOfferView();
            setEmiPrice(intent);
        }
    }

    private void setEmiPrice(Intent intent) {
        if (intent != null) {
            this.savedCardViewModel.setPaySecurelyText(intent.getStringExtra(EMIConstants.FINAL_PRICE));
            this.savedCardViewModel.setAmountIfNeeded();
        }
    }

    /* access modifiers changed from: private */
    public void onUpiPayClick() {
        if (SDKUtility.isPaytmApp(this.context) && SDKUtility.isUpiPushEnabled() && this.vpaDetail != null) {
            if (!DirectPaymentBL.getInstance().isBankOffersAvailable() && !ConvenienceFeeController.getInstance().isConvenienceFeeEnabled()) {
                SDKUtility.startUpiPush(this.context, this.vpaDetail, SDKConstants.PUSH_FROM_PUSH, String.valueOf(SDKUtility.getDiffAmount()));
            } else if (this.context instanceof UpiEncouragementListener) {
                ((UpiEncouragementListener) this.context).autoSelectUpiPushView(this.vpaDetail.getPgBankCode());
            }
        }
    }

    public void makeUpiPushPayment(String str, String str2, String str3) {
        PaymentInstrument paymentInstrument;
        if ((DirectPaymentBL.getInstance().getPaytmBaseView() instanceof SavedCardView) && this.savedCardViewModel.isSelected()) {
            if (DirectPaymentBL.getInstance().isNativeJsonRequestSupported()) {
                paymentInstrument = new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), (String) null, PayUtility.getUpiPushRequestParam(str, str2, str3, this.vpaDetail));
            } else {
                paymentInstrument = new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), SDKUtility.addAuthDefaultParams(this.context, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId())), PayUtility.getUpiPushRequestParamWebRedirection(str, str2, str3, this.vpaDetail));
            }
            paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_UPI);
            paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_SAVED_CARDS);
            if (DirectPaymentBL.getInstance().isNativeJsonRequestSupported()) {
                paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
            } else {
                paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
            }
            new TransactionProcessor(this.context, "upi_push", paymentInstrument).startTransaction(this.saveCardLayoutBinding.btnProceed);
        }
    }

    public void hidePaymentsLoader() {
        SavedCardViewModel savedCardViewModel2;
        SaveCardLayout2Binding saveCardLayout2Binding = this.saveCardLayoutBinding;
        if (saveCardLayout2Binding != null && (savedCardViewModel2 = this.savedCardViewModel) != null) {
            savedCardViewModel2.hidePaymentProgressbar(saveCardLayout2Binding.btnProceed);
        }
    }

    public boolean isTenureSelected() {
        return this.emiChannelInfo != null;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.context != null) {
            this.context.unregisterReceiver(this.networkConnectivityReceiver);
            unregisterBroadCast(this.context);
        }
    }
}
