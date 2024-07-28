package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel;

public abstract class ge extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29814a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29815b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29816c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29817d;

    /* renamed from: e  reason: collision with root package name */
    protected SRPHeaderViewModel f29818e;

    public abstract void a(SRPHeaderViewModel sRPHeaderViewModel);

    protected ge(Object obj, View view, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        super(obj, view, 0);
        this.f29814a = imageView;
        this.f29815b = imageView2;
        this.f29816c = textView;
        this.f29817d = textView2;
    }
}
