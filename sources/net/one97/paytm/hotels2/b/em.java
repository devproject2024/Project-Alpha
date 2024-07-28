package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.SRPViewModel;

public abstract class em extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29617a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29618b;

    /* renamed from: c  reason: collision with root package name */
    public final View f29619c;

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintLayout f29620d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f29621e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f29622f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f29623g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f29624h;

    /* renamed from: i  reason: collision with root package name */
    public final LinearLayout f29625i;
    public final LinearLayout j;
    public final ConstraintLayout k;
    public final View l;
    public final ConstraintLayout m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    protected SRPViewModel s;

    public abstract void a(SRPViewModel sRPViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected em(Object obj, View view, ImageView imageView, ImageView imageView2, View view2, ConstraintLayout constraintLayout, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ConstraintLayout constraintLayout2, View view3, ConstraintLayout constraintLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, 3);
        Object obj2 = obj;
        View view4 = view;
        this.f29617a = imageView;
        this.f29618b = imageView2;
        this.f29619c = view2;
        this.f29620d = constraintLayout;
        this.f29621e = imageView3;
        this.f29622f = imageView4;
        this.f29623g = imageView5;
        this.f29624h = linearLayout;
        this.f29625i = linearLayout2;
        this.j = linearLayout3;
        this.k = constraintLayout2;
        this.l = view3;
        this.m = constraintLayout3;
        this.n = textView;
        this.o = textView2;
        this.p = textView3;
        this.q = textView4;
        this.r = textView5;
    }
}
