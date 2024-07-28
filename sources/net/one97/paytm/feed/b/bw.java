package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class bw extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f34008a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f34009b;

    /* renamed from: c  reason: collision with root package name */
    protected String f34010c;

    protected bw(Object obj, View view, TextView textView, RecyclerView recyclerView) {
        super(obj, view, 0);
        this.f34008a = textView;
        this.f34009b = recyclerView;
    }
}
