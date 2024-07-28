package com.alipay.mobile.nebulacore.web;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import androidx.localbroadcastmanager.a.a;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Bridge;
import com.alipay.mobile.h5container.api.H5Data;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5PageData;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5WebDriverHelper;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5DevDebugProvider;
import com.alipay.mobile.nebula.provider.H5DialogManagerProvider;
import com.alipay.mobile.nebula.provider.H5LocationDialogProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.webview.APJsPromptResult;
import com.alipay.mobile.nebula.webview.APJsResult;
import com.alipay.mobile.nebula.webview.APWebChromeClient;
import com.alipay.mobile.nebula.webview.APWebView;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.api.NebulaService;
import com.alipay.mobile.nebulacore.core.H5PageImpl;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.log.H5PerformanceScheduler;
import com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl;
import com.alipay.mobile.nebulacore.ui.H5Activity;
import com.alipay.mobile.nebulacore.ui.H5FileChooserActivity;
import com.alipay.mobile.nebulacore.ui.H5PromptDialog;
import com.alipay.mobile.nebulacore.view.H5Dialog;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public class H5WebChromeClient implements APWebChromeClient {
    private static final String BRIDGE_MSG_HEADER = "h5container.message: ";
    public static final String FILE_CHOOSER_RESULT = "FILE_CHOOSER_RESULT";
    private static b sSyncJsApiList;
    public String TAG = "H5WebChromeClient";
    /* access modifiers changed from: private */
    public H5Page h5Page;
    private Handler mConsoleMessageHandler;
    public APWebChromeClient.CustomViewCallback mCustomViewCallback;
    private boolean mEnableAsyncConsoleMessage = true;
    private H5PageData pageData;
    /* access modifiers changed from: private */
    public BroadcastReceiver previousReceiver;
    private H5WebDriverHelper webDriverHelper;

    public Bitmap getDefaultVideoPoster() {
        return null;
    }

    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
    }

    public void onCloseWindow(APWebView aPWebView) {
    }

    public boolean onCreateWindow(APWebView aPWebView, boolean z, boolean z2, Message message) {
        return false;
    }

    public void onGeolocationPermissionsHidePrompt() {
    }

    public void onRequestFocus(APWebView aPWebView) {
    }

    public H5WebChromeClient(H5PageImpl h5PageImpl) {
        this.TAG += hashCode();
        this.h5Page = h5PageImpl;
        this.pageData = h5PageImpl.getPageData();
        this.webDriverHelper = Nebula.getService().getWebDriverHelper();
        if (H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO.equals(H5Environment.getConfigWithProcessCache("h5_asyncConsoleMessage"))) {
            this.mEnableAsyncConsoleMessage = false;
        }
    }

    public H5Page getH5Page() {
        return this.h5Page;
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        this.webDriverHelper.onConsoleMessage(consoleMessage);
        if (consoleMessage == null) {
            return false;
        }
        String message = consoleMessage.message();
        String str = this.TAG;
        H5Log.d(str, "onConsoleMessage " + message + " lineNumber " + consoleMessage.lineNumber());
        if (H5BridgePolicy.get() == 0) {
            return handleMsgFromJs(message);
        }
        return false;
    }

    private void sendBugMeConsole(String str, String str2) {
        if (this.h5Page != null && H5ProviderManagerImpl.getInstance().getProvider(H5DevDebugProvider.class.getName()) != null) {
            final e eVar = new e();
            eVar.put("content", (Object) str);
            if (str2 != null) {
                eVar.put(H5Param.FUNC, (Object) str2);
            }
            if (this.mConsoleMessageHandler == null) {
                this.mConsoleMessageHandler = new Handler();
            }
            this.mConsoleMessageHandler.post(new Runnable() {
                public void run() {
                    if (H5WebChromeClient.this.h5Page != null) {
                        H5WebChromeClient.this.h5Page.sendEvent(H5Plugin.CommonEvents.H5_DEV_CONSOLE, eVar);
                    }
                }
            });
        }
    }

    private boolean handleMsgFromJs(String str) {
        H5ConfigProvider h5ConfigProvider;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String replaceFirst = str.startsWith(BRIDGE_MSG_HEADER) ? str.replaceFirst(BRIDGE_MSG_HEADER, "") : null;
        if (this.h5Page == null || !TextUtils.isEmpty(replaceFirst)) {
            e parseObject = H5Utils.parseObject(replaceFirst);
            if (parseObject == null || parseObject.isEmpty()) {
                return false;
            }
            String string = H5Utils.getString(parseObject, "clientId");
            String string2 = H5Utils.getString(parseObject, H5Param.FUNC);
            String string3 = H5Utils.getString(parseObject, H5Param.MSG_TYPE);
            boolean z = H5Utils.getBoolean(parseObject, H5Param.KEEP_CALLBACK, false);
            sendBugMeConsole(str, string2);
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            e jSONObject = H5Utils.getJSONObject(parseObject, H5Param.PARAM, (e) null);
            try {
                if (H5Param.MONITOR_PERFORMANCE.equals(string2)) {
                    b jSONArray = jSONObject.getJSONArray("data");
                    if (jSONArray.size() == 1) {
                        e jSONObject2 = jSONArray.getJSONObject(0);
                        if ("headScreen".equals(H5Utils.getString(jSONObject2, "name"))) {
                            onGetHeadScreen(jSONObject2.get("value"));
                        }
                    }
                }
            } catch (Throwable th) {
                H5Log.e(this.TAG, "Report perf to last pagedata error", th);
            }
            H5Page h5Page2 = this.h5Page;
            if (h5Page2 == null) {
                return true;
            }
            final H5Bridge bridge = h5Page2.getBridge();
            if (bridge == null) {
                H5Log.e(this.TAG, "bridge == null");
                return false;
            }
            H5Event.Builder builder = new H5Event.Builder();
            builder.action(string2).param(jSONObject).target(this.h5Page).type(string3).id(string).keepCallback(z);
            final H5Event build = builder.build();
            if (this.mEnableAsyncConsoleMessage) {
                if (sSyncJsApiList == null && (h5ConfigProvider = (H5ConfigProvider) Nebula.getProviderManager().getProvider(H5ConfigProvider.class.getName())) != null) {
                    sSyncJsApiList = H5Utils.parseArray(h5ConfigProvider.getConfig("h5_syncJsApi"));
                }
                b bVar = sSyncJsApiList;
                if (bVar == null || !bVar.contains(build.getAction())) {
                    if (this.mConsoleMessageHandler == null) {
                        this.mConsoleMessageHandler = new Handler();
                    }
                    this.mConsoleMessageHandler.post(new Runnable() {
                        public void run() {
                            bridge.sendToNative(build);
                        }
                    });
                    return true;
                }
            }
            bridge.sendToNative(build);
            return true;
        }
        if (!str.startsWith("invokeJS msgType") && !str.contains("load AlipayJSBridge")) {
            H5Log.d("NBH5AppContentLog", "AppId/" + H5Utils.getString(this.h5Page.getParams(), "appId") + AppConstants.COMMA + str);
        }
        sendBugMeConsole(str, (String) null);
        return false;
    }

    private void onGetHeadScreen(Object obj) {
        NebulaService service = Nebula.getService();
        if (!(service == null || this.pageData == null)) {
            e eVar = new e();
            eVar.put("headScreen", obj);
            eVar.put("url", (Object) this.pageData.getPageUrl());
            eVar.put("appId", (Object) this.pageData.getAppId());
            eVar.put(H5Param.isTinyApp, (Object) this.pageData.getIsTinyApp());
            service.sendEvent(H5Plugin.InternalEvents.H5_GET_HEAD_SCREEN, eVar);
        }
        H5PerformanceScheduler.appendHeadScreen(obj);
    }

    public void onProgressChanged(APWebView aPWebView, int i2) {
        if (Nebula.DEBUG) {
            H5Log.d(this.TAG, "onProgressChanged [progress] ".concat(String.valueOf(i2)));
        }
        if (this.h5Page != null) {
            e eVar = new e();
            eVar.put(H5Param.PROGRESS, (Object) Integer.valueOf(i2));
            this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_PROGRESS, eVar);
        }
    }

    public void onReceivedTitle(APWebView aPWebView, String str) {
        String str2 = this.TAG;
        H5Log.d(str2, "onReceivedTitle [title] " + str + " " + aPWebView.getUrl());
        this.pageData.setTitle(str);
        if (this.h5Page != null) {
            aPWebView.loadUrl("javascript:{window.__alipayConsole__ = window.console}");
            e eVar = new e();
            eVar.put("url", (Object) aPWebView.getUrl());
            eVar.put("title", (Object) str);
            this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_RECEIVED_TITLE, eVar);
        }
    }

    public void onReceivedIcon(APWebView aPWebView, Bitmap bitmap) {
        if (Nebula.DEBUG) {
            H5Log.d(this.TAG, "onReceivedIcon");
        }
    }

    public void onReceivedTouchIconUrl(APWebView aPWebView, String str, boolean z) {
        if (Nebula.DEBUG) {
            String str2 = this.TAG;
            H5Log.d(str2, "onReceivedTouchIconUrl. [url] " + str + " [precomposed] " + z);
        }
    }

    public boolean onJsBeforeUnload(APWebView aPWebView, String str, String str2, APJsResult aPJsResult) {
        if (!Nebula.DEBUG) {
            return false;
        }
        String str3 = this.TAG;
        H5Log.d(str3, "onJsBeforeUnload [url] " + str + " [message] " + str2);
        return false;
    }

    public void onGeolocationPermissionsShowPrompt(final String str, final GeolocationPermissions.Callback callback) {
        H5Log.d(this.TAG, "onGeolocationPermissionsShowPrompt ".concat(String.valueOf(str)));
        H5Page h5Page2 = this.h5Page;
        if (h5Page2 == null) {
            callback.invoke(str, true, true);
            return;
        }
        final String host = H5UrlHelper.parseUrl(h5Page2.getUrl()).getHost();
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5ProviderManagerImpl.getInstance().getProvider(H5ConfigProvider.class.getName());
        H5Data data = Nebula.getService().getData();
        boolean z = H5Utils.getBoolean(this.h5Page.getParams(), H5Param.isH5app, false);
        if (TextUtils.isEmpty(host) || ((data != null && "Y".equals(data.get(host))) || z || (h5ConfigProvider != null && h5ConfigProvider.permitLocation(this.h5Page.getUrl())))) {
            callback.invoke(str, true, true);
            return;
        }
        AnonymousClass3 r2 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (i2 == -1) {
                    callback.invoke(str, true, true);
                    H5Data data = Nebula.getService().getData();
                    if (data != null) {
                        data.set(host, "Y");
                        return;
                    }
                    return;
                }
                callback.invoke(str, false, false);
            }
        };
        if (!(this.h5Page.getContext().getContext() instanceof Activity)) {
            H5Log.d(this.TAG, "not H5Activity");
            callback.invoke(str, true, true);
            return;
        }
        Activity activity = (Activity) this.h5Page.getContext().getContext();
        if (activity.isFinishing()) {
            H5Log.d(this.TAG, "isFinishing");
            callback.invoke(str, true, true);
            return;
        }
        showLocationDialog(activity, host, r2);
    }

    private void showLocationDialog(Activity activity, String str, DialogInterface.OnClickListener onClickListener) {
        H5LocationDialogProvider h5LocationDialogProvider = (H5LocationDialogProvider) Nebula.getProviderManager().getProvider(H5LocationDialogProvider.class.getName());
        if (h5LocationDialogProvider != null) {
            AlertDialog createLocationDialog = h5LocationDialogProvider.createLocationDialog(activity, str, onClickListener);
            if (createLocationDialog != null) {
                createLocationDialog.show();
                return;
            }
            return;
        }
        onClickListener.onClick((DialogInterface) null, -1);
    }

    public View getVideoLoadingProgressView() {
        H5Log.debug(this.TAG, "getVideoLoadingProgressView");
        return null;
    }

    public void openFileChooser(ValueCallback valueCallback, boolean z) {
        H5Page h5Page2 = this.h5Page;
        if (h5Page2 != null && h5Page2.getContentView() != null) {
            try {
                Activity activityFromContext = getActivityFromContext(this.h5Page.getContentView().getContext());
                if (activityFromContext != null) {
                    a a2 = a.a(H5Environment.getContext());
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(FILE_CHOOSER_RESULT);
                    if (this.previousReceiver != null) {
                        a2.a(this.previousReceiver);
                        this.previousReceiver = null;
                    }
                    final a aVar = a2;
                    final Activity activity = activityFromContext;
                    final ValueCallback valueCallback2 = valueCallback;
                    final boolean z2 = z;
                    this.previousReceiver = new BroadcastReceiver() {
                        /* JADX WARNING: type inference failed for: r1v0, types: [android.content.BroadcastReceiver, android.database.Cursor] */
                        /* JADX WARNING: type inference failed for: r11v5, types: [android.net.Uri[]] */
                        /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
                        /* JADX WARNING: type inference failed for: r3v11, types: [android.net.Uri[]] */
                        /* JADX WARNING: type inference failed for: r1v3 */
                        /* JADX WARNING: Multi-variable type inference failed */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void onReceive(android.content.Context r10, android.content.Intent r11) {
                            /*
                                r9 = this;
                                java.lang.String r10 = ""
                                if (r11 == 0) goto L_0x00c6
                                java.lang.String r0 = r11.getAction()
                                if (r0 == 0) goto L_0x00c6
                                android.os.Bundle r0 = r11.getExtras()
                                if (r0 == 0) goto L_0x00c6
                                androidx.localbroadcastmanager.a.a r0 = r4
                                if (r0 != 0) goto L_0x0016
                                goto L_0x00c6
                            L_0x0016:
                                r0.a((android.content.BroadcastReceiver) r9)
                                com.alipay.mobile.nebulacore.web.H5WebChromeClient r0 = com.alipay.mobile.nebulacore.web.H5WebChromeClient.this
                                r1 = 0
                                android.content.BroadcastReceiver unused = r0.previousReceiver = r1
                                java.lang.String r0 = r11.getAction()
                                com.alipay.mobile.nebulacore.web.H5WebChromeClient r2 = com.alipay.mobile.nebulacore.web.H5WebChromeClient.this
                                java.lang.String r2 = r2.TAG
                                java.lang.String r3 = java.lang.String.valueOf(r0)
                                java.lang.String r4 = "onReceive action "
                                java.lang.String r3 = r4.concat(r3)
                                com.alipay.mobile.nebula.util.H5Log.d(r2, r3)
                                java.lang.String r2 = "FILE_CHOOSER_RESULT"
                                boolean r0 = r2.equals(r0)
                                if (r0 != 0) goto L_0x003d
                                return
                            L_0x003d:
                                r0 = 0
                                r2 = 1
                                android.os.Bundle r11 = r11.getExtras()     // Catch:{ all -> 0x0098 }
                                java.lang.String r3 = "fileUri"
                                java.lang.Object r11 = r11.get(r3)     // Catch:{ all -> 0x0098 }
                                android.net.Uri r11 = (android.net.Uri) r11     // Catch:{ all -> 0x0098 }
                                if (r11 != 0) goto L_0x0051
                                android.net.Uri r11 = android.net.Uri.parse(r10)     // Catch:{ all -> 0x0098 }
                            L_0x0051:
                                android.app.Activity r3 = r5     // Catch:{ all -> 0x0098 }
                                if (r3 == 0) goto L_0x006e
                                android.app.Activity r3 = r5     // Catch:{ all -> 0x0098 }
                                boolean r3 = r3.isFinishing()     // Catch:{ all -> 0x0098 }
                                if (r3 != 0) goto L_0x006e
                                if (r11 == 0) goto L_0x006e
                                android.app.Activity r3 = r5     // Catch:{ all -> 0x0098 }
                                android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ all -> 0x0098 }
                                r5 = 0
                                r6 = 0
                                r7 = 0
                                r8 = 0
                                r4 = r11
                                android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0098 }
                            L_0x006e:
                                com.alipay.mobile.nebulacore.web.H5WebChromeClient r3 = com.alipay.mobile.nebulacore.web.H5WebChromeClient.this     // Catch:{ all -> 0x0098 }
                                java.lang.String r3 = r3.TAG     // Catch:{ all -> 0x0098 }
                                java.lang.String r4 = "onReceive result "
                                java.lang.String r5 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x0098 }
                                java.lang.String r4 = r4.concat(r5)     // Catch:{ all -> 0x0098 }
                                com.alipay.mobile.nebula.util.H5Log.d(r3, r4)     // Catch:{ all -> 0x0098 }
                                android.webkit.ValueCallback r3 = r6     // Catch:{ all -> 0x0098 }
                                if (r3 == 0) goto L_0x0092
                                boolean r3 = r7     // Catch:{ all -> 0x0098 }
                                if (r3 != 0) goto L_0x0088
                                goto L_0x008d
                            L_0x0088:
                                android.net.Uri[] r3 = new android.net.Uri[r2]     // Catch:{ all -> 0x0098 }
                                r3[r0] = r11     // Catch:{ all -> 0x0098 }
                                r11 = r3
                            L_0x008d:
                                android.webkit.ValueCallback r3 = r6     // Catch:{ all -> 0x0098 }
                                r3.onReceiveValue(r11)     // Catch:{ all -> 0x0098 }
                            L_0x0092:
                                if (r1 == 0) goto L_0x00be
                                r1.close()
                                return
                            L_0x0098:
                                r11 = move-exception
                                com.alipay.mobile.nebulacore.web.H5WebChromeClient r3 = com.alipay.mobile.nebulacore.web.H5WebChromeClient.this     // Catch:{ all -> 0x00bf }
                                java.lang.String r3 = r3.TAG     // Catch:{ all -> 0x00bf }
                                java.lang.String r4 = "exception detail"
                                com.alipay.mobile.nebula.util.H5Log.e(r3, r4, r11)     // Catch:{ all -> 0x00bf }
                                android.net.Uri r10 = android.net.Uri.parse(r10)     // Catch:{ all -> 0x00bf }
                                android.webkit.ValueCallback r11 = r6     // Catch:{ all -> 0x00bf }
                                if (r11 == 0) goto L_0x00b9
                                boolean r11 = r7     // Catch:{ all -> 0x00bf }
                                if (r11 != 0) goto L_0x00af
                                goto L_0x00b4
                            L_0x00af:
                                android.net.Uri[] r11 = new android.net.Uri[r2]     // Catch:{ all -> 0x00bf }
                                r11[r0] = r10     // Catch:{ all -> 0x00bf }
                                r10 = r11
                            L_0x00b4:
                                android.webkit.ValueCallback r11 = r6     // Catch:{ all -> 0x00bf }
                                r11.onReceiveValue(r10)     // Catch:{ all -> 0x00bf }
                            L_0x00b9:
                                if (r1 == 0) goto L_0x00be
                                r1.close()
                            L_0x00be:
                                return
                            L_0x00bf:
                                r10 = move-exception
                                if (r1 == 0) goto L_0x00c5
                                r1.close()
                            L_0x00c5:
                                throw r10
                            L_0x00c6:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.web.H5WebChromeClient.AnonymousClass4.onReceive(android.content.Context, android.content.Intent):void");
                        }
                    };
                    a2.a(this.previousReceiver, intentFilter);
                    activityFromContext.startActivity(new Intent(activityFromContext, H5FileChooserActivity.class));
                }
            } catch (ClassCastException e2) {
                H5Log.e(this.TAG, "exception detail", e2);
            } catch (ActivityNotFoundException e3) {
                H5Log.e(this.TAG, "exception detail", e3);
            }
        }
    }

    public static Activity getActivityFromContext(Context context) {
        int i2 = 5;
        while (context != null) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if (context instanceof ContextWrapper) {
                context = ((ContextWrapper) context).getBaseContext();
            }
            int i3 = i2 - 1;
            if (i2 <= 0) {
                break;
            }
            i2 = i3;
        }
        return null;
    }

    public void onShowCustomView(View view, APWebChromeClient.CustomViewCallback customViewCallback) {
        String str = this.TAG;
        H5Log.d(str, "onShowCustomView [SDK Version] " + Build.VERSION.SDK_INT);
        this.mCustomViewCallback = customViewCallback;
    }

    public void onHideCustomView() {
        String str = this.TAG;
        H5Log.d(str, "onShowCustomView [SDK Version] " + Build.VERSION.SDK_INT);
        this.mCustomViewCallback = null;
    }

    public boolean onJsAlert(APWebView aPWebView, String str, String str2, final APJsResult aPJsResult) {
        String str3 = this.TAG;
        H5Log.d(str3, "onJsAlert " + str + " " + str2);
        H5Page h5Page2 = this.h5Page;
        if (h5Page2 == null) {
            H5Log.d(this.TAG, "h5Page == null");
            aPJsResult.cancel();
            return true;
        }
        Activity activity = (Activity) h5Page2.getContext().getContext();
        if (activity == null || activity.isFinishing()) {
            H5Log.d(this.TAG, " isFinishing");
            aPJsResult.cancel();
            return false;
        } else if (!(activity instanceof H5Activity)) {
            H5Log.d(this.TAG, "not H5Activity");
            return false;
        } else {
            final H5DialogManagerProvider h5DialogManagerProvider = (H5DialogManagerProvider) H5ProviderManagerImpl.getInstance().getProvider(H5DialogManagerProvider.class.getName());
            if (h5DialogManagerProvider == null) {
                final H5Dialog h5Dialog = new H5Dialog(this.h5Page.getContext().getContext());
                h5Dialog.setMessage((CharSequence) str2).setPositiveButton(R.string.h5_default_confirm, (View.OnClickListener) new View.OnClickListener() {
                    public void onClick(View view) {
                        h5Dialog.dismiss();
                    }
                }).setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialogInterface) {
                        APJsResult aPJsResult = aPJsResult;
                        if (aPJsResult != null) {
                            aPJsResult.confirm();
                        }
                    }
                }).show();
            } else {
                Dialog createDialog = h5DialogManagerProvider.createDialog(activity, (String) null, str2, H5Environment.getResources().getString(R.string.h5_default_confirm), (String) null, (String) null);
                h5DialogManagerProvider.setPositiveListener(new H5DialogManagerProvider.OnClickPositiveListener() {
                    public void onClick() {
                        APJsResult aPJsResult = aPJsResult;
                        if (aPJsResult != null) {
                            aPJsResult.confirm();
                        }
                        h5DialogManagerProvider.disMissDialog();
                        h5DialogManagerProvider.release();
                    }
                });
                createDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialogInterface) {
                        APJsResult aPJsResult = aPJsResult;
                        if (aPJsResult != null) {
                            aPJsResult.confirm();
                        }
                        h5DialogManagerProvider.release();
                    }
                });
                createDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                        APJsResult aPJsResult = aPJsResult;
                        if (aPJsResult != null) {
                            aPJsResult.confirm();
                        }
                        h5DialogManagerProvider.release();
                    }
                });
                h5DialogManagerProvider.showDialog();
            }
            return true;
        }
    }

    public boolean onJsConfirm(APWebView aPWebView, String str, String str2, final APJsResult aPJsResult) {
        String str3 = this.TAG;
        H5Log.d(str3, "onJsConfirm " + str + " " + str2);
        H5Page h5Page2 = this.h5Page;
        if (h5Page2 == null) {
            H5Log.d(this.TAG, "h5Page == null");
            aPJsResult.cancel();
            return true;
        }
        Activity activity = (Activity) h5Page2.getContext().getContext();
        if (activity == null || activity.isFinishing()) {
            H5Log.d(this.TAG, "  isFinishing");
            aPJsResult.cancel();
            return false;
        } else if (!(activity instanceof H5Activity)) {
            H5Log.d(this.TAG, "not  H5activity");
            return false;
        } else {
            final H5DialogManagerProvider h5DialogManagerProvider = (H5DialogManagerProvider) H5ProviderManagerImpl.getInstance().getProvider(H5DialogManagerProvider.class.getName());
            if (h5DialogManagerProvider == null) {
                final H5Dialog h5Dialog = new H5Dialog(this.h5Page.getContext().getContext());
                h5Dialog.setMessage((CharSequence) str2).setPositiveButton(R.string.h5_default_confirm, (View.OnClickListener) new View.OnClickListener() {
                    public void onClick(View view) {
                        aPJsResult.confirm();
                        h5Dialog.dismiss();
                    }
                }).setNegativeButton(R.string.h5_default_cancel, (View.OnClickListener) new View.OnClickListener() {
                    public void onClick(View view) {
                        aPJsResult.cancel();
                        h5Dialog.dismiss();
                    }
                }).show();
            } else {
                Dialog createDialog = h5DialogManagerProvider.createDialog(activity, (String) null, str2, H5Environment.getResources().getString(R.string.h5_default_confirm), H5Environment.getResources().getString(R.string.h5_default_cancel), (String) null);
                h5DialogManagerProvider.setPositiveListener(new H5DialogManagerProvider.OnClickPositiveListener() {
                    public void onClick() {
                        APJsResult aPJsResult = aPJsResult;
                        if (aPJsResult != null) {
                            aPJsResult.confirm();
                        }
                        h5DialogManagerProvider.disMissDialog();
                    }
                });
                h5DialogManagerProvider.setNegativeListener(new H5DialogManagerProvider.OnClickNegativeListener() {
                    public void onClick() {
                        APJsResult aPJsResult = aPJsResult;
                        if (aPJsResult != null) {
                            aPJsResult.cancel();
                        }
                        h5DialogManagerProvider.disMissDialog();
                    }
                });
                createDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                        APJsResult aPJsResult = aPJsResult;
                        if (aPJsResult != null) {
                            aPJsResult.cancel();
                        }
                    }
                });
                h5DialogManagerProvider.showDialog();
            }
            return true;
        }
    }

    public boolean onJsPrompt(APWebView aPWebView, String str, String str2, String str3, final APJsPromptResult aPJsPromptResult) {
        String str4 = this.TAG;
        H5Log.d(str4, "onJsPrompt: url:" + str + " message:" + str2 + " defaultValue:" + str3);
        if (H5BridgePolicy.get() != 1 || !handleMsgFromJs(str2)) {
            H5Page h5Page2 = this.h5Page;
            if (h5Page2 == null) {
                aPJsPromptResult.cancel();
                return true;
            }
            Activity activity = (Activity) h5Page2.getContext().getContext();
            if (activity == null || activity.isFinishing()) {
                aPJsPromptResult.cancel();
                return false;
            } else if (!(activity instanceof H5Activity)) {
                return false;
            } else {
                final H5PromptDialog h5PromptDialog = new H5PromptDialog(activity, (String) null, str2, H5Environment.getResources().getString(R.string.h5_default_confirm), H5Environment.getResources().getString(R.string.h5_default_cancel));
                h5PromptDialog.show();
                h5PromptDialog.getInputContent().setHint(str3);
                h5PromptDialog.setPositiveListener(new H5PromptDialog.OnClickPositiveListener() {
                    public void onClick(String str) {
                        APJsPromptResult aPJsPromptResult = aPJsPromptResult;
                        if (aPJsPromptResult != null) {
                            aPJsPromptResult.confirm(h5PromptDialog.getInputContent().getText().toString());
                        }
                    }
                });
                h5PromptDialog.setNegativeListener(new H5PromptDialog.OnClickNegativeListener() {
                    public void onClick() {
                        APJsPromptResult aPJsPromptResult = aPJsPromptResult;
                        if (aPJsPromptResult != null) {
                            aPJsPromptResult.cancel();
                        }
                    }
                });
                h5PromptDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                        APJsPromptResult aPJsPromptResult = aPJsPromptResult;
                        if (aPJsPromptResult != null) {
                            aPJsPromptResult.cancel();
                        }
                    }
                });
                return true;
            }
        } else {
            aPJsPromptResult.confirm("true");
            return true;
        }
    }

    public void onRelease() {
        this.h5Page = null;
    }
}
