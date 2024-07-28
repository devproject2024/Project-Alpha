package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;

public abstract class dc extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29447a;

    /* renamed from: b  reason: collision with root package name */
    public final CardView f29448b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f29449c;

    /* renamed from: d  reason: collision with root package name */
    public final View f29450d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29451e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29452f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f29453g;

    /* renamed from: h  reason: collision with root package name */
    protected ReviewViewModel f29454h;

    public abstract void a(ReviewViewModel reviewViewModel);

    protected dc(Object obj, View view, ImageView imageView, CardView cardView, ImageView imageView2, View view2, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, 3);
        this.f29447a = imageView;
        this.f29448b = cardView;
        this.f29449c = imageView2;
        this.f29450d = view2;
        this.f29451e = textView;
        this.f29452f = textView2;
        this.f29453g = textView3;
    }
}
