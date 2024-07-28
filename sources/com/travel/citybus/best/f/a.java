package com.travel.citybus.best.f;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.citybus.best.model.BestEPurseTokenResponse;

public final class a extends ai {

    /* renamed from: a  reason: collision with root package name */
    public y<BestEPurseTokenResponse> f23055a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<Integer> f23056b = new y<>();

    /* renamed from: com.travel.citybus.best.f.a$a  reason: collision with other inner class name */
    public static final class C0446a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f23057a;

        public C0446a(a aVar) {
            this.f23057a = aVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f23057a.f23056b.postValue(Integer.valueOf(i2));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof BestEPurseTokenResponse) {
                this.f23057a.f23055a.postValue(iJRPaytmDataModel);
            }
        }
    }
}
