package net.one97.paytm.transport.iocl.c;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.i;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.CJRSecureSharedPreferences;
import net.one97.paytm.common.entity.CJRPGTokenListTransport;
import net.one97.paytm.transport.iocl.a;
import net.one97.paytm.transport.iocl.data.IOCLCommonResponse;
import net.one97.paytm.transport.iocl.data.c;

public final class b extends a {

    /* renamed from: g  reason: collision with root package name */
    public i<Boolean> f14301g = new i<>(Boolean.FALSE);

    /* renamed from: h  reason: collision with root package name */
    public i<Boolean> f14302h = new i<>(Boolean.FALSE);

    /* renamed from: i  reason: collision with root package name */
    public y<c> f14303i = new y<>();
    private i<Long> j = new i<>();

    public b(Application application) {
        super(application);
        c();
    }

    public final i<Long> d() {
        if (!(a() == null || a().getRewards() == null)) {
            this.j.set(a().getRewards().getPoints());
        }
        return this.j;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        IOCLCommonResponse iOCLCommonResponse;
        if (iJRPaytmDataModel instanceof IOCLCommonResponse) {
            iOCLCommonResponse = (IOCLCommonResponse) iJRPaytmDataModel;
        } else if (iJRPaytmDataModel instanceof CJRPGTokenListTransport) {
            a.a().f14209b.getWalletSSOToken((CJRPGTokenListTransport) iJRPaytmDataModel);
            net.one97.paytm.transport.iocl.b.b.a((Context) getApplication(), (com.paytm.network.listener.b) this, "home_screen");
            iOCLCommonResponse = null;
        } else {
            super.onApiSuccess(iJRPaytmDataModel);
            iOCLCommonResponse = a();
        }
        if (iOCLCommonResponse != null) {
            if ((iOCLCommonResponse.getUser().getStatus().equals("NEW_USER") || iOCLCommonResponse.getUser().getStatus().equals("NON_REGISTERED")) && !iOCLCommonResponse.getUser().isHasTransaction()) {
                this.f14303i.setValue(c.CONGRATULATIONS);
                this.f14301g.set(Boolean.FALSE);
                this.f14302h.set(Boolean.FALSE);
                return;
            }
            this.f14303i.setValue(c.DETAILS);
            this.f14301g.set(Boolean.TRUE);
            this.f14302h.set(Boolean.FALSE);
        }
    }

    public final void c() {
        this.f14295a.setValue(Boolean.TRUE);
        if (a.a() == null || !TextUtils.isEmpty(a.b().getWalletSSOToken(getApplication().getApplicationContext()))) {
            net.one97.paytm.transport.iocl.b.b.a((Context) getApplication(), (com.paytm.network.listener.b) this, "home_screen");
            return;
        }
        net.one97.paytm.transport.iocl.b.b.b(getApplication().getApplicationContext(), this, CJRSecureSharedPreferences.getInstance(getApplication().getApplicationContext()).getString("sso_token=", (String) null));
    }
}
