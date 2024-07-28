package com.paytm.business.merchantprofile.inactivemerchant;

import android.content.Context;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.business.merchantprofile.databinding.PrPaymentsInActiveMerchantBinding;
import kotlin.g.b.k;

public final class InActiveMerchantViewHolder extends RecyclerView.v {
    public final Context context;
    public final InactiveMerchantListener listener;
    public final PrPaymentsInActiveMerchantBinding mBinding;

    public final Context getContext() {
        return this.context;
    }

    public final InactiveMerchantListener getListener() {
        return this.listener;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InActiveMerchantViewHolder(Context context2, InactiveMerchantListener inactiveMerchantListener, PrPaymentsInActiveMerchantBinding prPaymentsInActiveMerchantBinding) {
        super(prPaymentsInActiveMerchantBinding.getRoot());
        k.d(context2, "context");
        k.d(inactiveMerchantListener, "listener");
        k.d(prPaymentsInActiveMerchantBinding, "mBinding");
        this.context = context2;
        this.listener = inactiveMerchantListener;
        this.mBinding = prPaymentsInActiveMerchantBinding;
        prPaymentsInActiveMerchantBinding.setData(inactiveMerchantListener.getInactivateMerchantData());
        this.mBinding.setListener(this.listener);
        Context context3 = this.context;
        if (((q) (!(context3 instanceof q) ? null : context3)) != null) {
            this.mBinding.setLifecycleOwner((q) this.context);
        }
    }

    public final PrPaymentsInActiveMerchantBinding getMBinding() {
        return this.mBinding;
    }
}
