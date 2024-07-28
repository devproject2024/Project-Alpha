package com.paytm.android.chat.bean;

import kotlin.g.b.g;

public enum RegistrationStatus {
    NOT_ON_PAYTM(0),
    PARTIAL(1),
    COMPLETE(2);
    
    public static final Companion Companion = null;
    private final int value;

    private RegistrationStatus(int i2) {
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

        public final RegistrationStatus fromString(String str) {
            try {
                for (RegistrationStatus registrationStatus : RegistrationStatus.values()) {
                    if (str != null && registrationStatus.getValue() == Integer.parseInt(str)) {
                        return registrationStatus;
                    }
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        public final RegistrationStatus fromInt(Integer num) {
            for (RegistrationStatus registrationStatus : RegistrationStatus.values()) {
                if (num != null && registrationStatus.getValue() == num.intValue()) {
                    return registrationStatus;
                }
            }
            return null;
        }
    }
}
