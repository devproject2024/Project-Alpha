package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.SRPViewModel;

public abstract class bq extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f29281a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29282b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29283c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f29284d;

    /* renamed from: e  reason: collision with root package name */
    protected SRPViewModel f29285e;

    public abstract void a(SRPViewModel sRPViewModel);

    protected bq(Object obj, View view, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2) {
        super(obj, view, 4);
        this.f29281a = textView;
        this.f29282b = imageView;
        this.f29283c = textView2;
        this.f29284d = imageView2;
    }
}
