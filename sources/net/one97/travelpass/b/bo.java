package net.one97.travelpass.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

public abstract class bo extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f30198a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f30199b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f30200c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f30201d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f30202e;

    protected bo(Object obj, View view, TextView textView, ImageView imageView, TextView textView2, TextView textView3, LinearLayout linearLayout) {
        super(obj, view, 0);
        this.f30198a = textView;
        this.f30199b = imageView;
        this.f30200c = textView2;
        this.f30201d = textView3;
        this.f30202e = linearLayout;
    }
}
