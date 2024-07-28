package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.feed.ui.feed.livetv.category.c;

public abstract class cu extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f34097a;

    /* renamed from: b  reason: collision with root package name */
    public final ProgressBar f34098b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f34099c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f34100d;

    /* renamed from: e  reason: collision with root package name */
    protected c f34101e;

    protected cu(Object obj, View view, RecyclerView recyclerView, ProgressBar progressBar, TextView textView, Toolbar toolbar) {
        super(obj, view, 1);
        this.f34097a = recyclerView;
        this.f34098b = progressBar;
        this.f34099c = textView;
        this.f34100d = toolbar;
    }
}
