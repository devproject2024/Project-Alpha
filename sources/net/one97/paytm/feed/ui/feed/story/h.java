package net.one97.paytm.feed.ui.feed.story;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.repository.models.stories.Stories;

public final class h<B extends ViewDataBinding, D extends Stories> extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    B f35220a;

    /* renamed from: b  reason: collision with root package name */
    e f35221b;

    /* renamed from: c  reason: collision with root package name */
    private View f35222c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(View view) {
        super(view);
        k.c(view, "view");
        this.f35222c = view;
        B a2 = f.a(this.f35222c);
        if (a2 != null) {
            this.f35220a = a2;
            return;
        }
        throw new u("null cannot be cast to non-null type B");
    }
}
