package com.paytm.android.chat.bean;

import kotlin.g.b.g;

public enum UserType {
    CUSTOMER(1),
    CHANNEL(2),
    MERCHANT(3);
    
    public static final Companion Companion = null;
    private final int value;

    private UserType(int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        Companion = new Companion((g) null);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final UserType fromString(String str) {
            try {
                for (UserType userType : UserType.values()) {
                    if (str != null && userType.getValue() == Integer.parseInt(str)) {
                        return userType;
                    }
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        public final UserType fromInt(Integer num) {
            for (UserType userType : UserType.values()) {
                if (num != null && userType.getValue() == num.intValue()) {
                    return userType;
                }
            }
            return null;
        }
    }
}
