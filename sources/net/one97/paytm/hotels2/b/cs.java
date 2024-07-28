package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;

public abstract class cs extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f29403a;

    /* renamed from: b  reason: collision with root package name */
    public final ConstraintLayout f29404b;

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f29405c;

    /* renamed from: d  reason: collision with root package name */
    public final View f29406d;

    /* renamed from: e  reason: collision with root package name */
    public final View f29407e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29408f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f29409g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f29410h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f29411i;
    public final TextView j;
    public final TextView k;
    public final ConstraintLayout l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    protected DetailsViewModel t;
    protected ReviewViewModel u;
    protected RoomSelectionViewModel v;

    public abstract void a(DetailsViewModel detailsViewModel);

    public abstract void a(ReviewViewModel reviewViewModel);

    public abstract void a(RoomSelectionViewModel roomSelectionViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected cs(Object obj, View view, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, View view2, View view3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, ConstraintLayout constraintLayout4, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13) {
        super(obj, view, 9);
        Object obj2 = obj;
        View view4 = view;
        this.f29403a = constraintLayout;
        this.f29404b = constraintLayout2;
        this.f29405c = constraintLayout3;
        this.f29406d = view2;
        this.f29407e = view3;
        this.f29408f = textView;
        this.f29409g = textView2;
        this.f29410h = textView3;
        this.f29411i = textView4;
        this.j = textView5;
        this.k = textView6;
        this.l = constraintLayout4;
        this.m = textView7;
        this.n = textView8;
        this.o = textView9;
        this.p = textView10;
        this.q = textView11;
        this.r = textView12;
        this.s = textView13;
    }
}
