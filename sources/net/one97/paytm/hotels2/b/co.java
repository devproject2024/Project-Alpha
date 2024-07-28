package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotels2.R;

public abstract class co extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29389a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29390b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29391c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29392d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29393e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29394f;

    /* renamed from: g  reason: collision with root package name */
    protected DetailsViewModel f29395g;

    public abstract void a(DetailsViewModel detailsViewModel);

    protected co(Object obj, View view, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, 0);
        this.f29389a = imageView;
        this.f29390b = imageView2;
        this.f29391c = textView;
        this.f29392d = textView2;
        this.f29393e = textView3;
        this.f29394f = textView4;
    }

    public static co a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (co) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_no_rooms_bottom_sheet, viewGroup, false, f.a());
    }
}
