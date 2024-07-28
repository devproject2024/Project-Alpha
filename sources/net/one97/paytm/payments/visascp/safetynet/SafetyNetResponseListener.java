package net.one97.paytm.payments.visascp.safetynet;

public interface SafetyNetResponseListener {
    void onSafetyNetResponseFailure(Exception exc);

    void onSafetyNetResponseSuccess(String str);
}
