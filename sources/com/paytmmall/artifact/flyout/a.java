package com.paytmmall.artifact.flyout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.gsonhtcfix.f;
import com.paytm.utility.q;
import com.paytmmall.a.a.c;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.b;
import com.paytmmall.artifact.d.d;
import com.paytmmall.artifact.d.j;
import com.paytmmall.artifact.d.s;
import com.paytmmall.artifact.d.t;
import com.paytmmall.artifact.d.u;
import com.paytmmall.artifact.d.v;
import com.paytmmall.clpartifact.utils.LogUtils;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.orflow.Utility;
import org.json.JSONArray;
import org.json.JSONObject;

public class a extends h {

    /* renamed from: a  reason: collision with root package name */
    public WebView f15823a;

    /* renamed from: b  reason: collision with root package name */
    com.paytm.b.a.a f15824b;

    /* renamed from: c  reason: collision with root package name */
    private final String f15825c = "startTime";

    /* renamed from: d  reason: collision with root package name */
    private final String f15826d = "mallCallback";

    /* renamed from: e  reason: collision with root package name */
    private String f15827e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f15828f = "H5FlyoutFragment";

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_h5_flyout, viewGroup, false);
        if (inflate != null) {
            this.f15823a = (WebView) inflate.findViewById(R.id.h5flyoutwebview);
            WebSettings settings = this.f15823a.getSettings();
            settings.setAppCacheMaxSize(5242880);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                settings.setAppCachePath(activity.getCacheDir().getAbsolutePath());
            }
            settings.setAllowFileAccess(true);
            settings.setAppCacheEnabled(true);
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            this.f15823a.addJavascriptInterface(new C0212a(getActivity(), this.f15823a), Utility.VERTICAL_NAME_MALL);
            this.f15824b = u.a(getActivity().getApplicationContext());
            com.paytmmall.artifact.common.a.a.a();
            long a2 = (long) com.paytmmall.artifact.common.a.a.a("flyoutCacheLimit", 600000);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f15824b.b("startTime", 0, false) > a2) {
                this.f15823a.getSettings().setCacheMode(-1);
                this.f15824b.a("startTime", currentTimeMillis, false);
            } else {
                this.f15823a.getSettings().setCacheMode(1);
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && !activity2.isFinishing()) {
                this.f15827e = d.b((Context) activity2, com.paytmmall.a.a.b());
            }
            this.f15827e = j.a(this.f15827e);
            this.f15823a.loadUrl(this.f15827e);
            WebView.setWebContentsDebuggingEnabled(true);
            this.f15823a.setWebViewClient(new WebViewClient() {
                public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    super.onPageStarted(webView, str, bitmap);
                    d.a((Activity) a.this.getActivity(), "Please wait...");
                }

                public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }

                public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    a.a(a.this, webResourceRequest.getUrl().toString());
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                }

                public final void onReceivedError(WebView webView, int i2, String str, String str2) {
                    a.a(a.this, str2);
                    super.onReceivedError(webView, i2, str, str2);
                }

                public final void onLoadResource(WebView webView, String str) {
                    super.onLoadResource(webView, str);
                }

                public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    super.onReceivedError(webView, webResourceRequest, webResourceError);
                    if (webResourceRequest != null && webResourceRequest.getUrl() != null) {
                        a.a(a.this, webResourceRequest.getUrl().toString());
                    }
                }

                public final void onPageFinished(WebView webView, String str) {
                    d.h();
                }
            });
        }
        return inflate;
    }

    /* renamed from: com.paytmmall.artifact.flyout.a$a  reason: collision with other inner class name */
    public class C0212a {

        /* renamed from: a  reason: collision with root package name */
        Context f15833a;

        /* renamed from: c  reason: collision with root package name */
        private WebView f15835c;

        C0212a(Context context, WebView webView) {
            this.f15833a = context;
            this.f15835c = webView;
        }

        @JavascriptInterface
        public final String handleEvent(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -934610812:
                    if (str.equals("remove")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -613569519:
                    if (str.equals("SEARCH_CLICK")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -385519706:
                    if (str.equals("SEND_MAP_ONLY")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -161774901:
                    if (str.equals("BACK_PRESS")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 102230:
                    if (str.equals("get")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 113762:
                    if (str.equals("set")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 368948223:
                    if (str.equals("SEND_EVENT_WITH_MAP")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 1214184595:
                    if (str.equals("mpOpenDeeplink")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1985819622:
                    if (str.equals("GET_GA_DATA")) {
                        c2 = 8;
                        break;
                    }
                    break;
                case 2006214101:
                    if (str.equals("GET_USER_DATA")) {
                        c2 = 9;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a.a(a.this);
                    break;
                case 1:
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (a.this.getActivity() != null) {
                            t.e().handleLink(a.this.getActivity(), jSONObject.getString("deeplink"));
                            break;
                        }
                    } catch (Exception e2) {
                        String unused = a.this.f15828f;
                        q.c(e2.getMessage());
                        break;
                    }
                    break;
                case 2:
                    if (a.this.getActivity() != null) {
                        b.a(a.this.getActivity());
                        break;
                    }
                    break;
                case 3:
                    try {
                        a.a(a.this, str, c.b((Activity) a.this.getActivity(), new JSONArray(str2)).toString());
                        break;
                    } catch (Exception e3) {
                        LogUtils.printStackTrace(e3);
                        break;
                    }
                case 4:
                    try {
                        c.a((Activity) a.this.getActivity(), new JSONObject(str2));
                        break;
                    } catch (Exception e4) {
                        LogUtils.printStackTrace(e4);
                        break;
                    }
                case 5:
                    try {
                        a.a(a.this, str, c.a((Activity) a.this.getActivity(), new JSONArray(str2)).toString());
                        break;
                    } catch (Exception e5) {
                        LogUtils.printStackTrace(e5);
                        break;
                    }
                case 6:
                    try {
                        com.paytmmall.artifact.common.b.a.a.a(a.b(a.this, new JSONObject(str2).toString()));
                        break;
                    } catch (Exception e6) {
                        s.a(e6);
                        break;
                    }
                case 7:
                    try {
                        JSONObject jSONObject2 = new JSONObject(str2);
                        com.paytmmall.artifact.common.b.a.a.a(String.valueOf(jSONObject2.get(AppConstants.NOTIFICATION_DETAILS.EVENT)), (Map) a.b(a.this, jSONObject2.toString()));
                        break;
                    } catch (Exception e7) {
                        s.a(e7);
                        break;
                    }
                case 8:
                    try {
                        return new f().a((Object) v.b());
                    } catch (Exception e8) {
                        s.a(e8);
                        break;
                    }
                case 9:
                    try {
                        return new f().a((Object) com.paytmmall.artifact.common.b.a.a.c());
                    } catch (Exception e9) {
                        s.a(e9);
                        break;
                    }
                default:
                    LogUtils.d("H5FlyoutFragment", str + " Doesnot Exist");
                    break;
            }
            return "";
        }
    }

    static /* synthetic */ void a(a aVar, String str) {
        FragmentActivity activity = aVar.getActivity();
        if (!TextUtils.isEmpty(aVar.f15827e) && str.startsWith(aVar.f15827e) && activity != null) {
            Toast.makeText(activity, R.string.No_internet_error, 0).show();
            aVar.f15823a.setVisibility(4);
            activity.finish();
        }
    }

    static /* synthetic */ void a(a aVar) {
        final FragmentActivity activity = aVar.getActivity();
        if (activity != null && !activity.isFinishing()) {
            activity.runOnUiThread(new Runnable() {
                public final void run() {
                    activity.onBackPressed();
                }
            });
        }
    }

    static /* synthetic */ HashMap b(a aVar, String str) {
        return (HashMap) new f().a(str, new com.google.gsonhtcfix.c.a<HashMap<String, Object>>() {
        }.getType());
    }

    static /* synthetic */ void a(a aVar, String str, String str2) {
        WebView webView = aVar.f15823a;
        if (webView != null) {
            webView.loadUrl("javascript:mallCallback('" + str + "', '" + str2 + "')");
        }
    }
}
