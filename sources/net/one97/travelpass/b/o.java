package net.one97.travelpass.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

public abstract class o extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f30264a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f30265b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f30266c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f30267d;

    protected o(Object obj, View view, LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, 0);
        this.f30264a = linearLayout;
        this.f30265b = imageView;
        this.f30266c = textView;
        this.f30267d = textView2;
    }
}
