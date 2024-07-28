package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.CancelOrderViewModel;

public abstract class e extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29555a;

    /* renamed from: b  reason: collision with root package name */
    public final CardView f29556b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29557c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29558d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29559e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29560f;

    /* renamed from: g  reason: collision with root package name */
    public final EditText f29561g;

    /* renamed from: h  reason: collision with root package name */
    protected CancelOrderViewModel f29562h;

    public abstract void a(CancelOrderViewModel cancelOrderViewModel);

    protected e(Object obj, View view, ImageView imageView, CardView cardView, TextView textView, TextView textView2, TextView textView3, TextView textView4, EditText editText) {
        super(obj, view, 1);
        this.f29555a = imageView;
        this.f29556b = cardView;
        this.f29557c = textView;
        this.f29558d = textView2;
        this.f29559e = textView3;
        this.f29560f = textView4;
        this.f29561g = editText;
    }
}
