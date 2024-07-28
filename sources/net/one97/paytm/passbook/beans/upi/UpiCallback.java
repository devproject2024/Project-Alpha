package net.one97.paytm.passbook.beans.upi;

public interface UpiCallback {
    void onError(Throwable th);

    void onSuccess(Object obj);
}
