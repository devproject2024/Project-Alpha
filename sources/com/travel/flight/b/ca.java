package com.travel.flight.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.pojo.PaymentDetail;

public abstract class ca extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f23780a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f23781b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f23782c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23783d;

    /* renamed from: e  reason: collision with root package name */
    protected PaymentDetail f23784e;

    public abstract void a(PaymentDetail paymentDetail);

    protected ca(Object obj, View view, ImageView imageView, RecyclerView recyclerView, ImageView imageView2, TextView textView) {
        super(obj, view, 0);
        this.f23780a = imageView;
        this.f23781b = recyclerView;
        this.f23782c = imageView2;
        this.f23783d = textView;
    }

    public static ca a(View view) {
        return (ca) bind(f.a(), view, R.layout.list_item_review_payment_detail);
    }
}
