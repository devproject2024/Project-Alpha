package net.one97.paytm.feed.ui.feed.h.b;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.repository.models.merchantstorefront.Brand;

public final class e<B extends ViewDataBinding, D extends Brand> extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    B f35068a;

    /* renamed from: b  reason: collision with root package name */
    private View f35069b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(View view) {
        super(view);
        k.c(view, "view");
        this.f35069b = view;
        B a2 = f.a(this.f35069b);
        if (a2 != null) {
            this.f35068a = a2;
            return;
        }
        throw new u("null cannot be cast to non-null type B");
    }
}
