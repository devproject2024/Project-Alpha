package com.paytmmall.a.b;

import android.text.TextUtils;
import com.paytmmall.artifact.common.b.a.a;
import com.paytmmall.artifact.d.s;
import java.io.Serializable;
import java.util.HashMap;
import net.one97.paytm.phoenix.provider.FetchValuesForKeysProvider;
import net.one97.paytm.phoenix.provider.FetchValuesForKeysProviderCallback;

public final class c implements Serializable, FetchValuesForKeysProvider {
    private static final String FLAGS = "flags";
    private static final String KEY_USER_SESSION = "USER_SESSION";

    public final void provideValuesForKeys(String str, FetchValuesForKeysProviderCallback fetchValuesForKeysProviderCallback) {
        if (!TextUtils.isEmpty(str) && fetchValuesForKeysProviderCallback != null) {
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 97513095) {
                if (hashCode == 1468308994 && str.equals(KEY_USER_SESSION)) {
                    c2 = 0;
                }
            } else if (str.equals(FLAGS)) {
                c2 = 1;
            }
            if (c2 == 0) {
                fetchValuesForKeysProviderCallback.onResult(getSessionDetails());
            } else if (c2 == 1) {
                try {
                    fetchValuesForKeysProviderCallback.onResult(getFlagsForH5());
                } catch (Exception e2) {
                    s.a(e2);
                }
            }
        }
    }

    private HashMap<String, Object> getFlagsForH5() {
        return a.d();
    }

    private HashMap<String, Object> getSessionDetails() {
        return a.c();
    }
}
