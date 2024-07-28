package net.one97.travelpass.b;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class c extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final y f30219a;

    /* renamed from: b  reason: collision with root package name */
    public final bc f30220b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f30221c;

    /* renamed from: d  reason: collision with root package name */
    public final ProgressBar f30222d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f30223e;

    protected c(Object obj, View view, y yVar, bc bcVar, RelativeLayout relativeLayout, ProgressBar progressBar, RecyclerView recyclerView) {
        super(obj, view, 2);
        this.f30219a = yVar;
        setContainedBinding(this.f30219a);
        this.f30220b = bcVar;
        setContainedBinding(this.f30220b);
        this.f30221c = relativeLayout;
        this.f30222d = progressBar;
        this.f30223e = recyclerView;
    }
}
