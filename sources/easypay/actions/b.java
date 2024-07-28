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
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.f;
import easypay.actions.EasypayBrowserFragment;
import easypay.entity.AssistDetailsResponse;
import easypay.entity.Operation;
import easypay.listeners.WebClientListener;
import easypay.manager.AssistMerchantDetails;
import easypay.manager.Constants;
import easypay.utils.AssistLogs;
import java.util.ArrayList;
import java.util.HashMap;
import paytm.assist.easypay.easypay.R;

public final class b implements WebClientListener, easypay.listeners.a {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Operation> f46067a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public String f46068b;

    /* renamed from: c  reason: collision with root package name */
    boolean f46069c = false;
    /* access modifiers changed from: package-private */

    /* renamed from: d  reason: collision with root package name */
    public int f46070d = 0;

    /* renamed from: e  reason: collision with root package name */
    private CheckBox f46071e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public WebView f46072f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public EasypayBrowserFragment f46073g;

    /* renamed from: h  reason: collision with root package name */
    private StringBuilder f46074h;

    /* renamed from: i  reason: collision with root package name */
    private Operation f46075i;
    /* access modifiers changed from: private */
    public easypay.utils.a j;

    public final void OnWcPageStart(WebView webView, String str, Bitmap bitmap) {
    }

    public final void OnWcSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
    }

    public final void WcshouldInterceptRequest(WebView webView, String str) {
    }

    public final boolean WcshouldOverrideUrlLoading(WebView webView, Object obj) {
        return false;
    }

    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
    }

    b(HashMap<String, Operation> hashMap, WebView webView, Activity activity, AssistDetailsResponse assistDetailsResponse) {
        if (hashMap != null) {
            try {
                this.f46067a = hashMap;
            } catch (Exception e2) {
                AssistLogs.printLog("EXCEPTION", e2);
                return;
            }
        }
        if (assistDetailsResponse != null) {
            this.f46068b = assistDetailsResponse.getBank();
        }
        this.f46072f = webView;
        this.f46071e = (CheckBox) activity.findViewById(R.id.cb_nb_userId);
        AssistMerchantDetails.getInstance().getEasyPayHelper().addJsCallListener(this);
        this.f46073g = AssistMerchantDetails.getInstance().getFragment();
        AssistMerchantDetails.getInstance().getWebClientInstance().addAssistWebClientListener(this);
        AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_IS_NET_BANKING, "true");
        if (!TextUtils.isEmpty(webView.getUrl())) {
            AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_NB_PAGE_URL, webView.getUrl());
            AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_ACS_URL, webView.getUrl());
        } else {
            AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_NB_PAGE_URL, "URl Not supported|couldnot invoke netbaking asssist");
        }
        this.f46074h = new StringBuilder();
        this.f46073g.b(true);
        this.j = new easypay.utils.a(activity.getApplicationContext(), "PaytmAsist");
        new f();
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, Operation operation) {
        if (operation != null) {
            try {
                if (!TextUtils.isEmpty(operation.getJsTemplate())) {
                    char c2 = 65535;
                    try {
                        switch (str.hashCode()) {
                            case -2086665488:
                                if (str.equals(Constants.NEXT_BTN)) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case -1590453867:
                                if (str.equals(Constants.SUBMIT_BTN)) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case -469982381:
                                if (str.equals(Constants.AUTOFILL_USERID)) {
                                    c2 = 8;
                                    break;
                                }
                                break;
                            case -83625758:
                                if (str.equals(Constants.READ_OTP)) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case 64933036:
                                if (str.equals(Constants.PASSWORD_INPUT_REGISTER)) {
                                    c2 = 7;
                                    break;
                                }
                                break;
                            case 1110972755:
                                if (str.equals(Constants.FILLER_FROM_CODE)) {
                                    c2 = 4;
                                    break;
                                }
                                break;
                            case 1201244404:
                                if (str.equals(Constants.PREVIOUS_BTN)) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 1559877390:
                                if (str.equals(Constants.FILLER_FROM_WEB)) {
                                    c2 = 5;
                                    break;
                                }
                                break;
                            case 1881123402:
                                if (str.equals(Constants.PASSWORD_FINDER)) {
                                    c2 = 6;
                                    break;
                                }
                                break;
                        }
                        switch (c2) {
                            case 0:
                                return;
                            case 1:
                                AssistLogs.printLog("Action  SUBMIT_BTN", this);
                                c(operation.getJsTemplate());
                                if (this.f46073g != null && AssistMerchantDetails.getInstance().isAdded(this.f46073g)) {
                                    this.f46073g.a("", 3);
                                    return;
                                }
                                return;
                            case 2:
                                AssistLogs.printLog("Action  NEXT_BTN", this);
                                c(operation.getJsTemplate());
                                return;
                            case 3:
                                c(operation.getJsTemplate());
                                return;
                            case 4:
                                return;
                            case 5:
                                AssistLogs.printLog(" called Action FILLER_FROM_WEB ", this);
                                c(operation.getJsTemplate());
                                return;
                            case 6:
                            case 7:
                                c(operation.getJsTemplate());
                                return;
                            case 8:
                                AssistLogs.printLog("Inside AUTOFILL_USERID", this);
                                this.f46075i = operation;
                                a();
                                return;
                            default:
                                return;
                        }
                    } catch (Exception e2) {
                        AssistLogs.printLog("EXCEPTION", e2);
                    }
                }
            } catch (Exception e3) {
                AssistLogs.printLog("EXCEPTION", e3);
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        String jsTemplate = this.f46075i.getJsTemplate();
        try {
            int indexOf = jsTemplate.indexOf("''");
            StringBuilder sb = new StringBuilder();
            int i2 = indexOf + 1;
            sb.append(jsTemplate.substring(0, i2));
            sb.append(str);
            sb.append(jsTemplate.substring(i2));
            String sb2 = sb.toString();
            AssistLogs.printLog("Autofill JS After UserId" + sb2, this);
            if (this.f46073g != null && AssistMerchantDetails.getInstance().isAdded(this.f46073g)) {
                this.f46073g.b(str);
            }
            AssistLogs.printLog("autofill js:" + sb2, this);
            c(sb2);
            if (!TextUtils.isEmpty(str)) {
                AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_IS_AUTOFILL_USER_ID_SUCCESS, "true");
            }
        } catch (Exception e2) {
            AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_IS_AUTOFILL_USER_ID_SUCCESS, "false");
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    class a implements Runnable {
        a() {
        }

        public final void run() {
            String string = b.this.j.getString(Constants.USER_ID_NET_BANK_KEY, "");
            AssistLogs.printLog("inside fetch USerID".concat(String.valueOf(string)), this);
            try {
                HashMap hashMap = (HashMap) new f().a(string, new C0772a().getType());
                if (b.this.f46073g != null && hashMap != null) {
                    AssistLogs.printLog("inside fetch USerID", this);
                    ArrayList arrayList = (ArrayList) hashMap.get(b.this.f46068b);
                    if (arrayList != null) {
                        int unused = b.this.f46070d = arrayList.size();
                        if (b.this.f46070d > 0) {
                            b.this.f46073g.a((String) arrayList.get(b.this.f46070d - 1));
                            if (b.this.f46070d > 1) {
                                b.this.f46073g.a(b.this.f46070d, true);
                                b.this.f46073g.f46019f = true;
                                EasypayBrowserFragment b2 = b.this.f46073g;
                                AppCompatActivity appCompatActivity = b2.f46015b;
                                if (appCompatActivity != null) {
                                    appCompatActivity.runOnUiThread(new EasypayBrowserFragment.j(arrayList));
                                }
                            } else {
                                b.this.f46073g.a(b.this.f46070d, false);
                                b.this.f46073g.f46019f = false;
                            }
                            b.this.b((String) arrayList.get(b.this.f46070d - 1));
                            b.this.f46073g.d();
                        }
                    }
                }
            } catch (Exception e2) {
                AssistLogs.printLog("EXCEPTION", e2);
            }
        }

        /* renamed from: easypay.actions.b$a$a  reason: collision with other inner class name */
        class C0772a extends com.google.gson.b.a<HashMap<String, ArrayList<String>>> {
            C0772a() {
            }
        }
    }

    private void a() {
        AssistLogs.printLog("inside fetch USerID before run", this);
        new Thread(new a()).start();
    }

    /* renamed from: easypay.actions.b$b  reason: collision with other inner class name */
    class C0773b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f46077a;

        C0773b(String str) {
            this.f46077a = str;
        }

        public final void run() {
            AssistLogs.printLog("Injecting JS", this);
            if (Build.VERSION.SDK_INT >= 19) {
                b.this.f46072f.evaluateJavascript(this.f46077a, new a());
            } else {
                b.this.f46072f.loadUrl(this.f46077a);
            }
        }

        /* renamed from: easypay.actions.b$b$a */
        class a implements ValueCallback<String> {
            a() {
            }

            public final /* synthetic */ void onReceiveValue(Object obj) {
                AssistLogs.printLog("JS Injected. Value received:".concat(String.valueOf((String) obj)), this);
            }
        }
    }

    private void c(String str) {
        try {
            if (this.f46072f != null && !TextUtils.isEmpty(str)) {
                this.f46072f.post(new C0773b(str));
            } else if (this.f46072f == null) {
                AssistLogs.printLog("Browser null", this);
            } else if (TextUtils.isEmpty(str)) {
                AssistLogs.printLog("Javascript Empty", this);
            }
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    public final void OnWcPageFinish(WebView webView, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (this.f46073g != null) {
                    this.f46073g.a("", 3);
                }
            } else if (this.f46073g != null) {
                this.f46073g.a("", 4);
                this.f46073g.a("", 4);
            }
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    public final void a(String str, String str2, int i2) {
        if (i2 != 106) {
            if (i2 == 108) {
                return;
            }
            if (i2 != 157) {
                if (i2 != 223) {
                    if (i2 != 224) {
                        switch (i2) {
                            case Constants.ACTION_PASSWORD_VIEWER:
                                this.f46074h.append(str2);
                                if (this.f46073g != null) {
                                    this.f46073g.a(str2, 1);
                                    return;
                                }
                                return;
                            case Constants.ACTION_UID_VIEWER:
                                if (this.f46073g == null) {
                                    return;
                                }
                                if (Constants.IS_RELEASE_8_1_0) {
                                    this.f46073g.a(str2, 0);
                                    return;
                                }
                                this.f46073g.c();
                                this.f46073g.a(R.id.ll_nb_login, Boolean.TRUE);
                                this.f46073g.b(str2);
                                this.f46073g.f46020g++;
                                if (!this.f46069c) {
                                    this.f46069c = true;
                                    AssistLogs.printLog("Autofill called", this);
                                    if (this.f46067a != null) {
                                        a(Constants.AUTOFILL_USERID, this.f46067a.get(Constants.AUTOFILL_USERID));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            case Constants.ACTION_REMOVE_NB_LAYOUT:
                                if (this.f46073g != null) {
                                    this.f46073g.a(str2, 3);
                                    return;
                                }
                                return;
                            default:
                                switch (i2) {
                                    case Constants.ACTION_NB_NEXT_BTN_CLICKED:
                                        if (this.f46073g != null) {
                                            this.f46073g.d();
                                            return;
                                        }
                                        return;
                                    case 160:
                                        if (this.f46073g != null) {
                                            this.f46073g.c();
                                            if (this.f46070d > 0) {
                                                this.f46073g.f46019f = true;
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    case Constants.ACTION_NB_WV_LOGIN_CLICKED:
                                        try {
                                            if (this.f46073g != null) {
                                                this.f46073g.a("", 5);
                                                return;
                                            }
                                            return;
                                        } catch (Exception e2) {
                                            AssistLogs.printLog("EXCEPTION", e2);
                                            return;
                                        }
                                    default:
                                        return;
                                }
                        }
                    } else if (this.f46073g != null) {
                        this.f46073g.a(R.id.parentPanel, Boolean.FALSE);
                    }
                } else if (this.f46073g != null) {
                    this.f46073g.a(R.id.parentPanel, Boolean.TRUE);
                }
            } else if (this.f46071e != null && this.f46071e.isChecked()) {
                if (AssistMerchantDetails.getInstance().getFragment() == null || AssistMerchantDetails.getInstance().getFragment().f46017d) {
                    easypay.utils.b.b(AssistMerchantDetails.getInstance().getContext(), str, this.f46068b);
                }
            }
        } else if (this.f46067a != null) {
            a(Constants.PASSWORD_FINDER, this.f46067a.get(Constants.PASSWORD_FINDER));
        }
    }

    public final void a(int i2) {
        if (i2 != 100) {
            if (i2 != 106) {
                switch (i2) {
                    case Constants.ACTION_PASSWORD_FOUND:
                        b((int) Constants.ACTION_PASSWORD_FOUND);
                        if (this.f46067a != null) {
                            a(Constants.PASSWORD_INPUT_REGISTER, this.f46067a.get(Constants.PASSWORD_INPUT_REGISTER));
                            return;
                        }
                        return;
                    case 155:
                        return;
                    case Constants.ACTION_DELAY_PASSWORD_FOUND:
                        try {
                            b((int) Constants.ACTION_DELAY_PASSWORD_FOUND);
                            new Handler().postDelayed(new c(), 500);
                            return;
                        } catch (Exception e2) {
                            AssistLogs.printLog("EXCEPTION", e2);
                            return;
                        }
                    default:
                        return;
                }
            } else if (this.f46067a != null) {
                a(Constants.PASSWORD_FINDER, this.f46067a.get(Constants.PASSWORD_FINDER));
            }
        } else if (this.f46067a != null) {
            a(Constants.SUBMIT_BTN, this.f46067a.get(Constants.SUBMIT_BTN));
        }
    }

    class c implements Runnable {
        c() {
        }

        public final void run() {
            if (b.this.f46067a != null) {
                b bVar = b.this;
                bVar.a(Constants.PASSWORD_FINDER, (Operation) bVar.f46067a.get(Constants.PASSWORD_FINDER));
            }
        }
    }

    private void b(int i2) {
        try {
            if (this.f46073g == null) {
                return;
            }
            if (i2 == 154) {
                this.f46073g.a(R.id.ll_nb_login, Boolean.TRUE);
                this.f46073g.a("", 1);
            } else if (i2 == 156) {
                this.f46073g.a(R.id.ll_nb_login, Boolean.TRUE);
                this.f46073g.a("", 1);
            }
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            b(str);
        }
    }
}
