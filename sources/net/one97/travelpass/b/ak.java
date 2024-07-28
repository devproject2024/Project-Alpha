package net.one97.travelpass.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ak extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f30088a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f30089b;

    protected ak(Object obj, View view, TextView textView, RecyclerView recyclerView) {
        super(obj, view, 0);
        this.f30088a = textView;
        this.f30089b = recyclerView;
    }
}
