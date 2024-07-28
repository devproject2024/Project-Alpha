package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class by extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f34015a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f34016b;

    /* renamed from: c  reason: collision with root package name */
    protected String f34017c;

    protected by(Object obj, View view, TextView textView, RecyclerView recyclerView) {
        super(obj, view, 0);
        this.f34015a = textView;
        this.f34016b = recyclerView;
    }
}
