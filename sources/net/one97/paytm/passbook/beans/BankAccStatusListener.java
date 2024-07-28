package net.one97.paytm.passbook.beans;

public interface BankAccStatusListener {
    void onBankStatus(AccountStatus accountStatus);

    public enum AccountStatus {
        DEFAULT(0),
        NOT_APPLIED(1),
        PROCESSING(2),
        ISSUED(3);
        
        private int numVal;

        private AccountStatus(int i2) {
            this.numVal = i2;
        }

        public static AccountStatus getAccount(int i2) {
            AccountStatus accountStatus = DEFAULT;
            if (i2 == accountStatus.numVal) {
                return accountStatus;
            }
            AccountStatus accountStatus2 = NOT_APPLIED;
            if (i2 == accountStatus2.numVal) {
                return accountStatus2;
            }
            AccountStatus accountStatus3 = PROCESSING;
            if (i2 == accountStatus3.numVal) {
                return accountStatus3;
            }
            AccountStatus accountStatus4 = ISSUED;
            return i2 == accountStatus4.numVal ? accountStatus4 : accountStatus;
        }

        public final int getNumVal() {
            return this.numVal;
        }
    }
}
