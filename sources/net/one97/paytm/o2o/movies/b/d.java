package net.one97.paytm.o2o.movies.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alipay.mobile.h5container.api.H5Param;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.gson.f;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.movies.booking.CJRPrevalidate;
import net.one97.paytm.common.entity.movies.foodbeverage.CJRFoodBeverageSetResponse;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.orflow.promo.utils.Constants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.b.c;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRCampaign;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRMCart;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRMovieCart;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRPaymentInfo;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRPromoMetaData;
import net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2;
import net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2;
import net.one97.paytm.o2o.movies.d.g;
import net.one97.paytm.o2o.movies.moviepass.a;
import net.one97.paytm.o2o.movies.utils.n;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class d implements b, a {

    /* renamed from: a  reason: collision with root package name */
    public CJRMovieCart f74904a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f74905b;

    /* renamed from: c  reason: collision with root package name */
    public g f74906c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f74907d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f74908e = false;

    /* renamed from: f  reason: collision with root package name */
    int f74909f = 0;

    /* renamed from: g  reason: collision with root package name */
    int f74910g = 0;

    /* renamed from: h  reason: collision with root package name */
    public String f74911h;

    /* renamed from: i  reason: collision with root package name */
    public String f74912i;
    public String j;
    public boolean k;
    private ProgressDialog l;
    private ArrayList<CJRFoodBeverageItemV2> m;
    private CJRPrevalidate n;
    private CJRCashWallet o;
    private boolean p = false;
    private int q;
    private String r;
    private String s = d.class.getSimpleName();
    private CJROrderSummaryMetadataResponseV2 t;
    private String u;
    /* access modifiers changed from: private */
    public int v;
    private boolean w;
    private String x;
    private PaytmSDKRequestClient.OtherPayOptionsListener y;
    private String z;

    public d(Activity activity, g gVar, CJROrderSummaryMetadataResponseV2 cJROrderSummaryMetadataResponseV2, String str) {
        this.f74905b = activity;
        this.f74906c = gVar;
        this.t = cJROrderSummaryMetadataResponseV2;
        this.u = str;
    }

    public final CJRPaymentInfo a() {
        CJRMovieCart cJRMovieCart = this.f74904a;
        if (cJRMovieCart == null || cJRMovieCart.getCart() == null) {
            return null;
        }
        return this.f74904a.getCart().paymentInfo;
    }

    public final void a(ArrayList<CJRFoodBeverageItemV2> arrayList) {
        this.k = false;
        if ((arrayList != null && this.m == null) || (arrayList == null && this.m != null)) {
            this.k = true;
        } else if (arrayList != null && arrayList != null) {
            if (arrayList.size() == this.m.size()) {
                int size = arrayList.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    boolean equals = arrayList.get(size).getmID().equals(this.m.get(size).getmID());
                    boolean z2 = arrayList.get(size).getmFoodQauntitySelected() == this.m.get(size).getmFoodQauntitySelected();
                    if (!equals || !z2) {
                        this.k = true;
                    } else {
                        size--;
                    }
                }
            } else {
                this.k = true;
            }
        }
        f fVar = new f();
        this.m = (ArrayList) fVar.a(fVar.b(arrayList), new com.google.gson.b.a<ArrayList<CJRFoodBeverageItemV2>>() {
        }.getType());
    }

    public final void b() {
        this.f74909f = 0;
        HashMap hashMap = new HashMap();
        com.paytm.utility.b.j();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("ClientId", "paytm");
        JSONObject b2 = b(this.m);
        StringBuilder sb = new StringBuilder();
        c.a();
        sb.append(c.a("postOrderSetFoodItemsUrl", (String) null));
        sb.append("?");
        String sb2 = sb.toString();
        if (URLUtil.isValidUrl(sb2)) {
            String s2 = com.paytm.utility.b.s(this.f74905b, sb2);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("Content-Type", "application/json");
            net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
            cVar.f42877a = this.f74905b;
            cVar.f42878b = a.c.MOVIES;
            cVar.f42879c = a.C0715a.POST;
            cVar.f42880d = s2;
            cVar.f42881e = null;
            cVar.f42882f = hashMap2;
            cVar.f42883g = null;
            cVar.f42884h = b2.toString();
            cVar.f42885i = new CJRFoodBeverageSetResponse();
            cVar.j = this;
            cVar.n = a.b.USER_FACING;
            cVar.o = "movies";
            cVar.t = n.h("CJRPostOrderFoodApiManager");
            com.paytm.network.a l2 = cVar.l();
            l2.f42859c = false;
            if (com.paytm.utility.b.c((Context) this.f74905b)) {
                e();
                l2.a();
                return;
            }
            f();
            if (!net.one97.paytm.o2o.movies.moviepass.d.a().a((NetworkCustomError) null)) {
                a(l2);
            }
        }
    }

    private JSONObject b(ArrayList<CJRFoodBeverageItemV2> arrayList) {
        CJRFoodBeverageItemV2 cJRFoodBeverageItemV2;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (!(arrayList == null || arrayList.size() <= 0 || (cJRFoodBeverageItemV2 = arrayList.get(0)) == null)) {
                jSONObject.put("provider_id", Integer.parseInt(cJRFoodBeverageItemV2.getmProviderID()));
                jSONObject.put("paytm_cinema_id", Integer.parseInt(cJRFoodBeverageItemV2.getmCinemaID()));
                this.q = Integer.parseInt(cJRFoodBeverageItemV2.getmProductID());
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                JSONObject jSONObject2 = new JSONObject();
                CJRFoodBeverageItemV2 cJRFoodBeverageItemV22 = arrayList.get(i2);
                int i3 = cJRFoodBeverageItemV22.getmFoodQauntitySelected();
                int parseInt = Integer.parseInt(cJRFoodBeverageItemV22.getmPrice());
                int i4 = i3 * parseInt;
                this.f74909f += i4;
                this.f74910g += Integer.parseInt(cJRFoodBeverageItemV22.getmConvinienceFee());
                jSONObject2.put("id", Integer.parseInt(cJRFoodBeverageItemV22.getmID()));
                jSONObject2.put("quantity", i3);
                jSONObject2.put("unit_price", parseInt);
                jSONObject2.put("price", i4);
                jSONObject2.put("conv_fee", Integer.parseInt(cJRFoodBeverageItemV22.getmConvinienceFee()));
                jSONObject2.put("itemImageUrl", cJRFoodBeverageItemV22.getmItemImageURL());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("total_charged_price", this.f74909f);
            jSONObject.put("total_conv_fee", this.f74910g);
            jSONObject.put("data", jSONArray);
            if (!(this.t == null || this.t.getShowTime() == null)) {
                jSONObject.put("show_datetime", this.t.getShowTime());
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private String b(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject2.put(CLPConstants.PRODUCT_ID, this.q);
            jSONObject2.put("qty", "1");
            jSONObject3.put("price", this.f74909f);
            jSONObject3.put("conv_fee", this.f74910g);
            jSONObject3.put("ty", "fd");
            jSONObject2.putOpt(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject3);
            JSONObject jSONObject5 = new JSONObject(str);
            jSONObject4.put("food_beverages", jSONObject5);
            jSONObject4.put("ticketNotPresent", 1);
            jSONObject4.put("isFoodPresent", 1);
            jSONObject4.put("providerId", jSONObject5.get("providerId"));
            jSONObject4.put(SDKConstants.KEY_TRANS_ID, jSONObject5.getString("tempTransId"));
            if (this.t != null) {
                jSONObject4.put(H5Param.SESSION_ID, this.t.getSessionId());
                jSONObject4.put("movie", this.t.getMovie());
                jSONObject4.put("cinema", this.t.getCinema());
                jSONObject4.put("multipleEticketSelected", false);
                jSONObject4.put("showTime", this.t.getShowTime());
                jSONObject4.put(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS, this.t.getStringAddress());
                jSONObject4.put("seatType", this.t.getSeatType());
                jSONObject4.put("seatIdsReturned", this.t.getSeatIdsReturned());
                jSONObject4.put("parent_booking_id", this.t.getBookingId());
                jSONObject4.put("totalTicketPrice", this.f74909f);
                jSONObject4.put("totalConvFee", this.f74910g);
                jSONObject4.put("citySearched", this.t.getCitySearched());
                jSONObject4.put("uniqueBookingId", this.t.getUniqueBookingId());
                jSONObject4.put("bookingIndex", this.t.getBookingIndex());
                jSONObject4.put("branchCode", this.t.getBranchCode());
                jSONObject4.put("movieImageUrl", this.t.getMovieImageUrl());
                jSONObject4.put("totalPgCharges", 0);
            }
            jSONObject4.put("parent_order_id", this.u);
            jSONObject4.put("totalCommision", jSONObject5.getString("commission"));
            jSONObject4.put("cinemaId", jSONObject5.getString("paytmCinemaId"));
            jSONObject4.put("bookingId", jSONObject5.getString("bookingId"));
            jSONObject4.put("totalFoodPrice", this.f74909f);
            JSONObject jSONObject6 = new JSONObject();
            String j2 = com.paytm.utility.b.j((Context) this.f74905b);
            String m2 = com.paytm.utility.b.m((Context) this.f74905b);
            String l2 = com.paytm.utility.b.l((Context) this.f74905b);
            if (!TextUtils.isEmpty(j2)) {
                jSONObject6.put("name", j2);
            }
            if (!TextUtils.isEmpty(m2)) {
                jSONObject6.put(AppConstants.KEY_EMAIL, m2);
            }
            if (!TextUtils.isEmpty(l2)) {
                jSONObject6.put("mobileNumber", l2);
            }
            jSONObject4.put("passenger", jSONObject6);
            jSONObject2.put("meta_data", jSONObject4);
            jSONArray.put(jSONObject2);
            jSONObject.put("cart_items", jSONArray);
            jSONObject.put("channel", com.paytm.utility.c.f43762a);
            String Q = com.paytm.utility.b.Q((Context) this.f74905b);
            if (!TextUtils.isEmpty(Q)) {
                jSONObject.put("version", Q);
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void a(NetworkCustomError networkCustomError) {
        if (networkCustomError != null) {
            try {
                String message = networkCustomError.getMessage();
                networkCustomError.getUrl();
                if (!TextUtils.isEmpty(networkCustomError.getMessage()) && (networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
                    net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.handleError(this.f74905b, networkCustomError, (String) null, (Bundle) null, false);
                } else if (message != null && message.equalsIgnoreCase("412")) {
                    com.paytm.utility.g.a((Context) this.f74905b, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                } else if (networkCustomError.getMessage() != null && !net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.checkErrorCode(this.f74905b, networkCustomError)) {
                    if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                        com.paytm.utility.b.b((Context) this.f74905b, this.f74905b.getResources().getString(R.string.network_error_heading), this.f74905b.getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                        return;
                    }
                    com.paytm.utility.b.d((Context) this.f74905b, networkCustomError.getUrl(), String.valueOf(networkCustomError.getStatusCode()));
                }
            } catch (Resources.NotFoundException | Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(final com.paytm.network.a aVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f74905b);
        builder.setTitle(this.f74905b.getString(net.one97.paytm.common.assets.R.string.no_connection));
        builder.setMessage(this.f74905b.getString(net.one97.paytm.common.assets.R.string.no_internet));
        builder.setPositiveButton(this.f74905b.getString(net.one97.paytm.common.assets.R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (com.paytm.utility.b.c((Context) d.this.f74905b)) {
                    d.this.e();
                    aVar.a();
                    return;
                }
                d.this.a(aVar);
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public void e() {
        Activity activity = this.f74905b;
        if (activity != null && !activity.isFinishing()) {
            ProgressDialog progressDialog = this.l;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.l = new ProgressDialog(this.f74905b);
                try {
                    this.l.setIndeterminateDrawable(androidx.core.content.b.a((Context) this.f74905b, R.drawable.custom_progress_bar_movies));
                    this.l.setMessage(this.f74905b.getString(R.string.please_wait_progress_msg));
                    this.l.setCancelable(false);
                    this.l.setCanceledOnTouchOutside(false);
                    this.l.show();
                } catch (Exception | IllegalArgumentException unused) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        Activity activity;
        ProgressDialog progressDialog = this.l;
        if (progressDialog != null && progressDialog.isShowing() && (activity = this.f74905b) != null && !activity.isFinishing()) {
            this.l.dismiss();
        }
    }

    private void g() {
        JSONObject jSONObject;
        c.a();
        String b2 = com.paytm.utility.c.b(c.a("postFnBVerifyURL", (String) null), (Context) this.f74905b);
        StringBuilder sb = new StringBuilder();
        sb.append("&payment_info=1");
        sb.append("&payment_info_version=2");
        sb.append("&native_withdraw=1");
        if (this.v == 1) {
            sb.append("&manual_promocode=1");
        }
        String str = b2 + sb.toString();
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("ClientId", "paytm");
        HashMap<String, String> a2 = com.paytm.utility.b.a((HashMap<String, String>) hashMap, (Context) this.f74905b);
        try {
            jSONObject = new JSONObject(this.n.getCartBody());
            try {
                if (!TextUtils.isEmpty(this.f74912i)) {
                    jSONObject.put("paymentFilters", this.f74912i);
                } else if (!TextUtils.isEmpty(this.j)) {
                    jSONObject.put("payment_intent", this.j);
                    jSONObject.put("enable_upi_psp", this.x);
                }
                if (TextUtils.isEmpty(this.f74912i) || this.v == 1) {
                    a(jSONObject);
                }
                new HashMap().put("manual_promo", Integer.valueOf(this.v));
            } catch (JSONException unused) {
            }
        } catch (JSONException unused2) {
            jSONObject = null;
        }
        String jSONObject2 = jSONObject.toString();
        net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
        cVar.f42877a = this.f74905b;
        cVar.f42878b = a.c.MOVIES;
        cVar.f42879c = a.C0715a.POST;
        cVar.f42880d = str;
        cVar.f42881e = null;
        cVar.f42882f = a2;
        cVar.f42883g = null;
        cVar.f42884h = jSONObject2;
        cVar.f42885i = new CJRMovieCart();
        cVar.j = new b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                HashMap<String, CJRCampaign> hashMap;
                CJRMovieCart cJRMovieCart = (CJRMovieCart) iJRPaytmDataModel;
                if (!d.this.f74907d) {
                    d.this.f();
                }
                if (d.this.f74912i != null) {
                    String unused = d.this.f74912i = null;
                    net.one97.paytm.o2o.movies.moviepass.d.a().a(cJRMovieCart.getCart(), false);
                    return;
                }
                if (d.this.v == 1) {
                    int unused2 = d.this.v = 0;
                    CJRPromoMetaData cJRPromoMetaData = cJRMovieCart.getCart().promoMetaData;
                    if (!(cJRPromoMetaData == null || (hashMap = cJRPromoMetaData.campData) == null || !Constants.BANK_OFFER_KEY.equalsIgnoreCase(hashMap.get(d.this.f74911h).campaignType))) {
                        net.one97.paytm.o2o.movies.moviepass.d.a().a(cJRMovieCart.getCart(), false);
                        return;
                    }
                }
                CJRMovieCart unused3 = d.this.f74904a = cJRMovieCart;
                d dVar = d.this;
                d.b(dVar, dVar.f74904a);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (d.this.f74905b != null && !d.this.f74905b.isFinishing()) {
                    if (networkCustomError != null && "failure_error".equalsIgnoreCase(networkCustomError.getMessage())) {
                        String unused = d.this.f74911h = null;
                    }
                    d.this.f();
                    if (!net.one97.paytm.o2o.movies.moviepass.d.a().a(networkCustomError)) {
                        d.this.a(networkCustomError);
                    }
                }
            }
        };
        cVar.n = a.b.USER_FACING;
        cVar.o = "movies";
        cVar.t = n.h("CJRJustTicketsBookingApiManager");
        com.paytm.network.a l2 = cVar.l();
        l2.f42859c = false;
        if (com.paytm.utility.b.c((Context) this.f74905b)) {
            e();
            l2.a();
            return;
        }
        f();
        if (!net.one97.paytm.o2o.movies.moviepass.d.a().a((NetworkCustomError) null)) {
            a(l2);
        }
    }

    private void a(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.f74911h)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("action", "applypromo");
                jSONObject2.put("globalcode", this.f74911h);
                jSONObject.put("promo_action", jSONObject2);
            } catch (JSONException unused) {
            }
        }
    }

    private void h() {
        com.paytm.utility.b.j();
        c.a();
        String b2 = com.paytm.utility.b.b((Context) this.f74905b, c.a("checkBalance", (String) null));
        HashMap hashMap = new HashMap();
        hashMap.put("ssotoken", net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getSSOToken(this.f74905b));
        hashMap.put("ClientId", "paytm");
        net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
        cVar.f42877a = this.f74905b;
        cVar.f42878b = a.c.MOVIES;
        cVar.f42879c = a.C0715a.POST;
        cVar.f42880d = b2;
        cVar.f42881e = null;
        cVar.f42882f = hashMap;
        cVar.f42883g = null;
        cVar.f42884h = null;
        cVar.f42885i = new CJRCashWallet();
        cVar.j = this;
        cVar.n = a.b.USER_FACING;
        cVar.o = "movies";
        cVar.t = n.h("CJRPOSTOrderFiddApimanager");
        com.paytm.network.a l2 = cVar.l();
        if (com.paytm.utility.b.c((Context) this.f74905b)) {
            e();
            l2.a();
            return;
        }
        f();
        a(l2);
    }

    private void i() {
        com.paytm.utility.b.j();
        try {
            if (this.f74905b == null) {
                return;
            }
            if (!this.f74905b.isFinishing()) {
                String sSOToken = net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getSSOToken(this.f74905b);
                if (TextUtils.isEmpty(sSOToken)) {
                    f();
                    net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.showSessionTimeoutAlert(this.f74905b, (String) null, (Bundle) null, (Exception) null);
                } else if (com.paytm.utility.b.c((Context) this.f74905b)) {
                    e();
                    net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getWalletTokenMovies(sSOToken, this.f74905b, new b() {
                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        }

                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                                d.a(d.this, (CJRPGTokenList) iJRPaytmDataModel);
                            }
                        }
                    });
                } else {
                    f();
                    com.paytm.utility.b.b((Context) this.f74905b, this.f74905b.getString(net.one97.paytm.common.assets.R.string.no_connection), this.f74905b.getString(R.string.no_internet));
                }
            }
        } catch (Exception unused) {
            f();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = r5.f74904a.getCart().paymentInfo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
            r5 = this;
            net.one97.paytm.o2o.movies.common.movies.booking.CJRMovieCart r0 = r5.f74904a
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001c
            net.one97.paytm.o2o.movies.common.movies.booking.CJRMCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x001c
            net.one97.paytm.o2o.movies.common.movies.booking.CJRMovieCart r0 = r5.f74904a
            net.one97.paytm.o2o.movies.common.movies.booking.CJRMCart r0 = r0.getCart()
            net.one97.paytm.o2o.movies.common.movies.booking.CJRPaymentInfo r0 = r0.paymentInfo
            if (r0 == 0) goto L_0x001c
            int r0 = r0.native_withdraw
            if (r0 != r2) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            boolean r3 = r5.f74908e
            if (r3 == 0) goto L_0x0025
            r5.h()
            return
        L_0x0025:
            if (r0 == 0) goto L_0x003d
            r5.w = r2
            net.one97.paytm.o2o.movies.d.g r0 = r5.f74906c
            net.one97.paytm.o2o.movies.common.movies.booking.CJRMovieCart r3 = r5.f74904a
            java.lang.String r4 = r5.j
            if (r4 == 0) goto L_0x0032
            r1 = 1
        L_0x0032:
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$OtherPayOptionsListener r2 = r5.y
            android.app.ProgressDialog r4 = r5.l
            r0.a(r3, r1, r2, r4)
            r0 = 0
            r5.y = r0
            return
        L_0x003d:
            r5.i()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.b.d.c():void");
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        Activity activity = this.f74905b;
        if (activity != null && !activity.isFinishing()) {
            if (iJRPaytmDataModel instanceof CJRPrevalidate) {
                this.n = (CJRPrevalidate) iJRPaytmDataModel;
                g();
            } else if (iJRPaytmDataModel instanceof CJRCashWallet) {
                CJRCashWallet cJRCashWallet = (CJRCashWallet) iJRPaytmDataModel;
                if (cJRCashWallet == null || cJRCashWallet.getResponse() == null) {
                    this.o = null;
                    i();
                    return;
                }
                this.o = cJRCashWallet;
                i();
            } else if (iJRPaytmDataModel instanceof CJRRechargePayment) {
                CJRRechargePayment cJRRechargePayment = (CJRRechargePayment) iJRPaytmDataModel;
                if (cJRRechargePayment.getStatus() == null || !cJRRechargePayment.getStatus().equalsIgnoreCase("SUCCESS")) {
                    f();
                    if (cJRRechargePayment != null && cJRRechargePayment.getCode() == 401) {
                        NetworkCustomError networkCustomError = new NetworkCustomError();
                        c.a();
                        if (!TextUtils.isEmpty(c.a("cartCheckout", (String) null))) {
                            c.a();
                            networkCustomError.setUrl(c.a("cartCheckout", (String) null));
                            if (cJRRechargePayment.getError() != null && !TextUtils.isEmpty(cJRRechargePayment.getError().getMessage())) {
                                networkCustomError.setAlertMessage(cJRRechargePayment.getError().getMessage());
                            }
                        }
                        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.showSessionTimeoutAlert(this.f74905b, (String) null, (Bundle) null, networkCustomError);
                    } else if (cJRRechargePayment != null && cJRRechargePayment.getError() != null) {
                        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.showCustomAlert(this.f74905b, cJRRechargePayment.getError().getTitle(), cJRRechargePayment.getError().getMessage());
                    }
                } else {
                    f();
                    if (!this.p || !this.f74908e) {
                        if (this.w) {
                            net.one97.paytm.o2o.movies.moviepass.d.a().a(cJRRechargePayment);
                            return;
                        }
                        Intent intent = new Intent(this.f74905b, net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPaytmActivityMap().get("paymentActivity"));
                        if (!TextUtils.isEmpty(cJRRechargePayment.getmTxnToken())) {
                            intent.putExtra("txnToken", cJRRechargePayment.getmTxnToken());
                            intent.putExtra("orderid", cJRRechargePayment.getOrderId());
                            intent.putExtra("mid", cJRRechargePayment.getMID());
                            intent.putExtra("nativeSdkEnabled", true);
                            CJRMovieCart cJRMovieCart = this.f74904a;
                            if (cJRMovieCart != null) {
                                intent.putExtra("recharge cart", cJRMovieCart);
                            }
                        } else {
                            intent.putExtra("nativeSdkEnabled", false);
                        }
                        intent.putExtra(UpiConstants.FROM, "MoviesFnBPage");
                        intent.putExtra("is_movie_ticket", true);
                        intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
                        this.f74905b.startActivity(intent);
                    } else if (cJRRechargePayment != null && cJRRechargePayment.getOrderId() != null) {
                        String orderId = cJRRechargePayment.getOrderId();
                        Intent intent2 = new Intent(this.f74905b, net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPaytmActivityMap().get("ordersummary"));
                        intent2.putExtra(UpiConstants.FROM, "Payment");
                        intent2.putExtra("order_id", orderId);
                        intent2.putExtra(AppConstants.IS_CANCEL, false);
                        this.f74905b.startActivity(intent2);
                    }
                }
            } else if ((iJRPaytmDataModel instanceof CJRFoodBeverageSetResponse) && (str = ((CJRFoodBeverageSetResponse) iJRPaytmDataModel).getmFoodBevResponse()) != null && !TextUtils.isEmpty(str)) {
                q.d("foodCArt ".concat(String.valueOf(b(str))));
                com.paytm.utility.b.j();
                c.a();
                String a2 = c.a("moviesPrevalidate", (String) null);
                if (URLUtil.isValidUrl(a2)) {
                    String d2 = com.paytm.utility.b.d((Context) this.f74905b, a2);
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put("ClientId", "paytm");
                    String b2 = b(str);
                    "prevalidate : ".concat(String.valueOf(b2));
                    com.paytm.utility.b.j();
                    net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
                    cVar.f42877a = this.f74905b;
                    cVar.f42878b = a.c.MOVIES;
                    cVar.f42879c = a.C0715a.POST;
                    cVar.f42880d = d2;
                    cVar.f42881e = null;
                    cVar.f42882f = hashMap;
                    cVar.f42883g = null;
                    cVar.f42884h = b2;
                    cVar.f42885i = new CJRPrevalidate();
                    cVar.j = this;
                    cVar.n = a.b.USER_FACING;
                    cVar.o = "movies";
                    cVar.t = n.h("CJRJustTicketsBookingApiManager");
                    com.paytm.network.a l2 = cVar.l();
                    l2.f42859c = false;
                    if (com.paytm.utility.b.c((Context) this.f74905b)) {
                        e();
                        l2.a();
                        return;
                    }
                    f();
                    a(l2);
                }
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        Activity activity = this.f74905b;
        if (activity != null && !activity.isFinishing()) {
            f();
            if ((iJRPaytmDataModel instanceof CJRRechargeCart) && networkCustomError != null && "failure_error".equalsIgnoreCase(networkCustomError.getMessage())) {
                this.f74911h = null;
            }
            if ((iJRPaytmDataModel instanceof CJRFoodBeverageSetResponse) || (iJRPaytmDataModel instanceof CJRPrevalidate)) {
                if (!net.one97.paytm.o2o.movies.moviepass.d.a().a(networkCustomError)) {
                    Activity activity2 = this.f74905b;
                    com.paytm.utility.b.b((Context) activity2, activity2.getResources().getString(R.string.error_generic_movies_title), this.f74905b.getResources().getString(R.string.error_generic_movies_body));
                } else {
                    return;
                }
            }
            if (iJRPaytmDataModel instanceof CJRRechargePayment) {
                net.one97.paytm.o2o.movies.moviepass.d.a().b(net.one97.paytm.o2o.movies.moviepass.d.b(networkCustomError));
            }
            a(networkCustomError);
        }
    }

    public final void a(String str, int i2, String str2, boolean z2) {
        this.v = i2;
        this.f74912i = str2;
        this.f74911h = str;
        this.f74907d = false;
        if (a() == null || this.k) {
            b();
        } else {
            g();
        }
    }

    public final void a(String str, String str2) {
        this.j = str;
        this.x = str2;
        g();
    }

    public final void a(String str) {
        this.z = str;
        i();
    }

    public final void a(PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener) {
        this.y = otherPayOptionsListener;
        this.f74906c.b();
        this.j = null;
        this.f74912i = null;
        this.v = 0;
        g();
    }

    public final void d() {
        this.f74906c.b();
    }

    public final void a(boolean z2) {
        if (!z2) {
            this.f74912i = null;
            this.f74911h = null;
            this.j = null;
            this.v = 0;
        }
        f();
    }

    static /* synthetic */ void b(d dVar, CJRMovieCart cJRMovieCart) {
        String str;
        if (cJRMovieCart != null && cJRMovieCart.getCartStatus() != null && cJRMovieCart.getCartStatus().getResult() != null && cJRMovieCart.getCartStatus().getResult().equalsIgnoreCase("SUCCESS") && !net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.containsError(cJRMovieCart, dVar.f74905b)) {
            CJRMCart cart = cJRMovieCart.getCart();
            Activity activity = dVar.f74905b;
            if (activity != null && !activity.isFinishing()) {
                String str2 = null;
                if (cart == null || cart.getPromoStatus() == null || !cart.getPromoStatus().equalsIgnoreCase("SUCCESS")) {
                    String promoFailureText = cart != null ? cart.getPromoFailureText() : null;
                    if (promoFailureText == null || promoFailureText.trim().length() == 0) {
                        promoFailureText = dVar.f74905b.getResources().getString(R.string.msg_invalid_recharge_promo_code);
                    }
                    net.one97.paytm.o2o.movies.moviepass.d.a().a(promoFailureText);
                    dVar.j = null;
                    dVar.f74912i = null;
                    g gVar = dVar.f74906c;
                    if (gVar != null) {
                        cart.getPaytmCashBack();
                        gVar.a(promoFailureText);
                    }
                    if (dVar.f74907d) {
                        dVar.c();
                    }
                    dVar.f74911h = null;
                    return;
                }
                if (cart.getCartItems() == null || cart.getCartItems().size() <= 0) {
                    str = null;
                } else {
                    String str3 = null;
                    int i2 = 0;
                    while (true) {
                        if ((TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) && i2 < cart.getCartItems().size()) {
                            CJRCartProduct cJRCartProduct = cart.getCartItems().get(i2);
                            dVar.f74911h = cJRCartProduct.getPromoCode();
                            String str4 = dVar.f74911h;
                            String promoText = cJRCartProduct.getPromoText();
                            dVar.r = promoText;
                            i2++;
                            String str5 = str4;
                            str3 = promoText;
                            str2 = str5;
                        }
                    }
                    String str6 = str3;
                    str = str2;
                    str2 = str6;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = cart.getPromoText();
                }
                net.one97.paytm.o2o.movies.moviepass.d.a().a(cart, true);
                g gVar2 = dVar.f74906c;
                if (gVar2 != null) {
                    cart.getPaytmCashBack();
                    gVar2.a(str, str2, cart.getPaytmDiscount());
                }
                if (dVar.f74907d) {
                    dVar.c();
                }
            }
        }
    }

    static /* synthetic */ void a(d dVar, CJRPGTokenList cJRPGTokenList) {
        String str;
        String str2;
        String pgToken = net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPgToken(cJRPGTokenList);
        if (!TextUtils.isEmpty(pgToken)) {
            com.paytm.utility.b.j();
            Activity activity = dVar.f74905b;
            if (activity != null && !activity.isFinishing()) {
                dVar.p = false;
                c.a();
                String b2 = com.paytm.utility.c.b(c.a("postFnBCheckoutURL", (String) null), (Context) dVar.f74905b);
                String k2 = com.paytm.utility.b.k();
                if (Uri.parse(b2).getQuery() != null) {
                    str = b2 + "&wallet_token=" + pgToken + "&client_id=" + k2;
                } else {
                    str = b2 + "?wallet_token=" + pgToken + "&client_id=" + k2;
                }
                String d2 = com.paytm.utility.b.d(str, "POST");
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                hashMap.put("ClientId", "paytm");
                HashMap<String, String> a2 = com.paytm.utility.b.a((HashMap<String, String>) hashMap, (Context) dVar.f74905b);
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.clearRisk();
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.setRiskExtendedInfo(dVar.f74905b, (String) null, (String) null, false, (String) null);
                String jsonOfRiskExtendedInfo = net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getJsonOfRiskExtendedInfo();
                if (!TextUtils.isEmpty(jsonOfRiskExtendedInfo)) {
                    a2.put("risk_extended_info", jsonOfRiskExtendedInfo);
                }
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.clearRisk();
                CJRPrevalidate cJRPrevalidate = dVar.n;
                if (cJRPrevalidate != null) {
                    str2 = cJRPrevalidate.getCartBody();
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (!TextUtils.isEmpty(dVar.z)) {
                            jSONObject.put("payment_intent", dVar.z);
                        }
                        dVar.a(jSONObject);
                        str2 = jSONObject.toString();
                    } catch (JSONException unused) {
                    }
                } else {
                    str2 = "";
                }
                CJRCashWallet cJRCashWallet = dVar.o;
                if (cJRCashWallet == null || !dVar.f74908e) {
                    d2 = d2 + "&native_withdraw=1";
                } else if (0.0d <= cJRCashWallet.getResponse().getAmount()) {
                    dVar.p = true;
                    d2 = d2 + "&withdraw=1";
                }
                net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
                cVar.f42877a = dVar.f74905b;
                cVar.f42878b = a.c.MOVIES;
                cVar.f42879c = a.C0715a.POST;
                cVar.f42880d = d2;
                cVar.f42881e = null;
                cVar.f42882f = a2;
                cVar.f42883g = null;
                cVar.f42884h = str2;
                cVar.f42885i = new CJRRechargePayment();
                cVar.j = dVar;
                cVar.n = a.b.USER_FACING;
                cVar.o = "movies";
                cVar.t = n.h("CJRPostOrderFoodApimManager");
                com.paytm.network.a l2 = cVar.l();
                l2.f42859c = false;
                if (com.paytm.utility.b.c((Context) dVar.f74905b)) {
                    dVar.e();
                    l2.a();
                    return;
                }
                dVar.f();
                dVar.a(l2);
                return;
            }
            return;
        }
        dVar.f();
        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.showSessionTimeoutAlert(dVar.f74905b, (String) null, (Bundle) null, (Exception) null);
    }
}
