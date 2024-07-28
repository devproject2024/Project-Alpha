package net.one97.paytm.feed.ui.base;

import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.ai;
import com.arthurivanets.arvi.widget.b;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.repository.models.FeedItem;

public abstract class c<B extends ViewDataBinding, D extends FeedItem, VM extends ai> extends b {

    /* renamed from: c  reason: collision with root package name */
    protected B f34874c;

    /* renamed from: d  reason: collision with root package name */
    private final ViewGroup f34875d;

    /* renamed from: e  reason: collision with root package name */
    private final View f34876e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(ViewGroup viewGroup, View view) {
        super(viewGroup, view);
        k.c(viewGroup, "viewGroup");
        k.c(view, "view");
        this.f34875d = viewGroup;
        this.f34876e = view;
        B a2 = f.a(this.f34876e);
        if (a2 != null) {
            this.f34874c = a2;
            return;
        }
        throw new u("null cannot be cast to non-null type B");
    }
}
