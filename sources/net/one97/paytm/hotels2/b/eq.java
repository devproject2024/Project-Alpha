package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterViewModel;

public abstract class eq extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29635a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29636b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29637c;

    /* renamed from: d  reason: collision with root package name */
    protected SRPFilterViewModel f29638d;

    public abstract void a(SRPFilterViewModel sRPFilterViewModel);

    protected eq(Object obj, View view, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, 1);
        this.f29635a = imageView;
        this.f29636b = textView;
        this.f29637c = textView2;
    }
}
