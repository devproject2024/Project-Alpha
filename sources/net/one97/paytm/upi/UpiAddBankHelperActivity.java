package net.one97.paytm.upi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.io.Serializable;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UPISettingsActivity;
import net.one97.paytm.upi.util.UpiConstants;

public final class UpiAddBankHelperActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final a f66481a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private String f66482b;

    /* renamed from: c  reason: collision with root package name */
    private int f66483c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Context context, String str) {
            k.c(context, "context");
            k.c(str, "virtualAddress");
            Intent intent = new Intent(context, UpiAddBankHelperActivity.class);
            intent.putExtra("vpa", str);
            context.startActivity(intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("vpa");
        k.a((Object) stringExtra, "intent.getStringExtra(UpiConstants.EXTRA_VPA)");
        this.f66482b = stringExtra;
        this.f66483c = getIntent().getIntExtra("self_destroy", 0);
        AccountProviderActivity.a((Activity) this, 101);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 101) {
            if (i2 == 102) {
                if (i3 == -1) {
                    if (this.f66483c == 0) {
                        UPISettingsActivity.a aVar = UPISettingsActivity.f68712d;
                        UPISettingsActivity.a.a(this);
                    } else {
                        setResult(-1);
                    }
                }
                finish();
            }
        } else if (i3 == -1) {
            Serializable serializableExtra = intent != null ? intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER) : null;
            if (serializableExtra != null) {
                AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) serializableExtra;
                Activity activity = this;
                String str = this.f66482b;
                if (str == null) {
                    k.a("virtualAddress");
                }
                BankVpaCreationActivity.a(activity, accountProvider, str, 102);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider");
        } else {
            finish();
        }
    }
}
