package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.arthurivanets.arvi.widget.PlayableItemsRecyclerView;
import net.one97.paytm.feed.ui.feed.e;

public abstract class u extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f34224a;

    /* renamed from: b  reason: collision with root package name */
    public final ProgressBar f34225b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f34226c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f34227d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f34228e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f34229f;

    /* renamed from: g  reason: collision with root package name */
    public final SwipeRefreshLayout f34230g;

    /* renamed from: h  reason: collision with root package name */
    public final PlayableItemsRecyclerView f34231h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f34232i;
    protected e j;
    protected Integer k;

    public abstract void a(Integer num);

    protected u(Object obj, View view, TextView textView, ProgressBar progressBar, TextView textView2, ImageView imageView, TextView textView3, TextView textView4, SwipeRefreshLayout swipeRefreshLayout, PlayableItemsRecyclerView playableItemsRecyclerView, TextView textView5) {
        super(obj, view, 0);
        this.f34224a = textView;
        this.f34225b = progressBar;
        this.f34226c = textView2;
        this.f34227d = imageView;
        this.f34228e = textView3;
        this.f34229f = textView4;
        this.f34230g = swipeRefreshLayout;
        this.f34231h = playableItemsRecyclerView;
        this.f34232i = textView5;
    }
}
