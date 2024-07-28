package net.one97.paytm.o2o.movies.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

public final class ObservableWebView extends WebView {

    /* renamed from: a  reason: collision with root package name */
    private a f76165a;

    public interface a {
        void a(int i2);
    }

    public final a getOnScrollChangedCallback() {
        return this.f76165a;
    }

    public final void setOnScrollChangedCallback(a aVar) {
        this.f76165a = aVar;
    }

    public ObservableWebView(Context context) {
        super(context);
    }

    public ObservableWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ObservableWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public final void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        a aVar = this.f76165a;
        if (aVar != null) {
            aVar.a(i3);
        }
    }
}
