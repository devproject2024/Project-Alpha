package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel;
import net.one97.paytm.hotel4.viewmodel.SRPViewModel;

public abstract class ey extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f29670a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29671b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f29672c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29673d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f29674e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29675f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f29676g;

    /* renamed from: h  reason: collision with root package name */
    protected SRPHeaderViewModel f29677h;

    /* renamed from: i  reason: collision with root package name */
    protected SRPViewModel f29678i;

    public abstract void a(SRPHeaderViewModel sRPHeaderViewModel);

    public abstract void a(SRPViewModel sRPViewModel);

    protected ey(Object obj, View view, TextView textView, TextView textView2, ImageView imageView, TextView textView3, LinearLayout linearLayout, TextView textView4, TextView textView5) {
        super(obj, view, 2);
        this.f29670a = textView;
        this.f29671b = textView2;
        this.f29672c = imageView;
        this.f29673d = textView3;
        this.f29674e = linearLayout;
        this.f29675f = textView4;
        this.f29676g = textView5;
    }
}
