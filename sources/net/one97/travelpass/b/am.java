package net.one97.travelpass.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class am extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f30094a;

    /* renamed from: b  reason: collision with root package name */
    public final View f30095b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f30096c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f30097d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f30098e;

    protected am(Object obj, View view, ImageView imageView, View view2, RecyclerView recyclerView, RelativeLayout relativeLayout, TextView textView) {
        super(obj, view, 0);
        this.f30094a = imageView;
        this.f30095b = view2;
        this.f30096c = recyclerView;
        this.f30097d = relativeLayout;
        this.f30098e = textView;
    }
}
