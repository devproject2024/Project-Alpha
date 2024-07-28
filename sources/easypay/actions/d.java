package easypay.actions;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.gson.f;
import easypay.actions.EasypayBrowserFragment;
import easypay.entity.AssistMetaData;
import easypay.entity.Operation;
import easypay.listeners.AppCallbacks;
import easypay.listeners.WebClientListener;
import easypay.manager.AssistMerchantDetails;
import easypay.manager.Constants;
import easypay.manager.EasypayWebViewClient;
import easypay.utils.AssistLogs;
import easypay.widget.Passcode;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import paytm.assist.easypay.easypay.R;

public final class d implements AppCallbacks, WebClientListener, easypay.listeners.a {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public EasypayBrowserFragment f46080a;

    /* renamed from: b  reason: collision with root package name */
    HashMap<String, Operation> f46081b;

    /* renamed from: c  reason: collision with root package name */
    private EasypayWebViewClient f46082c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Activity f46083d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public WebView f46084e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f46085f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f46086g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f46087h;

    public final void OnWcPageFinish(WebView webView, String str) {
    }

    public final void OnWcPageStart(WebView webView, String str, Bitmap bitmap) {
    }

    public final void OnWcSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
    }

    public final void WcshouldInterceptRequest(WebView webView, String str) {
    }

    public final boolean WcshouldOverrideUrlLoading(WebView webView, Object obj) {
        return false;
    }

    public final void onApiError(String str) {
    }

    public final void onNetworkError(String str) {
    }

    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
    }

    d(Activity activity, WebView webView, EasypayBrowserFragment easypayBrowserFragment, EasypayWebViewClient easypayWebViewClient, HashMap<String, Operation> hashMap) {
        if (activity != null) {
            try {
                this.f46083d = activity;
                this.f46080a = easypayBrowserFragment;
                this.f46084e = webView;
                if (hashMap != null) {
                    this.f46081b = hashMap;
                } else {
                    this.f46081b = new HashMap<>();
                }
                if (easypayWebViewClient == null) {
                    this.f46082c = AssistMerchantDetails.getInstance().getWebClientInstance();
                } else {
                    this.f46082c = easypayWebViewClient;
                }
                AssistMerchantDetails.getInstance().getEasyPayHelper().addJsCallListener(this);
                AssistMerchantDetails.getInstance().setListener(this);
            } catch (Exception e2) {
                AssistLogs.printLog("EXCEPTION", e2);
            }
            EasypayWebViewClient easypayWebViewClient2 = this.f46082c;
            if (easypayWebViewClient2 != null) {
                easypayWebViewClient2.addAssistWebClientListener(this);
            }
        }
    }

    private void a(boolean z, String str) {
        try {
            AssistLogs.printLog("insideSuccessEvent", this);
            AssistLogs.printLog("Logging wrapper page event:" + z, this);
            if (z) {
                AssistMerchantDetails.getInstance().setBankPageType(Constants.EXTRA_BANK_PAGE_WRAPPER);
            }
            AssistMerchantDetails instance = AssistMerchantDetails.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append(z);
            instance.setEventInEventMap(Constants.EVENTS_IS_WRAPPER_PAGER, sb.toString());
            if (!TextUtils.isEmpty(str)) {
                AssistMerchantDetails instance2 = AssistMerchantDetails.getInstance();
                instance2.logNewEvents(Constants.EVENTS_CALLBACK_FUNCTION, "callback function passed " + str);
                a("javascript:" + str);
            } else {
                AssistMerchantDetails.getInstance().logNewEvents(Constants.EVENTS_CALLBACK_FUNCTION, "callback function empty ");
            }
            if (z) {
                this.f46086g = true;
            } else {
                try {
                    if (this.f46080a != null && AssistMerchantDetails.getInstance().isAdded(this.f46080a)) {
                        AssistLogs.printLog("Activating otphelper", this);
                        this.f46080a.c(this.f46083d.getString(R.string.waiting_for_otp_label, new Object[]{AssistMerchantDetails.getInstance().geTxnBank()}));
                        this.f46080a.a(R.id.otpHelper, Boolean.TRUE);
                        new Handler().postDelayed(new a(), 10000);
                    }
                } catch (Exception e2) {
                    try {
                        AssistLogs.printLog("EXCEPTION", e2);
                    } catch (Exception e3) {
                        AssistLogs.printLog("EXCEPTION", e3);
                    }
                }
            }
            e.a().c();
            b(Constants.SUBMIT_BTN);
            b(Constants.FILLER_FROM_CODE);
            b(Constants.RESEND_BTN);
        } catch (Exception e4) {
            AssistLogs.printLog("Any Exception in OTP Flow" + e4.getMessage(), this);
            AssistLogs.printLog("EXCEPTION", e4);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(String str) {
        Operation operation = this.f46081b.get(str);
        if (operation != null && !TextUtils.isEmpty(operation.getActionMetadata())) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1590453867:
                    if (str.equals(Constants.SUBMIT_BTN)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -83625758:
                    if (str.equals(Constants.READ_OTP)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1110972755:
                    if (str.equals(Constants.FILLER_FROM_CODE)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1559877390:
                    if (str.equals(Constants.FILLER_FROM_WEB)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1918496694:
                    if (str.equals(Constants.RESEND_BTN)) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 != 0 && c2 != 1 && c2 != 2 && c2 != 3 && c2 == 4) {
                AssistLogs.printLog("New otphelper:FILLER_FROM_WEB", this);
                a(operation.getJsTemplate());
            }
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        try {
            if (this.f46080a != null && this.f46080a.isVisible() && AssistMerchantDetails.getInstance().isAdded(this.f46080a)) {
                this.f46080a.c(this.f46083d.getString(R.string.otp_could_not_detcted));
                AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_SMS_DETECTED, "false");
                AssistMerchantDetails.getInstance().setRiskExtendedInfoParam(Constants.EVENTS_SMS_DETECTED, "false");
                this.f46080a.c(false);
                this.f46080a.n = true;
                this.f46080a.e();
            }
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    class a implements Runnable {
        a() {
        }

        public final void run() {
            if (d.this.f46083d != null) {
                AssistLogs.printLog("About to fire OTP not detected and broadcast received = " + d.this.f46085f, this);
                if (!d.this.f46083d.isFinishing() && AssistMerchantDetails.getInstance().isAdded(d.this.f46080a) && !d.this.f46085f) {
                    AssistLogs.printLog("OTP not detected ", this);
                    AssistMerchantDetails.getInstance().logNewEvents(Constants.TIMESTAMP_OTP_NOT_AUTO_READ, easypay.utils.b.d());
                    d.this.a();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, String str2, String str3) {
        String replace = str2.replace(str, str3);
        AssistLogs.printLog("Filler from Code ".concat(String.valueOf(replace)), this);
        a(replace);
    }

    public final void a(int i2) {
        if (i2 == 300) {
            try {
                this.f46087h = true;
            } catch (Exception e2) {
                AssistLogs.printLog("EXCEPTION", e2);
            }
        }
    }

    public final void smsReceivedCallback(String str, boolean z) {
        JSONObject jSONObject;
        if (z) {
            if (this.f46086g) {
                Passcode passcode = this.f46080a.k;
                String str2 = null;
                if ((passcode != null ? passcode.getTag() : null) != null) {
                    Operation operation = (Operation) this.f46080a.k.getTag();
                    try {
                        jSONObject = new JSONObject(operation.getActionMetadata());
                    } catch (JSONException e2) {
                        AssistLogs.printLog("EXCEPTION", e2);
                        jSONObject = null;
                    }
                    f fVar = new f();
                    if (jSONObject != null) {
                        str2 = jSONObject.toString();
                    }
                    a(((AssistMetaData) fVar.a(str2, AssistMetaData.class)).getJsField(), operation.getJsTemplate(), str);
                }
            }
            this.f46085f = true;
            try {
                AssistLogs.printLog("After Sms :fill otp on assist:isAssistVisible" + this.f46080a.f46018e, this);
                if (this.f46080a != null) {
                    if (AssistMerchantDetails.getInstance().isAdded(this.f46080a) && this.f46080a.f46018e) {
                        try {
                            this.f46080a.c(this.f46083d.getString(R.string.otp_detected));
                            if (this.f46080a.k != null) {
                                this.f46080a.k.setText(str);
                                AssistMerchantDetails.getInstance().logNewEvents(Constants.TIMESTAMP_OTP_AUTO_READ, easypay.utils.b.d());
                                AssistMerchantDetails.getInstance().setRiskExtendedInfoParam(Constants.EVENTS_IS_AUTOFILL_SUCCESS, "true");
                                AssistMerchantDetails.getInstance().setRiskExtendedInfoParam(Constants.EVENTS_IS_AUTOFILL_SUCCESS, "true");
                            }
                            EasypayBrowserFragment easypayBrowserFragment = this.f46080a;
                            boolean z2 = this.f46087h;
                            if (AssistMerchantDetails.getInstance().getAssistFeatureEvents() == null || AssistMerchantDetails.getInstance().getAssistFeatureEvents().isNewUIEnabled()) {
                                easypayBrowserFragment.n = true;
                                easypayBrowserFragment.e();
                            } else {
                                easypayBrowserFragment.n = false;
                                easypayBrowserFragment.a(R.id.btn_submit_otp, Boolean.FALSE);
                            }
                            easypayBrowserFragment.m = true;
                            String string = easypayBrowserFragment.getString(R.string.submit_time);
                            try {
                                if (easypayBrowserFragment.j != null) {
                                    easypayBrowserFragment.j.cancel();
                                }
                                if (!z2) {
                                    easypayBrowserFragment.a(false);
                                    easypayBrowserFragment.c(true);
                                    AssistLogs.printLog("Timer called", easypayBrowserFragment);
                                    if (!(AssistMerchantDetails.getInstance().getAssistFeatureEvents() == null || AssistMerchantDetails.getInstance().getAssistFeatureEvents().getAutoSubmitTimer() == 0)) {
                                        easypayBrowserFragment.o = easypayBrowserFragment.l.getAssistFeatureEvents().getAutoSubmitTimer();
                                        AssistMerchantDetails.getInstance().logNewEvents(Constants.EVENTS_AUTO_SUBMIT_TIMER, Integer.valueOf(easypayBrowserFragment.o));
                                    }
                                    easypayBrowserFragment.j = new EasypayBrowserFragment.l((long) (easypayBrowserFragment.o * 1000), string).start();
                                    return;
                                }
                                easypayBrowserFragment.c(false);
                                if (easypayBrowserFragment.f46022i != null) {
                                    easypayBrowserFragment.f46022i.setEnabled(true);
                                    return;
                                }
                                return;
                            } catch (Exception e3) {
                                AssistLogs.printLog("EXCEPTION", e3);
                                return;
                            }
                        } catch (Exception e4) {
                            AssistLogs.printLog("EXCEPTION", e4);
                            return;
                        }
                    }
                }
                AssistMerchantDetails.getInstance().setRiskExtendedInfoParam(Constants.EVENTS_IS_AUTOFILL_SUCCESS, "false");
                AssistMerchantDetails.getInstance().setRiskExtendedInfoParam(Constants.EVENTS_IS_AUTOFILL_SUCCESS, "false");
            } catch (Exception e5) {
                AssistLogs.printLog("EXCEPTION", e5);
            }
        } else {
            AssistMerchantDetails.getInstance().logNewEvents(Constants.TIMESTAMP_OTP_NOT_AUTO_READ, easypay.utils.b.d());
            a();
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f46089a;

        b(String str) {
            this.f46089a = str;
        }

        public final void run() {
            AssistLogs.printLog("Injecting Js", this);
            if (Build.VERSION.SDK_INT >= 19) {
                d.this.f46084e.evaluateJavascript(this.f46089a, new a());
            } else {
                d.this.f46084e.loadUrl(this.f46089a);
            }
        }

        class a implements ValueCallback<String> {
            a() {
            }

            public final /* synthetic */ void onReceiveValue(Object obj) {
                AssistLogs.printLog("JS Injected. Value received:".concat(String.valueOf((String) obj)), this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        if (this.f46084e != null && !TextUtils.isEmpty(str)) {
            this.f46084e.post(new b(str));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0095, code lost:
        r4 = r2.f46080a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00bc, code lost:
        r4 = r2.f46080a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r3, java.lang.String r4, int r5) {
        /*
            r2 = this;
            java.lang.String r3 = "EXCEPTION"
            r0 = 1
            r1 = 112(0x70, float:1.57E-43)
            if (r5 == r1) goto L_0x00cb
            r1 = 158(0x9e, float:2.21E-43)
            if (r5 == r1) goto L_0x00b8
            r1 = 201(0xc9, float:2.82E-43)
            if (r5 == r1) goto L_0x00b5
            r0 = 0
            switch(r5) {
                case 107: goto L_0x004d;
                case 108: goto L_0x003f;
                case 109: goto L_0x0017;
                case 110: goto L_0x0016;
                default: goto L_0x0013;
            }
        L_0x0013:
            switch(r5) {
                case 221: goto L_0x00a5;
                case 222: goto L_0x0091;
                case 223: goto L_0x0083;
                case 224: goto L_0x006a;
                case 225: goto L_0x0058;
                default: goto L_0x0016;
            }
        L_0x0016:
            return
        L_0x0017:
            easypay.actions.EasypayBrowserFragment r5 = r2.f46080a     // Catch:{ Exception -> 0x003a }
            if (r5 == 0) goto L_0x0039
            easypay.actions.EasypayBrowserFragment r5 = r2.f46080a     // Catch:{ Exception -> 0x003a }
            boolean r5 = r5.isResumed()     // Catch:{ Exception -> 0x003a }
            if (r5 == 0) goto L_0x0039
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003a }
            java.lang.String r0 = "Show Log Called :Minimizing Assist:"
            r5.<init>(r0)     // Catch:{ Exception -> 0x003a }
            r5.append(r4)     // Catch:{ Exception -> 0x003a }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x003a }
            easypay.utils.AssistLogs.printLog(r4, r2)     // Catch:{ Exception -> 0x003a }
            easypay.actions.EasypayBrowserFragment r4 = r2.f46080a     // Catch:{ Exception -> 0x003a }
            r4.removeAssist()     // Catch:{ Exception -> 0x003a }
        L_0x0039:
            return
        L_0x003a:
            r4 = move-exception
            easypay.utils.AssistLogs.printLog(r3, r4)     // Catch:{ Exception -> 0x00d4 }
            return
        L_0x003f:
            java.lang.String r5 = "OTP value change requested. New Value:"
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r4 = r5.concat(r4)     // Catch:{ Exception -> 0x00d4 }
            easypay.utils.AssistLogs.printLog(r4, r2)     // Catch:{ Exception -> 0x00d4 }
            return
        L_0x004d:
            java.lang.String r4 = "Success Event called for ACS page"
            easypay.utils.AssistLogs.printLog(r4, r2)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r4 = ""
            r2.a(r0, r4)     // Catch:{ Exception -> 0x00d4 }
            return
        L_0x0058:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r0 = "javascript:"
            r5.<init>(r0)     // Catch:{ Exception -> 0x00d4 }
            r5.append(r4)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x00d4 }
            r2.a((java.lang.String) r4)     // Catch:{ Exception -> 0x00d4 }
            return
        L_0x006a:
            easypay.actions.EasypayBrowserFragment r4 = r2.f46080a     // Catch:{ Exception -> 0x00d4 }
            if (r4 == 0) goto L_0x00d3
            easypay.actions.EasypayBrowserFragment r4 = r2.f46080a     // Catch:{ Exception -> 0x00d4 }
            int r5 = paytm.assist.easypay.easypay.R.id.parentPanel     // Catch:{ Exception -> 0x00d4 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x00d4 }
            r4.a((int) r5, (java.lang.Boolean) r1)     // Catch:{ Exception -> 0x00d4 }
            easypay.actions.EasypayBrowserFragment r4 = r2.f46080a     // Catch:{ Exception -> 0x00d4 }
            r4.c((boolean) r0)     // Catch:{ Exception -> 0x00d4 }
            easypay.actions.e r4 = easypay.actions.e.a()     // Catch:{ Exception -> 0x00d4 }
            r4.f46092a = r0     // Catch:{ Exception -> 0x00d4 }
            return
        L_0x0083:
            easypay.actions.EasypayBrowserFragment r4 = r2.f46080a     // Catch:{ Exception -> 0x00d4 }
            if (r4 == 0) goto L_0x00d3
            easypay.actions.EasypayBrowserFragment r4 = r2.f46080a     // Catch:{ Exception -> 0x00d4 }
            int r5 = paytm.assist.easypay.easypay.R.id.parentPanel     // Catch:{ Exception -> 0x00d4 }
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x00d4 }
            r4.a((int) r5, (java.lang.Boolean) r0)     // Catch:{ Exception -> 0x00d4 }
            return
        L_0x0091:
            easypay.actions.EasypayBrowserFragment r4 = r2.f46080a     // Catch:{ Exception -> 0x00d4 }
            if (r4 == 0) goto L_0x00d3
            easypay.actions.EasypayBrowserFragment r4 = r2.f46080a     // Catch:{ Exception -> 0x00d4 }
            android.widget.ImageView r5 = r4.f46021h     // Catch:{ Exception -> 0x00d4 }
            if (r5 == 0) goto L_0x00a4
            int r5 = r5.getVisibility()     // Catch:{ Exception -> 0x00d4 }
            if (r5 != 0) goto L_0x00a4
            r4.b()     // Catch:{ Exception -> 0x00d4 }
        L_0x00a4:
            return
        L_0x00a5:
            easypay.actions.EasypayBrowserFragment r4 = r2.f46080a     // Catch:{ Exception -> 0x00d4 }
            if (r4 == 0) goto L_0x00d3
            easypay.actions.EasypayBrowserFragment r4 = r2.f46080a     // Catch:{ Exception -> 0x00d4 }
            r4.minimizeAssist()     // Catch:{ Exception -> 0x00d4 }
            easypay.actions.e r4 = easypay.actions.e.a()     // Catch:{ Exception -> 0x00d4 }
            r4.f46092a = r0     // Catch:{ Exception -> 0x00d4 }
            return
        L_0x00b5:
            r2.f46086g = r0     // Catch:{ Exception -> 0x00d4 }
            return
        L_0x00b8:
            easypay.actions.EasypayBrowserFragment r4 = r2.f46080a     // Catch:{ Exception -> 0x00d4 }
            if (r4 == 0) goto L_0x00d3
            easypay.actions.EasypayBrowserFragment r4 = r2.f46080a     // Catch:{ Exception -> 0x00d4 }
            androidx.appcompat.app.AppCompatActivity r5 = r4.f46015b     // Catch:{ Exception -> 0x00d4 }
            if (r5 == 0) goto L_0x00ca
            easypay.actions.EasypayBrowserFragment$n r0 = new easypay.actions.EasypayBrowserFragment$n     // Catch:{ Exception -> 0x00d4 }
            r0.<init>()     // Catch:{ Exception -> 0x00d4 }
            r5.runOnUiThread(r0)     // Catch:{ Exception -> 0x00d4 }
        L_0x00ca:
            return
        L_0x00cb:
            java.lang.String r5 = "Success Event called for wrapper page"
            easypay.utils.AssistLogs.printLog(r5, r2)     // Catch:{ Exception -> 0x00d4 }
            r2.a(r0, r4)     // Catch:{ Exception -> 0x00d4 }
        L_0x00d3:
            return
        L_0x00d4:
            r4 = move-exception
            easypay.utils.AssistLogs.printLog(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: easypay.actions.d.a(java.lang.String, java.lang.String, int):void");
    }
}
