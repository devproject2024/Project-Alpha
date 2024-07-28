package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotel4.viewmodel.GalleryViewModel;

public abstract class be extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29238a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29239b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29240c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29241d;

    /* renamed from: e  reason: collision with root package name */
    protected GalleryViewModel f29242e;

    /* renamed from: f  reason: collision with root package name */
    protected DetailsViewModel f29243f;

    public abstract void a(DetailsViewModel detailsViewModel);

    public abstract void a(GalleryViewModel galleryViewModel);

    protected be(Object obj, View view, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        super(obj, view, 1);
        this.f29238a = imageView;
        this.f29239b = imageView2;
        this.f29240c = textView;
        this.f29241d = textView2;
    }
}
