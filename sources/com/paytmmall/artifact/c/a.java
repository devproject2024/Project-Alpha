package com.paytmmall.artifact.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.common.b;
import com.paytmmall.artifact.d.t;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.orflow.Utility;

public class a extends h {

    /* renamed from: a  reason: collision with root package name */
    public WebView f15402a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15403b = "startTime";

    /* renamed from: c  reason: collision with root package name */
    private final String f15404c = "mallCallback";

    /* renamed from: d  reason: collision with root package name */
    private String f15405d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f15406e;

    /* renamed from: f  reason: collision with root package name */
    private BroadcastReceiver f15407f = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (a.this.isAdded() && intent != null && !TextUtils.isEmpty(intent.getAction()) && "action_update_login_status".equals(intent.getAction())) {
                a.this.a();
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_h5_my_profile, viewGroup, false);
        if (inflate != null) {
            this.f15402a = (WebView) inflate.findViewById(R.id.h5MyProfile);
            WebSettings settings = this.f15402a.getSettings();
            settings.setAppCacheMaxSize(5242880);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                settings.setAppCachePath(activity.getCacheDir().getAbsolutePath());
            }
            settings.setAllowFileAccess(true);
            settings.setAppCacheEnabled(true);
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            this.f15402a.addJavascriptInterface(new b(getActivity(), this.f15402a), Utility.VERTICAL_NAME_MALL);
            a();
            WebView.setWebContentsDebuggingEnabled(true);
            this.f15402a.canGoBack();
            this.f15402a.setOnKeyListener(new View.OnKeyListener() {
                public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                    return a.this.a(view, i2, keyEvent);
                }
            });
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("action_update_login_status");
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                androidx.localbroadcastmanager.a.a.a((Context) activity2).a(this.f15407f, intentFilter);
            }
        }
        return inflate;
    }

    public void onResume() {
        super.onResume();
        if (!this.f15406e) {
            a();
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing() && !TextUtils.isEmpty(t.e().getSSOToken(getActivity()))) {
            this.f15405d = com.paytmmall.a.a.g();
            this.f15402a.loadUrl(this.f15405d);
            this.f15406e = true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, int i2, KeyEvent keyEvent) {
        if (i2 != 4 || keyEvent.getAction() != 1 || !this.f15402a.canGoBack()) {
            return false;
        }
        this.f15402a.goBack();
        this.f15402a.loadUrl("javascript:onBackPress();");
        return true;
    }
}
