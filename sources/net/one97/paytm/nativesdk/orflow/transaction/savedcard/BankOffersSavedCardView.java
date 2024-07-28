package net.one97.paytm.nativesdk.orflow.transaction.savedcard;

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
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.f;
import com.alipay.mobile.h5container.api.H5Param;
import com.android.volley.VolleyError;
import com.bumptech.glide.b;
import com.bumptech.glide.e.a;
import com.bumptech.glide.e.h;
import com.bumptech.glide.load.b.j;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import easypay.manager.Constants;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ConvenienceFeeController;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.CardData;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
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
import net.one97.paytm.nativesdk.common.model.CardDetails;
import net.one97.paytm.nativesdk.common.model.CardPaymentIntentData;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.common.model.SavedInstruments;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.databinding.SavedCardBankOfferBinding;
import net.one97.paytm.nativesdk.emiSubvention.EMIConstants;
import net.one97.paytm.nativesdk.emiSubvention.ISubventionProvider;
import net.one97.paytm.nativesdk.emiSubvention.models.BankData;
import net.one97.paytm.nativesdk.emiSubvention.models.EmiValidatePlan;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.EmiChannelInfo;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.PromoCodeResponse;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.utility.DebitCreditCardUtility;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.view.VisaInfoBottomSheet;
import net.one97.paytm.nativesdk.instruments.savedCard.listeners.SavedCardClickListener;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;
import net.one97.paytm.nativesdk.orflow.transaction.BankOfferCardView;
import net.one97.paytm.nativesdk.orflow.transaction.TransactionDialogListener;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.paymethods.model.PaytmAssistParams;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public class BankOffersSavedCardView extends PaytmBaseView implements SavedCardClickListener, BankOfferCardView {
    private static final String otp = "otp";
    private String bankCode = "";
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (SDKConstants.UNREGISTER_BROADCAST_PBP.equalsIgnoreCase(intent.getAction())) {
                BankOffersSavedCardView.this.unregisterBroadCast(context);
            } else if (SDKConstants.HYBRID_WALLET_CHECKED_UNCHECKED.equalsIgnoreCase(intent.getAction())) {
                BankOffersSavedCardView.this.hybridCheckChanged();
            }
        }
    };
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public String currentEmiPlanId;
    private char dash = '-';
    /* access modifiers changed from: private */
    public EmiChannelInfo emiChannelInfo;
    /* access modifiers changed from: private */
    public ArrayList<PaymentIntent> emiPaymentIntent;
    /* access modifiers changed from: private */
    public String emiPlanData;
    private String fourDots = " •••• ";
    /* access modifiers changed from: private */
    public VisaEnrollmentHelper helper;
    /* access modifiers changed from: private */
    public boolean isCreditCardLayout;
    private boolean isVisaOptionDisplayed;
    /* access modifiers changed from: private */
    public SavedCardBankOfferBinding lastRadioChecked;
    private EnrollmentListener listener;
    private String mode;
    private ArrayList<PaymentIntent> paymentIntent;
    private int prevEmiSelectedPosition;
    /* access modifiers changed from: private */
    public SavedCardBankOfferBinding saveCardLayoutBinding;
    private boolean saveNewCard = true;
    /* access modifiers changed from: private */
    public SavedInstruments savedCard;
    /* access modifiers changed from: private */
    public BankOfferSavedCardViewModel savedCardViewModel;
    private char slash = '/';
    private TransactionDialogListener transactionDialogListener;

    public void bankEmiOfferError() {
    }

    public void bankEmiOfferReceived() {
    }

    public void changeArrowIcon(boolean z) {
    }

    public void changeOfferTextBgColor(int i2, int i3, boolean z) {
    }

    public void changeRemainingAmt(String str) {
    }

    public void closeKeyboard() {
    }

    public void deselectView() {
    }

    public void disableProceedButton() {
    }

    public void enableProceedButton() {
    }

    public void scrollTo(View view) {
    }

    public void showAnimation(boolean z) {
    }

    public void startCheckingOfferAnimation() {
    }

    public void stopCheckingOfferAnimation() {
    }

    public BankOffersSavedCardView(Context context2, SavedInstruments savedInstruments, Instruments instruments) {
        super(instruments);
        this.context = context2;
        this.savedCard = savedInstruments;
        this.paymentIntent = PromoHelper.Companion.getInstance().getPaymentIntent();
    }

    public void refreshLayout() {
        if (!DirectPaymentBL.getInstance().isWalletEnabledOnMerchant() || DirectPaymentBL.getInstance().isWalletAmountSufficientToPay() || !DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
            this.saveCardLayoutBinding.txtamount.setVisibility(8);
        } else {
            this.saveCardLayoutBinding.txtamount.setVisibility(0);
            this.saveCardLayoutBinding.txtamount.setText(this.context.getResources().getString(R.string.nativesdk_amount, new Object[]{SDKUtility.priceWithoutDecimal(DirectPaymentBL.getInstance().getDifferentialAmount())}));
        }
        this.savedCardViewModel.paySecurelyText.set(SDKUtility.getPaySecurelyText(this.context));
        updateVisaSingleClickUI();
    }

    /* access modifiers changed from: private */
    public void hybridCheckChanged() {
        BankOfferSavedCardViewModel bankOfferSavedCardViewModel = this.savedCardViewModel;
        if (bankOfferSavedCardViewModel != null) {
            bankOfferSavedCardViewModel.hybridCheckChanged();
        }
    }

    public PaytmBaseView getSavedCardView() {
        this.saveCardLayoutBinding = (SavedCardBankOfferBinding) f.a((LayoutInflater) this.context.getSystemService("layout_inflater"), R.layout.saved_card_bank_offer, (ViewGroup) null, false);
        this.isCreditCardLayout = this.savedCard.getCardDetails().getCardType().contains(SDKConstants.CREDIT);
        String substring = this.savedCard.getCardDetails().getFirstSixDigit().substring(0, 4);
        String lastFourDigit = this.savedCard.getCardDetails().getLastFourDigit();
        this.helper = new VisaEnrollmentHelper();
        Context context2 = this.context;
        String str = substring + "   XXXX   " + lastFourDigit;
        StringBuilder sb = new StringBuilder();
        sb.append(this.savedCard.getIssuingBank());
        sb.append(" ");
        sb.append(this.isCreditCardLayout ? "Credit Card" : "Debit Card");
        this.savedCardViewModel = new BankOfferSavedCardViewModel(context2, str, sb.toString(), this.savedCard.getIconUrl(), this.savedCard, this);
        this.saveCardLayoutBinding.setSaveCardModel(this.savedCardViewModel);
        this.view = this.saveCardLayoutBinding.getRoot();
        this.saveCardLayoutBinding.imgEmiCross.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BankOffersSavedCardView.this.saveCardLayoutBinding.emiDetailsLayout.setVisibility(8);
                BankOffersSavedCardView.this.saveCardLayoutBinding.tvEmiAvailbale.setVisibility(0);
                BankOffersSavedCardView.this.saveCardLayoutBinding.tvChangePlan.setVisibility(8);
                BankOffersSavedCardView.this.saveCardLayoutBinding.tvTotalAmount.setVisibility(8);
                BankOffersSavedCardView.this.hideSubventedOfferView();
                EmiChannelInfo unused = BankOffersSavedCardView.this.emiChannelInfo = null;
                String unused2 = BankOffersSavedCardView.this.emiPlanData = null;
                BankOffersSavedCardView.this.savedCardViewModel.setEmiEnabled(false);
            }
        });
        this.saveCardLayoutBinding.tvEmiAvailbale.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BankOffersSavedCardView.this.savedCardViewModel.setEmiEnabled(true);
                BankOffersSavedCardView.this.selectSavedCard();
                BankOffersSavedCardView.this.sendEmiGAEvent();
            }
        });
        this.saveCardLayoutBinding.tvChangePlan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BankOffersSavedCardView.this.selectSavedCard();
            }
        });
        this.saveCardLayoutBinding.iconVscpInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BankOffersSavedCardView.this.inflateInfoBottomSheet(true);
            }
        });
        this.saveCardLayoutBinding.tvOneClickDetail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BankOffersSavedCardView.this.inflateInfoBottomSheet(false);
            }
        });
        this.saveCardLayoutBinding.tvOneClickMsg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (BankOffersSavedCardView.this.saveCardLayoutBinding.cbOneClick.isChecked()) {
                    BankOffersSavedCardView.this.savedCardViewModel.isSingleVisaClickChecked.set(false);
                } else {
                    BankOffersSavedCardView.this.savedCardViewModel.isSingleVisaClickChecked.set(true);
                }
            }
        });
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
        SDKUtility.getDiffAmount();
        this.saveCardLayoutBinding.getRoot().setTag(this.savedCard);
        if (!this.savedCard.isEmiAvailable() || !DirectPaymentBL.getInstance().isMultiItemEmiFlow()) {
            this.saveCardLayoutBinding.tvEmiAvailbale.setVisibility(8);
        } else {
            this.saveCardLayoutBinding.tvEmiAvailbale.setVisibility(0);
            this.saveCardLayoutBinding.tvEmiAvailbale.setText(SDKUtility.getEmiAvailableText(this.context, this.savedCard.getSubventionType()));
        }
        b.b(this.context).a(Integer.valueOf(SDKUtility.getCardImage(this.savedCard.getChannelCode()))).b((a<?>) new h().a(j.f6875a)).a(this.saveCardLayoutBinding.ivSavedCard);
        savedCardSelected();
        this.view = this.saveCardLayoutBinding.getRoot();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SDKConstants.UNREGISTER_BROADCAST);
        intentFilter.addAction(SDKConstants.HYBRID_WALLET_CHECKED_UNCHECKED);
        androidx.localbroadcastmanager.a.a.a(this.context.getApplicationContext()).a(this.broadcastReceiver, intentFilter);
        return this;
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
                    put("event_label2", "bank offer express checkout");
                    put("vertical_name", "emi");
                }
            });
        }
    }

    public void onProceedClick(View view) {
        if (!TextUtils.isEmpty(this.mode)) {
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
            goForTransaction(this.mode, str2, this.savedCard.getChannelCode(), view);
        }
    }

    /* access modifiers changed from: private */
    public void selectSavedCard() {
        if (DirectPaymentBL.getInstance().isMultiItemEmiFlow()) {
            openMultiItemPlanSelectionScreen();
        }
        savedCardSelected();
    }

    private void openMultiItemPlanSelectionScreen() {
        if (this.saveCardLayoutBinding.pbSelectPlan.getVisibility() != 0) {
            this.saveCardLayoutBinding.pbSelectPlan.setVisibility(0);
            BankData bankData = new BankData();
            bankData.setType(this.savedCard.getSubventionType());
            bankData.setBankName(this.savedCard.getIssuingBank());
            bankData.setBankCode(this.savedCard.getIssuingBank());
            bankData.setCardType(this.savedCard.getCardDetails().getCardType());
            this.emiPaymentIntent = buildEmiPaymentIntent();
            EmiUtil.fetchTenuresWithOffers(bankData, new ISubventionProvider.IBankTenureListener() {
                public void onBankSuccessResponse(String str) {
                    String str2 = str;
                    EmiUtil.startEmiPlanActivity(BankOffersSavedCardView.this.context, str2, SDKUtility.priceWithoutDecimal(SDKUtility.getDiffAmount()), "OR_FLOW_SAVED_CARD", EmiUtil.EMI_PLAN_REQUEST_CODE, BankOffersSavedCardView.this.emiPaymentIntent, (String) null, BankOffersSavedCardView.this.currentEmiPlanId, true);
                    BankOffersSavedCardView.this.saveCardLayoutBinding.pbSelectPlan.setVisibility(8);
                }

                public void onBankError(String str, String str2) {
                    BankOffersSavedCardView.this.saveCardLayoutBinding.pbSelectPlan.setVisibility(8);
                    Context access$1000 = BankOffersSavedCardView.this.context;
                    Toast.makeText(access$1000, str + ": " + str2, 1).show();
                }

                public void onBankNetworkError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
                    if (EmiUtil.isAuthError(apiResponseError)) {
                        SDKUtility.handleVerticalError(apiResponseError, BankOffersSavedCardView.this.context);
                        return;
                    }
                    BankOffersSavedCardView.this.saveCardLayoutBinding.pbSelectPlan.setVisibility(8);
                    Context access$1000 = BankOffersSavedCardView.this.context;
                    Toast.makeText(access$1000, apiResponseError.getErrorTitle() + ": " + apiResponseError.getErrorMsg(), 1).show();
                }
            }, this.emiPaymentIntent, (String) null);
        }
    }

    private void savedCardSelected() {
        if (DirectPaymentBL.getInstance().lastInsufficuentAmountError != null) {
            DirectPaymentBL.getInstance().lastInsufficuentAmountError.set("");
        }
        this.savedCardViewModel.paySecurelyText.set(SDKUtility.getPaySecurelyText(this.context));
        DirectPaymentBL.getInstance().closeOpnedView();
        DirectPaymentBL.getInstance().setPaytmBaseView(this);
        this.savedCardViewModel.setSelected(true);
        this.savedCardViewModel.getBankOffers();
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
            this.saveCardLayoutBinding.rbCardNumber.setChecked(true);
            this.saveCardLayoutBinding.rbCardNumber.setTypeface((Typeface) null, 1);
            this.saveCardLayoutBinding.rbCardNumber.setTag(this.savedCard);
            if (DirectPaymentBL.getInstance().isWalletEnabledOnMerchant() && !DirectPaymentBL.getInstance().isWalletAmountSufficientToPay() && DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
                this.saveCardLayoutBinding.txtamount.setVisibility(0);
                this.saveCardLayoutBinding.txtamount.setText(this.context.getResources().getString(R.string.nativesdk_amount, new Object[]{SDKUtility.priceWithoutDecimal(SDKUtility.formatNumber(MerchantBL.getMerchantInstance().getWithoutDoubleAmount(Double.valueOf(DirectPaymentBL.getInstance().getDifferentialAmount()).doubleValue())))}));
            }
            this.saveCardLayoutBinding.twoModeAuthLayout.setVisibility(8);
            this.saveCardLayoutBinding.rbSavedCardOtp.setChecked(true);
            this.saveCardLayoutBinding.rbSavedCardOtp.setTypeface((Typeface) null, 1);
            this.saveCardLayoutBinding.cvvLayout.setVisibility(0);
            setLeftRightMargin(28, this.saveCardLayoutBinding.cvvLayout);
            this.mode = "otp";
            this.mode = "otp";
            if (this.savedCard.getChannelCode().equalsIgnoreCase(SDKConstants.MAESTRO)) {
                this.saveCardLayoutBinding.cvvLayout.setVisibility(8);
            }
            this.saveCardLayoutBinding.txtAtmPinText.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    BankOffersSavedCardView.this.saveCardLayoutBinding.rbSavedCardAtmPin.performClick();
                }
            });
            this.saveCardLayoutBinding.txtOtpText.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    BankOffersSavedCardView.this.saveCardLayoutBinding.rbSavedCardOtp.performClick();
                }
            });
            this.saveCardLayoutBinding.twoModeAuthLayout.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public void onCheckedChanged(RadioGroup radioGroup, int i2) {
                    radioGroup.findViewById(R.id.rb_saved_card_atm_pin);
                    BankOffersSavedCardView bankOffersSavedCardView = BankOffersSavedCardView.this;
                    bankOffersSavedCardView.makeCvvErrorMessageNormal(bankOffersSavedCardView.saveCardLayoutBinding);
                    if (((RadioButton) radioGroup.findViewById(R.id.rb_saved_card_otp)).isChecked()) {
                        BankOffersSavedCardView.this.saveCardLayoutBinding.cvvLayout.setVisibility(0);
                        return;
                    }
                    BankOffersSavedCardView.this.saveCardLayoutBinding.cvvLayout.setVisibility(8);
                    SDKUtility.hideKeyboard(BankOffersSavedCardView.this.saveCardLayoutBinding.etCvv, BankOffersSavedCardView.this.context);
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
                    BankOffersSavedCardView bankOffersSavedCardView = BankOffersSavedCardView.this;
                    bankOffersSavedCardView.makeCvvErrorMessageNormal(bankOffersSavedCardView.saveCardLayoutBinding);
                    if (BankOffersSavedCardView.this.savedCard.getChannelCode().equalsIgnoreCase(SDKConstants.AMEX)) {
                        if (editable.toString().trim().length() == 4) {
                            SDKUtility.hideKeyboard(BankOffersSavedCardView.this.saveCardLayoutBinding.etCvv, BankOffersSavedCardView.this.context);
                        }
                    } else if (editable.toString().trim().length() == 3) {
                        SDKUtility.hideKeyboard(BankOffersSavedCardView.this.saveCardLayoutBinding.etCvv, BankOffersSavedCardView.this.context);
                    }
                }
            });
            SavedInstruments savedInstruments2 = this.savedCard;
            if (savedInstruments2 == null || savedInstruments2.getHasLowSuccess() == null || !this.savedCard.getHasLowSuccess().getStatus()) {
                this.savedCardViewModel.lowSuccess.set(8);
            } else {
                this.savedCardViewModel.lowSuccess.set(0);
                this.saveCardLayoutBinding.textViewLowSuccess.setText(this.savedCard.getHasLowSuccess().getMsg());
            }
            if (this.saveCardLayoutBinding.cvvLayout.getVisibility() != 0) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        SDKUtility.hideKeyboard(BankOffersSavedCardView.this.saveCardLayoutBinding.etCvv, BankOffersSavedCardView.this.context);
                    }
                }, 200);
            }
            this.bankCode = this.savedCard.getIssuingBank();
            scrollTo(this.saveCardLayoutBinding.getRoot());
            SDKUtility.expand(this.saveCardLayoutBinding.getRoot(), (Integer) null);
            hitPromoCodeApiForSavedCard(this.saveCardLayoutBinding, this.savedCard.getCardDetails().getCardId(), this.savedCard.getCardDetails().getCardType().equalsIgnoreCase(SDKConstants.CREDIT));
            if (isVisaSingleClickEnabled()) {
                checkVisaConsentFlow();
            }
            updateVisaSingleClickUI();
            return;
        }
        DialogUtility.showErrorInstrumentDialog(this.context.getResources().getString(R.string.your_card_is_blocked), this.savedCard.getIsDisabled().getMsg(), this.context);
        this.saveCardLayoutBinding.rbCardNumber.setChecked(false);
    }

    private void hitPromoCodeApiForSavedCard(final SavedCardBankOfferBinding savedCardBankOfferBinding, String str, boolean z) {
        if (DirectPaymentBL.getInstance().isPromoCodeExist()) {
            final String promoCodeApiUrl = NativeSdkGtmLoader.getPromoCodeApiUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId());
            NativeSDKRepository.getInstance().fetchPromoCodeDetail(str.replace(String.valueOf(this.dash), ""), z ? SDKConstants.CREDIT : SDKConstants.DEBIT, new PaymentMethodDataSource.Callback<PromoCodeResponse>() {
                public void onResponse(PromoCodeResponse promoCodeResponse) {
                    if (savedCardBankOfferBinding != null && BankOffersSavedCardView.this.lastRadioChecked != null) {
                        if (promoCodeResponse == null || promoCodeResponse.getBody() == null || promoCodeResponse.getBody().getPromoCodeDetail() == null || TextUtils.isEmpty(promoCodeResponse.getBody().getPromoCodeDetail().getPromoMsg())) {
                            savedCardBankOfferBinding.tvPromoMessage.setVisibility(8);
                        } else if (promoCodeResponse.getBody().getResultInfo().getResultStatus().equalsIgnoreCase("FAILURE")) {
                            savedCardBankOfferBinding.tvPromoMessage.setText(promoCodeResponse.getBody().getPromoCodeDetail().getPromoErrorMsg());
                            savedCardBankOfferBinding.tvPromoMessage.setVisibility(0);
                            savedCardBankOfferBinding.tvPromoMessage.setBackgroundColor(Color.parseColor("#fdfbd3"));
                            savedCardBankOfferBinding.tvPromoMessage.setTextColor(Color.parseColor("#666666"));
                        } else {
                            savedCardBankOfferBinding.tvPromoMessage.setText(promoCodeResponse.getBody().getPromoCodeDetail().getPromoMsg());
                            savedCardBankOfferBinding.tvPromoMessage.setVisibility(0);
                            savedCardBankOfferBinding.tvPromoMessage.setBackgroundColor(Color.parseColor("#bef8ce"));
                            savedCardBankOfferBinding.tvPromoMessage.setTextColor(Color.parseColor("#222222"));
                        }
                    }
                }

                public void onErrorResponse(VolleyError volleyError, PromoCodeResponse promoCodeResponse) {
                    BankOffersSavedCardView.this.showServerFailureAlert(volleyError);
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.API_TIME_OUT, BankOffersSavedCardView.this.isCreditCardLayout ? "Credit Card" : "Debit Card", promoCodeApiUrl));
                }
            });
        }
    }

    public void openAutoInstrument() {
        isOnceClicked = true;
        savedCardSelected();
    }

    public void closeView() {
        closeKeyboard();
        this.saveCardLayoutBinding.rbCardNumber.setChecked(false);
        this.saveCardLayoutBinding.rbCardNumber.setTypeface((Typeface) null, 0);
        this.saveCardLayoutBinding.twoModeAuthLayout.clearCheck();
        this.saveCardLayoutBinding.twoModeAuthLayout.setVisibility(8);
        this.saveCardLayoutBinding.etCvv.setText("");
        this.saveCardLayoutBinding.cvvLayout.setVisibility(8);
        this.saveCardLayoutBinding.textViewLowSuccess.setVisibility(8);
        this.saveCardLayoutBinding.txtamount.setVisibility(8);
        this.saveCardLayoutBinding.tvPromoMessage.setVisibility(8);
        this.prevEmiSelectedPosition = -1;
        this.emiChannelInfo = null;
        this.emiPlanData = null;
        if (this.saveCardLayoutBinding.emiDetailsLayout.getVisibility() == 0) {
            this.saveCardLayoutBinding.emiDetailsLayout.setVisibility(8);
            this.saveCardLayoutBinding.tvEmiAvailbale.setVisibility(0);
            hideSubventedOfferView();
        }
        this.savedCardViewModel.hideOffer();
        this.savedCardViewModel.setSelected(false);
        updateVisaSingleClickUI();
    }

    /* access modifiers changed from: private */
    public void showServerFailureAlert(VolleyError volleyError) {
        String str;
        try {
            str = DebitCreditCardUtility.getFailureReponse(new String(volleyError.networkResponse.data, AppConstants.UTF_8), this.context);
        } catch (Exception unused) {
            str = this.context.getResources().getString(R.string.server_communication_failed);
        }
        Context context2 = this.context;
        DialogUtility.showDialog(context2, context2.getResources().getString(R.string.unknown_error), str, (DialogInterface.OnClickListener) null);
    }

    private void changeEMIUi(SavedCardBankOfferBinding savedCardBankOfferBinding, EmiChannelInfo emiChannelInfo2, int i2, String str) {
        this.prevEmiSelectedPosition = i2;
        DecimalFormat decimalFormat = new DecimalFormat(".##");
        this.emiChannelInfo = emiChannelInfo2;
        if (!TextUtils.isEmpty(str)) {
            savedCardBankOfferBinding.tvTotalAmount.setVisibility(0);
            RoboTextView roboTextView = savedCardBankOfferBinding.tvTotalAmount;
            roboTextView.setText("Total " + this.context.getString(R.string.nativesdk_amount, new Object[]{str}));
        } else {
            savedCardBankOfferBinding.tvTotalAmount.setVisibility(8);
        }
        savedCardBankOfferBinding.tvChangePlan.setVisibility(0);
        savedCardBankOfferBinding.emiDetailsLayout.setVisibility(0);
        savedCardBankOfferBinding.tvEmiAvailbale.setVisibility(8);
        savedCardBankOfferBinding.txtEmiDetails.setText(this.context.getResources().getString(R.string.emi_details, new Object[]{decimalFormat.format(Double.valueOf(this.emiChannelInfo.getEmiPerMonth())), this.emiChannelInfo.getOfMonths(), decimalFormat.format(Double.valueOf(this.emiChannelInfo.getInterestRate()))}));
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
    public void makeCvvErrorMessageNormal(SavedCardBankOfferBinding savedCardBankOfferBinding) {
        savedCardBankOfferBinding.txtErrMsg.setVisibility(8);
        savedCardBankOfferBinding.txtErrMsg.setText("");
        savedCardBankOfferBinding.cvvLayout.setBackgroundResource(R.drawable.white_background_with_border);
    }

    private void changeCvvUi(SavedCardBankOfferBinding savedCardBankOfferBinding, boolean z) {
        if (z) {
            savedCardBankOfferBinding.cvvLayout.setBackgroundResource(R.drawable.edit_text_error_bg);
            savedCardBankOfferBinding.txtErrMsg.setVisibility(0);
            savedCardBankOfferBinding.txtErrMsg.setText(this.context.getResources().getString(R.string.native_enter_valid_cvv));
            if (savedCardBankOfferBinding.twoModeAuthLayout.getVisibility() == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) savedCardBankOfferBinding.txtErrMsg.getLayoutParams();
                layoutParams.setMargins(convertDpToPixel(70), convertDpToPixel(10), convertDpToPixel(H5Param.WEBVIEW_FONT_SIZE_LARGER), convertDpToPixel(0));
                savedCardBankOfferBinding.txtErrMsg.setLayoutParams(layoutParams);
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) savedCardBankOfferBinding.txtErrMsg.getLayoutParams();
            layoutParams2.setMargins(convertDpToPixel(30), convertDpToPixel(10), convertDpToPixel(H5Param.WEBVIEW_FONT_SIZE_LARGER), convertDpToPixel(0));
            savedCardBankOfferBinding.txtErrMsg.setLayoutParams(layoutParams2);
            return;
        }
        savedCardBankOfferBinding.txtErrMsg.setVisibility(8);
        savedCardBankOfferBinding.txtErrMsg.setText("");
        savedCardBankOfferBinding.cvvLayout.setBackgroundResource(R.drawable.white_background_with_border);
    }

    private void goForTransaction(String str, String str2, String str3, View view) {
        String str4;
        String str5 = str;
        String str6 = str3;
        View view2 = view;
        boolean z = this.isCreditCardLayout;
        String str7 = SDKConstants.CREDIT;
        String str8 = z ? str7 : SDKConstants.DEBIT;
        if (this.emiChannelInfo == null || !this.savedCardViewModel.isEmiEnabled()) {
            str4 = null;
        } else {
            str4 = this.emiChannelInfo.getPlanId();
            str8 = "EMI";
        }
        HashMap<String, String> cardsTranscationParam = PayUtility.getCardsTranscationParam(str5, str8, str2, this.saveNewCard ? "1" : "0", str4);
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
        String str9 = Constants.EASYPAY_PAYTYPE_CREDIT_CARD;
        if (!isEmpty && str5.equalsIgnoreCase("otp")) {
            paytmAssistParams.setPayType(this.isCreditCardLayout ? str9 : Constants.EASYPAY_PAYTYPE_DEBIT_CARD);
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
                str9 = Constants.EASYPAY_PAYTYPE_DEBIT_CARD;
            }
            paymentInstrument.setPayType(str9);
        }
        if (!TextUtils.isEmpty(str3)) {
            paymentInstrument.setCardType(str6);
        }
        paymentInstrument.setGaPaymentMethod(this.isCreditCardLayout ? "Credit Card" : "Debit Card");
        paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_SAVED_CARDS);
        TransactionProcessor transactionProcessor = new TransactionProcessor(this.context, BaseViewModel.PaymentType.CARD, paymentInstrument);
        transactionProcessor.setAssistParams(paytmAssistParams);
        if (this.emiChannelInfo == null || !this.savedCardViewModel.isEmiEnabled()) {
            transactionProcessor.setPaymentIntent(this.paymentIntent);
        } else {
            if (this.emiPaymentIntent == null) {
                this.emiPaymentIntent = buildEmiPaymentIntent();
            }
            transactionProcessor.setPaymentIntent(this.emiPaymentIntent);
        }
        if (DirectPaymentBL.getInstance().isRiskConvenienceFeeApplied(getPayMode())) {
            String riskConvenienceFeeAmount = DirectPaymentBL.getInstance().getRiskConvenienceFeeAmount(getPayMode());
            transactionProcessor.setRiskExtendInfo(SDKConstants.RISK_CONV_FEE_API_PARAM);
            transactionProcessor.setRiskConvenienveFee(riskConvenienceFeeAmount);
        }
        transactionProcessor.setEmiPlanData(this.emiPlanData);
        boolean z2 = this.savedCardViewModel.showVisaOneClick.get() == 0 && this.saveCardLayoutBinding.tvOneClickEnabled.getVisibility() == 0;
        if (!DirectPaymentBL.getInstance().isVisaOneClickEnabledForOffers() || !this.savedCard.isOneClickSupported() || ((this.savedCardViewModel.showVisaOneClick.get() != 0 || !this.savedCardViewModel.isSingleVisaClickChecked.get()) && !z2)) {
            transactionProcessor.startTransaction(view2);
        } else {
            transactionProcessor.setVisaSingleClickEnabled(true);
            transactionProcessor.isEnrolled(z2);
            transactionProcessor.setSavedCardTransaction(true);
            transactionProcessor.setCardDetails(new CardData(this.savedCard.getCardDetails().getFirstSixDigit(), this.savedCard.getCardDetails().getLastFourDigit(), this.savedCard.getCardDetails().getExpiryDate()));
            String str10 = SDKConstants.GA_SAVED_CC;
            if (!z2) {
                if (!this.isCreditCardLayout) {
                    str10 = SDKConstants.GA_SAVED_DC;
                }
                SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_PAY_CLICKED, SDKConstants.GA_ENROLLMENT, str10));
            } else {
                if (!this.isCreditCardLayout) {
                    str10 = SDKConstants.GA_SAVED_DC;
                }
                SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_PAY_CLICKED, SDKConstants.GA_REPEAT, str10));
            }
            this.helper.proceedForTranscation(this.view.getContext(), transactionProcessor, paymentInstrument, !z2 ? view2 : null, this.savedCard.getChannelCode());
        }
        view2.setOnClickListener((View.OnClickListener) null);
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

    /* access modifiers changed from: private */
    public void unregisterBroadCast(Context context2) {
        try {
            androidx.localbroadcastmanager.a.a.a(context2).a(this.broadcastReceiver);
        } catch (IllegalArgumentException unused) {
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        PaytmSDKRequestClient.ApiResponseError apiResponseError;
        super.onActivityResult(i2, i3, intent);
        if (i3 == 0 && intent != null && (apiResponseError = (PaytmSDKRequestClient.ApiResponseError) intent.getSerializableExtra(EMIConstants.AUTH_ERROR)) != null) {
            SDKUtility.handleVerticalError(apiResponseError, this.context);
        } else if (i2 == 2048 && i3 == -1 && intent != null && "OR_FLOW_SAVED_CARD".equalsIgnoreCase(intent.getStringExtra(EMIConstants.FROM_VIEW))) {
            try {
                this.transactionDialogListener.updatePaySecurelyText(intent.getStringExtra(EMIConstants.FINAL_PRICE));
            } catch (Exception unused) {
            }
            String stringExtra = intent.getStringExtra(EMIConstants.VALIDATED_DATA);
            EmiChannelInfo emiChannelInfo2 = new EmiChannelInfo();
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
            this.emiChannelInfo = emiChannelInfo2;
            this.emiPlanData = stringExtra;
            this.currentEmiPlanId = emiValidatePlan.getPlanId();
            changeEMIUi(this.saveCardLayoutBinding, this.emiChannelInfo, 0, intent.getStringExtra(EMIConstants.EFFECTIVE_PRICE));
            updateSubventedOfferView(intent.getStringExtra(EMIConstants.OFFER_MSG));
        }
    }

    private ArrayList<PaymentIntent> buildEmiPaymentIntent() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.savedCard.getChannelCode());
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.savedCard.getIssuingBank());
        CardPaymentIntentData cardPaymentIntentData = new CardPaymentIntentData();
        cardPaymentIntentData.setCardHash(this.savedCard.getCardDetails().getCardHash());
        cardPaymentIntentData.setBin6(this.savedCard.getCardDetails().getFirstSixDigit());
        cardPaymentIntentData.setBin8(this.savedCard.getCardDetails().getFirstEightDigit());
        return ConvenienceFeeController.getInstance().buildPaymentIntent(PayMethodType.EMI.name(), arrayList, arrayList2, cardPaymentIntentData, this.isCreditCardLayout ? SDKConstants.CREDIT : SDKConstants.DEBIT, Double.valueOf(0.0d));
    }

    public void setTransactionDialogListener(TransactionDialogListener transactionDialogListener2) {
        this.transactionDialogListener = transactionDialogListener2;
    }

    private void updateSubventedOfferView(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.saveCardLayoutBinding.tvSubventionOffer.setVisibility(0);
            this.saveCardLayoutBinding.tvSubventionOffer.setText(str);
            return;
        }
        hideSubventedOfferView();
    }

    /* access modifiers changed from: private */
    public void hideSubventedOfferView() {
        this.transactionDialogListener.updatePaySecurelyText(MerchantBL.getMerchantInstance().getAmount());
        this.saveCardLayoutBinding.tvSubventionOffer.setVisibility(8);
    }

    public void updateVisaSingleClickUI() {
        BankOfferSavedCardViewModel bankOfferSavedCardViewModel = this.savedCardViewModel;
        if (bankOfferSavedCardViewModel != null) {
            bankOfferSavedCardViewModel.netPayableAmount = Double.valueOf(bankOfferSavedCardViewModel.getAmount());
            final CardData cardData = new CardData(this.savedCard.getCardDetails().getFirstSixDigit(), this.savedCard.getCardDetails().getLastFourDigit(), this.savedCard.getCardDetails().getExpiryDate());
            if (isVisaSingleClickEnabled()) {
                if (this.listener == null) {
                    this.listener = new EnrollmentListener() {
                        public void isEnrolled(EnrollmentData enrollmentData) {
                            if (!enrollmentData.isEligible() || !(BankOffersSavedCardView.this.context instanceof ActivityInteractor) || !((ActivityInteractor) BankOffersSavedCardView.this.context).isUIEnable()) {
                                BankOffersSavedCardView.this.upateSavedCardViewWithCvv();
                            } else if (!BankOffersSavedCardView.this.isSelected()) {
                                if (enrollmentData.isEnrolled()) {
                                    BankOffersSavedCardView.this.savedCardViewModel.showVisaOneClick.set(0);
                                    BankOffersSavedCardView.this.enableVisaSingleClickEnrolledView();
                                } else {
                                    BankOffersSavedCardView.this.savedCardViewModel.showVisaOneClick.set(8);
                                }
                                BankOffersSavedCardView.this.hideCvvLayout();
                            } else {
                                BankOffersSavedCardView.this.savedCardViewModel.showVisaOneClick.set(0);
                                if (enrollmentData.isEnrolled()) {
                                    BankOffersSavedCardView.this.helper.createOnClickInfoObject(cardData);
                                    BankOffersSavedCardView.this.enableVisaSingleClickEnrolledView();
                                    return;
                                }
                                BankOffersSavedCardView.this.addAnimationVisa();
                                BankOffersSavedCardView.this.showCvvLayout();
                                BankOffersSavedCardView bankOffersSavedCardView = BankOffersSavedCardView.this;
                                bankOffersSavedCardView.preInitCardEnrollment(bankOffersSavedCardView.context, cardData);
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

    public void preInitCardEnrollment(Context context2, CardData cardData) {
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
    public void hideCvvLayout() {
        this.saveCardLayoutBinding.twoModeAuthLayout.setVisibility(8);
        this.saveCardLayoutBinding.cvvLayout.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void addAnimationVisa() {
        if (!this.isVisaOptionDisplayed) {
            SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_CHECKBOX_DISPLAYED, SDKConstants.GA_ENROLLMENT, this.isCreditCardLayout ? SDKConstants.GA_SAVED_CC : SDKConstants.GA_SAVED_DC));
            this.isVisaOptionDisplayed = true;
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (BankOffersSavedCardView.this.saveCardLayoutBinding.oneClickContainer != null) {
                    BankOffersSavedCardView.this.saveCardLayoutBinding.oneClickContainer.startAnimation(AnimationUtils.loadAnimation(BankOffersSavedCardView.this.context, R.anim.shake_animation));
                }
            }
        }, 500);
    }

    /* access modifiers changed from: private */
    public void showCvvLayout() {
        this.saveCardLayoutBinding.twoModeAuthLayout.setVisibility(8);
        this.saveCardLayoutBinding.twoModeAuthLayout.setVisibility(8);
        this.saveCardLayoutBinding.rbSavedCardOtp.setChecked(true);
        this.saveCardLayoutBinding.rbSavedCardOtp.setTypeface((Typeface) null, 1);
        this.saveCardLayoutBinding.cvvLayout.setVisibility(0);
        setLeftRightMargin(28, this.saveCardLayoutBinding.cvvLayout);
        this.mode = "otp";
        this.mode = "otp";
        if (this.savedCard.getChannelCode().equalsIgnoreCase(SDKConstants.MAESTRO)) {
            this.saveCardLayoutBinding.cvvLayout.setVisibility(8);
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

    private boolean isVisaSingleClickEnabled() {
        return DirectPaymentBL.getInstance().isVisaOneClickEnabledForOffers() && this.savedCard.isOneClickSupported() && isVSCPEligible();
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

    /* access modifiers changed from: private */
    public void inflateInfoBottomSheet(boolean z) {
        VisaInfoBottomSheet visaInfoBottomSheet = new VisaInfoBottomSheet();
        Bundle bundle = new Bundle();
        bundle.putString("amount", DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getOneClickMaxAmount());
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
}
