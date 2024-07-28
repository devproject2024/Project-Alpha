package net.one97.paytm.feed.ui.feed.story;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.ce;
import net.one97.paytm.feed.repository.models.stories.StoryData;
import net.one97.paytm.feed.ui.base.b;

public final class c extends b<ce, StoryData, Object> {

    /* renamed from: b  reason: collision with root package name */
    public d f35191b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f35192c = ((RecyclerView) this.f35194e.findViewById(R.id.feed_stories_recyclerview));

    /* renamed from: d  reason: collision with root package name */
    private LinearLayoutManager f35193d;

    /* renamed from: e  reason: collision with root package name */
    private final View f35194e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(View view) {
        super(view);
        k.c(view, "view");
        this.f35194e = view;
        RecyclerView recyclerView = this.f35192c;
        if (recyclerView != null) {
            recyclerView.setItemAnimator((RecyclerView.f) null);
            this.f35193d = new LinearLayoutManager(recyclerView.getContext(), 0, false);
            recyclerView.setLayoutManager(this.f35193d);
            this.f35191b = new d();
            recyclerView.setAdapter(this.f35191b);
        }
    }
}
