package net.one97.paytm.feed.ui.feed.livetv.category.a;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.b.am;

public final class b extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    final am f35118a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view) {
        super(view);
        k.c(view, "view");
        ViewDataBinding a2 = f.a(view);
        if (a2 != null) {
            this.f35118a = (am) a2;
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.feed.databinding.FeedLiveTvCategoryItemBinding");
    }
}
