package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.feed.repository.models.merchantstorefront.FeedMerchantStoreFront;
import net.one97.paytm.feed.ui.feed.h.b.c;

public abstract class as extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f33881a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f33882b;

    /* renamed from: c  reason: collision with root package name */
    protected FeedMerchantStoreFront f33883c;

    /* renamed from: d  reason: collision with root package name */
    protected c f33884d;

    protected as(Object obj, View view, TextView textView, RecyclerView recyclerView) {
        super(obj, view, 0);
        this.f33881a = textView;
        this.f33882b = recyclerView;
    }
}
