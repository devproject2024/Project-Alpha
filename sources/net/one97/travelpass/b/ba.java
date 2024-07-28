package net.one97.travelpass.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ba extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f30150a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f30151b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f30152c;

    protected ba(Object obj, View view, TextView textView, RecyclerView recyclerView, TextView textView2) {
        super(obj, view, 0);
        this.f30150a = textView;
        this.f30151b = recyclerView;
        this.f30152c = textView2;
    }
}
