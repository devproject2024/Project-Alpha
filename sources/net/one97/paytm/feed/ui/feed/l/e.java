package net.one97.paytm.feed.ui.feed.l;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps;

public final class e<B extends ViewDataBinding, D extends RecommendedApps> extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    B f35101a;

    /* renamed from: b  reason: collision with root package name */
    View f35102b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(View view) {
        super(view);
        k.c(view, "view");
        this.f35102b = view;
        B a2 = f.a(this.f35102b);
        if (a2 != null) {
            this.f35101a = a2;
            return;
        }
        throw new u("null cannot be cast to non-null type B");
    }
}
