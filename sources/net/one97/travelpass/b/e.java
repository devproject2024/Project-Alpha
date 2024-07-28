package net.one97.travelpass.b;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class e extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f30228a;

    /* renamed from: b  reason: collision with root package name */
    public final y f30229b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f30230c;

    /* renamed from: d  reason: collision with root package name */
    public final ProgressBar f30231d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f30232e;

    /* renamed from: f  reason: collision with root package name */
    public final bc f30233f;

    protected e(Object obj, View view, RelativeLayout relativeLayout, y yVar, RelativeLayout relativeLayout2, ProgressBar progressBar, RecyclerView recyclerView, bc bcVar) {
        super(obj, view, 2);
        this.f30228a = relativeLayout;
        this.f30229b = yVar;
        setContainedBinding(this.f30229b);
        this.f30230c = relativeLayout2;
        this.f30231d = progressBar;
        this.f30232e = recyclerView;
        this.f30233f = bcVar;
        setContainedBinding(this.f30233f);
    }
}
