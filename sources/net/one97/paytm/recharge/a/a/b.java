package net.one97.paytm.recharge.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticBillCategoriesResponse;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticEditBillNameResponse;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionListModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionSavedCardsModel;
import net.one97.paytm.recharge.domain.entities.CJRCreateSubscriptionApiResponse;
import net.one97.paytm.recharge.domain.entities.CJRFetchBalanceResponse;
import net.one97.paytm.recharge.domain.entities.CJRNativeWithDrawDetails;
import net.one97.paytm.recharge.domain.entities.CJRPaymentOptionBody;
import net.one97.paytm.recharge.domain.entities.CJRPaymentOptionResponse;
import net.one97.paytm.recharge.widgets.model.CJRTaggedObservable;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONObject;

public final class b {

    /* renamed from: net.one97.paytm.recharge.a.a.b$b  reason: collision with other inner class name */
    static final class C1159b<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f60192a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f60193b;

        C1159b(String str, Context context) {
            this.f60192a = str;
            this.f60193b = context;
        }

        public final void subscribe(final z<CJRAutomaticSubscriptionCheckModel> zVar) {
            kotlin.g.b.k.a((Object) zVar, "emitter");
            if (!zVar.isDisposed()) {
                net.one97.paytm.recharge.automatic.c.a.b bVar = net.one97.paytm.recharge.automatic.c.a.b.f60258a;
                String e2 = net.one97.paytm.recharge.automatic.c.a.b.e();
                String s = com.paytm.utility.b.s(this.f60193b, e2 + "?rech_num=" + this.f60192a);
                kotlin.g.b.k.a((Object) s, "CJRAppCommonUtility.addD…sWithoutSSO(context, url)");
                HashMap<String, String> a2 = com.paytm.utility.b.a((HashMap<String, String>) new HashMap(), this.f60193b);
                kotlin.g.b.k.a((Object) a2, "CJRAppCommonUtility.addS…nHeader(headers, context)");
                net.one97.paytm.recharge.automatic.e.d.a();
                net.one97.paytm.recharge.automatic.e.d.a(new net.one97.paytm.recharge.automatic.e.b(s, new net.one97.paytm.recharge.widgets.b.d() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        z zVar = zVar;
                        if (iJRPaytmDataModel != null) {
                            zVar.onSuccess((CJRAutomaticSubscriptionCheckModel) iJRPaytmDataModel);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel");
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        if (networkCustomError != null) {
                            zVar.onError(networkCustomError);
                        }
                    }
                }, new CJRAutomaticSubscriptionCheckModel(), a2));
            }
        }
    }

    static final class h<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f60215a;

        h(Context context) {
            this.f60215a = context;
        }

        public final void subscribe(final z<CJRAutomaticSubscriptionSavedCardsModel> zVar) {
            kotlin.g.b.k.a((Object) zVar, "emitter");
            if (!zVar.isDisposed()) {
                StringBuilder sb = new StringBuilder();
                net.one97.paytm.recharge.automatic.c.a.b bVar = net.one97.paytm.recharge.automatic.c.a.b.f60258a;
                sb.append(net.one97.paytm.recharge.automatic.c.a.b.i());
                sb.append(com.paytm.utility.b.n(this.f60215a));
                sb.append("/NORMAL");
                String s = com.paytm.utility.b.s(this.f60215a, sb.toString());
                kotlin.g.b.k.a((Object) s, "CJRAppCommonUtility.addD…sWithoutSSO(context, url)");
                Map hashMap = new HashMap();
                String a2 = com.paytm.utility.d.a(this.f60215a);
                kotlin.g.b.k.a((Object) a2, "CJRNetUtility.getSSOToken(context)");
                hashMap.put("session_token", a2);
                hashMap.put("token_type", AppConstants.USER);
                net.one97.paytm.recharge.automatic.e.d.a();
                net.one97.paytm.recharge.automatic.e.d.a(new net.one97.paytm.recharge.automatic.e.b(s, new net.one97.paytm.recharge.widgets.b.d() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        z zVar = zVar;
                        if (iJRPaytmDataModel != null) {
                            zVar.onSuccess((CJRAutomaticSubscriptionSavedCardsModel) iJRPaytmDataModel);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionSavedCardsModel");
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        if (networkCustomError != null) {
                            zVar.onError(networkCustomError);
                        }
                    }
                }, new CJRAutomaticSubscriptionSavedCardsModel((ArrayList) null, 1, (kotlin.g.b.g) null), hashMap));
            }
        }
    }

    static final class e<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f60200a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f60201b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f60202c;

        e(String str, Context context, String str2) {
            this.f60200a = str;
            this.f60201b = context;
            this.f60202c = str2;
        }

        public final void subscribe(final z<CJROrderSummary> zVar) {
            kotlin.g.b.k.a((Object) zVar, "emitter");
            if (!zVar.isDisposed()) {
                net.one97.paytm.recharge.automatic.c.a.b bVar = net.one97.paytm.recharge.automatic.c.a.b.f60258a;
                String a2 = kotlin.g.b.k.a(net.one97.paytm.recharge.automatic.c.a.b.c(), (Object) this.f60200a);
                String str = com.paytm.utility.b.b(this.f60201b, a2) + "&actions=0";
                if (!TextUtils.isEmpty(this.f60202c)) {
                    str = str + "&pg_screen=" + this.f60202c;
                }
                net.one97.paytm.recharge.automatic.e.d.a();
                net.one97.paytm.recharge.automatic.e.d.a(new net.one97.paytm.recharge.automatic.e.b(str, new net.one97.paytm.recharge.widgets.b.d() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        z zVar = zVar;
                        if (iJRPaytmDataModel != null) {
                            zVar.onSuccess((CJROrderSummary) iJRPaytmDataModel);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.shopping.CJROrderSummary");
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        if (networkCustomError != null) {
                            zVar.onError(networkCustomError);
                        }
                    }
                }, new CJROrderSummary(), (Map<String, String>) null));
            }
        }
    }

    static final class j<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f60219a;

        j(Context context) {
            this.f60219a = context;
        }

        public final void subscribe(z<CJRFrequentOrderList> zVar) {
            kotlin.g.b.k.a((Object) zVar, "emitter");
            if (!zVar.isDisposed()) {
                net.one97.paytm.recharge.automatic.c.a.b bVar = net.one97.paytm.recharge.automatic.c.a.b.f60258a;
                String s = com.paytm.utility.b.s(this.f60219a, net.one97.paytm.recharge.automatic.c.a.b.b());
                URLUtil.isValidUrl(s);
                net.one97.paytm.recharge.automatic.e.b bVar2 = new net.one97.paytm.recharge.automatic.e.b(s, new a(zVar), new CJRFrequentOrderList(), com.paytm.utility.b.ah(this.f60219a));
                net.one97.paytm.recharge.automatic.e.d.a();
                net.one97.paytm.recharge.automatic.e.d.a(bVar2);
            }
        }

        public static final class a implements net.one97.paytm.recharge.widgets.b.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ z f60220a;

            a(z zVar) {
                this.f60220a = zVar;
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                z zVar = this.f60220a;
                if (iJRPaytmDataModel != null) {
                    zVar.onSuccess((CJRFrequentOrderList) iJRPaytmDataModel);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.recharge.CJRFrequentOrderList");
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (networkCustomError != null) {
                    this.f60220a.tryOnError(networkCustomError);
                }
            }
        }
    }

    public static final class d<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f60198a;

        public d(Context context) {
            this.f60198a = context;
        }

        public final void subscribe(z<CJRAutomaticBillCategoriesResponse> zVar) {
            kotlin.g.b.k.a((Object) zVar, "emitter");
            if (!zVar.isDisposed()) {
                net.one97.paytm.recharge.automatic.c.a.b bVar = net.one97.paytm.recharge.automatic.c.a.b.f60258a;
                String l = net.one97.paytm.recharge.automatic.c.a.b.l();
                CharSequence charSequence = l;
                if (!TextUtils.isEmpty(charSequence)) {
                    if (l == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!p.a(charSequence, (CharSequence) "?", false)) {
                        l = l + "?child_site_id=1&site_id=1&client=androidapp";
                    }
                }
                String s = com.paytm.utility.b.s(this.f60198a, l);
                URLUtil.isValidUrl(s);
                net.one97.paytm.recharge.automatic.e.b bVar2 = new net.one97.paytm.recharge.automatic.e.b(s, new a(zVar), new CJRAutomaticBillCategoriesResponse((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, 127, (kotlin.g.b.g) null));
                net.one97.paytm.recharge.automatic.e.d.a();
                net.one97.paytm.recharge.automatic.e.d.a(bVar2);
            }
        }

        public static final class a implements net.one97.paytm.recharge.widgets.b.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ z f60199a;

            a(z zVar) {
                this.f60199a = zVar;
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                z zVar = this.f60199a;
                if (iJRPaytmDataModel != null) {
                    zVar.onSuccess((CJRAutomaticBillCategoriesResponse) iJRPaytmDataModel);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRAutomaticBillCategoriesResponse");
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (networkCustomError != null) {
                    this.f60199a.tryOnError(networkCustomError);
                }
            }
        }
    }

    static final class i<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f60217a;

        i(Context context) {
            this.f60217a = context;
        }

        public final void subscribe(z<CJRAutomaticSubscriptionListModel> zVar) {
            kotlin.g.b.k.a((Object) zVar, "emitter");
            if (!zVar.isDisposed()) {
                net.one97.paytm.recharge.automatic.c.a.b bVar = net.one97.paytm.recharge.automatic.c.a.b.f60258a;
                String d2 = net.one97.paytm.recharge.automatic.c.a.b.d();
                if (!URLUtil.isValidUrl(d2)) {
                    zVar.onSuccess(new CJRAutomaticSubscriptionListModel());
                }
                HashMap<String, String> a2 = com.paytm.utility.b.a((HashMap<String, String>) new HashMap(), this.f60217a);
                kotlin.g.b.k.a((Object) a2, "CJRAppCommonUtility.addS…nHeader(headers, context)");
                net.one97.paytm.recharge.automatic.e.b bVar2 = new net.one97.paytm.recharge.automatic.e.b(com.paytm.utility.b.s(this.f60217a, d2), new a(zVar), new CJRAutomaticSubscriptionListModel(), a2);
                net.one97.paytm.recharge.automatic.e.d.a();
                net.one97.paytm.recharge.automatic.e.d.a(bVar2);
            }
        }

        public static final class a implements net.one97.paytm.recharge.widgets.b.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ z f60218a;

            a(z zVar) {
                this.f60218a = zVar;
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                z zVar = this.f60218a;
                if (iJRPaytmDataModel != null) {
                    zVar.onSuccess((CJRAutomaticSubscriptionListModel) iJRPaytmDataModel);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionListModel");
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (networkCustomError != null) {
                    this.f60218a.tryOnError(networkCustomError);
                }
            }
        }
    }

    static final class c<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f60195a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f60196b;

        c(Context context, String str) {
            this.f60195a = context;
            this.f60196b = str;
        }

        public final void subscribe(z<CJRCreateSubscriptionApiResponse> zVar) {
            z<CJRCreateSubscriptionApiResponse> zVar2 = zVar;
            kotlin.g.b.k.a((Object) zVar2, "emitter");
            if (!zVar.isDisposed()) {
                net.one97.paytm.recharge.automatic.c.a.b bVar = net.one97.paytm.recharge.automatic.c.a.b.f60258a;
                String s = com.paytm.utility.b.s(this.f60195a, net.one97.paytm.recharge.automatic.c.a.b.f());
                Map hashMap = new HashMap();
                String a2 = com.paytm.utility.d.a(this.f60195a);
                kotlin.g.b.k.a((Object) a2, "CJRNetUtility.getSSOToken(context)");
                hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, a2);
                net.one97.paytm.recharge.automatic.e.c cVar = new net.one97.paytm.recharge.automatic.e.c(s, new a(zVar2), new CJRCreateSubscriptionApiResponse((String) null, (String) null, (Long) null, (String) null, (Long) null, (String) null, (CJRNativeWithDrawDetails) null, 127, (kotlin.g.b.g) null), hashMap, this.f60196b);
                net.one97.paytm.recharge.automatic.e.d.a();
                net.one97.paytm.recharge.automatic.e.d.a(cVar);
            }
        }

        public static final class a implements net.one97.paytm.recharge.widgets.b.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ z f60197a;

            a(z zVar) {
                this.f60197a = zVar;
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                z zVar = this.f60197a;
                if (iJRPaytmDataModel != null) {
                    zVar.onSuccess((CJRCreateSubscriptionApiResponse) iJRPaytmDataModel);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRCreateSubscriptionApiResponse");
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (networkCustomError != null) {
                    this.f60197a.tryOnError(networkCustomError);
                }
            }
        }
    }

    static final class g<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f60210a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f60211b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f60212c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f60213d;

        g(String str, String str2, Context context, String str3) {
            this.f60210a = str;
            this.f60211b = str2;
            this.f60212c = context;
            this.f60213d = str3;
        }

        public final void subscribe(z<CJRPaymentOptionResponse> zVar) {
            kotlin.g.b.k.a((Object) zVar, "emitter");
            if (!zVar.isDisposed()) {
                net.one97.paytm.recharge.automatic.c.a.b bVar = net.one97.paytm.recharge.automatic.c.a.b.f60258a;
                String g2 = net.one97.paytm.recharge.automatic.c.a.b.g();
                String s = com.paytm.utility.b.s(this.f60212c, g2 + "?mid=" + this.f60210a + "&orderId=" + this.f60211b);
                kotlin.g.b.k.a((Object) s, "CJRAppCommonUtility.addD…sWithoutSSO(context, url)");
                net.one97.paytm.recharge.automatic.e.c cVar = new net.one97.paytm.recharge.automatic.e.c(s, new a(zVar), new CJRPaymentOptionResponse((CJRPaymentOptionBody) null, 1, (kotlin.g.b.g) null), (Map<String, String>) null, this.f60213d);
                net.one97.paytm.recharge.automatic.e.d.a();
                net.one97.paytm.recharge.automatic.e.d.a(cVar);
            }
        }

        public static final class a implements net.one97.paytm.recharge.widgets.b.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ z f60214a;

            a(z zVar) {
                this.f60214a = zVar;
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                z zVar = this.f60214a;
                if (iJRPaytmDataModel != null) {
                    zVar.onSuccess((CJRPaymentOptionResponse) iJRPaytmDataModel);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRPaymentOptionResponse");
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (networkCustomError != null) {
                    this.f60214a.tryOnError(networkCustomError);
                }
            }
        }
    }

    static final class f<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f60204a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f60205b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f60206c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ HashMap f60207d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ JSONObject f60208e;

        f(String str, String str2, Context context, HashMap hashMap, JSONObject jSONObject) {
            this.f60204a = str;
            this.f60205b = str2;
            this.f60206c = context;
            this.f60207d = hashMap;
            this.f60208e = jSONObject;
        }

        public final void subscribe(z<CJRTaggedObservable<CJRFetchBalanceResponse>> zVar) {
            kotlin.g.b.k.a((Object) zVar, "emitter");
            if (!zVar.isDisposed()) {
                StringBuilder sb = new StringBuilder();
                net.one97.paytm.recharge.automatic.c.a.b bVar = net.one97.paytm.recharge.automatic.c.a.b.f60258a;
                sb.append(net.one97.paytm.recharge.automatic.c.a.b.k());
                sb.append("?mid=");
                sb.append(this.f60204a);
                sb.append("&orderId=");
                sb.append(this.f60205b);
                String s = com.paytm.utility.b.s(this.f60206c, sb.toString());
                kotlin.g.b.k.a((Object) s, "CJRAppCommonUtility.addD…sWithoutSSO(context, url)");
                net.one97.paytm.recharge.automatic.e.c cVar = new net.one97.paytm.recharge.automatic.e.c(s, new a(zVar), new CJRFetchBalanceResponse(), this.f60207d, this.f60208e.toString());
                net.one97.paytm.recharge.automatic.e.d.a();
                net.one97.paytm.recharge.automatic.e.d.a(cVar);
            }
        }

        public static final class a implements net.one97.paytm.recharge.widgets.b.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ z f60209a;

            a(z zVar) {
                this.f60209a = zVar;
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                z zVar = this.f60209a;
                if (iJRPaytmDataModel != null) {
                    zVar.onSuccess(new CJRTaggedObservable("tag.get.ppbl.balance", (CJRFetchBalanceResponse) iJRPaytmDataModel));
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRFetchBalanceResponse");
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (networkCustomError != null) {
                    this.f60209a.tryOnError(networkCustomError);
                }
            }
        }
    }

    static final class a<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Long f60188a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Integer f60189b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f60190c;

        a(Long l, Integer num, Context context) {
            this.f60188a = l;
            this.f60189b = num;
            this.f60190c = context;
        }

        public final void subscribe(z<CJRAutomaticSubscriptionCheckModel> zVar) {
            kotlin.g.b.k.a((Object) zVar, "emitter");
            if (!zVar.isDisposed()) {
                net.one97.paytm.recharge.automatic.c.a.b bVar = net.one97.paytm.recharge.automatic.c.a.b.f60258a;
                String str = (net.one97.paytm.recharge.automatic.c.a.b.a() + "?order_id=" + this.f60188a) + "&status=" + this.f60189b;
                if (!URLUtil.isValidUrl(str)) {
                    zVar.onSuccess(new CJRAutomaticSubscriptionCheckModel());
                }
                String s = com.paytm.utility.b.s(this.f60190c, str);
                Map hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                String a2 = com.paytm.utility.d.a(this.f60190c);
                kotlin.g.b.k.a((Object) a2, "CJRNetUtility.getSSOToken(context)");
                hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, a2);
                net.one97.paytm.recharge.automatic.e.c cVar = new net.one97.paytm.recharge.automatic.e.c(s, new C1158a(zVar), new CJRAutomaticSubscriptionCheckModel(), hashMap, (String) null);
                net.one97.paytm.recharge.automatic.e.d.a();
                net.one97.paytm.recharge.automatic.e.d.a(cVar);
            }
        }

        /* renamed from: net.one97.paytm.recharge.a.a.b$a$a  reason: collision with other inner class name */
        public static final class C1158a implements net.one97.paytm.recharge.widgets.b.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ z f60191a;

            C1158a(z zVar) {
                this.f60191a = zVar;
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                z zVar = this.f60191a;
                if (iJRPaytmDataModel != null) {
                    zVar.onSuccess((CJRAutomaticSubscriptionCheckModel) iJRPaytmDataModel);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel");
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (networkCustomError != null) {
                    this.f60191a.tryOnError(networkCustomError);
                }
            }
        }
    }

    public static final class k<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f60221a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f60222b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f60223c;

        public k(Context context, String str, String str2) {
            this.f60221a = context;
            this.f60222b = str;
            this.f60223c = str2;
        }

        public final void subscribe(z<CJRAutomaticEditBillNameResponse> zVar) {
            kotlin.g.b.k.a((Object) zVar, "emitter");
            if (!zVar.isDisposed()) {
                net.one97.paytm.recharge.automatic.c.a.b bVar = net.one97.paytm.recharge.automatic.c.a.b.f60258a;
                String s = com.paytm.utility.b.s(this.f60221a, net.one97.paytm.recharge.automatic.c.a.b.n());
                kotlin.g.b.k.a((Object) s, "CJRAppCommonUtility.addD…sWithoutSSO(context, url)");
                Map hashMap = new HashMap();
                String a2 = com.paytm.utility.d.a(this.f60221a);
                kotlin.g.b.k.a((Object) a2, "CJRNetUtility.getSSOToken(context)");
                hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, a2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(UpiConstants.EXTRA_SUBSCRIPTION_ID, this.f60222b);
                jSONObject.put("nickname", this.f60223c);
                jSONObject.put("customer_id", com.paytm.utility.b.n(this.f60221a));
                net.one97.paytm.recharge.automatic.e.c cVar = new net.one97.paytm.recharge.automatic.e.c(s, new a(zVar), new CJRAutomaticEditBillNameResponse(0, (String) null, (Integer) null, 7, (kotlin.g.b.g) null), hashMap, jSONObject.toString());
                net.one97.paytm.recharge.automatic.e.d.a();
                net.one97.paytm.recharge.automatic.e.d.a(cVar);
            }
        }

        public static final class a implements net.one97.paytm.recharge.widgets.b.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ z f60224a;

            a(z zVar) {
                this.f60224a = zVar;
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                z zVar = this.f60224a;
                if (iJRPaytmDataModel != null) {
                    zVar.onSuccess((CJRAutomaticEditBillNameResponse) iJRPaytmDataModel);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRAutomaticEditBillNameResponse");
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (networkCustomError != null) {
                    this.f60224a.tryOnError(networkCustomError);
                }
            }
        }
    }
}
