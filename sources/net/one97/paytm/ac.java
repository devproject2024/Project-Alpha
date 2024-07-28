package net.one97.paytm;

import android.webkit.JavascriptInterface;
import org.json.JSONObject;

public final class ac {

    /* renamed from: a  reason: collision with root package name */
    private a f51963a;

    public interface a {
        void a();
    }

    public ac(a aVar) {
        this.f51963a = aVar;
    }

    @JavascriptInterface
    public final void postMessage(String str) {
        if (this.f51963a != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String str2 = "";
                if (jSONObject.has("functionName")) {
                    str2 = jSONObject.getString("functionName");
                }
                char c2 = 65535;
                if (str2.hashCode() == -1111243300) {
                    if (str2.equals("onBackPressed")) {
                        c2 = 0;
                    }
                }
                if (c2 == 0) {
                    this.f51963a.a();
                }
            } catch (Exception unused) {
            }
        }
    }
}
