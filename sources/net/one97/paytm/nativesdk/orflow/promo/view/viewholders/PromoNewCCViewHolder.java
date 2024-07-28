package net.one97.paytm.nativesdk.orflow.promo.view.viewholders;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.R;

public final class PromoNewCCViewHolder extends PromoNewCardViewHolder {
    public static final Companion Companion = new Companion((g) null);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PromoNewCCViewHolder(Context context, View view) {
        super(context, view);
        k.c(context, "context");
        k.c(view, "view");
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final PromoNewCardViewHolder create(Context context, ViewGroup viewGroup) {
            k.c(context, "context");
            k.c(viewGroup, "parent");
            return new PromoNewCardViewHolder(context, BaseViewHolder.Companion.getView(viewGroup, R.layout.vh_promo_newcard));
        }
    }
}
