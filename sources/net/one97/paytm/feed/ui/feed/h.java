package net.one97.paytm.feed.ui.feed;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.a;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.repository.models.progress.FeedProgress;
import net.one97.paytm.feed.ui.base.b;

public final class h extends b<ViewDataBinding, FeedProgress, a> {

    /* renamed from: b  reason: collision with root package name */
    private final View f35062b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(View view) {
        super(view);
        k.c(view, "view");
        this.f35062b = view;
    }

    public final void a(FeedProgress feedProgress) {
        k.c(feedProgress, "data");
        View view = this.f35062b;
        view.setBackgroundColor(androidx.core.content.b.c(view.getContext(), R.color.feed_divider));
    }
}
