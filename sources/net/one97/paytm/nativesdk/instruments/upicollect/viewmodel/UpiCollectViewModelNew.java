package net.one97.paytm.nativesdk.instruments.upicollect.viewmodel;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.b;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import androidx.fragment.app.q;
import com.alipay.mobile.h5container.api.H5Param;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ConvenienceFeeController;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.Requester.APIReqtGenerator;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.listeners.TransactionProcessorListener;
import net.one97.paytm.nativesdk.common.model.ApplyPromoRequest;
import net.one97.paytm.nativesdk.common.model.ApplyPromoResponse;
import net.one97.paytm.nativesdk.common.model.CardPaymentIntentData;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.instruments.upicollect.listeners.UpiCollectListener;
import net.one97.paytm.nativesdk.instruments.upicollect.models.Body;
import net.one97.paytm.nativesdk.instruments.upicollect.models.ExtendInfo;
import net.one97.paytm.nativesdk.instruments.upicollect.models.RecurringDetails;
import net.one97.paytm.nativesdk.instruments.upicollect.models.UpiDeeplinkResponse;
import net.one97.paytm.nativesdk.instruments.upicollect.models.UpiOptionsModel;
import net.one97.paytm.nativesdk.instruments.upicollect.models.VerifyVpaResponse;
import net.one97.paytm.nativesdk.instruments.upicollect.view.UpiCollectViewNew;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentRepository;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.DeeplinkInfo;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;
import net.one97.paytm.nativesdk.upiHelp.view.UpiHelpBottomSheet;

public class UpiCollectViewModelNew extends BaseViewModel implements Response.ErrorListener, Response.Listener {
    public i<String> amount = new i<>("");
    public i<String> cashBackText = new i<>("");
    public ObservableInt cashBackTextVisibility = new ObservableInt(8);
    private String cashierRequestId;
    public ObservableInt checkOfferVisibility = new ObservableInt(8);
    public i<SpannableString> collectConvFeeText = new i<>(new SpannableString(""));
    public ObservableInt collectConvFeeTextVisibility = new ObservableInt(8);
    public i<String> collectLoaderMsg = new i<>("");
    public ObservableInt collectLoaderVisibility = new ObservableInt(8);
    /* access modifiers changed from: private */
    public Context context;
    public i<String> disableMessage = new i<>("");
    public ObservableInt disableMessageCollectVisibility = new ObservableInt(8);
    public ObservableInt disableMessageIntentVisibility = new ObservableInt(8);
    public ObservableInt howItWorksVisibility = new ObservableInt(8);
    private double instrumentConvenienceFee;
    public i<SpannableString> intentConvFeeText = new i<>(new SpannableString(""));
    public ObservableInt intentConvFeeTextVisibility = new ObservableInt(8);
    public i<String> intentLoaderMsg = new i<>("");
    public ObservableInt intentLoaderVisibility = new ObservableInt(8);
    /* access modifiers changed from: private */
    public boolean isAlreadySelected = false;
    private boolean isErrorDeeplink = false;
    public ObservableBoolean isInValidVPA = new ObservableBoolean(false);
    private boolean isRequestDone = false;
    private boolean isTimerDone = false;
    private boolean isUpiActivityStarted = false;
    private boolean isUpiIntentSelected = true;
    public ObservableBoolean isVerifyClickable = new ObservableBoolean(true);
    /* access modifiers changed from: private */
    public boolean isVpaVerified;
    /* access modifiers changed from: private */
    public UpiCollectListener listener;
    public i<String> paySecurelyText = new i<>();
    /* access modifiers changed from: private */
    public ArrayList<PaymentIntent> paymentIntents;
    /* access modifiers changed from: private */
    public PaymentModes paymentModes;
    public ObservableBoolean radioChecked = new ObservableBoolean(false);
    private UpiOptionsModel selectedUpiOptionsModel;
    public ObservableInt tagImageVisibility = new ObservableInt(0);
    private String transId;
    private ArrayList<UpiOptionsModel> upiAppsInstalled;
    public ObservableInt upiCollectVisibility = new ObservableInt(0);
    private Uri.Builder upiDeepLink;
    public ObservableInt upiIntentSeparatorVisibility = new ObservableInt(0);
    private HashMap<String, Boolean> upiPayModesMap = new HashMap<>();
    public ObservableInt verifiedIconVisibility = new ObservableInt(8);
    public ObservableInt verifiedProgressVisibility = new ObservableInt(8);
    public ObservableInt verifyTextVisibility = new ObservableInt(8);
    private String vpaAddress;
    public ObservableInt vpaInputLayoutVisibility;

    public void completeTransaction(AppCompatActivity appCompatActivity) {
    }

    public void deselectView() {
    }

    public UpiCollectViewModelNew(Context context2, PaymentModes paymentModes2, UpiCollectListener upiCollectListener) {
        super(context2, upiCollectListener);
        int i2 = 0;
        this.listener = upiCollectListener;
        this.context = context2;
        this.vpaInputLayoutVisibility = new ObservableInt(8);
        this.paymentModes = paymentModes2;
        populatePayModesMap();
        this.upiCollectVisibility.set(isUpiCollectEnabled() ? 0 : 8);
        this.upiIntentSeparatorVisibility.set(!isUpiCollectEnabled() ? 8 : i2);
    }

    public void setUpiAppsInstalled(ArrayList<UpiOptionsModel> arrayList) {
        this.upiAppsInstalled = arrayList;
    }

    private void populatePayModesMap() {
        for (int i2 = 0; i2 < this.paymentModes.getPayChannelOptions().size(); i2++) {
            this.upiPayModesMap.put(this.paymentModes.getPayChannelOptions().get(i2).getChannelCode(), Boolean.TRUE);
        }
    }

    public boolean isUpiCollectEnabled() {
        return this.upiPayModesMap.get("UPI") != null && this.upiPayModesMap.get("UPI").booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0022, code lost:
        r0 = r2.upiAppsInstalled;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isUpiIntentEnabled() {
        /*
            r2 = this;
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            boolean r0 = r0.isNativeJsonRequestSupported()
            if (r0 == 0) goto L_0x002e
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = r2.upiPayModesMap
            java.lang.String r1 = "UPIPUSH"
            java.lang.Object r0 = r0.get(r1)
            if (r0 == 0) goto L_0x002e
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = r2.upiPayModesMap
            java.lang.Object r0 = r0.get(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x002e
            java.util.ArrayList<net.one97.paytm.nativesdk.instruments.upicollect.models.UpiOptionsModel> r0 = r2.upiAppsInstalled
            if (r0 == 0) goto L_0x002e
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x002e
            r0 = 1
            return r0
        L_0x002e:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.instruments.upicollect.viewmodel.UpiCollectViewModelNew.isUpiIntentEnabled():boolean");
    }

    public void setVpaVerified(boolean z) {
        this.isVpaVerified = z;
    }

    public void refreshLayout() {
        setAmountIfNeeded();
        buildPaymentIntent();
        if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
            getBankOffers();
        } else {
            fetchConvenienceFee();
        }
    }

    public void proceedToPayUpi(View view) {
        Context context2;
        VpaBankAccountDetail primaryVpa;
        if (this.selectedUpiOptionsModel != null) {
            if (SDKUtility.isAppInvokeFlow()) {
                SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAY_BUTTON_CLICKED, SDKConstants.AI_KEY_UPI_INTENT));
            }
            if (SDKUtility.shouldShowValidatePromoError()) {
                setValidatePromoText(true);
            } else if (this.selectedUpiOptionsModel.getResolveInfo().activityInfo.packageName.contains("net.one97.paytm") && (primaryVpa = getPrimaryVpa()) != null && SDKUtility.isPaytmApp(this.context) && SDKUtility.isUpiPushEnabled()) {
                SDKUtility.startUpiPush(this.context, primaryVpa, "intent", getNetPayableAmount());
            } else if (!DirectPaymentBL.getInstance().isSubsCriptionFlow() || !DirectPaymentBL.getInstance().isWalletChecked() || DirectPaymentBL.getInstance().isWalletOtpValidated() || (context2 = this.context) == null) {
                fetchDeepLinkForIntentFlow(view);
            } else {
                Toast.makeText(this.context, context2.getString(R.string.otp_not_validated), 0).show();
            }
        }
    }

    public VpaBankAccountDetail getPrimaryVpa() {
        List<VpaBankAccountDetail> allUnFilteredVpas = SDKUtility.getAllUnFilteredVpas();
        if (allUnFilteredVpas == null || allUnFilteredVpas.size() <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < allUnFilteredVpas.size(); i2++) {
            if (allUnFilteredVpas.get(i2).getVpaDetail() != null && allUnFilteredVpas.get(i2).getVpaDetail().getPrimary()) {
                return allUnFilteredVpas.get(i2);
            }
        }
        return allUnFilteredVpas.get(0);
    }

    public void setSelectedUpiOptionsModel(UpiOptionsModel upiOptionsModel) {
        this.selectedUpiOptionsModel = upiOptionsModel;
    }

    public void setUpiIntentSelected(boolean z) {
        this.isUpiIntentSelected = z;
        if (z) {
            this.collectLoaderVisibility.set(8);
            if (SDKUtility.isAppInvokeFlow()) {
                SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAYMODE_CLICKED, SDKConstants.AI_KEY_UPI_INTENT, H5Param.DEFAULT_LONG_PRESSO_LOGIN));
            }
        } else {
            this.intentLoaderVisibility.set(8);
        }
        hideLoading();
        if (SDKUtility.shouldShowValidatePromoError() && z) {
            setValidatePromoText(true);
        }
        fetchConvenienceFee();
    }

    public boolean isUpiIntentSelected() {
        return this.isUpiIntentSelected;
    }

    public UpiOptionsModel getSelectedUpiOptionsModel() {
        return this.selectedUpiOptionsModel;
    }

    public void verifyVPA(View view) {
        verifyVPA((View) null, false, false);
    }

    private void verifyVPA(final View view, final boolean z, final boolean z2) {
        if (!TextUtils.isEmpty(this.vpaAddress)) {
            if (!this.vpaAddress.contains("@")) {
                this.listener.changeVpaEditTextUi(true, this.context.getResources().getString(R.string.native_enter_valid_vpa_address));
            } else if (this.vpaAddress.trim().contains(" ")) {
                this.listener.changeVpaEditTextUi(true, this.context.getResources().getString(R.string.native_enter_valid_vpa_address));
            } else {
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventUPI(SDKConstants.GA_UPI_ONBOARDING, SDKConstants.UPI_HANDLE_ENTERED, MerchantBL.getMerchantInstance().getOrderId(), this.vpaAddress, MerchantBL.getMerchantInstance().getMid()));
                if (SDKUtility.isNetworkAvailable(this.context)) {
                    this.isVerifyClickable.set(false);
                    this.verifiedProgressVisibility.set(8);
                    if (z2) {
                        showLoading(this.context.getString(R.string.native_checking_offers));
                        this.checkOfferVisibility.set(8);
                    }
                    PaymentRepository.Companion.getInstance(this.context).validateVPA(this.vpaAddress, new PaymentMethodDataSource.Callback<VerifyVpaResponse>() {
                        public void onResponse(VerifyVpaResponse verifyVpaResponse) {
                            UpiCollectViewModelNew.this.isVerifyClickable.set(true);
                            UpiCollectViewModelNew.this.verifiedProgressVisibility.set(8);
                            if (verifyVpaResponse != null && verifyVpaResponse.getBody() != null && verifyVpaResponse.getBody().getValid() != null) {
                                if (!verifyVpaResponse.getBody().getValid().booleanValue()) {
                                    UpiCollectViewModelNew.this.checkOfferVisibility.set(8);
                                    UpiCollectViewModelNew.this.hideLoading();
                                    boolean unused = UpiCollectViewModelNew.this.isVpaVerified = false;
                                    UpiCollectViewModelNew.this.verifiedIconVisibility.set(8);
                                    UpiCollectViewModelNew.this.listener.changeVpaEditTextUi(true, UpiCollectViewModelNew.this.context.getResources().getString(R.string.native_enter_valid_vpa_address));
                                } else if (DirectPaymentBL.getInstance().isSubsCriptionFlow()) {
                                    RecurringDetails recurringDetails = verifyVpaResponse.getBody().getRecurringDetails();
                                    if (recurringDetails == null) {
                                        return;
                                    }
                                    if (!recurringDetails.getPspSupportedRecurring().booleanValue() || !recurringDetails.getBankSupportedRecurring().booleanValue()) {
                                        UpiCollectViewModelNew.this.checkOfferVisibility.set(8);
                                        UpiCollectViewModelNew.this.hideLoading();
                                        boolean unused2 = UpiCollectViewModelNew.this.isVpaVerified = false;
                                        UpiCollectViewModelNew.this.verifiedIconVisibility.set(8);
                                        UpiCollectViewModelNew.this.listener.changeVpaEditTextUi(true, UpiCollectViewModelNew.this.context.getResources().getString(R.string.subscription_recurring_vpa_error_text));
                                        return;
                                    }
                                    UpiCollectViewModelNew.this.verifiedIconVisibility.set(0);
                                    UpiCollectViewModelNew.this.sendEventAppInvokeUpiCollect();
                                    UpiCollectViewModelNew.this.verifyTextVisibility.set(8);
                                    UpiCollectViewModelNew.this.listener.changeVpaEditTextUi(false, SDKConstants.VPA_VERIFIED);
                                    boolean unused3 = UpiCollectViewModelNew.this.isVpaVerified = true;
                                    if (z) {
                                        UpiCollectViewModelNew.this.proceedToPay(view);
                                    } else if (z2) {
                                        UpiCollectViewModelNew.this.getBankOffers();
                                    }
                                } else {
                                    UpiCollectViewModelNew.this.verifiedIconVisibility.set(0);
                                    UpiCollectViewModelNew.this.sendEventAppInvokeUpiCollect();
                                    UpiCollectViewModelNew.this.verifyTextVisibility.set(8);
                                    UpiCollectViewModelNew.this.listener.changeVpaEditTextUi(false, SDKConstants.VPA_VERIFIED);
                                    boolean unused4 = UpiCollectViewModelNew.this.isVpaVerified = true;
                                    if (z) {
                                        UpiCollectViewModelNew.this.proceedToPay(view);
                                    } else if (z2) {
                                        UpiCollectViewModelNew.this.getBankOffers();
                                    }
                                }
                            }
                        }

                        public void onErrorResponse(VolleyError volleyError, VerifyVpaResponse verifyVpaResponse) {
                            UpiCollectViewModelNew.this.isVerifyClickable.set(true);
                            boolean unused = UpiCollectViewModelNew.this.isVpaVerified = true;
                            UpiCollectViewModelNew.this.verifiedProgressVisibility.set(8);
                            UpiCollectViewModelNew.this.verifyTextVisibility.set(0);
                            if (z) {
                                UpiCollectViewModelNew.this.proceedToPay(view);
                            } else if (z2) {
                                UpiCollectViewModelNew.this.getBankOffers();
                            }
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void sendEventAppInvokeUpiCollect() {
        if (MerchantBL.getMerchantInstance().isTransparentAppInvoke() || MerchantBL.getMerchantInstance().isAppInvoke()) {
            String str = this.vpaAddress;
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_NEW_UPI_ENTERED, str.substring(str.indexOf(64))));
        }
    }

    public void proceedToPay(View view) {
        Context context2;
        if (!SDKUtility.isNetworkAvailable(this.context)) {
            DialogUtility.showNoInternetDialog(this.context, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
        } else if (TextUtils.isEmpty(this.vpaAddress)) {
            this.listener.changeVpaEditTextUi(true, this.context.getResources().getString(R.string.native_enter_vpa_address));
            this.checkOfferVisibility.set(8);
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_PAY_CLICKED_ERROR, "BHIM UPI COLLECT", "Invalid VPA address"));
        } else if (!this.vpaAddress.contains("@")) {
            this.listener.changeVpaEditTextUi(true, this.context.getResources().getString(R.string.native_enter_valid_vpa_address));
            this.checkOfferVisibility.set(8);
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_PAY_CLICKED_ERROR, "BHIM UPI COLLECT", "Invalid VPA address"));
        } else if (SDKUtility.shouldShowValidatePromoError() && (this.applyPromoFailed || DirectPaymentBL.getInstance().getPaymentFlowBankOffer().equals(SDKConstants.ADDANDPAY))) {
            setValidatePromoText(false);
        } else if (!this.isVpaVerified) {
            verifyVPA(view, true, false);
        } else {
            VpaBankAccountDetail registeredVpa = getRegisteredVpa(this.vpaAddress);
            if (registeredVpa == null || !SDKUtility.isPaytmApp(this.context) || !SDKUtility.isUpiPushEnabled()) {
                if (DirectPaymentBL.getInstance().isOpeningAuto()) {
                    if (SDKUtility.isHybridCase()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(System.currentTimeMillis());
                        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", "pay_clicked", SDKConstants.UPI_COLLECT, SDKConstants.GA_KEY_HYBRID, sb.toString(), ""));
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(System.currentTimeMillis());
                        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", "pay_clicked", SDKConstants.UPI_COLLECT, SDKConstants.GA_KEY_NEW, sb2.toString(), ""));
                    }
                }
                String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(this.context, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()));
                HashMap<String, String> upiCollectParam = PayUtility.getUpiCollectParam(this.vpaAddress);
                if (isNativeJsonFlowEnabled()) {
                    this.listener.closeKeyboard();
                }
                PaymentInstrument paymentInstrument = new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), addAuthDefaultParams, upiCollectParam);
                paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_UPI_COllECT);
                paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_DEFAULT);
                if (isNativeJsonFlowEnabled()) {
                    paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
                } else {
                    paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
                }
                if (SDKUtility.isAppInvokeFlow()) {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAY_BUTTON_CLICKED, SDKConstants.AI_KEY_UPI_COLLECT));
                }
                if (!DirectPaymentBL.getInstance().isSubsCriptionFlow() || !DirectPaymentBL.getInstance().isWalletChecked() || DirectPaymentBL.getInstance().isWalletOtpValidated() || (context2 = this.context) == null) {
                    this.cashBackTextVisibility.set(8);
                    TransactionProcessor transactionProcessor = new TransactionProcessor(this.context, BaseViewModel.PaymentType.UPI_COLLECT, paymentInstrument);
                    if (SDKUtility.isHybridCase() && this.paymentModes.getHybridPaymentOffer() != null) {
                        transactionProcessor.setOfferBody(new f().b(this.paymentModes.getHybridPaymentOffer()));
                    } else if (!SDKUtility.isHybridCase() && this.paymentModes.getPaymentOffer() != null) {
                        transactionProcessor.setOfferBody(new f().b(this.paymentModes.getPaymentOffer()));
                    }
                    transactionProcessor.setPaymentIntent(getPaymentIntent());
                    transactionProcessor.startTransaction(view);
                    return;
                }
                Toast.makeText(this.context, context2.getString(R.string.otp_not_validated), 0).show();
                return;
            }
            if (SDKUtility.isOfferValid(getPaymentOffer())) {
                TextUtils.isEmpty(getPaymentOffer().getTotalInstantDiscount());
            }
            SDKUtility.startUpiPush(this.context, registeredVpa, SDKConstants.PUSH_FROM_COLLECT, getNetPayableAmount());
        }
    }

    public void howItWorksClicked(View view) {
        UpiHelpBottomSheet instance = UpiHelpBottomSheet.getInstance();
        q a2 = ((AppCompatActivity) this.context).getSupportFragmentManager().a();
        a2.a("upisheet");
        instance.show(a2, (String) null);
    }

    public void bhimUpiClicked(View view) {
        if (!this.isAlreadySelected) {
            this.isAlreadySelected = true;
            if (DirectPaymentBL.getInstance().lastInsufficuentAmountError != null) {
                DirectPaymentBL.getInstance().lastInsufficuentAmountError.set("");
            }
            if (this.vpaInputLayoutVisibility.get() == 0) {
                hideBhimUpi();
                this.listener.closeKeyboard();
            } else {
                setAmountIfNeeded();
                this.radioChecked.set(true);
                this.listener.showUpiIntent();
                this.listener.showAnimation(false);
                this.listener.changeArrowIcon(true);
                this.listener.selectView();
                this.howItWorksVisibility.set(0);
            }
            if (SDKUtility.isHybridCase()) {
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_UPI_COllECT, SDKConstants.GA_KEY_HYBRID));
            } else {
                SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_UPI_COllECT, SDKConstants.GA_KEY_NEW));
            }
            if (SDKUtility.shouldShowValidatePromoError() && this.isUpiIntentSelected) {
                setValidatePromoText(true);
            }
            if (SDKUtility.isAppInvokeFlow()) {
                SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAYMODE_CLICKED, SDKConstants.AI_KEY_UPI_COLLECT, H5Param.DEFAULT_LONG_PRESSO_LOGIN));
            }
        }
    }

    public void checkBankOffersClick(View view) {
        if (TextUtils.isEmpty(this.vpaAddress)) {
            this.listener.changeVpaEditTextUi(true, this.context.getResources().getString(R.string.native_enter_vpa_address));
            this.checkOfferVisibility.set(8);
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_PAY_CLICKED_ERROR, "BHIM UPI COLLECT", "Invalid VPA address"));
        } else if (!this.vpaAddress.contains("@")) {
            this.listener.changeVpaEditTextUi(true, this.context.getResources().getString(R.string.native_enter_valid_vpa_address));
            this.checkOfferVisibility.set(8);
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_PAY_CLICKED_ERROR, "BHIM UPI COLLECT", "Invalid VPA address"));
        } else {
            getBankOffers();
        }
    }

    private void setAmountIfNeeded() {
        this.amount.set("");
    }

    public void hideBhimUpi() {
        this.amount.set("");
        this.radioChecked.set(false);
        this.listener.clearVpaAddress();
        this.vpaInputLayoutVisibility.set(8);
        this.listener.changeArrowIcon(false);
        this.howItWorksVisibility.set(8);
        this.isAlreadySelected = false;
        this.bankOfferText = new i(new SpannableString(""));
        this.bankOfferVisibility.set(8);
        this.cashBackTextVisibility.set(8);
        this.cashBackText = new i<>("");
        this.checkOfferVisibility.set(8);
        hideLoading();
        this.paymentModes.setHybridPaymentOffer((ApplyPromoResponse.PaymentOffer) null);
        this.paymentModes.setPaymentOffer((ApplyPromoResponse.PaymentOffer) null);
    }

    public void vpaAddressBeforeTextChange(Editable editable) {
        this.vpaAddress = editable.toString().trim();
    }

    private VpaBankAccountDetail getRegisteredVpa(String str) {
        List<VpaBankAccountDetail> allUnFilteredVpas = SDKUtility.getAllUnFilteredVpas();
        if (allUnFilteredVpas == null || allUnFilteredVpas.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i2 = 0; i2 < allUnFilteredVpas.size(); i2++) {
            if (allUnFilteredVpas.get(i2).getVpaDetail() != null && str.trim().equalsIgnoreCase(allUnFilteredVpas.get(i2).getVpaDetail().getName()) && allUnFilteredVpas.get(i2).getAccRefId().equalsIgnoreCase(allUnFilteredVpas.get(i2).getVpaDetail().getDefaultDebitAccRefId())) {
                return allUnFilteredVpas.get(i2);
            }
        }
        return null;
    }

    private String getUpiIntentRequestBody() {
        Body body = new Body();
        body.setMid(MerchantBL.getMerchantInstance().getMid());
        body.setOrderId(MerchantBL.getMerchantInstance().getOrderId());
        body.setPaymentMode(SDKConstants.UPI_INTENT);
        body.setPaymentFlow((!DirectPaymentBL.getInstance().isPaytmWalletChecked() || DirectPaymentBL.getInstance().isWalletAmountSufficientToPay()) ? SDKConstants.NATIVE_SDK_NONE : DirectPaymentBL.getInstance().getPaymentFlowAvailable());
        body.setRequestType("NATIVE");
        body.setRefUrl("");
        body.setTxnNote("");
        ExtendInfo extendInfo = new ExtendInfo();
        extendInfo.setUdf1("");
        extendInfo.setUdf2("");
        extendInfo.setUdf3("");
        extendInfo.setPayerPSPApp(this.selectedUpiOptionsModel.getAppName());
        extendInfo.setComments("NA");
        extendInfo.setMercUnqRef("");
        body.setExtendInfo(extendInfo);
        return new f().b(body);
    }

    public void onErrorResponse(VolleyError volleyError) {
        this.listener.hideFetchDeeplinkDialog();
        this.isErrorDeeplink = true;
        this.isRequestDone = true;
        if (this.isTimerDone) {
            Context context2 = this.context;
            Toast.makeText(context2, context2.getString(R.string.native_some_went_wrong), 0).show();
        }
    }

    public void onResponse(Object obj) {
        String str;
        if (obj instanceof DeeplinkInfo) {
            this.isRequestDone = true;
            this.isTimerDone = true;
            DeeplinkInfo deeplinkInfo = (DeeplinkInfo) obj;
            str = deeplinkInfo.getDeepLink();
            this.transId = deeplinkInfo.getTransId();
            this.cashierRequestId = deeplinkInfo.getCashierRequestId();
        } else if (obj instanceof UpiDeeplinkResponse) {
            this.isRequestDone = true;
            UpiDeeplinkResponse upiDeeplinkResponse = (UpiDeeplinkResponse) obj;
            str = upiDeeplinkResponse.getBody().getDeeplink();
            this.transId = upiDeeplinkResponse.getBody().getTransId();
            this.cashierRequestId = upiDeeplinkResponse.getBody().getCashierRequestId();
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            this.listener.hideFetchDeeplinkDialog();
            this.isErrorDeeplink = true;
            if (this.isTimerDone) {
                Context context2 = this.context;
                Toast.makeText(context2, context2.getString(R.string.native_some_went_wrong), 0).show();
                return;
            }
            return;
        }
        this.upiDeepLink = Uri.parse(str).buildUpon();
        this.listener.hideFetchDeeplinkDialog();
        if (this.isTimerDone) {
            openUpiApplication();
        }
    }

    public void fetchDeepLinkForIntentFlow(View view) {
        if (!SDKUtility.isNetworkAvailable(this.context)) {
            DialogUtility.showNoInternetDialog(this.context, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            return;
        }
        try {
            if (!appInstalledOrNot(this.selectedUpiOptionsModel.getResolveInfo().activityInfo.packageName)) {
                Toast.makeText(this.context, this.context.getString(R.string.app_not_installed), 1).show();
            } else if (SDKUtility.shouldShowValidatePromoError()) {
                setValidatePromoText(this.isUpiIntentSelected);
            } else {
                PaymentInstrument paymentInstrument = new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), (String) null, (HashMap<String, String>) null);
                paymentInstrument.setRequestBody(getUpiIntentRequestBody());
                paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_UPI_INTENT);
                paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_DEFAULT);
                if (isNativeJsonFlowEnabled()) {
                    paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
                } else {
                    paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
                }
                TransactionProcessor transactionProcessor = new TransactionProcessor(this.context, BaseViewModel.PaymentType.UPI_INTENT, paymentInstrument);
                if (SDKUtility.isHybridCase() && this.paymentModes.getHybridPaymentOffer() != null) {
                    transactionProcessor.setOfferBody(new f().b(this.paymentModes.getHybridPaymentOffer()));
                } else if (!SDKUtility.isHybridCase() && this.paymentModes.getPaymentOffer() != null) {
                    transactionProcessor.setOfferBody(new f().b(this.paymentModes.getPaymentOffer()));
                }
                transactionProcessor.setTransactionProcessorListener(new TransactionProcessorListener() {
                    public void onProcessTransactionResponse(Object obj) {
                        UpiCollectViewModelNew.this.onResponse(obj);
                    }

                    public void onIntentFlowComplete() {
                        if (UpiCollectViewModelNew.this.listener != null) {
                            UpiCollectViewModelNew.this.listener.onIntentFlowComplete();
                        }
                    }
                });
                DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
                transactionProcessor.setPaymentIntent(this.paymentIntents);
                transactionProcessor.startTransaction(view);
            }
        } catch (Exception unused) {
            Context context2 = this.context;
            Toast.makeText(context2, context2.getString(R.string.app_not_installed), 1).show();
        }
    }

    private void executeRequest(Request request) {
        if (SDKUtility.isNetworkAvailable(this.context)) {
            VolleyRequestQueue.getInstance(this.context).addToRequestQueue(request);
        }
    }

    private void openUpiApplication() {
        try {
            ActivityInfo activityInfo = this.selectedUpiOptionsModel.getResolveInfo().activityInfo;
            ComponentName componentName = new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.upiDeepLink.toString()));
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setComponent(componentName);
            if (this.context instanceof Activity) {
                ((AppCompatActivity) this.context).startActivityForResult(intent, UpiCollectViewNew.REQUEST_CODE_UPI_APP);
                DirectPaymentBL.getInstance().setUpiOptionsModel(this.selectedUpiOptionsModel);
            } else {
                this.context.startActivity(intent);
            }
            this.isUpiActivityStarted = true;
        } catch (Exception e2) {
            LogUtility.e("UpiCollectViewModel", "Something went wrong when opening application" + e2.toString());
        }
    }

    public boolean isUpiActivityStarted() {
        return this.isUpiActivityStarted;
    }

    public void setUpiActivityStarted(boolean z) {
        this.isUpiActivityStarted = z;
    }

    public String getTransId() {
        return this.transId;
    }

    public String getCashierRequestId() {
        return this.cashierRequestId;
    }

    private boolean appInstalledOrNot(String str) {
        try {
            this.context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public HashMap<String, String> getProcessTransactionRequest(String str, String str2, String str3, String str4) {
        VpaBankAccountDetail vpaBankAccountDetail;
        if ("intent".equalsIgnoreCase(str4)) {
            vpaBankAccountDetail = getPrimaryVpa();
        } else {
            vpaBankAccountDetail = getRegisteredVpa(this.vpaAddress);
        }
        if (DirectPaymentBL.getInstance().isNativeJsonRequestSupported()) {
            return PayUtility.getUpiPushRequestParam(str, str2, str3, vpaBankAccountDetail);
        }
        return PayUtility.getUpiPushRequestParamWebRedirection(str, str2, str3, vpaBankAccountDetail);
    }

    public void showCheckOffer() {
        if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
            this.checkOfferVisibility.set(0);
        } else {
            this.checkOfferVisibility.set(8);
        }
    }

    /* access modifiers changed from: private */
    public void showOffers() {
        ApplyPromoResponse.PaymentOffer hybridPaymentOffer = SDKUtility.isHybridCase() ? this.paymentModes.getHybridPaymentOffer() : this.paymentModes.getPaymentOffer();
        if (!SDKUtility.isOfferValid(hybridPaymentOffer) && !SDKUtility.shouldShowValidatePromoError()) {
            this.listener.changeCheckOfferText(this.context.getString(R.string.no_offer_found), b.c(this.context, R.color.color_fd5c5c));
            this.bankOfferVisibility.set(8);
            this.tagImageVisibility.set(8);
            setPaySecurelyText();
        } else if (hybridPaymentOffer.getTotalCashbackAmount() != null) {
            this.bankOfferVisibility.set(0);
            i iVar = this.bankOfferText;
            Context context2 = this.context;
            iVar.set(SDKUtility.getBankOfferText(context2, context2.getString(R.string.cashback_applied_successfully, new Object[]{hybridPaymentOffer.getTotalCashbackAmount()}), hybridPaymentOffer));
            this.cashBackTextVisibility.set(0);
            this.cashBackText.set(this.context.getString(R.string.effective_cashback_price, new Object[]{MerchantBL.getMerchantInstance().getWithoutDoubleAmount(SDKUtility.getEffectAfterOfferAmount(hybridPaymentOffer.getTotalCashbackAmount()))}));
            setPaySecurelyText();
            this.applyPromoFailed = false;
            this.listener.changeOfferTextBgColor(b.c(this.context, R.color.color_e8f8f1), b.c(this.context, R.color.color_21c17a), false);
        } else if (hybridPaymentOffer.getTotalInstantDiscount() != null) {
            this.bankOfferVisibility.set(0);
            i iVar2 = this.bankOfferText;
            Context context3 = this.context;
            iVar2.set(SDKUtility.getBankOfferText(context3, context3.getString(R.string.instant_discount_applied_successfully, new Object[]{hybridPaymentOffer.getTotalInstantDiscount()}), hybridPaymentOffer));
            this.cashBackTextVisibility.set(8);
            setPaySecurelyText();
            this.applyPromoFailed = false;
            this.listener.changeOfferTextBgColor(b.c(this.context, R.color.color_e8f8f1), b.c(this.context, R.color.color_21c17a), false);
        } else {
            this.tagImageVisibility.set(8);
            this.bankOfferVisibility.set(8);
            this.cashBackTextVisibility.set(8);
            setValidatePromoText(false);
        }
    }

    public void getBankOffers() {
        if (!this.isVpaVerified) {
            if (this.isUpiIntentSelected) {
                fetchConvenienceFee();
            } else {
                verifyVPA((View) null, false, true);
            }
        } else if (DirectPaymentBL.getInstance().isBankOffersAvailable()) {
            if ((SDKUtility.isHybridCase() ? this.paymentModes.getHybridPaymentOffer() : this.paymentModes.getPaymentOffer()) != null) {
                showOffers();
                fetchConvenienceFee();
                return;
            }
            ApplyPromoRequest.PaymentOption paymentOption = new ApplyPromoRequest.PaymentOption();
            StringBuilder sb = new StringBuilder();
            sb.append(SDKUtility.getDiffAmount());
            paymentOption.setTransactionAmount(sb.toString());
            paymentOption.setPayMethod(PayMethodType.UPI.name());
            paymentOption.setVpa(this.vpaAddress);
            this.paymentModes.setHybridPaymentOffer((ApplyPromoResponse.PaymentOffer) null);
            this.paymentModes.setPaymentOffer((ApplyPromoResponse.PaymentOffer) null);
            this.listener.disableProceedButton();
            setPaySecurelyText();
            this.bankOfferVisibility.set(8);
            this.checkOfferVisibility.set(8);
            showLoading(this.context.getString(R.string.native_checking_offers));
            NativeSDKRepository.getInstance().applyOffer(APIReqtGenerator.getApplyPromoRequestObj(true, paymentOption, MerchantBL.getMerchantInstance().getAppInvokePromoCode()), new PaymentMethodDataSource.Callback<ApplyPromoResponse>() {
                private boolean isHybrid = SDKUtility.isHybridCase();

                public void onResponse(ApplyPromoResponse applyPromoResponse) {
                    UpiCollectViewModelNew.this.checkOfferVisibility.set(8);
                    UpiCollectViewModelNew.this.listener.enableProceedButton();
                    UpiCollectViewModelNew.this.checkOfferVisibility.set(8);
                    UpiCollectViewModelNew.this.hideLoading();
                    if (DirectPaymentBL.getInstance().getPaytmBaseView() instanceof UpiCollectViewNew) {
                        if (applyPromoResponse == null || applyPromoResponse.getBody() == null) {
                            UpiCollectViewModelNew.this.showCheckOffer();
                            UpiCollectViewModelNew.this.bankOfferVisibility.set(8);
                            UpiCollectViewModelNew.this.setPaySecurelyText();
                            UpiCollectViewModelNew.this.hideLoading();
                            UpiCollectViewModelNew.this.setValidatePromoText(false);
                            DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
                        } else if (applyPromoResponse.getBody().getPaymentOffer() != null) {
                            if (this.isHybrid) {
                                UpiCollectViewModelNew.this.paymentModes.setHybridPaymentOffer(applyPromoResponse.getBody().getPaymentOffer());
                            } else {
                                UpiCollectViewModelNew.this.paymentModes.setPaymentOffer(applyPromoResponse.getBody().getPaymentOffer());
                            }
                            SDKUtils.setPromoCodeFromApplyPromoResponse(applyPromoResponse);
                            UpiCollectViewModelNew.this.showOffers();
                        } else {
                            UpiCollectViewModelNew.this.setValidatePromoText(false);
                            DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
                        }
                        UpiCollectViewModelNew.this.fetchConvenienceFee();
                    }
                }

                public void onErrorResponse(VolleyError volleyError, ApplyPromoResponse applyPromoResponse) {
                    UpiCollectViewModelNew.this.listener.enableProceedButton();
                    UpiCollectViewModelNew.this.bankOfferVisibility.set(8);
                    UpiCollectViewModelNew.this.showCheckOffer();
                    UpiCollectViewModelNew.this.hideLoading();
                    UpiCollectViewModelNew.this.cashBackTextVisibility.set(8);
                    UpiCollectViewModelNew.this.setValidatePromoText(false);
                    DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void fetchConvenienceFee() {
        buildPaymentIntent();
        if (ConvenienceFeeController.getInstance().isConvenienceFeeEnabled()) {
            ArrayList<PaymentIntent> cachedConvenienceFeeIntent = ConvenienceFeeController.getInstance().getCachedConvenienceFeeIntent(this.paymentIntents);
            if (cachedConvenienceFeeIntent != null) {
                this.paymentIntents = cachedConvenienceFeeIntent;
                configureConvFeeView();
                return;
            }
            getConvenienceFee();
        }
    }

    private void buildPaymentIntent() {
        this.paymentIntents = ConvenienceFeeController.getInstance().buildPaymentIntent(PayMethodType.UPI.name(), (ArrayList<String>) null, (ArrayList<String>) null, (CardPaymentIntentData) null, (String) null, Double.valueOf(getTotalInstantDiscount()));
    }

    private void getConvenienceFee() {
        if (!SDKUtility.isNetworkAvailable(this.context)) {
            DialogUtility.showNoInternetDialog(this.context, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            return;
        }
        this.listener.disableProceedButton();
        showLoading(this.context.getString(R.string.conv_fee_fetching));
        PaytmSDKRequestClient.CallbackData callbackData = new PaytmSDKRequestClient.CallbackData();
        callbackData.setPaymentIntents(this.paymentIntents);
        SDKUtility.addOfferInCallBackData(callbackData, getPaymentOffer());
        DirectPaymentBL.getInstance().getRequestClient().verifyCart(callbackData, new PaytmSDKRequestClient.OnVerifyResponse() {
            public void onVerifySuccess(PaytmSDKRequestClient.VerifyResponseData verifyResponseData) {
                UpiCollectViewModelNew.this.hideLoading();
                if (!UpiCollectViewModelNew.this.isAlreadySelected) {
                    UpiCollectViewModelNew.this.listener.enableProceedButton();
                } else if (verifyResponseData == null || verifyResponseData.getConvFeeResponse() == null) {
                    UpiCollectViewModelNew.this.listener.disableProceedButton();
                    UpiCollectViewModelNew.this.intentConvFeeTextVisibility.set(8);
                    UpiCollectViewModelNew.this.collectConvFeeTextVisibility.set(8);
                    SDKUtility.handleVerticalError((PaytmSDKRequestClient.ApiResponseError) null, UpiCollectViewModelNew.this.context);
                } else {
                    ArrayList unused = UpiCollectViewModelNew.this.paymentIntents = ConvenienceFeeController.Companion.getInstance().setConvFeeResponse(verifyResponseData.getConvFeeResponse(), (ArrayList<PaymentIntent>) UpiCollectViewModelNew.this.paymentIntents, verifyResponseData.getVerifyModel());
                    UpiCollectViewModelNew.this.configureConvFeeView();
                    UpiCollectViewModelNew.this.listener.enableProceedButton();
                }
            }

            public void onVerifyError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
                UpiCollectViewModelNew.this.hideLoading();
                UpiCollectViewModelNew.this.listener.disableProceedButton();
                SDKUtility.handleVerticalError(apiResponseError, UpiCollectViewModelNew.this.context);
            }
        });
    }

    /* access modifiers changed from: private */
    public void configureConvFeeView() {
        if (this.isAlreadySelected) {
            String str = null;
            Iterator<PaymentIntent> it2 = this.paymentIntents.iterator();
            double d2 = 0.0d;
            while (it2.hasNext()) {
                PaymentIntent next = it2.next();
                d2 += next.getConvFee();
                String convFeeText = next.getConvFeeText();
                if (next.getMode().equalsIgnoreCase(PayMethodType.UPI.name())) {
                    this.instrumentConvenienceFee = next.getConvFee();
                    setPaySecurelyText();
                    setAmountIfNeeded();
                    if (getPaymentOffer() != null && !TextUtils.isEmpty(getPaymentOffer().getTotalCashbackAmount())) {
                        this.cashBackTextVisibility.set(0);
                        this.cashBackText.set(this.context.getString(R.string.effective_cashback_price, new Object[]{SDKUtility.getDoubleFormaAmount((next.getTxnAmount() + next.getConvFee()) - SDKUtility.parseDouble(getPaymentOffer().getTotalCashbackAmount()))}));
                    }
                }
                str = convFeeText;
            }
            if (!this.isUpiIntentSelected || !isUpiIntentEnabled()) {
                this.collectConvFeeTextVisibility.set(0);
                this.intentConvFeeTextVisibility.set(8);
                SDKUtility.setConvenienceFeeText(this.collectConvFeeText, SDKUtility.priceWithoutDecimal(d2), str, this.context);
            } else {
                this.intentConvFeeTextVisibility.set(0);
                this.collectConvFeeTextVisibility.set(8);
                SDKUtility.setConvenienceFeeText(this.intentConvFeeText, SDKUtility.priceWithoutDecimal(d2), str, this.context);
            }
            if (d2 <= 0.0d) {
                this.collectConvFeeTextVisibility.set(8);
                this.intentConvFeeTextVisibility.set(8);
            }
        }
    }

    private void showLoading(String str) {
        if (this.isUpiIntentSelected) {
            this.intentLoaderMsg.set(str);
            this.intentLoaderVisibility.set(0);
        } else {
            this.collectLoaderMsg.set(str);
            this.collectLoaderVisibility.set(0);
        }
        this.collectConvFeeTextVisibility.set(8);
        this.intentConvFeeTextVisibility.set(8);
        this.listener.startCheckingOfferAnimation();
    }

    /* access modifiers changed from: private */
    public void hideLoading() {
        this.intentLoaderVisibility.set(8);
        this.collectLoaderVisibility.set(8);
        this.listener.stopCheckingOfferAnimation();
    }

    public void clearOffer() {
        this.bankOfferVisibility.set(8);
        showCheckOffer();
        hideLoading();
        this.cashBackTextVisibility.set(8);
        this.tagImageVisibility.set(0);
        this.paymentModes.setHybridPaymentOffer((ApplyPromoResponse.PaymentOffer) null);
        this.paymentModes.setPaymentOffer((ApplyPromoResponse.PaymentOffer) null);
        setPaySecurelyText();
    }

    public ApplyPromoResponse.PaymentOffer getPaymentOffer() {
        if (SDKUtility.isHybridCase()) {
            return this.paymentModes.getHybridPaymentOffer();
        }
        return this.paymentModes.getPaymentOffer();
    }

    private double getTotalInstantDiscount() {
        ApplyPromoResponse.PaymentOffer paymentOffer = getPaymentOffer();
        if (paymentOffer == null) {
            return 0.0d;
        }
        return SDKUtility.parseDouble(paymentOffer.getTotalInstantDiscount());
    }

    public String getNetPayableAmount() {
        return SDKUtility.getNetPayableAmount(this.context, getTotalInstantDiscount(), this.instrumentConvenienceFee);
    }

    public Object getVerifyResponseModel() {
        return ConvenienceFeeController.Companion.getInstance().getVerifyResponseModel(this.paymentIntents);
    }

    public void setPaySecurelyText() {
        this.paySecurelyText.set(SDKUtility.getNetPaySecurelyText(this.context, getTotalInstantDiscount(), this.instrumentConvenienceFee));
    }

    public ArrayList<PaymentIntent> getPaymentIntent() {
        if (this.paymentIntents == null) {
            buildPaymentIntent();
        }
        return this.paymentIntents;
    }

    public boolean isHybridDisabled() {
        return this.paymentModes.isHybridDisabled();
    }

    public boolean isEmiHybridDisabled() {
        return this.paymentModes.isEmiHybridDisabled();
    }

    public void setValidatePromoText(boolean z) {
        super.setValidatePromoText();
        if (SDKUtility.shouldShowValidatePromoError() && z && !DirectPaymentBL.getInstance().getPaymentFlowBankOffer().equals(SDKConstants.ADDANDPAY)) {
            this.bankOfferVisibility.set(8);
            this.intentLoaderVisibility.set(0);
            this.intentLoaderMsg.set(this.context.getString(R.string.applied_promocode_not_valid));
            this.listener.changeOfferTextColor(b.c(this.context, R.color.color_fd5c5c));
        }
    }
}
