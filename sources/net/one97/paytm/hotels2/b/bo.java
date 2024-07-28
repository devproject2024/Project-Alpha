package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.hotel4.viewmodel.HotelBookingStatusViewModel;

public abstract class bo extends ViewDataBinding {
    public final LinearLayout A;
    public final ImageView B;
    public final ImageView C;
    public final ShimmerFrameLayout D;
    public final FrameLayout E;
    public final TextView F;
    public final by G;
    public final Toolbar H;
    public final ImageView I;
    public final ImageView J;
    public final TextView K;
    public final TextView L;
    public final TextView M;
    public final TextView N;
    public final TextView O;
    protected HotelBookingStatusViewModel P;

    /* renamed from: a  reason: collision with root package name */
    public final AppBarLayout f29272a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f29273b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29274c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29275d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f29276e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f29277f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f29278g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f29279h;

    /* renamed from: i  reason: collision with root package name */
    public final ImageView f29280i;
    public final TextView j;
    public final CollapsingToolbarLayout k;
    public final LinearLayout l;
    public final ImageView m;
    public final FrameLayout n;
    public final TextView o;
    public final ImageView p;
    public final ImageView q;
    public final ImageView r;
    public final ImageView s;
    public final CardView t;
    public final View u;
    public final View v;
    public final NestedScrollView w;
    public final bw x;
    public final TextView y;
    public final bu z;

    public abstract void a(HotelBookingStatusViewModel hotelBookingStatusViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected bo(Object obj, View view, AppBarLayout appBarLayout, LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView, LinearLayout linearLayout4, ImageView imageView2, TextView textView3, CollapsingToolbarLayout collapsingToolbarLayout, LinearLayout linearLayout5, ImageView imageView3, FrameLayout frameLayout, TextView textView4, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, CardView cardView, View view2, View view3, NestedScrollView nestedScrollView, bw bwVar, TextView textView5, bu buVar, LinearLayout linearLayout6, ImageView imageView8, ImageView imageView9, ShimmerFrameLayout shimmerFrameLayout, FrameLayout frameLayout2, TextView textView6, by byVar, Toolbar toolbar, ImageView imageView10, ImageView imageView11, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        super(obj, view, 7);
        Object obj2 = obj;
        View view4 = view;
        this.f29272a = appBarLayout;
        this.f29273b = linearLayout;
        this.f29274c = textView;
        this.f29275d = textView2;
        this.f29276e = linearLayout2;
        this.f29277f = linearLayout3;
        this.f29278g = imageView;
        this.f29279h = linearLayout4;
        this.f29280i = imageView2;
        this.j = textView3;
        this.k = collapsingToolbarLayout;
        this.l = linearLayout5;
        this.m = imageView3;
        this.n = frameLayout;
        this.o = textView4;
        this.p = imageView4;
        this.q = imageView5;
        this.r = imageView6;
        this.s = imageView7;
        this.t = cardView;
        this.u = view2;
        this.v = view3;
        this.w = nestedScrollView;
        this.x = bwVar;
        setContainedBinding(this.x);
        this.y = textView5;
        this.z = buVar;
        setContainedBinding(this.z);
        this.A = linearLayout6;
        this.B = imageView8;
        this.C = imageView9;
        this.D = shimmerFrameLayout;
        this.E = frameLayout2;
        this.F = textView6;
        this.G = byVar;
        setContainedBinding(this.G);
        this.H = toolbar;
        this.I = imageView10;
        this.J = imageView11;
        this.K = textView7;
        this.L = textView8;
        this.M = textView9;
        this.N = textView10;
        this.O = textView11;
    }
}
