package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterViewModel;

public abstract class ao extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f29168a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29169b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29170c;

    /* renamed from: d  reason: collision with root package name */
    protected SRPFilterViewModel f29171d;

    public abstract void a(SRPFilterViewModel sRPFilterViewModel);

    protected ao(Object obj, View view, TextView textView, ImageView imageView, TextView textView2) {
        super(obj, view, 1);
        this.f29168a = textView;
        this.f29169b = imageView;
        this.f29170c = textView2;
    }
}
