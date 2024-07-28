package net.one97.travelpass.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import net.one97.travelpass.model.BookingDetailsResponse;
import net.one97.travelpass.ui.a.b;

public abstract class q extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f30272a;

    /* renamed from: b  reason: collision with root package name */
    public final Guideline f30273b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f30274c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f30275d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f30276e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f30277f;

    /* renamed from: g  reason: collision with root package name */
    public final ConstraintLayout f30278g;

    /* renamed from: h  reason: collision with root package name */
    public final View f30279h;

    /* renamed from: i  reason: collision with root package name */
    protected BookingDetailsResponse.BookingItems f30280i;
    protected Integer j;
    protected b.a k;

    public abstract void a(Integer num);

    public abstract void a(BookingDetailsResponse.BookingItems bookingItems);

    public abstract void a(b.a aVar);

    protected q(Object obj, View view, View view2, Guideline guideline, ImageView imageView, TextView textView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout, View view3) {
        super(obj, view, 0);
        this.f30272a = view2;
        this.f30273b = guideline;
        this.f30274c = imageView;
        this.f30275d = textView;
        this.f30276e = textView2;
        this.f30277f = textView3;
        this.f30278g = constraintLayout;
        this.f30279h = view3;
    }
}
