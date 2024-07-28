package net.one97.paytm.contactsdk;

import android.app.Application;
import android.content.Context;
import com.paytm.contactsSdk.ContactsSDKApplicationInterface;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.q;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.j.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.smssdk.a.c;

public final class ContactSDKInterfaceImpl implements ContactsSDKApplicationInterface {

    /* renamed from: a  reason: collision with root package name */
    public static final ContactSDKInterfaceImpl f50280a = new ContactSDKInterfaceImpl();

    public final int workManagerRetryCount() {
        return 3;
    }

    private ContactSDKInterfaceImpl() {
    }

    public final void onLogin() {
        ContactsSDKApplicationInterface.DefaultImpls.onLogin(this);
    }

    public final void updateConsent() {
        ContactsSDKApplicationInterface.DefaultImpls.updateConsent(this);
    }

    public final Application getApplicationContext() {
        Context appContext = CJRJarvisApplication.getAppContext();
        if (appContext != null) {
            return (Application) appContext;
        }
        throw new u("null cannot be cast to non-null type android.app.Application");
    }

    public final String getContactsSdkBaseURL() {
        if (k.a((Object) "release", (Object) SDKConstants.KEY_STAGING_API)) {
            c.a();
            String a2 = c.a("ComsBaseURL", ContactsConstant.BASE_URL);
            q.d("Contact SDK URL ".concat(String.valueOf(a2)));
            k.a((Object) a2, "value");
            return a2;
        }
        c.a();
        String a3 = c.a("ComsBaseURL", "https://ups.paytm.com");
        q.d("Contact SDK URL ".concat(String.valueOf(a3)));
        k.a((Object) a3, "value");
        return a3;
    }

    public final int downloadBatchSize() {
        c.a();
        int a2 = c.a("ComsDownloadBatchSize", 30);
        q.d("Contact SDK Download Batch Size ".concat(String.valueOf(a2)));
        return a2;
    }

    public final int uploadBatchSize() {
        c.a();
        int a2 = c.a("ComsUploadBatchSize", 30);
        q.d("Contact SDK Upload Batch Size ".concat(String.valueOf(a2)));
        return a2;
    }

    public final String consentPrivacyPolicyUrl() {
        c.a();
        String a2 = c.a("privacyPolicyUrl", (String) null);
        k.a((Object) a2, "GTMLoader.getInstance().…S_SDK_PRIVACY_POLICY_URL)");
        return a2;
    }

    public final String getDeviceId() {
        String A = b.A((Context) getApplicationContext());
        k.a((Object) A, "CJRAppCommonUtility.getD…(getApplicationContext())");
        return A;
    }

    public final boolean getIsStage() {
        return k.a((Object) "release", (Object) SDKConstants.KEY_STAGING_API);
    }

    public final String getAppVersion() {
        String Q = b.Q((Context) getApplicationContext());
        k.a((Object) Q, "CJRAppCommonUtility.getA…(getApplicationContext())");
        return Q;
    }

    public final String getLocale() {
        String g2 = b.g();
        k.a((Object) g2, "CJRAppCommonUtility.getLocale()");
        return g2;
    }

    public final String getNetworkType() {
        String b2 = b.b((Context) getApplicationContext());
        return b2 == null ? "" : b2;
    }

    public final String getIp() {
        getApplicationContext();
        String o = b.o();
        k.a((Object) o, "CJRAppCommonUtility.getIp(getApplicationContext())");
        return o;
    }

    public final String getLanLng() {
        return b.s((Context) getApplicationContext()) + "+" + b.t((Context) getApplicationContext());
    }

    public final String getSSOToken() {
        String q = a.q(getApplicationContext());
        return q != null ? q : "";
    }

    public final String getUpsSdkURL() {
        if (k.a((Object) "release", (Object) SDKConstants.KEY_STAGING_API)) {
            c.a();
            String a2 = c.a("ComsUPSBaseURL", "https://ups-staging.paytm.com");
            k.a((Object) a2, "GTMLoader.getInstance().…//ups-staging.paytm.com\")");
            return a2;
        }
        c.a();
        String a3 = c.a("ComsUPSBaseURL", "https://ups.paytm.com");
        k.a((Object) a3, "GTMLoader.getInstance().… \"https://ups.paytm.com\")");
        return a3;
    }

    public final String getUserId() {
        String n = b.n(CJRJarvisApplication.getAppContext());
        return n != null ? n : "";
    }

    public final int getWorkManagerRetryInterval() {
        c.a();
        int a2 = c.a("ComsRetryInterval", 30);
        q.d("Contact SDK Work Manager Retry Interval ".concat(String.valueOf(a2)));
        return a2;
    }

    public final boolean isContactsSDKLocalSyncEnabled() {
        c.a();
        boolean z = true;
        if (c.a("ComsLocalSyncEnabled", 1) != 1) {
            z = false;
        }
        q.d("Local Sync Value ".concat(String.valueOf(z)));
        return z;
    }

    public final boolean isContactsSDKRemoteSyncEnabled() {
        c.a();
        boolean z = true;
        if (c.a("ComsRemoteSyncEnaled", 1) != 1) {
            z = false;
        }
        q.d("Remote Sync Value ".concat(String.valueOf(z)));
        return z;
    }

    public final boolean isConsentStatusAvailableInSmsSdk() {
        c.a aVar = net.one97.paytm.smssdk.a.c.f65060a;
        return c.a.a(getApplicationContext()).b(ContactsConstant.CONTACTS_CONSENT_KEY, false);
    }

    public final boolean getConsentStatusFromSmsSdk() {
        c.a aVar = net.one97.paytm.smssdk.a.c.f65060a;
        return c.a.a(getApplicationContext()).b(ContactsConstant.CONTACTS_CONSENT_KEY, false, false);
    }

    public final void removeConsentStatusFromSmsSdk() {
        c.a aVar = net.one97.paytm.smssdk.a.c.f65060a;
        c.a.a(getApplicationContext()).a(ContactsConstant.CONTACTS_CONSENT_KEY, false);
    }

    public final long healthApiInterval() {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a("ComsHealthAPIInterval", 24);
    }
}
