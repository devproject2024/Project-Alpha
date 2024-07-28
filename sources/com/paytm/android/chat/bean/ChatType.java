package com.paytm.android.chat.bean;

import kotlin.g.b.g;
import kotlin.m.p;

public enum ChatType {
    P2P,
    P2M,
    P2C,
    P2VPA,
    P2VPAM,
    P2BK;
    
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

        public final ChatType fromString(String str) {
            for (ChatType chatType : ChatType.values()) {
                if (p.a(chatType.toString(), str, true)) {
                    return chatType;
                }
            }
            return null;
        }
    }
}
