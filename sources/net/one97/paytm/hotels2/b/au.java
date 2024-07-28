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
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotels2.R;

public abstract class au extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29193a;

    /* renamed from: b  reason: collision with root package name */
    public final CardView f29194b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29195c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29196d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f29197e;

    /* renamed from: f  reason: collision with root package name */
    public final ConstraintLayout f29198f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f29199g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f29200h;

    /* renamed from: i  reason: collision with root package name */
    protected DetailsViewModel f29201i;

    public abstract void a(DetailsViewModel detailsViewModel);

    protected au(Object obj, View view, ImageView imageView, CardView cardView, TextView textView, TextView textView2, ImageView imageView2, ConstraintLayout constraintLayout, TextView textView3, TextView textView4) {
        super(obj, view, 3);
        this.f29193a = imageView;
        this.f29194b = cardView;
        this.f29195c = textView;
        this.f29196d = textView2;
        this.f29197e = imageView2;
        this.f29198f = constraintLayout;
        this.f29199g = textView3;
        this.f29200h = textView4;
    }

    public static au a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (au) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_fragment_full_map, viewGroup, false, f.a());
    }
}
