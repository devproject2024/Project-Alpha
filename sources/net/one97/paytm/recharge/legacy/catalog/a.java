package net.one97.paytm.recharge.legacy.catalog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.fragment.app.Fragment;
import com.google.gsonhtcfix.o;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.g;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.x;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJRDetailProduct;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.aa;
import net.one97.paytm.recharge.common.e.af;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.f.d;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.n;
import net.one97.paytm.recharge.common.utils.y;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2;
import net.one97.paytm.recharge.legacy.catalog.model.v2.CJRUtilityCheckboxItem;
import net.one97.paytm.recharge.model.BannerData;
import net.one97.paytm.recharge.model.ContactItemModel;
import net.one97.paytm.recharge.model.creditcard.CJRCreditCardMID;
import net.one97.paytm.recharge.model.creditcard.CJRCreditCardToken;
import net.one97.paytm.recharge.ordersummary.f.h;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class a implements FetchPayOptionsListener, ai {

    /* renamed from: a  reason: collision with root package name */
    protected CJRCashWallet f52607a;

    /* renamed from: b  reason: collision with root package name */
    Map<String, Object> f52608b;

    /* renamed from: c  reason: collision with root package name */
    protected af f52609c;

    /* renamed from: d  reason: collision with root package name */
    protected C0940a f52610d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f52611e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Context f52612f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Activity f52613g;

    /* renamed from: h  reason: collision with root package name */
    private CJRRechargeCart f52614h;

    /* renamed from: i  reason: collision with root package name */
    private CJRRechargePayment f52615i;
    private boolean j;
    private String k;
    private g.a l;
    private boolean m;
    private boolean n;
    private h o;
    private b p;
    private String q;
    private String r;
    private String s;
    /* access modifiers changed from: private */
    public aa t;

    /* renamed from: net.one97.paytm.recharge.legacy.catalog.a$a  reason: collision with other inner class name */
    public interface C0940a {
        void a(String str, Map<String, String> map, String str2);

        void a(CJRPGTokenList cJRPGTokenList);

        void o();
    }

    public interface b {
        void c(boolean z);
    }

    public void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse) {
    }

    public void onRequestStart() {
    }

    public void onVpaReceived(VpaFetch vpaFetch) {
    }

    private a(Activity activity, Context context, af afVar, C0940a aVar, String str, h hVar) {
        this.m = false;
        this.n = false;
        this.s = "";
        this.f52612f = context;
        this.f52613g = activity;
        this.f52610d = aVar;
        this.f52609c = afVar;
        this.k = str;
        this.o = hVar;
        this.p = afVar instanceof b ? (b) afVar : null;
    }

    public a(Context context, String str, af afVar, g.a aVar, h hVar, aa aaVar) {
        this(context, afVar, aVar, hVar);
        this.t = aaVar;
        this.s = str;
    }

    public a(Activity activity, Context context, String str, af afVar, C0940a aVar, String str2, h hVar, aa aaVar) {
        this(activity, context, afVar, aVar, str2, hVar);
        this.t = aaVar;
        this.s = str;
    }

    private a(Context context, af afVar, g.a aVar, h hVar) {
        this.m = false;
        this.n = false;
        this.s = "";
        this.f52612f = context;
        this.f52609c = afVar;
        this.l = aVar;
        this.o = hVar;
        this.p = afVar instanceof b ? (b) afVar : null;
    }

    private static String a(HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        try {
            for (Map.Entry next : hashMap.entrySet()) {
                if (z) {
                    z = false;
                } else {
                    sb.append(AppConstants.AND_SIGN);
                }
                sb.append(URLEncoder.encode((String) next.getKey(), AppConstants.UTF_8));
                sb.append("=");
                sb.append(URLEncoder.encode((String) next.getValue(), AppConstants.UTF_8));
            }
        } catch (UnsupportedEncodingException e2) {
            q.d(e2.getMessage());
        }
        return sb.toString();
    }

    public final synchronized void a() {
        this.f52609c = null;
    }

    public final void a(String str, String str2, boolean z, Object obj) {
        af afVar;
        Context context = this.f52612f;
        c cVar = c.f62654a;
        String b2 = com.paytm.utility.b.b(context, str2, c.C());
        af afVar2 = this.f52609c;
        if (afVar2 != null && !z) {
            afVar2.g();
        }
        if (com.paytm.utility.b.c(this.f52612f)) {
            af afVar3 = this.f52609c;
            if (afVar3 != null && z) {
                afVar3.j();
            }
            d.a();
            d.b(b(str, b2, z, obj));
            return;
        }
        af afVar4 = this.f52609c;
        if (afVar4 != null) {
            afVar4.h();
        }
        if (this.t == null || (afVar = this.f52609c) == null || !afVar.n()) {
            a(obj);
        } else {
            this.t.a(b(str, b2, z, obj), this.f52612f, false);
        }
    }

    public final net.one97.paytm.recharge.common.f.b b(String str, final String str2, final boolean z, Object obj) {
        if (obj instanceof CJRRechargeErrorModel) {
            CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
            if (cJRRechargeErrorModel.getFlowName() == null) {
                cJRRechargeErrorModel.setFlowName(new CRUFlowModel());
            }
            cJRRechargeErrorModel.getFlowName().setErrorType(ERROR_TYPE.UNDEFINED.name());
            cJRRechargeErrorModel.getFlowName().setActionType(ACTION_TYPE.GET_CATEGORY_CATALOG.name());
            cJRRechargeErrorModel.getFlowName().setTag(str);
        }
        return new net.one97.paytm.recharge.common.f.b(str, com.paytm.utility.b.b(this.f52612f, str2), new ai() {
            public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                a.this.a_(str, iJRPaytmDataModel, obj);
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                if (!z || networkCustomError == null || !"network_error".equalsIgnoreCase(networkCustomError.getMessage())) {
                    a.this.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
                } else {
                    a.this.t.a(a.this.b(str, str2, z, obj), a.this.f52612f, false);
                }
            }
        }, new CJRUtilityProductListV2(), obj);
    }

    public final void a(String str, String str2, Object obj) {
        try {
            c cVar = c.f62654a;
            String e2 = c.e();
            if (!TextUtils.isEmpty(e2)) {
                String str3 = e2 + str2;
                HashMap hashMap = new HashMap();
                hashMap.put("request_Type", "s2s");
                if (com.paytm.utility.b.c(this.f52612f)) {
                    if (this.f52609c != null) {
                        this.f52609c.j();
                    }
                    d.a();
                    d.b(new net.one97.paytm.recharge.common.f.b(str, com.paytm.utility.b.b(this.f52612f, str3), this, new CJRDetailProduct(), hashMap, obj));
                    return;
                }
                a(obj);
            }
        } catch (NullPointerException e3) {
            q.d(e3.getMessage());
        }
    }

    private void a(Object obj) {
        af afVar = this.f52609c;
        if (afVar != null) {
            afVar.h();
            this.f52609c.m();
            return;
        }
        ACTION_TYPE action_type = ACTION_TYPE.UNDEFINED;
        if (obj instanceof CJRRechargeErrorModel) {
            CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
            if (cJRRechargeErrorModel.getFlowName() != null) {
                action_type = ACTION_TYPE.Companion.getActionType(cJRRechargeErrorModel.getFlowName().getActionType(), action_type);
            }
        }
        g.f43805b = this.l;
        az azVar = az.f61525a;
        az.a(this.f52612f, ERROR_TYPE.NO_CONNECTION, action_type, this.f52612f.getString(R.string.no_connection), this.f52612f.getString(R.string.no_internet));
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        b bVar = this.p;
        if (bVar != null) {
            bVar.c(true);
        }
        af afVar = this.f52609c;
        if (afVar != null) {
            afVar.h();
        }
        C0940a aVar = this.f52610d;
        if (aVar != null) {
            aVar.o();
        }
        if (networkCustomError != null) {
            if (networkCustomError.getMessage() != null) {
                q.d(networkCustomError.getMessage());
            }
            CJRRechargeUtilities.INSTANCE.handleError(str, this.f52613g, (Fragment) null, networkCustomError, true, 3, obj);
        }
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        af afVar;
        af afVar2;
        if (iJRPaytmDataModel != null) {
            if (iJRPaytmDataModel instanceof CJRUtilityProductListV2) {
                af afVar3 = this.f52609c;
                if (afVar3 != null) {
                    afVar3.h();
                    this.f52609c.a((CJRUtilityProductListV2) iJRPaytmDataModel);
                }
            } else if (iJRPaytmDataModel instanceof CJRDetailProduct) {
                af afVar4 = this.f52609c;
                if (afVar4 != null) {
                    afVar4.h();
                    this.f52609c.a((CJRDetailProduct) iJRPaytmDataModel);
                }
            } else if (iJRPaytmDataModel instanceof CJRCreditCardMID) {
                CJRCreditCardMID cJRCreditCardMID = (CJRCreditCardMID) iJRPaytmDataModel;
                if (!(cJRCreditCardMID == null || cJRCreditCardMID.getMid() == null)) {
                    this.f52609c.b(cJRCreditCardMID.getMid());
                }
            } else if (iJRPaytmDataModel instanceof CJRCreditCardToken) {
                CJRCreditCardToken cJRCreditCardToken = (CJRCreditCardToken) iJRPaytmDataModel;
                if (cJRCreditCardToken != null && cJRCreditCardToken.getErrorCode() != null) {
                    af afVar5 = this.f52609c;
                    if (afVar5 != null) {
                        afVar5.h();
                    }
                    az azVar = az.f61525a;
                    az.a(this.f52612f, ERROR_TYPE.UNDEFINED, ACTION_TYPE.CLP_PROCEED, cJRCreditCardToken.getStatus(), cJRCreditCardToken.getErrorMsg());
                } else if (!(cJRCreditCardToken == null || cJRCreditCardToken.getToken() == null)) {
                    this.f52609c.c(cJRCreditCardToken.getToken());
                }
            } else if (iJRPaytmDataModel instanceof CJRRechargeCart) {
                if (iJRPaytmDataModel != null) {
                    CJRRechargeCart cJRRechargeCart = (CJRRechargeCart) iJRPaytmDataModel;
                    if (!(cJRRechargeCart.getCart() == null || cJRRechargeCart.getCart().getPaymentInstruments() == null)) {
                        PaytmSDK.parseAndSetInstruments(cJRRechargeCart.getCart().getPaymentInstruments().toString());
                    }
                }
                af afVar6 = this.f52609c;
                if (afVar6 != null) {
                    afVar6.a((CJRRechargeCart) iJRPaytmDataModel, obj);
                    if (this.f52609c.k()) {
                        this.f52609c.h();
                    }
                }
            } else if (iJRPaytmDataModel instanceof CJRCashWallet) {
                CJRCashWallet cJRCashWallet = (CJRCashWallet) iJRPaytmDataModel;
                if (cJRCashWallet == null) {
                    C0940a aVar = this.f52610d;
                    if (aVar != null) {
                        aVar.o();
                    }
                } else {
                    this.f52607a = cJRCashWallet;
                    if (this.m && (afVar2 = this.f52609c) != null) {
                        afVar2.a(cJRCashWallet);
                    } else if (!this.n || (afVar = this.f52609c) == null) {
                        b();
                    } else {
                        afVar.b(cJRCashWallet);
                    }
                }
            } else if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                this.f52610d.a((CJRPGTokenList) iJRPaytmDataModel);
            }
            if (iJRPaytmDataModel instanceof CJRRechargePayment) {
                this.f52615i = (CJRRechargePayment) iJRPaytmDataModel;
                if (this.f52615i.getStatus() == null || !this.f52615i.getStatus().equalsIgnoreCase("SUCCESS")) {
                    af afVar7 = this.f52609c;
                    if (afVar7 != null) {
                        afVar7.h();
                    }
                    CJRRechargePayment cJRRechargePayment = this.f52615i;
                    if (cJRRechargePayment == null || !(cJRRechargePayment.getCode() == 401 || this.f52615i.getCode() == 410 || this.f52615i.getCode() == 403)) {
                        CJRRechargePayment cJRRechargePayment2 = this.f52615i;
                        if (cJRRechargePayment2 == null || cJRRechargePayment2.getError() == null) {
                            az azVar2 = az.f61525a;
                            az.a(this.f52612f, ERROR_TYPE.UNDEFINED, ACTION_TYPE.CLP_PROCEED, this.f52612f.getResources().getString(R.string.error), this.f52612f.getResources().getString(R.string.msg_invalid_url));
                            return;
                        }
                        az azVar3 = az.f61525a;
                        az.a(this.f52612f, ERROR_TYPE.UNDEFINED, ACTION_TYPE.CLP_PROCEED, this.f52615i.getError().getTitle(), this.f52615i.getError().getMessage());
                        return;
                    }
                    NetworkCustomError networkCustomError = new NetworkCustomError();
                    c cVar = c.f62654a;
                    if (!TextUtils.isEmpty(c.a((JSONObject) null))) {
                        c cVar2 = c.f62654a;
                        networkCustomError.setUrl(c.a((JSONObject) null));
                        if (this.f52615i.getError() != null && !TextUtils.isEmpty(this.f52615i.getError().getMessage())) {
                            networkCustomError.setAlertMessage(this.f52615i.getError().getMessage());
                        }
                    }
                    CJRRechargeUtilities.INSTANCE.showSessionTimeoutAlert((Activity) this.f52612f, (String) null, (Bundle) null, networkCustomError);
                } else if (this.j) {
                    af afVar8 = this.f52609c;
                    if (afVar8 != null) {
                        afVar8.h();
                    }
                    com.paytm.utility.b.j();
                    if (this.f52615i.getOrderId() != null) {
                        String orderId = this.f52615i.getOrderId();
                        Intent intent = new Intent(this.f52612f, this.o.a(this.f52614h));
                        intent.putExtra(UpiConstants.FROM, "Payment");
                        intent.putExtra("order_id", orderId);
                        this.f52614h.getCart().setPaymentInstruments((o) null);
                        this.f52614h.getCart().setPaymentInfo((o) null);
                        intent.putExtra("recharge cart", this.f52614h);
                        intent.putExtra(com.business.merchant_payments.common.utility.AppConstants.IS_CANCEL, false);
                        intent.putExtra("recharge_ga_data_for_summary", (Serializable) this.f52608b);
                        this.f52612f.startActivity(intent);
                        net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a() {
                            public final Object invoke() {
                                return a.this.d();
                            }
                        });
                    }
                } else {
                    com.paytm.utility.b.j();
                    if (!ab.a(this.f52615i) || this.f52609c == null) {
                        a(this.f52615i);
                    } else {
                        ba.a(this.f52612f, this.f52615i, (FetchPayOptionsListener) this);
                    }
                }
            } else if (iJRPaytmDataModel instanceof BannerData) {
                BannerData bannerData = (BannerData) iJRPaytmDataModel;
                if (bannerData.bannerPage != null) {
                    q.d("BannerResponse" + bannerData.bannerPage.size());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x d() {
        c cVar = c.f62654a;
        String X = c.X();
        if (c() == null || c().size() <= 0) {
            return null;
        }
        c().get(0).getLastItemInCategoryMap();
        String verticalLabel = c().get(0).getVerticalLabel();
        String lastItemInCategoryMap = c().get(0).getLastItemInCategoryMap();
        if (verticalLabel != null) {
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            net.one97.paytm.recharge.di.helper.b.b(verticalLabel, this.f52612f, X, lastItemInCategoryMap);
            return null;
        }
        net.one97.paytm.recharge.di.helper.b bVar2 = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.b(SDKConstants.GA_KEY_DEFAULT, this.f52612f, X, lastItemInCategoryMap);
        return null;
    }

    private void a(CJRRechargePayment cJRRechargePayment) {
        net.one97.paytm.recharge.common.utils.a aVar = net.one97.paytm.recharge.common.utils.a.f61493a;
        Activity activity = this.f52613g;
        String str = this.s;
        CJRRechargeCart cJRRechargeCart = this.f52614h;
        Map<String, Object> map = this.f52608b;
        Class b2 = this.o.b(cJRRechargeCart);
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.common.utils.a.a(activity, str, cJRRechargeCart, cJRRechargePayment, map, b2, net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null), false);
        af afVar = this.f52609c;
        if (afVar != null) {
            afVar.h();
        }
    }

    private ArrayList<CJRCartProduct> c() {
        return this.f52614h.getCart().getCartItems();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void b(String str, CJRRechargeCart cJRRechargeCart, JSONObject jSONObject, List<CJRUtilityCheckboxItem> list, boolean z, String str2, String str3) {
        String str4;
        ArrayList<CJRCartProduct> cartItems;
        JSONObject jSONObject2 = jSONObject;
        int i2 = 0;
        this.j = false;
        JSONObject jSONObject3 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.CLP_PROCEED, ERROR_TYPE.UNDEFINED);
        if (cJRRechargeCart != null) {
            try {
                if (!(cJRRechargeCart.getCart() == null || cJRRechargeCart.getCart().getCartItems() == null || cJRRechargeCart.getCart().getCartItems().size() <= 0)) {
                    Iterator<CJRCartProduct> it2 = cJRRechargeCart.getCart().getCartItems().iterator();
                    while (it2.hasNext()) {
                        CJRCartProduct next = it2.next();
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put(CLPConstants.PRODUCT_ID, next.getProductId());
                        jSONObject4.put("qty", next.getQuantity());
                        Map<String, String> configurationList = next.getConfigurationList();
                        JSONObject jSONObject5 = new JSONObject();
                        if (configurationList != null) {
                            for (String next2 : configurationList.keySet()) {
                                if (next2 != null && next2.equalsIgnoreCase("recharge_number")) {
                                    this.r = configurationList.get(next2);
                                    if (!TextUtils.isEmpty(str2)) {
                                        this.q = URLEncoder.encode(str2, AppConstants.UTF_8);
                                        jSONObject5.put(next2, configurationList.get(next2).toString());
                                    }
                                }
                                String str5 = str2;
                                jSONObject5.put(next2, configurationList.get(next2).toString());
                            }
                        }
                        String str6 = str2;
                        jSONObject4.put(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject5);
                        if (jSONObject2 != null) {
                            CJRUtilityCheckboxItem a3 = a(list, Integer.valueOf(next.getProductId()).intValue());
                            JSONObject jSONObject6 = new JSONObject();
                            if (!(a3 == null || a3.getMetaData() == null || a3.getMetaData().keySet() == null || a3.getMetaData().keySet().size() <= 0)) {
                                for (String next3 : a3.getMetaData().keySet()) {
                                    if (a3.getMetaData().get(next3) != null) {
                                        jSONObject6.put(next3, a3.getMetaData().get(next3));
                                    }
                                }
                            }
                            if (jSONObject.names() != null) {
                                for (int i3 = 0; i3 < jSONObject.names().length(); i3++) {
                                    if (!(jSONObject.names().get(i3) == null || jSONObject2.get(jSONObject.names().get(i3).toString()) == null)) {
                                        jSONObject6.put(jSONObject.names().get(i3).toString(), jSONObject2.get(jSONObject.names().get(i3).toString()));
                                    }
                                }
                            }
                            jSONObject4.put("meta_data", jSONObject6);
                        } else {
                            List<CJRUtilityCheckboxItem> list2 = list;
                        }
                        jSONArray.put(jSONObject4);
                    }
                }
            } catch (Exception e2) {
                q.d(e2.getMessage());
            }
        }
        jSONObject3.put("cart_items", jSONArray);
        if (a2.getFlowName() != null) {
            net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
            a2.getFlowName().setRequestBody(net.one97.paytm.recharge.widgets.c.d.a(jSONObject3));
        }
        if (cJRRechargeCart != null && cJRRechargeCart.getCart() != null && "SUCCESS".equalsIgnoreCase(cJRRechargeCart.getCart().getPromoStatus()) && (cartItems = cJRRechargeCart.getCart().getCartItems()) != null && cartItems.size() > 0 && !TextUtils.isEmpty(cJRRechargeCart.getCart().getPaytmPromocode())) {
            jSONObject3.put(Utility.EVENT_CATEGORY_PROMOCODE, cartItems.get(0).getPromoCode());
        }
        if (!(cJRRechargeCart == null || cJRRechargeCart.getCart() == null || TextUtils.isEmpty(cJRRechargeCart.getCart().getPaymentMethod()))) {
            jSONObject3.put("payment_method", cJRRechargeCart.getCart().getPaymentMethod());
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("wallet_token", str);
        hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this.f52612f));
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("risk_extended_info", str3);
        }
        net.one97.paytm.f.b.a().c();
        c cVar = c.f62654a;
        String a4 = c.a(jSONObject3);
        if (URLUtil.isValidUrl(a4)) {
            String s2 = com.paytm.utility.b.s(this.f52612f, a4);
            String k2 = com.paytm.utility.b.k();
            if (Uri.parse(s2).getQuery() != null) {
                str4 = s2 + "&client_id=" + k2;
            } else {
                str4 = s2 + "?client_id=" + k2;
            }
            String str7 = str4;
            CJRCashWallet cJRCashWallet = this.f52607a;
            if (!(cJRCashWallet == null || cJRCashWallet.getResponse() == null)) {
                int amount = (int) this.f52607a.getResponse().getAmount();
                try {
                    i2 = (int) Float.parseFloat(cJRRechargeCart.getCart().getFinalPrice());
                } catch (Exception e3) {
                    q.d(e3.getMessage());
                }
                if (!z || i2 > amount) {
                    str7 = ab.b(str7);
                } else {
                    this.j = true;
                    str7 = str7 + "&withdraw=1";
                }
            }
            String d2 = com.paytm.utility.b.d(str7, "POST");
            StringBuilder sb = new StringBuilder();
            sb.append(d2);
            sb.append("json cart item ");
            sb.append(jSONObject3.toString());
            com.paytm.utility.b.j();
            if (com.paytm.utility.b.c(this.f52612f)) {
                this.f52612f.getApplicationContext();
                d.a();
                d.b(new net.one97.paytm.recharge.common.f.c("post_checkout", d2, (ai) new ai() {
                    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                        a.this.a_(str, iJRPaytmDataModel, obj);
                    }

                    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                        if (networkCustomError != null) {
                            if (a.this.f52609c != null) {
                                a.this.f52609c.h();
                            }
                            if (a.this.f52610d != null) {
                                a.this.f52610d.o();
                            }
                            CJRRechargeUtilities.INSTANCE.handleError(str, a.this.f52613g, (Fragment) null, networkCustomError, true, 3, obj);
                        }
                    }
                }, (IJRPaytmDataModel) new CJRRechargePayment(), (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject3.toString(), (Object) a2));
                return;
            }
            this.f52610d.a(d2, hashMap, jSONObject3.toString());
            af afVar = this.f52609c;
            if (afVar != null) {
                afVar.h();
                return;
            }
            return;
        }
        b((Object) a2);
        af afVar2 = this.f52609c;
        if (afVar2 != null) {
            afVar2.h();
        }
    }

    public final void a(CJRPGTokenList cJRPGTokenList, CJRRechargeCart cJRRechargeCart, JSONObject jSONObject, List<CJRUtilityCheckboxItem> list, boolean z) {
        String str;
        this.f52614h = cJRRechargeCart;
        String pgToken = CJRRechargeUtilities.INSTANCE.getPgToken(cJRPGTokenList);
        if (!TextUtils.isEmpty(pgToken)) {
            try {
                str = cJRRechargeCart.getCart().getCartItems().get(0).getConfigurationList().get("recharge_number");
            } catch (Exception unused) {
                str = null;
            }
            if (!com.paytm.utility.b.c(str) || this.f52612f == null) {
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                b(pgToken, cJRRechargeCart, jSONObject, list, z, (String) null, net.one97.paytm.recharge.widgets.c.d.a(this.f52612f, (String) null, (String) null));
                return;
            }
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable(str, pgToken, cJRRechargeCart, jSONObject, list, z) {
                private final /* synthetic */ String f$1;
                private final /* synthetic */ String f$2;
                private final /* synthetic */ CJRRechargeCart f$3;
                private final /* synthetic */ JSONObject f$4;
                private final /* synthetic */ List f$5;
                private final /* synthetic */ boolean f$6;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                    this.f$5 = r6;
                    this.f$6 = r7;
                }

                public final void run() {
                    a.this.a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6);
                }
            });
            return;
        }
        af afVar = this.f52609c;
        if (afVar != null) {
            afVar.h();
        }
        CJRRechargeUtilities.INSTANCE.showSessionTimeoutAlert(this.f52613g, (String) null, (Bundle) null, new NetworkCustomError());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, CJRRechargeCart cJRRechargeCart, JSONObject jSONObject, List list, boolean z) {
        String str3 = str;
        n nVar = n.f61679a;
        ContactItemModel a2 = n.a(str);
        String name = a2 != null ? a2.getName() : null;
        if (TextUtils.isEmpty(name)) {
            name = ab.a(this.f52612f, str);
        }
        String str4 = name;
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        new Handler(Looper.getMainLooper()).post(new Runnable(str2, cJRRechargeCart, jSONObject, list, z, str4, net.one97.paytm.recharge.widgets.c.d.a(this.f52612f, str4, str)) {
            private final /* synthetic */ String f$1;
            private final /* synthetic */ CJRRechargeCart f$2;
            private final /* synthetic */ JSONObject f$3;
            private final /* synthetic */ List f$4;
            private final /* synthetic */ boolean f$5;
            private final /* synthetic */ String f$6;
            private final /* synthetic */ String f$7;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
                this.f$6 = r7;
                this.f$7 = r8;
            }

            public final void run() {
                a.this.b(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7);
            }
        });
    }

    public final void b() {
        if (!TextUtils.isEmpty(ax.a(this.f52612f.getApplicationContext()).b("sso_token=", "", true))) {
            af afVar = this.f52609c;
            if (afVar != null) {
                afVar.g();
            }
            if (this.f52613g != null) {
                CJRRechargeUtilities.INSTANCE.getWalletToken(this);
                return;
            }
            return;
        }
        CJRRechargeUtilities.INSTANCE.showSessionTimeoutAlert(this.f52613g, (String) null, (Bundle) null, new NetworkCustomError());
        af afVar2 = this.f52609c;
        if (afVar2 != null) {
            afVar2.h();
        }
    }

    public final void a(String str, Map<String, String> map, ArrayList<String> arrayList, ArrayList<String> arrayList2, String str2, boolean z, JSONObject jSONObject, List<CJRUtilityCheckboxItem> list, boolean z2, List<CJRUtilityProductV2> list2, String str3, String str4, Object obj) {
        CRUFlowModel flowName;
        Map<String, String> map2 = map;
        ArrayList<String> arrayList3 = arrayList;
        ArrayList<String> arrayList4 = arrayList2;
        JSONObject jSONObject2 = jSONObject;
        List<CJRUtilityProductV2> list3 = list2;
        Object obj2 = obj;
        this.f52611e = z;
        JSONObject jSONObject3 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        int i2 = 1;
        if (map2 != null) {
            try {
                if (map.size() > 0) {
                    int i3 = 0;
                    while (i3 < map.size()) {
                        JSONObject jSONObject4 = new JSONObject();
                        String obj3 = map.keySet().toArray()[i3].toString();
                        CJRUtilityCheckboxItem a2 = a(list, Integer.valueOf(obj3).intValue());
                        jSONObject4.put(CLPConstants.PRODUCT_ID, obj3);
                        jSONObject4.put("qty", i2);
                        JSONObject jSONObject5 = new JSONObject();
                        if (!(arrayList3 == null || arrayList4 == null)) {
                            int i4 = 0;
                            while (i4 < arrayList.size()) {
                                if (!list3.get(0).getAttributes().isLengthyForm()) {
                                    jSONObject5.put(arrayList3.get(i4), arrayList4.get(i4));
                                } else if (arrayList3.get(i4).equalsIgnoreCase("recharge_number") || arrayList3.get(i4).equalsIgnoreCase("recharge_number_2") || arrayList3.get(i4).equalsIgnoreCase("category_id")) {
                                    jSONObject5.put(arrayList3.get(i4), arrayList4.get(i4));
                                }
                                i4++;
                                Object obj4 = obj;
                            }
                        }
                        jSONObject5.put("price", map2.get(obj3));
                        jSONObject5.put("totalamount", str3);
                        jSONObject5.put(ab.f61497b, this.f52609c.l());
                        jSONObject4.put(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject5);
                        if (jSONObject2 != null) {
                            JSONObject jSONObject6 = new JSONObject();
                            if (!(a2 == null || a2.getMetaData() == null || a2.getMetaData().keySet() == null || a2.getMetaData().keySet().size() <= 0)) {
                                for (String next : a2.getMetaData().keySet()) {
                                    jSONObject6.put(next, a2.getMetaData().get(next));
                                    Map<String, String> map3 = map;
                                }
                            }
                            for (int i5 = 0; i5 < jSONObject.names().length(); i5++) {
                                jSONObject6.put(jSONObject.names().get(i5).toString(), jSONObject2.get(jSONObject.names().get(i5).toString()));
                            }
                            if (list3 != null) {
                                for (CJRUtilityProductV2 next2 : list2) {
                                    if (!(next2 == null || !String.valueOf(next2.getId()).equalsIgnoreCase(obj3) || next2.getAttributes() == null)) {
                                        if (!TextUtils.isEmpty(next2.getAttributes().getLocationKey())) {
                                            jSONObject6.put("location_key", next2.getAttributes().getLocationKey());
                                        }
                                        if (!TextUtils.isEmpty(next2.getAttributes().getAdditionalInfo1())) {
                                            jSONObject6.put("additional_info_1", next2.getAttributes().getAdditionalInfo1());
                                        }
                                        if (!TextUtils.isEmpty(next2.getAttributes().getAdditionalInfo2())) {
                                            jSONObject6.put("additional_info_2", next2.getAttributes().getAdditionalInfo2());
                                        }
                                        if (!TextUtils.isEmpty(next2.getAttributes().getAdditionalInfo3())) {
                                            jSONObject6.put("additional_info_3", next2.getAttributes().getAdditionalInfo3());
                                        }
                                        if (!TextUtils.isEmpty(next2.getAttributes().getAdditionalInfo4())) {
                                            jSONObject6.put("additional_info_4", next2.getAttributes().getAdditionalInfo4());
                                        }
                                    }
                                }
                            }
                            jSONObject4.put("meta_data", jSONObject6);
                        }
                        jSONArray.put(jSONObject4);
                        i3++;
                        map2 = map;
                        Object obj5 = obj;
                        i2 = 1;
                    }
                    if (jSONArray.length() != 0) {
                        jSONObject3.put("cart_items", jSONArray);
                        jSONObject3.put("payment_method", str2);
                        Object obj6 = obj;
                        if ((obj6 instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj6).getFlowName()) != null) {
                            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                            flowName.setRequestBody(net.one97.paytm.recharge.widgets.c.d.a(jSONObject3));
                        }
                        af afVar = this.f52609c;
                        if (afVar != null) {
                            if (z2) {
                                afVar.d(this.f52612f.getString(R.string.automatic_verifying_your_bill_text));
                            } else {
                                afVar.i();
                            }
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("Content-Type", "application/json");
                        hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this.f52612f));
                        az azVar = az.f61525a;
                        String a3 = az.a(jSONObject3);
                        c cVar = c.f62654a;
                        String c2 = c.c(a3);
                        y yVar = y.f61814b;
                        y.a(jSONObject3);
                        if (URLUtil.isValidUrl(c2)) {
                            String a4 = ba.a(a3, com.paytm.utility.b.s(this.f52612f, c2));
                            StringBuilder sb = new StringBuilder("express cart ");
                            sb.append(a4);
                            sb.append(" json cart");
                            sb.append(jSONObject3.toString());
                            com.paytm.utility.b.j();
                            if (com.paytm.utility.b.c(this.f52612f)) {
                                d.a();
                                d.b(new net.one97.paytm.recharge.common.f.c(str, a4, this, new CJRRechargeCart(), hashMap, jSONObject3.toString(), a.c.RECHARGES, a.b.USER_FACING, str4, obj));
                                return;
                            }
                            aa aaVar = this.t;
                            boolean b2 = aaVar != null ? aaVar.b() : false;
                            af afVar2 = this.f52609c;
                            if (afVar2 != null) {
                                afVar2.h();
                            }
                            aa aaVar2 = this.t;
                            if (aaVar2 != null) {
                                aaVar2.a(new net.one97.paytm.recharge.common.f.c(str, a4, (ai) this, (IJRPaytmDataModel) new CJRRechargeCart(), (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject3.toString(), obj), this.f52612f, b2);
                            } else {
                                C0940a aVar = this.f52610d;
                                if (aVar != null) {
                                    aVar.a(a4, hashMap, jSONObject3.toString());
                                }
                            }
                            b bVar = this.p;
                            if (bVar != null) {
                                bVar.c(true);
                                return;
                            }
                            return;
                        }
                        af afVar3 = this.f52609c;
                        if (afVar3 != null) {
                            afVar3.h();
                        }
                        b(obj6);
                        return;
                    }
                    return;
                }
            } catch (Exception e2) {
                b bVar2 = this.p;
                if (bVar2 != null) {
                    bVar2.c(true);
                }
                af afVar4 = this.f52609c;
                if (afVar4 != null) {
                    afVar4.h();
                }
                q.d(e2.getMessage());
                AlertDialog.Builder builder = new AlertDialog.Builder(this.f52612f);
                builder.setTitle(this.f52612f.getResources().getString(R.string.network_error_heading_re)).setMessage(this.f52612f.getResources().getString(R.string.network_error_message_re));
                builder.setCancelable(false);
                builder.setPositiveButton(this.f52612f.getResources().getString(R.string.ok_re), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
                return;
            }
        }
        if (this.p != null) {
            this.p.c(true);
        }
        if (this.f52609c != null) {
            this.f52609c.h();
        }
        if (this.f52612f != null) {
            az azVar2 = az.f61525a;
            az.a(this.f52612f, ERROR_TYPE.UNDEFINED, ACTION_TYPE.CLP_PROCEED, this.f52612f.getString(R.string.operator_unavailable_tittle), this.f52612f.getString(R.string.product_not_available));
        }
    }

    private static String a(String str) {
        String substring = str.substring(str.length() - 4, str.length());
        String substring2 = "XXXXXXXXXXXXXXXXXXXX".substring(0, str.length() - 4);
        return substring2 + substring;
    }

    public final void a(String str, Map<String, Object> map, boolean z, boolean z2, Object obj) {
        this.m = z;
        this.n = z2;
        this.f52608b = map;
        c cVar = c.f62654a;
        String t2 = c.t();
        HashMap hashMap = new HashMap();
        hashMap.put("ssotoken", CJRRechargeUtilities.INSTANCE.getSSOToken(this.f52612f));
        if (!URLUtil.isValidUrl(t2)) {
            this.f52609c.h();
            b(obj);
        } else if (com.paytm.utility.b.c(this.f52612f)) {
            this.f52612f.getApplicationContext();
            d.a();
            d.b(new net.one97.paytm.recharge.common.f.c(str, t2, (ai) this, (IJRPaytmDataModel) new CJRCashWallet(), (Map<String, String>) null, (Map<String, String>) hashMap, (String) null, obj));
            this.f52609c.g();
        } else {
            C0940a aVar = this.f52610d;
            if (aVar != null) {
                aVar.o();
            }
            this.f52609c.h();
        }
    }

    private void b(Object obj) {
        ACTION_TYPE action_type = ACTION_TYPE.UNDEFINED;
        if (obj instanceof CJRRechargeErrorModel) {
            CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
            if (cJRRechargeErrorModel.getFlowName() != null) {
                action_type = ACTION_TYPE.Companion.getActionType(cJRRechargeErrorModel.getFlowName().getActionType(), action_type);
            }
        }
        az azVar = az.f61525a;
        az.a(this.f52612f, ERROR_TYPE.INVALID_URL, action_type, this.f52612f.getString(R.string.error), this.f52612f.getString(R.string.msg_invalid_url));
    }

    private static CJRUtilityCheckboxItem a(List<CJRUtilityCheckboxItem> list, int i2) {
        for (CJRUtilityCheckboxItem next : list) {
            if (next.getId() == ((long) i2)) {
                return next;
            }
        }
        return null;
    }

    public final void b(String str, String str2, Object obj) {
        c cVar = c.f62654a;
        String aP = c.aP();
        if (URLUtil.isValidUrl(aP)) {
            String str3 = aP + "?product_ids=" + str2;
            CJRCreditCardMID cJRCreditCardMID = new CJRCreditCardMID();
            cJRCreditCardMID.setProductId(str2);
            if (com.paytm.utility.b.c(this.f52612f)) {
                d.a();
                d.b(new net.one97.paytm.recharge.common.f.b(str, str3, this, cJRCreditCardMID, obj));
                return;
            }
            a(obj);
        }
    }

    public final void a(String str, String str2, String str3, Object obj) {
        c cVar = c.f62654a;
        String aQ = c.aQ();
        if (URLUtil.isValidUrl(aQ)) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("CARD_NUMBER", str3);
            hashMap2.put("CUST_ID", com.paytm.utility.b.n(this.f52612f));
            hashMap2.put("MID", str2);
            String a2 = a((HashMap<String, String>) hashMap2);
            if (com.paytm.utility.b.c(this.f52612f)) {
                d.a();
                d.b(new net.one97.paytm.recharge.common.f.c(str, aQ, (ai) this, (IJRPaytmDataModel) new CJRCreditCardToken(), (Map<String, String>) null, (Map<String, String>) hashMap, a2, obj));
                return;
            }
            a(obj);
        }
    }

    public void onPaymentOptionsError() {
        a(this.f52615i);
        this.f52609c.h();
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        if (a2.getFlowName() == null) {
            a2.setFlowName(new CRUFlowModel());
        }
        a2.getFlowName().setErrorType(ERROR_TYPE.UI_DESCRIPTION.name());
        a2.getFlowName().setActionType(ACTION_TYPE.CLP_PROCEED.name());
        CJRRechargeCart cJRRechargeCart = this.f52614h;
        if (!(cJRRechargeCart == null || cJRRechargeCart.getCart() == null || this.f52614h.getCart().getCartItems() == null || this.f52614h.getCart().getCartItems().isEmpty())) {
            a2.setProductId(this.f52614h.getCart().getCartItems().get(0).getProductId());
        }
        a2.getFlowName().setTag("fetchPaymentOptions");
        Context context = this.f52612f;
        if (context != null) {
            a2.setErrorMsg(context.getString(R.string.error_message, new Object[]{"onPaymentOptionsError", a.class.getSimpleName()}));
            az azVar = az.f61525a;
            az.a(a2);
        }
    }

    public void onRequestEnd(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch) {
        PaytmSDK.setResponse(cJPayMethodResponse, vpaFetch);
        a(this.f52615i);
        this.f52609c.h();
    }

    public final void a(String str, Map<String, String> map, ArrayList<String> arrayList, ArrayList<String> arrayList2, boolean z, String str2, String str3, String str4, String str5, Object obj) {
        CRUFlowModel flowName;
        String str6 = str5;
        Object obj2 = obj;
        this.f52611e = z;
        JSONObject jSONObject = new JSONObject();
        String substring = str3.substring(0, 6);
        String a2 = a(str3);
        String a3 = a(str4);
        String obj3 = map.keySet().toArray()[0].toString();
        try {
            if (map.size() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (arrayList.get(0) == "category_id") {
                        jSONObject2.put("category_id", arrayList2.get(i2));
                    } else {
                        ArrayList<String> arrayList3 = arrayList2;
                    }
                }
                jSONObject2.put("price", map.get(obj3));
                jSONObject2.put("recharge_number", a2);
                jSONObject2.put("recharge_number_2", a3);
                jSONObject2.put("token_id", str2);
                jSONObject2.put(ab.f61497b, this.f52609c.l());
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("bin_number", substring);
                if (str6 != null) {
                    jSONObject3.put("payment_request_type", str6);
                }
                jSONObject3.put("id", com.paytm.utility.b.n(this.f52612f));
                jSONObject3.put("customer_mobile", com.paytm.utility.b.l(this.f52612f));
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(CLPConstants.PRODUCT_ID, obj3);
                jSONObject4.put("qty", 1);
                jSONObject4.put(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject2);
                jSONObject4.put("meta_data", jSONObject3);
                if ((obj2 instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj2).getFlowName()) != null) {
                    flowName.setRequestBody(jSONObject2.toString());
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject4);
                jSONObject.put("cart_items", jSONArray);
                if (str6 != null) {
                    jSONObject.put("payment_request_type", str6);
                }
                if (!TextUtils.isEmpty((CharSequence) null)) {
                    jSONObject.put(Utility.EVENT_CATEGORY_PROMOCODE, (Object) null);
                }
                af afVar = this.f52609c;
                if (afVar != null) {
                    afVar.i();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this.f52612f));
                az azVar = az.f61525a;
                String a4 = az.a(jSONObject);
                c cVar = c.f62654a;
                String c2 = c.c(a4);
                y yVar = y.f61814b;
                y.a(jSONObject);
                if (URLUtil.isValidUrl(c2)) {
                    String a5 = ba.a(a4, com.paytm.utility.b.s(this.f52612f, c2));
                    StringBuilder sb = new StringBuilder("express cart ");
                    sb.append(a5);
                    sb.append(" json cart");
                    sb.append(jSONObject.toString());
                    com.paytm.utility.b.j();
                    if (com.paytm.utility.b.c(this.f52612f)) {
                        net.one97.paytm.recharge.common.f.c cVar2 = new net.one97.paytm.recharge.common.f.c(str, a5, this, new CJRRechargeCart(), hashMap, jSONObject.toString(), a.c.RECHARGES, a.b.USER_FACING, "Credit card", obj);
                        cVar2.a(ba.f61539a);
                        d.a();
                        d.b(cVar2);
                        return;
                    }
                    af afVar2 = this.f52609c;
                    if (afVar2 != null) {
                        afVar2.h();
                    }
                    C0940a aVar = this.f52610d;
                    if (aVar != null) {
                        aVar.a(a5, hashMap, jSONObject.toString());
                        return;
                    }
                    return;
                }
                af afVar3 = this.f52609c;
                if (afVar3 != null) {
                    afVar3.h();
                }
                b(obj2);
                return;
            }
            if (this.f52609c != null) {
                this.f52609c.h();
            }
            if (this.f52612f != null) {
                az azVar2 = az.f61525a;
                az.a(this.f52612f, ERROR_TYPE.UNDEFINED, ACTION_TYPE.CLP_PROCEED, this.f52612f.getString(R.string.operator_unavailable_tittle), this.f52612f.getString(R.string.product_not_available));
            }
        } catch (Exception e2) {
            af afVar4 = this.f52609c;
            if (afVar4 != null) {
                afVar4.h();
            }
            q.d(e2.getMessage());
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f52612f);
            builder.setTitle(this.f52612f.getResources().getString(R.string.network_error_heading_re)).setMessage(this.f52612f.getResources().getString(R.string.network_error_message_re));
            builder.setCancelable(false);
            builder.setPositiveButton(this.f52612f.getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        }
    }
}
