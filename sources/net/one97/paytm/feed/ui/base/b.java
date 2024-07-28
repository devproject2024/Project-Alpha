package net.one97.paytm.feed.ui.base;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.ai;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.repository.models.FeedItem;

public abstract class b<B extends ViewDataBinding, D extends FeedItem, VM extends ai> extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public B f34872a;

    /* renamed from: b  reason: collision with root package name */
    private View f34873b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view) {
        super(view);
        k.c(view, "view");
        this.f34873b = view;
        B a2 = f.a(this.f34873b);
        if (a2 != null) {
            this.f34872a = a2;
            return;
        }
        throw new u("null cannot be cast to non-null type B");
    }
}
