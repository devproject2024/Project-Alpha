package net.one97.paytm.nativesdk.orflow.transaction.newcard;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.f;
import androidx.localbroadcastmanager.a.a;
import com.bumptech.glide.b;
import com.bumptech.glide.e.h;
import com.bumptech.glide.load.b.j;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ConvenienceFeeController;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.helpers.GTMLoader;
import net.one97.paytm.nativesdk.common.model.CardPaymentIntentData;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.common.model.SavedInstruments;
import net.one97.paytm.nativesdk.databinding.NewCardBankOffersBinding;
import net.one97.paytm.nativesdk.emiSubvention.EMIConstants;
import net.one97.paytm.nativesdk.emiSubvention.ISubventionProvider;
import net.one97.paytm.nativesdk.emiSubvention.models.BankData;
import net.one97.paytm.nativesdk.emiSubvention.models.EmiValidatePlan;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.listeners.DebitCreditCardListener;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.EmiChannelInfo;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.view.VisaInfoBottomSheet;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;
import net.one97.paytm.nativesdk.orflow.promo.model.GetCardDetailsResponse;
import net.one97.paytm.nativesdk.orflow.transaction.BankOfferCardView;
import net.one97.paytm.nativesdk.orflow.transaction.TransactionDialogListener;
import net.one97.paytm.nativesdk.orflow.transaction.newcard.BankOffersNewCardViewModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public class BankOffersNewCardView extends PaytmBaseView implements DebitCreditCardListener, BankOfferCardView {
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            BankOffersNewCardView bankOffersNewCardView;
            if (SDKConstants.UNCHECK_VIEWS_ACTION_FILTER.equalsIgnoreCase(intent.getAction())) {
                if (BankOffersNewCardView.this.debitCreditCardViewModel != null) {
                    BankOffersNewCardView.this.debitCreditCardViewModel.uncheckLastCardSelected();
                }
            } else if (SDKConstants.UNREGISTER_BROADCAST.equalsIgnoreCase(intent.getAction())) {
                BankOffersNewCardView.this.unregisterBroadCast(context);
            } else if (SDKConstants.REFRESH_LAYOUT_FILTER.equalsIgnoreCase(intent.getAction())) {
                BankOffersNewCardView.this.debitCreditCardViewModel.refreshSavedCards();
            } else if (SDKConstants.NET_BANKING_ACTION_FILTER.equalsIgnoreCase(intent.getAction()) && DirectPaymentBL.getInstance().getPaytmBaseView() == (bankOffersNewCardView = BankOffersNewCardView.this)) {
                String unused = bankOffersNewCardView.emiChannelCode = intent.getStringExtra(SDKConstants.CHANNEL_CODE);
                String unused2 = BankOffersNewCardView.this.emiChannelName = intent.getStringExtra(SDKConstants.CHANNEL_NAME);
                BankOffersNewCardView.this.debitCreditCardViewModel.newCardContainerVisibilty.set(8);
                BankOffersNewCardView.this.debitCreditCardViewModel.payWithNewDebitCardVisibility.set(0);
            }
        }
    };
    private GetCardDetailsResponse cardDetailsResponse;
    private boolean creditCard;
    /* access modifiers changed from: private */
    public String currentEmiPlanId;
    /* access modifiers changed from: private */
    public NewCardBankOffersBinding debitCreditCardLayoutBinding;
    /* access modifiers changed from: private */
    public BankOffersNewCardViewModel debitCreditCardViewModel;
    /* access modifiers changed from: private */
    public String emiChannelCode;
    /* access modifiers changed from: private */
    public String emiChannelName = "";
    private boolean isEmiView;
    private int prevEmiSelectedPosition = -1;
    private ProgressDialog progressDialog;
    private LinearLayout saveCardsContainer;
    private TransactionDialogListener transactionDialogListener;

    public void addSavedCard(View view) {
    }

    public void atmRadioChecked(boolean z) {
    }

    public void changeArrowIcon(boolean z) {
    }

    public void changeOfferTextBgColor(int i2, int i3, boolean z) {
    }

    public void clearEmiDetails() {
    }

    public void clearRadioGroup() {
    }

    public void clearSavedCard() {
    }

    public void closeView() {
    }

    public void disableProceedButton() {
    }

    public void enableProceedButton() {
    }

    public void hidePaymentsLoader() {
    }

    public void scrollTo(int i2) {
    }

    public void scrollTo(View view) {
    }

    public void showHideAnimation(View view, boolean z) {
    }

    public void showRiskConvenienceFeeInfo(String str, String str2, String str3) {
    }

    public void startCheckingOfferAnimation() {
    }

    public void stopCheckingOfferAnimation() {
    }

    public void updateNewCardImage(String str) {
    }

    public void refreshLayout() {
        this.debitCreditCardViewModel.refreshLayout();
    }

    /* access modifiers changed from: private */
    public void unregisterBroadCast(Context context) {
        if (context != null) {
            try {
                a.a(context.getApplicationContext()).a(this.broadcastReceiver);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    public BankOffersNewCardView(Context context, boolean z, boolean z2, Instruments instruments, LinearLayout linearLayout) {
        super(instruments);
        this.saveCardsContainer = linearLayout;
        this.context = context;
        this.creditCard = z;
        this.isEmiView = z2;
        this.progressDialog = new ProgressDialog(context);
        this.progressDialog.setTitle(this.context.getResources().getString(R.string.please_wait));
    }

    public PaytmBaseView getDebitCreditCardsView(GetCardDetailsResponse getCardDetailsResponse) {
        this.cardDetailsResponse = getCardDetailsResponse;
        this.debitCreditCardLayoutBinding = (NewCardBankOffersBinding) f.a((LayoutInflater) this.context.getSystemService("layout_inflater"), R.layout.new_card_bank_offers, (ViewGroup) null, false);
        this.debitCreditCardLayoutBinding.etCvv.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, final boolean z) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if (z && BankOffersNewCardView.this.debitCreditCardViewModel.isExiparyInvalid()) {
                            BankOffersNewCardView.this.debitCreditCardLayoutBinding.etExpiryValidity.requestFocus();
                        }
                    }
                }, 200);
            }
        });
        this.creditCard = SDKConstants.CREDIT.equalsIgnoreCase(getCardDetailsResponse.getBody().getCardDetails().getBinDetail().getPaymentMode());
        this.debitCreditCardViewModel = new BankOffersNewCardViewModel(this.context, this.creditCard, this.isEmiView, this);
        this.debitCreditCardViewModel.setPaymentIntent(PromoHelper.Companion.getInstance().getPaymentIntent());
        this.debitCreditCardLayoutBinding.etCardNumber.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            public void onDestroyActionMode(ActionMode actionMode) {
            }

            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        this.debitCreditCardLayoutBinding.etCardNumber.setLongClickable(false);
        NewCardBankOffersBinding newCardBankOffersBinding = this.debitCreditCardLayoutBinding;
        newCardBankOffersBinding.setView(newCardBankOffersBinding.getRoot());
        this.debitCreditCardLayoutBinding.setDebitCardModel(this.debitCreditCardViewModel);
        this.debitCreditCardLayoutBinding.tvOneClickMsg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (BankOffersNewCardView.this.debitCreditCardLayoutBinding.cbOneClick.isChecked()) {
                    BankOffersNewCardView.this.debitCreditCardViewModel.isSingleVisaClickChecked.set(false);
                } else {
                    BankOffersNewCardView.this.debitCreditCardViewModel.isSingleVisaClickChecked.set(true);
                }
            }
        });
        if (DirectPaymentBL.getInstance().getGtmStringValues() != null) {
            String string = GTMLoader.getString(SDKConstants.KEY_ENABLE_SCP_TEXT);
            if (!TextUtils.isEmpty(string)) {
                this.debitCreditCardLayoutBinding.tvOneClickMsg.setText(string);
            }
        }
        this.debitCreditCardLayoutBinding.tvOneClickViewDetails.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BankOffersNewCardView.this.inflateInfoBottomSheet(false);
            }
        });
        this.debitCreditCardLayoutBinding.iconVscpInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BankOffersNewCardView.this.inflateInfoBottomSheet(true);
            }
        });
        if (getCardDetailsResponse.getBody() != null) {
            this.debitCreditCardLayoutBinding.etCardNumber.setText(getCardDetailsResponse.getBody().getCardNumber());
            this.debitCreditCardLayoutBinding.etCardNumber.setOnClickListener((View.OnClickListener) null);
            this.debitCreditCardLayoutBinding.etCardNumber.setClickable(false);
            this.debitCreditCardLayoutBinding.etCardNumber.clearFocus();
            this.debitCreditCardLayoutBinding.etExpiryValidity.requestFocus();
            if (getCardDetailsResponse.getBody().getCardDetails() != null) {
                b.b(this.context).a(getCardDetailsResponse.getBody().getCardDetails().getIconUrl()).a(this.debitCreditCardLayoutBinding.ivCardLogo);
            }
            this.debitCreditCardViewModel.setCardNumber(getCardDetailsResponse.getBody().getCardNumber());
            this.debitCreditCardViewModel.fetchBinDetails(getCardDetailsResponse.getBody().getCardNumber().replace("-", "").substring(0, 6), (BankOffersNewCardViewModel.SetOnFetchBinResult) null);
        }
        if (getCardDetailsResponse.getBody().getCardDetails() == null || !getCardDetailsResponse.getBody().getCardDetails().isEmiAvailable().booleanValue() || !DirectPaymentBL.getInstance().isMultiItemEmiFlow()) {
            this.debitCreditCardLayoutBinding.tvEmiAvailbale.setVisibility(8);
        } else {
            this.debitCreditCardLayoutBinding.tvEmiAvailbale.setVisibility(0);
            this.debitCreditCardLayoutBinding.tvEmiAvailbale.setText(SDKUtility.getEmiAvailableText(this.context, getCardDetailsResponse.getBody().getCardDetails().getSubventionType()));
        }
        this.debitCreditCardLayoutBinding.imgEmiCross.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BankOffersNewCardView.this.debitCreditCardLayoutBinding.emiDetailsLayout.setVisibility(8);
                BankOffersNewCardView.this.debitCreditCardLayoutBinding.tvEmiAvailbale.setVisibility(0);
                BankOffersNewCardView.this.debitCreditCardLayoutBinding.tvChangePlan.setVisibility(8);
                BankOffersNewCardView.this.debitCreditCardLayoutBinding.tvTotalAmount.setVisibility(8);
                BankOffersNewCardView.this.debitCreditCardViewModel.setEmiChannelInfo((EmiChannelInfo) null);
                BankOffersNewCardView.this.debitCreditCardViewModel.setEmiPlanData((String) null);
                BankOffersNewCardView.this.debitCreditCardViewModel.setEmiEnabled(false);
                BankOffersNewCardView.this.hideSubventedOfferView();
            }
        });
        this.debitCreditCardLayoutBinding.tvEmiAvailbale.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BankOffersNewCardView.this.debitCreditCardViewModel.setEmiEnabled(true);
                BankOffersNewCardView.this.selectSavedCard();
                BankOffersNewCardView.this.sendEmiGAEvent();
            }
        });
        this.debitCreditCardLayoutBinding.tvChangePlan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BankOffersNewCardView.this.selectSavedCard();
            }
        });
        this.view = this.debitCreditCardLayoutBinding.getRoot();
        if (this.broadcastReceiver != null) {
            registerReciever(this.context, this.broadcastReceiver);
        }
        this.debitCreditCardViewModel.updateVisaSingleClickUI();
        return this;
    }

    /* access modifiers changed from: private */
    public void sendEmiGAEvent() {
        if (DirectPaymentBL.getInstance().isMultiItemEmiFlow()) {
            SDKUtility.sendGaEvents(new HashMap<String, Object>() {
                {
                    put("event_category", "emi");
                    put("event_action", "emi_available_clicked");
                    put("event_label", "emi available");
                    put("event_label2", "bank offer express checkout");
                    put("vertical_name", "emi");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void selectSavedCard() {
        if (DirectPaymentBL.getInstance().isMultiItemEmiFlow()) {
            openMultiItemPlanSelectionScreen();
        }
    }

    private void openMultiItemPlanSelectionScreen() {
        if (this.debitCreditCardLayoutBinding.pbSelectPlan.getVisibility() != 0) {
            this.debitCreditCardLayoutBinding.pbSelectPlan.setVisibility(0);
            BankData bankData = new BankData();
            bankData.setType(this.cardDetailsResponse.getBody().getCardDetails().getSubventionType());
            bankData.setBankName(this.cardDetailsResponse.getBody().getCardDetails().getBinDetail().getIssuingBankCode());
            bankData.setBankCode(this.cardDetailsResponse.getBody().getCardDetails().getBinDetail().getIssuingBankCode());
            bankData.setCardType(this.cardDetailsResponse.getBody().getCardDetails().getBinDetail().getPaymentMode());
            this.debitCreditCardViewModel.setEmiPaymentIntent(buildEmiPaymentIntent());
            EmiUtil.fetchTenuresWithOffers(bankData, new ISubventionProvider.IBankTenureListener() {
                public void onBankSuccessResponse(String str) {
                    String str2 = str;
                    EmiUtil.startEmiPlanActivity(BankOffersNewCardView.this.context, str2, SDKUtility.priceWithoutDecimal(SDKUtility.getDiffAmount()), "OR_FLOW_SAVED_CARD", EmiUtil.EMI_PLAN_REQUEST_CODE, BankOffersNewCardView.this.debitCreditCardViewModel.getEmiPaymentIntent(), (String) null, BankOffersNewCardView.this.currentEmiPlanId);
                    BankOffersNewCardView.this.debitCreditCardLayoutBinding.pbSelectPlan.setVisibility(8);
                }

                public void onBankError(String str, String str2) {
                    BankOffersNewCardView.this.debitCreditCardLayoutBinding.pbSelectPlan.setVisibility(8);
                    Context access$1100 = BankOffersNewCardView.this.context;
                    Toast.makeText(access$1100, str + ": " + str2, 1).show();
                }

                public void onBankNetworkError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
                    if (EmiUtil.isAuthError(apiResponseError)) {
                        SDKUtility.handleVerticalError(apiResponseError, BankOffersNewCardView.this.context);
                        return;
                    }
                    BankOffersNewCardView.this.debitCreditCardLayoutBinding.pbSelectPlan.setVisibility(8);
                    Context access$1300 = BankOffersNewCardView.this.context;
                    Toast.makeText(access$1300, apiResponseError.getErrorTitle() + ": " + apiResponseError.getErrorMsg(), 1).show();
                }
            }, this.debitCreditCardViewModel.getEmiPaymentIntent(), (String) null);
        }
    }

    public void openAutoInstrument() {
        LinearLayout linearLayout = this.saveCardsContainer;
        if (linearLayout == null || linearLayout.getChildCount() <= 0) {
            this.debitCreditCardViewModel.debitCardViewClicked((View) null);
        } else {
            this.saveCardsContainer.getChildAt(0).performClick();
        }
        isOnceClicked = true;
    }

    private void enableDisableView(View view, boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        Drawable a2 = androidx.core.content.b.a(this.context, R.drawable.grey_background_with_border);
        Drawable a3 = androidx.core.content.b.a(this.context, R.drawable.white_background_with_border);
        view.setEnabled(z);
        if (z) {
            if (i2 < 16) {
                view.setBackgroundDrawable(a3);
            } else {
                view.setBackground(a3);
            }
        } else if (i2 < 16) {
            view.setBackgroundDrawable(a2);
        } else {
            view.setBackground(a2);
        }
    }

    public void onProceedClick(View view) {
        this.debitCreditCardViewModel.proceedClicked(view);
    }

    public void monthEditTextFocus() {
        if (this.debitCreditCardLayoutBinding.etExpiryValidity.isEnabled()) {
            this.debitCreditCardLayoutBinding.etExpiryValidity.requestFocus();
        } else {
            cvvEditTextFocus();
        }
    }

    public void cvvEditTextFocus() {
        if (this.debitCreditCardLayoutBinding.etCvv.isEnabled()) {
            this.debitCreditCardLayoutBinding.etCvv.requestFocus();
        } else {
            closeKeyboard();
        }
    }

    public void updateNewCardImage(int i2) {
        if (i2 == -1) {
            this.debitCreditCardLayoutBinding.ivCardLogo.setVisibility(8);
            return;
        }
        this.debitCreditCardLayoutBinding.ivCardLogo.setVisibility(0);
        b.b(this.context).a(Integer.valueOf(i2)).b((com.bumptech.glide.e.a<?>) ((h) new h().a(80, 80)).a(j.f6875a)).a(this.debitCreditCardLayoutBinding.ivCardLogo);
    }

    private void refershSavedCardsView() {
        if (this.saveCardsContainer != null) {
            for (int i2 = 0; i2 < this.saveCardsContainer.getChildCount(); i2++) {
                View childAt = this.saveCardsContainer.getChildAt(i2);
                if (!(childAt == null || childAt.getTag() == null || !(childAt.getTag() instanceof SavedInstruments))) {
                    SavedInstruments savedInstruments = (SavedInstruments) childAt.getTag();
                    double diffAmount = SDKUtility.getDiffAmount();
                    if (diffAmount < DirectPaymentBL.getInstance().getEmiMin() || diffAmount > DirectPaymentBL.getInstance().getEmiMax() || !savedInstruments.isEmiAvailable()) {
                        childAt.findViewById(R.id.tv_emi_availbale).setVisibility(8);
                    } else {
                        childAt.findViewById(R.id.tv_emi_availbale).setVisibility(0);
                    }
                    childAt.findViewById(R.id.emi_details_layout).setVisibility(8);
                    childAt.findViewById(R.id.tv_change_plan).setVisibility(8);
                    childAt.findViewById(R.id.tv_total_amount).setVisibility(8);
                }
            }
            this.prevEmiSelectedPosition = -1;
        }
    }

    public void clearNewCardInfo() {
        this.debitCreditCardLayoutBinding.etCardNumber.setText("");
        this.debitCreditCardLayoutBinding.etCvv.setText("");
        enableDisableView(this.debitCreditCardLayoutBinding.etCvv, true);
        enableDisableView(this.debitCreditCardLayoutBinding.etExpiryValidity, true);
        this.debitCreditCardLayoutBinding.etExpiryValidity.setText("");
        updateNewCardImage(-1);
        this.debitCreditCardLayoutBinding.otpTopLayout.setVisibility(8);
        this.debitCreditCardLayoutBinding.etOtpCVV.setText("");
        this.debitCreditCardLayoutBinding.tvCvvHelp.setVisibility(0);
        this.debitCreditCardLayoutBinding.otpCvvLayout.setBackgroundResource(R.drawable.white_background_with_border);
        this.debitCreditCardLayoutBinding.etCardNumber.requestFocus();
        changeCvvRequiredNotRequired(true);
        changeCvvRequiredNotRequired(true);
    }

    public void cardClicked() {
        DirectPaymentBL.getInstance().closeOpnedView();
        DirectPaymentBL.getInstance().setPaytmBaseView(this);
        SDKUtility.expand(this.debitCreditCardLayoutBinding.newCardContainer, (Integer) null);
    }

    public void hideCvvKeyBoard() {
        SDKUtility.hideKeyboard(this.debitCreditCardLayoutBinding.etCvv, this.context);
    }

    public void closeCachierSheet() {
        this.instruments.closeCashierSheet();
    }

    public void showNewCardAnimation() {
        showHideAnimation(this.debitCreditCardLayoutBinding.newCardContainer, false);
    }

    public void hideNewCardAnimation() {
        showHideAnimation(this.debitCreditCardLayoutBinding.newCardContainer, true);
    }

    public void changeCardUi(boolean z, int i2) {
        String str = "Credit Card";
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    if (z) {
                        if (this.debitCreditCardLayoutBinding.etCvv.isEnabled()) {
                            this.debitCreditCardLayoutBinding.tvCvv.setText(this.context.getResources().getString(R.string.native_enter_valid_cvv));
                            this.debitCreditCardLayoutBinding.tvCvv.setTextColor(-65536);
                            this.debitCreditCardLayoutBinding.etCvv.setBackgroundResource(R.drawable.edit_text_error_bg);
                        } else {
                            this.debitCreditCardLayoutBinding.txtErrMsg.setText(this.context.getResources().getString(R.string.native_enter_valid_cvv));
                            this.debitCreditCardLayoutBinding.txtErrMsg.setTextColor(-65536);
                            this.debitCreditCardLayoutBinding.otpCvvLayout.setBackgroundResource(R.drawable.edit_text_error_bg);
                        }
                        if (!this.creditCard) {
                            str = "Debit Card";
                        }
                        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_PAY_CLICKED_ERROR, str, "Invalid CVV (New Cards)"));
                    } else if (this.debitCreditCardLayoutBinding.etCvv.isEnabled()) {
                        if (!SDKConstants.MAESTRO.equalsIgnoreCase(this.debitCreditCardViewModel.newCardType)) {
                            this.debitCreditCardLayoutBinding.tvCvv.setText(this.context.getResources().getString(R.string.cvv));
                        }
                        this.debitCreditCardLayoutBinding.tvCvv.setTextColor(this.context.getResources().getColor(R.color.light_black));
                        this.debitCreditCardLayoutBinding.etCvv.setBackgroundResource(R.drawable.white_background_with_border);
                    } else {
                        this.debitCreditCardLayoutBinding.txtErrMsg.setText("");
                        this.debitCreditCardLayoutBinding.txtErrMsg.setVisibility(8);
                        this.debitCreditCardLayoutBinding.otpCvvLayout.setBackgroundResource(R.drawable.white_background_with_border);
                    }
                }
            } else if (z) {
                this.debitCreditCardLayoutBinding.tvExipary.setText(this.context.getResources().getString(R.string.enter_valid_expiray));
                this.debitCreditCardLayoutBinding.tvExipary.setTextColor(-65536);
                this.debitCreditCardLayoutBinding.etExpiryValidity.setBackgroundResource(R.drawable.edit_text_error_bg);
                if (!this.creditCard) {
                    str = "Debit Card";
                }
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_PAY_CLICKED_ERROR, str, "Invalid Expiry Date (New Cards)"));
            } else {
                if (!SDKConstants.MAESTRO.equalsIgnoreCase(this.debitCreditCardViewModel.newCardType)) {
                    this.debitCreditCardLayoutBinding.tvExipary.setText(this.context.getResources().getString(R.string.expiry_validity_date));
                }
                this.debitCreditCardLayoutBinding.tvExipary.setTextColor(this.context.getResources().getColor(R.color.light_black));
                this.debitCreditCardLayoutBinding.etExpiryValidity.setBackgroundResource(R.drawable.white_background_with_border);
            }
        } else if (z) {
            this.debitCreditCardLayoutBinding.tvEnterCardNumber.setText(this.context.getResources().getString(R.string.enter_valid_card_number));
            this.debitCreditCardLayoutBinding.tvEnterCardNumber.setTextColor(-65536);
            this.debitCreditCardLayoutBinding.etCardNumber.setBackgroundResource(R.drawable.edit_text_error_bg);
            if (!this.creditCard) {
                str = "Debit Card";
            }
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_PAY_CLICKED_ERROR, str, "Invalid Card Number (New Cards)"));
        } else {
            this.debitCreditCardLayoutBinding.tvEnterCardNumber.setText(this.context.getResources().getString(R.string.enter_your_card_details));
            this.debitCreditCardLayoutBinding.tvEnterCardNumber.setTextColor(this.context.getResources().getColor(R.color.light_black));
            this.debitCreditCardLayoutBinding.etCardNumber.setBackgroundResource(R.drawable.white_background_with_border);
        }
    }

    public void showHideProgressDialog(boolean z) {
        if (z) {
            this.progressDialog.show();
        } else {
            this.progressDialog.hide();
        }
    }

    public void closeKeyboard() {
        try {
            if (!SDKUtility.hideKeyboard((Activity) this.context)) {
                SDKUtility.hideKeyboard(this.debitCreditCardLayoutBinding.etCardNumber, this.context);
                SDKUtility.hideKeyboard(this.debitCreditCardLayoutBinding.etExpiryValidity, this.context);
                SDKUtility.hideKeyboard(this.debitCreditCardLayoutBinding.etCvv, this.context);
            }
        } catch (Exception unused) {
        }
    }

    public void enableDisableExipary(boolean z) {
        enableDisableView(this.debitCreditCardLayoutBinding.etExpiryValidity, z);
        this.debitCreditCardLayoutBinding.tvExipary.setTextColor(this.context.getResources().getColor(R.color.light_black));
        if (z) {
            changeExpiryRequiredNotRequired(true);
        } else {
            changeExpiryRequiredNotRequired(false);
        }
    }

    public void enableDisableCvv(boolean z) {
        enableDisableView(this.debitCreditCardLayoutBinding.etCvv, z);
        this.debitCreditCardLayoutBinding.tvCvv.setTextColor(this.context.getResources().getColor(R.color.light_black));
        if (z) {
            changeCvvRequiredNotRequired(true);
            return;
        }
        changeCvvRequiredNotRequired(false);
        this.debitCreditCardLayoutBinding.tvCvvHelp.setVisibility(8);
    }

    public void changeCvvRequiredNotRequired(boolean z) {
        if (z) {
            this.debitCreditCardLayoutBinding.tvCvvHelp.setVisibility(0);
            this.debitCreditCardLayoutBinding.tvCvv.setText(this.context.getResources().getString(R.string.cvv));
            return;
        }
        this.debitCreditCardLayoutBinding.tvCvvHelp.setVisibility(8);
        this.debitCreditCardLayoutBinding.tvCvv.setText(this.context.getResources().getString(R.string.native_cvv_not_required));
    }

    public void changeCvvFieldLength(int i2) {
        this.debitCreditCardLayoutBinding.etCvv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
    }

    public void changePromoCodeBg(boolean z) {
        if (z) {
            this.debitCreditCardLayoutBinding.tvPromoMessage.setBackgroundColor(Color.parseColor("#fdfbd3"));
            this.debitCreditCardLayoutBinding.tvPromoMessage.setTextColor(Color.parseColor("#666666"));
            return;
        }
        this.debitCreditCardLayoutBinding.tvPromoMessage.setBackgroundColor(Color.parseColor("#bef8ce"));
        this.debitCreditCardLayoutBinding.tvPromoMessage.setTextColor(Color.parseColor("#222222"));
    }

    public void animateOneClickContainer() {
        RelativeLayout relativeLayout = this.debitCreditCardLayoutBinding.oneClickContainer;
        relativeLayout.startAnimation(AnimationUtils.loadAnimation(relativeLayout.getContext(), R.anim.shake_animation));
    }

    public void changeExpiryRequiredNotRequired(boolean z) {
        if (z) {
            this.debitCreditCardLayoutBinding.tvExipary.setText(this.context.getResources().getString(R.string.expiry_validity_date));
        } else {
            this.debitCreditCardLayoutBinding.tvExipary.setText(this.context.getResources().getString(R.string.native_expirary_nr));
        }
    }

    public void sendUncheckBroadcast() {
        unregisterBroadCast(this.context);
        Intent intent = new Intent();
        intent.setAction(SDKConstants.UNCHECK_VIEWS_ACTION_FILTER);
        a.a(this.context.getApplicationContext()).a(intent);
        registerReciever(this.context, this.broadcastReceiver);
    }

    public boolean isEmiView() {
        return this.isEmiView;
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
            EmiChannelInfo emiChannelInfo = new EmiChannelInfo();
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
            this.debitCreditCardViewModel.setEmiChannelInfo(emiChannelInfo);
            this.debitCreditCardViewModel.setEmiPlanData(stringExtra);
            this.currentEmiPlanId = emiValidatePlan.getPlanId();
            updateSubventedOfferView(intent.getStringExtra(EMIConstants.OFFER_MSG));
            changeEMIUi(this.debitCreditCardLayoutBinding, this.debitCreditCardViewModel.getEmiChannelInfo(), 0, intent.getStringExtra(EMIConstants.EFFECTIVE_PRICE));
        }
    }

    private void changeEMIUi(NewCardBankOffersBinding newCardBankOffersBinding, EmiChannelInfo emiChannelInfo, int i2, String str) {
        this.prevEmiSelectedPosition = i2;
        DecimalFormat decimalFormat = new DecimalFormat(".##");
        this.debitCreditCardViewModel.setEmiChannelInfo(emiChannelInfo);
        if (!TextUtils.isEmpty(str)) {
            newCardBankOffersBinding.tvTotalAmount.setVisibility(0);
            RoboTextView roboTextView = newCardBankOffersBinding.tvTotalAmount;
            roboTextView.setText("Total " + this.context.getString(R.string.nativesdk_amount, new Object[]{str}));
        } else {
            newCardBankOffersBinding.tvTotalAmount.setVisibility(8);
        }
        newCardBankOffersBinding.tvChangePlan.setVisibility(0);
        newCardBankOffersBinding.emiDetailsLayout.setVisibility(0);
        newCardBankOffersBinding.tvEmiAvailbale.setVisibility(8);
        newCardBankOffersBinding.txtEmiDetails.setText(this.context.getResources().getString(R.string.emi_details, new Object[]{decimalFormat.format(Double.valueOf(this.debitCreditCardViewModel.getEmiChannelInfo().getEmiPerMonth())), this.debitCreditCardViewModel.getEmiChannelInfo().getOfMonths(), decimalFormat.format(Double.valueOf(this.debitCreditCardViewModel.getEmiChannelInfo().getInterestRate()))}));
    }

    private ArrayList<PaymentIntent> buildEmiPaymentIntent() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.cardDetailsResponse.getBody().getCardDetails().getBinDetail().getChannelCode());
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.cardDetailsResponse.getBody().getCardDetails().getBinDetail().getIssuingBankCode());
        CardPaymentIntentData cardPaymentIntentData = new CardPaymentIntentData();
        cardPaymentIntentData.setCardHash(this.cardDetailsResponse.getBody().getCardHash());
        String replace = this.cardDetailsResponse.getBody().getCardNumber().replace("-", "");
        String substring = replace.substring(0, 6);
        String substring2 = replace.substring(0, 8);
        cardPaymentIntentData.setBin6(substring);
        cardPaymentIntentData.setBin8(substring2);
        return ConvenienceFeeController.getInstance().buildPaymentIntent(PayMethodType.EMI.name(), arrayList, arrayList2, cardPaymentIntentData, this.cardDetailsResponse.getBody().getCardDetails().getBinDetail().getPaymentMode(), Double.valueOf(0.0d));
    }

    public void setTransactionDialogListener(TransactionDialogListener transactionDialogListener2) {
        this.transactionDialogListener = transactionDialogListener2;
    }

    private void updateSubventedOfferView(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.debitCreditCardLayoutBinding.tvSubventionOffer.setVisibility(0);
            this.debitCreditCardLayoutBinding.tvSubventionOffer.setText(str);
            return;
        }
        hideSubventedOfferView();
    }

    /* access modifiers changed from: private */
    public void hideSubventedOfferView() {
        this.transactionDialogListener.updatePaySecurelyText(MerchantBL.getMerchantInstance().getAmount());
        this.debitCreditCardLayoutBinding.tvSubventionOffer.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void inflateInfoBottomSheet(boolean z) {
        VisaInfoBottomSheet visaInfoBottomSheet = new VisaInfoBottomSheet();
        Bundle bundle = new Bundle();
        bundle.putString("amount", DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getOneClickMaxAmount());
        boolean z2 = this.creditCard;
        String str = SDKConstants.GA_NEW_CC;
        bundle.putString(VisaInfoBottomSheet.KEY_CARD_TYPE, z2 ? str : SDKConstants.GA_NEW_DC);
        if (z) {
            if (!this.creditCard) {
                str = SDKConstants.GA_NEW_DC;
            }
            SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_INFO_CLICKED, SDKConstants.GA_REPEAT, str));
            bundle.putString(VisaInfoBottomSheet.KEY_INFO_MESSAGE, GTMLoader.getString(SDKConstants.KEY_SCP_ENABLED_INFO_DESCRIPTION));
            bundle.putString(VisaInfoBottomSheet.KEY_INFO_NOTE, GTMLoader.getString(SDKConstants.KEY_SCP_ENABLED_INFO_NOTE));
            bundle.putString(VisaInfoBottomSheet.KEY_FLOW_TYPE, SDKConstants.GA_REPEAT);
        } else {
            if (!this.creditCard) {
                str = SDKConstants.GA_NEW_DC;
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
