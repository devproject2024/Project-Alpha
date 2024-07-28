package net.one97.paytm.g;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class a extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f50477a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f50478b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f50479c;

    protected a(Object obj, View view, RelativeLayout relativeLayout, RecyclerView recyclerView, TextView textView) {
        super(obj, view, 0);
        this.f50477a = relativeLayout;
        this.f50478b = recyclerView;
        this.f50479c = textView;
    }
}
