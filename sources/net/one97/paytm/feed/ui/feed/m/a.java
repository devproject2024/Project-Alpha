package net.one97.paytm.feed.ui.feed.m;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;

public final class a<B extends ViewDataBinding, D extends FeedGeneric> extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    B f35140a;

    /* renamed from: b  reason: collision with root package name */
    e f35141b;

    /* renamed from: c  reason: collision with root package name */
    private View f35142c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view) {
        super(view);
        k.c(view, "view");
        this.f35142c = view;
        B a2 = f.a(this.f35142c);
        if (a2 != null) {
            this.f35140a = a2;
            return;
        }
        throw new u("null cannot be cast to non-null type B");
    }
}
