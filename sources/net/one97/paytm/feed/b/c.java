package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class c extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f34022a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f34023b;

    /* renamed from: c  reason: collision with root package name */
    protected String f34024c;

    protected c(Object obj, View view, TextView textView, RecyclerView recyclerView) {
        super(obj, view, 0);
        this.f34022a = textView;
        this.f34023b = recyclerView;
    }
}
