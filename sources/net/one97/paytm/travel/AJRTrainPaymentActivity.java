package net.one97.paytm.travel;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import com.google.gsonhtcfix.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.e;
import com.travel.train.model.trainticket.CJRServerErrorFormat;
import com.travel.train.model.trainticket.CJRTrainDisplayName;
import com.travel.train.model.trainticket.CJRTrainFareDetail;
import com.travel.train.model.trainticket.CJRTrainValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.m.d;
import kotlin.m.p;
import kotlin.s;
import kotlin.u;
import net.one97.paytm.AJRRechargePaymentActivity;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.j.c;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.model.CreateOrderResponse;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ap;
import net.one97.paytm.travel.b;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AJRTrainPaymentActivity extends AJRRechargePaymentActivity implements PaytmSDKRequestClient {
    private final String C = "TrainDefCheckoutUrl";
    private String D = "Payment Gateway Fee";
    private String E = "left";
    private String F = "Plain";
    private String G = "Seperator";
    private boolean H;
    private String I;
    private String J;
    private int K;
    private JSONObject L = new JSONObject();
    private b M;
    private int N = 1234;
    private PaytmSDKRequestClient.OnCheckoutResponse O;
    private PaytmSDKRequestClient.OnVerifyResponse P;
    private a Q = a.PRE_VERIFY;

    /* renamed from: a  reason: collision with root package name */
    private final String f65140a = "train_fare_details";

    /* renamed from: b  reason: collision with root package name */
    private final String f65141b = "grand_total_key";

    /* renamed from: c  reason: collision with root package name */
    private final String f65142c = "requestid";

    /* renamed from: d  reason: collision with root package name */
    private final String f65143d = "payment_info";

    /* renamed from: e  reason: collision with root package name */
    private final String f65144e = "test_id";

    /* renamed from: f  reason: collision with root package name */
    private final String f65145f = "checkoutUrl";

    /* renamed from: g  reason: collision with root package name */
    private final String f65146g = "payment_intent";

    /* renamed from: h  reason: collision with root package name */
    private final String f65147h = "updatedDiscountAmount";

    /* renamed from: i  reason: collision with root package name */
    private final String f65148i = "finalDiscount";
    private final String j = "reseller";
    private final String k = "1";
    private final String l = "TrainVerifyUrl";

    public enum a {
        PRE_VERIFY,
        POST_VERIFY,
        CHECK_OUT
    }

    public final void applyAnotherOffer(PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener) {
        k.c(applyAnotherOfferListener, "applyAnotherOfferListener");
    }

    public final boolean isConvFeeEnabled() {
        return true;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        CJRCart cart;
        CJRCart cart2;
        int i2 = a.f65152a[this.Q.ordinal()];
        String str = null;
        if (i2 != 1) {
            if (i2 == 2) {
                this.H = true;
                if (iJRPaytmDataModel != null) {
                    CJRTrainCartVerify cJRTrainCartVerify = (CJRTrainCartVerify) iJRPaytmDataModel;
                    CJRRechargePayment payment = cJRTrainCartVerify != null ? cJRTrainCartVerify.getPayment() : null;
                    PaytmSDKRequestClient.CheckoutResponseData checkoutResponseData = new PaytmSDKRequestClient.CheckoutResponseData();
                    CreateOrderResponse createOrderResponse = new CreateOrderResponse();
                    createOrderResponse.setMessage(payment != null ? payment.getMessage() : null);
                    createOrderResponse.setMID(payment != null ? payment.getMID() : null);
                    createOrderResponse.setNative_withdraw(payment != null ? payment.isNativeEnabled() : null);
                    createOrderResponse.setORDER_ID(payment != null ? payment.getOrderId() : null);
                    CreateOrderResponse.NativeWithdrawDetails nativeWithdrawDetails = new CreateOrderResponse.NativeWithdrawDetails();
                    nativeWithdrawDetails.setTxnToken(payment != null ? payment.getmTxnToken() : null);
                    createOrderResponse.setNative_withdraw_details(nativeWithdrawDetails);
                    createOrderResponse.setStatus(payment != null ? payment.getStatus() : null);
                    createOrderResponse.setTOKEN_TYPE(payment != null ? payment.getmTxnToken() : null);
                    if (payment != null) {
                        str = payment.getTxnAmount();
                    }
                    createOrderResponse.setTXN_AMOUNT(str);
                    checkoutResponseData.setCreateOrderResponse(createOrderResponse);
                    PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse = this.O;
                    if (onCheckoutResponse != null) {
                        onCheckoutResponse.onCheckoutSuccess(checkoutResponseData);
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.travel.CJRTrainCartVerify");
            }
        } else if (iJRPaytmDataModel != null) {
            CJRTrainCartVerify cJRTrainCartVerify2 = (CJRTrainCartVerify) iJRPaytmDataModel;
            CJRRechargeCart cJRRechargeCart = cJRTrainCartVerify2 != null ? cJRTrainCartVerify2.getmRechargeCart() : null;
            PaytmSDKRequestClient.ConvFeeResponse convFeeResponse = new PaytmSDKRequestClient.ConvFeeResponse();
            convFeeResponse.setAggregatePGConvFee((cJRRechargeCart == null || (cart2 = cJRRechargeCart.getCart()) == null) ? null : cart2.getAggregatePGConvFee());
            convFeeResponse.setTotalAmtIncConvFee((cJRRechargeCart == null || (cart = cJRRechargeCart.getCart()) == null) ? null : cart.getFinalPrice());
            if (convFeeResponse.getAggregatePGConvFee() != null) {
                if (cJRTrainCartVerify2 != null) {
                    str = cJRTrainCartVerify2.getConvFeeLabel();
                }
                convFeeResponse.setConvFeeLabel(str);
            }
            PaytmSDKRequestClient.OnVerifyResponse onVerifyResponse = this.P;
            if (onVerifyResponse != null) {
                PaytmSDKRequestClient.VerifyResponseData verifyResponseData = new PaytmSDKRequestClient.VerifyResponseData();
                verifyResponseData.setConvFeeResponse(convFeeResponse);
                verifyResponseData.setVerifyModel(cJRRechargeCart);
                onVerifyResponse.onVerifySuccess(verifyResponseData);
            }
        } else {
            throw new u("null cannot be cast to non-null type net.one97.paytm.travel.CJRTrainCartVerify");
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (!isFinishing() && iJRPaytmDataModel != null && networkCustomError != null) {
            CJRServerErrorFormat cJRServerErrorFormat = new CJRServerErrorFormat();
            if (networkCustomError.networkResponse != null) {
                NetworkResponse networkResponse = networkCustomError.networkResponse;
                k.a((Object) networkResponse, "networkCustomError.networkResponse");
                if (networkResponse.data != null) {
                    try {
                        byte[] bArr = networkResponse.data;
                        k.a((Object) bArr, "response.data");
                        Object a2 = new f().a(new String(bArr, d.f47971a), cJRServerErrorFormat.getClass());
                        k.a((Object) a2, "Gson().fromJson(jsonString, errorFormat.javaClass)");
                        cJRServerErrorFormat = (CJRServerErrorFormat) a2;
                    } catch (Exception e2) {
                        e2.getMessage();
                    }
                }
            }
            int i3 = a.f65153b[this.Q.ordinal()];
            if (i3 == 1) {
                this.K++;
                k.c(networkCustomError, "error");
                if (this.K < 3) {
                    this.Q = a.POST_VERIFY;
                    a(c(this, this.I), a(this.J, false), this.L, (IJRPaytmDataModel) new CJRTrainCartVerify());
                    return;
                }
                PaytmSDKRequestClient.OnVerifyResponse onVerifyResponse = this.P;
                k.c(networkCustomError, "error");
                s<Integer, String, String> b2 = b(networkCustomError);
                PaytmSDKRequestClient.ApiResponseError a3 = a(b2.getFirst(), b2.getSecond(), b2.getThird(), false);
                if (onVerifyResponse != null) {
                    onVerifyResponse.onVerifyError(a3);
                }
            } else if (i3 == 2) {
                this.H = false;
                if (!(cJRServerErrorFormat == null || cJRServerErrorFormat.getStatus() == null || cJRServerErrorFormat.getStatus().getMessage() == null || TextUtils.isEmpty(cJRServerErrorFormat.getStatus().getMessage().getTitle()) || TextUtils.isEmpty(cJRServerErrorFormat.getStatus().getMessage().getMessage()))) {
                    networkCustomError.setAlertMessage(cJRServerErrorFormat.getStatus().getMessage().getMessage());
                    networkCustomError.setmAlertTitle(cJRServerErrorFormat.getStatus().getMessage().getTitle());
                }
                PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse = this.O;
                if (onCheckoutResponse == null) {
                    k.a();
                }
                a(networkCustomError, onCheckoutResponse);
            }
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRTrainPaymentActivity f65149a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f65150b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f65151c;

        b(AJRTrainPaymentActivity aJRTrainPaymentActivity, int i2, int i3) {
            this.f65149a = aJRTrainPaymentActivity;
            this.f65150b = i2;
            this.f65151c = i3;
        }

        public final void run() {
            try {
                if (PromoHelper.Companion.getInstance().getTransactionSheetView() != null) {
                    aa aaVar = aa.f47921a;
                    String string = this.f65149a.getResources().getString(R.string.flight_updated_discount_message);
                    k.a((Object) string, "resources.getString(R.st…updated_discount_message)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.f65150b), Integer.valueOf(this.f65151c)}, 2));
                    k.b(format, "java.lang.String.format(format, *args)");
                    View transactionSheetView = PromoHelper.Companion.getInstance().getTransactionSheetView();
                    if (transactionSheetView == null) {
                        k.a();
                    }
                    Snackbar a2 = Snackbar.a(transactionSheetView, (CharSequence) format, 0);
                    k.a((Object) a2, "Snackbar.make(txnView!!,…ge, Snackbar.LENGTH_LONG)");
                    View b2 = a2.b();
                    k.a((Object) b2, "snackbar.view");
                    b2.getBackground().setColorFilter(this.f65149a.getResources().getColor(R.color.color_504efa), PorterDuff.Mode.SRC_IN);
                    View findViewById = b2.findViewById(R.id.snackbar_text);
                    if (findViewById != null) {
                        ((TextView) findViewById).setTextColor(this.f65149a.getResources().getColor(R.color.white));
                        a2.c();
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void verifyCart(PaytmSDKRequestClient.CallbackData callbackData, PaytmSDKRequestClient.OnVerifyResponse onVerifyResponse) {
        k.c(callbackData, "data");
        k.c(onVerifyResponse, "onVerifyResponse");
        if (this.H && this.O != null) {
            NetworkCustomError networkCustomError = new NetworkCustomError();
            networkCustomError.setStatusCode(500);
            networkCustomError.setAlertMessage(getResources().getString(R.string.error_diff_checkout_default));
            networkCustomError.setmAlertTitle(getResources().getString(R.string.oops));
            PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse = this.O;
            if (onCheckoutResponse == null) {
                k.a();
            }
            a(networkCustomError, onCheckoutResponse);
        } else if (isConvFeeEnabled()) {
            this.P = onVerifyResponse;
            this.I = getIntent().getStringExtra("wallet_token");
            this.J = getIntent().getStringExtra(this.f65142c);
            ArrayList<PaymentIntent> paymentIntents = callbackData.getPaymentIntents();
            this.L.put(this.f65146g, paymentIntents != null ? new f().a((Object) paymentIntents) : null);
            this.Q = a.POST_VERIFY;
            a(c(this, this.I), a(this.J, false), this.L, (IJRPaytmDataModel) new CJRTrainCartVerify());
        }
    }

    public final void doCheckout(PaytmSDKRequestClient.CallbackData callbackData, PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse) {
        k.c(callbackData, "data");
        k.c(onCheckoutResponse, "onCheckoutResponse");
        this.O = onCheckoutResponse;
        JSONArray jSONArray = new JSONArray();
        Iterator<PaymentIntent> it2 = callbackData.getPaymentIntents().iterator();
        while (it2.hasNext()) {
            PaymentIntent next = it2.next();
            JSONObject jSONObject = new JSONObject();
            Double d2 = null;
            jSONObject.put("mode", next != null ? next.getMode() : null);
            jSONObject.put("conv_fee", next != null ? Double.valueOf(next.getConvFee()) : null);
            if (next != null) {
                d2 = Double.valueOf(next.getTxnAmount());
            }
            jSONObject.put("txnAmount", d2);
            jSONArray.put(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(this.f65146g, jSONArray);
        this.Q = a.CHECK_OUT;
        Context context = this;
        HashMap<String, String> c2 = c(context, this.I);
        HashMap<String, String> a2 = a(this.J, true);
        k.c(c2, "headers");
        k.c(a2, "urlParams");
        c.a();
        String a3 = c.a(this.C, "");
        if (!TextUtils.isEmpty(a3) && URLUtil.isValidUrl(a3)) {
            k.a((Object) a3, "URL");
            String c3 = com.paytm.utility.a.c(context, a(a3, a2));
            if (c3 == null) {
                k.a();
            }
            String b2 = b(context, c3);
            c.a();
            String b3 = ab.b(b2);
            k.a((Object) b3, "URL");
            a((IJRPaytmDataModel) new CJRTrainCartVerify(), b3, c2, jSONObject2);
        }
    }

    private final void a(NetworkCustomError networkCustomError, PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse) {
        s<Integer, String, String> b2 = b(networkCustomError);
        a(b2.getFirst(), b2.getSecond(), b2.getThird(), onCheckoutResponse);
    }

    private s<Integer, String, String> b(NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "error");
        if (networkCustomError instanceof ap) {
            return new s<>(Integer.valueOf(((ap) networkCustomError).getStatusCode()), getResources().getString(R.string.msg_invalid_url), getResources().getString(R.string.error));
        }
        return new s<>(Integer.valueOf(networkCustomError.getStatusCode()), networkCustomError.getAlertMessage(), networkCustomError.getAlertTitle());
    }

    private static PaytmSDKRequestClient.ApiResponseError a(Integer num, String str, String str2, boolean z) {
        PaytmSDKRequestClient.ApiResponseError apiResponseError = new PaytmSDKRequestClient.ApiResponseError();
        apiResponseError.setStatusCode(num != null ? num.intValue() : -1);
        apiResponseError.setErrorMsg(str);
        apiResponseError.setErrorTitle(str2);
        apiResponseError.setShouldClosePG(z);
        return apiResponseError;
    }

    private static void a(Integer num, String str, String str2, PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse) {
        k.c(onCheckoutResponse, "checkoutListener");
        onCheckoutResponse.onCheckoutError(a(num, str, str2, true));
    }

    public final void createOrderInfoFragment(PaytmSDKRequestClient.ShowOrderInfoFragment showOrderInfoFragment, Object obj) {
        Intent intent;
        Bundle extras;
        Bundle extras2;
        CJRCart cart;
        CJRCart cart2;
        if (!isFinishing() && (intent = getIntent()) != null && (extras = intent.getExtras()) != null && extras.containsKey(this.f65140a)) {
            Intent intent2 = getIntent();
            k.a((Object) intent2, "intent");
            Bundle extras3 = intent2.getExtras();
            if (extras3 == null) {
                k.a();
            }
            ArrayList arrayList = (ArrayList) extras3.getSerializable(this.f65140a);
            CJRTrainFareDetail cJRTrainFareDetail = null;
            Integer valueOf = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (valueOf.intValue() > 0) {
                CJRRechargeCart cJRRechargeCart = (CJRRechargeCart) obj;
                k.c(arrayList, "mFareDetails");
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    CJRTrainFareDetail cJRTrainFareDetail2 = (CJRTrainFareDetail) it2.next();
                    k.a((Object) cJRTrainFareDetail2, "fareDetail");
                    if (cJRTrainFareDetail2.getKey() == this.N) {
                        arrayList.remove(cJRTrainFareDetail2);
                        break;
                    }
                }
                Intent intent3 = getIntent();
                if (!(intent3 == null || (extras2 = intent3.getExtras()) == null || !extras2.containsKey(this.f65141b))) {
                    Intent intent4 = getIntent();
                    k.a((Object) intent4, "intent");
                    Bundle extras4 = intent4.getExtras();
                    if (extras4 == null) {
                        k.a();
                    }
                    int i2 = extras4.getInt(this.f65141b);
                    int size = arrayList.size();
                    int size2 = arrayList.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        Object obj2 = arrayList.get(i3);
                        k.a(obj2, "mFareDetails[index]");
                        CJRTrainFareDetail cJRTrainFareDetail3 = (CJRTrainFareDetail) obj2;
                        if (cJRTrainFareDetail3.getKey() == i2) {
                            for (CJRTrainValue next : cJRTrainFareDetail3.getValue()) {
                                k.a((Object) next, "values");
                                if (next.isAmount()) {
                                    if (!TextUtils.isEmpty((cJRRechargeCart == null || (cart2 = cJRRechargeCart.getCart()) == null) ? null : cart2.getFinalPrice())) {
                                        if (cJRRechargeCart == null) {
                                            k.a();
                                        }
                                        CJRCart cart3 = cJRRechargeCart.getCart();
                                        k.a((Object) cart3, "verifyObject!!.cart");
                                        next.setText(cart3.getFinalPrice());
                                    } else {
                                        next.setText(next.getServerAmount());
                                    }
                                }
                            }
                            size = i3;
                        }
                    }
                    if (!TextUtils.isEmpty((cJRRechargeCart == null || (cart = cJRRechargeCart.getCart()) == null) ? null : cart.getAggregatePGConvFee())) {
                        if (cJRRechargeCart == null) {
                            k.a();
                        }
                        CJRCart cart4 = cJRRechargeCart.getCart();
                        k.a((Object) cart4, "verifyObject!!.cart");
                        if (!p.a(cart4.getAggregatePGConvFee(), "0", true)) {
                            CJRCart cart5 = cJRRechargeCart.getCart();
                            String aggregatePGConvFee = cart5 != null ? cart5.getAggregatePGConvFee() : null;
                            if (aggregatePGConvFee == null) {
                                k.a();
                            }
                            k.c(aggregatePGConvFee, "mConvinienceFee");
                            if (!TextUtils.isEmpty(aggregatePGConvFee)) {
                                cJRTrainFareDetail = new CJRTrainFareDetail();
                                cJRTrainFareDetail.setKey(this.N);
                                CJRTrainDisplayName cJRTrainDisplayName = new CJRTrainDisplayName();
                                cJRTrainDisplayName.setText(this.D);
                                cJRTrainDisplayName.setAlignment(this.E);
                                cJRTrainDisplayName.setTextType(this.F);
                                cJRTrainFareDetail.setDisplayName(new ArrayList());
                                cJRTrainFareDetail.getDisplayName().add(cJRTrainDisplayName);
                                CJRTrainValue cJRTrainValue = new CJRTrainValue();
                                cJRTrainValue.setText(getString(R.string.rs_symbols));
                                cJRTrainValue.setAlignment(this.E);
                                cJRTrainValue.setTextType(this.F);
                                CJRTrainValue cJRTrainValue2 = new CJRTrainValue();
                                cJRTrainValue2.setText(aggregatePGConvFee);
                                cJRTrainValue2.setAlignment(this.E);
                                cJRTrainValue2.setTextType(this.F);
                                cJRTrainFareDetail.setValue(new ArrayList());
                                cJRTrainFareDetail.getValue().add(cJRTrainValue);
                                cJRTrainFareDetail.getValue().add(cJRTrainValue2);
                                cJRTrainFareDetail.setType(this.F);
                                cJRTrainFareDetail.setVisibility(true);
                            }
                            if (cJRTrainFareDetail != null) {
                                if (size <= arrayList.size()) {
                                    Object obj3 = arrayList.get(size - 1);
                                    k.a(obj3, "mFareDetails[convFeeIndex - 1]");
                                    if (p.a(((CJRTrainFareDetail) obj3).getType(), this.G, true)) {
                                        size--;
                                    }
                                    arrayList.add(size, cJRTrainFareDetail);
                                } else {
                                    arrayList.add(cJRTrainFareDetail);
                                }
                            }
                        }
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putSerializable(this.f65140a, arrayList);
                b.a aVar = b.f65154a;
                b bVar = new b();
                bVar.setArguments(bundle);
                this.M = bVar;
                if (showOrderInfoFragment != null) {
                    showOrderInfoFragment.showFragment(this.M);
                }
            }
        }
    }

    public final void onOtherPayModeSelected(boolean z, PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener) {
        k.c(otherPayOptionsListener, "otherPayOptionsListener");
        setResult(-1);
        PaytmSDKRequestClient.ApiResponseError apiResponseError = new PaytmSDKRequestClient.ApiResponseError();
        apiResponseError.setShouldClosePG(true);
        otherPayOptionsListener.onError(apiResponseError);
    }

    private void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, JSONObject jSONObject, IJRPaytmDataModel iJRPaytmDataModel) {
        k.c(hashMap, "headers");
        k.c(hashMap2, "urlParams");
        k.c(iJRPaytmDataModel, "model");
        c.a();
        String a2 = c.a(this.l, "");
        if (!TextUtils.isEmpty(a2) && URLUtil.isValidUrl(a2)) {
            k.a((Object) a2, "URL");
            String a3 = a(a2, hashMap2);
            Context context = this;
            String c2 = com.paytm.utility.a.c(context, a3);
            k.a((Object) c2, "URL");
            a(iJRPaytmDataModel, b(context, c2), hashMap, jSONObject);
        }
    }

    private static String a(String str, HashMap<String, String> hashMap) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry entry : hashMap.entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        String uri = buildUpon.build().toString();
        k.a((Object) uri, "uriBuilder.build().toString()");
        return uri;
    }

    private final void a(IJRPaytmDataModel iJRPaytmDataModel, String str, HashMap<String, String> hashMap, JSONObject jSONObject) {
        String str2;
        com.paytm.network.b bVar = new com.paytm.network.b();
        Context context = this;
        bVar.f42877a = context;
        bVar.f42878b = a.c.TRAIN;
        bVar.n = a.b.SILENT;
        bVar.o = "Payment";
        bVar.f42879c = a.C0715a.POST;
        bVar.f42880d = str;
        bVar.f42882f = hashMap;
        if (jSONObject != null) {
            str2 = jSONObject.toString();
        } else {
            str2 = null;
        }
        bVar.f42884h = str2;
        bVar.f42885i = iJRPaytmDataModel;
        bVar.x = 1;
        bVar.j = this;
        com.paytm.network.a l2 = bVar.l();
        l2.f42859c = false;
        if (com.paytm.utility.a.m(context)) {
            l2.a();
            return;
        }
        NetworkCustomError networkCustomError = new NetworkCustomError();
        networkCustomError.setErrorType(NetworkCustomError.ErrorType.NetworkError);
        handleErrorCode(-1, (IJRPaytmDataModel) null, networkCustomError);
    }

    private static String b(Context context, String str) {
        k.c(str, "url");
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("user_email", com.paytm.utility.b.m(context));
        buildUpon.appendQueryParameter("user_mobile", com.paytm.utility.b.l(context));
        String uri = buildUpon.build().toString();
        k.a((Object) uri, "uriBuilder.build().toString()");
        return uri;
    }

    private HashMap<String, String> c(Context context, String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        Map map = hashMap;
        map.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(context));
        map.put("wallet_token", str);
        if (!TextUtils.isEmpty(com.paytm.utility.b.ak(context)) && com.paytm.utility.b.ak(context).equals(e.b.RESELLER.name())) {
            map.put(this.j, this.k);
        }
        return hashMap;
    }

    private HashMap<String, String> a(String str, boolean z) {
        HashMap<String, String> hashMap = new HashMap<>();
        Map map = hashMap;
        map.put(this.f65142c, str);
        if (z) {
            map.put(this.f65143d, "1");
        }
        if (getIntent() != null) {
            Intent intent = getIntent();
            k.a((Object) intent, "intent");
            if (intent.getExtras() != null && getIntent().hasExtra(this.f65144e)) {
                map.put(this.f65144e, getIntent().getStringExtra(this.f65144e));
            }
        }
        return hashMap;
    }

    public final void a(boolean z, String str, PaytmSDKRequestClient paytmSDKRequestClient) {
        if (getIntent() != null) {
            Intent intent = getIntent();
            k.a((Object) intent, "intent");
            if (intent.getExtras() != null && getIntent().hasExtra(this.f65147h)) {
                int intExtra = getIntent().getIntExtra(this.f65147h, 0);
                int intExtra2 = getIntent().getIntExtra(this.f65148i, 0);
                if (intExtra > 0 && intExtra2 > 0) {
                    new Handler().postDelayed(new b(this, intExtra, intExtra2), 1000);
                }
            }
        }
        if (paytmSDKRequestClient == null) {
            super.a(z, str, (PaytmSDKRequestClient) this);
        } else {
            super.a(z, str, paytmSDKRequestClient);
        }
    }
}
