package net.one97.paytm.feed.ui.feed.livetv.channel;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.repository.models.livetv.Channel;

public final class c<B extends ViewDataBinding, D extends Channel> extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public B f35137a;

    /* renamed from: b  reason: collision with root package name */
    public a f35138b;

    /* renamed from: c  reason: collision with root package name */
    private View f35139c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(View view) {
        super(view);
        k.c(view, "view");
        this.f35139c = view;
        B a2 = f.a(this.f35139c);
        if (a2 != null) {
            this.f35137a = a2;
            return;
        }
        throw new u("null cannot be cast to non-null type B");
    }
}
