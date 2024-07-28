package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.hotel4.viewmodel.SRPSortViewModel;
import net.one97.paytm.hotels2.R;

public abstract class fa extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29680a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f29681b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29682c;

    /* renamed from: d  reason: collision with root package name */
    protected SRPSortViewModel f29683d;

    public abstract void a(SRPSortViewModel sRPSortViewModel);

    protected fa(Object obj, View view, ImageView imageView, RecyclerView recyclerView, TextView textView) {
        super(obj, view, 0);
        this.f29680a = imageView;
        this.f29681b = recyclerView;
        this.f29682c = textView;
    }

    public static fa a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (fa) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_srp_sort_view, viewGroup, false, f.a());
    }
}
