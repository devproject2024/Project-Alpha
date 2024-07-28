package net.one97.paytm.upgradeKyc.d;

import android.graphics.Bitmap;
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
import net.one97.paytm.common.entity.auth.TncData;
import net.one97.paytm.i.g;
import net.one97.paytm.upgradeKyc.R;

public class m extends g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public a f65713a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f65714b;

    public interface a {
        void onTncAccepted();
    }

    public static m a(ArrayList<TncData> arrayList) {
        m mVar = new m();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", arrayList);
        mVar.setArguments(bundle);
        return mVar;
    }

    public final void a(a aVar) {
        this.f65713a = aVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 16973936);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_kyc_tnc, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f65714b = (ProgressBar) getView().findViewById(R.id.fragment_kyc_tnc_progress_bar);
        WebView webView = (WebView) getView().findViewById(R.id.fragment_kyc_tnc_webview_message);
        webView.setWebViewClient(new WebViewClient() {
            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                m.this.f65714b.setVisibility(0);
                super.onPageStarted(webView, str, bitmap);
            }

            public final void onPageFinished(WebView webView, String str) {
                m.this.f65714b.setVisibility(8);
                super.onPageFinished(webView, str);
            }
        });
        ArrayList arrayList = (ArrayList) getArguments().getSerializable("data");
        if (arrayList != null && arrayList.size() > 0) {
            String url = ((TncData) arrayList.get(0)).getUrl();
            if (!TextUtils.isEmpty(url)) {
                webView.loadUrl(url);
            }
        }
        ((TextView) getView().findViewById(R.id.fragment_kyc_tnc_btn_close)).setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.fragment_kyc_tnc_btn_close) {
            a aVar = this.f65713a;
            if (aVar != null) {
                aVar.onTncAccepted();
            }
            dismiss();
        }
    }
}
