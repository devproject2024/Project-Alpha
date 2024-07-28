package net.one97.paytm.acceptPayment.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.acceptPayment.viewModel.c;
import net.one97.paytm.acceptPayment.webview.VideoEnabledWebView;

public abstract class m extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LottieAnimationView f52009a;

    /* renamed from: b  reason: collision with root package name */
    public final VideoEnabledWebView f52010b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f52011c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f52012d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f52013e;

    /* renamed from: f  reason: collision with root package name */
    public final RelativeLayout f52014f;

    /* renamed from: g  reason: collision with root package name */
    public final ConstraintLayout f52015g;

    /* renamed from: h  reason: collision with root package name */
    protected c f52016h;

    public abstract void a(c cVar);

    protected m(Object obj, View view, LottieAnimationView lottieAnimationView, VideoEnabledWebView videoEnabledWebView, ImageView imageView, RelativeLayout relativeLayout, TextView textView, RelativeLayout relativeLayout2, ConstraintLayout constraintLayout) {
        super(obj, view, 3);
        this.f52009a = lottieAnimationView;
        this.f52010b = videoEnabledWebView;
        this.f52011c = imageView;
        this.f52012d = relativeLayout;
        this.f52013e = textView;
        this.f52014f = relativeLayout2;
        this.f52015g = constraintLayout;
    }
}
