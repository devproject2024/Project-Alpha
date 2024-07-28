package net.one97.paytm.nativesdk.instruments.emi.view;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.f;
import androidx.fragment.app.q;
import androidx.localbroadcastmanager.a.a;
import java.util.ArrayList;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.WebViewActivity;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.model.ApplyPromoResponse;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.model.SavedInstruments;
import net.one97.paytm.nativesdk.databinding.EmiLayoutBinding;
import net.one97.paytm.nativesdk.emiSubvention.EMIConstants;
import net.one97.paytm.nativesdk.emiSubvention.EmiPojoCreater;
import net.one97.paytm.nativesdk.emiSubvention.ISubventionProvider;
import net.one97.paytm.nativesdk.emiSubvention.models.BankData;
import net.one97.paytm.nativesdk.emiSubvention.models.EmiValidatePlan;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.nativesdk.emiSubvention.views.SelectBankActivity;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.listeners.SetOnEmiClickListener;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.EmiChannelInfo;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.view.EmiDetailsBottomSheet;
import net.one97.paytm.nativesdk.instruments.emi.listeners.EmiClickListener;
import net.one97.paytm.nativesdk.instruments.emi.viewmodel.EmiViewModel;
import net.one97.paytm.nativesdk.instruments.netbanking.view.NetBankingProvidersActivity;
import net.one97.paytm.nativesdk.instruments.savedCard.view.SavedCardView;
import net.one97.paytm.nativesdk.orflow.promo.utils.Constants;

public class EmiView extends PaytmBaseView implements EmiDetailsBottomSheet.EmiConvenienceFeeListener, EmiClickListener {
    private static final int REQUEST_EMI_BANK = 1024;
    private static final int REQUEST_EMI_MULTI_ITEM_BANK = 1025;
    private EmiDetailsBottomSheet emiDetailsBottomSheet;
    /* access modifiers changed from: private */
    public EmiLayoutBinding emiLayoutBinding;
    private ArrayList<SavedCardView> emiSavedCardViews;
    /* access modifiers changed from: private */
    public EmiViewModel emiViewModel;
    private PaymentModes paymentModes;
    /* access modifiers changed from: private */
    public int prevSelectedPosition = -1;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (SavedCardView.SAVED_CARD_SELECTED.equalsIgnoreCase(intent.getAction())) {
                EmiView.this.emiViewModel.deSelectAddedCard();
                EmiView.this.emiLayoutBinding.tvUseAnother.setTypeface((Typeface) null, 0);
                EmiView.this.emiLayoutBinding.tvAddedBankName.setTypeface((Typeface) null, 0);
            }
        }
    };
    /* access modifiers changed from: private */
    public ArrayList<BankData> subventionBankList;

    public void changeCardView(boolean z) {
    }

    public void changeOfferTextBgColor(int i2, int i3, boolean z) {
    }

    public void changePromoCodeBg(boolean z) {
    }

    public void changeRemainingAmt(String str) {
    }

    public void monthEditTextFocus() {
    }

    public EmiView(Context context, Instruments instruments, PaymentModes paymentModes2) {
        super(instruments);
        this.context = context;
        this.paymentModes = paymentModes2;
    }

    public void refreshLayout() {
        this.emiViewModel.refreshLayout();
    }

    public PaytmBaseView getEmiView() {
        this.emiLayoutBinding = (EmiLayoutBinding) f.a(LayoutInflater.from(this.context), R.layout.emi_layout, (ViewGroup) null, false);
        this.emiViewModel = new EmiViewModel(this.context, this.paymentModes, this);
        this.emiLayoutBinding.setEmiViewModel(this.emiViewModel);
        this.view = this.emiLayoutBinding.getRoot();
        this.emiLayoutBinding.rlSelectEMIPlan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (EmiView.this.emiViewModel.getCardUIValidator().isCardValid(EmiView.this.emiViewModel.getCardNumber())) {
                    EmiView.this.openEmiPlanSelectionScreen();
                } else {
                    Toast.makeText(EmiView.this.context, "Please enter valid card number", 0).show();
                }
            }
        });
        this.emiLayoutBinding.tvChangePlan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EmiView.this.openEmiPlanSelectionScreen();
            }
        });
        this.emiLayoutBinding.tvChangeBankCard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EmiView.this.handleEmiChangeBankCardClick();
            }
        });
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SavedCardView.SAVED_CARD_SELECTED);
        a.a(this.context.getApplicationContext()).a(this.receiver, intentFilter);
        return this;
    }

    /* access modifiers changed from: private */
    public void handleEmiChangeBankCardClick() {
        this.prevSelectedPosition = 0;
        this.emiViewModel.changeBankCardClicked();
        this.emiViewModel.setFetchPlanString((String) null);
    }

    /* access modifiers changed from: private */
    public void openEmiPlanSelectionScreen() {
        if (DirectPaymentBL.getInstance().isMultiItemEmiFlow()) {
            openMultiItemPlanSelectionScreen();
        } else {
            openEmiDetailBottomSheet();
        }
    }

    private void openMultiItemPlanSelectionScreen() {
        if (this.emiLayoutBinding.pbSelectEmiPlan.getVisibility() != 0) {
            this.emiLayoutBinding.pbSelectEmiPlan.setVisibility(0);
            this.emiViewModel.fetchTenures();
        }
    }

    private void openEmiDetailBottomSheet() {
        if (TextUtils.isEmpty(this.emiViewModel.getEmiChannelCode())) {
            Toast.makeText(this.context, this.context.getResources().getString(R.string.select_bank), 0).show();
            return;
        }
        this.emiDetailsBottomSheet = EmiDetailsBottomSheet.getInstance(this.emiViewModel.getEmiChannelCode(), this.emiViewModel.getEmiType(), (String) null, this.emiViewModel.getCardNumber(), this.prevSelectedPosition, this.emiViewModel.getEmiConvenienceFee(), this.emiViewModel.getCardHash(), getInstantDiscount(), new SetOnEmiClickListener() {
            public void onClick(EmiChannelInfo emiChannelInfo, int i2, String str) {
                int unused = EmiView.this.prevSelectedPosition = i2;
                EmiView.this.emiViewModel.setEmiChannelInfo(emiChannelInfo);
                EmiView.this.updateSelectedView(emiChannelInfo, str);
            }
        }, this);
        this.emiDetailsBottomSheet.setSelectedPosition(this.prevSelectedPosition);
        q a2 = ((AppCompatActivity) this.context).getSupportFragmentManager().a();
        a2.a("emisheet");
        this.emiDetailsBottomSheet.show(a2, (String) null);
    }

    /* access modifiers changed from: private */
    public void updateSelectedView(EmiChannelInfo emiChannelInfo, String str) {
        if (emiChannelInfo != null) {
            this.emiViewModel.setViewUpdatedToNew(true);
            this.emiViewModel.visibilityCardNumber.set(false);
            this.emiViewModel.visibilitySelectPlan.set(false);
            this.emiViewModel.visibilitySelectedCardView.set(true);
            this.emiViewModel.visibilitySelectedPlan.set(true);
            this.emiViewModel.visibilityCvvLayout.set(true);
            this.emiViewModel.visibilityProceedBtn.set(true);
            this.emiViewModel.visibilityChangeBankCard.set(true);
            if (SDKConstants.BAJAJ_FINSERVER_CHANNEL_CODE.equalsIgnoreCase(this.emiViewModel.getEmiChannelCode())) {
                this.emiLayoutBinding.etCvv.setEnabled(false);
            }
            this.emiLayoutBinding.tvAddedBankName.setText(this.emiViewModel.getEmiChannelName());
            String cardNumber = this.emiViewModel.getCardNumber();
            StringBuilder sb = new StringBuilder();
            if (cardNumber.length() >= 18) {
                for (int i2 = 0; i2 < cardNumber.length(); i2++) {
                    if (i2 < 4 || i2 > cardNumber.length() - 5) {
                        sb.append(cardNumber.charAt(i2));
                    } else if (i2 < cardNumber.length() - 5) {
                        if (cardNumber.charAt(i2) == '-') {
                            sb.append(" ");
                        } else {
                            sb.append("•");
                        }
                    }
                }
            }
            this.emiViewModel.addedCardNumber.set(sb.toString());
            this.emiLayoutBinding.tvAddedEmiInfo.setText(this.context.getResources().getString(R.string.emi_details, new Object[]{emiChannelInfo.getEmiPerMonth(), emiChannelInfo.getOfMonths(), emiChannelInfo.getInterestRate()}));
            EmiViewModel emiViewModel2 = this.emiViewModel;
            emiViewModel2.setAddedTotalAmountText("Total " + this.context.getString(R.string.nativesdk_amount, new Object[]{str}));
            this.emiViewModel.updateSubventedOfferView();
        }
    }

    public void openAutoInstrument() {
        this.emiViewModel.emiClicked((View) null);
        isOnceClicked = true;
    }

    public void closeView() {
        this.emiViewModel.deselectView();
        this.emiLayoutBinding.txtEmiSelectBank.setText(this.context.getString(R.string.select_bank));
        closeKeyboard();
        DirectPaymentBL.getInstance().setLastSelectedEmiSavedView((SavedCardView) null);
        enableWallet();
    }

    public void changeArrowIcon(boolean z) {
        if (z) {
            this.emiLayoutBinding.txtDebitCreditCard.setTypeface((Typeface) null, 1);
        } else {
            this.emiLayoutBinding.txtDebitCreditCard.setTypeface((Typeface) null, 0);
        }
    }

    public void showAnimation(boolean z) {
        if (!z && isOnceClicked) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ObjectAnimator.ofInt(EmiView.this.instruments.getScrollView(), "scrollY", new int[]{(int) EmiView.this.getView().getY()}).setDuration(500).start();
                }
            }, 1000);
        }
    }

    public void closeKeyboard() {
        try {
            if (!SDKUtility.hideKeyboard((Activity) this.context)) {
                SDKUtility.hideKeyboard(this.emiLayoutBinding.btnProceed, this.context);
            }
        } catch (Exception unused) {
        }
    }

    public void openSelectBankActivity() {
        if (!DirectPaymentBL.getInstance().isMultiItemEmiFlow()) {
            Intent intent = new Intent(this.context, NetBankingProvidersActivity.class);
            intent.putExtra("fromemi", true);
            intent.putExtra("a", true);
            intent.putExtra(CJRPGTransactionRequestUtils.PAYER_BANK_NAME, "");
            if (this.context instanceof Activity) {
                ((Activity) this.context).startActivityForResult(intent, 1024);
            }
        } else if (this.emiLayoutBinding.pbSelectBank.getVisibility() != 0) {
            ArrayList<BankData> arrayList = this.subventionBankList;
            if (arrayList == null || arrayList.size() <= 0) {
                this.emiLayoutBinding.pbSelectBank.setVisibility(0);
                if (!SDKUtility.isNetworkAvailable(this.context)) {
                    SDKUtility.showErrorInSnackBar(this.context, this.context.getResources().getString(R.string.no_connection), this.context.getResources().getString(R.string.no_internet));
                } else {
                    DirectPaymentBL.getInstance().getSubventionProvider().getBanks(new ISubventionProvider.IBankListener() {
                        public void onBankSuccessResponse(String str) {
                            if (EmiView.this.context instanceof Activity) {
                                ArrayList unused = EmiView.this.subventionBankList = EmiPojoCreater.getBankList(str);
                                if (EmiView.this.subventionBankList == null || EmiView.this.subventionBankList.size() <= 0) {
                                    Toast.makeText(EmiView.this.context, "0 banks found to support your claim.", 1).show();
                                } else {
                                    Intent intent = new Intent(EmiView.this.context, SelectBankActivity.class);
                                    intent.putParcelableArrayListExtra(EMIConstants.EMI_DATA, EmiView.this.subventionBankList);
                                    ((Activity) EmiView.this.context).startActivityForResult(intent, 1024);
                                }
                            }
                            EmiView.this.emiLayoutBinding.pbSelectBank.setVisibility(8);
                        }

                        public void onBankError(String str, String str2) {
                            if (str2 == null || str2.isEmpty()) {
                                str2 = "Something went wrong.";
                            }
                            Toast.makeText(EmiView.this.context, str2, 1).show();
                            EmiView.this.emiLayoutBinding.pbSelectBank.setVisibility(8);
                        }

                        public void onBankNetworkError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
                            if (EmiUtil.isAuthError(apiResponseError)) {
                                SDKUtility.handleVerticalError(apiResponseError, EmiView.this.context);
                                return;
                            }
                            Toast.makeText(EmiView.this.context, "Please connect to internet.", 1).show();
                            EmiView.this.emiLayoutBinding.pbSelectBank.setVisibility(8);
                        }
                    });
                }
            } else {
                Intent intent2 = new Intent(this.context, SelectBankActivity.class);
                intent2.putParcelableArrayListExtra(EMIConstants.EMI_DATA, this.subventionBankList);
                ((Activity) this.context).startActivityForResult(intent2, 1024);
            }
        }
    }

    public void clearCardInfo() {
        this.emiLayoutBinding.etCardNumber.setText("");
        this.prevSelectedPosition = -1;
    }

    public void binResponseReceived(BinResponse binResponse) {
        if (SDKConstants.AMEX.equalsIgnoreCase(binResponse.getBody().getBinDetail().getChannelCode())) {
            this.emiLayoutBinding.etCvv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        } else {
            this.emiLayoutBinding.etCvv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
        }
        int cardImage = SDKUtility.getCardImage(binResponse.getBody().getBinDetail().getChannelCode());
        if (cardImage >= 0) {
            this.emiLayoutBinding.ivCardLogo.setImageResource(cardImage);
            this.emiViewModel.visibilityCardImage.set(true);
        }
    }

    public void deSelectSavedCard() {
        this.emiLayoutBinding.tvUseAnother.setTypeface((Typeface) null, 1);
        this.emiLayoutBinding.tvAddedBankName.setTypeface((Typeface) null, 1);
        if (this.emiSavedCardViews != null) {
            for (int i2 = 0; i2 < this.emiSavedCardViews.size(); i2++) {
                this.emiSavedCardViews.get(i2).deselectView();
            }
        }
    }

    public void changeExpiryView(boolean z) {
        if (z) {
            this.emiLayoutBinding.etExpiryValidity.setBackgroundResource(R.drawable.edit_text_error_bg);
        } else {
            this.emiLayoutBinding.etExpiryValidity.setBackgroundResource(R.drawable.white_background_with_border);
        }
    }

    public void changeCvvView(boolean z) {
        if (z) {
            this.emiLayoutBinding.etCvv.setBackgroundResource(R.drawable.edit_text_error_bg);
        } else {
            this.emiLayoutBinding.etCvv.setBackgroundResource(R.drawable.white_background_with_border);
        }
    }

    public void enableProceedButton() {
        this.emiLayoutBinding.btnProceed.setEnabled(true);
        this.emiLayoutBinding.btnProceed.setClickable(true);
    }

    public void disableProceedButton() {
        this.emiLayoutBinding.btnProceed.setEnabled(false);
        this.emiLayoutBinding.btnProceed.setClickable(false);
    }

    public void startCheckingOfferAnimation() {
        SDKUtility.startAnimation(this.emiLayoutBinding.ltvGetOffers);
    }

    public void stopCheckingOfferAnimation() {
        SDKUtility.stopAnimation(this.emiLayoutBinding.ltvGetOffers);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        PaytmSDKRequestClient.ApiResponseError apiResponseError;
        super.onActivityResult(i2, i3, intent);
        if (i3 == 0 && intent != null && (apiResponseError = (PaytmSDKRequestClient.ApiResponseError) intent.getSerializableExtra(EMIConstants.AUTH_ERROR)) != null) {
            SDKUtility.handleVerticalError(apiResponseError, this.context);
        } else if (i2 == 1024 && i3 == -1) {
            BankData bankData = (BankData) intent.getParcelableExtra(EMIConstants.SELECTED_BANK);
            if (bankData != null) {
                clearOffer();
                clearEMIPrevState();
                this.emiViewModel.setEmiDetails(bankData);
                handleEmiBankSelection();
            }
        } else if (i2 == 2048 && i3 == -1) {
            if ("EMI_VIEW".equalsIgnoreCase(intent.getStringExtra(EMIConstants.FROM_VIEW))) {
                this.emiViewModel.setPaySecurelyText(intent.getStringExtra(EMIConstants.FINAL_PRICE));
                this.emiViewModel.setAmountIfNeeded();
                EmiChannelInfo emiChannelInfo = new EmiChannelInfo();
                String stringExtra = intent.getStringExtra(EMIConstants.VALIDATED_DATA);
                EmiValidatePlan emiValidatePlan = (EmiValidatePlan) intent.getSerializableExtra(EMIConstants.VALIDATED_RESPONSE);
                StringBuilder sb = new StringBuilder();
                sb.append(emiValidatePlan.getEmi());
                emiChannelInfo.setEmiPerMonth(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(emiValidatePlan.getRate());
                emiChannelInfo.setInterestRate(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(emiValidatePlan.getInterval());
                emiChannelInfo.setOfMonths(sb3.toString());
                emiChannelInfo.setPlanId(emiValidatePlan.getPgPlanId());
                this.emiViewModel.setCurrentEmiPlanId(emiValidatePlan.getPlanId());
                this.emiViewModel.setEmiChannelInfo(emiChannelInfo);
                this.emiViewModel.setEmiResponseData(stringExtra);
                this.emiViewModel.setSubventedOfferText(intent.getStringExtra(EMIConstants.OFFER_MSG));
                updateSelectedView(emiChannelInfo, intent.getStringExtra(EMIConstants.EFFECTIVE_PRICE));
            }
        } else if (i2 == 2050 && i3 == -1 && this.emiSavedCardViews != null) {
            for (int i4 = 0; i4 < this.emiSavedCardViews.size(); i4++) {
                this.emiSavedCardViews.get(i4).onActivityResult(i2, i3, intent);
            }
        }
    }

    private void clearEMIPrevState() {
        this.emiLayoutBinding.etCardNumber.setText("");
        this.emiLayoutBinding.etCvv.setText("");
        this.emiLayoutBinding.etExpiryValidity.setText("");
        this.emiLayoutBinding.llSavedCardContainer.removeAllViews();
        this.emiViewModel.clearState();
    }

    public void cvvEditTextFocus() {
        this.emiLayoutBinding.etCvv.requestFocus();
    }

    public void enableDisableCVV(boolean z) {
        this.emiLayoutBinding.etCvv.setEnabled(z);
        if (!z) {
            this.emiLayoutBinding.etCvv.setHint("CVV Not Required");
        } else {
            this.emiLayoutBinding.etCvv.setHint("Enter CVV");
        }
    }

    public void enableDisableExpiry(boolean z) {
        this.emiLayoutBinding.etExpiryValidity.setEnabled(z);
        if (!z) {
            this.emiLayoutBinding.etExpiryValidity.setHint("Expiry Not Required");
        } else {
            this.emiLayoutBinding.etExpiryValidity.setHint("Expiry / Validity Date");
        }
    }

    public void onViewSelected() {
        DirectPaymentBL.getInstance().closeOpnedView();
        DirectPaymentBL.getInstance().setPaytmBaseView(this);
        if (this.emiViewModel.isHybridDisabled() || this.emiViewModel.isEmiHybridDisabled()) {
            disableWallet();
        }
    }

    public void onTenureSuccess(String str) {
        this.emiLayoutBinding.pbSelectEmiPlan.setVisibility(8);
    }

    public void onTenureFailure(String str, String str2) {
        this.emiLayoutBinding.pbSelectEmiPlan.setVisibility(8);
        Context context = this.context;
        Toast.makeText(context, str + ": " + str2, 1).show();
    }

    public void tncClickListener() {
        if (this.context != null) {
            Intent intent = new Intent(this.context, WebViewActivity.class);
            intent.putExtra(Constants.WEB_URL, Constants.TNC_URL);
            intent.putExtra("show_cross_button", true);
            this.context.startActivity(intent);
        }
    }

    private void clearOffer() {
        this.paymentModes.setHybridPaymentOffer((ApplyPromoResponse.PaymentOffer) null);
        this.paymentModes.setPaymentOffer((ApplyPromoResponse.PaymentOffer) null);
        this.emiViewModel.hideOffer();
    }

    private void handleEmiBankSelection() {
        this.emiLayoutBinding.txtEmiSelectBank.setText(this.emiViewModel.getEmiChannelName());
        if (SDKConstants.ZEST_MONEY_CHANNEL_CODE.equalsIgnoreCase(this.emiViewModel.getEmiChannelCode())) {
            this.emiViewModel.setZestMoneyTransaction(true);
            handleZestMoneySelection();
            return;
        }
        if (this.emiViewModel.isHybridDisabled() || this.emiViewModel.isEmiHybridDisabled()) {
            showHybridEmiErrorMessage();
            disableWallet();
        } else if (SDKConstants.BAJAJ_FINSERVER_CHANNEL_CODE.equalsIgnoreCase(this.emiViewModel.getEmiChannelCode())) {
            showHybridEmiErrorMessage();
            disableWallet();
        } else {
            enableWallet();
        }
        showEmiAvailableSavedCards();
    }

    private void showHybridEmiErrorMessage() {
        String emiChannelName = this.emiViewModel.getEmiChannelName();
        SDKUtility.showErrorInSnackBar(this.context, emiChannelName + " selected", "Paytm Wallet and " + emiChannelName + " cannot be used together for this payment.");
    }

    private void disableWallet() {
        try {
            Intent intent = new Intent();
            intent.setAction(SDKConstants.DISABLE_WALLET_UPI_COLLECT);
            a.a(this.context).a(intent);
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    private void enableWallet() {
        try {
            Intent intent = new Intent();
            intent.setAction(SDKConstants.ENABLE_WALLET_UPI_COLLECT);
            a.a(this.context).a(intent);
        } catch (Exception unused) {
        }
    }

    private void handleZestMoneySelection() {
        this.emiViewModel.visibilityProceedBtn.set(true);
    }

    private void showEmiAvailableSavedCards() {
        ArrayList<SavedInstruments> arrayList;
        if (!TextUtils.isEmpty(this.emiViewModel.getEmiChannelCode())) {
            if (!SDKUtility.isSaveCardsAvailable()) {
                this.emiViewModel.visibilityAnotherCard.set(false);
                this.emiViewModel.visibilityCardNumber.set(true);
                this.emiViewModel.visibilitySelectPlan.set(true);
                return;
            }
            DirectPaymentBL.getInstance().setLastSelectedEmiSavedView((SavedCardView) null);
            if (DirectPaymentBL.getInstance().isWalletAmountSufficientToPay() || !SDKConstants.ADDANDPAY.equalsIgnoreCase(DirectPaymentBL.getInstance().getSelectedPaymentMode())) {
                arrayList = DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getMerchantPayOption().getSavedInstruments();
            } else {
                arrayList = DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getAddMoneyPayOption().getSavedInstruments();
            }
            Instruments instruments = new Instruments();
            this.emiSavedCardViews = new ArrayList<>();
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                try {
                    if (this.emiViewModel.getEmiChannelCode().equalsIgnoreCase(arrayList.get(i3).getIssuingBank()) && this.emiViewModel.getSelectedBankData() != null && this.emiViewModel.getSelectedBankData().getCardType().equalsIgnoreCase(arrayList.get(i3).getCardDetails().getCardType()) && arrayList.get(i3).isEmiAvailable()) {
                        SavedCardView savedCardView = (SavedCardView) instruments.getSavedCardView(this.context, arrayList.get(i3), true);
                        this.emiSavedCardViews.add(savedCardView);
                        this.emiLayoutBinding.llSavedCardContainer.addView(savedCardView.getView());
                        i2++;
                    }
                } catch (Exception unused) {
                }
            }
            if (i2 > 0) {
                this.emiSavedCardViews.get(0).selectView();
            }
            if (i2 == 0) {
                this.emiViewModel.visibilityAnotherCard.set(false);
                this.emiViewModel.visibilityCardNumber.set(true);
                this.emiViewModel.visibilitySelectPlan.set(true);
                return;
            }
            this.emiViewModel.visibilitySavedCardContainer.set(true);
            this.emiViewModel.visibilityAnotherCard.set(true);
            this.emiViewModel.visibilityCardNumber.set(false);
            this.emiViewModel.visibilitySelectPlan.set(false);
        }
    }

    public void setEmiConvenienceFeeResponse(Object obj, ArrayList<PaymentIntent> arrayList, String str) {
        this.emiViewModel.setVerifyResponseModel(obj);
        this.emiViewModel.setPaymentIntents(arrayList);
        this.emiViewModel.configureConvFeeView();
    }

    public void onDestroy() {
        super.onDestroy();
        a.a(this.context.getApplicationContext()).a(this.receiver);
    }

    public ApplyPromoResponse.PaymentOffer getPaymentOffer() {
        if (SDKUtility.isHybridCase()) {
            return this.paymentModes.getHybridPaymentOffer();
        }
        return this.paymentModes.getPaymentOffer();
    }

    public String getInstantDiscount() {
        ApplyPromoResponse.PaymentOffer paymentOffer = getPaymentOffer();
        return (paymentOffer == null || TextUtils.isEmpty(paymentOffer.getTotalInstantDiscount())) ? "" : paymentOffer.getTotalInstantDiscount();
    }

    public boolean isTenureSelected() {
        return this.emiViewModel.getEmiChannelInfo() != null;
    }

    public boolean isHybridDisabled() {
        return this.emiViewModel.isHybridDisabled();
    }

    public boolean isEmiHybridDisabled() {
        return this.emiViewModel.isEmiHybridDisabled();
    }
}
