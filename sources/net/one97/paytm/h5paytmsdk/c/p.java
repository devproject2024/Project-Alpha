package net.one97.paytm.h5paytmsdk.c;

import android.content.Context;
import com.alipay.iap.android.common.b.c;
import com.alipay.iap.android.webapp.sdk.utils.KitUtils;
import com.alipay.mobile.h5container.api.H5Context;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.nebula.provider.H5ErrorPageView;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.webview.APWebView;
import com.alipay.mobile.nebulacore.android.AndroidWebView;

public final class p implements H5ErrorPageView {
    public final boolean enableShowErrorPage() {
        return true;
    }

    public final void errorPageCallback(H5Page h5Page, APWebView aPWebView, String str, int i2, String str2) {
        H5Utils.runOnMain(new a(aPWebView, h5Page, str), 20);
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APWebView f17094a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Page f17095b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17096c;

        a(APWebView aPWebView, H5Page h5Page, String str) {
            this.f17094a = aPWebView;
            this.f17095b = h5Page;
            this.f17096c = str;
        }

        public final void run() {
            H5Context context;
            Context context2;
            try {
                APWebView aPWebView = this.f17094a;
                if (aPWebView != null) {
                    aPWebView.stopLoading();
                    if (aPWebView instanceof AndroidWebView) {
                        ((AndroidWebView) aPWebView).getWebViewEx().clearView();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            H5Page h5Page = this.f17095b;
            if (h5Page != null && (context = h5Page.getContext()) != null && (context2 = context.getContext()) != null) {
                c.e();
                APWebView aPWebView2 = this.f17094a;
                if (aPWebView2 != null) {
                    aPWebView2.loadDataWithBaseURL(this.f17096c, KitUtils.getAssetContent(context2, "paytmErrorPage.html"), "text/html", "utf-8", this.f17096c);
                }
            }
        }
    }
}
