package net.one97.paytm.oauth.utils;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import java.lang.ref.WeakReference;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.activity.OauthWebViewActivity;
import net.one97.paytm.oauth.c.c;

public final class d extends c {

    /* renamed from: b  reason: collision with root package name */
    private boolean f56765b;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<Context> f56766c;

    /* renamed from: d  reason: collision with root package name */
    private String f56767d;

    public d(String str, boolean z, Context context) {
        super(str);
        this.f56767d = str;
        this.f56765b = z;
        this.f56766c = new WeakReference<>(context);
    }

    public final void onClick(View view) {
        String str;
        String str2 = this.f56767d;
        boolean z = this.f56765b;
        WeakReference<Context> weakReference = this.f56766c;
        if (weakReference != null && weakReference.get() != null) {
            if (z) {
                str = OauthModule.a().f52574a;
            } else {
                str = OauthModule.a().f52575b;
            }
            Intent intent = new Intent((Context) this.f56766c.get(), OauthWebViewActivity.class);
            intent.putExtra("webview_url", str);
            intent.putExtra("webview_title", str2);
            ((Context) this.f56766c.get()).startActivity(intent);
        }
    }
}
