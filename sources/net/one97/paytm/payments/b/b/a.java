package net.one97.paytm.payments.b.b;

import net.one97.paytm.paymentsBank.utils.o;

public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f17207a = o.a().getPersonalisedPDCProductId();

    /* renamed from: b  reason: collision with root package name */
    public static final String f17208b = o.a().getNonPersonalisedPDCProductId();

    public enum b {
        DEVICE_BINDING_WALLET,
        DEVICE_BINDING_PASSBOOK
    }

    /* renamed from: net.one97.paytm.payments.b.b.a$a  reason: collision with other inner class name */
    public enum C0259a {
        PASSCODE_ALREADY_EXIST("passcode_already_exist"),
        PASSCODE_SET_SUCCESS("passcode_set_success"),
        PASSCODE_SET_FAILURE("passcode_set_failue");
        
        private String value;

        private C0259a(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }
}
