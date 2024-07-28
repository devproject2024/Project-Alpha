package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class o extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f34200a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f34201b;

    protected o(Object obj, View view, RecyclerView recyclerView, LinearLayout linearLayout) {
        super(obj, view, 0);
        this.f34200a = recyclerView;
        this.f34201b = linearLayout;
    }
}
