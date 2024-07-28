package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;

public abstract class m extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f29906a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29907b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29908c;

    /* renamed from: d  reason: collision with root package name */
    protected DetailsViewModel f29909d;

    public abstract void a(DetailsViewModel detailsViewModel);

    protected m(Object obj, View view, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, 2);
        this.f29906a = textView;
        this.f29907b = textView2;
        this.f29908c = textView3;
    }
}
