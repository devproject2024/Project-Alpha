package net.one97.paytm.phoenix.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import kotlin.g.b.k;

public final class o {

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f59652a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f59653b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ViewGroup f59654c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ WebView f59655d;

        public a(Context context, View view, ViewGroup viewGroup, WebView webView) {
            this.f59652a = context;
            this.f59653b = view;
            this.f59654c = viewGroup;
            this.f59655d = webView;
        }

        public final void onGlobalLayout() {
            Resources resources = ((Activity) this.f59652a).getResources();
            k.a((Object) resources, "context.resources");
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            Rect rect = new Rect();
            this.f59653b.getWindowVisibleDisplayFrame(rect);
            int i2 = displayMetrics.heightPixels - rect.bottom;
            if (this.f59654c.getPaddingBottom() != i2) {
                ViewGroup viewGroup = this.f59654c;
                viewGroup.setPadding(viewGroup.getPaddingLeft(), this.f59654c.getPaddingTop(), this.f59654c.getPaddingRight(), i2);
                if (i2 < 0) {
                    ViewGroup viewGroup2 = this.f59654c;
                    viewGroup2.setPadding(viewGroup2.getPaddingLeft(), this.f59654c.getPaddingTop(), this.f59654c.getPaddingRight(), 0);
                }
            } else if (i2 != 0) {
                this.f59655d.evaluateJavascript("if (document.activeElement) { document.activeElement.scrollIntoView({behavior: \"smooth\", block: \"center\", inline: \"nearest\"}); }", (ValueCallback) null);
            }
        }
    }
}
