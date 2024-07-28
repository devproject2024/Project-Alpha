package com.travel.flight.b;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.pojo.PaymentDetail;
import java.util.List;

public abstract class bk extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f23706a;

    /* renamed from: b  reason: collision with root package name */
    protected List<PaymentDetail> f23707b;

    public abstract void a(List<PaymentDetail> list);

    protected bk(Object obj, View view, RecyclerView recyclerView) {
        super(obj, view, 0);
        this.f23706a = recyclerView;
    }
}
