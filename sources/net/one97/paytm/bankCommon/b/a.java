package net.one97.paytm.bankCommon.b;

import net.one97.paytm.nativesdk.BuildConfig;

public final class a {

    /* renamed from: net.one97.paytm.bankCommon.b.a$a  reason: collision with other inner class name */
    public enum C0220a {
        BANK_TRANSACTION(BuildConfig.BANK_TXN_SCOPE),
        RESET_SECRET("reset_secret"),
        DC_TXN("dc_txn");
        
        private final String scope;

        private C0220a(String str) {
            this.scope = str;
        }

        public final String getScope() {
            return this.scope;
        }
    }
}
