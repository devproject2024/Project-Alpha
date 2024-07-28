package net.one97.paytm.upi.h;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import net.one97.paytm.upi.common.PaytmLogs;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.util.CryptLib;
import net.one97.paytm.upi.util.NpciProfileCredentialsBuilder;
import net.one97.paytm.upi.util.UpiAppUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.npci.upi.security.services.CLRemoteResultReceiver;
import org.npci.upi.security.services.CLServices;
import org.npci.upi.security.services.ServiceConnectionStatusNotifier;

public final class a {

    /* renamed from: c  reason: collision with root package name */
    private static a f66975c;

    /* renamed from: a  reason: collision with root package name */
    public CLServices f66976a;

    /* renamed from: b  reason: collision with root package name */
    public Application f66977b;

    /* renamed from: net.one97.paytm.upi.h.a$a  reason: collision with other inner class name */
    public interface C1347a {
        void onServiceConnected();

        void onServiceDisconnected();
    }

    private a(Context context, final C1347a aVar) {
        if (context instanceof Application) {
            this.f66977b = (Application) context;
        } else {
            this.f66977b = (Application) context.getApplicationContext();
        }
        try {
            CLServices.initService(this.f66977b, new ServiceConnectionStatusNotifier() {
                public final void serviceConnected(CLServices cLServices) {
                    a.this.f66976a = cLServices;
                    C1347a aVar = aVar;
                    if (aVar != null) {
                        aVar.onServiceConnected();
                    }
                    PaytmLogs.d("CL Service", "Service connected");
                }

                public final void serviceDisconnected() {
                    a.this.f66976a = null;
                    C1347a aVar = aVar;
                    if (aVar != null) {
                        aVar.onServiceDisconnected();
                    }
                    PaytmLogs.d("CL Service", "Service disconnected");
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static synchronized a a(Context context, C1347a aVar) {
        a aVar2;
        synchronized (a.class) {
            if (f66975c == null) {
                f66975c = new a(context, aVar);
            } else if (aVar != null) {
                aVar.onServiceConnected();
            }
            aVar2 = f66975c;
        }
        return aVar2;
    }

    public final boolean a() {
        return this.f66976a != null;
    }

    public static String a(String str, String str2, String str3, String str4) {
        String str5 = null;
        try {
            CryptLib cryptLib = new CryptLib();
            String str6 = str + "|" + str2 + "|" + str4;
            PaytmLogs.d("PSP Hmac Msg", str6);
            str5 = Base64.encodeToString(cryptLib.encrypt(cryptLib.SHA256(str6), cryptLib.decodeUsingBase64(str3)), 2);
            PaytmLogs.d("PSP Hmac", str5);
            return str5;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str5;
        }
    }

    public final void a(String str, String str2, String str3, int i2, BankAccountDetails.BankAccount bankAccount, CLRemoteResultReceiver cLRemoteResultReceiver) {
        String controlsForCheckBalance;
        String str4 = str;
        int i3 = i2;
        if (i3 == 0) {
            controlsForCheckBalance = NpciProfileCredentialsBuilder.getControlsForCheckBalance(bankAccount);
        } else if (i3 != 1) {
            controlsForCheckBalance = i3 != 2 ? "" : NpciProfileCredentialsBuilder.getControlsForResetPin(bankAccount);
        } else {
            controlsForCheckBalance = NpciProfileCredentialsBuilder.getControlsForChangePin(bankAccount);
        }
        String str5 = str3;
        a(NpciProfileCredentialsBuilder.getKeycode(), TextUtils.isEmpty(str2) ? NpciProfileCredentialsBuilder.getXmlPayload(this.f66977b) : str2, controlsForCheckBalance, NpciProfileCredentialsBuilder.getConfiguration(bankAccount), NpciProfileCredentialsBuilder.getSalt(str, this.f66977b), NpciProfileCredentialsBuilder.getPayerInfo(bankAccount.getAccount()), NpciProfileCredentialsBuilder.getTrust(str, str3, this.f66977b), NpciProfileCredentialsBuilder.getLanguagePref(), cLRemoteResultReceiver);
    }

    public final void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, CLRemoteResultReceiver cLRemoteResultReceiver) {
        if (this.f66976a != null) {
            PaytmLogs.d(CLConstants.INPUT_KEY_KEY_CODE, str);
            PaytmLogs.d("listKeyPayload", str2);
            PaytmLogs.d("credAllowed", str3);
            String str9 = str4;
            PaytmLogs.d(CLConstants.INPUT_KEY_CONFIGURATION, str9);
            String str10 = str5;
            PaytmLogs.d(CLConstants.INPUT_KEY_SALT, str10);
            String str11 = str6;
            PaytmLogs.d(CLConstants.INPUT_KEY_PAY_INFO, str11);
            String str12 = str7;
            PaytmLogs.d(CLConstants.INPUT_KEY_TRUST, str12);
            String str13 = str8;
            PaytmLogs.d(CLConstants.INPUT_KEY_LANGUAGE_PREFERENCE, str13);
            UpiAppUtils.disableScreenCapturing();
            this.f66976a.getCredential(str, str2, str3, str9, str10, str11, str12, str13, cLRemoteResultReceiver);
            return;
        }
        throw new IllegalStateException("CL Services is null");
    }
}
