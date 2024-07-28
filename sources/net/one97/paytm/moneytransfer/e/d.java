package net.one97.paytm.moneytransfer.e;

import android.content.Context;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.MoneyTransferValidatePasscode;
import net.one97.paytm.common.entity.moneytransfer.PPBPrevalidateResponseModel;
import net.one97.paytm.moneytransfer.d.c;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.utils.d;
import net.one97.paytm.moneytransfer.utils.l;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    b f54016a;

    public interface a {
        void a();

        void a(NetworkCustomError networkCustomError);

        void a(boolean z);
    }

    public interface b {
        void a();

        void a(NetworkCustomError networkCustomError);

        void a(PPBPrevalidateResponseModel pPBPrevalidateResponseModel);
    }

    public final void a(Context context, b bVar, String str, String str2, String str3) {
        k.c(context, "context");
        k.c(bVar, H5Event.TYPE_CALL_BACK);
        this.f54016a = bVar;
        StringBuilder sb = new StringBuilder();
        c.a aVar = net.one97.paytm.moneytransfer.d.c.C;
        sb.append(net.one97.paytm.moneytransfer.d.c.a(c.a.a().l));
        sb.append("?amount=".concat(String.valueOf(str)));
        sb.append("&ifsc=".concat(String.valueOf(str2)));
        sb.append("&beneficiaryName=" + URLEncoder.encode(str3, AppConstants.UTF_8));
        String sb2 = sb.toString();
        k.a((Object) sb2, "urlBuilder.toString()");
        a(context, sb2);
    }

    public final void b(Context context, b bVar, String str, String str2, String str3) {
        k.c(context, "context");
        k.c(bVar, H5Event.TYPE_CALL_BACK);
        this.f54016a = bVar;
        StringBuilder sb = new StringBuilder();
        c.a aVar = net.one97.paytm.moneytransfer.d.c.C;
        sb.append(net.one97.paytm.moneytransfer.d.c.a(c.a.a().l));
        sb.append("?amount=".concat(String.valueOf(str)));
        sb.append("&ifsc=".concat(String.valueOf(str2)));
        sb.append("&beneficiaryName=" + URLEncoder.encode(str3, AppConstants.UTF_8));
        sb.append("account_type=ica");
        String sb2 = sb.toString();
        k.a((Object) sb2, "urlBuilder.toString()");
        a(context, sb2);
    }

    private final void a(Context context, String str) {
        HashMap<String, String> a2 = a(context);
        d.a aVar = net.one97.paytm.moneytransfer.utils.d.f54161a;
        d.a.a().a((Map<String, String>) a2).a(str).a((IJRPaytmDataModel) new PPBPrevalidateResponseModel("", "", false, false, "", 0)).a((com.paytm.network.listener.b) new C0967d(this)).l().a();
    }

    /* renamed from: net.one97.paytm.moneytransfer.e.d$d  reason: collision with other inner class name */
    public static final class C0967d implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f54020a;

        C0967d(d dVar) {
            this.f54020a = dVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            b bVar;
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof PPBPrevalidateResponseModel) && (bVar = this.f54020a.f54016a) != null) {
                bVar.a((PPBPrevalidateResponseModel) iJRPaytmDataModel);
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            b bVar;
            NetworkResponse networkResponse = null;
            if ((networkCustomError != null ? networkCustomError.networkResponse : null) != null) {
                if (networkCustomError != null) {
                    networkResponse = networkCustomError.networkResponse;
                }
                if (m.a(networkResponse.statusCode)) {
                    b bVar2 = this.f54020a.f54016a;
                    if (bVar2 != null) {
                        bVar2.a();
                        return;
                    }
                    return;
                }
            }
            if (networkCustomError != null && (bVar = this.f54020a.f54016a) != null) {
                bVar.a(networkCustomError);
            }
        }
    }

    public final void a(Context context, String str, a aVar) {
        k.c(context, "context");
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        HashMap hashMap = new HashMap();
        String q = com.paytm.utility.a.q(context);
        if (q == null) {
            q = "";
        }
        Map map = hashMap;
        map.put("Authorization", q);
        map.put("Content-Type", "application/json");
        map.put("client", "ANDROID");
        map.put("User-Agent", UpiConstants.B2C_ANDROID);
        d.a aVar2 = net.one97.paytm.moneytransfer.d.d.f53996a;
        String a2 = k.a(net.one97.paytm.moneytransfer.d.d.b(d.a.a()).a("passcodeExistsURL", "https://oauth.paytmbank.com/bank-oauth/ext/v2/passcode-exists"), (Object) com.paytm.utility.c.a(context, false));
        new HashMap().put("screen_name", str);
        d.a aVar3 = net.one97.paytm.moneytransfer.utils.d.f54161a;
        d.a.a().a((Map<String, String>) map).a(a2).a((IJRPaytmDataModel) new MoneyTransferValidatePasscode()).a((com.paytm.network.listener.b) new c(this, context, aVar)).l().a();
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f54017a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f54018b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a f54019c;

        c(d dVar, Context context, a aVar) {
            this.f54017a = dVar;
            this.f54018b = context;
            this.f54019c = aVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof MoneyTransferValidatePasscode)) {
                MoneyTransferValidatePasscode moneyTransferValidatePasscode = (MoneyTransferValidatePasscode) iJRPaytmDataModel;
                if (moneyTransferValidatePasscode.getResponseCode() == 1100) {
                    Context context = this.f54018b;
                    k.c(context, "context");
                    l.a aVar = l.f54175a;
                    Context applicationContext = context.getApplicationContext();
                    k.a((Object) applicationContext, "context.applicationContext");
                    l.a.a(applicationContext).a("is_passcode_set", true, true);
                    a aVar2 = this.f54019c;
                    if (aVar2 != null) {
                        aVar2.a(true);
                    }
                } else if (moneyTransferValidatePasscode.getResponseCode() == 1101) {
                    a aVar3 = this.f54019c;
                    if (aVar3 != null) {
                        aVar3.a(false);
                    }
                } else {
                    a aVar4 = this.f54019c;
                    if (aVar4 != null) {
                        aVar4.a(false);
                    }
                }
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            a aVar;
            NetworkResponse networkResponse = null;
            if ((networkCustomError != null ? networkCustomError.networkResponse : null) != null) {
                if (networkCustomError != null) {
                    networkResponse = networkCustomError.networkResponse;
                }
                if (m.a(networkResponse.statusCode)) {
                    a aVar2 = this.f54019c;
                    if (aVar2 != null) {
                        aVar2.a();
                        return;
                    }
                    return;
                }
            }
            if (networkCustomError != null && (aVar = this.f54019c) != null) {
                aVar.a(networkCustomError);
            }
        }
    }

    private static HashMap<String, String> a(Context context) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("authorization", "{userToken:" + com.paytm.utility.a.q(context) + "}");
        return hashMap;
    }
}
