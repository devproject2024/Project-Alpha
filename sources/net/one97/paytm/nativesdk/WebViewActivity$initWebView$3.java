package net.one97.paytm.nativesdk;

import android.os.Build;
import android.webkit.DownloadListener;
import androidx.core.app.a;
import kotlin.g.b.k;

final class WebViewActivity$initWebView$3 implements DownloadListener {
    final /* synthetic */ WebViewActivity this$0;

    WebViewActivity$initWebView$3(WebViewActivity webViewActivity) {
        this.this$0 = webViewActivity;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        if (Build.VERSION.SDK_INT < 23 || this.this$0.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            WebViewActivity webViewActivity = this.this$0;
            k.a((Object) str3, "contentDisposition");
            k.a((Object) str4, "mimetype");
            webViewActivity.download(str, str3, str4);
            return;
        }
        this.this$0.url = str;
        this.this$0.contentDisposition = str3;
        this.this$0.mimetype = str4;
        a.a(this.this$0, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
    }
}
