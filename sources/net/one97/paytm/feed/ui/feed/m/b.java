package net.one97.paytm.feed.ui.feed.m;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;

public final class b<B extends ViewDataBinding, D extends FeedGeneric> extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    B f35143a;

    /* renamed from: b  reason: collision with root package name */
    e f35144b;

    /* renamed from: c  reason: collision with root package name */
    private View f35145c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view) {
        super(view);
        k.c(view, "view");
        this.f35145c = view;
        B a2 = f.a(this.f35145c);
        if (a2 != null) {
            this.f35143a = a2;
            return;
        }
        throw new u("null cannot be cast to non-null type B");
    }
}
