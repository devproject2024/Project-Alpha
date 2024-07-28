package net.one97.paytm.nativesdk.orflow.promo.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam;
import net.one97.paytm.nativesdk.orflow.promo.view.viewholders.BaseViewHolder;
import net.one97.paytm.nativesdk.orflow.promo.view.viewholders.PromoNewCCViewHolder;
import net.one97.paytm.nativesdk.orflow.promo.view.viewholders.PromoNewCardViewHolder;
import net.one97.paytm.nativesdk.orflow.promo.view.viewholders.PromoNewVpaViewHolder;
import net.one97.paytm.nativesdk.orflow.promo.view.viewholders.PromoSavedInstrumentViewHolder;

public final class PromoPayOptionListAdapter extends RecyclerView.a<RecyclerView.v> {
    private final Context mContext;
    private final ArrayList<PromoPayOptionAdapterParam> mPayOptionItemList;
    private final View.OnClickListener onClickListener;
    private final int viewTypeCC = 1000;

    public PromoPayOptionListAdapter(Context context, ArrayList<PromoPayOptionAdapterParam> arrayList, View.OnClickListener onClickListener2) {
        k.c(context, "mContext");
        k.c(arrayList, "mPayOptionItemList");
        k.c(onClickListener2, "onClickListener");
        this.mContext = context;
        this.mPayOptionItemList = arrayList;
        this.onClickListener = onClickListener2;
    }

    public final int getViewTypeCC() {
        return this.viewTypeCC;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        RecyclerView.v vVar;
        k.c(viewGroup, "parent");
        if (i2 == 2) {
            vVar = PromoNewCardViewHolder.Companion.create(this.mContext, viewGroup);
        } else if (i2 == this.viewTypeCC) {
            vVar = PromoNewCCViewHolder.Companion.create(this.mContext, viewGroup);
        } else if (i2 == 1 || i2 != 4) {
            vVar = PromoSavedInstrumentViewHolder.Companion.create(this.mContext, viewGroup);
        } else {
            vVar = PromoNewVpaViewHolder.Companion.create(this.mContext, viewGroup);
        }
        if (vVar instanceof BaseViewHolder) {
            ((BaseViewHolder) vVar).setOnClickListener(this.onClickListener);
        }
        return vVar;
    }

    public final int getItemCount() {
        return this.mPayOptionItemList.size();
    }

    public final int getItemViewType(int i2) {
        PromoPayOptionAdapterParam promoPayOptionAdapterParam = this.mPayOptionItemList.get(i2);
        k.a((Object) promoPayOptionAdapterParam, "mPayOptionItemList.get(position)");
        if (promoPayOptionAdapterParam.getVIEWTYPE() == 2) {
            PromoPayOptionAdapterParam promoPayOptionAdapterParam2 = this.mPayOptionItemList.get(i2);
            k.a((Object) promoPayOptionAdapterParam2, "mPayOptionItemList.get(position)");
            if (SDKConstants.CREDIT.equals(promoPayOptionAdapterParam2.getMode())) {
                return this.viewTypeCC;
            }
        }
        PromoPayOptionAdapterParam promoPayOptionAdapterParam3 = this.mPayOptionItemList.get(i2);
        k.a((Object) promoPayOptionAdapterParam3, "mPayOptionItemList.get(position)");
        return promoPayOptionAdapterParam3.getVIEWTYPE();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        if (i2 != -1 && i2 < this.mPayOptionItemList.size()) {
            ((BaseViewHolder) vVar).bindView(this.mPayOptionItemList.get(i2));
        }
    }
}
