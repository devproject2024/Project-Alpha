package net.one97.paytm.phoenix.core.web;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import com.alipay.mobile.h5container.api.H5Param;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.e.a;
import net.one97.paytm.phoenix.manager.EventPubSubManager;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import net.one97.paytm.phoenix.util.j;
import org.json.JSONException;
import org.json.JSONObject;

public final class PhoenixJavascriptInterface {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f59402a;

    /* renamed from: b  reason: collision with root package name */
    private final a f59403b;

    public PhoenixJavascriptInterface(Activity activity, a aVar) {
        k.c(activity, "activity");
        k.c(aVar, "service");
        this.f59402a = activity;
        this.f59403b = aVar;
    }

    @JavascriptInterface
    public final void postMessage(String str) {
        k.c(str, "messageAsJson");
        j jVar = j.f59646a;
        String simpleName = getClass().getSimpleName();
        k.a((Object) simpleName, "this.javaClass.simpleName");
        j.a(simpleName, "postMessage: ".concat(String.valueOf(str)));
        try {
            JSONObject jSONObject = new JSONObject(str);
            H5Event h5Event = new H5Event(jSONObject.optString("bridgeName"), jSONObject.optString(H5Param.MSG_TYPE), jSONObject.optJSONObject("params"), jSONObject.optString("callbackId"), jSONObject.optBoolean(H5Param.KEEP_CALLBACK));
            j jVar2 = j.f59646a;
            String simpleName2 = getClass().getSimpleName();
            k.a((Object) simpleName2, "this.javaClass.simpleName");
            j.a(simpleName2, "event: ".concat(String.valueOf(h5Event)));
            j jVar3 = j.f59646a;
            String simpleName3 = getClass().getSimpleName();
            k.a((Object) simpleName3, "this.javaClass.simpleName");
            j.a(simpleName3, "event params: " + h5Event.getParams());
            h5Event.setActivity(this.f59402a);
            String bridgeName = h5Event.getBridgeName();
            if (bridgeName != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("funcName", bridgeName);
                if (h5Event.getParams() == null) {
                    h5Event.setParams(jSONObject2);
                } else {
                    JSONObject params = h5Event.getParams();
                    if (params == null) {
                        k.a();
                    }
                    params.accumulate("default", jSONObject2);
                }
                b a2 = this.f59403b.a(this.f59402a);
                if (a2 == null) {
                    return;
                }
                if (k.a((Object) h5Event.getMsgType(), (Object) com.alipay.mobile.h5container.api.H5Event.TYPE_CALL) && this.f59403b.a().a(this.f59402a, bridgeName)) {
                    h5Event.startTrace();
                    this.f59403b.a().a(h5Event, a2);
                } else if ((k.a((Object) h5Event.getMsgType(), (Object) "subscribe") || k.a((Object) h5Event.getMsgType(), (Object) "unsubscribe")) && (this.f59402a instanceof PhoenixActivity)) {
                    h5Event.startTrace();
                    EventPubSubManager eventPubSubManager = ((PhoenixActivity) this.f59402a).f59609g;
                    if (eventPubSubManager != null) {
                        eventPubSubManager.a(h5Event, a2);
                    }
                } else {
                    j jVar4 = j.f59646a;
                    j.c("PhoenixJavascriptInterface", "no plugin can handle this action");
                    a2.a(h5Event, 1, "not implemented!");
                }
            }
        } catch (JSONException e2) {
            j jVar5 = j.f59646a;
            j.a("PhoenixJavascriptInterface", "Syntax error", e2);
        }
    }
}
