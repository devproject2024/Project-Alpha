package com.google.zxing.client.a;

import com.google.zxing.r;

public final class x extends u {
    public final /* synthetic */ q a(r rVar) {
        String b2 = b(rVar);
        String str = null;
        if (!b2.startsWith("smsto:") && !b2.startsWith("SMSTO:") && !b2.startsWith("mmsto:") && !b2.startsWith("MMSTO:")) {
            return null;
        }
        String substring = b2.substring(6);
        int indexOf = substring.indexOf(58);
        if (indexOf >= 0) {
            str = substring.substring(indexOf + 1);
            substring = substring.substring(0, indexOf);
        }
        return new w(substring, str);
    }
}
