package net.one97.paytm.games.view.pfg.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.webkit.WebView;
import kotlin.g.b.k;

public final class GamesWebView extends WebView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f35742a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GamesWebView(Context context) {
        super(context);
        k.c(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GamesWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        k.c(attributeSet, "attrs");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GamesWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        k.c(attributeSet, "attrs");
    }

    public final boolean getMIsInViewPager$paytmGamepind_release() {
        return this.f35742a;
    }

    public final void setMIsInViewPager$paytmGamepind_release(boolean z) {
        this.f35742a = z;
    }

    /* access modifiers changed from: protected */
    public final void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        ViewParent parent;
        if (this.f35742a && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        super.onOverScrolled(i2, i3, z, z2);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        k.c(motionEvent, "p_event");
        if (motionEvent.getAction() == 2 && this.f35742a && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(motionEvent);
    }
}
