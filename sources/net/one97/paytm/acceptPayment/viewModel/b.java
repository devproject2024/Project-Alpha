package net.one97.paytm.acceptPayment.viewModel;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.aj;
import androidx.lifecycle.w;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.deeplinkUtil.DeepLinkConstant;
import com.business.merchant_payments.downloadqr.DownloadQrActivity;
import com.business.merchant_payments.mapqr.view.ScanActivityVision;
import com.business.merchant_payments.notificationsettings.activity.MpNotificationsActivity;
import com.business.merchant_payments.requestmoney.PaymentLinkActivity;
import com.business.merchant_payments.utility.BackgroundTaskExecutor;
import com.business.merchant_payments.utility.MPConstants;
import com.paytm.business.merchantprofile.view.ProfileBusinessDetailsActivity;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.a.ae;
import kotlin.g.a.m;
import kotlin.m.p;
import kotlin.o;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.acceptPayment.R;
import net.one97.paytm.acceptPayment.activities.AcceptPaymentMerchantSettings;
import net.one97.paytm.acceptPayment.f.a;
import net.one97.paytm.acceptPayment.home.AcceptPaymentMainActivity;
import net.one97.paytm.acceptPayment.model.DownloadSettlement;
import net.one97.paytm.acceptPayment.model.ForceUpdateResponseModel;
import net.one97.paytm.acceptPayment.model.MerchantInfoRaw;
import net.one97.paytm.acceptPayment.model.NetworkRequest;
import net.one97.paytm.acceptPayment.model.RequestData;
import net.one97.paytm.acceptPayment.model.Result;
import net.one97.paytm.acceptPayment.model.ResultInfo;
import net.one97.paytm.acceptPayment.onBoarding.view.OnBoardingActivity;
import net.one97.paytm.acceptPayment.viewModel.d;
import net.one97.paytm.acceptPayment.webview.AcceptPaymentWebViewActivity;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends d {

    /* renamed from: a  reason: collision with root package name */
    public final Context f52171a;

    /* renamed from: b  reason: collision with root package name */
    public DeepLinkData f52172b;

    /* renamed from: c  reason: collision with root package name */
    final net.one97.paytm.acceptPayment.f.a f52173c = new net.one97.paytm.acceptPayment.f.a();

    /* renamed from: d  reason: collision with root package name */
    public boolean f52174d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a f52175e = a((kotlin.g.a.a<? extends LiveData<NetworkRequest>>) new l(this));

    /* renamed from: f  reason: collision with root package name */
    public final d.a f52176f = a((kotlin.g.a.a<? extends LiveData<NetworkRequest>>) new e(this));

    /* renamed from: g  reason: collision with root package name */
    JSONObject f52177g;
    /* access modifiers changed from: private */
    public final d.a l = a((kotlin.g.a.a<? extends LiveData<NetworkRequest>>) new d(this));
    private final BackgroundTaskExecutor m = new BackgroundTaskExecutor((androidx.lifecycle.k) null, 1, (kotlin.g.b.g) null);

    public b() {
        net.one97.paytm.acceptPayment.b.a b2 = net.one97.paytm.acceptPayment.configs.a.a().b();
        kotlin.g.b.k.b(b2, "AcceptPaymentsConfig.get…tAcceptPaymentsListener()");
        this.f52171a = b2.a();
    }

    static final class l extends kotlin.g.b.l implements kotlin.g.a.a<LiveData<NetworkRequest>> {
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(b bVar) {
            super(0);
            this.this$0 = bVar;
        }

        public final LiveData<NetworkRequest> invoke() {
            String str = this.this$0.f52188h;
            AnonymousClass1 r1 = new kotlin.g.a.b<NetworkRequest, x>(this) {
                final /* synthetic */ l this$0;

                {
                    this.this$0 = r1;
                }

                public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((NetworkRequest) obj);
                    return x.f47997a;
                }

                public final void invoke(NetworkRequest networkRequest) {
                    kotlin.g.b.k.d(networkRequest, "request");
                    IJRPaytmDataModel ijrPaytmDataModel = networkRequest.getIjrPaytmDataModel();
                    if (!(ijrPaytmDataModel instanceof MerchantInfoRaw)) {
                        ijrPaytmDataModel = null;
                    }
                    MerchantInfoRaw merchantInfoRaw = (MerchantInfoRaw) ijrPaytmDataModel;
                    if (merchantInfoRaw != null) {
                        Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(this.this$0.this$0), (kotlin.d.f) null, (CoroutineStart) null, new a(merchantInfoRaw, (kotlin.d.d) null, this), 3, (Object) null);
                    }
                }

                /* renamed from: net.one97.paytm.acceptPayment.viewModel.b$l$1$a */
                static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
                    final /* synthetic */ MerchantInfoRaw $it;
                    Object L$0;
                    int label;
                    private CoroutineScope p$;
                    final /* synthetic */ AnonymousClass1 this$0;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    a(MerchantInfoRaw merchantInfoRaw, kotlin.d.d dVar, AnonymousClass1 r3) {
                        super(2, dVar);
                        this.$it = merchantInfoRaw;
                        this.this$0 = r3;
                    }

                    public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                        kotlin.g.b.k.d(dVar, "completion");
                        a aVar = new a(this.$it, dVar, this.this$0);
                        aVar.p$ = (CoroutineScope) obj;
                        return aVar;
                    }

                    public final Object invoke(Object obj, Object obj2) {
                        return ((a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
                    }

                    public final Object invokeSuspend(Object obj) {
                        kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                        int i2 = this.label;
                        if (i2 == 0) {
                            ResultKt.a(obj);
                            CoroutineScope coroutineScope = this.p$;
                            com.business.common_module.e.a merchantInfo = this.$it.getMerchantInfo();
                            if (merchantInfo != null) {
                                net.one97.paytm.acceptPayment.utils.b.a(System.currentTimeMillis());
                                net.one97.paytm.acceptPayment.d.a aVar2 = net.one97.paytm.acceptPayment.d.a.f52050a;
                                String currentMerchant = merchantInfo.getCurrentMerchant();
                                kotlin.g.b.k.b(currentMerchant, "merchantInfo.currentMerchant");
                                ArrayList<com.business.common_module.e.b> merchants = merchantInfo.getMerchants();
                                kotlin.g.b.k.b(merchants, "merchantInfo.merchants");
                                merchantInfo.setMerchants(aVar2.a(currentMerchant, merchants));
                                net.one97.paytm.acceptPayment.d.a aVar3 = net.one97.paytm.acceptPayment.d.a.f52050a;
                                net.one97.paytm.acceptPayment.d.a.a(merchantInfo);
                            }
                            this.L$0 = coroutineScope;
                            this.label = 1;
                            if (DelayKt.delay(100, this) == aVar) {
                                return aVar;
                            }
                        } else if (i2 == 1) {
                            ResultKt.a(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.g.b.k.b(net.one97.paytm.acceptPayment.b.b.a(), "GTMHelper.getInstance()");
                        if (net.one97.paytm.acceptPayment.b.b.h()) {
                            this.this$0.this$0.this$0.f52176f.b();
                        } else {
                            this.this$0.this$0.this$0.a();
                        }
                        return x.f47997a;
                    }
                }
            };
            kotlin.g.b.k.d(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
            return net.one97.paytm.acceptPayment.f.b.a(new a.c(net.one97.paytm.acceptPayment.utils.d.f52163a), r1, (kotlin.g.a.a<x>) null, str);
        }
    }

    static final class e extends kotlin.g.b.l implements kotlin.g.a.a<LiveData<NetworkRequest>> {
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(b bVar) {
            super(0);
            this.this$0 = bVar;
        }

        public final LiveData<NetworkRequest> invoke() {
            String str = this.this$0.f52188h;
            AnonymousClass1 r1 = new kotlin.g.a.b<NetworkRequest, x>(this) {
                final /* synthetic */ e this$0;

                {
                    this.this$0 = r1;
                }

                public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((NetworkRequest) obj);
                    return x.f47997a;
                }

                public final void invoke(NetworkRequest networkRequest) {
                    kotlin.g.b.k.d(networkRequest, "request");
                    IJRPaytmDataModel ijrPaytmDataModel = networkRequest.getIjrPaytmDataModel();
                    if (!(ijrPaytmDataModel instanceof ForceUpdateResponseModel)) {
                        ijrPaytmDataModel = null;
                    }
                    ForceUpdateResponseModel forceUpdateResponseModel = (ForceUpdateResponseModel) ijrPaytmDataModel;
                    if (forceUpdateResponseModel != null) {
                        b.a(this.this$0.this$0, forceUpdateResponseModel);
                    }
                }
            };
            AnonymousClass2 r2 = new kotlin.g.a.a<x>(this) {
                final /* synthetic */ e this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    this.this$0.this$0.f52189i.setValue(h.f52200a);
                    this.this$0.this$0.a();
                }
            };
            kotlin.g.b.k.d(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
            return net.one97.paytm.acceptPayment.f.b.a(new a.b(net.one97.paytm.acceptPayment.utils.d.f52163a), r1, r2, str);
        }
    }

    static final class d extends kotlin.g.b.l implements kotlin.g.a.a<LiveData<NetworkRequest>> {
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar) {
            super(0);
            this.this$0 = bVar;
        }

        public final LiveData<NetworkRequest> invoke() {
            RequestData requestData = new RequestData(this.this$0.f52188h, (String) null, this.this$0.f52177g, 2, (kotlin.g.b.g) null);
            AnonymousClass1 r0 = new kotlin.g.a.b<NetworkRequest, x>(this) {
                final /* synthetic */ d this$0;

                {
                    this.this$0 = r1;
                }

                public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((NetworkRequest) obj);
                    return x.f47997a;
                }

                public final void invoke(NetworkRequest networkRequest) {
                    kotlin.g.b.k.d(networkRequest, "request");
                    IJRPaytmDataModel ijrPaytmDataModel = networkRequest.getIjrPaytmDataModel();
                    if (!(ijrPaytmDataModel instanceof DownloadSettlement)) {
                        ijrPaytmDataModel = null;
                    }
                    DownloadSettlement downloadSettlement = (DownloadSettlement) ijrPaytmDataModel;
                    if (downloadSettlement != null) {
                        b.a(this.this$0.this$0, downloadSettlement);
                    }
                }
            };
            AnonymousClass2 r1 = new kotlin.g.a.a<x>(this) {
                final /* synthetic */ d this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    Toast.makeText(this.this$0.this$0.f52171a, net.one97.paytm.acceptPayment.configs.a.a().b().a(this.this$0.this$0.f52171a).getString(R.string.ap_some_went_wrong), 0).show();
                    this.this$0.this$0.f52189i.setValue(e.f52196a);
                }
            };
            kotlin.g.b.k.d(requestData, H5RpcPlugin.RpcRequest.RpcParam.REQUEST_DATA);
            return net.one97.paytm.acceptPayment.f.b.a(new a.C0929a(net.one97.paytm.acceptPayment.utils.d.f52163a), r0, r1, requestData);
        }
    }

    public final void a() {
        if (!b()) {
            b(AcceptPaymentMainActivity.class, (Map<String, String>) null);
        }
    }

    private final boolean b() {
        String str;
        String str2;
        DeepLinkData deepLinkData = this.f52172b;
        if (deepLinkData != null) {
            str = deepLinkData.f50284b;
        } else {
            str = null;
        }
        DeepLinkData deepLinkData2 = this.f52172b;
        if (deepLinkData2 != null) {
            str2 = deepLinkData2.f50288f;
        } else {
            str2 = null;
        }
        if (!kotlin.g.b.k.a((Object) str, (Object) DeepLinkConstant.ACCEPT_PAYMENT_AUTHORITY) || str2 == null) {
            return false;
        }
        switch (str2.hashCode()) {
            case -1990679366:
                if (!str2.equals(DeepLinkConstant.FEATURES.MERCHANT_SETTING)) {
                    return false;
                }
                a((Class<? extends Activity>) AcceptPaymentMerchantSettings.class, (Map<String, String>) null);
                return true;
            case -1695880281:
                if (!str2.equals("verify_qr")) {
                    return false;
                }
                c(str2);
                return true;
            case -1615723206:
                if (!str2.equals(DeepLinkConstant.FEATURES.SETTLEMENT)) {
                    return false;
                }
                net.one97.paytm.acceptPayment.b.b.a();
                String a2 = net.one97.paytm.acceptPayment.utils.b.a((String) null, net.one97.paytm.acceptPayment.b.b.c("ap_setting_url"));
                kotlin.g.b.k.b(a2, "settlementWeppageDeeplink");
                b(a2);
                return true;
            case -1598179289:
                if (!str2.equals(DeepLinkConstant.FEATURES.KEY_WHATSAPP_BOTTOM_SHEET_LAUNCH)) {
                    return false;
                }
                c(str2);
                return true;
            case -1276952588:
                if (!str2.equals(DeepLinkConstant.FEATURES.DOWNLOAD_PAYMENTS_STATEMENT)) {
                    return false;
                }
                c();
                return true;
            case -1211138760:
                if (!str2.equals(DeepLinkConstant.FEATURES.DOWNLOAD_QR)) {
                    return false;
                }
                a((Class<? extends Activity>) DownloadQrActivity.class);
                return true;
            case -1164337520:
                if (!str2.equals("settlement_summary")) {
                    return false;
                }
                Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(this), Dispatchers.getMain(), (CoroutineStart) null, new C0935b((kotlin.d.d) null, this, str2), 2, (Object) null);
                return true;
            case -1003406089:
                if (!str2.equals("notification_settings")) {
                    return false;
                }
                a((Class<? extends Activity>) MpNotificationsActivity.class, (Map<String, String>) null);
                return true;
            case -552460880:
                if (!str2.equals("business_detail")) {
                    return false;
                }
                a((Class<? extends Activity>) ProfileBusinessDetailsActivity.class);
                return true;
            case -497186157:
                if (!str2.equals(DeepLinkConstant.FEATURES.PAYMENT_LINK)) {
                    return false;
                }
                f();
                return true;
            case -365225363:
                if (!str2.equals("payment_summary")) {
                    return false;
                }
                Job unused2 = BuildersKt__Builders_commonKt.launch$default(aj.a(this), Dispatchers.getMain(), (CoroutineStart) null, new a((kotlin.d.d) null, this, str2), 2, (Object) null);
                return true;
            case -310781729:
                if (!str2.equals(DeepLinkConstant.FEATURES.UMP_WEB)) {
                    return false;
                }
                e();
                return true;
            case -181736007:
                if (!str2.equals("auto_settlement")) {
                    return false;
                }
                net.one97.paytm.acceptPayment.b.b.a();
                String a3 = net.one97.paytm.acceptPayment.utils.b.a((String) null, net.one97.paytm.acceptPayment.b.b.c("ap_setting_url"));
                kotlin.g.b.k.b(a3, "settlementWeppageDeeplink");
                b(a3);
                return true;
            case 177080454:
                if (!str2.equals(DeepLinkConstant.FEATURES.LINK_QR)) {
                    return false;
                }
                a((Class<? extends Activity>) ScanActivityVision.class);
                return true;
            case 214910879:
                if (!str2.equals("select_bank")) {
                    return false;
                }
                net.one97.paytm.acceptPayment.b.b.a();
                String a4 = net.one97.paytm.acceptPayment.utils.b.a((String) null, net.one97.paytm.acceptPayment.b.b.c("ap_setting_url"));
                kotlin.g.b.k.b(a4, "settlementWeppageDeeplink");
                b(a4);
                return true;
            case 454228475:
                if (!str2.equals("view_qr")) {
                    return false;
                }
                c(str2);
                return true;
            case 894146353:
                if (!str2.equals(DeepLinkConstant.FEATURES.MERCHANT_CASHBACK)) {
                    return false;
                }
                this.f52189i.setValue(new g("paytmmp://cash_wallet?featuretype=vip&screen=homescreenMerchant&showHomeOnBack=false"));
                return true;
            case 1021788416:
                if (!str2.equals(DeepLinkConstant.FEATURES.KEY_WHATSAPP_CONSENT_ACTIVATE)) {
                    return false;
                }
                c(str2);
                return true;
            case 1178745787:
                if (!str2.equals("limit_charges")) {
                    return false;
                }
                net.one97.paytm.acceptPayment.b.b.a();
                String a5 = net.one97.paytm.acceptPayment.utils.b.a((String) null, net.one97.paytm.acceptPayment.b.b.c("ap_limits_url_v2"));
                kotlin.g.b.k.b(a5, "limitsDeeplin");
                b(a5);
                return true;
            case 1234305202:
                if (!str2.equals(DeepLinkConstant.FEATURES.ORDER_QR)) {
                    return false;
                }
                this.f52189i.setValue(new g("paytmmp://grid?url=https://catalog.paytm.com/merchandising-store-llpid-160663?channel=web&site_id=1&version=2"));
                return true;
            default:
                return false;
        }
    }

    private final void c() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(this), Dispatchers.getMain(), (CoroutineStart) null, new c(this, (kotlin.d.d) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final JSONObject d() {
        boolean z;
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(com.paytm.utility.b.m(this.f52171a))) {
                str = com.paytm.utility.b.m(this.f52171a);
                z = true;
            } else {
                str = null;
                z = false;
            }
            jSONObject.put(AppConstants.KEY_EMAIL, str);
            jSONObject.put("downloadSource", "UMP");
            jSONObject.put("sendToEmail", z);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private final void b(String str) {
        if (!net.one97.paytm.acceptPayment.d.a.f52050a.x()) {
            this.f52172b = net.one97.paytm.acceptPayment.utils.b.a(str);
            e();
        } else if (!this.f52175e.a()) {
            this.f52175e.b();
        } else {
            b(AcceptPaymentMainActivity.class, (Map<String, String>) null);
        }
    }

    private final void c(String str) {
        b(AcceptPaymentMainActivity.class, ae.b((o<? extends K, ? extends V>[]) new o[]{t.a("featuretype", str)}));
    }

    private final void e() {
        if (this.f52174d || net.one97.paytm.acceptPayment.d.a.f52050a.D() != null) {
            this.m.execute(new j(this), new k(this));
        } else if (!this.f52175e.a()) {
            this.f52175e.b();
        } else {
            b(OnBoardingActivity.class, (Map<String, String>) null);
        }
    }

    static final class j extends kotlin.g.b.l implements kotlin.g.a.a<Map<String, ? extends String>> {
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(b bVar) {
            super(0);
            this.this$0 = bVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
            r3 = (r3 = r3.f50289g).toString();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.Map<java.lang.String, java.lang.String> invoke() {
            /*
                r5 = this;
                net.one97.paytm.acceptPayment.viewModel.b r0 = r5.this$0
                net.one97.paytm.deeplink.DeepLinkData r0 = r0.f52172b
                r1 = 0
                if (r0 == 0) goto L_0x0065
                android.net.Uri r0 = r0.f50289g
                if (r0 == 0) goto L_0x0065
                java.util.HashMap r0 = net.one97.paytm.acceptPayment.utils.b.a((android.net.Uri) r0)
                java.lang.String r2 = "featuretype"
                r0.remove(r2)
                java.lang.String r2 = "url"
                boolean r3 = r0.containsKey(r2)
                if (r3 == 0) goto L_0x0039
                net.one97.paytm.acceptPayment.viewModel.b r3 = r5.this$0
                net.one97.paytm.deeplink.DeepLinkData r3 = r3.f52172b
                if (r3 == 0) goto L_0x0035
                android.net.Uri r3 = r3.f50289g
                if (r3 == 0) goto L_0x0035
                java.lang.String r3 = r3.toString()
                if (r3 == 0) goto L_0x0035
                java.lang.String r4 = "url="
                java.lang.String r3 = kotlin.m.p.d(r3, r4, r3)
                goto L_0x0036
            L_0x0035:
                r3 = r1
            L_0x0036:
                r0.put(r2, r3)
            L_0x0039:
                net.one97.paytm.acceptPayment.viewModel.b r2 = r5.this$0
                net.one97.paytm.deeplink.DeepLinkData r2 = r2.f52172b
                if (r2 == 0) goto L_0x0041
                android.net.Uri r1 = r2.f50289g
            L_0x0041:
                java.lang.String r1 = java.lang.String.valueOf(r1)
                java.lang.String r2 = "deeplink_url"
                r0.put(r2, r1)
                r1 = 1
                kotlin.o[] r1 = new kotlin.o[r1]
                net.one97.paytm.acceptPayment.viewModel.b r2 = r5.this$0
                com.google.gson.f r2 = r2.j
                java.lang.String r2 = r2.b(r0)
                java.lang.String r3 = "query_param"
                kotlin.o r2 = kotlin.t.a(r3, r2)
                r3 = 0
                r1[r3] = r2
                java.util.Map r1 = kotlin.a.ae.b((kotlin.o<? extends K, ? extends V>[]) r1)
                r1.putAll(r0)
            L_0x0065:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.acceptPayment.viewModel.b.j.invoke():java.util.Map");
        }
    }

    public static final class k implements BackgroundTaskExecutor.BackgroundTaskListener<Map<String, ? extends String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f52184a;

        k(b bVar) {
            this.f52184a = bVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            this.f52184a.b(AcceptPaymentWebViewActivity.class, (Map) obj);
        }

        public final void onError(Exception exc) {
            kotlin.g.b.k.d(exc, "e");
            this.f52184a.b(AcceptPaymentMainActivity.class, (Map<String, String>) null);
        }
    }

    /* access modifiers changed from: private */
    public final void a(Class<? extends Activity> cls, Map<String, String> map) {
        if (!net.one97.paytm.acceptPayment.d.a.f52050a.x()) {
            this.m.execute(new h(this), new i(this, map, cls));
        } else if (!this.f52175e.a()) {
            this.f52175e.b();
        } else {
            b(AcceptPaymentMainActivity.class, (Map<String, String>) null);
        }
    }

    static final /* synthetic */ class h extends kotlin.g.b.j implements kotlin.g.a.a<Map<String, String>> {
        h(b bVar) {
            super(0, bVar, b.class, "getDeeplinkData", "getDeeplinkData()Ljava/util/Map;", 0);
        }

        public final Map<String, String> invoke() {
            return b.c((b) this.receiver);
        }
    }

    public static final class i implements BackgroundTaskExecutor.BackgroundTaskListener<Map<String, ? extends String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f52181a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map f52182b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Class f52183c;

        i(b bVar, Map map, Class cls) {
            this.f52181a = bVar;
            this.f52182b = map;
            this.f52183c = cls;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Map map = (Map) obj;
            if (map != null) {
                Map b2 = ae.b(map);
                Map map2 = this.f52182b;
                if (map2 != null) {
                    b2.putAll(map2);
                }
                this.f52181a.b(this.f52183c, b2);
                return;
            }
            this.f52181a.b(AcceptPaymentMainActivity.class, (Map<String, String>) null);
        }

        public final void onError(Exception exc) {
            kotlin.g.b.k.d(exc, "e");
            this.f52181a.b(AcceptPaymentMainActivity.class, (Map<String, String>) null);
        }
    }

    private final void a(Class<? extends Activity> cls) {
        if (net.one97.paytm.acceptPayment.d.a.f52050a.D() != null) {
            this.m.execute(new f(this), new g(this, cls));
        } else if (!this.f52175e.a()) {
            this.f52175e.b();
        } else {
            b(OnBoardingActivity.class, (Map<String, String>) null);
        }
    }

    static final /* synthetic */ class f extends kotlin.g.b.j implements kotlin.g.a.a<Map<String, String>> {
        f(b bVar) {
            super(0, bVar, b.class, "getDeeplinkData", "getDeeplinkData()Ljava/util/Map;", 0);
        }

        public final Map<String, String> invoke() {
            return b.c((b) this.receiver);
        }
    }

    public static final class g implements BackgroundTaskExecutor.BackgroundTaskListener<Map<String, ? extends String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f52178a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map f52179b = null;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Class f52180c;

        /* JADX WARNING: type inference failed for: r2v0, types: [java.util.Map, java.lang.Class] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        g(net.one97.paytm.acceptPayment.viewModel.b r1, java.util.Map r2) {
            /*
                r0 = this;
                r0.f52178a = r1
                r1 = 0
                r0.f52179b = r1
                r0.f52180c = r2
                r0.<init>()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.acceptPayment.viewModel.b.g.<init>(net.one97.paytm.acceptPayment.viewModel.b, java.lang.Class):void");
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Map map = (Map) obj;
            if (map != null) {
                Map b2 = ae.b(map);
                Map map2 = this.f52179b;
                if (map2 != null) {
                    b2.putAll(map2);
                }
                this.f52178a.b(this.f52180c, b2);
                return;
            }
            this.f52178a.b(AcceptPaymentMainActivity.class, (Map<String, String>) null);
        }

        public final void onError(Exception exc) {
            kotlin.g.b.k.d(exc, "e");
            this.f52178a.b(AcceptPaymentMainActivity.class, (Map<String, String>) null);
        }
    }

    private final void f() {
        if (net.one97.paytm.acceptPayment.d.a.f52050a.e() && net.one97.paytm.acceptPayment.d.a.f52050a.f() && net.one97.paytm.acceptPayment.d.a.f52050a.u()) {
            b(PaymentLinkActivity.class, (Map<String, String>) null);
        } else if (!this.f52175e.a()) {
            this.f52175e.b();
        } else {
            b(AcceptPaymentMainActivity.class, (Map<String, String>) null);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static kotlin.o<java.lang.String, java.lang.String> b(java.util.Map<java.lang.String, java.lang.String> r8, java.lang.String r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "start"
            boolean r1 = r8.containsKey(r0)
            java.lang.String r2 = "DateUtility.getFormatted…            outputFormat)"
            r3 = 1
            r4 = 0
            java.lang.String r5 = ""
            if (r1 == 0) goto L_0x002c
            java.lang.Object r0 = r8.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0018
            r0 = r5
        L_0x0018:
            java.lang.String r0 = com.business.merchant_payments.common.utility.DateUtility.getFormattedDate(r0, r9, r10)
            kotlin.g.b.k.b(r0, r2)
            int r1 = r0.length()
            if (r1 <= 0) goto L_0x0027
            r1 = 1
            goto L_0x0028
        L_0x0027:
            r1 = 0
        L_0x0028:
            if (r1 == 0) goto L_0x002d
            r1 = 1
            goto L_0x002e
        L_0x002c:
            r0 = r5
        L_0x002d:
            r1 = 0
        L_0x002e:
            java.lang.String r6 = "end"
            boolean r7 = r8.containsKey(r6)
            if (r7 == 0) goto L_0x0052
            java.lang.Object r8 = r8.get(r6)
            java.lang.String r8 = (java.lang.String) r8
            if (r8 != 0) goto L_0x003f
            r8 = r5
        L_0x003f:
            java.lang.String r5 = com.business.merchant_payments.common.utility.DateUtility.getFormattedDate(r8, r9, r10)
            kotlin.g.b.k.b(r5, r2)
            int r8 = r5.length()
            if (r8 <= 0) goto L_0x004e
            r8 = 1
            goto L_0x004f
        L_0x004e:
            r8 = 0
        L_0x004f:
            if (r8 == 0) goto L_0x0052
            r4 = 1
        L_0x0052:
            if (r1 == 0) goto L_0x005c
            if (r4 == 0) goto L_0x005c
            kotlin.o r8 = new kotlin.o
            r8.<init>(r0, r5)
            return r8
        L_0x005c:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.acceptPayment.viewModel.b.b(java.util.Map, java.lang.String, java.lang.String):kotlin.o");
    }

    @kotlin.d.b.a.f(b = "AcceptPaymentInitViewmodel.kt", c = {362}, d = "invokeSuspend", e = "net.one97.paytm.acceptPayment.viewModel.AcceptPaymentInitViewmodel$downloadPaymentsStatement$1")
    static final class c extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        Object L$0;
        Object L$1;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = bVar;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.d(dVar, "completion");
            c cVar = new c(this.this$0, dVar);
            cVar.p$ = (CoroutineScope) obj;
            return cVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((c) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        @kotlin.d.b.a.f(b = "AcceptPaymentInitViewmodel.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.acceptPayment.viewModel.AcceptPaymentInitViewmodel$downloadPaymentsStatement$1$dates$1")
        static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super o<? extends String, ? extends String>>, Object> {
            int label;
            private CoroutineScope p$;
            final /* synthetic */ c this$0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, kotlin.d.d dVar) {
                super(2, dVar);
                this.this$0 = cVar;
            }

            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                kotlin.g.b.k.d(dVar, "completion");
                a aVar = new a(this.this$0, dVar);
                aVar.p$ = (CoroutineScope) obj;
                return aVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
            }

            public final Object invokeSuspend(Object obj) {
                Uri uri;
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                if (this.label == 0) {
                    ResultKt.a(obj);
                    DeepLinkData deepLinkData = this.this$0.this$0.f52172b;
                    if (deepLinkData != null) {
                        uri = deepLinkData.f50289g;
                    } else {
                        uri = null;
                    }
                    HashMap<String, String> a2 = net.one97.paytm.acceptPayment.utils.b.a(uri);
                    kotlin.g.b.k.b(a2, "queryParams");
                    return b.b((Map<String, String>) a2, "dd/MM/yyyy HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ssZZZZZ");
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public final Object invokeSuspend(Object obj) {
            JSONObject jSONObject;
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.a(obj);
                CoroutineScope coroutineScope = this.p$;
                JSONObject a2 = this.this$0.d();
                CoroutineDispatcher coroutineDispatcher = Dispatchers.getDefault();
                a aVar2 = new a(this, (kotlin.d.d) null);
                this.L$0 = coroutineScope;
                this.L$1 = a2;
                this.label = 1;
                obj = BuildersKt.withContext(coroutineDispatcher, aVar2, this);
                if (obj == aVar) {
                    return aVar;
                }
                jSONObject = a2;
            } else if (i2 == 1) {
                jSONObject = (JSONObject) this.L$1;
                ResultKt.a(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            o oVar = (o) obj;
            if (oVar != null) {
                jSONObject.put("orderCreatedStartTime", oVar.getFirst());
                jSONObject.put("orderCreatedEndTime", oVar.getSecond());
                b bVar = this.this$0;
                bVar.f52177g = jSONObject;
                bVar.l.b();
            } else {
                this.this$0.a((Class<? extends Activity>) AcceptPaymentMainActivity.class, (Map<String, String>) null);
            }
            return x.f47997a;
        }
    }

    static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ String $featureType$inlined;
        Object L$0;
        Object L$1;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(kotlin.d.d dVar, b bVar, String str) {
            super(2, dVar);
            this.this$0 = bVar;
            this.$featureType$inlined = str;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.d(dVar, "completion");
            a aVar = new a(dVar, this.this$0, this.$featureType$inlined);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            Map map;
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.a(obj);
                CoroutineScope coroutineScope = this.p$;
                Map b2 = ae.b((o<? extends K, ? extends V>[]) new o[]{t.a("type", "PAYMENTS")});
                CoroutineDispatcher coroutineDispatcher = Dispatchers.getDefault();
                AnonymousClass1 r4 = new m<CoroutineScope, kotlin.d.d<? super o<? extends String, ? extends String>>, Object>(this, (kotlin.d.d) null) {
                    int label;
                    private CoroutineScope p$;
                    final /* synthetic */ a this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                        kotlin.g.b.k.d(dVar, "completion");
                        AnonymousClass1 r0 = 

                        /* renamed from: net.one97.paytm.acceptPayment.viewModel.b$b  reason: collision with other inner class name */
                        static final class C0935b extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
                            final /* synthetic */ String $featureType$inlined;
                            Object L$0;
                            Object L$1;
                            int label;
                            private CoroutineScope p$;
                            final /* synthetic */ b this$0;

                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                            C0935b(kotlin.d.d dVar, b bVar, String str) {
                                super(2, dVar);
                                this.this$0 = bVar;
                                this.$featureType$inlined = str;
                            }

                            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                                kotlin.g.b.k.d(dVar, "completion");
                                C0935b bVar = new C0935b(dVar, this.this$0, this.$featureType$inlined);
                                bVar.p$ = (CoroutineScope) obj;
                                return bVar;
                            }

                            public final Object invoke(Object obj, Object obj2) {
                                return ((C0935b) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
                            }

                            public final Object invokeSuspend(Object obj) {
                                Map map;
                                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                                int i2 = this.label;
                                if (i2 == 0) {
                                    ResultKt.a(obj);
                                    CoroutineScope coroutineScope = this.p$;
                                    Map b2 = ae.b((o<? extends K, ? extends V>[]) new o[]{t.a("type", "SETTLEMENTS")});
                                    CoroutineDispatcher coroutineDispatcher = Dispatchers.getDefault();
                                    AnonymousClass1 r4 = new m<CoroutineScope, kotlin.d.d<? super o<? extends String, ? extends String>>, Object>(this, (kotlin.d.d) null) {
                                        int label;
                                        private CoroutineScope p$;
                                        final /* synthetic */ C0935b this$0;

                                        {
                                            this.this$0 = r1;
                                        }

                                        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                                            kotlin.g.b.k.d(dVar, "completion");
                                            AnonymousClass1 r0 = 

                                            /* access modifiers changed from: private */
                                            public final void b(Class<?> cls, Map<String, String> map) {
                                                this.f52189i.setValue(new m(cls, map));
                                            }

                                            public static final /* synthetic */ o a(Map map) {
                                                if (!map.containsKey("range")) {
                                                    return null;
                                                }
                                                String str = (String) map.get("range");
                                                if (kotlin.g.b.k.a((Object) str, (Object) "today")) {
                                                    return new o(DateUtility.getTodayStartDate("dd MMMM yy"), DateUtility.getCurrentFormattedDate("dd MMMM yy"));
                                                }
                                                if (kotlin.g.b.k.a((Object) str, (Object) "week")) {
                                                    return new o(DateUtility.getWeekStartDate("dd MMMM yy"), DateUtility.getCurrentFormattedDate("dd MMMM yy"));
                                                }
                                                if (kotlin.g.b.k.a((Object) str, (Object) MPConstants.PaymentSummaryRange.MONTH)) {
                                                    return new o(DateUtility.getMonthStartDate("dd MMMM yy"), DateUtility.getCurrentFormattedDate("dd MMMM yy"));
                                                }
                                                if (kotlin.g.b.k.a((Object) str, (Object) "custom")) {
                                                    return b((Map<String, String>) map, "dd/MM/yyyy", "dd MMM yy");
                                                }
                                                return null;
                                            }

                                            public static final /* synthetic */ Map c(b bVar) {
                                                Uri uri;
                                                DeepLinkData deepLinkData = bVar.f52172b;
                                                if (deepLinkData == null || (uri = deepLinkData.f50289g) == null) {
                                                    return null;
                                                }
                                                HashMap<String, String> a2 = net.one97.paytm.acceptPayment.utils.b.a(uri);
                                                a2.remove("featuretype");
                                                Map b2 = ae.b((o<? extends K, ? extends V>[]) new o[]{t.a("query_param", bVar.j.b(a2))});
                                                b2.putAll(a2);
                                                return b2;
                                            }

                                            public static final /* synthetic */ void a(b bVar, ForceUpdateResponseModel forceUpdateResponseModel) {
                                                Result results;
                                                if (forceUpdateResponseModel.getResults() == null || (results = forceUpdateResponseModel.getResults()) == null || !results.getForceUpdate()) {
                                                    bVar.a();
                                                    return;
                                                }
                                                w<n> wVar = bVar.f52189i;
                                                Result results2 = forceUpdateResponseModel.getResults();
                                                kotlin.g.b.k.a((Object) results2);
                                                wVar.setValue(new k(results2));
                                            }

                                            public static final /* synthetic */ void a(b bVar, DownloadSettlement downloadSettlement) {
                                                ResultInfo resultInfo = downloadSettlement.getResultInfo();
                                                kotlin.g.b.k.b(resultInfo, "downloadSettlement.resultInfo");
                                                if (p.a(resultInfo.getResultCode(), "success", true)) {
                                                    Toast.makeText(bVar.f52171a, net.one97.paytm.acceptPayment.configs.a.a().b().a(bVar.f52171a).getString(R.string.ap_download_settlement_msg_new), 0).show();
                                                } else {
                                                    Toast.makeText(bVar.f52171a, net.one97.paytm.acceptPayment.configs.a.a().b().a(bVar.f52171a).getString(R.string.ap_some_went_wrong), 0).show();
                                                }
                                                bVar.f52189i.setValue(e.f52196a);
                                            }
                                        }
