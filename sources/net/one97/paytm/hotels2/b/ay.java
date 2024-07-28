package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.travel.customViews.GalleryLoopRecyclerView;
import net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel;
import net.one97.paytm.hotel4.viewmodel.SRPViewModel;
import net.one97.paytm.hotels2.R;

public abstract class ay extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29211a;

    /* renamed from: b  reason: collision with root package name */
    public final CardView f29212b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29213c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29214d;

    /* renamed from: e  reason: collision with root package name */
    public final GalleryLoopRecyclerView f29215e;

    /* renamed from: f  reason: collision with root package name */
    public final ConstraintLayout f29216f;

    /* renamed from: g  reason: collision with root package name */
    protected SRPViewModel f29217g;

    /* renamed from: h  reason: collision with root package name */
    protected SRPHeaderViewModel f29218h;

    public abstract void a(SRPHeaderViewModel sRPHeaderViewModel);

    public abstract void a(SRPViewModel sRPViewModel);

    protected ay(Object obj, View view, ImageView imageView, CardView cardView, TextView textView, TextView textView2, GalleryLoopRecyclerView galleryLoopRecyclerView, ConstraintLayout constraintLayout) {
        super(obj, view, 0);
        this.f29211a = imageView;
        this.f29212b = cardView;
        this.f29213c = textView;
        this.f29214d = textView2;
        this.f29215e = galleryLoopRecyclerView;
        this.f29216f = constraintLayout;
    }

    public static ay a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (ay) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_fragment_map, viewGroup, false, f.a());
    }
}
