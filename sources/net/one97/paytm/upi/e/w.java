package net.one97.paytm.upi.e;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f66919a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f66920b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f66921c;

    /* renamed from: d  reason: collision with root package name */
    private final ConstraintLayout f66922d;

    w(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView, ImageView imageView) {
        this.f66922d = constraintLayout;
        this.f66919a = recyclerView;
        this.f66920b = textView;
        this.f66921c = imageView;
    }

    public final ConstraintLayout a() {
        return this.f66922d;
    }
}
