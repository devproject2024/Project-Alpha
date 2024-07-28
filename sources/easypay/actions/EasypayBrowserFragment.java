package easypay.actions;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import easypay.entity.AssistDetailsResponse;
import easypay.entity.AssistMetaData;
import easypay.entity.AssistUrlResponse;
import easypay.entity.Operation;
import easypay.listeners.WebClientListener;
import easypay.manager.AssistMerchantDetails;
import easypay.manager.Constants;
import easypay.manager.EasypayWebViewClient;
import easypay.utils.AssistLogs;
import easypay.widget.Passcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import paytm.assist.easypay.easypay.R;

public class EasypayBrowserFragment extends net.one97.paytm.i.h implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, WebClientListener {
    /* access modifiers changed from: private */
    public EditText A;
    /* access modifiers changed from: private */
    public LinearLayout B;
    /* access modifiers changed from: private */
    public String C = "";
    /* access modifiers changed from: private */
    public String D;
    /* access modifiers changed from: private */
    public RelativeLayout E;
    /* access modifiers changed from: private */
    public HashMap<String, Operation> F;
    /* access modifiers changed from: private */
    public Button G;
    /* access modifiers changed from: private */
    public ImageButton H;
    /* access modifiers changed from: private */
    public ImageButton I;
    /* access modifiers changed from: private */
    public TextView J;
    /* access modifiers changed from: private */
    public TextView K;
    /* access modifiers changed from: private */
    public TextView L;
    /* access modifiers changed from: private */
    public TextView[] M = new TextView[3];
    /* access modifiers changed from: private */
    public ImageView N;
    /* access modifiers changed from: private */
    public ImageView O;
    /* access modifiers changed from: private */
    public TextView P;
    /* access modifiers changed from: private */
    public TextView Q;
    /* access modifiers changed from: private */
    public TextView R;
    /* access modifiers changed from: private */
    public TextView S;
    /* access modifiers changed from: private */
    public ConstraintLayout T;
    /* access modifiers changed from: private */
    public ConstraintLayout U;
    private TextWatcher V;
    /* access modifiers changed from: private */
    public Operation W;

    /* renamed from: a  reason: collision with root package name */
    public AssistDetailsResponse f46014a;

    /* renamed from: b  reason: collision with root package name */
    public AppCompatActivity f46015b;

    /* renamed from: c  reason: collision with root package name */
    boolean f46016c = false;
    /* access modifiers changed from: package-private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f46017d = true;

    /* renamed from: e  reason: collision with root package name */
    boolean f46018e = false;
    /* access modifiers changed from: package-private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f46019f = false;

    /* renamed from: g  reason: collision with root package name */
    int f46020g = 0;
    /* access modifiers changed from: package-private */

    /* renamed from: h  reason: collision with root package name */
    public ImageView f46021h;
    /* access modifiers changed from: package-private */

    /* renamed from: i  reason: collision with root package name */
    public Button f46022i;
    /* access modifiers changed from: package-private */
    public CountDownTimer j;
    Passcode k;
    /* access modifiers changed from: package-private */
    public volatile AssistMerchantDetails l;
    /* access modifiers changed from: package-private */
    public boolean m;
    public boolean n;
    int o = 8;
    /* access modifiers changed from: private */
    public WebView p;
    /* access modifiers changed from: private */
    public d q;
    /* access modifiers changed from: private */
    public b r;
    /* access modifiers changed from: private */
    public HashMap<String, Operation> s = new HashMap<>();
    private StringBuilder t = new StringBuilder();
    private EasypayWebViewClient u;
    private boolean v = true;
    private boolean w = false;
    /* access modifiers changed from: private */
    public LinearLayout x;
    /* access modifiers changed from: private */
    public CheckBox y;
    /* access modifiers changed from: private */
    public EditText z;

    public void OnWcSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
    }

    public void WcshouldInterceptRequest(WebView webView, String str) {
    }

    public boolean WcshouldOverrideUrlLoading(WebView webView, Object obj) {
        return false;
    }

    public void onReceivedError(WebView webView, int i2, String str, String str2) {
    }

    public static EasypayBrowserFragment a() {
        return new EasypayBrowserFragment();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.easypay_browser_frag_revamp, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        try {
            this.l = AssistMerchantDetails.getInstance();
            this.f46015b = (AppCompatActivity) getActivity();
            AssistLogs.printLog("Activity Instance:" + this.f46015b.toString(), this);
            this.u = this.l.getWebClientInstance();
            this.t.append("|");
            this.p = this.l.getWebView();
            this.f46021h = (ImageView) this.f46015b.findViewById(R.id.img_show_assist);
            this.S = (TextView) this.f46015b.findViewById(R.id.tv_detection_status);
            this.N = (ImageView) this.f46015b.findViewById(R.id.img_hide_assist);
            this.k = (Passcode) this.f46015b.findViewById(R.id.edit_text_otp);
            this.Q = (TextView) this.f46015b.findViewById(R.id.tv_submit_otp_time);
            this.R = (TextView) this.f46015b.findViewById(R.id.tv_tap_to_pause);
            this.f46022i = (Button) this.f46015b.findViewById(R.id.btn_submit_otp);
            this.T = (ConstraintLayout) this.f46015b.findViewById(R.id.cl_show_assist);
            this.U = (ConstraintLayout) this.f46015b.findViewById(R.id.cl_hide_assist);
            this.O = (ImageView) this.f46015b.findViewById(R.id.img_paytm_assist_banner);
            this.l.setFragmentResumed(false);
            this.l.setFragmentPaused(false);
            this.x = (LinearLayout) this.f46015b.findViewById(R.id.ll_nb_login);
            this.y = (CheckBox) this.f46015b.findViewById(R.id.cb_nb_userId);
            this.z = (EditText) this.f46015b.findViewById(R.id.et_nb_password);
            this.A = (EditText) this.f46015b.findViewById(R.id.et_nb_userIdCustomerId);
            this.B = (LinearLayout) this.f46015b.findViewById(R.id.ll_nb_user_id_Selector);
            this.E = (RelativeLayout) this.f46015b.findViewById(R.id.parentPanel);
            this.G = (Button) this.f46015b.findViewById(R.id.nb_bt_submit);
            this.J = (TextView) this.f46015b.findViewById(R.id.tv_user_id_one);
            this.K = (TextView) this.f46015b.findViewById(R.id.tv_user_id_two);
            this.L = (TextView) this.f46015b.findViewById(R.id.tv_user_id_three);
            this.H = (ImageButton) this.f46015b.findViewById(R.id.nb_image_bt_previous);
            this.I = (ImageButton) this.f46015b.findViewById(R.id.nb_image_bt_next);
            this.P = (TextView) this.f46015b.findViewById(R.id.img_pwd_show);
            this.V = new k();
            TextView[] textViewArr = this.M;
            textViewArr[0] = this.J;
            textViewArr[1] = this.K;
            textViewArr[2] = this.L;
            this.z.setText("");
            this.A.setText("");
            this.y.setOnCheckedChangeListener(this);
            this.y.setButtonDrawable(R.drawable.ic_checkbox_selected);
            this.A.addTextChangedListener(this.V);
            Drawable drawable = this.f46015b.getBaseContext().getResources().getDrawable(R.drawable.ic_show_passcode);
            drawable.setBounds(0, 0, 24, 24);
            this.P.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            if (this.p != null) {
                this.p.getSettings().setDomStorageEnabled(true);
                this.p.getSettings().setJavaScriptEnabled(true);
                if (Build.VERSION.SDK_INT >= 21) {
                    this.p.getSettings().setMixedContentMode(0);
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    WebView.setWebContentsDebuggingEnabled(true);
                }
                this.p.addJavascriptInterface(this.l.getEasyPayHelper(), Constants.TAG);
            }
            if (this.u != null) {
                this.u.addAssistWebClientListener(this);
            }
            AppCompatActivity appCompatActivity = this.f46015b;
            if (appCompatActivity != null) {
                appCompatActivity.runOnUiThread(new p());
            }
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    class k implements TextWatcher {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        k() {
        }

        public final void afterTextChanged(Editable editable) {
            if (editable.toString().equals(EasypayBrowserFragment.this.D)) {
                EasypayBrowserFragment.this.b(false);
                EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
                easypayBrowserFragment.a(false, easypayBrowserFragment.D);
            } else if (editable.toString().equals(EasypayBrowserFragment.this.C)) {
                EasypayBrowserFragment easypayBrowserFragment2 = EasypayBrowserFragment.this;
                easypayBrowserFragment2.b(easypayBrowserFragment2.f46017d);
            } else {
                EasypayBrowserFragment.this.b(true);
                EasypayBrowserFragment.this.a(true, editable.toString());
            }
        }
    }

    class p implements Runnable {
        p() {
        }

        public final void run() {
            AssistLogs.printLog("ClickListener set for views", this);
            EasypayBrowserFragment.this.N.setOnClickListener(EasypayBrowserFragment.this);
            EasypayBrowserFragment.this.J.setOnClickListener(EasypayBrowserFragment.this);
            EasypayBrowserFragment.this.K.setOnClickListener(EasypayBrowserFragment.this);
            EasypayBrowserFragment.this.L.setOnClickListener(EasypayBrowserFragment.this);
            EasypayBrowserFragment.this.P.setOnClickListener(EasypayBrowserFragment.this);
            EasypayBrowserFragment.this.I.setOnClickListener(EasypayBrowserFragment.this);
            EasypayBrowserFragment.this.H.setOnClickListener(EasypayBrowserFragment.this);
            EasypayBrowserFragment.this.S.setOnClickListener(EasypayBrowserFragment.this);
            EasypayBrowserFragment.this.R.setOnClickListener(EasypayBrowserFragment.this);
            EasypayBrowserFragment.this.f46022i.setOnClickListener(EasypayBrowserFragment.this);
            EasypayBrowserFragment.this.y.setOnClickListener(EasypayBrowserFragment.this);
            EasypayBrowserFragment.this.O.setOnClickListener(EasypayBrowserFragment.this);
            EasypayBrowserFragment.this.G.setOnClickListener(EasypayBrowserFragment.this);
            EasypayBrowserFragment.this.f46021h.setOnClickListener(EasypayBrowserFragment.this);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        e.a().d();
        try {
            this.l.setFragmentResumed(false);
            this.l.setFragmentPaused(false);
            this.l = null;
            AssistLogs.printLog("Inside on destroy EasypayBrowserFragment", this);
            this.r = null;
            this.q = null;
        } catch (NullPointerException e2) {
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    public void onClick(View view) {
        try {
            AssistLogs.printLog("Click event received for view ID:" + view.getId(), this);
            if (view.getId() == R.id.img_hide_assist) {
                f();
                AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_IS_ASSIST_MINIMIZED_USER, "true");
            } else if (view.getId() == R.id.img_show_assist) {
                b();
            } else if (view.getId() == R.id.img_paytm_assist_banner) {
                this.f46021h.performClick();
            } else if (view.getId() == R.id.tv_detection_status) {
                this.N.performClick();
            } else if (view.getId() == R.id.tv_user_id_one) {
                if (this.r != null) {
                    this.r.a(this.J.getText().toString());
                }
                a(this.J.getText().toString());
                a(false, this.D);
            } else if (view.getId() == R.id.tv_user_id_two) {
                if (this.r != null) {
                    this.r.a(this.K.getText().toString());
                }
                a(this.K.getText().toString());
                a(false, this.D);
            } else if (view.getId() == R.id.tv_user_id_three) {
                if (this.r != null) {
                    this.r.a(this.L.getText().toString());
                }
                a(this.L.getText().toString());
            } else if (view.getId() == R.id.nb_bt_submit) {
                if (!this.w || this.r == null) {
                    this.z.setText("");
                    return;
                }
                this.r.a(Constants.SUBMIT_BTN, this.F.get(Constants.SUBMIT_BTN));
                AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_IS_NB_SUBMIT_CLICKED, "true");
                AssistMerchantDetails instance = AssistMerchantDetails.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append(!this.v);
                instance.setEventInEventMap(Constants.EVENTS_IS_SHOW_PASSWORD_CLICKED, sb.toString());
                AssistMerchantDetails instance2 = AssistMerchantDetails.getInstance();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f46017d);
                instance2.setEventInEventMap(Constants.EVENTS_IS_REMEMBER_USER_ID_CHECKED, sb2.toString());
            } else if (view.getId() == R.id.nb_image_bt_next && this.r != null) {
                this.r.a(Constants.NEXT_BTN, this.F.get(Constants.NEXT_BTN));
            } else if (view.getId() == R.id.nb_image_bt_previous && this.r != null) {
                this.r.a(Constants.PREVIOUS_BTN, this.F.get(Constants.PREVIOUS_BTN));
            } else if (view.getId() == R.id.tv_tap_to_pause) {
                try {
                    AssistMerchantDetails.getInstance().logNewEvents(Constants.TIMESTAMP_TAP_TO_PAUSE, easypay.utils.b.d());
                    AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_IS_PAUSE_BUTTON_TAPPED, "true");
                    AssistMerchantDetails.getInstance().setRiskExtendedInfoParam(Constants.EVENTS_IS_PAUSE_BUTTON_TAPPED, "true");
                    if (this.j != null) {
                        this.j.cancel();
                    }
                    a(true);
                    c(false);
                    this.n = true;
                    e();
                } catch (Exception e2) {
                    AssistLogs.printLog("EXCEPTION", e2);
                }
            } else if (view.getId() == R.id.btn_submit_otp) {
                AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_IS_SUBMIT_BUTTON_CLICKED_MANUALLY, "true");
                AssistMerchantDetails.getInstance().setRiskExtendedInfoParam(Constants.EVENTS_IS_SUBMIT_BUTTON_CLICKED_MANUALLY, "true");
                AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_IS_AUTO_SUBMIT_ASSIST_EVENTS, "false");
                AssistMerchantDetails.getInstance().setRiskExtendedInfoParam(Constants.EVENTS_IS_AUTO_SUBMIT_ASSIST_EVENTS, "false");
                AssistMerchantDetails.getInstance().logNewEvents(Constants.TIMESTAMP_SUBMIT_OTP_MANUAL, easypay.utils.b.d());
                g();
            } else if (view.getId() == R.id.img_pwd_show) {
                try {
                    if (this.v) {
                        Drawable drawable = this.f46015b.getBaseContext().getResources().getDrawable(R.drawable.ic_hide_passcode);
                        drawable.setBounds(0, 0, 24, 24);
                        this.P.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                        this.P.setText(getString(R.string.hide));
                        this.z.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        this.v = false;
                        return;
                    }
                    Drawable drawable2 = this.f46015b.getBaseContext().getResources().getDrawable(R.drawable.ic_show_passcode);
                    drawable2.setBounds(0, 0, 24, 24);
                    this.P.setCompoundDrawables(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.P.setText(getString(R.string.show));
                    this.z.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    this.z.setSelection(this.z.getText().length());
                    this.v = true;
                } catch (Exception e3) {
                    AssistLogs.printLog("EXCEPTION", e3);
                }
            }
        } catch (NullPointerException e4) {
            AssistLogs.printLog("EXCEPTION", e4);
        }
    }

    class q implements Runnable {
        q() {
        }

        public final void run() {
            EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
            easypayBrowserFragment.f46016c = false;
            easypayBrowserFragment.T.setVisibility(0);
            EasypayBrowserFragment.this.U.setVisibility(8);
            EasypayBrowserFragment.this.e();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        AppCompatActivity appCompatActivity = this.f46015b;
        if (appCompatActivity != null) {
            appCompatActivity.runOnUiThread(new q());
        }
    }

    class r implements Runnable {
        r() {
        }

        public final void run() {
            EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
            easypayBrowserFragment.f46016c = true;
            if (easypayBrowserFragment.j != null) {
                EasypayBrowserFragment.this.j.cancel();
            }
            EasypayBrowserFragment.this.T.setVisibility(8);
            EasypayBrowserFragment.this.U.setVisibility(0);
            AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_IS_ASSIST_MINIMIZED, "true");
            EasypayBrowserFragment.this.c(false);
            EasypayBrowserFragment.this.n = true;
        }
    }

    private void f() {
        AppCompatActivity appCompatActivity = this.f46015b;
        if (appCompatActivity != null) {
            appCompatActivity.runOnUiThread(new r());
        }
    }

    class s implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f46055a;

        s(String str) {
            this.f46055a = str;
        }

        public final void run() {
            EasypayBrowserFragment.this.b(false);
            String unused = EasypayBrowserFragment.this.D = this.f46055a;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        AppCompatActivity appCompatActivity = this.f46015b;
        if (appCompatActivity != null) {
            appCompatActivity.runOnUiThread(new s(str));
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        AssistDetailsResponse assistDetailsResponse = this.f46014a;
        if (assistDetailsResponse != null && this.f46018e) {
            if (Constants.EASYPAY_PAYTYPE_CREDIT_CARD.equalsIgnoreCase(assistDetailsResponse.getPayType()) || Constants.EASYPAY_PAYTYPE_DEBIT_CARD.equalsIgnoreCase(this.f46014a.getPayType())) {
                Operation operation = this.s.get(Constants.SUBMIT_BTN);
                d dVar = this.q;
                if (!AssistMerchantDetails.getInstance().isFragmentPaused() && !dVar.f46080a.f46016c) {
                    if (operation == null) {
                        try {
                            AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_IS_SUBMITTED, "false");
                            AssistMerchantDetails.getInstance().setRiskExtendedInfoParam(Constants.EVENTS_IS_SUBMITTED, "false");
                        } catch (Exception e2) {
                            AssistLogs.printLog("EXCEPTION", e2);
                        }
                    } else {
                        AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_IS_SUBMITTED, "true");
                        AssistMerchantDetails.getInstance().setRiskExtendedInfoParam(Constants.EVENTS_IS_SUBMITTED, "true");
                        dVar.a(operation.getJsTemplate());
                    }
                }
            }
        }
    }

    public void checkAssistFlow(WebView webView, String str) {
        AssistLogs.printLog("Activity Instance(Check Assist flow):" + this.f46015b.toString(), this);
        AppCompatActivity appCompatActivity = this.f46015b;
        if (appCompatActivity == null || appCompatActivity.isFinishing()) {
            AppCompatActivity appCompatActivity2 = this.f46015b;
            if (appCompatActivity2 == null) {
                AssistLogs.printLog("Activity null", this);
            } else if (appCompatActivity2.isFinishing()) {
                AssistLogs.printLog("Activity has started finishing", this);
            }
        } else {
            try {
                String string = this.f46015b.getSharedPreferences(Constants.EASYPAY_NEW_PREFERENCE_FILE, 0).getString(Constants.EASY_PAY_CONFIG_PREF_KEY, "");
                AssistLogs.printLog("in checkAssistFlow Config json:" + string, this);
                if (!TextUtils.isEmpty(string)) {
                    this.f46014a = (AssistDetailsResponse) new com.google.gson.f().a(string, AssistDetailsResponse.class);
                    if (this.f46014a == null) {
                        AssistLogs.printLog("imDetail resoinse Null", this);
                    } else if (this.f46014a.getBank().equalsIgnoreCase(this.l.geTxnBank())) {
                        AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_IS_BANK_ENABLED, this.f46014a.getEnabled().toString());
                        if (this.f46014a.getEnabled().booleanValue()) {
                            for (int i2 = 0; i2 < this.f46014a.getResponse().size(); i2++) {
                                if (!str.toLowerCase().contains("paytm") && this.f46014a.getResponse().get(i2).getUrl().equals("LOGGER_SCRIPT_LOAD")) {
                                    String replace = this.f46014a.getResponse().get(i2).getOperations().get(0).getJsTemplate().replace("CARDINFO", AssistMerchantDetails.getInstance().getDetailString());
                                    if (Build.VERSION.SDK_INT >= 19) {
                                        webView.evaluateJavascript(replace, new t());
                                    } else {
                                        webView.loadUrl(replace);
                                    }
                                }
                                if (str.contains(this.f46014a.getResponse().get(i2).getUrl())) {
                                    this.w = true;
                                    AssistDetailsResponse assistDetailsResponse = this.f46014a;
                                    try {
                                        AssistLogs.printLog("In assistNewFlow():mdetailresponse=" + this.f46014a.getBank() + AppConstants.COLON + this.f46014a.getResponse(), this);
                                        if (this.f46014a != null) {
                                            if (assistDetailsResponse.getPayType().equalsIgnoreCase(Constants.EASYPAY_PAYTYPE_CREDIT_CARD) || assistDetailsResponse.getPayType().equalsIgnoreCase(Constants.EASYPAY_PAYTYPE_DEBIT_CARD)) {
                                                this.s = new HashMap<>();
                                                a(this.s, str, assistDetailsResponse);
                                                if (this.q == null) {
                                                    AssistLogs.printLog("Making object NewOtpHelper", this);
                                                    this.q = new d(this.f46015b, webView, this, this.u, this.s);
                                                }
                                                if (this.s.size() > 0) {
                                                    AssistLogs.printLog("Easypay browser fragment:fire do action-Filler from web ", this);
                                                    new Handler().postDelayed(new u(), 1000);
                                                }
                                            } else if ("NB".equalsIgnoreCase(assistDetailsResponse.getPayType())) {
                                                this.F = new HashMap<>();
                                                a(this.F, str, assistDetailsResponse);
                                                if (this.r == null) {
                                                    AssistLogs.printLog("Making object NBHelper", this);
                                                    this.r = new b(this.F, this.p, this.f46015b, assistDetailsResponse);
                                                }
                                                if (this.F.size() > 0) {
                                                    AssistLogs.printLog("Starting NB features", this);
                                                    new Handler().postDelayed(new v(), 1000);
                                                }
                                            }
                                        }
                                    } catch (Exception e2) {
                                        AssistLogs.printLog("EXCEPTION", e2);
                                    }
                                }
                            }
                            return;
                        }
                        AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_IS_ASSIST_POPPED, "false");
                    } else {
                        AssistLogs.printLog("Config JSON picked from cache doesn't have same bank name", this);
                        AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_IS_ASSIST_POPPED, "false");
                    }
                }
            } catch (Exception e3) {
                AssistLogs.printLog("EXCEPTION", e3);
            }
        }
    }

    class t implements ValueCallback<String> {
        public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
        }

        t() {
        }
    }

    class u implements Runnable {
        u() {
        }

        public final void run() {
            if (EasypayBrowserFragment.this.q != null) {
                d u = EasypayBrowserFragment.this.q;
                HashMap<String, Operation> v = EasypayBrowserFragment.this.s;
                if (v != null) {
                    u.f46081b = v;
                }
                EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
                EasypayBrowserFragment.a(easypayBrowserFragment, (Operation) easypayBrowserFragment.s.get(Constants.FILLER_FROM_CODE));
                EasypayBrowserFragment.this.q.b(Constants.FILLER_FROM_WEB);
            }
        }
    }

    class v implements Runnable {
        v() {
        }

        public final void run() {
            try {
                if (EasypayBrowserFragment.this.r != null) {
                    b w = EasypayBrowserFragment.this.r;
                    HashMap<String, Operation> x = EasypayBrowserFragment.this.F;
                    AssistDetailsResponse y = EasypayBrowserFragment.this.f46014a;
                    if (x != null) {
                        try {
                            w.f46067a = x;
                        } catch (Exception e2) {
                            AssistLogs.printLog("EXCEPTION", e2);
                            return;
                        }
                    }
                    if (y != null) {
                        w.f46068b = y.getBank();
                    }
                    if (w.f46067a != null && w.f46067a.containsKey(Constants.FILLER_FROM_WEB)) {
                        w.a(Constants.FILLER_FROM_WEB, w.f46067a.get(Constants.FILLER_FROM_WEB));
                    }
                }
            } catch (Exception e3) {
                AssistLogs.printLog("EXCEPTION", e3);
            }
        }
    }

    class w implements TextWatcher {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        w() {
        }

        public final void afterTextChanged(Editable editable) {
            JSONObject jSONObject;
            if (EasypayBrowserFragment.this.W != null) {
                try {
                    String obj = editable.toString();
                    AssistLogs.printLog("Text Change:" + obj, this);
                    try {
                        if (obj.length() > 0 && obj.length() < 6) {
                            AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_OTP_MANUALLY_REQUESTED, "true");
                            AssistMerchantDetails.getInstance().setRiskExtendedInfoParam(Constants.EVENTS_OTP_MANUALLY_REQUESTED, "true");
                        }
                        String str = null;
                        if (obj.length() < 6) {
                            if (EasypayBrowserFragment.this.k != null) {
                                EasypayBrowserFragment.this.k.setTypeface((Typeface) null, 1);
                            }
                        } else if (obj.length() == 6 && EasypayBrowserFragment.this.k != null) {
                            EasypayBrowserFragment.this.k.setTypeface((Typeface) null, 0);
                        }
                        EasypayBrowserFragment.this.e();
                        if (EasypayBrowserFragment.this.k != null) {
                            Operation operation = (Operation) EasypayBrowserFragment.this.k.getTag();
                            try {
                                jSONObject = new JSONObject(operation.getActionMetadata());
                            } catch (JSONException e2) {
                                AssistLogs.printLog("EXCEPTION", e2);
                                jSONObject = null;
                            }
                            com.google.gson.f fVar = new com.google.gson.f();
                            if (jSONObject != null) {
                                str = jSONObject.toString();
                            }
                            String jsField = ((AssistMetaData) fVar.a(str, AssistMetaData.class)).getJsField();
                            if (EasypayBrowserFragment.this.q != null) {
                                EasypayBrowserFragment.this.q.a(jsField, operation.getJsTemplate(), obj);
                            }
                        }
                    } catch (NullPointerException e3) {
                        AssistLogs.printLog("EXCEPTION", e3);
                    }
                } catch (Exception e4) {
                    AssistLogs.printLog("EXCEPTION", e4);
                }
            }
        }
    }

    private static void a(HashMap<String, Operation> hashMap, String str, AssistDetailsResponse assistDetailsResponse) {
        Iterator<AssistUrlResponse> it2 = assistDetailsResponse.getResponse().iterator();
        while (it2.hasNext()) {
            AssistUrlResponse next = it2.next();
            if (str.contains(next.getUrl())) {
                AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_ACS_URL, str);
                ArrayList<Operation> operations = next.getOperations();
                if (operations != null && !operations.isEmpty()) {
                    Iterator<Operation> it3 = operations.iterator();
                    while (it3.hasNext()) {
                        Operation next2 = it3.next();
                        hashMap.put(next2.getActionType(), next2);
                    }
                }
            }
        }
    }

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AssistUrlResponse f46023a;

        public a(AssistUrlResponse assistUrlResponse) {
            this.f46023a = assistUrlResponse;
        }

        public final void run() {
            if (EasypayBrowserFragment.a(this.f46023a.getUrl(), EasypayBrowserFragment.this.p.getUrl())) {
                EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
                easypayBrowserFragment.checkAssistFlow(easypayBrowserFragment.p, EasypayBrowserFragment.this.p.getUrl());
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f46025a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f46026b;

        b(int i2, String str) {
            this.f46025a = i2;
            this.f46026b = str;
        }

        public final void run() {
            try {
                if (this.f46025a == 1) {
                    EasypayBrowserFragment.this.x.setVisibility(0);
                    if (EasypayBrowserFragment.this.y.getVisibility() == 0) {
                        EasypayBrowserFragment.this.y.setVisibility(8);
                        String unused = EasypayBrowserFragment.this.C = EasypayBrowserFragment.this.A.getText().toString();
                    }
                    EasypayBrowserFragment.this.z.setVisibility(0);
                    EasypayBrowserFragment.this.H.setVisibility(0);
                    EasypayBrowserFragment.this.I.setVisibility(8);
                    EasypayBrowserFragment.this.A.setVisibility(8);
                    EasypayBrowserFragment.this.B.setVisibility(8);
                    if (EasypayBrowserFragment.this.G.getVisibility() != 0) {
                        EasypayBrowserFragment.this.G.setVisibility(0);
                    }
                    EasypayBrowserFragment.this.P.setVisibility(0);
                    if (this.f46026b != null) {
                        EasypayBrowserFragment.this.z.setText(this.f46026b);
                    }
                } else if (this.f46025a == 0) {
                    if (EasypayBrowserFragment.this.z.getVisibility() == 0 || EasypayBrowserFragment.this.z.getVisibility() == 4) {
                        EasypayBrowserFragment.this.z.setVisibility(8);
                    }
                    if (EasypayBrowserFragment.this.P.getVisibility() == 0 || EasypayBrowserFragment.this.P.getVisibility() == 4) {
                        EasypayBrowserFragment.this.P.setVisibility(8);
                    }
                    if (EasypayBrowserFragment.this.y.getVisibility() == 0 || EasypayBrowserFragment.this.y.getVisibility() == 4) {
                        EasypayBrowserFragment.this.y.setVisibility(8);
                    }
                    if (EasypayBrowserFragment.this.G.getVisibility() == 0 || EasypayBrowserFragment.this.G.getVisibility() == 4) {
                        EasypayBrowserFragment.this.G.setVisibility(8);
                    }
                } else if (this.f46025a == 3) {
                    if (EasypayBrowserFragment.this.x != null && EasypayBrowserFragment.this.z != null) {
                        EasypayBrowserFragment.this.z.setText("");
                    }
                } else if (this.f46025a == 4) {
                    if (EasypayBrowserFragment.this.x != null) {
                        EasypayBrowserFragment.this.x.setVisibility(0);
                    }
                } else if (this.f46025a == 5 && EasypayBrowserFragment.this.x != null) {
                    EasypayBrowserFragment.this.x.setVisibility(8);
                }
            } catch (Exception e2) {
                AssistLogs.printLog("EXCEPTION", e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, int i2) {
        this.f46015b.runOnUiThread(new b(i2, str));
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, Boolean bool) {
        try {
            View findViewById = this.f46015b.findViewById(i2);
            int i3 = bool.booleanValue() ? 0 : 8;
            if (i2 == R.id.otpHelper) {
                AssistLogs.printLog("Layout visible for NewOtpHelper", this);
                AssistMerchantDetails.getInstance().logNewEvents(Constants.TIMESTAMP_ASSIST_POPPED, easypay.utils.b.d());
                AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_IS_ASSIST_POPPED, "true");
                this.f46018e = true;
            } else if (i2 == R.id.ll_nb_login) {
                AssistLogs.printLog("Layout visible for NBHelper", this);
                AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_IS_NET_BANKING, "true");
                AssistMerchantDetails.getInstance().logNewEvents(Constants.TIMESTAMP_ASSIST_POPPED, easypay.utils.b.d());
                AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_IS_ASSIST_POPPED, "true");
                this.f46018e = true;
            } else if (i2 == R.id.btn_submit_otp || i2 == R.id.tv_tap_to_pause || i2 == R.id.tv_submit_otp_time) {
                i3 = bool.booleanValue() ? 0 : 4;
            } else if (i2 == R.id.parentPanel) {
                this.f46018e = bool.booleanValue();
            }
            if (this.f46015b != null) {
                this.f46015b.runOnUiThread(new c(i2, findViewById, i3));
            }
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f46028a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f46029b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f46030c;

        c(int i2, View view, int i3) {
            this.f46028a = i2;
            this.f46029b = view;
            this.f46030c = i3;
        }

        public final void run() {
            if (this.f46028a == R.id.ll_nb_login) {
                EasypayBrowserFragment.this.E.setBackgroundColor(0);
            }
            View view = this.f46029b;
            if (view != null) {
                view.setVisibility(this.f46030c);
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        public final void run() {
            EasypayBrowserFragment.this.x.setVisibility(0);
            EasypayBrowserFragment.this.z.setVisibility(8);
            EasypayBrowserFragment.this.H.setVisibility(8);
            EasypayBrowserFragment.this.P.setVisibility(8);
            EasypayBrowserFragment.this.G.setVisibility(8);
            EasypayBrowserFragment.this.I.setVisibility(0);
            EasypayBrowserFragment.this.y.setVisibility(0);
            EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
            easypayBrowserFragment.b(easypayBrowserFragment.f46017d);
            EasypayBrowserFragment.this.A.setVisibility(0);
            if (!EasypayBrowserFragment.this.f46019f || EasypayBrowserFragment.this.r == null || EasypayBrowserFragment.this.r.f46070d <= 1) {
                EasypayBrowserFragment.this.B.setVisibility(8);
            } else {
                EasypayBrowserFragment.this.B.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        AppCompatActivity appCompatActivity = this.f46015b;
        if (appCompatActivity != null) {
            appCompatActivity.runOnUiThread(new d());
        }
    }

    class e implements Runnable {
        e() {
        }

        public final void run() {
            EasypayBrowserFragment.this.z.setVisibility(0);
            EasypayBrowserFragment.this.H.setVisibility(0);
            EasypayBrowserFragment.this.P.setVisibility(0);
            EasypayBrowserFragment.this.G.setVisibility(0);
            EasypayBrowserFragment.this.I.setVisibility(8);
            EasypayBrowserFragment.this.y.setVisibility(8);
            EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
            boolean unused = easypayBrowserFragment.f46017d = easypayBrowserFragment.y.isChecked();
            EasypayBrowserFragment easypayBrowserFragment2 = EasypayBrowserFragment.this;
            String unused2 = easypayBrowserFragment2.C = easypayBrowserFragment2.A.getText().toString();
            EasypayBrowserFragment.this.A.setVisibility(8);
            EasypayBrowserFragment.this.B.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        AppCompatActivity appCompatActivity = this.f46015b;
        if (appCompatActivity != null) {
            appCompatActivity.runOnUiThread(new e());
        }
    }

    class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f46034a;

        f(String str) {
            this.f46034a = str;
        }

        public final void run() {
            EasypayBrowserFragment.this.A.setText(this.f46034a);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(String str) {
        AppCompatActivity appCompatActivity = this.f46015b;
        if (appCompatActivity != null) {
            appCompatActivity.runOnUiThread(new f(str));
        }
    }

    class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f46036a;

        g(boolean z) {
            this.f46036a = z;
        }

        public final void run() {
            EasypayBrowserFragment.this.y.setChecked(this.f46036a);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(boolean z2) {
        AppCompatActivity appCompatActivity = this.f46015b;
        if (appCompatActivity != null) {
            appCompatActivity.runOnUiThread(new g(z2));
        }
    }

    public void onResume() {
        super.onResume();
        this.l.setFragmentResumed(true);
        this.l.setFragmentPaused(false);
    }

    public void onPause() {
        super.onPause();
        this.l.setFragmentResumed(false);
        this.l.setFragmentPaused(true);
    }

    public void onStop() {
        super.onStop();
        CountDownTimer countDownTimer = this.j;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        AssistLogs.printLog("Pushed to background, toggle submit button", this);
        c(false);
        this.n = true;
        a(true);
    }

    public void onDestroy() {
        EditText editText = this.A;
        if (editText != null) {
            editText.removeTextChangedListener(this.V);
        }
        super.onDestroy();
    }

    public void OnWcPageFinish(WebView webView, String str) {
        if (this.l != null) {
            AssistMerchantDetails assistMerchantDetails = this.l;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            assistMerchantDetails.setTimeFinish(sb.toString());
        }
        StringBuilder sb2 = this.t;
        if (sb2 != null) {
            sb2.append(str);
            this.t.append("|");
        }
    }

    public void OnWcPageStart(WebView webView, String str, Bitmap bitmap) {
        if (this.l != null) {
            AssistMerchantDetails assistMerchantDetails = this.l;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            assistMerchantDetails.setTimeStart(sb.toString());
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        CheckBox checkBox;
        this.f46017d = z2;
        if (!z2 || (checkBox = this.y) == null) {
            CheckBox checkBox2 = this.y;
            if (checkBox2 != null) {
                checkBox2.setButtonDrawable(R.drawable.ic_checkbox_unselected);
                return;
            }
            return;
        }
        checkBox.setButtonDrawable(R.drawable.ic_checkbox_selected);
        SharedPreferences.Editor edit = this.f46015b.getSharedPreferences(Constants.BANKPREF, 0).edit();
        edit.putString(Constants.USER_ID_NET_BANK_KEY, "abcd");
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void c(String str) {
        AssistLogs.printLog("Set detection status text: ".concat(String.valueOf(str)), this);
        AppCompatActivity appCompatActivity = this.f46015b;
        if (appCompatActivity != null) {
            appCompatActivity.runOnUiThread(new h(str));
        }
    }

    class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f46038a;

        h(String str) {
            this.f46038a = str;
        }

        public final void run() {
            if (!TextUtils.isEmpty(this.f46038a)) {
                EasypayBrowserFragment.this.S.setText(this.f46038a);
            }
        }
    }

    public void removeAssist() {
        a(R.id.parentPanel, Boolean.FALSE);
        c(false);
        b bVar = this.r;
        if (bVar != null) {
            bVar.f46069c = false;
        }
    }

    public void minimizeAssist() {
        ImageView imageView = this.N;
        if (imageView != null && imageView.getVisibility() == 0) {
            f();
        }
    }

    class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f46040a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f46041b;

        i(boolean z, int i2) {
            this.f46040a = z;
            this.f46041b = i2;
        }

        public final void run() {
            if (this.f46040a) {
                EasypayBrowserFragment.this.B.setVisibility(0);
                for (int i2 = 0; i2 < 3; i2++) {
                    if (i2 >= this.f46041b || EasypayBrowserFragment.this.M[i2].getText().equals(EasypayBrowserFragment.this.D)) {
                        EasypayBrowserFragment.this.M[i2].setVisibility(8);
                    } else {
                        EasypayBrowserFragment.this.M[i2].setVisibility(0);
                    }
                }
                return;
            }
            EasypayBrowserFragment.this.B.setVisibility(8);
            for (int i3 = 0; i3 < this.f46041b; i3++) {
                EasypayBrowserFragment.this.M[i3].setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, boolean z2) {
        AppCompatActivity appCompatActivity = this.f46015b;
        if (appCompatActivity != null) {
            appCompatActivity.runOnUiThread(new i(z2, i2));
        }
    }

    class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f46043a;

        j(ArrayList arrayList) {
            this.f46043a = arrayList;
        }

        public final void run() {
            int size = this.f46043a.size();
            for (int i2 = size - 1; i2 >= 0; i2 += -1) {
                EasypayBrowserFragment.this.M[(size - i2) - 1].setText((CharSequence) this.f46043a.get(i2));
                AssistLogs.printLog(((String) this.f46043a.get(i2)) + " USER ID", this);
            }
        }
    }

    class l extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f46046a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(long j, String str) {
            super(j, 1000);
            this.f46046a = str;
        }

        public final void onTick(long j) {
            String str;
            long j2 = j / 1000;
            int i2 = (j2 > 1 ? 1 : (j2 == 1 ? 0 : -1));
            if (i2 > 0) {
                str = this.f46046a + " " + j2 + " seconds";
            } else if (i2 == 0) {
                str = this.f46046a + " " + j2 + " second";
            } else {
                onFinish();
                str = "";
            }
            AssistLogs.printLog("Timer countdown:".concat(String.valueOf(str)), this);
            EasypayBrowserFragment.c(EasypayBrowserFragment.this, str);
        }

        public final void onFinish() {
            if (EasypayBrowserFragment.this.R.getVisibility() == 0) {
                AssistMerchantDetails.getInstance().logNewEvents(Constants.TIMESTAMP_SUBMIT_OTP_AUTO, easypay.utils.b.d());
                EasypayBrowserFragment.this.g();
                AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_IS_PAUSE_BUTTON_TAPPED, "false");
                AssistMerchantDetails.getInstance().setRiskExtendedInfoParam(Constants.EVENTS_IS_PAUSE_BUTTON_TAPPED, "false");
                AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_IS_AUTO_SUBMIT_ASSIST_EVENTS, "true");
                AssistMerchantDetails.getInstance().setRiskExtendedInfoParam(Constants.EVENTS_IS_AUTO_SUBMIT_ASSIST_EVENTS, "true");
                AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_IS_SUBMIT_BUTTON_CLICKED_MANUALLY, "false");
                AssistMerchantDetails.getInstance().setRiskExtendedInfoParam(Constants.EVENTS_IS_SUBMIT_BUTTON_CLICKED_MANUALLY, "false");
                AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_OTP_MANUALLY_REQUESTED, "false");
                AssistMerchantDetails.getInstance().setRiskExtendedInfoParam(Constants.EVENTS_OTP_MANUALLY_REQUESTED, "false");
            }
        }
    }

    class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f46048a;

        m(String str) {
            this.f46048a = str;
        }

        public final void run() {
            EasypayBrowserFragment.this.Q.setText(this.f46048a);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(boolean z2) {
        AssistLogs.printLog("Toggling auto submit UI:".concat(String.valueOf(z2)), this);
        a(R.id.tv_tap_to_pause, Boolean.valueOf(z2));
        a(R.id.tv_submit_otp_time, Boolean.valueOf(z2));
    }

    /* access modifiers changed from: private */
    public void a(boolean z2, String str) {
        if (str == null) {
            str = this.D;
        }
        b bVar = this.r;
        int i2 = bVar == null ? 0 : bVar.f46070d;
        if (i2 == 1) {
            if (z2) {
                this.B.setVisibility(0);
                this.M[0].setVisibility(0);
                this.M[0].setText(this.D);
            } else {
                this.B.setVisibility(8);
                this.M[0].setVisibility(8);
            }
        } else if (i2 > 1) {
            for (int i3 = 0; i3 < i2; i3++) {
                if (this.M[i3].getText().equals(str)) {
                    this.M[i3].setVisibility(8);
                } else if (!this.M[i3].getText().equals("")) {
                    this.M[i3].setVisibility(0);
                }
            }
        }
        b(z2);
    }

    class n implements Runnable {
        n() {
        }

        public final void run() {
            EasypayBrowserFragment.this.k.setText("");
            String geTxnBank = EasypayBrowserFragment.this.l == null ? Constants.DEFAULT_BANK : EasypayBrowserFragment.this.l.geTxnBank();
            EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
            easypayBrowserFragment.c(easypayBrowserFragment.f46015b.getString(R.string.waiting_for_otp_label, new Object[]{geTxnBank}));
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 121 && i3 == -1) {
            AssistLogs.printLog("NO SMS permission, user consent received", this);
            if (intent != null) {
                AssistLogs.printLog("NO SMS permission, message data received", this);
                String stringExtra = intent.getStringExtra("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
                if (this.q != null) {
                    AssistLogs.printLog("NO SMS permission, sending message to OtpHelper", this);
                    e.a().a(stringExtra, "", false);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        AssistLogs.printLog("Toggle Submit button State : Assist Layout Visible: " + isAssistLayoutPopped(), this);
        AppCompatActivity appCompatActivity = this.f46015b;
        if (appCompatActivity != null) {
            appCompatActivity.runOnUiThread(new o());
        }
    }

    class o implements Runnable {
        o() {
        }

        public final void run() {
            Passcode passcode = EasypayBrowserFragment.this.k;
            if (passcode != null && passcode.getText() != null) {
                int length = EasypayBrowserFragment.this.k.getText().toString().length();
                EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
                if (easypayBrowserFragment.n) {
                    if (length == 6) {
                        if (easypayBrowserFragment.f46022i != null) {
                            EasypayBrowserFragment.this.f46022i.setEnabled(true);
                        }
                    } else if (easypayBrowserFragment.f46022i != null) {
                        EasypayBrowserFragment.this.f46022i.setEnabled(false);
                    }
                    EasypayBrowserFragment.this.a(R.id.btn_submit_otp, Boolean.TRUE);
                } else if (easypayBrowserFragment.m) {
                    EasypayBrowserFragment.this.a(R.id.btn_submit_otp, Boolean.FALSE);
                }
            }
        }
    }

    public boolean isAssistLayoutPopped() {
        return this.f46018e;
    }

    public void startActivityForResult(Intent intent, int i2) {
        if (intent == null) {
            intent = new Intent();
        }
        super.startActivityForResult(intent, i2);
    }

    public StringBuilder getRedirectUrl() {
        return this.t;
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z2) {
        if (z2) {
            this.k.setEnabled(true);
            this.k.setInputType(2);
            return;
        }
        this.k.setEnabled(false);
        this.k.setInputType(0);
    }

    static /* synthetic */ void a(EasypayBrowserFragment easypayBrowserFragment, Operation operation) {
        try {
            easypayBrowserFragment.W = operation;
            if (easypayBrowserFragment.k != null) {
                AssistLogs.printLog("Text Watcher", easypayBrowserFragment);
                easypayBrowserFragment.k.addTextChangedListener(new w());
                easypayBrowserFragment.k.setTag(operation);
            }
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    static /* synthetic */ boolean a(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return str2.contains(str);
    }

    static /* synthetic */ void c(EasypayBrowserFragment easypayBrowserFragment, String str) {
        AppCompatActivity appCompatActivity = easypayBrowserFragment.f46015b;
        if (appCompatActivity != null) {
            appCompatActivity.runOnUiThread(new m(str));
        }
    }
}
