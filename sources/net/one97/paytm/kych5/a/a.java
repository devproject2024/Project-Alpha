package net.one97.paytm.kych5.a;

import java.io.Serializable;
import net.one97.paytm.kych5.a.c;
import net.one97.paytm.phoenix.provider.FetchValuesForKeysProvider;
import net.one97.paytm.phoenix.provider.FetchValuesForKeysProviderCallback;

public final class a implements Serializable, FetchValuesForKeysProvider {
    private String verticalName;

    public a(String str) {
        this.verticalName = str;
    }

    public final void provideValuesForKeys(String str, final FetchValuesForKeysProviderCallback fetchValuesForKeysProviderCallback) {
        c cVar = c.f51043a;
        c.a(this.verticalName, str, new c.b() {
            public final void a(Object obj) {
                FetchValuesForKeysProviderCallback fetchValuesForKeysProviderCallback = fetchValuesForKeysProviderCallback;
                if (fetchValuesForKeysProviderCallback != null) {
                    fetchValuesForKeysProviderCallback.onResult(obj);
                }
            }
        });
    }
}
