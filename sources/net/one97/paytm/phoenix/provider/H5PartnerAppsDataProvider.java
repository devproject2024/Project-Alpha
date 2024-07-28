package net.one97.paytm.phoenix.provider;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.paytm.network.a;
import com.paytm.utility.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.b.d;
import net.one97.paytm.h5.model.partner.PartnerHomePageModel;
import net.one97.paytm.j.c;
import net.one97.paytm.l;

public final class H5PartnerAppsDataProvider {
    public static final H5PartnerAppsDataProvider INSTANCE = new H5PartnerAppsDataProvider();
    /* access modifiers changed from: private */
    public static final HashMap<String, MiniAppData> appData = new HashMap<>();
    /* access modifiers changed from: private */
    public static String partnerRawData;

    public interface H5PartnerAppsDataProviderCallback {
        void onAppUrlFetched(String str);

        void onError(String str);
    }

    public interface H5PartnerAppsUrlProviderCallback {
        void onAppUrlFetched(MiniAppData miniAppData);

        void onError(String str);
    }

    public interface StoreFrontDataFetched {
        void onDataFetched();

        void onError(String str);
    }

    private H5PartnerAppsDataProvider() {
    }

    public static final String getAppName(String str) {
        k.c(str, "appId");
        MiniAppData miniAppData = appData.get(str);
        if (miniAppData != null) {
            return miniAppData.getName();
        }
        return null;
    }

    public static final void getPartnerData(Context context, H5PartnerAppsDataProviderCallback h5PartnerAppsDataProviderCallback) {
        x xVar;
        k.c(context, "context");
        INSTANCE.clearData();
        CharSequence charSequence = partnerRawData;
        if (charSequence == null || charSequence.length() == 0) {
            a dataFromStoreFront = INSTANCE.getDataFromStoreFront(context, new H5PartnerAppsDataProvider$getPartnerData$request$1(h5PartnerAppsDataProviderCallback));
            if (dataFromStoreFront != null) {
                if (b.c(context)) {
                    dataFromStoreFront.a();
                    xVar = x.f47997a;
                } else if (h5PartnerAppsDataProviderCallback != null) {
                    h5PartnerAppsDataProviderCallback.onError("SR");
                    xVar = x.f47997a;
                } else {
                    xVar = null;
                }
                if (xVar != null) {
                    return;
                }
            }
            if (h5PartnerAppsDataProviderCallback != null) {
                h5PartnerAppsDataProviderCallback.onError("SR");
                x xVar2 = x.f47997a;
            }
        } else if (h5PartnerAppsDataProviderCallback != null) {
            h5PartnerAppsDataProviderCallback.onAppUrlFetched(partnerRawData);
        }
    }

    public static final void getAppUrl(Context context, String str, int i2, H5PartnerAppsUrlProviderCallback h5PartnerAppsUrlProviderCallback) {
        k.c(context, "context");
        k.c(str, "appId");
        INSTANCE.clearData();
        if (appData.get(str) == null || appData.size() == 0) {
            a dataFromStoreFront = INSTANCE.getDataFromStoreFront(context, new H5PartnerAppsDataProvider$getAppUrl$request$1(str, h5PartnerAppsUrlProviderCallback));
            if (dataFromStoreFront != null) {
                if (!b.c(context)) {
                    new Handler(Looper.getMainLooper()).post(new H5PartnerAppsDataProvider$getAppUrl$$inlined$let$lambda$1(dataFromStoreFront, context));
                } else {
                    dataFromStoreFront.a();
                }
            } else if (h5PartnerAppsUrlProviderCallback != null) {
                h5PartnerAppsUrlProviderCallback.onError("SW");
            }
        } else if (h5PartnerAppsUrlProviderCallback != null) {
            h5PartnerAppsUrlProviderCallback.onAppUrlFetched(appData.get(str));
        }
    }

    private final void clearData() {
        l lVar = l.f52428a;
        if (l.b()) {
            appData.clear();
            partnerRawData = null;
        }
    }

    private final a getDataFromStoreFront(Context context, StoreFrontDataFetched storeFrontDataFetched) {
        Context context2 = context;
        StoreFrontDataFetched storeFrontDataFetched2 = storeFrontDataFetched;
        clearData();
        HashMap hashMap = new HashMap();
        b.a((HashMap<String, String>) hashMap, context);
        k.a((Object) c.a(), "GTMLoader.getInstance()");
        String ak = c.ak();
        CharSequence charSequence = ak;
        if (charSequence == null || charSequence.length() == 0) {
            storeFrontDataFetched2.onError("SR");
            return null;
        }
        if (p.c(charSequence, (CharSequence) "?")) {
            int a2 = p.a(charSequence, "?", 0, false, 6);
            if (ak != null) {
                ak = ak.substring(0, a2);
                k.a((Object) ak, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        a a3 = d.a(context, addCustomerIdToUrl(context, ((ak + com.paytm.utility.c.a(context, false)) + "&device=android") + "&resolution=" + b.U(context)), new H5PartnerAppsDataProvider$getDataFromStoreFront$request$1(storeFrontDataFetched2), hashMap, (Map<String, String>) null, a.C0715a.POST, (String) null, new PartnerHomePageModel(), a.c.HOME, a.b.SILENT);
        a3.b(false);
        return a3;
    }

    private final String addCustomerIdToUrl(Context context, String str) {
        StringBuilder sb = new StringBuilder(p.b(str, (CharSequence) "?"));
        if (b.r(context)) {
            if (p.c((CharSequence) sb, (CharSequence) "?")) {
                sb.append(AppConstants.AND_SIGN);
            } else {
                sb.append("?");
            }
            sb.append("customer_id=" + b.n(context));
        }
        String sb2 = sb.toString();
        k.a((Object) sb2, "str.toString()");
        return sb2;
    }
}
