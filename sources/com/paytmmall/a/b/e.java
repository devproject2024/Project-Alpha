package com.paytmmall.a.b;

import android.content.Context;
import net.one97.paytm.phoenix.b.b;
import net.one97.paytm.phoenix.provider.PaytmPhoenixWhitelistAppDataProvider;

public final class e implements PaytmPhoenixWhitelistAppDataProvider {
    public final void doesAppExist(String str, Context context, b bVar) {
    }

    public final boolean isAppWhitelisted(String str) {
        return true;
    }

    public final boolean isDomainWhitelisted(String str) {
        return false;
    }
}
