package net.one97.paytm.bankCommon.model;

public class IllegalErrorCode extends Exception {
    private static final long serialVersionUID = 1;

    public IllegalErrorCode(String str) {
        super(str);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
