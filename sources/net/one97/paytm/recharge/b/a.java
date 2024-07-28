package net.one97.paytm.recharge.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8;

public abstract class a extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final AppBarLayout f60306a;

    /* renamed from: b  reason: collision with root package name */
    public final CollapsingToolbarLayout f60307b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f60308c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f60309d;

    /* renamed from: e  reason: collision with root package name */
    public final Toolbar f60310e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f60311f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f60312g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f60313h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f60314i;
    public final CJRCircleImageViewV8 j;

    protected a(Object obj, View view, AppBarLayout appBarLayout, CollapsingToolbarLayout collapsingToolbarLayout, TextView textView, TextView textView2, Toolbar toolbar, TextView textView3, TextView textView4, LinearLayout linearLayout, TextView textView5, CJRCircleImageViewV8 cJRCircleImageViewV8) {
        super(obj, view, 0);
        this.f60306a = appBarLayout;
        this.f60307b = collapsingToolbarLayout;
        this.f60308c = textView;
        this.f60309d = textView2;
        this.f60310e = toolbar;
        this.f60311f = textView3;
        this.f60312g = textView4;
        this.f60313h = linearLayout;
        this.f60314i = textView5;
        this.j = cJRCircleImageViewV8;
    }
}
