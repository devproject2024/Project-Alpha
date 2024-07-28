package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.CancelOrderViewModel;

public abstract class k extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f29897a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29898b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29899c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29900d;

    /* renamed from: e  reason: collision with root package name */
    public final ConstraintLayout f29901e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29902f;

    /* renamed from: g  reason: collision with root package name */
    protected CancelOrderViewModel f29903g;

    public abstract void a(CancelOrderViewModel cancelOrderViewModel);

    protected k(Object obj, View view, TextView textView, TextView textView2, TextView textView3, TextView textView4, ConstraintLayout constraintLayout, TextView textView5) {
        super(obj, view, 1);
        this.f29897a = textView;
        this.f29898b = textView2;
        this.f29899c = textView3;
        this.f29900d = textView4;
        this.f29901e = constraintLayout;
        this.f29902f = textView5;
    }
}
