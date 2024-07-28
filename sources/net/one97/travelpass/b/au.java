package net.one97.travelpass.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class au extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f30124a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f30125b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f30126c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f30127d;

    protected au(Object obj, View view, RelativeLayout relativeLayout, RecyclerView recyclerView, ImageView imageView, TextView textView) {
        super(obj, view, 0);
        this.f30124a = relativeLayout;
        this.f30125b = recyclerView;
        this.f30126c = imageView;
        this.f30127d = textView;
    }
}
