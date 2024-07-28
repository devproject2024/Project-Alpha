package net.one97.paytm.phoenix.provider;

import com.paytm.utility.q;
import java.io.Serializable;
import net.one97.paytm.h5.c;

public class PhoenixFetchValuesForKeysProvider implements Serializable, FetchValuesForKeysProvider {
    private String verticalName;

    public PhoenixFetchValuesForKeysProvider(String str) {
        this.verticalName = str;
    }

    public void provideValuesForKeys(String str, FetchValuesForKeysProviderCallback fetchValuesForKeysProviderCallback) {
        q.d("provideValuesForKeys: ".concat(String.valueOf(str)));
        c cVar = c.f50543a;
        c.a(this.verticalName, str, new c.C0910c() {
            public final void onResult(Object obj) {
                PhoenixFetchValuesForKeysProvider.lambda$provideValuesForKeys$0(FetchValuesForKeysProviderCallback.this, obj);
            }
        });
    }

    static /* synthetic */ void lambda$provideValuesForKeys$0(FetchValuesForKeysProviderCallback fetchValuesForKeysProviderCallback, Object obj) {
        if (fetchValuesForKeysProviderCallback != null) {
            if (obj != null) {
                q.d("fetchValuesForKeysProviderCallback not null: " + obj.toString());
            } else {
                q.d("fetchValuesForKeysProviderCallback not null but any is null: ");
            }
            q.d("fetchValuesForKeysProviderCallback not null: ");
            fetchValuesForKeysProviderCallback.onResult(obj);
        }
    }
}
