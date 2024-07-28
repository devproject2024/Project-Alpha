package net.one97.paytm.phoenix.provider;

import android.content.Context;
import net.one97.paytm.phoenix.b.b;

public interface PaytmPhoenixWhitelistAppDataProvider {
    void doesAppExist(String str, Context context, b bVar);

    boolean isAppWhitelisted(String str);

    boolean isDomainWhitelisted(String str);
}
