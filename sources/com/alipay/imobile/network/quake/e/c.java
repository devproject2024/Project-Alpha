package com.alipay.imobile.network.quake.e;

import android.content.Context;
import com.alipay.imobile.network.quake.e;
import com.alipay.imobile.network.quake.e.a.a;

public final class c extends a {
    public c(Context context) {
        super(context);
    }

    public final String c(e eVar) {
        Object obj;
        if (eVar != null && (eVar instanceof com.alipay.imobile.network.quake.g.e)) {
            com.alipay.imobile.network.quake.g.e eVar2 = (com.alipay.imobile.network.quake.g.e) eVar;
            if (eVar2.y && (obj = eVar2.p) != null) {
                return obj.toString();
            }
        }
        return super.c(eVar);
    }
}
