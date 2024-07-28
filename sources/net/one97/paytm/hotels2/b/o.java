package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;

public abstract class o extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29915a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29916b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29917c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29918d;

    /* renamed from: e  reason: collision with root package name */
    protected DetailsViewModel f29919e;

    public abstract void a(DetailsViewModel detailsViewModel);

    protected o(Object obj, View view, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        super(obj, view, 1);
        this.f29915a = imageView;
        this.f29916b = imageView2;
        this.f29917c = textView;
        this.f29918d = textView2;
    }
}
