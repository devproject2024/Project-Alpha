package net.one97.paytm.moneytransferv4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import java.io.Serializable;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.UpiConstants;

public final class MoneyTransferUtilityActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final a f54779a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private String f54780b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f54781c = "";

    /* renamed from: d  reason: collision with root package name */
    private int f54782d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Context context, String str, String str2, int i2) {
            k.c(context, "context");
            k.c(str, "virtualAddress");
            k.c(str2, "deeplink");
            Intent intent = new Intent(context, MoneyTransferUtilityActivity.class);
            intent.putExtra("vpa", str);
            intent.putExtra("deeplink", str2);
            intent.putExtra("utility_type", i2);
            context.startActivity(intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("vpa");
        k.a((Object) stringExtra, "intent.getStringExtra(UpiConstants.EXTRA_VPA)");
        this.f54780b = stringExtra;
        this.f54782d = getIntent().getIntExtra("utility_type", 0);
        String stringExtra2 = getIntent().getStringExtra("deeplink");
        k.a((Object) stringExtra2, "intent.getStringExtra(\"deeplink\")");
        this.f54781c = stringExtra2;
        int i2 = this.f54782d;
        if (i2 == 1100) {
            if (this.f54780b.length() > 0) {
                AccountProviderActivity.a((Activity) this, 101);
            } else {
                Toast.makeText(this, "UPI ID param is missing.", 0).show();
            }
        } else if (i2 == 1101) {
            Intent intent = new Intent(this, UpiRegistrationActivity.class);
            intent.putExtra("redirect", 80);
            intent.setFlags(536870912);
            startActivityForResult(intent, 103);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        boolean z = true;
        switch (i2) {
            case 101:
                if (i3 == -1) {
                    Serializable serializableExtra = intent != null ? intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER) : null;
                    if (serializableExtra != null) {
                        BankVpaCreationActivity.a((Activity) this, (AccountProviderBody.AccountProvider) serializableExtra, this.f54780b, 102);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider");
                }
                finish();
                return;
            case 102:
                if (i3 == -1) {
                    if (this.f54781c.length() != 0) {
                        z = false;
                    }
                    if (z) {
                        setResult(-1);
                    } else {
                        d.a aVar = d.f53996a;
                        d.b(d.a.a()).a((Context) this, this.f54781c);
                    }
                }
                finish();
                return;
            case 103:
                if (i3 == -1) {
                    if (this.f54781c.length() != 0) {
                        z = false;
                    }
                    if (z) {
                        setResult(-1);
                    } else {
                        d.a aVar2 = d.f53996a;
                        d.b(d.a.a()).a((Context) this, this.f54781c);
                    }
                }
                finish();
                return;
            default:
                return;
        }
    }
}
