package net.one97.paytm.phoenix.core.web;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import kotlin.g.b.k;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final WebView f59422a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f59423b;

    public d(WebView webView, boolean z) {
        k.c(webView, "webView");
        this.f59422a = webView;
        this.f59423b = z;
    }

    public static final class a implements DownloadListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f59424a;

        public a(d dVar) {
            this.f59424a = dVar;
        }

        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Uri parse = Uri.parse(str);
            k.a((Object) parse, "Uri.parse(url)");
            this.f59424a.f59422a.getContext().startActivity(new Intent("android.intent.action.VIEW", parse));
        }
    }
}
