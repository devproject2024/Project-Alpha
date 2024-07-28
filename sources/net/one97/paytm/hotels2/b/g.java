package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.service.model.ordersummary.CancelRefundData;

public abstract class g extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f29789a;

    /* renamed from: b  reason: collision with root package name */
    public final View f29790b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f29791c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29792d;

    /* renamed from: e  reason: collision with root package name */
    protected String f29793e;

    /* renamed from: f  reason: collision with root package name */
    protected CancelRefundData f29794f;

    /* renamed from: g  reason: collision with root package name */
    protected Boolean f29795g;

    public abstract void a(Boolean bool);

    public abstract void a(String str);

    public abstract void a(CancelRefundData cancelRefundData);

    protected g(Object obj, View view, TextView textView, View view2, ImageView imageView, TextView textView2) {
        super(obj, view, 0);
        this.f29789a = textView;
        this.f29790b = view2;
        this.f29791c = imageView;
        this.f29792d = textView2;
    }
}
