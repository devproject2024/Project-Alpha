package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotel4.viewmodel.GalleryViewModel;
import net.one97.paytm.hotels2.R;

public abstract class bc extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final Button f29229a;

    /* renamed from: b  reason: collision with root package name */
    public final TabLayout f29230b;

    /* renamed from: c  reason: collision with root package name */
    public final be f29231c;

    /* renamed from: d  reason: collision with root package name */
    public final ViewPager f29232d;

    /* renamed from: e  reason: collision with root package name */
    protected GalleryViewModel f29233e;

    /* renamed from: f  reason: collision with root package name */
    protected DetailsViewModel f29234f;

    public abstract void a(DetailsViewModel detailsViewModel);

    public abstract void a(GalleryViewModel galleryViewModel);

    protected bc(Object obj, View view, Button button, TabLayout tabLayout, be beVar, ViewPager viewPager) {
        super(obj, view, 1);
        this.f29229a = button;
        this.f29230b = tabLayout;
        this.f29231c = beVar;
        setContainedBinding(this.f29231c);
        this.f29232d = viewPager;
    }

    public static bc a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (bc) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_gallery_fragment, viewGroup, false, f.a());
    }
}
