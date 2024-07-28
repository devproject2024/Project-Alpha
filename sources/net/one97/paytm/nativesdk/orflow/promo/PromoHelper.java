package net.one97.paytm.nativesdk.orflow.promo;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.j;
import com.android.volley.VolleyError;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.Utils.Server;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.app.VerifyPromoCallbackListener;
import net.one97.paytm.nativesdk.app.VerifyPromoResultListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.emiSubvention.EMIConstants;
import net.one97.paytm.nativesdk.interfaces.PromoSearchListener;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.nativesdk.orflow.interfaces.GAEventListener;
import net.one97.paytm.nativesdk.orflow.interfaces.OnPromoActivityDestroyListener;
import net.one97.paytm.nativesdk.orflow.promo.datasource.PromoSearchRepository;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IFreebieApplyListener;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IFreebieFetchListener;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IFreebieRequestListener;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IFreebieResponseListener;
import net.one97.paytm.nativesdk.orflow.promo.model.CJRPromoData;
import net.one97.paytm.nativesdk.orflow.promo.model.Freebie;
import net.one97.paytm.nativesdk.orflow.promo.model.Gratification;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam;
import net.one97.paytm.nativesdk.orflow.promo.model.Request;
import net.one97.paytm.nativesdk.orflow.promo.utils.Constants;
import net.one97.paytm.nativesdk.orflow.promo.utils.PromoUtils;
import net.one97.paytm.nativesdk.orflow.promo.view.BasePromoPayOptionSheet;
import net.one97.paytm.nativesdk.orflow.promo.view.MallPromoSearchActivity;
import net.one97.paytm.nativesdk.orflow.promo.view.PromoOfferDetailSheet;
import net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet;
import net.one97.paytm.nativesdk.orflow.promo.view.PromoSearchActivity;
import net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoNetBankingSheet;
import net.one97.paytm.nativesdk.orflow.transaction.TransactionDialogListener;
import org.json.JSONArray;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class PromoHelper implements VerifyPromoResultListener, PromoSearchListener {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static PromoHelper INSTANCE;
    private double amount;
    private String bankOfferPromoCode;
    private CJPayMethodResponse cjPayMethodResponse;
    private IFreebieFetchListener freebieFetchListener;
    private List<? extends CJRPromoData> freebieItems;
    private GAEventListener gaEventListener;
    private IFreebieRequestListener iFreebieRequestListener;
    private double instantDiscount;
    private boolean is8DigitBin;
    private boolean isMultiItemEmiFlow;
    private Server mServer;
    private String mid;
    private String offerText;
    private OnPromoActivityDestroyListener onPromoActivityDestroyListener;
    private Object paymentFilters;
    private PromoPayOptionAdapterParam paymentInstrumentBeforeApply;
    private ArrayList<PaymentIntent> paymentIntent;
    private ArrayList<PaymentIntent> paymentIntentBeforeApply;
    private double paytmCashBack;
    private final ArrayList<PromoSearchListener> promoSearchObservers;
    private Request promoSearchRequest;
    private String promoSearchResponse;
    private PromoPayOptionAdapterParam selectedPaymentInstrument;
    private String selectedPromoCode;
    private String ssoToken;
    private TransactionDialogListener transactionDialogListener;
    private VerifyPromoCallbackListener verifyPromoCallbackListener;
    private final ArrayList<VerifyPromoResultListener> verifyPromoObservers;
    private String verticalName;

    private PromoHelper() {
        this.verifyPromoObservers = new ArrayList<>();
        this.promoSearchObservers = new ArrayList<>();
        this.verticalName = "";
        this.mServer = Server.PRODUCTION;
    }

    public /* synthetic */ PromoHelper(g gVar) {
        this();
    }

    public final String getMid() {
        return this.mid;
    }

    public final void setMid(String str) {
        this.mid = str;
    }

    public final double getAmount() {
        return this.amount;
    }

    public final void setAmount(double d2) {
        this.amount = d2;
    }

    public final String getSsoToken() {
        return this.ssoToken;
    }

    public final void setSsoToken(String str) {
        this.ssoToken = str;
    }

    public final String getSelectedPromoCode() {
        return this.selectedPromoCode;
    }

    public final void setSelectedPromoCode(String str) {
        this.selectedPromoCode = str;
    }

    public final String getOfferText() {
        return this.offerText;
    }

    public final void setOfferText(String str) {
        this.offerText = str;
    }

    public final double getInstantDiscount() {
        return this.instantDiscount;
    }

    public final void setInstantDiscount(double d2) {
        this.instantDiscount = d2;
    }

    public final double getPaytmCashBack() {
        return this.paytmCashBack;
    }

    public final void setPaytmCashBack(double d2) {
        this.paytmCashBack = d2;
    }

    public final CJPayMethodResponse getCjPayMethodResponse() {
        return this.cjPayMethodResponse;
    }

    public final void setCjPayMethodResponse(CJPayMethodResponse cJPayMethodResponse) {
        this.cjPayMethodResponse = cJPayMethodResponse;
    }

    public final PromoPayOptionAdapterParam getSelectedPaymentInstrument() {
        return this.selectedPaymentInstrument;
    }

    public final void setSelectedPaymentInstrument(PromoPayOptionAdapterParam promoPayOptionAdapterParam) {
        this.selectedPaymentInstrument = promoPayOptionAdapterParam;
    }

    public final PromoPayOptionAdapterParam getPaymentInstrumentBeforeApply() {
        return this.paymentInstrumentBeforeApply;
    }

    public final void setPaymentInstrumentBeforeApply(PromoPayOptionAdapterParam promoPayOptionAdapterParam) {
        this.paymentInstrumentBeforeApply = promoPayOptionAdapterParam;
    }

    public final ArrayList<PaymentIntent> getPaymentIntent() {
        return this.paymentIntent;
    }

    public final void setPaymentIntent(ArrayList<PaymentIntent> arrayList) {
        this.paymentIntent = arrayList;
    }

    public final ArrayList<PaymentIntent> getPaymentIntentBeforeApply() {
        return this.paymentIntentBeforeApply;
    }

    public final void setPaymentIntentBeforeApply(ArrayList<PaymentIntent> arrayList) {
        this.paymentIntentBeforeApply = arrayList;
    }

    public final String getVerticalName() {
        return this.verticalName;
    }

    public final void setVerticalName(String str) {
        k.c(str, "<set-?>");
        this.verticalName = str;
    }

    public final Server getMServer() {
        return this.mServer;
    }

    public final void setMServer(Server server) {
        k.c(server, "<set-?>");
        this.mServer = server;
    }

    public final boolean is8DigitBin() {
        return this.is8DigitBin;
    }

    public final void set8DigitBin(boolean z) {
        this.is8DigitBin = z;
    }

    public final GAEventListener getGaEventListener() {
        return this.gaEventListener;
    }

    public final void setGaEventListener(GAEventListener gAEventListener) {
        this.gaEventListener = gAEventListener;
    }

    public final OnPromoActivityDestroyListener getOnPromoActivityDestroyListener() {
        return this.onPromoActivityDestroyListener;
    }

    public final void setOnPromoActivityDestroyListener(OnPromoActivityDestroyListener onPromoActivityDestroyListener2) {
        this.onPromoActivityDestroyListener = onPromoActivityDestroyListener2;
    }

    public final List<CJRPromoData> getFreebieItems() {
        return this.freebieItems;
    }

    public final void setFreebieItems(List<? extends CJRPromoData> list) {
        this.freebieItems = list;
    }

    public final String getBankOfferPromoCode() {
        return this.bankOfferPromoCode;
    }

    public final void setBankOfferPromoCode(String str) {
        this.bankOfferPromoCode = str;
    }

    public final Object getPaymentFilters() {
        return this.paymentFilters;
    }

    public final void setPaymentFilters(Object obj) {
        this.paymentFilters = obj;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final PromoHelper getInstance() {
            if (PromoHelper.INSTANCE == null) {
                PromoHelper.INSTANCE = new PromoHelper((g) null);
            }
            PromoHelper access$getINSTANCE$cp = PromoHelper.INSTANCE;
            if (access$getINSTANCE$cp == null) {
                k.a();
            }
            return access$getINSTANCE$cp;
        }

        public final void clear() {
            PromoHelper.INSTANCE = null;
        }
    }

    public final void clearPaymentIntent() {
        this.selectedPaymentInstrument = null;
        this.bankOfferPromoCode = null;
        this.paymentIntent = null;
    }

    public final void clearPromo(PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener) {
        k.c(applyAnotherOfferListener, "listener");
        PromoUtils.log("clear promo called");
        VerifyPromoCallbackListener verifyPromoCallbackListener2 = this.verifyPromoCallbackListener;
        if (verifyPromoCallbackListener2 != null) {
            verifyPromoCallbackListener2.clearPromoCode(this.selectedPromoCode, applyAnotherOfferListener);
        }
    }

    public final void startPromoSearchActivity(Context context, double d2, String str, String str2, String str3, Configuration configuration, VerifyPromoCallbackListener verifyPromoCallbackListener2) {
        k.c(context, "context");
        k.c(str, "mid");
        k.c(str2, "ssoToken");
        k.c(str3, "promoSearchResponse");
        k.c(configuration, CLConstants.INPUT_KEY_CONFIGURATION);
        k.c(verifyPromoCallbackListener2, "verifyPromoCallbackListener");
        this.mid = str;
        this.amount = d2;
        this.ssoToken = str2;
        this.verifyPromoCallbackListener = verifyPromoCallbackListener2;
        this.promoSearchResponse = str3;
        setConfiguration(configuration);
        context.startActivity(new Intent(context, PromoSearchActivity.class));
    }

    public final void startMallPromoSearchActivity(Context context, double d2, String str, String str2, String str3, VerifyPromoCallbackListener verifyPromoCallbackListener2, IFreebieFetchListener iFreebieFetchListener, HashMap<String, Object> hashMap, IFreebieRequestListener iFreebieRequestListener2, Configuration configuration) {
        k.c(context, "context");
        k.c(str, "mid");
        k.c(str2, "ssoToken");
        k.c(str3, "promoSearchResponse");
        k.c(verifyPromoCallbackListener2, "verifyPromoCallbackListener");
        k.c(iFreebieFetchListener, "iFreebieFetchListener");
        k.c(hashMap, "dataMap");
        k.c(iFreebieRequestListener2, "iFreebieRequestListener");
        k.c(configuration, CLConstants.INPUT_KEY_CONFIGURATION);
        this.mid = str;
        this.amount = d2;
        this.ssoToken = str2;
        this.verifyPromoCallbackListener = verifyPromoCallbackListener2;
        this.promoSearchResponse = str3;
        this.freebieFetchListener = iFreebieFetchListener;
        this.iFreebieRequestListener = iFreebieRequestListener2;
        Intent intent = new Intent(context, MallPromoSearchActivity.class);
        intent.putExtra(Constants.DATA_MAP, hashMap);
        setConfiguration(configuration);
        context.startActivity(intent);
    }

    public final void startMallFreebieListActivity(Activity activity, List<? extends CJRPromoData> list, IFreebieFetchListener iFreebieFetchListener, IFreebieRequestListener iFreebieRequestListener2, HashMap<String, Object> hashMap) {
        k.c(activity, "activity");
        k.c(list, "promoData");
        k.c(iFreebieFetchListener, "iFreebieFetchListener");
        k.c(iFreebieRequestListener2, "iFreebieRequestListener");
        k.c(hashMap, Item.CTA_URL_TYPE_MAP);
        this.freebieFetchListener = iFreebieFetchListener;
        this.iFreebieRequestListener = iFreebieRequestListener2;
        PromoUtils.startFreebieListActivity(activity, (List<CJRPromoData>) list, hashMap);
    }

    public final void startPromoSearchActivityWithoutData(Context context, double d2, String str, String str2, Request request, Configuration configuration, VerifyPromoCallbackListener verifyPromoCallbackListener2) {
        k.c(context, "context");
        k.c(str, "mid");
        k.c(str2, "ssoToken");
        k.c(request, "request");
        k.c(configuration, CLConstants.INPUT_KEY_CONFIGURATION);
        k.c(verifyPromoCallbackListener2, "verifyPromoCallbackListener");
        this.mid = str;
        this.amount = d2;
        this.ssoToken = str2;
        this.verifyPromoCallbackListener = verifyPromoCallbackListener2;
        this.promoSearchRequest = request;
        setConfiguration(configuration);
        context.startActivity(new Intent(context, PromoSearchActivity.class));
    }

    public final void onPromoSearchSuccess(String str) {
        ListIterator<PromoSearchListener> listIterator = this.promoSearchObservers.listIterator();
        k.a((Object) listIterator, "promoSearchObservers.listIterator()");
        while (listIterator.hasNext()) {
            listIterator.next().onPromoSearchSuccess(str);
        }
    }

    public final void onPromoSearchError(VolleyError volleyError) {
        ListIterator<PromoSearchListener> listIterator = this.promoSearchObservers.listIterator();
        k.a((Object) listIterator, "promoSearchObservers.listIterator()");
        while (listIterator.hasNext()) {
            listIterator.next().onPromoSearchError(volleyError);
        }
    }

    public final void getAllPromo(Application application) {
        k.c(application, "context");
        String str = this.promoSearchResponse;
        if (str != null) {
            if (str == null) {
                k.a();
            }
            onPromoSearchSuccess(str);
        } else if (this.promoSearchRequest == null) {
            onPromoSearchSuccess("");
        } else {
            PromoSearchRepository.Companion companion = PromoSearchRepository.Companion;
            Context applicationContext = application.getApplicationContext();
            k.a((Object) applicationContext, "context.applicationContext");
            PromoSearchRepository instance = companion.getInstance(applicationContext);
            Request request = this.promoSearchRequest;
            if (request == null) {
                k.a();
            }
            instance.getAllPromos(request, this);
        }
    }

    public final void onPromoSelected(String str, String str2, int i2, Object obj) {
        String str3;
        this.paymentFilters = obj;
        if (obj == null) {
            str3 = null;
        } else {
            String obj2 = obj.toString();
            this.is8DigitBin = getIs8DigitBinRequired(obj);
            str3 = obj2;
        }
        this.selectedPromoCode = str;
        PromoUtils.log("Promo Selected = ".concat(String.valueOf(str)));
        this.offerText = str2;
        VerifyPromoCallbackListener verifyPromoCallbackListener2 = this.verifyPromoCallbackListener;
        if (verifyPromoCallbackListener2 != null) {
            verifyPromoCallbackListener2.onPromoSelected(str, i2, str3, this);
        }
    }

    public final void onPaymentModeSelected(ArrayList<PaymentIntent> arrayList, PromoPayOptionAdapterParam promoPayOptionAdapterParam) {
        k.c(arrayList, EMIConstants.PAYMENT_INTENT);
        k.c(promoPayOptionAdapterParam, "selectedItem");
        this.paymentIntentBeforeApply = arrayList;
        this.paymentInstrumentBeforeApply = promoPayOptionAdapterParam;
        PromoUtils.log("payment intent selected " + this.selectedPromoCode);
        VerifyPromoCallbackListener verifyPromoCallbackListener2 = this.verifyPromoCallbackListener;
        if (verifyPromoCallbackListener2 != null) {
            verifyPromoCallbackListener2.onPaymentIntentSelected(this.selectedPromoCode, arrayList, createUpiPspApps(), this);
        }
    }

    public final void openPromoPayOptionsBottomSheet(j jVar, double d2, String str, String str2, CJPayMethodResponse cJPayMethodResponse, PaytmSDKRequestClient.VerifyResponseData verifyResponseData, Configuration configuration, VerifyPromoCallbackListener verifyPromoCallbackListener2) {
        BasePromoPayOptionSheet basePromoPayOptionSheet;
        k.c(jVar, "fragmentManager");
        k.c(str, "mid");
        k.c(str2, "ssoToken");
        k.c(cJPayMethodResponse, "cjPayMethodResponse");
        k.c(configuration, CLConstants.INPUT_KEY_CONFIGURATION);
        k.c(verifyPromoCallbackListener2, "verifyPromoCallbackListener");
        this.mid = str;
        this.amount = d2;
        this.ssoToken = str2;
        this.offerText = verifyResponseData != null ? verifyResponseData.getOfferText() : null;
        this.verifyPromoCallbackListener = verifyPromoCallbackListener2;
        setConfiguration(configuration);
        if (verifyResponseData != null) {
            Boolean is8DigitBin2 = verifyResponseData.getIs8DigitBin();
            k.a((Object) is8DigitBin2, "responseParam.is8DigitBin");
            this.is8DigitBin = is8DigitBin2.booleanValue();
            this.paytmCashBack = verifyResponseData.getPaytmCashBack();
            this.instantDiscount = verifyResponseData.getPaytmDiscount();
            this.selectedPromoCode = verifyResponseData.getPromoCode();
        } else {
            this.is8DigitBin = false;
            this.paytmCashBack = 0.0d;
            this.instantDiscount = 0.0d;
            this.selectedPromoCode = null;
        }
        if (Utility.INSTANCE.shouldShowNBOnlySheet(cJPayMethodResponse)) {
            basePromoPayOptionSheet = PromoNetBankingSheet.Companion.getInstance(cJPayMethodResponse);
        } else {
            basePromoPayOptionSheet = PromoPayOptionsBottomSheet.Companion.getInstance(cJPayMethodResponse);
        }
        basePromoPayOptionSheet.show(jVar, PromoPayOptionsBottomSheet.class.getSimpleName());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
        if (android.text.TextUtils.isEmpty(r7 != null ? r7.getOfferText() : null) == false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onVerifyPromoSuccess(net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r5, boolean r6, net.one97.paytm.nativesdk.app.PaytmSDKRequestClient.VerifyResponseData r7) {
        /*
            r4 = this;
            r4.cjPayMethodResponse = r5
            r0 = 0
            if (r5 == 0) goto L_0x0008
            net.one97.paytm.nativesdk.PaytmSDK.setResponse(r5, r0)
        L_0x0008:
            if (r7 == 0) goto L_0x0026
            java.lang.String r1 = r7.getMid()
            if (r1 == 0) goto L_0x0026
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            r3 = 1
            if (r2 != 0) goto L_0x001c
            r2 = 1
            goto L_0x001d
        L_0x001c:
            r2 = 0
        L_0x001d:
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r1 = r0
        L_0x0022:
            if (r1 == 0) goto L_0x0026
            r4.mid = r1
        L_0x0026:
            java.lang.String r1 = r4.offerText
            if (r1 == 0) goto L_0x003a
            if (r7 == 0) goto L_0x0031
            java.lang.String r1 = r7.getOfferText()
            goto L_0x0032
        L_0x0031:
            r1 = r0
        L_0x0032:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0044
        L_0x003a:
            if (r7 == 0) goto L_0x0041
            java.lang.String r1 = r7.getOfferText()
            goto L_0x0042
        L_0x0041:
            r1 = r0
        L_0x0042:
            r4.offerText = r1
        L_0x0044:
            if (r7 == 0) goto L_0x004c
            double r1 = r7.getPaytmDiscount()
            r4.instantDiscount = r1
        L_0x004c:
            if (r7 == 0) goto L_0x0054
            double r1 = r7.getPaytmCashBack()
            r4.paytmCashBack = r1
        L_0x0054:
            java.lang.Object r1 = r4.paymentFilters
            if (r1 != 0) goto L_0x0066
            if (r7 == 0) goto L_0x0066
            java.lang.Boolean r1 = r7.getIs8DigitBin()
            if (r1 == 0) goto L_0x0066
            boolean r1 = r1.booleanValue()
            r4.is8DigitBin = r1
        L_0x0066:
            if (r7 == 0) goto L_0x006d
            java.util.List r1 = r7.getFreebieItems()
            goto L_0x006e
        L_0x006d:
            r1 = r0
        L_0x006e:
            r4.freebieItems = r1
            java.util.ArrayList<net.one97.paytm.nativesdk.app.VerifyPromoResultListener> r1 = r4.verifyPromoObservers
            java.util.ListIterator r1 = r1.listIterator()
            java.lang.String r2 = "verifyPromoObservers.listIterator()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
        L_0x007b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x008b
            java.lang.Object r2 = r1.next()
            net.one97.paytm.nativesdk.app.VerifyPromoResultListener r2 = (net.one97.paytm.nativesdk.app.VerifyPromoResultListener) r2
            r2.onVerifyPromoSuccess(r5, r6, r7)
            goto L_0x007b
        L_0x008b:
            if (r7 == 0) goto L_0x0091
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$ConvFeeResponse r0 = r7.getConvFeeResponse()
        L_0x0091:
            if (r0 == 0) goto L_0x00c1
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r5 = Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r5 = r5.getInstance()
            java.util.ArrayList<net.one97.paytm.nativesdk.common.model.PaymentIntent> r5 = r5.paymentIntent
            if (r5 == 0) goto L_0x00c1
            net.one97.paytm.nativesdk.ConvenienceFeeOrController$Companion r5 = net.one97.paytm.nativesdk.ConvenienceFeeOrController.Companion
            net.one97.paytm.nativesdk.ConvenienceFeeOrController r5 = r5.getInstance()
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$ConvFeeResponse r6 = r7.getConvFeeResponse()
            java.lang.String r0 = "responseParam.convFeeResponse"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r0 = Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r0 = r0.getInstance()
            java.util.ArrayList<net.one97.paytm.nativesdk.common.model.PaymentIntent> r0 = r0.paymentIntent
            if (r0 != 0) goto L_0x00b9
            kotlin.g.b.k.a()
        L_0x00b9:
            java.lang.Object r7 = r7.getVerifyModel()
            r5.setConvFeeResponse((net.one97.paytm.nativesdk.app.PaytmSDKRequestClient.ConvFeeResponse) r6, (java.util.ArrayList<net.one97.paytm.nativesdk.common.model.PaymentIntent>) r0, (java.lang.Object) r7)
            return
        L_0x00c1:
            net.one97.paytm.nativesdk.ConvenienceFeeOrController$Companion r5 = net.one97.paytm.nativesdk.ConvenienceFeeOrController.Companion
            net.one97.paytm.nativesdk.ConvenienceFeeOrController r5 = r5.getInstance()
            r5.resetConvenienceFee()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.PromoHelper.onVerifyPromoSuccess(net.one97.paytm.nativesdk.common.model.CJPayMethodResponse, boolean, net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$VerifyResponseData):void");
    }

    public final void openPromoOfferDetailSheet(j jVar, String str, String str2) {
        k.c(jVar, "fragmentManager");
        k.c(str, "promoText");
        k.c(str2, "offerText");
        PromoOfferDetailSheet.Companion.getInstance(str, str2).show(jVar, PromoOfferDetailSheet.class.getSimpleName());
    }

    public final void onVerifyPromoError(String str) {
        ListIterator<VerifyPromoResultListener> listIterator = this.verifyPromoObservers.listIterator();
        k.a((Object) listIterator, "verifyPromoObservers.listIterator()");
        while (listIterator.hasNext()) {
            listIterator.next().onVerifyPromoError(str);
        }
    }

    public final void onNonPromoError(String str) {
        ListIterator<VerifyPromoResultListener> listIterator = this.verifyPromoObservers.listIterator();
        k.a((Object) listIterator, "verifyPromoObservers.listIterator()");
        while (listIterator.hasNext()) {
            listIterator.next().onNonPromoError(str);
        }
    }

    public final void onVerifyPromoNetworkError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
        ListIterator<VerifyPromoResultListener> listIterator = this.verifyPromoObservers.listIterator();
        k.a((Object) listIterator, "verifyPromoObservers.listIterator()");
        while (listIterator.hasNext()) {
            listIterator.next().onVerifyPromoNetworkError(apiResponseError);
        }
    }

    public final void onPromoSearchActivityDestroy(boolean z) {
        OnPromoActivityDestroyListener onPromoActivityDestroyListener2 = this.onPromoActivityDestroyListener;
        if (onPromoActivityDestroyListener2 != null) {
            onPromoActivityDestroyListener2.onPromoSearchActivityDestroy(z);
        }
    }

    public final void performGAOperation(Context context, Map<String, ? extends Object> map) {
        GAEventListener gAEventListener;
        k.c(map, "eventMap");
        if (context != null && (gAEventListener = this.gaEventListener) != null) {
            gAEventListener.sendGAEvents(context, map);
        }
    }

    public final void sendScreenViewEvent(Context context, String str, String str2) {
        k.c(context, "context");
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str2, "verticalName");
        GAEventListener gAEventListener = this.gaEventListener;
        if (gAEventListener != null) {
            gAEventListener.sendScreenViewEvent(context, str, str2);
        }
    }

    public final PaymentIntent getUpdatedPaymentIntent(double d2) {
        ArrayList<PaymentIntent> arrayList = this.paymentIntent;
        if (arrayList == null) {
            return null;
        }
        if (arrayList != null && arrayList.size() == 0) {
            return null;
        }
        ArrayList<PaymentIntent> arrayList2 = this.paymentIntent;
        if (arrayList2 == null) {
            k.a();
        }
        PaymentIntent paymentIntent2 = arrayList2.get(0);
        k.a((Object) paymentIntent2, "paymentIntent!!.get(0)");
        PaymentIntent paymentIntent3 = paymentIntent2;
        PaymentIntent paymentIntent4 = new PaymentIntent();
        paymentIntent4.setTxnAmount(d2);
        paymentIntent4.setBanks(paymentIntent3.getBanks());
        paymentIntent4.setMode(paymentIntent3.getMode());
        paymentIntent4.setChannels(paymentIntent3.getChannels());
        paymentIntent4.setCardHash(paymentIntent3.getCardHash());
        paymentIntent4.setVpa(paymentIntent3.getVpa());
        paymentIntent4.setMode_type(paymentIntent3.getMode_type());
        paymentIntent4.setBin6(paymentIntent3.getBin6());
        paymentIntent4.setBin8(paymentIntent3.getBin8());
        paymentIntent4.setConvFee(paymentIntent3.getConvFee());
        return paymentIntent4;
    }

    private final void setConfiguration(Configuration configuration) {
        Server server = configuration.getServer();
        if (server != null) {
            this.mServer = server;
        }
        this.verticalName = configuration.getVerticalName();
    }

    public final void setServer() {
        NativeSdkGtmLoader.setServerUrl(this.mServer);
    }

    public final void addPromoSearchObserver(PromoSearchListener promoSearchListener) {
        k.c(promoSearchListener, "promoSearchListener");
        if (!this.promoSearchObservers.contains(promoSearchListener)) {
            this.promoSearchObservers.listIterator().add(promoSearchListener);
        }
    }

    public final void removePromoSearchObserver(PromoSearchListener promoSearchListener) {
        k.c(promoSearchListener, "listener");
        ListIterator<PromoSearchListener> listIterator = this.promoSearchObservers.listIterator();
        k.a((Object) listIterator, "promoSearchObservers.listIterator()");
        while (listIterator.hasNext()) {
            PromoSearchListener next = listIterator.next();
            k.a((Object) next, "iterator.next()");
            if (k.a((Object) next, (Object) promoSearchListener)) {
                listIterator.remove();
            }
        }
    }

    public final void addVerifyPromoObserver(VerifyPromoResultListener verifyPromoResultListener) {
        k.c(verifyPromoResultListener, "listener");
        if (!this.verifyPromoObservers.contains(verifyPromoResultListener)) {
            this.verifyPromoObservers.listIterator().add(verifyPromoResultListener);
        }
    }

    public final void removeVerifyPromoObserver(VerifyPromoResultListener verifyPromoResultListener) {
        k.c(verifyPromoResultListener, "listener");
        ListIterator<VerifyPromoResultListener> listIterator = this.verifyPromoObservers.listIterator();
        k.a((Object) listIterator, "verifyPromoObservers.listIterator()");
        while (listIterator.hasNext()) {
            VerifyPromoResultListener next = listIterator.next();
            k.a((Object) next, "iterator.next()");
            if (k.a((Object) next, (Object) verifyPromoResultListener)) {
                listIterator.remove();
            }
        }
    }

    private final String createUpiPspApps() {
        return new JSONArray().toString();
    }

    public final void clearAllListeners() {
        this.gaEventListener = null;
        this.onPromoActivityDestroyListener = null;
        this.verifyPromoCallbackListener = null;
        this.freebieFetchListener = null;
        this.iFreebieRequestListener = null;
    }

    public static final class Configuration {
        private Server mServer = Server.PRODUCTION;
        private String mVerticalName = "";

        public final Configuration setVerticalName(String str) {
            k.c(str, "verticalName");
            Configuration configuration = this;
            configuration.mVerticalName = str;
            return configuration;
        }

        public final Configuration setServer(Server server) {
            k.c(server, "server");
            Configuration configuration = this;
            configuration.mServer = server;
            return configuration;
        }

        public final Server getServer() {
            return this.mServer;
        }

        public final String getVerticalName() {
            return this.mVerticalName;
        }
    }

    public final void getFreebies(PromoListItem promoListItem, IFreebieResponseListener iFreebieResponseListener) {
        k.c(promoListItem, "item");
        k.c(iFreebieResponseListener, "freebieResponseListener");
        PromoUtils.log("trying for freebieResponse" + String.valueOf(this.freebieFetchListener));
        IFreebieFetchListener iFreebieFetchListener = this.freebieFetchListener;
        if (iFreebieFetchListener != null) {
            iFreebieFetchListener.fetchFreebie(promoListItem.getFreebieListUrl(), new PromoHelper$getFreebies$1(iFreebieResponseListener, promoListItem));
        }
    }

    public final void getFreebies(Gratification gratification, PromoListItem promoListItem, IFreebieResponseListener iFreebieResponseListener) {
        k.c(gratification, "gratification");
        k.c(promoListItem, "item");
        k.c(iFreebieResponseListener, "freebieResponseListener");
        IFreebieFetchListener iFreebieFetchListener = this.freebieFetchListener;
        if (iFreebieFetchListener != null) {
            iFreebieFetchListener.fetchFreebie(gratification.getListUrl(), new PromoHelper$getFreebies$2(iFreebieResponseListener, gratification, promoListItem));
        }
    }

    public final void getFreebies(String str, IFreebieResponseListener iFreebieResponseListener) {
        k.c(str, "listUrl");
        k.c(iFreebieResponseListener, "freebieResponseListener");
        IFreebieFetchListener iFreebieFetchListener = this.freebieFetchListener;
        if (iFreebieFetchListener != null) {
            iFreebieFetchListener.fetchFreebie(str, new PromoHelper$getFreebies$3(iFreebieResponseListener));
        }
    }

    public final void bulkAddFreebie(List<? extends CJRPromoData> list, HashMap<Integer, Freebie> hashMap, IFreebieApplyListener iFreebieApplyListener) {
        k.c(hashMap, "selectedFreebieData");
        k.c(iFreebieApplyListener, "iFreebieApplyListener");
        IFreebieRequestListener iFreebieRequestListener2 = this.iFreebieRequestListener;
        if (iFreebieRequestListener2 != null) {
            iFreebieRequestListener2.applyBulkFreebie(list, hashMap, iFreebieApplyListener);
        }
    }

    public final void clearListeners(PromoSearchListener promoSearchListener, VerifyPromoResultListener verifyPromoResultListener) {
        k.c(promoSearchListener, "iPromoSearchObserver");
        k.c(verifyPromoResultListener, "verifyPromoResultListener");
        this.mid = null;
        this.amount = 0.0d;
        this.ssoToken = null;
        this.verifyPromoCallbackListener = null;
        this.promoSearchResponse = null;
        this.freebieFetchListener = null;
        this.iFreebieRequestListener = null;
        removePromoSearchObserver(promoSearchListener);
        removeVerifyPromoObserver(verifyPromoResultListener);
        clearAllListeners();
    }

    private final boolean getIs8DigitBinRequired(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof JSONObject) {
                    return ((JSONObject) obj).optBoolean("is8DigitBin");
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public final boolean isMultiItemEmiFlow() {
        return this.isMultiItemEmiFlow;
    }

    public final void setMultiItemEmiFlow(boolean z) {
        this.isMultiItemEmiFlow = z;
    }

    public final void setTransactionDialogListener(TransactionDialogListener transactionDialogListener2) {
        this.transactionDialogListener = transactionDialogListener2;
    }

    public final View getTransactionSheetView() {
        TransactionDialogListener transactionDialogListener2 = this.transactionDialogListener;
        if (transactionDialogListener2 != null) {
            return transactionDialogListener2.getTransactionDialogView();
        }
        return null;
    }
}
