package net.one97.paytm.upi.e;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public final class z {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f66933a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f66934b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f66935c;

    /* renamed from: d  reason: collision with root package name */
    private final ConstraintLayout f66936d;

    z(ConstraintLayout constraintLayout, TextView textView, TextView textView2, RecyclerView recyclerView) {
        this.f66936d = constraintLayout;
        this.f66933a = textView;
        this.f66934b = textView2;
        this.f66935c = recyclerView;
    }

    public final ConstraintLayout a() {
        return this.f66936d;
    }
}
