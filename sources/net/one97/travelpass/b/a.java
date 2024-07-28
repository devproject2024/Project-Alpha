package net.one97.travelpass.b;

import android.view.View;
import android.widget.ProgressBar;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class a extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final y f30058a;

    /* renamed from: b  reason: collision with root package name */
    public final bc f30059b;

    /* renamed from: c  reason: collision with root package name */
    public final ProgressBar f30060c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f30061d;

    protected a(Object obj, View view, y yVar, bc bcVar, ProgressBar progressBar, RecyclerView recyclerView) {
        super(obj, view, 2);
        this.f30058a = yVar;
        setContainedBinding(this.f30058a);
        this.f30059b = bcVar;
        setContainedBinding(this.f30059b);
        this.f30060c = progressBar;
        this.f30061d = recyclerView;
    }
}
