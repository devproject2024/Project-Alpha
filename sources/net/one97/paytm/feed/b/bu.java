package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.feed.repository.models.recommendedapps.FeedRecommendedApps;
import net.one97.paytm.feed.ui.feed.a;

public abstract class bu extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f33999a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f34000b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f34001c;

    /* renamed from: d  reason: collision with root package name */
    protected FeedRecommendedApps f34002d;

    /* renamed from: e  reason: collision with root package name */
    protected a f34003e;

    protected bu(Object obj, View view, TextView textView, RecyclerView recyclerView, TextView textView2) {
        super(obj, view, 0);
        this.f33999a = textView;
        this.f34000b = recyclerView;
        this.f34001c = textView2;
    }
}
