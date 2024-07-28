package net.one97.paytm.payments.visascp;

import net.one97.paytm.payments.visascp.VisaSCPImpl;

public interface VisaSCP {
    void checkAllEnrolledCards(String str, String str2, String str3, String str4, String str5);

    boolean clearEnrollment(String str, String str2, String str3, String str4);

    void createOneClickInfoObject(String str, String str2, String str3, String str4);

    void deEnrollCard(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, VisaSCPImpl.DeEnrollCardListener deEnrollCardListener);

    String getDeEnrollmentData(String str, String str2, String str3, String str4, String str5);

    void getOneClickInfo(String str, String str2, String str3, String str4, VisaSCPImpl.GetOneClickInfoListener getOneClickInfoListener);

    void isEnrolled(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, VisaSCPImpl.IsEnrolledListener isEnrolledListener);

    boolean isEnrollmentSuccess(String str, String str2, String str3, String str4);

    String setEnrollmentData(String str, String str2, String str3, String str4, String str5);

    void verifyDevice(String str, String str2, String str3, String str4, String str5, String str6, String str7, VisaSCPImpl.DeviceVerificationListener deviceVerificationListener);
}
