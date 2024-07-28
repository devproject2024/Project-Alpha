package net.one97.paytm.hotels2.b;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.PagerGalleryViewModel;

public abstract class fk extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29721a;

    /* renamed from: b  reason: collision with root package name */
    protected String f29722b;

    /* renamed from: c  reason: collision with root package name */
    protected Drawable f29723c;

    /* renamed from: d  reason: collision with root package name */
    protected String f29724d;

    /* renamed from: e  reason: collision with root package name */
    protected PagerGalleryViewModel f29725e;

    public abstract void a(String str);

    public abstract void a(PagerGalleryViewModel pagerGalleryViewModel);

    public abstract void b(String str);

    protected fk(Object obj, View view, ImageView imageView) {
        super(obj, view, 0);
        this.f29721a = imageView;
    }
}
