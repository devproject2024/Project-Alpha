package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;

public abstract class ad extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f53618a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f53619b;

    /* renamed from: c  reason: collision with root package name */
    public final View f53620c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f53621d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f53622e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f53623f;

    /* renamed from: g  reason: collision with root package name */
    public final View f53624g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f53625h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f53626i;
    public final ImageView j;
    public final TextView k;
    public final ConstraintLayout l;
    public final Group m;
    public final TextView n;
    protected UpiPendingRequestModel o;
    protected Integer p;
    protected Boolean q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ad(Object obj, View view, TextView textView, ImageView imageView, View view2, TextView textView2, TextView textView3, TextView textView4, View view3, ImageView imageView2, TextView textView5, ImageView imageView3, TextView textView6, ConstraintLayout constraintLayout, Group group, TextView textView7) {
        super(obj, view, 0);
        Object obj2 = obj;
        View view4 = view;
        this.f53618a = textView;
        this.f53619b = imageView;
        this.f53620c = view2;
        this.f53621d = textView2;
        this.f53622e = textView3;
        this.f53623f = textView4;
        this.f53624g = view3;
        this.f53625h = imageView2;
        this.f53626i = textView5;
        this.j = imageView3;
        this.k = textView6;
        this.l = constraintLayout;
        this.m = group;
        this.n = textView7;
    }
}
