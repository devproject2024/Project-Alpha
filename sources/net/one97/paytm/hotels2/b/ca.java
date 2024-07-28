package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ca extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f29333a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f29334b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29335c;

    protected ca(Object obj, View view, ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView) {
        super(obj, view, 0);
        this.f29333a = constraintLayout;
        this.f29334b = recyclerView;
        this.f29335c = textView;
    }
}
