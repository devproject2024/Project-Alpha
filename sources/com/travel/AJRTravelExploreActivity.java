package com.travel;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.common.widgets.a;

public class AJRTravelExploreActivity extends CJRActionBarBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private static WebView f21379a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public LottieAnimationView f21380b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(getString(R.string.travel_explore_heading));
        e();
        c();
        d();
        setContentView(R.layout.pre_td_activity_ajrtravel_explore);
        f21379a = (WebView) findViewById(R.id.webView);
        this.f21380b = (LottieAnimationView) findViewById(R.id.progress);
        Bundle extras = getIntent().getExtras();
        if (extras.containsKey("extra_home_data")) {
            f21379a.getSettings().setJavaScriptEnabled(true);
            f21379a.loadUrl(extras.getString("extra_home_data"));
        }
        f21379a.setWebViewClient(new WebViewClient() {
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return true;
            }

            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                AJRTravelExploreActivity.this.f21380b.setVisibility(0);
                a.a(AJRTravelExploreActivity.this.f21380b);
            }

            public final void onPageFinished(WebView webView, String str) {
                AJRTravelExploreActivity.this.f21380b.setVisibility(8);
                a.b(AJRTravelExploreActivity.this.f21380b);
            }
        });
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        d();
        c();
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
