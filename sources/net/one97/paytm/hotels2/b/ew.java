package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.hotel4.viewmodel.EditSearchViewModel;
import net.one97.paytm.hotels2.R;

public abstract class ew extends ViewDataBinding {
    public final ac A;
    public final TextView B;
    public final TextView C;
    protected EditSearchViewModel D;

    /* renamed from: a  reason: collision with root package name */
    public final ac f29661a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29662b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29663c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29664d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29665e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29666f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f29667g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f29668h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f29669i;
    public final TextView j;
    public final TextView k;
    public final ac l;
    public final TextView m;
    public final ConstraintLayout n;
    public final ConstraintLayout o;
    public final ConstraintLayout p;
    public final ConstraintLayout q;
    public final View r;
    public final View s;
    public final View t;
    public final View u;
    public final TextView v;
    public final TextView w;
    public final ImageView x;
    public final LottieAnimationView y;
    public final TextView z;

    public abstract void a(EditSearchViewModel editSearchViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ew(Object obj, View view, ac acVar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, ac acVar2, TextView textView11, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, View view2, View view3, View view4, View view5, TextView textView12, TextView textView13, ImageView imageView, LottieAnimationView lottieAnimationView, TextView textView14, ac acVar3, TextView textView15, TextView textView16) {
        super(obj, view, 15);
        Object obj2 = obj;
        View view6 = view;
        this.f29661a = acVar;
        setContainedBinding(this.f29661a);
        this.f29662b = textView;
        this.f29663c = textView2;
        this.f29664d = textView3;
        this.f29665e = textView4;
        this.f29666f = textView5;
        this.f29667g = textView6;
        this.f29668h = textView7;
        this.f29669i = textView8;
        this.j = textView9;
        this.k = textView10;
        this.l = acVar2;
        setContainedBinding(this.l);
        this.m = textView11;
        this.n = constraintLayout;
        this.o = constraintLayout2;
        this.p = constraintLayout3;
        this.q = constraintLayout4;
        this.r = view2;
        this.s = view3;
        this.t = view4;
        this.u = view5;
        this.v = textView12;
        this.w = textView13;
        this.x = imageView;
        this.y = lottieAnimationView;
        this.z = textView14;
        this.A = acVar3;
        setContainedBinding(this.A);
        this.B = textView15;
        this.C = textView16;
    }

    public static ew a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (ew) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_srp_inputedit_bottom_sheet, viewGroup, false, f.a());
    }
}
