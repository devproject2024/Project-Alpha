package com.google.android.gms.internal.icing;

import com.alipay.mobile.h5container.api.H5Param;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.HashMap;
import java.util.Map;

public final class fn {

    /* renamed from: a  reason: collision with root package name */
    static final String[] f10240a = {Item.KEY_TEXT1, "text2", H5Param.MENU_ICON, "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity", "thing_proto"};

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, Integer> f10241b = new HashMap(f10240a.length);

    public static String a(int i2) {
        if (i2 < 0) {
            return null;
        }
        String[] strArr = f10240a;
        if (i2 >= strArr.length) {
            return null;
        }
        return strArr[i2];
    }

    static {
        int i2 = 0;
        while (true) {
            String[] strArr = f10240a;
            if (i2 < strArr.length) {
                f10241b.put(strArr[i2], Integer.valueOf(i2));
                i2++;
            } else {
                return;
            }
        }
    }
}
