package net.one97.paytm.paymentsBank.si.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.i.g;
import net.one97.paytm.paymentsBank.R;

public class f extends g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public a f18886a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f18887b;

    public interface a {
        void g();
    }

    public static f a(ArrayList<PBTncData> arrayList) {
        f fVar = new f();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", arrayList);
        fVar.setArguments(bundle);
        return fVar;
    }

    public final void a(a aVar) {
        this.f18886a = aVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 16973936);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.pb_fragment_kyc_tnc, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f18887b = (ProgressBar) getView().findViewById(R.id.fragment_kyc_tnc_progress_bar);
        WebView webView = (WebView) getView().findViewById(R.id.fragment_kyc_tnc_webview_message);
        webView.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 19) {
            webView.setLayerType(2, (Paint) null);
        } else {
            webView.setLayerType(1, (Paint) null);
        }
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.setWebViewClient(new WebViewClient() {
            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                f.this.f18887b.setVisibility(0);
                super.onPageStarted(webView, str, bitmap);
            }

            public final void onPageFinished(WebView webView, String str) {
                f.this.f18887b.setVisibility(8);
                super.onPageFinished(webView, str);
            }
        });
        ArrayList arrayList = (ArrayList) getArguments().getSerializable("data");
        if (arrayList != null && arrayList.size() > 0) {
            String url = ((PBTncData) arrayList.get(0)).getUrl();
            if (!TextUtils.isEmpty(url)) {
                webView.loadUrl(url);
            }
        }
        ((TextView) getView().findViewById(R.id.fragment_kyc_tnc_btn_close)).setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.fragment_kyc_tnc_btn_close) {
            a aVar = this.f18886a;
            if (aVar != null) {
                aVar.g();
            }
            dismiss();
        }
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.a((Context) getActivity());
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }
}
