package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.makeramen.roundedimageview.RoundedImageView;

public abstract class bg extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final AppBarLayout f33939a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f33940b;

    /* renamed from: c  reason: collision with root package name */
    public final CollapsingToolbarLayout f33941c;

    /* renamed from: d  reason: collision with root package name */
    public final ProgressBar f33942d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f33943e;

    /* renamed from: f  reason: collision with root package name */
    public final RoundedImageView f33944f;

    /* renamed from: g  reason: collision with root package name */
    public final RelativeLayout f33945g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f33946h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f33947i;
    public final TextView j;
    public final TextView k;
    public final RecyclerView l;
    public final CoordinatorLayout m;
    public final Toolbar n;
    public final TextView o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected bg(Object obj, View view, AppBarLayout appBarLayout, ImageView imageView, CollapsingToolbarLayout collapsingToolbarLayout, ProgressBar progressBar, ImageView imageView2, RoundedImageView roundedImageView, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, RecyclerView recyclerView, CoordinatorLayout coordinatorLayout, Toolbar toolbar, TextView textView5) {
        super(obj, view, 0);
        Object obj2 = obj;
        View view2 = view;
        this.f33939a = appBarLayout;
        this.f33940b = imageView;
        this.f33941c = collapsingToolbarLayout;
        this.f33942d = progressBar;
        this.f33943e = imageView2;
        this.f33944f = roundedImageView;
        this.f33945g = relativeLayout;
        this.f33946h = textView;
        this.f33947i = textView2;
        this.j = textView3;
        this.k = textView4;
        this.l = recyclerView;
        this.m = coordinatorLayout;
        this.n = toolbar;
        this.o = textView5;
    }
}
