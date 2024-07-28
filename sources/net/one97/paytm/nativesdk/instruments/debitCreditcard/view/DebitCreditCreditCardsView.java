package net.one97.paytm.nativesdk.instruments.debitCreditcard.view;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.b;
import androidx.databinding.f;
import androidx.fragment.app.q;
import androidx.lifecycle.z;
import androidx.localbroadcastmanager.a.a;
import com.alipay.mobile.h5container.api.H5Param;
import com.bumptech.glide.e.h;
import com.bumptech.glide.load.b.j;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ConvenienceFeeController;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.helpers.GTMLoader;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.common.model.SavedInstruments;
import net.one97.paytm.nativesdk.databinding.DebitCreditCardLayoutBinding;
import net.one97.paytm.nativesdk.databinding.SaveCardLayoutBinding;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.listeners.DebitCreditCardListener;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.listeners.SetOnEmiClickListener;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.EmiChannelInfo;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.view.AddMoneyFeeBottomSheet;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.view.EmiDetailsBottomSheet;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.viewmodel.DebitCreditCardViewModel;
import net.one97.paytm.nativesdk.instruments.netbanking.view.NetBankingProvidersActivity;
import net.one97.paytm.nativesdk.instruments.savedCard.view.SavedCardView;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;
import net.one97.paytm.nativesdk.paymethods.listeners.UpiEncouragementListener;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public class DebitCreditCreditCardsView extends PaytmBaseView implements DebitCreditCardListener, AddMoneyFeeBottomSheet.AddMoneyBottomSheetListener, EmiDetailsBottomSheet.EmiConvenienceFeeListener {
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (SDKConstants.UNCHECK_VIEWS_ACTION_FILTER.equalsIgnoreCase(intent.getAction())) {
                if (DebitCreditCreditCardsView.this.debitCreditCardViewModel != null) {
                    DebitCreditCreditCardsView.this.debitCreditCardViewModel.uncheckLastCardSelected();
                }
            } else if (SDKConstants.UNREGISTER_BROADCAST.equalsIgnoreCase(intent.getAction())) {
                DebitCreditCreditCardsView.this.unregisterBroadCast(context);
            } else if (SDKConstants.REFRESH_LAYOUT_FILTER.equalsIgnoreCase(intent.getAction())) {
                if (DebitCreditCreditCardsView.this.debitCreditCardViewModel != null) {
                    DebitCreditCreditCardsView.this.debitCreditCardViewModel.refreshSavedCards();
                }
            } else if (SDKConstants.NET_BANKING_ACTION_FILTER.equalsIgnoreCase(intent.getAction())) {
                PaytmBaseView paytmBaseView = DirectPaymentBL.getInstance().getPaytmBaseView();
                DebitCreditCreditCardsView debitCreditCreditCardsView = DebitCreditCreditCardsView.this;
                if (paytmBaseView == debitCreditCreditCardsView) {
                    String unused = debitCreditCreditCardsView.emiChannelCode = intent.getStringExtra(SDKConstants.CHANNEL_CODE);
                    String unused2 = DebitCreditCreditCardsView.this.emiChannelName = intent.getStringExtra(SDKConstants.CHANNEL_NAME);
                    String unused3 = DebitCreditCreditCardsView.this.emiType = intent.getStringExtra("emiType");
                    DebitCreditCreditCardsView.this.handleEmiBankSelection();
                    if (DebitCreditCreditCardsView.this.debitCreditCardViewModel != null) {
                        DebitCreditCreditCardsView.this.debitCreditCardViewModel.refreshConvenienceFee(DebitCreditCreditCardsView.this.emiType);
                        DebitCreditCreditCardsView.this.debitCreditCardViewModel.clearOffer();
                        DebitCreditCreditCardsView.this.debitCreditCardViewModel.crossClicked(DebitCreditCreditCardsView.this.debitCreditCardLayoutBinding.ivCross);
                    }
                }
            } else if (SDKConstants.EMI_REFRESH_FILTER.equalsIgnoreCase(intent.getAction())) {
                if (!DebitCreditCreditCardsView.this.isEmiView) {
                    if (DebitCreditCreditCardsView.this.debitCreditCardViewModel != null) {
                        DebitCreditCreditCardsView.this.debitCreditCardViewModel.refreshEmiInfo();
                    }
                    DebitCreditCreditCardsView.this.refershSavedCardsView();
                } else if (DebitCreditCreditCardsView.this.emiChannelInfo != null) {
                    DebitCreditCreditCardsView.this.debitCreditCardLayoutBinding.txtSelectEmiPlan.setText(context.getResources().getString(R.string.native_emi_detail, new Object[]{DebitCreditCreditCardsView.this.emiChannelInfo.getEmiPerMonth(), DebitCreditCreditCardsView.this.emiChannelInfo.getOfMonths()}));
                }
            } else if (SavedCardView.SAVED_CARD_SELECTED.equalsIgnoreCase(intent.getAction())) {
                DebitCreditCreditCardsView.this.debitCreditCardViewModel.hideNewCardInfo();
            }
        }
    };
    private boolean creditCard;
    /* access modifiers changed from: private */
    public DebitCreditCardLayoutBinding debitCreditCardLayoutBinding;
    /* access modifiers changed from: private */
    public DebitCreditCardViewModel debitCreditCardViewModel;
    /* access modifiers changed from: private */
    public String emiChannelCode;
    /* access modifiers changed from: private */
    public EmiChannelInfo emiChannelInfo;
    /* access modifiers changed from: private */
    public String emiChannelName = "";
    /* access modifiers changed from: private */
    public String emiType;
    /* access modifiers changed from: private */
    public boolean isEmiView;
    private boolean isWalletDisabled = false;
    private BroadcastReceiver networkConnectivityReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equalsIgnoreCase(intent.getAction()) && SDKUtility.isNetworkAvailable(context) && DebitCreditCreditCardsView.this.debitCreditCardViewModel != null) {
                DebitCreditCreditCardsView.this.debitCreditCardViewModel.fetchCardDetails();
            }
        }
    };
    /* access modifiers changed from: private */
    public int prevEmiSelectedPosition = -1;
    private ProgressDialog progressDialog;
    private LinearLayout saveCardsContainer;
    private VpaBankAccountDetail vpaDetail;

    public void atmRadioChecked(boolean z) {
    }

    public void clearRadioGroup() {
    }

    public void refreshLayout() {
        this.debitCreditCardViewModel.refreshLayout(this.emiChannelCode, this.emiChannelName, this.emiType);
        if (this.debitCreditCardViewModel.isFetchBinCompleted.getValue() != null && this.debitCreditCardViewModel.isFetchBinCompleted.getValue().booleanValue() && !TextUtils.isEmpty(this.debitCreditCardViewModel.bankCode)) {
            showUpiPayOption();
        }
    }

    /* access modifiers changed from: private */
    public void handleEmiBankSelection() {
        if (SDKConstants.ZEST_MONEY_CHANNEL_CODE.equalsIgnoreCase(this.emiChannelCode)) {
            RoboTextView roboTextView = this.debitCreditCardLayoutBinding.txtEmiSelectBank;
            roboTextView.setText(this.emiChannelName + " NBFC");
            this.debitCreditCardLayoutBinding.txtSelectEmiPlan.setText(this.context.getResources().getString(R.string.select_emi_plan));
            this.debitCreditCardLayoutBinding.emiSavedCardsContainer.removeAllViews();
            this.debitCreditCardViewModel.payWithNewDebitCardVisibility.set(8);
            this.debitCreditCardViewModel.newCardContainerVisibilty.set(0);
            this.debitCreditCardLayoutBinding.selectEmiPlanLayout.setVisibility(8);
            this.debitCreditCardLayoutBinding.llNewCardLayout.setVisibility(8);
            this.debitCreditCardLayoutBinding.otpTopLayout.setVisibility(8);
            this.debitCreditCardLayoutBinding.llSaveCard.setVisibility(8);
            this.debitCreditCardViewModel.addMoneySaveCardVisibility.set(false);
            this.debitCreditCardViewModel.setZestMoneyTransaction(true);
            this.debitCreditCardLayoutBinding.btnProceed.setVisibility(0);
            this.debitCreditCardLayoutBinding.emiSavedCardsTopLayout.setVisibility(8);
            this.debitCreditCardLayoutBinding.emiSavedCardsContainer.removeAllViews();
            return;
        }
        this.debitCreditCardViewModel.setZestMoneyTransaction(false);
        clearEmiDetails();
        if (SDKConstants.BAJAJ_FINSERVER_CHANNEL_CODE.equalsIgnoreCase(this.emiChannelCode)) {
            Toast.makeText(this.context, "Paytm Wallet and BAJAJ FINSERV EMI CARD cannot be used together for this payment", 1).show();
            enableDisableCvv(false);
            disableWallet();
        } else {
            enableDisableCvv(true);
            enableWallet();
        }
        this.emiChannelInfo = null;
        this.prevEmiSelectedPosition = -1;
        this.debitCreditCardViewModel.setEmiType(this.emiType);
        this.debitCreditCardLayoutBinding.selectEmiPlanLayout.setVisibility(0);
        this.debitCreditCardLayoutBinding.llNewCardLayout.setVisibility(0);
        this.debitCreditCardLayoutBinding.llSaveCard.setVisibility(8);
        if (TextUtils.isEmpty(this.emiType)) {
            this.debitCreditCardLayoutBinding.txtEmiSelectBank.setText(this.emiChannelName);
        } else if (this.emiType.equalsIgnoreCase(SDKConstants.CREDIT)) {
            RoboTextView roboTextView2 = this.debitCreditCardLayoutBinding.txtEmiSelectBank;
            roboTextView2.setText(this.emiChannelName + " Credit Card");
        } else if (this.emiType.equalsIgnoreCase(SDKConstants.DEBIT)) {
            RoboTextView roboTextView3 = this.debitCreditCardLayoutBinding.txtEmiSelectBank;
            roboTextView3.setText(this.emiChannelName + " Debit Card");
        } else if (this.emiType.equalsIgnoreCase("NBFC")) {
            RoboTextView roboTextView4 = this.debitCreditCardLayoutBinding.txtEmiSelectBank;
            roboTextView4.setText(this.emiChannelName + " NBFC");
        }
        if (SDKConstants.BAJAJ_FINSERVER_CHANNEL_CODE.equalsIgnoreCase(this.emiChannelCode)) {
            this.debitCreditCardLayoutBinding.txtEmiSelectBank.setText(this.emiChannelName);
        }
        this.debitCreditCardLayoutBinding.txtSelectEmiPlan.setText(this.context.getResources().getString(R.string.select_emi_plan));
        this.debitCreditCardViewModel.showSavedCards(this.emiChannelCode);
    }

    private void disableWallet() {
        try {
            Intent intent = new Intent();
            intent.setAction(SDKConstants.DISABLE_WALLET_UPI_COLLECT);
            a.a(this.context).a(intent);
            this.isWalletDisabled = true;
        } catch (Exception unused) {
        }
    }

    private void enableWallet() {
        try {
            Intent intent = new Intent();
            intent.setAction(SDKConstants.ENABLE_WALLET_UPI_COLLECT);
            a.a(this.context).a(intent);
            this.isWalletDisabled = false;
        } catch (Exception unused) {
        }
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

    public DebitCreditCreditCardsView(Context context, boolean z, boolean z2, Instruments instruments, LinearLayout linearLayout) {
        super(instruments);
        this.saveCardsContainer = linearLayout;
        this.context = context;
        this.creditCard = z;
        this.isEmiView = z2;
        this.progressDialog = new ProgressDialog(context);
        this.progressDialog.setTitle(this.context.getResources().getString(R.string.please_wait));
        if (this.broadcastReceiver != null) {
            registerReciever(this.context, this.broadcastReceiver);
            if (this.isEmiView) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(SDKConstants.NET_BANKING_ACTION_FILTER);
                intentFilter.addAction(SDKConstants.EMI_REFRESH_FILTER);
                intentFilter.addAction(SavedCardView.SAVED_CARD_SELECTED);
                a.a(this.context.getApplicationContext()).a(this.broadcastReceiver, intentFilter);
            }
        }
        if (this.context != null) {
            this.context.registerReceiver(this.networkConnectivityReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    public PaytmBaseView getDebitCreditCardsView(List<SavedInstruments> list) {
        this.debitCreditCardLayoutBinding = (DebitCreditCardLayoutBinding) f.a((LayoutInflater) this.context.getSystemService("layout_inflater"), R.layout.debit_credit_card_layout, (ViewGroup) null, false);
        this.debitCreditCardLayoutBinding.tvBankOffer.setMovementMethod(LinkMovementMethod.getInstance());
        this.debitCreditCardLayoutBinding.tvBankOfferBottom.setMovementMethod(LinkMovementMethod.getInstance());
        this.debitCreditCardLayoutBinding.tvConvFee.setMovementMethod(LinkMovementMethod.getInstance());
        this.debitCreditCardLayoutBinding.selectBankLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(DebitCreditCreditCardsView.this.context, NetBankingProvidersActivity.class);
                intent.putExtra("fromemi", true);
                intent.putExtra("a", true);
                intent.putExtra(CJRPGTransactionRequestUtils.PAYER_BANK_NAME, DebitCreditCreditCardsView.this.emiChannelName);
                DebitCreditCreditCardsView.this.context.startActivity(intent);
            }
        });
        this.debitCreditCardLayoutBinding.selectEmiPlanLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (TextUtils.isEmpty(DebitCreditCreditCardsView.this.emiChannelCode)) {
                    Toast.makeText(DebitCreditCreditCardsView.this.context, DebitCreditCreditCardsView.this.context.getResources().getString(R.string.select_bank), 0).show();
                } else if (!DebitCreditCreditCardsView.this.debitCreditCardViewModel.isCardNumberInvalid()) {
                    EmiDetailsBottomSheet instance = EmiDetailsBottomSheet.getInstance(DebitCreditCreditCardsView.this.emiChannelCode, DebitCreditCreditCardsView.this.emiType, (String) null, DebitCreditCreditCardsView.this.debitCreditCardViewModel.getCardNumber(), DebitCreditCreditCardsView.this.prevEmiSelectedPosition, DebitCreditCreditCardsView.this.debitCreditCardViewModel.getEmiConvenienceFee(), DebitCreditCreditCardsView.this.debitCreditCardViewModel.getCardHash(), DebitCreditCreditCardsView.this.debitCreditCardViewModel.getInstantDiscount(), new SetOnEmiClickListener() {
                        public void onClick(EmiChannelInfo emiChannelInfo, int i2, String str) {
                            int unused = DebitCreditCreditCardsView.this.prevEmiSelectedPosition = i2;
                            new DecimalFormat(".##");
                            EmiChannelInfo unused2 = DebitCreditCreditCardsView.this.emiChannelInfo = emiChannelInfo;
                            DirectPaymentBL.getInstance().setEmiViewSelectedEmiChannelInfo(DebitCreditCreditCardsView.this.emiChannelInfo);
                            DebitCreditCreditCardsView.this.debitCreditCardViewModel.setEmiChannelInfo(DebitCreditCreditCardsView.this.emiChannelInfo);
                            DebitCreditCreditCardsView.this.debitCreditCardLayoutBinding.emiSavedCardsContainer.setTag(DebitCreditCreditCardsView.this.emiChannelInfo);
                            DebitCreditCreditCardsView.this.debitCreditCardLayoutBinding.txtSelectEmiPlan.setText(DebitCreditCreditCardsView.this.context.getResources().getString(R.string.native_emi_detail, new Object[]{DebitCreditCreditCardsView.this.emiChannelInfo.getEmiPerMonth(), DebitCreditCreditCardsView.this.emiChannelInfo.getOfMonths()}));
                            DebitCreditCreditCardsView.this.debitCreditCardLayoutBinding.llSaveCard.setVisibility(0);
                            DebitCreditCreditCardsView.this.debitCreditCardLayoutBinding.txtEmiSelectBank.setText(DebitCreditCreditCardsView.this.emiChannelName);
                            DirectPaymentBL.getInstance().setLastRadioChecked((SaveCardLayoutBinding) null);
                        }
                    }, DebitCreditCreditCardsView.this);
                    q a2 = ((AppCompatActivity) DebitCreditCreditCardsView.this.context).getSupportFragmentManager().a();
                    a2.a("emisheet");
                    instance.show(a2, (String) null);
                }
            }
        });
        if (!SDKUtils.isRiskConvFeeApplicableScheme(this.creditCard ? SDKConstants.CREDIT : SDKConstants.DEBIT)) {
            SDKUtility.handlePromotionVisibility(this.debitCreditCardLayoutBinding.tvPromotion, 0);
        } else {
            SDKUtility.handlePromotionVisibility(this.debitCreditCardLayoutBinding.tvPromotion, 8);
        }
        this.debitCreditCardLayoutBinding.etExpiryValidity.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, final boolean z) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if (z && DebitCreditCreditCardsView.this.debitCreditCardViewModel.isCardNumberInvalid()) {
                            DebitCreditCreditCardsView.this.debitCreditCardLayoutBinding.etCardNumber.requestFocus();
                        }
                    }
                }, 200);
            }
        });
        this.debitCreditCardLayoutBinding.etCvv.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, final boolean z) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if (z && DebitCreditCreditCardsView.this.debitCreditCardViewModel.isExiparyInvalid()) {
                            DebitCreditCreditCardsView.this.debitCreditCardLayoutBinding.etExpiryValidity.requestFocus();
                        }
                    }
                }, 200);
            }
        });
        this.debitCreditCardLayoutBinding.iconVscpInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DebitCreditCreditCardsView.this.inflateInfoBottomSheet(true);
            }
        });
        this.debitCreditCardViewModel = new DebitCreditCardViewModel(this.context, this.creditCard, this.isEmiView, this);
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
        this.debitCreditCardLayoutBinding.setDebitCardModel(this.debitCreditCardViewModel);
        this.debitCreditCardLayoutBinding.tvOneClickMsg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (DebitCreditCreditCardsView.this.debitCreditCardLayoutBinding.cbOneClick.isChecked()) {
                    DebitCreditCreditCardsView.this.debitCreditCardViewModel.isSingleVisaClickChecked.set(false);
                } else {
                    DebitCreditCreditCardsView.this.debitCreditCardViewModel.isSingleVisaClickChecked.set(true);
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
                DebitCreditCreditCardsView.this.inflateInfoBottomSheet(false);
            }
        });
        this.view = this.debitCreditCardLayoutBinding.getRoot();
        this.debitCreditCardLayoutBinding.upiPayOption.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventUPI(SDKConstants.GA_UPI_ENCOURAGEMENT, SDKConstants.UPI_NEW_DC_ADDED, MerchantBL.getMerchantInstance().getOrderId(), DebitCreditCreditCardsView.this.debitCreditCardViewModel.bankName, MerchantBL.getMerchantInstance().getMid()));
                DebitCreditCreditCardsView.this.onUpiPayClick();
            }
        });
        this.debitCreditCardLayoutBinding.tvUpiCheckbox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DebitCreditCreditCardsView.this.debitCreditCardViewModel.upiConsentChecked.set(!DebitCreditCreditCardsView.this.debitCreditCardViewModel.upiConsentChecked.get());
            }
        });
        this.debitCreditCardLayoutBinding.cbUpiCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                DebitCreditCreditCardsView.this.debitCreditCardViewModel.upiConsentChecked.set(z);
            }
        });
        this.debitCreditCardViewModel.isFetchBinCompleted.observe((androidx.lifecycle.q) this.context, new z<Boolean>() {
            public void onChanged(Boolean bool) {
                if (bool.booleanValue()) {
                    DebitCreditCreditCardsView.this.showUpiConsentCheckbox();
                } else {
                    DebitCreditCreditCardsView.this.hideUpiConsentCheckbox();
                }
            }
        });
        return this;
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
        if ((DirectPaymentBL.getInstance().getPaytmBaseView() instanceof DebitCreditCreditCardsView) && isSelected()) {
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
            new TransactionProcessor(this.context, "upi_push", paymentInstrument).startTransaction(this.debitCreditCardLayoutBinding.btnProceed);
        }
    }

    /* access modifiers changed from: private */
    public void showUpiConsentCheckbox() {
        if (SDKConstants.DEBIT.equalsIgnoreCase(this.debitCreditCardViewModel.getBinPaymentMode()) && this.debitCreditCardViewModel.bankCode != null) {
            if (SDKUtils.isToShowUpiConsent(this.debitCreditCardViewModel.bankCode)) {
                this.debitCreditCardViewModel.upiCheckboxVisibility.set(0);
                this.debitCreditCardViewModel.upiConsentChecked.set(true);
                TextView textView = this.debitCreditCardLayoutBinding.tvUpiCheckbox;
                Context context = this.context;
                int i2 = R.string.native_upi_consent_text;
                textView.setText(context.getString(i2, new Object[]{this.debitCreditCardViewModel.bankCode + " Bank"}));
                return;
            }
            hideUpiConsentCheckbox();
            showUpiPayOption();
        }
    }

    /* access modifiers changed from: private */
    public void hideUpiConsentCheckbox() {
        this.debitCreditCardViewModel.upiCheckboxVisibility.set(8);
        this.debitCreditCardLayoutBinding.cbUpiCheckbox.setChecked(false);
        this.debitCreditCardViewModel.upiConsentChecked.set(false);
    }

    private void hideUpiPayOption() {
        this.debitCreditCardViewModel.upiPayOptionVisibility.set(8);
    }

    private void showUpiPayOption() {
        this.vpaDetail = SDKUtils.isToShowUpiPayOption(this.debitCreditCardViewModel.bankCode, this.context);
        VpaBankAccountDetail vpaBankAccountDetail = this.vpaDetail;
        if ((vpaBankAccountDetail == null || vpaBankAccountDetail.getBankMetaData() == null || TextUtils.isEmpty(this.vpaDetail.getBankMetaData().getPerTxnLimit()) || Double.parseDouble(this.vpaDetail.getBankMetaData().getPerTxnLimit()) >= SDKUtility.getDiffAmount()) && SDKConstants.DEBIT.equalsIgnoreCase(this.debitCreditCardViewModel.getBinPaymentMode()) && SDKUtility.isPaytmApp(this.context) && SDKUtility.isUpiPushEnabled() && this.vpaDetail != null) {
            this.debitCreditCardViewModel.upiPayOptionVisibility.set(0);
            TextView textView = this.debitCreditCardLayoutBinding.upiPayText;
            Context context = this.context;
            int i2 = R.string.native_upi_option_text;
            textView.setText(context.getString(i2, new Object[]{this.debitCreditCardViewModel.bankCode + " Bank"}));
            return;
        }
        hideUpiPayOption();
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

    public void openAutoInstrument(boolean z) {
        this.debitCreditCardViewModel.debitCardViewClicked((View) null);
        isOnceClicked = true;
    }

    private void enableDisableView(View view, boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        Drawable a2 = b.a(this.context, R.drawable.grey_background_with_border);
        Drawable a3 = b.a(this.context, R.drawable.white_background_with_border);
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
        com.bumptech.glide.b.b(this.context).a(Integer.valueOf(i2)).b((com.bumptech.glide.e.a<?>) ((h) new h().a(80, 80)).a(j.f6875a)).a(this.debitCreditCardLayoutBinding.ivCardLogo);
    }

    public void updateNewCardImage(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.debitCreditCardLayoutBinding.ivCardLogo.setVisibility(0);
            com.bumptech.glide.b.b(this.context).a(str).b((com.bumptech.glide.e.a<?>) ((h) new h().a(80, 80)).a(j.f6875a)).a(this.debitCreditCardLayoutBinding.ivCardLogo);
        }
    }

    /* access modifiers changed from: private */
    public void refershSavedCardsView() {
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

    public void addSavedCard(View view) {
        if (this.isEmiView) {
            this.debitCreditCardLayoutBinding.emiSavedCardsTopLayout.setVisibility(0);
            this.debitCreditCardLayoutBinding.emiSavedCardsContainer.addView(view);
            return;
        }
        LinearLayout linearLayout = this.saveCardsContainer;
        if (linearLayout != null) {
            linearLayout.addView(view);
        }
    }

    public void clearSavedCard() {
        this.debitCreditCardLayoutBinding.cardContainer.removeAllViews();
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
        this.debitCreditCardLayoutBinding.oneClickContainer.clearAnimation();
        changeCvvRequiredNotRequired(true);
        changeCvvRequiredNotRequired(true);
        if (!SDKUtils.isRiskConvFeeApplicableScheme(this.creditCard ? SDKConstants.CREDIT : SDKConstants.DEBIT)) {
            SDKUtility.handlePromotionVisibility(this.debitCreditCardLayoutBinding.tvPromotion, 0);
        }
    }

    public void closeView() {
        this.debitCreditCardViewModel.hideAllLayouts();
        this.debitCreditCardLayoutBinding.ivRightArrow.setImageResource(R.drawable.ic_right_chevron_dark);
        this.debitCreditCardLayoutBinding.txtDebitCreditCard.setTypeface((Typeface) null, 0);
        SDKUtility.collapse(this.debitCreditCardLayoutBinding.newCardContainer);
        closeKeyboard();
        this.emiChannelCode = "";
        this.emiChannelName = "";
        this.prevEmiSelectedPosition = -1;
        if (this.isEmiView) {
            enableWallet();
        }
        DirectPaymentBL.getInstance().setEmiViewSelectedEmiChannelInfo((EmiChannelInfo) null);
        if (!SDKUtils.isRiskConvFeeApplicableScheme(this.creditCard ? SDKConstants.CREDIT : SDKConstants.DEBIT)) {
            SDKUtility.handlePromotionVisibility(this.debitCreditCardLayoutBinding.tvPromotion, 0);
        } else {
            SDKUtility.handlePromotionVisibility(this.debitCreditCardLayoutBinding.tvPromotion, 8);
        }
    }

    public void cardClicked() {
        DirectPaymentBL.getInstance().closeOpnedView();
        DirectPaymentBL.getInstance().setPaytmBaseView(this);
        SDKUtility.handlePromotionVisibility(this.debitCreditCardLayoutBinding.tvPromotion, 8);
        SDKUtility.expand(this.debitCreditCardLayoutBinding.newCardContainer, (Integer) null);
        if (SDKUtility.isAppInvokeFlow()) {
            String str = this.debitCreditCardViewModel.isCreditCardLayout() ? SDKConstants.AI_KEY_NEW_CC : SDKConstants.AI_KEY_NEW_DC;
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAYMODE_CLICKED, str, H5Param.DEFAULT_LONG_PRESSO_LOGIN));
            if (DirectPaymentBL.getInstance().getPaymentFlowAvailable().equals(SDKConstants.ADDANDPAY) && DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
                SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAYMODE_ADDANDPAY_CLICKED, str));
            }
        }
    }

    public void changeArrowIcon(boolean z) {
        if (z) {
            this.debitCreditCardLayoutBinding.ivRightArrow.setImageResource(R.drawable.ic_down_chevron_dark);
            this.debitCreditCardLayoutBinding.txtDebitCreditCard.setTypeface((Typeface) null, 1);
            return;
        }
        this.debitCreditCardLayoutBinding.ivRightArrow.setImageResource(R.drawable.ic_right_chevron_dark);
        this.debitCreditCardLayoutBinding.txtDebitCreditCard.setTypeface((Typeface) null, 0);
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

    public void showHideAnimation(View view, boolean z) {
        if (!z && isOnceClicked) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ObjectAnimator.ofInt(DebitCreditCreditCardsView.this.instruments.getScrollView(), "scrollY", new int[]{(int) DebitCreditCreditCardsView.this.getView().getY()}).setDuration(500).start();
                }
            }, 200);
        }
    }

    public void scrollTo(final View view) {
        if (isOnceClicked) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ObjectAnimator.ofInt(DebitCreditCreditCardsView.this.instruments.getScrollView(), "scrollY", new int[]{((int) (((View) view.getParent()).getY() + view.getY())) - 50}).setDuration(500).start();
                }
            }, 200);
        }
    }

    public void scrollTo(final int i2) {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                ObjectAnimator.ofInt(DebitCreditCreditCardsView.this.instruments.getScrollView(), "scrollY", new int[]{i2}).setDuration(500).start();
            }
        }, 200);
    }

    public void changeCardUi(boolean z, int i2) {
        String str = "Credit Card";
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    if (z) {
                        if (this.debitCreditCardLayoutBinding.etCvv.isEnabled()) {
                            this.debitCreditCardLayoutBinding.tvCvv.setText(this.context.getResources().getString(R.string.native_enter_valid_cvv));
                            this.debitCreditCardLayoutBinding.tvCvv.setTextColor(Color.parseColor("#fd5c5c"));
                            this.debitCreditCardLayoutBinding.etCvv.setBackgroundResource(R.drawable.edit_text_error_bg);
                        } else {
                            this.debitCreditCardLayoutBinding.txtErrMsg.setText(this.context.getResources().getString(R.string.native_enter_valid_cvv));
                            this.debitCreditCardLayoutBinding.txtErrMsg.setTextColor(Color.parseColor("#fd5c5c"));
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
                this.debitCreditCardLayoutBinding.tvExipary.setTextColor(Color.parseColor("#fd5c5c"));
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
            this.debitCreditCardLayoutBinding.tvEnterCardNumber.setTextColor(Color.parseColor("#fd5c5c"));
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

    public void clearEmiDetails() {
        this.debitCreditCardLayoutBinding.txtSelectEmiPlan.setText(this.context.getResources().getString(R.string.select_emi_plan));
        this.debitCreditCardLayoutBinding.txtEmiSelectBank.setText(this.context.getResources().getString(R.string.select_bank));
        this.debitCreditCardLayoutBinding.emiSavedCardsContainer.removeAllViews();
        this.debitCreditCardLayoutBinding.emiSavedCardsTopLayout.setVisibility(8);
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
        this.debitCreditCardLayoutBinding.tvPromoMessage.setBackgroundColor(Color.parseColor("#e8f8f1"));
        this.debitCreditCardLayoutBinding.tvPromoMessage.setTextColor(Color.parseColor("#222222"));
    }

    public void animateOneClickContainer() {
        RelativeLayout relativeLayout = this.debitCreditCardLayoutBinding.oneClickContainer;
        relativeLayout.startAnimation(AnimationUtils.loadAnimation(relativeLayout.getContext(), R.anim.shake_animation));
    }

    public void showRiskConvenienceFeeInfo(String str, String str2, String str3) {
        AddMoneyFeeBottomSheet instance = AddMoneyFeeBottomSheet.Companion.getInstance(str, str2, str3);
        if (this.context instanceof AppCompatActivity) {
            instance.show(((AppCompatActivity) this.context).getSupportFragmentManager(), AddMoneyFeeBottomSheet.TAG);
            instance.setCallbackListener(this);
        }
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

    public void hidePaymentsLoader() {
        DebitCreditCardLayoutBinding debitCreditCardLayoutBinding2;
        DebitCreditCardViewModel debitCreditCardViewModel2 = this.debitCreditCardViewModel;
        if (!(debitCreditCardViewModel2 == null || (debitCreditCardLayoutBinding2 = this.debitCreditCardLayoutBinding) == null)) {
            debitCreditCardViewModel2.hidePaymentProgressbar(debitCreditCardLayoutBinding2.btnProceed);
        }
        LinearLayout linearLayout = this.saveCardsContainer;
        if (linearLayout != null && linearLayout.getChildCount() > 0) {
            for (int i2 = 0; i2 < this.saveCardsContainer.getChildCount(); i2++) {
                this.debitCreditCardViewModel.hidePaymentProgressbar(this.saveCardsContainer.getChildAt(i2).findViewById(R.id.btnProceed));
            }
        }
        DebitCreditCardLayoutBinding debitCreditCardLayoutBinding3 = this.debitCreditCardLayoutBinding;
        if (debitCreditCardLayoutBinding3 != null && debitCreditCardLayoutBinding3.emiSavedCardsContainer != null && this.debitCreditCardLayoutBinding.emiSavedCardsContainer.getChildCount() > 0) {
            for (int i3 = 0; i3 < this.debitCreditCardLayoutBinding.emiSavedCardsContainer.getChildCount(); i3++) {
                this.debitCreditCardViewModel.hidePaymentProgressbar(this.debitCreditCardLayoutBinding.emiSavedCardsContainer.getChildAt(i3).findViewById(R.id.btnProceed));
            }
        }
    }

    public boolean isEmiView() {
        return this.isEmiView;
    }

    public void onDestroy() {
        super.onDestroy();
        unregisterBroadCast(this.context);
        if (this.context != null) {
            this.context.unregisterReceiver(this.networkConnectivityReceiver);
        }
    }

    public void enableProceedButton() {
        this.debitCreditCardLayoutBinding.btnProceed.setEnabled(true);
        this.debitCreditCardLayoutBinding.btnProceed.setClickable(true);
    }

    public void disableProceedButton() {
        this.debitCreditCardLayoutBinding.btnProceed.setEnabled(false);
        this.debitCreditCardLayoutBinding.btnProceed.setClickable(false);
    }

    public void startCheckingOfferAnimation() {
        SDKUtility.startAnimation(this.debitCreditCardLayoutBinding.ltvGetOffers);
    }

    public void stopCheckingOfferAnimation() {
        SDKUtility.stopAnimation(this.debitCreditCardLayoutBinding.ltvGetOffers);
    }

    public void changeOfferTextBgColor(int i2, int i3, boolean z) {
        this.debitCreditCardLayoutBinding.tvBankOfferBottom.setBackgroundColor(i2);
        this.debitCreditCardLayoutBinding.tvBankOfferBottom.setTextColor(i3);
        this.debitCreditCardLayoutBinding.tvBankOffer.setBackgroundColor(i2);
        this.debitCreditCardLayoutBinding.tvBankOffer.setTextColor(i3);
        SDKUtility.setPaddingBankOffer(this.debitCreditCardLayoutBinding.tvBankOffer, z, this.context, 15, 26, 10, 10);
    }

    public void onAddMoneyProceedClicked() {
        this.debitCreditCardViewModel.proceedClicked(this.debitCreditCardLayoutBinding.btnProceed, false);
    }

    public LinearLayout getSaveCardsContainer() {
        return this.saveCardsContainer;
    }

    public Object getVerifyResponseModel() {
        return this.debitCreditCardViewModel.getVerifyResponseModel();
    }

    public void setEmiConvenienceFeeResponse(Object obj, ArrayList<PaymentIntent> arrayList, String str) {
        this.debitCreditCardViewModel.setPaymentIntents(arrayList);
        this.debitCreditCardViewModel.setAggregatePgConvFee(str);
        this.debitCreditCardViewModel.configureConvFeeView();
    }
}
