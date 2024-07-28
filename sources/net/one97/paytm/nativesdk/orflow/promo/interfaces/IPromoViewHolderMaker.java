package net.one97.paytm.nativesdk.orflow.promo.interfaces;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.nativesdk.orflow.promo.model.Gratification;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem;

public interface IPromoViewHolderMaker {
    String getAppliedPromo();

    View.OnClickListener getClickListener();

    Context getContext();

    String getCurrentError();

    int getCurrentErrorIndex();

    void getFreebieList(Gratification gratification, PromoListItem promoListItem);

    void getFreebieList(PromoListItem promoListItem);

    int getPromoCount();

    List<PromoListItem> getPromoList();

    HashMap<String, Object> getResponseHeader();

    void registerTimer(CountDownTimer countDownTimer);
}
