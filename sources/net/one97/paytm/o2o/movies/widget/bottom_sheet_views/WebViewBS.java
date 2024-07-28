package net.one97.paytm.o2o.movies.widget.bottom_sheet_views;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.a.d;
import net.one97.paytm.o2o.movies.common.a.e;
import net.one97.paytm.o2o.movies.utils.n;
import net.one97.paytm.o2o.movies.widget.ObservableWebView;

public final class WebViewBS extends BottomSheetBaseView {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f76216d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f76217e;

    public final View a(int i2) {
        if (this.f76217e == null) {
            this.f76217e = new HashMap();
        }
        View view = (View) this.f76217e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f76217e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebViewBS(Context context) {
        super(context);
        k.c(context, "context");
        setPeekHeight(n.b(450));
        ((ImageView) a(R.id.btn_close)).setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ WebViewBS f76218a;

            {
                this.f76218a = r1;
            }

            public final void onClick(View view) {
                this.f76218a.f76195a.dismiss();
            }
        });
        ((ObservableWebView) a(R.id.web_view)).setOnScrollChangedCallback(new ObservableWebView.a(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ WebViewBS f76219a;

            {
                this.f76219a = r1;
            }

            public final void a(int i2) {
                this.f76219a.f76216d = i2;
            }
        });
        ObservableWebView observableWebView = (ObservableWebView) a(R.id.web_view);
        k.a((Object) observableWebView, "web_view");
        observableWebView.setWebViewClient(new WebViewClient(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ WebViewBS f76220a;

            {
                this.f76220a = r1;
            }

            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                ProgressBar progressBar = (ProgressBar) this.f76220a.a(R.id.loader);
                if (progressBar != null) {
                    e.a(progressBar, true);
                }
            }

            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                ProgressBar progressBar = (ProgressBar) this.f76220a.a(R.id.loader);
                if (progressBar != null) {
                    e.a(progressBar, false);
                }
            }
        });
        BottomSheetBehavior<View> bottomSheetBehaviour = getBottomSheetBehaviour();
        if (bottomSheetBehaviour != null) {
            bottomSheetBehaviour.setBottomSheetCallback(new a(bottomSheetBehaviour, this));
        }
    }

    /* access modifiers changed from: protected */
    public final int c() {
        return R.layout.view_webview_bs;
    }

    public static final class a extends BottomSheetBehavior.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f76221a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WebViewBS f76222b;

        public final void onSlide(View view, float f2) {
            k.c(view, "bottomSheet");
        }

        a(BottomSheetBehavior bottomSheetBehavior, WebViewBS webViewBS) {
            this.f76221a = bottomSheetBehavior;
            this.f76222b = webViewBS;
        }

        public final void onStateChanged(View view, int i2) {
            k.c(view, "bottomSheet");
            if (i2 == 1 && this.f76222b.f76216d > 0) {
                this.f76221a.setState(3);
                this.f76222b.setExpanded(true);
            } else if (!this.f76222b.f76196b && i2 == 1) {
                this.f76221a.setState(4);
                this.f76222b.setExpanded(false);
            } else if (i2 == 5) {
                this.f76222b.f76195a.dismiss();
                this.f76222b.setExpanded(false);
            } else if (i2 == 3) {
                this.f76222b.setExpanded(true);
            }
        }
    }

    public final void a(String str) {
        if (!(str == null || d.b(str) == null)) {
            ((ObservableWebView) a(R.id.web_view)).loadDataWithBaseURL((String) null, str, "text/html", "utf-8", (String) null);
        }
        this.f76195a.show();
    }
}
