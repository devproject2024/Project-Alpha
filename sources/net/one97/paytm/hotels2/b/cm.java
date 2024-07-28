package net.one97.paytm.hotels2.b;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterLocalityAndHotelChainItemViewModel;

public abstract class cm extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f29380a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29381b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f29382c;

    /* renamed from: d  reason: collision with root package name */
    protected Drawable f29383d;

    /* renamed from: e  reason: collision with root package name */
    protected SRPFilterLocalityAndHotelChainItemViewModel f29384e;

    public abstract void a(Drawable drawable);

    public abstract void a(SRPFilterLocalityAndHotelChainItemViewModel sRPFilterLocalityAndHotelChainItemViewModel);

    protected cm(Object obj, View view, View view2, ImageView imageView, ImageView imageView2) {
        super(obj, view, 2);
        this.f29380a = view2;
        this.f29381b = imageView;
        this.f29382c = imageView2;
    }
}
