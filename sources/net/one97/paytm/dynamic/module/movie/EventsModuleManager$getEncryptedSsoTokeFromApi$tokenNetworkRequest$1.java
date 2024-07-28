package net.one97.paytm.dynamic.module.movie;

import android.text.TextUtils;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.m.p;
import net.one97.paytm.h5.c;
import net.one97.paytm.utils.t;

public final class EventsModuleManager$getEncryptedSsoTokeFromApi$tokenNetworkRequest$1 implements b {
    final /* synthetic */ c.C0910c $callback;

    EventsModuleManager$getEncryptedSsoTokeFromApi$tokenNetworkRequest$1(c.C0910c cVar) {
        this.$callback = cVar;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof EncryptedSSOToken) {
            EncryptedSSOToken encryptedSSOToken = (EncryptedSSOToken) iJRPaytmDataModel;
            if (!p.a("success", encryptedSSOToken.getStatus(), true) || !TextUtils.isEmpty(encryptedSSOToken.getError())) {
                c.C0910c cVar = this.$callback;
                if (cVar != null) {
                    cVar.onResult("");
                    return;
                }
                return;
            }
            String encSSSOToken = encryptedSSOToken.getEncSSSOToken();
            t.a(encSSSOToken);
            c.C0910c cVar2 = this.$callback;
            if (cVar2 != null) {
                cVar2.onResult(encSSSOToken);
            }
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        c.C0910c cVar = this.$callback;
        if (cVar != null) {
            cVar.onResult("");
        }
    }
}
