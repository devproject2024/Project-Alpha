package net.one97.paytm.bankCommon.utils;

public interface c {

    public enum a {
        IMPS,
        UPI,
        ALL
    }

    public enum b {
        SAVING_ACCOUNT_DETAILS,
        BLOCK_UNBLOCK_CARD,
        RETURN_TO_CALLER_ACTIVITY,
        ADD_NOMINEE
    }

    /* renamed from: net.one97.paytm.bankCommon.utils.c$c  reason: collision with other inner class name */
    public enum C0228c {
        RUPAY("RUPAY"),
        VISA_PLATINUM("VISA_PLATINUM_PRIMARY"),
        VISA_CLASSIC("VISA_CLASSIC_PRIMARY"),
        MASTER_PLATINUM("MASTER_PLATINUM_PRIMARY"),
        MASTER_CLASSIC("MASTER_CLASSIC_PRIMARY");
        
        public final String stringValue;

        private C0228c(String str) {
            this.stringValue = str;
        }

        public final String toString() {
            return this.stringValue;
        }
    }
}
