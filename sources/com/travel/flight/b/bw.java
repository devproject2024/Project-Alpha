package com.travel.flight.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.travel.flight.R;
import com.travel.flight.pojo.Info;

public abstract class bw extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f23756a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f23757b;

    /* renamed from: c  reason: collision with root package name */
    protected Info f23758c;

    public abstract void a(Info info);

    protected bw(Object obj, View view, TextView textView, TextView textView2) {
        super(obj, view, 0);
        this.f23756a = textView;
        this.f23757b = textView2;
    }

    public static bw a(View view) {
        return (bw) bind(f.a(), view, R.layout.list_item_refund_info);
    }
}
