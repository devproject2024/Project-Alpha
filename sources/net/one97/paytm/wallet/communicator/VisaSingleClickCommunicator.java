package net.one97.paytm.wallet.communicator;

import android.content.Context;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.payments.visascp.VisaSCPImpl;
import net.one97.paytm.wallet.communicator.a;

public class VisaSingleClickCommunicator implements a {
    public void createOneClickInfoObject(Context context, String str, String str2, String str3, String str4) {
        CJRJarvisApplication.a(context).createOneClickInfoObject(str, str2, str3, str4);
    }

    public void getOneClickInfo(Context context, String str, String str2, String str3, String str4, final a.C1415a aVar) {
        CJRJarvisApplication.a(context).getOneClickInfo(str, str2, str3, str4, new VisaSCPImpl.GetOneClickInfoListener() {
            public final void onRequestStart() {
            }

            public final void onRequestEnd(String str) {
                aVar.a(str);
            }

            public final void onRequestError(String str, String str2, String str3) {
                aVar.a();
            }
        });
    }

    public void isEnrolled(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, a.b bVar) {
        final a.b bVar2 = bVar;
        CJRJarvisApplication.a(context).isEnrolled(str, str2, str3, str4, str5, str6, str7, str8, new VisaSCPImpl.IsEnrolledListener() {
            public final void onRequestStart() {
            }

            public final void onRequestEnd(boolean z, boolean z2, String str) {
                bVar2.a(z, z2, str);
            }

            public final void onRequestError(String str, String str2) {
                bVar2.a(str, str2);
            }
        });
    }

    public void setEnrollmentData(Context context, String str, String str2, String str3, String str4, String str5) {
        CJRJarvisApplication.a(context).setEnrollmentData(str, str2, str3, str4, str5);
    }

    public void checkAllEnrolledCards(Context context, String str, String str2, String str3, String str4, String str5) {
        CJRJarvisApplication.a(context).checkAllEnrolledCards(str, str2, str3, str4, str5);
    }
}
