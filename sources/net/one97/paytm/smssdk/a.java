package net.one97.paytm.smssdk;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.smssdk.model.ConsentStatus;
import net.one97.paytm.smssdk.model.ConsentStatusResponse;
import net.one97.paytm.smssdk.model.SmsDataUploadResponse;
import net.one97.paytm.smssdk.model.StatusInfo;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f65042a = new a();

    private a() {
    }

    public static com.paytm.network.a a(Context context, b bVar, List<String> list, String str) {
        k.c(context, "context");
        k.c(bVar, "responseHandler");
        k.c(list, "consentKeys");
        k.c(str, "requestId");
        StringBuilder sb = new StringBuilder();
        b bVar2 = b.f65064b;
        sb.append(b.a().f65046c);
        sb.append("?preferenceKeys=");
        sb.append(kotlin.a.k.a((Iterable) list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 63));
        String sb2 = sb.toString();
        HashMap hashMap = new HashMap();
        a(hashMap);
        Map map = hashMap;
        String Q = com.paytm.utility.b.Q(context);
        k.a((Object) Q, "CJRAppCommonUtility.getAppVersionName(context)");
        map.put("appVersion", Q);
        String A = com.paytm.utility.b.A(context);
        k.a((Object) A, "CJRAppCommonUtility.getDeviceID(context)");
        map.put("deviceId", A);
        map.put("requestId", str);
        HashMap hashMap2 = new HashMap();
        com.paytm.network.b a2 = a(context, sb2, bVar, new ConsentStatus((String) null, (ConsentStatusResponse) null, (StatusInfo) null, 7, (g) null), map);
        a2.a(a.C0715a.GET);
        a2.a(false);
        a2.a(false);
        a2.b((Map) hashMap2);
        return a2.l();
    }

    public static com.paytm.network.a a(Context context, b bVar, String str) {
        k.c(context, "context");
        k.c(bVar, "responseHandler");
        k.c(str, "body");
        b bVar2 = b.f65064b;
        String str2 = b.a().f65047d;
        if (str2 == null) {
            k.a();
        }
        HashMap hashMap = new HashMap();
        a(hashMap);
        Map map = hashMap;
        b bVar3 = b.f65064b;
        String c2 = b.c();
        if (c2 == null) {
            k.a();
        }
        map.put("x-user-id", c2);
        map.put("Content-Type", "application/json");
        com.paytm.network.b a2 = a(context, str2, bVar, new SmsDataUploadResponse("test"), map);
        a2.a(a.C0715a.POST);
        a2.b((Map) new HashMap());
        a2.b(str);
        a2.a(false);
        a2.j();
        return a2.l();
    }

    public static com.paytm.network.b a(Context context, String str, b bVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map) {
        k.c(context, "context");
        k.c(str, "url");
        k.c(bVar, "listener");
        k.c(iJRPaytmDataModel, "model");
        k.c(map, "headers");
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.a(context);
        bVar2.a(str);
        bVar2.a(map);
        bVar2.a(iJRPaytmDataModel);
        bVar2.a(a.b.USER_FACING);
        bVar2.a(bVar);
        bVar2.c("SmsSdk");
        com.paytm.network.b a2 = bVar2.a(a.c.SMS);
        k.a((Object) a2, "setVerticalId(CJRCommonNetworkCall.VerticalId.SMS)");
        k.a((Object) a2, "with(CJRCommonNetworkCal…VerticalId.SMS)\n        }");
        return a2;
    }

    public static void a(HashMap<String, String> hashMap) {
        Map map = hashMap;
        b bVar = b.f65064b;
        String b2 = b.b();
        if (b2 == null) {
            k.a();
        }
        map.put("sso-token", b2);
    }
}
