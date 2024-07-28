package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterViewModel;

public abstract class ai extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f29140a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29141b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29142c;

    /* renamed from: d  reason: collision with root package name */
    protected SRPFilterViewModel f29143d;

    public abstract void a(SRPFilterViewModel sRPFilterViewModel);

    protected ai(Object obj, View view, TextView textView, ImageView imageView, TextView textView2) {
        super(obj, view, 1);
        this.f29140a = textView;
        this.f29141b = imageView;
        this.f29142c = textView2;
    }
}
