package net.one97.travelpass.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class m extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f30258a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f30259b;

    protected m(Object obj, View view, RecyclerView recyclerView, TextView textView) {
        super(obj, view, 0);
        this.f30258a = recyclerView;
        this.f30259b = textView;
    }
}
