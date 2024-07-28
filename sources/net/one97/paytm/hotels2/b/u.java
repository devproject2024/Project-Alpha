package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;

public abstract class u extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29942a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29943b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29944c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29945d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29946e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29947f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f29948g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f29949h;

    /* renamed from: i  reason: collision with root package name */
    protected DetailsViewModel f29950i;

    public abstract void a(DetailsViewModel detailsViewModel);

    protected u(Object obj, View view, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, 3);
        this.f29942a = imageView;
        this.f29943b = textView;
        this.f29944c = textView2;
        this.f29945d = textView3;
        this.f29946e = textView4;
        this.f29947f = textView5;
        this.f29948g = textView6;
        this.f29949h = textView7;
    }
}
