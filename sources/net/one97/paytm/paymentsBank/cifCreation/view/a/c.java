package net.one97.paytm.paymentsBank.cifCreation.view.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import net.one97.paytm.i.h;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.cifCreation.view.a.c;
import net.one97.paytm.paymentsBank.cifCreation.view.activity.CIFCreateActivity;
import net.one97.paytm.paymentsBank.cifCreation.view.activity.FdCalculaterActivity;
import net.one97.paytm.paymentsBank.customView.CustomNumberToTextEditTextView;
import net.one97.paytm.paymentsBank.slfd.view.CustomAmountTextInputEditText;
import net.one97.paytm.paymentsBank.utils.o;

public class c extends h implements CustomNumberToTextEditTextView.a, CustomAmountTextInputEditText.c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public TextView f18020a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public TextView f18021b;

    /* renamed from: c  reason: collision with root package name */
    private WebView f18022c;

    /* renamed from: d  reason: collision with root package name */
    private Button f18023d;

    /* renamed from: e  reason: collision with root package name */
    private Double f18024e;

    /* renamed from: f  reason: collision with root package name */
    private String f18025f;

    /* renamed from: g  reason: collision with root package name */
    private int f18026g;

    /* renamed from: h  reason: collision with root package name */
    private int f18027h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public long f18028i = 0;
    private int j = 7;

    public static c a(Bundle bundle) {
        c cVar = new c();
        cVar.setArguments(bundle);
        return cVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f18024e = Double.valueOf(getArguments().getDouble("EXTRA_FD_RATE"));
            this.f18026g = getArguments().getInt("EXTRA_FD_TENURE_MONTHS");
            this.f18027h = getArguments().getInt("EXTRA_FD_TENURE_DAYS");
            this.f18025f = getArguments().getString("EXTRA_INTEREST_CALCULATOR_JS");
            if (getArguments().containsKey("MAX_DIGITS")) {
                this.j = getArguments().getInt("MAX_DIGITS");
            }
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.pb_fragment_fd_calculator, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() instanceof CIFCreateActivity) {
            ((CIFCreateActivity) getActivity()).c(false);
        }
        TextView textView = (TextView) getView().findViewById(R.id.tv_fd_rate);
        FrameLayout frameLayout = (FrameLayout) getView().findViewById(R.id.etAmount);
        frameLayout.removeAllViews();
        this.f18020a = (TextView) getView().findViewById(R.id.tv_total_interest);
        this.f18021b = (TextView) getView().findViewById(R.id.tv_maturity_value);
        this.f18023d = (Button) getView().findViewById(R.id.dummyView);
        View findViewById = getView().findViewById(R.id.maturityView);
        if (o.a().getBooleanFromGTM("showMaturityValueNewUserBoarding", false)) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(4);
        }
        textView.setText(getString(R.string.fd_calculator_interest_rate, this.f18024e.toString() + "%", Integer.valueOf(this.f18026g)));
        CustomNumberToTextEditTextView customNumberToTextEditTextView = new CustomNumberToTextEditTextView(getActivity());
        customNumberToTextEditTextView.setEditTextListener(this);
        customNumberToTextEditTextView.setNoOfDigitBeforeDecimal(this.j);
        frameLayout.addView(customNumberToTextEditTextView);
        this.f18022c = (WebView) getView().findViewById(R.id.wbJS);
        this.f18022c.addJavascriptInterface(new a(getActivity()), "AndroidInterface");
        this.f18022c.getSettings().setJavaScriptEnabled(true);
        this.f18022c.setWebChromeClient(new b(this, (byte) 0));
        this.f18022c.setWebViewClient(new C0297c(this, (byte) 0));
        try {
            String encodeToString = Base64.encodeToString(URLEncoder.encode(new String(this.f18025f.getBytes(), StandardCharsets.UTF_8), AppConstants.UTF_8).replace("+", "%20").getBytes(), 2);
            this.f18022c.loadUrl("javascript:(function() {var parent = document.getElementsByTagName('head').item(0);var script = document.createElement('script');script.type = 'text/javascript';script.innerHTML = decodeURIComponent(window.atob('" + encodeToString + "'));parent.appendChild(script)})();");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        customNumberToTextEditTextView.getEdtAmount().setText("₹ 10,000");
        if (customNumberToTextEditTextView.getEdtAmount() != null) {
            customNumberToTextEditTextView.getEdtAmount().setFocusChangeListener(this);
        }
        if (getContext() instanceof FdCalculaterActivity) {
            customNumberToTextEditTextView.getEdtAmount().requestFocus();
            customNumberToTextEditTextView.getEdtAmount().requestFocusFromTouch();
        }
    }

    public final void a(long j2) {
        this.f18028i = j2;
        WebView webView = this.f18022c;
        webView.loadUrl("javascript:calculateInterest(" + j2 + AppConstants.COMMA + this.f18024e + AppConstants.COMMA + this.f18026g + AppConstants.COMMA + this.f18027h + ")");
    }

    public final void a() {
        this.f18028i = 0;
        this.f18020a.setText("");
        this.f18021b.setText("");
    }

    public final void a(boolean z) {
        if (z && getContext() != null && (getContext() instanceof CIFCreateActivity)) {
            this.f18023d.requestFocus();
            this.f18023d.requestFocusFromTouch();
            Intent intent = new Intent(getContext(), FdCalculaterActivity.class);
            intent.putExtras(getArguments());
            startActivity(intent);
        }
    }

    class b extends WebChromeClient {
        private b() {
        }

        /* synthetic */ b(c cVar, byte b2) {
            this();
        }

        public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            jsResult.confirm();
            return true;
        }
    }

    /* renamed from: net.one97.paytm.paymentsBank.cifCreation.view.a.c$c  reason: collision with other inner class name */
    class C0297c extends WebViewClient {
        public final void onPageFinished(WebView webView, String str) {
        }

        private C0297c() {
        }

        /* synthetic */ C0297c(c cVar, byte b2) {
            this();
        }
    }

    class a {

        /* renamed from: b  reason: collision with root package name */
        private Context f18030b;

        a(Context context) {
            this.f18030b = context;
        }

        @JavascriptInterface
        public final void showTotalInterest(String str) {
            ((Activity) this.f18030b).runOnUiThread(new Runnable(str) {
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    c.a.this.a(this.f$1);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(String str) {
            try {
                c.this.f18020a.setText(c.this.getString(R.string.rs_str, net.one97.paytm.bankCommon.mapping.a.ad(str)));
                int round = Math.round((float) c.this.f18028i) + Integer.valueOf(str).intValue();
                c.this.f18021b.setText(c.this.getString(R.string.rs_str, net.one97.paytm.bankCommon.mapping.a.a((double) round)));
            } catch (Exception unused) {
            }
        }
    }
}
