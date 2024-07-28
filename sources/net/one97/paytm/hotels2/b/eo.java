package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel;

public abstract class eo extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f29626a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29627b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f29628c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f29629d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29630e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29631f;

    /* renamed from: g  reason: collision with root package name */
    protected SRPHeaderViewModel f29632g;

    public abstract void a(SRPHeaderViewModel sRPHeaderViewModel);

    protected eo(Object obj, View view, TextView textView, TextView textView2, ImageView imageView, LinearLayout linearLayout, TextView textView3, TextView textView4) {
        super(obj, view, 0);
        this.f29626a = textView;
        this.f29627b = textView2;
        this.f29628c = imageView;
        this.f29629d = linearLayout;
        this.f29630e = textView3;
        this.f29631f = textView4;
    }
}
