package a.a.a.a.a.g;

import a.a.a.a.a.b.i;
import a.a.a.a.a.c.c;
import a.a.a.a.a.c.d;
import a.a.a.a.a.f.b;
import android.webkit.WebView;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public b f739a = new b((WebView) null);

    /* renamed from: b  reason: collision with root package name */
    public a.a.a.a.a.b.a f740b;

    /* renamed from: c  reason: collision with root package name */
    public C0002a f741c;

    /* renamed from: d  reason: collision with root package name */
    public long f742d;

    /* renamed from: a.a.a.a.a.g.a$a  reason: collision with other inner class name */
    public enum C0002a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_HIDDEN
    }

    public a() {
        d();
    }

    public void a() {
    }

    public final void a(float f2) {
        d.a();
        d.a(c(), f2);
    }

    /* access modifiers changed from: package-private */
    public final void a(WebView webView) {
        this.f739a = new b(webView);
    }

    public void b() {
        this.f739a.clear();
    }

    public final WebView c() {
        return (WebView) this.f739a.get();
    }

    public final void a(i iVar, a.a.a.a.a.b.d dVar) {
        String str = iVar.f705e;
        JSONObject jSONObject = new JSONObject();
        a.a.a.a.a.e.b.a(jSONObject, "environment", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        a.a.a.a.a.e.b.a(jSONObject, "adSessionType", dVar.f686f);
        a.a.a.a.a.e.b.a(jSONObject, "deviceInfo", a.a.a.a.a.e.a.a());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        a.a.a.a.a.e.b.a(jSONObject, "supports", jSONArray);
        JSONObject jSONObject2 = new JSONObject();
        a.a.a.a.a.e.b.a(jSONObject2, "partnerName", dVar.f681a.f696a);
        a.a.a.a.a.e.b.a(jSONObject2, "partnerVersion", dVar.f681a.f697b);
        a.a.a.a.a.e.b.a(jSONObject, "omidNativeInfo", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        a.a.a.a.a.e.b.a(jSONObject3, "libraryVersion", "1.2.17-Paytm");
        a.a.a.a.a.e.b.a(jSONObject3, "appId", c.a().f721a.getApplicationContext().getPackageName());
        a.a.a.a.a.e.b.a(jSONObject, AppManagerUtil.EXTEND_PREFIX_DEFAULT, jSONObject3);
        if (dVar.f685e != null) {
            a.a.a.a.a.e.b.a(jSONObject, "customReferenceData", dVar.f685e);
        }
        JSONObject jSONObject4 = new JSONObject();
        for (T t : Collections.unmodifiableList(dVar.f683c)) {
            a.a.a.a.a.e.b.a(jSONObject4, t.f698a, t.f700c);
        }
        d.a();
        d.a(c(), str, jSONObject, jSONObject4);
    }

    public final void d() {
        this.f742d = System.nanoTime();
        this.f741c = C0002a.AD_STATE_IDLE;
    }
}
