package net.one97.paytm.nativesdk.paymethods.viewmodel;

import android.app.Application;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import androidx.databinding.i;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.appsflyer.internal.referrer.Payload;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyPostRequest;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.SavedMandateBanksItem;
import net.one97.paytm.nativesdk.common.Requester.APIReqtGenerator;
import net.one97.paytm.nativesdk.common.model.AccountBalance;
import net.one97.paytm.nativesdk.common.model.BalanceInfo;
import net.one97.paytm.nativesdk.common.model.Body;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.CustomVolleyError;
import net.one97.paytm.nativesdk.common.model.IsDisabled;
import net.one97.paytm.nativesdk.common.model.MerchantPayOption;
import net.one97.paytm.nativesdk.common.model.MinAmount;
import net.one97.paytm.nativesdk.common.model.PayChannelOptions;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.model.SavedInstruments;
import net.one97.paytm.nativesdk.common.model.SelectedInstrument;
import net.one97.paytm.nativesdk.common.viewmodel.BaseNativeViewModel;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;
import net.one97.paytm.nativesdk.paymethods.listeners.CashierInstrumentListner;
import net.one97.paytm.nativesdk.paymethods.listeners.OnBottomSheetChangeListener;
import net.one97.paytm.nativesdk.paymethods.listeners.OnPayMethodSelectedListener;
import net.one97.paytm.nativesdk.paymethods.model.PaymentInstrumentView;
import net.one97.paytm.nativesdk.paymethods.model.fetchBalance.CJRFetchBalanceResponse;
import net.one97.paytm.nativesdk.transcation.PayUtility;

public class InstrumentSheetViewModel extends BaseNativeViewModel implements Response.ErrorListener, Response.Listener<Object> {
    private i<String> amount = new i<>();
    private final CashierInstrumentListner cashierInstrumentListner;
    private final Application context;
    private String defaultPayOption;
    private String gaPayOptions = "";
    private boolean isDisableInstrument;
    private final OnBottomSheetChangeListener mBottomSheetChangeListener;
    private i<String> mInstrumentPrimaryInfo = new i<>();
    private i<String> mInstrumentSecondaryInfo = new i<>();
    private final y<List<PaymentInstrumentView>> mInstrumentViewsList = new y<>();
    private List<PaymentInstrumentView> mInstrumentsList = new ArrayList();
    private String mPaymentMode;
    private OnPayMethodSelectedListener payMethodSelectedListener;
    private PaymentInstrumentView.PostpaidView postpaidView;
    private String savedPayOptions = "";
    private i<String> titleForCashierSheet = new i<>();

    public final OnPayMethodSelectedListener getPayMethodSelectedListener() {
        return this.payMethodSelectedListener;
    }

    public final void setPayMethodSelectedListener(OnPayMethodSelectedListener onPayMethodSelectedListener) {
        this.payMethodSelectedListener = onPayMethodSelectedListener;
    }

    public InstrumentSheetViewModel(String str, String str2, OnPayMethodSelectedListener onPayMethodSelectedListener, OnBottomSheetChangeListener onBottomSheetChangeListener, boolean z, String str3, CashierInstrumentListner cashierInstrumentListner2, Application application) {
        k.c(str, "primaryInfo");
        k.c(str2, "secondaryInfo");
        k.c(onBottomSheetChangeListener, "mBottomSheetChangeListener");
        k.c(str3, "mPaymentMode");
        k.c(cashierInstrumentListner2, "cashierInstrumentListner");
        k.c(application, "context");
        this.payMethodSelectedListener = onPayMethodSelectedListener;
        this.mBottomSheetChangeListener = onBottomSheetChangeListener;
        this.isDisableInstrument = z;
        this.mPaymentMode = str3;
        this.cashierInstrumentListner = cashierInstrumentListner2;
        this.context = application;
        this.mInstrumentPrimaryInfo.set(String.valueOf(str));
        this.mInstrumentSecondaryInfo.set(String.valueOf(str2));
    }

    public final Application getContext() {
        return this.context;
    }

    public final y<List<PaymentInstrumentView>> getMInstrumentViewsList$nativesdk_debug() {
        return this.mInstrumentViewsList;
    }

    public final List<PaymentInstrumentView> getMInstrumentsList() {
        return this.mInstrumentsList;
    }

    public final void setMInstrumentsList(List<PaymentInstrumentView> list) {
        k.c(list, "<set-?>");
        this.mInstrumentsList = list;
    }

    public final LiveData<List<PaymentInstrumentView>> getInstrumentViewList() {
        return this.mInstrumentViewsList;
    }

    public final void addPaymentViews() {
        addPaymentViews(SDKUtils.INSTANCE.isAddMoneyPaymentFlow());
    }

    public static /* synthetic */ void addPaymentViews$default(InstrumentSheetViewModel instrumentSheetViewModel, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                z = true;
            }
            instrumentSheetViewModel.addPaymentViews(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPaymentViews");
    }

    public final void addPaymentViews(boolean z) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(getViewModelScope(this), (f) null, (CoroutineStart) null, new InstrumentSheetViewModel$addPaymentViews$1(this, z, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void initialize(boolean z) {
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (instance.isWalletAmountSufficientToPay() || !z) {
            DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
            k.a((Object) instance2, "DirectPaymentBL.getInstance()");
            instance2.setSelectedPaymentMode(SDKConstants.HYBRID);
            return;
        }
        DirectPaymentBL instance3 = DirectPaymentBL.getInstance();
        k.a((Object) instance3, "DirectPaymentBL.getInstance()");
        instance3.setSelectedPaymentMode(SDKConstants.ADDANDPAY);
    }

    /* access modifiers changed from: private */
    public final void addMGVInstrument() {
        ArrayList<PayChannelOptions> payChannelOptions;
        PayChannelOptions payChannelOptions2;
        BalanceInfo balanceInfo;
        AccountBalance accountBalance;
        String value;
        Double b2;
        PaymentModes instrument = DirectPaymentBL.getInstance().getInstrument(PayMethodType.GIFT_VOUCHER);
        if (instrument != null && (payChannelOptions = instrument.getPayChannelOptions()) != null && (payChannelOptions2 = (PayChannelOptions) kotlin.a.k.e(payChannelOptions)) != null && (balanceInfo = payChannelOptions2.getBalanceInfo()) != null && (accountBalance = balanceInfo.getAccountBalance()) != null && (value = accountBalance.getValue()) != null && (b2 = p.b(value)) != null) {
            double doubleValue = b2.doubleValue();
            IsDisabled isDisabled = instrument.getIsDisabled();
            if (isDisabled != null && !isDisabled.getStatus() && Double.compare(doubleValue, 0.0d) > 0) {
                MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
                k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
                if (Double.compare(doubleValue, SDKUtility.parseDouble(merchantInstance.getAmount())) >= 0) {
                    this.mInstrumentsList.add(new PaymentInstrumentView.GiftVoucher(instrument, true));
                } else {
                    this.mInstrumentsList.add(new PaymentInstrumentView.GiftVoucher(instrument, false));
                }
            }
        }
    }

    public void postInstrumentsToUI() {
        if (shouldfollowPriorityOrder()) {
            Collection arrayList = new ArrayList();
            for (Object next : this.mInstrumentsList) {
                if (((PaymentInstrumentView) next).getPriorityOrder() != -1) {
                    arrayList.add(next);
                }
            }
            List a2 = kotlin.a.k.a((List) arrayList, new InstrumentSheetViewModel$postInstrumentsToUI$$inlined$sortedBy$1());
            this.mInstrumentsList.clear();
            this.mInstrumentsList.addAll(a2);
        }
        this.mInstrumentViewsList.setValue(this.mInstrumentsList);
    }

    public boolean shouldfollowPriorityOrder() {
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        if (merchantInstance.isAppInvoke()) {
            MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
            if (merchantInstance2.isPriorityEnableForAppInvokeFull()) {
                return true;
            }
        }
        MerchantBL merchantInstance3 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance3, "MerchantBL.getMerchantInstance()");
        if (merchantInstance3.isAppInvoke()) {
            return false;
        }
        MerchantBL merchantInstance4 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance4, "MerchantBL.getMerchantInstance()");
        return merchantInstance4.isPriorityEnableForOnUS();
    }

    /* access modifiers changed from: private */
    public final void addWalletView() {
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (instance.isWalletEnabledOnMerchant()) {
            PaymentModes instrument = DirectPaymentBL.getInstance().getInstrument(PayMethodType.BALANCE);
            DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
            k.a((Object) instance2, "DirectPaymentBL.getInstance()");
            if (!p.a(SDKConstants.HYBRID, instance2.getPaymentFlowAvailable(), true)) {
                DirectPaymentBL instance3 = DirectPaymentBL.getInstance();
                k.a((Object) instance3, "DirectPaymentBL.getInstance()");
                if (!p.a(SDKConstants.ADDANDPAY, instance3.getPaymentFlowAvailable(), true)) {
                    DirectPaymentBL instance4 = DirectPaymentBL.getInstance();
                    k.a((Object) instance4, "DirectPaymentBL.getInstance()");
                    if (instance4.isWalletAmountSufficientToPay()) {
                        List<PaymentInstrumentView> list = this.mInstrumentsList;
                        k.a((Object) instrument, "wallet");
                        list.add(new PaymentInstrumentView.WalletView(instrument, true));
                        return;
                    }
                    List<PaymentInstrumentView> list2 = this.mInstrumentsList;
                    k.a((Object) instrument, "wallet");
                    list2.add(new PaymentInstrumentView.WalletView(instrument, false));
                    return;
                }
            }
            DirectPaymentBL instance5 = DirectPaymentBL.getInstance();
            k.a((Object) instance5, "DirectPaymentBL.getInstance()");
            if (instance5.isRemainingAmountInDecimals()) {
                DirectPaymentBL instance6 = DirectPaymentBL.getInstance();
                k.a((Object) instance6, "DirectPaymentBL.getInstance()");
                if (!p.a(SDKConstants.ADDANDPAY, instance6.getPaymentFlowAvailable(), true)) {
                    List<PaymentInstrumentView> list3 = this.mInstrumentsList;
                    k.a((Object) instrument, "wallet");
                    list3.add(new PaymentInstrumentView.WalletView(instrument, false));
                    return;
                }
            }
            List<PaymentInstrumentView> list4 = this.mInstrumentsList;
            k.a((Object) instrument, "wallet");
            list4.add(new PaymentInstrumentView.WalletView(instrument, true));
        }
    }

    /* access modifiers changed from: private */
    public final void addVpas(boolean z) {
        List list;
        Object obj;
        if (!z) {
            DirectPaymentBL instance = DirectPaymentBL.getInstance();
            k.a((Object) instance, "DirectPaymentBL.getInstance()");
            list = instance.getMerchantModes();
        } else {
            DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
            k.a((Object) instance2, "DirectPaymentBL.getInstance()");
            list = instance2.getAddMoneyModes();
        }
        if (list != null) {
            Iterator it2 = list.iterator();
            while (true) {
                String str = null;
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                PaymentModes paymentModes = (PaymentModes) obj;
                String name = PayMethodType.UPI.name();
                if (paymentModes != null) {
                    str = paymentModes.getPaymentMode();
                }
                if (p.a(name, str, true)) {
                    break;
                }
            }
            PaymentModes paymentModes2 = (PaymentModes) obj;
            if (paymentModes2 != null) {
                List<VpaBankAccountDetail> allVpas = SDKUtility.getAllVpas();
                String uPIPriority = getUPIPriority();
                Collection collection = allVpas;
                if (collection != null && (true ^ collection.isEmpty())) {
                    for (VpaBankAccountDetail vpaBankAccountDetail : (List) collection) {
                        List<PaymentInstrumentView> list2 = this.mInstrumentsList;
                        if (paymentModes2 == null) {
                            k.a();
                        }
                        k.a((Object) vpaBankAccountDetail, "it");
                        list2.add(new PaymentInstrumentView.UPIPushView(paymentModes2, vpaBankAccountDetail, uPIPriority));
                    }
                    setDefaultPayOption(SDKConstants.GA_KEY_UPI);
                }
                if (SDKUtils.isToShowUpiOnboardingView()) {
                    this.mInstrumentsList.add(new PaymentInstrumentView.UpiOnboardingView(paymentModes2, uPIPriority));
                    this.mInstrumentsList.add(new PaymentInstrumentView.Divider());
                }
            }
        }
    }

    private final String getUPIPriority() {
        Body body;
        MerchantPayOption merchantPayOption;
        UpiProfile upiProfile;
        Body body2;
        MerchantPayOption addMoneyPayOption;
        UpiProfile upiProfile2;
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (p.a(SDKConstants.ADDANDPAY, instance.getSelectedPaymentMode(), true)) {
            DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
            k.a((Object) instance2, "DirectPaymentBL.getInstance()");
            CJPayMethodResponse cjPayMethodResponse = instance2.getCjPayMethodResponse();
            if (cjPayMethodResponse == null || (body2 = cjPayMethodResponse.getBody()) == null || (addMoneyPayOption = body2.getAddMoneyPayOption()) == null || (upiProfile2 = addMoneyPayOption.getUpiProfile()) == null) {
                return null;
            }
            return upiProfile2.getPriority();
        }
        DirectPaymentBL instance3 = DirectPaymentBL.getInstance();
        k.a((Object) instance3, "DirectPaymentBL.getInstance()");
        CJPayMethodResponse cjPayMethodResponse2 = instance3.getCjPayMethodResponse();
        if (cjPayMethodResponse2 == null || (body = cjPayMethodResponse2.getBody()) == null || (merchantPayOption = body.getMerchantPayOption()) == null || (upiProfile = merchantPayOption.getUpiProfile()) == null) {
            return null;
        }
        return upiProfile.getPriority();
    }

    private final void addSavedMandateView() {
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (instance.getMerchantAccountDetails() == null) {
            PaymentModes instrument = DirectPaymentBL.getInstance().getInstrument(PayMethodType.BANK_MANDATE);
            DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
            k.a((Object) instance2, "DirectPaymentBL.getInstance()");
            if (instance2.getSavedMandateBanksItemList() != null) {
                DirectPaymentBL instance3 = DirectPaymentBL.getInstance();
                k.a((Object) instance3, "DirectPaymentBL.getInstance()");
                if (instance3.getSavedMandateBanksItemList().size() > 0) {
                    DirectPaymentBL instance4 = DirectPaymentBL.getInstance();
                    k.a((Object) instance4, "DirectPaymentBL.getInstance()");
                    for (SavedMandateBanksItem savedMandateView : instance4.getSavedMandateBanksItemList()) {
                        List<PaymentInstrumentView> list = this.mInstrumentsList;
                        k.a((Object) instrument, "bankMandate");
                        list.add(new PaymentInstrumentView.SavedMandateView(instrument, savedMandateView));
                    }
                }
            }
        }
    }

    private final void addMandateView() {
        PaymentModes instrument = DirectPaymentBL.getInstance().getInstrument(PayMethodType.BANK_MANDATE);
        List<PaymentInstrumentView> list = this.mInstrumentsList;
        k.a((Object) instrument, "bankMandate");
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        list.add(new PaymentInstrumentView.BankMandateView(instrument, instance.getMerchantAccountDetails()));
    }

    /* access modifiers changed from: private */
    public final void initializeEmiParameters(boolean z) {
        List list;
        double d2;
        Body body;
        MerchantPayOption merchantPayOption;
        Body body2;
        MerchantPayOption addMoneyPayOption;
        ArrayList<PaymentModes> arrayList = null;
        if (z) {
            DirectPaymentBL instance = DirectPaymentBL.getInstance();
            k.a((Object) instance, "DirectPaymentBL.getInstance()");
            CJPayMethodResponse cjPayMethodResponse = instance.getCjPayMethodResponse();
            if (!(cjPayMethodResponse == null || (body2 = cjPayMethodResponse.getBody()) == null || (addMoneyPayOption = body2.getAddMoneyPayOption()) == null)) {
                arrayList = addMoneyPayOption.getPaymentModes();
            }
            list = arrayList;
        } else {
            DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
            k.a((Object) instance2, "DirectPaymentBL.getInstance()");
            CJPayMethodResponse cjPayMethodResponse2 = instance2.getCjPayMethodResponse();
            if (!(cjPayMethodResponse2 == null || (body = cjPayMethodResponse2.getBody()) == null || (merchantPayOption = body.getMerchantPayOption()) == null)) {
                arrayList = merchantPayOption.getPaymentModes();
            }
            list = arrayList;
        }
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            Iterator it2 = ((ArrayList) list).iterator();
            while (it2.hasNext()) {
                PaymentModes paymentModes = (PaymentModes) it2.next();
                k.a((Object) paymentModes, "merchantPayMethod");
                if (p.a(paymentModes.getPaymentMode(), PayMethodType.EMI.name(), true)) {
                    double d3 = 0.0d;
                    if (ExtensionsKt.isNotNullNotEmpty(paymentModes.getPayChannelOptions())) {
                        PayChannelOptions payChannelOptions = paymentModes.getPayChannelOptions().get(0);
                        k.a((Object) payChannelOptions, "payChannelOption1");
                        MinAmount minAmount = payChannelOptions.getMinAmount();
                        k.a((Object) minAmount, "payChannelOption1.minAmount");
                        double parseDouble = SDKUtility.parseDouble(minAmount.getValue());
                        MinAmount maxAmount = payChannelOptions.getMaxAmount();
                        k.a((Object) maxAmount, "payChannelOption1.maxAmount");
                        double parseDouble2 = SDKUtility.parseDouble(maxAmount.getValue());
                        Iterator<PayChannelOptions> it3 = paymentModes.getPayChannelOptions().iterator();
                        d2 = parseDouble2;
                        d3 = parseDouble;
                        while (it3.hasNext()) {
                            PayChannelOptions next = it3.next();
                            k.a((Object) next, "payChannelOption");
                            MinAmount minAmount2 = next.getMinAmount();
                            k.a((Object) minAmount2, "payChannelOption.minAmount");
                            double parseDouble3 = SDKUtility.parseDouble(minAmount2.getValue());
                            MinAmount maxAmount2 = next.getMaxAmount();
                            k.a((Object) maxAmount2, "payChannelOption.maxAmount");
                            double parseDouble4 = SDKUtility.parseDouble(maxAmount2.getValue());
                            if (d3 >= parseDouble3) {
                                d3 = parseDouble3;
                            }
                            if (d2 <= parseDouble4) {
                                d2 = parseDouble4;
                            }
                        }
                    } else {
                        d2 = 0.0d;
                    }
                    DirectPaymentBL instance3 = DirectPaymentBL.getInstance();
                    k.a((Object) instance3, "DirectPaymentBL.getInstance()");
                    instance3.setEmiMin(d3);
                    DirectPaymentBL instance4 = DirectPaymentBL.getInstance();
                    k.a((Object) instance4, "DirectPaymentBL.getInstance()");
                    instance4.setEmiMax(d2);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void addPaymentFlowSpecificViews(boolean z) {
        CJPayMethodResponse cjPayMethodResponse;
        Body body;
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        if (instance != null && (cjPayMethodResponse = instance.getCjPayMethodResponse()) != null && (body = cjPayMethodResponse.getBody()) != null) {
            DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
            k.a((Object) instance2, "DirectPaymentBL.getInstance()");
            if (instance2.isWalletAmountSufficientToPay() || !z) {
                MerchantPayOption merchantPayOption = body.getMerchantPayOption();
                if (merchantPayOption != null) {
                    Collection paymentModes = merchantPayOption.getPaymentModes();
                    if (paymentModes != null && (!paymentModes.isEmpty())) {
                        addPaytmInstruments$default(this, (ArrayList) paymentModes, false, 2, (Object) null);
                    }
                    Collection savedInstruments = merchantPayOption.getSavedInstruments();
                    if (savedInstruments != null && (!savedInstruments.isEmpty())) {
                        addSavedCards((ArrayList) savedInstruments);
                    }
                    PaymentInstrumentView.PostpaidView postpaidView2 = this.postpaidView;
                    if (postpaidView2 != null) {
                        this.mInstrumentsList.add(postpaidView2);
                    }
                    Collection savedMandateBanks = merchantPayOption.getSavedMandateBanks();
                    if (savedMandateBanks != null && (!savedMandateBanks.isEmpty())) {
                        DirectPaymentBL instance3 = DirectPaymentBL.getInstance();
                        k.a((Object) instance3, "DirectPaymentBL.getInstance()");
                        if (instance3.isBankMandateEnabled()) {
                            addSavedMandateView();
                        }
                    }
                    Collection paymentModes2 = merchantPayOption.getPaymentModes();
                    if (paymentModes2 != null && (!paymentModes2.isEmpty())) {
                        addPgInstruments((ArrayList) paymentModes2);
                        return;
                    }
                    return;
                }
                return;
            }
            MerchantPayOption addMoneyPayOption = body.getAddMoneyPayOption();
            if (addMoneyPayOption != null) {
                Collection paymentModes3 = addMoneyPayOption.getPaymentModes();
                if (paymentModes3 != null && (!paymentModes3.isEmpty())) {
                    addPaytmInstruments((ArrayList) paymentModes3, true);
                }
                Collection savedInstruments2 = addMoneyPayOption.getSavedInstruments();
                if (savedInstruments2 != null && (!savedInstruments2.isEmpty())) {
                    addSavedCards((ArrayList) savedInstruments2);
                }
                PaymentInstrumentView.PostpaidView postpaidView3 = this.postpaidView;
                if (postpaidView3 != null) {
                    this.mInstrumentsList.add(postpaidView3);
                }
                Collection paymentModes4 = addMoneyPayOption.getPaymentModes();
                if (paymentModes4 != null && (!paymentModes4.isEmpty())) {
                    addPgInstruments((ArrayList) paymentModes4);
                }
            }
        }
    }

    private final void addPgInstruments(ArrayList<PaymentModes> arrayList) {
        IsDisabled isDisabled;
        addSortingIndex(arrayList);
        sortPaymentMethods(arrayList);
        StringBuilder sb = new StringBuilder();
        PaymentInstrumentView.CODView cODView = null;
        for (PaymentModes paymentModes : arrayList) {
            String paymentMode = paymentModes.getPaymentMode();
            k.a((Object) paymentMode, "it.paymentMode");
            if (paymentMode != null) {
                String lowerCase = paymentMode.toLowerCase();
                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                if (k.a((Object) lowerCase, (Object) ExtensionsKt.nameToLowercase(PayMethodType.CREDIT_CARD))) {
                    IsDisabled isDisabled2 = paymentModes.getIsDisabled();
                    if (isDisabled2 == null || !isDisabled2.getStatus()) {
                        this.mInstrumentsList.add(new PaymentInstrumentView.CreditCardView(paymentModes));
                        sb.append("Credit Card, ");
                    }
                } else if (k.a((Object) lowerCase, (Object) ExtensionsKt.nameToLowercase(PayMethodType.DEBIT_CARD))) {
                    IsDisabled isDisabled3 = paymentModes.getIsDisabled();
                    if (isDisabled3 == null || !isDisabled3.getStatus()) {
                        this.mInstrumentsList.add(new PaymentInstrumentView.DebitCardView(paymentModes));
                        sb.append("Debit Card, ");
                    }
                } else if (k.a((Object) lowerCase, (Object) ExtensionsKt.nameToLowercase(PayMethodType.UPI))) {
                    this.mInstrumentsList.add(new PaymentInstrumentView.UPIColletView(paymentModes));
                    sb.append("Upi Collect, ");
                    k.a((Object) sb, "buffer.append(SDKConstan…UPI_COllECT).append(\", \")");
                } else if (k.a((Object) lowerCase, (Object) ExtensionsKt.nameToLowercase(PayMethodType.EMI))) {
                    this.mInstrumentsList.add(new PaymentInstrumentView.EMIView(paymentModes));
                    sb.append("Emi, ");
                    k.a((Object) sb, "buffer.append(SDKConstan….GA_KEY_EMI).append(\", \")");
                } else if (k.a((Object) lowerCase, (Object) ExtensionsKt.nameToLowercase(PayMethodType.NET_BANKING))) {
                    this.mInstrumentsList.add(new PaymentInstrumentView.NetBankingView(paymentModes));
                    sb.append("Netbanking, ");
                    k.a((Object) sb, "buffer.append(SDKConstan…_NETBANKING).append(\", \")");
                } else if (k.a((Object) lowerCase, (Object) ExtensionsKt.nameToLowercase(PayMethodType.COD))) {
                    IsDisabled isDisabled4 = paymentModes.getIsDisabled();
                    if (isDisabled4 == null || !isDisabled4.getStatus()) {
                        cODView = new PaymentInstrumentView.CODView(paymentModes);
                        sb.append("Cod, ");
                    }
                } else if (k.a((Object) lowerCase, (Object) ExtensionsKt.nameToLowercase(PayMethodType.WALLET))) {
                    this.mInstrumentsList.add(new PaymentInstrumentView.WalletView(paymentModes, true));
                    sb.append("AOA Wallet, ");
                    k.a((Object) sb, "buffer.append(SDKConstan…_AOA_WALLET).append(\", \")");
                } else if (k.a((Object) lowerCase, (Object) ExtensionsKt.nameToLowercase(PayMethodType.BANK_MANDATE)) && ((isDisabled = paymentModes.getIsDisabled()) == null || !isDisabled.getStatus())) {
                    DirectPaymentBL instance = DirectPaymentBL.getInstance();
                    k.a((Object) instance, "DirectPaymentBL.getInstance()");
                    if (instance.isBankMandateEnabled()) {
                        addMandateView();
                        sb.append("new_bank_mandate, ");
                    }
                }
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        if (cODView != null) {
            this.mInstrumentsList.add(cODView);
        }
        String sb2 = sb.toString();
        k.a((Object) sb2, "buffer.toString()");
        this.gaPayOptions = sb2;
    }

    private final void addSortingIndex(ArrayList<PaymentModes> arrayList) {
        Iterator<PaymentModes> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            PaymentModes next = it2.next();
            k.a((Object) next, "merchantPayMethod");
            if (next.getIsDisabled() != null) {
                IsDisabled isDisabled = next.getIsDisabled();
                k.a((Object) isDisabled, "merchantPayMethod.isDisabled");
                if (isDisabled.getStatus()) {
                }
            }
            if (p.a(next.getPaymentMode(), PayMethodType.CREDIT_CARD.name(), true)) {
                next.setSortingWeight(2);
                setDefaultPayOption("Credit Card");
            } else if (p.a(next.getPaymentMode(), PayMethodType.DEBIT_CARD.name(), true)) {
                next.setSortingWeight(1);
                setDefaultPayOption("Debit Card");
            } else if (p.a(next.getPaymentMode(), PayMethodType.NET_BANKING.name(), true)) {
                next.setSortingWeight(4);
                setDefaultPayOption(SDKConstants.GA_KEY_NETBANKING);
            } else if (p.a(next.getPaymentMode(), PayMethodType.UPI.name(), true)) {
                next.setSortingWeight(3);
                setDefaultPayOption(SDKConstants.GA_KEY_UPI_COllECT);
            } else if (p.a(next.getPaymentMode(), PayMethodType.EMI.name(), true)) {
                next.setSortingWeight(5);
                setDefaultPayOption(SDKConstants.GA_KEY_EMI);
            } else if (p.a(next.getPaymentMode(), PayMethodType.COD.name(), true)) {
                next.setSortingWeight(6);
                setDefaultPayOption(SDKConstants.GA_KEY_COD);
            } else if (p.a(next.getPaymentMode(), PayMethodType.WALLET.name(), true)) {
                next.setSortingWeight(7);
                setDefaultPayOption(SDKConstants.GA_KEY_AOA_WALLET);
            } else if (p.a(next.getPaymentMode(), PayMethodType.BANK_MANDATE.name(), true)) {
                next.setSortingWeight(8);
                setDefaultPayOption(SDKConstants.GA_KEY_AOA_WALLET);
            }
        }
    }

    private final void setDefaultPayOption(String str) {
        if (TextUtils.isEmpty(this.defaultPayOption)) {
            this.defaultPayOption = str;
        }
    }

    private final void sortPaymentMethods(ArrayList<PaymentModes> arrayList) {
        kotlin.a.k.a(arrayList, InstrumentSheetViewModel$sortPaymentMethods$1.INSTANCE);
    }

    private final void addSavedCards(ArrayList<SavedInstruments> arrayList) {
        for (SavedInstruments savedInstruments : arrayList) {
            IsDisabled isDisabled = savedInstruments.getIsDisabled();
            if (isDisabled == null || !isDisabled.getStatus()) {
                this.mInstrumentsList.add(new PaymentInstrumentView.SavedCardView(savedInstruments));
            }
        }
    }

    static /* synthetic */ void addPaytmInstruments$default(InstrumentSheetViewModel instrumentSheetViewModel, ArrayList arrayList, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            instrumentSheetViewModel.addPaytmInstruments(arrayList, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPaytmInstruments");
    }

    private final void addPaytmInstruments(ArrayList<PaymentModes> arrayList, boolean z) {
        IsDisabled isDisabled;
        this.postpaidView = null;
        Iterator<PaymentModes> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            PaymentModes next = it2.next();
            k.a((Object) next, "modes");
            IsDisabled isDisabled2 = next.getIsDisabled();
            if ((isDisabled2 == null || isDisabled2.getMerchantAccept()) && ((isDisabled = next.getIsDisabled()) == null || isDisabled.getUserAccountExist())) {
                MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
                if (ExtensionsKt.isNotNullNotBlank(merchantInstance != null ? merchantInstance.getSsoToken() : null)) {
                    MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
                    if (ExtensionsKt.isNotNullNotBlank(merchantInstance2 != null ? merchantInstance2.getSsoMobileNumber() : null)) {
                        if (p.a(next.getPaymentMode(), PayMethodType.PPBL.name(), true) && !SDKUtility.isPPBBankUpiAvailable()) {
                            this.mInstrumentsList.add(new PaymentInstrumentView.PaytmBankView(next));
                            DirectPaymentBL instance = DirectPaymentBL.getInstance();
                            k.a((Object) instance, "DirectPaymentBL.getInstance()");
                            instance.setPaytmOptionExists(true);
                            setDefaultPayOption(SDKConstants.GA_KEY_PPB);
                            addSavedPayOption(SDKConstants.GA_KEY_PPB);
                        } else if (p.a(next.getPaymentMode(), PayMethodType.PAYTM_DIGITAL_CREDIT.name(), true)) {
                            this.postpaidView = new PaymentInstrumentView.PostpaidView(next, z);
                            DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
                            k.a((Object) instance2, "DirectPaymentBL.getInstance()");
                            instance2.setPaytmOptionExists(true);
                            setDefaultPayOption(SDKConstants.GA_KEY_POSTPAID);
                            addSavedPayOption(SDKConstants.GA_KEY_POSTPAID);
                        }
                    }
                }
            }
        }
    }

    private final void addSavedPayOption(String str) {
        if (!p.a(str, this.defaultPayOption, true)) {
            String str2 = this.savedPayOptions;
            this.savedPayOptions = str2 + str + ", ";
        }
    }

    public final void sendGAEvent() {
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.PG_SCREEN_LOADED, String.valueOf(System.currentTimeMillis()), this.defaultPayOption, this.savedPayOptions, this.gaPayOptions));
    }

    public final void dismissCashierSheet() {
        this.mBottomSheetChangeListener.onChangeBottomSheet(SDKConstants.SELECTED, false);
    }

    public final void payMethodSelected(View view) {
        k.c(view, "view");
        String str = this.mInstrumentPrimaryInfo.get();
        String str2 = this.mInstrumentSecondaryInfo.get();
        String str3 = this.mPaymentMode;
        if (!this.isDisableInstrument) {
            if (str2 == null) {
                k.a();
            }
            if (p.a(str2, this.context.getString(R.string.check_balance), true)) {
                callBalanceAPI(this.mPaymentMode);
                return;
            }
            new HashMap();
            if (p.a(str3, PayMethodType.BALANCE.name(), true)) {
                k.a((Object) PayUtility.getBalanceParam(str3), "PayUtility.getBalanceParam(paymentMode)");
            } else if (!p.a(str3, PayMethodType.PAYTM_DIGITAL_CREDIT.name(), true)) {
                p.a(str3, PayMethodType.PPBL.name(), true);
            }
            DirectPaymentBL instance = DirectPaymentBL.getInstance();
            k.a((Object) instance, "DirectPaymentBL.getInstance()");
            instance.setSelectedInstrument(new SelectedInstrument(str, str2, (BaseViewModel) null));
            OnPayMethodSelectedListener onPayMethodSelectedListener = this.payMethodSelectedListener;
            if (onPayMethodSelectedListener == null) {
                k.a();
            }
            onPayMethodSelectedListener.OnPayMethodSelected();
            dismissCashierSheet();
        }
    }

    private final void callBalanceAPI(String str) {
        executeRequest(getFetchBalanceInstrumentRequest(str));
    }

    private final Request<Object> getFetchBalanceInstrumentRequest(String str) {
        Map hashMap = new HashMap();
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        String ssoToken = merchantInstance.getSsoToken();
        k.a((Object) ssoToken, "MerchantBL.getMerchantInstance().ssoToken");
        hashMap.put("SSO_TOKEN", ssoToken);
        MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
        String mid = merchantInstance2.getMid();
        MerchantBL merchantInstance3 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance3, "MerchantBL.getMerchantInstance()");
        VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, NativeSdkGtmLoader.getFetchBalanceUrl(mid, merchantInstance3.getOrderId()), hashMap, (Map<String, String>) null, APIReqtGenerator.createJsonForFetchBalance(str, false), this, this, CJRFetchBalanceResponse.class);
        volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(2500, 2, 1.0f));
        return volleyPostRequest;
    }

    private final void executeRequest(Request<Object> request) {
        if (SDKUtility.isNetworkAvailable(this.context)) {
            VolleyRequestQueue.getInstance(this.context).addToRequestQueue(request);
            Application application = this.context;
            DialogUtility.showProgressDialog(application, application.getString(R.string.please_wait), false);
            return;
        }
        DialogUtility.showNetworkDialog(request, this.context);
    }

    public void onErrorResponse(VolleyError volleyError) {
        k.c(volleyError, "error");
        if (volleyError instanceof CustomVolleyError) {
            String url = ((CustomVolleyError) volleyError).getUrl();
            k.a((Object) url, "error.url");
            MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
            String mid = merchantInstance.getMid();
            MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
            String fetchBalanceUrl = NativeSdkGtmLoader.getFetchBalanceUrl(mid, merchantInstance2.getOrderId());
            k.a((Object) fetchBalanceUrl, "NativeSdkGtmLoader.getFe…rchantInstance().orderId)");
            if (p.a((CharSequence) url, (CharSequence) fetchBalanceUrl, false)) {
                this.mInstrumentSecondaryInfo.set(this.context.getString(R.string.check_balance));
                this.cashierInstrumentListner.onFetchBalance(this.mInstrumentSecondaryInfo.get());
            }
        }
    }

    public void onResponse(Object obj) {
        k.c(obj, Payload.RESPONSE);
        if (obj instanceof CJRFetchBalanceResponse) {
            CJRFetchBalanceResponse cJRFetchBalanceResponse = (CJRFetchBalanceResponse) obj;
            if (cJRFetchBalanceResponse.getBody() != null) {
                net.one97.paytm.nativesdk.paymethods.model.fetchBalance.Body body = cJRFetchBalanceResponse.getBody();
                k.a((Object) body, "response.body");
                if (body.getBalanceInfo() != null) {
                    Application application = this.context;
                    if (application != null) {
                        i<String> iVar = this.mInstrumentSecondaryInfo;
                        int i2 = R.string.nativesdk_balance;
                        net.one97.paytm.nativesdk.paymethods.model.fetchBalance.Body body2 = cJRFetchBalanceResponse.getBody();
                        k.a((Object) body2, "response.body");
                        net.one97.paytm.nativesdk.paymethods.model.fetchBalance.BalanceInfo balanceInfo = body2.getBalanceInfo();
                        k.a((Object) balanceInfo, "response.body.balanceInfo");
                        iVar.set(Html.fromHtml(application.getString(i2, new Object[]{balanceInfo.getValue()})).toString());
                    }
                    this.cashierInstrumentListner.onFetchBalance(this.mInstrumentSecondaryInfo.get());
                }
            }
        }
    }
}
