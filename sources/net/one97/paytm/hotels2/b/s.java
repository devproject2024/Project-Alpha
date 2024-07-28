package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;

public abstract class s extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f29933a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29934b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29935c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29936d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29937e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29938f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f29939g;

    /* renamed from: h  reason: collision with root package name */
    public final ConstraintLayout f29940h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f29941i;
    protected DetailsViewModel j;

    public abstract void a(DetailsViewModel detailsViewModel);

    protected s(Object obj, View view, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, ConstraintLayout constraintLayout, TextView textView7) {
        super(obj, view, 6);
        this.f29933a = recyclerView;
        this.f29934b = textView;
        this.f29935c = textView2;
        this.f29936d = textView3;
        this.f29937e = textView4;
        this.f29938f = textView5;
        this.f29939g = textView6;
        this.f29940h = constraintLayout;
        this.f29941i = textView7;
    }
}
