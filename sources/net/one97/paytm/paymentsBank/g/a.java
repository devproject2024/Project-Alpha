package net.one97.paytm.paymentsBank.g;

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
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.i.g;
import net.one97.paytm.paymentsBank.R;

public class a extends g implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ProgressBar f18544a;

    /* renamed from: b  reason: collision with root package name */
    private C0317a f18545b;

    /* renamed from: net.one97.paytm.paymentsBank.g.a$a  reason: collision with other inner class name */
    public interface C0317a {
        void a();
    }

    public static a a(ArrayList<PBTncData> arrayList) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", arrayList);
        aVar.setArguments(bundle);
        return aVar;
    }

    public final void a(C0317a aVar) {
        this.f18545b = aVar;
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
        this.f18544a = (ProgressBar) getView().findViewById(R.id.fragment_kyc_tnc_progress_bar);
        WebView webView = (WebView) getView().findViewById(R.id.fragment_kyc_tnc_webview_message);
        webView.setWebViewClient(new WebViewClient() {
            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                a.this.f18544a.setVisibility(0);
                super.onPageStarted(webView, str, bitmap);
            }

            public final void onPageFinished(WebView webView, String str) {
                a.this.f18544a.setVisibility(8);
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
            C0317a aVar = this.f18545b;
            if (aVar != null) {
                aVar.a();
            }
            dismiss();
        }
    }
}
