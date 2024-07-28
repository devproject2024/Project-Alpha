package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;

public abstract class ac extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f33813a;

    /* renamed from: b  reason: collision with root package name */
    public final ConstraintLayout f33814b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f33815c;

    /* renamed from: d  reason: collision with root package name */
    protected Boolean f33816d;

    public abstract void a(Boolean bool);

    protected ac(Object obj, View view, ImageView imageView, ConstraintLayout constraintLayout, TextView textView) {
        super(obj, view, 0);
        this.f33813a = imageView;
        this.f33814b = constraintLayout;
        this.f33815c = textView;
    }
}
