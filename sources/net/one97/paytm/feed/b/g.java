package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.feed.ui.feed.livetv.channel.b;

public abstract class g extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f34163a;

    /* renamed from: b  reason: collision with root package name */
    public final ProgressBar f34164b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f34165c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f34166d;

    /* renamed from: e  reason: collision with root package name */
    protected b f34167e;

    protected g(Object obj, View view, RecyclerView recyclerView, ProgressBar progressBar, TextView textView, Toolbar toolbar) {
        super(obj, view, 1);
        this.f34163a = recyclerView;
        this.f34164b = progressBar;
        this.f34165c = textView;
        this.f34166d = toolbar;
    }
}
