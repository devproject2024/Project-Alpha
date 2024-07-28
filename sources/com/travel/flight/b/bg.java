package com.travel.flight.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.travel.flight.pojo.ModifiedParentOrder;

public abstract class bg extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f23690a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f23691b;

    /* renamed from: c  reason: collision with root package name */
    protected ModifiedParentOrder f23692c;

    public abstract void a(ModifiedParentOrder modifiedParentOrder);

    protected bg(Object obj, View view, ImageView imageView, TextView textView) {
        super(obj, view, 0);
        this.f23690a = imageView;
        this.f23691b = textView;
    }
}
