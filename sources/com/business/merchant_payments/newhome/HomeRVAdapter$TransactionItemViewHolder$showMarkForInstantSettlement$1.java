package com.business.merchant_payments.newhome;

import android.widget.ImageView;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.newhome.HomeRVAdapter;
import kotlin.g.b.k;

public final class HomeRVAdapter$TransactionItemViewHolder$showMarkForInstantSettlement$1 implements Runnable {
    public final /* synthetic */ HomeRVAdapter.TransactionItemViewHolder this$0;

    public HomeRVAdapter$TransactionItemViewHolder$showMarkForInstantSettlement$1(HomeRVAdapter.TransactionItemViewHolder transactionItemViewHolder) {
        this.this$0 = transactionItemViewHolder;
    }

    public final void run() {
        ImageView imageView = this.this$0.getMBinding().ivInstantSettled;
        k.b(imageView, "mBinding.ivInstantSettled");
        if (imageView.isAttachedToWindow()) {
            HomeRVListener access$getMListener$p = this.this$0.this$0.mListener;
            ImageView imageView2 = this.this$0.getMBinding().ivInstantSettled;
            k.b(imageView2, "mBinding.ivInstantSettled");
            access$getMListener$p.showInstantSettlementCoachmark(imageView2);
            APSharedPreferences instance = APSharedPreferences.getInstance();
            instance.setISTrackedMerchantId(instance.getMerchantMid());
            instance.setInstantSettlementStatus(true);
        }
    }
}
