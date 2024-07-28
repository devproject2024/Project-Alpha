package net.one97.paytm.nativesdk.orflow.promo.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IPromoDataProvider;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IPromoViewHolderMaker;
import net.one97.paytm.nativesdk.orflow.promo.model.Gratification;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem;
import net.one97.paytm.nativesdk.orflow.promo.utils.PromoViewHolderFactory;
import net.one97.paytm.nativesdk.orflow.promo.view.viewholders.BasePromoViewHolder;

public class MallPromoAdapter extends RecyclerView.a<BasePromoViewHolder> implements IPromoViewHolderMaker {
    private Context mContext;
    private List<PromoListItem> mPromoList;
    private IPromoDataProvider promoDataProvider;

    public MallPromoAdapter(Activity activity, List<PromoListItem> list, IPromoDataProvider iPromoDataProvider) {
        this.mContext = activity;
        this.mPromoList = list;
        this.promoDataProvider = iPromoDataProvider;
    }

    public BasePromoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return PromoViewHolderFactory.getViewHolder(this.mContext, viewGroup, i2, this);
    }

    public void onBindViewHolder(BasePromoViewHolder basePromoViewHolder, int i2) {
        basePromoViewHolder.bindView(basePromoViewHolder.getAdapterPosition());
    }

    public int getItemCount() {
        List<PromoListItem> list = this.mPromoList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public List<PromoListItem> getPromoList() {
        return this.mPromoList;
    }

    public View.OnClickListener getClickListener() {
        return this.promoDataProvider.getClickListener();
    }

    public String getAppliedPromo() {
        return this.promoDataProvider.getAppliedPromo();
    }

    public HashMap<String, Object> getResponseHeader() {
        IPromoDataProvider iPromoDataProvider = this.promoDataProvider;
        return iPromoDataProvider != null ? iPromoDataProvider.getResponseHeader() : new HashMap<>();
    }

    public Context getContext() {
        return this.mContext;
    }

    public void getFreebieList(PromoListItem promoListItem) {
        this.promoDataProvider.getFreebies(promoListItem);
    }

    public void getFreebieList(Gratification gratification, PromoListItem promoListItem) {
        this.promoDataProvider.getFreebies(gratification, promoListItem);
    }

    public void registerTimer(CountDownTimer countDownTimer) {
        this.promoDataProvider.registerTimer(countDownTimer);
    }

    public int getCurrentErrorIndex() {
        return this.promoDataProvider.getCurrentErrorIndex();
    }

    public String getCurrentError() {
        return this.promoDataProvider.getCurrentError();
    }

    public int getPromoCount() {
        return this.promoDataProvider.getPromoCount();
    }

    public int getItemViewType(int i2) {
        return PromoViewHolderFactory.getViewType(this.mPromoList.get(i2));
    }
}
