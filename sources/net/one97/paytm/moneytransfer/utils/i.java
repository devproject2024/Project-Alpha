package net.one97.paytm.moneytransfer.utils;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static int f54163a = 100;

    public enum b {
        VPA("vpa"),
        ACC_NO("bankAccount"),
        MOBILE("mobileNumber");
        
        private final String type;

        private b(String str) {
            this.type = str;
        }

        public final String getType() {
            return this.type;
        }
    }

    public enum a {
        SUCCESS("SUCCESS"),
        DEEMED("DEEMED"),
        PENDING("PENDING"),
        FAILURE("FAILURE");
        
        private final String type;

        private a(String str) {
            this.type = str;
        }

        public final String getType() {
            return this.type;
        }
    }
}
