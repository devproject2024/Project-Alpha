package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;

public abstract class q extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f29924a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29925b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29926c;

    /* renamed from: d  reason: collision with root package name */
    protected DetailsViewModel f29927d;

    public abstract void a(DetailsViewModel detailsViewModel);

    protected q(Object obj, View view, RecyclerView recyclerView, TextView textView, TextView textView2) {
        super(obj, view, 1);
        this.f29924a = recyclerView;
        this.f29925b = textView;
        this.f29926c = textView2;
    }
}
