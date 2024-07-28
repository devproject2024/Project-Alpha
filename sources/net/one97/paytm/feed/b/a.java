package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class a extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f33798a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f33799b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f33800c;

    /* renamed from: d  reason: collision with root package name */
    public final ProgressBar f33801d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f33802e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f33803f;

    protected a(Object obj, View view, ImageView imageView, TextView textView, ImageView imageView2, ProgressBar progressBar, RecyclerView recyclerView, TextView textView2) {
        super(obj, view, 0);
        this.f33798a = imageView;
        this.f33799b = textView;
        this.f33800c = imageView2;
        this.f33801d = progressBar;
        this.f33802e = recyclerView;
        this.f33803f = textView2;
    }
}
