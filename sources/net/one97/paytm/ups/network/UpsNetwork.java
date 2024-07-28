package net.one97.paytm.ups.network;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.ups.network.model.consent.ConsentStatus;
import net.one97.paytm.ups.network.model.consent.ConsentStatusResponse;
import net.one97.paytm.ups.network.model.consent.ConsentUpdateResponse;
import net.one97.paytm.ups.network.model.consent.Response;
import net.one97.paytm.ups.network.model.consent.StatusInfo;
import net.one97.paytm.ups.sdk.UpsSdkInterface;

public final class UpsNetwork implements UpsNetworkHelper {
    public static final UpsNetwork INSTANCE = new UpsNetwork();
    /* access modifiers changed from: private */
    public static UpsSdkInterface upsSdkInterface;

    private UpsNetwork() {
    }

    public static final /* synthetic */ UpsSdkInterface access$getUpsSdkInterface$p(UpsNetwork upsNetwork) {
        UpsSdkInterface upsSdkInterface2 = upsSdkInterface;
        if (upsSdkInterface2 == null) {
            k.a("upsSdkInterface");
        }
        return upsSdkInterface2;
    }

    public final boolean initUpsSdkHelper(UpsSdkInterface upsSdkInterface2) {
        if (upsSdkInterface2 != null) {
            upsSdkInterface = upsSdkInterface2;
            return true;
        }
        throw new NullPointerException("UpsSdkInterface is NULL.");
    }

    public final a putConsentNetworkCall(Context context, b bVar, String str, String str2) {
        k.c(context, "context");
        k.c(bVar, "responseHandler");
        k.c(str, "body");
        k.c(str2, "requestId");
        UpsSdkInterface upsSdkInterface2 = upsSdkInterface;
        if (upsSdkInterface2 != null) {
            if (upsSdkInterface2 == null) {
                k.a("upsSdkInterface");
            }
            if (!upsSdkInterface2.isLoggedIn()) {
                return null;
            }
            return putConsentNetworkCallInternal(context, bVar, str, str2);
        }
        throw new NullPointerException("UpsSdkInterface is NULL.");
    }

    private final a putConsentNetworkCallInternal(Context context, b bVar, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        UpsSdkInterface upsSdkInterface2 = upsSdkInterface;
        if (upsSdkInterface2 == null) {
            k.a("upsSdkInterface");
        }
        sb.append(upsSdkInterface2.getProvider().getUpsSdkURL());
        sb.append("/ups/v1/user-preferences");
        String sb2 = sb.toString();
        Map hashMap = new HashMap();
        UpsSdkInterface upsSdkInterface3 = upsSdkInterface;
        if (upsSdkInterface3 == null) {
            k.a("upsSdkInterface");
        }
        String sSOToken = upsSdkInterface3.getSSOToken();
        if (sSOToken == null) {
            k.a();
        }
        hashMap.put("sso-token", sSOToken);
        UpsSdkInterface upsSdkInterface4 = upsSdkInterface;
        if (upsSdkInterface4 == null) {
            k.a("upsSdkInterface");
        }
        hashMap.put("appVersion", upsSdkInterface4.getProvider().getAppVersion());
        UpsSdkInterface upsSdkInterface5 = upsSdkInterface;
        if (upsSdkInterface5 == null) {
            k.a("upsSdkInterface");
        }
        hashMap.put("deviceId", upsSdkInterface5.getProvider().getDeviceId());
        hashMap.put("requestId", str2);
        hashMap.put("Content-Type", "application/json");
        com.paytm.network.b networkCallBuilder = getNetworkCallBuilder(context, sb2, bVar, new ConsentUpdateResponse((String) null, (Response) null, (StatusInfo) null, 7, (g) null), hashMap);
        networkCallBuilder.f42879c = a.C0715a.PUT;
        networkCallBuilder.f42883g = new HashMap();
        networkCallBuilder.f42884h = str;
        networkCallBuilder.k = false;
        networkCallBuilder.y = false;
        return networkCallBuilder.l();
    }

    public final a getConsentNetworkCall(Context context, b bVar, List<String> list, String str) {
        k.c(context, "context");
        k.c(bVar, "responseHandler");
        k.c(list, "consentKeys");
        k.c(str, "requestId");
        UpsSdkInterface upsSdkInterface2 = upsSdkInterface;
        if (upsSdkInterface2 != null) {
            if (upsSdkInterface2 == null) {
                k.a("upsSdkInterface");
            }
            if (!upsSdkInterface2.isLoggedIn()) {
                return null;
            }
            return getConsentNetworkCallInternal(context, bVar, list, str);
        }
        throw new NullPointerException("UpsSdkInterface is NULL.");
    }

    private final a getConsentNetworkCallInternal(Context context, b bVar, List<String> list, String str) {
        StringBuilder sb = new StringBuilder();
        UpsSdkInterface upsSdkInterface2 = upsSdkInterface;
        if (upsSdkInterface2 == null) {
            k.a("upsSdkInterface");
        }
        sb.append(upsSdkInterface2.getProvider().getUpsSdkURL());
        sb.append("/ups/v1/user-preferences");
        String str2 = sb.toString() + "?preferenceKeys=" + kotlin.a.k.a((Iterable) list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 63);
        Map hashMap = new HashMap();
        UpsSdkInterface upsSdkInterface3 = upsSdkInterface;
        if (upsSdkInterface3 == null) {
            k.a("upsSdkInterface");
        }
        String sSOToken = upsSdkInterface3.getSSOToken();
        if (sSOToken == null) {
            k.a();
        }
        hashMap.put("sso-token", sSOToken);
        UpsSdkInterface upsSdkInterface4 = upsSdkInterface;
        if (upsSdkInterface4 == null) {
            k.a("upsSdkInterface");
        }
        hashMap.put("appVersion", upsSdkInterface4.getProvider().getAppVersion());
        UpsSdkInterface upsSdkInterface5 = upsSdkInterface;
        if (upsSdkInterface5 == null) {
            k.a("upsSdkInterface");
        }
        hashMap.put("deviceId", upsSdkInterface5.getProvider().getDeviceId());
        hashMap.put("requestId", str);
        HashMap hashMap2 = new HashMap();
        com.paytm.network.b networkCallBuilder = getNetworkCallBuilder(context, str2, bVar, new ConsentStatus((String) null, (ConsentStatusResponse) null, (StatusInfo) null, 7, (g) null), hashMap);
        networkCallBuilder.f42879c = a.C0715a.GET;
        networkCallBuilder.k = false;
        networkCallBuilder.y = false;
        networkCallBuilder.k = false;
        networkCallBuilder.f42883g = hashMap2;
        return networkCallBuilder.l();
    }

    private final com.paytm.network.b getNetworkCallBuilder(Context context, String str, b bVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map) {
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = context;
        bVar2.f42880d = str;
        bVar2.f42882f = map;
        bVar2.f42885i = iJRPaytmDataModel;
        bVar2.n = a.b.USER_FACING;
        bVar2.j = bVar;
        bVar2.o = "UpsSdk";
        bVar2.f42878b = a.c.SMS;
        k.a((Object) bVar2, "setVerticalId(CJRCommonNetworkCall.VerticalId.SMS)");
        k.a((Object) bVar2, "with(CJRCommonNetworkCal…VerticalId.SMS)\n        }");
        return bVar2;
    }
}
