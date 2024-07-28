package net.one97.paytm.payments.visascp;

public interface VisaSCPImpl {

    public interface DeEnrollCardListener {
        void onRequestEnd(boolean z, String str);

        void onRequestError(String str, String str2);

        void onRequestStart();
    }

    public interface DeviceVerificationListener {
        void onRequestEnd(boolean z, String str);

        void onRequestError(String str, String str2, String str3);

        void onRequestStart();
    }

    public interface GetOneClickInfoListener {
        void onRequestEnd(String str);

        void onRequestError(String str, String str2, String str3);

        void onRequestStart();
    }

    public interface IsEnrolledListener {
        void onRequestEnd(boolean z, boolean z2, String str);

        void onRequestError(String str, String str2);

        void onRequestStart();
    }

    public interface KeyGenerationListener {
        void onKeyGenerated();

        void onKeyNotGenerated();
    }

    public interface SafetyNetListener {
        void onError();

        void onSuccess(String str);
    }
}
