package net.one97.paytm.phoenix.provider;

import net.one97.paytm.h5.b.c;
import net.one97.paytm.h5.model.H5AppDetailsForUserModel;
import net.one97.paytm.phoenix.b.b;

public final class PhoenixWhiteListAppDataProviderImpl$doesAppExist$1 implements c.a {
    final /* synthetic */ b $callback;

    PhoenixWhiteListAppDataProviderImpl$doesAppExist$1(b bVar) {
        this.$callback = bVar;
    }

    public final void onAppDataFetched(H5AppDetailsForUserModel h5AppDetailsForUserModel) {
        this.$callback.a(Boolean.TRUE);
    }

    public final void onError(String str) {
        this.$callback.a(Boolean.FALSE);
    }
}
