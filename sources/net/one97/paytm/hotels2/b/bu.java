package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.hotel4.viewmodel.HotelBookingStatusViewModel;

public abstract class bu extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final CardView f29298a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29299b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f29300c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f29301d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29302e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29303f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f29304g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f29305h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f29306i;
    public final TextView j;
    public final View k;
    public final View l;
    public final View m;
    protected HotelBookingStatusViewModel n;

    public abstract void a(HotelBookingStatusViewModel hotelBookingStatusViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected bu(Object obj, View view, CardView cardView, ImageView imageView, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, View view2, View view3, View view4) {
        super(obj, view, 1);
        Object obj2 = obj;
        View view5 = view;
        this.f29298a = cardView;
        this.f29299b = imageView;
        this.f29300c = recyclerView;
        this.f29301d = recyclerView2;
        this.f29302e = textView;
        this.f29303f = textView2;
        this.f29304g = textView3;
        this.f29305h = textView4;
        this.f29306i = textView5;
        this.j = textView6;
        this.k = view2;
        this.l = view3;
        this.m = view4;
    }
}
