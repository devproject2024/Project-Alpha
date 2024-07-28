package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.hotel4.viewmodel.SRPListItemViewModel;

public abstract class gg extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f29823a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29824b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f29825c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f29826d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f29827e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f29828f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f29829g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f29830h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f29831i;
    public final RecyclerView j;
    public final View k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    protected SRPListItemViewModel o;
    protected Integer p;
    protected Integer q;
    protected Integer r;
    protected Integer s;
    protected Integer t;
    protected String u;
    protected String v;
    protected String w;
    protected String x;
    protected String y;

    public abstract void a(Integer num);

    public abstract void a(String str);

    public abstract void a(SRPListItemViewModel sRPListItemViewModel);

    public abstract void b(Integer num);

    public abstract void b(String str);

    public abstract void c(Integer num);

    public abstract void c(String str);

    public abstract void d(Integer num);

    public abstract void d(String str);

    public abstract void e(Integer num);

    public abstract void e(String str);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected gg(Object obj, View view, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, TextView textView, TextView textView2, TextView textView3, RecyclerView recyclerView, View view2, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, 0);
        Object obj2 = obj;
        View view3 = view;
        this.f29823a = constraintLayout;
        this.f29824b = imageView;
        this.f29825c = imageView2;
        this.f29826d = imageView3;
        this.f29827e = imageView4;
        this.f29828f = imageView5;
        this.f29829g = textView;
        this.f29830h = textView2;
        this.f29831i = textView3;
        this.j = recyclerView;
        this.k = view2;
        this.l = textView4;
        this.m = textView5;
        this.n = textView6;
    }

    public final SRPListItemViewModel a() {
        return this.o;
    }
}
