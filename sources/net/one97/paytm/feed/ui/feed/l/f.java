package net.one97.paytm.feed.ui.feed.l;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps;

public final class f<B extends ViewDataBinding, D extends RecommendedApps> extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    B f35103a;

    /* renamed from: b  reason: collision with root package name */
    View f35104b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(View view) {
        super(view);
        k.c(view, "view");
        this.f35104b = view;
        B a2 = androidx.databinding.f.a(this.f35104b);
        if (a2 != null) {
            this.f35103a = a2;
            return;
        }
        throw new u("null cannot be cast to non-null type B");
    }
}
