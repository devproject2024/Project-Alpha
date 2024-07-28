package com.appsflyer.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.alipay.mobile.h5container.api.H5Param;
import com.appsflyer.AFDeepLinkManager;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.OneLinkHttpTask;
import com.appsflyer.ServerConfigHandler;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab extends OneLinkHttpTask {

    /* renamed from: Ι  reason: contains not printable characters */
    private static List<String> f163 = Arrays.asList(new String[]{"onelink.me", "onelnk.com", "app.aflink.com"});

    /* renamed from: ı  reason: contains not printable characters */
    private String f164;

    /* renamed from: ǃ  reason: contains not printable characters */
    private String f165;

    /* renamed from: ι  reason: contains not printable characters */
    public b f166;

    public interface b {
        /* renamed from: ı  reason: contains not printable characters */
        void m121(String str);

        /* renamed from: ɩ  reason: contains not printable characters */
        void m122(Map<String, String> map);
    }

    public ab(Uri uri, AppsFlyerLibCore appsFlyerLibCore) {
        super(appsFlyerLibCore);
        if (!TextUtils.isEmpty(uri.getHost()) && !TextUtils.isEmpty(uri.getPath())) {
            boolean z = false;
            for (String contains : f163) {
                if (uri.getHost().contains(contains)) {
                    z = true;
                }
            }
            if (AFDeepLinkManager.f0 != null) {
                StringBuilder sb = new StringBuilder("Validate custom domain URLs: ");
                sb.append(Arrays.asList(AFDeepLinkManager.f0));
                AFLogger.afRDLog(sb.toString());
                for (String str : AFDeepLinkManager.f0) {
                    if (uri.getHost().contains(str) && str != "") {
                        StringBuilder sb2 = new StringBuilder("DeepLink matches customDomain: ");
                        sb2.append(uri.toString());
                        AFLogger.afDebugLog(sb2.toString());
                        z = true;
                    }
                }
            }
            String[] split = uri.getPath().split("/");
            if (z && split.length == 3) {
                this.oneLinkId = split[1];
                this.f165 = split[2];
                this.f164 = uri.toString();
            }
        }
    }

    /* renamed from: ι  reason: contains not printable characters */
    public final boolean m120() {
        return !TextUtils.isEmpty(this.oneLinkId) && !TextUtils.isEmpty(this.f165) && !this.oneLinkId.equals(AppManagerUtil.EXTEND_PREFIX_DEFAULT);
    }

    public final void initRequest(HttpsURLConnection httpsURLConnection) throws JSONException, IOException {
        httpsURLConnection.setRequestMethod(H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD);
    }

    public final String getOneLinkUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(ServerConfigHandler.getUrl("https://%sonelink.%s/shortlink-sdk/v1"));
        sb.append("/");
        sb.append(this.oneLinkId);
        sb.append("?id=");
        sb.append(this.f165);
        return sb.toString();
    }

    public final void handleResponse(String str) {
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
            this.f166.m122(hashMap);
        } catch (JSONException e2) {
            this.f166.m121("Can't parse one link data");
            AFLogger.afErrorLog("Error while parsing to json ".concat(String.valueOf(str)), e2);
        }
    }

    public final void onErrorResponse() {
        String str = this.f164;
        if (str == null) {
            str = "Can't get one link data";
        }
        this.f166.m121(str);
    }
}
