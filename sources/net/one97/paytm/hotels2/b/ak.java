package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterViewModel;

public abstract class ak extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f29149a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29150b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29151c;

    /* renamed from: d  reason: collision with root package name */
    protected SRPFilterViewModel f29152d;

    public abstract void a(SRPFilterViewModel sRPFilterViewModel);

    protected ak(Object obj, View view, TextView textView, ImageView imageView, TextView textView2) {
        super(obj, view, 1);
        this.f29149a = textView;
        this.f29150b = imageView;
        this.f29151c = textView2;
    }
}
