package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.hotel4.viewmodel.CancelOrderViewModel;

public abstract class c extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29324a;

    /* renamed from: b  reason: collision with root package name */
    public final CardView f29325b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f29326c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f29327d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29328e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29329f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f29330g;

    /* renamed from: h  reason: collision with root package name */
    public final View f29331h;

    /* renamed from: i  reason: collision with root package name */
    public final View f29332i;
    protected CancelOrderViewModel j;

    public abstract void a(CancelOrderViewModel cancelOrderViewModel);

    protected c(Object obj, View view, ImageView imageView, CardView cardView, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView, TextView textView2, TextView textView3, View view2, View view3) {
        super(obj, view, 1);
        this.f29324a = imageView;
        this.f29325b = cardView;
        this.f29326c = recyclerView;
        this.f29327d = recyclerView2;
        this.f29328e = textView;
        this.f29329f = textView2;
        this.f29330g = textView3;
        this.f29331h = view2;
        this.f29332i = view3;
    }
}
