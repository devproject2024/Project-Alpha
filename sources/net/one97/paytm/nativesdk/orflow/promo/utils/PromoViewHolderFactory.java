package net.one97.paytm.nativesdk.orflow.promo.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IPromoViewHolderMaker;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem;
import net.one97.paytm.nativesdk.orflow.promo.view.viewholders.BasePromoViewHolder;
import net.one97.paytm.nativesdk.orflow.promo.view.viewholders.CashbackViewHolder;
import net.one97.paytm.nativesdk.orflow.promo.view.viewholders.FreebieGratViewHolder;

public class PromoViewHolderFactory {
    private static final int VIEW_TYPE_CASHBACK = 101;
    private static final int VIEW_TYPE_FREEBIE_GRAT = 102;

    public static BasePromoViewHolder getViewHolder(Context context, ViewGroup viewGroup, int i2, IPromoViewHolderMaker iPromoViewHolderMaker) {
        FreebieGratViewHolder freebieGratViewHolder;
        View inflateLayout = inflateLayout(context, viewGroup, getLayout(i2));
        if (i2 == 101) {
            return new CashbackViewHolder(inflateLayout, iPromoViewHolderMaker);
        }
        if (i2 != 102) {
            freebieGratViewHolder = null;
        } else {
            freebieGratViewHolder = new FreebieGratViewHolder(inflateLayout, iPromoViewHolderMaker);
        }
        new CashbackViewHolder(inflateLayout(context, viewGroup, getLayout(i2)), iPromoViewHolderMaker);
        return freebieGratViewHolder;
    }

    private static int getLayout(int i2) {
        if (i2 != 101) {
            return R.layout.cashback_promo_layout;
        }
        return R.layout.cashback_promo_layout;
    }

    private static View inflateLayout(Context context, ViewGroup viewGroup, int i2) {
        return LayoutInflater.from(context).inflate(i2, viewGroup, false);
    }

    public static int getViewType(PromoListItem promoListItem) {
        return (PromoUtils.isFreebie(promoListItem) || PromoUtils.isGratification(promoListItem.getGratifications())) ? 102 : 101;
    }
}
