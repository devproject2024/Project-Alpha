package net.one97.paytm.recharge.common.activity;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.ActionBar;
import androidx.viewpager.widget.ViewPager;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.widgets.CirclePageIndicator;
import net.one97.paytm.recharge.R;

public final class AJRViewPageWebViewActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private boolean f60841a = true;

    /* renamed from: b  reason: collision with root package name */
    private boolean f60842b;

    /* renamed from: c  reason: collision with root package name */
    private ActionBar f60843c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f60844d;

    /* renamed from: e  reason: collision with root package name */
    private String f60845e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<String> f60846f;

    /* renamed from: g  reason: collision with root package name */
    private ViewPager f60847g;

    /* renamed from: h  reason: collision with root package name */
    private CirclePageIndicator f60848h;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ajrview_page_web_view);
        this.f60847g = (ViewPager) findViewById(R.id.view_pager);
        this.f60848h = (CirclePageIndicator) findViewById(R.id.circular_page_indicator);
        WebView webView = (WebView) findViewById(R.id.web_view);
        if (getIntent().getBooleanExtra("open_single_webpage", false)) {
            ViewPager viewPager = this.f60847g;
            if (viewPager != null) {
                viewPager.setVisibility(8);
            }
            CirclePageIndicator circlePageIndicator = this.f60848h;
            if (circlePageIndicator != null) {
                circlePageIndicator.setVisibility(8);
            }
            k.a((Object) webView, "webView");
            webView.setVisibility(0);
            String stringExtra = getIntent().getStringExtra("web_page_url");
            if (!TextUtils.isEmpty(stringExtra)) {
                webView.loadUrl(com.paytm.utility.b.c((Context) this, stringExtra));
                webView.setWebViewClient(new b());
                if (Build.VERSION.SDK_INT >= 19) {
                    webView.setLayerType(2, (Paint) null);
                } else {
                    webView.setLayerType(1, (Paint) null);
                }
                WebSettings settings = webView.getSettings();
                k.a((Object) settings, "webView.settings");
                settings.setBuiltInZoomControls(true);
                WebSettings settings2 = webView.getSettings();
                k.a((Object) settings2, "webView.settings");
                settings2.setDisplayZoomControls(false);
                WebSettings settings3 = webView.getSettings();
                k.a((Object) settings3, "webView.settings");
                settings3.setLoadWithOverviewMode(true);
                WebSettings settings4 = webView.getSettings();
                k.a((Object) settings4, "webView.settings");
                settings4.setUseWideViewPort(true);
                WebSettings settings5 = webView.getSettings();
                k.a((Object) settings5, "webView.settings");
                settings5.setJavaScriptEnabled(true);
                WebSettings settings6 = webView.getSettings();
                k.a((Object) settings6, "webView.settings");
                settings6.setDomStorageEnabled(true);
                WebSettings settings7 = webView.getSettings();
                k.a((Object) settings7, "webView.settings");
                settings7.setJavaScriptCanOpenWindowsAutomatically(true);
                WebSettings settings8 = webView.getSettings();
                k.a((Object) settings8, "webView.settings");
                settings8.setCacheMode(2);
                webView.requestFocus(130);
            }
        } else {
            ViewPager viewPager2 = this.f60847g;
            if (viewPager2 != null) {
                viewPager2.setVisibility(0);
            }
            CirclePageIndicator circlePageIndicator2 = this.f60848h;
            if (circlePageIndicator2 != null) {
                circlePageIndicator2.setVisibility(0);
            }
            k.a((Object) webView, "webView");
            webView.setVisibility(8);
            this.f60846f = getIntent().getStringArrayListExtra("list_of_urls");
            ArrayList<String> arrayList = this.f60846f;
            if (arrayList != null) {
                ViewPager viewPager3 = this.f60847g;
                if (viewPager3 != null) {
                    if (arrayList == null) {
                        k.a();
                    }
                    viewPager3.setOffscreenPageLimit(arrayList.size() - 1);
                }
                ViewPager viewPager4 = this.f60847g;
                if (viewPager4 != null) {
                    ArrayList<String> arrayList2 = this.f60846f;
                    if (arrayList2 == null) {
                        k.a();
                    }
                    viewPager4.setAdapter(new a(arrayList2, this));
                }
                CirclePageIndicator circlePageIndicator3 = this.f60848h;
                if (circlePageIndicator3 != null) {
                    circlePageIndicator3.setViewPager(this.f60847g);
                }
            }
        }
        this.f60843c = getSupportActionBar();
        this.f60845e = getIntent().getStringExtra("title");
        if (!TextUtils.isEmpty(this.f60845e)) {
            ActionBar actionBar = this.f60843c;
            if (actionBar == null) {
                k.a();
            }
            actionBar.a((CharSequence) this.f60845e);
        }
        this.f60841a = true;
        ActionBar actionBar2 = this.f60843c;
        if (actionBar2 == null) {
            k.a();
        }
        actionBar2.b(true);
        if (this.f60843c == null) {
            k.a();
        }
    }

    public static final class b extends WebViewClient {
        b() {
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            k.c(webView, "view");
            k.c(str, "url");
            webView.loadUrl(str);
            return false;
        }
    }

    public final void onPause() {
        super.onPause();
        this.f60844d = true;
        com.paytm.utility.b.u();
        if (this.f60842b) {
            finish();
        }
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        k.c(menuItem, "menuItem");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public static final class a extends androidx.viewpager.widget.a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList<String> f60849a;

        /* renamed from: b  reason: collision with root package name */
        private final Context f60850b;

        public a(ArrayList<String> arrayList, Context context) {
            k.c(arrayList, "urls");
            k.c(context, "context");
            this.f60849a = arrayList;
            this.f60850b = context;
        }

        public final int getCount() {
            return this.f60849a.size();
        }

        public final boolean isViewFromObject(View view, Object obj) {
            k.c(view, "p0");
            k.c(obj, "p1");
            return k.a((Object) view, obj);
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i2) {
            k.c(viewGroup, "container");
            View inflate = LayoutInflater.from(this.f60850b).inflate(R.layout.web_view_item_for_pager, (ViewGroup) null);
            WebView webView = (WebView) inflate.findViewById(R.id.web_view);
            k.a((Object) webView, "webView");
            webView.setVisibility(0);
            webView.loadUrl(com.paytm.utility.b.c(this.f60850b, this.f60849a.get(i2)));
            webView.setWebViewClient(new C1171a());
            if (Build.VERSION.SDK_INT >= 19) {
                webView.setLayerType(2, (Paint) null);
            } else {
                webView.setLayerType(1, (Paint) null);
            }
            WebSettings settings = webView.getSettings();
            k.a((Object) settings, "webView.settings");
            settings.setBuiltInZoomControls(true);
            WebSettings settings2 = webView.getSettings();
            k.a((Object) settings2, "webView.settings");
            settings2.setDisplayZoomControls(false);
            WebSettings settings3 = webView.getSettings();
            k.a((Object) settings3, "webView.settings");
            settings3.setLoadWithOverviewMode(true);
            WebSettings settings4 = webView.getSettings();
            k.a((Object) settings4, "webView.settings");
            settings4.setUseWideViewPort(true);
            WebSettings settings5 = webView.getSettings();
            k.a((Object) settings5, "webView.settings");
            settings5.setJavaScriptEnabled(true);
            WebSettings settings6 = webView.getSettings();
            k.a((Object) settings6, "webView.settings");
            settings6.setDomStorageEnabled(true);
            WebSettings settings7 = webView.getSettings();
            k.a((Object) settings7, "webView.settings");
            settings7.setJavaScriptCanOpenWindowsAutomatically(true);
            WebSettings settings8 = webView.getSettings();
            k.a((Object) settings8, "webView.settings");
            settings8.setCacheMode(2);
            webView.requestFocus(130);
            viewGroup.addView(inflate);
            k.a((Object) inflate, Item.KEY_LAYOUT);
            return inflate;
        }

        /* renamed from: net.one97.paytm.recharge.common.activity.AJRViewPageWebViewActivity$a$a  reason: collision with other inner class name */
        public static final class C1171a extends WebViewClient {
            C1171a() {
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                k.c(webView, "view");
                k.c(str, "url");
                webView.loadUrl(str);
                return false;
            }
        }

        public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            k.c(viewGroup, "container");
            k.c(obj, "view");
            ((ViewPager) viewGroup).removeView((View) obj);
        }
    }
}
