package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;

/* renamed from: net.one97.paytm.hotels2.b.do  reason: invalid class name */
public abstract class Cdo extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f29501a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29502b;

    /* renamed from: c  reason: collision with root package name */
    public final CardView f29503c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f29504d;

    /* renamed from: e  reason: collision with root package name */
    public final View f29505e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29506f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f29507g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f29508h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f29509i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    protected RoomSelectionViewModel s;
    protected ReviewViewModel t;

    public abstract void a(ReviewViewModel reviewViewModel);

    public abstract void a(RoomSelectionViewModel roomSelectionViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected Cdo(Object obj, View view, TextView textView, ImageView imageView, CardView cardView, ImageView imageView2, View view2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14) {
        super(obj, view, 5);
        Object obj2 = obj;
        View view3 = view;
        this.f29501a = textView;
        this.f29502b = imageView;
        this.f29503c = cardView;
        this.f29504d = imageView2;
        this.f29505e = view2;
        this.f29506f = textView2;
        this.f29507g = textView3;
        this.f29508h = textView4;
        this.f29509i = textView5;
        this.j = textView6;
        this.k = textView7;
        this.l = textView8;
        this.m = textView9;
        this.n = textView10;
        this.o = textView11;
        this.p = textView12;
        this.q = textView13;
        this.r = textView14;
    }
}
