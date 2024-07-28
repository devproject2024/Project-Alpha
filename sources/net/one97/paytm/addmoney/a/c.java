package net.one97.paytm.addmoney.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.utils.CustomAmountTextInputEditText;

public abstract class c extends ViewDataBinding {
    public final LottieAnimationView A;
    protected net.one97.paytm.autoaddmoney.c.c B;

    /* renamed from: a  reason: collision with root package name */
    public final TextView f48023a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f48024b;

    /* renamed from: c  reason: collision with root package name */
    public final AppBarLayout f48025c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f48026d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f48027e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f48028f;

    /* renamed from: g  reason: collision with root package name */
    public final Barrier f48029g;

    /* renamed from: h  reason: collision with root package name */
    public final Barrier f48030h;

    /* renamed from: i  reason: collision with root package name */
    public final ConstraintLayout f48031i;
    public final CollapsingToolbarLayout j;
    public final CustomAmountTextInputEditText k;
    public final CustomAmountTextInputEditText l;
    public final TextView m;
    public final TextView n;
    public final ImageView o;
    public final ImageView p;
    public final RelativeLayout q;
    public final TextView r;
    public final RelativeLayout s;
    public final RecyclerView t;
    public final NestedScrollView u;
    public final TextView v;
    public final Toolbar w;
    public final TextView x;
    public final View y;
    public final View z;

    public abstract void a(net.one97.paytm.autoaddmoney.c.c cVar);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected c(e eVar, View view, TextView textView, TextView textView2, AppBarLayout appBarLayout, TextView textView3, TextView textView4, TextView textView5, Barrier barrier, Barrier barrier2, ConstraintLayout constraintLayout, CollapsingToolbarLayout collapsingToolbarLayout, CustomAmountTextInputEditText customAmountTextInputEditText, CustomAmountTextInputEditText customAmountTextInputEditText2, TextView textView6, TextView textView7, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout, TextView textView8, RelativeLayout relativeLayout2, RecyclerView recyclerView, NestedScrollView nestedScrollView, TextView textView9, Toolbar toolbar, TextView textView10, View view2, View view3, LottieAnimationView lottieAnimationView) {
        super(eVar, view, 0);
        e eVar2 = eVar;
        View view4 = view;
        this.f48023a = textView;
        this.f48024b = textView2;
        this.f48025c = appBarLayout;
        this.f48026d = textView3;
        this.f48027e = textView4;
        this.f48028f = textView5;
        this.f48029g = barrier;
        this.f48030h = barrier2;
        this.f48031i = constraintLayout;
        this.j = collapsingToolbarLayout;
        this.k = customAmountTextInputEditText;
        this.l = customAmountTextInputEditText2;
        this.m = textView6;
        this.n = textView7;
        this.o = imageView;
        this.p = imageView2;
        this.q = relativeLayout;
        this.r = textView8;
        this.s = relativeLayout2;
        this.t = recyclerView;
        this.u = nestedScrollView;
        this.v = textView9;
        this.w = toolbar;
        this.x = textView10;
        this.y = view2;
        this.z = view3;
        this.A = lottieAnimationView;
    }

    public final net.one97.paytm.autoaddmoney.c.c a() {
        return this.B;
    }

    public static c a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (c) f.a(layoutInflater, R.layout.am_fragment_set_automatic, viewGroup, false, f.a());
    }
}
