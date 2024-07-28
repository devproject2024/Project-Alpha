package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotels2.R;

public abstract class eg extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f29590a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29591b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29592c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29593d;

    /* renamed from: e  reason: collision with root package name */
    public final View f29594e;

    /* renamed from: f  reason: collision with root package name */
    public final View f29595f;

    /* renamed from: g  reason: collision with root package name */
    protected DetailsViewModel f29596g;

    public abstract void a(DetailsViewModel detailsViewModel);

    protected eg(Object obj, View view, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, View view2, View view3) {
        super(obj, view, 0);
        this.f29590a = recyclerView;
        this.f29591b = textView;
        this.f29592c = textView2;
        this.f29593d = textView3;
        this.f29594e = view2;
        this.f29595f = view3;
    }

    public static eg a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (eg) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_rs_sticky_header, viewGroup, false, f.a());
    }
}
