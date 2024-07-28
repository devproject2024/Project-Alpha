package net.one97.paytm.p2b.data.Bean;

public class InvalidOTPException extends Exception {
    public InvalidOTPException(String str) {
        super(str);
    }
}
