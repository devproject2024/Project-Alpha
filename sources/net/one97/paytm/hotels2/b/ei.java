package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.PagerGalleryViewModel;

public abstract class ei extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29599a;

    /* renamed from: b  reason: collision with root package name */
    protected String f29600b;

    /* renamed from: c  reason: collision with root package name */
    protected String f29601c;

    /* renamed from: d  reason: collision with root package name */
    protected PagerGalleryViewModel f29602d;

    /* renamed from: e  reason: collision with root package name */
    protected Integer f29603e;

    public abstract void a(Integer num);

    public abstract void a(String str);

    public abstract void a(PagerGalleryViewModel pagerGalleryViewModel);

    public abstract void b(String str);

    protected ei(Object obj, View view, ImageView imageView) {
        super(obj, view, 0);
        this.f29599a = imageView;
    }
}
