package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.HotelSearchViewModel;

public abstract class gm extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29850a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29851b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29852c;

    /* renamed from: d  reason: collision with root package name */
    protected HotelSearchViewModel f29853d;

    public abstract void a(HotelSearchViewModel hotelSearchViewModel);

    protected gm(Object obj, View view, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, 1);
        this.f29850a = imageView;
        this.f29851b = textView;
        this.f29852c = textView2;
    }
}
