package com.travel.citybus.brts.d;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;

public final class a extends ai {

    /* renamed from: a  reason: collision with root package name */
    public final y<CJROrderSummary> f23370a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public final y<Integer> f23371b = new y<>();

    /* renamed from: com.travel.citybus.brts.d.a$a  reason: collision with other inner class name */
    public static final class C0452a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f23372a;

        public C0452a(a aVar) {
            this.f23372a = aVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f23372a.f23371b.postValue(Integer.valueOf(i2));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CJROrderSummary) {
                this.f23372a.f23370a.postValue(iJRPaytmDataModel);
            }
        }
    }
}
