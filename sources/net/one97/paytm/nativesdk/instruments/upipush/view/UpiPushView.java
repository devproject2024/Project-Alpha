package net.one97.paytm.nativesdk.instruments.upipush.view;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.b;
import androidx.databinding.f;
import androidx.localbroadcastmanager.a.a;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Param;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.HealthType;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.app.UpiPushCallbackListener;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.model.CustomVolleyError;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.model.RiskConvenienceFeeItem;
import net.one97.paytm.nativesdk.databinding.SingleVpaLayoutBinding;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.view.AddMoneyFeeBottomSheet;
import net.one97.paytm.nativesdk.instruments.upipush.callbacks.SetOnUpiPushListener;
import net.one97.paytm.nativesdk.instruments.upipush.model.BankHealth;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;
import net.one97.paytm.nativesdk.instruments.upipush.viewmodel.UpiPushViewModel;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;

public class UpiPushView extends PaytmBaseView implements UpiPushCallbackListener.CheckBalanceListener, AddMoneyFeeBottomSheet.AddMoneyBottomSheetListener, SetOnUpiPushListener, UpiPushViewModel.BankOfferUpdateListener {
    public static final int REQUEST_CODE_UPI_CHECK_BALANCE = 233;
    public static final int REQUEST_CODE_UPI_SET_PIN = 234;
    protected double availableBalance;
    private boolean isUpiWarning = false;
    private SingleVpaLayoutBinding lastProceedButton;
    protected UpiPushViewModel model;
    private BroadcastReceiver networkConnectivityReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equalsIgnoreCase(intent.getAction()) && SDKUtility.isNetworkAvailable(context) && UpiPushView.this.model != null && UpiPushView.this.model.isSelected) {
                UpiPushView.this.model.fetchConvenienceFee();
            }
        }
    };
    private PaymentModes paymentModes;
    private BroadcastReceiver refreshUpiLimit = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (SDKConstants.REFRESH_UPI.equalsIgnoreCase(intent.getAction())) {
                UpiPushView.this.setSelected(false);
                UpiPushView.this.refreshLayout();
            }
        }
    };
    protected SingleVpaLayoutBinding singleVpaLayoutBinding;
    public String transactionErrorCode;
    /* access modifiers changed from: private */
    public VpaBankAccountDetail vpaDetail;

    public UpiPushView(Context context, VpaBankAccountDetail vpaBankAccountDetail, PaymentModes paymentModes2, Instruments instruments) {
        super(instruments);
        this.context = context;
        this.vpaDetail = vpaBankAccountDetail;
        this.paymentModes = paymentModes2;
        if (this.context != null) {
            this.context.registerReceiver(this.networkConnectivityReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(SDKConstants.REFRESH_UPI);
            a.a(this.context.getApplicationContext()).a(this.refreshUpiLimit, intentFilter);
        }
    }

    public void refreshLayout() {
        this.model.invalidatePaymentIntent();
        if (this.lastProceedButton != null) {
            clickOnLayout(true);
        } else {
            setHealthDataAndReturnIsEnabled(true);
        }
    }

    public void selectUpiEncouragementView() {
        this.singleVpaLayoutBinding.vpaTopLayout.performClick();
    }

    public String getPgBankCode() {
        VpaBankAccountDetail vpaBankAccountDetail = this.vpaDetail;
        if (vpaBankAccountDetail == null) {
            return null;
        }
        return vpaBankAccountDetail.getPgBankCode();
    }

    public PaytmBaseView getUpiPushView() {
        this.singleVpaLayoutBinding = (SingleVpaLayoutBinding) f.a((LayoutInflater) this.context.getSystemService("layout_inflater"), R.layout.single_vpa_layout, (ViewGroup) null, false);
        this.singleVpaLayoutBinding.tvBankOffer.setMovementMethod(LinkMovementMethod.getInstance());
        this.singleVpaLayoutBinding.tvConvFee.setMovementMethod(LinkMovementMethod.getInstance());
        this.model = new UpiPushViewModel(this.context, this.vpaDetail, this.paymentModes, this);
        this.model.setBankOfferUpdateListener(this);
        this.singleVpaLayoutBinding.setModel(this.model);
        this.view = this.singleVpaLayoutBinding.getRoot();
        this.singleVpaLayoutBinding.rbBankName.setText(this.vpaDetail.getBank());
        this.singleVpaLayoutBinding.txtAccount.setText(this.context.getResources().getString(R.string.vpa_account_number, new Object[]{SDKUtility.maskNumber(this.vpaDetail.getMaskedAccountNumber())}));
        this.singleVpaLayoutBinding.txtVpa.setText(this.context.getResources().getString(R.string.native_linked_to_vpa, new Object[]{this.vpaDetail.getName()}));
        this.singleVpaLayoutBinding.txtVpa.setVisibility(8);
        this.singleVpaLayoutBinding.vpaTopLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UpiPushView.this.clickOnLayout(false);
            }
        });
        this.singleVpaLayoutBinding.btnProceed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (DirectPaymentBL.getInstance().isRiskConvenienceFeeApplied(PayMethodType.UPI.name())) {
                    UpiPushView.this.showRiskConvFeeInfo();
                } else {
                    UpiPushView.this.onProceedClicked(view);
                }
            }
        });
        SDKUtility.handlePromotionVisibility(this.singleVpaLayoutBinding.tvPromotion, 0);
        setHealthDataAndReturnIsEnabled();
        return this;
    }

    /* access modifiers changed from: private */
    public void clickOnLayout(boolean z) {
        if (setHealthDataAndReturnIsEnabled(z)) {
            setSelected(true);
            if (SDKUtility.isAppInvokeFlow()) {
                if (isPPBLUpiPushView()) {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAYMODE_CLICKED, SDKConstants.AI_KEY_PPBL, H5Param.DEFAULT_LONG_PRESSO_LOGIN));
                    if (SDKConstants.ADDANDPAY.equals(DirectPaymentBL.getInstance().getPaymentFlowAvailable()) && DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
                        SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAYMODE_ADDANDPAY_CLICKED, SDKConstants.AI_KEY_PPBL));
                    }
                } else {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAYMODE_CLICKED, "UPI", H5Param.DEFAULT_LONG_PRESSO_LOGIN));
                    if (DirectPaymentBL.getInstance().getPaymentFlowAvailable().equals(SDKConstants.ADDANDPAY) && DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
                        SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAYMODE_ADDANDPAY_CLICKED, "UPI"));
                    }
                }
            }
            SingleVpaLayoutBinding singleVpaLayoutBinding2 = this.lastProceedButton;
            SingleVpaLayoutBinding singleVpaLayoutBinding3 = this.singleVpaLayoutBinding;
            if (singleVpaLayoutBinding2 == singleVpaLayoutBinding3) {
                setAmountIfNeeded(singleVpaLayoutBinding3);
                if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
                    this.model.getBankOffers();
                    return;
                }
                if (DirectPaymentBL.getInstance().getPaytmBaseView() instanceof PPBLUpiPushView) {
                    UpiPushViewModel upiPushViewModel = this.model;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.availableBalance);
                    if (!upiPushViewModel.checkIfAmountSufficient(sb.toString())) {
                        disableView();
                        openNextInstrument();
                        return;
                    }
                }
                this.model.fetchConvenienceFee();
                return;
            }
            if (DirectPaymentBL.getInstance().lastInsufficuentAmountError != null) {
                DirectPaymentBL.getInstance().lastInsufficuentAmountError.set("");
            }
            DirectPaymentBL.getInstance().closeOpnedView();
            SingleVpaLayoutBinding singleVpaLayoutBinding4 = this.lastProceedButton;
            if (!(singleVpaLayoutBinding4 == null || singleVpaLayoutBinding4 == this.singleVpaLayoutBinding)) {
                singleVpaLayoutBinding4.btnProceed.setVisibility(8);
                this.lastProceedButton.rbBankName.setChecked(false);
                this.lastProceedButton.rbBankName.setTypeface((Typeface) null, 0);
                this.lastProceedButton.txtamount.setVisibility(8);
            }
            this.singleVpaLayoutBinding.btnProceed.setVisibility(0);
            this.singleVpaLayoutBinding.rbBankName.setChecked(true);
            this.singleVpaLayoutBinding.rbBankName.setTypeface((Typeface) null, 1);
            this.lastProceedButton = this.singleVpaLayoutBinding;
            selectedView();
            setAmountIfNeeded(this.singleVpaLayoutBinding);
            SDKUtility.expand(this.singleVpaLayoutBinding.btnProceed, (Integer) null);
            if (!DirectPaymentBL.getInstance().isOpeningAuto()) {
                if (SDKConstants.GA_KEY_UPI.equalsIgnoreCase(DirectPaymentBL.getInstance().getDefaultSelectedPayOption())) {
                    if (SDKUtility.isHybridCase()) {
                        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_UPI, SDKConstants.GA_KEY_HYBRID));
                    } else {
                        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_UPI, SDKConstants.GA_KEY_DEFAULT));
                    }
                } else if (SDKUtility.isHybridCase()) {
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_UPI, SDKConstants.GA_KEY_HYBRID));
                } else {
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_UPI, SDKConstants.GA_KEY_NEW));
                }
            }
            this.model.setSelected();
        }
    }

    private boolean setHealthDataAndReturnIsEnabled() {
        return setHealthDataAndReturnIsEnabled(false);
    }

    private boolean setHealthDataAndReturnIsEnabled(boolean z) {
        this.transactionErrorCode = null;
        if (!SDKUtility.isUpiPushEnabled()) {
            setErrorMessageProperties(R.color.color_ff585d, this.context.getString(R.string.disable_paymode_error_message));
            disableView(z);
            return false;
        }
        BankHealth bankHealth = SDKUtils.getBankHealth(this.context, this.vpaDetail);
        if (bankHealth == null || bankHealth.getCategory() == null) {
            enableView();
            setDisabled(false);
            this.singleVpaLayoutBinding.tvInsufficientBalance.setVisibility(8);
        } else if (bankHealth.getCategory().equalsIgnoreCase(HealthType.RED.name())) {
            setErrorMessageProperties(R.color.red, bankHealth.getDisplayMsg());
            disableView(z);
            return false;
        } else {
            if (bankHealth.getCategory().equalsIgnoreCase(HealthType.YELLOW.name())) {
                setErrorMessageProperties(R.color.yellow_color, bankHealth.getDisplayMsg());
                this.isUpiWarning = true;
                enableView();
            } else {
                this.singleVpaLayoutBinding.tvInsufficientBalance.setVisibility(8);
                enableView();
            }
            if (this.vpaDetail.getBankMetaData() != null && !TextUtils.isEmpty(this.vpaDetail.getBankMetaData().getPerTxnLimit()) && Double.parseDouble(this.vpaDetail.getBankMetaData().getPerTxnLimit()) < SDKUtility.getDiffAmount()) {
                setErrorMessageProperties(R.color.red, this.context.getString(R.string.upi_limit_msg, new Object[]{this.vpaDetail.getBankMetaData().getPerTxnLimit()}));
                this.transactionErrorCode = SDKConstants.UPI_LIMIT_EXCEED_ERROR;
                disableView(z);
                return false;
            }
        }
        return true;
    }

    private void setErrorMessageProperties(int i2, String str) {
        this.singleVpaLayoutBinding.tvInsufficientBalance.setTextColor(b.c(this.context, i2));
        this.singleVpaLayoutBinding.tvInsufficientBalance.setText(str);
        this.singleVpaLayoutBinding.tvInsufficientBalance.setVisibility(0);
    }

    public void openAutoInstrument() {
        setSelected(true);
        if (setHealthDataAndReturnIsEnabled()) {
            this.singleVpaLayoutBinding.vpaTopLayout.performClick();
        }
    }

    public void closeView() {
        setSelected(false);
        clearAllSelection();
    }

    /* access modifiers changed from: private */
    public void showRiskConvFeeInfo() {
        RiskConvenienceFeeItem riskConvenienceFeeItem = DirectPaymentBL.getInstance().getRiskConvenienceFeeItem(PayMethodType.UPI.name());
        AddMoneyFeeBottomSheet instance = AddMoneyFeeBottomSheet.Companion.getInstance(riskConvenienceFeeItem.getFeePercent(), riskConvenienceFeeItem.getReason(), PayMethodType.UPI.name());
        if (this.context instanceof AppCompatActivity) {
            instance.show(((AppCompatActivity) this.context).getSupportFragmentManager(), AddMoneyFeeBottomSheet.TAG);
            instance.setCallbackListener(this);
        }
    }

    /* access modifiers changed from: private */
    public void onProceedClicked(View view) {
        if (DirectPaymentBL.getInstance().isUpiOnBoarded()) {
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventUPI(SDKConstants.GA_UPI_ONBOARDING, SDKConstants.GA_UPI_ONBOARDING_PAY_CLICKED, MerchantBL.getMerchantInstance().getOrderId(), this.vpaDetail.getBank(), MerchantBL.getMerchantInstance().getMid()));
            DirectPaymentBL.getInstance().setUpiOnBoarded(false);
        }
        if (SDKUtility.isAppInvokeFlow()) {
            if (isPPBLUpiPushView()) {
                SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAY_BUTTON_CLICKED, SDKConstants.AI_KEY_PPBL));
            } else {
                SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAY_BUTTON_CLICKED, "UPI"));
            }
        }
        if (SDKUtility.shouldShowValidatePromoError() && (this.model.applyPromoFailed || DirectPaymentBL.getInstance().getPaymentFlowBankOffer().equals(SDKConstants.ADDANDPAY))) {
            this.model.setValidatePromoText();
        } else if (DirectPaymentBL.getInstance().isSubsCriptionFlow() && DirectPaymentBL.getInstance().isWalletChecked() && !DirectPaymentBL.getInstance().isWalletOtpValidated() && this.context != null) {
            Toast.makeText(this.context, this.context.getString(R.string.otp_not_validated), 0).show();
        } else if (!SDKUtility.isNetworkAvailable(this.context)) {
            DialogUtility.showNoInternetDialog(this.context, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
        } else {
            if (!SDKUtility.isPaytmApp(this.context) || !SDKUtility.isUpiPushEnabled() || this.vpaDetail == null) {
                this.model.proceedClicked(this.vpaDetail, view);
            } else {
                SDKUtility.startUpiPush(this.context, this.vpaDetail, SDKConstants.PUSH_FROM_PUSH, this.model.getNetPayableAmount());
            }
            if (SDKConstants.GA_KEY_UPI.equalsIgnoreCase(DirectPaymentBL.getInstance().getDefaultSelectedPayOption())) {
                if (SDKUtility.isHybridCase()) {
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("pay_clicked", SDKConstants.GA_KEY_UPI, SDKConstants.GA_KEY_HYBRID));
                } else {
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("pay_clicked", SDKConstants.GA_KEY_UPI, SDKConstants.GA_KEY_DEFAULT));
                }
            } else if (SDKUtility.isHybridCase()) {
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("pay_clicked", SDKConstants.GA_KEY_UPI, SDKConstants.GA_KEY_HYBRID));
            } else {
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("pay_clicked", SDKConstants.GA_KEY_UPI, SDKConstants.GA_KEY_NEW));
            }
        }
    }

    private void setAmountIfNeeded(SingleVpaLayoutBinding singleVpaLayoutBinding2) {
        singleVpaLayoutBinding2.txtamount.setVisibility(8);
        this.model.setPaySecurelyText();
    }

    public void makeUpiPushPayment(String str, String str2, String str3) {
        PaymentInstrument paymentInstrument;
        if ((DirectPaymentBL.getInstance().getPaytmBaseView() instanceof UpiPushView) && this.model.isSelected) {
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
            this.model.cashBackTextVisibility.set(8);
            TransactionProcessor transactionProcessor = new TransactionProcessor(this.context, "upi_push", paymentInstrument);
            if (SDKUtility.isOfferValid(this.model.getPaymentOffer())) {
                transactionProcessor.setOfferBody(new com.google.gson.f().b(this.model.getPaymentOffer()));
            }
            transactionProcessor.setPaymentIntent(this.model.getPaymentIntent());
            transactionProcessor.startTransaction(this.singleVpaLayoutBinding.btnProceed);
        }
    }

    public void clearAllSelection() {
        SingleVpaLayoutBinding singleVpaLayoutBinding2 = this.lastProceedButton;
        if (singleVpaLayoutBinding2 != null) {
            singleVpaLayoutBinding2.btnProceed.setVisibility(8);
            this.lastProceedButton.rbBankName.setChecked(false);
            this.lastProceedButton.rbBankName.setTypeface((Typeface) null, 0);
            this.lastProceedButton.txtamount.setVisibility(8);
            SDKUtility.collapse(this.lastProceedButton.btnProceed);
            this.lastProceedButton = null;
        }
        UpiPushViewModel upiPushViewModel = this.model;
        upiPushViewModel.isSelected = false;
        upiPushViewModel.bankOfferVisibility.set(8);
        SDKUtility.handlePromotionVisibility(this.singleVpaLayoutBinding.tvPromotion, 0);
        this.model.convFeeTextVisibility.set(8);
        this.model.hideLoading();
    }

    public void selectedView() {
        DirectPaymentBL.getInstance().setPaytmBaseView(this);
        SDKUtility.handlePromotionVisibility(this.singleVpaLayoutBinding.tvPromotion, 8);
        if (isOnceClicked) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ObjectAnimator.ofInt(UpiPushView.this.instruments.getScrollView(), "scrollY", new int[]{(int) UpiPushView.this.singleVpaLayoutBinding.getRoot().getY()}).setDuration(500).start();
                }
            }, 200);
        }
        isOnceClicked = true;
        if (SDKUtility.isPaytmApp(this.context)) {
            this.singleVpaLayoutBinding.llCheckBalanceContainer.setVisibility(0);
        } else {
            this.singleVpaLayoutBinding.llCheckBalanceContainer.setVisibility(8);
        }
        updateCheckBalanceLayout();
    }

    public void onWalletStateChange() {
        hasSufficientBalance();
    }

    public void disableSelectedUpiPayOption(String str) {
        this.transactionErrorCode = str;
        if (SDKConstants.FGW_NOT_SUFFICIENT_FUNDS.equalsIgnoreCase(str)) {
            this.singleVpaLayoutBinding.tvInsufficientBalance.setText(this.context.getResources().getString(R.string.native_insufficent_balance));
            if (!SDKUtility.isHybridSupported() || SDKUtility.isHybridCase()) {
                disableView();
            } else {
                this.singleVpaLayoutBinding.tvInsufficientBalance.setVisibility(0);
            }
        } else if (SDKConstants.FGW_PIN_RETRY_LIMIT_BREACHED.equalsIgnoreCase(str)) {
            this.singleVpaLayoutBinding.tvInsufficientBalance.setText(this.context.getResources().getString(R.string.native_pin_upi_limit_breached));
            disableView();
        } else if ("196".equalsIgnoreCase(str)) {
            this.singleVpaLayoutBinding.tvInsufficientBalance.setText(this.context.getResources().getString(R.string.native_payment_limit_exceeds));
            disableView();
        }
    }

    public void updateCheckBalanceLayout() {
        if (this.availableBalance != 0.0d || (this instanceof PPBLUpiPushView)) {
            this.singleVpaLayoutBinding.tvCheckBalance.setText(Html.fromHtml(this.context.getString(R.string.nativesdk_balance, new Object[]{MerchantBL.getMerchantInstance().getWithoutDoubleAmount(this.availableBalance)})).toString());
            this.singleVpaLayoutBinding.tvCheckBalance.setTextColor(this.context.getResources().getColor(R.color.color_666666));
            this.singleVpaLayoutBinding.tvCheckBalance.setOnClickListener((View.OnClickListener) null);
            hasSufficientBalance();
            return;
        }
        this.singleVpaLayoutBinding.tvCheckBalance.setTextColor(this.context.getResources().getColor(R.color.color_00b9f5));
        if ("Y".equalsIgnoreCase(this.vpaDetail.getMpinSet())) {
            this.singleVpaLayoutBinding.tvCheckBalance.setText(this.context.getResources().getString(R.string.check_balance));
            this.singleVpaLayoutBinding.tvCheckBalance.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    UpiPushView.this.getBalance();
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.GA_CHECK_BALANCE_ACTION, UpiPushView.this.vpaDetail.getBank(), "UPI", "init", ""));
                }
            });
            return;
        }
        this.singleVpaLayoutBinding.tvCheckBalance.setText(this.context.getResources().getString(R.string.set_upi_pin));
        this.singleVpaLayoutBinding.tvCheckBalance.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UpiPushView.this.setUpiPin();
            }
        });
    }

    private void hasSufficientBalance() {
        if ((this.availableBalance == 0.0d && !(this instanceof PPBLUpiPushView)) || !this.model.isBalanceFetchHit) {
            return;
        }
        if (this.model.checkIfAmountSufficient(Double.toString(this.availableBalance))) {
            enableView();
            return;
        }
        this.singleVpaLayoutBinding.tvInsufficientBalance.setText(this.context.getResources().getString(R.string.native_insufficent_balance));
        disableView();
    }

    /* access modifiers changed from: protected */
    public void disableView() {
        disableView(false);
    }

    /* access modifiers changed from: protected */
    public void disableView(boolean z) {
        setDisabled(true);
        this.singleVpaLayoutBinding.btnProceed.setVisibility(8);
        this.singleVpaLayoutBinding.rbBankName.setChecked(false);
        this.singleVpaLayoutBinding.tvInsufficientBalance.setVisibility(0);
        if (this.availableBalance == 0.0d) {
            this.singleVpaLayoutBinding.llCheckBalanceContainer.setVisibility(8);
        } else {
            this.singleVpaLayoutBinding.llCheckBalanceContainer.setVisibility(0);
        }
        this.singleVpaLayoutBinding.rbBankName.setTypeface((Typeface) null, 0);
        if (this.transactionErrorCode != null && !z) {
            openNextInstrument();
        }
        this.singleVpaLayoutBinding.tvInsufficientBalance.setAlpha(1.0f);
        this.singleVpaLayoutBinding.vpaTopLayout.setClickable(false);
        this.singleVpaLayoutBinding.vpaTopLayout.setAlpha(0.4f);
    }

    /* access modifiers changed from: protected */
    public void openNextInstrument() {
        if (this.context != null && isSelected()) {
            Intent intent = new Intent();
            intent.setAction(SDKConstants.OPEN_AUTO_INSTRUMENT_PPB_POSTPAID);
            intent.putExtra(SDKConstants.IS_POSTPAID, false);
            a.a(this.context.getApplicationContext()).a(intent);
        }
    }

    private void enableView() {
        setDisabled(false);
        if (this.transactionErrorCode == null) {
            if (isSelected()) {
                this.singleVpaLayoutBinding.rbBankName.setChecked(true);
                this.singleVpaLayoutBinding.rbBankName.setTypeface((Typeface) null, 1);
                this.singleVpaLayoutBinding.btnProceed.setVisibility(0);
            } else {
                this.singleVpaLayoutBinding.llCheckBalanceContainer.setVisibility(8);
                this.singleVpaLayoutBinding.rbBankName.setChecked(false);
            }
            this.singleVpaLayoutBinding.vpaTopLayout.setClickable(true);
            this.singleVpaLayoutBinding.vpaTopLayout.setAlpha(1.0f);
            if (!this.isUpiWarning) {
                this.singleVpaLayoutBinding.tvInsufficientBalance.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    public void setUpiPin() {
        if (PaytmSDK.getUpiCallBackListener() != null) {
            PaytmSDK.getUpiCallBackListener().setUpiPin((Activity) this.context, new com.google.gson.f().b(SDKUtils.convertVpaPojo(this.vpaDetail)), 234);
        }
    }

    public void updateSetPinLayout() {
        if (isSelected()) {
            this.vpaDetail.setMpinSet("Y");
            updateCheckBalanceLayout();
        }
    }

    public void getBalance() {
        if (isSelected() && PaytmSDK.getUpiCallBackListener() != null) {
            PaytmSDK.getUpiCallBackListener().checkBalance((Activity) this.context, new com.google.gson.f().b(SDKUtils.convertVpaPojo(this.vpaDetail)), REQUEST_CODE_UPI_CHECK_BALANCE, this);
        }
    }

    private void showCheckBalanceLoader() {
        LottieAnimationView lottieAnimationView = this.singleVpaLayoutBinding.ltvLoadingCheckbalance;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
            lottieAnimationView.setVisibility(0);
        }
        this.singleVpaLayoutBinding.ltvLoadingCheckbalance.setVisibility(0);
        this.singleVpaLayoutBinding.tvCheckBalance.setVisibility(8);
    }

    private void hideCheckBalanceLoader() {
        LottieAnimationView lottieAnimationView = this.singleVpaLayoutBinding.ltvLoadingCheckbalance;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.pauseAnimation();
            lottieAnimationView.setVisibility(8);
        }
        this.singleVpaLayoutBinding.ltvLoadingCheckbalance.setVisibility(8);
        this.singleVpaLayoutBinding.tvCheckBalance.setVisibility(0);
    }

    public void enableProceedButton() {
        this.singleVpaLayoutBinding.btnProceed.setEnabled(true);
        this.singleVpaLayoutBinding.btnProceed.setClickable(true);
    }

    public void disableProceedButton() {
        this.singleVpaLayoutBinding.btnProceed.setEnabled(false);
        this.singleVpaLayoutBinding.btnProceed.setClickable(false);
    }

    public void startCheckingOfferAnimation() {
        SDKUtility.startAnimation(this.singleVpaLayoutBinding.ltvGetOffers);
    }

    public void stopCheckingOfferAnimation() {
        SDKUtility.stopAnimation(this.singleVpaLayoutBinding.ltvGetOffers);
    }

    public void changeOfferTextBgColor(int i2, int i3, boolean z) {
        this.singleVpaLayoutBinding.tvBankOffer.setBackgroundColor(i2);
        this.singleVpaLayoutBinding.tvBankOffer.setTextColor(i3);
        SDKUtility.setPaddingBankOffer(this.singleVpaLayoutBinding.tvBankOffer, z, this.context, 15, 26, 10, 10);
    }

    public Object getVerifyResponseModel() {
        return this.model.getVerifyResponseModel();
    }

    public void onAddMoneyProceedClicked() {
        onProceedClicked(this.singleVpaLayoutBinding.btnProceed);
    }

    public void onRequestStart() {
        showCheckBalanceLoader();
    }

    public void onRequestEnd() {
        hideCheckBalanceLoader();
    }

    public void onFetchBalanceSuccess(String str) {
        if (this.context != null) {
            hideCheckBalanceLoader();
            try {
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.GA_CHECK_BALANCE_ACTION, this.vpaDetail.getBank(), "UPI", "success", this.model.checkIfAmountSufficient(str) ? "Sufficient balance" : "Insufficient balance"));
                this.availableBalance = Double.parseDouble(str);
                updateCheckBalanceLayout();
            } catch (Exception unused) {
            }
        }
    }

    public void onError(int i2, String str, boolean z) {
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.GA_CHECK_BALANCE_ACTION, this.vpaDetail.getBank(), "UPI", ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE, ""));
        hideCheckBalanceLoader();
        if (this.context != null && !TextUtils.isEmpty(str) && z && isSelected()) {
            if (i2 != 4) {
                Toast.makeText(this.context, str, 0).show();
            } else if (PaytmSDK.getCallbackListener() != null) {
                PaytmSDK.getCallbackListener().onSessionExpire((CustomVolleyError) null);
            }
        }
    }

    public void onBankOfferFetched() {
        hasSufficientBalance();
    }

    public void hidePaymentsLoader() {
        SingleVpaLayoutBinding singleVpaLayoutBinding2;
        UpiPushViewModel upiPushViewModel = this.model;
        if (upiPushViewModel != null && (singleVpaLayoutBinding2 = this.singleVpaLayoutBinding) != null) {
            upiPushViewModel.hidePaymentProgressbar(singleVpaLayoutBinding2.btnProceed);
        }
    }

    public void setAmount(String str) {
        this.singleVpaLayoutBinding.txtamount.setText(str);
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.context != null) {
                this.context.unregisterReceiver(this.networkConnectivityReceiver);
                this.context.unregisterReceiver(this.refreshUpiLimit);
            }
        } catch (Exception unused) {
        }
    }

    private boolean isPPBLUpiPushView() {
        return this instanceof PPBLUpiPushView;
    }
}
