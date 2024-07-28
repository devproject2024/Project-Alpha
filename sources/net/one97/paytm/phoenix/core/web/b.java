package net.one97.paytm.phoenix.core.web;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.FrameLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.f;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.phoenix.provider.PhoenixProgressHandler;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import net.one97.paytm.phoenix.util.g;
import net.one97.paytm.phoenix.util.j;

public final class b extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    private View f59407a;

    /* renamed from: b  reason: collision with root package name */
    private WebChromeClient.CustomViewCallback f59408b;

    /* renamed from: c  reason: collision with root package name */
    private int f59409c;

    /* renamed from: d  reason: collision with root package name */
    private int f59410d;

    /* renamed from: e  reason: collision with root package name */
    private final WebView f59411e;

    /* renamed from: f  reason: collision with root package name */
    private final net.one97.paytm.phoenix.manager.b f59412f;

    /* renamed from: g  reason: collision with root package name */
    private PhoenixProgressHandler f59413g;

    /* renamed from: h  reason: collision with root package name */
    private final String f59414h;

    /* renamed from: i  reason: collision with root package name */
    private a f59415i;

    public interface a {
        boolean a();
    }

    public b(WebView webView, net.one97.paytm.phoenix.manager.b bVar, PhoenixProgressHandler phoenixProgressHandler, String str, a aVar) {
        k.c(webView, "webView");
        k.c(bVar, "fileHandler");
        k.c(phoenixProgressHandler, "progressHandler");
        this.f59411e = webView;
        this.f59412f = bVar;
        this.f59413g = phoenixProgressHandler;
        this.f59414h = str;
        this.f59415i = aVar;
    }

    public final void onRequestFocus(WebView webView) {
        super.onRequestFocus(webView);
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        Context context;
        if (!(webView == null || (context = webView.getContext()) == null)) {
            g gVar = g.f59641a;
            if (str2 == null) {
                k.a();
            }
            g.a(context, str2);
        }
        if (jsResult == null) {
            return true;
        }
        jsResult.confirm();
        return true;
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.f59407a != null) {
            onHideCustomView();
            return;
        }
        Context context = this.f59411e.getContext();
        if (context != null) {
            ((PhoenixActivity) context).B = true;
            this.f59407a = view;
            Context context2 = this.f59411e.getContext();
            if (context2 != null) {
                Window window = ((PhoenixActivity) context2).getWindow();
                k.a((Object) window, "(webView.context as PhoenixActivity).window");
                this.f59410d = window.getDecorView().getSystemUiVisibility();
                Context context3 = this.f59411e.getContext();
                if (context3 != null) {
                    this.f59409c = ((PhoenixActivity) context3).getRequestedOrientation();
                    Context context4 = this.f59411e.getContext();
                    if (context4 != null) {
                        ((PhoenixActivity) context4).setRequestedOrientation(0);
                        this.f59408b = customViewCallback;
                        Context context5 = this.f59411e.getContext();
                        if (context5 != null) {
                            Window window2 = ((PhoenixActivity) context5).getWindow();
                            k.a((Object) window2, "(webView.context as PhoenixActivity).window");
                            View decorView = window2.getDecorView();
                            if (decorView != null) {
                                ((FrameLayout) decorView).addView(this.f59407a, new FrameLayout.LayoutParams(-1, -1));
                                Context context6 = this.f59411e.getContext();
                                if (context6 != null) {
                                    Window window3 = ((PhoenixActivity) context6).getWindow();
                                    k.a((Object) window3, "(webView.context as PhoenixActivity).window");
                                    View decorView2 = window3.getDecorView();
                                    k.a((Object) decorView2, "(webView.context as Phoe…ctivity).window.decorView");
                                    decorView2.setSystemUiVisibility(3846);
                                    Context context7 = this.f59411e.getContext();
                                    if (context7 != null) {
                                        PhoenixActivity phoenixActivity = (PhoenixActivity) context7;
                                        Window window4 = phoenixActivity.getWindow();
                                        k.a((Object) window4, "window");
                                        window4.getDecorView().setOnSystemUiVisibilityChangeListener(new PhoenixActivity.u(phoenixActivity));
                                        return;
                                    }
                                    throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
                                }
                                throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
                            }
                            throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
    }

    public final void onShowCustomView(View view, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, i2, customViewCallback);
    }

    public final void onHideCustomView() {
        Context context = this.f59411e.getContext();
        if (context != null) {
            ((PhoenixActivity) context).B = false;
            Context context2 = this.f59411e.getContext();
            if (context2 != null) {
                Window window = ((PhoenixActivity) context2).getWindow();
                k.a((Object) window, "window");
                window.getDecorView().setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener) null);
                Context context3 = this.f59411e.getContext();
                if (context3 != null) {
                    Window window2 = ((PhoenixActivity) context3).getWindow();
                    k.a((Object) window2, "(webView.context as PhoenixActivity).window");
                    View decorView = window2.getDecorView();
                    if (decorView != null) {
                        ((FrameLayout) decorView).removeView(this.f59407a);
                        this.f59407a = null;
                        Context context4 = this.f59411e.getContext();
                        if (context4 != null) {
                            Window window3 = ((PhoenixActivity) context4).getWindow();
                            k.a((Object) window3, "(webView.context as PhoenixActivity).window");
                            window3.getDecorView().setSystemUiVisibility(this.f59410d);
                            Context context5 = this.f59411e.getContext();
                            if (context5 != null) {
                                ((PhoenixActivity) context5).setRequestedOrientation(this.f59409c);
                                WebChromeClient.CustomViewCallback customViewCallback = this.f59408b;
                                if (customViewCallback != null) {
                                    customViewCallback.onCustomViewHidden();
                                }
                                this.f59408b = null;
                                return;
                            }
                            throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
    }

    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        if (callback != null) {
            callback.invoke(str, true, false);
        }
    }

    public final void onPermissionRequest(PermissionRequest permissionRequest) {
        if (permissionRequest == null || Build.VERSION.SDK_INT < 21) {
            super.onPermissionRequest(permissionRequest);
            return;
        }
        permissionRequest.grant(permissionRequest.getResources());
        j jVar = j.f59646a;
        j.c("onPermissionRequest", "Permission Granted");
    }

    public final void onConsoleMessage(String str, int i2, String str2) {
        super.onConsoleMessage(str, i2, str2);
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return super.onConsoleMessage(consoleMessage);
    }

    public final void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        super.onPermissionRequestCanceled(permissionRequest);
        j jVar = j.f59646a;
        j.c("onPermissionRequestCanceled", "Permission Denied");
    }

    public final boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        String[] strArr;
        boolean z;
        a aVar = this.f59415i;
        if (aVar != null) {
            if (aVar == null) {
                k.a();
            }
            return aVar.a();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            z = fileChooserParams != null && fileChooserParams.getMode() == 1;
            if (fileChooserParams == null) {
                k.a();
            }
            strArr = fileChooserParams.getAcceptTypes();
            k.a((Object) strArr, "fileChooserParams!!.acceptTypes");
        } else {
            strArr = null;
            z = true;
        }
        net.one97.paytm.phoenix.manager.b bVar = this.f59412f;
        if (webView == null) {
            k.a();
        }
        Context context = webView.getContext();
        k.a((Object) context, "webView!!.context");
        if (strArr == null) {
            k.a("acceptType");
        }
        k.c(context, "context");
        k.c(strArr, "acceptType");
        bVar.f59599a = valueCallback;
        if (context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0 || context.checkCallingOrSelfPermission("android.permission.CAMERA") != 0) {
            return false;
        }
        if (context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 && context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            new File(Environment.getExternalStorageDirectory().toString() + "/h5/").mkdirs();
            ArrayList arrayList = new ArrayList();
            if (strArr.length > 0 && !TextUtils.isEmpty(strArr[0]) && (f.a((T[]) strArr, "image/*") || f.a((T[]) strArr, ".png"))) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                k.a((Object) queryIntentActivities, "listCam");
                net.one97.paytm.phoenix.manager.b.a(queryIntentActivities, intent, arrayList);
            }
            if (f.a((T[]) strArr, ".mp4") || f.a((T[]) strArr, "video/*")) {
                Intent intent2 = new Intent("android.media.action.VIDEO_CAPTURE");
                List<ResolveInfo> queryIntentActivities2 = context.getPackageManager().queryIntentActivities(intent2, 0);
                k.a((Object) queryIntentActivities2, "listVid");
                net.one97.paytm.phoenix.manager.b.a(queryIntentActivities2, intent2, arrayList);
            }
            Intent intent3 = new Intent();
            intent3.setType("*/*");
            intent3.setAction("android.intent.action.GET_CONTENT");
            if (strArr.length > 0 && !TextUtils.isEmpty(strArr[0])) {
                net.one97.paytm.phoenix.manager.b.a(intent3, strArr);
            }
            if (z) {
                intent3.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            }
            Intent createChooser = Intent.createChooser(intent3, "Select Source");
            Object[] array = arrayList.toArray(new Parcelable[0]);
            if (array != null) {
                createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) array);
                if (context != null) {
                    ((PhoenixActivity) context).a(createChooser, 12345, "phoenixHtmlPickFile");
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity");
                }
            } else {
                throw new u("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        return true;
    }

    public final void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        super.onReceivedTouchIconUrl(webView, str, z);
    }

    public final void onReceivedIcon(WebView webView, Bitmap bitmap) {
        super.onReceivedIcon(webView, bitmap);
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bb, code lost:
        if (android.text.TextUtils.isEmpty(r12) == false) goto L_0x00d1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReceivedTitle(android.webkit.WebView r11, java.lang.String r12) {
        /*
            r10 = this;
            super.onReceivedTitle(r11, r12)
            r0 = 0
            if (r11 == 0) goto L_0x000b
            android.content.Context r1 = r11.getContext()
            goto L_0x000c
        L_0x000b:
            r1 = r0
        L_0x000c:
            boolean r2 = r1 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r2 == 0) goto L_0x0160
            r2 = r1
            net.one97.paytm.phoenix.ui.PhoenixActivity r2 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r2
            boolean r3 = r2.j
            if (r3 != 0) goto L_0x0026
            r3 = 1
            r2.j = r3
            net.one97.paytm.phoenix.core.web.b$b r3 = new net.one97.paytm.phoenix.core.web.b$b
            r3.<init>(r11)
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r4 = 10
            r11.postDelayed(r3, r4)
        L_0x0026:
            net.one97.paytm.phoenix.util.j r11 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r11 = java.lang.String.valueOf(r12)
            java.lang.String r3 = "onReceivedTitle title: "
            java.lang.String r11 = r3.concat(r11)
            java.lang.String r3 = "Startup params:"
            net.one97.paytm.phoenix.util.j.b(r3, r11)
            net.one97.paytm.phoenix.util.j r11 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r4 = "default title: "
            r11.<init>(r4)
            java.lang.String r4 = r10.f59414h
            r11.append(r4)
            java.lang.String r11 = r11.toString()
            net.one97.paytm.phoenix.util.j.b(r3, r11)
            android.content.Intent r11 = r2.getIntent()
            java.lang.String r4 = "appIconUrl"
            if (r11 == 0) goto L_0x0063
            android.os.Bundle r11 = r11.getExtras()
            if (r11 == 0) goto L_0x0063
            boolean r11 = r11.containsKey(r4)
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)
            goto L_0x0064
        L_0x0063:
            r11 = r0
        L_0x0064:
            net.one97.paytm.phoenix.util.j r5 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r5 = "TITLE_BAR_APP_ICON"
            java.lang.String r11 = r5.concat(r11)
            net.one97.paytm.phoenix.util.j.b(r3, r11)
            android.content.Intent r11 = r2.getIntent()
            if (r11 == 0) goto L_0x0088
            android.os.Bundle r11 = r11.getExtras()
            if (r11 == 0) goto L_0x0088
            boolean r11 = r11.containsKey(r4)
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)
            goto L_0x0089
        L_0x0088:
            r11 = r0
        L_0x0089:
            if (r11 != 0) goto L_0x008e
            kotlin.g.b.k.a()
        L_0x008e:
            boolean r11 = r11.booleanValue()
            if (r11 != 0) goto L_0x0160
            boolean r11 = r2.D
            java.lang.String r4 = "Paytm"
            if (r11 == 0) goto L_0x00c0
            java.lang.Boolean r11 = r2.F
            if (r11 != 0) goto L_0x00a1
            kotlin.g.b.k.a()
        L_0x00a1:
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x00c0
            java.lang.String r11 = r10.f59414h
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x00b4
            java.lang.String r12 = r10.f59414h
            goto L_0x00d1
        L_0x00b4:
            r11 = r12
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x00be
            goto L_0x00d1
        L_0x00be:
            r12 = r4
            goto L_0x00d1
        L_0x00c0:
            boolean r11 = r2.D
            if (r11 != 0) goto L_0x00c5
            goto L_0x00d1
        L_0x00c5:
            java.lang.String r11 = r10.f59414h
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x00be
            java.lang.String r12 = r10.f59414h
        L_0x00d1:
            net.one97.paytm.phoenix.util.j r11 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r11 = java.lang.String.valueOf(r12)
            java.lang.String r2 = "txtTitle: "
            java.lang.String r11 = r2.concat(r11)
            net.one97.paytm.phoenix.util.j.b(r3, r11)
            r11 = r12
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x0160
            if (r12 == 0) goto L_0x00f4
            int r11 = r12.length()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r11)
        L_0x00f4:
            if (r0 != 0) goto L_0x00f9
            kotlin.g.b.k.a()
        L_0x00f9:
            int r11 = r0.intValue()
            r0 = 0
            r2 = 25
            if (r11 <= r2) goto L_0x0127
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            if (r12 == 0) goto L_0x011f
            java.lang.String r12 = r12.substring(r0, r2)
            java.lang.String r2 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            r11.append(r12)
            java.lang.String r12 = "..."
            r11.append(r12)
            java.lang.String r12 = r11.toString()
            goto L_0x0127
        L_0x011f:
            kotlin.u r11 = new kotlin.u
            java.lang.String r12 = "null cannot be cast to non-null type java.lang.String"
            r11.<init>(r12)
            throw r11
        L_0x0127:
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            java.lang.String r11 = "title"
            r5.put(r11, r12)
            java.lang.String r11 = "isResultRequired"
            r5.put(r11, r0)
            net.one97.paytm.phoenix.api.H5Event r11 = new net.one97.paytm.phoenix.api.H5Event
            r6 = 0
            r7 = 0
            r8 = 24
            r9 = 0
            java.lang.String r3 = "setTitle"
            java.lang.String r4 = "call"
            r2 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            android.app.Activity r1 = (android.app.Activity) r1
            r11.setActivity(r1)
            net.one97.paytm.phoenix.core.c r12 = net.one97.paytm.phoenix.core.c.f59399a
            net.one97.paytm.phoenix.api.e r12 = r12.a()
            net.one97.paytm.phoenix.core.c r0 = net.one97.paytm.phoenix.core.c.f59399a
            net.one97.paytm.phoenix.api.b r0 = r0.a(r1)
            if (r0 != 0) goto L_0x015d
            kotlin.g.b.k.a()
        L_0x015d:
            r12.a(r11, r0)
        L_0x0160:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.core.web.b.onReceivedTitle(android.webkit.WebView, java.lang.String):void");
    }

    /* renamed from: net.one97.paytm.phoenix.core.web.b$b  reason: collision with other inner class name */
    static final class C1148b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WebView f59416a;

        C1148b(WebView webView) {
            this.f59416a = webView;
        }

        public final void run() {
            a.a(this.f59416a);
        }
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
    }

    public final void onProgressChanged(WebView webView, int i2) {
        j jVar = j.f59646a;
        j.a("PhoenixWebChromeClient", "onProgressChanged: ".concat(String.valueOf(i2)));
        this.f59413g.setProgress$phoenix_debug(i2);
        super.onProgressChanged(webView, i2);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    public final void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        super.getVisitedHistory(valueCallback);
    }

    public final View getVideoLoadingProgressView() {
        return super.getVideoLoadingProgressView();
    }

    public final void onGeolocationPermissionsHidePrompt() {
        super.onGeolocationPermissionsHidePrompt();
    }

    public final Bitmap getDefaultVideoPoster() {
        return super.getDefaultVideoPoster();
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        return super.onCreateWindow(webView, z, z2, message);
    }

    public final void onCloseWindow(WebView webView) {
        super.onCloseWindow(webView);
    }

    public final boolean onJsTimeout() {
        return super.onJsTimeout();
    }
}
