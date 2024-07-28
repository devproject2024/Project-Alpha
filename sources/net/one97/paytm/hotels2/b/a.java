package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.hotel4.service.model.ordersummary.CancelRefundData;
import net.one97.paytm.hotel4.viewmodel.CancelOrderViewModel;
import net.one97.paytm.hotels2.R;

public abstract class a extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final c f29095a;

    /* renamed from: b  reason: collision with root package name */
    public final e f29096b;

    /* renamed from: c  reason: collision with root package name */
    public final g f29097c;

    /* renamed from: d  reason: collision with root package name */
    public final i f29098d;

    /* renamed from: e  reason: collision with root package name */
    public final FrameLayout f29099e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f29100f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f29101g;

    /* renamed from: h  reason: collision with root package name */
    public final CardView f29102h;

    /* renamed from: i  reason: collision with root package name */
    public final View f29103i;
    public final View j;
    public final LinearLayout k;
    public final LinearLayout l;
    public final LinearLayout m;
    public final LottieAnimationView n;
    public final TextView o;
    public final Toolbar p;
    public final TextView q;
    public final TextView r;
    protected CancelOrderViewModel s;
    protected CancelRefundData t;

    public abstract void a(CancelRefundData cancelRefundData);

    public abstract void a(CancelOrderViewModel cancelOrderViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected a(Object obj, View view, c cVar, e eVar, g gVar, i iVar, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, CardView cardView, View view2, View view3, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LottieAnimationView lottieAnimationView, TextView textView, Toolbar toolbar, TextView textView2, TextView textView3) {
        super(obj, view, 5);
        Object obj2 = obj;
        View view4 = view;
        this.f29095a = cVar;
        setContainedBinding(this.f29095a);
        this.f29096b = eVar;
        setContainedBinding(this.f29096b);
        this.f29097c = gVar;
        setContainedBinding(this.f29097c);
        this.f29098d = iVar;
        setContainedBinding(this.f29098d);
        this.f29099e = frameLayout;
        this.f29100f = imageView;
        this.f29101g = imageView2;
        this.f29102h = cardView;
        this.f29103i = view2;
        this.j = view3;
        this.k = linearLayout;
        this.l = linearLayout2;
        this.m = linearLayout3;
        this.n = lottieAnimationView;
        this.o = textView;
        this.p = toolbar;
        this.q = textView2;
        this.r = textView3;
    }

    public static a a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (a) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_cancel_order_lyout, viewGroup, false, f.a());
    }
}
