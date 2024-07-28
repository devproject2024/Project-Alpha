package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.viewpager.widget.ViewPager;
import net.one97.paytm.hotel4.viewmodel.PagerGalleryViewModel;
import net.one97.paytm.hotels2.R;

public abstract class bg extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ViewPager f29247a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29248b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f29249c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29250d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29251e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29252f;

    /* renamed from: g  reason: collision with root package name */
    protected PagerGalleryViewModel f29253g;

    public abstract void a(PagerGalleryViewModel pagerGalleryViewModel);

    protected bg(Object obj, View view, ViewPager viewPager, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, 2);
        this.f29247a = viewPager;
        this.f29248b = imageView;
        this.f29249c = linearLayout;
        this.f29250d = textView;
        this.f29251e = textView2;
        this.f29252f = textView3;
    }

    public static bg a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (bg) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_gallery_item_selection_fragment, viewGroup, false, f.a());
    }
}
