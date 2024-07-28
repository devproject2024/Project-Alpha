package net.one97.paytm.transport.iocl_v1.c;

import android.app.Application;
import android.content.Context;
import androidx.databinding.i;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.transport.iocl_v1.b.b;
import net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse;

public final class c extends b {

    /* renamed from: f  reason: collision with root package name */
    public i<Boolean> f14438f = new i<>(Boolean.FALSE);

    /* renamed from: g  reason: collision with root package name */
    public i<Boolean> f14439g = new i<>(Boolean.FALSE);

    /* renamed from: h  reason: collision with root package name */
    public y<net.one97.paytm.transport.iocl_v1.data.c> f14440h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    private i<Long> f14441i = new i<>();

    public c(Application application) {
        super(application);
        b();
    }

    public final i<Long> c() {
        if (!(a() == null || a().getRewards() == null)) {
            this.f14441i.set(a().getRewards().getPoints());
        }
        return this.f14441i;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        IOCLCommonResponse iOCLCommonResponse;
        if (iJRPaytmDataModel instanceof IOCLCommonResponse) {
            iOCLCommonResponse = (IOCLCommonResponse) iJRPaytmDataModel;
        } else {
            super.onApiSuccess(iJRPaytmDataModel);
            iOCLCommonResponse = a();
        }
        if (iOCLCommonResponse != null) {
            if ((iOCLCommonResponse.getUser().getStatus().equals("NEW_USER") || iOCLCommonResponse.getUser().getStatus().equals("NON_REGISTERED")) && !iOCLCommonResponse.getUser().isHasTransaction()) {
                this.f14440h.setValue(net.one97.paytm.transport.iocl_v1.data.c.CONGRATULATIONS);
                this.f14438f.set(Boolean.FALSE);
                this.f14439g.set(Boolean.FALSE);
                return;
            }
            this.f14440h.setValue(net.one97.paytm.transport.iocl_v1.data.c.DETAILS);
            this.f14438f.set(Boolean.TRUE);
            this.f14439g.set(Boolean.FALSE);
        }
    }

    public final void b() {
        this.f14433a.setValue(Boolean.TRUE);
        b.a((Context) getApplication(), (com.paytm.network.listener.b) this, "home_screen");
    }
}
