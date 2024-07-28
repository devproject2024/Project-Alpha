package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.HotelBookingStatusViewModel;

public abstract class bw extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f29307a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29308b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29309c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29310d;

    /* renamed from: e  reason: collision with root package name */
    public final ConstraintLayout f29311e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29312f;

    /* renamed from: g  reason: collision with root package name */
    protected HotelBookingStatusViewModel f29313g;

    public abstract void a(HotelBookingStatusViewModel hotelBookingStatusViewModel);

    protected bw(Object obj, View view, TextView textView, TextView textView2, TextView textView3, TextView textView4, ConstraintLayout constraintLayout, TextView textView5) {
        super(obj, view, 1);
        this.f29307a = textView;
        this.f29308b = textView2;
        this.f29309c = textView3;
        this.f29310d = textView4;
        this.f29311e = constraintLayout;
        this.f29312f = textView5;
    }
}
