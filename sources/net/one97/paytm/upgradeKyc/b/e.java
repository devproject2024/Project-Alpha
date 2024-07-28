package net.one97.paytm.upgradeKyc.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.upgradeKyc.aotp.b.c;

public abstract class e extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f65587a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f65588b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f65589c;

    /* renamed from: d  reason: collision with root package name */
    public final View f65590d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f65591e;

    /* renamed from: f  reason: collision with root package name */
    public final LottieAnimationView f65592f;

    /* renamed from: g  reason: collision with root package name */
    public final ConstraintLayout f65593g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f65594h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f65595i;
    protected c j;

    public abstract void a(c cVar);

    protected e(Object obj, View view, ImageView imageView, TextView textView, TextView textView2, View view2, TextView textView3, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout, TextView textView4, TextView textView5) {
        super(obj, view, 0);
        this.f65587a = imageView;
        this.f65588b = textView;
        this.f65589c = textView2;
        this.f65590d = view2;
        this.f65591e = textView3;
        this.f65592f = lottieAnimationView;
        this.f65593g = constraintLayout;
        this.f65594h = textView4;
        this.f65595i = textView5;
    }
}
