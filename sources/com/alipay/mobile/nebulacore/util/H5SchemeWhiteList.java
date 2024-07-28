package com.alipay.mobile.nebulacore.util;

import java.util.HashSet;
import java.util.Set;

public class H5SchemeWhiteList {
    public static Set<String> sSchemeMap = new HashSet<String>() {
        {
            add("alipay");
            add("alipays");
            add("alipayqr");
            add("alipass");
            add("alipaywifi");
            add("alipaywifimcd");
            add("alipayauth");
            add("alipayre");
            add("alipaysrc");
            add("alipayqrrc");
            add("alipassrc");
            add("alipaywifirc");
            add("alipaywifimcdrc");
            add("alipayauthrc");
            add("alipayrerc");
            add("tel");
            add("sms");
            add("smsto");
            add("mms");
            add("mmsto");
            add("alipayhk");
        }
    };
}
