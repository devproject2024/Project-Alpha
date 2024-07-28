package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class co extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f34072a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f34073b;

    /* renamed from: c  reason: collision with root package name */
    protected String f34074c;

    protected co(Object obj, View view, TextView textView, RecyclerView recyclerView) {
        super(obj, view, 0);
        this.f34072a = textView;
        this.f34073b = recyclerView;
    }
}
