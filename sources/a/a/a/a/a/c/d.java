package a.a.a.a.a.c;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import org.json.JSONObject;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f722a = new d();

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WebView f723a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f724b;

        a(WebView webView, String str) {
            this.f723a = webView;
            this.f724b = str;
        }

        public final void run() {
            this.f723a.loadUrl(this.f724b);
        }
    }

    private d() {
    }

    public static d a() {
        return f722a;
    }

    public static void a(WebView webView, float f2) {
        a(webView, "setDeviceVolume", Float.valueOf(f2));
    }

    public static void a(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        a(webView, "startSession", str, jSONObject, jSONObject2);
    }

    public static void a(WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            a(sb, objArr);
            sb.append(")}");
            a(webView, sb);
        }
    }

    private static void a(WebView webView, StringBuilder sb) {
        String sb2 = sb.toString();
        Handler handler = webView.getHandler();
        if (handler == null || Looper.myLooper() == handler.getLooper()) {
            webView.loadUrl(sb2);
        } else {
            handler.post(new a(webView, sb2));
        }
    }

    private static void a(StringBuilder sb, Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                if (obj == null) {
                    sb.append('\"');
                } else {
                    if (obj instanceof String) {
                        String obj2 = obj.toString();
                        if (obj2.startsWith("{")) {
                            sb.append(obj2);
                        } else {
                            sb.append('\"');
                            sb.append(obj2);
                        }
                    } else {
                        sb.append(obj);
                    }
                    sb.append(AppConstants.COMMA);
                }
                sb.append('\"');
                sb.append(AppConstants.COMMA);
            }
            sb.setLength(sb.length() - 1);
        }
    }

    public static boolean a(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        webView.loadUrl("javascript: ".concat(String.valueOf(str)));
        return true;
    }

    public static void b(WebView webView, String str) {
        a(webView, "setNativeViewHierarchy", str);
    }
}
