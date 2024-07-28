package net.one97.paytm.n;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.g.b.k;
import net.one97.paytm.wallet.communicator.b;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final g f55768a;

    /* renamed from: b  reason: collision with root package name */
    private final int f55769b = 36865;

    /* renamed from: c  reason: collision with root package name */
    private String f55770c;

    public f(g gVar, String str) {
        k.c(gVar, "listener");
        this.f55768a = gVar;
        this.f55770c = str;
    }

    private final Intent b(Activity activity) {
        Intent intent = new Intent();
        intent.putExtra("ENTER_HEADER", "paytm_saving_account_confirm");
        if (this.f55770c == null) {
            this.f55770c = "DEVICE_BINDING_WALLET";
        }
        intent.putExtra("show_feature_specific_view", this.f55770c);
        Intent verifyPasscodeActivity = b.a().getVerifyPasscodeActivity(activity, intent);
        k.a((Object) verifyPasscodeActivity, "WalletCommManager.getWal…ctivity(activity, intent)");
        return verifyPasscodeActivity;
    }

    public final void a(Activity activity) {
        k.c(activity, "activity");
        activity.startActivityForResult(b(activity), this.f55769b);
    }

    public final void a(Fragment fragment) {
        k.c(fragment, "fragment");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            k.a((Object) activity, "it");
            fragment.startActivityForResult(b(activity), this.f55769b);
            return;
        }
        this.f55768a.b();
    }

    public final void a(int i2, int i3) {
        if (i2 == this.f55769b) {
            if (i3 == -1) {
                this.f55768a.a();
            } else {
                this.f55768a.b();
            }
        }
    }
}
