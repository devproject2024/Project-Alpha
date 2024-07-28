package net.one97.paytm.wallet.communicator;

import android.content.Context;

public interface a {

    /* renamed from: net.one97.paytm.wallet.communicator.a$a  reason: collision with other inner class name */
    public interface C1415a {
        void a();

        void a(String str);
    }

    public interface b {
        void a(String str, String str2);

        void a(boolean z, boolean z2, String str);
    }

    void checkAllEnrolledCards(Context context, String str, String str2, String str3, String str4, String str5);

    void createOneClickInfoObject(Context context, String str, String str2, String str3, String str4);

    void getOneClickInfo(Context context, String str, String str2, String str3, String str4, C1415a aVar);

    void isEnrolled(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, b bVar);

    void setEnrollmentData(Context context, String str, String str2, String str3, String str4, String str5);
}
