package com.travel.flight.b;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.pojo.Card;

public abstract class by extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f23763a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23764b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f23765c;

    /* renamed from: d  reason: collision with root package name */
    protected Card f23766d;

    public abstract void a(Card card);

    protected by(Object obj, View view, RecyclerView recyclerView, ImageView imageView, ImageView imageView2) {
        super(obj, view, 0);
        this.f23763a = recyclerView;
        this.f23764b = imageView;
        this.f23765c = imageView2;
    }

    public static by a(View view) {
        return (by) bind(f.a(), view, R.layout.list_item_refund_source);
    }
}
