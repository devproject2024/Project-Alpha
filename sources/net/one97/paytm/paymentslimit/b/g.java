package net.one97.paytm.paymentslimit.b;

public final class g extends com.paytm.network.a {

    public enum a {
        PAYMENTS_LIMIT("PaymentsLimit");
        
        private final String stringValue;

        private a(String str) {
            this.stringValue = str;
        }

        public final String toString() {
            return this.stringValue;
        }
    }
}
