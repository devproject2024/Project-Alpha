package net.one97.paytm.payments.c.b;

import java.io.Serializable;
import net.one97.paytm.d.a.a.a;
import net.one97.paytm.phoenix.provider.FetchValuesForKeysProvider;
import net.one97.paytm.phoenix.provider.FetchValuesForKeysProviderCallback;

public final class c implements Serializable, FetchValuesForKeysProvider {
    private String verticalName;

    public c(String str) {
        this.verticalName = str;
    }

    public final void provideValuesForKeys(String str, final FetchValuesForKeysProviderCallback fetchValuesForKeysProviderCallback) {
        a aVar = a.f16781a;
        a.a(this.verticalName, str, new a.b() {
            public final void a(Object obj) {
                FetchValuesForKeysProviderCallback fetchValuesForKeysProviderCallback = fetchValuesForKeysProviderCallback;
                if (fetchValuesForKeysProviderCallback != null) {
                    fetchValuesForKeysProviderCallback.onResult(obj);
                }
            }
        });
    }
}
