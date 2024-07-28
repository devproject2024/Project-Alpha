package com.google.zxing.client.a;

import com.google.zxing.r;

public final class aa extends u {
    public final /* synthetic */ q a(r rVar) {
        String str;
        String b2 = b(rVar);
        if (!b2.startsWith("tel:") && !b2.startsWith("TEL:")) {
            return null;
        }
        if (b2.startsWith("TEL:")) {
            str = "tel:" + b2.substring(4);
        } else {
            str = b2;
        }
        int indexOf = b2.indexOf(63, 4);
        return new z(indexOf < 0 ? b2.substring(4) : b2.substring(4, indexOf), str);
    }
}
