package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterItemViewModel;

public abstract class fi extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f29712a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29713b;

    /* renamed from: c  reason: collision with root package name */
    protected String f29714c;

    /* renamed from: d  reason: collision with root package name */
    protected SRPFilterItemViewModel f29715d;

    public abstract void a(String str);

    public abstract void a(SRPFilterItemViewModel sRPFilterItemViewModel);

    protected fi(Object obj, View view, TextView textView, ImageView imageView) {
        super(obj, view, 2);
        this.f29712a = textView;
        this.f29713b = imageView;
    }
}
