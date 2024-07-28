package net.one97.paytm.wallet.rateMerchant.b;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.wallet.rateMerchant.a.a;
import net.one97.paytm.wallet.rateMerchant.entity.MerchantFollowResponse;
import net.one97.paytm.wallet.rateMerchant.entity.MerchantPPReviewResponse;
import net.one97.paytm.wallet.rateMerchant.entity.RatingResponse;
import net.one97.paytm.wallet.rateMerchant.entity.ReviewQuestionResponse;
import org.json.JSONObject;

public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static final a f71634b = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static b f71635c;

    /* renamed from: a  reason: collision with root package name */
    final Context f71636a;

    public b(Context context) {
        k.c(context, "appContext");
        this.f71636a = context;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a(Context context) {
            k.c(context, "appContext");
            if (b.f71635c == null) {
                b.f71635c = new b(context);
            }
            b c2 = b.f71635c;
            if (c2 == null) {
                k.a();
            }
            return c2;
        }
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f71638a;

        c(y yVar) {
            this.f71638a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof MerchantPPReviewResponse) {
                y yVar = this.f71638a;
                a.C1455a aVar = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                yVar.setValue(a.C1455a.a((Object) iJRPaytmDataModel));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            y yVar = this.f71638a;
            a.C1455a aVar = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
            yVar.setValue(a.C1455a.a(networkCustomError, false));
        }
    }

    static NetworkCustomError a(String str) {
        NetworkCustomError networkCustomError = new NetworkCustomError();
        if (k.a((Object) str, (Object) "600")) {
            networkCustomError.mErrorType = NetworkCustomError.ErrorType.NoConnectionError;
        } else {
            networkCustomError.mErrorType = NetworkCustomError.ErrorType.ServerError;
        }
        networkCustomError.setAlertMessage("Network Error");
        return networkCustomError;
    }

    /* access modifiers changed from: package-private */
    public final com.paytm.network.b a() {
        com.paytm.network.b a2 = new com.paytm.network.b().a(this.f71636a).a(a.c.WALLET).a(a.b.SILENT);
        k.a((Object) a2, "networkCallBuilder");
        return a2;
    }

    /* renamed from: net.one97.paytm.wallet.rateMerchant.b.b$b  reason: collision with other inner class name */
    public static final class C1458b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f71637a;

        C1458b(y yVar) {
            this.f71637a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof MerchantFollowResponse) {
                y yVar = this.f71637a;
                a.C1455a aVar = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                yVar.setValue(a.C1455a.a((Object) iJRPaytmDataModel));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            y yVar = this.f71637a;
            a.C1455a aVar = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
            yVar.setValue(a.C1455a.a(networkCustomError, false));
        }
    }

    public final LiveData<net.one97.paytm.wallet.rateMerchant.a.a<RatingResponse>> a(String str, String str2, String str3, float f2, String str4, String str5) {
        k.c(str, SDKConstants.KEY_MERCHANT_ID);
        k.c(str2, "clientId");
        k.c(str3, "clientSecret");
        k.c(str5, SDKConstants.EVENT_KEY_SCREEN_NAME);
        y yVar = new y();
        a.C1455a aVar = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
        yVar.setValue(a.C1455a.a(false));
        String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f71636a, "channels_rate_review_url");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Content-Type", "application/Json");
        linkedHashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.d.a(this.f71636a));
        linkedHashMap.put(ContactsConstant.USER_AGENT, "android");
        linkedHashMap.put("x-client-name", str2);
        linkedHashMap.put("x-client-secret", str3);
        linkedHashMap.put("v", "v2");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("entityIdentifier", str);
        jSONObject.put("ratingValue", (int) f2);
        if (!TextUtils.isEmpty(str4)) {
            jSONObject.put("reviewDescription", str4);
        }
        jSONObject.put("userName", com.paytm.utility.b.j(this.f71636a));
        String jSONObject2 = jSONObject.toString();
        k.a((Object) jSONObject2, "requestJson.toString()");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            a.C1455a aVar2 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
            yVar.setValue(a.C1455a.a(b(), false));
        } else {
            com.paytm.network.a l = a().a(this.f71636a).a(a.C0715a.POST).a((Map<String, String>) linkedHashMap).a((IJRPaytmDataModel) new RatingResponse((Integer) null, (String) null, 3, (g) null)).a(stringFromGTM).b(jSONObject2).c(str5).a((com.paytm.network.listener.b) new e(yVar)).l();
            if (com.paytm.utility.b.c(this.f71636a)) {
                l.a();
            } else {
                a.C1455a aVar3 = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                yVar.setValue(a.C1455a.a(a("600"), false));
            }
        }
        return yVar;
    }

    public static final class e implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f71640a;

        e(y yVar) {
            this.f71640a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof RatingResponse) {
                y yVar = this.f71640a;
                a.C1455a aVar = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                yVar.setValue(a.C1455a.a((Object) iJRPaytmDataModel));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            y yVar = this.f71640a;
            a.C1455a aVar = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
            yVar.setValue(a.C1455a.a(networkCustomError, false));
        }
    }

    public static final class d implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f71639a;

        d(y yVar) {
            this.f71639a = yVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof ReviewQuestionResponse) {
                y yVar = this.f71639a;
                a.C1455a aVar = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
                yVar.setValue(a.C1455a.a((Object) iJRPaytmDataModel));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            y yVar = this.f71639a;
            a.C1455a aVar = net.one97.paytm.wallet.rateMerchant.a.a.f71610e;
            yVar.setValue(a.C1455a.a(networkCustomError, false));
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> a(Context context) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept", "application/json");
        hashMap.put("session_token", com.paytm.utility.d.a(context));
        hashMap.put("v", "v2");
        String s = com.paytm.utility.b.s(this.f71636a);
        Double d2 = null;
        Double b2 = s != null ? p.b(s) : null;
        String t = com.paytm.utility.b.t(this.f71636a);
        if (t != null) {
            d2 = p.b(t);
        }
        if (b2 != null) {
            hashMap.put("lat", String.valueOf(b2.doubleValue()));
        } else {
            hashMap.put("lat", "0.0");
        }
        if (d2 != null) {
            hashMap.put("lon", String.valueOf(d2.doubleValue()));
        } else {
            hashMap.put("lon", "0.0");
        }
        return hashMap;
    }

    static NetworkCustomError b() {
        return new NetworkCustomError("Url is null");
    }
}
