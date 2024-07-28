package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;

public abstract class y extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f29960a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29961b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29962c;

    /* renamed from: d  reason: collision with root package name */
    protected DetailsViewModel f29963d;

    public abstract void a(DetailsViewModel detailsViewModel);

    protected y(Object obj, View view, RecyclerView recyclerView, TextView textView, TextView textView2) {
        super(obj, view, 1);
        this.f29960a = recyclerView;
        this.f29961b = textView;
        this.f29962c = textView2;
    }
}
