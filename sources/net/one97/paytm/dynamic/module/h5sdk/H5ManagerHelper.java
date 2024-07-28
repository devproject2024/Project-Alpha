package net.one97.paytm.dynamic.module.h5sdk;

import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.h5.b.c;
import net.one97.paytm.h5.b.e;
import net.one97.paytm.h5paytmsdk.b.ad;
import net.one97.paytm.phoenix.api.d;
import net.one97.paytm.phoenix.provider.PhoenixFetchValuesForKeysProvider;
import net.one97.paytm.verifier.a.c;

public final class H5ManagerHelper {
    public static final H5ManagerHelper INSTANCE = new H5ManagerHelper();

    private H5ManagerHelper() {
    }

    public static final void loadPage(String str, String str2, String str3, Bundle bundle, String str4, boolean z, Context context) {
        String str5 = str2;
        Context context2 = context;
        String str6 = str;
        k.c(str, "verticalName");
        k.c(str2, "appUniqueId");
        String str7 = str3;
        k.c(str3, "urlOrAssetPath");
        k.c(context2, "context");
        if (c.a()) {
            INSTANCE.loadPageFromH5Manager(str, str2, str3, bundle, str4, z, context, true);
        } else {
            net.one97.paytm.h5.b.c.a(context2, str2, (c.a) new H5ManagerHelper$loadPage$1(str, str2, str3, bundle, str4, z, context));
        }
    }

    public static /* synthetic */ void loadPageFromH5Manager$default(H5ManagerHelper h5ManagerHelper, String str, String str2, String str3, Bundle bundle, String str4, boolean z, Context context, boolean z2, int i2, Object obj) {
        h5ManagerHelper.loadPageFromH5Manager(str, str2, str3, bundle, str4, z, context, (i2 & 128) != 0 ? false : z2);
    }

    public final void loadPageFromH5Manager(String str, String str2, String str3, Bundle bundle, String str4, boolean z, Context context, boolean z2) {
        String str5 = str;
        k.c(str, "verticalName");
        String str6 = str2;
        k.c(str2, "appUniqueId");
        String str7 = str3;
        k.c(str3, "urlOrAssetPath");
        k.c(context, "context");
        if (z2) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(new PhoenixFetchValuesForKeysProvider(str));
            PhoenixManagerImpl.INSTANCE.loadPage(str2, str3, bundle, str4, z, (List<? extends d>) null, arrayList);
            return;
        }
        ArrayList arrayList2 = new ArrayList(1);
        arrayList2.add(new e(str));
        PaytmH5ManagerImpl.INSTANCE.loadPage(str2, str3, bundle, str4, z, (List<? extends ad>) null, arrayList2);
    }
}
