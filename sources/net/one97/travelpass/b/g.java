package net.one97.travelpass.b;

import android.view.View;
import android.widget.ProgressBar;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class g extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f30237a;

    /* renamed from: b  reason: collision with root package name */
    public final y f30238b;

    /* renamed from: c  reason: collision with root package name */
    public final ProgressBar f30239c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f30240d;

    protected g(Object obj, View view, View view2, y yVar, ProgressBar progressBar, RecyclerView recyclerView) {
        super(obj, view, 1);
        this.f30237a = view2;
        this.f30238b = yVar;
        setContainedBinding(this.f30238b);
        this.f30239c = progressBar;
        this.f30240d = recyclerView;
    }
}
