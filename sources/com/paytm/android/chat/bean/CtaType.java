package com.paytm.android.chat.bean;

import kotlin.g.b.g;
import kotlin.m.p;

public enum CtaType {
    OPENCHATBOTTOMSHEET,
    DEEPLINK,
    UPI_PAY,
    UPI_MARK_AS_SPAM,
    UPI_DECLINE,
    UPI_CANCEL,
    UPI_EXPIRED;
    
    public static final Companion Companion = null;

    static {
        Companion = new Companion((g) null);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final CtaType fromString(String str) {
            for (CtaType ctaType : CtaType.values()) {
                if (p.a(ctaType.toString(), str, true)) {
                    return ctaType;
                }
            }
            return null;
        }
    }
}
