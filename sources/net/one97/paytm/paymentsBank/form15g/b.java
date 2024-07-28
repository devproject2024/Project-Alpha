package net.one97.paytm.paymentsBank.form15g;

public enum b {
    NOT_APPLIED(0),
    APPROVAL_PENDING(1),
    APPROVED(2),
    REJECTED(3),
    SUBMISSION_PENDING(4);

    private b(int i2) {
    }

    public static b getStatus(int i2) {
        if (i2 == 0) {
            return NOT_APPLIED;
        }
        if (i2 == 1) {
            return APPROVAL_PENDING;
        }
        if (i2 == 2) {
            return APPROVED;
        }
        if (i2 == 3) {
            return REJECTED;
        }
        if (i2 == 4) {
            return SUBMISSION_PENDING;
        }
        return NOT_APPLIED;
    }
}
