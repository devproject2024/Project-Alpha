package net.one97.paytm.passbook.utility;

import net.one97.paytm.passbook.R;

public final class p {

    public enum a {
        PAYTM_PAYMENT_BANK(1, "PYTM", "Paytm Payments Bank", "", -1),
        HDFC_BANK(2, "HDFC", "HDFC", "ic_bank_hdfc", R.drawable.pass_ic_bank_hdfc),
        ICICI_BANK(3, "ICIC", "ICICI", "ic_bank_icici", R.drawable.pass_ic_bank_icici),
        AXIS_BANK(4, "UTIB", "AXIS", "ic_bank_axis_bank", R.drawable.pass_ic_bank_axis_bank),
        SBI_BANK(5, "SBIN", "State Bank of India", "ic_bank_sbi", R.drawable.pass_ic_bank_sbi),
        YES_BANK(6, "YESB", "YesBank", "ic_bank_yes_bank", R.drawable.pass_ic_bank_yes_bank),
        PNB(7, "PUNB", "Punjab National Bank", "", -1),
        BOB(8, "BARB", "Bank of Baroda", "ic_bank_of_baroda", R.drawable.pass_ic_bank_of_baroda);
        
        private final String mAccountProvider;
        private final int mBankPriority;
        private final String mDrawableName;
        private final int mIconId;
        private final String mIfscCode;

        private a(int i2, String str, String str2, String str3, int i3) {
            this.mBankPriority = i2;
            this.mIfscCode = str;
            this.mAccountProvider = str2;
            this.mDrawableName = str3;
            this.mIconId = i3;
        }

        public final String getIfscCode() {
            return this.mIfscCode;
        }

        public final String getAccountProvider() {
            return this.mAccountProvider;
        }

        public final String getDrawableName() {
            return this.mDrawableName;
        }

        public final int getDrawableId() {
            return this.mIconId;
        }
    }
}
