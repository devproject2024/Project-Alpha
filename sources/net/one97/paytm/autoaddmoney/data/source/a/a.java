package net.one97.paytm.autoaddmoney.data.source.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5Param;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.addmoney.common.a;
import net.one97.paytm.addmoney.common.binRequest.CJRBinRequest;
import net.one97.paytm.addmoney.common.binRequest.CJRBinRequestBody;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyPPBL;
import net.one97.paytm.addmoney.common.model.CJRSubscribeAutoAdd;
import net.one97.paytm.addmoney.common.model.Head;
import net.one97.paytm.addmoney.common.model.PaymentDestinationType;
import net.one97.paytm.addmoney.common.paymethodresponse.HasLowSuccess;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.autoaddmoney.data.source.a;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.auth.KYCFetchTnc;
import net.one97.paytm.common.entity.auth.KYCTncAccept;
import net.one97.paytm.common.entity.auth.TncData;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.autoSubscription.AddDebitOrCreditCard;
import net.one97.paytm.wallet.newdesign.addmoney.model.BinDetail;
import net.one97.paytm.wallet.newdesign.addmoney.model.CJRBinResponse;
import net.one97.paytm.wallet.newdesign.addmoney.model.CJRBinResponseBody;
import net.one97.paytm.wallet.newdesign.addmoney.model.CJRSubscribeDisableAutoAdd;
import net.one97.paytm.wallet.newdesign.addmoney.model.CJRSubscribeFetchStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements net.one97.paytm.autoaddmoney.data.source.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f49217a = new a();

    private a() {
    }

    public static void a(ArrayList<IJRDataModel> arrayList, a.h hVar) {
        kotlin.g.b.k.c(arrayList, "mSavedCardList");
        kotlin.g.b.k.c(hVar, H5Event.TYPE_CALL_BACK);
        Map hashMap = new HashMap();
        String a2 = com.paytm.utility.d.a(net.one97.paytm.helper.a.f50546a.a().j());
        kotlin.g.b.k.a((Object) a2, "CJRNetUtility.getSSOToke….getApplicationContext())");
        hashMap.put("session_token", a2);
        hashMap.put("token_type", AppConstants.USER);
        hashMap.put("Content-Type", "application/json");
        hashMap.put(UpiConstants.CACHE_CONTROL, "no-cache");
        String f2 = net.one97.paytm.helper.a.f50546a.a().f("ppbl_merchantId");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(SDKConstants.KEY_MERCHANT_ID, f2);
        a.C0848a aVar = net.one97.paytm.addmoney.common.a.f48418a;
        com.paytm.network.a l2 = a.C0848a.a().a((IJRPaytmDataModel) new CJRAvailableInstrumentsAddMoneyPPBL()).a((Map<String, String>) hashMap).b((Map) hashMap2).a((com.paytm.network.listener.b) new c(hVar, arrayList)).a(net.one97.paytm.helper.a.f50546a.a().f("fetch_subscription_cards") + com.paytm.utility.b.n(net.one97.paytm.helper.a.f50546a.a().j()) + "/PPBL").l();
        if (com.paytm.utility.b.c(net.one97.paytm.helper.a.f50546a.a().j())) {
            l2.a();
            return;
        }
        kotlin.g.b.k.a((Object) l2, "cjrCommonNetworkCall");
        hVar.a(l2);
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.h f49220a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f49221b;

        c(a.h hVar, ArrayList arrayList) {
            this.f49220a = hVar;
            this.f49221b = arrayList;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (networkCustomError == null || networkCustomError.networkResponse == null || !(networkCustomError.networkResponse.statusCode == 403 || networkCustomError.networkResponse.statusCode == 401 || networkCustomError.networkResponse.statusCode == 410)) {
                this.f49220a.a(this.f49221b);
            } else {
                this.f49220a.b(networkCustomError);
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CJRAvailableInstrumentsAddMoneyPPBL) {
                CJRAvailableInstrumentsAddMoneyPPBL cJRAvailableInstrumentsAddMoneyPPBL = (CJRAvailableInstrumentsAddMoneyPPBL) iJRPaytmDataModel;
                if (cJRAvailableInstrumentsAddMoneyPPBL.getData() != null && cJRAvailableInstrumentsAddMoneyPPBL.getData().size() > 0) {
                    int size = cJRAvailableInstrumentsAddMoneyPPBL.getData().size();
                    for (int i2 = 0; i2 < size; i2++) {
                        this.f49221b.add(cJRAvailableInstrumentsAddMoneyPPBL.getData().get(i2));
                    }
                }
            }
            this.f49220a.a(this.f49221b);
        }
    }

    public final void a(a.f fVar) {
        kotlin.g.b.k.c(fVar, "listener");
        String f2 = net.one97.paytm.helper.a.f50546a.a().f("userSubsctionKYCUrl");
        if (URLUtil.isValidUrl(f2)) {
            String e2 = com.paytm.utility.b.e(net.one97.paytm.helper.a.f50546a.a().j(), f2);
            Map<String, String> a2 = AddMoneyUtils.a(net.one97.paytm.helper.a.f50546a.a().j());
            a.C0848a aVar = net.one97.paytm.addmoney.common.a.f48418a;
            com.paytm.network.a l2 = a.C0848a.a().a(net.one97.paytm.helper.a.f50546a.a().j()).a((IJRPaytmDataModel) new KYCFetchTnc()).a(a2).a((com.paytm.network.listener.b) new d(fVar)).a(e2).l();
            if (com.paytm.utility.b.c(net.one97.paytm.helper.a.f50546a.a().j())) {
                l2.a();
                return;
            }
            kotlin.g.b.k.a((Object) l2, "cjrCommonNetworkCall");
            fVar.a(l2);
            return;
        }
        fVar.a();
    }

    public static final class d implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.f f49222a;

        d(a.f fVar) {
            this.f49222a = fVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (networkCustomError != null && networkCustomError.networkResponse != null) {
                if (networkCustomError.networkResponse.statusCode == 403 || networkCustomError.networkResponse.statusCode == 401 || networkCustomError.networkResponse.statusCode == 410) {
                    this.f49222a.b(networkCustomError);
                }
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null) {
                KYCFetchTnc kYCFetchTnc = (KYCFetchTnc) iJRPaytmDataModel;
                if (kYCFetchTnc.getStatus() == null || !p.a(kYCFetchTnc.getStatus(), "error", true)) {
                    if (kYCFetchTnc.getStatus() != null && p.a(kYCFetchTnc.getStatus(), "success", true) && kYCFetchTnc.getTncDataList() != null) {
                        ArrayList<TncData> tncDataList = kYCFetchTnc.getTncDataList();
                        a.f fVar = this.f49222a;
                        kotlin.g.b.k.a((Object) tncDataList, "mTncDataList");
                        fVar.a(tncDataList);
                    }
                } else if (!TextUtils.isEmpty(kYCFetchTnc.getMessage())) {
                    a.f fVar2 = this.f49222a;
                    String message = kYCFetchTnc.getMessage();
                    kotlin.g.b.k.a((Object) message, "kycFetchTnc.message");
                    fVar2.a(message);
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.auth.KYCFetchTnc");
            }
        }
    }

    public static final class h implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.h f49227a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f49228b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f49229c;

        h(a.h hVar, boolean z, ArrayList arrayList) {
            this.f49227a = hVar;
            this.f49228b = z;
            this.f49229c = arrayList;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (networkCustomError == null || networkCustomError.networkResponse == null || !(networkCustomError.networkResponse.statusCode == 403 || networkCustomError.networkResponse.statusCode == 401 || networkCustomError.networkResponse.statusCode == 410)) {
                a aVar = a.f49217a;
                a.a(this.f49228b, new ArrayList(), this.f49227a);
                return;
            }
            this.f49227a.b(networkCustomError);
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CJRAvailableInstrumentsAddMoney) {
                CJRAvailableInstrumentsAddMoney cJRAvailableInstrumentsAddMoney = (CJRAvailableInstrumentsAddMoney) iJRPaytmDataModel;
                if (cJRAvailableInstrumentsAddMoney.getData() != null && cJRAvailableInstrumentsAddMoney.getData().size() > 0) {
                    this.f49229c.clear();
                    int size = cJRAvailableInstrumentsAddMoney.getData().size();
                    for (int i2 = 0; i2 < size; i2++) {
                        this.f49229c.add(cJRAvailableInstrumentsAddMoney.getData().get(i2));
                    }
                }
                if (net.one97.paytm.helper.a.f50546a.a().g("isCreditCardEnabledForSubscription") || this.f49228b) {
                    a aVar = a.f49217a;
                    a.a(this.f49228b, this.f49229c, this.f49227a);
                    return;
                }
                a aVar2 = a.f49217a;
                a.a((ArrayList<IJRDataModel>) this.f49229c, this.f49227a);
            }
        }
    }

    public static final class f implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.h f49224a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f49225b;

        f(a.h hVar, ArrayList arrayList) {
            this.f49224a = hVar;
            this.f49225b = arrayList;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (networkCustomError == null || networkCustomError.networkResponse == null || !(networkCustomError.networkResponse.statusCode == 403 || networkCustomError.networkResponse.statusCode == 401 || networkCustomError.networkResponse.statusCode == 410)) {
                a aVar = a.f49217a;
                a.a((ArrayList<IJRDataModel>) this.f49225b, this.f49224a);
                return;
            }
            this.f49224a.b(networkCustomError);
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRAvailableInstrumentsAddMoneyCreditCard)) {
                CJRAvailableInstrumentsAddMoneyCreditCard cJRAvailableInstrumentsAddMoneyCreditCard = (CJRAvailableInstrumentsAddMoneyCreditCard) iJRPaytmDataModel;
                if (cJRAvailableInstrumentsAddMoneyCreditCard.getData() != null && cJRAvailableInstrumentsAddMoneyCreditCard.getData().size() > 0) {
                    int size = cJRAvailableInstrumentsAddMoneyCreditCard.getData().size();
                    for (int i2 = 0; i2 < size; i2++) {
                        this.f49225b.add(cJRAvailableInstrumentsAddMoneyCreditCard.getData().get(i2));
                    }
                }
                a aVar = a.f49217a;
                a.a((ArrayList<IJRDataModel>) this.f49225b, this.f49224a);
            }
        }
    }

    public final void a(ArrayList<TncData> arrayList, a.g gVar) {
        kotlin.g.b.k.c(arrayList, "mTncDataList");
        kotlin.g.b.k.c(gVar, "saveTncListener");
        Context j2 = net.one97.paytm.helper.a.f50546a.a().j();
        x.e eVar = new x.e();
        eVar.element = net.one97.paytm.helper.a.f50546a.a().f("kyc_tnc_user_url");
        if (!URLUtil.isValidUrl((String) eVar.element)) {
            gVar.a();
            return;
        }
        eVar.element = com.paytm.utility.b.e(net.one97.paytm.helper.a.f50546a.a().j(), (String) eVar.element);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mode", "clickthrough");
            jSONObject.put("deviceId", com.paytm.utility.b.A(j2));
            JSONArray jSONArray = new JSONArray();
            Iterator<TncData> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                TncData next = it2.next();
                if (next != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", next.getCode());
                    jSONObject2.put("version", next.getVersion());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("tnCList", jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        String jSONObject3 = jSONObject.toString();
        kotlin.g.b.k.a((Object) jSONObject3, "requestBody.toString()");
        Map<String, String> a2 = AddMoneyUtils.a(j2);
        a.C0848a aVar = net.one97.paytm.addmoney.common.a.f48418a;
        com.paytm.network.a l2 = a.C0848a.c().a((IJRPaytmDataModel) new KYCTncAccept()).a(a2).b(jSONObject3).c(getClass().getCanonicalName()).a((com.paytm.network.listener.b) new k(eVar, gVar)).a((String) eVar.element).l();
        if (com.paytm.utility.b.c(j2)) {
            l2.a();
            return;
        }
        kotlin.g.b.k.a((Object) l2, "cjrCommonNetworkCall");
        gVar.a(l2);
    }

    public static final class k implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f49235a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.g f49236b;

        k(x.e eVar, a.g gVar) {
            this.f49235a = eVar;
            this.f49236b = gVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (!TextUtils.isEmpty((String) this.f49235a.element)) {
                String str = (String) this.f49235a.element;
                kotlin.g.b.k.a((Object) str, "urlSaveTnc");
                CharSequence charSequence = str;
                if (networkCustomError == null) {
                    kotlin.g.b.k.a();
                }
                String url = networkCustomError.getUrl();
                kotlin.g.b.k.a((Object) url, "p2!!.getUrl()");
                if (p.a(charSequence, (CharSequence) url, false)) {
                    this.f49236b.a("");
                }
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null) {
                KYCTncAccept kYCTncAccept = (KYCTncAccept) iJRPaytmDataModel;
                if (kYCTncAccept.getStatus() == null || !p.a(kYCTncAccept.getStatus(), "error", true)) {
                    if (kYCTncAccept.getStatus() != null && p.a(kYCTncAccept.getStatus(), "success", true) && kotlin.g.b.k.a((Object) kYCTncAccept.getResponseCode(), (Object) "2004")) {
                        this.f49236b.b();
                    }
                } else if (!TextUtils.isEmpty(kYCTncAccept.getMessage())) {
                    a.g gVar = this.f49236b;
                    String message = kYCTncAccept.getMessage();
                    kotlin.g.b.k.a((Object) message, "kycTncAccept.message");
                    gVar.a(message);
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.auth.KYCTncAccept");
            }
        }
    }

    public static final class i implements net.one97.paytm.addmoney.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.j f49230a;

        i(a.j jVar) {
            this.f49230a = jVar;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRRechargePayment)) {
                this.f49230a.a((CJRRechargePayment) iJRPaytmDataModel);
            }
        }

        public final void b(NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(networkCustomError, "error");
            if (networkCustomError.networkResponse == null || !(networkCustomError.networkResponse.statusCode == 403 || networkCustomError.networkResponse.statusCode == 401 || networkCustomError.networkResponse.statusCode == 410)) {
                this.f49230a.a(networkCustomError);
            } else {
                this.f49230a.b(networkCustomError);
            }
        }
    }

    public final void a(String str, a.j jVar) {
        kotlin.g.b.k.c(jVar, "walletSSOTokenListener");
        Context j2 = net.one97.paytm.helper.a.f50546a.a().j();
        if (str == null) {
            kotlin.g.b.k.a();
        }
        new net.one97.paytm.addmoney.utils.a(j2).a(new j(j2, new i(jVar), str));
    }

    public static final class j implements net.one97.paytm.addmoney.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f49231a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.addmoney.h f49232b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f49233c;

        j(Context context, net.one97.paytm.addmoney.h hVar, String str) {
            this.f49231a = context;
            this.f49232b = hVar;
            this.f49233c = str;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRPGTokenList)) {
                String a2 = net.one97.paytm.helper.a.f50546a.a().a((CJRPGTokenList) iJRPaytmDataModel);
                if (!TextUtils.isEmpty(a2)) {
                    new net.one97.paytm.addmoney.utils.a(this.f49231a).a(new C0874a(this), a2, "1", PaymentDestinationType.TO_WALLET.getNumVal(), this.f49233c);
                }
            }
        }

        /* renamed from: net.one97.paytm.autoaddmoney.data.source.a.a$j$a  reason: collision with other inner class name */
        public static final class C0874a implements net.one97.paytm.addmoney.h {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ j f49234a;

            C0874a(j jVar) {
                this.f49234a = jVar;
            }

            public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                kotlin.g.b.k.c(iJRPaytmDataModel, Payload.RESPONSE);
                this.f49234a.f49232b.a(iJRPaytmDataModel);
            }

            public final void b(NetworkCustomError networkCustomError) {
                kotlin.g.b.k.c(networkCustomError, "error");
                this.f49234a.f49232b.b(networkCustomError);
            }
        }

        public final void b(NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(networkCustomError, "error");
            this.f49232b.b(networkCustomError);
        }
    }

    public final void a(String str, a.e eVar) {
        kotlin.g.b.k.c(str, "cardString");
        kotlin.g.b.k.c(eVar, H5Event.TYPE_CALL_BACK);
        Context j2 = net.one97.paytm.helper.a.f50546a.a().j();
        HashMap hashMap = new HashMap();
        CJRBinRequest cJRBinRequest = new CJRBinRequest();
        Head head = new Head(SDKConstants.SSO, com.paytm.utility.d.a(j2), "M", "roboso21355757629213", "1", "V1");
        head.setRequestTimeStamp("1");
        CJRBinRequestBody cJRBinRequestBody = new CJRBinRequestBody();
        cJRBinRequestBody.setBin(str);
        cJRBinRequestBody.setIndutryTypeId(SDKConstants.KEY_RETAIL);
        cJRBinRequestBody.setDeviceId(com.paytm.utility.b.A(j2));
        cJRBinRequestBody.setChannelId("WEB");
        cJRBinRequestBody.setSignature("1");
        cJRBinRequestBody.setRequestType("OFFLINE");
        cJRBinRequestBody.setOrderId("123456");
        cJRBinRequest.setBody(cJRBinRequestBody);
        cJRBinRequest.setHead(head);
        String a2 = AddMoneyUtils.a((Object) cJRBinRequest);
        Map map = hashMap;
        map.put("Content-Type", "application/json");
        String f2 = net.one97.paytm.helper.a.f50546a.a().f("offline_pg_fetch_bin_URL");
        a.C0848a aVar = net.one97.paytm.addmoney.common.a.f48418a;
        a.C0848a.b().a((Map<String, String>) map).a(f2).b(a2).a((IJRPaytmDataModel) new CJRBinResponse()).a((com.paytm.network.listener.b) new e(eVar)).l().a();
    }

    public static final class e implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.e f49223a;

        e(a.e eVar) {
            this.f49223a = eVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, Payload.RESPONSE);
            if (iJRPaytmDataModel instanceof CJRBinResponse) {
                CJRBinResponse cJRBinResponse = (CJRBinResponse) iJRPaytmDataModel;
                if (cJRBinResponse.getBody() != null) {
                    CJRBinResponseBody body = cJRBinResponse.getBody();
                    kotlin.g.b.k.a((Object) body, "response.body");
                    if (body.getBinDetail() != null) {
                        CJRBinResponseBody body2 = cJRBinResponse.getBody();
                        kotlin.g.b.k.a((Object) body2, "response.body");
                        BinDetail binDetail = body2.getBinDetail();
                        kotlin.g.b.k.a((Object) binDetail, "response.body.binDetail");
                        HasLowSuccess hasLowSuccess = binDetail.getHasLowSuccess();
                        CJRBinResponseBody body3 = cJRBinResponse.getBody();
                        kotlin.g.b.k.a((Object) body3, "response.body");
                        BinDetail binDetail2 = body3.getBinDetail();
                        kotlin.g.b.k.a((Object) binDetail2, "response.body.binDetail");
                        String channelName = binDetail2.getChannelName();
                        kotlin.g.b.k.a((Object) channelName, "response.body.binDetail.channelName");
                        if (channelName != null) {
                            String lowerCase = channelName.toLowerCase();
                            kotlin.g.b.k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                            CJRBinResponseBody body4 = cJRBinResponse.getBody();
                            kotlin.g.b.k.a((Object) body4, "response.body");
                            BinDetail binDetail3 = body4.getBinDetail();
                            kotlin.g.b.k.a((Object) binDetail3, "response.body.binDetail");
                            this.f49223a.a(hasLowSuccess, binDetail3.getPaymentMode(), lowerCase);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                }
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            AddDebitOrCreditCard.class.getSimpleName();
            q.d(networkCustomError.getMessage());
        }
    }

    public final void a(String str, a.i iVar) {
        kotlin.g.b.k.c(iVar, H5Event.TYPE_CALL_BACK);
        Context j2 = net.one97.paytm.helper.a.f50546a.a().j();
        StringBuilder sb = new StringBuilder();
        String f2 = net.one97.paytm.helper.a.f50546a.a().f("orderdetail");
        if (f2 == null) {
            kotlin.g.b.k.a();
        }
        sb.append(f2);
        sb.append(str);
        String sb2 = sb.toString();
        net.one97.paytm.wallet.utility.f fVar = net.one97.paytm.wallet.utility.f.f72321a;
        String a2 = net.one97.paytm.wallet.utility.f.a(com.paytm.utility.b.b(j2, sb2) + "&actions=1");
        if (a2 == null) {
            a2 = "";
        }
        net.one97.paytm.wallet.utility.f fVar2 = net.one97.paytm.wallet.utility.f.f72321a;
        String b2 = net.one97.paytm.wallet.utility.f.b(a2);
        if (b2 == null) {
            b2 = "";
        }
        a.C0848a aVar = net.one97.paytm.addmoney.common.a.f48418a;
        com.paytm.network.a l2 = a.C0848a.a().a(b2).a((IJRPaytmDataModel) new CJROrderSummary()).c("AutoSubscriptionUtil").a((com.paytm.network.listener.b) new m(iVar)).l();
        if (com.paytm.utility.b.c(j2)) {
            l2.a();
            return;
        }
        kotlin.g.b.k.a((Object) l2, "commonNetworkCall");
        iVar.a(l2);
    }

    public static final class m implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.i f49238a;

        m(a.i iVar) {
            this.f49238a = iVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, Payload.RESPONSE);
            if (iJRPaytmDataModel instanceof CJROrderSummary) {
                this.f49238a.a((CJROrderSummary) iJRPaytmDataModel);
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            a.i iVar = this.f49238a;
            String alertMessage = networkCustomError != null ? networkCustomError.getAlertMessage() : null;
            if (alertMessage == null) {
                kotlin.g.b.k.a();
            }
            iVar.a(alertMessage);
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x005e */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x007b A[SYNTHETIC, Splitter:B:15:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x008c A[Catch:{ JSONException -> 0x00fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00be A[Catch:{ JSONException -> 0x00fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0145  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.common.entity.IJRDataModel r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, net.one97.paytm.autoaddmoney.data.source.a.C0872a r21) {
        /*
            r16 = this;
            r0 = r17
            r1 = r20
            r2 = r21
            java.lang.String r3 = "requestType"
            kotlin.g.b.k.c(r1, r3)
            java.lang.String r4 = "callback"
            kotlin.g.b.k.c(r2, r4)
            net.one97.paytm.helper.a$a r4 = net.one97.paytm.helper.a.f50546a
            net.one97.paytm.helper.c r4 = r4.a()
            android.content.Context r4 = r4.j()
            net.one97.paytm.helper.a$a r5 = net.one97.paytm.helper.a.f50546a
            net.one97.paytm.helper.c r5 = r5.a()
            java.lang.String r6 = "create_subscription_url"
            java.lang.String r5 = r5.f((java.lang.String) r6)
            boolean r6 = android.webkit.URLUtil.isValidUrl(r5)
            if (r6 != 0) goto L_0x0030
            r21.a()
            return
        L_0x0030:
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.util.Map r6 = (java.util.Map) r6
            java.lang.String r7 = com.paytm.utility.d.a(r4)
            java.lang.String r8 = "CJRNetUtility.getSSOToken(appContext)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            java.lang.String r8 = "ssoToken"
            r6.put(r8, r7)
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            java.lang.String r8 = "Content-Type"
            java.lang.String r9 = "application/json"
            r6.put(r8, r9)
            r8 = 0
            double r10 = java.lang.Double.parseDouble(r18)     // Catch:{ Exception -> 0x005d }
            double r8 = java.lang.Double.parseDouble(r19)     // Catch:{ Exception -> 0x005e }
            goto L_0x005e
        L_0x005d:
            r10 = r8
        L_0x005e:
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00fe }
            r12.<init>()     // Catch:{ JSONException -> 0x00fe }
            java.lang.String r13 = "currencyCode"
            java.lang.String r14 = "INR"
            r12.put(r13, r14)     // Catch:{ JSONException -> 0x00fe }
            java.lang.String r13 = "minBalance"
            r12.put(r13, r10)     // Catch:{ JSONException -> 0x00fe }
            java.lang.String r10 = ""
            boolean r11 = r0 instanceof net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard.Card     // Catch:{ JSONException -> 0x00fe }
            java.lang.String r13 = "card.cardType"
            java.lang.String r14 = "cardId"
            java.lang.String r15 = "PPBL"
            if (r11 == 0) goto L_0x008c
            net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard$Card r0 = (net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard.Card) r0     // Catch:{ JSONException -> 0x00fe }
            java.lang.String r10 = r0.getSavedCardId()     // Catch:{ JSONException -> 0x00fe }
            r12.put(r14, r10)     // Catch:{ JSONException -> 0x00fe }
            java.lang.String r10 = r0.getCardType()     // Catch:{ JSONException -> 0x00fe }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r13)     // Catch:{ JSONException -> 0x00fe }
            goto L_0x00a9
        L_0x008c:
            boolean r11 = r0 instanceof net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney.Card     // Catch:{ JSONException -> 0x00fe }
            if (r11 == 0) goto L_0x00a1
            net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney$Card r0 = (net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney.Card) r0     // Catch:{ JSONException -> 0x00fe }
            java.lang.String r10 = r0.getSavedCardId()     // Catch:{ JSONException -> 0x00fe }
            r12.put(r14, r10)     // Catch:{ JSONException -> 0x00fe }
            java.lang.String r10 = r0.getCardType()     // Catch:{ JSONException -> 0x00fe }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r13)     // Catch:{ JSONException -> 0x00fe }
            goto L_0x00a9
        L_0x00a1:
            boolean r0 = r0 instanceof net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyPPBL.Card     // Catch:{ JSONException -> 0x00fe }
            if (r0 == 0) goto L_0x00a9
            r12.put(r14, r15)     // Catch:{ JSONException -> 0x00fe }
            r10 = r15
        L_0x00a9:
            r12.put(r3, r1)     // Catch:{ JSONException -> 0x00fe }
            java.lang.String r0 = "DEBIT_CARD"
            r1 = 1
            boolean r0 = kotlin.m.p.a((java.lang.String) r10, (java.lang.String) r0, (boolean) r1)     // Catch:{ JSONException -> 0x00fe }
            java.lang.String r3 = "subsPaymentMode"
            if (r0 == 0) goto L_0x00be
            java.lang.String r0 = "DC"
            r12.put(r3, r0)     // Catch:{ JSONException -> 0x00fe }
            goto L_0x00d5
        L_0x00be:
            java.lang.String r0 = "CREDIT_CARD"
            boolean r0 = kotlin.m.p.a((java.lang.String) r10, (java.lang.String) r0, (boolean) r1)     // Catch:{ JSONException -> 0x00fe }
            if (r0 == 0) goto L_0x00cc
            java.lang.String r0 = "CC"
            r12.put(r3, r0)     // Catch:{ JSONException -> 0x00fe }
            goto L_0x00d5
        L_0x00cc:
            boolean r0 = kotlin.m.p.a((java.lang.String) r10, (java.lang.String) r15, (boolean) r1)     // Catch:{ JSONException -> 0x00fe }
            if (r0 == 0) goto L_0x00d5
            r12.put(r3, r15)     // Catch:{ JSONException -> 0x00fe }
        L_0x00d5:
            java.lang.String r0 = "topUpAmount"
            r12.put(r0, r8)     // Catch:{ JSONException -> 0x00fe }
            java.lang.String r0 = "request"
            r7.put(r0, r12)     // Catch:{ JSONException -> 0x00fe }
            java.lang.String r0 = "operationType"
            java.lang.String r1 = "CREATE_EDIT_SUBSCRIPTION"
            r7.put(r0, r1)     // Catch:{ JSONException -> 0x00fe }
            java.lang.String r0 = "ipAddress"
            java.lang.String r1 = "127.0.0.1"
            r7.put(r0, r1)     // Catch:{ JSONException -> 0x00fe }
            java.lang.String r0 = "platformName"
            java.lang.String r1 = "PayTM"
            r7.put(r0, r1)     // Catch:{ JSONException -> 0x00fe }
            java.lang.String r0 = "version"
            java.lang.String r1 = "1.0"
            r7.put(r0, r1)     // Catch:{ JSONException -> 0x00fe }
            goto L_0x0102
        L_0x00fe:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0102:
            java.lang.String r0 = r7.toString()
            java.lang.String r1 = "requestBody.toString()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.addmoney.common.a$a r1 = net.one97.paytm.addmoney.common.a.f48418a
            com.paytm.network.b r1 = net.one97.paytm.addmoney.common.a.C0848a.b()
            com.paytm.network.b r1 = r1.a((android.content.Context) r4)
            net.one97.paytm.addmoney.common.model.CJRSubscribeAutoAdd r3 = new net.one97.paytm.addmoney.common.model.CJRSubscribeAutoAdd
            r3.<init>()
            com.paytm.network.model.IJRPaytmDataModel r3 = (com.paytm.network.model.IJRPaytmDataModel) r3
            com.paytm.network.b r1 = r1.a((com.paytm.network.model.IJRPaytmDataModel) r3)
            com.paytm.network.b r1 = r1.a((java.util.Map<java.lang.String, java.lang.String>) r6)
            com.paytm.network.b r0 = r1.b((java.lang.String) r0)
            net.one97.paytm.autoaddmoney.data.source.a.a$a r1 = new net.one97.paytm.autoaddmoney.data.source.a.a$a
            r1.<init>(r2)
            com.paytm.network.listener.b r1 = (com.paytm.network.listener.b) r1
            com.paytm.network.b r0 = r0.a((com.paytm.network.listener.b) r1)
            com.paytm.network.b r0 = r0.a((java.lang.String) r5)
            com.paytm.network.a r0 = r0.l()
            boolean r1 = com.paytm.utility.b.c((android.content.Context) r4)
            if (r1 == 0) goto L_0x0145
            r0.a()
            return
        L_0x0145:
            java.lang.String r1 = "cjrCommonNetworkCall"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r2.a((com.paytm.network.a) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.autoaddmoney.data.source.a.a.a(net.one97.paytm.common.entity.IJRDataModel, java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.autoaddmoney.data.source.a$a):void");
    }

    /* renamed from: net.one97.paytm.autoaddmoney.data.source.a.a$a  reason: collision with other inner class name */
    public static final class C0873a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.C0872a f49218a;

        C0873a(a.C0872a aVar) {
            this.f49218a = aVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f49218a.a(networkCustomError);
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null) {
                this.f49218a.a((CJRSubscribeAutoAdd) iJRPaytmDataModel);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.addmoney.common.model.CJRSubscribeAutoAdd");
        }
    }

    public final void a(a.b bVar) {
        kotlin.g.b.k.c(bVar, "disableSubscription");
        Context j2 = net.one97.paytm.helper.a.f50546a.a().j();
        String f2 = net.one97.paytm.helper.a.f50546a.a().f("remove_subscription");
        if (!URLUtil.isValidUrl(f2)) {
            bVar.a();
            return;
        }
        Map hashMap = new HashMap();
        String a2 = com.paytm.utility.d.a(j2);
        kotlin.g.b.k.a((Object) a2, "CJRNetUtility.getSSOToken(appContext)");
        hashMap.put("ssoToken", a2);
        JSONObject jSONObject = new JSONObject();
        hashMap.put("Content-Type", "application/json");
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("custId", com.paytm.utility.b.n(j2));
            jSONObject.put("request", jSONObject2);
            jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
            jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
            jSONObject.put("version", "1.0");
            jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "REMOVE_SUBSCRIPTION");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        String jSONObject3 = jSONObject.toString();
        kotlin.g.b.k.a((Object) jSONObject3, "requestBody.toString()");
        a.C0848a aVar = net.one97.paytm.addmoney.common.a.f48418a;
        com.paytm.network.a l2 = a.C0848a.b().a((IJRPaytmDataModel) new CJRSubscribeDisableAutoAdd()).a((Map<String, String>) hashMap).a(f2).b(jSONObject3).a((com.paytm.network.listener.b) new b(bVar)).c(getClass().getSimpleName()).l();
        if (com.paytm.utility.b.c(j2)) {
            l2.a();
            return;
        }
        kotlin.g.b.k.a((Object) l2, "commonNetworkCall");
        bVar.a(l2);
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.b f49219a;

        b(a.b bVar) {
            this.f49219a = bVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f49219a.a(networkCustomError != null ? networkCustomError.getAlertMessage() : null);
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRSubscribeDisableAutoAdd)) {
                this.f49219a.a((CJRSubscribeDisableAutoAdd) iJRPaytmDataModel);
            }
        }
    }

    public final void a(net.one97.paytm.addmoney.h hVar) {
        kotlin.g.b.k.c(hVar, H5Event.TYPE_CALL_BACK);
        String f2 = net.one97.paytm.helper.a.f50546a.a().f("check_user_balance_service");
        if (f2 != null) {
            try {
                if (URLUtil.isValidUrl(f2)) {
                    String e2 = com.paytm.utility.b.e(net.one97.paytm.helper.a.f50546a.a().j(), f2);
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("isDetailInfo", H5Param.DEFAULT_LONG_PRESSO_LOGIN);
                    jSONObject2.put("computeAddableAmount", true);
                    jSONObject.put("request", jSONObject2);
                    HashMap hashMap = new HashMap();
                    hashMap.put("ssotoken", com.paytm.utility.d.a(net.one97.paytm.helper.a.f50546a.a().j()));
                    hashMap.put("Accept-Encoding", "gzip");
                    if (com.paytm.utility.b.c(net.one97.paytm.helper.a.f50546a.a().j())) {
                        a.C0848a aVar = net.one97.paytm.addmoney.common.a.f48418a;
                        a.C0848a.b().a((Map<String, String>) hashMap).a(e2).a((IJRPaytmDataModel) new CJRCashWallet()).b(jSONObject.toString()).c("AddMoneyAuto").a((com.paytm.network.listener.b) new g(hVar)).l().a();
                        return;
                    }
                    NetworkCustomError networkCustomError = new NetworkCustomError();
                    networkCustomError.setUrl(e2);
                    hVar.b(networkCustomError);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                NetworkCustomError networkCustomError2 = new NetworkCustomError();
                networkCustomError2.setUrl(f2);
                hVar.b(networkCustomError2);
            }
        }
    }

    public static final class g implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.addmoney.h f49226a;

        g(net.one97.paytm.addmoney.h hVar) {
            this.f49226a = hVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            this.f49226a.a(iJRPaytmDataModel);
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.g.b.k.c(networkCustomError, "networkCustomError");
            this.f49226a.b(networkCustomError);
        }
    }

    public final void a(a.d dVar) {
        kotlin.g.b.k.c(dVar, H5Event.TYPE_CALL_BACK);
        Context j2 = net.one97.paytm.helper.a.f50546a.a().j();
        String f2 = net.one97.paytm.helper.a.f50546a.a().f("fetch_subscription_url");
        if (!URLUtil.isValidUrl(f2)) {
            dVar.a();
            return;
        }
        String a2 = com.paytm.utility.d.a(j2);
        HashMap hashMap = new HashMap();
        if (a2 != null) {
            hashMap.put("ssoToken", a2);
        }
        Map map = hashMap;
        map.put("Content-Type", "application/json");
        a.C0848a aVar = net.one97.paytm.addmoney.common.a.f48418a;
        com.paytm.network.a l2 = a.C0848a.b().a(f2).a((IJRPaytmDataModel) new CJRSubscribeFetchStatus()).a((Map<String, String>) map).b("").a((com.paytm.network.listener.b) new l(dVar)).l();
        if (com.paytm.utility.b.c(j2)) {
            l2.a();
            return;
        }
        kotlin.g.b.k.a((Object) l2, "commonNetworkCall");
        dVar.a(l2);
    }

    public static final class l implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.d f49237a;

        l(a.d dVar) {
            this.f49237a = dVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (networkCustomError == null || networkCustomError.networkResponse == null || !(networkCustomError.networkResponse.statusCode == 403 || networkCustomError.networkResponse.statusCode == 401 || networkCustomError.networkResponse.statusCode == 410)) {
                this.f49237a.a(networkCustomError);
            } else {
                this.f49237a.b(networkCustomError);
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRSubscribeFetchStatus)) {
                this.f49237a.a((CJRSubscribeFetchStatus) iJRPaytmDataModel);
            }
        }
    }

    public final void a(boolean z, a.h hVar) {
        kotlin.g.b.k.c(hVar, "savedCardListener");
        ArrayList arrayList = new ArrayList();
        Map hashMap = new HashMap();
        String a2 = com.paytm.utility.d.a(net.one97.paytm.helper.a.f50546a.a().j());
        kotlin.g.b.k.a((Object) a2, "CJRNetUtility.getSSOToke….getApplicationContext())");
        hashMap.put("session_token", a2);
        hashMap.put("token_type", AppConstants.USER);
        hashMap.put("Content-Type", "application/json");
        a.C0848a aVar = net.one97.paytm.addmoney.common.a.f48418a;
        com.paytm.network.a l2 = a.C0848a.a().a((IJRPaytmDataModel) new CJRAvailableInstrumentsAddMoney()).a((Map<String, String>) hashMap).a((com.paytm.network.listener.b) new h(hVar, z, arrayList)).a(net.one97.paytm.helper.a.f50546a.a().f("fetch_subscription_cards") + com.paytm.utility.b.n(net.one97.paytm.helper.a.f50546a.a().j()) + "/DC").l();
        if (com.paytm.utility.b.c(net.one97.paytm.helper.a.f50546a.a().j())) {
            l2.a();
            return;
        }
        kotlin.g.b.k.a((Object) l2, "cjrCommonNetworkCall");
        hVar.a(l2);
    }

    public static final /* synthetic */ void a(boolean z, ArrayList arrayList, a.h hVar) {
        if (net.one97.paytm.helper.a.f50546a.a().g("isCCAllowedForAutoAm") || z) {
            Map hashMap = new HashMap();
            String a2 = com.paytm.utility.d.a(net.one97.paytm.helper.a.f50546a.a().j());
            kotlin.g.b.k.a((Object) a2, "CJRNetUtility.getSSOToke….getApplicationContext())");
            hashMap.put("session_token", a2);
            hashMap.put("token_type", AppConstants.USER);
            hashMap.put("Content-Type", "application/json");
            a.C0848a aVar = net.one97.paytm.addmoney.common.a.f48418a;
            com.paytm.network.a l2 = a.C0848a.a().a(net.one97.paytm.helper.a.f50546a.a().f("fetch_subscription_cards") + com.paytm.utility.b.n(net.one97.paytm.helper.a.f50546a.a().j()) + "/CC").a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new CJRAvailableInstrumentsAddMoneyCreditCard()).a((com.paytm.network.listener.b) new f(hVar, arrayList)).l();
            if (com.paytm.utility.b.c(net.one97.paytm.helper.a.f50546a.a().j())) {
                l2.a();
                return;
            }
            kotlin.g.b.k.a((Object) l2, "cjrCommonNetworkCall");
            hVar.a(l2);
            return;
        }
        a((ArrayList<IJRDataModel>) arrayList, hVar);
    }
}
