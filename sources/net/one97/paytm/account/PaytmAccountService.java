package net.one97.paytm.account;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.NetworkErrorException;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.paytm.utility.q;

public class PaytmAccountService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private a f52267a;

    public static Account a() {
        return new Account("Paytm", "net.one97.paytm");
    }

    public void onCreate() {
        q.a("Service created");
        this.f52267a = new a(this);
    }

    public void onDestroy() {
        q.a("Service destroyed");
    }

    public IBinder onBind(Intent intent) {
        return this.f52267a.getIBinder();
    }

    public class a extends AbstractAccountAuthenticator {
        public final Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) throws NetworkErrorException {
            return null;
        }

        public final Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) throws NetworkErrorException {
            return null;
        }

        public a(Context context) {
            super(context);
        }

        public final Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
            throw new UnsupportedOperationException();
        }

        public final Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) throws NetworkErrorException {
            throw new UnsupportedOperationException();
        }

        public final String getAuthTokenLabel(String str) {
            throw new UnsupportedOperationException();
        }

        public final Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) throws NetworkErrorException {
            throw new UnsupportedOperationException();
        }

        public final Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) throws NetworkErrorException {
            throw new UnsupportedOperationException();
        }
    }
}
