package net.one97.paytm.feed.ui.feed.g;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.repository.models.language.FeedLanguageData;

public final class d<B extends ViewDataBinding, D extends FeedLanguageData> extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    B f35060a;

    /* renamed from: b  reason: collision with root package name */
    private View f35061b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(View view) {
        super(view);
        k.c(view, "view");
        this.f35061b = view;
        B a2 = f.a(this.f35061b);
        if (a2 != null) {
            this.f35060a = a2;
            return;
        }
        throw new u("null cannot be cast to non-null type B");
    }
}
