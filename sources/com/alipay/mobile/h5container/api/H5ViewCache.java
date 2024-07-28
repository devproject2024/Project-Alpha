package com.alipay.mobile.h5container.api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alipay.mobile.framework.b;
import com.alipay.mobile.nebula.R;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import java.util.HashMap;

public class H5ViewCache {
    /* access modifiers changed from: private */
    public static int[] VIEW_ID_TO_CACHE = {R.layout.h5_loading_fragment, R.layout.h5_web_content, R.layout.h5_loading_view};
    /* access modifiers changed from: private */
    public static HashMap<Integer, View> sViewCache;

    public static void initViewCache() {
        if (sViewCache == null) {
            H5Utils.getExecutor(H5ThreadType.NORMAL).execute(new Runnable() {
                public final void run() {
                    HashMap unused = H5ViewCache.sViewCache = new HashMap();
                    b.a();
                    LayoutInflater from = LayoutInflater.from(b.c());
                    for (int i2 : H5ViewCache.VIEW_ID_TO_CACHE) {
                        H5ViewCache.sViewCache.put(Integer.valueOf(i2), from.inflate(i2, (ViewGroup) null));
                    }
                }
            });
        }
    }

    public static View getCachedViewById(int i2) {
        HashMap<Integer, View> hashMap = sViewCache;
        if (hashMap == null) {
            return null;
        }
        return hashMap.remove(Integer.valueOf(i2));
    }
}
