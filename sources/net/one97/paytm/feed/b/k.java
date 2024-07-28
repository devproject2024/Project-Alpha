package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.feed.ui.feed.actions.comment.c;
import net.one97.paytm.feed.ui.feed.actions.comment.g;

public abstract class k extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f34181a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f34182b;

    /* renamed from: c  reason: collision with root package name */
    public final EditText f34183c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f34184d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f34185e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f34186f;

    /* renamed from: g  reason: collision with root package name */
    public final ProgressBar f34187g;

    /* renamed from: h  reason: collision with root package name */
    protected g f34188h;

    /* renamed from: i  reason: collision with root package name */
    protected c f34189i;

    protected k(Object obj, View view, RecyclerView recyclerView, TextView textView, EditText editText, RelativeLayout relativeLayout, ImageView imageView, TextView textView2, ProgressBar progressBar) {
        super(obj, view, 1);
        this.f34181a = recyclerView;
        this.f34182b = textView;
        this.f34183c = editText;
        this.f34184d = relativeLayout;
        this.f34185e = imageView;
        this.f34186f = textView2;
        this.f34187g = progressBar;
    }
}
