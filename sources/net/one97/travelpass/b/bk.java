package net.one97.travelpass.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class bk extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f30185a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f30186b;

    protected bk(Object obj, View view, TextView textView, RecyclerView recyclerView) {
        super(obj, view, 0);
        this.f30185a = textView;
        this.f30186b = recyclerView;
    }
}
