package net.one97.paytm.upi.b;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.UPICheckBalanceHelper;
import net.one97.paytm.upi.util.UpiConstants;

public abstract class b extends a implements n.c {

    /* renamed from: a  reason: collision with root package name */
    private final int f66593a = 10022;

    /* renamed from: b  reason: collision with root package name */
    private final int f66594b = 10023;

    /* renamed from: c  reason: collision with root package name */
    protected final int f66595c = 10021;

    /* renamed from: d  reason: collision with root package name */
    protected UPICheckBalanceHelper f66596d;

    /* renamed from: e  reason: collision with root package name */
    private String f66597e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f66598f;

    public abstract void j();

    public void k() {
        HashMap hashMap = this.f66598f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        k();
    }

    public b(int i2) {
        super(i2);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 80 || i3 != -1) {
            if (i2 == this.f66595c && i3 == -1) {
                j();
            } else if (i2 == this.f66593a && i3 == -1) {
                if (intent == null) {
                    k.a();
                }
                Serializable serializableExtra = intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER);
                if (serializableExtra != null) {
                    AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) serializableExtra;
                    Fragment fragment = this;
                    String str = this.f66597e;
                    if (str == null) {
                        k.a("_primaryVpa");
                    }
                    BankVpaCreationActivity.a(fragment, accountProvider, str, this.f66594b);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider");
            }
        }
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError, boolean z) {
        if (z) {
            Intent intent = new Intent(getContext(), UpiRegistrationActivity.class);
            intent.putExtra("redirect", 80);
            intent.setFlags(536870912);
            startActivityForResult(intent, 80);
            return;
        }
        super.a(upiCustomVolleyError, z);
    }
}
