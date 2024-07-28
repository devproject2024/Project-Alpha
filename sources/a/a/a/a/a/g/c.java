package a.a.a.a.a.g;

import a.a.a.a.a.b.h;
import a.a.a.a.a.c.d;
import android.os.Handler;
import android.webkit.WebView;
import java.util.List;

public final class c extends a {

    /* renamed from: e  reason: collision with root package name */
    WebView f747e;

    /* renamed from: f  reason: collision with root package name */
    private List<h> f748f;

    /* renamed from: g  reason: collision with root package name */
    private final String f749g;

    public c(List<h> list, String str) {
        this.f748f = list;
        this.f749g = str;
    }

    public final void b() {
        super.b();
        new Handler().postDelayed(new a(), 2000);
        this.f747e = null;
    }

    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private WebView f751b = c.this.f747e;

        public final void run() {
            this.f751b.destroy();
        }

        a() {
        }
    }

    public final void a() {
        super.a();
        WebView webView = new WebView(a.a.a.a.a.c.c.a().f721a);
        this.f747e = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        a(this.f747e);
        d.a();
        d.a(this.f747e, this.f749g);
        for (h hVar : this.f748f) {
            String externalForm = hVar.f699b.toExternalForm();
            d.a();
            WebView webView2 = this.f747e;
            if (externalForm != null) {
                d.a(webView2, "var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);".replace("%SCRIPT_SRC%", externalForm));
            }
        }
    }
}
