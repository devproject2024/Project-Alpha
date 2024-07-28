package com.travel.flight.b;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.travel.flight.R;
import com.travel.flight.pojo.Item;

public abstract class cc extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    protected Item f23789a;

    public abstract void a(Item item);

    protected cc(Object obj, View view) {
        super(obj, view, 0);
    }

    public static cc a(View view) {
        return (cc) bind(f.a(), view, R.layout.list_item_review_payment_item);
    }
}
