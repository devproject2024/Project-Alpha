package net.one97.paytm.wallet.c;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import net.one97.paytm.i.f;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;

public class l extends f {

    /* renamed from: a  reason: collision with root package name */
    View f70069a;

    /* renamed from: b  reason: collision with root package name */
    String f70070b;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f70069a = layoutInflater.inflate(R.layout.lyt_link_based_warning_bottomsheet, viewGroup, false);
        if (getArguments() != null) {
            this.f70070b = getArguments().getString("warning_msg", "");
        }
        WebView webView = (WebView) this.f70069a.findViewById(R.id.wv_termsNCondition);
        webView.loadDataWithBaseURL((String) null, this.f70070b, "text/html", "utf-8", (String) null);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                String stringFromGTM = b.a().getStringFromGTM(b.a().getContext(), "linkBasedWarningRedirectionURL");
                if (TextUtils.isEmpty(stringFromGTM)) {
                    b.a().startHelpAndSupport(b.a().getContext());
                    return true;
                }
                b.a().openScreenViaDeeplink(b.a().getContext(), stringFromGTM);
                return true;
            }
        });
        this.f70069a.findViewById(R.id.ll_proceed).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                l.this.dismiss();
            }
        });
        return this.f70069a;
    }
}
