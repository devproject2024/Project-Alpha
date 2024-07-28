package net.one97.paytm.feed.ui.feed.livetv.category;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.ak;
import net.one97.paytm.feed.ui.feed.livetv.category.a.a;
import net.one97.paytm.feed.utility.h;

public final class b extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    a f35119a;

    /* renamed from: b  reason: collision with root package name */
    final ak f35120b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f35121c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view) {
        super(view);
        k.c(view, "view");
        this.f35121c = (RecyclerView) view.findViewById(R.id.tv_channel_category_recyclerview);
        RecyclerView recyclerView = this.f35121c;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
            this.f35119a = new a();
            recyclerView.addItemDecoration(new h());
            recyclerView.setAdapter(this.f35119a);
        }
        ViewDataBinding a2 = f.a(view);
        if (a2 != null) {
            this.f35120b = (ak) a2;
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.feed.databinding.FeedLiveTvCategoryBinding");
    }
}
