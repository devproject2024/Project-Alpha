package net.one97.paytm.feed.ui.feed.a;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.ui.feed.m.e;

public final class b<B extends ViewDataBinding, D extends FeedGeneric> extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    e f34922a;

    /* renamed from: b  reason: collision with root package name */
    B f34923b;

    /* renamed from: c  reason: collision with root package name */
    private View f34924c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view) {
        super(view);
        k.c(view, "view");
        this.f34924c = view;
        B a2 = f.a(this.f34924c);
        if (a2 != null) {
            this.f34923b = a2;
            return;
        }
        throw new u("null cannot be cast to non-null type B");
    }
}
