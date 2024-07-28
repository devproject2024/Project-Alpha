package com.paytm.business.merchantprofile.common.utility;

import kotlin.g.b.g;
import kotlin.m.p;

public final class MerchantTypeToPPIMapper {
    public static final Companion Companion = new Companion((g) null);

    public static final String mapMerchantTypeToPPI(String str) {
        return Companion.mapMerchantTypeToPPI(str);
    }

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final String mapMerchantTypeToPPI(String str) {
            if (str == null || p.a(str)) {
                return "";
            }
            if (p.a(str, MerchantTypeToPPIMapperKt.CONST_NON_SD, true)) {
                return "0";
            }
            if (p.a(str, MerchantTypeToPPIMapperKt.CONST_50K, true)) {
                return "1";
            }
            if (p.a(str, MerchantTypeToPPIMapperKt.CONST_500K, true)) {
                return "2";
            }
            if (p.a(str, MerchantTypeToPPIMapperKt.CONST_100K, true)) {
                return "3";
            }
            if (p.a(str, MerchantTypeToPPIMapperKt.CONST_UNLIMITED_SD, true)) {
                return "4";
            }
            return "";
        }
    }
}
