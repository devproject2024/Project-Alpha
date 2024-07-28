package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterViewModel;

public abstract class ag extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f29131a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29132b;

    /* renamed from: c  reason: collision with root package name */
    protected String f29133c;

    /* renamed from: d  reason: collision with root package name */
    protected String f29134d;

    /* renamed from: e  reason: collision with root package name */
    protected SRPFilterViewModel f29135e;

    public abstract void a(String str);

    public abstract void a(SRPFilterViewModel sRPFilterViewModel);

    public abstract void b(String str);

    protected ag(Object obj, View view, RecyclerView recyclerView, TextView textView) {
        super(obj, view, 0);
        this.f29131a = recyclerView;
        this.f29132b = textView;
    }
}
