package net.one97.paytm.addmoney.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.autoaddmoney.c.b;

public abstract class e extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final AppBarLayout f48034a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f48035b;

    /* renamed from: c  reason: collision with root package name */
    public final Barrier f48036c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f48037d;

    /* renamed from: e  reason: collision with root package name */
    public final View f48038e;

    /* renamed from: f  reason: collision with root package name */
    public final CollapsingToolbarLayout f48039f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f48040g;

    /* renamed from: h  reason: collision with root package name */
    public final View f48041h;

    /* renamed from: i  reason: collision with root package name */
    public final View f48042i;
    public final ImageView j;
    public final ImageView k;
    public final ImageView l;
    public final ConstraintLayout m;
    public final View n;
    public final View o;
    public final NestedScrollView p;
    public final TextView q;
    public final Toolbar r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    protected b y;

    public abstract void a(b bVar);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected e(androidx.databinding.e eVar, View view, AppBarLayout appBarLayout, TextView textView, Barrier barrier, TextView textView2, View view2, CollapsingToolbarLayout collapsingToolbarLayout, TextView textView3, View view3, View view4, ImageView imageView, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout, View view5, View view6, NestedScrollView nestedScrollView, TextView textView4, Toolbar toolbar, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10) {
        super(eVar, view, 0);
        androidx.databinding.e eVar2 = eVar;
        View view7 = view;
        this.f48034a = appBarLayout;
        this.f48035b = textView;
        this.f48036c = barrier;
        this.f48037d = textView2;
        this.f48038e = view2;
        this.f48039f = collapsingToolbarLayout;
        this.f48040g = textView3;
        this.f48041h = view3;
        this.f48042i = view4;
        this.j = imageView;
        this.k = imageView2;
        this.l = imageView3;
        this.m = constraintLayout;
        this.n = view5;
        this.o = view6;
        this.p = nestedScrollView;
        this.q = textView4;
        this.r = toolbar;
        this.s = textView5;
        this.t = textView6;
        this.u = textView7;
        this.v = textView8;
        this.w = textView9;
        this.x = textView10;
    }

    public static e a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (e) f.a(layoutInflater, R.layout.am_fragmentautoadd_edit, viewGroup, false, f.a());
    }
}
