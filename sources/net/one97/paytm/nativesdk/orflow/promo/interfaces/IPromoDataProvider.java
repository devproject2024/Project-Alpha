package net.one97.paytm.nativesdk.orflow.promo.interfaces;

import android.os.CountDownTimer;
import android.view.View;
import java.util.HashMap;
import net.one97.paytm.nativesdk.orflow.promo.model.Gratification;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem;

public interface IPromoDataProvider {
    String getAppliedPromo();

    View.OnClickListener getClickListener();

    String getCurrentError();

    int getCurrentErrorIndex();

    void getFreebies(Gratification gratification, PromoListItem promoListItem);

    void getFreebies(PromoListItem promoListItem);

    int getPromoCount();

    HashMap<String, Object> getResponseHeader();

    void registerTimer(CountDownTimer countDownTimer);
}
