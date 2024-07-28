package net.one97.paytm.v2.features.cashbacklanding.b;

import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.vipcashback.f.h;

public final class a {

    /* renamed from: net.one97.paytm.v2.features.cashbacklanding.b.a$a  reason: collision with other inner class name */
    public static final class C0360a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f20145a;

        C0360a(y yVar) {
            this.f20145a = yVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f20145a.setValue(h.a(iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            this.f20145a.setValue(h.a(iJRPaytmDataModel));
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f20146a;

        b(y yVar) {
            this.f20146a = yVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f20146a.setValue(h.a(iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            this.f20146a.setValue(h.a(iJRPaytmDataModel));
        }
    }
}
