package net.one97.paytm.prime.c;

import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;

public abstract class a extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f59746a;

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f59747b;

    /* renamed from: c  reason: collision with root package name */
    public final LottieAnimationView f59748c;

    /* renamed from: d  reason: collision with root package name */
    public final WebView f59749d;

    /* renamed from: e  reason: collision with root package name */
    public final RelativeLayout f59750e;

    protected a(Object obj, View view, View view2, FrameLayout frameLayout, LottieAnimationView lottieAnimationView, WebView webView, RelativeLayout relativeLayout) {
        super(obj, view, 0);
        this.f59746a = view2;
        this.f59747b = frameLayout;
        this.f59748c = lottieAnimationView;
        this.f59749d = webView;
        this.f59750e = relativeLayout;
    }
}
