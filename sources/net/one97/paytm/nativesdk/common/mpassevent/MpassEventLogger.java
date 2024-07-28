package net.one97.paytm.nativesdk.common.mpassevent;

import android.content.Context;
import android.os.Build;
import com.android.volley.DefaultRetryPolicy;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyPostRequest;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue;

public final class MpassEventLogger {
    private final Context context;
    private String custSDKVersion;
    private String eventAction;
    private String mMid = this.mid;
    private String mOrderId = this.orderId;
    private final String mid;
    private final String orderId;
    private String sdkFlow = SDKConstants.NSDK_EVENT_CATEGORY;

    public MpassEventLogger(Context context2, String str, String str2) {
        k.c(context2, "context");
        this.context = context2;
        this.orderId = str;
        this.mid = str2;
    }

    public final String getMOrderId() {
        return this.mOrderId;
    }

    public final void setMOrderId(String str) {
        this.mOrderId = str;
    }

    public final String getMMid() {
        return this.mMid;
    }

    public final void setMMid(String str) {
        this.mMid = str;
    }

    public final String getSdkFlow() {
        return this.sdkFlow;
    }

    public final void setSdkFlow(String str) {
        this.sdkFlow = str;
    }

    public final String getEventAction() {
        return this.eventAction;
    }

    public final void setEventAction(String str) {
        this.eventAction = str;
    }

    public final String getCustSDKVersion() {
        return this.custSDKVersion;
    }

    public final void setCustSDKVersion(String str) {
        this.custSDKVersion = str;
    }

    public final void sendLog(Map<String, ? extends Object> map) {
        String str;
        if (k.a((Object) this.sdkFlow, (Object) SDKConstants.CUI_EVENT_CATEGORY)) {
            str = getMpassRequestUrl(buildRequestBodyWithParamsForCustomSDK(map), SDKConstants.CUI_EVENT_CATEGORY);
        } else {
            str = getMpassRequestUrl(buildRequestBodyWithParams(map), SDKConstants.NSDK_EVENT_CATEGORY);
        }
        VolleyPostRequest volleyPostRequest = new VolleyPostRequest(0, str, (Map<String, String>) null, (Map<String, String>) null, (String) null, MpassEventLogger$sendLog$1.INSTANCE, MpassEventLogger$sendLog$2.INSTANCE, String.class);
        volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(2500, 2, 1.0f));
        VolleyRequestQueue.getInstance(this.context).addToRequestQueue(volleyPostRequest);
    }

    private final String buildRequestBodyWithParams(Map<String, ? extends Object> map) {
        StringBuilder sb = new StringBuilder();
        if (this.mMid != null) {
            sb.append("mid=" + this.mMid + '^');
        }
        if (this.mOrderId != null) {
            sb.append("orderid=" + this.mOrderId + '^');
        }
        sb.append("deviceModel=" + Build.MANUFACTURER + "-" + Build.MODEL + "^");
        sb.append("os=android^");
        StringBuilder sb2 = new StringBuilder("osVersion=");
        sb2.append(Build.VERSION.SDK_INT);
        sb2.append('^');
        sb.append(sb2.toString());
        sb.append("timestamp=" + System.currentTimeMillis() + '^');
        sb.append("flow=AndroidNativeSDK^");
        sb.append("sdkVersion=NSDK_9.1.0-RC1^");
        sb.append("platform=SDK^");
        sb.append("deviceType=SmartPhone^");
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                sb.append(((String) next.getKey()) + '=' + next.getValue() + '^');
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        String sb3 = sb.toString();
        k.a((Object) sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    private final String buildRequestBodyWithParamsForCustomSDK(Map<String, ? extends Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("mid=" + this.mMid + '^');
        sb.append("orderid=" + this.mOrderId + '^');
        sb.append("sdkVersion=CUI_" + this.custSDKVersion + '^');
        sb.append("deviceModel=" + Build.MANUFACTURER + "-" + Build.MODEL + "^");
        sb.append("os=android^");
        StringBuilder sb2 = new StringBuilder("osVersion=");
        sb2.append(Build.VERSION.SDK_INT);
        sb2.append("^");
        sb.append(sb2.toString());
        sb.append("timestamp=" + System.currentTimeMillis() + "^");
        sb.append("flow=CustomUI^");
        sb.append("platform=SDK^");
        sb.append("deviceType=SmartPhone^");
        sb.append("eventCategory=CUI_SDK_PG^");
        sb.append("eventAction=" + this.eventAction + '^');
        if (map != null) {
            for (String next : map.keySet()) {
                sb.append(next + "=" + map.get(next) + "^");
            }
            sb.replace(sb.length() - 1, sb.length() - 1, "");
        }
        String sb3 = sb.toString();
        k.a((Object) sb3, "body.toString()");
        return sb3;
    }

    private final String getMpassRequestUrl(String str, String str2) {
        return NativeSdkGtmLoader.MPASS_API_URL + "?data=DW-COOKIE,af7ba81c-89c9-483c-a080-c31810628346_1596204312728,,,,,,,eventType=" + str2 + '^' + str + ",,,,,,,,," + str2;
    }
}
