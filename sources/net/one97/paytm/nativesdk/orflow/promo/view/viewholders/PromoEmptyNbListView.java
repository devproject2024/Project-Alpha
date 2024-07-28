package net.one97.paytm.nativesdk.orflow.promo.view.viewholders;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam;

public final class PromoEmptyNbListView extends BaseViewHolder<PromoPayOptionAdapterParam> {
    public static final Companion Companion = new Companion((g) null);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PromoEmptyNbListView(Context context, View view) {
        super(context, view);
        k.c(context, "context");
        k.c(view, "itemView");
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final PromoEmptyNbListView create(Context context, ViewGroup viewGroup) {
            k.c(context, "context");
            k.c(viewGroup, "parent");
            return new PromoEmptyNbListView(context, BaseViewHolder.Companion.getView(viewGroup, R.layout.promo_nb_retry_view));
        }
    }

    public final void bindView(PromoPayOptionAdapterParam promoPayOptionAdapterParam) {
        ((LinearLayout) getMView().findViewById(R.id.llRetryOptions)).setOnClickListener(getMOnClickListener());
    }
}
