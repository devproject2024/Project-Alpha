package net.one97.paytm.wallet.rateMerchant.b;

import android.content.Context;
import android.webkit.URLUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m;
import kotlin.m.p;
import kotlin.o;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.wallet.rateMerchant.a.a;
import net.one97.paytm.wallet.rateMerchant.b.b;
import net.one97.paytm.wallet.rateMerchant.entity.MerchantFollowResponse;
import net.one97.paytm.wallet.rateMerchant.entity.MerchantPPReviewData;
import net.one97.paytm.wallet.rateMerchant.entity.MerchantPPReviewResponse;
import net.one97.paytm.wallet.rateMerchant.entity.QnARequestBody;
import net.one97.paytm.wallet.rateMerchant.entity.RatingResponse;
import net.one97.paytm.wallet.rateMerchant.entity.ReviewQuestionData;
import net.one97.paytm.wallet.rateMerchant.entity.ReviewQuestionResponse;
import org.json.JSONObject;

public final class d implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f71644a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static d f71645e;

    /* renamed from: b  reason: collision with root package name */
    private final Context f71646b;

    /* renamed from: c  reason: collision with root package name */
    private final b f71647c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final a f71648d;

    static final class b<I, O> implements androidx.arch.core.c.a<X, Y> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f71649a;

        b(d dVar) {
            this.f71649a = dVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            String str;
            net.one97.paytm.wallet.rateMerchant.a.a aVar = (net.one97.paytm.wallet.rateMerchant.a.a) obj;
            int i2 = e.f71657b[aVar.f71611a.ordinal()];
            if (i2 == 1) {
                MerchantFollowResponse merchantFollowResponse = (MerchantFollowResponse) aVar.f71612b;
                if (merchantFollowResponse == null || !p.a("success", merchantFollowResponse.getStatusMsg(), true)) {
                    a.C1455a aVar2 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                    if (merchantFollowResponse == null || (str = merchantFollowResponse.getStatusMsg()) == null) {
                        str = "Parsing Error";
                    }
                    return a.C1455a.a(new NetworkCustomError(str), false);
                }
                a.C1455a aVar3 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                String statusMsg = merchantFollowResponse.getStatusMsg();
                if (statusMsg == null) {
                    k.a();
                }
                return a.C1455a.a((Object) statusMsg);
            } else if (i2 == 2) {
                a.C1455a aVar4 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                return a.C1455a.a(aVar.f71613c, false);
            } else if (i2 == 3) {
                a.C1455a aVar5 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                return a.C1455a.a(false);
            } else {
                throw new m();
            }
        }
    }

    static final class c<I, O> implements androidx.arch.core.c.a<X, Y> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f71650a;

        c(d dVar) {
            this.f71650a = dVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            net.one97.paytm.wallet.rateMerchant.a.a aVar = (net.one97.paytm.wallet.rateMerchant.a.a) obj;
            int i2 = e.f71656a[aVar.f71611a.ordinal()];
            if (i2 == 1) {
                MerchantPPReviewResponse merchantPPReviewResponse = (MerchantPPReviewResponse) aVar.f71612b;
                MerchantPPReviewData data = merchantPPReviewResponse != null ? merchantPPReviewResponse.getData() : null;
                if (data == null) {
                    return net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                }
                this.f71650a.f71648d.f71631b = data;
                a.C1455a aVar2 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                return a.C1455a.a((Object) data);
            } else if (i2 == 2) {
                a.C1455a aVar3 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                return a.C1455a.a(aVar.f71613c, false);
            } else if (i2 == 3) {
                a.C1455a aVar4 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                return a.C1455a.a(aVar.f71614d);
            } else {
                throw new m();
            }
        }
    }

    /* renamed from: net.one97.paytm.wallet.rateMerchant.b.d$d  reason: collision with other inner class name */
    static final class C1459d<I, O> implements androidx.arch.core.c.a<X, Y> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f71651a;

        C1459d(float f2) {
            this.f71651a = f2;
        }

        public final /* synthetic */ Object apply(Object obj) {
            net.one97.paytm.wallet.rateMerchant.a.a aVar = (net.one97.paytm.wallet.rateMerchant.a.a) obj;
            int i2 = e.f71659d[aVar.f71611a.ordinal()];
            if (i2 == 1) {
                RatingResponse ratingResponse = (RatingResponse) aVar.f71612b;
                if (ratingResponse != null) {
                    Integer code = ratingResponse.getCode();
                    if (code != null && 200 == code.intValue()) {
                        a.C1455a aVar2 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                        return a.C1455a.a((Object) new o(Float.valueOf(this.f71651a), Boolean.TRUE));
                    }
                    a.C1455a aVar3 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                    return a.C1455a.a((Object) new o(Float.valueOf(this.f71651a), Boolean.FALSE));
                }
                a.C1455a aVar4 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                return a.C1455a.a((Object) new o(Float.valueOf(this.f71651a), Boolean.FALSE));
            } else if (i2 == 2) {
                a.C1455a aVar5 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                return a.C1455a.a(aVar.f71613c, false);
            } else if (i2 == 3) {
                a.C1455a aVar6 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                return a.C1455a.a(false);
            } else {
                throw new m();
            }
        }
    }

    static final class e<I, O> implements androidx.arch.core.c.a<X, Y> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f71652a = new e();

        e() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            net.one97.paytm.wallet.rateMerchant.a.a aVar = (net.one97.paytm.wallet.rateMerchant.a.a) obj;
            int i2 = e.f71658c[aVar.f71611a.ordinal()];
            if (i2 == 1) {
                RatingResponse ratingResponse = (RatingResponse) aVar.f71612b;
                if (ratingResponse != null) {
                    Integer code = ratingResponse.getCode();
                    if (code != null && 200 == code.intValue()) {
                        a.C1455a aVar2 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                        return a.C1455a.a((Object) Boolean.TRUE);
                    }
                    a.C1455a aVar3 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                    return a.C1455a.a((Object) Boolean.FALSE);
                }
                a.C1455a aVar4 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                return a.C1455a.a((Object) Boolean.FALSE);
            } else if (i2 == 2) {
                a.C1455a aVar5 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                return a.C1455a.a(aVar.f71613c, false);
            } else if (i2 == 3) {
                a.C1455a aVar6 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                return a.C1455a.a(false);
            } else {
                throw new m();
            }
        }
    }

    public d(Context context, b bVar, a aVar) {
        k.c(context, "appContext");
        k.c(bVar, "channelsRemoteRepository");
        k.c(aVar, "channelsLocalRepository");
        this.f71646b = context;
        this.f71647c = bVar;
        this.f71648d = aVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static c a(Context context, b bVar, a aVar) {
            k.c(context, "appContext");
            k.c(bVar, "channelsRemoteRepository");
            k.c(aVar, "channelsLocalRepository");
            if (d.f71645e == null) {
                d.f71645e = new d(context, bVar, aVar);
            }
            d c2 = d.f71645e;
            if (c2 == null) {
                k.a();
            }
            return c2;
        }
    }

    public final LiveData<net.one97.paytm.wallet.rateMerchant.a.a<MerchantPPReviewData>> a(String str) {
        k.c(str, SDKConstants.KEY_MERCHANT_ID);
        b bVar = this.f71647c;
        k.c(str, SDKConstants.KEY_MERCHANT_ID);
        y yVar = new y();
        a.C1455a aVar = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
        yVar.setValue(a.C1455a.a(false));
        String str2 = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(bVar.f71636a, "channels_merchant_url") + "/rnr?pgMid=" + str;
        if (!URLUtil.isValidUrl(str2)) {
            a.C1455a aVar2 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
            yVar.setValue(a.C1455a.a(b.b(), false));
        } else {
            com.paytm.network.a l = bVar.a().a(bVar.f71636a).a(a.C0715a.GET).a(bVar.a(bVar.f71636a)).a((IJRPaytmDataModel) new MerchantPPReviewResponse((net.one97.paytm.wallet.rateMerchant.entity.b) null, (MerchantPPReviewData) null, 3, (g) null)).a(str2).c("channels/payment-success").a((com.paytm.network.listener.b) new b.c(yVar)).l();
            if (com.paytm.utility.b.c(bVar.f71636a)) {
                l.a();
            } else {
                a.C1455a aVar3 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                yVar.setValue(a.C1455a.a(b.a("600"), false));
            }
        }
        LiveData<net.one97.paytm.wallet.rateMerchant.a.a<MerchantPPReviewData>> a2 = ah.a(yVar, new c(this));
        k.a((Object) a2, "Transformations.map(remo…}\n            }\n        }");
        return a2;
    }

    public final MerchantPPReviewData a() {
        return this.f71648d.f71631b;
    }

    public final LiveData<net.one97.paytm.wallet.rateMerchant.a.a<String>> a(String str, boolean z, String str2) {
        k.c(str, "contractId");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        b bVar = this.f71647c;
        k.c(str, SDKConstants.KEY_MERCHANT_ID);
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        y yVar = new y();
        a.C1455a aVar = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
        yVar.setValue(a.C1455a.a(false));
        String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(bVar.f71636a, "channels_merchant_relation_url");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            a.C1455a aVar2 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
            yVar.setValue(a.C1455a.a(b.b(), false));
        } else {
            com.paytm.network.b a2 = bVar.a().a(bVar.f71636a).a(a.C0715a.POST).a(bVar.a(bVar.f71636a)).a((IJRPaytmDataModel) new MerchantFollowResponse((String) null, (String) null, 3, (g) null)).a(stringFromGTM);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("contractId", str);
            jSONObject.put("follow", z ? 1 : 0);
            String jSONObject2 = jSONObject.toString();
            k.a((Object) jSONObject2, "requestJson.toString()");
            com.paytm.network.a l = a2.b(jSONObject2).c(str2).a((com.paytm.network.listener.b) new b.C1458b(yVar)).l();
            if (com.paytm.utility.b.c(bVar.f71636a)) {
                l.a();
            } else {
                a.C1455a aVar3 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                yVar.setValue(a.C1455a.a(b.a("600"), false));
            }
        }
        LiveData<net.one97.paytm.wallet.rateMerchant.a.a<String>> a3 = ah.a(yVar, new b(this));
        k.a((Object) a3, "Transformations.map(remo…}\n            }\n        }");
        return a3;
    }

    public final LiveData<net.one97.paytm.wallet.rateMerchant.a.a<Boolean>> a(String str, String str2, String str3, float f2, String str4, String str5) {
        k.c(str, SDKConstants.KEY_MERCHANT_ID);
        k.c(str2, "clientId");
        k.c(str3, "clientSecret");
        k.c(str5, SDKConstants.EVENT_KEY_SCREEN_NAME);
        LiveData<net.one97.paytm.wallet.rateMerchant.a.a<Boolean>> a2 = ah.a(this.f71647c.a(str, str2, str3, f2, str4, str5), e.f71652a);
        k.a((Object) a2, "Transformations.map(remo…}\n            }\n        }");
        return a2;
    }

    public final LiveData<net.one97.paytm.wallet.rateMerchant.a.a<ReviewQuestionResponse>> a(QnARequestBody qnARequestBody) {
        k.c(qnARequestBody, "qnaRequestBody");
        b bVar = this.f71647c;
        k.c(qnARequestBody, "qnaRequestBody");
        y yVar = new y();
        String str = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(bVar.f71636a, "channels_merchant_url") + "/qa";
        a.C1455a aVar = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
        yVar.setValue(a.C1455a.a(false));
        if (!URLUtil.isValidUrl(str)) {
            a.C1455a aVar2 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
            yVar.setValue(a.C1455a.a(b.b(), false));
        } else {
            com.paytm.network.b a2 = bVar.a().a(bVar.f71636a).a(a.C0715a.POST).a(bVar.a(bVar.f71636a)).a((IJRPaytmDataModel) new ReviewQuestionResponse((net.one97.paytm.wallet.rateMerchant.entity.b) null, (ReviewQuestionData) null, 3, (g) null)).a(str);
            String a3 = new f().a((Object) qnARequestBody);
            k.a((Object) a3, "gson.toJson(qnaRequestBody)");
            com.paytm.network.a l = a2.b(a3).c("channels/payment-success").a((com.paytm.network.listener.b) new b.d(yVar)).l();
            if (com.paytm.utility.b.c(bVar.f71636a)) {
                l.a();
            } else {
                a.C1455a aVar3 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                yVar.setValue(a.C1455a.a(b.a("600"), false));
            }
        }
        return yVar;
    }

    public final LiveData<net.one97.paytm.wallet.rateMerchant.a.a<o<Float, Boolean>>> a(String str, String str2, String str3, float f2, String str4) {
        k.c(str, SDKConstants.KEY_MERCHANT_ID);
        k.c(str2, "clientId");
        k.c(str3, "clientSecret");
        k.c(str4, SDKConstants.EVENT_KEY_SCREEN_NAME);
        LiveData<net.one97.paytm.wallet.rateMerchant.a.a<o<Float, Boolean>>> a2 = ah.a(this.f71647c.a(str, str2, str3, f2, "", str4), new C1459d(f2));
        k.a((Object) a2, "Transformations.map(remo…}\n            }\n        }");
        return a2;
    }

    public final o<String, String> b() {
        return this.f71648d.f71630a;
    }
}
