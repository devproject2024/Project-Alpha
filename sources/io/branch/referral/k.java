package io.branch.referral;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import io.branch.referral.m;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import net.one97.paytm.nativesdk.transcation.viewmodel.DirectFormItemType;
import org.json.JSONObject;

public final class k {

    /* renamed from: h  reason: collision with root package name */
    private static k f46520h;

    /* renamed from: a  reason: collision with root package name */
    boolean f46521a;

    /* renamed from: b  reason: collision with root package name */
    boolean f46522b;

    /* renamed from: c  reason: collision with root package name */
    a f46523c = null;

    /* renamed from: d  reason: collision with root package name */
    boolean f46524d = false;

    /* renamed from: e  reason: collision with root package name */
    String f46525e;

    /* renamed from: f  reason: collision with root package name */
    boolean f46526f;

    /* renamed from: g  reason: collision with root package name */
    Dialog f46527g;

    public interface b {
        void b(String str);

        void c(String str);

        void d(String str);
    }

    private k() {
    }

    public static k a() {
        if (f46520h == null) {
            f46520h = new k();
        }
        return f46520h;
    }

    public final boolean a(JSONObject jSONObject, String str, Context context, b bVar) {
        return a(new a(this, jSONObject, str, (byte) 0), context, bVar);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(a aVar, Context context, b bVar) {
        if (this.f46521a || this.f46524d) {
            if (bVar != null) {
                bVar.d(aVar.f46536b);
            }
            return false;
        }
        this.f46521a = false;
        this.f46522b = false;
        if (!(context == null || aVar == null)) {
            if (aVar.a(context)) {
                if (!TextUtils.isEmpty(aVar.f46538d)) {
                    b(aVar, context, bVar);
                } else {
                    this.f46524d = true;
                    new c(aVar, context, bVar).execute(new Void[0]);
                }
                return true;
            } else if (bVar != null) {
                bVar.d(aVar.f46536b);
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void b(final a aVar, Context context, final b bVar) {
        if (context != null && aVar != null) {
            final WebView webView = new WebView(context);
            webView.getSettings().setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 19) {
                webView.setLayerType(2, (Paint) null);
            }
            this.f46526f = false;
            if (!TextUtils.isEmpty(aVar.f46538d)) {
                webView.loadDataWithBaseURL((String) null, aVar.f46538d, "text/html", "utf-8", (String) null);
                webView.setWebViewClient(new WebViewClient() {
                    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        boolean a2 = k.this.a(str);
                        if (!a2) {
                            webView.loadUrl(str);
                        } else if (k.this.f46527g != null) {
                            k.this.f46527g.dismiss();
                        }
                        return a2;
                    }

                    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                        super.onPageStarted(webView, str, bitmap);
                    }

                    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
                        super.onReceivedError(webView, i2, str, str2);
                        k.this.f46526f = true;
                    }

                    public final void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        k kVar = k.this;
                        a aVar = aVar;
                        b bVar = bVar;
                        WebView webView2 = webView;
                        if (kVar.f46526f || c.a() == null || c.a().n == null) {
                            kVar.f46521a = false;
                            if (bVar != null) {
                                bVar.d(aVar.f46536b);
                                return;
                            }
                            return;
                        }
                        Activity activity = (Activity) c.a().n.get();
                        if (activity != null) {
                            Context applicationContext = activity.getApplicationContext();
                            String str2 = aVar.f46535a;
                            q.a(applicationContext);
                            q.c("bnc_branch_view_use_".concat(String.valueOf(str2)), q.f(str2) + 1);
                            kVar.f46525e = activity.getClass().getName();
                            RelativeLayout relativeLayout = new RelativeLayout(activity);
                            relativeLayout.setVisibility(8);
                            relativeLayout.addView(webView2, new RelativeLayout.LayoutParams(-1, -1));
                            relativeLayout.setBackgroundColor(0);
                            if (kVar.f46527g == null || !kVar.f46527g.isShowing()) {
                                kVar.f46527g = new Dialog(activity, 16973834);
                                kVar.f46527g.setContentView(relativeLayout);
                                relativeLayout.setVisibility(0);
                                webView2.setVisibility(0);
                                kVar.f46527g.show();
                                k.a((View) relativeLayout);
                                k.a((View) webView2);
                                kVar.f46521a = true;
                                kVar.f46527g.setOnDismissListener(new DialogInterface.OnDismissListener(bVar, aVar) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ b f46532a;

                                    /* renamed from: b  reason: collision with root package name */
                                    final /* synthetic */ a f46533b;

                                    {
                                        this.f46532a = r2;
                                        this.f46533b = r3;
                                    }

                                    public final void onDismiss(DialogInterface dialogInterface) {
                                        k kVar = k.this;
                                        kVar.f46521a = false;
                                        kVar.f46527g = null;
                                        if (this.f46532a == null) {
                                            return;
                                        }
                                        if (kVar.f46522b) {
                                            this.f46532a.b(this.f46533b.f46536b);
                                        } else {
                                            this.f46532a.c(this.f46533b.f46536b);
                                        }
                                    }
                                });
                            } else if (bVar != null) {
                                bVar.d(aVar.f46536b);
                            }
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(String str) {
        try {
            URI uri = new URI(str);
            if (!uri.getScheme().equalsIgnoreCase("branch-cta")) {
                return false;
            }
            if (uri.getHost().equalsIgnoreCase("accept")) {
                this.f46522b = true;
            } else if (!uri.getHost().equalsIgnoreCase(DirectFormItemType.CANCEL)) {
                return false;
            } else {
                this.f46522b = false;
            }
            return true;
        } catch (URISyntaxException unused) {
            return false;
        }
    }

    static void a(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(500);
        alphaAnimation.setStartOffset(10);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setFillAfter(true);
        view.setVisibility(0);
        view.startAnimation(alphaAnimation);
    }

    public final boolean a(JSONObject jSONObject, String str) {
        Activity activity;
        a aVar = new a(this, jSONObject, str, (byte) 0);
        if (c.a().n == null || (activity = (Activity) c.a().n.get()) == null || !aVar.a(activity)) {
            return false;
        }
        this.f46523c = new a(this, jSONObject, str, (byte) 0);
        return true;
    }

    class c extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: b  reason: collision with root package name */
        private final a f46542b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f46543c;

        /* renamed from: d  reason: collision with root package name */
        private final b f46544d;

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return a();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            Boolean bool = (Boolean) obj;
            super.onPostExecute(bool);
            if (bool.booleanValue()) {
                k.this.b(this.f46542b, this.f46543c, this.f46544d);
            } else {
                b bVar = this.f46544d;
                if (bVar != null) {
                    bVar.d(this.f46542b.f46536b);
                }
            }
            k.this.f46524d = false;
        }

        public c(a aVar, Context context, b bVar) {
            this.f46542b = aVar;
            this.f46543c = context;
            this.f46544d = bVar;
        }

        private Boolean a() {
            int i2;
            boolean z = false;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(this.f46542b.f46537c).openConnection()));
                httpURLConnection.setRequestMethod(H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD);
                httpURLConnection.connect();
                i2 = httpURLConnection.getResponseCode();
                if (i2 == 200) {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        byte[] bArr = new byte[TarConstants.EOF_BLOCK];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        this.f46542b.f46538d = byteArrayOutputStream.toString(AppConstants.UTF_8);
                        byteArrayOutputStream.close();
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                i2 = -1;
            }
            if (i2 == 200) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        String f46535a;

        /* renamed from: b  reason: collision with root package name */
        String f46536b;

        /* renamed from: c  reason: collision with root package name */
        String f46537c;

        /* renamed from: d  reason: collision with root package name */
        String f46538d;

        /* renamed from: f  reason: collision with root package name */
        private int f46540f;

        /* synthetic */ a(k kVar, JSONObject jSONObject, String str, byte b2) {
            this(jSONObject, str);
        }

        private a(JSONObject jSONObject, String str) {
            this.f46535a = "";
            this.f46536b = "";
            this.f46540f = 1;
            this.f46537c = "";
            this.f46538d = "";
            try {
                this.f46536b = str;
                if (jSONObject.has(m.a.BranchViewID.getKey())) {
                    this.f46535a = jSONObject.getString(m.a.BranchViewID.getKey());
                }
                if (jSONObject.has(m.a.BranchViewNumOfUse.getKey())) {
                    this.f46540f = jSONObject.getInt(m.a.BranchViewNumOfUse.getKey());
                }
                if (jSONObject.has(m.a.BranchViewUrl.getKey())) {
                    this.f46537c = jSONObject.getString(m.a.BranchViewUrl.getKey());
                }
                if (jSONObject.has(m.a.BranchViewHtml.getKey())) {
                    this.f46538d = jSONObject.getString(m.a.BranchViewHtml.getKey());
                }
            } catch (Exception unused) {
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean a(Context context) {
            q.a(context);
            int f2 = q.f(this.f46535a);
            int i2 = this.f46540f;
            return i2 > f2 || i2 == -1;
        }
    }
}
